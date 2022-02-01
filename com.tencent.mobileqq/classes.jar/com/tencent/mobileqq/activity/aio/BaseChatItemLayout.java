package com.tencent.mobileqq.activity.aio;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout.BaseChatItemLayoutViewBasicAbility;
import com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout.BaseChatItemLayoutViewWrapper;
import com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout.BaseChatItemLayoutViewWrapperFactory;
import com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout.BubbleViewWrapper;
import com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout.HeadIconWrapper;
import com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout.IBubbleViewProcessor;
import com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout.IHeadIconProcessor;
import com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout.INickNameLayoutProcessor;
import com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout.NickNameChatItemLayoutProcessor;
import com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout.NickNameChatItemLayoutProcessor.NickNameLayoutData;
import com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout.NickNameLayoutViewWrapper;
import com.tencent.mobileqq.activity.aio.helper.AIOLongShotHelper;
import com.tencent.mobileqq.activity.selectable.SelectableCursor;
import com.tencent.mobileqq.activity.selectable.SelectableDelegate;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.bubble.LeftSwipeReplyHelper;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.emoticon.EmojiStickerManager.Sticker;
import com.tencent.mobileqq.emoticon.EmojiStickerManager.StickerDoubleClickListener;
import com.tencent.mobileqq.emoticon.StickerInfo;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.widget.TroopRobotNextTipsView;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.config.business.qvip.QVipStickerProcessor;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.MosaicURLImageView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQViewCompatUtil;
import com.tencent.widget.OnlineStatusCircleView;
import java.util.ArrayList;
import java.util.Iterator;

