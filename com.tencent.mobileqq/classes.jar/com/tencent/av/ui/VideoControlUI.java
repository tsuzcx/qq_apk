package com.tencent.av.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.text.TextPaint;
import android.text.method.ScrollingMovementMethod;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.OrientationEventListener;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.av.AVLog;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.camera.CameraUtils;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.av.doodle.DoodleLogic;
import com.tencent.av.doodle.DoodleReportController;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.av.ui.funchat.zimu.ZimuView;
import com.tencent.av.ui.funchat.zimu.ZimuViewLive;
import com.tencent.av.ui.redbag.AVRedBagMgr;
import com.tencent.av.ui.redbag.RedBagUtil;
import com.tencent.av.utils.QQAnimationListener;
import com.tencent.av.utils.QQFrameByFrameAnimation;
import com.tencent.av.utils.RingAnimator;
import com.tencent.av.utils.SensorHelper;
import com.tencent.av.utils.TintStateDrawable;
import com.tencent.av.utils.TipsManager;
import com.tencent.av.utils.TraeHelper;
import com.tencent.av.utils.UITools;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.QQUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import kck;
import kcl;
import kcm;
import kcn;
import kco;
import kcp;
import kcq;
import kcr;
import kcs;
import kct;
import kcu;
import kcv;
import kcw;
import kcx;
import kcy;

public abstract class VideoControlUI
{
  float jdField_a_of_type_Float = 0.0F;
  private int jdField_a_of_type_Int;
  Context jdField_a_of_type_AndroidContentContext = null;
  public Resources a;
  GestureDetector.OnGestureListener jdField_a_of_type_AndroidViewGestureDetector$OnGestureListener = new kcr(this);
  public GestureDetector a;
  OrientationEventListener jdField_a_of_type_AndroidViewOrientationEventListener = null;
  public ViewGroup a;
  AlphaAnimation jdField_a_of_type_AndroidViewAnimationAlphaAnimation = null;
  public Animation a;
  TranslateAnimation jdField_a_of_type_AndroidViewAnimationTranslateAnimation = null;
  public FrameLayout a;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout = null;
  Toast jdField_a_of_type_AndroidWidgetToast = null;
  public VideoController a;
  public VideoAppInterface a;
  public EffectSettingUi a;
  public QavPanel a;
  public VideoNetStateBar a;
  QQAnimationListener jdField_a_of_type_ComTencentAvUtilsQQAnimationListener = new kck(this);
  QQFrameByFrameAnimation jdField_a_of_type_ComTencentAvUtilsQQFrameByFrameAnimation = null;
  RingAnimator jdField_a_of_type_ComTencentAvUtilsRingAnimator = null;
  public SensorHelper a;
  public TipsManager a;
  public TraeHelper a;
  public WeakReference a;
  private kcs jdField_a_of_type_Kcs;
  kct jdField_a_of_type_Kct;
  kcv jdField_a_of_type_Kcv;
  kcx jdField_a_of_type_Kcx = null;
  public kcy a;
  float jdField_b_of_type_Float = 0.0F;
  View.OnTouchListener jdField_b_of_type_AndroidViewView$OnTouchListener = new kcq(this);
  ViewGroup jdField_b_of_type_AndroidViewViewGroup = null;
  AlphaAnimation jdField_b_of_type_AndroidViewAnimationAlphaAnimation = null;
  Animation.AnimationListener jdField_b_of_type_AndroidViewAnimationAnimation$AnimationListener = new kcm(this);
  Animation jdField_b_of_type_AndroidViewAnimationAnimation = null;
  TranslateAnimation jdField_b_of_type_AndroidViewAnimationTranslateAnimation = null;
  Button jdField_b_of_type_AndroidWidgetButton = null;
  public FrameLayout b;
  public ImageButton b;
  ImageView jdField_b_of_type_AndroidWidgetImageView = null;
  public LinearLayout b;
  public ControlUIObserver b;
  kcx jdField_b_of_type_Kcx = null;
  public View c;
  Animation jdField_c_of_type_AndroidViewAnimationAnimation = null;
  TranslateAnimation jdField_c_of_type_AndroidViewAnimationTranslateAnimation = null;
  Button jdField_c_of_type_AndroidWidgetButton = null;
  public FrameLayout c;
  public RelativeLayout c;
  public final String c;
  Animation jdField_d_of_type_AndroidViewAnimationAnimation = null;
  TranslateAnimation jdField_d_of_type_AndroidViewAnimationTranslateAnimation = null;
  Button jdField_d_of_type_AndroidWidgetButton = null;
  public RelativeLayout d;
  public String d;
  TranslateAnimation jdField_e_of_type_AndroidViewAnimationTranslateAnimation = null;
  public Button e;
  String jdField_e_of_type_JavaLangString = "DEVICE_EARPHONE;DEVICE_SPEAKERPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;";
  Button f;
  public String f;
  Button g;
  public TextView g;
  public String g;
  public TextView h;
  Runnable h;
  public String h;
  public boolean h;
  public TextView i;
  Runnable i;
  public boolean i;
  int jdField_j_of_type_Int = 0;
  public TextView j;
  Runnable jdField_j_of_type_JavaLangRunnable = new kcl(this);
  public boolean j;
  public int k;
  public TextView k;
  public boolean k;
  int l;
  public boolean l;
  int jdField_m_of_type_Int = 0;
  boolean jdField_m_of_type_Boolean = false;
  public int n;
  public boolean n;
  int o;
  public boolean o;
  int p = 0;
  public int q = 0;
  int r = 0;
  int s = 0;
  int t = 0;
  public int u = 1;
  public int v;
  public int w;
  
