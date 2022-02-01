package com.etrump.mixlayout;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.Spannable;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewTreeObserver;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.Vas.ColorFont.DynamicMultipleStyleLayout;
import com.Vas.ColorFont.ExpressionLayout;
import com.Vas.ColorFont.FastColorFontCache;
import com.Vas.ColorFont.FastColorFontHelper;
import com.Vas.ColorFont.FounderBaseLayout;
import com.Vas.ColorFont.FounderBaseLayout.FounderHighlightInterface;
import com.Vas.ColorFont.FounderColorLayout;
import com.Vas.ColorFont.StrikingLayout;
import com.etrump.mixlayout.api.ETFontUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.ToolAppRuntime;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.item.RichStatItemBuilder.Holder;
import com.tencent.mobileqq.activity.aio.item.TextItemBuilder.Holder;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.bubble.BubbleInfo;
import com.tencent.mobileqq.bubble.VipBubbleDrawable;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.profilecard.api.IProfileCardApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.text.style.EmoticonSpan;
import com.tencent.mobileqq.vas.VasMonitorHandler;
import com.tencent.mobileqq.vas.font.api.FontManagerConstants;
import com.tencent.mobileqq.vas.font.api.IETextView;
import com.tencent.mobileqq.vas.font.api.IFontManagerService;
import com.tencent.mobileqq.vas.util.VasMonitorDT;
import com.tencent.mobileqq.widget.AnimationTextView;
import com.tencent.mobileqq.widget.AnimationTextView.OnDoubleClick;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import com.tencent.widget.XListView;
import java.util.concurrent.atomic.AtomicBoolean;

