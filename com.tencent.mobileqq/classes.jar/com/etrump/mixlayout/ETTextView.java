package com.etrump.mixlayout;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.text.Spannable;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewTreeObserver;
import android.widget.TextView;
import com.Vas.ColorFont.FastColorFontHelper;
import com.Vas.ColorFont.FounderColorLayout;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.TextItemBuilder.Holder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.bubble.BubbleInfo;
import com.tencent.mobileqq.bubble.VipBubbleDrawable;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.vas.VasMonitorHandler;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.AnimationTextView;
import com.tencent.mobileqq.widget.AnimationTextView.OnDoubleClick;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import com.tencent.widget.XListView;
import java.util.concurrent.atomic.AtomicBoolean;
import pu;
import pv;
import pw;
import px;

public class ETTextView
  extends AnimationTextView
{
  public static boolean i;
  private static boolean l;
  public int a;
  public long a;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler();
  private MotionEvent jdField_a_of_type_AndroidViewMotionEvent;
  public FounderColorLayout a;
  public ETFont a;
  public ETLayout a;
  public SessionInfo a;
  public ChatMessage a;
  Runnable jdField_a_of_type_JavaLangRunnable = new pu(this);
  public boolean a;
  public int b;
  private MotionEvent b;
  public boolean b;
  private float jdField_c_of_type_Float;
  public int c;
  private Runnable jdField_c_of_type_JavaLangRunnable = new pv(this);
  public boolean c;
  private float d;
  public int d;
  public boolean d;
  private float e;
  public int e;
  public boolean e;
  private int f;
  public boolean f;
  private int jdField_g_of_type_Int;
  boolean jdField_g_of_type_Boolean = false;
  private int h;
  public boolean h;
  private int i;
  private boolean m;
  private boolean n;
  private boolean o;
  private boolean p;
  
  static
  {
    jdField_i_of_type_Boolean = true;
  }
  
  public ETTextView(Context paramContext)
  {
    super(paramContext);
    this.jdField_b_of_type_Int = -1;
    this.jdField_c_of_type_Int = -1;
    this.jdField_d_of_type_Int = -1;
    this.jdField_e_of_type_Int = -1;
  }
  
  public ETTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_b_of_type_Int = -1;
    this.jdField_c_of_type_Int = -1;
    this.jdField_d_of_type_Int = -1;
    this.jdField_e_of_type_Int = -1;
  }
  
  public ETTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_b_of_type_Int = -1;
    this.jdField_c_of_type_Int = -1;
    this.jdField_d_of_type_Int = -1;
    this.jdField_e_of_type_Int = -1;
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    BubbleInfo localBubbleInfo;
    Object localObject;
    Resources localResources;
    boolean bool;
    if (this.jdField_a_of_type_ComEtrumpMixlayoutETLayout.a(paramInt1, paramInt2) != null)
    {
      localBubbleInfo = (BubbleInfo)getTag(2131362293);
      localObject = (ChatMessage)getTag(2131362294);
      localResources = getResources();
      bool = false;
      if (localObject != null) {
        bool = ((ChatMessage)localObject).isSend();
      }
      localObject = getBackground();
      if ((localObject == null) || (!(localObject instanceof VipBubbleDrawable))) {
        break label82;
      }
      ((VipBubbleDrawable)localObject).jdField_a_of_type_Boolean = true;
    }
    label82:
    while ((localObject == null) || (localBubbleInfo == null)) {
      return;
    }
    if (bool) {}
    for (paramInt1 = 2130845657;; paramInt1 = 2130845493)
    {
      localBubbleInfo.a(this, localResources.getDrawable(paramInt1));
      return;
    }
  }
  
  private boolean g()
  {
    if (this.jdField_a_of_type_ComEtrumpMixlayoutETLayout == null) {}
    ETDecoration localETDecoration;
    do
    {
      return false;
      localETDecoration = this.jdField_a_of_type_ComEtrumpMixlayoutETLayout.a();
    } while ((localETDecoration == null) || (localETDecoration.a() <= 0));
    return true;
  }
  
  public ETLayout a()
  {
    return this.jdField_a_of_type_ComEtrumpMixlayoutETLayout;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComVasColorFontFounderColorLayout != null) {
      this.jdField_a_of_type_ComVasColorFontFounderColorLayout.a();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if ((!g()) || (!f()) || (!this.jdField_d_of_type_Boolean)) {}
    do
    {
      return;
      this.jdField_e_of_type_Boolean = false;
      this.o = jdField_i_of_type_Boolean;
    } while ((!this.o) || (this.p) || ((!paramBoolean) && ((this.jdField_a_of_type_ComTencentMobileqqDataChatMessage == null) || (!android.text.TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.getExtInfoFromExtStr("font_animation_played")))) && (this.jdField_a_of_type_ComEtrumpMixlayoutETLayout.a().jdField_a_of_type_Int == -1)));
    if ((!paramBoolean) && (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.saveExtInfoToExtStr("font_animation_played", "1");
      ThreadManager.executeOnSubThread(new pw(this));
    }
    String str2;
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface))
    {
      str2 = ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).c();
      if (!paramBoolean) {
        break label211;
      }
    }
    label211:
    for (String str1 = "1";; str1 = "0")
    {
      VasWebviewUtil.reportCommercialDrainage(str2, "Font_Mall", "0X800813C", "0", 0, 1, 1, null, str1, "" + this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId);
      this.p = true;
      this.jdField_a_of_type_AndroidOsHandler.post(this.jdField_c_of_type_JavaLangRunnable);
      return;
    }
  }
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_ComEtrumpMixlayoutETFont != null) && (this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId != 0) && (this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontType == 1)) {
      return !ETEngine.getInstance().native_containComplexScript(getText().toString());
    }
    return false;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComVasColorFontFounderColorLayout != null) {
      this.jdField_a_of_type_ComVasColorFontFounderColorLayout.b();
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComEtrumpMixlayoutETFont == null) || (!f())) {}
    int j;
    int k;
    label264:
    label271:
    do
    {
      Object localObject;
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return;
                if (!(BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
                  break;
                }
                localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
                if (localObject == null) {
                  break;
                }
                localObject = (FontManager)((QQAppInterface)localObject).getManager(41);
              } while ((localObject != null) && (!((FontManager)localObject).b()));
              if (!jdField_i_of_type_Boolean) {
                break;
              }
            } while ((!paramBoolean) && ((this.jdField_a_of_type_ComTencentMobileqqDataChatMessage == null) || (!android.text.TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.getExtInfoFromExtStr("font_animation_played")))) && (!this.jdField_h_of_type_Boolean));
            if ((!paramBoolean) && (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null))
            {
              this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.saveExtInfoToExtStr("font_animation_played", "1");
              ThreadManager.executeOnSubThread(new px(this));
            }
            String str;
            if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface))
            {
              str = ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).c();
              if (!paramBoolean) {
                break label264;
              }
            }
            for (localObject = "1";; localObject = "0")
            {
              VasWebviewUtil.reportCommercialDrainage(str, "Font_Mall", "0X800813C", "0", 0, 1, 1, null, (String)localObject, "" + this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId);
              if (this.jdField_a_of_type_ComVasColorFontFounderColorLayout == null) {
                break;
              }
              j = this.jdField_a_of_type_ComVasColorFontFounderColorLayout.jdField_a_of_type_Int;
              localObject = this.jdField_a_of_type_ComVasColorFontFounderColorLayout.jdField_a_of_type_ArrayOfInt;
              if (localObject == null) {
                break;
              }
              k = localObject[0];
              if (j != 0) {
                break label271;
              }
              a();
              this.jdField_h_of_type_Boolean = true;
              return;
            }
          } while ((j <= 0) || (j >= k));
          c();
          this.jdField_h_of_type_Boolean = true;
          return;
        } while (this.jdField_a_of_type_ComVasColorFontFounderColorLayout == null);
        j = this.jdField_a_of_type_ComVasColorFontFounderColorLayout.jdField_a_of_type_Int;
        localObject = this.jdField_a_of_type_ComVasColorFontFounderColorLayout.jdField_a_of_type_ArrayOfInt;
      } while (localObject == null);
      k = localObject[0];
    } while ((j <= 0) || (j >= k));
    b();
  }
  
  public boolean b()
  {
    return (this.jdField_a_of_type_ComEtrumpMixlayoutETFont != null) && (this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId != 0) && (this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontType == 4) && (FastColorFontHelper.a().a(this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontPath) == 3);
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComVasColorFontFounderColorLayout != null) {
      this.jdField_a_of_type_ComVasColorFontFounderColorLayout.c();
    }
  }
  
  public boolean c()
  {
    return (a()) && (this.jdField_a_of_type_ComEtrumpMixlayoutETLayout.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
  }
  
  public void d()
  {
    this.o = false;
    this.p = false;
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
  }
  
  public boolean d()
  {
    return b();
  }
  
  public void e()
  {
    this.o = false;
    if (g()) {
      this.jdField_a_of_type_ComEtrumpMixlayoutETLayout.a().a();
    }
  }
  
  public boolean e()
  {
    if (!this.m)
    {
      this.n = com.tencent.mobileqq.text.TextUtils.b(getText().toString());
      this.m = true;
    }
    return (this.jdField_a_of_type_ComEtrumpMixlayoutETFont != null) && (this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId != 0) && (this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontType == 4) && (!this.n);
  }
  
  public boolean f()
  {
    if ((getContext() instanceof FragmentActivity))
    {
      Object localObject = ((FragmentActivity)getContext()).getChatFragment();
      if ((localObject != null) && (((ChatFragment)localObject).a() != null) && (((ChatFragment)localObject).a().a != null))
      {
        localObject = ((ChatFragment)localObject).a().a;
        localObject = AIOUtils.a((ListView)localObject, AIOUtils.a(this.jdField_a_of_type_Long, ((XListView)localObject).getAdapter()));
        if ((localObject != null) && ((((View)localObject).getTag() instanceof TextItemBuilder.Holder)) && (((TextItemBuilder.Holder)((View)localObject).getTag()).e.getTop() + ((View)localObject).getBottom() >= getContext().getResources().getDimensionPixelSize(2131558448))) {
          return true;
        }
      }
    }
    return false;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if ((!c()) && (!e())) {
      super.onDraw(paramCanvas);
    }
    do
    {
      do
      {
        return;
        if (c())
        {
          if ((this.jdField_a_of_type_ComEtrumpMixlayoutETLayout == null) || (this.jdField_a_of_type_ComEtrumpMixlayoutETLayout.jdField_a_of_type_ComEtrumpMixlayoutETFont == null))
          {
            super.onDraw(paramCanvas);
            return;
          }
          if (((this.o) && (this.p)) || (this.jdField_a_of_type_ComEtrumpMixlayoutETLayout.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontColor != getCurrentTextColor())) {}
          try
          {
            this.jdField_a_of_type_ComEtrumpMixlayoutETLayout.b(getCurrentTextColor());
            this.jdField_a_of_type_ComEtrumpMixlayoutETLayout.jdField_b_of_type_ComEtrumpMixlayoutETFont.mFontColor = getLinkTextColors().getDefaultColor();
            this.jdField_a_of_type_ComEtrumpMixlayoutETLayout.a();
            if (this.jdField_e_of_type_Boolean) {
              a(false);
            }
            this.jdField_a_of_type_ComEtrumpMixlayoutETLayout.a(paramCanvas, getPaddingLeft(), getPaddingTop());
            return;
          }
          catch (Throwable localThrowable)
          {
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.e("ETTextView", 2, "onDraw err" + localThrowable.getMessage());
              }
            }
          }
        }
      } while (!e());
      if (!this.jdField_a_of_type_ComVasColorFontFounderColorLayout.a(paramCanvas, this.jdField_a_of_type_Long)) {
        super.onDraw(paramCanvas);
      }
    } while ((!this.jdField_f_of_type_Boolean) || (!b()));
    b(false);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    try
    {
      if (e())
      {
        if (this.jdField_a_of_type_ComVasColorFontFounderColorLayout == null) {
          this.jdField_a_of_type_ComVasColorFontFounderColorLayout = new FounderColorLayout(this, this.jdField_a_of_type_ComEtrumpMixlayoutETFont);
        }
        int[] arrayOfInt = this.jdField_a_of_type_ComVasColorFontFounderColorLayout.a(paramInt1, paramInt2, this.jdField_a_of_type_Long, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_ComEtrumpMixlayoutETFont);
        if ((arrayOfInt != null) && (arrayOfInt[0] > 0) && (arrayOfInt[1] > 0)) {
          setMeasuredDimension(arrayOfInt[0], arrayOfInt[1]);
        }
        for (;;)
        {
          this.jdField_f_of_type_Boolean = true;
          return;
          super.onMeasure(paramInt1, paramInt2);
        }
      }
      if (a()) {
        break label202;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("ETTextView", 1, "measure fail ", localThrowable);
      localThrowable.printStackTrace();
      this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId = 0;
      this.jdField_a_of_type_ComEtrumpMixlayoutETLayout.jdField_a_of_type_Long = -1L;
      if ((!l) && (localThrowable.getMessage().contains("textlayout")))
      {
        VasMonitorHandler.a(null, "individual_v2_font_measure_error", "font_measure_error", localThrowable.getMessage(), localThrowable.getMessage(), 0.0F);
        l = true;
      }
      super.onMeasure(paramInt1, paramInt2);
      return;
    }
    super.onMeasure(paramInt1, paramInt2);
    return;
    label202:
    int i4 = View.MeasureSpec.getMode(paramInt1);
    int i3 = View.MeasureSpec.getMode(paramInt2);
    int k = View.MeasureSpec.getSize(paramInt1);
    int i1 = View.MeasureSpec.getSize(paramInt2);
    if (this.jdField_a_of_type_ComEtrumpMixlayoutETLayout == null) {
      this.jdField_a_of_type_ComEtrumpMixlayoutETLayout = new ETLayout();
    }
    if (this.jdField_a_of_type_ComEtrumpMixlayoutETFont != null)
    {
      this.jdField_a_of_type_ComEtrumpMixlayoutETFont.setColor(getCurrentTextColor());
      this.jdField_a_of_type_ComEtrumpMixlayoutETFont.setSize(getTextSize());
      if (this.jdField_c_of_type_Float <= 0.0F) {
        break label529;
      }
      this.jdField_a_of_type_ComEtrumpMixlayoutETFont.setCrochet(true, this.jdField_i_of_type_Int, (int)this.jdField_c_of_type_Float);
    }
    int j;
    while ((this.jdField_a_of_type_ComEtrumpMixlayoutETLayout.jdField_a_of_type_Long != this.jdField_a_of_type_Long) || ((this.jdField_a_of_type_ComEtrumpMixlayoutETFont != null) && (!this.jdField_a_of_type_ComEtrumpMixlayoutETFont.equals(this.jdField_a_of_type_ComEtrumpMixlayoutETLayout.jdField_a_of_type_ComEtrumpMixlayoutETFont))) || (this.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_ComEtrumpMixlayoutETLayout.jdField_b_of_type_Boolean != this.jdField_a_of_type_Boolean))
    {
      e();
      d();
      this.jdField_g_of_type_Boolean = false;
      int i2 = this.jdField_a_of_type_Int - (getPaddingLeft() + getPaddingRight());
      j = i2;
      if (i4 == -2147483648) {
        j = Math.min(k, i2);
      }
      i2 = getLinkTextColors().getDefaultColor();
      this.jdField_a_of_type_ComEtrumpMixlayoutETLayout.jdField_a_of_type_Long = this.jdField_a_of_type_Long;
      this.jdField_a_of_type_ComEtrumpMixlayoutETLayout.jdField_b_of_type_Boolean = this.jdField_a_of_type_Boolean;
      this.jdField_a_of_type_ComEtrumpMixlayoutETLayout.a(this.jdField_h_of_type_Int);
      ETFont localETFont = new ETFont(this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId, this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontPath, getTextSize());
      localETFont.copy(this.jdField_a_of_type_ComEtrumpMixlayoutETFont);
      if (!this.jdField_a_of_type_ComEtrumpMixlayoutETLayout.a(j, getText(), localETFont, i2))
      {
        this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId = 0;
        this.jdField_a_of_type_ComEtrumpMixlayoutETLayout.jdField_a_of_type_Long = -1L;
        super.onMeasure(paramInt1, paramInt2);
        return;
        label529:
        this.jdField_a_of_type_ComEtrumpMixlayoutETFont.setCrochet(false, this.jdField_i_of_type_Int, 0);
      }
      else
      {
        if ((this.jdField_a_of_type_ComEtrumpMixlayoutETLayout.jdField_a_of_type_Int >= 2048) || (this.jdField_a_of_type_ComEtrumpMixlayoutETLayout.jdField_b_of_type_Int >= 2048)) {
          throw new Exception("large bitmap width=" + 0 + ", height=" + 0);
        }
        if (this.jdField_a_of_type_ComEtrumpMixlayoutETLayout.jdField_a_of_type_Boolean) {
          throw new Exception("no text use system measure2");
        }
        this.jdField_a_of_type_ComEtrumpMixlayoutETLayout.a(this.jdField_a_of_type_ComEtrumpMixlayoutETLayout.jdField_a_of_type_Int, this.jdField_a_of_type_ComEtrumpMixlayoutETLayout.jdField_b_of_type_Int);
        this.jdField_a_of_type_ComEtrumpMixlayoutETLayout.a();
        this.jdField_e_of_type_Boolean = true;
      }
    }
    for (;;)
    {
      setMeasuredDimension(Math.max(k, this.jdField_f_of_type_Int), Math.max(j, this.jdField_g_of_type_Int));
      return;
      label689:
      k = this.jdField_a_of_type_ComEtrumpMixlayoutETLayout.jdField_a_of_type_Int + getPaddingLeft() + getPaddingRight();
      label765:
      while (i3 != 1073741824)
      {
        if (this.jdField_a_of_type_ComEtrumpMixlayoutETLayout != null)
        {
          j = this.jdField_a_of_type_ComEtrumpMixlayoutETLayout.jdField_b_of_type_Int + getPaddingTop() + getPaddingBottom();
          if (i3 != -2147483648) {
            break label765;
          }
          j = Math.min(j, i1);
          break;
        }
        throw new Exception("measure height fail Layout is null");
        break;
        if (i4 != 1073741824) {
          break label689;
        }
      }
      j = i1;
    }
  }
  
  public boolean onPreDraw()
  {
    if ((!c()) && (!e()))
    {
      getViewTreeObserver().removeOnPreDrawListener(this);
      return super.onPreDraw();
    }
    getViewTreeObserver().removeOnPreDrawListener(this);
    return true;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((!c()) && (!e())) {
      return super.onTouchEvent(paramMotionEvent);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView$OnDoubleClick != null)
    {
      int i3;
      int i4;
      if ((this.jdField_b_of_type_AndroidViewMotionEvent != null) && (paramMotionEvent.getAction() == 0))
      {
        this.jdField_a_of_type_Float = paramMotionEvent.getX();
        this.jdField_b_of_type_Float = paramMotionEvent.getY();
        j = (int)paramMotionEvent.getX();
        k = (int)paramMotionEvent.getY();
        i1 = getPaddingLeft();
        i2 = getPaddingTop();
        i3 = getScrollX();
        i4 = getScrollY();
        this.jdField_b_of_type_Int = -1;
        this.jdField_c_of_type_Int = -1;
        if (c()) {
          a(j - i1 + i3, k - i2 + i4);
        }
        this.jdField_a_of_type_AndroidViewMotionEvent = MotionEvent.obtain(paramMotionEvent);
        if ((this.jdField_b_of_type_AndroidViewMotionEvent != null) && (this.jdField_a_of_type_AndroidViewMotionEvent != null) && (a(this.jdField_a_of_type_AndroidViewMotionEvent, this.jdField_b_of_type_AndroidViewMotionEvent, paramMotionEvent)))
        {
          this.j = false;
          this.jdField_a_of_type_AndroidViewMotionEvent = null;
          this.jdField_b_of_type_AndroidViewMotionEvent = null;
          if (this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView$OnDoubleClick != null)
          {
            this.k = true;
            this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView$OnDoubleClick.a(this);
            return true;
          }
        }
      }
      else
      {
        if ((this.jdField_b_of_type_AndroidViewMotionEvent != null) || (paramMotionEvent.getAction() != 0)) {
          break label332;
        }
        this.j = true;
        this.jdField_a_of_type_Float = paramMotionEvent.getX();
        this.jdField_b_of_type_Float = paramMotionEvent.getY();
        j = (int)paramMotionEvent.getX();
        k = (int)paramMotionEvent.getY();
        i1 = getPaddingLeft();
        i2 = getPaddingTop();
        i3 = getScrollX();
        i4 = getScrollY();
        this.jdField_b_of_type_Int = -1;
        this.jdField_c_of_type_Int = -1;
        if (c()) {
          a(j - i1 + i3, k - i2 + i4);
        }
        if (QLog.isColorLevel()) {
          QLog.d("ETTextView", 2, "reserve to initial status");
        }
      }
    }
    label332:
    while (paramMotionEvent.getAction() != 1) {
      return super.onTouchEvent(paramMotionEvent);
    }
    if (QLog.isColorLevel()) {
      QLog.d("ETTextView", 2, "action up");
    }
    int i1 = (int)paramMotionEvent.getX();
    int j = (int)paramMotionEvent.getY();
    int i2 = getPaddingLeft();
    int k = getPaddingTop();
    i1 = i1 - i2 + getScrollX();
    j = j - k + getScrollY();
    this.jdField_d_of_type_Int = i1;
    this.jdField_e_of_type_Int = j;
    if (c()) {
      j = this.jdField_a_of_type_ComEtrumpMixlayoutETLayout.a(i1, j) + 1;
    }
    for (;;)
    {
      ClickableSpan[] arrayOfClickableSpan = (ClickableSpan[])((Spannable)getText()).getSpans(j, j, ClickableSpan.class);
      if (arrayOfClickableSpan.length != 0)
      {
        arrayOfClickableSpan[0].onClick(this);
        return true;
        if (e()) {
          j = this.jdField_a_of_type_ComVasColorFontFounderColorLayout.a(i1, j);
        }
      }
      else
      {
        this.jdField_b_of_type_AndroidViewMotionEvent = MotionEvent.obtain(paramMotionEvent);
        if (this.k)
        {
          this.k = false;
          this.jdField_b_of_type_AndroidViewMotionEvent = null;
        }
        postDelayed(this.jdField_a_of_type_JavaLangRunnable, 200L);
        break;
      }
      j = 0;
    }
  }
  
  public void setFont(int paramInt, long paramLong)
  {
    if (this.jdField_a_of_type_ComEtrumpMixlayoutETFont == null) {
      this.jdField_a_of_type_ComEtrumpMixlayoutETFont = new ETFont(paramInt, "", getTextSize());
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId == 0) {
        setTypeface(null);
      }
      if (this.jdField_a_of_type_Long != paramLong) {
        this.m = false;
      }
      this.jdField_a_of_type_Long = paramLong;
      return;
      this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId = paramInt;
    }
  }
  
  public void setFont(ETFont paramETFont, long paramLong)
  {
    if (this.jdField_a_of_type_ComEtrumpMixlayoutETFont == null)
    {
      this.jdField_a_of_type_ComEtrumpMixlayoutETFont = new ETFont(paramETFont.mFontId, paramETFont.mFontPath, getTextSize(), paramETFont.mFontType, paramETFont.mTypeface);
      this.jdField_a_of_type_ComEtrumpMixlayoutETFont.copy(paramETFont);
      this.jdField_a_of_type_ComEtrumpMixlayoutETFont.setSize(getTextSize());
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontType != 1) && (this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mTypeface != null)) {
        setTypeface(this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mTypeface);
      }
      if (this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId == 0) {
        setTypeface(null);
      }
      this.jdField_a_of_type_Long = paramLong;
      if (this.jdField_a_of_type_ComEtrumpMixlayoutETLayout == null) {
        this.jdField_a_of_type_ComEtrumpMixlayoutETLayout = new ETLayout();
      }
      return;
      this.jdField_a_of_type_ComEtrumpMixlayoutETFont.copy(paramETFont);
      this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mAnimationId = paramLong;
      this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mText = paramETFont.mText;
      if (paramETFont.mFontType != 1) {
        this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mTypeface = paramETFont.mTypeface;
      }
      this.jdField_a_of_type_ComEtrumpMixlayoutETFont.m_diyHandle = paramETFont.m_diyHandle;
    }
  }
  
  public void setFont(ETFont paramETFont, ChatMessage paramChatMessage, SessionInfo paramSessionInfo)
  {
    if (this.jdField_a_of_type_Long != paramChatMessage.uniseq) {
      this.m = false;
    }
    Object localObject;
    if ((paramETFont.mText == null) && ((paramChatMessage instanceof MessageForText)))
    {
      localObject = (MessageForText)paramChatMessage;
      if (android.text.TextUtils.isEmpty(((MessageForText)localObject).sb)) {
        break label102;
      }
      if (android.text.TextUtils.isEmpty(((MessageForText)localObject).sb2)) {
        break label92;
      }
      localObject = ((MessageForText)localObject).sb2;
    }
    for (;;)
    {
      paramETFont.mText = ((CharSequence)localObject);
      setFont(paramETFont, paramChatMessage.uniseq);
      this.jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramChatMessage;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
      return;
      label92:
      localObject = ((MessageForText)localObject).sb;
      continue;
      label102:
      localObject = null;
    }
  }
  
  public void setMaxWidth(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    super.setMaxWidth(paramInt);
  }
  
  public void setMinHeight(int paramInt)
  {
    this.jdField_g_of_type_Int = paramInt;
    super.setMinHeight(paramInt);
  }
  
  public void setMinWidth(int paramInt)
  {
    this.jdField_f_of_type_Int = paramInt;
    super.setMinWidth(paramInt);
  }
  
  public void setShadowLayer(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt)
  {
    this.jdField_c_of_type_Float = paramFloat1;
    this.jdField_d_of_type_Float = paramFloat2;
    this.jdField_e_of_type_Float = paramFloat3;
    this.jdField_i_of_type_Int = paramInt;
    super.setShadowLayer(paramFloat1, paramFloat2, paramFloat3, paramInt);
    if (this.jdField_a_of_type_ComEtrumpMixlayoutETFont != null) {
      this.jdField_a_of_type_ComEtrumpMixlayoutETFont.setShadow(true, paramInt, (int)paramFloat2, (int)paramFloat3, (int)paramFloat1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.etrump.mixlayout.ETTextView
 * JD-Core Version:    0.7.0.1
 */