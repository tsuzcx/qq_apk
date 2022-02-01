package com.tencent.av.ui;

import Override;
import afur;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
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
import android.support.annotation.Nullable;
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
import aqfv;
import atwl;
import bcst;
import bgmj;
import bgsg;
import bhjt;
import bhjz;
import bies;
import bkho;
import bqcd;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.magicface.FaceItem;
import com.tencent.av.business.manager.voiceRecog.VoiceRecogTips;
import com.tencent.av.camera.CameraUtils;
import com.tencent.av.core.SDKConfigInfo;
import com.tencent.av.opengl.GraphicRenderMgr;
import com.tencent.av.report.AVReport;
import com.tencent.av.ui.funchat.filter.EffectFilterPanel;
import com.tencent.av.ui.funchat.record.QavRecordButtonView;
import com.tencent.av.ui.guide.GuideHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.File;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import lbc;
import lbu;
import lca;
import lcc;
import ldy;
import ley;
import lez;
import lfe;
import lgp;
import lhi;
import lhu;
import lhw;
import lit;
import ljd;
import ljo;
import ljw;
import lkz;
import lnn;
import loz;
import lsv;
import lsw;
import lve;
import lvi;
import lyj;
import lyu;
import maf;
import mam;
import man;
import map;
import maq;
import mar;
import mas;
import mat;
import mau;
import mav;
import maw;
import may;
import mbb;
import mbc;
import mbq;
import mbv;
import mbx;
import mcb;
import mcc;
import mdy;
import mgv;
import mih;
import miu;
import mli;
import mmj;
import mmo;
import mno;
import moy;
import mpu;
import mqo;
import mqq.app.BaseActivity;
import mqq.app.MobileQQ;
import mqu;
import mqw;
import msn;
import mso;
import msp;
import mue;

