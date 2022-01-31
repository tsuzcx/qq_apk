package com.tencent.av.ui;

import actj;
import amkf;
import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewStub;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.Toast;
import apvd;
import axqy;
import bbea;
import bbkb;
import bbzh;
import bbzn;
import bcuc;
import bfpc;
import bkvi;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.magicface.FaceItem;
import com.tencent.av.business.manager.voiceRecog.VoiceRecogTips;
import com.tencent.av.camera.CameraUtils;
import com.tencent.av.opengl.GraphicRenderMgr;
import com.tencent.av.report.AVReport;
import com.tencent.av.ui.funchat.filter.EffectFilterPanel;
import com.tencent.av.ui.funchat.record.QavRecordButtonView;
import com.tencent.av.ui.guide.GuideHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mfsdk.LeakInspector.LeakInspector;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.debug.PstnCardTestActivity;
import com.tencent.mobileqq.mqsafeedit.MD5;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.vipav.VipFullScreenVideoView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.File;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import lcg;
import lcx;
import lde;
import lfb;
import lga;
import lgb;
import lgg;
import lhr;
import lil;
import liu;
import liw;
import ljt;
import lkb;
import lko;
import lkw;
import llz;
import lon;
import lpu;
import ltm;
import ltn;
import lvv;
import lvz;
import lyw;
import lze;
import mao;
import mav;
import maw;
import may;
import maz;
import mba;
import mbb;
import mbc;
import mbd;
import mbe;
import mbf;
import mbh;
import mbk;
import mbl;
import mby;
import mcd;
import mcf;
import mcj;
import mck;
import mee;
import mha;
import min;
import mll;
import mmk;
import mmp;
import mnp;
import moz;
import mpv;
import mqq.app.BaseActivity;
import mqq.app.MobileQQ;
import mqu;
import mqw;
import msn;
import mso;
import msp;
import muc;
import zzp;