public class ETTextView
  extends AnimationTextView
  implements IETextView
{
  public static final int MSG_DECORATION_RENDER = 2;
  public static final int MSG_DECORATION_TRIGGER = 0;
  public static final int MSG_DECORATION_UPDATE = 1;
  public static final int MSG_RECYCLE_BITMAP = 3;
  static final String TAG = "ETTextView";
  public static Handler mCreateDecorationHandler;
  private static boolean mReportError = false;
  private static Bitmap mSwapBitmap;
  private static Handler mUIHandler;
  private boolean hasComplexScript = false;
  private boolean hasComputeComplexScript = false;
  public boolean isFounderAnimating = false;
  public boolean isParsingMagicFont = false;
  public ETTextView.TextAnimationListener mAnimationListener;
  private final ETTextView.BitmapLocker mBitmapLocker = new ETTextView.BitmapLocker(this, null);
  private boolean mCacheMeasureResult = true;
  public int mClickEpId = -1;
  public int mClickcEId = -1;
  private MotionEvent mCurrentDownEvent;
  private boolean mDecorAnimating = false;
  private boolean mDecorRunning = false;
  private ETDecoration mDecoration;
  int mEmojiX = -1;
  int mEmojiY = -1;
  private int[] mFZColor = new int[4];
  public ETFont mFont;
  public FounderBaseLayout mFounderColorLayout;
  public boolean mHasClickedArkSpan = false;
  public ETLayout mLayout;
  private int mLinkBackcolor;
  public boolean mMagicFont = false;
  public int mMaxWidth = 2147483647;
  public ChatMessage mMessage;
  private int mMinHeight;
  private int mMinWidth;
  public long mMsgId;
  private ETTextView.OnTextOrFontChangeListener mOnBeforeTextOrFontChangeListener;
  private boolean mPauseAnimation = false;
  private MotionEvent mPreviousUpEvent;
  private Paint mSelectPaint;
  public SessionInfo mSessionInfo;
  private int mShadowColor = 0;
  private float mShadowDx = 0.0F;
  private float mShadowDy = 0.0F;
  private float mShadowRadius = 0.0F;
  private TextGraphMap mTextGraphMap;
  private ETTextSelection mTextSelection = null;
  Runnable mTimerForSecondClick = new ETTextView.1(this);
  public boolean shouldStartAnimation = false;
  
  public ETTextView(Context paramContext)
  {
    super(paramContext);
    initHandler();
    init();
  }
  
  public ETTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initHandler();
    init();
  }
  
  public ETTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initHandler();
    init();
  }
  
  public static void clearCache()
  {
    Handler localHandler = mUIHandler;
    if (localHandler != null) {
      localHandler.removeCallbacksAndMessages(null);
    }
    localHandler = mCreateDecorationHandler;
    if (localHandler != null)
    {
      localHandler.removeCallbacksAndMessages(null);
      mCreateDecorationHandler.sendEmptyMessage(3);
    }
  }
  
  private void createFounderLayout(Class<? extends FounderBaseLayout> paramClass)
  {
    Object localObject = this.mFounderColorLayout;
    if ((localObject == null) || (localObject.getClass() != paramClass))
    {
      if (paramClass == FounderColorLayout.class)
      {
        this.mFounderColorLayout = new FounderColorLayout(this, this.mFont);
        return;
      }
      if (paramClass == StrikingLayout.class)
      {
        this.mFounderColorLayout = new StrikingLayout(this, this.mFont);
        return;
      }
      if (paramClass == DynamicMultipleStyleLayout.class)
      {
        this.mFounderColorLayout = new DynamicMultipleStyleLayout(this, this.mFont);
        return;
      }
      if (paramClass == ExpressionLayout.class) {
        this.mFounderColorLayout = new ExpressionLayout(this, this.mFont);
      }
    }
    else
    {
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Unkown class: ");
    ((StringBuilder)localObject).append(paramClass.getName());
    throw new RuntimeException(((StringBuilder)localObject).toString());
  }
  
  private void dealSmallEmojiClick(int paramInt1, int paramInt2)
  {
    Object localObject1 = this.mLayout.a(paramInt1, paramInt2);
    if ((localObject1 instanceof EmoticonSpan)) {
      localObject1 = (EmoticonSpan)localObject1;
    } else {
      localObject1 = null;
    }
    if (localObject1 != null)
    {
      localObject1 = (BubbleInfo)getTag(2131364116);
      Object localObject2 = (ChatMessage)getTag(2131364568);
      Resources localResources = getResources();
      boolean bool = false;
      if (localObject2 != null) {
        bool = ((ChatMessage)localObject2).isSend();
      }
      localObject2 = getBackground();
      if ((localObject2 != null) && ((localObject2 instanceof VipBubbleDrawable)))
      {
        ((VipBubbleDrawable)localObject2).jdField_a_of_type_Boolean = true;
        return;
      }
      if ((localObject2 != null) && (localObject1 != null))
      {
        if (bool) {
          paramInt1 = 2130850335;
        } else {
          paramInt1 = 2130850159;
        }
        ((BubbleInfo)localObject1).a(this, localResources.getDrawable(paramInt1));
      }
    }
  }
  
  private boolean hasDecorAnimation()
  {
    Object localObject = this.mLayout;
    boolean bool = false;
    if (localObject == null) {
      return false;
    }
    localObject = this.mDecoration;
    if (localObject == null) {
      return false;
    }
    if (((ETDecoration)localObject).getFrameNum() > 0) {
      bool = true;
    }
    return bool;
  }
  
  private static void initHandler()
  {
    if (mCreateDecorationHandler == null)
    {
      mUIHandler = new ETTextView.UpdateUIHandler(null);
      Object localObject;
      if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface))
      {
        localObject = (IFontManagerService)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getRuntimeService(IFontManagerService.class, "");
        if ((localObject != null) && (((IFontManagerService)localObject).getHandlerThread() != null) && (((IFontManagerService)localObject).getHandlerThread().getLooper() != null)) {
          mCreateDecorationHandler = new ETTextView.DecorationHandler(((IFontManagerService)localObject).getHandlerThread().getLooper());
        }
      }
      else if ((BaseApplicationImpl.getApplication().getRuntime() instanceof ToolAppRuntime))
      {
        localObject = FontManagerForTool.a();
        if (localObject != null) {
          mCreateDecorationHandler = new ETTextView.DecorationHandler(((FontManagerForTool)localObject).a.getLooper());
        }
      }
    }
  }
  
  private void setFont(ETFont paramETFont, long paramLong, int paramInt)
  {
    if (this.mMsgId != paramLong) {
      this.hasComputeComplexScript = false;
    }
    ETFont localETFont = this.mFont;
    if (localETFont == null)
    {
      this.mFont = new ETFont(paramETFont.mFontId, paramETFont.mFontPath, getTextSize(), paramETFont.mFontType, paramETFont.mTypeface);
      this.mFont.copy(paramETFont);
      this.mFont.setSize(getTextSize());
    }
    else
    {
      localETFont.copy(paramETFont);
      localETFont = this.mFont;
      localETFont.mAnimationId = paramLong;
      localETFont.mText = paramETFont.mText;
      if (paramETFont.mFontType != 1) {
        this.mFont.mTypeface = paramETFont.mTypeface;
      }
      this.mFont.mDiyHandle = paramETFont.mDiyHandle;
    }
    paramETFont = this.mFont;
    paramETFont.mComboIndex = paramInt;
    if ((paramETFont.mFontType != 1) && (this.mFont.mTypeface != null)) {
      setTypeface(this.mFont.mTypeface);
    }
    if (this.mFont.mFontId == 0) {
      setTypeface(null);
    }
    this.mMsgId = paramLong;
    if (this.mLayout == null) {
      this.mLayout = new ETLayout();
    }
    this.mFont.setColor(getCurrentTextColor());
    paramETFont = this.mOnBeforeTextOrFontChangeListener;
    if (paramETFont != null) {
      paramETFont.a(this);
    }
  }
  
  public void clearFounderAnimation()
  {
    if (this.mFounderColorLayout != null)
    {
      this.mMsgId = System.currentTimeMillis();
      this.mFounderColorLayout.i();
    }
  }
  
  public void clearHighlightContent()
  {
    Object localObject;
    if (isUsingFZColorFont2())
    {
      localObject = this.mFounderColorLayout;
      if ((localObject instanceof FounderBaseLayout.FounderHighlightInterface)) {
        ((FounderBaseLayout.FounderHighlightInterface)localObject).d();
      }
    }
    else if (isUsingHYFont())
    {
      localObject = this.mTextSelection;
      if (localObject != null) {
        ((ETTextSelection)localObject).a();
      }
    }
    else
    {
      super.clearHighlightContent();
    }
  }
  
  public ETLayout getETLayout()
  {
    return this.mLayout;
  }
  
  public int getETMaxWidth()
  {
    return this.mMaxWidth;
  }
  
  public TextGraphMap getTextGraphMap()
  {
    if (this.mTextGraphMap == null) {
      this.mTextGraphMap = new TextGraphMap(getText());
    }
    return this.mTextGraphMap;
  }
  
  public boolean hasFounderAnimationFont()
  {
    ETFont localETFont = this.mFont;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localETFont != null)
    {
      bool1 = bool2;
      if (localETFont.mFontId != 0)
      {
        bool1 = bool2;
        if (this.mFont.mFontType == 4)
        {
          int i = FastColorFontCache.b(this.mFont.mFontId);
          if ((i != 3) && (i != 7))
          {
            bool1 = bool2;
            if (i != 8) {}
          }
          else
          {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public boolean hasHYFont()
  {
    ETFont localETFont = this.mFont;
    if (((localETFont != null) && (localETFont.mFontId != 0) && (this.mFont.mFontType == 1)) || (isDrawDefaultByHY())) {
      return ETEngine.getInstance().native_containComplexScript(getText().toString()) ^ true;
    }
    return false;
  }
  
  public void highlightContent()
  {
    int i;
    int j;
    if (isUsingFZColorFont2())
    {
      if ((this.mFounderColorLayout instanceof FounderBaseLayout.FounderHighlightInterface))
      {
        i = getTextGraphMap().a(startIndex());
        j = getTextGraphMap().a(endIndex());
        ((FounderBaseLayout.FounderHighlightInterface)this.mFounderColorLayout).a(i, j);
      }
    }
    else if (isUsingHYFont())
    {
      if (this.mTextSelection != null)
      {
        i = getTextGraphMap().a(startIndex());
        j = getTextGraphMap().a(endIndex() - 1);
        this.mTextSelection.a(i, j);
      }
    }
    else {
      super.highlightContent();
    }
  }
  
  protected void init()
  {
    this.mSelectPaint = new Paint();
    setTypeface(null);
  }
  
  public boolean isCacheMeasureResult()
  {
    return this.mCacheMeasureResult;
  }
  
  public boolean isDrawDefaultByHY()
  {
    ETFont localETFont = this.mFont;
    return (localETFont != null) && (localETFont.mFontId == 9999) && (!android.text.TextUtils.isEmpty(this.mFont.mFontPath)) && (VasShieldFont.jdField_a_of_type_Int == 4);
  }
  
  public boolean isUseExpressFont()
  {
    boolean bool3 = isUsingFZColorFont2();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      int i = FastColorFontCache.b(this.mFont.mFontId);
      int j = FastColorFontCache.c(this.mFont.mFontId);
      bool1 = bool2;
      if (i == 8) {
        if (j != 3)
        {
          bool1 = bool2;
          if (j != 4) {}
        }
        else
        {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public boolean isUsingFZColorFont2()
  {
    if (!this.hasComputeComplexScript)
    {
      this.hasComplexScript = com.tencent.mobileqq.text.TextUtils.isContainComplexScript(getText().toString());
      this.hasComputeComplexScript = true;
    }
    ETFont localETFont = this.mFont;
    return (localETFont != null) && (localETFont.mFontId != 0) && (this.mFont.mFontType == 4) && (!this.hasComplexScript);
  }
  
  public boolean isUsingFounderAnimationFont()
  {
    return hasFounderAnimationFont();
  }
  
  public boolean isUsingHYFont()
  {
    if (hasHYFont())
    {
      ETLayout localETLayout = this.mLayout;
      if ((localETLayout != null) && (localETLayout.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())) {
        return true;
      }
    }
    return false;
  }
  
  public boolean isViewVisible()
  {
    boolean bool1 = getContext() instanceof BaseActivity;
    boolean bool2 = true;
    if (bool1)
    {
      Object localObject1 = ((BaseActivity)getContext()).getChatFragment();
      if ((localObject1 != null) && (((ChatFragment)localObject1).a() != null) && (((ChatFragment)localObject1).a().a != null))
      {
        localObject1 = ((ChatFragment)localObject1).a().a;
        localObject1 = AIOUtils.a((ListView)localObject1, AIOUtils.a(this.mMsgId, ((XListView)localObject1).getAdapter()));
        Object localObject2;
        if ((localObject1 != null) && ((((View)localObject1).getTag() instanceof TextItemBuilder.Holder)))
        {
          localObject2 = (TextItemBuilder.Holder)((View)localObject1).getTag();
          if ((((TextItemBuilder.Holder)localObject2).d != null) && (((TextItemBuilder.Holder)localObject2).d.getTop() + ((View)localObject1).getBottom() >= getContext().getResources().getDimensionPixelSize(2131299168))) {
            return true;
          }
        }
        else if ((localObject1 != null) && ((AIOUtils.a((View)localObject1) instanceof RichStatItemBuilder.Holder)))
        {
          localObject2 = (RichStatItemBuilder.Holder)AIOUtils.a((View)localObject1);
          if (((View)localObject1).getTop() + ((View)localObject1).getBottom() >= getContext().getResources().getDimensionPixelSize(2131299168)) {
            return true;
          }
        }
      }
    }
    boolean bool3 = ((IProfileCardApi)QRoute.api(IProfileCardApi.class)).isProfileCardActivity(getContext());
    bool1 = bool2;
    if (!(getContext() instanceof QQBrowserActivity))
    {
      bool1 = bool2;
      if (!(getContext() instanceof PublicFragmentActivity))
      {
        if (bool3) {
          return true;
        }
        bool1 = false;
      }
    }
    return bool1;
  }
  
  public void locationByIndex(int paramInt, int[] paramArrayOfInt, boolean paramBoolean)
  {
    if (isUsingFZColorFont2())
    {
      if ((this.mFounderColorLayout instanceof FounderBaseLayout.FounderHighlightInterface))
      {
        paramInt = getTextGraphMap().a(paramInt);
        ((FounderBaseLayout.FounderHighlightInterface)this.mFounderColorLayout).a(paramInt, paramArrayOfInt, paramBoolean);
      }
    }
    else if (isUsingHYFont())
    {
      if (this.mTextSelection != null)
      {
        paramInt = getTextGraphMap().a(paramInt);
        this.mTextSelection.a(paramInt, paramArrayOfInt, paramBoolean);
      }
    }
    else {
      super.locationByIndex(paramInt, paramArrayOfInt, paramBoolean);
    }
  }
  
  public void onAnimationEnd(int paramInt)
  {
    ETTextView.TextAnimationListener localTextAnimationListener = this.mAnimationListener;
    if (localTextAnimationListener != null) {
      localTextAnimationListener.a(this.mMessage, paramInt);
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    FounderBaseLayout localFounderBaseLayout = this.mFounderColorLayout;
    if (localFounderBaseLayout != null) {
      localFounderBaseLayout.e();
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (android.text.TextUtils.isEmpty(getText()))
    {
      super.onDraw(paramCanvas);
      return;
    }
    boolean bool2 = isUsingHYFont();
    boolean bool1 = true;
    if ((!bool2) && (!isUsingFZColorFont2()))
    {
      ??? = this.mFont;
      if ((??? != null) && (((ETFont)???).mFontId != 0)) {
        if ((this.mFont.mFontType == 1) && (ETEngine.getInstance().native_isColorVariantFont(this.mFont)))
        {
          setTextColor(ETEngine.getInstance().native_getTextColor(this.mFont));
        }
        else if (this.mFont.mFontType == 4)
        {
          ??? = this.mFZColor;
          if (FastColorFontHelper.a().a(this.mFont.mFontId, this.mFont.mComboIndex, (int[])???) == 1) {
            setTextColor(Color.argb(???[3], ???[0], ???[1], ???[2]));
          }
        }
      }
      try
      {
        super.onDraw(paramCanvas);
        return;
      }
      catch (Exception paramCanvas)
      {
        ??? = new StringBuilder();
        ((StringBuilder)???).append("onDraw failed of:");
        ((StringBuilder)???).append(getText());
        QLog.e("ETTextView", 1, ((StringBuilder)???).toString(), paramCanvas);
        return;
      }
    }
    long l1;
    int j;
    int i;
    if (isUsingHYFont())
    {
      l1 = System.currentTimeMillis();
      if (this.shouldStartAnimation) {
        startDecorAnimation(false, false);
      }
      ??? = this.mTextSelection;
      if (??? != null)
      {
        ??? = ((ETTextSelection)???).a();
        this.mSelectPaint.setColor(highlightBackgroundColor());
        if (??? != null)
        {
          j = ((SparseArray)???).size();
          i = 0;
          while (i < j)
          {
            paramCanvas.drawRect((Rect)((SparseArray)???).valueAt(i), this.mSelectPaint);
            i += 1;
          }
        }
      }
      this.mLayout.jdField_a_of_type_ComEtrumpMixlayoutETFont.setColor(getCurrentTextColor());
    }
    for (;;)
    {
      long l2;
      synchronized (this.mBitmapLocker)
      {
        Object localObject2 = this.mBitmapLocker.a();
        if ((localObject2 != null) && (!((Bitmap)localObject2).isRecycled()))
        {
          int m = getPaddingLeft();
          int k = getPaddingTop();
          if ((this.mDecorRunning) && (this.mDecoration != null))
          {
            paramCanvas.drawBitmap((Bitmap)localObject2, m, k, null);
            i = m;
            j = k;
            if (this.mDecoration.getDecorationType() == 1)
            {
              this.mLayout.a(paramCanvas, m, k);
              i = m;
              j = k;
            }
          }
          else
          {
            ETEngine localETEngine = ETEngine.getInstance();
            if ((this.mDecoration == null) || (this.mDecoration.isLastFrame())) {
              break label700;
            }
            ((Bitmap)localObject2).eraseColor(0);
            this.mLayout.a(localETEngine, (Bitmap)localObject2, this.mDecoration, bool1);
            this.mLayout.a(paramCanvas, m, k, (Bitmap)localObject2);
            i = m;
            j = k;
            if (this.mDecoration != null)
            {
              localObject2 = this.mDecoration.mMargins;
              i = m;
              j = k;
              if (localObject2 != null)
              {
                i = m + ((Rect)localObject2).left;
                j = k + ((Rect)localObject2).top;
              }
            }
            this.mLayout.a(paramCanvas, i, j);
          }
          this.mLayout.b(paramCanvas, i, j);
        }
        l2 = System.currentTimeMillis();
        FontReportUtils.a("action_draw", this.mFont.mFontId, this.mFont.mFontType, getText().length(), l2 - l1);
        return;
      }
      if (isUsingFZColorFont2())
      {
        l1 = System.currentTimeMillis();
        ??? = this.mFounderColorLayout;
        if ((??? != null) && (!((FounderBaseLayout)???).a(paramCanvas)))
        {
          super.onDraw(paramCanvas);
        }
        else
        {
          l2 = System.currentTimeMillis();
          FontReportUtils.a("action_draw", this.mFont.mFontId, 4, getText().length(), l2 - l1);
        }
        if (hasFounderAnimationFont()) {
          startFounderDecorAnimation(false, false);
        }
      }
      return;
      label700:
      bool1 = false;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (android.text.TextUtils.isEmpty(getText()))
    {
      super.onMeasure(paramInt1, paramInt2);
      return;
    }
    label1413:
    label1419:
    label1425:
    label1431:
    label1446:
    for (;;)
    {
      int i;
      int j;
      int i1;
      int m;
      boolean bool;
      try
      {
        Object localObject1;
        if (isUsingFZColorFont2())
        {
          i = FastColorFontCache.b(this.mFont.mFontId);
          j = FastColorFontCache.c(this.mFont.mFontId);
          if (i == 8)
          {
            if (j != 1)
            {
              if (j != 2) {
                break label1392;
              }
              continue;
              createFounderLayout(FounderColorLayout.class);
              continue;
              createFounderLayout(ExpressionLayout.class);
              continue;
            }
            createFounderLayout(StrikingLayout.class);
          }
          else if (i == 7)
          {
            createFounderLayout(DynamicMultipleStyleLayout.class);
          }
          else
          {
            createFounderLayout(FounderColorLayout.class);
          }
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("createFounderLayout: ");
            ((StringBuilder)localObject1).append(this.mFont.mFontId);
            ((StringBuilder)localObject1).append(",");
            ((StringBuilder)localObject1).append(i);
            ((StringBuilder)localObject1).append(",");
            ((StringBuilder)localObject1).append(j);
            ((StringBuilder)localObject1).append(",");
            ((StringBuilder)localObject1).append(this.mFounderColorLayout);
            QLog.d("ETTextView", 2, ((StringBuilder)localObject1).toString());
          }
          localObject1 = this.mFounderColorLayout.a(paramInt1, paramInt2, this.mMsgId, this.mMagicFont, this.mFont);
          if ((localObject1 != null) && (localObject1[0] > 0) && (localObject1[1] > 0))
          {
            setMeasuredDimension(localObject1[0], localObject1[1]);
            return;
          }
          super.onMeasure(paramInt1, paramInt2);
        }
        else
        {
          if (!hasHYFont())
          {
            super.onMeasure(paramInt1, paramInt2);
            return;
          }
          i1 = View.MeasureSpec.getMode(paramInt1);
          int n = View.MeasureSpec.getMode(paramInt2);
          m = View.MeasureSpec.getSize(paramInt1);
          int k = View.MeasureSpec.getSize(paramInt2);
          Object localObject3 = this.mLayout;
          localObject1 = null;
          if ((localObject3 == null) || (this.mLayout.jdField_a_of_type_Long != this.mMsgId) || ((this.mFont != null) && (!this.mFont.equals(this.mLayout.jdField_a_of_type_ComEtrumpMixlayoutETFont))) || (!this.mCacheMeasureResult) || (this.mLayout.jdField_b_of_type_Boolean != this.mMagicFont))
          {
            this.mDecorRunning = false;
            this.mLayout = new ETLayout();
            this.mTextSelection = new ETTextSelection(this, this.mLayout);
            if (this.mDecoration != null)
            {
              this.mDecoration.deleteDescriptor();
              this.mDecoration = null;
            }
            int i2 = getLinkTextColors().getDefaultColor();
            if (this.mFont != null)
            {
              this.mFont.setColor(getCurrentTextColor());
              this.mFont.setSize(getTextSize());
              if ((getPaint().getFlags() & 0x20) <= 0) {
                break label1413;
              }
              bool = true;
              this.mFont.setBold(bool);
              if (this.mShadowRadius > 0.0F) {
                this.mFont.setShadow(true, this.mShadowColor, (int)this.mShadowDx, (int)this.mShadowDy, (int)this.mShadowRadius);
              } else {
                this.mFont.setShadow(false, 0, 0, 0, 0);
              }
            }
            localObject1 = ETEngine.getInstance();
            localObject3 = getPaint().getFontMetrics();
            float f1 = ((Paint.FontMetrics)localObject3).descent;
            float f2 = ((Paint.FontMetrics)localObject3).ascent;
            float f3 = ((Paint.FontMetrics)localObject3).leading;
            this.mLayout.jdField_a_of_type_Int = ((int)(f1 - f2 + f3));
            this.mLayout.jdField_a_of_type_Long = this.mMsgId;
            this.mLayout.jdField_b_of_type_Boolean = this.mMagicFont;
            this.mLayout.a(this.mLinkBackcolor);
            localObject3 = new ETFont(this.mFont.mFontId, this.mFont.mFontPath, getTextSize());
            ((ETFont)localObject3).copy(this.mFont);
            i = this.mMaxWidth;
            if ((i1 == -2147483648) || (i1 == 1073741824)) {
              i = Math.min(this.mMaxWidth, m);
            }
            j = i - (getPaddingLeft() + getPaddingRight());
            i = j;
            if (i1 == -2147483648) {
              i = Math.min(m, j);
            }
            if (this.mLayout.jdField_b_of_type_Boolean)
            {
              f1 = FontManagerConstants.magicFontNormalSize1;
              if (FontSettingManager.getFontLevel() == 18.0F) {
                f1 = FontManagerConstants.magicFontMaxSize1;
              }
              ((ETFont)localObject3).setSize(f1 * getTextSize());
            }
            j = ((ETEngine)localObject1).native_getHorizontalMarginThreshold((ETFont)localObject3, i);
            ((ETFont)localObject3).setSize(getTextSize());
            if ((j <= 0) || (j >= i)) {
              break label1419;
            }
            bool = this.mLayout.a((ETEngine)localObject1, i - j, getText(), (ETFont)localObject3, i2, true, i);
            this.mDecoration = this.mLayout.a((ETEngine)localObject1, true);
            if (this.mDecoration == null)
            {
              bool = this.mLayout.a((ETEngine)localObject1, i, getText(), (ETFont)localObject3, i2, false, i);
              this.mDecoration = this.mLayout.a((ETEngine)localObject1, true);
            }
            if (!bool)
            {
              this.mFont.mFontId = 0;
              this.mLayout.jdField_a_of_type_Long = -1L;
              super.onMeasure(paramInt1, paramInt2);
              return;
            }
            if ((this.mLayout.jdField_b_of_type_Int >= 2048) || (this.mLayout.c >= 2048)) {
              continue;
            }
            if (!this.mLayout.jdField_a_of_type_Boolean)
            {
              i = this.mLayout.jdField_b_of_type_Int;
              j = this.mLayout.c;
              if (this.mDecoration == null) {
                break label1425;
              }
              localObject1 = this.mDecoration.mMargins;
              i += ((Rect)localObject1).left + ((Rect)localObject1).right;
              j += ((Rect)localObject1).top + ((Rect)localObject1).bottom;
              ETTextView.BitmapLocker.a(this.mBitmapLocker, i, j);
            }
          }
          else
          {
            if (this.mDecoration == null) {
              break label1431;
            }
            localObject1 = this.mDecoration.mMargins;
            break label1431;
            j = this.mLayout.jdField_b_of_type_Int + getPaddingLeft() + getPaddingRight();
            i = j;
            if (localObject1 != null) {
              i = j + (((Rect)localObject1).left + ((Rect)localObject1).right);
            }
            m = Math.min(i, this.mMaxWidth);
            if (n == 1073741824)
            {
              i = k;
            }
            else
            {
              j = this.mLayout.c + getPaddingTop() + getPaddingBottom();
              i = j;
              if (localObject1 != null) {
                i = j + (((Rect)localObject1).top + ((Rect)localObject1).bottom);
              }
              if (n != -2147483648) {
                break label1446;
              }
              i = Math.min(i, k);
            }
            setMeasuredDimension(Math.max(m, this.mMinWidth), Math.max(i, this.mMinHeight));
            return;
          }
          throw new Exception("no text use system measure2");
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("large bitmap width=");
          ((StringBuilder)localObject1).append(0);
          ((StringBuilder)localObject1).append(", height=");
          ((StringBuilder)localObject1).append(0);
          throw new Exception(((StringBuilder)localObject1).toString());
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("ETTextView", 1, "measure fail ", localThrowable);
        localThrowable.printStackTrace();
        this.mFont.mFontId = 0;
        this.mLayout.jdField_a_of_type_Long = -1L;
        if ((!mReportError) && (localThrowable.getMessage().contains("textlayout")))
        {
          VasMonitorHandler.a(null, "individual_v2_font_measure_error", "font_measure_error", localThrowable.getMessage(), localThrowable.getMessage(), 0.0F);
          VasMonitorDT.a("individual_v2_font_measure_error", "font_measure_error");
          mReportError = true;
        }
        super.onMeasure(paramInt1, paramInt2);
        return;
      }
      label1392:
      if ((j != 3) && (j != 4)) {
        if (j == 5)
        {
          continue;
          bool = false;
          continue;
          bool = false;
          continue;
          Object localObject2 = null;
          continue;
          if (i1 == 1073741824) {
            i = m;
          }
        }
      }
    }
  }
  
  public boolean onPreDraw()
  {
    if ((!isUsingHYFont()) && (!isUsingFZColorFont2()))
    {
      getViewTreeObserver().removeOnPreDrawListener(this);
      return super.onPreDraw();
    }
    getViewTreeObserver().removeOnPreDrawListener(this);
    return true;
  }
  
  protected void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    super.onTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
    this.mTextGraphMap = null;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((!isUsingHYFont()) && (!isUsingFZColorFont2())) {
      return super.onTouchEvent(paramMotionEvent);
    }
    if (this.onDoubleClick != null)
    {
      int i;
      int j;
      int k;
      int m;
      int n;
      int i1;
      Object localObject;
      if ((this.mPreviousUpEvent != null) && (paramMotionEvent.getAction() == 0))
      {
        this.touchL = paramMotionEvent.getX();
        this.touchT = paramMotionEvent.getY();
        i = (int)paramMotionEvent.getX();
        j = (int)paramMotionEvent.getY();
        k = getPaddingLeft();
        m = getPaddingTop();
        n = getScrollX();
        i1 = getScrollY();
        this.mClickEpId = -1;
        this.mClickcEId = -1;
        if (isUsingHYFont()) {
          dealSmallEmojiClick(i - k + n, j - m + i1);
        }
        this.mCurrentDownEvent = MotionEvent.obtain(paramMotionEvent);
        localObject = this.mPreviousUpEvent;
        if (localObject != null)
        {
          MotionEvent localMotionEvent = this.mCurrentDownEvent;
          if ((localMotionEvent != null) && (isConsideredDoubleTap(localMotionEvent, (MotionEvent)localObject, paramMotionEvent)))
          {
            this.isSingleClick = false;
            this.mCurrentDownEvent = null;
            this.mPreviousUpEvent = null;
            if (this.onDoubleClick != null)
            {
              this.doublleClicked = true;
              this.onDoubleClick.a(this);
              return true;
            }
          }
        }
      }
      else if ((this.mPreviousUpEvent == null) && (paramMotionEvent.getAction() == 0))
      {
        this.isSingleClick = true;
        this.touchL = paramMotionEvent.getX();
        this.touchT = paramMotionEvent.getY();
        i = (int)paramMotionEvent.getX();
        j = (int)paramMotionEvent.getY();
        k = getPaddingLeft();
        m = getPaddingTop();
        n = getScrollX();
        i1 = getScrollY();
        this.mClickEpId = -1;
        this.mClickcEId = -1;
        if (isUsingHYFont()) {
          dealSmallEmojiClick(i - k + n, j - m + i1);
        }
        if (QLog.isColorLevel()) {
          QLog.d("ETTextView", 2, "reserve to initial status");
        }
      }
      else if (paramMotionEvent.getAction() == 1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ETTextView", 2, "action up");
        }
        k = (int)paramMotionEvent.getX();
        i = (int)paramMotionEvent.getY();
        m = getPaddingLeft();
        j = getPaddingTop();
        k = k - m + getScrollX();
        i = i - j + getScrollY();
        this.mEmojiX = k;
        this.mEmojiY = i;
        if (isUsingHYFont()) {
          i = this.mLayout.b(k, i) + 1;
        } else if (isUsingFZColorFont2()) {
          i = this.mFounderColorLayout.a(k, i, getTextGraphMap());
        } else {
          i = 0;
        }
        localObject = (ClickableSpan[])((Spannable)getText()).getSpans(i, i, ClickableSpan.class);
        if (localObject.length != 0)
        {
          localObject[0].onClick(this);
          return true;
        }
        this.mPreviousUpEvent = MotionEvent.obtain(paramMotionEvent);
        if ((isUsingHYFont()) && (!this.mDecorRunning))
        {
          localObject = this.mDecoration;
          if (localObject != null) {
            ((ETDecoration)localObject).gotoLastFrame();
          }
        }
        if (this.doublleClicked)
        {
          this.doublleClicked = false;
          this.mPreviousUpEvent = null;
        }
        postDelayed(this.mTimerForSecondClick, 200L);
      }
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void pauseAnimation()
  {
    this.mPauseAnimation = true;
  }
  
  public void pauseFounderColorFontAnimation()
  {
    FounderBaseLayout localFounderBaseLayout = this.mFounderColorLayout;
    if (localFounderBaseLayout != null) {
      localFounderBaseLayout.f();
    }
  }
  
  public void restartFounderColorFontAnimation()
  {
    FounderBaseLayout localFounderBaseLayout = this.mFounderColorLayout;
    if (localFounderBaseLayout != null) {
      localFounderBaseLayout.g();
    }
  }
  
  public void setCacheMeasureResult(boolean paramBoolean)
  {
    if (this.mCacheMeasureResult != paramBoolean)
    {
      this.mCacheMeasureResult = paramBoolean;
      requestLayout();
    }
  }
  
  public void setDefaultFont(Typeface paramTypeface, long paramLong)
  {
    setTypeface(paramTypeface);
    if (VasShieldFont.jdField_a_of_type_Int == 4)
    {
      paramTypeface = this.mFont;
      if (paramTypeface == null)
      {
        this.mFont = new ETFont(9999, VasShieldFont.a(), getTextSize());
      }
      else
      {
        paramTypeface.mFontId = 9999;
        paramTypeface.setPath(VasShieldFont.a());
        this.mFont.setSize(getTextSize());
      }
      this.mMsgId = paramLong;
      this.mFont.mFontType = -1;
    }
    else
    {
      this.mFont = null;
    }
    paramTypeface = this.mOnBeforeTextOrFontChangeListener;
    if (paramTypeface != null) {
      paramTypeface.a(this);
    }
  }
  
  public void setFont(int paramInt, long paramLong)
  {
    ETFont localETFont = this.mFont;
    if (localETFont == null) {
      this.mFont = new ETFont(paramInt, "", getTextSize());
    } else {
      localETFont.mFontId = paramInt;
    }
    if (this.mFont.mFontId == 0) {
      setTypeface(null);
    }
    if (this.mMsgId != paramLong) {
      this.hasComputeComplexScript = false;
    }
    this.mMsgId = paramLong;
  }
  
  public void setFont(ETFont paramETFont, long paramLong)
  {
    setFont(paramETFont, paramLong, 0);
  }
  
  public void setFont(ETFont paramETFont, ChatMessage paramChatMessage, SessionInfo paramSessionInfo)
  {
    if ((paramETFont.mText == null) && ((paramChatMessage instanceof MessageForText)))
    {
      MessageForText localMessageForText = (MessageForText)paramChatMessage;
      localObject = null;
      if (!android.text.TextUtils.isEmpty(localMessageForText.sb)) {
        if (!android.text.TextUtils.isEmpty(localMessageForText.sb2)) {
          localObject = localMessageForText.sb2;
        } else {
          localObject = localMessageForText.sb;
        }
      }
      paramETFont.mText = ((CharSequence)localObject);
    }
    Object localObject = paramChatMessage.getExtInfoFromExtStr("vip_sub_font_id");
    int i = 0;
    if (!android.text.TextUtils.isEmpty((CharSequence)localObject)) {
      i = Integer.parseInt((String)localObject);
    }
    setFont(paramETFont, paramChatMessage.uniseq, i);
    this.mMessage = paramChatMessage;
    this.mSessionInfo = paramSessionInfo;
  }
  
  public void setIsFounderAnimating(boolean paramBoolean)
  {
    this.isFounderAnimating = paramBoolean;
  }
  
  public void setMaxWidth(int paramInt)
  {
    this.mMaxWidth = paramInt;
    super.setMaxWidth(paramInt);
  }
  
  public void setMinHeight(int paramInt)
  {
    this.mMinHeight = paramInt;
    super.setMinHeight(paramInt);
  }
  
  public void setMinWidth(int paramInt)
  {
    this.mMinWidth = paramInt;
    super.setMinWidth(paramInt);
  }
  
  public void setOnTextOrFontChangeListener(ETTextView.OnTextOrFontChangeListener paramOnTextOrFontChangeListener)
  {
    this.mOnBeforeTextOrFontChangeListener = paramOnTextOrFontChangeListener;
  }
  
  public void setShadowLayer(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt)
  {
    super.setShadowLayer(paramFloat1, paramFloat2, paramFloat3, paramInt);
    this.mShadowRadius = paramFloat1;
    this.mShadowDx = paramFloat2;
    this.mShadowDy = paramFloat3;
    this.mShadowColor = paramInt;
  }
  
  public void setText(CharSequence paramCharSequence, TextView.BufferType paramBufferType)
  {
    ETTextView.OnTextOrFontChangeListener localOnTextOrFontChangeListener = this.mOnBeforeTextOrFontChangeListener;
    if (localOnTextOrFontChangeListener != null) {
      localOnTextOrFontChangeListener.a(this, paramCharSequence);
    }
    super.setText(paramCharSequence, paramBufferType);
  }
  
  public void setTextAnimationListener(ETTextView.TextAnimationListener paramTextAnimationListener)
  {
    this.mAnimationListener = paramTextAnimationListener;
  }
  
  public final void setTextMsg(CharSequence paramCharSequence)
  {
    String str;
    if (getText() != null) {
      str = getText().toString();
    } else {
      str = "";
    }
    if ((paramCharSequence != null) && (!paramCharSequence.toString().equals(str)))
    {
      setText(paramCharSequence);
      this.mMsgId = System.currentTimeMillis();
      requestLayout();
      invalidate();
    }
  }
  
  public void setTypeface(Typeface paramTypeface)
  {
    Typeface localTypeface = paramTypeface;
    if (paramTypeface == null) {}
    try
    {
      localTypeface = Typeface.DEFAULT;
      super.setTypeface(localTypeface);
      return;
    }
    catch (Exception paramTypeface)
    {
      label19:
      break label19;
    }
    QLog.e("ETTextView", 1, "fail to setTypeface", paramTypeface);
  }
  
  public void startAnimation(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (isUsingHYFont())
    {
      startDecorAnimation(paramBoolean1, paramBoolean2);
      return;
    }
    if (hasFounderAnimationFont()) {
      startFounderDecorAnimation(paramBoolean1, paramBoolean2);
    }
  }
  
  public void startDecorAnimation(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.mPauseAnimation = false;
    if ((hasDecorAnimation()) && (isViewVisible()))
    {
      if (this.isParsingMagicFont) {
        return;
      }
      boolean bool;
      if ((ETFontUtil.enableAnimation) && (!this.mPauseAnimation)) {
        bool = true;
      } else {
        bool = false;
      }
      this.mDecorAnimating = bool;
      if ((this.mDecorAnimating) && (!this.mDecorRunning))
      {
        if ((paramBoolean2) && (this.mDecoration.isLastFrame())) {
          return;
        }
        this.mDecorRunning = true;
        this.shouldStartAnimation = false;
        mUIHandler.obtainMessage(0, ETTextView.DecorationHolder.a(this)).sendToTarget();
        if (!paramBoolean2)
        {
          ETTextView.TextAnimationListener localTextAnimationListener = this.mAnimationListener;
          if (localTextAnimationListener != null) {
            localTextAnimationListener.a(this.mMessage, paramBoolean1, this.mFont.mFontId);
          }
        }
      }
    }
  }
  
  public void startFounderColorFontAnimation()
  {
    FounderBaseLayout localFounderBaseLayout = this.mFounderColorLayout;
    if (localFounderBaseLayout != null) {
      localFounderBaseLayout.b();
    }
  }
  
  public void startFounderDecorAnimation(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.mPauseAnimation = false;
    if (this.mFont != null)
    {
      if (!isViewVisible()) {
        return;
      }
      Object localObject;
      if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface))
      {
        localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        if (localObject != null)
        {
          localObject = (IFontManagerService)((QQAppInterface)localObject).getRuntimeService(IFontManagerService.class, "");
          if ((localObject != null) && (!((IFontManagerService)localObject).getFounderDynamicFontAbility())) {
            return;
          }
        }
      }
      int i;
      int j;
      if ((ETFontUtil.enableAnimation) && (!this.mPauseAnimation))
      {
        if ((this.mFounderColorLayout != null) && ((this.shouldStartAnimation) || (paramBoolean1) || (paramBoolean2)))
        {
          i = this.mFounderColorLayout.e;
          localObject = this.mFounderColorLayout.i;
          if (localObject != null)
          {
            j = localObject[0];
            if ((paramBoolean2) && (i == 0)) {
              return;
            }
            if (i == 0)
            {
              startFounderColorFontAnimation();
              this.isFounderAnimating = true;
            }
            else if ((i > 0) && (i < j))
            {
              restartFounderColorFontAnimation();
              this.isFounderAnimating = true;
            }
            this.shouldStartAnimation = false;
            if (!paramBoolean2)
            {
              localObject = this.mAnimationListener;
              if (localObject != null) {
                ((ETTextView.TextAnimationListener)localObject).a(this.mMessage, paramBoolean1, this.mFont.mFontId);
              }
            }
          }
        }
      }
      else
      {
        localObject = this.mFounderColorLayout;
        if (localObject != null)
        {
          i = ((FounderBaseLayout)localObject).e;
          localObject = this.mFounderColorLayout.i;
          if (localObject != null)
          {
            j = localObject[0];
            if ((i > 0) && (i < j)) {
              pauseFounderColorFontAnimation();
            }
          }
        }
      }
    }
  }
  
  public void stopAllDecorAnimation()
  {
    Handler localHandler = mUIHandler;
    if (localHandler != null)
    {
      localHandler.removeMessages(0);
      mUIHandler.removeMessages(1);
    }
    localHandler = mCreateDecorationHandler;
    if (localHandler != null) {
      localHandler.removeMessages(2);
    }
    this.mDecorAnimating = false;
    if (hasDecorAnimation()) {
      this.mDecoration.gotoLastFrame();
    }
  }
  
  public void stopFounderColorFontAnimation()
  {
    FounderBaseLayout localFounderBaseLayout = this.mFounderColorLayout;
    if (localFounderBaseLayout != null) {
      localFounderBaseLayout.a(true);
    }
  }
  
  public int touchIndex(int paramInt1, int paramInt2)
  {
    Object localObject;
    if (isUsingFZColorFont2())
    {
      localObject = this.mFounderColorLayout;
      if ((localObject instanceof FounderBaseLayout.FounderHighlightInterface))
      {
        paramInt1 = ((FounderBaseLayout.FounderHighlightInterface)localObject).a(paramInt1, paramInt2);
        return getTextGraphMap().b(paramInt1);
      }
      return -1;
    }
    if (isUsingHYFont())
    {
      localObject = this.mTextSelection;
      if (localObject != null)
      {
        paramInt1 = ((ETTextSelection)localObject).a(paramInt1, paramInt2);
        return getTextGraphMap().b(paramInt1);
      }
      return -1;
    }
    return super.touchIndex(paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.etrump.mixlayout.ETTextView
 * JD-Core Version:    0.7.0.1
 */