  public VideoControlUI(VideoAppInterface paramVideoAppInterface, AVActivity paramAVActivity, ViewGroup paramViewGroup, ControlUIObserver paramControlUIObserver)
  {
    this.jdField_k_of_type_Int = 0;
    this.jdField_l_of_type_Int = 0;
    this.jdField_o_of_type_Int = 0;
    this.jdField_h_of_type_Boolean = false;
    this.jdField_i_of_type_Boolean = true;
    this.jdField_j_of_type_Boolean = false;
    this.jdField_d_of_type_JavaLangString = null;
    this.jdField_h_of_type_JavaLangRunnable = null;
    this.jdField_a_of_type_AndroidContentResResources = null;
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
    this.jdField_a_of_type_AndroidViewViewGroup = null;
    this.jdField_g_of_type_AndroidWidgetTextView = null;
    this.jdField_h_of_type_AndroidWidgetTextView = null;
    this.jdField_i_of_type_AndroidWidgetTextView = null;
    this.jdField_a_of_type_ComTencentAvUtilsTipsManager = null;
    this.jdField_j_of_type_AndroidWidgetTextView = null;
    this.jdField_b_of_type_AndroidWidgetLinearLayout = null;
    this.jdField_e_of_type_AndroidWidgetButton = null;
    this.jdField_f_of_type_AndroidWidgetButton = null;
    this.jdField_g_of_type_AndroidWidgetButton = null;
    this.jdField_k_of_type_AndroidWidgetTextView = null;
    this.jdField_a_of_type_AndroidViewGestureDetector = null;
    this.jdField_a_of_type_ComTencentAvUiQavPanel = null;
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = null;
    this.jdField_d_of_type_AndroidWidgetRelativeLayout = null;
    this.jdField_a_of_type_AndroidWidgetFrameLayout = null;
    this.jdField_b_of_type_AndroidWidgetFrameLayout = null;
    this.jdField_c_of_type_AndroidWidgetFrameLayout = null;
    this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar = null;
    this.jdField_a_of_type_AndroidViewAnimationAnimation = null;
    this.jdField_i_of_type_JavaLangRunnable = null;
    this.jdField_c_of_type_AndroidViewView = null;
    this.jdField_a_of_type_ComTencentAvUtilsTraeHelper = null;
    this.jdField_a_of_type_ComTencentAvUtilsSensorHelper = null;
    this.jdField_l_of_type_Boolean = false;
    this.jdField_a_of_type_Kcy = new kcy(this);
    this.jdField_o_of_type_Boolean = true;
    this.jdField_h_of_type_JavaLangString = (Build.MANUFACTURER + "." + Build.MODEL);
    this.jdField_c_of_type_JavaLangString = (getClass().getSimpleName() + "_" + AudioHelper.a());
    if (QLog.isDevelopLevel()) {
      QLog.w(this.jdField_c_of_type_JavaLangString, 1, "VideoControlUI");
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramAVActivity);
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
    this.jdField_a_of_type_Kcv = new kcv(this);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_Kcv);
    paramVideoAppInterface = (AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (paramVideoAppInterface == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e(this.jdField_c_of_type_JavaLangString, 2, "VideoControlUI-->can not get AVActivity");
      }
      return;
    }
    this.jdField_a_of_type_AndroidContentResResources = paramVideoAppInterface.getResources();
    if (this.jdField_a_of_type_AndroidContentResResources == null)
    {
      AVLog.d(this.jdField_c_of_type_JavaLangString, "mRes is null. exit video progress");
      paramAVActivity = paramVideoAppInterface.getString(2131428796) + " 0x08";
      Toast.makeText(paramVideoAppInterface.getApplicationContext(), paramAVActivity, 0).show();
      paramVideoAppInterface.finish();
      return;
    }
    this.jdField_a_of_type_ComTencentAvVideoController = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    if (this.jdField_a_of_type_ComTencentAvVideoController == null)
    {
      AVLog.d(this.jdField_c_of_type_JavaLangString, "mVideoController is null. exit video progress");
      paramAVActivity = this.jdField_a_of_type_AndroidContentResResources.getString(2131428796) + " 0x09";
      Toast.makeText(paramVideoAppInterface.getApplicationContext(), paramAVActivity, 0).show();
      paramVideoAppInterface.finish();
      return;
    }
    this.jdField_b_of_type_ComTencentAvUiControlUIObserver = paramControlUIObserver;
    this.r = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131560102);
    this.jdField_b_of_type_Float = this.jdField_a_of_type_AndroidContentResResources.getDimension(2131560103);
    this.s = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131560104);
    this.t = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131560105);
  }
  
  private int a()
  {
    int i8 = 0;
    boolean bool3 = false;
    int i7;
    Object localObject1;
    Object localObject2;
    boolean bool2;
    boolean bool1;
    label119:
    int i5;
    int i4;
    label152:
    boolean bool4;
    int i6;
    label181:
    int i2;
    int i9;
    int i1;
    int i3;
    boolean bool5;
    if ((!this.jdField_n_of_type_Boolean) && (!this.jdField_i_of_type_Boolean))
    {
      i7 = 1;
      if ((this.jdField_a_of_type_JavaLangRefWeakReference == null) || (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null)) {
        break label632;
      }
      localObject1 = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (!(localObject1 instanceof AVActivity)) {
        break label632;
      }
      localObject1 = (AVActivity)localObject1;
      localObject2 = (ZimuView)((AVActivity)localObject1).findViewById(2131362542);
      if ((localObject2 == null) || (((ZimuView)localObject2).getVisibility() != 0)) {
        break label623;
      }
      bool2 = ((ZimuView)localObject2).a().equals("film");
      bool1 = ((ZimuView)localObject2).a().equals("liveshow");
      localObject2 = ((AVActivity)localObject1).jdField_a_of_type_ComTencentAvUiVideoLayerUI;
      if (localObject2 == null) {
        break label611;
      }
      bool3 = ((VideoLayerUI)localObject2).d();
      i5 = ((VideoLayerUI)localObject2).h();
      i4 = ((VideoLayerUI)localObject2).g();
      localObject2 = ((AVActivity)localObject1).jdField_a_of_type_ComTencentAvUiVideoControlUI.jdField_a_of_type_ComTencentAvUiEffectSettingUi;
      if (localObject2 == null) {
        break label602;
      }
      bool4 = ((EffectSettingUi)localObject2).isShown();
      i6 = ((EffectSettingUi)localObject2).a();
      localObject1 = ((AVActivity)localObject1).findViewById(2131365944);
      if (localObject1 == null) {
        break label581;
      }
      localObject2 = ((View)localObject1).findViewById(2131365949);
      if (!bool2) {
        break label364;
      }
      i2 = ((View)localObject1).getHeight();
      i9 = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131560083);
      i1 = ((View)localObject1).getHeight();
      int i12 = ((View)localObject2).getTop();
      int i13 = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131560080);
      i3 = ((View)localObject1).getHeight();
      int i10 = ((View)localObject2).getHeight();
      int i11 = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131560083);
      i1 = i1 - i12 - i13;
      bool5 = bool4;
      i3 = i3 - i10 + i11;
      i2 = i9 + i2;
      bool4 = bool3;
      bool3 = bool5;
    }
    for (;;)
    {
      label312:
      if (((bool2) || (bool1)) && (!bool4)) {
        if (i7 != 0)
        {
          i1 = 0;
          if (bool2)
          {
            i1 = 2131560081;
            label343:
            if (i1 == 0) {
              break label576;
            }
            i1 = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(i1);
          }
        }
      }
      for (;;)
      {
        return i1;
        i7 = 0;
        break;
        label364:
        if (!bool1) {
          break label581;
        }
        i2 = ((View)localObject1).getHeight();
        i1 = (int)(this.jdField_a_of_type_AndroidContentResResources.getDisplayMetrics().widthPixels / QAVPtvTemplateAdapter.jdField_a_of_type_Float + 0.5F + this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131560132));
        i3 = ((View)localObject1).getHeight();
        i9 = ((View)localObject2).getHeight();
        i3 -= i9;
        bool5 = bool3;
        bool3 = bool4;
        bool4 = bool5;
        break label312;
        if (!bool1) {
          break label343;
        }
        i1 = 2131560133;
        break label343;
        if (bool3)
        {
          switch (i6)
          {
          default: 
            return this.jdField_a_of_type_ComTencentAvUiQavPanel.a();
          case 1: 
          case 2: 
          case 4: 
          case 6: 
            return i1;
          case 5: 
            return i2;
          }
          return i3;
        }
        return this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131560084);
        if ((bool1) && (bool4))
        {
          if (i7 != 0) {
            return this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131560133);
          }
          return i5 - ScreenLayoutDoubleScreen.b(i4);
        }
        i1 = i8;
        if (i7 == 0)
        {
          return this.jdField_a_of_type_ComTencentAvUiQavPanel.a();
          label576:
          i1 = 0;
        }
      }
      label581:
      i1 = 0;
      i3 = 0;
      bool5 = bool3;
      i2 = 0;
      bool3 = bool4;
      bool4 = bool5;
      continue;
      label602:
      i6 = -1;
      bool4 = false;
      break label181;
      label611:
      i4 = 0;
      i5 = 0;
      bool3 = false;
      break label152;
      label623:
      bool1 = false;
      bool2 = false;
      break label119;
      label632:
      i1 = 0;
      i2 = 0;
      bool4 = false;
      i6 = -1;
      bool2 = false;
      i4 = 0;
      i5 = 0;
      bool1 = false;
      i3 = 0;
    }
  }
  
  private void a(int paramInt, Object paramObject)
  {
    AVLog.c(this.jdField_c_of_type_JavaLangString, "notifyEvent :" + paramInt + "|" + paramObject);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(paramInt), paramObject });
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((Build.VERSION.SDK_INT >= 19) && (this.jdField_a_of_type_JavaLangRefWeakReference != null))
    {
      Object localObject = (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localObject != null)
      {
        Window localWindow = ((Activity)localObject).getWindow();
        if (localWindow != null) {
          for (;;)
          {
            try
            {
              localObject = (ZimuView)((Activity)localObject).findViewById(2131362542);
              if ((localObject == null) || (((ZimuView)localObject).getVisibility() != 0) || (!(localObject instanceof ZimuViewLive))) {
                break label136;
              }
              ((ZimuViewLive)localObject).a();
              i1 = 1;
              if ((!paramBoolean1) || (!paramBoolean2) || (l())) {
                break label141;
              }
              localWindow.setFlags(2048, 1024);
              return;
            }
            catch (Exception localException)
            {
              localException.printStackTrace();
              return;
            }
            localWindow.addFlags(1024);
            return;
            label136:
            int i1 = 0;
            continue;
            label141:
            if (i1 == 0) {}
          }
        }
      }
    }
  }
  
  private void b(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_AndroidContentContext == null) || (CameraUtils.a(this.jdField_a_of_type_AndroidContentContext).b()) || (CameraUtils.a(this.jdField_a_of_type_AndroidContentContext).c())) {
      if (QLog.isColorLevel())
      {
        QLog.w(this.jdField_c_of_type_JavaLangString, 1, "enableCameraRelatedBtn, enable[" + paramBoolean + "], already opening or opened");
        QLog.d(this.jdField_c_of_type_JavaLangString, 2, "");
      }
    }
    label336:
    label367:
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)
            {
              if (paramBoolean)
              {
                if ((this.jdField_a_of_type_ComTencentAvVideoController.a().d == 1) || (this.jdField_a_of_type_ComTencentAvVideoController.a().d == 2))
                {
                  if (this.jdField_a_of_type_ComTencentAvVideoController.a().f())
                  {
                    this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131365408, true);
                    this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131365404, true);
                    return;
                  }
                  this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131365408, false);
                  this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131365404, false);
                  return;
                }
                this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131365408, true);
                this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131365404, true);
                return;
              }
              this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131365408, false);
              this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131365404, false);
              return;
            }
            if (!paramBoolean) {
              break label367;
            }
            if ((this.jdField_a_of_type_ComTencentAvVideoController.a().d != 1) && (this.jdField_a_of_type_ComTencentAvVideoController.a().d != 2)) {
              break label336;
            }
            if (!this.jdField_a_of_type_ComTencentAvVideoController.a().f()) {
              break;
            }
            if (this.jdField_e_of_type_AndroidWidgetButton != null) {
              this.jdField_e_of_type_AndroidWidgetButton.setEnabled(true);
            }
          } while (this.jdField_b_of_type_AndroidWidgetButton == null);
          this.jdField_b_of_type_AndroidWidgetButton.setEnabled(true);
          return;
          if (this.jdField_e_of_type_AndroidWidgetButton != null) {
            this.jdField_e_of_type_AndroidWidgetButton.setEnabled(false);
          }
        } while (this.jdField_b_of_type_AndroidWidgetButton == null);
        this.jdField_b_of_type_AndroidWidgetButton.setEnabled(false);
        return;
        if (this.jdField_e_of_type_AndroidWidgetButton != null) {
          this.jdField_e_of_type_AndroidWidgetButton.setEnabled(true);
        }
      } while (this.jdField_b_of_type_AndroidWidgetButton == null);
      this.jdField_b_of_type_AndroidWidgetButton.setEnabled(true);
      return;
      if (this.jdField_e_of_type_AndroidWidgetButton != null) {
        this.jdField_e_of_type_AndroidWidgetButton.setEnabled(false);
      }
    } while (this.jdField_b_of_type_AndroidWidgetButton == null);
    this.jdField_b_of_type_AndroidWidgetButton.setEnabled(false);
  }
  
  private void c(boolean paramBoolean)
  {
    a(paramBoolean, k());
  }
  
  public void B() {}
  
  public void C() {}
  
  public void E()
  {
    af();
  }
  
  public void F()
  {
    ag();
  }
  
  public void H() {}
  
  public void X()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_c_of_type_JavaLangString, 2, "onPauseAudio");
    }
    if (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null)
    {
      if ((this.jdField_o_of_type_Int != 0) && (this.jdField_o_of_type_Int != 1)) {
        break label50;
      }
      this.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(28, true);
    }
    label50:
    while (this.jdField_o_of_type_Int != 2) {
      return;
    }
    this.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(29, true);
  }
  
  public void Y()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_c_of_type_JavaLangString, 2, "onResumeAudio");
    }
    if (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null) {
      this.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(29, false);
    }
  }
  
  public void Z()
  {
    if (this.jdField_h_of_type_Boolean) {}
    while (((this.jdField_j_of_type_Int < 2) || (this.jdField_j_of_type_Int > 4)) && (!this.jdField_a_of_type_ComTencentAvVideoController.a().f())) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_c_of_type_JavaLangString, 2, "startTimer");
    }
    this.jdField_h_of_type_Boolean = true;
    if (this.jdField_h_of_type_JavaLangRunnable == null) {
      this.jdField_h_of_type_JavaLangRunnable = new kcw(this);
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_h_of_type_JavaLangRunnable, 0L);
  }
  
  public int a(int paramInt)
  {
    return 0;
  }
  
  public View a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvUiQavPanel == null) {
      return null;
    }
    return this.jdField_a_of_type_ComTencentAvUiQavPanel.a(paramInt2, paramInt1, paramBoolean);
  }
  
  public AlphaAnimation a(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);; localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F))
    {
      localAlphaAnimation.setFillEnabled(true);
      localAlphaAnimation.setStartOffset(0L);
      localAlphaAnimation.setDuration(200L);
      localAlphaAnimation.setFillAfter(true);
      return localAlphaAnimation;
    }
  }
  
  public String a(String paramString)
  {
    return paramString;
  }
  
  @TargetApi(11)
  public void a(float paramFloat)
  {
    if ((Build.VERSION.SDK_INT >= 11) && (this.jdField_a_of_type_AndroidWidgetLinearLayout.getRotation() != paramFloat))
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setRotation(paramFloat);
      b("setTipsRotation");
    }
  }
  
  public void a(int paramInt1, int paramInt2) {}
  
  void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_AndroidWidgetToast != null)
    {
      int i1 = Build.VERSION.SDK_INT;
      if ((i1 != 14) && (i1 != 15)) {
        this.jdField_a_of_type_AndroidWidgetToast.cancel();
      }
    }
    this.jdField_a_of_type_AndroidWidgetToast = null;
    Context localContext = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localContext != null)
    {
      if (paramInt3 == 0) {}
      try
      {
        this.jdField_a_of_type_AndroidWidgetToast = QQToast.a(localContext, paramInt1, paramInt2).a();
        return;
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          return;
        }
        QLog.e(this.jdField_c_of_type_JavaLangString, 2, "showToast-->can not show toast-->e=" + localException.getMessage());
      }
      this.jdField_a_of_type_AndroidWidgetToast = QQToast.a(localContext, paramInt1, paramInt2).b(paramInt3);
      return;
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.jdField_a_of_type_AndroidWidgetToast != null)
    {
      int i1 = Build.VERSION.SDK_INT;
      if ((i1 != 14) && (i1 != 15)) {
        this.jdField_a_of_type_AndroidWidgetToast.cancel();
      }
    }
    this.jdField_a_of_type_AndroidWidgetToast = null;
    Context localContext = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localContext != null)
    {
      if (paramInt4 == 0) {}
      try
      {
        this.jdField_a_of_type_AndroidWidgetToast = QQToast.a(localContext, paramInt2, paramInt1, paramInt3).a();
        return;
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          return;
        }
        QLog.e(this.jdField_c_of_type_JavaLangString, 2, "showToast-->can not show toast-->e=" + localException.getMessage());
      }
      this.jdField_a_of_type_AndroidWidgetToast = QQToast.a(localContext, paramInt2, paramInt1, paramInt3).b(paramInt4);
      return;
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar != null) {
      this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar.a(paramInt1, paramInt2, paramInt3, paramString);
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(int paramInt1, int paramInt2, String paramString) {}
  
  public void a(int paramInt1, int paramInt2, String paramString1, String paramString2, long paramLong) {}
  
  public void a(int paramInt, String paramString) {}
  
  public void a(int paramInt, boolean paramBoolean)
  {
    switch (paramInt)
    {
    }
    ImageButton localImageButton;
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
              do
              {
                do
                {
                  return;
                  if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)
                  {
                    this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131365406, paramBoolean);
                    return;
                  }
                } while (this.jdField_c_of_type_AndroidWidgetButton == null);
                this.jdField_c_of_type_AndroidWidgetButton.setEnabled(paramBoolean);
                return;
                if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)
                {
                  this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131365402, paramBoolean);
                  return;
                }
              } while (this.jdField_d_of_type_AndroidWidgetButton == null);
              this.jdField_d_of_type_AndroidWidgetButton.setEnabled(paramBoolean);
              return;
              if (this.jdField_a_of_type_ComTencentAvUiQavPanel == null) {
                break;
              }
              this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131365404, paramBoolean);
            } while (VcSystemInfo.b());
            this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131365404, false);
            return;
          } while (this.jdField_b_of_type_AndroidWidgetButton == null);
          this.jdField_b_of_type_AndroidWidgetButton.setEnabled(paramBoolean);
        } while (VcSystemInfo.b());
        this.jdField_b_of_type_AndroidWidgetButton.setEnabled(false);
        return;
      } while (this.jdField_a_of_type_AndroidViewViewGroup == null);
      localImageButton = (ImageButton)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365374);
    } while (localImageButton == null);
    localImageButton.setEnabled(paramBoolean);
  }
  
  public void a(Intent paramIntent) {}
  
  public abstract void a(View paramView);
  
  public void a(TipsManager paramTipsManager)
  {
    this.jdField_a_of_type_ComTencentAvUtilsTipsManager = paramTipsManager;
    if (this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar != null) {
      this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar.a(this.jdField_a_of_type_ComTencentAvUtilsTipsManager);
    }
  }
  
  public void a(String paramString) {}
  
  public void a(String paramString1, int paramInt1, String paramString2, int paramInt2) {}
  
  public void a(String paramString, Bitmap paramBitmap) {}
  
  public void a(String paramString1, String paramString2) {}
  
  public void a(String paramString, boolean paramBoolean) {}
  
  public boolean a()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_ComTencentAvUiEffectSettingUi != null)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_ComTencentAvUiEffectSettingUi.isShown()) {
        bool1 = this.jdField_a_of_type_ComTencentAvUiEffectSettingUi.a();
      }
    }
    return bool1;
  }
  
  boolean a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAvUiEffectSettingUi != null) {
      return this.jdField_a_of_type_ComTencentAvUiEffectSettingUi.a(paramInt);
    }
    return false;
  }
  
  public abstract boolean a(int paramInt, KeyEvent paramKeyEvent);
  
  public void aa()
  {
    if (!this.jdField_h_of_type_Boolean) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_c_of_type_JavaLangString, 2, "stopTimer");
      }
      this.jdField_h_of_type_Boolean = false;
    } while (this.jdField_h_of_type_JavaLangRunnable == null);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_h_of_type_JavaLangRunnable);
    this.jdField_h_of_type_JavaLangRunnable = null;
  }
  
  public void ab()
  {
    if (this.jdField_b_of_type_AndroidWidgetImageView != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_c_of_type_JavaLangString, 2, "setScreenDarken");
      }
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
      localAlphaAnimation.setDuration(500L);
      localAlphaAnimation.setFillAfter(true);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetImageView.startAnimation(localAlphaAnimation);
    }
  }
  
  void ac()
  {
    this.jdField_a_of_type_ComTencentAvUtilsQQFrameByFrameAnimation = new QQFrameByFrameAnimation();
    this.jdField_a_of_type_ComTencentAvUtilsQQFrameByFrameAnimation.a(100);
    this.jdField_a_of_type_ComTencentAvUtilsQQFrameByFrameAnimation.b(8);
    this.jdField_a_of_type_ComTencentAvUtilsQQFrameByFrameAnimation.a(new int[] { 2130840138, 2130840139 });
    this.jdField_a_of_type_ComTencentAvUtilsQQFrameByFrameAnimation.a(this.jdField_a_of_type_ComTencentAvUtilsQQAnimationListener);
  }
  
  public void ad()
  {
    Context localContext = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if ((localContext != null) && ((localContext instanceof AVActivity)) && (((AVActivity)localContext).b())) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_j_of_type_JavaLangRunnable);
    }
    label184:
    do
    {
      do
      {
        return;
        if ((this.jdField_a_of_type_ComTencentAvVideoController.a().d != 2) && (this.jdField_a_of_type_ComTencentAvVideoController.a().d != 4)) {
          break label184;
        }
        if (!this.jdField_i_of_type_Boolean) {
          break;
        }
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_j_of_type_JavaLangRunnable);
      } while (((this.jdField_a_of_type_ComTencentAvVideoController.a().d == 2) && (!this.jdField_a_of_type_ComTencentAvVideoController.a().f())) || ((this.jdField_a_of_type_ComTencentAvVideoController.a().d == 4) && (this.jdField_a_of_type_ComTencentAvVideoController.a().k())));
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_j_of_type_JavaLangRunnable, 6000L);
      return;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_j_of_type_JavaLangRunnable);
      return;
    } while ((this.jdField_a_of_type_ComTencentAvVideoController.a().d != 1) && (this.jdField_a_of_type_ComTencentAvVideoController.a().d != 3));
    if (!this.jdField_i_of_type_Boolean)
    {
      if ((this.jdField_a_of_type_ComTencentAvVideoController.a().d == 2) && (!this.jdField_a_of_type_ComTencentAvVideoController.a().f()))
      {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_j_of_type_JavaLangRunnable);
        return;
      }
      i(0);
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_j_of_type_JavaLangRunnable);
  }
  
  public void ae()
  {
    if ((this.jdField_a_of_type_ComTencentAvVideoController.a().i == 9500) && (this.jdField_a_of_type_ComTencentAvVideoController.s)) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_j_of_type_JavaLangRunnable);
    }
  }
  
  public void af()
  {
    if (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null) {
      this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a();
    }
  }
  
  public void ag()
  {
    if (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null) {
      this.jdField_a_of_type_ComTencentAvUtilsTipsManager.b();
    }
  }
  
  public void ah()
  {
    if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)
    {
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131365402, false);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131365404, false);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131365406, false);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131365408, false);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131365396, false);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131365400, false);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131365393, false);
    }
  }
  
  public void ai()
  {
    if (this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar != null) {
      this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar.h();
    }
  }
  
  public void aj()
  {
    if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null) {
      if ((this.jdField_a_of_type_ComTencentAvVideoController.a().d != 2) && (this.jdField_a_of_type_ComTencentAvVideoController.a().d != 4)) {
        break label46;
      }
    }
    label46:
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_ComTencentAvUiQavPanel.d(bool);
      return;
    }
  }
  
  public void ak()
  {
    a(g(), k());
  }
  
  void b()
  {
    this.jdField_d_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365367));
    this.jdField_h_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131366273));
    this.jdField_b_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365374));
    Object localObject1 = this.jdField_a_of_type_AndroidContentResResources.getDrawable(2130840163);
    Object localObject2 = TintStateDrawable.a(this.jdField_a_of_type_AndroidContentResResources, 2130840163, 2131494073);
    this.jdField_b_of_type_AndroidWidgetImageButton.setMinimumWidth(((Drawable)localObject1).getIntrinsicWidth());
    this.jdField_b_of_type_AndroidWidgetImageButton.setMinimumHeight(((Drawable)localObject1).getIntrinsicHeight());
    this.jdField_b_of_type_AndroidWidgetImageButton.setImageDrawable((Drawable)localObject2);
    this.jdField_b_of_type_AndroidWidgetImageButton.setScaleType(ImageView.ScaleType.FIT_CENTER);
    this.jdField_i_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365384));
    this.jdField_a_of_type_ComTencentAvUiQavPanel = ((QavPanel)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365940));
    if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null) {
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setTipsManager(this.jdField_a_of_type_ComTencentAvUtilsTipsManager);
    }
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365390));
    this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365905));
    this.jdField_g_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365907));
    this.jdField_e_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365908));
    this.jdField_f_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365396));
    this.jdField_d_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365402));
    this.jdField_c_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365406));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365404));
    QLog.w(this.jdField_c_of_type_JavaLangString, 1, "initUI, mOpenCameraBtn[" + this.jdField_b_of_type_AndroidWidgetButton + "], mAddContactBtn[" + this.jdField_f_of_type_AndroidWidgetButton + "], mMuteBtn[" + this.jdField_d_of_type_AndroidWidgetButton + "], mHandFreeBtn[" + this.jdField_c_of_type_AndroidWidgetButton + "]");
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365385));
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365395));
    this.jdField_c_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365906));
    this.jdField_b_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365403));
    if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)
    {
      this.jdField_a_of_type_Kct = new kct(this);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setBtnOnTouchListener(this.jdField_a_of_type_Kct);
    }
    localObject1 = (AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e(this.jdField_c_of_type_JavaLangString, 2, "initUI-->can not get AVActivity");
      }
      return;
    }
    this.jdField_k_of_type_AndroidWidgetTextView = ((TextView)((AVActivity)localObject1).findViewById(2131365841));
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), this.jdField_a_of_type_AndroidViewGestureDetector$OnGestureListener);
    this.jdField_k_of_type_AndroidWidgetTextView.setOnTouchListener(this.jdField_b_of_type_AndroidViewView$OnTouchListener);
    this.jdField_k_of_type_AndroidWidgetTextView.setMovementMethod(ScrollingMovementMethod.getInstance());
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)((AVActivity)localObject1).findViewById(2131364269));
    this.jdField_j_of_type_AndroidWidgetTextView = ((TextView)((AVActivity)localObject1).findViewById(2131365836));
    this.jdField_j_of_type_AndroidWidgetTextView.getPaint().setFlags(8);
    localObject2 = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject2 == null)
    {
      QLog.e(this.jdField_c_of_type_JavaLangString, 2, "fail to get context");
      return;
    }
    if ((this.jdField_a_of_type_AndroidViewViewGroup != null) && (this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365371) != null) && (this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365383) != null)) {
      this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar = new VideoNetStateBar(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, (AVActivity)localObject1, this.jdField_a_of_type_AndroidViewViewGroup);
    }
    if (this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar != null)
    {
      this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar.a();
      if (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null) {
        this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar.a(this.jdField_a_of_type_ComTencentAvUtilsTipsManager);
      }
    }
    localObject1 = (WindowManager)((Context)localObject2).getSystemService("window");
    localObject2 = new DisplayMetrics();
    ((WindowManager)localObject1).getDefaultDisplay().getMetrics((DisplayMetrics)localObject2);
    this.jdField_a_of_type_Float = ((DisplayMetrics)localObject2).widthPixels;
    int i1 = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131559912);
    this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation = new TranslateAnimation(0.0F, this.jdField_a_of_type_Float / 6.0F - this.jdField_a_of_type_Float / 4.0F, 0.0F, 0.0F);
    this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation.setFillAfter(true);
    this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation.setDuration(150L);
    this.jdField_c_of_type_AndroidViewAnimationTranslateAnimation = new TranslateAnimation(0.0F, this.jdField_a_of_type_Float / 4.0F - this.jdField_a_of_type_Float / 6.0F, 0.0F, 0.0F);
    this.jdField_c_of_type_AndroidViewAnimationTranslateAnimation.setFillAfter(true);
    this.jdField_c_of_type_AndroidViewAnimationTranslateAnimation.setDuration(150L);
    this.jdField_d_of_type_AndroidViewAnimationTranslateAnimation = new TranslateAnimation(0.0F, this.jdField_a_of_type_Float - this.jdField_a_of_type_Float / 2.0F - (this.jdField_a_of_type_Float - this.jdField_a_of_type_Float / 4.0F), 0.0F, 0.0F);
    this.jdField_d_of_type_AndroidViewAnimationTranslateAnimation.setFillAfter(true);
    this.jdField_d_of_type_AndroidViewAnimationTranslateAnimation.setDuration(150L);
    this.jdField_e_of_type_AndroidViewAnimationTranslateAnimation = new TranslateAnimation(0.0F, this.jdField_a_of_type_Float - this.jdField_a_of_type_Float / 4.0F - (this.jdField_a_of_type_Float - this.jdField_a_of_type_Float / 2.0F), 0.0F, 0.0F);
    this.jdField_e_of_type_AndroidViewAnimationTranslateAnimation.setFillAfter(true);
    this.jdField_e_of_type_AndroidViewAnimationTranslateAnimation.setDuration(150L);
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation = new TranslateAnimation(0.0F, -i1, 0.0F, 0.0F);
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setFillAfter(true);
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setDuration(150L);
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setAnimationListener(this.jdField_b_of_type_AndroidViewAnimationAnimation$AnimationListener);
    this.jdField_c_of_type_AndroidViewAnimationAnimation = AnimationUtils.loadAnimation((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), 2131034224);
    this.jdField_c_of_type_AndroidViewAnimationAnimation.setAnimationListener(this.jdField_b_of_type_AndroidViewAnimationAnimation$AnimationListener);
    this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.setFillAfter(true);
    this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.setDuration(1000L);
    this.jdField_b_of_type_AndroidViewAnimationAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    this.jdField_b_of_type_AndroidViewAnimationAlphaAnimation.setFillAfter(true);
    this.jdField_b_of_type_AndroidViewAnimationAlphaAnimation.setDuration(1000L);
    this.jdField_d_of_type_AndroidViewAnimationAnimation = AnimationUtils.loadAnimation((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), 2131034248);
    localObject1 = (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject1 != null)
    {
      this.jdField_a_of_type_ComTencentAvUtilsTraeHelper = TraeHelper.a();
      if (this.jdField_a_of_type_ComTencentAvUiQavPanel == null) {
        break label1284;
      }
      this.jdField_a_of_type_ComTencentAvUiQavPanel.a(this.jdField_a_of_type_ComTencentAvUtilsTraeHelper);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentAvUtilsSensorHelper != null) {
        this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.a(false);
      }
      this.jdField_a_of_type_ComTencentAvUtilsSensorHelper = SensorHelper.a(this.jdField_a_of_type_ComTencentAvUtilsSensorHelper, (Activity)localObject1, this.jdField_a_of_type_ComTencentAvVideoController, this.jdField_a_of_type_ComTencentAvUtilsTraeHelper);
      this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.a(true);
      this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.a();
      if ((!SmallScreenUtils.b()) || (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)) {
        break;
      }
      this.jdField_h_of_type_AndroidWidgetTextView.setText(null);
      this.jdField_h_of_type_AndroidWidgetTextView.setBackgroundResource(0);
      this.jdField_h_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(this.jdField_a_of_type_AndroidContentResResources.getDrawable(2130840173), null, null, null);
      return;
      label1284:
      this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.a(this.jdField_c_of_type_AndroidWidgetButton);
    }
  }
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_c_of_type_JavaLangString, 2, "onClose type = " + paramInt + ", state = " + this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Int);
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().g()) {
      r(paramInt);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentAvUtilsSensorHelper != null) {
        this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.a(false);
      }
      if (SmallScreenUtils.b())
      {
        if (this.jdField_a_of_type_ComTencentAvUiQavPanel == null) {
          break;
        }
        this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131365402, false);
        this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131365404, false);
        this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131365406, false);
        this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131365408, false);
        this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131365396, false);
        this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131365400, false);
      }
      return;
      if ((paramInt == 25) || (paramInt == 56)) {
        r(paramInt);
      }
      s();
    }
    this.jdField_h_of_type_AndroidWidgetTextView.setEnabled(false);
  }
  
  public void b(int paramInt1, int paramInt2) {}
  
  public void b(String paramString)
  {
    if ((this.jdField_a_of_type_JavaLangRefWeakReference == null) || (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null)) {}
    int i1;
    int i2;
    float f1;
    do
    {
      return;
      Activity localActivity = (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      i1 = UITools.b(localActivity);
      i2 = UITools.a(localActivity);
      f1 = UITools.a(localActivity);
    } while (!QLog.isDevelopLevel());
    QLog.w(this.jdField_c_of_type_JavaLangString, 1, "adaptScreens[" + paramString + "], bottomBarHeight[" + d() + "], topBarHeight[" + c() + "], density[" + f1 + "], screenSize[" + i2 + ", " + i1 + "], hasSmartBar[" + h() + "]");
  }
  
  void b(String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {
      return;
    }
    AVActivity localAVActivity = (AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    paramString1 = DialogUtil.a(localAVActivity, 230).setMessage(paramString1).setTitle(paramString2).setNegativeButton(2131433029, new kco(this));
    if (UITools.a(localAVActivity)) {}
    for (int i1 = 2131429208;; i1 = 2131429209)
    {
      paramString1 = paramString1.setPositiveButton(i1, new kcn(this));
      if (!localAVActivity.isResume()) {
        break;
      }
      try
      {
        paramString1.show();
        return;
      }
      catch (Exception paramString1)
      {
        QLog.d(this.jdField_c_of_type_JavaLangString, 1, "showPermissionDialog, crash", paramString1);
        return;
      }
    }
  }
  
  public void b(String paramString, boolean paramBoolean) {}
  
  public abstract void b(boolean paramBoolean, int paramInt);
  
  public void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.jdField_m_of_type_Boolean == paramBoolean2) {}
    do
    {
      do
      {
        return;
        this.jdField_m_of_type_Boolean = paramBoolean2;
        if (!paramBoolean2) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_c_of_type_JavaLangString, 2, "onPhoneCalling call start isSelf: " + paramBoolean1 + ",deviceName: " + this.jdField_a_of_type_ComTencentAvVideoController.a().o);
        }
        if (this.jdField_a_of_type_ComTencentAvUtilsTraeHelper != null) {
          this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.b();
        }
      } while (this.jdField_a_of_type_ComTencentAvVideoController == null);
      this.jdField_a_of_type_ComTencentAvVideoController.a().u = this.jdField_a_of_type_ComTencentAvVideoController.a().o;
      return;
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_c_of_type_JavaLangString, 2, "onPhoneCalling call end isSelf: " + paramBoolean1 + ",mAudioStateBeforePhoneCall: " + this.jdField_a_of_type_ComTencentAvVideoController.a().u + ",mAudioSesstionType:" + this.jdField_e_of_type_JavaLangString);
      }
    } while ((this.jdField_a_of_type_ComTencentAvUtilsTraeHelper == null) || (this.jdField_a_of_type_ComTencentAvVideoController == null));
    if ("DEVICE_SPEAKERPHONE".equals(this.jdField_a_of_type_ComTencentAvVideoController.a().u))
    {
      this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.a("DEVICE_EARPHONE;DEVICE_SPEAKERPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;");
      return;
    }
    if ("DEVICE_EARPHONE".equals(this.jdField_a_of_type_ComTencentAvVideoController.a().u))
    {
      this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.a("DEVICE_SPEAKERPHONE;DEVICE_EARPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;");
      return;
    }
    this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.a(this.jdField_e_of_type_JavaLangString);
  }
  
  public int c()
  {
    if (this.jdField_a_of_type_AndroidViewViewGroup == null) {}
    do
    {
      return 0;
      if (this.jdField_d_of_type_AndroidWidgetRelativeLayout == null) {
        this.jdField_d_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365367));
      }
    } while (this.jdField_d_of_type_AndroidWidgetRelativeLayout == null);
    int i1 = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131559756);
    if (this.jdField_n_of_type_Boolean) {
      i1 += this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131559862) / 5 * this.v;
    }
    for (;;)
    {
      return i1;
      if (this.jdField_i_of_type_Boolean) {
        i1 += this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131559862);
      } else {
        i1 = 0;
      }
    }
  }
  
  public void c(int paramInt) {}
  
  public void c(String paramString) {}
  
  protected void c(boolean paramBoolean, int paramInt) {}
  
  public void c_(boolean paramBoolean) {}
  
  public int d()
  {
    int i2 = 0;
    if (this.jdField_a_of_type_AndroidViewViewGroup == null) {}
    do
    {
      return 0;
      if (this.jdField_c_of_type_AndroidWidgetRelativeLayout == null) {
        this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365390));
      }
    } while ((this.jdField_c_of_type_AndroidWidgetRelativeLayout == null) && (this.jdField_a_of_type_ComTencentAvUiQavPanel == null));
    int i1 = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131559757);
    if (this.jdField_n_of_type_Boolean) {
      if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null) {
        i1 = a();
      }
    }
    for (;;)
    {
      int i3 = i1 / 5 * this.v;
      i2 = i3;
      if (i3 > i1) {}
      for (;;)
      {
        i2 = i1;
        if (h()) {
          i2 = i1 + this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131559916);
        }
        return i2;
        if (this.jdField_c_of_type_AndroidWidgetRelativeLayout == null) {
          break label243;
        }
        i1 = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131559856);
        break;
        if (this.jdField_i_of_type_Boolean)
        {
          if ((this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) && (UITools.a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()) <= 320))
          {
            i1 = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131559858) + i1;
            continue;
          }
          if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)
          {
            i1 = a();
            continue;
          }
          if (this.jdField_c_of_type_AndroidWidgetRelativeLayout != null) {
            i1 = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131559856) + i1;
          }
        }
        else
        {
          i1 = a();
          continue;
        }
        i1 = i2;
      }
      label243:
      i1 = 0;
    }
  }
  
  public void d()
  {
    this.jdField_j_of_type_Int = 1;
    if ((Build.VERSION.SDK_INT >= 21) && (this.jdField_a_of_type_Kcs == null))
    {
      this.jdField_a_of_type_Kcs = new kcs(this);
      if (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null) {
        break label112;
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_c_of_type_JavaLangString, 2, "register camera availability change receiver");
      }
      this.jdField_a_of_type_AndroidContentContext = ((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getApplicationContext();
      localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("com.tencent.mobileqq.qav.camera.availability");
      if (this.jdField_a_of_type_AndroidContentContext != null) {
        this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_Kcs, localIntentFilter);
      }
    }
    label112:
    while (!QLog.isColorLevel())
    {
      IntentFilter localIntentFilter;
      return;
    }
    QLog.d(this.jdField_c_of_type_JavaLangString, 2, "CANNOT register camera availability change receiver!");
  }
  
  void d(int paramInt) {}
  
  public void d(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().h == 11) {
      if (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null) {
        this.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(43, true);
      }
    }
    while (this.jdField_a_of_type_ComTencentAvUtilsTipsManager == null) {
      return;
    }
    TipsManager.a(105, paramString);
    this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(105, paramString, true);
  }
  
  public void e(int paramInt)
  {
    this.w = paramInt;
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_c_of_type_JavaLangString, 2, "onDetectNoDevicePermission type ： " + paramInt);
    }
    this.jdField_f_of_type_JavaLangString = "";
    Object localObject = (AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    String str;
    if (paramInt == 1)
    {
      QLog.w(this.jdField_c_of_type_JavaLangString, 1, "请求相机权限.2");
      str = ((AVActivity)localObject).getString(2131429204);
      localObject = ((AVActivity)localObject).getString(2131429206);
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().j())
      {
        this.jdField_f_of_type_JavaLangString = "0X8004892";
        this.jdField_g_of_type_JavaLangString = "0X8004893";
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().i == 1)
        {
          this.jdField_f_of_type_JavaLangString = "0X8004898";
          this.jdField_g_of_type_JavaLangString = "0X8004899";
        }
      }
    }
    do
    {
      do
      {
        for (;;)
        {
          this.jdField_o_of_type_Boolean = true;
          ReportController.b(null, "CliOper", "", "", this.jdField_f_of_type_JavaLangString, this.jdField_f_of_type_JavaLangString, 0, 0, "", "", this.jdField_h_of_type_JavaLangString, "");
          b(str, (String)localObject);
          return;
          if (this.jdField_a_of_type_ComTencentAvVideoController.a().d == 2)
          {
            this.jdField_f_of_type_JavaLangString = "0X800488C";
            this.jdField_g_of_type_JavaLangString = "0X800488D";
          }
        }
        if (paramInt == 2)
        {
          QLog.w(this.jdField_c_of_type_JavaLangString, 1, "请求相机权限.3");
          str = ((AVActivity)localObject).getString(2131429204);
          localObject = ((AVActivity)localObject).getString(2131429206);
          if (this.jdField_a_of_type_ComTencentAvVideoController.a().j())
          {
            this.jdField_f_of_type_JavaLangString = "0X80049D3";
            if (this.jdField_a_of_type_ComTencentAvVideoController.a().i == 1) {
              this.jdField_f_of_type_JavaLangString = "0X80049D4";
            }
          }
          for (;;)
          {
            this.jdField_o_of_type_Boolean = false;
            break;
            if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int == 1) {
              this.jdField_f_of_type_JavaLangString = "0X80049D1";
            } else if (this.jdField_a_of_type_ComTencentAvVideoController.a().d == 2) {
              this.jdField_f_of_type_JavaLangString = "0X80049D2";
            }
          }
        }
        if (paramInt == 3)
        {
          str = ((AVActivity)localObject).getString(2131429205);
          localObject = ((AVActivity)localObject).getString(2131429207);
          if (this.jdField_a_of_type_ComTencentAvVideoController.a().j())
          {
            this.jdField_f_of_type_JavaLangString = "0X800488F";
            this.jdField_g_of_type_JavaLangString = "0X8004890";
            if (this.jdField_a_of_type_ComTencentAvVideoController.a().i == 1)
            {
              this.jdField_f_of_type_JavaLangString = "0X8004895";
              this.jdField_g_of_type_JavaLangString = "0X8004896";
            }
          }
          for (;;)
          {
            this.jdField_o_of_type_Boolean = true;
            break;
            if (this.jdField_a_of_type_ComTencentAvVideoController.a().d == 2)
            {
              this.jdField_f_of_type_JavaLangString = "0X8004889";
              this.jdField_g_of_type_JavaLangString = "0X800488A";
            }
            else if (this.jdField_a_of_type_ComTencentAvVideoController.a().d == 1)
            {
              this.jdField_f_of_type_JavaLangString = "0X8004885";
              this.jdField_g_of_type_JavaLangString = "0X8004886";
            }
          }
        }
        if ((paramInt == 4) && (localObject != null))
        {
          if (!this.jdField_a_of_type_ComTencentAvVideoController.h()) {
            this.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(26, true);
          }
          localObject = "";
          if (this.jdField_a_of_type_ComTencentAvVideoController.a().j())
          {
            localObject = "0X8004891";
            if (this.jdField_a_of_type_ComTencentAvVideoController.a().i == 1) {
              localObject = "0X8004897";
            }
          }
          for (;;)
          {
            ReportController.b(null, "CliOper", "", "", (String)localObject, (String)localObject, 0, 0, "", "", this.jdField_h_of_type_JavaLangString, "");
            return;
            if (this.jdField_a_of_type_ComTencentAvVideoController.a().d == 2) {
              localObject = "0X800488B";
            } else if (this.jdField_a_of_type_ComTencentAvVideoController.a().d == 1) {
              localObject = "0X8004887";
            }
          }
        }
      } while (paramInt != 2048);
      this.jdField_a_of_type_ComTencentAvVideoController.a().k = true;
      if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)
      {
        this.jdField_a_of_type_ComTencentAvUiQavPanel.b(2131365402, true);
        this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131365402, true);
      }
      localObject = (FrameLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365401);
    } while (localObject == null);
    ((FrameLayout)localObject).setClickable(true);
  }
  
  public abstract void e(String paramString);
  
  public void e(boolean paramBoolean) {}
  
  public void f()
  {
    this.jdField_j_of_type_Int = 2;
    if (this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar != null) {
      this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar.d();
    }
  }
  
  public abstract void f(String paramString);
  
  public void f(boolean paramBoolean) {}
  
  public boolean f()
  {
    if (this.jdField_a_of_type_ComTencentAvUiEffectSettingUi != null) {
      return this.jdField_a_of_type_ComTencentAvUiEffectSettingUi.isShown();
    }
    return false;
  }
  
  public void g()
  {
    this.jdField_j_of_type_Int = 3;
    if (this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar != null) {
      this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar.e();
    }
  }
  
  public abstract void g(int paramInt);
  
  public abstract void g(boolean paramBoolean);
  
  public boolean g()
  {
    if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null) {}
    for (Object localObject = this.jdField_a_of_type_ComTencentAvUiQavPanel; (this.jdField_d_of_type_AndroidWidgetRelativeLayout == null) || (this.jdField_d_of_type_AndroidWidgetRelativeLayout.getVisibility() != 0) || (localObject == null) || (((View)localObject).getVisibility() != 0); localObject = this.jdField_c_of_type_AndroidWidgetRelativeLayout) {
      return false;
    }
    return true;
  }
  
  public void h()
  {
    this.jdField_j_of_type_Int = 4;
    if (this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar != null) {
      this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar.f();
    }
  }
  
  public abstract void h(int paramInt);
  
  protected boolean h()
  {
    if (!Build.MANUFACTURER.equalsIgnoreCase("meizu")) {
      return false;
    }
    try
    {
      boolean bool = ((Boolean)Class.forName("android.os.Build").getMethod("hasSmartBar", new Class[0]).invoke(null, new Object[0])).booleanValue();
      return bool;
    }
    catch (Exception localException)
    {
      if (Build.DEVICE.equals("mx2")) {
        return true;
      }
      if ((Build.DEVICE.equals("mx")) || (Build.DEVICE.equals("m9"))) {
        return false;
      }
    }
    return false;
  }
  
  public void i() {}
  
  public void i(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentAvUiQavPanel != null) && (this.jdField_a_of_type_ComTencentAvUiQavPanel.isPressed())) {}
    label383:
    do
    {
      do
      {
        boolean bool2;
        do
        {
          do
          {
            do
            {
              return;
              if (this.jdField_a_of_type_ComTencentAvVideoController != null) {
                break;
              }
            } while (!QLog.isColorLevel());
            QLog.e(this.jdField_c_of_type_JavaLangString, 2, "switchToolBar-->mVideoController is null, Why???");
            return;
          } while (((this.jdField_a_of_type_ComTencentAvVideoController.a().i == 9500) && (this.jdField_a_of_type_ComTencentAvVideoController.s)) || (this.jdField_l_of_type_Boolean) || ((!this.jdField_a_of_type_ComTencentAvVideoController.a().f()) && (this.jdField_a_of_type_ComTencentAvVideoController.a().d == 2)));
          bool2 = this.jdField_i_of_type_Boolean;
          if (this.jdField_a_of_type_AndroidViewViewGroup != null) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.e(this.jdField_c_of_type_JavaLangString, 2, "switchToolBar-->mRootView is null Why");
        return;
        if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Boolean) || (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Boolean)) {
          break;
        }
        s(true);
        QLog.w(this.jdField_c_of_type_JavaLangString, 1, "switchToolBar, ToolbarDisplay[" + bool2 + "->" + this.jdField_i_of_type_Boolean + "], type[" + paramInt + "]");
        if (this.jdField_c_of_type_AndroidWidgetRelativeLayout == null) {
          this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365390));
        }
        if (this.jdField_d_of_type_AndroidWidgetRelativeLayout == null) {
          this.jdField_d_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365367));
        }
        SmallScreenUtils.a();
        if (!this.jdField_i_of_type_Boolean) {
          break label782;
        }
        if (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null) {
          this.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(false);
        }
        if (this.jdField_a_of_type_ComTencentAvUiQavPanel == null) {
          break label696;
        }
        if (QLog.isColorLevel()) {
          QLog.e(this.jdField_c_of_type_JavaLangString, 2, "WL_DEBUG switchToolBar mQavPanel.isShown()[" + this.jdField_a_of_type_ComTencentAvUiQavPanel.isShown() + "], mTopToolbar.isShown()[" + this.jdField_d_of_type_AndroidWidgetRelativeLayout.isShown() + "]");
        }
      } while ((this.jdField_a_of_type_ComTencentAvUiQavPanel.isShown()) && (this.jdField_d_of_type_AndroidWidgetRelativeLayout.isShown()));
      if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)
      {
        this.jdField_a_of_type_ComTencentAvUiQavPanel.setVisibility(0);
        this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        this.p += 1;
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_c_of_type_JavaLangString, 2, "WL_DEBUG switchToolBar type=" + paramInt + ", toolbarShowTimes: " + this.p);
        }
        if (paramInt != 1) {
          break label739;
        }
        this.jdField_a_of_type_AndroidViewAnimationAnimation = a(true);
        this.jdField_b_of_type_AndroidViewAnimationAnimation = a(true);
        if (this.jdField_a_of_type_Kcx == null) {
          this.jdField_a_of_type_Kcx = new kcx(this, 2);
        }
        if (this.jdField_b_of_type_Kcx == null) {
          this.jdField_b_of_type_Kcx = new kcx(this, 1);
        }
        this.jdField_a_of_type_AndroidViewAnimationAnimation.setAnimationListener(this.jdField_a_of_type_Kcx);
        this.jdField_b_of_type_AndroidViewAnimationAnimation.setAnimationListener(this.jdField_b_of_type_Kcx);
        if (VcSystemInfo.a()) {
          break label865;
        }
        if (this.jdField_a_of_type_ComTencentAvUiQavPanel == null) {
          break label851;
        }
        this.jdField_a_of_type_ComTencentAvUiQavPanel.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimation);
        if ((this.jdField_a_of_type_ComTencentAvVideoController.a() > 10L) || (this.p > 2)) {
          aj();
        }
      }
      for (;;)
      {
        this.jdField_d_of_type_AndroidWidgetRelativeLayout.startAnimation(this.jdField_b_of_type_AndroidViewAnimationAnimation);
        return;
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().d == 1)
        {
          s(true);
          break;
        }
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().d == 3)
        {
          s(true);
          break;
        }
        if (DoodleLogic.a().a.a)
        {
          s(true);
          break;
        }
        if (!this.jdField_i_of_type_Boolean) {}
        for (boolean bool1 = true;; bool1 = false)
        {
          s(bool1);
          break;
        }
        if ((!this.jdField_c_of_type_AndroidWidgetRelativeLayout.isShown()) || (!this.jdField_d_of_type_AndroidWidgetRelativeLayout.isShown())) {
          break label383;
        }
        QLog.e(this.jdField_c_of_type_JavaLangString, 2, "WL_DEBUG switchToolBar mQavPanel null");
        return;
        this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        break label398;
        this.jdField_a_of_type_AndroidViewAnimationAnimation = AnimationUtils.loadAnimation((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), 2131034230);
        this.jdField_b_of_type_AndroidViewAnimationAnimation = AnimationUtils.loadAnimation((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), 2131034267);
        break label486;
        if (paramInt == 1)
        {
          this.jdField_a_of_type_AndroidViewAnimationAnimation = a(false);
          this.jdField_b_of_type_AndroidViewAnimationAnimation = a(false);
          break label486;
        }
        this.jdField_a_of_type_AndroidViewAnimationAnimation = AnimationUtils.loadAnimation((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), 2131034229);
        this.jdField_b_of_type_AndroidViewAnimationAnimation = AnimationUtils.loadAnimation((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), 2131034266);
        break label486;
        this.jdField_c_of_type_AndroidWidgetRelativeLayout.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimation);
      }
      if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(118), Boolean.valueOf(this.jdField_i_of_type_Boolean), Boolean.valueOf(true), Long.valueOf(0L) });
      }
      if (this.jdField_a_of_type_Kcx != null) {
        this.jdField_a_of_type_Kcx.onAnimationEnd(null);
      }
    } while (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null);
    label398:
    label486:
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(118), Boolean.valueOf(this.jdField_i_of_type_Boolean), Boolean.valueOf(false), Long.valueOf(0L) });
    label696:
    label739:
    return;
  }
  
  @TargetApi(16)
  public boolean i()
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)
    {
      Context localContext = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (Build.VERSION.SDK_INT >= 16) {
        try
        {
          KeyguardManager localKeyguardManager = (KeyguardManager)localContext.getSystemService("keyguard");
          if (QLog.isColorLevel()) {
            QLog.e(this.jdField_c_of_type_JavaLangString, 2, "isKeyguardLocked = " + localKeyguardManager.isKeyguardLocked() + ". isKeyguardSecure =" + localKeyguardManager.isKeyguardSecure());
          }
          if ((localKeyguardManager != null) && (localKeyguardManager.isKeyguardLocked()))
          {
            boolean bool = localKeyguardManager.isKeyguardSecure();
            if (bool) {
              return true;
            }
          }
          return false;
        }
        catch (SecurityException localSecurityException)
        {
          if (QLog.isColorLevel()) {
            QLog.e(this.jdField_c_of_type_JavaLangString, 2, "isKeyguardLocked() = " + localSecurityException);
          }
          return QQUtils.a(localContext);
        }
      }
      return QQUtils.a(localContext);
    }
    return true;
  }
  
  public void j()
  {
    this.jdField_j_of_type_Int = 5;
    aa();
    if (this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar != null) {
      this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar.g();
    }
    if (this.jdField_a_of_type_ComTencentAvUtilsSensorHelper != null) {
      this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.b(false);
    }
  }
  
  boolean j()
  {
    if (this.jdField_a_of_type_ComTencentAvUiEffectSettingUi != null) {
      return this.jdField_a_of_type_ComTencentAvUiEffectSettingUi.isShown();
    }
    return false;
  }
  
  public void k()
  {
    this.jdField_j_of_type_Int = 6;
    aa();
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_Kcy);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_j_of_type_JavaLangRunnable);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_h_of_type_JavaLangRunnable);
      if (this.jdField_a_of_type_Kcv != null)
      {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_Kcv);
        this.jdField_a_of_type_Kcv = null;
      }
    }
    if (this.jdField_a_of_type_ComTencentAvUtilsSensorHelper != null) {
      this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.a(false);
    }
    if ((Build.VERSION.SDK_INT >= 21) && (this.jdField_a_of_type_Kcs != null))
    {
      if (this.jdField_a_of_type_AndroidContentContext == null) {
        break label469;
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_c_of_type_JavaLangString, 2, "UnRegister camera availability change receiver");
      }
      this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_Kcs);
      this.jdField_a_of_type_Kcs = null;
      this.jdField_a_of_type_AndroidContentContext = null;
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentAvUiEffectSettingUi != null)
      {
        this.jdField_a_of_type_ComTencentAvUiEffectSettingUi.g();
        this.jdField_a_of_type_ComTencentAvUiEffectSettingUi = null;
      }
      if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)
      {
        this.jdField_a_of_type_ComTencentAvUiQavPanel.h();
        this.jdField_a_of_type_ComTencentAvUiQavPanel = null;
      }
      this.jdField_a_of_type_AndroidContentResResources = null;
      this.jdField_a_of_type_JavaLangRefWeakReference = null;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
      this.jdField_a_of_type_ComTencentAvVideoController = null;
      if (this.jdField_a_of_type_AndroidViewViewGroup != null)
      {
        this.jdField_a_of_type_AndroidViewViewGroup.removeAllViews();
        this.jdField_a_of_type_AndroidViewViewGroup = null;
      }
      this.jdField_a_of_type_AndroidViewOrientationEventListener = null;
      this.jdField_a_of_type_ComTencentAvUtilsQQFrameByFrameAnimation = null;
      this.jdField_g_of_type_AndroidWidgetTextView = null;
      this.jdField_a_of_type_ComTencentAvUtilsTipsManager = null;
      this.jdField_c_of_type_AndroidWidgetButton = null;
      this.jdField_d_of_type_AndroidWidgetButton = null;
      this.jdField_b_of_type_AndroidWidgetButton = null;
      this.jdField_b_of_type_AndroidWidgetLinearLayout = null;
      this.jdField_a_of_type_AndroidViewAnimationAnimation = null;
      this.jdField_b_of_type_AndroidViewAnimationAnimation = null;
      this.jdField_a_of_type_AndroidWidgetToast = null;
      this.jdField_c_of_type_AndroidWidgetRelativeLayout = null;
      this.jdField_d_of_type_AndroidWidgetRelativeLayout = null;
      this.jdField_a_of_type_Kcx = null;
      this.jdField_b_of_type_Kcx = null;
      this.jdField_b_of_type_AndroidWidgetImageView = null;
      this.jdField_c_of_type_AndroidViewView = null;
      this.jdField_h_of_type_JavaLangRunnable = null;
      this.jdField_b_of_type_ComTencentAvUiControlUIObserver = null;
      this.jdField_h_of_type_AndroidWidgetTextView = null;
      this.jdField_i_of_type_AndroidWidgetTextView = null;
      this.jdField_e_of_type_AndroidWidgetButton = null;
      this.jdField_f_of_type_AndroidWidgetButton = null;
      this.jdField_g_of_type_AndroidWidgetButton = null;
      this.jdField_b_of_type_AndroidWidgetImageButton = null;
      this.jdField_b_of_type_AndroidViewViewGroup = null;
      this.jdField_a_of_type_AndroidWidgetFrameLayout = null;
      this.jdField_c_of_type_AndroidWidgetFrameLayout = null;
      this.jdField_b_of_type_AndroidWidgetFrameLayout = null;
      this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation = null;
      this.jdField_c_of_type_AndroidViewAnimationAnimation = null;
      this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation = null;
      this.jdField_c_of_type_AndroidViewAnimationTranslateAnimation = null;
      this.jdField_d_of_type_AndroidViewAnimationTranslateAnimation = null;
      this.jdField_e_of_type_AndroidViewAnimationTranslateAnimation = null;
      this.jdField_a_of_type_ComTencentAvUtilsRingAnimator = null;
      this.jdField_a_of_type_ComTencentAvUtilsQQAnimationListener = null;
      this.jdField_b_of_type_AndroidViewAnimationAnimation$AnimationListener = null;
      this.jdField_a_of_type_ComTencentAvUtilsSensorHelper = null;
      if (this.jdField_a_of_type_ComTencentAvUtilsTraeHelper != null) {
        this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.a(false);
      }
      this.jdField_a_of_type_ComTencentAvUtilsTraeHelper = null;
      if (this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar != null)
      {
        this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar.c();
        this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar = null;
      }
      return;
      label469:
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_c_of_type_JavaLangString, 2, "CANNOT UnRegister camera availability change receiver!!");
      }
    }
  }
  
  public void k(int paramInt) {}
  
  public void k(String paramString) {}
  
  protected boolean k()
  {
    boolean bool3 = false;
    boolean bool2 = bool3;
    Object localObject;
    if (this.jdField_a_of_type_ComTencentAvVideoController != null)
    {
      localObject = this.jdField_a_of_type_ComTencentAvVideoController.a();
      if (localObject == null) {
        break label91;
      }
    }
    label91:
    for (boolean bool1 = ((SessionInfo)localObject).z;; bool1 = false)
    {
      localObject = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if ((localObject instanceof AVActivity))
      {
        localObject = ((AVActivity)localObject).jdField_a_of_type_ComTencentAvUiVideoLayerUI;
        if (localObject == null) {}
      }
      for (bool2 = ((VideoLayerUI)localObject).d();; bool2 = false)
      {
        if (!bool2)
        {
          bool2 = bool3;
          if (bool1) {}
        }
        else
        {
          bool2 = true;
        }
        return bool2;
      }
    }
  }
  
  public void l() {}
  
  public void l(int paramInt) {}
  
  public void l(String paramString) {}
  
  public void l(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvUiQavPanel == null) {}
    label198:
    label217:
    label355:
    for (;;)
    {
      return;
      boolean bool1;
      Object localObject;
      if ((this.jdField_a_of_type_ComTencentAvVideoController.a().d == 2) || (this.jdField_a_of_type_ComTencentAvVideoController.a().d == 4))
      {
        bool1 = true;
        boolean bool2 = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Boolean;
        AVLog.a(this.jdField_c_of_type_JavaLangString, "updateEffectBtn isVideo=" + bool1 + ", local hasvideo=" + bool2);
        if (!paramBoolean) {
          break label338;
        }
        VoiceChangeDataReport.a(this.jdField_a_of_type_ComTencentAvVideoController.a());
        this.u = 1;
        if ((bool1) && (bool2)) {
          this.u = 2;
        }
        localObject = this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131365408);
        if ((localObject == null) || (!(localObject instanceof Button))) {
          continue;
        }
        localObject = (Button)localObject;
        ((Button)localObject).setTag(2131362547, Integer.valueOf(this.u));
        if (this.u != 2) {
          break label269;
        }
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().d != 2) {
          break label258;
        }
        ((Button)localObject).setText(2131428731);
        ((Button)localObject).setContentDescription(((Button)localObject).getContext().getResources().getText(2131428734));
        this.jdField_a_of_type_ComTencentAvUiQavPanel.a(this.u, bool1);
        c(bool1, this.u);
      }
      for (;;)
      {
        if (this.jdField_a_of_type_ComTencentAvUtilsTraeHelper == null) {
          break label355;
        }
        this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.a();
        return;
        bool1 = false;
        break;
        ((Button)localObject).setText(2131428732);
        break label198;
        int i1 = this.jdField_a_of_type_ComTencentAvVideoController.a().S;
        this.jdField_a_of_type_ComTencentAvUiQavPanel.setEffectDrawable(VoiceChangeData.a().a(i1, ((Button)localObject).getResources(), new kcp(this, paramBoolean)));
        ((Button)localObject).setText(2131428733);
        ((Button)localObject).setContentDescription(((Button)localObject).getContext().getResources().getText(2131428733));
        break label217;
        if (!(this instanceof DoubleVideoCtrlUI)) {
          this.jdField_a_of_type_ComTencentAvUiQavPanel.a(0, bool1);
        }
      }
    }
  }
  
  protected boolean l()
  {
    boolean bool = false;
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
      bool = RedBagUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface).a();
    }
    return bool;
  }
  
  public void m()
  {
    if (this.jdField_a_of_type_ComTencentAvUtilsSensorHelper != null) {
      this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.a();
    }
  }
  
  public void m(String paramString)
  {
    QLog.w(this.jdField_c_of_type_JavaLangString, 1, "hideToolBar[" + paramString + "], isToolBarDisplay[" + g() + "], mToolbarDisplay[" + this.jdField_i_of_type_Boolean + "]");
    if (this.jdField_i_of_type_Boolean) {
      i(0);
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_j_of_type_JavaLangRunnable);
  }
  
  void m(boolean paramBoolean)
  {
    if (this.jdField_i_of_type_JavaLangRunnable == null) {
      this.jdField_i_of_type_JavaLangRunnable = new kcu(this);
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().post(this.jdField_i_of_type_JavaLangRunnable);
      return;
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_i_of_type_JavaLangRunnable);
  }
  
  public void n(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar != null) {
      this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar.b(paramBoolean);
    }
  }
  
  public void o() {}
  
  public void o(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar != null) {
      this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar.c(paramBoolean);
    }
  }
  
  public void p() {}
  
  public void p(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar != null) {
      this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar.a(paramBoolean);
    }
  }
  
  public void q() {}
  
  public void q(int paramInt)
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)
    {
      Activity localActivity = (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localActivity != null) {
        localActivity.getLayoutInflater().inflate(paramInt, this.jdField_a_of_type_AndroidViewViewGroup);
      }
    }
  }
  
  public void q(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar != null) {
      this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar.d(paramBoolean);
    }
  }
  
  public void r() {}
  
  void r(int paramInt)
  {
    int i1 = 2131429074;
    switch (paramInt)
    {
    default: 
      i1 = 2131429078;
    case 12: 
    case 43: 
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().i == 1011) {
        if (paramInt != 9) {
          break label182;
        }
      }
      break;
    }
    label182:
    for (i1 = 2131428688;; i1 = 2131429073)
    {
      d(i1);
      return;
      i1 = 2131428851;
      break;
      i1 = 2131429075;
      break;
      i1 = 2131429080;
      break;
      i1 = 2131429077;
      break;
      i1 = 2131429079;
      break;
      i1 = 2131429078;
      break;
    }
  }
  
  public void r(boolean paramBoolean)
  {
    a(g(), paramBoolean);
  }
  
  void s() {}
  
  void s(int paramInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)
            {
              this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131365402, this.jdField_a_of_type_AndroidContentResResources.getString(2131428902));
              this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131365402, true);
              return;
            }
          } while (this.jdField_d_of_type_AndroidWidgetButton == null);
          UITools.a(this.jdField_d_of_type_AndroidWidgetButton, this.jdField_a_of_type_AndroidContentResResources.getString(2131428902));
          this.jdField_d_of_type_AndroidWidgetButton.setSelected(true);
          return;
          if (this.jdField_a_of_type_ComTencentAvUiQavPanel == null) {
            break;
          }
          this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131365404, this.jdField_a_of_type_AndroidContentResResources.getString(2131428881));
          this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131365404, true);
        } while (VcSystemInfo.b());
        this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131365404, false);
        return;
      } while (this.jdField_b_of_type_AndroidWidgetButton == null);
      UITools.a(this.jdField_b_of_type_AndroidWidgetButton, this.jdField_a_of_type_AndroidContentResResources.getString(2131428881));
      this.jdField_b_of_type_AndroidWidgetButton.setSelected(true);
    } while (VcSystemInfo.b());
    this.jdField_b_of_type_AndroidWidgetButton.setEnabled(false);
  }
  
  public void s(boolean paramBoolean)
  {
    if (this.jdField_i_of_type_Boolean != paramBoolean)
    {
      this.jdField_i_of_type_Boolean = paramBoolean;
      a(170, Boolean.valueOf(this.jdField_i_of_type_Boolean));
    }
  }
  
  public void t() {}
  
  public void t(int paramInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)
            {
              this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131365402, this.jdField_a_of_type_AndroidContentResResources.getString(2131428901));
              this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131365402, false);
              return;
            }
          } while (this.jdField_d_of_type_AndroidWidgetButton == null);
          UITools.a(this.jdField_d_of_type_AndroidWidgetButton, this.jdField_a_of_type_AndroidContentResResources.getString(2131428901));
          this.jdField_d_of_type_AndroidWidgetButton.setSelected(false);
          return;
          if (this.jdField_a_of_type_ComTencentAvUiQavPanel == null) {
            break;
          }
          this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131365404, this.jdField_a_of_type_AndroidContentResResources.getString(2131428880));
          this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131365404, false);
        } while (VcSystemInfo.b());
        this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131365404, false);
        return;
      } while (this.jdField_b_of_type_AndroidWidgetButton == null);
      UITools.a(this.jdField_b_of_type_AndroidWidgetButton, this.jdField_a_of_type_AndroidContentResResources.getString(2131428880));
      this.jdField_b_of_type_AndroidWidgetButton.setSelected(false);
    } while (VcSystemInfo.b());
    this.jdField_b_of_type_AndroidWidgetButton.setEnabled(false);
  }
  
  public void u() {}
  
  public void u(int paramInt)
  {
    this.jdField_n_of_type_Int = paramInt;
  }
  
  public abstract void v();
  
  public void v(int paramInt)
  {
    Object localObject = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if ((localObject != null) && (this.jdField_a_of_type_ComTencentAvUiEffectSettingUi == null) && ((localObject instanceof AVActivity)))
    {
      AVActivity localAVActivity = (AVActivity)localObject;
      RelativeLayout localRelativeLayout = (RelativeLayout)localAVActivity.findViewById(2131365390);
      if (localRelativeLayout != null)
      {
        this.jdField_a_of_type_ComTencentAvUiEffectSettingUi = new EffectSettingUi(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, localAVActivity);
        this.jdField_a_of_type_ComTencentAvUiEffectSettingUi.setVisibility(8);
        float f1 = ((Context)localObject).getResources().getDimension(2131560000);
        localObject = new RelativeLayout.LayoutParams(-1, -1);
        ((RelativeLayout.LayoutParams)localObject).addRule(12, -1);
        ((RelativeLayout.LayoutParams)localObject).setMargins(0, (int)f1, 0, 0);
        localRelativeLayout.addView(this.jdField_a_of_type_ComTencentAvUiEffectSettingUi, (ViewGroup.LayoutParams)localObject);
        this.jdField_a_of_type_ComTencentAvUiEffectSettingUi.a();
      }
    }
    if (this.jdField_a_of_type_ComTencentAvUiEffectSettingUi != null) {
      this.jdField_a_of_type_ComTencentAvUiEffectSettingUi.b(paramInt);
    }
  }
  
  public void z()
  {
    String str;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      str = this.jdField_c_of_type_JavaLangString;
      localStringBuilder = new StringBuilder().append("displayToolBar, mApp[");
      if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {
        break label61;
      }
    }
    label61:
    for (boolean bool = true;; bool = false)
    {
      QLog.d(str, 2, bool + "]");
      if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
        break;
      }
      return;
    }
    if (!g())
    {
      s(false);
      i(0);
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_j_of_type_JavaLangRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.av.ui.VideoControlUI
 * JD-Core Version:    0.7.0.1
 */