package com.tencent.mobileqq.activity.aio.audiopanel;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.app.BabyQHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableBitmapDrawable;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.XPanelContainer;
import upi;

public class AudioPanel
  extends LinearLayout
  implements Handler.Callback, ViewPager.OnPageChangeListener, View.OnClickListener
{
  private static final int jdField_a_of_type_Int = jdField_a_of_type_ArrayOfInt[1] - jdField_a_of_type_ArrayOfInt[0];
  private static PopupWindow jdField_a_of_type_AndroidWidgetPopupWindow;
  private static final int[] jdField_a_of_type_ArrayOfInt = { 1038, 1948, 2857, 3766, 4675, 5584, 6493, 7402, 8311, 10000 };
  private float jdField_a_of_type_Float;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private Rect jdField_a_of_type_AndroidGraphicsRect;
  View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  private InputLinearLayout jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private AudioPanelAdapter jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelAdapter;
  private AudioPanelViewPager jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelViewPager;
  private PressToSpeakPanel jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPressToSpeakPanel;
  private PanelIconLinearLayout jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private WeakReferenceHandler jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
  private boolean jdField_a_of_type_Boolean;
  private String[] jdField_a_of_type_ArrayOfJavaLangString = new String[3];
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int = 1;
  private Rect jdField_b_of_type_AndroidGraphicsRect;
  private ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int;
  private boolean jdField_e_of_type_Boolean;
  private int jdField_f_of_type_Int = -1;
  private boolean jdField_f_of_type_Boolean;
  private int jdField_g_of_type_Int;
  private boolean jdField_g_of_type_Boolean;
  private boolean h;
  
  public AudioPanel(Context paramContext)
  {
    super(paramContext);
  }
  
  public AudioPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public static int a(int paramInt)
  {
    int i = 8000;
    if (paramInt < 5000) {
      i = 4000;
    }
    for (;;)
    {
      paramInt = Math.min((int)(i * 0.3F / jdField_a_of_type_Int), jdField_a_of_type_ArrayOfInt.length - 1);
      return jdField_a_of_type_ArrayOfInt[paramInt];
      if (paramInt >= 8000) {
        if (paramInt < 10000) {
          i = 10000;
        } else if (paramInt < 14000) {
          i = 13000;
        } else if (paramInt < 18000) {
          i = 16000;
        } else if (paramInt < 23000) {
          i = 19000;
        } else if (paramInt < 27000) {
          i = 22000;
        } else if (paramInt < 32000) {
          i = 25000;
        } else if (paramInt < 35000) {
          i = 28000;
        } else if (paramInt < 40000) {
          i = 32000;
        } else if (paramInt < 50000) {
          i = 40000;
        } else {
          i = 40000;
        }
      }
    }
  }
  
  public static View a(Context paramContext, ViewGroup paramViewGroup1, ViewGroup paramViewGroup2)
  {
    paramViewGroup2 = (ViewGroup)paramViewGroup1.getParent();
    int j = paramViewGroup2.getChildCount();
    int i = 0;
    if (i < j) {
      if (paramViewGroup2.getChildAt(i) != paramViewGroup1) {}
    }
    for (;;)
    {
      if (i >= 0)
      {
        paramContext = new View(paramContext);
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, paramViewGroup1.getHeight());
        localLayoutParams.addRule(6, paramViewGroup1.getId());
        localLayoutParams.addRule(8, paramViewGroup1.getId());
        paramContext.setLayoutParams(localLayoutParams);
        paramViewGroup2.addView(paramContext, i);
        return paramContext;
        i += 1;
        break;
      }
      return null;
      i = -1;
    }
  }
  
  public static PopupWindow a(Context paramContext, int paramInt1, int paramInt2, View paramView, int paramInt3, int paramInt4, int paramInt5)
  {
    if ((jdField_a_of_type_AndroidWidgetPopupWindow != null) && (jdField_a_of_type_AndroidWidgetPopupWindow.isShowing())) {
      return jdField_a_of_type_AndroidWidgetPopupWindow;
    }
    paramContext = new View(paramContext);
    paramContext.setBackgroundColor(1275068416);
    jdField_a_of_type_AndroidWidgetPopupWindow = new PopupWindow(paramContext, paramInt1, paramInt2);
    jdField_a_of_type_AndroidWidgetPopupWindow.showAtLocation(paramView, paramInt3, paramInt4, paramInt5);
    return jdField_a_of_type_AndroidWidgetPopupWindow;
  }
  
  public static String a(double paramDouble)
  {
    if (paramDouble < 1000.0D) {}
    int j;
    for (int i = 0;; i = (int)(paramDouble / 1000.0D + 0.5D))
    {
      j = i / 60;
      i %= 60;
      if (i >= 10) {
        break;
      }
      return j + ":0" + i;
    }
    return j + ":" + i;
  }
  
  private void f()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelViewPager.getCurrentItem() == 1) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPressToSpeakPanel != null))
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPressToSpeakPanel.a();
      Rect localRect = new Rect();
      ((ImageView)localObject).getGlobalVisibleRect(localRect);
      localObject = new Rect();
      super.getGlobalVisibleRect((Rect)localObject);
      int i = localRect.left - ((Rect)localObject).left;
      int j = localRect.top - ((Rect)localObject).top;
      this.jdField_a_of_type_Float = TypedValue.applyDimension(1, 30.0F, getResources().getDisplayMetrics());
      this.jdField_a_of_type_AndroidGraphicsRect = new Rect(i, j, localRect.width() + i, localRect.height() + j);
      this.jdField_g_of_type_Int = 40;
      this.jdField_b_of_type_Float = 0.98F;
      if (QLog.isColorLevel()) {
        QLog.d("HollowRound", 2, "initAndStartHollowRoundAnim:" + this.jdField_g_of_type_Int + ", " + this.jdField_b_of_type_Float);
      }
      this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
      this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
      this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
      h();
    }
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_AndroidGraphicsRect != null)
    {
      this.jdField_g_of_type_Int -= 3;
      this.jdField_b_of_type_Float += 0.04593333F;
      if (QLog.isColorLevel()) {
        QLog.d("HollowRound", 2, "updateHollowRoundAnim:" + this.jdField_g_of_type_Int + ", " + this.jdField_b_of_type_Float);
      }
    }
  }
  
  private void h()
  {
    if (this.jdField_b_of_type_AndroidGraphicsRect == null)
    {
      super.invalidate();
      return;
    }
    super.invalidate(this.jdField_b_of_type_AndroidGraphicsRect);
  }
  
  public int a()
  {
    int i = -1;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelViewPager != null) {
      i = this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelViewPager.getCurrentItem();
    }
    return i;
  }
  
  public void a()
  {
    BaseChatPie.z = false;
    e();
    int i;
    View localView;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelAdapter.jdField_a_of_type_AndroidViewViewGroup != null)
    {
      ViewGroup localViewGroup = this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelAdapter.jdField_a_of_type_AndroidViewViewGroup;
      int j = localViewGroup.getChildCount();
      i = 0;
      if (i >= j) {
        break label87;
      }
      localView = localViewGroup.getChildAt(i);
      if (localView.getVisibility() != 0) {
        break label80;
      }
    }
    for (;;)
    {
      if ((localView != null) && ((localView instanceof AudioPanelCallback))) {
        ((AudioPanelCallback)localView).d();
      }
      b(true);
      return;
      label80:
      i += 1;
      break;
      label87:
      localView = null;
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelViewPager.getCurrentItem() != paramInt)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelViewPager.setCurrentItem(paramInt);
      requestLayout();
      a(this.jdField_b_of_type_AndroidViewViewGroup, this.jdField_b_of_type_AndroidViewViewGroup.getChildAt(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelViewPager.getCurrentItem()), -8355712, -15158044);
    }
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    if (this.jdField_f_of_type_Boolean)
    {
      this.jdField_f_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(0, this.jdField_c_of_type_Boolean, false);
    }
  }
  
  void a(ViewGroup paramViewGroup, View paramView, int paramInt1, int paramInt2)
  {
    if (paramViewGroup != null)
    {
      int j = paramViewGroup.getChildCount();
      int i = 0;
      if (i < j)
      {
        View localView = paramViewGroup.getChildAt(i);
        if ((localView instanceof TextView)) {
          ((TextView)localView).setTextColor(paramInt1);
        }
        for (;;)
        {
          i += 1;
          break;
          if ((i == 0) && (this.jdField_c_of_type_AndroidWidgetTextView != null)) {
            this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(paramInt1);
          }
        }
      }
    }
    if (paramView != null)
    {
      if (!(paramView instanceof TextView)) {
        break label98;
      }
      ((TextView)paramView).setTextColor(paramInt2);
    }
    label98:
    while ((!(paramView instanceof FrameLayout)) || (this.jdField_c_of_type_AndroidWidgetTextView == null)) {
      return;
    }
    this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(paramInt2);
    BabyQHandler.a(this.jdField_a_of_type_AndroidViewView);
  }
  
  public void a(QQAppInterface paramQQAppInterface, BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo, InputLinearLayout paramInputLinearLayout, PanelIconLinearLayout paramPanelIconLinearLayout)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout = paramInputLinearLayout;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout = paramPanelIconLinearLayout;
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelViewPager = ((AudioPanelViewPager)findViewById(2131365676));
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131369437));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369442));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369443));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369441));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131369440);
    this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131369439));
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.G) {
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelAdapter = new AudioPanelAdapter(paramQQAppInterface, paramBaseChatPie, this, this.jdField_a_of_type_AndroidViewViewGroup, this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout, this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelViewPager.a(paramQQAppInterface, this);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelViewPager.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelAdapter);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelViewPager.setOnPageChangeListener(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelViewPager.setCurrentItem(Math.min(1, this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelAdapter.getCount() - 1));
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-15158044);
    this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-8355712);
    this.jdField_c_of_type_Boolean = true;
    this.jdField_d_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
    paramBaseChatPie = getResources().getDrawable(2130845947);
    if ((paramBaseChatPie instanceof BitmapDrawable)) {
      paramBaseChatPie = ((BitmapDrawable)paramBaseChatPie).getBitmap();
    }
    for (;;)
    {
      paramBaseChatPie = new BitmapDrawable(paramBaseChatPie);
      if (paramBaseChatPie != null)
      {
        paramBaseChatPie.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        paramBaseChatPie.setDither(true);
        setBackgroundDrawable(paramBaseChatPie);
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(3);
        if (QLog.isColorLevel()) {
          QLog.d("AIOAudioPanel", 2, "AudioPanel.init() is called,time is:" + System.currentTimeMillis());
        }
        if (Utils.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a))
        {
          paramQQAppInterface = (BabyQHandler)paramQQAppInterface.a(53);
          if (paramQQAppInterface.a(2))
          {
            paramQQAppInterface.b();
            BabyQHandler.a(getContext(), this.jdField_a_of_type_AndroidViewView);
          }
        }
        return;
        if (!(paramBaseChatPie instanceof SkinnableBitmapDrawable)) {
          break label456;
        }
        paramBaseChatPie = ((SkinnableBitmapDrawable)paramBaseChatPie).getBitmap();
        break;
        if (QLog.isColorLevel()) {
          QLog.d("AIOAudioPanel", 2, "AudioPanel background is null:");
        }
      }
      label456:
      paramBaseChatPie = null;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    int i = 0;
    b(false);
    this.h = paramBoolean;
    WeakReferenceHandler localWeakReferenceHandler = this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler;
    if (paramBoolean) {
      i = 600;
    }
    localWeakReferenceHandler.sendEmptyMessageDelayed(1, i + 1200);
  }
  
  public boolean a()
  {
    int i;
    View localView;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelAdapter.jdField_a_of_type_AndroidViewViewGroup != null)
    {
      ViewGroup localViewGroup = this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelAdapter.jdField_a_of_type_AndroidViewViewGroup;
      int j = localViewGroup.getChildCount();
      i = 0;
      if (i >= j) {
        break label91;
      }
      localView = localViewGroup.getChildAt(i);
      if (localView.getVisibility() != 0) {}
    }
    for (;;)
    {
      if ((localView != null) && ((localView instanceof AudioPanelCallback))) {}
      for (boolean bool = ((AudioPanelCallback)localView).a();; bool = false)
      {
        b(true);
        return bool;
        i += 1;
        break;
      }
      label91:
      localView = null;
    }
  }
  
  public int b()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public void b()
  {
    jdField_a_of_type_AndroidWidgetPopupWindow = null;
    int i;
    View localView;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelAdapter.jdField_a_of_type_AndroidViewViewGroup != null)
    {
      ViewGroup localViewGroup = this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelAdapter.jdField_a_of_type_AndroidViewViewGroup;
      int j = localViewGroup.getChildCount();
      i = 0;
      if (i >= j) {
        break label82;
      }
      localView = localViewGroup.getChildAt(i);
      if (localView.getVisibility() != 0) {
        break label75;
      }
    }
    for (;;)
    {
      if ((localView != null) && ((localView instanceof AudioPanelCallback))) {
        ((AudioPanelCallback)localView).e();
      }
      e();
      return;
      label75:
      i += 1;
      break;
      label82:
      localView = null;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidGraphicsRect != null)
    {
      this.jdField_a_of_type_AndroidGraphicsRect = null;
      this.jdField_b_of_type_AndroidGraphicsRect = null;
    }
    this.h = false;
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(2);
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(1);
    if (paramBoolean) {
      h();
    }
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelAdapter.jdField_b_of_type_AndroidViewViewGroup != null) && ((this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelAdapter.jdField_b_of_type_AndroidViewViewGroup instanceof ListenChangeVoicePanel)))
    {
      ((AudioPanelCallback)this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelAdapter.jdField_b_of_type_AndroidViewViewGroup).e();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelAdapter.jdField_b_of_type_AndroidViewViewGroup = null;
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_AndroidGraphicsRect != null) {
      b(true);
    }
  }
  
  public void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    Rect localRect = this.jdField_a_of_type_AndroidGraphicsRect;
    if (localRect != null)
    {
      if (this.jdField_g_of_type_Int > 0) {
        break label42;
      }
      if (!this.h) {
        a(true);
      }
    }
    else
    {
      return;
    }
    b(false);
    return;
    label42:
    float f1 = localRect.width() / 2;
    float f2 = this.jdField_b_of_type_Float * f1;
    if (f2 > this.jdField_a_of_type_Float + f1) {
      f1 = this.jdField_a_of_type_Float;
    }
    for (;;)
    {
      if (f1 > 0.0F)
      {
        float f3 = f1 / 2.0F;
        this.jdField_a_of_type_AndroidGraphicsPaint.setColor(Color.argb(this.jdField_g_of_type_Int, 0, 0, 255));
        this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(f1);
        paramCanvas.drawCircle(localRect.centerX(), localRect.centerY(), f2 - f3, this.jdField_a_of_type_AndroidGraphicsPaint);
      }
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessageDelayed(2, 55L);
      return;
      if (f2 > f1) {
        f1 = f2 - f1;
      } else {
        f1 = 0.0F;
      }
    }
  }
  
  public void e()
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.i;
    if (i < 0) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.i = -1;
    ThreadManager.post(new upi(this, i), 8, null, false);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1) {
      f();
    }
    do
    {
      return true;
      if (paramMessage.what == 2)
      {
        g();
        h();
        return true;
      }
    } while (paramMessage.what != 3);
    paramMessage = ((RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(35)).a("103100.103300.103301");
    RedTouch localRedTouch = new RedTouch(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), this.jdField_c_of_type_AndroidWidgetTextView).a(53).a();
    this.jdField_c_of_type_AndroidWidgetTextView.setTag(localRedTouch);
    localRedTouch.a(paramMessage);
    return true;
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == 2131369442)
    {
      setCurrentPannel(1, false);
      i = 1;
    }
    for (;;)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "changevoice", "0X8006F4D", 0, 0, "" + i, "", "", "");
      return;
      if (i == 2131369443)
      {
        setCurrentPannel(2, false);
        i = 2;
      }
      else
      {
        if (i == 2131369441)
        {
          setCurrentPannel(0, false);
          ((RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(35)).b("103100.103300.103301");
          paramView = this.jdField_c_of_type_AndroidWidgetTextView.getTag();
          if ((paramView != null) && ((paramView instanceof RedTouch))) {
            ((RedTouch)paramView).b();
          }
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout != null) {
            this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setShowRed(2, false);
          }
        }
        i = 0;
      }
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction() & 0xFF;
    if (i == 0) {
      getParent().requestDisallowInterceptTouchEvent(true);
    }
    for (;;)
    {
      return super.onInterceptTouchEvent(paramMotionEvent);
      if ((i == 1) || (i == 3)) {
        getParent().requestDisallowInterceptTouchEvent(false);
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((!this.jdField_b_of_type_Boolean) || (this.jdField_d_of_type_Boolean))
    {
      this.jdField_d_of_type_Boolean = false;
      paramInt2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelViewPager.getCurrentItem();
      View localView = this.jdField_b_of_type_AndroidViewViewGroup.getChildAt(paramInt2);
      if (localView != null)
      {
        paramInt1 = (paramInt3 - paramInt1 - localView.getWidth()) / 2;
        paramInt1 = localView.getLeft() - paramInt1;
        if (QLog.isColorLevel()) {
          QLog.d("AIOAudioPanel", 2, "needScrollX is:" + paramInt1);
        }
        this.jdField_b_of_type_AndroidViewViewGroup.scrollTo(paramInt1, this.jdField_b_of_type_AndroidViewViewGroup.getScrollY());
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    j = 0;
    for (;;)
    {
      try
      {
        localLayoutParams = (LinearLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelViewPager.getLayoutParams();
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelViewPager.getCurrentItem() != 0) || (!ListenChangeVoicePanel.jdField_b_of_type_Boolean)) {
          continue;
        }
        i = 1;
      }
      catch (Exception localException)
      {
        LinearLayout.LayoutParams localLayoutParams;
        continue;
        if (i == 0) {
          continue;
        }
        int i = j;
        continue;
      }
      localLayoutParams.topMargin = i;
      super.onMeasure(paramInt1, paramInt2);
      return;
      i = 0;
      continue;
      i = XPanelContainer.jdField_d_of_type_Int / 2;
    }
  }
  
  public void onPageScrollStateChanged(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "onPageScrollStateChanged() is called,state is:" + paramInt);
    }
    if (paramInt == 0)
    {
      this.jdField_b_of_type_Boolean = false;
      a(this.jdField_b_of_type_AndroidViewViewGroup, this.jdField_b_of_type_AndroidViewViewGroup.getChildAt(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelViewPager.getCurrentItem()), -8355712, -15158044);
      if (a() == 0)
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "changevoice", "0X8006F4C", 0, 0, "1", "", "", "");
        ((RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(35)).b("103100.103300.103301");
        Object localObject = this.jdField_c_of_type_AndroidWidgetTextView.getTag();
        if ((localObject != null) && ((localObject instanceof RedTouch))) {
          ((RedTouch)localObject).b();
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setShowRed(2, false);
        }
      }
    }
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    paramInt1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelViewPager.getWidth();
    paramInt2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelViewPager.getPageMargin() + paramInt1;
    if (!this.jdField_b_of_type_Boolean)
    {
      this.jdField_e_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelViewPager.getCurrentItem();
      this.jdField_c_of_type_Int = ((this.jdField_e_of_type_Int + this.jdField_f_of_type_Int) * paramInt2);
      this.jdField_d_of_type_Int = this.jdField_b_of_type_AndroidViewViewGroup.getScrollX();
      this.jdField_b_of_type_Boolean = true;
    }
    paramFloat = this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelViewPager.getScrollX() - this.jdField_c_of_type_Int;
    if (paramFloat < 0.0F) {
      paramInt1 = this.jdField_e_of_type_Int - 1;
    }
    for (;;)
    {
      View localView1 = this.jdField_b_of_type_AndroidViewViewGroup.getChildAt(this.jdField_e_of_type_Int);
      View localView2 = this.jdField_b_of_type_AndroidViewViewGroup.getChildAt(paramInt1);
      if (QLog.isColorLevel())
      {
        QLog.d("AIOAudioPanel", 2, "onPageScrolled() is called,pageBeforeScroll is:" + this.jdField_e_of_type_Int + ",nextPage is:" + paramInt1 + ",vpWidthWithMargin is:" + paramInt2);
        QLog.d("AIOAudioPanel", 2, "vpRelativeScrollX is:" + paramFloat + ",vpScrollXBeforeScroll is:" + this.jdField_c_of_type_Int + ",pdScrollXBeforeScroll is:" + this.jdField_d_of_type_Int);
      }
      if ((localView1 != null) && (localView2 != null))
      {
        paramInt1 = localView1.getLeft() + localView1.getWidth() / 2;
        int i = localView2.getLeft() + localView2.getWidth() / 2;
        int j = (int)(Math.abs(paramFloat / paramInt2) * (i - paramInt1));
        if (QLog.isColorLevel()) {
          QLog.d("AIOAudioPanel", 2, "centerChildCenterX is:" + paramInt1 + ",nextCenterChildCenterX is:" + i + ",pdRelativeScrollX is:" + j);
        }
        this.jdField_b_of_type_AndroidViewViewGroup.scrollTo(this.jdField_d_of_type_Int + j, this.jdField_b_of_type_AndroidViewViewGroup.getScrollY());
        if (Math.abs(paramFloat) == paramInt2) {
          a(this.jdField_b_of_type_AndroidViewViewGroup, localView2, -8355712, -15158044);
        }
      }
      return;
      if (paramFloat > 0.0F) {
        paramInt1 = this.jdField_e_of_type_Int + 1;
      } else {
        paramInt1 = this.jdField_e_of_type_Int;
      }
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "onPageSelected() is called,position is:" + paramInt);
    }
    if (paramInt == 0) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005471", "0X8005471", 0, 0, "", "", "", "");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(paramInt, this.jdField_c_of_type_Boolean, this.jdField_e_of_type_Boolean);
    this.jdField_e_of_type_Boolean = false;
    if ((AppSetting.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ArrayOfJavaLangString != null) && (paramInt < this.jdField_a_of_type_ArrayOfJavaLangString.length))
    {
      int i = 0;
      if (i < this.jdField_b_of_type_AndroidViewViewGroup.getChildCount())
      {
        Object localObject = this.jdField_b_of_type_AndroidViewViewGroup.getChildAt(i);
        if ((localObject != null) && (i < this.jdField_a_of_type_ArrayOfJavaLangString.length))
        {
          if (!(localObject instanceof TextView)) {
            break label234;
          }
          localObject = (TextView)localObject;
          label163:
          this.jdField_a_of_type_ArrayOfJavaLangString[i] = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131433780, new Object[] { ((TextView)localObject).getText() });
          if (paramInt != i) {
            break label248;
          }
          ((TextView)localObject).setContentDescription("已选定" + this.jdField_a_of_type_ArrayOfJavaLangString[i]);
        }
        for (;;)
        {
          i += 1;
          break;
          label234:
          localObject = (TextView)((View)localObject).findViewById(2131369441);
          break label163;
          label248:
          ((TextView)localObject).setContentDescription(this.jdField_a_of_type_ArrayOfJavaLangString[i]);
        }
      }
      AccessibilityUtil.a(this.jdField_b_of_type_AndroidViewViewGroup, "已选定" + this.jdField_a_of_type_ArrayOfJavaLangString[paramInt]);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public void setCurrentPannel(int paramInt, boolean paramBoolean)
  {
    if ((paramInt < 0) || (paramInt >= 3)) {}
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelViewPager.getCurrentItem() != paramInt)
      {
        this.jdField_e_of_type_Boolean = paramBoolean;
        this.jdField_f_of_type_Boolean = paramBoolean;
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelViewPager.setCurrentItem(paramInt);
        requestLayout();
        a(this.jdField_b_of_type_AndroidViewViewGroup, this.jdField_b_of_type_AndroidViewViewGroup.getChildAt(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelViewPager.getCurrentItem()), -8355712, -15158044);
      }
    } while (!this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelViewPager.jdField_a_of_type_Boolean);
    this.jdField_f_of_type_Int = (-paramInt);
  }
  
  public void setReceiptMode(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelAdapter.a(paramBoolean);
    this.jdField_g_of_type_Boolean = true;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPressToSpeakPanel != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPressToSpeakPanel.setUseOnce(true);
    }
  }
  
  public void setSpeakPanel(PressToSpeakPanel paramPressToSpeakPanel)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPressToSpeakPanel = paramPressToSpeakPanel;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPressToSpeakPanel.setUseOnce(this.jdField_g_of_type_Boolean);
  }
  
  public void setStatus(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setStatus(paramInt);
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_Boolean = false;
    }
    if (paramInt == 0)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "changevoice", "0X8006F49", 0, 0, "" + a(), "", "", "");
      if (a() == 0) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "changevoice", "0X8006F4C", 0, 0, "0", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.AudioPanel
 * JD-Core Version:    0.7.0.1
 */