public class AVActivity
  extends BaseActivity
  implements SensorEventListener, lit, lsw
{
  public int a;
  long jdField_a_of_type_Long = 0L;
  Dialog jdField_a_of_type_AndroidAppDialog = null;
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = null;
  public Bitmap a;
  private Sensor jdField_a_of_type_AndroidHardwareSensor;
  private SensorManager jdField_a_of_type_AndroidHardwareSensorManager;
  Handler jdField_a_of_type_AndroidOsHandler = new mas(this);
  private MessageQueue.IdleHandler jdField_a_of_type_AndroidOsMessageQueue$IdleHandler = new mam(this);
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = null;
  public RelativeLayout a;
  public bhjz a;
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
  ldy jdField_a_of_type_Ldy = new mav(this);
  lfe jdField_a_of_type_Lfe = new mbb(this);
  ljd jdField_a_of_type_Ljd = new mau(this);
  private ljw jdField_a_of_type_Ljw = new ljw();
  private lyj jdField_a_of_type_Lyj;
  mbc jdField_a_of_type_Mbc = null;
  public mbq a;
  private mbv jdField_a_of_type_Mbv;
  public mbx a;
  public mgv a;
  public mih a;
  public miu a;
  public mli a;
  public mmj a;
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
    this.jdField_a_of_type_Mli = null;
    this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    this.jdField_b_of_type_AndroidGraphicsBitmap = null;
    this.jdField_h_of_type_Int = 0;
    this.jdField_a_of_type_Mbx = new may(this);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(this);
    this.jdField_a_of_type_ComTencentAvUiGuideGuideHelper = new GuideHelper();
    this.jdField_a_of_type_Bhjz = new man(this);
    this.jdField_k_of_type_Boolean = false;
    this.jdField_m_of_type_Boolean = false;
    this.mIsShadow = false;
    this.jdField_b_of_type_JavaLangString = ("AVActivity_" + AudioHelper.b());
  }
  
  private String a(Intent paramIntent)
  {
    int i2 = paramIntent.getIntExtra("uinType", -1);
    int i3 = mue.b(i2);
    int i1 = i3;
    if (i3 == 0) {
      i1 = 3;
    }
    String str1;
    if (i2 == 1006)
    {
      str1 = paramIntent.getStringExtra("toMobile");
      if (!paramIntent.getBooleanExtra("isDoubleVideoMeeting", false)) {
        break label285;
      }
      str1 = paramIntent.getStringExtra("GroupId");
      i2 = 0;
      i1 = 100;
    }
    label285:
    for (;;)
    {
      String str3 = paramIntent.getStringExtra("Fromwhere");
      i3 = i1;
      String str2 = str1;
      if (i1 == 3)
      {
        i3 = i1;
        str2 = str1;
        if (TextUtils.equals("AIOShareScreen", str3))
        {
          str2 = paramIntent.getStringExtra("uin");
          i3 = 100;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i(this.jdField_b_of_type_JavaLangString, 2, "genSessionIdFromIntent, [" + i2 + "," + i3 + "," + str2 + "]");
      }
      if ((i2 == -1) || (TextUtils.isEmpty(str2)))
      {
        if (QLog.isColorLevel()) {
          QLog.e(this.jdField_b_of_type_JavaLangString, 2, "genSessionIdFromIntent error: uinType " + i2 + ", relationId " + str2);
        }
        return null;
        if ((i1 == 1) || (i1 == 2))
        {
          str1 = paramIntent.getStringExtra("GroupId");
          break;
        }
        str1 = paramIntent.getStringExtra("uin");
        break;
      }
      return lbu.a(i3, str2, new int[0]);
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
    bqcd.a(paramActivity);
    if (bqcd.b())
    {
      int i1 = bqcd.b(paramActivity);
      int i2 = ImmersiveUtils.getStatusBarHeight(paramActivity);
      QLog.w(ImmersiveUtils.jdField_a_of_type_JavaLangString, 1, "initLiuHaiProperty, onAttachedToWindow, notchheight[" + i1 + "], statusBarHeight[" + i2 + "]");
      if (bqcd.c(paramActivity))
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
        ley localley;
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
              } while ((this.jdField_a_of_type_ComTencentAvUiVideoControlUI == null) || (this.jdField_a_of_type_ComTencentAvUiVideoControlUI.h()));
              localley = this.jdField_a_of_type_ComTencentAvVideoController.a();
              i1 = localley.jdField_d_of_type_Int;
              if (QLog.isDevelopLevel()) {
                QLog.w(this.jdField_b_of_type_JavaLangString, 1, "SwitchToolbar, sessionType[" + i1 + "], isInviting[" + localley.h() + "], isToolBarDisplay[" + this.jdField_a_of_type_ComTencentAvUiVideoControlUI.i() + "|" + this.jdField_a_of_type_ComTencentAvUiVideoControlUI.jdField_h_of_type_Boolean + "], seq[" + paramLong + "]");
              }
              if ((i1 != 1) && (i1 != 3)) {
                break;
              }
            } while ((!this.jdField_a_of_type_ComTencentAvUiVideoControlUI.a.b(1)) && (!this.jdField_a_of_type_ComTencentAvUiVideoControlUI.a.b(3)));
            this.jdField_a_of_type_ComTencentAvUiVideoControlUI.a.a(paramLong, 0, true);
            return;
            if (!localley.h()) {
              break;
            }
          } while ((i1 != 2) || ((!this.jdField_a_of_type_ComTencentAvUiVideoControlUI.a.b(1)) && (!this.jdField_a_of_type_ComTencentAvUiVideoControlUI.a.b(3))));
          this.jdField_a_of_type_ComTencentAvUiVideoControlUI.a.a(paramLong, 0, true);
          return;
        } while ((this.jdField_a_of_type_Mbq != null) && (this.jdField_a_of_type_Mbq.a()));
        if ((!localley.jdField_B_of_type_Boolean) || (this.jdField_a_of_type_ComTencentAvUiVideoControlUI.i())) {
          break;
        }
      } while (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null);
      maf.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1022, 2131695098);
      return;
      if (!a())
      {
        if ((!this.jdField_a_of_type_ComTencentAvUiVideoControlUI.i()) && ((this.jdField_a_of_type_ComTencentAvUiVideoControlUI.a.b(1)) || (this.jdField_a_of_type_ComTencentAvUiVideoControlUI.a.b(3)))) {
          this.jdField_a_of_type_ComTencentAvUiVideoControlUI.a.a(paramLong, 0, false);
        }
        b(paramLong, "SwitchToolbar", this.jdField_a_of_type_ComTencentAvUiVideoControlUI.i());
        this.jdField_a_of_type_ComTencentAvUiVideoControlUI.c(0);
        return;
      }
    } while (this.jdField_a_of_type_ComTencentAvUiVideoControlUI.i());
    b(paramLong, "SwitchToolbar2", this.jdField_a_of_type_ComTencentAvUiVideoControlUI.i());
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
  
  private void k()
  {
    if (this.jdField_b_of_type_AndroidGraphicsBitmap == null) {
      this.jdField_b_of_type_AndroidGraphicsBitmap = mue.a(getApplicationContext(), 2130841915);
    }
  }
  
  private void l()
  {
    View localView = findViewById(2131373514);
    if ((localView != null) && (this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch == null) && (!isDestroyed())) {
      runOnUiThread(new AVActivity.9(this, localView));
    }
  }
  
  private void m()
  {
    if (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) {}
    do
    {
      return;
      View localView = super.findViewById(2131363079);
      this.jdField_a_of_type_ComTencentAvUiVideoLayerUI = new VideoLayerUI(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this, localView);
      this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(a());
      this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(new mat(this));
    } while (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI == null);
    this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(this.jdField_a_of_type_Mih);
  }
  
  public void BtnOnClick(View paramView)
  {
    long l1 = AudioHelper.b();
    QLog.d(this.jdField_b_of_type_JavaLangString, 1, "BtnOnClick, id[" + mdy.a(paramView.getId()) + "], nfonWindowFocus[" + this.jdField_j_of_type_Boolean + "], seq[" + l1 + "]");
    if (!this.jdField_j_of_type_Boolean) {}
    for (;;)
    {
      return;
      if ((this.jdField_a_of_type_Mbq != null) && (this.jdField_a_of_type_Mbq.a())) {
        this.jdField_a_of_type_Mbq.a(paramView);
      }
      while ((paramView.getId() == 2131373514) && (this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch != null))
      {
        lve.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch, 1);
        this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = null;
        return;
        if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI != null)
        {
          this.jdField_a_of_type_ComTencentAvUiVideoControlUI.C(l1);
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
    mpu.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface).a(paramView);
    if (AudioHelper.e()) {}
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
    SharedPreferences localSharedPreferences = bgsg.a(getApplicationContext());
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
    if (!this.jdField_a_of_type_ComTencentAvUiVideoControlUI.i())
    {
      if (QLog.isDevelopLevel()) {
        QLog.w(this.jdField_b_of_type_JavaLangString, 1, "qav_UserGuide_for_more.init, 工具栏没显示, seq[" + paramLong + "]");
      }
      return null;
    }
    Object localObject = findViewById(2131373514);
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
    ImageView localImageView = (ImageView)findViewById(2131373385);
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
    int i1 = afur.a(10.0F, getResources());
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
  
  public lyj a()
  {
    return this.jdField_a_of_type_Lyj;
  }
  
  @TargetApi(21)
  @Nullable
  public miu a()
  {
    if (Build.VERSION.SDK_INT < 21) {
      return null;
    }
    this.jdField_a_of_type_Miu = this.jdField_a_of_type_ComTencentAvVideoController.a();
    this.jdField_a_of_type_Miu.a(this);
    return this.jdField_a_of_type_Miu;
  }
  
  void a()
  {
    if (this.jdField_a_of_type_Mbc == null) {
      this.jdField_a_of_type_Mbc = new mbc(this, super.getApplicationContext(), 2);
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
    while ((this.jdField_a_of_type_ComTencentAvUiVideoControlUI == null) || (this.jdField_a_of_type_ComTencentAvUiVideoControlUI.h()) || (paramInt == this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.f())) {
      return;
    }
    long l1 = AudioHelper.b();
    this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.g(paramInt);
    if (((this.jdField_a_of_type_ComTencentAvUiVideoControlUI instanceof DoubleVideoCtrlUI)) && ((paramInt == 2) || (paramInt == 1)))
    {
      this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.f(l1);
      ((DoubleVideoCtrlUI)this.jdField_a_of_type_ComTencentAvUiVideoControlUI).a(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.i(), c());
    }
    this.jdField_a_of_type_ComTencentAvUiVideoControlUI.C(l1);
    this.jdField_a_of_type_ComTencentAvUiVideoControlUI.f(l1, 65535);
    if (this.jdField_a_of_type_Mih != null)
    {
      this.jdField_a_of_type_Mih.a(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.i(), this.jdField_a_of_type_ComTencentAvUiVideoControlUI, this.jdField_a_of_type_Mih.c());
      this.jdField_a_of_type_Mih.a(this.jdField_a_of_type_Mih.c());
      this.jdField_a_of_type_Mih.b(this.jdField_a_of_type_Mih.c());
    }
    if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_B_of_type_Boolean) && (!this.jdField_a_of_type_ComTencentAvVideoController.a().I)) {
      mno.a("0X8008ABA");
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
        this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.b(paramLong, false, false);
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
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().r()) {}
      while (this.jdField_a_of_type_Mmj != null)
      {
        this.jdField_a_of_type_Mmj.a();
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
    while ((this.jdField_a_of_type_ComTencentAvUiVideoControlUI == null) || (this.jdField_a_of_type_ComTencentAvUiVideoControlUI.h())) {
      return;
    }
    int i5 = this.jdField_a_of_type_ComTencentAvUiVideoControlUI.a(paramLong);
    int i6 = this.jdField_a_of_type_ComTencentAvUiVideoControlUI.b();
    Object localObject;
    if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI.i())
    {
      localObject = findViewById(2131373510);
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
      if (this.jdField_a_of_type_Mmj != null)
      {
        i4 = this.jdField_a_of_type_Mmj.a();
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
          if ((this.jdField_a_of_type_Mmj == null) || (paramInt == 1)) {
            break;
          }
          this.jdField_a_of_type_Mmj.b(i6);
          return;
          if ((i5 != 0) || (!bqcd.b())) {
            break label510;
          }
        }
      }
      label447:
      label510:
      for (i1 = bqcd.b(this);; i1 = 0)
      {
        localObject = this.jdField_a_of_type_ComTencentAvVideoController.a();
        if ((((ley)localObject).x()) && ((((ley)localObject).jdField_B_of_type_Boolean) || (((ley)localObject).C)) && (this.jdField_a_of_type_Mih != null) && (!this.jdField_a_of_type_Mih.d()))
        {
          i2 = this.jdField_a_of_type_Mih.c();
          localObject = this.jdField_a_of_type_ComTencentAvUiVideoLayerUI;
          if (i2 == 0) {}
          for (i3 = -1;; i3 = i2)
          {
            ((VideoLayerUI)localObject).i = i3;
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
    if ((paramInt1 == 2131373514) && (paramInt3 == 0))
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
      } while ((this.jdField_a_of_type_ComTencentAvUiVideoControlUI == null) || (this.jdField_a_of_type_ComTencentAvUiVideoControlUI.h()));
      this.jdField_a_of_type_ComTencentAvUiVideoControlUI.b(paramLong, paramInt);
      this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(paramInt, false);
      this.jdField_a_of_type_ComTencentAvCameraCameraUtils.a(paramInt);
      this.jdField_h_of_type_Int = paramInt;
      if (this.jdField_a_of_type_Mih != null)
      {
        this.jdField_a_of_type_Mih.d(paramInt);
        this.jdField_a_of_type_Mih.d();
        this.jdField_a_of_type_Mih.a(this.jdField_a_of_type_ComTencentAvUiVideoControlUI, this.jdField_h_of_type_Int);
      }
    } while ((!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_B_of_type_Boolean) && (!this.jdField_a_of_type_ComTencentAvVideoController.a().C));
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
    Intent localIntent = afur.a(new Intent(super.getApplicationContext(), SplashActivity.class), null);
    localIntent.putExtra("uin", paramString1);
    localIntent.putExtra("uintype", paramInt);
    localIntent.putExtra("uinname", paramString2);
    startActivity(localIntent);
    QLog.w(this.jdField_b_of_type_JavaLangString, 1, "enterChatWin, uin[" + paramString1 + "], type[" + paramInt + "], seq[" + paramLong + "]");
    this.jdField_e_of_type_Boolean = false;
    finish();
    paramInt = 2130772140;
    paramString1 = this.jdField_a_of_type_ComTencentAvVideoController.a();
    if (paramString1 != null) {
      paramInt = lyu.a(paramString1.L);
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
      if ((i2 != i1) && (AudioHelper.f())) {
        QLog.w(this.jdField_b_of_type_JavaLangString, 1, "ShowRecordBtn, from[" + paramString + "], bShown[" + paramBoolean + "], seq[" + paramLong + "]");
      }
      if ((paramBoolean) && (this.jdField_a_of_type_ComTencentAvVideoController != null) && (this.jdField_a_of_type_ComTencentAvVideoController.a().G))
      {
        this.jdField_a_of_type_ComTencentAvVideoController.a().G = false;
        paramBoolean = this.jdField_a_of_type_Mih.i();
        boolean bool = mih.f();
        if ((!paramBoolean) || (!bool)) {
          break;
        }
        mno.a("0X8008AB2");
      }
      return;
    }
    mno.a("0X8008AB1");
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentAvVideoController.a();
    QLog.w(this.jdField_b_of_type_JavaLangString, 1, "avideo onCreateUI, SessionType[" + ((ley)localObject1).jdField_d_of_type_Int + "], seq[" + paramLong + "]");
    mpu.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this);
    Object localObject2 = this.jdField_a_of_type_ComTencentAvVideoController.a(getApplicationContext());
    if (localObject2 != null) {
      ((loz)localObject2).a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    }
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131373232));
    }
    this.jdField_a_of_type_JavaLangRunnable = new AVActivity.5(this);
    if (this.jdField_a_of_type_ComTencentAvCameraCameraUtils == null)
    {
      this.jdField_a_of_type_ComTencentAvCameraCameraUtils = CameraUtils.a(this);
      this.jdField_a_of_type_ComTencentAvCameraCameraUtils.a(this.jdField_a_of_type_Ljd);
      this.jdField_a_of_type_ComTencentAvCameraCameraUtils.a(this.jdField_a_of_type_ComTencentAvVideoController.jdField_a_of_type_Lca);
    }
    localObject2 = super.findViewById(2131363079).findViewById(2131363076);
    try
    {
      ((View)localObject2).setBackgroundResource(2130842074);
      if (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI == null) {
        m();
      }
      if (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) {
        this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.c();
      }
      c(false);
      if (this.jdField_b_of_type_Int == 0)
      {
        QLog.i(this.jdField_b_of_type_JavaLangString, 2, "onCreateUI, SessionType[" + this.jdField_b_of_type_Int + "], isDoubleMeeting[" + this.jdField_g_of_type_Boolean + "]");
        if (this.jdField_g_of_type_Boolean) {
          this.jdField_b_of_type_Int = 1;
        }
      }
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
          this.jdField_a_of_type_ComTencentImageURLDrawable.setURLDrawableListener(new maw(this));
          this.jdField_a_of_type_ComTencentImageURLDrawable.startDownload();
          if (1 == this.jdField_a_of_type_ComTencentImageURLDrawable.getStatus())
          {
            paramBoolean = true;
            this.n = paramBoolean;
            bcst.b(null, "CliOper", "", "", "0X800A75E", "0X800A75E", i1, this.jdField_a_of_type_Mso.jdField_a_of_type_Int, "", "", "", "");
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
              ((DoubleVideoCtrlUI)localObject2).a(2131373210, this.jdField_a_of_type_ComTencentAvVideoController.n, 2130841973);
              if (!this.jdField_a_of_type_ComTencentAvVideoController.p) {
                ((DoubleVideoCtrlUI)localObject2).a.a(true, 0, false);
              }
            }
          }
          if ((((ley)localObject1).jdField_g_of_type_Int != 4) && (((ley)localObject1).x()) && (!this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_Int == 1) && (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) && (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getParent() != null) && (!isDestroyed()))
          {
            i1 = mmo.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, ((ley)localObject1).jdField_d_of_type_JavaLangString, true, true);
            if ((i1 > 0) && (this.jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView == null)) {
              this.jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView = bhjt.a(this, (RelativeLayout)this.jdField_a_of_type_AndroidWidgetRelativeLayout.getParent(), false);
            }
            i2 = bhjt.a();
            localObject1 = bhjt.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, i1, i2, null);
            if (localObject1 != null)
            {
              localObject2 = new File((String)localObject1);
              if ((localObject2 == null) || (!((File)localObject2).exists())) {
                break label1339;
              }
              if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
                this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new AVActivity.7(this, (String)localObject1, i2, i1), 1000L);
              }
            }
          }
          this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView = ((QavRecordButtonView)findViewById(2131376232));
          a(paramLong, "onCreateUI", false);
          if (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) {
            this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.k(0);
          }
          localObject1 = (RelativeLayout)findViewById(2131380769);
          if ((localObject1 != null) && (mih.f()))
          {
            this.jdField_a_of_type_Mih = new mih(this, (RelativeLayout)localObject1, this.jdField_a_of_type_ComTencentAvVideoController, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_ComTencentAvUiVideoControlUI);
            this.jdField_a_of_type_Mih.c(1);
            if (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) {
              this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(this.jdField_a_of_type_Mih);
            }
          }
          l();
          lsv.a().a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this);
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
            break label1042;
          }
          this.jdField_a_of_type_ComTencentAvUiVideoControlUI = new DoubleVideoMeetingCtrlUI(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_Mbx);
          this.jdField_b_of_type_Int = ((ley)localObject1).jdField_d_of_type_Int;
        }
        for (;;)
        {
          this.jdField_a_of_type_ComTencentAvUiVideoControlUI.m(this.jdField_a_of_type_ComTencentAvCameraCameraUtils.a());
          break;
          label1042:
          this.jdField_a_of_type_ComTencentAvUiVideoControlUI = new DoubleVideoCtrlUI(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_Mbx);
        }
        if (this.jdField_g_of_type_Boolean)
        {
          this.jdField_a_of_type_ComTencentAvUiVideoControlUI = new DoubleVideoMeetingCtrlUI(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_Mbx);
          this.jdField_b_of_type_Int = ((ley)localObject1).jdField_d_of_type_Int;
        }
        else
        {
          this.jdField_a_of_type_ComTencentAvUiVideoControlUI = new DoubleVideoCtrlUI(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_Mbx);
          this.jdField_a_of_type_ComTencentAvUiVideoControlUI.m(this.jdField_a_of_type_ComTencentAvCameraCameraUtils.a());
          continue;
          if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI == null)
          {
            if (!this.jdField_g_of_type_Boolean) {
              break label1217;
            }
            this.jdField_a_of_type_ComTencentAvUiVideoControlUI = new DoubleVideoMeetingCtrlUI(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_Mbx);
            this.jdField_b_of_type_Int = ((ley)localObject1).jdField_d_of_type_Int;
          }
          for (;;)
          {
            this.jdField_a_of_type_ComTencentAvUiVideoControlUI.m(this.jdField_a_of_type_ComTencentAvCameraCameraUtils.a());
            break;
            label1217:
            if (((ley)localObject1).D == 1)
            {
              this.jdField_a_of_type_ComTencentAvUiVideoControlUI = new MultiVideoCtrlLayerUI4Discussion(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_Mbx);
            }
            else if (((ley)localObject1).D == 10)
            {
              this.jdField_a_of_type_ComTencentAvUiVideoControlUI = new MultiVideoCtrlLayerUI4NewGroupChat(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_Mbx);
            }
            else
            {
              if (QLog.isColorLevel()) {
                QLog.d(this.jdField_b_of_type_JavaLangString, 2, "OnCreateUI --> Not Set MultiAVType");
              }
              this.jdField_a_of_type_ComTencentAvUiVideoControlUI = new MultiVideoCtrlLayerUI4Discussion(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_Mbx);
            }
          }
          paramBoolean = false;
          continue;
          label1339:
          QLog.e(this.jdField_b_of_type_JavaLangString, 1, "funcall --> !file.exists() + path:" + (String)localObject1);
        }
      }
    }
  }
  
  public void a(Integer paramInteger, Object paramObject1, Object paramObject2)
  {
    lbc.c(this.jdField_b_of_type_JavaLangString, "notifyEvent :" + paramInteger + "|" + paramObject1 + "|" + paramObject2);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { paramInteger, paramObject1, paramObject2 });
  }
  
  public void a(String paramString)
  {
    lgp locallgp = (lgp)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(3);
    FaceItem localFaceItem = locallgp.a(paramString);
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
        new mcc(l1, localFaceItem.getId(), true, 2).a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
        VoiceRecogTips.b(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramString);
        bcst.b(null, "CliOper", "", "", "0X800984F", "0X800984F", 0, 0, "", "", "", localFaceItem.getId());
        return;
      }
      locallgp.a(l1, localFaceItem);
      return;
    }
    QLog.i(this.jdField_b_of_type_JavaLangString, 1, "onAVVoiceRecogComplete. recogResult = " + paramString + ", paly voice sticker falied. voiceStickerItem == null.");
  }
  
  void a(String paramString, long paramLong)
  {
    View localView = findViewById(2131373385);
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
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i(this.jdField_b_of_type_JavaLangString, 2, "updateDoubleMeeting, from[" + paramString + "], [" + this.jdField_g_of_type_Boolean + "-->" + paramBoolean);
    }
    if (this.jdField_g_of_type_Boolean != paramBoolean) {
      this.jdField_g_of_type_Boolean = paramBoolean;
    }
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
    if (this.jdField_a_of_type_Mbc != null) {
      this.jdField_a_of_type_Mbc.enable();
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
        if ((this.jdField_a_of_type_Lyj == null) || (this.jdField_a_of_type_Lyj.a()))
        {
          if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 4)
          {
            ArrayList localArrayList = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList;
            int i1 = 0;
            if (i1 < localArrayList.size())
            {
              lnn locallnn = (lnn)localArrayList.get(i1);
              String str = mqu.a(locallnn.jdField_a_of_type_Long);
              int i2 = locallnn.jdField_a_of_type_Int;
              if ((locallnn.jdField_b_of_type_Long == 5L) || (locallnn.jdField_b_of_type_Long == 14L)) {}
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
          this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.b(paramLong, false, false);
        }
        this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.x();
      }
      if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
        this.jdField_a_of_type_ComTencentAvUiVideoControlUI.m(paramLong);
      }
      if (this.jdField_a_of_type_Mbq != null) {
        this.jdField_a_of_type_Mbq.d();
      }
      f();
      this.jdField_a_of_type_ComTencentAvVideoController.a(true);
      this.jdField_a_of_type_ComTencentAvVideoController.h(false);
      if (this.jdField_a_of_type_Lyj != null) {
        this.jdField_a_of_type_Lyj.a(paramLong, this.jdField_e_of_type_Boolean);
      }
    } while (this.jdField_a_of_type_Mmj == null);
    this.jdField_a_of_type_Mmj.a();
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
      if ((!mih.k()) && (this.jdField_a_of_type_Mih != null)) {
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
            if ((i1 != 0) && (this.jdField_a_of_type_ComTencentAvVideoController.a().C))
            {
              this.jdField_a_of_type_Mih.d(this.jdField_h_of_type_Int);
              this.jdField_a_of_type_Mih.d();
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
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().C)
      {
        this.jdField_a_of_type_Mih.d(0);
        this.jdField_a_of_type_Mih.d();
        this.jdField_a_of_type_Mih.k();
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
    QLog.w(this.jdField_b_of_type_JavaLangString, 1, "onNeedChangeDoubleScreenMode, id[" + paramString + "], seq[" + l1 + "], hasChangeDoubleScreen[" + this.jdField_a_of_type_ComTencentAvVideoController.a().U + "]");
    getResources();
    if (!this.jdField_a_of_type_ComTencentAvVideoController.a().U)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a().a(true);
      a(2, false);
      maf.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1043);
      return;
    }
    if (this.jdField_a_of_type_AndroidViewView$OnClickListener == null) {
      this.jdField_a_of_type_AndroidViewView$OnClickListener = new mar(this, paramString, l1);
    }
    maf.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1044, null, this.jdField_a_of_type_AndroidViewView$OnClickListener);
  }
  
  public void b(boolean paramBoolean)
  {
    VideoLayerUI.a(findViewById(2131363079), paramBoolean);
  }
  
  boolean b()
  {
    if (isDestroyed()) {}
    do
    {
      do
      {
        return false;
      } while ((this.jdField_a_of_type_ComTencentAvUiVideoControlUI == null) || (this.jdField_a_of_type_ComTencentAvUiVideoControlUI.h()));
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
    if (this.jdField_a_of_type_Mbc != null) {
      this.jdField_a_of_type_Mbc.disable();
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
    ley localley = this.jdField_a_of_type_ComTencentAvVideoController.a();
    int i2 = localley.jdField_d_of_type_Int;
    Object localObject1 = ((Intent)localObject3).getStringExtra("Fromwhere");
    boolean bool = ((Intent)localObject3).getBooleanExtra("isDoubleVideoMeeting", false);
    a("processExtraData", bool);
    if ("AVNotification".equals(localObject1))
    {
      if (((localley.jdField_g_of_type_Int == 2) || (localley.jdField_g_of_type_Int == 13)) && (i4 != 1) && (i4 != 2))
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_b_of_type_JavaLangString, 2, "Close Double Video Meeting. --> QAVNotification to MultiVideo");
        }
        if (localley.J) {
          break label390;
        }
        this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, localley.jdField_d_of_type_JavaLangString, 1, true);
        this.jdField_a_of_type_ComTencentAvVideoController.a(localley.jdField_d_of_type_JavaLangString, 230);
        this.jdField_a_of_type_ComTencentAvVideoController.b(230);
      }
      if (localley.jdField_j_of_type_Int == 1)
      {
        if (localley.D != 10) {
          break label428;
        }
        bcst.b(null, "CliOper", "", "", "0X8005930", "0X8005930", 0, 0, "", "", "", "");
      }
    }
    label390:
    long l1;
    for (;;)
    {
      if (bool) {
        bcst.b(null, "CliOper", "", "", "0X8005209", "0X8005209", 0, 0, "", "", "", "");
      }
      if (i4 != 0) {
        break label464;
      }
      lbc.d(this.jdField_b_of_type_JavaLangString, "processExtraData-->can not get session type in intent.");
      ((lhw)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4)).a(localley.b(), 5, 1015L);
      finish();
      return;
      l1 = Long.valueOf(localley.jdField_d_of_type_JavaLangString).longValue();
      this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, 3, l1);
      this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, l1, 1);
      break;
      label428:
      bcst.b(null, "CliOper", "", "", "0X80046D7", "0X80046D7", 0, 0, "", "", "", "");
    }
    label464:
    String str = null;
    if ((i4 == 1) || (i4 == 2))
    {
      str = ((Intent)localObject3).getStringExtra("uin");
      label489:
      if (!"AVNotification".equals(localObject1)) {
        break label2363;
      }
      if ((i4 != 1) && (i4 != 2)) {
        break label639;
      }
      str = localley.jdField_d_of_type_JavaLangString;
    }
    label1798:
    label2360:
    label2363:
    for (;;)
    {
      int i1;
      int i3;
      int i5;
      if (str == null)
      {
        lbc.d(this.jdField_b_of_type_JavaLangString, "processExtraData-->can not get uin in intent.");
        ((lhw)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4)).a(localley.b(), 5, 1016L);
        finish();
        return;
        if ((i4 != 3) && (i4 != 4)) {
          break label489;
        }
        str = ((Intent)localObject3).getStringExtra("GroupId");
        i1 = ((Intent)localObject3).getIntExtra("MeetingConfID", 0);
        i3 = ((Intent)localObject3).getIntExtra("ConfAppID", 0);
        i5 = ((Intent)localObject3).getIntExtra("MeetingStasks", -1);
        localley.O = i1;
        localley.P = i3;
        localley.Q = i5;
        break label489;
        label639:
        if ((i4 != 3) && (i4 != 4)) {
          break label2363;
        }
        if (bool)
        {
          str = localley.jdField_d_of_type_JavaLangString;
          continue;
        }
        str = String.valueOf(this.jdField_a_of_type_ComTencentAvVideoController.jdField_a_of_type_Long);
        continue;
      }
      Object localObject2;
      if ((i2 == 1) || (i2 == 2))
      {
        localObject2 = localley.jdField_d_of_type_JavaLangString;
        i1 = mue.b(localley.jdField_j_of_type_Int);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          lbc.d(this.jdField_b_of_type_JavaLangString, "can not get the original peeruin");
          ((lhw)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4)).a(localley.b(), 5, 1016L);
          finish();
        }
      }
      else if ((i2 == 3) || (i2 == 4))
      {
        localObject2 = String.valueOf(this.jdField_a_of_type_ComTencentAvVideoController.jdField_a_of_type_Long);
        i1 = this.jdField_a_of_type_ComTencentAvVideoController.jdField_c_of_type_Int;
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          lbc.d(this.jdField_b_of_type_JavaLangString, "can not get the original group uin");
          ((lhw)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4)).a(localley.b(), 5, 1016L);
          finish();
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_b_of_type_JavaLangString, 2, "original session type is none");
        }
        i1 = 0;
        localObject1 = null;
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, "processExtraData-->IntentSessionType=" + i4 + ", OriginalSessionType=" + i2 + ", IntentUin=" + str);
      }
      if ((localObject1 != null) && (QLog.isColorLevel())) {
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, "processExtraData-->OriginalUin=" + (String)localObject1 + ", originalRelationType=" + i1);
      }
      if ((i2 == 0) && (!this.jdField_a_of_type_ComTencentAvVideoController.l()))
      {
        d(paramLong);
        label984:
        QLog.w(this.jdField_b_of_type_JavaLangString, 1, "processExtraData, mSessionType[" + this.jdField_b_of_type_Int + "], mUinType[" + this.jdField_d_of_type_Int + "], mPeerUin[" + this.jdField_c_of_type_JavaLangString + "], mPeerName[" + this.jdField_e_of_type_JavaLangString + "], mPhoneNum[" + this.jdField_f_of_type_JavaLangString + "], mSelfNation[" + this.jdField_g_of_type_JavaLangString + "], mSelfMobile[" + this.jdField_h_of_type_JavaLangString + "], mIsReceiver[" + this.jdField_a_of_type_Boolean + "], mIsAudioMode[" + this.jdField_b_of_type_Boolean + "], mExtraUin[" + this.jdField_i_of_type_JavaLangString + "], mIsPeerNetworkWell[" + this.jdField_c_of_type_Boolean + "], mIsFriend[" + this.jdField_d_of_type_Boolean + "], mFromWhere[" + this.jdField_j_of_type_JavaLangString + "], intentUinStr[" + str + "], \nsession[" + localley + "]");
        bgmj.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ArrayOfByte);
        return;
      }
      if ((i2 == 3) || (i2 == 4) || (this.jdField_a_of_type_ComTencentAvVideoController.l()))
      {
        if ((i2 != 0) || (!this.jdField_a_of_type_ComTencentAvVideoController.l())) {
          break label2360;
        }
        localObject1 = "";
      }
      for (;;)
      {
        if ((i4 == 1) || (i4 == 2))
        {
          if (this.jdField_a_of_type_ComTencentAvVideoController.l()) {
            this.jdField_a_of_type_ComTencentAvVideoController.g(true);
          }
          for (;;)
          {
            d(paramLong);
            str = lbu.a(3, this.jdField_c_of_type_JavaLangString, new int[0]);
            if (lbu.a().a(str)) {
              break;
            }
            localObject1 = lbu.a().a(str, false);
            ((ley)localObject1).jdField_e_of_type_Boolean = false;
            ((ley)localObject1).a("processExtraData", 0);
            ((ley)localObject1).ag = false;
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
          break label984;
        }
        l1 = Long.valueOf(str).longValue();
        i3 = 0;
        i5 = ((Intent)localObject3).getIntExtra("MultiAVType", 0);
        localley.au = ((Intent)localObject3).getBooleanExtra("disableInvite", false);
        i2 = i3;
        if (localley.D != 0)
        {
          i2 = i3;
          if (i5 != localley.D)
          {
            i2 = i3;
            if (i5 != 0) {
              i2 = 1;
            }
          }
        }
        localley.a(i5);
        if (!bool) {
          if (this.jdField_a_of_type_ComTencentAvVideoController.l())
          {
            this.jdField_a_of_type_ComTencentAvVideoController.g(true);
            label1519:
            if (i2 != 0)
            {
              this.jdField_a_of_type_ComTencentAvVideoController.a(i1, this.jdField_a_of_type_ComTencentAvVideoController.jdField_a_of_type_Long, 99);
              localley.a(i5);
              localley.a(paramLong, "processExtraData.1", 3);
            }
            localley.c("processExtraData.1", ((Intent)localObject3).getIntExtra("Type", -1));
            localley.jdField_g_of_type_Long = l1;
            this.jdField_d_of_type_JavaLangString = str;
            if (str.compareTo((String)localObject1) != 0) {
              break label1798;
            }
            if (i2 == 0) {
              break label1786;
            }
            this.jdField_b_of_type_Int = i4;
            i1 = ((Intent)localObject3).getIntExtra("uinType", -1);
            localley.jdField_j_of_type_Int = i1;
            this.jdField_d_of_type_Int = i1;
            this.jdField_i_of_type_JavaLangString = localley.jdField_f_of_type_JavaLangString;
            if (localley.E == -1) {
              localley.c("processExtraData.2", 0);
            }
            this.jdField_c_of_type_Boolean = localley.r;
            if (QLog.isColorLevel()) {
              QLog.d(this.jdField_b_of_type_JavaLangString, 2, "processExtraData multiAVType: " + localley.D);
            }
          }
        }
        for (;;)
        {
          if (i2 != 0) {
            break label1882;
          }
          this.jdField_d_of_type_Int = localley.jdField_j_of_type_Int;
          this.jdField_i_of_type_JavaLangString = localley.jdField_f_of_type_JavaLangString;
          this.jdField_c_of_type_Boolean = localley.r;
          break;
          if ((str.compareTo((String)localObject1) == 0) || (!this.jdField_a_of_type_ComTencentAvVideoController.jdField_e_of_type_Boolean)) {
            break label1519;
          }
          this.jdField_a_of_type_ComTencentAvVideoController.a(i1, this.jdField_a_of_type_ComTencentAvVideoController.jdField_a_of_type_Long, 98);
          localley.a(i5);
          break label1519;
          label1786:
          this.jdField_b_of_type_Int = localley.jdField_d_of_type_Int;
          continue;
          localley.a(paramLong, "processExtraData.2", i4);
          localley.jdField_j_of_type_Int = ((Intent)localObject3).getIntExtra("uinType", -1);
          if ((localley.E == 0) || (localley.E == 1)) {
            localley.jdField_a_of_type_ArrayOfLong = ((Intent)localObject3).getLongArrayExtra("DiscussUinList");
          }
          this.jdField_b_of_type_Int = i4;
          continue;
          localley.jdField_d_of_type_JavaLangString = str;
          this.jdField_b_of_type_Int = i4;
          this.jdField_c_of_type_JavaLangString = str;
        }
        label1882:
        break label984;
        if (((i2 != 1) && (i2 != 2)) || ((i4 != 1) && (i4 != 2))) {
          break label984;
        }
        i1 = ((Intent)localObject3).getIntExtra("uinType", -1);
        if ((i1 != -1) && (i1 != localley.jdField_j_of_type_Int))
        {
          if (QLog.isColorLevel()) {
            QLog.w(this.jdField_b_of_type_JavaLangString, 2, "New Double Video in , newUinType !=-1 && newUinType != oldUinType , close old video.");
          }
          this.jdField_a_of_type_ComTencentAvVideoController.a(false, 203, new int[] { localley.D });
          this.jdField_a_of_type_ComTencentAvVideoController.b(203);
          if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI != null)
          {
            this.jdField_a_of_type_ComTencentAvUiVideoControlUI.d(paramLong);
            this.jdField_a_of_type_ComTencentAvUiVideoControlUI = null;
          }
          localObject1 = localley.jdField_d_of_type_JavaLangString;
          localObject2 = lbu.a(3, (String)localObject1, new int[0]);
          Object localObject4 = lbu.a().c((String)localObject2);
          if (localObject4 == null)
          {
            lbc.d(this.jdField_b_of_type_JavaLangString, "Can not get SessionInfo : SessionId = " + (String)localObject2);
            finish();
            return;
          }
          localObject3 = ((ley)localObject4).jdField_f_of_type_JavaLangString;
          i1 = localley.jdField_j_of_type_Int;
          localObject4 = ((ley)localObject4).jdField_s_of_type_JavaLangString;
          this.jdField_a_of_type_ComTencentAvVideoController.a((String)localObject1, 231);
          this.jdField_a_of_type_ComTencentAvVideoController.b(231);
          this.jdField_a_of_type_ComTencentAvVideoController.a("AVActivity.processExtraData", (String)localObject2, i1, (String)localObject1, (String)localObject3, 0, (String)localObject4, false, true);
          d(paramLong);
          localObject1 = lbu.a(3, this.jdField_c_of_type_JavaLangString, new int[0]);
          localObject2 = lbu.a().a((String)localObject1, false);
          ((ley)localObject2).jdField_e_of_type_Boolean = true;
          ((ley)localObject2).a("processExtraData", 2);
          ((ley)localObject2).ag = false;
          if (((String)localObject1).equals(this.jdField_a_of_type_JavaLangString)) {
            break label984;
          }
          this.jdField_a_of_type_JavaLangString = ((String)localObject1);
          break label984;
        }
        if (QLog.isColorLevel()) {
          QLog.w(this.jdField_b_of_type_JavaLangString, 2, "New Double Video in , newUinType !=-1 && newUinType == oldUinType , resume old video");
        }
        this.jdField_b_of_type_Int = localley.jdField_d_of_type_Int;
        a("processExtraData", localley.J);
        this.jdField_d_of_type_Int = localley.jdField_j_of_type_Int;
        this.jdField_c_of_type_JavaLangString = localley.jdField_d_of_type_JavaLangString;
        this.jdField_e_of_type_JavaLangString = localley.jdField_e_of_type_JavaLangString;
        this.jdField_l_of_type_JavaLangString = localley.jdField_k_of_type_JavaLangString;
        this.jdField_e_of_type_Int = localley.A;
        this.jdField_m_of_type_JavaLangString = localley.jdField_p_of_type_JavaLangString;
        this.jdField_f_of_type_Int = localley.jdField_B_of_type_Int;
        this.jdField_i_of_type_JavaLangString = localley.jdField_f_of_type_JavaLangString;
        this.jdField_f_of_type_JavaLangString = localley.a();
        this.jdField_a_of_type_Boolean = localley.jdField_e_of_type_Boolean;
        this.jdField_b_of_type_Boolean = localley.S;
        this.jdField_c_of_type_Boolean = localley.r;
        this.jdField_d_of_type_Boolean = localley.jdField_N_of_type_Boolean;
        break label984;
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
    ley localley = this.jdField_a_of_type_ComTencentAvVideoController.a();
    QLog.w(this.jdField_b_of_type_JavaLangString + "|VideoNodeManager", 1, "processIntentData begin, isProcessCreate[" + this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.jdField_c_of_type_Boolean + "], isMsfRecv[" + this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.jdField_d_of_type_Boolean + "], seq[" + paramLong + "], \nSessionInfo[" + localley + "]");
    Object localObject1;
    boolean bool1;
    String str1;
    Object localObject2;
    String str2;
    long l1;
    if ((this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.jdField_c_of_type_Boolean) || (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.jdField_d_of_type_Boolean))
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.jdField_c_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.jdField_d_of_type_Boolean = false;
      lhu.a(26);
      localObject1 = super.getIntent();
      AudioHelper.a(this.jdField_b_of_type_JavaLangString + "_processIntentData", ((Intent)localObject1).getExtras());
      this.jdField_b_of_type_Int = ((Intent)localObject1).getIntExtra("sessionType", 0);
      this.jdField_d_of_type_Int = ((Intent)localObject1).getIntExtra("uinType", -1);
      this.jdField_c_of_type_JavaLangString = ((Intent)localObject1).getStringExtra("uin");
      this.jdField_l_of_type_JavaLangString = ((Intent)localObject1).getStringExtra("dstClient");
      bool1 = ((Intent)localObject1).getBooleanExtra("isDoubleVideoMeeting", false);
      boolean bool2 = bool1;
      if ("AIOShareScreen".equals(((Intent)localObject1).getStringExtra("Fromwhere")))
      {
        if (QLog.isColorLevel()) {
          QLog.i(this.jdField_b_of_type_JavaLangString, 2, "processIntentData, from share screen. uinType[" + this.jdField_d_of_type_Int + "]");
        }
        if (this.jdField_d_of_type_Int == 0) {
          bool1 = true;
        }
        localley.ad = 4;
        bool2 = bool1;
      }
      a("processIntentData", bool2);
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
      this.jdField_b_of_type_Long = bhjt.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_c_of_type_JavaLangString, 3, true, null);
      this.jdField_g_of_type_Int = ((Intent)localObject1).getIntExtra("vipType", 0);
      lbc.b("VideoNodeManager", "==> AVActivity processIntentData() mSessionType = " + this.jdField_b_of_type_Int + "  mIsAudioMode = " + this.jdField_b_of_type_Boolean);
      lhu.b(this.jdField_b_of_type_Int);
      if (!this.jdField_b_of_type_Boolean) {
        break label867;
      }
      l1 = 1L;
      label659:
      lhu.a(13, l1);
      if ((this.jdField_d_of_type_Int == 0) && (this.jdField_a_of_type_Boolean)) {
        this.jdField_d_of_type_Boolean = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_c_of_type_JavaLangString);
      }
      if (this.jdField_d_of_type_Int != 1008) {
        break label903;
      }
      if (localObject2 == null) {
        break label875;
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
        break label1179;
      }
      localley.c("processIntentData", ((Intent)localObject1).getIntExtra("Type", -1));
      localObject2 = ((Intent)localObject1).getStringExtra("GroupId");
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        break label1005;
      }
      lbc.d(this.jdField_b_of_type_JavaLangString, "relationIdStr is null");
      this.jdField_e_of_type_Boolean = true;
      ((lhw)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4)).a(localley.b(), 5, 1016L);
      finish();
      return;
      lhu.a();
      break;
      label867:
      l1 = 2L;
      break label659;
      label875:
      this.jdField_a_of_type_ArrayOfByte = new byte[] { 1, 1, -118 };
      continue;
      label903:
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
    label1005:
    int i2 = ((Intent)localObject1).getIntExtra("MultiAVType", 0);
    int i1 = i2;
    if (i2 == 0)
    {
      i2 = localley.D;
      i1 = i2;
      if (QLog.isColorLevel())
      {
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, "Not get avtype inside intent default value: " + i2);
        i1 = i2;
      }
    }
    localley.a(i1);
    if (localObject2 != null)
    {
      localley.jdField_g_of_type_Long = Long.valueOf((String)localObject2).longValue();
      this.jdField_d_of_type_JavaLangString = ((String)localObject2);
    }
    localley.jdField_a_of_type_ArrayOfLong = ((Intent)localObject1).getLongArrayExtra("DiscussUinList");
    localley.au = ((Intent)localObject1).getBooleanExtra("disableInvite", false);
    while (this.jdField_b_of_type_Int == 0)
    {
      lbc.d(this.jdField_b_of_type_JavaLangString, "invalid sessionType!!!");
      this.jdField_e_of_type_Boolean = true;
      ((lhw)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4)).a(localley.b(), 5, 1015L);
      finish();
      return;
      label1179:
      localley.ai = ((Intent)localObject1).getBooleanExtra("isOtherTerminalOnChating", false);
      if (localley.ai)
      {
        localley.jdField_i_of_type_Long = ((Intent)localObject1).getLongExtra("otherTerminalChatingRoomId", 0L);
        localley.ak = ((Intent)localObject1).getBooleanExtra("startfromVideoEntry", false);
      }
    }
    i1 = ((Intent)localObject1).getIntExtra("remoteStatus", 0);
    if (this.jdField_a_of_type_Boolean)
    {
      if (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))
      {
        lbc.d(this.jdField_b_of_type_JavaLangString, "uin is empty");
        this.jdField_e_of_type_Boolean = true;
        ((lhw)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4)).a(localley.b(), 5, 1016L);
        finish();
        return;
      }
      if (TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) {
        this.jdField_e_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
      }
      if ((this.jdField_d_of_type_Int != 1011) && (localley.jdField_a_of_type_Lez.jdField_b_of_type_Boolean))
      {
        this.jdField_a_of_type_ComTencentAvVideoController.a(localley.jdField_d_of_type_JavaLangString, 232);
        this.jdField_a_of_type_ComTencentAvVideoController.b(232);
      }
      localley.a(paramLong, "processIntentData", this.jdField_b_of_type_Int);
      localley.jdField_j_of_type_Int = this.jdField_d_of_type_Int;
      localley.jdField_d_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
      localley.jdField_e_of_type_JavaLangString = this.jdField_e_of_type_JavaLangString;
      localley.jdField_f_of_type_JavaLangString = this.jdField_i_of_type_JavaLangString;
      localley.jdField_g_of_type_JavaLangString = str1;
      localley.a(this.jdField_f_of_type_JavaLangString);
      if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
        Looper.myQueue().addIdleHandler(this.jdField_a_of_type_AndroidOsMessageQueue$IdleHandler);
      }
      localley.jdField_e_of_type_Boolean = this.jdField_a_of_type_Boolean;
      localley.S = this.jdField_b_of_type_Boolean;
      localley.r = this.jdField_c_of_type_Boolean;
      localley.jdField_i_of_type_JavaLangString = this.jdField_g_of_type_JavaLangString;
      localley.jdField_j_of_type_JavaLangString = this.jdField_h_of_type_JavaLangString;
      localley.jdField_k_of_type_JavaLangString = this.jdField_l_of_type_JavaLangString;
      localley.jdField_p_of_type_JavaLangString = this.jdField_m_of_type_JavaLangString;
      localley.A = this.jdField_e_of_type_Int;
      localley.jdField_B_of_type_Int = this.jdField_f_of_type_Int;
      localley.jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_ArrayOfByte;
      localley.jdField_N_of_type_Boolean = this.jdField_d_of_type_Boolean;
      localley.jdField_f_of_type_Int = this.jdField_b_of_type_Int;
      localley.n = this.jdField_f_of_type_Boolean;
      localley.jdField_b_of_type_Long = this.jdField_b_of_type_Long;
      localley.jdField_p_of_type_Int = this.jdField_g_of_type_Int;
      if (i1 != 4) {
        break label2095;
      }
      bool1 = true;
      label1594:
      localley.jdField_s_of_type_Boolean = bool1;
      localley.jdField_l_of_type_Int = ((Intent)localObject1).getIntExtra("friendTerminal", 3);
      localley.e("processIntentData", this.jdField_g_of_type_Boolean);
      localley.q = this.jdField_c_of_type_Int;
      localley.jdField_l_of_type_JavaLangString = ((Intent)localObject1).getStringExtra("actId");
      localley.jdField_m_of_type_JavaLangString = ((Intent)localObject1).getStringExtra("mp_ext_params");
      localley.jdField_a_of_type_Long = this.jdField_a_of_type_Long;
      if ((this.jdField_d_of_type_Int != 1011) && (this.jdField_d_of_type_Int != 21)) {
        break label2131;
      }
      localley.jdField_a_of_type_Lez.jdField_a_of_type_JavaLangString = str2;
      localley.jdField_a_of_type_Lez.jdField_b_of_type_JavaLangString = ((Intent)localObject1).getStringExtra("name");
      localley.jdField_a_of_type_Lez.jdField_c_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
      if (Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).longValue() <= Long.valueOf(this.jdField_c_of_type_JavaLangString).longValue()) {
        break label2101;
      }
      localley.jdField_a_of_type_Lez.jdField_a_of_type_Boolean = true;
      localObject1 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication().getApplicationInfo().dataDir + "/" + MD5.toMD5(str2) + ".jpg";
      if (!atwl.a((String)localObject1)) {}
    }
    for (;;)
    {
      try
      {
        localley.jdField_a_of_type_Lez.jdField_a_of_type_AndroidGraphicsBitmap = BitmapFactory.decodeFile((String)localObject1);
        QLog.w(this.jdField_b_of_type_JavaLangString + "|VideoNodeManager", 1, "processIntentData end, mRelationId[" + this.jdField_d_of_type_JavaLangString + "], bStartByTerminalSwitch[" + localley.ai + "], terSwitchStartFromVideoEntry[" + localley.ak + "], \nSessionInfo[" + localley + "]");
        return;
        if (this.jdField_d_of_type_Int == 1006)
        {
          if (TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString))
          {
            lbc.d(this.jdField_b_of_type_JavaLangString, "phoneNum is empty");
            this.jdField_e_of_type_Boolean = true;
            ((lhw)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4)).a(localley.b(), 5, 1016L);
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
          lbc.d(this.jdField_b_of_type_JavaLangString, "Create video failed because uin is empty");
          this.jdField_e_of_type_Boolean = true;
          ((lhw)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4)).a(localley.b(), 5, 1016L);
          finish();
          return;
        }
        if (!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) {
          break;
        }
        this.jdField_e_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
        break;
        label2095:
        bool1 = false;
        break label1594;
        label2101:
        localley.jdField_a_of_type_Lez.jdField_a_of_type_Boolean = false;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        QLog.d(this.jdField_b_of_type_JavaLangString, 1, "processIntentData OutOfMemoryError", localOutOfMemoryError);
        continue;
      }
      label2131:
      localley.jdField_a_of_type_Lez.jdField_a_of_type_JavaLangString = null;
      localley.jdField_a_of_type_Lez.jdField_b_of_type_JavaLangString = null;
      localley.jdField_a_of_type_Lez.jdField_a_of_type_Boolean = false;
    }
  }
  
  public void d(boolean paramBoolean)
  {
    QLog.w(this.jdField_b_of_type_JavaLangString, 1, "onZimuModeChange, inZimu[" + paramBoolean + "]");
    mih localmih;
    if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (this.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) && (this.jdField_a_of_type_Mih != null))
    {
      this.jdField_a_of_type_Mih.jdField_d_of_type_Boolean = paramBoolean;
      localmih = this.jdField_a_of_type_Mih;
      if (!paramBoolean) {
        break label87;
      }
    }
    label87:
    for (int i1 = 0;; i1 = this.jdField_h_of_type_Int)
    {
      localmih.d(i1);
      this.jdField_a_of_type_Mih.d();
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
      boolean bool = super.dispatchTouchEvent(paramMotionEvent);
      EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
      return bool;
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
        if (this.jdField_a_of_type_Mih == null) {
          break label219;
        }
        i1 = this.jdField_a_of_type_Mih.c();
        ((DoubleVideoCtrlUI)localObject).e_(i1);
        g(l1);
      }
    }
    if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (this.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) && (this.jdField_a_of_type_Mih != null))
    {
      this.jdField_a_of_type_Mih.jdField_c_of_type_Boolean = paramBoolean;
      if ((this.jdField_a_of_type_ComTencentAvVideoController.a().C) || (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_B_of_type_Boolean))
      {
        localObject = this.jdField_a_of_type_Mih;
        if (!paramBoolean) {
          break label224;
        }
      }
    }
    label219:
    label224:
    for (int i1 = i2;; i1 = this.jdField_h_of_type_Int)
    {
      ((mih)localObject).d(i1);
      this.jdField_a_of_type_Mih.d();
      localObject = findViewById(2131363079);
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
    bkho localbkho = bkho.c(this);
    localbkho.getWindow().addFlags(524288);
    localbkho.getWindow().addFlags(2097152);
    localbkho.getWindow().addFlags(128);
    localbkho.b(2131719078);
    localbkho.c(2131690582);
    localbkho.a(new map(this));
    localbkho.setOnDismissListener(new maq(this));
    localbkho.setCanceledOnTouchOutside(true);
    localbkho.e(150);
    this.jdField_a_of_type_AndroidAppDialog = localbkho;
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
    lbc.d(this.jdField_b_of_type_JavaLangString, "avideo life_finish, FromWhere[" + this.jdField_j_of_type_JavaLangString + "]");
    ley localley = lbu.a().a();
    if ((localley.jdField_B_of_type_Boolean) && (this.jdField_a_of_type_Mih != null))
    {
      this.jdField_a_of_type_Mih.c();
      if (this.jdField_a_of_type_Mih.b() < 1000L) {
        break label311;
      }
    }
    for (;;)
    {
      localley.v = i1;
      bcst.b(null, "CliOper", "", "", "0X800863D", "0X800863D", 0, 0, "", "", "", "");
      if ((this.jdField_e_of_type_Boolean) && (localley.aE) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null))
      {
        String str1 = String.valueOf(localley.jdField_g_of_type_Long);
        String str2 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getDisplayName(this.jdField_d_of_type_Int, str1, localley.jdField_f_of_type_JavaLangString);
        Intent localIntent = afur.a(new Intent(super.getApplicationContext(), SplashActivity.class), null);
        localIntent.putExtra("uin", str1);
        localIntent.putExtra("uintype", localley.jdField_j_of_type_Int);
        localIntent.putExtra("uinname", str2);
        startActivity(localIntent);
      }
      if (QLog.isColorLevel()) {
        QLog.i("double_2_multi", 2, "finish fromDoubleChat[" + localley.aE + "], session[" + localley + "]");
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
    ViewGroup localViewGroup = (ViewGroup)findViewById(2131363079);
    float f1 = getResources().getDimension(2131297636);
    float f2 = getResources().getDimension(2131297639);
    Object localObject = new RelativeLayout.LayoutParams(-1, (int)f1);
    ((RelativeLayout.LayoutParams)localObject).setMargins(0, (int)f2, 0, 0);
    this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterPanel = new EffectFilterPanel(getBaseContext(), this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterPanel.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = localViewGroup.findViewById(2131373534);
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
      ViewGroup localViewGroup = (ViewGroup)findViewById(2131363079);
      this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterPanel.setVisibility(8);
      localViewGroup.removeView(this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterPanel);
      this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterPanel = null;
    }
  }
  
  public void h(boolean paramBoolean)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (this.jdField_a_of_type_ComTencentAvVideoController.a() != null) && (VideoLayerUIBase.b(this.jdField_a_of_type_ComTencentAvVideoController.a())))
    {
      bool1 = true;
      QLog.d(this.jdField_b_of_type_JavaLangString, 1, "quitDoubleScreenStatus, exit[" + paramBoolean + "],[needIntercept:=" + bool1 + "]");
      if (!bool1) {
        break label88;
      }
    }
    label88:
    do
    {
      return;
      bool1 = false;
      break;
      a(1, false);
      if ((a()) && (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null)) {
        this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a("onChangeUI_quitDoubleScreenStatus");
      }
      if (paramBoolean) {
        a(2);
      }
    } while (!this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(3));
    FaceItem localFaceItem = (FaceItem)((lgp)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(3)).a();
    if ((localFaceItem != null) && (localFaceItem.isInteract()) && (localFaceItem.isSameType("face"))) {}
    for (paramBoolean = bool2;; paramBoolean = false)
    {
      lbc.c(this.jdField_b_of_type_JavaLangString, "onChangeUI_quitDoubleScreenStatus isIntactiveFace:" + paramBoolean);
      if (!paramBoolean) {
        break;
      }
      a(Integer.valueOf(6101), null, Boolean.valueOf(false));
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
  
  @TargetApi(21)
  public void j() {}
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "life_onActivityResult, requestCode[" + paramInt1 + "], resultCode[" + paramInt2 + "]");
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 801) {
      mpu.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramInt2, paramIntent);
    }
    do
    {
      do
      {
        return;
        if (paramInt1 == 802)
        {
          mpu.b(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramInt2, paramIntent);
          return;
        }
        if (paramInt1 != 1002) {
          break;
        }
      } while (this.jdField_a_of_type_Mgv == null);
      this.jdField_a_of_type_Mgv.f();
      return;
    } while ((Build.VERSION.SDK_INT < 21) || (paramInt1 != 8080) || (this.jdField_a_of_type_Miu == null));
    if (paramInt2 == -1)
    {
      this.jdField_a_of_type_Miu.a(paramIntent);
      this.jdField_a_of_type_Miu.a();
      return;
    }
    this.jdField_a_of_type_Miu.b();
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
    mcb localmcb = new mcb(null);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(7002), localmcb });
    QLog.i(this.jdField_b_of_type_JavaLangString, 1, "avideo onBackPressed, BlockSystemBack[" + localmcb.jdField_b_of_type_Boolean + "], BlockName[" + localmcb.jdField_b_of_type_JavaLangString + "]");
    boolean bool1 = localmcb.jdField_b_of_type_Boolean;
    boolean bool2 = bool1;
    if (!bool1)
    {
      bool2 = bool1;
      if (this.jdField_a_of_type_Mmj != null) {
        bool2 = this.jdField_a_of_type_Mmj.c();
      }
    }
    bool1 = bool2;
    if (!bool2)
    {
      if ((this.jdField_a_of_type_Mbq == null) || (!this.jdField_a_of_type_Mbq.a())) {
        break label221;
      }
      bool1 = this.jdField_a_of_type_Mbq.b();
    }
    for (;;)
    {
      bool2 = bool1;
      if (this.jdField_a_of_type_Mgv != null)
      {
        bool2 = bool1;
        if (this.jdField_a_of_type_Mgv.a())
        {
          this.jdField_a_of_type_Mgv.c();
          bool2 = true;
        }
      }
      if (!bool2) {
        super.onBackPressed();
      }
      this.jdField_a_of_type_ComTencentAvVideoController.a("backgroundReason", "2");
      lcc.jdField_a_of_type_JavaLangString = "2";
      return;
      label221:
      bool1 = bool2;
      if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
        bool1 = this.jdField_a_of_type_ComTencentAvUiVideoControlUI.a();
      }
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AudioHelper.b(this.jdField_b_of_type_JavaLangString + ".onCreate.begin");
    long l1 = AudioHelper.b();
    QLog.w(this.jdField_b_of_type_JavaLangString + "|VideoNodeManager", 1, "avideo life_onCreate, seq[" + l1 + "], IS_CPU_64_BIT = " + false);
    this.mIsShadow = false;
    super.onCreate(paramBundle);
    super.requestWindowFeature(1);
    super.setContentView(2131559683);
    super.getWindow().addFlags(524288);
    super.getWindow().addFlags(2097152);
    super.getWindow().addFlags(128);
    super.getWindow().setSoftInputMode(18);
    g(true);
    a(super.getWindow());
    Object localObject1 = super.getAppRuntime();
    paramBundle = (Bundle)localObject1;
    Object localObject2;
    boolean bool;
    if (localObject1 == null)
    {
      paramBundle = BaseApplicationImpl.getApplication();
      if (paramBundle == null) {
        break label326;
      }
      QLog.d(this.jdField_b_of_type_JavaLangString, 1, "onCreate, 尝试同步获取AppRuntime");
      paramBundle = paramBundle.getRuntime();
      localObject1 = this.jdField_b_of_type_JavaLangString;
      localObject2 = new StringBuilder().append("onCreate, 同步获取AppRuntime结果");
      if (paramBundle == null) {
        break label320;
      }
      bool = true;
      QLog.d((String)localObject1, 1, bool);
    }
    for (;;)
    {
      if (paramBundle != null) {
        break label343;
      }
      lbc.d(this.jdField_b_of_type_JavaLangString, "onCreate, appRuntime is null exit");
      paramBundle = super.getString(2131719019) + " 0x05";
      Toast.makeText(super.getBaseContext(), paramBundle, 0).show();
      this.jdField_e_of_type_Boolean = true;
      sendBroadcast(new Intent("com.tencent.av.ui.AVLoadingDialogActivity.ACTION_LOADING_FINISH"));
      finish();
      return;
      label320:
      bool = false;
      break;
      label326:
      QLog.d(this.jdField_b_of_type_JavaLangString, 1, "onCreate, BaseApplicationImpl.getApplication is null");
      paramBundle = (Bundle)localObject1;
    }
    label343:
    if ((paramBundle instanceof VideoAppInterface)) {}
    for (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = ((VideoAppInterface)paramBundle); this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null; this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = null)
    {
      lbc.d(this.jdField_b_of_type_JavaLangString, "onCreate, AppRuntime is no VideoAppInterface, " + paramBundle.getClass().getName() + " exit");
      paramBundle = super.getString(2131719019) + " 0x06";
      Toast.makeText(super.getBaseContext(), paramBundle, 0).show();
      this.jdField_e_of_type_Boolean = true;
      sendBroadcast(new Intent("com.tencent.av.ui.AVLoadingDialogActivity.ACTION_LOADING_FINISH"));
      finish();
      return;
    }
    f(true);
    paramBundle = (lhw)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4);
    localObject1 = lbu.a().a();
    if (localObject1 != null)
    {
      QLog.d(this.jdField_b_of_type_JavaLangString, 1, "avideo life_onCreate roomId = " + ((ley)localObject1).b() + ",isReceiver = " + ((ley)localObject1).jdField_e_of_type_Boolean);
      if (((ley)localObject1).jdField_e_of_type_Boolean) {
        paramBundle.a(((ley)localObject1).b(), 7, 1L);
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
      lhi.a().a(this);
      this.jdField_a_of_type_ComTencentAvVideoController = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
      if (this.jdField_a_of_type_ComTencentAvVideoController != null) {
        break;
      }
      lbc.d(this.jdField_b_of_type_JavaLangString, "onCreate,VideoAppInterface.mVideoController exit");
      paramBundle = super.getString(2131719019) + " 0x07";
      Toast.makeText(super.getBaseContext(), paramBundle, 0).show();
      this.jdField_e_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast(new Intent("com.tencent.av.ui.AVLoadingDialogActivity.ACTION_LOADING_FINISH"));
      finish();
      return;
      QLog.d(this.jdField_b_of_type_JavaLangString, 1, "avideo life_onCreate sessionInfo is null ");
    }
    if (!this.jdField_a_of_type_ComTencentAvVideoController.c())
    {
      lbc.d(this.jdField_b_of_type_JavaLangString, "onCreate,VideoAppInterface.initVcController exit");
      paramBundle = super.getString(2131719019) + " 0x08";
      Toast.makeText(super.getBaseContext(), paramBundle, 0).show();
      this.jdField_e_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast(new Intent("com.tencent.av.ui.AVLoadingDialogActivity.ACTION_LOADING_FINISH"));
      finish();
      return;
    }
    this.jdField_a_of_type_ComTencentAvVideoController.z(SDKConfigInfo.getDeviceInfo(getApplicationContext()));
    paramBundle = super.getIntent();
    int i1;
    if (paramBundle != null)
    {
      i1 = paramBundle.getIntExtra("uinType", -1);
      localObject1 = paramBundle.getStringExtra("uin");
      if (i1 == 1008)
      {
        localObject2 = lbu.a(3, (String)localObject1, new int[0]);
        localObject2 = lbu.a().c((String)localObject2);
        if ((localObject2 == null) || (((ley)localObject2).jdField_j_of_type_Int == -1))
        {
          localObject2 = lbu.a().a();
          if ((((ley)localObject2).jdField_j_of_type_Int != -1) && ((((ley)localObject2).h()) || (((ley)localObject2).j())))
          {
            paramBundle = new Intent("tencent.video.v2q.ypc2b.failEnter.asIsInviting");
            paramBundle.setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getPackageName());
            paramBundle.putExtra("uin", (String)localObject1);
            paramBundle.putExtra("uinType", i1);
            this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast(paramBundle);
            this.jdField_e_of_type_Boolean = true;
            this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast(new Intent("com.tencent.av.ui.AVLoadingDialogActivity.ACTION_LOADING_FINISH"));
            lbc.d(this.jdField_b_of_type_JavaLangString, "onCreate,VideoAppInterface.UIN_TYPE_PUBLIC_ACCOUNT exit: " + (String)localObject1);
            finish();
            return;
          }
        }
      }
    }
    if (QLog.isColorLevel())
    {
      localObject1 = this.jdField_b_of_type_JavaLangString;
      localObject2 = new StringBuilder().append("onCreate, from[");
      if (paramBundle == null)
      {
        paramBundle = "null";
        QLog.i((String)localObject1, 2, paramBundle);
      }
    }
    else
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_Ldy);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_Mbx);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_Lfe);
      this.jdField_a_of_type_ComTencentAvVideoController.b();
      a();
      d();
      this.jdField_a_of_type_JavaLangString = a(getIntent());
      if ((TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) || (a(getIntent())) || (lbu.a().a(this.jdField_a_of_type_JavaLangString))) {
        break label1668;
      }
      this.jdField_a_of_type_ComTencentAvVideoController.a(false, 204, new int[] { this.jdField_a_of_type_ComTencentAvVideoController.a().D });
      this.jdField_a_of_type_ComTencentAvVideoController.b(204);
      lbu.a().a(this.jdField_a_of_type_JavaLangString, false);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i(this.jdField_b_of_type_JavaLangString, 2, "onCreate, sessionId[" + this.jdField_a_of_type_JavaLangString + "]");
      }
      if (!this.jdField_a_of_type_ComTencentAvVideoController.a().a()) {
        c(l1);
      }
      GraphicRenderMgr.getInstance();
      ThreadManager.post(new AVActivity.4(this), 5, null, false);
      this.jdField_a_of_type_Msp = msp.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      b(0);
      a(l1, false);
      if ((this.jdField_a_of_type_ComTencentAvUiVideoControlUI instanceof DoubleVideoCtrlUI)) {
        lvi.a().a();
      }
      if (EffectSettingUi.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, false))
      {
        this.jdField_a_of_type_Mbv = new mbv(this);
        this.jdField_a_of_type_Mbv.a();
      }
      this.jdField_a_of_type_Lyj = lyj.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      i1 = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_N_of_type_Int;
      if (QLog.isDevelopLevel()) {
        QLog.d(this.jdField_b_of_type_JavaLangString, 4, "onCreate changeVideoLayoutMode Style=" + this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int + "|" + this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_N_of_type_Int + "|" + this.jdField_a_of_type_ComTencentAvVideoController.h());
      }
      a(i1, false);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast(new Intent("com.tencent.av.ui.AVLoadingDialogActivity.ACTION_LOADING_FINISH"));
      paramBundle = (ViewStub)findViewById(2131373241);
      this.jdField_a_of_type_Mgv = new mgv(findViewById(2131373176), paramBundle, 2131373476, this.jdField_a_of_type_ComTencentAvVideoController, this);
      this.jdField_a_of_type_Mmj = new mmj(this, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface)) {
        findViewById(2131373411).setVisibility(0);
      }
      this.jdField_a_of_type_ComTencentAvUiGuideGuideHelper.a(this);
      AudioHelper.b(this.jdField_b_of_type_JavaLangString + ".onCreate.end");
      return;
      paramBundle = paramBundle.getStringExtra("Fromwhere");
      break;
      label1668:
      this.jdField_a_of_type_JavaLangString = lbu.a().a().jdField_c_of_type_JavaLangString;
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
    j();
    if (this.jdField_a_of_type_Mmj != null)
    {
      this.jdField_a_of_type_Mmj.a(this.jdField_e_of_type_Boolean);
      this.jdField_a_of_type_Mmj = null;
    }
    if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (this.jdField_a_of_type_ComTencentAvVideoController.a() != null) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_B_of_type_Boolean) && (this.jdField_a_of_type_Mih != null)) {
      this.jdField_a_of_type_Mih.c();
    }
    if (this.jdField_a_of_type_Mih != null)
    {
      this.jdField_a_of_type_Mih.e();
      this.jdField_a_of_type_Mih = null;
    }
    if (this.jdField_a_of_type_ComTencentAvCameraCameraUtils != null)
    {
      this.jdField_a_of_type_ComTencentAvCameraCameraUtils.b(this.jdField_a_of_type_Ljd);
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
    if (this.jdField_a_of_type_Mbq != null)
    {
      this.jdField_a_of_type_Mbq.b();
      this.jdField_a_of_type_Mbq = null;
    }
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView.stopPlayback();
        localObject = this.jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView.getParent();
        if ((localObject instanceof ViewGroup)) {
          ((ViewGroup)localObject).removeAllViews();
        }
        this.jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView = null;
      }
    }
    catch (Throwable localThrowable)
    {
      Object localObject;
      label356:
      break label356;
    }
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_Lfe);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_Mbx);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_Ldy);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      localObject = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
      if (localObject != null) {
        ((ljo)localObject).a();
      }
    }
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null)
    {
      unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
    }
    if (this.jdField_e_of_type_Boolean)
    {
      lkz.a().a();
      if (this.jdField_a_of_type_Msp != null) {
        this.jdField_a_of_type_Msp.a(this.jdField_a_of_type_JavaLangString);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i(this.jdField_b_of_type_JavaLangString, 2, "onDestroy isQuit[" + this.jdField_e_of_type_Boolean + "], session[" + this.jdField_a_of_type_JavaLangString + "]");
    }
    this.jdField_a_of_type_ComTencentAvVideoController = null;
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a().d("AVActivity.onDestroy", 0);
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = null;
    this.jdField_a_of_type_Msp = null;
    this.jdField_a_of_type_Mbc = null;
    AudioHelper.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
    this.jdField_a_of_type_Mbx = null;
    this.jdField_a_of_type_Lfe = null;
    if (this.jdField_a_of_type_Mbv != null)
    {
      this.jdField_a_of_type_Mbv.b();
      this.jdField_a_of_type_Mbv = null;
    }
    lhi.a().a(null);
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(7004), this.jdField_c_of_type_JavaLangString, Boolean.valueOf(this.jdField_e_of_type_Boolean) });
    }
    lsv.a().a();
    lsv.a().a(null, null);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
    if (this.jdField_a_of_type_Mgv != null)
    {
      bcst.b(null, "CliOper", "", "", "0X800A345", "0X800A345", this.jdField_a_of_type_Mgv.a(), 0, "", "", "", "");
      this.jdField_a_of_type_Mgv.g();
    }
    this.jdField_a_of_type_Mgv = null;
    mqo.a(this);
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
      } while (((paramKeyEvent.jdField_d_of_type_Int != 2) || (!paramKeyEvent.l())) && ((paramKeyEvent.jdField_d_of_type_Int != 4) || (paramKeyEvent.jdField_g_of_type_Int < 9)));
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
    if (this.jdField_a_of_type_Lyj != null) {
      this.jdField_a_of_type_Lyj.b();
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
          if ((i2 != 2) && (this.jdField_a_of_type_ComTencentAvVideoController.a().D != 2)) {
            break label290;
          }
          if (this.jdField_a_of_type_ComTencentAvVideoController.a().D != i2) {
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
    aqfv.a(this, 2, true);
    lsv.a().a(16);
    i(false);
    bies.a(BaseApplicationImpl.getContext(), true, 50, 1);
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
        if ("0".equals(lcc.jdField_a_of_type_JavaLangString)) {
          this.jdField_a_of_type_ComTencentAvVideoController.a("backgroundReason", "5");
        }
      }
      QLog.d(this.jdField_b_of_type_JavaLangString, 1, "avideo life_onPause end");
      if (this.jdField_a_of_type_Mgv != null)
      {
        this.jdField_a_of_type_Mgv.c();
        this.jdField_a_of_type_Mgv.f();
      }
      this.jdField_a_of_type_Ljw.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_a_of_type_ComTencentAvVideoController);
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
    //   2: invokevirtual 2570	com/tencent/av/ui/AVActivity:i	(Z)V
    //   5: invokestatic 243	com/tencent/mobileqq/utils/AudioHelper:b	()J
    //   8: lstore 9
    //   10: aload_0
    //   11: iconst_2
    //   12: iconst_0
    //   13: invokestatic 2567	aqfv:a	(Landroid/content/Context;IZ)V
    //   16: invokestatic 2573	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   19: bipush 50
    //   21: iconst_0
    //   22: invokestatic 2605	bies:a	(Landroid/content/Context;II)V
    //   25: invokestatic 2573	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   28: iconst_0
    //   29: bipush 50
    //   31: iconst_1
    //   32: invokestatic 2578	bies:a	(Landroid/content/Context;ZII)V
    //   35: invokestatic 2573	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   38: bipush 50
    //   40: iconst_2
    //   41: invokestatic 2605	bies:a	(Landroid/content/Context;II)V
    //   44: new 231	java/lang/StringBuilder
    //   47: dup
    //   48: invokespecial 232	java/lang/StringBuilder:<init>	()V
    //   51: aload_0
    //   52: getfield 252	com/tencent/av/ui/AVActivity:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   55: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: ldc_w 2607
    //   61: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: invokevirtual 250	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   67: invokestatic 2258	com/tencent/mobileqq/utils/AudioHelper:b	(Ljava/lang/String;)V
    //   70: aload_0
    //   71: iconst_0
    //   72: putfield 229	com/tencent/av/ui/AVActivity:mIsShadow	Z
    //   75: aload_0
    //   76: invokespecial 2609	mqq/app/BaseActivity:onResume	()V
    //   79: invokestatic 1612	lbu:a	()Llbu;
    //   82: invokevirtual 2063	lbu:a	()Lley;
    //   85: astore 21
    //   87: aload_0
    //   88: getfield 252	com/tencent/av/ui/AVActivity:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   91: iconst_1
    //   92: new 231	java/lang/StringBuilder
    //   95: dup
    //   96: invokespecial 232	java/lang/StringBuilder:<init>	()V
    //   99: ldc_w 2611
    //   102: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: aload_0
    //   106: getfield 569	com/tencent/av/ui/AVActivity:o	Z
    //   109: invokevirtual 471	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   112: ldc_w 531
    //   115: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: lload 9
    //   120: invokevirtual 246	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   123: ldc_w 2613
    //   126: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: aload 21
    //   131: invokevirtual 728	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   134: ldc_w 313
    //   137: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: invokevirtual 250	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   143: invokestatic 406	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   146: aload_0
    //   147: iconst_0
    //   148: putfield 2580	com/tencent/av/ui/AVActivity:jdField_i_of_type_Boolean	Z
    //   151: invokestatic 2616	lpb:a	()V
    //   154: aload_0
    //   155: getfield 139	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvAppVideoAppInterface	Lcom/tencent/av/app/VideoAppInterface;
    //   158: iconst_4
    //   159: invokevirtual 1300	com/tencent/av/app/VideoAppInterface:a	(I)Llgb;
    //   162: checkcast 1512	lhw
    //   165: astore 22
    //   167: aload 21
    //   169: getfield 895	ley:jdField_e_of_type_Boolean	Z
    //   172: ifeq +16 -> 188
    //   175: aload 22
    //   177: aload 21
    //   179: invokevirtual 1513	ley:b	()J
    //   182: bipush 8
    //   184: lconst_1
    //   185: invokevirtual 1518	lhw:a	(JIJ)V
    //   188: aload_0
    //   189: invokevirtual 1137	com/tencent/av/ui/AVActivity:getIntent	()Landroid/content/Intent;
    //   192: ldc_w 2338
    //   195: iconst_0
    //   196: invokevirtual 284	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   199: ifeq +13 -> 212
    //   202: aload 22
    //   204: ldc2_w 2339
    //   207: iconst_3
    //   208: lconst_1
    //   209: invokevirtual 1518	lhw:a	(JIJ)V
    //   212: aload_0
    //   213: getfield 139	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvAppVideoAppInterface	Lcom/tencent/av/app/VideoAppInterface;
    //   216: invokevirtual 2617	com/tencent/av/app/VideoAppInterface:j	()Z
    //   219: ifne +10 -> 229
    //   222: aload_0
    //   223: getfield 139	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvAppVideoAppInterface	Lcom/tencent/av/app/VideoAppInterface;
    //   226: invokevirtual 2618	com/tencent/av/app/VideoAppInterface:b	()V
    //   229: aload_0
    //   230: getfield 569	com/tencent/av/ui/AVActivity:o	Z
    //   233: ifeq +19 -> 252
    //   236: aload_0
    //   237: getfield 79	com/tencent/av/ui/AVActivity:jdField_b_of_type_Int	I
    //   240: iconst_1
    //   241: if_icmpeq +11 -> 252
    //   244: aload_0
    //   245: getfield 79	com/tencent/av/ui/AVActivity:jdField_b_of_type_Int	I
    //   248: iconst_2
    //   249: if_icmpne +3 -> 252
    //   252: aload_0
    //   253: iconst_0
    //   254: putfield 569	com/tencent/av/ui/AVActivity:o	Z
    //   257: aload_0
    //   258: iconst_0
    //   259: putfield 203	com/tencent/av/ui/AVActivity:jdField_k_of_type_Boolean	Z
    //   262: aload_0
    //   263: iconst_2
    //   264: invokevirtual 2422	com/tencent/av/ui/AVActivity:b	(I)V
    //   267: aload_0
    //   268: getfield 141	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvVideoController	Lcom/tencent/av/VideoController;
    //   271: iconst_1
    //   272: invokevirtual 1406	com/tencent/av/VideoController:h	(Z)V
    //   275: aload_0
    //   276: getfield 334	com/tencent/av/ui/AVActivity:jdField_a_of_type_Lyj	Llyj;
    //   279: ifnull +10 -> 289
    //   282: aload_0
    //   283: getfield 334	com/tencent/av/ui/AVActivity:jdField_a_of_type_Lyj	Llyj;
    //   286: invokevirtual 2554	lyj:b	()V
    //   289: getstatic 458	android/os/Build$VERSION:SDK_INT	I
    //   292: bipush 21
    //   294: if_icmplt +47 -> 341
    //   297: aload_0
    //   298: getfield 141	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvVideoController	Lcom/tencent/av/VideoController;
    //   301: invokevirtual 834	com/tencent/av/VideoController:a	()Lmiu;
    //   304: astore 19
    //   306: aload 19
    //   308: ifnull +33 -> 341
    //   311: aload 19
    //   313: invokevirtual 2619	miu:c	()Z
    //   316: ifeq +25 -> 341
    //   319: aload_0
    //   320: getfield 139	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvAppVideoAppInterface	Lcom/tencent/av/app/VideoAppInterface;
    //   323: invokevirtual 1009	com/tencent/av/app/VideoAppInterface:a	()Landroid/os/Handler;
    //   326: new 2621	com/tencent/av/ui/AVActivity$11
    //   329: dup
    //   330: aload_0
    //   331: invokespecial 2622	com/tencent/av/ui/AVActivity$11:<init>	(Lcom/tencent/av/ui/AVActivity;)V
    //   334: ldc2_w 2623
    //   337: invokevirtual 1018	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   340: pop
    //   341: aload_0
    //   342: getfield 139	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvAppVideoAppInterface	Lcom/tencent/av/app/VideoAppInterface;
    //   345: invokevirtual 1009	com/tencent/av/app/VideoAppInterface:a	()Landroid/os/Handler;
    //   348: new 2626	com/tencent/av/ui/AVActivity$12
    //   351: dup
    //   352: aload_0
    //   353: lload 9
    //   355: invokespecial 2628	com/tencent/av/ui/AVActivity$12:<init>	(Lcom/tencent/av/ui/AVActivity;J)V
    //   358: ldc2_w 2629
    //   361: invokevirtual 1018	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   364: pop
    //   365: aload 21
    //   367: getfield 517	ley:jdField_d_of_type_Int	I
    //   370: iconst_2
    //   371: if_icmpne +1073 -> 1444
    //   374: aload 21
    //   376: invokevirtual 2547	ley:l	()Z
    //   379: ifeq +1011 -> 1390
    //   382: aload 21
    //   384: getfield 1202	ley:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   387: astore 19
    //   389: aload 21
    //   391: getfield 2631	ley:jdField_k_of_type_Boolean	Z
    //   394: istore 15
    //   396: aload_0
    //   397: getfield 141	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvVideoController	Lcom/tencent/av/VideoController;
    //   400: aload_0
    //   401: getfield 93	com/tencent/av/ui/AVActivity:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   404: invokevirtual 2633	com/tencent/av/VideoController:b	(Ljava/lang/String;)Z
    //   407: istore 16
    //   409: aload 21
    //   411: getfield 2634	ley:jdField_i_of_type_Boolean	Z
    //   414: istore 17
    //   416: aload 21
    //   418: getfield 2635	ley:jdField_j_of_type_Boolean	Z
    //   421: istore 18
    //   423: iload 18
    //   425: ifeq +41 -> 466
    //   428: invokestatic 2639	bgln:d	()Ljava/lang/String;
    //   431: astore 20
    //   433: aload_0
    //   434: getfield 901	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvCameraCameraUtils	Lcom/tencent/av/camera/CameraUtils;
    //   437: lload 9
    //   439: invokevirtual 2641	com/tencent/av/camera/CameraUtils:a	(J)Z
    //   442: ifne +835 -> 1277
    //   445: aload_0
    //   446: getfield 901	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvCameraCameraUtils	Lcom/tencent/av/camera/CameraUtils;
    //   449: lload 9
    //   451: invokevirtual 909	com/tencent/av/camera/CameraUtils:b	(J)Z
    //   454: ifne +823 -> 1277
    //   457: aload_0
    //   458: getfield 901	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvCameraCameraUtils	Lcom/tencent/av/camera/CameraUtils;
    //   461: lload 9
    //   463: invokevirtual 2642	com/tencent/av/camera/CameraUtils:a	(J)V
    //   466: aload_0
    //   467: getfield 594	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   470: ifnull +59 -> 529
    //   473: iload 18
    //   475: ifeq +871 -> 1346
    //   478: iload 15
    //   480: ifeq +866 -> 1346
    //   483: iload 17
    //   485: ifeq +830 -> 1315
    //   488: aload_0
    //   489: getfield 594	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   492: lload 9
    //   494: aload 19
    //   496: iconst_1
    //   497: iconst_1
    //   498: iconst_0
    //   499: iload 16
    //   501: invokevirtual 1394	com/tencent/av/ui/VideoLayerUI:a	(JLjava/lang/String;IZZZ)V
    //   504: aload_0
    //   505: getfield 139	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvAppVideoAppInterface	Lcom/tencent/av/app/VideoAppInterface;
    //   508: ldc_w 2643
    //   511: invokestatic 2646	mpu:a	(Lcom/tencent/av/app/VideoAppInterface;Ljava/lang/String;)Z
    //   514: istore 15
    //   516: aload_0
    //   517: getfield 594	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   520: lload 9
    //   522: iconst_1
    //   523: iload 15
    //   525: invokevirtual 904	com/tencent/av/ui/VideoLayerUI:b	(JZZ)Z
    //   528: pop
    //   529: aload_0
    //   530: getfield 594	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   533: ifnull +10 -> 543
    //   536: aload_0
    //   537: getfield 594	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   540: invokevirtual 2648	com/tencent/av/ui/VideoLayerUI:q	()V
    //   543: aload_0
    //   544: getfield 514	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoControlUI	Lcom/tencent/av/ui/VideoControlUI;
    //   547: ifnull +12 -> 559
    //   550: aload_0
    //   551: getfield 514	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoControlUI	Lcom/tencent/av/ui/VideoControlUI;
    //   554: lload 9
    //   556: invokevirtual 2650	com/tencent/av/ui/VideoControlUI:b	(J)V
    //   559: aload_0
    //   560: getfield 544	com/tencent/av/ui/AVActivity:jdField_a_of_type_Mbq	Lmbq;
    //   563: ifnull +10 -> 573
    //   566: aload_0
    //   567: getfield 544	com/tencent/av/ui/AVActivity:jdField_a_of_type_Mbq	Lmbq;
    //   570: invokevirtual 2651	mbq:c	()V
    //   573: aload_0
    //   574: getfield 141	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvVideoController	Lcom/tencent/av/VideoController;
    //   577: iconst_0
    //   578: invokevirtual 1404	com/tencent/av/VideoController:a	(Z)I
    //   581: pop
    //   582: aload_0
    //   583: invokevirtual 2652	com/tencent/av/ui/AVActivity:b	()V
    //   586: aload_0
    //   587: invokevirtual 2653	com/tencent/av/ui/AVActivity:e	()V
    //   590: aload_0
    //   591: getfield 139	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvAppVideoAppInterface	Lcom/tencent/av/app/VideoAppInterface;
    //   594: invokevirtual 2361	com/tencent/av/app/VideoAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   597: new 263	android/content/Intent
    //   600: dup
    //   601: ldc_w 2312
    //   604: invokespecial 2313	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   607: invokevirtual 2364	com/tencent/qphone/base/util/BaseApplication:sendBroadcast	(Landroid/content/Intent;)V
    //   610: aload_0
    //   611: getfield 594	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   614: ifnull +20 -> 634
    //   617: aload_0
    //   618: invokevirtual 558	com/tencent/av/ui/AVActivity:a	()Z
    //   621: ifeq +13 -> 634
    //   624: aload_0
    //   625: getfield 594	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   628: ldc_w 2643
    //   631: invokevirtual 2141	com/tencent/av/ui/VideoLayerUI:a	(Ljava/lang/String;)V
    //   634: aload 21
    //   636: getfield 517	ley:jdField_d_of_type_Int	I
    //   639: iconst_2
    //   640: if_icmpeq +12 -> 652
    //   643: aload 21
    //   645: getfield 517	ley:jdField_d_of_type_Int	I
    //   648: iconst_1
    //   649: if_icmpne +45 -> 694
    //   652: aload_0
    //   653: getfield 614	com/tencent/av/ui/AVActivity:jdField_a_of_type_Mih	Lmih;
    //   656: ifnull +38 -> 694
    //   659: aload_0
    //   660: getfield 614	com/tencent/av/ui/AVActivity:jdField_a_of_type_Mih	Lmih;
    //   663: invokevirtual 2655	mih:d	()I
    //   666: iconst_1
    //   667: if_icmpne +27 -> 694
    //   670: aload 21
    //   672: getfield 975	ley:C	Z
    //   675: ifeq +19 -> 694
    //   678: aload_0
    //   679: getfield 221	com/tencent/av/ui/AVActivity:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   682: new 2657	com/tencent/av/ui/AVActivity$14
    //   685: dup
    //   686: aload_0
    //   687: invokespecial 2658	com/tencent/av/ui/AVActivity$14:<init>	(Lcom/tencent/av/ui/AVActivity;)V
    //   690: invokevirtual 1260	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   693: pop
    //   694: aload 21
    //   696: getfield 2661	ley:X	I
    //   699: iconst_m1
    //   700: if_icmpne +12 -> 712
    //   703: aload 21
    //   705: aload_0
    //   706: invokevirtual 2662	com/tencent/av/ui/AVActivity:a	()I
    //   709: putfield 2661	ley:X	I
    //   712: aload 21
    //   714: getfield 2665	ley:W	I
    //   717: iconst_m1
    //   718: if_icmpne +105 -> 823
    //   721: aload_0
    //   722: invokevirtual 575	com/tencent/av/ui/AVActivity:getApplicationContext	()Landroid/content/Context;
    //   725: invokestatic 684	bgsg:a	(Landroid/content/Context;)Landroid/content/SharedPreferences;
    //   728: astore 19
    //   730: aload 21
    //   732: aload 19
    //   734: new 231	java/lang/StringBuilder
    //   737: dup
    //   738: invokespecial 232	java/lang/StringBuilder:<init>	()V
    //   741: ldc_w 2667
    //   744: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   747: aload_0
    //   748: getfield 139	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvAppVideoAppInterface	Lcom/tencent/av/app/VideoAppInterface;
    //   751: invokevirtual 689	com/tencent/av/app/VideoAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   754: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   757: invokevirtual 250	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   760: iconst_1
    //   761: invokeinterface 699 3 0
    //   766: putfield 2665	ley:W	I
    //   769: aload 21
    //   771: getfield 2665	ley:W	I
    //   774: iconst_1
    //   775: if_icmpne +48 -> 823
    //   778: aload 19
    //   780: invokeinterface 2671 1 0
    //   785: new 231	java/lang/StringBuilder
    //   788: dup
    //   789: invokespecial 232	java/lang/StringBuilder:<init>	()V
    //   792: ldc_w 2667
    //   795: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   798: aload_0
    //   799: getfield 139	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvAppVideoAppInterface	Lcom/tencent/av/app/VideoAppInterface;
    //   802: invokevirtual 689	com/tencent/av/app/VideoAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   805: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   808: invokevirtual 250	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   811: iconst_0
    //   812: invokeinterface 2677 3 0
    //   817: invokeinterface 2680 1 0
    //   822: pop
    //   823: aload 21
    //   825: getfield 2068	ley:v	I
    //   828: ifeq +38 -> 866
    //   831: aload 21
    //   833: getfield 2068	ley:v	I
    //   836: iconst_1
    //   837: if_icmpne +1299 -> 2136
    //   840: aload_0
    //   841: iconst_2
    //   842: aload_0
    //   843: invokevirtual 739	com/tencent/av/ui/AVActivity:getResources	()Landroid/content/res/Resources;
    //   846: ldc_w 2681
    //   849: invokevirtual 2682	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   852: iconst_0
    //   853: invokestatic 2687	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;ILjava/lang/CharSequence;I)Lcom/tencent/mobileqq/widget/QQToast;
    //   856: invokevirtual 2690	com/tencent/mobileqq/widget/QQToast:a	()Landroid/widget/Toast;
    //   859: pop
    //   860: aload 21
    //   862: iconst_0
    //   863: putfield 2068	ley:v	I
    //   866: aload_0
    //   867: getfield 139	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvAppVideoAppInterface	Lcom/tencent/av/app/VideoAppInterface;
    //   870: iconst_2
    //   871: anewarray 1294	java/lang/Object
    //   874: dup
    //   875: iconst_0
    //   876: sipush 7000
    //   879: invokestatic 2160	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   882: aastore
    //   883: dup
    //   884: iconst_1
    //   885: aload_0
    //   886: getfield 93	com/tencent/av/ui/AVActivity:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   889: aastore
    //   890: invokevirtual 1297	com/tencent/av/app/VideoAppInterface:a	([Ljava/lang/Object;)V
    //   893: invokestatic 670	com/tencent/mobileqq/utils/AudioHelper:e	()Z
    //   896: ifeq +10 -> 906
    //   899: aload_0
    //   900: getfield 139	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvAppVideoAppInterface	Lcom/tencent/av/app/VideoAppInterface;
    //   903: invokestatic 2693	com/tencent/mobileqq/debug/PstnCardTestActivity:showTestBtn	(Lcom/tencent/av/app/VideoAppInterface;)V
    //   906: invokestatic 1249	lsv:a	()Llsv;
    //   909: bipush 16
    //   911: invokevirtual 2694	lsv:b	(I)V
    //   914: aload 21
    //   916: getfield 2635	ley:jdField_j_of_type_Boolean	Z
    //   919: istore 15
    //   921: aload 21
    //   923: getfield 2631	ley:jdField_k_of_type_Boolean	Z
    //   926: istore 16
    //   928: iload 15
    //   930: ifeq +8 -> 938
    //   933: iload 16
    //   935: ifne +1224 -> 2159
    //   938: invokestatic 1249	lsv:a	()Llsv;
    //   941: iconst_1
    //   942: invokevirtual 2568	lsv:a	(I)V
    //   945: invokestatic 2697	java/lang/System:currentTimeMillis	()J
    //   948: lstore 11
    //   950: invokestatic 2428	lvi:a	()Llvi;
    //   953: getfield 2698	lvi:jdField_b_of_type_Long	J
    //   956: lstore 13
    //   958: aload 21
    //   960: invokevirtual 1513	ley:b	()J
    //   963: lconst_0
    //   964: lcmp
    //   965: ifle +1204 -> 2169
    //   968: aload 21
    //   970: invokevirtual 1513	ley:b	()J
    //   973: lstore 7
    //   975: aload 22
    //   977: lload 7
    //   979: bipush 25
    //   981: lload 11
    //   983: lload 13
    //   985: lsub
    //   986: invokevirtual 1518	lhw:a	(JIJ)V
    //   989: aload_0
    //   990: getfield 141	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvVideoController	Lcom/tencent/av/VideoController;
    //   993: ldc_w 2585
    //   996: ldc_w 2700
    //   999: invokevirtual 2238	com/tencent/av/VideoController:a	(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/av/VideoController;
    //   1002: pop
    //   1003: ldc_w 2587
    //   1006: putstatic 2241	lcc:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1009: new 231	java/lang/StringBuilder
    //   1012: dup
    //   1013: invokespecial 232	java/lang/StringBuilder:<init>	()V
    //   1016: aload_0
    //   1017: getfield 252	com/tencent/av/ui/AVActivity:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1020: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1023: ldc_w 2702
    //   1026: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1029: invokevirtual 250	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1032: invokestatic 2258	com/tencent/mobileqq/utils/AudioHelper:b	(Ljava/lang/String;)V
    //   1035: aload_0
    //   1036: invokevirtual 1137	com/tencent/av/ui/AVActivity:getIntent	()Landroid/content/Intent;
    //   1039: ldc_w 2704
    //   1042: iconst_0
    //   1043: invokevirtual 267	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   1046: ifeq +21 -> 1067
    //   1049: invokestatic 2709	addy:a	()Laddy;
    //   1052: aload_0
    //   1053: invokevirtual 1137	com/tencent/av/ui/AVActivity:getIntent	()Landroid/content/Intent;
    //   1056: ldc_w 2704
    //   1059: iconst_0
    //   1060: invokevirtual 267	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   1063: iconst_1
    //   1064: invokevirtual 2710	addy:a	(IZ)V
    //   1067: aload_0
    //   1068: invokevirtual 2711	com/tencent/av/ui/AVActivity:a	()Lcom/tencent/av/VideoController;
    //   1071: invokevirtual 2712	com/tencent/av/VideoController:x	()V
    //   1074: invokestatic 2713	com/tencent/av/VideoController:a	()Lcom/tencent/av/VideoController;
    //   1077: aload_0
    //   1078: invokevirtual 1093	com/tencent/av/VideoController:a	(Landroid/content/Context;)Lloz;
    //   1081: astore 19
    //   1083: aload 19
    //   1085: ifnull +12 -> 1097
    //   1088: aload 19
    //   1090: lload 9
    //   1092: invokeinterface 2716 3 0
    //   1097: invokestatic 670	com/tencent/mobileqq/utils/AudioHelper:e	()Z
    //   1100: ifeq +46 -> 1146
    //   1103: aload_0
    //   1104: getfield 252	com/tencent/av/ui/AVActivity:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1107: iconst_1
    //   1108: new 231	java/lang/StringBuilder
    //   1111: dup
    //   1112: invokespecial 232	java/lang/StringBuilder:<init>	()V
    //   1115: ldc_w 2718
    //   1118: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1121: aload_0
    //   1122: invokevirtual 1996	com/tencent/av/ui/AVActivity:getWindow	()Landroid/view/Window;
    //   1125: invokevirtual 445	android/view/Window:getDecorView	()Landroid/view/View;
    //   1128: invokevirtual 450	android/view/View:getSystemUiVisibility	()I
    //   1131: invokevirtual 309	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1134: ldc_w 313
    //   1137: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1140: invokevirtual 250	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1143: invokestatic 406	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1146: aload_0
    //   1147: getfield 179	com/tencent/av/ui/AVActivity:jdField_a_of_type_Ljw	Lljw;
    //   1150: aload_0
    //   1151: aload_0
    //   1152: getfield 139	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvAppVideoAppInterface	Lcom/tencent/av/app/VideoAppInterface;
    //   1155: aload_0
    //   1156: getfield 141	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvVideoController	Lcom/tencent/av/VideoController;
    //   1159: invokevirtual 2721	ljw:a	(Lmqq/app/BaseActivity;Lcom/tencent/av/app/VideoAppInterface;Lcom/tencent/av/VideoController;)V
    //   1162: aload_0
    //   1163: getfield 924	com/tencent/av/ui/AVActivity:jdField_a_of_type_Mmj	Lmmj;
    //   1166: ifnull +76 -> 1242
    //   1169: invokestatic 304	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1172: ifeq +41 -> 1213
    //   1175: aload_0
    //   1176: getfield 252	com/tencent/av/ui/AVActivity:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1179: iconst_2
    //   1180: new 231	java/lang/StringBuilder
    //   1183: dup
    //   1184: invokespecial 232	java/lang/StringBuilder:<init>	()V
    //   1187: ldc_w 2723
    //   1190: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1193: aload 21
    //   1195: getfield 2726	ley:aC	Z
    //   1198: invokevirtual 471	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1201: ldc_w 313
    //   1204: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1207: invokevirtual 250	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1210: invokestatic 316	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1213: aload 21
    //   1215: getfield 2726	ley:aC	Z
    //   1218: ifeq +17 -> 1235
    //   1221: aload_0
    //   1222: getfield 924	com/tencent/av/ui/AVActivity:jdField_a_of_type_Mmj	Lmmj;
    //   1225: iconst_0
    //   1226: invokevirtual 2727	mmj:a	(I)V
    //   1229: aload 21
    //   1231: iconst_0
    //   1232: putfield 2726	ley:aC	Z
    //   1235: aload_0
    //   1236: getfield 924	com/tencent/av/ui/AVActivity:jdField_a_of_type_Mmj	Lmmj;
    //   1239: invokevirtual 928	mmj:a	()V
    //   1242: return
    //   1243: astore 19
    //   1245: aload_0
    //   1246: getfield 252	com/tencent/av/ui/AVActivity:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1249: iconst_1
    //   1250: new 231	java/lang/StringBuilder
    //   1253: dup
    //   1254: invokespecial 232	java/lang/StringBuilder:<init>	()V
    //   1257: ldc_w 2729
    //   1260: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1263: aload 19
    //   1265: invokevirtual 728	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1268: invokevirtual 250	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1271: invokestatic 326	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1274: goto -1195 -> 79
    //   1277: aload 20
    //   1279: ldc_w 2731
    //   1282: invokevirtual 2734	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1285: ifeq -819 -> 466
    //   1288: aload_0
    //   1289: getfield 901	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvCameraCameraUtils	Lcom/tencent/av/camera/CameraUtils;
    //   1292: invokevirtual 2737	com/tencent/av/camera/CameraUtils:a	()Landroid/hardware/Camera$Parameters;
    //   1295: ifnonnull -829 -> 466
    //   1298: aload_0
    //   1299: getfield 901	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvCameraCameraUtils	Lcom/tencent/av/camera/CameraUtils;
    //   1302: ldc_w 2739
    //   1305: lload 9
    //   1307: iconst_m1
    //   1308: iconst_m1
    //   1309: invokevirtual 2742	com/tencent/av/camera/CameraUtils:a	(Ljava/lang/String;JII)V
    //   1312: goto -846 -> 466
    //   1315: aload_0
    //   1316: getfield 594	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   1319: lload 9
    //   1321: iconst_1
    //   1322: iconst_0
    //   1323: invokevirtual 904	com/tencent/av/ui/VideoLayerUI:b	(JZZ)Z
    //   1326: pop
    //   1327: aload_0
    //   1328: getfield 594	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   1331: lload 9
    //   1333: aload 19
    //   1335: iconst_1
    //   1336: iconst_1
    //   1337: iconst_0
    //   1338: iload 16
    //   1340: invokevirtual 1394	com/tencent/av/ui/VideoLayerUI:a	(JLjava/lang/String;IZZZ)V
    //   1343: goto -814 -> 529
    //   1346: iload 18
    //   1348: ifeq +18 -> 1366
    //   1351: aload_0
    //   1352: getfield 594	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   1355: lload 9
    //   1357: iconst_1
    //   1358: iconst_0
    //   1359: invokevirtual 904	com/tencent/av/ui/VideoLayerUI:b	(JZZ)Z
    //   1362: pop
    //   1363: goto -834 -> 529
    //   1366: iload 15
    //   1368: ifeq -839 -> 529
    //   1371: aload_0
    //   1372: getfield 594	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   1375: lload 9
    //   1377: aload 19
    //   1379: iconst_1
    //   1380: iconst_1
    //   1381: iconst_0
    //   1382: iload 16
    //   1384: invokevirtual 1394	com/tencent/av/ui/VideoLayerUI:a	(JLjava/lang/String;IZZZ)V
    //   1387: goto -858 -> 529
    //   1390: aload 21
    //   1392: getfield 1831	ley:ai	Z
    //   1395: ifne -866 -> 529
    //   1398: aload_0
    //   1399: getfield 125	com/tencent/av/ui/AVActivity:jdField_f_of_type_Boolean	Z
    //   1402: ifne -873 -> 529
    //   1405: aload 21
    //   1407: lload 9
    //   1409: iconst_1
    //   1410: invokevirtual 912	ley:a	(JZ)V
    //   1413: aload_0
    //   1414: getfield 901	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvCameraCameraUtils	Lcom/tencent/av/camera/CameraUtils;
    //   1417: lload 9
    //   1419: invokevirtual 2642	com/tencent/av/camera/CameraUtils:a	(J)V
    //   1422: aload_0
    //   1423: getfield 594	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   1426: ifnull -897 -> 529
    //   1429: aload_0
    //   1430: getfield 594	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   1433: lload 9
    //   1435: iconst_1
    //   1436: iconst_0
    //   1437: invokevirtual 904	com/tencent/av/ui/VideoLayerUI:b	(JZZ)Z
    //   1440: pop
    //   1441: goto -912 -> 529
    //   1444: aload 21
    //   1446: getfield 517	ley:jdField_d_of_type_Int	I
    //   1449: iconst_4
    //   1450: if_icmpne -921 -> 529
    //   1453: aload 21
    //   1455: getfield 1365	ley:jdField_c_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   1458: astore 23
    //   1460: aload 23
    //   1462: new 2744	mao
    //   1465: dup
    //   1466: aload_0
    //   1467: invokespecial 2745	mao:<init>	(Lcom/tencent/av/ui/AVActivity;)V
    //   1470: invokestatic 2751	java/util/Collections:sort	(Ljava/util/List;Ljava/util/Comparator;)V
    //   1473: aload_0
    //   1474: getfield 141	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvVideoController	Lcom/tencent/av/VideoController;
    //   1477: invokevirtual 2448	com/tencent/av/VideoController:h	()I
    //   1480: istore 4
    //   1482: iconst_0
    //   1483: istore_3
    //   1484: iload_3
    //   1485: aload 23
    //   1487: invokevirtual 1370	java/util/ArrayList:size	()I
    //   1490: if_icmpge -961 -> 529
    //   1493: aload 23
    //   1495: iload_3
    //   1496: invokevirtual 1374	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1499: checkcast 1376	lnn
    //   1502: astore 24
    //   1504: aload 24
    //   1506: getfield 1377	lnn:jdField_a_of_type_Long	J
    //   1509: invokestatic 1382	mqu:a	(J)Ljava/lang/String;
    //   1512: astore 25
    //   1514: aload 24
    //   1516: getfield 1383	lnn:jdField_a_of_type_Int	I
    //   1519: istore 5
    //   1521: aload 24
    //   1523: getfield 2752	lnn:jdField_a_of_type_Boolean	Z
    //   1526: istore 16
    //   1528: aload_0
    //   1529: getfield 594	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   1532: ifnull +371 -> 1903
    //   1535: aload_0
    //   1536: getfield 594	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   1539: aload 25
    //   1541: iload 5
    //   1543: invokevirtual 2755	com/tencent/av/ui/VideoLayerUI:a	(Ljava/lang/String;I)Z
    //   1546: istore 15
    //   1548: aload_0
    //   1549: getfield 85	com/tencent/av/ui/AVActivity:jdField_d_of_type_Int	I
    //   1552: invokestatic 2756	mqo:b	(I)I
    //   1555: istore 6
    //   1557: aload_0
    //   1558: getfield 139	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvAppVideoAppInterface	Lcom/tencent/av/app/VideoAppInterface;
    //   1561: iload 6
    //   1563: aload 25
    //   1565: aload 21
    //   1567: getfield 1645	ley:jdField_g_of_type_Long	J
    //   1570: invokestatic 1551	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1573: invokevirtual 2077	com/tencent/av/app/VideoAppInterface:getDisplayName	(ILjava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1576: astore 20
    //   1578: aload 24
    //   1580: getfield 2757	lnn:jdField_b_of_type_Boolean	Z
    //   1583: ifeq +126 -> 1709
    //   1586: aload 25
    //   1588: aload_0
    //   1589: getfield 139	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvAppVideoAppInterface	Lcom/tencent/av/app/VideoAppInterface;
    //   1592: invokevirtual 689	com/tencent/av/app/VideoAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1595: invokevirtual 1391	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1598: ifne +111 -> 1709
    //   1601: iload 16
    //   1603: ifeq +106 -> 1709
    //   1606: aload 24
    //   1608: getfield 2758	lnn:jdField_d_of_type_Boolean	Z
    //   1611: ifne +98 -> 1709
    //   1614: aload 20
    //   1616: invokestatic 2760	mqu:a	(Ljava/lang/String;)I
    //   1619: bipush 20
    //   1621: if_icmple +561 -> 2182
    //   1624: new 231	java/lang/StringBuilder
    //   1627: dup
    //   1628: invokespecial 232	java/lang/StringBuilder:<init>	()V
    //   1631: aload 20
    //   1633: iconst_0
    //   1634: bipush 20
    //   1636: invokestatic 2763	mqu:a	(Ljava/lang/String;II)Ljava/lang/String;
    //   1639: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1642: ldc_w 2765
    //   1645: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1648: invokevirtual 250	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1651: astore 19
    //   1653: iload 5
    //   1655: iconst_2
    //   1656: if_icmpne +269 -> 1925
    //   1659: aload_0
    //   1660: ldc_w 2766
    //   1663: invokevirtual 2767	com/tencent/av/ui/AVActivity:getString	(I)Ljava/lang/String;
    //   1666: iconst_1
    //   1667: anewarray 1294	java/lang/Object
    //   1670: dup
    //   1671: iconst_0
    //   1672: aload 19
    //   1674: aastore
    //   1675: invokestatic 2771	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1678: astore 19
    //   1680: aload_0
    //   1681: getfield 514	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoControlUI	Lcom/tencent/av/ui/VideoControlUI;
    //   1684: ifnull +225 -> 1909
    //   1687: aload_0
    //   1688: getfield 514	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoControlUI	Lcom/tencent/av/ui/VideoControlUI;
    //   1691: instanceof 2773
    //   1694: ifeq +215 -> 1909
    //   1697: aload_0
    //   1698: getfield 514	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoControlUI	Lcom/tencent/av/ui/VideoControlUI;
    //   1701: sipush 1036
    //   1704: aload 19
    //   1706: invokevirtual 2776	com/tencent/av/ui/VideoControlUI:a	(ILjava/lang/String;)V
    //   1709: aload_0
    //   1710: getfield 594	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   1713: ifnull +183 -> 1896
    //   1716: aload_0
    //   1717: invokespecial 373	com/tencent/av/ui/AVActivity:k	()V
    //   1720: aload 24
    //   1722: getfield 2757	lnn:jdField_b_of_type_Boolean	Z
    //   1725: ifne +381 -> 2106
    //   1728: aload 24
    //   1730: getfield 2752	lnn:jdField_a_of_type_Boolean	Z
    //   1733: ifne +373 -> 2106
    //   1736: iload 4
    //   1738: iconst_4
    //   1739: if_icmpeq +337 -> 2076
    //   1742: aload 21
    //   1744: getfield 2778	ley:F	I
    //   1747: iconst_2
    //   1748: if_icmpne +246 -> 1994
    //   1751: aconst_null
    //   1752: ldc_w 1172
    //   1755: ldc_w 412
    //   1758: ldc_w 412
    //   1761: ldc_w 2780
    //   1764: ldc_w 2780
    //   1767: iconst_0
    //   1768: iconst_0
    //   1769: ldc_w 412
    //   1772: ldc_w 412
    //   1775: ldc_w 412
    //   1778: ldc_w 412
    //   1781: invokestatic 1180	bcst:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1784: aload_0
    //   1785: getfield 594	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   1788: lload 9
    //   1790: aload 25
    //   1792: iload 5
    //   1794: aload_0
    //   1795: getfield 145	com/tencent/av/ui/AVActivity:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   1798: aload 24
    //   1800: getfield 2757	lnn:jdField_b_of_type_Boolean	Z
    //   1803: aload 24
    //   1805: getfield 2752	lnn:jdField_a_of_type_Boolean	Z
    //   1808: invokevirtual 2783	com/tencent/av/ui/VideoLayerUI:a	(JLjava/lang/String;ILandroid/graphics/Bitmap;ZZ)V
    //   1811: iload 15
    //   1813: ifne +83 -> 1896
    //   1816: aload 21
    //   1818: getfield 1493	ley:J	Z
    //   1821: ifne +75 -> 1896
    //   1824: ldc_w 2784
    //   1827: fstore_2
    //   1828: fload_2
    //   1829: fstore_1
    //   1830: aload_0
    //   1831: getfield 594	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   1834: aload 25
    //   1836: iload 5
    //   1838: invokevirtual 2786	com/tencent/av/ui/VideoLayerUI:b	(Ljava/lang/String;I)Z
    //   1841: ifeq +20 -> 1861
    //   1844: fload_2
    //   1845: fstore_1
    //   1846: aload_0
    //   1847: getfield 594	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   1850: invokevirtual 858	com/tencent/av/ui/VideoLayerUI:f	()I
    //   1853: iconst_3
    //   1854: if_icmpeq +7 -> 1861
    //   1857: ldc_w 2787
    //   1860: fstore_1
    //   1861: aload_0
    //   1862: invokevirtual 575	com/tencent/av/ui/AVActivity:getApplicationContext	()Landroid/content/Context;
    //   1865: fload_1
    //   1866: invokestatic 2790	mue:a	(Landroid/content/Context;F)F
    //   1869: fstore_1
    //   1870: aload_0
    //   1871: getfield 594	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   1874: aload 25
    //   1876: iload 5
    //   1878: aload 20
    //   1880: fload_1
    //   1881: iconst_m1
    //   1882: invokevirtual 2793	com/tencent/av/ui/VideoLayerUI:a	(Ljava/lang/String;ILjava/lang/String;FI)V
    //   1885: aload_0
    //   1886: getfield 594	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   1889: aload 25
    //   1891: iload 5
    //   1893: invokevirtual 2794	com/tencent/av/ui/VideoLayerUI:a	(Ljava/lang/String;I)V
    //   1896: iload_3
    //   1897: iconst_1
    //   1898: iadd
    //   1899: istore_3
    //   1900: goto -416 -> 1484
    //   1903: iconst_0
    //   1904: istore 15
    //   1906: goto -358 -> 1548
    //   1909: aload_0
    //   1910: getfield 139	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvAppVideoAppInterface	Lcom/tencent/av/app/VideoAppInterface;
    //   1913: sipush 1036
    //   1916: aload 19
    //   1918: invokestatic 2797	maf:a	(Lcom/tencent/av/app/VideoAppInterface;ILjava/lang/String;)Z
    //   1921: pop
    //   1922: goto -213 -> 1709
    //   1925: aload_0
    //   1926: ldc_w 2798
    //   1929: invokevirtual 2767	com/tencent/av/ui/AVActivity:getString	(I)Ljava/lang/String;
    //   1932: iconst_1
    //   1933: anewarray 1294	java/lang/Object
    //   1936: dup
    //   1937: iconst_0
    //   1938: aload 19
    //   1940: aastore
    //   1941: invokestatic 2771	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1944: astore 19
    //   1946: aload_0
    //   1947: getfield 514	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoControlUI	Lcom/tencent/av/ui/VideoControlUI;
    //   1950: ifnull +28 -> 1978
    //   1953: aload_0
    //   1954: getfield 514	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoControlUI	Lcom/tencent/av/ui/VideoControlUI;
    //   1957: instanceof 2773
    //   1960: ifeq +18 -> 1978
    //   1963: aload_0
    //   1964: getfield 514	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoControlUI	Lcom/tencent/av/ui/VideoControlUI;
    //   1967: sipush 1037
    //   1970: aload 19
    //   1972: invokevirtual 2776	com/tencent/av/ui/VideoControlUI:a	(ILjava/lang/String;)V
    //   1975: goto -266 -> 1709
    //   1978: aload_0
    //   1979: getfield 139	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvAppVideoAppInterface	Lcom/tencent/av/app/VideoAppInterface;
    //   1982: sipush 1037
    //   1985: aload 19
    //   1987: invokestatic 2797	maf:a	(Lcom/tencent/av/app/VideoAppInterface;ILjava/lang/String;)Z
    //   1990: pop
    //   1991: goto -282 -> 1709
    //   1994: aload 21
    //   1996: getfield 1274	ley:D	I
    //   1999: bipush 10
    //   2001: if_icmpne +39 -> 2040
    //   2004: aconst_null
    //   2005: ldc_w 1172
    //   2008: ldc_w 412
    //   2011: ldc_w 412
    //   2014: ldc_w 2800
    //   2017: ldc_w 2800
    //   2020: iconst_0
    //   2021: iconst_0
    //   2022: ldc_w 412
    //   2025: ldc_w 412
    //   2028: ldc_w 412
    //   2031: ldc_w 412
    //   2034: invokestatic 1180	bcst:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2037: goto -253 -> 1784
    //   2040: aconst_null
    //   2041: ldc_w 1172
    //   2044: ldc_w 412
    //   2047: ldc_w 412
    //   2050: ldc_w 2802
    //   2053: ldc_w 2802
    //   2056: iconst_0
    //   2057: iconst_0
    //   2058: ldc_w 412
    //   2061: ldc_w 412
    //   2064: ldc_w 412
    //   2067: ldc_w 412
    //   2070: invokestatic 1180	bcst:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2073: goto -289 -> 1784
    //   2076: aload_0
    //   2077: getfield 594	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   2080: lload 9
    //   2082: aload 25
    //   2084: iload 5
    //   2086: aload_0
    //   2087: getfield 147	com/tencent/av/ui/AVActivity:jdField_b_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   2090: aload 24
    //   2092: getfield 2757	lnn:jdField_b_of_type_Boolean	Z
    //   2095: aload 24
    //   2097: getfield 2752	lnn:jdField_a_of_type_Boolean	Z
    //   2100: invokevirtual 2783	com/tencent/av/ui/VideoLayerUI:a	(JLjava/lang/String;ILandroid/graphics/Bitmap;ZZ)V
    //   2103: goto -292 -> 1811
    //   2106: aload_0
    //   2107: getfield 594	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   2110: lload 9
    //   2112: aload 25
    //   2114: iload 5
    //   2116: aload_0
    //   2117: getfield 147	com/tencent/av/ui/AVActivity:jdField_b_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   2120: aload 24
    //   2122: getfield 2757	lnn:jdField_b_of_type_Boolean	Z
    //   2125: aload 24
    //   2127: getfield 2752	lnn:jdField_a_of_type_Boolean	Z
    //   2130: invokevirtual 2783	com/tencent/av/ui/VideoLayerUI:a	(JLjava/lang/String;ILandroid/graphics/Bitmap;ZZ)V
    //   2133: goto -322 -> 1811
    //   2136: aload_0
    //   2137: getfield 139	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvAppVideoAppInterface	Lcom/tencent/av/app/VideoAppInterface;
    //   2140: sipush 1023
    //   2143: ldc_w 2803
    //   2146: invokestatic 557	maf:a	(Lcom/tencent/av/app/VideoAppInterface;II)Z
    //   2149: pop
    //   2150: ldc_w 2805
    //   2153: invokestatic 892	mno:a	(Ljava/lang/String;)V
    //   2156: goto -1296 -> 860
    //   2159: invokestatic 1249	lsv:a	()Llsv;
    //   2162: iconst_1
    //   2163: invokevirtual 2694	lsv:b	(I)V
    //   2166: goto -1221 -> 945
    //   2169: ldc2_w 2339
    //   2172: lstore 7
    //   2174: goto -1199 -> 975
    //   2177: astore 19
    //   2179: goto -1273 -> 906
    //   2182: aload 20
    //   2184: astore 19
    //   2186: goto -533 -> 1653
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2189	0	this	AVActivity
    //   1829	52	1	f1	float
    //   1827	18	2	f2	float
    //   1483	417	3	i1	int
    //   1480	260	4	i2	int
    //   1519	596	5	i3	int
    //   1555	7	6	i4	int
    //   973	1200	7	l1	long
    //   8	2103	9	l2	long
    //   948	34	11	l3	long
    //   956	28	13	l4	long
    //   394	1511	15	bool1	boolean
    //   407	1195	16	bool2	boolean
    //   414	70	17	bool3	boolean
    //   421	926	18	bool4	boolean
    //   304	785	19	localObject1	Object
    //   1243	135	19	localIllegalArgumentException	java.lang.IllegalArgumentException
    //   1651	335	19	str1	String
    //   2177	1	19	localException	Exception
    //   2184	1	19	localObject2	Object
    //   431	1752	20	str2	String
    //   85	1910	21	localley	ley
    //   165	811	22	locallhw	lhw
    //   1458	36	23	localArrayList	ArrayList
    //   1502	624	24	locallnn	lnn
    //   1512	601	25	str3	String
    // Exception table:
    //   from	to	target	type
    //   70	79	1243	java/lang/IllegalArgumentException
    //   899	906	2177	java/lang/Exception
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    this.jdField_k_of_type_Boolean = true;
  }
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (paramSensorEvent != null)) {
      this.jdField_a_of_type_ComTencentAvVideoController.jdField_a_of_type_Lca.a(paramSensorEvent.values);
    }
  }
  
  public void onStart()
  {
    ley localley = lbu.a().a();
    lhu.a(20, 1L);
    if ((localley != null) && (localley.l())) {
      lhu.a(31);
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
    if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_B_of_type_Boolean) && (this.jdField_a_of_type_Mih != null))
    {
      this.jdField_a_of_type_Mih.c();
      if (this.jdField_a_of_type_Mih.b() < 1000L) {
        break label278;
      }
    }
    label278:
    for (int i1 = 1;; i1 = 2)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a().v = i1;
      bcst.b(null, "CliOper", "", "", "0X800863D", "0X800863D", 0, 0, "", "", "", "");
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
    if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (this.jdField_a_of_type_ComTencentAvVideoController.a().D == 2)) {
      return;
    }
    b(4);
    long l1 = AudioHelper.b();
    if (AudioHelper.f()) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.ui.AVActivity
 * JD-Core Version:    0.7.0.1
 */