public class BaseChatItemLayout
  extends ChatItemAnimLayout
  implements SelectCursorTouchHelper.SelectCursorTouchHelperListener, SelectableCursor
{
  public static final int A;
  public static int B;
  public static int C;
  public static int D;
  public static int E;
  public static int F;
  public static int G;
  public static int H;
  public static int I;
  public static int J;
  public static int K;
  public static int L;
  public static int M;
  public static int N;
  public static int O;
  public static int P;
  public static int Q;
  public static int R;
  public static int S;
  public static int T;
  public static int U;
  public static int V;
  public static int W;
  public static final int a = ViewUtils.dpToPx(5.0F);
  private static final int aD = ViewUtils.dpToPx(2.0F);
  private static final int aE = ViewUtils.dpToPx(18.0F);
  private static final int aF;
  private static final int aG;
  private static final int aH;
  private static final int aI;
  private static final int aJ;
  private static final int aK;
  private static final int aL;
  private static final int aM;
  public static boolean ad = false;
  public static BaseChatItemLayout.OnChatMessageCheckedChangeListener an;
  public static CompoundButton.OnCheckedChangeListener ao = new BaseChatItemLayout.2();
  public static final int b;
  public static final int c;
  public static int d;
  public static int e;
  public static int f;
  public static int g;
  public static final float h;
  public static final float i;
  public static final float j;
  public static final int k;
  public static final int l;
  public static final int m;
  public static final int n;
  public static final int o;
  public static final int p;
  public static final int q;
  public static final int r;
  public static final int s;
  public static final int t;
  public static final int u;
  public static final int v;
  @Deprecated
  public static final float w;
  public static final int x;
  public static int y;
  public static final int z;
  protected int[] Z = new int[2];
  private SelectableDelegate aN;
  private boolean aO = false;
  private boolean aP = false;
  private int aQ = -1;
  private int aR = -1;
  private int aS = -1;
  private int aT = -1;
  private int aU = -1;
  private int aV = -1;
  private Paint aW;
  private Rect aX;
  private int aY;
  private boolean aZ = false;
  public TextView aa;
  TextView ab;
  public CheckBox ac;
  public URLImageView ae;
  public OnlineStatusCircleView af;
  public ProgressBar ag;
  public ImageView ah;
  public ImageView ai;
  int aj = 0;
  int ak;
  TroopRobotNextTipsView al;
  public ArrayList<EmojiStickerManager.Sticker> am;
  BaseChatItemLayout.MiniAioShieldItemTouchListener ap = null;
  ChatMessage aq;
  public EmojiStickerManager.StickerDoubleClickListener ar;
  private int ba = -1;
  private int bb = -1;
  private int bc = -1;
  private BaseChatItemLayoutViewWrapperFactory bd;
  private TextView be;
  private boolean bf = false;
  private boolean bg = this.bf;
  private int bh = 0;
  private int bi = 0;
  private int bj = 0;
  private int bk = 0;
  private boolean bl = false;
  private MotionEvent bm;
  private boolean bn = false;
  
  static
  {
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    DisplayMetrics localDisplayMetrics = localBaseApplication.getResources().getDisplayMetrics();
    w = localDisplayMetrics.density;
    h = localBaseApplication.getResources().getDimensionPixelSize(2131296687);
    i = localBaseApplication.getResources().getDimensionPixelSize(2131299864);
    j = localBaseApplication.getResources().getDimensionPixelSize(2131296687);
    k = localBaseApplication.getResources().getDimensionPixelSize(2131296614);
    l = localBaseApplication.getResources().getDimensionPixelSize(2131296613);
    aF = localBaseApplication.getResources().getDimensionPixelSize(2131296611);
    aG = localBaseApplication.getResources().getDimensionPixelSize(2131296612);
    aH = localBaseApplication.getResources().getDimensionPixelSize(2131296609);
    aI = localBaseApplication.getResources().getDimensionPixelSize(2131296610);
    m = localBaseApplication.getResources().getDimensionPixelSize(2131296608);
    n = localBaseApplication.getResources().getDimensionPixelSize(2131296683);
    o = localBaseApplication.getResources().getDimensionPixelSize(2131296682);
    aJ = localBaseApplication.getResources().getDimensionPixelSize(2131296680);
    aK = localBaseApplication.getResources().getDimensionPixelSize(2131296681);
    aL = localBaseApplication.getResources().getDimensionPixelSize(2131296678);
    aM = localBaseApplication.getResources().getDimensionPixelSize(2131296679);
    r = localBaseApplication.getResources().getDimensionPixelSize(2131296670);
    q = localBaseApplication.getResources().getDimensionPixelSize(2131296620);
    p = localBaseApplication.getResources().getDimensionPixelSize(2131296663);
    b = localDisplayMetrics.widthPixels;
    c = localDisplayMetrics.heightPixels;
    d = Math.min(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels);
    e = (int)(d - w * 108.0F);
    f = e - getBubblePaddingAlignHead() - getBubblePaddingAlignError();
    g = f - r * 2;
    s = localBaseApplication.getResources().getDimensionPixelSize(2131296657);
    t = localBaseApplication.getResources().getDimensionPixelSize(2131296658);
    u = localBaseApplication.getResources().getDimensionPixelSize(2131296659);
    v = localBaseApplication.getResources().getDimensionPixelSize(2131296655);
    x = localBaseApplication.getResources().getDimensionPixelSize(2131296645);
    y = localBaseApplication.getResources().getDimensionPixelSize(2131296643);
    B = localBaseApplication.getResources().getDimensionPixelSize(2131299805);
    B = Math.min(B, f);
    int i1 = d - s - t - localBaseApplication.getResources().getDimensionPixelSize(2131299800) * 2;
    int i2 = getBubblePaddingAlignHead() + getBubblePaddingAlignError() + B;
    z = Math.min(i1, i2);
    if (d < 1441) {
      A = i1;
    } else {
      A = Math.min(i1, i2);
    }
    C = localBaseApplication.getResources().getDimensionPixelSize(2131296653);
    D = localBaseApplication.getResources().getDimensionPixelSize(2131296652);
    E = localBaseApplication.getResources().getDimensionPixelSize(2131296651);
    F = localBaseApplication.getResources().getDimensionPixelSize(2131296641);
    G = localBaseApplication.getResources().getDimensionPixelSize(2131296640);
    H = localBaseApplication.getResources().getDimensionPixelSize(2131296639);
    I = localBaseApplication.getResources().getDimensionPixelSize(2131296634);
    J = localBaseApplication.getResources().getDimensionPixelSize(2131296636);
    K = localBaseApplication.getResources().getDimensionPixelSize(2131296635);
    M = localBaseApplication.getResources().getDimensionPixelSize(2131296638);
    L = localBaseApplication.getResources().getDimensionPixelSize(2131296637);
    N = localBaseApplication.getResources().getDimensionPixelSize(2131296690);
    O = localBaseApplication.getResources().getDimensionPixelSize(2131296689);
    P = localBaseApplication.getResources().getDimensionPixelSize(2131296691);
    Q = AIOUtils.b(26.0F, localBaseApplication.getResources());
    R = localBaseApplication.getResources().getDimensionPixelSize(2131296644);
    S = localBaseApplication.getResources().getDimensionPixelSize(2131296662);
    T = localBaseApplication.getResources().getDimensionPixelSize(2131296660);
    U = localBaseApplication.getResources().getDimensionPixelSize(2131296661);
    V = localBaseApplication.getResources().getDimensionPixelSize(2131296647);
    W = localBaseApplication.getResources().getDimensionPixelSize(2131296646);
  }
  
  public BaseChatItemLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public BaseChatItemLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public BaseChatItemLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setWillNotDraw(false);
    setClipChildren(false);
    setClipToPadding(false);
    this.bd = new BaseChatItemLayoutViewWrapperFactory(this, paramContext);
  }
  
  private int a(float paramFloat1, float paramFloat2)
  {
    int i3 = this.aQ;
    int i2 = a;
    int i1 = i3 - i2 * 3;
    i3 += i2 * 3;
    int i4 = this.aR;
    i2 = i4 - aE - i2 * 2;
    if ((paramFloat1 >= i1) && (paramFloat1 <= i3) && (paramFloat2 >= i2) && (paramFloat2 <= i4) && (this.aO)) {
      return 1;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isTouchOnCursor, left=");
      localStringBuilder.append(i1);
      localStringBuilder.append(",right=");
      localStringBuilder.append(i3);
      localStringBuilder.append(",top=");
      localStringBuilder.append(i2);
      localStringBuilder.append(", bottom=");
      localStringBuilder.append(i4);
      localStringBuilder.append(", x=");
      localStringBuilder.append(paramFloat1);
      localStringBuilder.append(",y=");
      localStringBuilder.append(paramFloat2);
      QLog.d("BaseChatItemLayout", 2, localStringBuilder.toString());
    }
    i1 = this.aS;
    i2 = a;
    i3 = this.aT;
    i4 = aE;
    if ((paramFloat1 >= i1 - i2 * 3) && (paramFloat1 <= i1 + i2 * 3) && (paramFloat2 >= i3 - i4) && (paramFloat2 <= i3 + i2 * 2) && (this.aP)) {
      return 2;
    }
    return -1;
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    int i1 = this.ba;
    if (i1 == 1)
    {
      i1 = this.aU;
      if (i1 != -1) {
        this.aN.a(paramInt, i1, paramBoolean);
      }
    }
    else if (i1 == 2)
    {
      i1 = this.aV;
      if (i1 != -1) {
        this.aN.a(paramInt, i1, paramBoolean);
      }
    }
  }
  
  private void a(Canvas paramCanvas)
  {
    Object localObject = findViewById(2131430578);
    if (localObject != null)
    {
      this.aq = ((ChatMessage)((View)localObject).getTag(2131430627));
      this.bh = ((View)localObject).getLeft();
      this.bi = ((View)localObject).getMeasuredWidth();
      this.bj = ((View)localObject).getTop();
      this.bk = ((View)localObject).getMeasuredHeight();
    }
    int i2;
    int i1;
    int i3;
    int i4;
    if (this.am != null)
    {
      i2 = 0;
      i1 = 0;
      while (i2 <= this.am.size() - 1)
      {
        EmojiStickerManager.Sticker localSticker = (EmojiStickerManager.Sticker)this.am.get(i2);
        localObject = this.aq;
        if ((localObject != null) && (((ChatMessage)localObject).stickerHidden))
        {
          if (localSticker.b + this.bh + localSticker.d / 2 < getMeasuredWidth() / 2) {
            i3 = -400;
          } else {
            i3 = 400;
          }
          localSticker.g = i3;
          localSticker.h = 0;
        }
        i4 = paramCanvas.getSaveCount();
        paramCanvas.save();
        i3 = localSticker.b + this.bh;
        int i5 = (int)((localSticker.n - 1.0F) * localSticker.d);
        int i6 = (int)((localSticker.n - 1.0F) * localSticker.e);
        paramCanvas.translate(localSticker.g + i3 - i5 / 2, localSticker.c - i6 / 2);
        paramCanvas.rotate((float)localSticker.f, localSticker.d * localSticker.n / 2.0F, localSticker.e * localSticker.n / 2.0F);
        localSticker.a.setAlpha(localSticker.h);
        localSticker.a.setBounds(0, 0, (int)(localSticker.d * localSticker.n), (int)(localSticker.e * localSticker.n));
        localSticker.a.draw(paramCanvas);
        paramCanvas.restoreToCount(i4);
        if ((!localSticker.j) && ((!(localSticker.a instanceof URLDrawable)) || (((URLDrawable)localSticker.a).getStatus() == 1)))
        {
          boolean bool;
          if ((localSticker.d - localSticker.k >= 0) && (localSticker.e - localSticker.l >= 0)) {
            bool = false;
          } else {
            bool = true;
          }
          localSticker.j = bool;
          if (localSticker.o != null) {
            localSticker.o.isShown = localSticker.j;
          }
          if (!localSticker.j)
          {
            i4 = paramCanvas.getSaveCount();
            paramCanvas.save();
            paramCanvas.translate(i3 + localSticker.g - localSticker.d / 2 + localSticker.k, localSticker.c - localSticker.e / 2 + localSticker.l);
            paramCanvas.clipRect(0, 0, localSticker.d, localSticker.e);
            if (localSticker.m == null) {
              localObject = EmojiStickerManager.a().a(getContext()).mutate();
            } else {
              localObject = localSticker.m;
            }
            ((Drawable)localObject).setBounds(0, 0, localSticker.d, localSticker.e);
            ((Drawable)localObject).draw(paramCanvas);
            paramCanvas.restoreToCount(i4);
            localSticker.k += EmojiStickerManager.s;
            localSticker.l += EmojiStickerManager.s;
            localSticker.n -= EmojiStickerManager.t;
            if (localSticker.n < 1.0F) {
              localSticker.n = 1.0F;
            }
          }
        }
        if (localSticker.j) {
          localSticker.n = 1.0F;
        }
        if (!localSticker.j) {
          i1 = 1;
        }
        i2 += 1;
      }
      l();
    }
    else
    {
      i1 = 0;
    }
    if ((EmojiStickerManager.b) || ((!EmojiStickerManager.b) && (this.bf)))
    {
      i2 = paramCanvas.getSaveCount();
      i3 = this.bh;
      i4 = this.bj;
      paramCanvas.clipRect(i3, i4, this.bi + i3, this.bk + i4);
      if (this.bf) {
        localObject = "#19000000";
      } else {
        localObject = "#00000000";
      }
      paramCanvas.drawColor(Color.parseColor((String)localObject));
      paramCanvas.restoreToCount(i2);
      if (!EmojiStickerManager.b) {
        this.bf = false;
      }
    }
    if (i1 != 0) {
      invalidate();
    }
  }
  
  private boolean a(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getAction();
    int i2;
    if (!this.aZ)
    {
      i2 = a(paramMotionEvent.getX(), paramMotionEvent.getY());
      if ((i2 != -1) && (i1 == 0))
      {
        k();
        this.aZ = true;
        this.ba = i2;
        this.bb = this.aN.e();
        this.bc = this.aN.f();
        if (paramMotionEvent.getSource() != -1) {
          this.aN.a(this.ba, false);
        }
        if (this.aN.i()) {
          this.aN.j();
        }
        return true;
      }
      return false;
    }
    k();
    if ((i1 != 1) && (i1 != 3))
    {
      if (i1 == 2)
      {
        int i3 = (int)paramMotionEvent.getRawX();
        int i4 = (int)paramMotionEvent.getRawY();
        int i5 = this.ba;
        int[] arrayOfInt;
        if (i5 == 1)
        {
          i1 = this.aQ;
          i2 = this.aR;
          i5 = aE;
          int i6 = a;
          arrayOfInt = a(i3, i4, i1, i2, i6 * 2 + i5, -i5, this.aO, i6 * 2);
          i1 = arrayOfInt[0];
          i2 = arrayOfInt[1];
        }
        else
        {
          i1 = i3;
          i2 = i4;
          if (i5 == 2)
          {
            i1 = this.aS;
            i2 = this.aT;
            i5 = a;
            arrayOfInt = a(i3, i4, i1, i2, 0, i5 * 2, this.aP, -i5 * 2);
            i1 = arrayOfInt[0];
            i2 = arrayOfInt[1];
          }
        }
        c(i1, i2, paramMotionEvent.getSource());
        return true;
      }
    }
    else
    {
      this.aZ = false;
      this.aU = -1;
      this.aV = -1;
      this.aN.a(-1, true);
      this.aN.h();
      if (i1 == 1)
      {
        if (paramMotionEvent.getSource() == -1) {
          i1 = 2;
        } else {
          i1 = 1;
        }
        ReportController.b(null, "dc00898", "", "", "0X800AE7B", "0X800AE7B", i1, 0, "", "", "", "");
      }
    }
    return true;
  }
  
  private boolean a(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2)
  {
    long l1 = paramMotionEvent2.getEventTime();
    long l2 = paramMotionEvent1.getEventTime();
    boolean bool = false;
    if (l1 - l2 > 200L) {
      return false;
    }
    int i1 = (int)paramMotionEvent1.getX() - (int)paramMotionEvent2.getX();
    int i2 = (int)paramMotionEvent1.getY() - (int)paramMotionEvent2.getY();
    if (i1 * i1 + i2 * i2 < 10000) {
      bool = true;
    }
    return bool;
  }
  
  private int[] a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, boolean paramBoolean, int paramInt7)
  {
    int i2 = a;
    int i1 = paramInt2;
    if (paramInt1 >= paramInt3 - i2 * 3)
    {
      i1 = paramInt2;
      if (paramInt1 <= paramInt3 + i2 * 3)
      {
        i1 = paramInt2;
        if (paramInt2 >= paramInt4 - paramInt5)
        {
          i1 = paramInt2;
          if (paramInt2 <= paramInt4 + paramInt6)
          {
            i1 = paramInt2;
            if (paramBoolean) {
              i1 = paramInt2 + paramInt7;
            }
          }
        }
      }
    }
    return new int[] { paramInt1, i1 };
  }
  
  private boolean b(float paramFloat1, float paramFloat2)
  {
    Object localObject = this.am;
    if ((localObject != null) && (((ArrayList)localObject).size() > 0))
    {
      localObject = this.am.iterator();
      while (((Iterator)localObject).hasNext())
      {
        EmojiStickerManager.Sticker localSticker = (EmojiStickerManager.Sticker)((Iterator)localObject).next();
        int i1 = localSticker.b;
        int i2 = this.bh;
        int i5 = (int)((localSticker.n - 1.0F) * localSticker.d);
        int i4 = (int)((localSticker.n - 1.0F) * localSticker.e);
        int i3 = localSticker.g;
        i5 /= 2;
        int i6 = localSticker.c;
        i4 /= 2;
        float f1 = i1 + i2 + i3 - i5;
        if ((paramFloat1 > f1) && (paramFloat1 < f1 + localSticker.n * localSticker.d))
        {
          f1 = i6 - i4;
          if ((paramFloat2 > f1) && (paramFloat2 < f1 + localSticker.n * localSticker.e)) {
            return true;
          }
        }
      }
    }
    return false;
  }
  
  public static int getBubblePaddingAlignError()
  {
    if (QQTheme.isNowSimpleUI()) {
      return aI;
    }
    return aH;
  }
  
  public static int getBubblePaddingAlignHead()
  {
    if (QQTheme.isNowSimpleUI()) {
      return aG;
    }
    return aF;
  }
  
  public static int getTextBubblePaddingAlignError()
  {
    return getBubblePaddingAlignError() + getTextPaddingAlignError();
  }
  
  public static int getTextBubblePaddingAlignHead()
  {
    return getBubblePaddingAlignHead() + getTextPaddingAlignHead();
  }
  
  public static int getTextPaddingAlignError()
  {
    if (QQTheme.isNowSimpleUI()) {
      return aM;
    }
    return aL;
  }
  
  public static int getTextPaddingAlignHead()
  {
    if (QQTheme.isNowSimpleUI()) {
      return aK;
    }
    return aJ;
  }
  
  private void k()
  {
    if (this.aN != null) {
      return;
    }
    throw new IllegalStateException("Has no bound delegate!");
  }
  
  private void l()
  {
    if (this.bl)
    {
      Object localObject = this.am;
      if ((localObject != null) && (((ArrayList)localObject).size() > 0))
      {
        localObject = this.am.iterator();
        boolean bool = false;
        while (((Iterator)localObject).hasNext())
        {
          EmojiStickerManager.Sticker localSticker = (EmojiStickerManager.Sticker)((Iterator)localObject).next();
          if (localSticker.b + this.bh + localSticker.d / 2 < getMeasuredWidth() / 2)
          {
            if (Math.abs(localSticker.g) > 200)
            {
              localSticker.g -= EmojiStickerManager.r;
              localSticker.h -= Math.abs(EmojiStickerManager.r / 2);
              localSticker.h = Math.min(255, Math.max(0, localSticker.h));
            }
            else
            {
              localSticker.h += Math.abs(EmojiStickerManager.r / 2);
              localSticker.h = Math.min(255, Math.max(0, localSticker.h));
              localSticker.g += EmojiStickerManager.r;
            }
            if (localSticker.g <= 0) {
              break label362;
            }
            localSticker.g = 0;
            if (EmojiStickerManager.f == null) {
              localSticker.h = 255;
            }
            this.bl = false;
          }
          else
          {
            if (Math.abs(localSticker.g) < 200)
            {
              localSticker.h += Math.abs(EmojiStickerManager.r / 2);
              localSticker.h = Math.min(255, Math.max(0, localSticker.h));
              localSticker.g -= EmojiStickerManager.r;
            }
            else
            {
              localSticker.h -= Math.abs(EmojiStickerManager.r / 2);
              localSticker.h = Math.min(255, Math.max(0, localSticker.h));
              localSticker.g += EmojiStickerManager.r;
            }
            if (localSticker.g >= 0) {
              break label362;
            }
            localSticker.g = 0;
            if (EmojiStickerManager.f == null) {
              localSticker.h = 255;
            }
            this.bl = false;
          }
          bool = false;
          label362:
          if (localSticker.g < -400)
          {
            localSticker.g = -400;
            localSticker.h = 0;
            this.bl = false;
            bool = true;
          }
          if (localSticker.g > 400)
          {
            localSticker.g = 400;
            localSticker.h = 0;
            this.bl = false;
            bool = true;
          }
        }
        localObject = this.aq;
        if (localObject != null) {
          ((ChatMessage)localObject).stickerHidden = bool;
        }
        invalidate();
      }
    }
  }
  
  private void setTopId(int paramInt)
  {
    if (this.ak != paramInt)
    {
      this.ak = paramInt;
      Object localObject = (HeadIconWrapper)a(HeadIconWrapper.class);
      if (localObject != null)
      {
        localObject = ((HeadIconWrapper)localObject).c();
        if (localObject != null) {
          ((RelativeLayout.LayoutParams)((BaseChatItemLayoutViewBasicAbility)localObject).getLayoutParams()).addRule(3, this.ak);
        }
      }
      localObject = this.ae;
      if (localObject != null) {
        ((RelativeLayout.LayoutParams)((URLImageView)localObject).getLayoutParams()).addRule(3, this.ak);
      }
      localObject = (NickNameLayoutViewWrapper)a(NickNameLayoutViewWrapper.class);
      BaseChatItemLayoutViewBasicAbility localBaseChatItemLayoutViewBasicAbility;
      if (localObject != null)
      {
        localBaseChatItemLayoutViewBasicAbility = ((NickNameLayoutViewWrapper)localObject).d().c();
        if ((localBaseChatItemLayoutViewBasicAbility != null) && (localBaseChatItemLayoutViewBasicAbility.checkViewNonNull())) {
          ((RelativeLayout.LayoutParams)localBaseChatItemLayoutViewBasicAbility.getLayoutParams()).addRule(3, this.ak);
        }
        localObject = ((NickNameLayoutViewWrapper)localObject).c();
        if ((localObject != null) && (((BaseChatItemLayoutViewBasicAbility)localObject).checkViewNonNull())) {
          ((RelativeLayout.LayoutParams)((BaseChatItemLayoutViewBasicAbility)localObject).getLayoutParams()).addRule(3, this.ak);
        }
      }
      localObject = (BubbleViewWrapper)a(BubbleViewWrapper.class);
      if (localObject != null)
      {
        localObject = ((BubbleViewWrapper)localObject).c();
        if ((localObject != null) && (((BaseChatItemLayoutViewBasicAbility)localObject).checkViewNonNull()))
        {
          localBaseChatItemLayoutViewBasicAbility = a(NickNameChatItemLayoutProcessor.h);
          if ((localBaseChatItemLayoutViewBasicAbility == null) || (!localBaseChatItemLayoutViewBasicAbility.checkViewNonNull()) || (localBaseChatItemLayoutViewBasicAbility.getViewVisibility() != 0))
          {
            ((RelativeLayout.LayoutParams)((BaseChatItemLayoutViewBasicAbility)localObject).getLayoutParams()).addRule(3, this.ak);
            if (QLog.isColorLevel())
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append(" setTopId mTopId = ");
              ((StringBuilder)localObject).append(this.ak);
              QLog.d("BubbleView", 2, ((StringBuilder)localObject).toString());
            }
          }
        }
      }
    }
  }
  
  public int a(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    if ((!this.aO) && (!this.aP)) {
      return -1;
    }
    return new SelectCursorTouchHelper(this, this.aN).a(paramFloat1, paramFloat2, paramInt1, paramInt2);
  }
  
  @Nullable
  public BaseChatItemLayoutViewBasicAbility a(int paramInt)
  {
    BaseChatItemLayoutViewWrapper localBaseChatItemLayoutViewWrapper = a(NickNameLayoutViewWrapper.class);
    if (localBaseChatItemLayoutViewWrapper != null) {
      return localBaseChatItemLayoutViewWrapper.a(paramInt);
    }
    return null;
  }
  
  @Nullable
  public <T extends BaseChatItemLayoutViewWrapper> T a(Class<? extends BaseChatItemLayoutViewWrapper> paramClass)
  {
    return this.bd.a(paramClass);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    Object localObject = this.am;
    if ((localObject != null) && (((ArrayList)localObject).size() > 0))
    {
      localObject = this.aq;
      int i1;
      if ((localObject != null) && (((ChatMessage)localObject).stickerHidden)) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      localObject = this.am.iterator();
      while (((Iterator)localObject).hasNext())
      {
        EmojiStickerManager.Sticker localSticker = (EmojiStickerManager.Sticker)((Iterator)localObject).next();
        if ((this.aq != null) && (i1 != 0))
        {
          int i2;
          if (localSticker.b + this.bh + localSticker.d / 2 < getMeasuredWidth() / 2) {
            i2 = -400;
          } else {
            i2 = 400;
          }
          localSticker.g = i2;
          localSticker.h = 0;
        }
        if ((paramInt2 != EmojiStickerManager.q) || (localSticker.g != 0)) {
          if (paramInt2 == EmojiStickerManager.p)
          {
            if (localSticker.b + this.bh + localSticker.d / 2 < getMeasuredWidth() / 2) {
              localSticker.g -= paramInt1;
            } else {
              localSticker.g += paramInt1;
            }
            localSticker.h -= Math.abs(paramInt1 / 2);
            localSticker.h = Math.min(255, Math.max(0, localSticker.h));
          }
          else if (paramInt2 == EmojiStickerManager.q)
          {
            if (localSticker.b + this.bh + localSticker.d / 2 < getMeasuredWidth() / 2)
            {
              localSticker.g += paramInt1;
              if (localSticker.g > 0) {
                localSticker.g = 0;
              }
            }
            else
            {
              localSticker.g -= paramInt1;
              if (localSticker.g < 0) {
                localSticker.g = 0;
              }
            }
            localSticker.h += Math.abs(paramInt1 / 2);
            localSticker.h = Math.min(255, Math.max(0, localSticker.h));
          }
        }
        if (localSticker.g < -400) {
          localSticker.g = -400;
        }
        if (localSticker.g > 400) {
          localSticker.g = 400;
        }
      }
      if (i1 != 0)
      {
        localObject = this.aq;
        if (localObject != null) {
          ((ChatMessage)localObject).stickerHidden = false;
        }
      }
      invalidate();
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt3 == 2)
    {
      this.bb = (paramInt1 - paramInt2);
      return;
    }
    this.bc = (paramInt1 + paramInt2);
  }
  
  public void a(Context paramContext, BaseAdapter paramBaseAdapter)
  {
    Object localObject = (ImageView)findViewById(2131430602);
    if (localObject == null)
    {
      localObject = new ImageView(paramContext);
      ((ImageView)localObject).setId(2131430602);
      ((ImageView)localObject).setImageResource(2130838076);
      int i1 = V;
      paramBaseAdapter = new RelativeLayout.LayoutParams(i1, i1);
      paramBaseAdapter.leftMargin = (paramContext.getResources().getDisplayMetrics().widthPixels + W - getPaddingLeft());
      paramBaseAdapter.addRule(15, 2131430578);
      addView((View)localObject, paramBaseAdapter);
      ((ImageView)localObject).setVisibility(4);
      paramContext = (Context)localObject;
    }
    else
    {
      if ((getScrollX() != 0) && ((paramContext instanceof BaseActivity)))
      {
        paramContext = ((BaseActivity)paramContext).getChatFragment();
        if (paramContext != null)
        {
          paramContext = paramContext.k();
          if (paramContext != null)
          {
            paramContext = (LeftSwipeReplyHelper)paramContext.q(50);
            if (paramContext != null) {
              paramContext.a(this);
            }
          }
        }
      }
      paramBaseAdapter = (RelativeLayout.LayoutParams)((ImageView)localObject).getLayoutParams();
      paramContext = (Context)localObject;
    }
    localObject = a(BubbleViewWrapper.class);
    if (localObject != null)
    {
      localObject = ((BaseChatItemLayoutViewWrapper)localObject).c();
      if (localObject != null) {
        ((BaseChatItemLayoutViewBasicAbility)localObject).post(new BaseChatItemLayout.1(this, paramBaseAdapter, (BaseChatItemLayoutViewBasicAbility)localObject, paramContext));
      }
    }
  }
  
  protected void a(ImageView paramImageView, boolean paramBoolean)
  {
    if (paramImageView != null)
    {
      paramImageView = (RelativeLayout.LayoutParams)paramImageView.getLayoutParams();
      if (paramBoolean)
      {
        paramImageView.addRule(0, 2131430578);
        paramImageView.addRule(1, 0);
        return;
      }
      paramImageView.addRule(1, 2131430578);
      paramImageView.addRule(0, 0);
    }
  }
  
  protected void a(ProgressBar paramProgressBar, boolean paramBoolean)
  {
    if (paramProgressBar != null)
    {
      paramProgressBar = (RelativeLayout.LayoutParams)paramProgressBar.getLayoutParams();
      if (paramBoolean)
      {
        paramProgressBar.addRule(0, 2131430578);
        paramProgressBar.addRule(1, 0);
        return;
      }
      paramProgressBar.addRule(1, 2131430578);
      paramProgressBar.addRule(0, 0);
    }
  }
  
  public void a(SelectableDelegate paramSelectableDelegate)
  {
    this.aN = paramSelectableDelegate;
  }
  
  public boolean a()
  {
    TextView localTextView = this.ab;
    return (localTextView != null) && (localTextView.getVisibility() == 0);
  }
  
  public boolean a(Drawable paramDrawable, int paramInt1, int paramInt2, int paramInt3, int paramInt4, double paramDouble, String paramString, boolean paramBoolean, float paramFloat, StickerInfo paramStickerInfo)
  {
    if (this.am == null) {
      this.am = new ArrayList();
    }
    if (this.am.size() < QVipStickerProcessor.c)
    {
      EmojiStickerManager.Sticker localSticker = new EmojiStickerManager.Sticker();
      if (paramDrawable != null)
      {
        localSticker.a = paramDrawable.mutate();
        paramDrawable.setCallback(this);
      }
      localSticker.b = paramInt1;
      localSticker.c = paramInt2;
      localSticker.d = paramInt3;
      localSticker.e = paramInt4;
      localSticker.f = paramDouble;
      localSticker.i = paramString;
      localSticker.j = paramBoolean;
      localSticker.n = paramFloat;
      localSticker.o = paramStickerInfo;
      this.am.add(localSticker);
      return true;
    }
    return false;
  }
  
  @TargetApi(16)
  public void addChildrenForAccessibility(ArrayList<View> paramArrayList)
  {
    try
    {
      super.addChildrenForAccessibility(paramArrayList);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      label6:
      int i2;
      int i1;
      break label6;
    }
    i2 = getChildCount();
    i1 = 0;
    while (i1 < i2)
    {
      View localView = getChildAt(i1);
      if (localView.getVisibility() == 0) {
        if (QQViewCompatUtil.a(localView)) {
          paramArrayList.add(localView);
        } else {
          localView.addChildrenForAccessibility(paramArrayList);
        }
      }
      i1 += 1;
    }
  }
  
  public int b(int paramInt)
  {
    if (paramInt == 1) {
      return this.aQ;
    }
    return this.aS;
  }
  
  public void b(int paramInt1, int paramInt2, int paramInt3)
  {
    k();
    getLocationInWindow(this.Z);
    boolean bool;
    if ((paramInt1 != -1) && (paramInt2 != -1)) {
      bool = true;
    } else {
      bool = false;
    }
    int[] arrayOfInt;
    if (paramInt3 == 1)
    {
      arrayOfInt = this.Z;
      this.aQ = (paramInt1 - arrayOfInt[0]);
      this.aR = (paramInt2 - arrayOfInt[1]);
      this.aO = bool;
    }
    else
    {
      arrayOfInt = this.Z;
      this.aS = (paramInt1 - arrayOfInt[0]);
      this.aT = (paramInt2 - arrayOfInt[1]);
      this.aP = bool;
    }
    if (this.aW == null) {
      this.aW = new Paint(1);
    }
    if (this.aX == null) {
      this.aX = new Rect();
    }
    if (paramInt3 == 1)
    {
      this.aU = paramInt2;
    }
    else if (paramInt3 == 2)
    {
      this.aV = paramInt2;
    }
    else
    {
      this.aU = -1;
      this.aV = -1;
    }
    invalidate();
  }
  
  public boolean b()
  {
    ImageView localImageView = this.ah;
    return (localImageView != null) && (localImageView.getVisibility() == 0);
  }
  
  public int c(int paramInt)
  {
    if (paramInt == 1) {
      return this.aR;
    }
    return this.aT;
  }
  
  protected void c()
  {
    Object localObject = this.ae;
    if ((localObject != null) && (((URLImageView)localObject).getVisibility() == 0))
    {
      localObject = (RelativeLayout.LayoutParams)this.ae.getLayoutParams();
      if (this.aj == 1)
      {
        ((RelativeLayout.LayoutParams)localObject).addRule(11);
        ((RelativeLayout.LayoutParams)localObject).addRule(9, 0);
      }
      else
      {
        ((RelativeLayout.LayoutParams)localObject).addRule(9);
        ((RelativeLayout.LayoutParams)localObject).addRule(11, 0);
        CheckBox localCheckBox = this.ac;
        if ((localCheckBox != null) && (localCheckBox.getVisibility() != 8)) {
          ((RelativeLayout.LayoutParams)localObject).leftMargin = AIOUtils.b(25.0F, getContext().getResources());
        } else {
          ((RelativeLayout.LayoutParams)localObject).leftMargin = 0;
        }
      }
      ((RelativeLayout.LayoutParams)localObject).addRule(3, this.ak);
    }
  }
  
  protected void c(int paramInt1, int paramInt2, int paramInt3)
  {
    int i2;
    if (this.ba == 1) {
      i2 = this.bb;
    } else {
      i2 = this.bc;
    }
    int i1 = this.aN.b(paramInt1, paramInt2);
    if (paramInt3 == -1) {
      this.aN.a(this.ba, false);
    }
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateCursorLocation, touchIndex=");
      localStringBuilder.append(i1);
      localStringBuilder.append(", type=");
      localStringBuilder.append(this.ba);
      QLog.d("BaseChatItemLayout", 2, localStringBuilder.toString());
    }
    if (i1 == -1) {
      return;
    }
    if (i1 != i2)
    {
      if (this.ba == 1)
      {
        paramInt3 = this.bb;
        if (i1 < paramInt3)
        {
          paramInt3 = this.bc;
          this.bb = i1;
        }
      }
      for (;;)
      {
        i2 = i1;
        i1 = paramInt3;
        paramInt3 = i2;
        break;
        if (i1 > paramInt3)
        {
          paramInt3 = this.bc;
          if (i1 < paramInt3)
          {
            this.bb = i1;
            continue;
          }
        }
        paramInt3 = this.bb;
        if (i1 == paramInt3)
        {
          i1 = this.bc;
          break;
        }
        paramInt3 = this.bc;
        if (i1 == paramInt3)
        {
          i1 = paramInt3 - 1;
        }
        else
        {
          this.bb = paramInt3;
          this.bc = i1;
          this.ba = 2;
          this.aN.a(this.ba);
          break;
          paramInt3 = this.bc;
          if (i1 > paramInt3)
          {
            paramInt3 = this.bb;
            this.bc = i1;
            break;
          }
          if (i1 < paramInt3)
          {
            paramInt3 = this.bb;
            if (i1 > paramInt3)
            {
              this.bc = i1;
              break;
            }
          }
          paramInt3 = this.bc;
          if (i1 == paramInt3)
          {
            i1 = this.bb;
          }
          else
          {
            paramInt3 = this.bb;
            if (i1 == paramInt3)
            {
              i1 = paramInt3 + 1;
              break;
            }
            this.bc = paramInt3;
            this.bb = i1;
            this.ba = 1;
            this.aN.a(this.ba);
          }
        }
      }
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("update selection, s=");
        localStringBuilder.append(paramInt3);
        localStringBuilder.append(", e=");
        localStringBuilder.append(i1);
        QLog.d("BaseChatItemLayout", 2, localStringBuilder.toString());
      }
      this.aN.a(paramInt3, i1);
      this.aN.c(paramInt1, paramInt2);
      a(paramInt1, true);
      return;
    }
    a(paramInt1, false);
  }
  
  public boolean d()
  {
    return this.aj == 1;
  }
  
  public boolean d(int paramInt)
  {
    if (paramInt == 1) {
      return this.aO;
    }
    return this.aP;
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    try
    {
      a(paramCanvas);
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      label13:
      Rect localRect;
      int i1;
      int i2;
      int i3;
      float f1;
      break label13;
    }
    QLog.e("BaseChatItemLayout", 1, "dispatchDraw oom");
    if (this.aO)
    {
      localRect = this.aX;
      i1 = this.aQ;
      i2 = aD;
      i3 = this.aR;
      localRect.set(i1 - i2, i3 - aE, i1, i3);
      this.aW.setColor(this.aY);
      paramCanvas.drawRect(this.aX, this.aW);
      f1 = this.aX.centerX();
      i1 = this.aX.top;
      i2 = a;
      paramCanvas.drawCircle(f1, i1 - i2, i2, this.aW);
    }
    if (this.aP)
    {
      localRect = this.aX;
      i1 = this.aS;
      i2 = this.aT;
      localRect.set(i1, i2 - aE, aD + i1, i2);
      this.aW.setColor(this.aY);
      paramCanvas.drawRect(this.aX, this.aW);
      f1 = this.aX.centerX();
      i1 = this.aX.bottom;
      i2 = a;
      paramCanvas.drawCircle(f1, i1 + i2, i2, this.aW);
    }
  }
  
  @NonNull
  public View e()
  {
    return this;
  }
  
  public void e(int paramInt)
  {
    if (paramInt == 1) {
      this.aO = false;
    } else {
      this.aP = false;
    }
    invalidate();
  }
  
  public void f()
  {
    ArrayList localArrayList = this.am;
    if (localArrayList != null)
    {
      this.bl = false;
      localArrayList.clear();
    }
  }
  
  public void f(int paramInt)
  {
    this.aY = paramInt;
  }
  
  public void g(int paramInt)
  {
    Object localObject = this.am;
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        EmojiStickerManager.Sticker localSticker = (EmojiStickerManager.Sticker)((Iterator)localObject).next();
        localSticker.c += paramInt;
      }
    }
  }
  
  public boolean g()
  {
    ArrayList localArrayList = this.am;
    return (localArrayList == null) || (localArrayList.size() < QVipStickerProcessor.b);
  }
  
  public int getHeadIconPosition()
  {
    return this.aj;
  }
  
  public int getTopId()
  {
    return this.ak;
  }
  
  public void h()
  {
    this.bl = true;
    invalidate();
  }
  
  public boolean i()
  {
    ArrayList localArrayList = this.am;
    return (localArrayList != null) && (localArrayList.size() > 0);
  }
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    invalidate();
  }
  
  public void j()
  {
    setPendantImageVisible(false);
    View localView = findViewById(2131432263);
    if ((localView != null) && (localView.getVisibility() != 8)) {
      localView.setVisibility(8);
    }
    localView = findViewById(2131433476);
    if ((localView != null) && (localView.getVisibility() != 8)) {
      localView.setVisibility(8);
    }
    localView = findViewById(2131433475);
    if ((localView != null) && (localView.getVisibility() != 8)) {
      localView.setVisibility(8);
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.aB) {
      return true;
    }
    if (ad)
    {
      if (paramMotionEvent.getAction() == 0)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("MultiMsg_TAG", 4, "BaseChatItemLayout onInterceptTouchEvent...down ");
        }
        return true;
      }
    }
    else
    {
      if (b(paramMotionEvent.getX(), paramMotionEvent.getY())) {
        return true;
      }
      if (((this.aO) || (this.aP)) && (a(paramMotionEvent.getX(), paramMotionEvent.getY()) != -1))
      {
        k();
        this.aN.m();
        return true;
      }
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    Object localObject = this.am;
    if ((localObject != null) && (((ArrayList)localObject).size() > 0))
    {
      this.bl = false;
      paramInt1 = getMeasuredHeight();
      paramInt2 = getChildCount() - 1;
      while (paramInt2 >= 0)
      {
        localObject = getChildAt(paramInt2);
        int i1 = paramInt1;
        if (localObject != null)
        {
          i1 = paramInt1;
          if (((View)localObject).getId() == 2131430578)
          {
            localObject = (RelativeLayout.LayoutParams)((View)localObject).getLayoutParams();
            i1 = 0;
            int i3 = 0;
            while (i1 < this.am.size())
            {
              EmojiStickerManager.Sticker localSticker = (EmojiStickerManager.Sticker)this.am.get(i1);
              localSticker.h = 255;
              localSticker.g = 0;
              int i2 = paramInt1;
              if (localSticker.c + localSticker.e > paramInt1)
              {
                ((RelativeLayout.LayoutParams)localObject).bottomMargin = (localSticker.c + localSticker.e - paramInt1);
                i2 = localSticker.c + localSticker.e;
                i3 = 1;
              }
              i1 += 1;
              paramInt1 = i2;
            }
            if (i3 == 0)
            {
              ((RelativeLayout.LayoutParams)localObject).bottomMargin = 0;
            }
            else
            {
              setMeasuredDimension(getMeasuredWidth(), paramInt1);
              if (QLog.isColorLevel())
              {
                localObject = new StringBuilder();
                ((StringBuilder)localObject).append("onMeasure bubbleBottm = ");
                ((StringBuilder)localObject).append(paramInt1);
                QLog.d("BaseChatItemLayout", 2, ((StringBuilder)localObject).toString());
              }
            }
            i1 = paramInt1;
          }
        }
        paramInt2 -= 1;
        paramInt1 = i1;
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = this.aB;
    MotionEvent localMotionEvent = null;
    if (bool)
    {
      if ((paramMotionEvent.getAction() == 1) && (!this.aC))
      {
        paramMotionEvent = this.ap;
        if (paramMotionEvent != null)
        {
          paramMotionEvent.a_(this.aq);
          QQToast.makeText(BaseApplication.getContext(), 0, HardCodeUtil.a(2131899220), 0).show();
          return true;
        }
        paramMotionEvent = localMotionEvent;
        if (BaseActivity.sTopActivity != null) {
          paramMotionEvent = BaseActivity.sTopActivity.app;
        }
        ReportController.b(paramMotionEvent, "dc00898", "", "", "0X800A5A7", "0X800A5A7", 0, 0, "8", "", "", "");
      }
      return true;
    }
    if (ad)
    {
      AIOCheckBoxUtil.a(this, paramMotionEvent);
      return true;
    }
    if (b(paramMotionEvent.getX(), paramMotionEvent.getY()))
    {
      if (paramMotionEvent.getAction() == 0)
      {
        localMotionEvent = this.bm;
        if ((localMotionEvent != null) && (a(localMotionEvent, paramMotionEvent)))
        {
          this.bn = true;
          paramMotionEvent = this.ar;
          if (paramMotionEvent != null)
          {
            paramMotionEvent.a(this);
            return true;
          }
        }
      }
      else if (paramMotionEvent.getAction() == 1)
      {
        this.bm = MotionEvent.obtain(paramMotionEvent);
        if (this.bn)
        {
          this.bn = false;
          this.bm = null;
        }
      }
      return true;
    }
    if (((this.aO) || (this.aP)) && (a(paramMotionEvent))) {
      return true;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setBubbleView(View paramView)
  {
    BubbleViewWrapper localBubbleViewWrapper = (BubbleViewWrapper)a(BubbleViewWrapper.class);
    if (localBubbleViewWrapper != null) {
      ((IBubbleViewProcessor)localBubbleViewWrapper.a()).a(paramView);
    }
  }
  
  public void setCheckBox(ChatMessage paramChatMessage)
  {
    boolean bool = ad;
    if (bool)
    {
      Object localObject;
      if (this.ac == null)
      {
        this.ac = new CheckBox(getContext());
        this.ac.setButtonDrawable(2130839226);
        this.ac.setId(2131430605);
        this.ac.setOnCheckedChangeListener(ao);
        localObject = new RelativeLayout.LayoutParams(AIOUtils.b(24.0F, getContext().getResources()), AIOUtils.b(24.0F, getContext().getResources()));
        ((RelativeLayout.LayoutParams)localObject).topMargin = x;
        ((RelativeLayout.LayoutParams)localObject).addRule(9);
        ((RelativeLayout.LayoutParams)localObject).addRule(3, this.ak);
        addView(this.ac, (ViewGroup.LayoutParams)localObject);
      }
      else
      {
        localObject = new RelativeLayout.LayoutParams(AIOUtils.b(24.0F, getContext().getResources()), AIOUtils.b(24.0F, getContext().getResources()));
        ((RelativeLayout.LayoutParams)localObject).topMargin = x;
        ((RelativeLayout.LayoutParams)localObject).addRule(9);
        ((RelativeLayout.LayoutParams)localObject).addRule(3, this.ak);
        this.ac.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      this.ac.setTag(paramChatMessage);
      if (bool)
      {
        localObject = AIOLongShotHelper.f();
        if ((localObject != null) && (((AIOLongShotHelper)localObject).c()))
        {
          this.ac.setVisibility(8);
          this.ac.setChecked(((AIOLongShotHelper)localObject).a(paramChatMessage));
          return;
        }
        this.ac.setVisibility(0);
        if (MultiMsgManager.a().a(paramChatMessage))
        {
          this.ac.setChecked(true);
          return;
        }
        this.ac.setChecked(false);
        return;
      }
      this.ac.setVisibility(4);
      return;
    }
    paramChatMessage = this.ac;
    if (paramChatMessage != null) {
      paramChatMessage.setVisibility(8);
    }
  }
  
  public void setFailedIconResource(int paramInt, View.OnClickListener paramOnClickListener)
  {
    setFailedIconResource(paramInt, paramOnClickListener, null);
  }
  
  public void setFailedIconResource(int paramInt, View.OnClickListener paramOnClickListener, Object paramObject)
  {
    if (this.ah == null)
    {
      this.ah = new ImageView(getContext());
      this.ah.setId(2131430585);
      this.ah.setContentDescription(getContext().getString(2131886538));
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.bottomMargin = AIOUtils.b(16.0F, getContext().getResources());
      localLayoutParams.addRule(8, 2131430578);
      if (this.aj == 1)
      {
        localLayoutParams.addRule(0, 2131430578);
        localLayoutParams.addRule(1, 0);
      }
      else
      {
        localLayoutParams.addRule(1, 2131430578);
        localLayoutParams.addRule(0, 0);
      }
      addView(this.ah, localLayoutParams);
    }
    this.ah.setImageResource(paramInt);
    this.ah.setVisibility(0);
    this.ah.setOnClickListener(paramOnClickListener);
    this.ah.setTag(paramObject);
  }
  
  public void setFailedIconVisable(boolean paramBoolean, View.OnClickListener paramOnClickListener)
  {
    if (paramBoolean)
    {
      setFailedIconResource(2130838271, paramOnClickListener);
    }
    else
    {
      paramOnClickListener = this.ah;
      if (paramOnClickListener != null)
      {
        paramOnClickListener.setVisibility(8);
        this.ah.setOnClickListener(null);
      }
    }
    if (ad)
    {
      paramOnClickListener = this.ah;
      if (paramOnClickListener != null) {
        paramOnClickListener.setOnClickListener(null);
      }
    }
  }
  
  public void setGrayTipsText(boolean paramBoolean, ChatMessage paramChatMessage, CharSequence paramCharSequence, ColorStateList paramColorStateList, int paramInt)
  {
    int i1 = 0;
    if (paramBoolean)
    {
      if (this.ab == null)
      {
        this.ab = new TextView(getContext());
        this.ab.setId(2131430586);
        i1 = AIOUtils.b(12.0F, getContext().getResources());
        int i2 = AIOUtils.b(5.0F, getContext().getResources());
        this.ab.setBackgroundResource(2130846198);
        this.ab.setTextSize(2, 13.0F);
        if (paramColorStateList != null) {
          this.ab.setTextColor(paramColorStateList);
        }
        this.ab.setPadding(i1, i2, i1, i2);
        this.ab.setGravity(17);
        this.ab.setMovementMethod(new LinkMovementMethod());
        if (paramInt <= 0) {
          paramInt = -2;
        } else {
          paramInt = AIOUtils.b(paramInt, getContext().getResources());
        }
        paramColorStateList = new RelativeLayout.LayoutParams(paramInt, -2);
        paramColorStateList.bottomMargin = getContext().getResources().getDimensionPixelOffset(2131296689);
        paramInt = AIOUtils.b(45.0F, getContext().getResources());
        paramColorStateList.leftMargin = paramInt;
        paramColorStateList.rightMargin = paramInt;
        paramColorStateList.addRule(14);
        paramColorStateList.addRule(3, 2131430611);
        addView(this.ab, paramColorStateList);
      }
      this.ab.setVisibility(0);
      if ((paramCharSequence != null) && (!paramCharSequence.equals(this.ab.getTag())))
      {
        this.ab.setText(paramCharSequence);
        this.ab.setTag(paramCharSequence);
      }
      setTopId(2131430586);
    }
    else
    {
      paramCharSequence = this.ab;
      if (paramCharSequence != null)
      {
        paramCharSequence.setVisibility(8);
        paramCharSequence = this.aa;
        paramInt = i1;
        if (paramCharSequence != null)
        {
          paramInt = i1;
          if (paramCharSequence.getVisibility() == 0) {
            paramInt = 2131430611;
          }
        }
        setTopId(paramInt);
      }
    }
    if (this.ak == 2131430611)
    {
      paramCharSequence = this.aa;
      if (paramCharSequence != null)
      {
        paramCharSequence = (RelativeLayout.LayoutParams)paramCharSequence.getLayoutParams();
        paramInt = N;
        if (paramChatMessage.isFirstMsg)
        {
          paramInt = N;
          paramInt = P + paramInt;
        }
        paramCharSequence.topMargin = paramInt;
        return;
      }
    }
    if (this.ak == 2131430586)
    {
      paramChatMessage = this.ab;
      if (paramChatMessage != null)
      {
        paramChatMessage = (RelativeLayout.LayoutParams)paramChatMessage.getLayoutParams();
        paramChatMessage.topMargin = AIOUtils.b(10.0F, getContext().getResources());
        this.ab.setLayoutParams(paramChatMessage);
      }
    }
  }
  
  public void setHeadIconVisible(boolean paramBoolean)
  {
    HeadIconWrapper localHeadIconWrapper = (HeadIconWrapper)a(HeadIconWrapper.class);
    if (localHeadIconWrapper != null) {
      ((IHeadIconProcessor)localHeadIconWrapper.a()).b(paramBoolean);
    }
  }
  
  public void setHearIconPosition(int paramInt)
  {
    if (this.aj != paramInt)
    {
      this.aj = paramInt;
      int i1 = 0;
      boolean bool = true;
      if (paramInt != 1) {
        bool = false;
      }
      Object localObject = this.aa;
      paramInt = i1;
      if (localObject != null)
      {
        paramInt = i1;
        if (((TextView)localObject).getVisibility() == 0) {
          paramInt = this.aa.getId();
        }
      }
      localObject = this.ab;
      i1 = paramInt;
      if (localObject != null)
      {
        i1 = paramInt;
        if (((TextView)localObject).getVisibility() == 0) {
          i1 = this.ab.getId();
        }
      }
      localObject = this.ac;
      if (localObject != null) {
        ((RelativeLayout.LayoutParams)((CheckBox)localObject).getLayoutParams()).addRule(9);
      }
      localObject = (HeadIconWrapper)a(HeadIconWrapper.class);
      if (localObject != null) {
        ((IHeadIconProcessor)((HeadIconWrapper)localObject).a()).a(bool, i1);
      }
      c();
      localObject = (NickNameLayoutViewWrapper)a(NickNameLayoutViewWrapper.class);
      paramInt = i1;
      if (localObject != null)
      {
        localObject = ((NickNameLayoutViewWrapper)localObject).c();
        paramInt = i1;
        if (localObject != null)
        {
          paramInt = i1;
          if (((BaseChatItemLayoutViewBasicAbility)localObject).getViewVisibility() == 0)
          {
            ((RelativeLayout.LayoutParams)((BaseChatItemLayoutViewBasicAbility)localObject).getLayoutParams()).addRule(3, i1);
            paramInt = ((BaseChatItemLayoutViewBasicAbility)localObject).getId();
          }
        }
      }
      localObject = (BubbleViewWrapper)a(BubbleViewWrapper.class);
      if (localObject != null) {
        ((IBubbleViewProcessor)((BubbleViewWrapper)localObject).a()).a(bool, paramInt);
      }
      a(this.ag, bool);
      a(this.ah, bool);
    }
  }
  
  public void setMiniAioShieldItemTouchListener(BaseChatItemLayout.MiniAioShieldItemTouchListener paramMiniAioShieldItemTouchListener)
  {
    this.ap = paramMiniAioShieldItemTouchListener;
  }
  
  public void setNetIconVisible(boolean paramBoolean) {}
  
  public void setNick(boolean paramBoolean, NickNameChatItemLayoutProcessor.NickNameLayoutData paramNickNameLayoutData)
  {
    NickNameLayoutViewWrapper localNickNameLayoutViewWrapper = (NickNameLayoutViewWrapper)a(NickNameLayoutViewWrapper.class);
    if (localNickNameLayoutViewWrapper != null) {
      ((INickNameLayoutProcessor)localNickNameLayoutViewWrapper.a()).a(paramBoolean, paramNickNameLayoutData);
    }
  }
  
  public void setNick(boolean paramBoolean1, CharSequence paramCharSequence1, ColorStateList paramColorStateList1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, CharSequence paramCharSequence2, ColorStateList paramColorStateList2, String paramString)
  {
    setNick(paramBoolean1, new NickNameChatItemLayoutProcessor.NickNameLayoutData(paramCharSequence1, paramColorStateList1, paramBoolean2, paramBoolean3, paramBoolean4, paramBoolean5, paramCharSequence2, paramColorStateList2, paramString, -100, -100, -100, -100, -100, -100, -100));
  }
  
  public void setPendantImage(Drawable paramDrawable)
  {
    Object localObject = this.ae;
    CheckBox localCheckBox;
    if (localObject == null)
    {
      this.ae = new MosaicURLImageView(getContext());
      this.ae.setId(2131430599);
      this.ae.setScaleType(ImageView.ScaleType.FIT_XY);
      localObject = new RelativeLayout.LayoutParams(S, T);
      ((RelativeLayout.LayoutParams)localObject).addRule(3, 2131430586);
      ((RelativeLayout.LayoutParams)localObject).topMargin = U;
      if (this.aj == 1)
      {
        ((RelativeLayout.LayoutParams)localObject).addRule(11);
        ((RelativeLayout.LayoutParams)localObject).addRule(9, 0);
        ((RelativeLayout.LayoutParams)localObject).rightMargin = 0;
        ((RelativeLayout.LayoutParams)localObject).leftMargin = 0;
      }
      else
      {
        ((RelativeLayout.LayoutParams)localObject).addRule(9);
        ((RelativeLayout.LayoutParams)localObject).addRule(11, 0);
        localCheckBox = this.ac;
        if ((localCheckBox != null) && (localCheckBox.getVisibility() != 8)) {
          ((RelativeLayout.LayoutParams)localObject).leftMargin = AIOUtils.b(25.0F, getContext().getResources());
        } else {
          ((RelativeLayout.LayoutParams)localObject).leftMargin = 0;
        }
      }
      ((RelativeLayout.LayoutParams)localObject).addRule(3, this.ak);
      addView(this.ae, (ViewGroup.LayoutParams)localObject);
      localObject = this.af;
      if ((localObject != null) && (((OnlineStatusCircleView)localObject).getVisibility() == 0)) {
        this.af.bringToFront();
      }
    }
    else
    {
      localObject = (RelativeLayout.LayoutParams)((URLImageView)localObject).getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).addRule(3, 2131430586);
      if (this.aj == 1)
      {
        ((RelativeLayout.LayoutParams)localObject).addRule(11);
        ((RelativeLayout.LayoutParams)localObject).addRule(9, 0);
        ((RelativeLayout.LayoutParams)localObject).rightMargin = 0;
        ((RelativeLayout.LayoutParams)localObject).leftMargin = 0;
      }
      else
      {
        ((RelativeLayout.LayoutParams)localObject).addRule(9);
        ((RelativeLayout.LayoutParams)localObject).addRule(11, 0);
        localCheckBox = this.ac;
        if ((localCheckBox != null) && (localCheckBox.getVisibility() != 8)) {
          ((RelativeLayout.LayoutParams)localObject).leftMargin = AIOUtils.b(25.0F, getContext().getResources());
        } else {
          ((RelativeLayout.LayoutParams)localObject).leftMargin = 0;
        }
      }
      ((RelativeLayout.LayoutParams)localObject).addRule(3, this.ak);
    }
    this.ae.setVisibility(0);
    this.ae.setImageDrawable(paramDrawable);
    paramDrawable = AIOLongShotHelper.f();
    if ((paramDrawable != null) && (paramDrawable.h())) {
      this.ae.setVisibility(8);
    }
    if (ThemeUtil.isNowThemeIsNight(null, false, null)) {
      this.ae.setColorFilter(1996488704);
    }
  }
  
  public void setPendantImageVisible(boolean paramBoolean)
  {
    URLImageView localURLImageView = this.ae;
    if (localURLImageView != null)
    {
      int i1;
      if (paramBoolean) {
        i1 = 0;
      } else {
        i1 = 8;
      }
      localURLImageView.setVisibility(i1);
    }
  }
  
  public void setProgressVisable(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.ag == null)
      {
        this.ag = new ProgressBar(getContext(), null, 0);
        this.ag.setId(2131430606);
        this.ag.setIndeterminate(true);
        this.ag.setIndeterminateDrawable(getResources().getDrawable(2130839585));
        int i1 = AIOUtils.b(16.0F, getContext().getResources());
        localObject = new RelativeLayout.LayoutParams(i1, i1);
        ((RelativeLayout.LayoutParams)localObject).bottomMargin = AIOUtils.b(18.0F, getContext().getResources());
        ((RelativeLayout.LayoutParams)localObject).addRule(8, 2131430578);
        if (this.aj == 1)
        {
          ((RelativeLayout.LayoutParams)localObject).rightMargin = AIOUtils.b(4.0F, getContext().getResources());
          ((RelativeLayout.LayoutParams)localObject).addRule(0, 2131430578);
          ((RelativeLayout.LayoutParams)localObject).addRule(1, 0);
        }
        else
        {
          ((RelativeLayout.LayoutParams)localObject).leftMargin = AIOUtils.b(4.0F, getContext().getResources());
          ((RelativeLayout.LayoutParams)localObject).addRule(1, 2131430578);
          ((RelativeLayout.LayoutParams)localObject).addRule(0, 0);
        }
        addView(this.ag, (ViewGroup.LayoutParams)localObject);
      }
      this.ag.setVisibility(0);
      return;
    }
    Object localObject = this.ag;
    if (localObject != null) {
      ((ProgressBar)localObject).setVisibility(8);
    }
  }
  
  public void setRobotNextTipsView(boolean paramBoolean, Context paramContext, QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    if (paramBoolean)
    {
      if (this.al == null)
      {
        this.al = new TroopRobotNextTipsView(getContext(), paramContext, paramQQAppInterface);
        paramContext = new RelativeLayout.LayoutParams(e, -2);
        int i1 = getTextPaddingAlignHead();
        int i2 = getTextPaddingAlignError();
        if (paramChatMessage.isSend())
        {
          i1 = getTextPaddingAlignError();
          i2 = getTextPaddingAlignHead();
        }
        paramContext.addRule(3, 2131430578);
        paramContext.addRule(5, 2131430578);
        this.al.setPadding(i1, 0, i2, 0);
        addView(this.al, paramContext);
      }
      this.al.a(paramChatMessage);
      this.al.setVisibility(0);
      return;
    }
    paramContext = this.al;
    if (paramContext != null) {
      paramContext.setVisibility(8);
    }
  }
  
  public void setStickerPressStatus(boolean paramBoolean)
  {
    this.bf = paramBoolean;
    if (this.bf != this.bg) {
      invalidate();
    }
    this.bg = this.bf;
  }
  
  public void setTailMessage(boolean paramBoolean, CharSequence paramCharSequence, View.OnClickListener paramOnClickListener)
  {
    setTailMessage(paramBoolean, paramCharSequence, paramOnClickListener, true);
  }
  
  public void setTailMessage(boolean paramBoolean1, CharSequence paramCharSequence, View.OnClickListener paramOnClickListener, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      if (this.be == null)
      {
        this.be = new TextView(getContext());
        this.be.setId(2131430608);
        if (paramBoolean2) {
          this.be.setBackgroundResource(2130851832);
        } else {
          this.be.setBackgroundResource(2130842560);
        }
        this.be.setTextSize(2, 13.0F);
        this.be.setTextColor(-1);
        this.be.setGravity(17);
        this.be.setPadding(24, 0, 24, 0);
        Object localObject = new RelativeLayout.LayoutParams(-2, -2);
        ((RelativeLayout.LayoutParams)localObject).addRule(3, 2131430578);
        ((RelativeLayout.LayoutParams)localObject).addRule(5, 2131430578);
        ((RelativeLayout.LayoutParams)localObject).addRule(7, 0);
        ((RelativeLayout.LayoutParams)localObject).bottomMargin = l;
        addView(this.be, (ViewGroup.LayoutParams)localObject);
        localObject = new View(getContext());
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(0, 0);
        localLayoutParams.addRule(3, 2131430608);
        localLayoutParams.addRule(5, 2131430578);
        addView((View)localObject, localLayoutParams);
      }
      this.be.setVisibility(0);
      if (paramCharSequence != this.be.getTag()) {
        this.be.setText(paramCharSequence);
      }
      paramCharSequence = (RelativeLayout.LayoutParams)this.be.getLayoutParams();
      if (this.aj == 1) {
        paramCharSequence.leftMargin = getBubblePaddingAlignError();
      } else {
        paramCharSequence.leftMargin = getBubblePaddingAlignHead();
      }
      this.be.setOnClickListener(paramOnClickListener);
      return;
    }
    paramCharSequence = this.be;
    if (paramCharSequence != null) {
      paramCharSequence.setVisibility(8);
    }
  }
  
  public void setTimeStamp(boolean paramBoolean, ChatMessage paramChatMessage, ColorStateList paramColorStateList, CharSequence paramCharSequence)
  {
    if (paramChatMessage == null) {
      return;
    }
    long l1 = paramChatMessage.time;
    int i1 = 2131430586;
    if ((paramBoolean) && (l1 > 0L))
    {
      if (this.aa == null)
      {
        this.aa = new TextView(getContext());
        this.aa.setId(2131430611);
        int i2 = AIOUtils.b(14.0F, getContext().getResources());
        this.aa.setTextSize(2, 12.0F);
        this.aa.setPadding(i2, 0, i2, 0);
        this.aa.setGravity(17);
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        localLayoutParams.topMargin = N;
        localLayoutParams.bottomMargin = O;
        localLayoutParams.addRule(14);
        addView(this.aa, localLayoutParams);
        this.aa.setTag(Long.valueOf(0L));
      }
      if (paramColorStateList != null) {
        this.aa.setTextColor(paramColorStateList);
      }
      this.aa.setVisibility(0);
      if (((Long)this.aa.getTag()).longValue() != l1) {
        if (paramCharSequence != null)
        {
          this.aa.setText(paramCharSequence);
        }
        else
        {
          paramColorStateList = TimeFormatterUtils.a(getContext(), 3, l1 * 1000L);
          this.aa.setText(paramColorStateList);
        }
      }
      paramColorStateList = this.ab;
      if ((paramColorStateList == null) || (paramColorStateList.getVisibility() != 0)) {
        i1 = 2131430611;
      }
      setTopId(i1);
      paramColorStateList = (RelativeLayout.LayoutParams)this.aa.getLayoutParams();
      i1 = N;
      if (paramChatMessage.isFirstMsg) {
        i1 = N + P;
      }
      paramColorStateList.topMargin = i1;
      TimestampReporter.a(null, paramChatMessage);
      return;
    }
    paramChatMessage = this.aa;
    if (paramChatMessage != null)
    {
      paramChatMessage.setVisibility(8);
      paramChatMessage = this.ab;
      if ((paramChatMessage == null) || (paramChatMessage.getVisibility() != 0)) {
        i1 = 0;
      }
      setTopId(i1);
    }
  }
  
  public void setUnread(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      localObject = this.ai;
      if (localObject != null)
      {
        ((ImageView)localObject).setVisibility(0);
        return;
      }
      this.ai = new ImageView(getContext());
      localObject = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject).topMargin = AIOUtils.b(8.0F, getContext().getResources());
      ((RelativeLayout.LayoutParams)localObject).leftMargin = AIOUtils.b(-3.0F, getContext().getResources());
      ((RelativeLayout.LayoutParams)localObject).addRule(6, 2131430578);
      ((RelativeLayout.LayoutParams)localObject).addRule(1, 2131430578);
      addView(this.ai, (ViewGroup.LayoutParams)localObject);
      this.ai.setImageResource(2130852589);
      return;
    }
    Object localObject = this.ai;
    if (localObject != null)
    {
      ((ImageView)localObject).setOnClickListener(null);
      this.ai.setVisibility(8);
      this.ai = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.BaseChatItemLayout
 * JD-Core Version:    0.7.0.1
 */