public class AVActivity
  extends BaseActivity
  implements SensorEventListener, ljt, ltn
{
  public int a;
  long jdField_a_of_type_Long = 0L;
  Dialog jdField_a_of_type_AndroidAppDialog = null;
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = null;
  public Bitmap a;
  private Sensor jdField_a_of_type_AndroidHardwareSensor;
  private SensorManager jdField_a_of_type_AndroidHardwareSensorManager;
  Handler jdField_a_of_type_AndroidOsHandler = new mbb(this);
  private MessageQueue.IdleHandler jdField_a_of_type_AndroidOsMessageQueue$IdleHandler = new mav(this);
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = null;
  public RelativeLayout a;
  public bbzn a;
  public VideoController a;
  public VideoAppInterface a;
  public CameraUtils a;
  private AVActivity.AnimationTrigger jdField_a_of_type_ComTencentAvUiAVActivity$AnimationTrigger;
  public VideoControlUI a;
  public VideoLayerUI a;
  public EffectFilterPanel a;
  public QavRecordButtonView a;
  public GuideHelper a;
  private URLDrawable jdField_a_of_type_ComTencentImageURLDrawable;
  public RedTouch a;
  public VipFullScreenVideoView a;
  public Runnable a;
  public String a;
  public WeakReference<Activity> a;
  lfb jdField_a_of_type_Lfb = new mbd(this);
  lgg jdField_a_of_type_Lgg = new mbk(this);
  lkb jdField_a_of_type_Lkb = new mbe(this);
  private lkw jdField_a_of_type_Lkw = new lkw();
  private lyw jdField_a_of_type_Lyw;
  mbl jdField_a_of_type_Mbl = null;
  public mby a;
  private mcd jdField_a_of_type_Mcd;
  public mcf a;
  public mha a;
  public min a;
  public mll a;
  public mmk a;
  private mso jdField_a_of_type_Mso;
  msp jdField_a_of_type_Msp = null;
  boolean jdField_a_of_type_Boolean = false;
  byte[] jdField_a_of_type_ArrayOfByte = null;
  public int b;
  long jdField_b_of_type_Long = 0L;
  public Bitmap b;
  Runnable jdField_b_of_type_JavaLangRunnable = new AVActivity.3(this);
  public final String b;
  boolean jdField_b_of_type_Boolean = true;
  int jdField_c_of_type_Int = 0;
  public String c;
  boolean jdField_c_of_type_Boolean = false;
  public int d;
  public String d;
  boolean d;
  public int e;
  String e;
  public boolean e;
  int jdField_f_of_type_Int = 0;
  String jdField_f_of_type_JavaLangString = null;
  public boolean f;
  int jdField_g_of_type_Int = 0;
  String jdField_g_of_type_JavaLangString = null;
  public boolean g;
  public int h;
  String h;
  public boolean h;
  public String i;
  public boolean i;
  String jdField_j_of_type_JavaLangString = null;
  boolean jdField_j_of_type_Boolean = true;
  public String k;
  boolean k;
  String jdField_l_of_type_JavaLangString = null;
  boolean jdField_l_of_type_Boolean = false;
  public String m;
  boolean m;
  private boolean n;
  private boolean o;
  
  public AVActivity()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_d_of_type_Int = -1;
    this.jdField_e_of_type_Int = 0;
    this.jdField_c_of_type_JavaLangString = null;
    this.jdField_d_of_type_JavaLangString = null;
    this.jdField_e_of_type_JavaLangString = null;
    this.jdField_h_of_type_JavaLangString = null;
    this.jdField_i_of_type_JavaLangString = null;
    this.jdField_k_of_type_JavaLangString = null;
    this.jdField_m_of_type_JavaLangString = null;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_f_of_type_Boolean = false;
    this.jdField_g_of_type_Boolean = false;
    this.jdField_h_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangRunnable = null;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
    this.jdField_a_of_type_ComTencentAvVideoController = null;
    this.jdField_a_of_type_Mll = null;
    this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    this.jdField_b_of_type_AndroidGraphicsBitmap = null;
    this.jdField_h_of_type_Int = 0;
    this.jdField_a_of_type_Mcf = new mbh(this);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(this);
    this.jdField_a_of_type_ComTencentAvUiGuideGuideHelper = new GuideHelper();
    this.jdField_a_of_type_Bbzn = new maw(this);
    this.jdField_k_of_type_Boolean = false;
    this.jdField_m_of_type_Boolean = false;
    this.mIsShadow = false;
    this.jdField_b_of_type_JavaLangString = ("AVActivity_" + AudioHelper.b());
  }
  
  private String a(Intent paramIntent)
  {
    int i3 = paramIntent.getIntExtra("uinType", -1);
    int i2 = muc.b(i3);
    int i1 = i2;
    if (i2 == 0) {
      i1 = 3;
    }
    String str;
    if (i3 == 1006)
    {
      str = paramIntent.getStringExtra("toMobile");
      if (!paramIntent.getBooleanExtra("isDoubleVideoMeeting", false)) {
        break label166;
      }
      i1 = 100;
    }
    label166:
    for (paramIntent = paramIntent.getStringExtra("GroupId");; paramIntent = str)
    {
      if ((i3 == -1) || (TextUtils.isEmpty(paramIntent)))
      {
        if (QLog.isColorLevel()) {
          QLog.e(this.jdField_b_of_type_JavaLangString, 2, "genSessionIdFromIntent error: uinType " + i3 + ", relationId " + paramIntent);
        }
        return null;
        if ((i1 == 1) || (i1 == 2))
        {
          str = paramIntent.getStringExtra("GroupId");
          break;
        }
        str = paramIntent.getStringExtra("uin");
        break;
      }
      return lcx.a(i1, paramIntent, new int[0]);
    }
  }
  
  public static void a(Window paramWindow)
  {
    try
    {
      paramWindow.addFlags(WindowManager.LayoutParams.class.getField("FLAG_NEEDS_MENU_KEY").getInt(null));
      return;
    }
    catch (IllegalAccessException paramWindow)
    {
      while (!QLog.isDevelopLevel()) {}
      QLog.d("set_FLAG_NEEDS_MENU_KEY", 2, "Could not access FLAG_NEEDS_MENU_KEY", paramWindow);
      return;
    }
    catch (NoSuchFieldException paramWindow) {}
  }
  
  static boolean a(Activity paramActivity)
  {
    bkvi.a(paramActivity);
    if (bkvi.b())
    {
      int i1 = bkvi.b(paramActivity);
      int i2 = ImmersiveUtils.getStatusBarHeight(paramActivity);
      QLog.w(ImmersiveUtils.jdField_a_of_type_JavaLangString, 1, "initLiuHaiProperty, onAttachedToWindow, notchheight[" + i1 + "], statusBarHeight[" + i2 + "]");
      if (bkvi.c(paramActivity))
      {
        if (QLog.isDevelopLevel()) {
          QLog.w(ImmersiveUtils.jdField_a_of_type_JavaLangString, 1, "initLiuHaiProperty, onAttachedToWindow, enableNotch");
        }
        return true;
      }
      if (("" + Build.MANUFACTURER).equalsIgnoreCase("Lenovo")) {
        VideoControlUI.n = true;
      }
    }
    return false;
  }
  
  private boolean a(Intent paramIntent)
  {
    paramIntent = paramIntent.getStringExtra("Fromwhere");
    return (paramIntent != null) && (paramIntent.compareTo("AVNotification") == 0);
  }
  
  public static boolean a(Window paramWindow, boolean paramBoolean)
  {
    boolean bool = false;
    int i1 = ImmersiveUtils.isSupporImmersive();
    if (i1 == 1) {
      if (paramBoolean)
      {
        int i2 = paramWindow.getDecorView().getSystemUiVisibility();
        paramWindow.getDecorView().setSystemUiVisibility(i2 | 0x100 | 0x400);
        if (Build.VERSION.SDK_INT >= 21)
        {
          paramWindow.addFlags(-2147483648);
          paramWindow.clearFlags(67108864);
          paramWindow.setStatusBarColor(0);
          paramBoolean = true;
        }
      }
    }
    for (;;)
    {
      if (QLog.isDevelopLevel()) {
        QLog.w(ImmersiveUtils.jdField_a_of_type_JavaLangString, 1, "setImmersive, result[" + paramBoolean + "], isSupporImmersive[" + i1 + "], SystemUiVisibility[0x" + Integer.toHexString(paramWindow.getDecorView().getSystemUiVisibility()) + "], flags[0x" + Integer.toHexString(paramWindow.getAttributes().flags) + "]");
      }
      return paramBoolean;
      if (Build.VERSION.SDK_INT < 19) {
        break;
      }
      paramWindow.addFlags(67108864);
      break;
      paramWindow.clearFlags(67108864);
      break;
      paramBoolean = bool;
      if (AudioHelper.a(25) == 1)
      {
        AudioHelper.a("使用了index_disable_immersive");
        paramBoolean = bool;
      }
    }
  }
  
  private void c(String paramString)
  {
    if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (AudioHelper.jdField_b_of_type_Boolean)) {
      this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_b_of_type_JavaLangString = paramString;
    }
  }
  
  private void h(long paramLong)
  {
    if (isDestroyed()) {}
    label7:
    do
    {
      do
      {
        lga locallga;
        do
        {
          int i1;
          do
          {
            do
            {
              break label7;
              break label7;
              break label7;
              do
              {
                return;
              } while ((this.jdField_a_of_type_ComTencentAvUiVideoControlUI == null) || (this.jdField_a_of_type_ComTencentAvUiVideoControlUI.g()));
              locallga = this.jdField_a_of_type_ComTencentAvVideoController.a();
              i1 = locallga.jdField_d_of_type_Int;
              if (QLog.isDevelopLevel()) {
                QLog.w(this.jdField_b_of_type_JavaLangString, 1, "SwitchToolbar, sessionType[" + i1 + "], isInviting[" + locallga.f() + "], isToolBarDisplay[" + this.jdField_a_of_type_ComTencentAvUiVideoControlUI.h() + "|" + this.jdField_a_of_type_ComTencentAvUiVideoControlUI.jdField_h_of_type_Boolean + "], seq[" + paramLong + "]");
              }
              if ((i1 != 1) && (i1 != 3)) {
                break;
              }
            } while ((!this.jdField_a_of_type_ComTencentAvUiVideoControlUI.a.b(1)) && (!this.jdField_a_of_type_ComTencentAvUiVideoControlUI.a.b(3)));
            this.jdField_a_of_type_ComTencentAvUiVideoControlUI.a.a(paramLong, 0, true);
            return;
            if (!locallga.f()) {
              break;
            }
          } while ((i1 != 2) || ((!this.jdField_a_of_type_ComTencentAvUiVideoControlUI.a.b(1)) && (!this.jdField_a_of_type_ComTencentAvUiVideoControlUI.a.b(3))));
          this.jdField_a_of_type_ComTencentAvUiVideoControlUI.a.a(paramLong, 0, true);
          return;
        } while ((this.jdField_a_of_type_Mby != null) && (this.jdField_a_of_type_Mby.a()));
        if ((!locallga.jdField_A_of_type_Boolean) || (this.jdField_a_of_type_ComTencentAvUiVideoControlUI.h())) {
          break;
        }
      } while (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null);
      mao.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1022, 2131696054);
      return;
      if (!a())
      {
        if ((!this.jdField_a_of_type_ComTencentAvUiVideoControlUI.h()) && ((this.jdField_a_of_type_ComTencentAvUiVideoControlUI.a.b(1)) || (this.jdField_a_of_type_ComTencentAvUiVideoControlUI.a.b(3)))) {
          this.jdField_a_of_type_ComTencentAvUiVideoControlUI.a.a(paramLong, 0, false);
        }
        b(paramLong, "SwitchToolbar", this.jdField_a_of_type_ComTencentAvUiVideoControlUI.h());
        this.jdField_a_of_type_ComTencentAvUiVideoControlUI.c(0);
        return;
      }
    } while (this.jdField_a_of_type_ComTencentAvUiVideoControlUI.h());
    b(paramLong, "SwitchToolbar2", this.jdField_a_of_type_ComTencentAvUiVideoControlUI.h());
    this.jdField_a_of_type_ComTencentAvUiVideoControlUI.c(0);
  }
  
  private void i(long paramLong)
  {
    if (this.o) {}
    do
    {
      return;
      this.o = true;
    } while (this.jdField_a_of_type_ComTencentAvUiVideoControlUI == null);
    this.jdField_a_of_type_ComTencentAvUiVideoControlUI.c(paramLong);
  }
  
  private void j()
  {
    if (this.jdField_b_of_type_AndroidGraphicsBitmap == null) {
      this.jdField_b_of_type_AndroidGraphicsBitmap = muc.a(getApplicationContext(), 2130841451);
    }
  }
  
  private void k()
  {
    View localView = findViewById(2131372517);
    if ((localView != null) && (this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch == null) && (!isDestroyed())) {
      runOnUiThread(new AVActivity.9(this, localView));
    }
  }
  
  private void l()
  {
    if (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) {}
    do
    {
      return;
      View localView = super.findViewById(2131362929);
      this.jdField_a_of_type_ComTencentAvUiVideoLayerUI = new VideoLayerUI(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this, localView);
      this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(a());
      this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(new mbc(this));
    } while (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI == null);
    this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(this.jdField_a_of_type_Min);
  }
  
  public void BtnOnClick(View paramView)
  {
    long l1 = AudioHelper.b();
    QLog.d(this.jdField_b_of_type_JavaLangString, 1, "BtnOnClick, id[" + mee.a(paramView.getId()) + "], nfonWindowFocus[" + this.jdField_j_of_type_Boolean + "], seq[" + l1 + "]");
    if (!this.jdField_j_of_type_Boolean) {}
    for (;;)
    {
      return;
      if ((this.jdField_a_of_type_Mby != null) && (this.jdField_a_of_type_Mby.a())) {
        this.jdField_a_of_type_Mby.a(paramView);
      }
      while ((paramView.getId() == 2131372517) && (this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch != null))
      {
        lvv.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch, 1);
        this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = null;
        return;
        if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI != null)
        {
          this.jdField_a_of_type_ComTencentAvUiVideoControlUI.z(l1);
          mqw.c(paramView.getId());
          this.jdField_a_of_type_ComTencentAvUiVideoControlUI.a(l1, paramView);
          e(l1);
        }
      }
    }
  }
  
  public void TestMenuBtnOnClick(View paramView)
  {
    paramView = new PopupMenu(this, paramView);
    mpv.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface).a(paramView);
    if (AudioHelper.d()) {}
    try
    {
      PstnCardTestActivity.addMenuInVideoView(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramView);
      label35:
      paramView.show();
      return;
    }
    catch (Exception localException)
    {
      break label35;
    }
  }
  
  int a()
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {
      return 0;
    }
    SharedPreferences localSharedPreferences = bbkb.a(getApplicationContext());
    String str = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
    return localSharedPreferences.getInt("showRecordTip" + String.valueOf(str), 0);
  }
  
  View a(long paramLong)
  {
    if ((this.jdField_a_of_type_Mso == null) || (!this.n))
    {
      if (QLog.isDevelopLevel()) {
        QLog.w(this.jdField_b_of_type_JavaLangString, 1, "qav_UserGuide_for_more.init, 没有tips需要显示或者已经显示过, seq[" + paramLong + "]");
      }
      return null;
    }
    if (!this.jdField_a_of_type_ComTencentAvUiVideoControlUI.h())
    {
      if (QLog.isDevelopLevel()) {
        QLog.w(this.jdField_b_of_type_JavaLangString, 1, "qav_UserGuide_for_more.init, 工具栏没显示, seq[" + paramLong + "]");
      }
      return null;
    }
    Object localObject = findViewById(2131372517);
    if (localObject == null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.w(this.jdField_b_of_type_JavaLangString, 1, "qav_UserGuide_for_more.init, !MORE, seq[" + paramLong + "]");
      }
      return null;
    }
    if (((View)localObject).getVisibility() != 0)
    {
      if (QLog.isDevelopLevel()) {
        QLog.w(this.jdField_b_of_type_JavaLangString, 1, "qav_UserGuide_for_more.init, more按钮没显示出来, seq[" + paramLong + "]");
      }
      return null;
    }
    ImageView localImageView = (ImageView)findViewById(2131372388);
    if (localImageView == null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.w(this.jdField_b_of_type_JavaLangString, 1, "qav_UserGuide_for_more.init, !qav_more_tips, seq[" + paramLong + "]");
      }
      return null;
    }
    if (localImageView.getVisibility() == 0)
    {
      if (QLog.isDevelopLevel()) {
        QLog.w(this.jdField_b_of_type_JavaLangString, 1, "qav_UserGuide_for_more.init, qav_more_tips已经在显示中了, seq[" + paramLong + "]");
      }
      return null;
    }
    QLog.i(this.jdField_b_of_type_JavaLangString, 1, "MoreBtnTips. showTips. mMoreBtnTipsImageDownloaded = " + this.n + ", mMoreBtnTips = " + this.jdField_a_of_type_Mso);
    localImageView.setImageDrawable(this.jdField_a_of_type_ComTencentImageURLDrawable);
    int i1 = actj.a(10.0F, getResources());
    int i2 = (int)(25 * getResources().getDisplayMetrics().density / 1.5D);
    int[] arrayOfInt = new int[2];
    ((View)localObject).getLocationInWindow(arrayOfInt);
    int i3 = ((View)localObject).getWidth();
    int i4 = ((View)localObject).getHeight();
    int i5 = arrayOfInt[0];
    i5 = i3 / 2 + i5;
    int i6 = arrayOfInt[1] + i4 + i1;
    int i7 = (int)(this.jdField_a_of_type_ComTencentImageURLDrawable.getIntrinsicWidth() / 1.5D);
    int i8 = (int)(this.jdField_a_of_type_ComTencentImageURLDrawable.getIntrinsicHeight() / 1.5D);
    int i9 = i5 - i7 + i2;
    localObject = (RelativeLayout.LayoutParams)localImageView.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).topMargin = i6;
    ((RelativeLayout.LayoutParams)localObject).leftMargin = i9;
    ((RelativeLayout.LayoutParams)localObject).width = i7;
    ((RelativeLayout.LayoutParams)localObject).height = i8;
    QLog.w(this.jdField_b_of_type_JavaLangString, 1, "MoreBtnTips. offset[" + i1 + "], left_more[" + arrayOfInt[0] + "], top_more[" + arrayOfInt[1] + "], width_more[" + i3 + "], height_more[" + i4 + "], width_tips[" + i7 + "], height_tips[" + i8 + "], arrow[" + i2 + "], dockLeft[" + i5 + "], dockTop[" + i6 + "], tipsTop[" + i6 + "], tipsLeft[" + i9 + "], seq[" + paramLong + "]");
    return localImageView;
  }
  
  public VideoController a()
  {
    return this.jdField_a_of_type_ComTencentAvVideoController;
  }
  
  public AVActivity.AnimationTrigger a()
  {
    if (this.jdField_a_of_type_ComTencentAvUiAVActivity$AnimationTrigger == null) {
      this.jdField_a_of_type_ComTencentAvUiAVActivity$AnimationTrigger = new AVActivity.AnimationTrigger(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    }
    return this.jdField_a_of_type_ComTencentAvUiAVActivity$AnimationTrigger;
  }
  
  public lyw a()
  {
    return this.jdField_a_of_type_Lyw;
  }
  
  void a()
  {
    if (this.jdField_a_of_type_Mbl == null) {
      this.jdField_a_of_type_Mbl = new mbl(this, super.getApplicationContext(), 2);
    }
  }
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) && (this.jdField_a_of_type_ComTencentAvUiVideoControlUI.a() != null)) {
      this.jdField_a_of_type_ComTencentAvUiVideoControlUI.a().a(paramInt);
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (isDestroyed()) {}
    while ((this.jdField_a_of_type_ComTencentAvUiVideoControlUI == null) || (this.jdField_a_of_type_ComTencentAvUiVideoControlUI.g()) || (paramInt == this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.f())) {
      return;
    }
    long l1 = AudioHelper.b();
    this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.g(paramInt);
    if ((this.jdField_a_of_type_ComTencentAvUiVideoControlUI instanceof DoubleVideoCtrlUI))
    {
      this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.c(l1);
      ((DoubleVideoCtrlUI)this.jdField_a_of_type_ComTencentAvUiVideoControlUI).a(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.i(), c());
    }
    this.jdField_a_of_type_ComTencentAvUiVideoControlUI.z(l1);
    this.jdField_a_of_type_ComTencentAvUiVideoControlUI.f(l1, 65535);
    if (this.jdField_a_of_type_Min != null)
    {
      this.jdField_a_of_type_Min.a(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.i(), this.jdField_a_of_type_ComTencentAvUiVideoControlUI, this.jdField_a_of_type_Min.c());
      this.jdField_a_of_type_Min.a(this.jdField_a_of_type_Min.c());
      this.jdField_a_of_type_Min.b(this.jdField_a_of_type_Min.c());
    }
    if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_A_of_type_Boolean) && (!this.jdField_a_of_type_ComTencentAvVideoController.a().H)) {
      mnp.a("0X8008ABA");
    }
    if (this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterPanel != null)
    {
      paramBoolean = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_e_of_type_Boolean;
      this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterPanel.a(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.i(), paramBoolean);
    }
    this.jdField_a_of_type_ComTencentAvUiVideoControlUI.g(paramInt);
  }
  
  public void a(long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentAvCameraCameraUtils == null) {}
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null)
      {
        this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(paramLong, false, false);
        if (!this.jdField_a_of_type_ComTencentAvCameraCameraUtils.b(paramLong)) {
          this.jdField_a_of_type_ComTencentAvVideoController.a().a(paramLong, false);
        }
      }
      if (this.jdField_a_of_type_ComTencentAvCameraCameraUtils != null) {
        this.jdField_a_of_type_ComTencentAvCameraCameraUtils.a(paramLong, true);
      }
      if (!this.jdField_a_of_type_ComTencentAvCameraCameraUtils.b(paramLong))
      {
        QLog.w(this.jdField_b_of_type_JavaLangString, 1, "requestCloseCamera, 摄像头本来没打开, seq[" + paramLong + "]");
        if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
          this.jdField_a_of_type_ComTencentAvUiVideoControlUI.c(paramLong, true);
        }
      }
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().p()) {}
      while (this.jdField_a_of_type_Mmk != null)
      {
        this.jdField_a_of_type_Mmk.a();
        return;
        a(1, false);
      }
    }
  }
  
  public void a(long paramLong, int paramInt)
  {
    if (isDestroyed()) {
      break label7;
    }
    label7:
    while ((this.jdField_a_of_type_ComTencentAvUiVideoControlUI == null) || (this.jdField_a_of_type_ComTencentAvUiVideoControlUI.g())) {
      return;
    }
    int i5 = this.jdField_a_of_type_ComTencentAvUiVideoControlUI.a(paramLong);
    int i6 = this.jdField_a_of_type_ComTencentAvUiVideoControlUI.b();
    Object localObject;
    if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI.h())
    {
      localObject = findViewById(2131372513);
      if ((localObject == null) || (!(((View)localObject).getLayoutParams() instanceof ViewGroup.MarginLayoutParams))) {
        break label516;
      }
    }
    label516:
    for (int i1 = ((ViewGroup.MarginLayoutParams)((View)localObject).getLayoutParams()).topMargin;; i1 = 0)
    {
      int i2 = 0;
      int i3 = 0;
      int i7 = i5 + i3;
      int i4;
      label121:
      boolean bool;
      if (this.jdField_a_of_type_Mmk != null)
      {
        i4 = this.jdField_a_of_type_Mmk.a();
        QLog.w("ChatRoomUtil", 1, "calcControlUIOffset, topOffset[" + i7 + "], topToolbarHeight[" + i5 + "], topToolbarTop[" + i1 + "], bottomToolbarHeight[" + i6 + "], chatRoomInputPanelHeight[" + i4 + "], recordBarHeight[" + i2 + "], systemBarHeight[" + i3 + "], from[" + paramInt + "], seq[" + paramLong + "]");
        if (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null)
        {
          if ((c() != 1) || (i4 <= i6)) {
            break label447;
          }
          localObject = this.jdField_a_of_type_ComTencentAvUiVideoLayerUI;
          if (!this.jdField_a_of_type_ComTencentAvUiVideoControlUI.jdField_h_of_type_Boolean)
          {
            bool = true;
            label282:
            ((VideoLayerUI)localObject).a(paramLong, i7, i4, bool);
          }
        }
        else
        {
          this.jdField_a_of_type_ComTencentAvUiVideoControlUI.O();
          if ((this.jdField_a_of_type_Mmk == null) || (paramInt == 1)) {
            break;
          }
          this.jdField_a_of_type_Mmk.b(i6);
          return;
          if ((i5 != 0) || (!bkvi.b())) {
            break label510;
          }
        }
      }
      label447:
      label510:
      for (i1 = bkvi.b(this);; i1 = 0)
      {
        localObject = this.jdField_a_of_type_ComTencentAvVideoController.a();
        if ((((lga)localObject).v()) && ((((lga)localObject).jdField_A_of_type_Boolean) || (((lga)localObject).B)) && (this.jdField_a_of_type_Min != null) && (!this.jdField_a_of_type_Min.d()))
        {
          i2 = this.jdField_a_of_type_Min.c();
          localObject = this.jdField_a_of_type_ComTencentAvUiVideoLayerUI;
          if (i2 == 0) {}
          for (i3 = -1;; i3 = i2)
          {
            ((VideoLayerUI)localObject).jdField_i_of_type_Int = i3;
            i4 = 0;
            i3 = i1;
            i1 = i4;
            break;
          }
          bool = false;
          break label282;
          localObject = this.jdField_a_of_type_ComTencentAvUiVideoLayerUI;
          if (!this.jdField_a_of_type_ComTencentAvUiVideoControlUI.jdField_h_of_type_Boolean) {}
          for (bool = true;; bool = false)
          {
            ((VideoLayerUI)localObject).a(paramLong, i7, i6, bool);
            break;
          }
          i4 = 0;
          break label121;
        }
        i2 = 0;
        i4 = 0;
        i3 = i1;
        i1 = i4;
        break;
      }
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt1 == 2131372517) && (paramInt3 == 0))
    {
      a(paramLong, 2000L);
      this.jdField_a_of_type_ComTencentAvUiGuideGuideHelper.a(paramLong, this, 1, 0);
    }
  }
  
  public void a(long paramLong, int paramInt, boolean paramBoolean)
  {
    if (isDestroyed()) {}
    do
    {
      do
      {
        return;
      } while ((this.jdField_a_of_type_ComTencentAvUiVideoControlUI == null) || (this.jdField_a_of_type_ComTencentAvUiVideoControlUI.g()));
      this.jdField_a_of_type_ComTencentAvUiVideoControlUI.b(paramLong, paramInt);
      this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(paramInt, false);
      this.jdField_a_of_type_ComTencentAvCameraCameraUtils.a(paramInt);
      this.jdField_h_of_type_Int = paramInt;
      if (this.jdField_a_of_type_Min != null)
      {
        this.jdField_a_of_type_Min.d(paramInt);
        this.jdField_a_of_type_Min.d();
        this.jdField_a_of_type_Min.a(this.jdField_a_of_type_ComTencentAvUiVideoControlUI, this.jdField_h_of_type_Int);
      }
    } while ((!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_A_of_type_Boolean) && (!this.jdField_a_of_type_ComTencentAvVideoController.a().B));
    g(paramLong);
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    QLog.i(this.jdField_b_of_type_JavaLangString, 1, "MoreBtnTips. tryShow_qav_more_tips. mMoreBtnTipsImageDownloaded = " + this.n + ", mMoreBtnTips = " + this.jdField_a_of_type_Mso + ", delayMillis = " + paramLong2);
    if (this.jdField_a_of_type_Mso != null)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_b_of_type_JavaLangRunnable, paramLong2);
    }
  }
  
  public void a(long paramLong, String paramString1, int paramInt, String paramString2)
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {
      return;
    }
    Intent localIntent = actj.a(new Intent(super.getApplicationContext(), SplashActivity.class), null);
    localIntent.putExtra("uin", paramString1);
    localIntent.putExtra("uintype", paramInt);
    localIntent.putExtra("uinname", paramString2);
    startActivity(localIntent);
    QLog.w(this.jdField_b_of_type_JavaLangString, 1, "enterChatWin, uin[" + paramString1 + "], type[" + paramInt + "], seq[" + paramLong + "]");
    this.jdField_e_of_type_Boolean = false;
    finish();
    paramInt = 2130772134;
    paramString1 = this.jdField_a_of_type_ComTencentAvVideoController.a();
    if (paramString1 != null) {
      paramInt = lze.a(paramString1.K);
    }
    overridePendingTransition(0, paramInt);
  }
  
  public void a(long paramLong, String paramString, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView != null) {
      if (!paramBoolean) {
        break label168;
      }
    }
    label168:
    for (int i1 = 0;; i1 = 8)
    {
      int i2 = this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView.getVisibility();
      this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView.setVisibility(i1);
      if ((i2 != i1) && (AudioHelper.e())) {
        QLog.w(this.jdField_b_of_type_JavaLangString, 1, "ShowRecordBtn, from[" + paramString + "], bShown[" + paramBoolean + "], seq[" + paramLong + "]");
      }
      if ((paramBoolean) && (this.jdField_a_of_type_ComTencentAvVideoController != null) && (this.jdField_a_of_type_ComTencentAvVideoController.a().F))
      {
        this.jdField_a_of_type_ComTencentAvVideoController.a().F = false;
        paramBoolean = this.jdField_a_of_type_Min.i();
        boolean bool = min.f();
        if ((!paramBoolean) || (!bool)) {
          break;
        }
        mnp.a("0X8008AB2");
      }
      return;
    }
    mnp.a("0X8008AB1");
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentAvVideoController.a();
    QLog.w(this.jdField_b_of_type_JavaLangString, 1, "avideo onCreateUI, SessionType[" + ((lga)localObject1).jdField_d_of_type_Int + "], seq[" + paramLong + "]");
    mpv.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this);
    Object localObject2 = this.jdField_a_of_type_ComTencentAvVideoController.a(getApplicationContext());
    if (localObject2 != null) {
      ((lpu)localObject2).a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    }
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131372236));
    }
    this.jdField_a_of_type_JavaLangRunnable = new AVActivity.5(this);
    if (this.jdField_a_of_type_ComTencentAvCameraCameraUtils == null)
    {
      this.jdField_a_of_type_ComTencentAvCameraCameraUtils = CameraUtils.a(this);
      this.jdField_a_of_type_ComTencentAvCameraCameraUtils.a(this.jdField_a_of_type_Lkb);
      this.jdField_a_of_type_ComTencentAvCameraCameraUtils.a(this.jdField_a_of_type_ComTencentAvVideoController);
    }
    localObject2 = super.findViewById(2131362929).findViewById(2131362926);
    try
    {
      ((View)localObject2).setBackgroundResource(2130841604);
      if (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI == null) {
        l();
      }
      if (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) {
        this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.c();
      }
      c(false);
      switch (this.jdField_b_of_type_Int)
      {
      default: 
        int i2 = this.jdField_b_of_type_Int;
        int i1 = i2;
        if (this.jdField_b_of_type_Int == 3)
        {
          i1 = i2;
          if (getIntent() != null)
          {
            i1 = i2;
            if (getIntent().getBooleanExtra("isVideo", false)) {
              i1 = 4;
            }
          }
        }
        this.jdField_a_of_type_Mso = msn.a(i1);
        if ((this.jdField_a_of_type_Mso != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_Mso.jdField_a_of_type_JavaLangString)))
        {
          localObject2 = URLDrawable.URLDrawableOptions.obtain();
          this.jdField_a_of_type_ComTencentImageURLDrawable = URLDrawable.getDrawable(this.jdField_a_of_type_Mso.jdField_a_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject2);
          this.n = false;
          this.jdField_a_of_type_ComTencentImageURLDrawable.setURLDrawableListener(new mbf(this));
          this.jdField_a_of_type_ComTencentImageURLDrawable.startDownload();
          if (1 == this.jdField_a_of_type_ComTencentImageURLDrawable.getStatus())
          {
            paramBoolean = true;
            this.n = paramBoolean;
            axqy.b(null, "CliOper", "", "", "0X800A75E", "0X800A75E", i1, this.jdField_a_of_type_Mso.jdField_a_of_type_Int, "", "", "", "");
            QLog.i(this.jdField_b_of_type_JavaLangString, 1, "MoreBtnTips. getDrawableAndToDownloadImage. mMoreBtnTipsImageDownloaded = " + this.n);
          }
        }
        else
        {
          if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI != null)
          {
            this.jdField_a_of_type_ComTencentAvUiVideoControlUI.d();
            if ((this.jdField_d_of_type_Int == 9500) && ((this.jdField_a_of_type_ComTencentAvUiVideoControlUI instanceof DoubleVideoCtrlUI)))
            {
              localObject2 = (DoubleVideoCtrlUI)this.jdField_a_of_type_ComTencentAvUiVideoControlUI;
              ((DoubleVideoCtrlUI)localObject2).a(2131372219, this.jdField_a_of_type_ComTencentAvVideoController.o, 2130841508);
              if (!this.jdField_a_of_type_ComTencentAvVideoController.q) {
                ((DoubleVideoCtrlUI)localObject2).a.a(true, 0, false);
              }
            }
          }
          if ((((lga)localObject1).jdField_g_of_type_Int != 4) && (((lga)localObject1).v()) && (!this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_Int == 1) && (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) && (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getParent() != null))
          {
            i1 = mmp.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, ((lga)localObject1).jdField_d_of_type_JavaLangString, true, true);
            if ((i1 > 0) && (this.jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView == null)) {
              this.jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView = bbzh.a(this, (RelativeLayout)this.jdField_a_of_type_AndroidWidgetRelativeLayout.getParent(), false);
            }
            i2 = bbzh.a();
            localObject1 = bbzh.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, i1, i2, null);
            if (localObject1 != null)
            {
              localObject2 = new File((String)localObject1);
              if ((localObject2 == null) || (!((File)localObject2).exists())) {
                break label1217;
              }
              if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
                this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new AVActivity.7(this, (String)localObject1, i2, i1), 1000L);
              }
            }
          }
          this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView = ((QavRecordButtonView)findViewById(2131374988));
          a(paramLong, "onCreateUI", false);
          if (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) {
            this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.k(0);
          }
          localObject1 = (RelativeLayout)findViewById(2131379075);
          if ((localObject1 != null) && (min.f()))
          {
            this.jdField_a_of_type_Min = new min(this, (RelativeLayout)localObject1, this.jdField_a_of_type_ComTencentAvVideoController, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_ComTencentAvUiVideoControlUI);
            this.jdField_a_of_type_Min.c(1);
            if (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) {
              this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(this.jdField_a_of_type_Min);
            }
          }
          k();
          ltm.a().a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this);
          localObject1 = new AVActivity.8(this);
          new Handler().post((Runnable)localObject1);
          return;
        }
        break;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        QLog.d(this.jdField_b_of_type_JavaLangString, 1, "onCreateUI OutOfMemoryError", localOutOfMemoryError);
        continue;
        if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI == null)
        {
          if (!this.jdField_g_of_type_Boolean) {
            break label963;
          }
          this.jdField_a_of_type_ComTencentAvUiVideoControlUI = new DoubleVideoMeetingCtrlUI(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_Mcf);
          this.jdField_b_of_type_Int = ((lga)localObject1).jdField_d_of_type_Int;
        }
        for (;;)
        {
          this.jdField_a_of_type_ComTencentAvUiVideoControlUI.m(this.jdField_a_of_type_ComTencentAvCameraCameraUtils.a());
          break;
          label963:
          this.jdField_a_of_type_ComTencentAvUiVideoControlUI = new DoubleVideoCtrlUI(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_Mcf);
        }
        this.jdField_a_of_type_ComTencentAvUiVideoControlUI = new DoubleVideoCtrlUI(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_Mcf);
        this.jdField_a_of_type_ComTencentAvUiVideoControlUI.m(this.jdField_a_of_type_ComTencentAvCameraCameraUtils.a());
        continue;
        if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI == null)
        {
          if (!this.jdField_g_of_type_Boolean) {
            break label1095;
          }
          this.jdField_a_of_type_ComTencentAvUiVideoControlUI = new DoubleVideoMeetingCtrlUI(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_Mcf);
          this.jdField_b_of_type_Int = ((lga)localObject1).jdField_d_of_type_Int;
        }
        for (;;)
        {
          this.jdField_a_of_type_ComTencentAvUiVideoControlUI.m(this.jdField_a_of_type_ComTencentAvCameraCameraUtils.a());
          break;
          label1095:
          if (((lga)localObject1).C == 1)
          {
            this.jdField_a_of_type_ComTencentAvUiVideoControlUI = new MultiVideoCtrlLayerUI4Discussion(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_Mcf);
          }
          else if (((lga)localObject1).C == 10)
          {
            this.jdField_a_of_type_ComTencentAvUiVideoControlUI = new MultiVideoCtrlLayerUI4NewGroupChat(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_Mcf);
          }
          else
          {
            if (QLog.isColorLevel()) {
              QLog.d(this.jdField_b_of_type_JavaLangString, 2, "OnCreateUI --> Not Set MultiAVType");
            }
            this.jdField_a_of_type_ComTencentAvUiVideoControlUI = new MultiVideoCtrlLayerUI4Discussion(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_Mcf);
          }
        }
        paramBoolean = false;
        continue;
        label1217:
        QLog.e(this.jdField_b_of_type_JavaLangString, 1, "funcall --> !file.exists() + path:" + (String)localObject1);
      }
    }
  }
  
  public void a(Integer paramInteger, Object paramObject1, Object paramObject2)
  {
    lcg.c(this.jdField_b_of_type_JavaLangString, "notifyEvent :" + paramInteger + "|" + paramObject1 + "|" + paramObject2);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { paramInteger, paramObject1, paramObject2 });
  }
  
  public void a(String paramString)
  {
    lhr locallhr = (lhr)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(3);
    FaceItem localFaceItem = locallhr.a(paramString);
    if (localFaceItem != null)
    {
      long l1 = AudioHelper.b();
      if ((localFaceItem.isUsable()) || (TextUtils.isEmpty(localFaceItem.getResurl()))) {}
      for (boolean bool = true;; bool = false)
      {
        QLog.w(this.jdField_b_of_type_JavaLangString, 1, "onAVVoiceRecogComplete, recogResult[" + paramString + "], isResReady[" + bool + "], seq[" + l1 + "]");
        if (!bool) {
          break;
        }
        new mck(l1, localFaceItem.getId(), true, 2).a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
        VoiceRecogTips.b(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramString);
        axqy.b(null, "CliOper", "", "", "0X800984F", "0X800984F", 0, 0, "", "", "", localFaceItem.getId());
        return;
      }
      locallhr.a(l1, localFaceItem);
      return;
    }
    QLog.i(this.jdField_b_of_type_JavaLangString, 1, "onAVVoiceRecogComplete. recogResult = " + paramString + ", paly voice sticker falied. voiceStickerItem == null.");
  }
  
  void a(String paramString, long paramLong)
  {
    View localView = findViewById(2131372388);
    if (localView == null) {}
    do
    {
      do
      {
        return;
      } while (localView.getVisibility() != 0);
      localView.setVisibility(4);
      QLog.w(this.jdField_b_of_type_JavaLangString, 1, "MoreBtnTips. hide_qav_more_tips. from[" + paramString + "], seq[" + paramLong + "]");
    } while (this.jdField_a_of_type_Mso == null);
    msn.a(this.jdField_a_of_type_Mso.jdField_a_of_type_Int);
    this.jdField_a_of_type_Mso = null;
    this.jdField_a_of_type_ComTencentImageURLDrawable = null;
    this.n = false;
  }
  
  public void a(boolean paramBoolean)
  {
    RedTouch localRedTouch;
    if (this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch != null)
    {
      localRedTouch = this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch;
      if (!paramBoolean) {
        break label24;
      }
    }
    label24:
    for (int i1 = 0;; i1 = 8)
    {
      localRedTouch.setVisibility(i1);
      return;
    }
  }
  
  boolean a()
  {
    if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI == null) {}
    while (!this.jdField_a_of_type_ComTencentAvUiVideoControlUI.b(4)) {
      return false;
    }
    return true;
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Int;
  }
  
  void b()
  {
    if (this.jdField_a_of_type_Mbl != null) {
      this.jdField_a_of_type_Mbl.enable();
    }
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void b(long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {}
    do
    {
      return;
      c();
      if (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null)
      {
        if ((this.jdField_a_of_type_Lyw == null) || (this.jdField_a_of_type_Lyw.a()))
        {
          if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 4)
          {
            ArrayList localArrayList = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList;
            int i1 = 0;
            if (i1 < localArrayList.size())
            {
              lon locallon = (lon)localArrayList.get(i1);
              String str = mqu.a(locallon.jdField_a_of_type_Long);
              int i2 = locallon.jdField_a_of_type_Int;
              if (locallon.jdField_b_of_type_Long == 5L) {}
              for (boolean bool = true;; bool = false)
              {
                if (!str.equals(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin())) {
                  this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(paramLong, str, i2, false, false, bool);
                }
                i1 += 1;
                break;
              }
            }
          }
          this.jdField_a_of_type_ComTencentAvCameraCameraUtils.a(paramLong, false);
          this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(paramLong, false, false);
        }
        this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.x();
      }
      if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
        this.jdField_a_of_type_ComTencentAvUiVideoControlUI.l(paramLong);
      }
      if (this.jdField_a_of_type_Mby != null) {
        this.jdField_a_of_type_Mby.d();
      }
      f();
      this.jdField_a_of_type_ComTencentAvVideoController.a(true);
      this.jdField_a_of_type_ComTencentAvVideoController.i(false);
      if (this.jdField_a_of_type_Lyw != null) {
        this.jdField_a_of_type_Lyw.a(paramLong, this.jdField_e_of_type_Boolean);
      }
    } while (this.jdField_a_of_type_Mmk == null);
    this.jdField_a_of_type_Mmk.a();
  }
  
  public void b(long paramLong, String paramString, boolean paramBoolean)
  {
    int i2 = 1;
    int i1;
    if (QLog.isColorLevel())
    {
      i1 = -1;
      if (this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView != null)
      {
        if (this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView.getVisibility() == 0) {
          i1 = 1;
        }
      }
      else {
        QLog.w(this.jdField_b_of_type_JavaLangString, 1, "tryShowRecordBtn[" + paramString + "], bShown[" + paramBoolean + "], visibility[" + i1 + "], seq[" + paramLong + "]");
      }
    }
    else
    {
      if ((!min.k()) && (this.jdField_a_of_type_Min != null)) {
        break label146;
      }
      if ((this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView != null) && (this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView.getVisibility() != 8)) {
        this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView.setVisibility(8);
      }
    }
    label146:
    do
    {
      do
      {
        return;
        i1 = 0;
        break;
        int i3 = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int;
        i1 = i2;
        if (i3 != 1)
        {
          if (i3 != 2) {
            break label261;
          }
          i1 = i2;
        }
        for (;;)
        {
          if (paramBoolean)
          {
            if ((i1 != 0) && (this.jdField_a_of_type_ComTencentAvVideoController.a().B))
            {
              this.jdField_a_of_type_Min.d(this.jdField_h_of_type_Int);
              this.jdField_a_of_type_Min.d();
            }
            if (i1 == 0)
            {
              if ((this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView == null) || (this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView.getVisibility() != 0)) {
                break;
              }
              this.jdField_a_of_type_AndroidOsHandler.removeMessages(272);
              a(paramLong, "tryShowRecordBtn.1", false);
              return;
              i1 = 0;
              continue;
            }
            this.jdField_a_of_type_AndroidOsHandler.removeMessages(272);
            paramString = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(272);
            paramString.obj = Long.valueOf(paramLong);
            this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(paramString, 50L);
            return;
          }
        }
      } while (i1 == 0);
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().B)
      {
        this.jdField_a_of_type_Min.d(0);
        this.jdField_a_of_type_Min.d();
        this.jdField_a_of_type_Min.k();
      }
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(272);
      a(paramLong, "tryShowRecordBtn.2", false);
    } while (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI == null);
    label261:
    this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.k(0);
  }
  
  public void b(String paramString)
  {
    if ((this.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) && (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.i())) {
      return;
    }
    long l1 = AudioHelper.b();
    QLog.w(this.jdField_b_of_type_JavaLangString, 1, "onNeedChangeDoubleScreenMode, id[" + paramString + "], seq[" + l1 + "], hasChangeDoubleScreen[" + this.jdField_a_of_type_ComTencentAvVideoController.a().S + "]");
    getResources();
    if (!this.jdField_a_of_type_ComTencentAvVideoController.a().S)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a().a(true);
      a(2, false);
      mao.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1043);
      return;
    }
    if (this.jdField_a_of_type_AndroidViewView$OnClickListener == null) {
      this.jdField_a_of_type_AndroidViewView$OnClickListener = new mba(this, paramString, l1);
    }
    mao.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1044, null, this.jdField_a_of_type_AndroidViewView$OnClickListener);
  }
  
  public void b(boolean paramBoolean)
  {
    VideoLayerUI.a(findViewById(2131362929), paramBoolean);
  }
  
  boolean b()
  {
    if (isDestroyed()) {}
    do
    {
      do
      {
        return false;
      } while ((this.jdField_a_of_type_ComTencentAvUiVideoControlUI == null) || (this.jdField_a_of_type_ComTencentAvUiVideoControlUI.g()));
      if ((this.jdField_a_of_type_ComTencentAvUiVideoControlUI.a.b(1)) || (this.jdField_a_of_type_ComTencentAvUiVideoControlUI.a.b(3))) {
        return true;
      }
    } while ((!a()) && (!this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.i()));
    return true;
  }
  
  public int c()
  {
    int i1 = 1;
    if (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) {
      i1 = this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.f();
    }
    return i1;
  }
  
  void c()
  {
    if (this.jdField_a_of_type_Mbl != null) {
      this.jdField_a_of_type_Mbl.disable();
    }
  }
  
  void c(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString + "|VideoNodeManager", 2, "processExtraData, seq[" + paramLong + "]");
    }
    Object localObject3 = super.getIntent();
    if (localObject3 == null)
    {
      QLog.d(this.jdField_b_of_type_JavaLangString, 1, "processExtraData-->can not get intent");
      return;
    }
    AudioHelper.a("AVActivity.processExtraData", ((Intent)localObject3).getExtras());
    int i4 = ((Intent)localObject3).getIntExtra("sessionType", 0);
    lga locallga = this.jdField_a_of_type_ComTencentAvVideoController.a();
    int i3 = locallga.jdField_d_of_type_Int;
    boolean bool = ((Intent)localObject3).getBooleanExtra("isDoubleVideoMeeting", false);
    this.jdField_g_of_type_Boolean = bool;
    Object localObject1 = ((Intent)localObject3).getStringExtra("Fromwhere");
    if ((localObject1 != null) && (((String)localObject1).compareTo("AVNotification") == 0))
    {
      if (((locallga.jdField_g_of_type_Int == 2) || (locallga.jdField_g_of_type_Int == 13)) && (i4 != 1) && (i4 != 2))
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_b_of_type_JavaLangString, 2, "Close Double Video Meeting. --> QAVNotification to MultiVideo");
        }
        if (locallga.I) {
          break label392;
        }
        this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, locallga.jdField_d_of_type_JavaLangString, 1, true);
        this.jdField_a_of_type_ComTencentAvVideoController.a(locallga.jdField_d_of_type_JavaLangString, 230);
        this.jdField_a_of_type_ComTencentAvVideoController.b(230);
      }
      if (locallga.jdField_i_of_type_Int == 1)
      {
        if (locallga.C != 10) {
          break label430;
        }
        axqy.b(null, "CliOper", "", "", "0X8005930", "0X8005930", 0, 0, "", "", "", "");
      }
    }
    label392:
    long l1;
    for (;;)
    {
      if (bool) {
        axqy.b(null, "CliOper", "", "", "0X8005209", "0X8005209", 0, 0, "", "", "", "");
      }
      if (i4 != 0) {
        break label466;
      }
      lcg.d(this.jdField_b_of_type_JavaLangString, "processExtraData-->can not get session type in intent.");
      ((liw)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4)).a(locallga.b(), 5, 1015L);
      finish();
      return;
      l1 = Long.valueOf(locallga.jdField_d_of_type_JavaLangString).longValue();
      this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, 3, l1);
      this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, l1, 1);
      break;
      label430:
      axqy.b(null, "CliOper", "", "", "0X80046D7", "0X80046D7", 0, 0, "", "", "", "");
    }
    label466:
    String str = null;
    Object localObject2 = null;
    int i2 = 0;
    if ((i4 == 1) || (i4 == 2))
    {
      str = ((Intent)localObject3).getStringExtra("uin");
      label497:
      if ((localObject1 == null) || (((String)localObject1).compareTo("AVNotification") != 0)) {
        break label2376;
      }
      if ((i4 != 1) && (i4 != 2)) {
        break label652;
      }
      str = locallga.jdField_d_of_type_JavaLangString;
    }
    label652:
    label1814:
    label2373:
    label2376:
    for (;;)
    {
      int i1;
      int i5;
      if (str == null)
      {
        lcg.d(this.jdField_b_of_type_JavaLangString, "processExtraData-->can not get uin in intent.");
        ((liw)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4)).a(locallga.b(), 5, 1016L);
        finish();
        return;
        if ((i4 != 3) && (i4 != 4)) {
          break label497;
        }
        str = ((Intent)localObject3).getStringExtra("GroupId");
        i1 = ((Intent)localObject3).getIntExtra("MeetingConfID", 0);
        i5 = ((Intent)localObject3).getIntExtra("ConfAppID", 0);
        int i6 = ((Intent)localObject3).getIntExtra("MeetingStasks", -1);
        locallga.N = i1;
        locallga.O = i5;
        locallga.P = i6;
        break label497;
        if ((i4 != 3) && (i4 != 4)) {
          break label2376;
        }
        if (bool)
        {
          str = locallga.jdField_d_of_type_JavaLangString;
          continue;
        }
        str = String.valueOf(this.jdField_a_of_type_ComTencentAvVideoController.jdField_a_of_type_Long);
        continue;
      }
      if ((i3 == 1) || (i3 == 2))
      {
        localObject2 = locallga.jdField_d_of_type_JavaLangString;
        i1 = muc.b(locallga.jdField_i_of_type_Int);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          lcg.d(this.jdField_b_of_type_JavaLangString, "can not get the original peeruin");
          ((liw)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4)).a(locallga.b(), 5, 1016L);
          finish();
        }
      }
      else if ((i3 == 3) || (i3 == 4))
      {
        localObject2 = String.valueOf(this.jdField_a_of_type_ComTencentAvVideoController.jdField_a_of_type_Long);
        i1 = this.jdField_a_of_type_ComTencentAvVideoController.jdField_c_of_type_Int;
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          lcg.d(this.jdField_b_of_type_JavaLangString, "can not get the original group uin");
          ((liw)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4)).a(locallga.b(), 5, 1016L);
          finish();
        }
      }
      else
      {
        i1 = i2;
        localObject1 = localObject2;
        if (QLog.isColorLevel())
        {
          QLog.d(this.jdField_b_of_type_JavaLangString, 2, "original session type is none");
          localObject1 = localObject2;
          i1 = i2;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, "processExtraData-->IntentSessionType=" + i4 + ", OriginalSessionType=" + i3 + ", IntentUin=" + str);
      }
      if ((localObject1 != null) && (QLog.isColorLevel())) {
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, "processExtraData-->OriginalUin=" + (String)localObject1 + ", originalRelationType=" + i1);
      }
      if ((i3 == 0) && (!this.jdField_a_of_type_ComTencentAvVideoController.l()))
      {
        d(paramLong);
        label1006:
        QLog.w(this.jdField_b_of_type_JavaLangString, 1, "processExtraData, mSessionType[" + this.jdField_b_of_type_Int + "], mUinType[" + this.jdField_d_of_type_Int + "], mPeerUin[" + this.jdField_c_of_type_JavaLangString + "], mPeerName[" + this.jdField_e_of_type_JavaLangString + "], mPhoneNum[" + this.jdField_f_of_type_JavaLangString + "], mSelfNation[" + this.jdField_g_of_type_JavaLangString + "], mSelfMobile[" + this.jdField_h_of_type_JavaLangString + "], mIsReceiver[" + this.jdField_a_of_type_Boolean + "], mIsAudioMode[" + this.jdField_b_of_type_Boolean + "], mExtraUin[" + this.jdField_i_of_type_JavaLangString + "], mIsPeerNetworkWell[" + this.jdField_c_of_type_Boolean + "], mIsFriend[" + this.jdField_d_of_type_Boolean + "], mFromWhere[" + this.jdField_j_of_type_JavaLangString + "], intentUinStr[" + str + "], \nsession[" + locallga + "]");
        bbea.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ArrayOfByte);
        return;
      }
      if ((i3 == 3) || (i3 == 4) || (this.jdField_a_of_type_ComTencentAvVideoController.l()))
      {
        if ((i3 != 0) || (!this.jdField_a_of_type_ComTencentAvVideoController.l())) {
          break label2373;
        }
        localObject1 = "";
      }
      for (;;)
      {
        if ((i4 == 1) || (i4 == 2))
        {
          if (this.jdField_a_of_type_ComTencentAvVideoController.l()) {
            this.jdField_a_of_type_ComTencentAvVideoController.h(true);
          }
          for (;;)
          {
            d(paramLong);
            str = lcx.a(3, this.jdField_c_of_type_JavaLangString, new int[0]);
            if (lcx.a().a(str)) {
              break;
            }
            localObject1 = lcx.a().a(str, false);
            ((lga)localObject1).jdField_e_of_type_Boolean = false;
            ((lga)localObject1).a("processExtraData", 0);
            ((lga)localObject1).ae = false;
            if (!str.equals(this.jdField_a_of_type_JavaLangString)) {
              this.jdField_a_of_type_JavaLangString = str;
            }
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.w(this.jdField_b_of_type_JavaLangString, 2, "mutivideo to doublevideo bug fix call");
            return;
            this.jdField_a_of_type_ComTencentAvVideoController.a(i1, Long.valueOf((String)localObject1).longValue(), 97);
          }
        }
        if ((i4 != 3) && (i4 != 4)) {
          break label1006;
        }
        l1 = Long.valueOf(str).longValue();
        i3 = 0;
        i5 = ((Intent)localObject3).getIntExtra("MultiAVType", 0);
        locallga.as = ((Intent)localObject3).getBooleanExtra("disableInvite", false);
        i2 = i3;
        if (locallga.C != 0)
        {
          i2 = i3;
          if (i5 != locallga.C)
          {
            i2 = i3;
            if (i5 != 0) {
              i2 = 1;
            }
          }
        }
        locallga.a(i5);
        if (!bool) {
          if (this.jdField_a_of_type_ComTencentAvVideoController.l())
          {
            this.jdField_a_of_type_ComTencentAvVideoController.h(true);
            if (i2 != 0)
            {
              this.jdField_a_of_type_ComTencentAvVideoController.a(i1, this.jdField_a_of_type_ComTencentAvVideoController.jdField_a_of_type_Long, 99);
              locallga.a(i5);
              locallga.a(paramLong, "processExtraData.1", 3);
            }
            locallga.D = ((Intent)localObject3).getIntExtra("Type", -1);
            locallga.jdField_g_of_type_Long = l1;
            this.jdField_d_of_type_JavaLangString = str;
            if (str.compareTo((String)localObject1) != 0) {
              break label1814;
            }
            if (i2 == 0) {
              break label1802;
            }
            this.jdField_b_of_type_Int = i4;
            i1 = ((Intent)localObject3).getIntExtra("uinType", -1);
            locallga.jdField_i_of_type_Int = i1;
            this.jdField_d_of_type_Int = i1;
            this.jdField_i_of_type_JavaLangString = locallga.jdField_f_of_type_JavaLangString;
            if (locallga.D == -1) {
              locallga.D = 0;
            }
            this.jdField_c_of_type_Boolean = locallga.q;
            if (QLog.isColorLevel()) {
              QLog.d(this.jdField_b_of_type_JavaLangString, 2, "processExtraData multiAVType: " + locallga.C);
            }
          }
        }
        for (;;)
        {
          if (i2 != 0) {
            break label1898;
          }
          this.jdField_d_of_type_Int = locallga.jdField_i_of_type_Int;
          this.jdField_i_of_type_JavaLangString = locallga.jdField_f_of_type_JavaLangString;
          this.jdField_c_of_type_Boolean = locallga.q;
          break;
          if ((str.compareTo((String)localObject1) == 0) || (!this.jdField_a_of_type_ComTencentAvVideoController.jdField_e_of_type_Boolean)) {
            break label1541;
          }
          this.jdField_a_of_type_ComTencentAvVideoController.a(i1, this.jdField_a_of_type_ComTencentAvVideoController.jdField_a_of_type_Long, 98);
          locallga.a(i5);
          break label1541;
          this.jdField_b_of_type_Int = locallga.jdField_d_of_type_Int;
          continue;
          locallga.a(paramLong, "processExtraData.2", i4);
          locallga.jdField_i_of_type_Int = ((Intent)localObject3).getIntExtra("uinType", -1);
          if ((locallga.D == 0) || (locallga.D == 1)) {
            locallga.jdField_a_of_type_ArrayOfLong = ((Intent)localObject3).getLongArrayExtra("DiscussUinList");
          }
          this.jdField_b_of_type_Int = i4;
          continue;
          locallga.jdField_d_of_type_JavaLangString = str;
          this.jdField_b_of_type_Int = i4;
          this.jdField_c_of_type_JavaLangString = str;
        }
        label1898:
        break label1006;
        if (((i3 != 1) && (i3 != 2)) || ((i4 != 1) && (i4 != 2))) {
          break label1006;
        }
        i1 = ((Intent)localObject3).getIntExtra("uinType", -1);
        if ((i1 != -1) && (i1 != locallga.jdField_i_of_type_Int))
        {
          if (QLog.isColorLevel()) {
            QLog.w(this.jdField_b_of_type_JavaLangString, 2, "New Double Video in , newUinType !=-1 && newUinType != oldUinType , close old video.");
          }
          this.jdField_a_of_type_ComTencentAvVideoController.a(false, 203, new int[] { locallga.C });
          this.jdField_a_of_type_ComTencentAvVideoController.b(203);
          if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI != null)
          {
            this.jdField_a_of_type_ComTencentAvUiVideoControlUI.d(paramLong);
            this.jdField_a_of_type_ComTencentAvUiVideoControlUI = null;
          }
          localObject1 = locallga.jdField_d_of_type_JavaLangString;
          localObject2 = lcx.a(3, (String)localObject1, new int[0]);
          Object localObject4 = lcx.a().b((String)localObject2);
          if (localObject4 == null)
          {
            lcg.d(this.jdField_b_of_type_JavaLangString, "Can not get SessionInfo : SessionId = " + (String)localObject2);
            finish();
            return;
          }
          localObject3 = ((lga)localObject4).jdField_f_of_type_JavaLangString;
          i1 = locallga.jdField_i_of_type_Int;
          localObject4 = ((lga)localObject4).s;
          this.jdField_a_of_type_ComTencentAvVideoController.a((String)localObject1, 231);
          this.jdField_a_of_type_ComTencentAvVideoController.b(231);
          this.jdField_a_of_type_ComTencentAvVideoController.a("AVActivity.processExtraData", (String)localObject2, i1, (String)localObject1, (String)localObject3, 0, (String)localObject4, false, true);
          d(paramLong);
          localObject1 = lcx.a(3, this.jdField_c_of_type_JavaLangString, new int[0]);
          localObject2 = lcx.a().a((String)localObject1, false);
          ((lga)localObject2).jdField_e_of_type_Boolean = true;
          ((lga)localObject2).a("processExtraData", 2);
          ((lga)localObject2).ae = false;
          if (((String)localObject1).equals(this.jdField_a_of_type_JavaLangString)) {
            break label1006;
          }
          this.jdField_a_of_type_JavaLangString = ((String)localObject1);
          break label1006;
        }
        if (QLog.isColorLevel()) {
          QLog.w(this.jdField_b_of_type_JavaLangString, 2, "New Double Video in , newUinType !=-1 && newUinType == oldUinType , resume old video");
        }
        this.jdField_b_of_type_Int = locallga.jdField_d_of_type_Int;
        this.jdField_g_of_type_Boolean = locallga.I;
        this.jdField_d_of_type_Int = locallga.jdField_i_of_type_Int;
        this.jdField_c_of_type_JavaLangString = locallga.jdField_d_of_type_JavaLangString;
        this.jdField_e_of_type_JavaLangString = locallga.jdField_e_of_type_JavaLangString;
        this.jdField_l_of_type_JavaLangString = locallga.jdField_k_of_type_JavaLangString;
        this.jdField_e_of_type_Int = locallga.z;
        this.jdField_m_of_type_JavaLangString = locallga.jdField_p_of_type_JavaLangString;
        this.jdField_f_of_type_Int = locallga.jdField_A_of_type_Int;
        this.jdField_i_of_type_JavaLangString = locallga.jdField_f_of_type_JavaLangString;
        this.jdField_f_of_type_JavaLangString = locallga.a();
        this.jdField_a_of_type_Boolean = locallga.jdField_e_of_type_Boolean;
        this.jdField_b_of_type_Boolean = locallga.Q;
        this.jdField_c_of_type_Boolean = locallga.q;
        this.jdField_d_of_type_Boolean = locallga.L;
        break label1006;
      }
    }
  }
  
  public void c(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) {
      this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.f(paramBoolean);
    }
  }
  
  public boolean c()
  {
    return this.jdField_m_of_type_Boolean;
  }
  
  void d()
  {
    if ((this.jdField_a_of_type_AndroidHardwareSensorManager == null) && (this.jdField_a_of_type_AndroidHardwareSensor == null))
    {
      this.jdField_a_of_type_AndroidHardwareSensorManager = ((SensorManager)getSystemService("sensor"));
      this.jdField_a_of_type_AndroidHardwareSensor = this.jdField_a_of_type_AndroidHardwareSensorManager.getDefaultSensor(1);
    }
  }
  
  void d(long paramLong)
  {
    lga locallga = this.jdField_a_of_type_ComTencentAvVideoController.a();
    QLog.w(this.jdField_b_of_type_JavaLangString + "|VideoNodeManager", 1, "processIntentData begin, isProcessCreate[" + this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.jdField_c_of_type_Boolean + "], isMsfRecv[" + this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.jdField_d_of_type_Boolean + "], seq[" + paramLong + "], \nSessionInfo[" + locallga + "]");
    Object localObject1;
    String str1;
    Object localObject2;
    String str2;
    long l1;
    if ((this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.jdField_c_of_type_Boolean) || (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.jdField_d_of_type_Boolean))
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.jdField_c_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.jdField_d_of_type_Boolean = false;
      liu.a(26);
      localObject1 = super.getIntent();
      AudioHelper.a(this.jdField_b_of_type_JavaLangString + "_processIntentData", ((Intent)localObject1).getExtras());
      this.jdField_b_of_type_Int = ((Intent)localObject1).getIntExtra("sessionType", 0);
      this.jdField_d_of_type_Int = ((Intent)localObject1).getIntExtra("uinType", -1);
      this.jdField_c_of_type_JavaLangString = ((Intent)localObject1).getStringExtra("uin");
      this.jdField_l_of_type_JavaLangString = ((Intent)localObject1).getStringExtra("dstClient");
      this.jdField_g_of_type_Boolean = ((Intent)localObject1).getBooleanExtra("isDoubleVideoMeeting", false);
      this.jdField_m_of_type_JavaLangString = ((Intent)localObject1).getStringExtra("bindId");
      this.jdField_e_of_type_Int = ((Intent)localObject1).getIntExtra("bindType", 0);
      this.jdField_c_of_type_Int = ((Intent)localObject1).getIntExtra("subServiceType", 0);
      this.jdField_f_of_type_Int = ((Intent)localObject1).getIntExtra("extraType", 0);
      this.jdField_e_of_type_JavaLangString = ((Intent)localObject1).getStringExtra("name");
      this.jdField_g_of_type_JavaLangString = ((Intent)localObject1).getStringExtra("selfNation");
      this.jdField_h_of_type_JavaLangString = ((Intent)localObject1).getStringExtra("selfMobile");
      this.jdField_f_of_type_JavaLangString = ((Intent)localObject1).getStringExtra("toMobile");
      this.jdField_a_of_type_Boolean = ((Intent)localObject1).getBooleanExtra("receive", false);
      this.jdField_b_of_type_Boolean = ((Intent)localObject1).getBooleanExtra("isAudioMode", true);
      this.jdField_a_of_type_Long = ((Intent)localObject1).getLongExtra("main_timestamp", 0L);
      this.jdField_i_of_type_JavaLangString = ((Intent)localObject1).getStringExtra("extraUin");
      str1 = ((Intent)localObject1).getStringExtra("extraCode");
      localObject2 = ((Intent)localObject1).getByteArrayExtra("sig");
      this.jdField_c_of_type_Boolean = ((Intent)localObject1).getBooleanExtra("isPeerNetworkWell", false);
      this.jdField_d_of_type_Boolean = ((Intent)localObject1).getBooleanExtra("isFriend", false);
      this.jdField_j_of_type_JavaLangString = ((Intent)localObject1).getStringExtra("from");
      this.jdField_f_of_type_Boolean = ((Intent)localObject1).getBooleanExtra("shutCamera", false);
      str2 = ((Intent)localObject1).getStringExtra("headUrl");
      this.jdField_b_of_type_Long = bbzh.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_c_of_type_JavaLangString, 3, true, null);
      this.jdField_g_of_type_Int = ((Intent)localObject1).getIntExtra("vipType", 0);
      lcg.b("VideoNodeManager", "==> AVActivity processIntentData() mSessionType = " + this.jdField_b_of_type_Int + "  mIsAudioMode = " + this.jdField_b_of_type_Boolean);
      liu.b(this.jdField_b_of_type_Int);
      if (!this.jdField_b_of_type_Boolean) {
        break label773;
      }
      l1 = 1L;
      label568:
      liu.a(13, l1);
      if ((this.jdField_d_of_type_Int == 0) && (this.jdField_a_of_type_Boolean)) {
        this.jdField_d_of_type_Boolean = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_c_of_type_JavaLangString);
      }
      if (this.jdField_d_of_type_Int != 1008) {
        break label809;
      }
      if (localObject2 == null) {
        break label781;
      }
      this.jdField_a_of_type_ArrayOfByte = new byte[localObject2.length + 3];
      this.jdField_a_of_type_ArrayOfByte[0] = 1;
      this.jdField_a_of_type_ArrayOfByte[1] = 1;
      this.jdField_a_of_type_ArrayOfByte[2] = -116;
      System.arraycopy(localObject2, 0, this.jdField_a_of_type_ArrayOfByte, 3, localObject2.length);
    }
    for (;;)
    {
      AVReport.a().jdField_b_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
      if ((this.jdField_b_of_type_Int != 3) && (this.jdField_b_of_type_Int != 4)) {
        break label1085;
      }
      locallga.D = ((Intent)localObject1).getIntExtra("Type", -1);
      localObject2 = ((Intent)localObject1).getStringExtra("GroupId");
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        break label911;
      }
      lcg.d(this.jdField_b_of_type_JavaLangString, "relationIdStr is null");
      this.jdField_e_of_type_Boolean = true;
      ((liw)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4)).a(locallga.b(), 5, 1016L);
      finish();
      return;
      liu.a();
      break;
      label773:
      l1 = 2L;
      break label568;
      label781:
      this.jdField_a_of_type_ArrayOfByte = new byte[] { 1, 1, -118 };
      continue;
      label809:
      if (this.jdField_d_of_type_Int == 1011)
      {
        if (localObject2 != null)
        {
          this.jdField_a_of_type_ArrayOfByte = new byte[localObject2.length + 3];
          this.jdField_a_of_type_ArrayOfByte[0] = 1;
          this.jdField_a_of_type_ArrayOfByte[1] = 1;
          this.jdField_a_of_type_ArrayOfByte[2] = -118;
          System.arraycopy(localObject2, 0, this.jdField_a_of_type_ArrayOfByte, 3, localObject2.length);
        }
        else
        {
          this.jdField_a_of_type_ArrayOfByte = new byte[] { 1, 1, -118 };
        }
      }
      else {
        this.jdField_a_of_type_ArrayOfByte = ((byte[])localObject2);
      }
    }
    label911:
    int i2 = ((Intent)localObject1).getIntExtra("MultiAVType", 0);
    int i1 = i2;
    if (i2 == 0)
    {
      i2 = locallga.C;
      i1 = i2;
      if (QLog.isColorLevel())
      {
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, "Not get avtype inside intent default value: " + i2);
        i1 = i2;
      }
    }
    locallga.a(i1);
    if (localObject2 != null)
    {
      locallga.jdField_g_of_type_Long = Long.valueOf((String)localObject2).longValue();
      this.jdField_d_of_type_JavaLangString = ((String)localObject2);
    }
    locallga.jdField_a_of_type_ArrayOfLong = ((Intent)localObject1).getLongArrayExtra("DiscussUinList");
    locallga.as = ((Intent)localObject1).getBooleanExtra("disableInvite", false);
    while (this.jdField_b_of_type_Int == 0)
    {
      lcg.d(this.jdField_b_of_type_JavaLangString, "invalid sessionType!!!");
      this.jdField_e_of_type_Boolean = true;
      ((liw)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4)).a(locallga.b(), 5, 1015L);
      finish();
      return;
      label1085:
      locallga.ag = ((Intent)localObject1).getBooleanExtra("isOtherTerminalOnChating", false);
      if (locallga.ag)
      {
        locallga.jdField_i_of_type_Long = ((Intent)localObject1).getLongExtra("otherTerminalChatingRoomId", 0L);
        locallga.ai = ((Intent)localObject1).getBooleanExtra("startfromVideoEntry", false);
      }
    }
    i1 = ((Intent)localObject1).getIntExtra("remoteStatus", 0);
    boolean bool;
    if (this.jdField_a_of_type_Boolean)
    {
      if (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))
      {
        lcg.d(this.jdField_b_of_type_JavaLangString, "uin is empty");
        this.jdField_e_of_type_Boolean = true;
        ((liw)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4)).a(locallga.b(), 5, 1016L);
        finish();
        return;
      }
      if (TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) {
        this.jdField_e_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
      }
      if ((this.jdField_d_of_type_Int != 1011) && (locallga.jdField_a_of_type_Lgb.jdField_b_of_type_Boolean))
      {
        this.jdField_a_of_type_ComTencentAvVideoController.a(locallga.jdField_d_of_type_JavaLangString, 232);
        this.jdField_a_of_type_ComTencentAvVideoController.b(232);
      }
      locallga.a(paramLong, "processIntentData", this.jdField_b_of_type_Int);
      locallga.jdField_i_of_type_Int = this.jdField_d_of_type_Int;
      locallga.jdField_d_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
      locallga.jdField_e_of_type_JavaLangString = this.jdField_e_of_type_JavaLangString;
      locallga.jdField_f_of_type_JavaLangString = this.jdField_i_of_type_JavaLangString;
      locallga.jdField_g_of_type_JavaLangString = str1;
      locallga.a(this.jdField_f_of_type_JavaLangString);
      if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
        Looper.myQueue().addIdleHandler(this.jdField_a_of_type_AndroidOsMessageQueue$IdleHandler);
      }
      locallga.jdField_e_of_type_Boolean = this.jdField_a_of_type_Boolean;
      locallga.Q = this.jdField_b_of_type_Boolean;
      locallga.q = this.jdField_c_of_type_Boolean;
      locallga.jdField_i_of_type_JavaLangString = this.jdField_g_of_type_JavaLangString;
      locallga.jdField_j_of_type_JavaLangString = this.jdField_h_of_type_JavaLangString;
      locallga.jdField_k_of_type_JavaLangString = this.jdField_l_of_type_JavaLangString;
      locallga.jdField_p_of_type_JavaLangString = this.jdField_m_of_type_JavaLangString;
      locallga.z = this.jdField_e_of_type_Int;
      locallga.jdField_A_of_type_Int = this.jdField_f_of_type_Int;
      locallga.jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_ArrayOfByte;
      locallga.L = this.jdField_d_of_type_Boolean;
      locallga.jdField_f_of_type_Int = this.jdField_b_of_type_Int;
      locallga.jdField_m_of_type_Boolean = this.jdField_f_of_type_Boolean;
      locallga.jdField_b_of_type_Long = this.jdField_b_of_type_Long;
      locallga.o = this.jdField_g_of_type_Int;
      if (i1 != 4) {
        break label1998;
      }
      bool = true;
      label1500:
      locallga.r = bool;
      locallga.jdField_k_of_type_Int = ((Intent)localObject1).getIntExtra("friendTerminal", 3);
      locallga.I = this.jdField_g_of_type_Boolean;
      locallga.jdField_p_of_type_Int = this.jdField_c_of_type_Int;
      locallga.jdField_l_of_type_JavaLangString = ((Intent)localObject1).getStringExtra("actId");
      locallga.jdField_m_of_type_JavaLangString = ((Intent)localObject1).getStringExtra("mp_ext_params");
      locallga.jdField_a_of_type_Long = this.jdField_a_of_type_Long;
      if ((this.jdField_d_of_type_Int != 1011) && (this.jdField_d_of_type_Int != 21)) {
        break label2034;
      }
      locallga.jdField_a_of_type_Lgb.jdField_a_of_type_JavaLangString = str2;
      locallga.jdField_a_of_type_Lgb.jdField_b_of_type_JavaLangString = ((Intent)localObject1).getStringExtra("name");
      locallga.jdField_a_of_type_Lgb.jdField_c_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
      if (Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).longValue() <= Long.valueOf(this.jdField_c_of_type_JavaLangString).longValue()) {
        break label2004;
      }
      locallga.jdField_a_of_type_Lgb.jdField_a_of_type_Boolean = true;
      localObject1 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication().getApplicationInfo().dataDir + "/" + MD5.toMD5(str2) + ".jpg";
      if (!apvd.a((String)localObject1)) {}
    }
    for (;;)
    {
      try
      {
        locallga.jdField_a_of_type_Lgb.jdField_a_of_type_AndroidGraphicsBitmap = BitmapFactory.decodeFile((String)localObject1);
        QLog.w(this.jdField_b_of_type_JavaLangString + "|VideoNodeManager", 1, "processIntentData end, mRelationId[" + this.jdField_d_of_type_JavaLangString + "], bStartByTerminalSwitch[" + locallga.ag + "], terSwitchStartFromVideoEntry[" + locallga.ai + "], \nSessionInfo[" + locallga + "]");
        return;
        if (this.jdField_d_of_type_Int == 1006)
        {
          if (TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString))
          {
            lcg.d(this.jdField_b_of_type_JavaLangString, "phoneNum is empty");
            this.jdField_e_of_type_Boolean = true;
            ((liw)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4)).a(locallga.b(), 5, 1016L);
            finish();
            return;
          }
          this.jdField_c_of_type_JavaLangString = this.jdField_f_of_type_JavaLangString;
          if (!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) {
            break;
          }
          this.jdField_e_of_type_JavaLangString = this.jdField_f_of_type_JavaLangString;
          break;
        }
        if (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))
        {
          lcg.d(this.jdField_b_of_type_JavaLangString, "Create video failed because uin is empty");
          this.jdField_e_of_type_Boolean = true;
          ((liw)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4)).a(locallga.b(), 5, 1016L);
          finish();
          return;
        }
        if (!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) {
          break;
        }
        this.jdField_e_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
        break;
        label1998:
        bool = false;
        break label1500;
        label2004:
        locallga.jdField_a_of_type_Lgb.jdField_a_of_type_Boolean = false;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        QLog.d(this.jdField_b_of_type_JavaLangString, 1, "processIntentData OutOfMemoryError", localOutOfMemoryError);
        continue;
      }
      label2034:
      locallga.jdField_a_of_type_Lgb.jdField_a_of_type_JavaLangString = null;
      locallga.jdField_a_of_type_Lgb.jdField_b_of_type_JavaLangString = null;
      locallga.jdField_a_of_type_Lgb.jdField_a_of_type_Boolean = false;
    }
  }
  
  public void d(boolean paramBoolean)
  {
    QLog.w(this.jdField_b_of_type_JavaLangString, 1, "onZimuModeChange, inZimu[" + paramBoolean + "]");
    min localmin;
    if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (this.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) && (this.jdField_a_of_type_Min != null))
    {
      this.jdField_a_of_type_Min.jdField_d_of_type_Boolean = paramBoolean;
      localmin = this.jdField_a_of_type_Min;
      if (!paramBoolean) {
        break label87;
      }
    }
    label87:
    for (int i1 = 0;; i1 = this.jdField_h_of_type_Int)
    {
      localmin.d(i1);
      this.jdField_a_of_type_Min.d();
      return;
    }
  }
  
  boolean d()
  {
    if (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) {
      return this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.i();
    }
    return false;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return super.dispatchTouchEvent(paramMotionEvent);
      a("dispatchTouchEvent up", AudioHelper.b());
    }
  }
  
  void e()
  {
    if ((this.jdField_a_of_type_AndroidHardwareSensorManager != null) && (this.jdField_a_of_type_AndroidHardwareSensor != null)) {
      this.jdField_a_of_type_AndroidHardwareSensorManager.registerListener(this, this.jdField_a_of_type_AndroidHardwareSensor, 2);
    }
  }
  
  void e(long paramLong)
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)getSystemService("input_method");
    boolean bool;
    if (localInputMethodManager.isActive())
    {
      if ((getCurrentFocus() == null) || (getCurrentFocus().getWindowToken() == null)) {
        break label110;
      }
      bool = localInputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
    }
    for (int i1 = 1;; i1 = 2)
    {
      QLog.w(this.jdField_b_of_type_JavaLangString, 1, "closeIME , InputMethodManager, result[" + bool + "], step[" + i1 + "], seq[" + paramLong + "]");
      return;
      label110:
      bool = localInputMethodManager.hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0);
    }
  }
  
  public void e(boolean paramBoolean)
  {
    int i2 = 0;
    long l1 = AudioHelper.b();
    QLog.w(this.jdField_b_of_type_JavaLangString, 1, "onRedBagGameModeChange, inGame[" + paramBoolean + "], seq[" + l1 + "]");
    Object localObject;
    if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI != null)
    {
      this.jdField_a_of_type_ComTencentAvUiVideoControlUI.O();
      if ((this.jdField_a_of_type_ComTencentAvUiVideoControlUI instanceof DoubleVideoCtrlUI))
      {
        localObject = (DoubleVideoCtrlUI)this.jdField_a_of_type_ComTencentAvUiVideoControlUI;
        if (this.jdField_a_of_type_Min == null) {
          break label219;
        }
        i1 = this.jdField_a_of_type_Min.c();
        ((DoubleVideoCtrlUI)localObject).e_(i1);
        g(l1);
      }
    }
    if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (this.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) && (this.jdField_a_of_type_Min != null))
    {
      this.jdField_a_of_type_Min.jdField_c_of_type_Boolean = paramBoolean;
      if ((this.jdField_a_of_type_ComTencentAvVideoController.a().B) || (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_A_of_type_Boolean))
      {
        localObject = this.jdField_a_of_type_Min;
        if (!paramBoolean) {
          break label224;
        }
      }
    }
    label219:
    label224:
    for (int i1 = i2;; i1 = this.jdField_h_of_type_Int)
    {
      ((min)localObject).d(i1);
      this.jdField_a_of_type_Min.d();
      localObject = findViewById(2131362929);
      if (localObject != null)
      {
        if (!paramBoolean) {
          break label232;
        }
        ((View)localObject).setBackgroundColor(-16777216);
      }
      return;
      i1 = 0;
      break;
    }
    label232:
    ((View)localObject).setBackgroundDrawable(null);
  }
  
  public boolean e()
  {
    switch (b())
    {
    case -1: 
    case 0: 
    case 1: 
    case 4: 
    case 5: 
    default: 
      return false;
    }
    return true;
  }
  
  void f()
  {
    if ((this.jdField_a_of_type_AndroidHardwareSensorManager != null) && (this.jdField_a_of_type_AndroidHardwareSensor != null)) {
      this.jdField_a_of_type_AndroidHardwareSensorManager.unregisterListener(this);
    }
  }
  
  void f(long paramLong)
  {
    if ((this.jdField_a_of_type_ComTencentAvCameraCameraUtils == null) || (!this.jdField_a_of_type_ComTencentAvCameraCameraUtils.b(paramLong))) {
      return;
    }
    QLog.w(this.jdField_b_of_type_JavaLangString, 1, "showRotateMenu, seq[" + paramLong + "]");
    i();
    bfpc localbfpc = bfpc.c(this);
    localbfpc.getWindow().addFlags(524288);
    localbfpc.getWindow().addFlags(2097152);
    localbfpc.getWindow().addFlags(128);
    localbfpc.b(2131720806);
    localbfpc.c(2131690596);
    localbfpc.a(new may(this));
    localbfpc.setOnDismissListener(new maz(this));
    localbfpc.setCanceledOnTouchOutside(true);
    localbfpc.e(150);
    this.jdField_a_of_type_AndroidAppDialog = localbfpc;
    try
    {
      this.jdField_a_of_type_AndroidAppDialog.show();
      this.jdField_l_of_type_Boolean = true;
      return;
    }
    catch (Exception localException) {}
  }
  
  public void f(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {
      return;
    }
    ImmersiveUtils.a(false, getWindow());
  }
  
  public void finish()
  {
    int i1 = 1;
    if ((!TextUtils.isEmpty(this.jdField_j_of_type_JavaLangString)) && (this.jdField_j_of_type_JavaLangString.equals("from_app_contact"))) {
      moveTaskToBack(true);
    }
    lcg.d(this.jdField_b_of_type_JavaLangString, "avideo life_finish, FromWhere[" + this.jdField_j_of_type_JavaLangString + "]");
    lga locallga = lcx.a().a();
    if ((locallga.jdField_A_of_type_Boolean) && (this.jdField_a_of_type_Min != null))
    {
      this.jdField_a_of_type_Min.c();
      if (this.jdField_a_of_type_Min.b() < 1000L) {
        break label311;
      }
    }
    for (;;)
    {
      locallga.u = i1;
      axqy.b(null, "CliOper", "", "", "0X800863D", "0X800863D", 0, 0, "", "", "", "");
      if ((this.jdField_e_of_type_Boolean) && (locallga.aC) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null))
      {
        String str1 = String.valueOf(locallga.jdField_g_of_type_Long);
        String str2 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getDisplayName(this.jdField_d_of_type_Int, str1, locallga.jdField_f_of_type_JavaLangString);
        Intent localIntent = actj.a(new Intent(super.getApplicationContext(), SplashActivity.class), null);
        localIntent.putExtra("uin", str1);
        localIntent.putExtra("uintype", locallga.jdField_i_of_type_Int);
        localIntent.putExtra("uinname", str2);
        startActivity(localIntent);
      }
      if (QLog.isColorLevel()) {
        QLog.i("double_2_multi", 2, "finish fromDoubleChat[" + locallga.aC + "], session[" + locallga + "]");
      }
      super.finish();
      return;
      label311:
      i1 = 2;
    }
  }
  
  public void g()
  {
    int i1 = -1;
    ViewGroup localViewGroup = (ViewGroup)findViewById(2131362929);
    float f1 = getResources().getDimension(2131297536);
    float f2 = getResources().getDimension(2131297539);
    Object localObject = new RelativeLayout.LayoutParams(-1, (int)f1);
    ((RelativeLayout.LayoutParams)localObject).setMargins(0, (int)f2, 0, 0);
    this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterPanel = new EffectFilterPanel(getBaseContext(), this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterPanel.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = localViewGroup.findViewById(2131372534);
    if (localObject != null) {
      i1 = localViewGroup.indexOfChild((View)localObject);
    }
    localViewGroup.addView(this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterPanel, i1);
  }
  
  public void g(long paramLong)
  {
    a(paramLong, 0);
  }
  
  public void g(boolean paramBoolean)
  {
    if (a(getWindow(), paramBoolean)) {
      this.jdField_m_of_type_Boolean = paramBoolean;
    }
  }
  
  public int getRequestedOrientation()
  {
    return super.getRequestedOrientation();
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterPanel != null)
    {
      ViewGroup localViewGroup = (ViewGroup)findViewById(2131362929);
      this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterPanel.setVisibility(8);
      localViewGroup.removeView(this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterPanel);
      this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterPanel = null;
    }
  }
  
  public void h(boolean paramBoolean)
  {
    a(1, false);
    if ((a()) && (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null)) {
      this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a("onChangeUI_quitDoubleScreenStatus");
    }
    if (paramBoolean) {
      a(2);
    }
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(3))
    {
      FaceItem localFaceItem = (FaceItem)((lhr)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(3)).a();
      if ((localFaceItem == null) || (!localFaceItem.isInteract()) || (!localFaceItem.isSameType("face"))) {
        break label138;
      }
    }
    label138:
    for (paramBoolean = true;; paramBoolean = false)
    {
      lcg.c(this.jdField_b_of_type_JavaLangString, "onChangeUI_quitDoubleScreenStatus isIntactiveFace:" + paramBoolean);
      if (paramBoolean) {
        a(Integer.valueOf(6101), null, Boolean.valueOf(false));
      }
      return;
    }
  }
  
  public void i()
  {
    if ((!this.jdField_l_of_type_Boolean) || ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing()))) {}
    try
    {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
      label31:
      this.jdField_l_of_type_Boolean = false;
      this.jdField_a_of_type_AndroidAppDialog = null;
      return;
    }
    catch (Exception localException)
    {
      break label31;
    }
  }
  
  public void i(boolean paramBoolean)
  {
    int i1 = 2;
    if (QLog.isColorLevel()) {
      QLog.i(this.jdField_b_of_type_JavaLangString, 2, "updateNotificationFlag resume[" + paramBoolean + "]");
    }
    msp localmsp = msp.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    if (localmsp != null)
    {
      if (paramBoolean) {
        i1 = 1;
      }
      localmsp.a(i1);
    }
  }
  
  public boolean isDestroyed()
  {
    if (Build.VERSION.SDK_INT >= 17) {
      return super.isDestroyed();
    }
    return this.jdField_a_of_type_Int == 5;
  }
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "life_onActivityResult, requestCode[" + paramInt1 + "], resultCode[" + paramInt2 + "]");
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 801) {
      mpv.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramInt2, paramIntent);
    }
    do
    {
      return;
      if (paramInt1 == 802)
      {
        mpv.b(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramInt2, paramIntent);
        return;
      }
    } while ((paramInt1 != 1002) || (this.jdField_a_of_type_Mha == null));
    this.jdField_a_of_type_Mha.f();
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    a(this);
  }
  
  public void onBackPressed()
  {
    if (this.jdField_k_of_type_Boolean == true)
    {
      QLog.i(this.jdField_b_of_type_JavaLangString, 1, "avideo onBackPressed, onSaveInstanceState, return");
      return;
    }
    mcj localmcj = new mcj(null);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(7002), localmcj });
    QLog.i(this.jdField_b_of_type_JavaLangString, 1, "avideo onBackPressed, BlockSystemBack[" + localmcj.jdField_b_of_type_Boolean + "], BlockName[" + localmcj.jdField_b_of_type_JavaLangString + "]");
    boolean bool1 = localmcj.jdField_b_of_type_Boolean;
    boolean bool2 = bool1;
    if (!bool1)
    {
      bool2 = bool1;
      if (this.jdField_a_of_type_Mmk != null) {
        bool2 = this.jdField_a_of_type_Mmk.b();
      }
    }
    bool1 = bool2;
    if (!bool2)
    {
      if ((this.jdField_a_of_type_Mby == null) || (!this.jdField_a_of_type_Mby.a())) {
        break label221;
      }
      bool1 = this.jdField_a_of_type_Mby.b();
    }
    for (;;)
    {
      bool2 = bool1;
      if (this.jdField_a_of_type_Mha != null)
      {
        bool2 = bool1;
        if (this.jdField_a_of_type_Mha.a())
        {
          this.jdField_a_of_type_Mha.c();
          bool2 = true;
        }
      }
      if (!bool2) {
        super.onBackPressed();
      }
      this.jdField_a_of_type_ComTencentAvVideoController.a("backgroundReason", "2");
      lde.jdField_a_of_type_JavaLangString = "2";
      return;
      label221:
      bool1 = bool2;
      if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
        bool1 = this.jdField_a_of_type_ComTencentAvUiVideoControlUI.a();
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AudioHelper.b(this.jdField_b_of_type_JavaLangString + ".onCreate.begin");
    long l1 = AudioHelper.b();
    QLog.w(this.jdField_b_of_type_JavaLangString + "|VideoNodeManager", 1, "avideo life_onCreate, seq[" + l1 + "], IS_CPU_64_BIT = " + AppSetting.jdField_b_of_type_Boolean);
    this.mIsShadow = false;
    super.onCreate(paramBundle);
    super.requestWindowFeature(1);
    super.setContentView(2131559496);
    super.getWindow().addFlags(524288);
    super.getWindow().addFlags(2097152);
    super.getWindow().addFlags(128);
    super.getWindow().setSoftInputMode(18);
    g(true);
    a(super.getWindow());
    Object localObject = super.getAppRuntime();
    paramBundle = (Bundle)localObject;
    boolean bool;
    if (localObject == null)
    {
      paramBundle = BaseApplicationImpl.getApplication();
      if (paramBundle == null) {
        break label328;
      }
      QLog.d(this.jdField_b_of_type_JavaLangString, 1, "onCreate, 尝试同步获取AppRuntime");
      paramBundle = paramBundle.getRuntime();
      localObject = this.jdField_b_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder().append("onCreate, 同步获取AppRuntime结果");
      if (paramBundle == null) {
        break label322;
      }
      bool = true;
      QLog.d((String)localObject, 1, bool);
    }
    for (;;)
    {
      if (paramBundle != null) {
        break label345;
      }
      lcg.d(this.jdField_b_of_type_JavaLangString, "onCreate, appRuntime is null exit");
      paramBundle = super.getString(2131720749) + " 0x05";
      Toast.makeText(super.getBaseContext(), paramBundle, 0).show();
      this.jdField_e_of_type_Boolean = true;
      sendBroadcast(new Intent("com.tencent.av.ui.AVLoadingDialogActivity.ACTION_LOADING_FINISH"));
      finish();
      return;
      label322:
      bool = false;
      break;
      label328:
      QLog.d(this.jdField_b_of_type_JavaLangString, 1, "onCreate, BaseApplicationImpl.getApplication is null");
      paramBundle = (Bundle)localObject;
    }
    label345:
    if ((paramBundle instanceof VideoAppInterface)) {}
    for (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = ((VideoAppInterface)paramBundle); this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null; this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = null)
    {
      lcg.d(this.jdField_b_of_type_JavaLangString, "onCreate, AppRuntime is no VideoAppInterface, " + paramBundle.getClass().getName() + " exit");
      paramBundle = super.getString(2131720749) + " 0x06";
      Toast.makeText(super.getBaseContext(), paramBundle, 0).show();
      this.jdField_e_of_type_Boolean = true;
      sendBroadcast(new Intent("com.tencent.av.ui.AVLoadingDialogActivity.ACTION_LOADING_FINISH"));
      finish();
      return;
    }
    f(true);
    paramBundle = (liw)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4);
    localObject = lcx.a().a();
    if (localObject != null)
    {
      QLog.d(this.jdField_b_of_type_JavaLangString, 1, "avideo life_onCreate roomId = " + ((lga)localObject).b() + ",isReceiver = " + ((lga)localObject).jdField_e_of_type_Boolean);
      if (((lga)localObject).jdField_e_of_type_Boolean) {
        paramBundle.a(((lga)localObject).b(), 7, 1L);
      }
    }
    for (;;)
    {
      bool = getIntent().getBooleanExtra("isMakingAcall", false);
      if (bool) {
        paramBundle.a(-1L, 1, 1L);
      }
      QLog.d(this.jdField_b_of_type_JavaLangString, 1, "avideo life_onCreate  isMakingAcall =  " + bool);
      AVReport.a().a(getIntent(), this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
      lil.a().a(this);
      this.jdField_a_of_type_ComTencentAvVideoController = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
      if (this.jdField_a_of_type_ComTencentAvVideoController != null) {
        break;
      }
      lcg.d(this.jdField_b_of_type_JavaLangString, "onCreate,VideoAppInterface.mVideoController exit");
      paramBundle = super.getString(2131720749) + " 0x07";
      Toast.makeText(super.getBaseContext(), paramBundle, 0).show();
      this.jdField_e_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast(new Intent("com.tencent.av.ui.AVLoadingDialogActivity.ACTION_LOADING_FINISH"));
      finish();
      return;
      QLog.d(this.jdField_b_of_type_JavaLangString, 1, "avideo life_onCreate sessionInfo is null ");
    }
    if (!this.jdField_a_of_type_ComTencentAvVideoController.b())
    {
      lcg.d(this.jdField_b_of_type_JavaLangString, "onCreate,VideoAppInterface.initVcController exit");
      paramBundle = super.getString(2131720749) + " 0x08";
      Toast.makeText(super.getBaseContext(), paramBundle, 0).show();
      this.jdField_e_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast(new Intent("com.tencent.av.ui.AVLoadingDialogActivity.ACTION_LOADING_FINISH"));
      finish();
      return;
    }
    paramBundle = super.getIntent();
    int i1;
    if (paramBundle != null)
    {
      i1 = paramBundle.getIntExtra("uinType", -1);
      paramBundle = paramBundle.getStringExtra("uin");
      if (i1 == 1008)
      {
        localObject = lcx.a(3, paramBundle, new int[0]);
        localObject = lcx.a().b((String)localObject);
        if ((localObject == null) || (((lga)localObject).jdField_i_of_type_Int == -1))
        {
          localObject = lcx.a().a();
          if ((((lga)localObject).jdField_i_of_type_Int != -1) && ((((lga)localObject).f()) || (((lga)localObject).h())))
          {
            localObject = new Intent("tencent.video.v2q.ypc2b.failEnter.asIsInviting");
            ((Intent)localObject).setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getPackageName());
            ((Intent)localObject).putExtra("uin", paramBundle);
            ((Intent)localObject).putExtra("uinType", i1);
            this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast((Intent)localObject);
            this.jdField_e_of_type_Boolean = true;
            this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast(new Intent("com.tencent.av.ui.AVLoadingDialogActivity.ACTION_LOADING_FINISH"));
            lcg.d(this.jdField_b_of_type_JavaLangString, "onCreate,VideoAppInterface.UIN_TYPE_PUBLIC_ACCOUNT exit: " + paramBundle);
            finish();
            return;
          }
        }
      }
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_Lfb);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_Mcf);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_Lgg);
    this.jdField_a_of_type_ComTencentAvVideoController.b();
    a();
    d();
    this.jdField_a_of_type_JavaLangString = a(getIntent());
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (!a(getIntent())) && (!lcx.a().a(this.jdField_a_of_type_JavaLangString)))
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a(false, 204, new int[] { this.jdField_a_of_type_ComTencentAvVideoController.a().C });
      this.jdField_a_of_type_ComTencentAvVideoController.b(204);
      lcx.a().a(this.jdField_a_of_type_JavaLangString, false);
    }
    for (;;)
    {
      if (!this.jdField_a_of_type_ComTencentAvVideoController.a().a()) {
        c(l1);
      }
      GraphicRenderMgr.getInstance();
      ThreadManager.post(new AVActivity.4(this), 5, null, false);
      this.jdField_a_of_type_Msp = msp.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      b(0);
      a(l1, false);
      if ((this.jdField_a_of_type_ComTencentAvUiVideoControlUI instanceof DoubleVideoCtrlUI)) {
        lvz.a().a();
      }
      if (EffectSettingUi.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, false))
      {
        this.jdField_a_of_type_Mcd = new mcd(this);
        this.jdField_a_of_type_Mcd.a();
      }
      this.jdField_a_of_type_Lyw = lyw.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      i1 = this.jdField_a_of_type_ComTencentAvVideoController.a().M;
      if (QLog.isDevelopLevel()) {
        QLog.d(this.jdField_b_of_type_JavaLangString, 4, "onCreate changeVideoLayoutMode Style=" + this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int + "|" + this.jdField_a_of_type_ComTencentAvVideoController.a().M + "|" + this.jdField_a_of_type_ComTencentAvVideoController.g());
      }
      a(i1, false);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast(new Intent("com.tencent.av.ui.AVLoadingDialogActivity.ACTION_LOADING_FINISH"));
      paramBundle = (ViewStub)findViewById(2131372245);
      this.jdField_a_of_type_Mha = new mha(findViewById(2131372187), paramBundle, 2131372479, this.jdField_a_of_type_ComTencentAvVideoController, this);
      this.jdField_a_of_type_Mmk = new mmk(this, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface)) {
        findViewById(2131372414).setVisibility(0);
      }
      this.jdField_a_of_type_ComTencentAvUiGuideGuideHelper.a(this);
      AudioHelper.b(this.jdField_b_of_type_JavaLangString + ".onCreate.end");
      return;
      this.jdField_a_of_type_JavaLangString = lcx.a().a().jdField_c_of_type_JavaLangString;
    }
  }
  
  public void onDestroy()
  {
    this.mIsShadow = false;
    super.onDestroy();
    Looper.myQueue().removeIdleHandler(this.jdField_a_of_type_AndroidOsMessageQueue$IdleHandler);
    long l1 = AudioHelper.b();
    QLog.w(this.jdField_b_of_type_JavaLangString, 1, "avideo life_onDestroy, mActivityState[" + this.jdField_a_of_type_Int + "->" + 5 + "], seq[" + l1 + "], isQuit[" + this.jdField_e_of_type_Boolean + "], session[" + this.jdField_a_of_type_JavaLangString + "]");
    a("onDestroy", l1);
    this.jdField_a_of_type_ComTencentAvUiGuideGuideHelper.a(l1);
    b(5);
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(272);
    }
    if (this.jdField_a_of_type_Mmk != null)
    {
      this.jdField_a_of_type_Mmk.a(this.jdField_e_of_type_Boolean);
      this.jdField_a_of_type_Mmk = null;
    }
    if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (this.jdField_a_of_type_ComTencentAvVideoController.a() != null) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_A_of_type_Boolean) && (this.jdField_a_of_type_Min != null)) {
      this.jdField_a_of_type_Min.c();
    }
    if (this.jdField_a_of_type_Min != null)
    {
      this.jdField_a_of_type_Min.e();
      this.jdField_a_of_type_Min = null;
    }
    if (this.jdField_a_of_type_ComTencentAvCameraCameraUtils != null)
    {
      this.jdField_a_of_type_ComTencentAvCameraCameraUtils.b(this.jdField_a_of_type_Lkb);
      this.jdField_a_of_type_ComTencentAvCameraCameraUtils = null;
    }
    if (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null)
    {
      this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.p();
      this.jdField_a_of_type_ComTencentAvUiVideoLayerUI = null;
    }
    if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI != null)
    {
      this.jdField_a_of_type_ComTencentAvUiVideoControlUI.d(l1);
      this.jdField_a_of_type_ComTencentAvUiVideoControlUI = null;
    }
    if (this.jdField_a_of_type_Mby != null)
    {
      this.jdField_a_of_type_Mby.b();
      this.jdField_a_of_type_Mby = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView = null;
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_Lgg);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_Mcf);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_Lfb);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      lko locallko = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
      if (locallko != null) {
        locallko.a();
      }
    }
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null)
    {
      unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
    }
    if (this.jdField_e_of_type_Boolean)
    {
      llz.a().a();
      if (this.jdField_a_of_type_Msp != null) {
        this.jdField_a_of_type_Msp.a(this.jdField_a_of_type_JavaLangString);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i(this.jdField_b_of_type_JavaLangString, 2, "onDestroy isQuit[" + this.jdField_e_of_type_Boolean + "], session[" + this.jdField_a_of_type_JavaLangString + "]");
    }
    this.jdField_a_of_type_ComTencentAvVideoController = null;
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a().b("AVActivity.onDestroy", 0);
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = null;
    this.jdField_a_of_type_Msp = null;
    this.jdField_a_of_type_Mbl = null;
    AudioHelper.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
    this.jdField_a_of_type_Mcf = null;
    this.jdField_a_of_type_Lgg = null;
    if (this.jdField_a_of_type_Mcd != null)
    {
      this.jdField_a_of_type_Mcd.b();
      this.jdField_a_of_type_Mcd = null;
    }
    lil.a().a(null);
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(7004), this.jdField_c_of_type_JavaLangString, Boolean.valueOf(this.jdField_e_of_type_Boolean) });
    }
    ltm.a().a();
    ltm.a().a(null, null);
    zzp.a(this);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
    if (this.jdField_a_of_type_Mha != null)
    {
      axqy.b(null, "CliOper", "", "", "0X800A345", "0X800A345", this.jdField_a_of_type_Mha.a(), 0, "", "", "", "");
      this.jdField_a_of_type_Mha.g();
    }
    this.jdField_a_of_type_Mha = null;
    if (10 == BaseApplicationImpl.sProcessId)
    {
      QLog.i(this.jdField_b_of_type_JavaLangString, 1, "LeakInspector.afterOnDestroy.");
      LeakInspector.a(this);
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool = false;
    if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      bool = this.jdField_a_of_type_ComTencentAvUiVideoControlUI.a(paramInt, paramKeyEvent);
    }
    if (bool) {}
    long l1;
    do
    {
      do
      {
        do
        {
          return true;
          switch (paramInt)
          {
          case 84: 
          case 24: 
          case 25: 
          default: 
            return super.onKeyDown(paramInt, paramKeyEvent);
          }
        } while ((this.jdField_a_of_type_ComTencentAvVideoController == null) || (this.jdField_a_of_type_ComTencentAvCameraCameraUtils == null));
        paramKeyEvent = this.jdField_a_of_type_ComTencentAvVideoController.a();
      } while (((paramKeyEvent.jdField_d_of_type_Int != 2) || (!paramKeyEvent.j())) && ((paramKeyEvent.jdField_d_of_type_Int != 4) || (paramKeyEvent.jdField_g_of_type_Int < 9)));
      l1 = AudioHelper.b();
    } while (!this.jdField_a_of_type_ComTencentAvCameraCameraUtils.b(l1));
    f(l1);
    return true;
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    long l1 = AudioHelper.b();
    if (QLog.isColorLevel())
    {
      QLog.w(this.jdField_b_of_type_JavaLangString, 1, "life_onNewIntent, seq[" + l1 + "]");
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "");
    }
    if (this.jdField_a_of_type_Lyw != null) {
      this.jdField_a_of_type_Lyw.b();
    }
    setIntent(paramIntent);
    int i1 = paramIntent.getIntExtra("sessionType", 0);
    int i2 = paramIntent.getIntExtra("MultiAVType", 0);
    if ((this.jdField_b_of_type_Int == 1) || (this.jdField_b_of_type_Int == 2)) {
      if ((i1 == 3) || (i1 == 4))
      {
        if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI != null)
        {
          this.jdField_a_of_type_ComTencentAvUiVideoControlUI.d(l1);
          this.jdField_a_of_type_ComTencentAvUiVideoControlUI = null;
        }
        c(l1);
        b(0);
        a(l1, false);
      }
    }
    label164:
    do
    {
      do
      {
        do
        {
          break label164;
          do
          {
            return;
          } while ((this.jdField_b_of_type_Int != 3) && (this.jdField_b_of_type_Int != 4));
          if ((i2 != 2) && (this.jdField_a_of_type_ComTencentAvVideoController.a().C != 2)) {
            break label290;
          }
          if (this.jdField_a_of_type_ComTencentAvVideoController.a().C != i2) {
            break;
          }
          c(l1);
          if (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) {
            this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.x();
          }
        } while (this.jdField_a_of_type_ComTencentAvUiVideoControlUI == null);
        this.jdField_a_of_type_ComTencentAvUiVideoControlUI.c(paramIntent);
        return;
        if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI != null)
        {
          this.jdField_a_of_type_ComTencentAvUiVideoControlUI.d(l1);
          this.jdField_a_of_type_ComTencentAvUiVideoControlUI = null;
        }
        c(l1);
        b(0);
        a(l1, false);
        return;
        if ((i1 != 3) && (i1 != 4)) {
          break;
        }
        c(l1);
        if (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) {
          this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.x();
        }
      } while (this.jdField_a_of_type_ComTencentAvUiVideoControlUI == null);
      this.jdField_a_of_type_ComTencentAvUiVideoControlUI.c(paramIntent);
      return;
    } while ((i1 != 1) && (i1 != 2));
    label290:
    if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI != null)
    {
      this.jdField_a_of_type_ComTencentAvUiVideoControlUI.d(l1);
      this.jdField_a_of_type_ComTencentAvUiVideoControlUI = null;
    }
    c(l1);
    b(0);
    a(l1, false);
  }
  
  public void onPause()
  {
    long l1 = AudioHelper.b();
    QLog.w(this.jdField_b_of_type_JavaLangString, 1, "avideo life_onPause, seq[" + l1 + "]");
    amkf.a(this, 2, true);
    ltm.a().a(16);
    i(false);
    bcuc.a(BaseApplicationImpl.getContext(), true, 50, 1);
    this.jdField_i_of_type_Boolean = true;
    try
    {
      this.mIsShadow = false;
      super.onPause();
      b(3);
      if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
        this.jdField_a_of_type_ComTencentAvUiVideoControlUI.f();
      }
      if (this.jdField_a_of_type_ComTencentAvVideoController != null)
      {
        this.jdField_a_of_type_ComTencentAvVideoController.a("state", "0");
        if ("0".equals(lde.jdField_a_of_type_JavaLangString)) {
          this.jdField_a_of_type_ComTencentAvVideoController.a("backgroundReason", "5");
        }
      }
      QLog.d(this.jdField_b_of_type_JavaLangString, 1, "avideo life_onPause end");
      if (this.jdField_a_of_type_Mha != null)
      {
        this.jdField_a_of_type_Mha.c();
        this.jdField_a_of_type_Mha.f();
      }
      this.jdField_a_of_type_Lkw.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_a_of_type_ComTencentAvVideoController);
      return;
    }
    catch (Exception localException)
    {
      super.finish();
      QLog.w(this.jdField_b_of_type_JavaLangString, 1, "life_onPause, exit when onPause Exception, seq[" + l1 + "]", localException);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(l1, 1007);
    }
  }
  
  /* Error */
  public void onResume()
  {
    // Byte code:
    //   0: aload_0
    //   1: iconst_1
    //   2: invokevirtual 2473	com/tencent/av/ui/AVActivity:i	(Z)V
    //   5: invokestatic 242	com/tencent/mobileqq/utils/AudioHelper:b	()J
    //   8: lstore 9
    //   10: aload_0
    //   11: iconst_2
    //   12: iconst_0
    //   13: invokestatic 2471	amkf:a	(Landroid/content/Context;IZ)V
    //   16: invokestatic 2476	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   19: bipush 50
    //   21: iconst_0
    //   22: invokestatic 2508	bcuc:a	(Landroid/content/Context;II)V
    //   25: invokestatic 2476	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   28: iconst_0
    //   29: bipush 50
    //   31: iconst_1
    //   32: invokestatic 2481	bcuc:a	(Landroid/content/Context;ZII)V
    //   35: invokestatic 2476	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   38: bipush 50
    //   40: iconst_2
    //   41: invokestatic 2508	bcuc:a	(Landroid/content/Context;II)V
    //   44: new 230	java/lang/StringBuilder
    //   47: dup
    //   48: invokespecial 231	java/lang/StringBuilder:<init>	()V
    //   51: aload_0
    //   52: getfield 251	com/tencent/av/ui/AVActivity:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   55: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: ldc_w 2510
    //   61: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   67: invokestatic 2171	com/tencent/mobileqq/utils/AudioHelper:b	(Ljava/lang/String;)V
    //   70: aload_0
    //   71: iconst_0
    //   72: putfield 228	com/tencent/av/ui/AVActivity:mIsShadow	Z
    //   75: aload_0
    //   76: invokespecial 2512	mqq/app/BaseActivity:onResume	()V
    //   79: invokestatic 1568	lcx:a	()Llcx;
    //   82: invokevirtual 2000	lcx:a	()Llga;
    //   85: astore 21
    //   87: aload_0
    //   88: getfield 251	com/tencent/av/ui/AVActivity:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   91: iconst_1
    //   92: new 230	java/lang/StringBuilder
    //   95: dup
    //   96: invokespecial 231	java/lang/StringBuilder:<init>	()V
    //   99: ldc_w 2514
    //   102: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: aload_0
    //   106: getfield 557	com/tencent/av/ui/AVActivity:o	Z
    //   109: invokevirtual 458	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   112: ldc_w 519
    //   115: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: lload 9
    //   120: invokevirtual 245	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   123: ldc_w 2516
    //   126: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: aload 21
    //   131: invokevirtual 716	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   134: ldc_w 388
    //   137: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   143: invokestatic 391	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   146: aload_0
    //   147: iconst_0
    //   148: putfield 2483	com/tencent/av/ui/AVActivity:jdField_i_of_type_Boolean	Z
    //   151: invokestatic 2519	lpy:a	()V
    //   154: aload_0
    //   155: getfield 138	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvAppVideoAppInterface	Lcom/tencent/av/app/VideoAppInterface;
    //   158: iconst_4
    //   159: invokevirtual 1268	com/tencent/av/app/VideoAppInterface:a	(I)Llhd;
    //   162: checkcast 1468	liw
    //   165: astore 22
    //   167: aload 21
    //   169: getfield 871	lga:jdField_e_of_type_Boolean	Z
    //   172: ifeq +16 -> 188
    //   175: aload 22
    //   177: aload 21
    //   179: invokevirtual 1469	lga:b	()J
    //   182: bipush 8
    //   184: lconst_1
    //   185: invokevirtual 1474	liw:a	(JIJ)V
    //   188: aload_0
    //   189: invokevirtual 1105	com/tencent/av/ui/AVActivity:getIntent	()Landroid/content/Intent;
    //   192: ldc_w 2255
    //   195: iconst_0
    //   196: invokevirtual 283	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   199: ifeq +13 -> 212
    //   202: aload 22
    //   204: ldc2_w 2256
    //   207: iconst_3
    //   208: lconst_1
    //   209: invokevirtual 1474	liw:a	(JIJ)V
    //   212: aload_0
    //   213: getfield 138	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvAppVideoAppInterface	Lcom/tencent/av/app/VideoAppInterface;
    //   216: invokevirtual 2520	com/tencent/av/app/VideoAppInterface:i	()Z
    //   219: ifne +10 -> 229
    //   222: aload_0
    //   223: getfield 138	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvAppVideoAppInterface	Lcom/tencent/av/app/VideoAppInterface;
    //   226: invokevirtual 2521	com/tencent/av/app/VideoAppInterface:b	()V
    //   229: aload_0
    //   230: getfield 557	com/tencent/av/ui/AVActivity:o	Z
    //   233: ifeq +19 -> 252
    //   236: aload_0
    //   237: getfield 78	com/tencent/av/ui/AVActivity:jdField_b_of_type_Int	I
    //   240: iconst_1
    //   241: if_icmpeq +11 -> 252
    //   244: aload_0
    //   245: getfield 78	com/tencent/av/ui/AVActivity:jdField_b_of_type_Int	I
    //   248: iconst_2
    //   249: if_icmpne +3 -> 252
    //   252: aload_0
    //   253: iconst_0
    //   254: putfield 557	com/tencent/av/ui/AVActivity:o	Z
    //   257: aload_0
    //   258: iconst_0
    //   259: putfield 202	com/tencent/av/ui/AVActivity:jdField_k_of_type_Boolean	Z
    //   262: aload_0
    //   263: iconst_2
    //   264: invokevirtual 2326	com/tencent/av/ui/AVActivity:b	(I)V
    //   267: aload_0
    //   268: getfield 140	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvVideoController	Lcom/tencent/av/VideoController;
    //   271: iconst_1
    //   272: invokevirtual 1367	com/tencent/av/VideoController:i	(Z)V
    //   275: aload_0
    //   276: getfield 317	com/tencent/av/ui/AVActivity:jdField_a_of_type_Lyw	Llyw;
    //   279: ifnull +10 -> 289
    //   282: aload_0
    //   283: getfield 317	com/tencent/av/ui/AVActivity:jdField_a_of_type_Lyw	Llyw;
    //   286: invokevirtual 2458	lyw:b	()V
    //   289: aload_0
    //   290: getfield 138	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvAppVideoAppInterface	Lcom/tencent/av/app/VideoAppInterface;
    //   293: invokevirtual 985	com/tencent/av/app/VideoAppInterface:a	()Landroid/os/Handler;
    //   296: new 2523	com/tencent/av/ui/AVActivity$11
    //   299: dup
    //   300: aload_0
    //   301: lload 9
    //   303: invokespecial 2525	com/tencent/av/ui/AVActivity$11:<init>	(Lcom/tencent/av/ui/AVActivity;J)V
    //   306: ldc2_w 2526
    //   309: invokevirtual 994	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   312: pop
    //   313: aload 21
    //   315: getfield 504	lga:jdField_d_of_type_Int	I
    //   318: iconst_2
    //   319: if_icmpne +1084 -> 1403
    //   322: aload 21
    //   324: invokevirtual 2450	lga:j	()Z
    //   327: ifeq +1022 -> 1349
    //   330: aload 21
    //   332: getfield 1170	lga:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   335: astore 19
    //   337: aload 21
    //   339: getfield 2528	lga:jdField_k_of_type_Boolean	Z
    //   342: istore 16
    //   344: aload_0
    //   345: getfield 140	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvVideoController	Lcom/tencent/av/VideoController;
    //   348: aload_0
    //   349: getfield 92	com/tencent/av/ui/AVActivity:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   352: invokevirtual 2530	com/tencent/av/VideoController:b	(Ljava/lang/String;)I
    //   355: iconst_5
    //   356: if_icmpne +874 -> 1230
    //   359: iconst_1
    //   360: istore 15
    //   362: aload 21
    //   364: getfield 2531	lga:jdField_i_of_type_Boolean	Z
    //   367: istore 17
    //   369: aload 21
    //   371: getfield 2532	lga:jdField_j_of_type_Boolean	Z
    //   374: istore 18
    //   376: iload 18
    //   378: ifeq +41 -> 419
    //   381: invokestatic 2536	bbdh:d	()Ljava/lang/String;
    //   384: astore 20
    //   386: aload_0
    //   387: getfield 877	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvCameraCameraUtils	Lcom/tencent/av/camera/CameraUtils;
    //   390: lload 9
    //   392: invokevirtual 2538	com/tencent/av/camera/CameraUtils:a	(J)Z
    //   395: ifne +841 -> 1236
    //   398: aload_0
    //   399: getfield 877	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvCameraCameraUtils	Lcom/tencent/av/camera/CameraUtils;
    //   402: lload 9
    //   404: invokevirtual 885	com/tencent/av/camera/CameraUtils:b	(J)Z
    //   407: ifne +829 -> 1236
    //   410: aload_0
    //   411: getfield 877	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvCameraCameraUtils	Lcom/tencent/av/camera/CameraUtils;
    //   414: lload 9
    //   416: invokevirtual 2539	com/tencent/av/camera/CameraUtils:a	(J)V
    //   419: aload_0
    //   420: getfield 582	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   423: ifnull +59 -> 482
    //   426: iload 18
    //   428: ifeq +877 -> 1305
    //   431: iload 16
    //   433: ifeq +872 -> 1305
    //   436: iload 17
    //   438: ifeq +836 -> 1274
    //   441: aload_0
    //   442: getfield 582	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   445: lload 9
    //   447: aload 19
    //   449: iconst_1
    //   450: iconst_1
    //   451: iconst_0
    //   452: iload 15
    //   454: invokevirtual 1354	com/tencent/av/ui/VideoLayerUI:a	(JLjava/lang/String;IZZZ)V
    //   457: aload_0
    //   458: getfield 138	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvAppVideoAppInterface	Lcom/tencent/av/app/VideoAppInterface;
    //   461: ldc_w 2540
    //   464: invokestatic 2543	mpv:a	(Lcom/tencent/av/app/VideoAppInterface;Ljava/lang/String;)Z
    //   467: istore 15
    //   469: aload_0
    //   470: getfield 582	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   473: lload 9
    //   475: iconst_1
    //   476: iload 15
    //   478: invokevirtual 880	com/tencent/av/ui/VideoLayerUI:a	(JZZ)Z
    //   481: pop
    //   482: aload_0
    //   483: getfield 582	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   486: ifnull +10 -> 496
    //   489: aload_0
    //   490: getfield 582	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   493: invokevirtual 2545	com/tencent/av/ui/VideoLayerUI:q	()V
    //   496: aload_0
    //   497: getfield 501	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoControlUI	Lcom/tencent/av/ui/VideoControlUI;
    //   500: ifnull +12 -> 512
    //   503: aload_0
    //   504: getfield 501	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoControlUI	Lcom/tencent/av/ui/VideoControlUI;
    //   507: lload 9
    //   509: invokevirtual 2547	com/tencent/av/ui/VideoControlUI:b	(J)V
    //   512: aload_0
    //   513: getfield 532	com/tencent/av/ui/AVActivity:jdField_a_of_type_Mby	Lmby;
    //   516: ifnull +10 -> 526
    //   519: aload_0
    //   520: getfield 532	com/tencent/av/ui/AVActivity:jdField_a_of_type_Mby	Lmby;
    //   523: invokevirtual 2548	mby:c	()V
    //   526: aload_0
    //   527: getfield 140	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvVideoController	Lcom/tencent/av/VideoController;
    //   530: iconst_0
    //   531: invokevirtual 1365	com/tencent/av/VideoController:a	(Z)I
    //   534: pop
    //   535: aload_0
    //   536: invokevirtual 2549	com/tencent/av/ui/AVActivity:b	()V
    //   539: aload_0
    //   540: invokevirtual 2550	com/tencent/av/ui/AVActivity:e	()V
    //   543: aload_0
    //   544: getfield 138	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvAppVideoAppInterface	Lcom/tencent/av/app/VideoAppInterface;
    //   547: invokevirtual 2278	com/tencent/av/app/VideoAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   550: new 262	android/content/Intent
    //   553: dup
    //   554: ldc_w 2229
    //   557: invokespecial 2230	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   560: invokevirtual 2281	com/tencent/qphone/base/util/BaseApplication:sendBroadcast	(Landroid/content/Intent;)V
    //   563: aload_0
    //   564: getfield 582	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   567: ifnull +20 -> 587
    //   570: aload_0
    //   571: invokevirtual 546	com/tencent/av/ui/AVActivity:a	()Z
    //   574: ifeq +13 -> 587
    //   577: aload_0
    //   578: getfield 582	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   581: ldc_w 2540
    //   584: invokevirtual 2069	com/tencent/av/ui/VideoLayerUI:a	(Ljava/lang/String;)V
    //   587: aload 21
    //   589: getfield 504	lga:jdField_d_of_type_Int	I
    //   592: iconst_2
    //   593: if_icmpeq +12 -> 605
    //   596: aload 21
    //   598: getfield 504	lga:jdField_d_of_type_Int	I
    //   601: iconst_1
    //   602: if_icmpne +45 -> 647
    //   605: aload_0
    //   606: getfield 602	com/tencent/av/ui/AVActivity:jdField_a_of_type_Min	Lmin;
    //   609: ifnull +38 -> 647
    //   612: aload_0
    //   613: getfield 602	com/tencent/av/ui/AVActivity:jdField_a_of_type_Min	Lmin;
    //   616: invokevirtual 2552	min:d	()I
    //   619: iconst_1
    //   620: if_icmpne +27 -> 647
    //   623: aload 21
    //   625: getfield 952	lga:B	Z
    //   628: ifeq +19 -> 647
    //   631: aload_0
    //   632: getfield 220	com/tencent/av/ui/AVActivity:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   635: new 2554	com/tencent/av/ui/AVActivity$13
    //   638: dup
    //   639: aload_0
    //   640: invokespecial 2555	com/tencent/av/ui/AVActivity$13:<init>	(Lcom/tencent/av/ui/AVActivity;)V
    //   643: invokevirtual 1228	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   646: pop
    //   647: aload 21
    //   649: getfield 2558	lga:W	I
    //   652: iconst_m1
    //   653: if_icmpne +12 -> 665
    //   656: aload 21
    //   658: aload_0
    //   659: invokevirtual 2559	com/tencent/av/ui/AVActivity:a	()I
    //   662: putfield 2558	lga:W	I
    //   665: aload 21
    //   667: getfield 2562	lga:V	I
    //   670: iconst_m1
    //   671: if_icmpne +105 -> 776
    //   674: aload_0
    //   675: invokevirtual 563	com/tencent/av/ui/AVActivity:getApplicationContext	()Landroid/content/Context;
    //   678: invokestatic 672	bbkb:a	(Landroid/content/Context;)Landroid/content/SharedPreferences;
    //   681: astore 19
    //   683: aload 21
    //   685: aload 19
    //   687: new 230	java/lang/StringBuilder
    //   690: dup
    //   691: invokespecial 231	java/lang/StringBuilder:<init>	()V
    //   694: ldc_w 2564
    //   697: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   700: aload_0
    //   701: getfield 138	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvAppVideoAppInterface	Lcom/tencent/av/app/VideoAppInterface;
    //   704: invokevirtual 677	com/tencent/av/app/VideoAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   707: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   710: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   713: iconst_1
    //   714: invokeinterface 687 3 0
    //   719: putfield 2562	lga:V	I
    //   722: aload 21
    //   724: getfield 2562	lga:V	I
    //   727: iconst_1
    //   728: if_icmpne +48 -> 776
    //   731: aload 19
    //   733: invokeinterface 2568 1 0
    //   738: new 230	java/lang/StringBuilder
    //   741: dup
    //   742: invokespecial 231	java/lang/StringBuilder:<init>	()V
    //   745: ldc_w 2564
    //   748: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   751: aload_0
    //   752: getfield 138	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvAppVideoAppInterface	Lcom/tencent/av/app/VideoAppInterface;
    //   755: invokevirtual 677	com/tencent/av/app/VideoAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   758: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   761: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   764: iconst_0
    //   765: invokeinterface 2574 3 0
    //   770: invokeinterface 2577 1 0
    //   775: pop
    //   776: aload 21
    //   778: getfield 2005	lga:u	I
    //   781: ifeq +38 -> 819
    //   784: aload 21
    //   786: getfield 2005	lga:u	I
    //   789: iconst_1
    //   790: if_icmpne +1305 -> 2095
    //   793: aload_0
    //   794: iconst_2
    //   795: aload_0
    //   796: invokevirtual 729	com/tencent/av/ui/AVActivity:getResources	()Landroid/content/res/Resources;
    //   799: ldc_w 2578
    //   802: invokevirtual 2579	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   805: iconst_0
    //   806: invokestatic 2584	bcql:a	(Landroid/content/Context;ILjava/lang/CharSequence;I)Lbcql;
    //   809: invokevirtual 2587	bcql:a	()Landroid/widget/Toast;
    //   812: pop
    //   813: aload 21
    //   815: iconst_0
    //   816: putfield 2005	lga:u	I
    //   819: aload_0
    //   820: getfield 138	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvAppVideoAppInterface	Lcom/tencent/av/app/VideoAppInterface;
    //   823: iconst_2
    //   824: anewarray 1262	java/lang/Object
    //   827: dup
    //   828: iconst_0
    //   829: sipush 7000
    //   832: invokestatic 2088	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   835: aastore
    //   836: dup
    //   837: iconst_1
    //   838: aload_0
    //   839: getfield 92	com/tencent/av/ui/AVActivity:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   842: aastore
    //   843: invokevirtual 1265	com/tencent/av/app/VideoAppInterface:a	([Ljava/lang/Object;)V
    //   846: invokestatic 658	com/tencent/mobileqq/utils/AudioHelper:d	()Z
    //   849: ifeq +10 -> 859
    //   852: aload_0
    //   853: getfield 138	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvAppVideoAppInterface	Lcom/tencent/av/app/VideoAppInterface;
    //   856: invokestatic 2590	com/tencent/mobileqq/debug/PstnCardTestActivity:showTestBtn	(Lcom/tencent/av/app/VideoAppInterface;)V
    //   859: invokestatic 1217	ltm:a	()Lltm;
    //   862: bipush 16
    //   864: invokevirtual 2591	ltm:b	(I)V
    //   867: aload 21
    //   869: getfield 2532	lga:jdField_j_of_type_Boolean	Z
    //   872: istore 15
    //   874: aload 21
    //   876: getfield 2528	lga:jdField_k_of_type_Boolean	Z
    //   879: istore 16
    //   881: iload 15
    //   883: ifeq +8 -> 891
    //   886: iload 16
    //   888: ifne +1230 -> 2118
    //   891: invokestatic 1217	ltm:a	()Lltm;
    //   894: iconst_1
    //   895: invokevirtual 2472	ltm:a	(I)V
    //   898: invokestatic 2594	java/lang/System:currentTimeMillis	()J
    //   901: lstore 11
    //   903: invokestatic 2332	lvz:a	()Llvz;
    //   906: getfield 2595	lvz:jdField_b_of_type_Long	J
    //   909: lstore 13
    //   911: aload 21
    //   913: invokevirtual 1469	lga:b	()J
    //   916: lconst_0
    //   917: lcmp
    //   918: ifle +1210 -> 2128
    //   921: aload 21
    //   923: invokevirtual 1469	lga:b	()J
    //   926: lstore 7
    //   928: aload 22
    //   930: lload 7
    //   932: bipush 25
    //   934: lload 11
    //   936: lload 13
    //   938: lsub
    //   939: invokevirtual 1474	liw:a	(JIJ)V
    //   942: aload_0
    //   943: getfield 140	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvVideoController	Lcom/tencent/av/VideoController;
    //   946: ldc_w 2488
    //   949: ldc_w 2597
    //   952: invokevirtual 2161	com/tencent/av/VideoController:a	(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/av/VideoController;
    //   955: pop
    //   956: ldc_w 2490
    //   959: putstatic 2164	lde:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   962: new 230	java/lang/StringBuilder
    //   965: dup
    //   966: invokespecial 231	java/lang/StringBuilder:<init>	()V
    //   969: aload_0
    //   970: getfield 251	com/tencent/av/ui/AVActivity:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   973: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   976: ldc_w 2599
    //   979: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   982: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   985: invokestatic 2171	com/tencent/mobileqq/utils/AudioHelper:b	(Ljava/lang/String;)V
    //   988: aload_0
    //   989: invokevirtual 1105	com/tencent/av/ui/AVActivity:getIntent	()Landroid/content/Intent;
    //   992: ldc_w 2601
    //   995: iconst_0
    //   996: invokevirtual 266	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   999: ifeq +21 -> 1020
    //   1002: invokestatic 2606	aabg:a	()Laabg;
    //   1005: aload_0
    //   1006: invokevirtual 1105	com/tencent/av/ui/AVActivity:getIntent	()Landroid/content/Intent;
    //   1009: ldc_w 2601
    //   1012: iconst_0
    //   1013: invokevirtual 266	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   1016: iconst_1
    //   1017: invokevirtual 2607	aabg:a	(IZ)V
    //   1020: aload_0
    //   1021: invokevirtual 2608	com/tencent/av/ui/AVActivity:a	()Lcom/tencent/av/VideoController;
    //   1024: invokevirtual 2609	com/tencent/av/VideoController:x	()V
    //   1027: invokestatic 2610	com/tencent/av/VideoController:a	()Lcom/tencent/av/VideoController;
    //   1030: aload_0
    //   1031: invokevirtual 1068	com/tencent/av/VideoController:a	(Landroid/content/Context;)Llpu;
    //   1034: astore 19
    //   1036: aload 19
    //   1038: ifnull +12 -> 1050
    //   1041: aload 19
    //   1043: lload 9
    //   1045: invokeinterface 2613 3 0
    //   1050: invokestatic 658	com/tencent/mobileqq/utils/AudioHelper:d	()Z
    //   1053: ifeq +46 -> 1099
    //   1056: aload_0
    //   1057: getfield 251	com/tencent/av/ui/AVActivity:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1060: iconst_1
    //   1061: new 230	java/lang/StringBuilder
    //   1064: dup
    //   1065: invokespecial 231	java/lang/StringBuilder:<init>	()V
    //   1068: ldc_w 2615
    //   1071: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1074: aload_0
    //   1075: invokevirtual 1933	com/tencent/av/ui/AVActivity:getWindow	()Landroid/view/Window;
    //   1078: invokevirtual 432	android/view/Window:getDecorView	()Landroid/view/View;
    //   1081: invokevirtual 437	android/view/View:getSystemUiVisibility	()I
    //   1084: invokevirtual 302	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1087: ldc_w 388
    //   1090: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1093: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1096: invokestatic 391	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1099: aload_0
    //   1100: getfield 178	com/tencent/av/ui/AVActivity:jdField_a_of_type_Lkw	Llkw;
    //   1103: aload_0
    //   1104: aload_0
    //   1105: getfield 138	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvAppVideoAppInterface	Lcom/tencent/av/app/VideoAppInterface;
    //   1108: aload_0
    //   1109: getfield 140	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvVideoController	Lcom/tencent/av/VideoController;
    //   1112: invokevirtual 2618	lkw:a	(Lmqq/app/BaseActivity;Lcom/tencent/av/app/VideoAppInterface;Lcom/tencent/av/VideoController;)V
    //   1115: aload_0
    //   1116: getfield 900	com/tencent/av/ui/AVActivity:jdField_a_of_type_Mmk	Lmmk;
    //   1119: ifnull +76 -> 1195
    //   1122: invokestatic 297	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1125: ifeq +41 -> 1166
    //   1128: aload_0
    //   1129: getfield 251	com/tencent/av/ui/AVActivity:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1132: iconst_2
    //   1133: new 230	java/lang/StringBuilder
    //   1136: dup
    //   1137: invokespecial 231	java/lang/StringBuilder:<init>	()V
    //   1140: ldc_w 2620
    //   1143: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1146: aload 21
    //   1148: getfield 2623	lga:aA	Z
    //   1151: invokevirtual 458	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1154: ldc_w 388
    //   1157: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1160: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1163: invokestatic 718	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1166: aload 21
    //   1168: getfield 2623	lga:aA	Z
    //   1171: ifeq +17 -> 1188
    //   1174: aload_0
    //   1175: getfield 900	com/tencent/av/ui/AVActivity:jdField_a_of_type_Mmk	Lmmk;
    //   1178: iconst_0
    //   1179: invokevirtual 2624	mmk:a	(I)V
    //   1182: aload 21
    //   1184: iconst_0
    //   1185: putfield 2623	lga:aA	Z
    //   1188: aload_0
    //   1189: getfield 900	com/tencent/av/ui/AVActivity:jdField_a_of_type_Mmk	Lmmk;
    //   1192: invokevirtual 904	mmk:a	()V
    //   1195: return
    //   1196: astore 19
    //   1198: aload_0
    //   1199: getfield 251	com/tencent/av/ui/AVActivity:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1202: iconst_1
    //   1203: new 230	java/lang/StringBuilder
    //   1206: dup
    //   1207: invokespecial 231	java/lang/StringBuilder:<init>	()V
    //   1210: ldc_w 2626
    //   1213: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1216: aload 19
    //   1218: invokevirtual 716	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1221: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1224: invokestatic 307	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1227: goto -1148 -> 79
    //   1230: iconst_0
    //   1231: istore 15
    //   1233: goto -871 -> 362
    //   1236: aload 20
    //   1238: ldc_w 2628
    //   1241: invokevirtual 2631	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1244: ifeq -825 -> 419
    //   1247: aload_0
    //   1248: getfield 877	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvCameraCameraUtils	Lcom/tencent/av/camera/CameraUtils;
    //   1251: invokevirtual 2634	com/tencent/av/camera/CameraUtils:a	()Landroid/hardware/Camera$Parameters;
    //   1254: ifnonnull -835 -> 419
    //   1257: aload_0
    //   1258: getfield 877	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvCameraCameraUtils	Lcom/tencent/av/camera/CameraUtils;
    //   1261: ldc_w 2636
    //   1264: lload 9
    //   1266: iconst_m1
    //   1267: iconst_m1
    //   1268: invokevirtual 2639	com/tencent/av/camera/CameraUtils:a	(Ljava/lang/String;JII)V
    //   1271: goto -852 -> 419
    //   1274: aload_0
    //   1275: getfield 582	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   1278: lload 9
    //   1280: iconst_1
    //   1281: iconst_0
    //   1282: invokevirtual 880	com/tencent/av/ui/VideoLayerUI:a	(JZZ)Z
    //   1285: pop
    //   1286: aload_0
    //   1287: getfield 582	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   1290: lload 9
    //   1292: aload 19
    //   1294: iconst_1
    //   1295: iconst_1
    //   1296: iconst_0
    //   1297: iload 15
    //   1299: invokevirtual 1354	com/tencent/av/ui/VideoLayerUI:a	(JLjava/lang/String;IZZZ)V
    //   1302: goto -820 -> 482
    //   1305: iload 18
    //   1307: ifeq +18 -> 1325
    //   1310: aload_0
    //   1311: getfield 582	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   1314: lload 9
    //   1316: iconst_1
    //   1317: iconst_0
    //   1318: invokevirtual 880	com/tencent/av/ui/VideoLayerUI:a	(JZZ)Z
    //   1321: pop
    //   1322: goto -840 -> 482
    //   1325: iload 16
    //   1327: ifeq -845 -> 482
    //   1330: aload_0
    //   1331: getfield 582	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   1334: lload 9
    //   1336: aload 19
    //   1338: iconst_1
    //   1339: iconst_1
    //   1340: iconst_0
    //   1341: iload 15
    //   1343: invokevirtual 1354	com/tencent/av/ui/VideoLayerUI:a	(JLjava/lang/String;IZZZ)V
    //   1346: goto -864 -> 482
    //   1349: aload 21
    //   1351: getfield 1778	lga:ag	Z
    //   1354: ifne -872 -> 482
    //   1357: aload_0
    //   1358: getfield 124	com/tencent/av/ui/AVActivity:jdField_f_of_type_Boolean	Z
    //   1361: ifne -879 -> 482
    //   1364: aload 21
    //   1366: lload 9
    //   1368: iconst_1
    //   1369: invokevirtual 888	lga:a	(JZ)V
    //   1372: aload_0
    //   1373: getfield 877	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvCameraCameraUtils	Lcom/tencent/av/camera/CameraUtils;
    //   1376: lload 9
    //   1378: invokevirtual 2539	com/tencent/av/camera/CameraUtils:a	(J)V
    //   1381: aload_0
    //   1382: getfield 582	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   1385: ifnull -903 -> 482
    //   1388: aload_0
    //   1389: getfield 582	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   1392: lload 9
    //   1394: iconst_1
    //   1395: iconst_0
    //   1396: invokevirtual 880	com/tencent/av/ui/VideoLayerUI:a	(JZZ)Z
    //   1399: pop
    //   1400: goto -918 -> 482
    //   1403: aload 21
    //   1405: getfield 504	lga:jdField_d_of_type_Int	I
    //   1408: iconst_4
    //   1409: if_icmpne -927 -> 482
    //   1412: aload 21
    //   1414: getfield 1326	lga:jdField_c_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   1417: astore 23
    //   1419: aload 23
    //   1421: new 2641	max
    //   1424: dup
    //   1425: aload_0
    //   1426: invokespecial 2642	max:<init>	(Lcom/tencent/av/ui/AVActivity;)V
    //   1429: invokestatic 2648	java/util/Collections:sort	(Ljava/util/List;Ljava/util/Comparator;)V
    //   1432: aload_0
    //   1433: getfield 140	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvVideoController	Lcom/tencent/av/VideoController;
    //   1436: invokevirtual 2354	com/tencent/av/VideoController:g	()I
    //   1439: istore 4
    //   1441: iconst_0
    //   1442: istore_3
    //   1443: iload_3
    //   1444: aload 23
    //   1446: invokevirtual 1331	java/util/ArrayList:size	()I
    //   1449: if_icmpge -967 -> 482
    //   1452: aload 23
    //   1454: iload_3
    //   1455: invokevirtual 1335	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1458: checkcast 1337	lon
    //   1461: astore 24
    //   1463: aload 24
    //   1465: getfield 1338	lon:jdField_a_of_type_Long	J
    //   1468: invokestatic 1343	mqu:a	(J)Ljava/lang/String;
    //   1471: astore 25
    //   1473: aload 24
    //   1475: getfield 1344	lon:jdField_a_of_type_Int	I
    //   1478: istore 5
    //   1480: aload 24
    //   1482: getfield 2649	lon:jdField_a_of_type_Boolean	Z
    //   1485: istore 16
    //   1487: aload_0
    //   1488: getfield 582	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   1491: ifnull +371 -> 1862
    //   1494: aload_0
    //   1495: getfield 582	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   1498: aload 25
    //   1500: iload 5
    //   1502: invokevirtual 2652	com/tencent/av/ui/VideoLayerUI:a	(Ljava/lang/String;I)Z
    //   1505: istore 15
    //   1507: aload_0
    //   1508: getfield 84	com/tencent/av/ui/AVActivity:jdField_d_of_type_Int	I
    //   1511: invokestatic 2655	mqo:b	(I)I
    //   1514: istore 6
    //   1516: aload_0
    //   1517: getfield 138	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvAppVideoAppInterface	Lcom/tencent/av/app/VideoAppInterface;
    //   1520: iload 6
    //   1522: aload 25
    //   1524: aload 21
    //   1526: getfield 1604	lga:jdField_g_of_type_Long	J
    //   1529: invokestatic 1507	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1532: invokevirtual 2014	com/tencent/av/app/VideoAppInterface:getDisplayName	(ILjava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1535: astore 20
    //   1537: aload 24
    //   1539: getfield 2656	lon:jdField_b_of_type_Boolean	Z
    //   1542: ifeq +126 -> 1668
    //   1545: aload 25
    //   1547: aload_0
    //   1548: getfield 138	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvAppVideoAppInterface	Lcom/tencent/av/app/VideoAppInterface;
    //   1551: invokevirtual 677	com/tencent/av/app/VideoAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1554: invokevirtual 1351	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1557: ifne +111 -> 1668
    //   1560: iload 16
    //   1562: ifeq +106 -> 1668
    //   1565: aload 24
    //   1567: getfield 2657	lon:jdField_d_of_type_Boolean	Z
    //   1570: ifne +98 -> 1668
    //   1573: aload 20
    //   1575: invokestatic 2659	mqu:a	(Ljava/lang/String;)I
    //   1578: bipush 20
    //   1580: if_icmple +561 -> 2141
    //   1583: new 230	java/lang/StringBuilder
    //   1586: dup
    //   1587: invokespecial 231	java/lang/StringBuilder:<init>	()V
    //   1590: aload 20
    //   1592: iconst_0
    //   1593: bipush 20
    //   1595: invokestatic 2662	mqu:a	(Ljava/lang/String;II)Ljava/lang/String;
    //   1598: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1601: ldc_w 2664
    //   1604: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1607: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1610: astore 19
    //   1612: iload 5
    //   1614: iconst_2
    //   1615: if_icmpne +269 -> 1884
    //   1618: aload_0
    //   1619: ldc_w 2665
    //   1622: invokevirtual 2666	com/tencent/av/ui/AVActivity:getString	(I)Ljava/lang/String;
    //   1625: iconst_1
    //   1626: anewarray 1262	java/lang/Object
    //   1629: dup
    //   1630: iconst_0
    //   1631: aload 19
    //   1633: aastore
    //   1634: invokestatic 2670	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1637: astore 19
    //   1639: aload_0
    //   1640: getfield 501	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoControlUI	Lcom/tencent/av/ui/VideoControlUI;
    //   1643: ifnull +225 -> 1868
    //   1646: aload_0
    //   1647: getfield 501	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoControlUI	Lcom/tencent/av/ui/VideoControlUI;
    //   1650: instanceof 2672
    //   1653: ifeq +215 -> 1868
    //   1656: aload_0
    //   1657: getfield 501	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoControlUI	Lcom/tencent/av/ui/VideoControlUI;
    //   1660: sipush 1036
    //   1663: aload 19
    //   1665: invokevirtual 2675	com/tencent/av/ui/VideoControlUI:a	(ILjava/lang/String;)V
    //   1668: aload_0
    //   1669: getfield 582	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   1672: ifnull +183 -> 1855
    //   1675: aload_0
    //   1676: invokespecial 356	com/tencent/av/ui/AVActivity:j	()V
    //   1679: aload 24
    //   1681: getfield 2656	lon:jdField_b_of_type_Boolean	Z
    //   1684: ifne +381 -> 2065
    //   1687: aload 24
    //   1689: getfield 2649	lon:jdField_a_of_type_Boolean	Z
    //   1692: ifne +373 -> 2065
    //   1695: iload 4
    //   1697: iconst_4
    //   1698: if_icmpeq +337 -> 2035
    //   1701: aload 21
    //   1703: getfield 2678	lga:E	I
    //   1706: iconst_2
    //   1707: if_icmpne +246 -> 1953
    //   1710: aconst_null
    //   1711: ldc_w 1140
    //   1714: ldc_w 397
    //   1717: ldc_w 397
    //   1720: ldc_w 2680
    //   1723: ldc_w 2680
    //   1726: iconst_0
    //   1727: iconst_0
    //   1728: ldc_w 397
    //   1731: ldc_w 397
    //   1734: ldc_w 397
    //   1737: ldc_w 397
    //   1740: invokestatic 1148	axqy:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1743: aload_0
    //   1744: getfield 582	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   1747: lload 9
    //   1749: aload 25
    //   1751: iload 5
    //   1753: aload_0
    //   1754: getfield 144	com/tencent/av/ui/AVActivity:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   1757: aload 24
    //   1759: getfield 2656	lon:jdField_b_of_type_Boolean	Z
    //   1762: aload 24
    //   1764: getfield 2649	lon:jdField_a_of_type_Boolean	Z
    //   1767: invokevirtual 2683	com/tencent/av/ui/VideoLayerUI:a	(JLjava/lang/String;ILandroid/graphics/Bitmap;ZZ)V
    //   1770: iload 15
    //   1772: ifne +83 -> 1855
    //   1775: aload 21
    //   1777: getfield 1450	lga:I	Z
    //   1780: ifne +75 -> 1855
    //   1783: ldc_w 2684
    //   1786: fstore_2
    //   1787: fload_2
    //   1788: fstore_1
    //   1789: aload_0
    //   1790: getfield 582	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   1793: aload 25
    //   1795: iload 5
    //   1797: invokevirtual 2686	com/tencent/av/ui/VideoLayerUI:b	(Ljava/lang/String;I)Z
    //   1800: ifeq +20 -> 1820
    //   1803: fload_2
    //   1804: fstore_1
    //   1805: aload_0
    //   1806: getfield 582	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   1809: invokevirtual 833	com/tencent/av/ui/VideoLayerUI:f	()I
    //   1812: iconst_3
    //   1813: if_icmpeq +7 -> 1820
    //   1816: ldc_w 2687
    //   1819: fstore_1
    //   1820: aload_0
    //   1821: invokevirtual 563	com/tencent/av/ui/AVActivity:getApplicationContext	()Landroid/content/Context;
    //   1824: fload_1
    //   1825: invokestatic 2690	muc:a	(Landroid/content/Context;F)F
    //   1828: fstore_1
    //   1829: aload_0
    //   1830: getfield 582	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   1833: aload 25
    //   1835: iload 5
    //   1837: aload 20
    //   1839: fload_1
    //   1840: iconst_m1
    //   1841: invokevirtual 2693	com/tencent/av/ui/VideoLayerUI:a	(Ljava/lang/String;ILjava/lang/String;FI)V
    //   1844: aload_0
    //   1845: getfield 582	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   1848: aload 25
    //   1850: iload 5
    //   1852: invokevirtual 2694	com/tencent/av/ui/VideoLayerUI:a	(Ljava/lang/String;I)V
    //   1855: iload_3
    //   1856: iconst_1
    //   1857: iadd
    //   1858: istore_3
    //   1859: goto -416 -> 1443
    //   1862: iconst_0
    //   1863: istore 15
    //   1865: goto -358 -> 1507
    //   1868: aload_0
    //   1869: getfield 138	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvAppVideoAppInterface	Lcom/tencent/av/app/VideoAppInterface;
    //   1872: sipush 1036
    //   1875: aload 19
    //   1877: invokestatic 2697	mao:a	(Lcom/tencent/av/app/VideoAppInterface;ILjava/lang/String;)Z
    //   1880: pop
    //   1881: goto -213 -> 1668
    //   1884: aload_0
    //   1885: ldc_w 2698
    //   1888: invokevirtual 2666	com/tencent/av/ui/AVActivity:getString	(I)Ljava/lang/String;
    //   1891: iconst_1
    //   1892: anewarray 1262	java/lang/Object
    //   1895: dup
    //   1896: iconst_0
    //   1897: aload 19
    //   1899: aastore
    //   1900: invokestatic 2670	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1903: astore 19
    //   1905: aload_0
    //   1906: getfield 501	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoControlUI	Lcom/tencent/av/ui/VideoControlUI;
    //   1909: ifnull +28 -> 1937
    //   1912: aload_0
    //   1913: getfield 501	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoControlUI	Lcom/tencent/av/ui/VideoControlUI;
    //   1916: instanceof 2672
    //   1919: ifeq +18 -> 1937
    //   1922: aload_0
    //   1923: getfield 501	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoControlUI	Lcom/tencent/av/ui/VideoControlUI;
    //   1926: sipush 1037
    //   1929: aload 19
    //   1931: invokevirtual 2675	com/tencent/av/ui/VideoControlUI:a	(ILjava/lang/String;)V
    //   1934: goto -266 -> 1668
    //   1937: aload_0
    //   1938: getfield 138	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvAppVideoAppInterface	Lcom/tencent/av/app/VideoAppInterface;
    //   1941: sipush 1037
    //   1944: aload 19
    //   1946: invokestatic 2697	mao:a	(Lcom/tencent/av/app/VideoAppInterface;ILjava/lang/String;)Z
    //   1949: pop
    //   1950: goto -282 -> 1668
    //   1953: aload 21
    //   1955: getfield 1242	lga:C	I
    //   1958: bipush 10
    //   1960: if_icmpne +39 -> 1999
    //   1963: aconst_null
    //   1964: ldc_w 1140
    //   1967: ldc_w 397
    //   1970: ldc_w 397
    //   1973: ldc_w 2700
    //   1976: ldc_w 2700
    //   1979: iconst_0
    //   1980: iconst_0
    //   1981: ldc_w 397
    //   1984: ldc_w 397
    //   1987: ldc_w 397
    //   1990: ldc_w 397
    //   1993: invokestatic 1148	axqy:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1996: goto -253 -> 1743
    //   1999: aconst_null
    //   2000: ldc_w 1140
    //   2003: ldc_w 397
    //   2006: ldc_w 397
    //   2009: ldc_w 2702
    //   2012: ldc_w 2702
    //   2015: iconst_0
    //   2016: iconst_0
    //   2017: ldc_w 397
    //   2020: ldc_w 397
    //   2023: ldc_w 397
    //   2026: ldc_w 397
    //   2029: invokestatic 1148	axqy:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2032: goto -289 -> 1743
    //   2035: aload_0
    //   2036: getfield 582	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   2039: lload 9
    //   2041: aload 25
    //   2043: iload 5
    //   2045: aload_0
    //   2046: getfield 146	com/tencent/av/ui/AVActivity:jdField_b_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   2049: aload 24
    //   2051: getfield 2656	lon:jdField_b_of_type_Boolean	Z
    //   2054: aload 24
    //   2056: getfield 2649	lon:jdField_a_of_type_Boolean	Z
    //   2059: invokevirtual 2683	com/tencent/av/ui/VideoLayerUI:a	(JLjava/lang/String;ILandroid/graphics/Bitmap;ZZ)V
    //   2062: goto -292 -> 1770
    //   2065: aload_0
    //   2066: getfield 582	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   2069: lload 9
    //   2071: aload 25
    //   2073: iload 5
    //   2075: aload_0
    //   2076: getfield 146	com/tencent/av/ui/AVActivity:jdField_b_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   2079: aload 24
    //   2081: getfield 2656	lon:jdField_b_of_type_Boolean	Z
    //   2084: aload 24
    //   2086: getfield 2649	lon:jdField_a_of_type_Boolean	Z
    //   2089: invokevirtual 2683	com/tencent/av/ui/VideoLayerUI:a	(JLjava/lang/String;ILandroid/graphics/Bitmap;ZZ)V
    //   2092: goto -322 -> 1770
    //   2095: aload_0
    //   2096: getfield 138	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvAppVideoAppInterface	Lcom/tencent/av/app/VideoAppInterface;
    //   2099: sipush 1023
    //   2102: ldc_w 2703
    //   2105: invokestatic 545	mao:a	(Lcom/tencent/av/app/VideoAppInterface;II)Z
    //   2108: pop
    //   2109: ldc_w 2705
    //   2112: invokestatic 868	mnp:a	(Ljava/lang/String;)V
    //   2115: goto -1302 -> 813
    //   2118: invokestatic 1217	ltm:a	()Lltm;
    //   2121: iconst_1
    //   2122: invokevirtual 2591	ltm:b	(I)V
    //   2125: goto -1227 -> 898
    //   2128: ldc2_w 2256
    //   2131: lstore 7
    //   2133: goto -1205 -> 928
    //   2136: astore 19
    //   2138: goto -1279 -> 859
    //   2141: aload 20
    //   2143: astore 19
    //   2145: goto -533 -> 1612
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2148	0	this	AVActivity
    //   1788	52	1	f1	float
    //   1786	18	2	f2	float
    //   1442	417	3	i1	int
    //   1439	260	4	i2	int
    //   1478	596	5	i3	int
    //   1514	7	6	i4	int
    //   926	1206	7	l1	long
    //   8	2062	9	l2	long
    //   901	34	11	l3	long
    //   909	28	13	l4	long
    //   360	1504	15	bool1	boolean
    //   342	1219	16	bool2	boolean
    //   367	70	17	bool3	boolean
    //   374	932	18	bool4	boolean
    //   335	707	19	localObject1	Object
    //   1196	141	19	localIllegalArgumentException	java.lang.IllegalArgumentException
    //   1610	335	19	str1	String
    //   2136	1	19	localException	Exception
    //   2143	1	19	localObject2	Object
    //   384	1758	20	str2	String
    //   85	1869	21	locallga	lga
    //   165	764	22	localliw	liw
    //   1417	36	23	localArrayList	ArrayList
    //   1461	624	24	locallon	lon
    //   1471	601	25	str3	String
    // Exception table:
    //   from	to	target	type
    //   70	79	1196	java/lang/IllegalArgumentException
    //   852	859	2136	java/lang/Exception
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    this.jdField_k_of_type_Boolean = true;
  }
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (paramSensorEvent != null)) {
      this.jdField_a_of_type_ComTencentAvVideoController.a(paramSensorEvent.values);
    }
  }
  
  public void onStart()
  {
    lga locallga = lcx.a().a();
    liu.a(20, 1L);
    if ((locallga != null) && (locallga.j())) {
      liu.a(31);
    }
    this.mIsShadow = false;
    super.onStart();
    b(1);
    this.o = false;
    long l1 = AudioHelper.b();
    QLog.w(this.jdField_b_of_type_JavaLangString, 1, "avideo life_onStart, seq[" + l1 + "]");
    if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.jdField_a_of_type_ComTencentAvUiVideoControlUI.a(l1);
    }
    if (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) {
      this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.r();
    }
    if ((this.jdField_b_of_type_Int != 1) && (this.jdField_b_of_type_Int == 2)) {}
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(7003), this.jdField_c_of_type_JavaLangString });
  }
  
  public void onStop()
  {
    long l1 = AudioHelper.b();
    QLog.w(this.jdField_b_of_type_JavaLangString, 1, "onStop, seq[" + l1 + "]");
    super.onStop();
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {
      return;
    }
    long l2 = AudioHelper.c();
    this.mIsShadow = false;
    if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_A_of_type_Boolean) && (this.jdField_a_of_type_Min != null))
    {
      this.jdField_a_of_type_Min.c();
      if (this.jdField_a_of_type_Min.b() < 1000L) {
        break label278;
      }
    }
    label278:
    for (int i1 = 1;; i1 = 2)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a().u = i1;
      axqy.b(null, "CliOper", "", "", "0X800863D", "0X800863D", 0, 0, "", "", "", "");
      b(4);
      if (!this.jdField_h_of_type_Boolean) {
        b(l1);
      }
      i(l1);
      long l3 = AudioHelper.c();
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(7001), this.jdField_c_of_type_JavaLangString, Boolean.valueOf(this.jdField_e_of_type_Boolean) });
      e(l1);
      QLog.w(this.jdField_b_of_type_JavaLangString, 1, "avideo life_onStop, mIsMultiFinish[" + this.jdField_h_of_type_Boolean + "], seq[" + l1 + "], cost[" + (l3 - l2) + "]");
      return;
    }
  }
  
  protected void onUserLeaveHint()
  {
    super.onUserLeaveHint();
    if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (this.jdField_a_of_type_ComTencentAvVideoController.a().C == 2)) {
      return;
    }
    b(4);
    long l1 = AudioHelper.b();
    if (AudioHelper.e()) {
      QLog.w(this.jdField_b_of_type_JavaLangString, 1, "life_onUserLeaveHint, seq[" + l1 + "]");
    }
    i(l1);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "life_onWindowFocusChanged, hasFocus[" + paramBoolean + "], nfonWindowFocus[" + this.jdField_j_of_type_Boolean);
    }
    super.onWindowFocusChanged(paramBoolean);
    if (!paramBoolean)
    {
      this.jdField_j_of_type_Boolean = false;
      return;
    }
    super.getWindow().getDecorView().postDelayed(new AVActivity.onWindowFocusChangedRunnable(this), 500L);
    if (AVReport.a().jdField_a_of_type_Boolean)
    {
      AVReport.a().jdField_i_of_type_Long = SystemClock.elapsedRealtime();
      return;
    }
    AVReport.a().x = SystemClock.elapsedRealtime();
  }
  
  public String toString()
  {
    return "TAG[" + this.jdField_b_of_type_JavaLangString + "], ActivityState[" + b() + "], isActivityVisible[" + e() + "], " + super.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.ui.AVActivity
 * JD-Core Version:    0.7.0.1
 */