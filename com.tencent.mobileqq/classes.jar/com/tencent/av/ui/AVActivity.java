package com.tencent.av.ui;

import abvb;
import aepi;
import android.annotation.TargetApi;
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
import aofm;
import arso;
import azqs;
import bdhe;
import bdne;
import becr;
import becx;
import bexu;
import bhuf;
import bnle;
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
import lek;
import lfb;
import lfh;
import lhe;
import lid;
import lie;
import lij;
import lju;
import lko;
import lkx;
import lkz;
import llw;
import lme;
import lmr;
import lmz;
import loc;
import lqq;
import lsa;
import lvt;
import lvu;
import lyc;
import lyg;
import mbl;
import mbt;
import mdd;
import mdk;
import mdl;
import mdn;
import mdo;
import mdp;
import mdq;
import mdr;
import mds;
import mdt;
import mdu;
import mdw;
import mdz;
import mea;
import men;
import mes;
import meu;
import mey;
import mez;
import mgu;
import mjs;
import mlf;
import mls;
import mof;
import mpe;
import mpj;
import mqj;
import mqq.app.BaseActivity;
import mqq.app.MobileQQ;
import mrt;
import msp;
import mto;
import mtq;
import mvh;
import mvi;
import mvj;
import mww;

public class AVActivity
  extends BaseActivity
  implements SensorEventListener, llw, lvu
{
  public int a;
  long jdField_a_of_type_Long = 0L;
  Dialog jdField_a_of_type_AndroidAppDialog = null;
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = null;
  public Bitmap a;
  private Sensor jdField_a_of_type_AndroidHardwareSensor;
  private SensorManager jdField_a_of_type_AndroidHardwareSensorManager;
  Handler jdField_a_of_type_AndroidOsHandler = new mdq(this);
  private MessageQueue.IdleHandler jdField_a_of_type_AndroidOsMessageQueue$IdleHandler = new mdk(this);
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = null;
  public RelativeLayout a;
  public becx a;
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
  lhe jdField_a_of_type_Lhe = new mdt(this);
  lij jdField_a_of_type_Lij = new mdz(this);
  lme jdField_a_of_type_Lme = new mds(this);
  private lmz jdField_a_of_type_Lmz = new lmz();
  private mbl jdField_a_of_type_Mbl;
  mea jdField_a_of_type_Mea = null;
  public men a;
  private mes jdField_a_of_type_Mes;
  public meu a;
  public mjs a;
  public mlf a;
  public mls a;
  public mof a;
  public mpe a;
  private mvi jdField_a_of_type_Mvi;
  mvj jdField_a_of_type_Mvj = null;
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
    this.jdField_a_of_type_Mof = null;
    this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    this.jdField_b_of_type_AndroidGraphicsBitmap = null;
    this.jdField_h_of_type_Int = 0;
    this.jdField_a_of_type_Meu = new mdw(this);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(this);
    this.jdField_a_of_type_ComTencentAvUiGuideGuideHelper = new GuideHelper();
    this.jdField_a_of_type_Becx = new mdl(this);
    this.jdField_k_of_type_Boolean = false;
    this.jdField_m_of_type_Boolean = false;
    this.mIsShadow = false;
    this.jdField_b_of_type_JavaLangString = ("AVActivity_" + AudioHelper.b());
  }
  
  private String a(Intent paramIntent)
  {
    int i2 = paramIntent.getIntExtra("uinType", -1);
    int i3 = mww.b(i2);
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
      return lfb.a(i3, str2, new int[0]);
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
    bnle.a(paramActivity);
    if (bnle.b())
    {
      int i1 = bnle.b(paramActivity);
      int i2 = ImmersiveUtils.getStatusBarHeight(paramActivity);
      QLog.w(ImmersiveUtils.jdField_a_of_type_JavaLangString, 1, "initLiuHaiProperty, onAttachedToWindow, notchheight[" + i1 + "], statusBarHeight[" + i2 + "]");
      if (bnle.c(paramActivity))
      {
        if (QLog.isDevelopLevel()) {
          QLog.w(ImmersiveUtils.jdField_a_of_type_JavaLangString, 1, "initLiuHaiProperty, onAttachedToWindow, enableNotch");
        }
        return true;
      }
      if (("" + Build.MANUFACTURER).equalsIgnoreCase("Lenovo")) {
        VideoControlUI.o = true;
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
        lid locallid;
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
              locallid = this.jdField_a_of_type_ComTencentAvVideoController.a();
              i1 = locallid.jdField_d_of_type_Int;
              if (QLog.isDevelopLevel()) {
                QLog.w(this.jdField_b_of_type_JavaLangString, 1, "SwitchToolbar, sessionType[" + i1 + "], isInviting[" + locallid.g() + "], isToolBarDisplay[" + this.jdField_a_of_type_ComTencentAvUiVideoControlUI.h() + "|" + this.jdField_a_of_type_ComTencentAvUiVideoControlUI.jdField_i_of_type_Boolean + "], seq[" + paramLong + "]");
              }
              if ((i1 != 1) && (i1 != 3)) {
                break;
              }
            } while ((!this.jdField_a_of_type_ComTencentAvUiVideoControlUI.a.b(1)) && (!this.jdField_a_of_type_ComTencentAvUiVideoControlUI.a.b(3)));
            this.jdField_a_of_type_ComTencentAvUiVideoControlUI.a.a(paramLong, 0, true);
            return;
            if (!locallid.g()) {
              break;
            }
          } while ((i1 != 2) || ((!this.jdField_a_of_type_ComTencentAvUiVideoControlUI.a.b(1)) && (!this.jdField_a_of_type_ComTencentAvUiVideoControlUI.a.b(3))));
          this.jdField_a_of_type_ComTencentAvUiVideoControlUI.a.a(paramLong, 0, true);
          return;
        } while ((this.jdField_a_of_type_Men != null) && (this.jdField_a_of_type_Men.a()));
        if ((!locallid.B) || (this.jdField_a_of_type_ComTencentAvUiVideoControlUI.h())) {
          break;
        }
      } while (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null);
      mdd.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1022, 2131696218);
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
  
  private void k()
  {
    if (this.jdField_b_of_type_AndroidGraphicsBitmap == null) {
      this.jdField_b_of_type_AndroidGraphicsBitmap = mww.a(getApplicationContext(), 2130841612);
    }
  }
  
  private void l()
  {
    View localView = findViewById(2131372899);
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
      View localView = super.findViewById(2131362964);
      this.jdField_a_of_type_ComTencentAvUiVideoLayerUI = new VideoLayerUI(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this, localView);
      this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(a());
      this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(new mdr(this));
    } while (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI == null);
    this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(this.jdField_a_of_type_Mlf);
  }
  
  public void BtnOnClick(View paramView)
  {
    long l1 = AudioHelper.b();
    QLog.d(this.jdField_b_of_type_JavaLangString, 1, "BtnOnClick, id[" + mgu.a(paramView.getId()) + "], nfonWindowFocus[" + this.jdField_j_of_type_Boolean + "], seq[" + l1 + "]");
    if (!this.jdField_j_of_type_Boolean) {}
    for (;;)
    {
      return;
      if ((this.jdField_a_of_type_Men != null) && (this.jdField_a_of_type_Men.a())) {
        this.jdField_a_of_type_Men.a(paramView);
      }
      while ((paramView.getId() == 2131372899) && (this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch != null))
      {
        lyc.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch, 1);
        this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = null;
        return;
        if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI != null)
        {
          this.jdField_a_of_type_ComTencentAvUiVideoControlUI.C(l1);
          mtq.c(paramView.getId());
          this.jdField_a_of_type_ComTencentAvUiVideoControlUI.a(l1, paramView);
          e(l1);
        }
      }
    }
  }
  
  public void TestMenuBtnOnClick(View paramView)
  {
    paramView = new PopupMenu(this, paramView);
    msp.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface).a(paramView);
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
    SharedPreferences localSharedPreferences = bdne.a(getApplicationContext());
    String str = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
    return localSharedPreferences.getInt("showRecordTip" + String.valueOf(str), 0);
  }
  
  View a(long paramLong)
  {
    if ((this.jdField_a_of_type_Mvi == null) || (!this.n))
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
    Object localObject = findViewById(2131372899);
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
    ImageView localImageView = (ImageView)findViewById(2131372770);
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
    QLog.i(this.jdField_b_of_type_JavaLangString, 1, "MoreBtnTips. showTips. mMoreBtnTipsImageDownloaded = " + this.n + ", mMoreBtnTips = " + this.jdField_a_of_type_Mvi);
    localImageView.setImageDrawable(this.jdField_a_of_type_ComTencentImageURLDrawable);
    int i1 = aepi.a(10.0F, getResources());
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
  
  public mbl a()
  {
    return this.jdField_a_of_type_Mbl;
  }
  
  @TargetApi(21)
  @Nullable
  public mls a()
  {
    if (Build.VERSION.SDK_INT < 21) {
      return null;
    }
    this.jdField_a_of_type_Mls = this.jdField_a_of_type_ComTencentAvVideoController.a();
    this.jdField_a_of_type_Mls.a(this);
    return this.jdField_a_of_type_Mls;
  }
  
  void a()
  {
    if (this.jdField_a_of_type_Mea == null) {
      this.jdField_a_of_type_Mea = new mea(this, super.getApplicationContext(), 2);
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
    if (((this.jdField_a_of_type_ComTencentAvUiVideoControlUI instanceof DoubleVideoCtrlUI)) && ((paramInt == 2) || (paramInt == 1)))
    {
      this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.f(l1);
      ((DoubleVideoCtrlUI)this.jdField_a_of_type_ComTencentAvUiVideoControlUI).a(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.i(), c());
    }
    this.jdField_a_of_type_ComTencentAvUiVideoControlUI.C(l1);
    this.jdField_a_of_type_ComTencentAvUiVideoControlUI.f(l1, 65535);
    if (this.jdField_a_of_type_Mlf != null)
    {
      this.jdField_a_of_type_Mlf.a(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.i(), this.jdField_a_of_type_ComTencentAvUiVideoControlUI, this.jdField_a_of_type_Mlf.c());
      this.jdField_a_of_type_Mlf.a(this.jdField_a_of_type_Mlf.c());
      this.jdField_a_of_type_Mlf.b(this.jdField_a_of_type_Mlf.c());
    }
    if ((this.jdField_a_of_type_ComTencentAvVideoController.a().B) && (!this.jdField_a_of_type_ComTencentAvVideoController.a().I)) {
      mqj.a("0X8008ABA");
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
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().q()) {}
      while (this.jdField_a_of_type_Mpe != null)
      {
        this.jdField_a_of_type_Mpe.a();
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
      localObject = findViewById(2131372895);
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
      if (this.jdField_a_of_type_Mpe != null)
      {
        i4 = this.jdField_a_of_type_Mpe.a();
        QLog.w("ChatRoomUtil", 1, "calcControlUIOffset, topOffset[" + i7 + "], topToolbarHeight[" + i5 + "], topToolbarTop[" + i1 + "], bottomToolbarHeight[" + i6 + "], chatRoomInputPanelHeight[" + i4 + "], recordBarHeight[" + i2 + "], systemBarHeight[" + i3 + "], from[" + paramInt + "], seq[" + paramLong + "]");
        if (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null)
        {
          if ((c() != 1) || (i4 <= i6)) {
            break label447;
          }
          localObject = this.jdField_a_of_type_ComTencentAvUiVideoLayerUI;
          if (!this.jdField_a_of_type_ComTencentAvUiVideoControlUI.jdField_i_of_type_Boolean)
          {
            bool = true;
            label282:
            ((VideoLayerUI)localObject).a(paramLong, i7, i4, bool);
          }
        }
        else
        {
          this.jdField_a_of_type_ComTencentAvUiVideoControlUI.O();
          if ((this.jdField_a_of_type_Mpe == null) || (paramInt == 1)) {
            break;
          }
          this.jdField_a_of_type_Mpe.b(i6);
          return;
          if ((i5 != 0) || (!bnle.b())) {
            break label510;
          }
        }
      }
      label447:
      label510:
      for (i1 = bnle.b(this);; i1 = 0)
      {
        localObject = this.jdField_a_of_type_ComTencentAvVideoController.a();
        if ((((lid)localObject).w()) && ((((lid)localObject).B) || (((lid)localObject).jdField_C_of_type_Boolean)) && (this.jdField_a_of_type_Mlf != null) && (!this.jdField_a_of_type_Mlf.d()))
        {
          i2 = this.jdField_a_of_type_Mlf.c();
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
          if (!this.jdField_a_of_type_ComTencentAvUiVideoControlUI.jdField_i_of_type_Boolean) {}
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
    if ((paramInt1 == 2131372899) && (paramInt3 == 0))
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
      if (this.jdField_a_of_type_Mlf != null)
      {
        this.jdField_a_of_type_Mlf.d(paramInt);
        this.jdField_a_of_type_Mlf.d();
        this.jdField_a_of_type_Mlf.a(this.jdField_a_of_type_ComTencentAvUiVideoControlUI, this.jdField_h_of_type_Int);
      }
    } while ((!this.jdField_a_of_type_ComTencentAvVideoController.a().B) && (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_C_of_type_Boolean));
    g(paramLong);
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    QLog.i(this.jdField_b_of_type_JavaLangString, 1, "MoreBtnTips. tryShow_qav_more_tips. mMoreBtnTipsImageDownloaded = " + this.n + ", mMoreBtnTips = " + this.jdField_a_of_type_Mvi + ", delayMillis = " + paramLong2);
    if (this.jdField_a_of_type_Mvi != null)
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
    Intent localIntent = aepi.a(new Intent(super.getApplicationContext(), SplashActivity.class), null);
    localIntent.putExtra("uin", paramString1);
    localIntent.putExtra("uintype", paramInt);
    localIntent.putExtra("uinname", paramString2);
    startActivity(localIntent);
    QLog.w(this.jdField_b_of_type_JavaLangString, 1, "enterChatWin, uin[" + paramString1 + "], type[" + paramInt + "], seq[" + paramLong + "]");
    this.jdField_e_of_type_Boolean = false;
    finish();
    paramInt = 2130772136;
    paramString1 = this.jdField_a_of_type_ComTencentAvVideoController.a();
    if (paramString1 != null) {
      paramInt = mbt.a(paramString1.K);
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
      if ((paramBoolean) && (this.jdField_a_of_type_ComTencentAvVideoController != null) && (this.jdField_a_of_type_ComTencentAvVideoController.a().G))
      {
        this.jdField_a_of_type_ComTencentAvVideoController.a().G = false;
        paramBoolean = this.jdField_a_of_type_Mlf.i();
        boolean bool = mlf.f();
        if ((!paramBoolean) || (!bool)) {
          break;
        }
        mqj.a("0X8008AB2");
      }
      return;
    }
    mqj.a("0X8008AB1");
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentAvVideoController.a();
    QLog.w(this.jdField_b_of_type_JavaLangString, 1, "avideo onCreateUI, SessionType[" + ((lid)localObject1).jdField_d_of_type_Int + "], seq[" + paramLong + "]");
    msp.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this);
    Object localObject2 = this.jdField_a_of_type_ComTencentAvVideoController.a(getApplicationContext());
    if (localObject2 != null) {
      ((lsa)localObject2).a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    }
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131372618));
    }
    this.jdField_a_of_type_JavaLangRunnable = new AVActivity.5(this);
    if (this.jdField_a_of_type_ComTencentAvCameraCameraUtils == null)
    {
      this.jdField_a_of_type_ComTencentAvCameraCameraUtils = CameraUtils.a(this);
      this.jdField_a_of_type_ComTencentAvCameraCameraUtils.a(this.jdField_a_of_type_Lme);
      this.jdField_a_of_type_ComTencentAvCameraCameraUtils.a(this.jdField_a_of_type_ComTencentAvVideoController);
    }
    localObject2 = super.findViewById(2131362964).findViewById(2131362961);
    try
    {
      ((View)localObject2).setBackgroundResource(2130841768);
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
        this.jdField_a_of_type_Mvi = mvh.a(i1);
        if ((this.jdField_a_of_type_Mvi != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_Mvi.jdField_a_of_type_JavaLangString)))
        {
          localObject2 = URLDrawable.URLDrawableOptions.obtain();
          this.jdField_a_of_type_ComTencentImageURLDrawable = URLDrawable.getDrawable(this.jdField_a_of_type_Mvi.jdField_a_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject2);
          this.n = false;
          this.jdField_a_of_type_ComTencentImageURLDrawable.setURLDrawableListener(new mdu(this));
          this.jdField_a_of_type_ComTencentImageURLDrawable.startDownload();
          if (1 == this.jdField_a_of_type_ComTencentImageURLDrawable.getStatus())
          {
            paramBoolean = true;
            this.n = paramBoolean;
            azqs.b(null, "CliOper", "", "", "0X800A75E", "0X800A75E", i1, this.jdField_a_of_type_Mvi.jdField_a_of_type_Int, "", "", "", "");
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
              ((DoubleVideoCtrlUI)localObject2).a(2131372600, this.jdField_a_of_type_ComTencentAvVideoController.o, 2130841670);
              if (!this.jdField_a_of_type_ComTencentAvVideoController.q) {
                ((DoubleVideoCtrlUI)localObject2).a.a(true, 0, false);
              }
            }
          }
          if ((((lid)localObject1).jdField_g_of_type_Int != 4) && (((lid)localObject1).w()) && (!this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_Int == 1) && (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) && (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getParent() != null))
          {
            i1 = mpj.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, ((lid)localObject1).jdField_d_of_type_JavaLangString, true, true);
            if ((i1 > 0) && (this.jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView == null)) {
              this.jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView = becr.a(this, (RelativeLayout)this.jdField_a_of_type_AndroidWidgetRelativeLayout.getParent(), false);
            }
            i2 = becr.a();
            localObject1 = becr.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, i1, i2, null);
            if (localObject1 != null)
            {
              localObject2 = new File((String)localObject1);
              if ((localObject2 == null) || (!((File)localObject2).exists())) {
                break label1332;
              }
              if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
                this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new AVActivity.7(this, (String)localObject1, i2, i1), 1000L);
              }
            }
          }
          this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView = ((QavRecordButtonView)findViewById(2131375509));
          a(paramLong, "onCreateUI", false);
          if (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) {
            this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.k(0);
          }
          localObject1 = (RelativeLayout)findViewById(2131379811);
          if ((localObject1 != null) && (mlf.f()))
          {
            this.jdField_a_of_type_Mlf = new mlf(this, (RelativeLayout)localObject1, this.jdField_a_of_type_ComTencentAvVideoController, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_ComTencentAvUiVideoControlUI);
            this.jdField_a_of_type_Mlf.c(1);
            if (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) {
              this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(this.jdField_a_of_type_Mlf);
            }
          }
          l();
          lvt.a().a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this);
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
            break label1035;
          }
          this.jdField_a_of_type_ComTencentAvUiVideoControlUI = new DoubleVideoMeetingCtrlUI(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_Meu);
          this.jdField_b_of_type_Int = ((lid)localObject1).jdField_d_of_type_Int;
        }
        for (;;)
        {
          this.jdField_a_of_type_ComTencentAvUiVideoControlUI.m(this.jdField_a_of_type_ComTencentAvCameraCameraUtils.a());
          break;
          label1035:
          this.jdField_a_of_type_ComTencentAvUiVideoControlUI = new DoubleVideoCtrlUI(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_Meu);
        }
        if (this.jdField_g_of_type_Boolean)
        {
          this.jdField_a_of_type_ComTencentAvUiVideoControlUI = new DoubleVideoMeetingCtrlUI(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_Meu);
          this.jdField_b_of_type_Int = ((lid)localObject1).jdField_d_of_type_Int;
        }
        else
        {
          this.jdField_a_of_type_ComTencentAvUiVideoControlUI = new DoubleVideoCtrlUI(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_Meu);
          this.jdField_a_of_type_ComTencentAvUiVideoControlUI.m(this.jdField_a_of_type_ComTencentAvCameraCameraUtils.a());
          continue;
          if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI == null)
          {
            if (!this.jdField_g_of_type_Boolean) {
              break label1210;
            }
            this.jdField_a_of_type_ComTencentAvUiVideoControlUI = new DoubleVideoMeetingCtrlUI(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_Meu);
            this.jdField_b_of_type_Int = ((lid)localObject1).jdField_d_of_type_Int;
          }
          for (;;)
          {
            this.jdField_a_of_type_ComTencentAvUiVideoControlUI.m(this.jdField_a_of_type_ComTencentAvCameraCameraUtils.a());
            break;
            label1210:
            if (((lid)localObject1).jdField_C_of_type_Int == 1)
            {
              this.jdField_a_of_type_ComTencentAvUiVideoControlUI = new MultiVideoCtrlLayerUI4Discussion(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_Meu);
            }
            else if (((lid)localObject1).jdField_C_of_type_Int == 10)
            {
              this.jdField_a_of_type_ComTencentAvUiVideoControlUI = new MultiVideoCtrlLayerUI4NewGroupChat(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_Meu);
            }
            else
            {
              if (QLog.isColorLevel()) {
                QLog.d(this.jdField_b_of_type_JavaLangString, 2, "OnCreateUI --> Not Set MultiAVType");
              }
              this.jdField_a_of_type_ComTencentAvUiVideoControlUI = new MultiVideoCtrlLayerUI4Discussion(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_Meu);
            }
          }
          paramBoolean = false;
          continue;
          label1332:
          QLog.e(this.jdField_b_of_type_JavaLangString, 1, "funcall --> !file.exists() + path:" + (String)localObject1);
        }
      }
    }
  }
  
  public void a(Integer paramInteger, Object paramObject1, Object paramObject2)
  {
    lek.c(this.jdField_b_of_type_JavaLangString, "notifyEvent :" + paramInteger + "|" + paramObject1 + "|" + paramObject2);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { paramInteger, paramObject1, paramObject2 });
  }
  
  public void a(String paramString)
  {
    lju locallju = (lju)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(3);
    FaceItem localFaceItem = locallju.a(paramString);
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
        new mez(l1, localFaceItem.getId(), true, 2).a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
        VoiceRecogTips.b(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramString);
        azqs.b(null, "CliOper", "", "", "0X800984F", "0X800984F", 0, 0, "", "", "", localFaceItem.getId());
        return;
      }
      locallju.a(l1, localFaceItem);
      return;
    }
    QLog.i(this.jdField_b_of_type_JavaLangString, 1, "onAVVoiceRecogComplete. recogResult = " + paramString + ", paly voice sticker falied. voiceStickerItem == null.");
  }
  
  void a(String paramString, long paramLong)
  {
    View localView = findViewById(2131372770);
    if (localView == null) {}
    do
    {
      do
      {
        return;
      } while (localView.getVisibility() != 0);
      localView.setVisibility(4);
      QLog.w(this.jdField_b_of_type_JavaLangString, 1, "MoreBtnTips. hide_qav_more_tips. from[" + paramString + "], seq[" + paramLong + "]");
    } while (this.jdField_a_of_type_Mvi == null);
    mvh.a(this.jdField_a_of_type_Mvi.jdField_a_of_type_Int);
    this.jdField_a_of_type_Mvi = null;
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
    if (this.jdField_a_of_type_Mea != null) {
      this.jdField_a_of_type_Mea.enable();
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
        if ((this.jdField_a_of_type_Mbl == null) || (this.jdField_a_of_type_Mbl.a()))
        {
          if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 4)
          {
            ArrayList localArrayList = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList;
            int i1 = 0;
            if (i1 < localArrayList.size())
            {
              lqq locallqq = (lqq)localArrayList.get(i1);
              String str = mto.a(locallqq.jdField_a_of_type_Long);
              int i2 = locallqq.jdField_a_of_type_Int;
              if (locallqq.jdField_b_of_type_Long == 5L) {}
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
      if (this.jdField_a_of_type_Men != null) {
        this.jdField_a_of_type_Men.d();
      }
      f();
      this.jdField_a_of_type_ComTencentAvVideoController.a(true);
      this.jdField_a_of_type_ComTencentAvVideoController.i(false);
      if (this.jdField_a_of_type_Mbl != null) {
        this.jdField_a_of_type_Mbl.a(paramLong, this.jdField_e_of_type_Boolean);
      }
    } while (this.jdField_a_of_type_Mpe == null);
    this.jdField_a_of_type_Mpe.a();
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
      if ((!mlf.k()) && (this.jdField_a_of_type_Mlf != null)) {
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
            if ((i1 != 0) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_C_of_type_Boolean))
            {
              this.jdField_a_of_type_Mlf.d(this.jdField_h_of_type_Int);
              this.jdField_a_of_type_Mlf.d();
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
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_C_of_type_Boolean)
      {
        this.jdField_a_of_type_Mlf.d(0);
        this.jdField_a_of_type_Mlf.d();
        this.jdField_a_of_type_Mlf.k();
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
    QLog.w(this.jdField_b_of_type_JavaLangString, 1, "onNeedChangeDoubleScreenMode, id[" + paramString + "], seq[" + l1 + "], hasChangeDoubleScreen[" + this.jdField_a_of_type_ComTencentAvVideoController.a().T + "]");
    getResources();
    if (!this.jdField_a_of_type_ComTencentAvVideoController.a().T)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a().a(true);
      a(2, false);
      mdd.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1043);
      return;
    }
    if (this.jdField_a_of_type_AndroidViewView$OnClickListener == null) {
      this.jdField_a_of_type_AndroidViewView$OnClickListener = new mdp(this, paramString, l1);
    }
    mdd.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1044, null, this.jdField_a_of_type_AndroidViewView$OnClickListener);
  }
  
  public void b(boolean paramBoolean)
  {
    VideoLayerUI.a(findViewById(2131362964), paramBoolean);
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
    if (this.jdField_a_of_type_Mea != null) {
      this.jdField_a_of_type_Mea.disable();
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
    lid locallid = this.jdField_a_of_type_ComTencentAvVideoController.a();
    int i2 = locallid.jdField_d_of_type_Int;
    Object localObject1 = ((Intent)localObject3).getStringExtra("Fromwhere");
    boolean bool = ((Intent)localObject3).getBooleanExtra("isDoubleVideoMeeting", false);
    a("processExtraData", bool);
    if ("AVNotification".equals(localObject1))
    {
      if (((locallid.jdField_g_of_type_Int == 2) || (locallid.jdField_g_of_type_Int == 13)) && (i4 != 1) && (i4 != 2))
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_b_of_type_JavaLangString, 2, "Close Double Video Meeting. --> QAVNotification to MultiVideo");
        }
        if (locallid.J) {
          break label390;
        }
        this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, locallid.jdField_d_of_type_JavaLangString, 1, true);
        this.jdField_a_of_type_ComTencentAvVideoController.a(locallid.jdField_d_of_type_JavaLangString, 230);
        this.jdField_a_of_type_ComTencentAvVideoController.b(230);
      }
      if (locallid.jdField_i_of_type_Int == 1)
      {
        if (locallid.jdField_C_of_type_Int != 10) {
          break label428;
        }
        azqs.b(null, "CliOper", "", "", "0X8005930", "0X8005930", 0, 0, "", "", "", "");
      }
    }
    label390:
    long l1;
    for (;;)
    {
      if (bool) {
        azqs.b(null, "CliOper", "", "", "0X8005209", "0X8005209", 0, 0, "", "", "", "");
      }
      if (i4 != 0) {
        break label464;
      }
      lek.d(this.jdField_b_of_type_JavaLangString, "processExtraData-->can not get session type in intent.");
      ((lkz)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4)).a(locallid.b(), 5, 1015L);
      finish();
      return;
      l1 = Long.valueOf(locallid.jdField_d_of_type_JavaLangString).longValue();
      this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, 3, l1);
      this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, l1, 1);
      break;
      label428:
      azqs.b(null, "CliOper", "", "", "0X80046D7", "0X80046D7", 0, 0, "", "", "", "");
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
      str = locallid.jdField_d_of_type_JavaLangString;
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
        lek.d(this.jdField_b_of_type_JavaLangString, "processExtraData-->can not get uin in intent.");
        ((lkz)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4)).a(locallid.b(), 5, 1016L);
        finish();
        return;
        if ((i4 != 3) && (i4 != 4)) {
          break label489;
        }
        str = ((Intent)localObject3).getStringExtra("GroupId");
        i1 = ((Intent)localObject3).getIntExtra("MeetingConfID", 0);
        i3 = ((Intent)localObject3).getIntExtra("ConfAppID", 0);
        i5 = ((Intent)localObject3).getIntExtra("MeetingStasks", -1);
        locallid.N = i1;
        locallid.O = i3;
        locallid.P = i5;
        break label489;
        label639:
        if ((i4 != 3) && (i4 != 4)) {
          break label2363;
        }
        if (bool)
        {
          str = locallid.jdField_d_of_type_JavaLangString;
          continue;
        }
        str = String.valueOf(this.jdField_a_of_type_ComTencentAvVideoController.jdField_a_of_type_Long);
        continue;
      }
      Object localObject2;
      if ((i2 == 1) || (i2 == 2))
      {
        localObject2 = locallid.jdField_d_of_type_JavaLangString;
        i1 = mww.b(locallid.jdField_i_of_type_Int);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          lek.d(this.jdField_b_of_type_JavaLangString, "can not get the original peeruin");
          ((lkz)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4)).a(locallid.b(), 5, 1016L);
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
          lek.d(this.jdField_b_of_type_JavaLangString, "can not get the original group uin");
          ((lkz)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4)).a(locallid.b(), 5, 1016L);
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
        QLog.w(this.jdField_b_of_type_JavaLangString, 1, "processExtraData, mSessionType[" + this.jdField_b_of_type_Int + "], mUinType[" + this.jdField_d_of_type_Int + "], mPeerUin[" + this.jdField_c_of_type_JavaLangString + "], mPeerName[" + this.jdField_e_of_type_JavaLangString + "], mPhoneNum[" + this.jdField_f_of_type_JavaLangString + "], mSelfNation[" + this.jdField_g_of_type_JavaLangString + "], mSelfMobile[" + this.jdField_h_of_type_JavaLangString + "], mIsReceiver[" + this.jdField_a_of_type_Boolean + "], mIsAudioMode[" + this.jdField_b_of_type_Boolean + "], mExtraUin[" + this.jdField_i_of_type_JavaLangString + "], mIsPeerNetworkWell[" + this.jdField_c_of_type_Boolean + "], mIsFriend[" + this.jdField_d_of_type_Boolean + "], mFromWhere[" + this.jdField_j_of_type_JavaLangString + "], intentUinStr[" + str + "], \nsession[" + locallid + "]");
        bdhe.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ArrayOfByte);
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
            this.jdField_a_of_type_ComTencentAvVideoController.h(true);
          }
          for (;;)
          {
            d(paramLong);
            str = lfb.a(3, this.jdField_c_of_type_JavaLangString, new int[0]);
            if (lfb.a().a(str)) {
              break;
            }
            localObject1 = lfb.a().a(str, false);
            ((lid)localObject1).jdField_e_of_type_Boolean = false;
            ((lid)localObject1).a("processExtraData", 0);
            ((lid)localObject1).af = false;
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
        locallid.at = ((Intent)localObject3).getBooleanExtra("disableInvite", false);
        i2 = i3;
        if (locallid.jdField_C_of_type_Int != 0)
        {
          i2 = i3;
          if (i5 != locallid.jdField_C_of_type_Int)
          {
            i2 = i3;
            if (i5 != 0) {
              i2 = 1;
            }
          }
        }
        locallid.a(i5);
        if (!bool) {
          if (this.jdField_a_of_type_ComTencentAvVideoController.l())
          {
            this.jdField_a_of_type_ComTencentAvVideoController.h(true);
            label1519:
            if (i2 != 0)
            {
              this.jdField_a_of_type_ComTencentAvVideoController.a(i1, this.jdField_a_of_type_ComTencentAvVideoController.jdField_a_of_type_Long, 99);
              locallid.a(i5);
              locallid.a(paramLong, "processExtraData.1", 3);
            }
            locallid.b("processExtraData.1", ((Intent)localObject3).getIntExtra("Type", -1));
            locallid.jdField_g_of_type_Long = l1;
            this.jdField_d_of_type_JavaLangString = str;
            if (str.compareTo((String)localObject1) != 0) {
              break label1798;
            }
            if (i2 == 0) {
              break label1786;
            }
            this.jdField_b_of_type_Int = i4;
            i1 = ((Intent)localObject3).getIntExtra("uinType", -1);
            locallid.jdField_i_of_type_Int = i1;
            this.jdField_d_of_type_Int = i1;
            this.jdField_i_of_type_JavaLangString = locallid.jdField_f_of_type_JavaLangString;
            if (locallid.D == -1) {
              locallid.b("processExtraData.2", 0);
            }
            this.jdField_c_of_type_Boolean = locallid.r;
            if (QLog.isColorLevel()) {
              QLog.d(this.jdField_b_of_type_JavaLangString, 2, "processExtraData multiAVType: " + locallid.jdField_C_of_type_Int);
            }
          }
        }
        for (;;)
        {
          if (i2 != 0) {
            break label1882;
          }
          this.jdField_d_of_type_Int = locallid.jdField_i_of_type_Int;
          this.jdField_i_of_type_JavaLangString = locallid.jdField_f_of_type_JavaLangString;
          this.jdField_c_of_type_Boolean = locallid.r;
          break;
          if ((str.compareTo((String)localObject1) == 0) || (!this.jdField_a_of_type_ComTencentAvVideoController.jdField_e_of_type_Boolean)) {
            break label1519;
          }
          this.jdField_a_of_type_ComTencentAvVideoController.a(i1, this.jdField_a_of_type_ComTencentAvVideoController.jdField_a_of_type_Long, 98);
          locallid.a(i5);
          break label1519;
          label1786:
          this.jdField_b_of_type_Int = locallid.jdField_d_of_type_Int;
          continue;
          locallid.a(paramLong, "processExtraData.2", i4);
          locallid.jdField_i_of_type_Int = ((Intent)localObject3).getIntExtra("uinType", -1);
          if ((locallid.D == 0) || (locallid.D == 1)) {
            locallid.jdField_a_of_type_ArrayOfLong = ((Intent)localObject3).getLongArrayExtra("DiscussUinList");
          }
          this.jdField_b_of_type_Int = i4;
          continue;
          locallid.jdField_d_of_type_JavaLangString = str;
          this.jdField_b_of_type_Int = i4;
          this.jdField_c_of_type_JavaLangString = str;
        }
        label1882:
        break label984;
        if (((i2 != 1) && (i2 != 2)) || ((i4 != 1) && (i4 != 2))) {
          break label984;
        }
        i1 = ((Intent)localObject3).getIntExtra("uinType", -1);
        if ((i1 != -1) && (i1 != locallid.jdField_i_of_type_Int))
        {
          if (QLog.isColorLevel()) {
            QLog.w(this.jdField_b_of_type_JavaLangString, 2, "New Double Video in , newUinType !=-1 && newUinType != oldUinType , close old video.");
          }
          this.jdField_a_of_type_ComTencentAvVideoController.a(false, 203, new int[] { locallid.jdField_C_of_type_Int });
          this.jdField_a_of_type_ComTencentAvVideoController.b(203);
          if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI != null)
          {
            this.jdField_a_of_type_ComTencentAvUiVideoControlUI.d(paramLong);
            this.jdField_a_of_type_ComTencentAvUiVideoControlUI = null;
          }
          localObject1 = locallid.jdField_d_of_type_JavaLangString;
          localObject2 = lfb.a(3, (String)localObject1, new int[0]);
          Object localObject4 = lfb.a().c((String)localObject2);
          if (localObject4 == null)
          {
            lek.d(this.jdField_b_of_type_JavaLangString, "Can not get SessionInfo : SessionId = " + (String)localObject2);
            finish();
            return;
          }
          localObject3 = ((lid)localObject4).jdField_f_of_type_JavaLangString;
          i1 = locallid.jdField_i_of_type_Int;
          localObject4 = ((lid)localObject4).jdField_s_of_type_JavaLangString;
          this.jdField_a_of_type_ComTencentAvVideoController.a((String)localObject1, 231);
          this.jdField_a_of_type_ComTencentAvVideoController.b(231);
          this.jdField_a_of_type_ComTencentAvVideoController.a("AVActivity.processExtraData", (String)localObject2, i1, (String)localObject1, (String)localObject3, 0, (String)localObject4, false, true);
          d(paramLong);
          localObject1 = lfb.a(3, this.jdField_c_of_type_JavaLangString, new int[0]);
          localObject2 = lfb.a().a((String)localObject1, false);
          ((lid)localObject2).jdField_e_of_type_Boolean = true;
          ((lid)localObject2).a("processExtraData", 2);
          ((lid)localObject2).af = false;
          if (((String)localObject1).equals(this.jdField_a_of_type_JavaLangString)) {
            break label984;
          }
          this.jdField_a_of_type_JavaLangString = ((String)localObject1);
          break label984;
        }
        if (QLog.isColorLevel()) {
          QLog.w(this.jdField_b_of_type_JavaLangString, 2, "New Double Video in , newUinType !=-1 && newUinType == oldUinType , resume old video");
        }
        this.jdField_b_of_type_Int = locallid.jdField_d_of_type_Int;
        a("processExtraData", locallid.J);
        this.jdField_d_of_type_Int = locallid.jdField_i_of_type_Int;
        this.jdField_c_of_type_JavaLangString = locallid.jdField_d_of_type_JavaLangString;
        this.jdField_e_of_type_JavaLangString = locallid.jdField_e_of_type_JavaLangString;
        this.jdField_l_of_type_JavaLangString = locallid.jdField_k_of_type_JavaLangString;
        this.jdField_e_of_type_Int = locallid.z;
        this.jdField_m_of_type_JavaLangString = locallid.jdField_p_of_type_JavaLangString;
        this.jdField_f_of_type_Int = locallid.A;
        this.jdField_i_of_type_JavaLangString = locallid.jdField_f_of_type_JavaLangString;
        this.jdField_f_of_type_JavaLangString = locallid.a();
        this.jdField_a_of_type_Boolean = locallid.jdField_e_of_type_Boolean;
        this.jdField_b_of_type_Boolean = locallid.R;
        this.jdField_c_of_type_Boolean = locallid.r;
        this.jdField_d_of_type_Boolean = locallid.jdField_M_of_type_Boolean;
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
    lid locallid = this.jdField_a_of_type_ComTencentAvVideoController.a();
    QLog.w(this.jdField_b_of_type_JavaLangString + "|VideoNodeManager", 1, "processIntentData begin, isProcessCreate[" + this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.jdField_c_of_type_Boolean + "], isMsfRecv[" + this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.jdField_d_of_type_Boolean + "], seq[" + paramLong + "], \nSessionInfo[" + locallid + "]");
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
      lkx.a(26);
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
        locallid.ac = 4;
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
      this.jdField_b_of_type_Long = becr.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_c_of_type_JavaLangString, 3, true, null);
      this.jdField_g_of_type_Int = ((Intent)localObject1).getIntExtra("vipType", 0);
      lek.b("VideoNodeManager", "==> AVActivity processIntentData() mSessionType = " + this.jdField_b_of_type_Int + "  mIsAudioMode = " + this.jdField_b_of_type_Boolean);
      lkx.b(this.jdField_b_of_type_Int);
      if (!this.jdField_b_of_type_Boolean) {
        break label867;
      }
      l1 = 1L;
      label659:
      lkx.a(13, l1);
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
      locallid.b("processIntentData", ((Intent)localObject1).getIntExtra("Type", -1));
      localObject2 = ((Intent)localObject1).getStringExtra("GroupId");
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        break label1005;
      }
      lek.d(this.jdField_b_of_type_JavaLangString, "relationIdStr is null");
      this.jdField_e_of_type_Boolean = true;
      ((lkz)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4)).a(locallid.b(), 5, 1016L);
      finish();
      return;
      lkx.a();
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
      i2 = locallid.jdField_C_of_type_Int;
      i1 = i2;
      if (QLog.isColorLevel())
      {
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, "Not get avtype inside intent default value: " + i2);
        i1 = i2;
      }
    }
    locallid.a(i1);
    if (localObject2 != null)
    {
      locallid.jdField_g_of_type_Long = Long.valueOf((String)localObject2).longValue();
      this.jdField_d_of_type_JavaLangString = ((String)localObject2);
    }
    locallid.jdField_a_of_type_ArrayOfLong = ((Intent)localObject1).getLongArrayExtra("DiscussUinList");
    locallid.at = ((Intent)localObject1).getBooleanExtra("disableInvite", false);
    while (this.jdField_b_of_type_Int == 0)
    {
      lek.d(this.jdField_b_of_type_JavaLangString, "invalid sessionType!!!");
      this.jdField_e_of_type_Boolean = true;
      ((lkz)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4)).a(locallid.b(), 5, 1015L);
      finish();
      return;
      label1179:
      locallid.ah = ((Intent)localObject1).getBooleanExtra("isOtherTerminalOnChating", false);
      if (locallid.ah)
      {
        locallid.jdField_i_of_type_Long = ((Intent)localObject1).getLongExtra("otherTerminalChatingRoomId", 0L);
        locallid.aj = ((Intent)localObject1).getBooleanExtra("startfromVideoEntry", false);
      }
    }
    i1 = ((Intent)localObject1).getIntExtra("remoteStatus", 0);
    if (this.jdField_a_of_type_Boolean)
    {
      if (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))
      {
        lek.d(this.jdField_b_of_type_JavaLangString, "uin is empty");
        this.jdField_e_of_type_Boolean = true;
        ((lkz)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4)).a(locallid.b(), 5, 1016L);
        finish();
        return;
      }
      if (TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) {
        this.jdField_e_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
      }
      if ((this.jdField_d_of_type_Int != 1011) && (locallid.jdField_a_of_type_Lie.jdField_b_of_type_Boolean))
      {
        this.jdField_a_of_type_ComTencentAvVideoController.a(locallid.jdField_d_of_type_JavaLangString, 232);
        this.jdField_a_of_type_ComTencentAvVideoController.b(232);
      }
      locallid.a(paramLong, "processIntentData", this.jdField_b_of_type_Int);
      locallid.jdField_i_of_type_Int = this.jdField_d_of_type_Int;
      locallid.jdField_d_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
      locallid.jdField_e_of_type_JavaLangString = this.jdField_e_of_type_JavaLangString;
      locallid.jdField_f_of_type_JavaLangString = this.jdField_i_of_type_JavaLangString;
      locallid.jdField_g_of_type_JavaLangString = str1;
      locallid.a(this.jdField_f_of_type_JavaLangString);
      if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
        Looper.myQueue().addIdleHandler(this.jdField_a_of_type_AndroidOsMessageQueue$IdleHandler);
      }
      locallid.jdField_e_of_type_Boolean = this.jdField_a_of_type_Boolean;
      locallid.R = this.jdField_b_of_type_Boolean;
      locallid.r = this.jdField_c_of_type_Boolean;
      locallid.jdField_i_of_type_JavaLangString = this.jdField_g_of_type_JavaLangString;
      locallid.jdField_j_of_type_JavaLangString = this.jdField_h_of_type_JavaLangString;
      locallid.jdField_k_of_type_JavaLangString = this.jdField_l_of_type_JavaLangString;
      locallid.jdField_p_of_type_JavaLangString = this.jdField_m_of_type_JavaLangString;
      locallid.z = this.jdField_e_of_type_Int;
      locallid.A = this.jdField_f_of_type_Int;
      locallid.jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_ArrayOfByte;
      locallid.jdField_M_of_type_Boolean = this.jdField_d_of_type_Boolean;
      locallid.jdField_f_of_type_Int = this.jdField_b_of_type_Int;
      locallid.n = this.jdField_f_of_type_Boolean;
      locallid.jdField_b_of_type_Long = this.jdField_b_of_type_Long;
      locallid.o = this.jdField_g_of_type_Int;
      if (i1 != 4) {
        break label2095;
      }
      bool1 = true;
      label1594:
      locallid.jdField_s_of_type_Boolean = bool1;
      locallid.jdField_k_of_type_Int = ((Intent)localObject1).getIntExtra("friendTerminal", 3);
      locallid.d("processIntentData", this.jdField_g_of_type_Boolean);
      locallid.jdField_p_of_type_Int = this.jdField_c_of_type_Int;
      locallid.jdField_l_of_type_JavaLangString = ((Intent)localObject1).getStringExtra("actId");
      locallid.jdField_m_of_type_JavaLangString = ((Intent)localObject1).getStringExtra("mp_ext_params");
      locallid.jdField_a_of_type_Long = this.jdField_a_of_type_Long;
      if ((this.jdField_d_of_type_Int != 1011) && (this.jdField_d_of_type_Int != 21)) {
        break label2131;
      }
      locallid.jdField_a_of_type_Lie.jdField_a_of_type_JavaLangString = str2;
      locallid.jdField_a_of_type_Lie.jdField_b_of_type_JavaLangString = ((Intent)localObject1).getStringExtra("name");
      locallid.jdField_a_of_type_Lie.jdField_c_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
      if (Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).longValue() <= Long.valueOf(this.jdField_c_of_type_JavaLangString).longValue()) {
        break label2101;
      }
      locallid.jdField_a_of_type_Lie.jdField_a_of_type_Boolean = true;
      localObject1 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication().getApplicationInfo().dataDir + "/" + MD5.toMD5(str2) + ".jpg";
      if (!arso.a((String)localObject1)) {}
    }
    for (;;)
    {
      try
      {
        locallid.jdField_a_of_type_Lie.jdField_a_of_type_AndroidGraphicsBitmap = BitmapFactory.decodeFile((String)localObject1);
        QLog.w(this.jdField_b_of_type_JavaLangString + "|VideoNodeManager", 1, "processIntentData end, mRelationId[" + this.jdField_d_of_type_JavaLangString + "], bStartByTerminalSwitch[" + locallid.ah + "], terSwitchStartFromVideoEntry[" + locallid.aj + "], \nSessionInfo[" + locallid + "]");
        return;
        if (this.jdField_d_of_type_Int == 1006)
        {
          if (TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString))
          {
            lek.d(this.jdField_b_of_type_JavaLangString, "phoneNum is empty");
            this.jdField_e_of_type_Boolean = true;
            ((lkz)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4)).a(locallid.b(), 5, 1016L);
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
          lek.d(this.jdField_b_of_type_JavaLangString, "Create video failed because uin is empty");
          this.jdField_e_of_type_Boolean = true;
          ((lkz)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4)).a(locallid.b(), 5, 1016L);
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
        locallid.jdField_a_of_type_Lie.jdField_a_of_type_Boolean = false;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        QLog.d(this.jdField_b_of_type_JavaLangString, 1, "processIntentData OutOfMemoryError", localOutOfMemoryError);
        continue;
      }
      label2131:
      locallid.jdField_a_of_type_Lie.jdField_a_of_type_JavaLangString = null;
      locallid.jdField_a_of_type_Lie.jdField_b_of_type_JavaLangString = null;
      locallid.jdField_a_of_type_Lie.jdField_a_of_type_Boolean = false;
    }
  }
  
  public void d(boolean paramBoolean)
  {
    QLog.w(this.jdField_b_of_type_JavaLangString, 1, "onZimuModeChange, inZimu[" + paramBoolean + "]");
    mlf localmlf;
    if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (this.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) && (this.jdField_a_of_type_Mlf != null))
    {
      this.jdField_a_of_type_Mlf.jdField_d_of_type_Boolean = paramBoolean;
      localmlf = this.jdField_a_of_type_Mlf;
      if (!paramBoolean) {
        break label87;
      }
    }
    label87:
    for (int i1 = 0;; i1 = this.jdField_h_of_type_Int)
    {
      localmlf.d(i1);
      this.jdField_a_of_type_Mlf.d();
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
        if (this.jdField_a_of_type_Mlf == null) {
          break label219;
        }
        i1 = this.jdField_a_of_type_Mlf.c();
        ((DoubleVideoCtrlUI)localObject).e_(i1);
        g(l1);
      }
    }
    if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (this.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) && (this.jdField_a_of_type_Mlf != null))
    {
      this.jdField_a_of_type_Mlf.jdField_c_of_type_Boolean = paramBoolean;
      if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_C_of_type_Boolean) || (this.jdField_a_of_type_ComTencentAvVideoController.a().B))
      {
        localObject = this.jdField_a_of_type_Mlf;
        if (!paramBoolean) {
          break label224;
        }
      }
    }
    label219:
    label224:
    for (int i1 = i2;; i1 = this.jdField_h_of_type_Int)
    {
      ((mlf)localObject).d(i1);
      this.jdField_a_of_type_Mlf.d();
      localObject = findViewById(2131362964);
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
    bhuf localbhuf = bhuf.c(this);
    localbhuf.getWindow().addFlags(524288);
    localbhuf.getWindow().addFlags(2097152);
    localbhuf.getWindow().addFlags(128);
    localbhuf.b(2131721359);
    localbhuf.c(2131690648);
    localbhuf.a(new mdn(this));
    localbhuf.setOnDismissListener(new mdo(this));
    localbhuf.setCanceledOnTouchOutside(true);
    localbhuf.e(150);
    this.jdField_a_of_type_AndroidAppDialog = localbhuf;
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
    lek.d(this.jdField_b_of_type_JavaLangString, "avideo life_finish, FromWhere[" + this.jdField_j_of_type_JavaLangString + "]");
    lid locallid = lfb.a().a();
    if ((locallid.B) && (this.jdField_a_of_type_Mlf != null))
    {
      this.jdField_a_of_type_Mlf.c();
      if (this.jdField_a_of_type_Mlf.b() < 1000L) {
        break label311;
      }
    }
    for (;;)
    {
      locallid.u = i1;
      azqs.b(null, "CliOper", "", "", "0X800863D", "0X800863D", 0, 0, "", "", "", "");
      if ((this.jdField_e_of_type_Boolean) && (locallid.aD) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null))
      {
        String str1 = String.valueOf(locallid.jdField_g_of_type_Long);
        String str2 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getDisplayName(this.jdField_d_of_type_Int, str1, locallid.jdField_f_of_type_JavaLangString);
        Intent localIntent = aepi.a(new Intent(super.getApplicationContext(), SplashActivity.class), null);
        localIntent.putExtra("uin", str1);
        localIntent.putExtra("uintype", locallid.jdField_i_of_type_Int);
        localIntent.putExtra("uinname", str2);
        startActivity(localIntent);
      }
      if (QLog.isColorLevel()) {
        QLog.i("double_2_multi", 2, "finish fromDoubleChat[" + locallid.aD + "], session[" + locallid + "]");
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
    ViewGroup localViewGroup = (ViewGroup)findViewById(2131362964);
    float f1 = getResources().getDimension(2131297557);
    float f2 = getResources().getDimension(2131297560);
    Object localObject = new RelativeLayout.LayoutParams(-1, (int)f1);
    ((RelativeLayout.LayoutParams)localObject).setMargins(0, (int)f2, 0, 0);
    this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterPanel = new EffectFilterPanel(getBaseContext(), this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterPanel.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = localViewGroup.findViewById(2131372917);
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
      ViewGroup localViewGroup = (ViewGroup)findViewById(2131362964);
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
      FaceItem localFaceItem = (FaceItem)((lju)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(3)).a();
      if ((localFaceItem == null) || (!localFaceItem.isInteract()) || (!localFaceItem.isSameType("face"))) {
        break label138;
      }
    }
    label138:
    for (paramBoolean = true;; paramBoolean = false)
    {
      lek.c(this.jdField_b_of_type_JavaLangString, "onChangeUI_quitDoubleScreenStatus isIntactiveFace:" + paramBoolean);
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
    mvj localmvj = mvj.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    if (localmvj != null)
    {
      if (paramBoolean) {
        i1 = 1;
      }
      localmvj.a(i1);
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
      msp.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramInt2, paramIntent);
    }
    do
    {
      do
      {
        return;
        if (paramInt1 == 802)
        {
          msp.b(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramInt2, paramIntent);
          return;
        }
        if (paramInt1 != 1002) {
          break;
        }
      } while (this.jdField_a_of_type_Mjs == null);
      this.jdField_a_of_type_Mjs.f();
      return;
    } while ((Build.VERSION.SDK_INT < 21) || (paramInt1 != 8080) || (this.jdField_a_of_type_Mls == null));
    if (paramInt2 == -1)
    {
      this.jdField_a_of_type_Mls.a(paramIntent);
      this.jdField_a_of_type_Mls.a();
      return;
    }
    this.jdField_a_of_type_Mls.b();
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
    mey localmey = new mey(null);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(7002), localmey });
    QLog.i(this.jdField_b_of_type_JavaLangString, 1, "avideo onBackPressed, BlockSystemBack[" + localmey.jdField_b_of_type_Boolean + "], BlockName[" + localmey.jdField_b_of_type_JavaLangString + "]");
    boolean bool1 = localmey.jdField_b_of_type_Boolean;
    boolean bool2 = bool1;
    if (!bool1)
    {
      bool2 = bool1;
      if (this.jdField_a_of_type_Mpe != null) {
        bool2 = this.jdField_a_of_type_Mpe.c();
      }
    }
    bool1 = bool2;
    if (!bool2)
    {
      if ((this.jdField_a_of_type_Men == null) || (!this.jdField_a_of_type_Men.a())) {
        break label221;
      }
      bool1 = this.jdField_a_of_type_Men.b();
    }
    for (;;)
    {
      bool2 = bool1;
      if (this.jdField_a_of_type_Mjs != null)
      {
        bool2 = bool1;
        if (this.jdField_a_of_type_Mjs.a())
        {
          this.jdField_a_of_type_Mjs.c();
          bool2 = true;
        }
      }
      if (!bool2) {
        super.onBackPressed();
      }
      this.jdField_a_of_type_ComTencentAvVideoController.a("backgroundReason", "2");
      lfh.jdField_a_of_type_JavaLangString = "2";
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
    QLog.w(this.jdField_b_of_type_JavaLangString + "|VideoNodeManager", 1, "avideo life_onCreate, seq[" + l1 + "], IS_CPU_64_BIT = " + false);
    this.mIsShadow = false;
    super.onCreate(paramBundle);
    super.requestWindowFeature(1);
    super.setContentView(2131559547);
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
      lek.d(this.jdField_b_of_type_JavaLangString, "onCreate, appRuntime is null exit");
      paramBundle = super.getString(2131721302) + " 0x05";
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
      lek.d(this.jdField_b_of_type_JavaLangString, "onCreate, AppRuntime is no VideoAppInterface, " + paramBundle.getClass().getName() + " exit");
      paramBundle = super.getString(2131721302) + " 0x06";
      Toast.makeText(super.getBaseContext(), paramBundle, 0).show();
      this.jdField_e_of_type_Boolean = true;
      sendBroadcast(new Intent("com.tencent.av.ui.AVLoadingDialogActivity.ACTION_LOADING_FINISH"));
      finish();
      return;
    }
    f(true);
    paramBundle = (lkz)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4);
    localObject1 = lfb.a().a();
    if (localObject1 != null)
    {
      QLog.d(this.jdField_b_of_type_JavaLangString, 1, "avideo life_onCreate roomId = " + ((lid)localObject1).b() + ",isReceiver = " + ((lid)localObject1).jdField_e_of_type_Boolean);
      if (((lid)localObject1).jdField_e_of_type_Boolean) {
        paramBundle.a(((lid)localObject1).b(), 7, 1L);
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
      lko.a().a(this);
      this.jdField_a_of_type_ComTencentAvVideoController = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
      if (this.jdField_a_of_type_ComTencentAvVideoController != null) {
        break;
      }
      lek.d(this.jdField_b_of_type_JavaLangString, "onCreate,VideoAppInterface.mVideoController exit");
      paramBundle = super.getString(2131721302) + " 0x07";
      Toast.makeText(super.getBaseContext(), paramBundle, 0).show();
      this.jdField_e_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast(new Intent("com.tencent.av.ui.AVLoadingDialogActivity.ACTION_LOADING_FINISH"));
      finish();
      return;
      QLog.d(this.jdField_b_of_type_JavaLangString, 1, "avideo life_onCreate sessionInfo is null ");
    }
    if (!this.jdField_a_of_type_ComTencentAvVideoController.c())
    {
      lek.d(this.jdField_b_of_type_JavaLangString, "onCreate,VideoAppInterface.initVcController exit");
      paramBundle = super.getString(2131721302) + " 0x08";
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
      localObject1 = paramBundle.getStringExtra("uin");
      if (i1 == 1008)
      {
        localObject2 = lfb.a(3, (String)localObject1, new int[0]);
        localObject2 = lfb.a().c((String)localObject2);
        if ((localObject2 == null) || (((lid)localObject2).jdField_i_of_type_Int == -1))
        {
          localObject2 = lfb.a().a();
          if ((((lid)localObject2).jdField_i_of_type_Int != -1) && ((((lid)localObject2).g()) || (((lid)localObject2).i())))
          {
            paramBundle = new Intent("tencent.video.v2q.ypc2b.failEnter.asIsInviting");
            paramBundle.setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getPackageName());
            paramBundle.putExtra("uin", (String)localObject1);
            paramBundle.putExtra("uinType", i1);
            this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast(paramBundle);
            this.jdField_e_of_type_Boolean = true;
            this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast(new Intent("com.tencent.av.ui.AVLoadingDialogActivity.ACTION_LOADING_FINISH"));
            lek.d(this.jdField_b_of_type_JavaLangString, "onCreate,VideoAppInterface.UIN_TYPE_PUBLIC_ACCOUNT exit: " + (String)localObject1);
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
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_Lhe);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_Meu);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_Lij);
      this.jdField_a_of_type_ComTencentAvVideoController.b();
      a();
      d();
      this.jdField_a_of_type_JavaLangString = a(getIntent());
      if ((TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) || (a(getIntent())) || (lfb.a().a(this.jdField_a_of_type_JavaLangString))) {
        break label1654;
      }
      this.jdField_a_of_type_ComTencentAvVideoController.a(false, 204, new int[] { this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_C_of_type_Int });
      this.jdField_a_of_type_ComTencentAvVideoController.b(204);
      lfb.a().a(this.jdField_a_of_type_JavaLangString, false);
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
      this.jdField_a_of_type_Mvj = mvj.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      b(0);
      a(l1, false);
      if ((this.jdField_a_of_type_ComTencentAvUiVideoControlUI instanceof DoubleVideoCtrlUI)) {
        lyg.a().a();
      }
      if (EffectSettingUi.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, false))
      {
        this.jdField_a_of_type_Mes = new mes(this);
        this.jdField_a_of_type_Mes.a();
      }
      this.jdField_a_of_type_Mbl = mbl.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      i1 = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_M_of_type_Int;
      if (QLog.isDevelopLevel()) {
        QLog.d(this.jdField_b_of_type_JavaLangString, 4, "onCreate changeVideoLayoutMode Style=" + this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int + "|" + this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_M_of_type_Int + "|" + this.jdField_a_of_type_ComTencentAvVideoController.g());
      }
      a(i1, false);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast(new Intent("com.tencent.av.ui.AVLoadingDialogActivity.ACTION_LOADING_FINISH"));
      paramBundle = (ViewStub)findViewById(2131372627);
      this.jdField_a_of_type_Mjs = new mjs(findViewById(2131372566), paramBundle, 2131372861, this.jdField_a_of_type_ComTencentAvVideoController, this);
      this.jdField_a_of_type_Mpe = new mpe(this, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface)) {
        findViewById(2131372796).setVisibility(0);
      }
      this.jdField_a_of_type_ComTencentAvUiGuideGuideHelper.a(this);
      AudioHelper.b(this.jdField_b_of_type_JavaLangString + ".onCreate.end");
      return;
      paramBundle = paramBundle.getStringExtra("Fromwhere");
      break;
      label1654:
      this.jdField_a_of_type_JavaLangString = lfb.a().a().jdField_c_of_type_JavaLangString;
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
    if (this.jdField_a_of_type_Mpe != null)
    {
      this.jdField_a_of_type_Mpe.a(this.jdField_e_of_type_Boolean);
      this.jdField_a_of_type_Mpe = null;
    }
    if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (this.jdField_a_of_type_ComTencentAvVideoController.a() != null) && (this.jdField_a_of_type_ComTencentAvVideoController.a().B) && (this.jdField_a_of_type_Mlf != null)) {
      this.jdField_a_of_type_Mlf.c();
    }
    if (this.jdField_a_of_type_Mlf != null)
    {
      this.jdField_a_of_type_Mlf.e();
      this.jdField_a_of_type_Mlf = null;
    }
    if (this.jdField_a_of_type_ComTencentAvCameraCameraUtils != null)
    {
      this.jdField_a_of_type_ComTencentAvCameraCameraUtils.b(this.jdField_a_of_type_Lme);
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
    if (this.jdField_a_of_type_Men != null)
    {
      this.jdField_a_of_type_Men.b();
      this.jdField_a_of_type_Men = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView = null;
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_Lij);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_Meu);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_Lhe);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      lmr locallmr = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
      if (locallmr != null) {
        locallmr.a();
      }
    }
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null)
    {
      unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
    }
    if (this.jdField_e_of_type_Boolean)
    {
      loc.a().a();
      if (this.jdField_a_of_type_Mvj != null) {
        this.jdField_a_of_type_Mvj.a(this.jdField_a_of_type_JavaLangString);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i(this.jdField_b_of_type_JavaLangString, 2, "onDestroy isQuit[" + this.jdField_e_of_type_Boolean + "], session[" + this.jdField_a_of_type_JavaLangString + "]");
    }
    this.jdField_a_of_type_ComTencentAvVideoController = null;
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a().c("AVActivity.onDestroy", 0);
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = null;
    this.jdField_a_of_type_Mvj = null;
    this.jdField_a_of_type_Mea = null;
    AudioHelper.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
    this.jdField_a_of_type_Meu = null;
    this.jdField_a_of_type_Lij = null;
    if (this.jdField_a_of_type_Mes != null)
    {
      this.jdField_a_of_type_Mes.b();
      this.jdField_a_of_type_Mes = null;
    }
    lko.a().a(null);
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(7004), this.jdField_c_of_type_JavaLangString, Boolean.valueOf(this.jdField_e_of_type_Boolean) });
    }
    lvt.a().a();
    lvt.a().a(null, null);
    abvb.a(this);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
    if (this.jdField_a_of_type_Mjs != null)
    {
      azqs.b(null, "CliOper", "", "", "0X800A345", "0X800A345", this.jdField_a_of_type_Mjs.a(), 0, "", "", "", "");
      this.jdField_a_of_type_Mjs.g();
    }
    this.jdField_a_of_type_Mjs = null;
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
      } while (((paramKeyEvent.jdField_d_of_type_Int != 2) || (!paramKeyEvent.k())) && ((paramKeyEvent.jdField_d_of_type_Int != 4) || (paramKeyEvent.jdField_g_of_type_Int < 9)));
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
    if (this.jdField_a_of_type_Mbl != null) {
      this.jdField_a_of_type_Mbl.b();
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
          if ((i2 != 2) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_C_of_type_Int != 2)) {
            break label290;
          }
          if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_C_of_type_Int != i2) {
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
    aofm.a(this, 2, true);
    lvt.a().a(16);
    i(false);
    bexu.a(BaseApplicationImpl.getContext(), true, 50, 1);
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
        if ("0".equals(lfh.jdField_a_of_type_JavaLangString)) {
          this.jdField_a_of_type_ComTencentAvVideoController.a("backgroundReason", "5");
        }
      }
      QLog.d(this.jdField_b_of_type_JavaLangString, 1, "avideo life_onPause end");
      if (this.jdField_a_of_type_Mjs != null)
      {
        this.jdField_a_of_type_Mjs.c();
        this.jdField_a_of_type_Mjs.f();
      }
      this.jdField_a_of_type_Lmz.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_a_of_type_ComTencentAvVideoController);
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
    //   2: invokevirtual 2525	com/tencent/av/ui/AVActivity:i	(Z)V
    //   5: invokestatic 243	com/tencent/mobileqq/utils/AudioHelper:b	()J
    //   8: lstore 9
    //   10: aload_0
    //   11: iconst_2
    //   12: iconst_0
    //   13: invokestatic 2523	aofm:a	(Landroid/content/Context;IZ)V
    //   16: invokestatic 2528	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   19: bipush 50
    //   21: iconst_0
    //   22: invokestatic 2559	bexu:a	(Landroid/content/Context;II)V
    //   25: invokestatic 2528	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   28: iconst_0
    //   29: bipush 50
    //   31: iconst_1
    //   32: invokestatic 2533	bexu:a	(Landroid/content/Context;ZII)V
    //   35: invokestatic 2528	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   38: bipush 50
    //   40: iconst_2
    //   41: invokestatic 2559	bexu:a	(Landroid/content/Context;II)V
    //   44: new 231	java/lang/StringBuilder
    //   47: dup
    //   48: invokespecial 232	java/lang/StringBuilder:<init>	()V
    //   51: aload_0
    //   52: getfield 252	com/tencent/av/ui/AVActivity:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   55: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: ldc_w 2561
    //   61: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: invokevirtual 250	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   67: invokestatic 2225	com/tencent/mobileqq/utils/AudioHelper:b	(Ljava/lang/String;)V
    //   70: aload_0
    //   71: iconst_0
    //   72: putfield 229	com/tencent/av/ui/AVActivity:mIsShadow	Z
    //   75: aload_0
    //   76: invokespecial 2563	mqq/app/BaseActivity:onResume	()V
    //   79: invokestatic 1606	lfb:a	()Llfb;
    //   82: invokevirtual 2049	lfb:a	()Llid;
    //   85: astore 21
    //   87: aload_0
    //   88: getfield 252	com/tencent/av/ui/AVActivity:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   91: iconst_1
    //   92: new 231	java/lang/StringBuilder
    //   95: dup
    //   96: invokespecial 232	java/lang/StringBuilder:<init>	()V
    //   99: ldc_w 2565
    //   102: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: aload_0
    //   106: getfield 570	com/tencent/av/ui/AVActivity:o	Z
    //   109: invokevirtual 471	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   112: ldc_w 533
    //   115: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: lload 9
    //   120: invokevirtual 246	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   123: ldc_w 2567
    //   126: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: aload 21
    //   131: invokevirtual 729	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   134: ldc_w 313
    //   137: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: invokevirtual 250	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   143: invokestatic 406	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   146: aload_0
    //   147: iconst_0
    //   148: putfield 2534	com/tencent/av/ui/AVActivity:jdField_i_of_type_Boolean	Z
    //   151: invokestatic 2570	lse:a	()V
    //   154: aload_0
    //   155: getfield 139	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvAppVideoAppInterface	Lcom/tencent/av/app/VideoAppInterface;
    //   158: iconst_4
    //   159: invokevirtual 1296	com/tencent/av/app/VideoAppInterface:a	(I)Lljg;
    //   162: checkcast 1506	lkz
    //   165: astore 22
    //   167: aload 21
    //   169: getfield 897	lid:jdField_e_of_type_Boolean	Z
    //   172: ifeq +16 -> 188
    //   175: aload 22
    //   177: aload 21
    //   179: invokevirtual 1507	lid:b	()J
    //   182: bipush 8
    //   184: lconst_1
    //   185: invokevirtual 1512	lkz:a	(JIJ)V
    //   188: aload_0
    //   189: invokevirtual 1135	com/tencent/av/ui/AVActivity:getIntent	()Landroid/content/Intent;
    //   192: ldc_w 2306
    //   195: iconst_0
    //   196: invokevirtual 284	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   199: ifeq +13 -> 212
    //   202: aload 22
    //   204: ldc2_w 2307
    //   207: iconst_3
    //   208: lconst_1
    //   209: invokevirtual 1512	lkz:a	(JIJ)V
    //   212: aload_0
    //   213: getfield 139	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvAppVideoAppInterface	Lcom/tencent/av/app/VideoAppInterface;
    //   216: invokevirtual 2571	com/tencent/av/app/VideoAppInterface:i	()Z
    //   219: ifne +10 -> 229
    //   222: aload_0
    //   223: getfield 139	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvAppVideoAppInterface	Lcom/tencent/av/app/VideoAppInterface;
    //   226: invokevirtual 2572	com/tencent/av/app/VideoAppInterface:b	()V
    //   229: aload_0
    //   230: getfield 570	com/tencent/av/ui/AVActivity:o	Z
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
    //   254: putfield 570	com/tencent/av/ui/AVActivity:o	Z
    //   257: aload_0
    //   258: iconst_0
    //   259: putfield 203	com/tencent/av/ui/AVActivity:jdField_k_of_type_Boolean	Z
    //   262: aload_0
    //   263: iconst_2
    //   264: invokevirtual 2381	com/tencent/av/ui/AVActivity:b	(I)V
    //   267: aload_0
    //   268: getfield 141	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvVideoController	Lcom/tencent/av/VideoController;
    //   271: iconst_1
    //   272: invokevirtual 1401	com/tencent/av/VideoController:i	(Z)V
    //   275: aload_0
    //   276: getfield 334	com/tencent/av/ui/AVActivity:jdField_a_of_type_Mbl	Lmbl;
    //   279: ifnull +10 -> 289
    //   282: aload_0
    //   283: getfield 334	com/tencent/av/ui/AVActivity:jdField_a_of_type_Mbl	Lmbl;
    //   286: invokevirtual 2510	mbl:b	()V
    //   289: getstatic 458	android/os/Build$VERSION:SDK_INT	I
    //   292: bipush 21
    //   294: if_icmplt +47 -> 341
    //   297: aload_0
    //   298: getfield 141	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvVideoController	Lcom/tencent/av/VideoController;
    //   301: invokevirtual 835	com/tencent/av/VideoController:a	()Lmls;
    //   304: astore 19
    //   306: aload 19
    //   308: ifnull +33 -> 341
    //   311: aload 19
    //   313: invokevirtual 2573	mls:c	()Z
    //   316: ifeq +25 -> 341
    //   319: aload_0
    //   320: getfield 139	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvAppVideoAppInterface	Lcom/tencent/av/app/VideoAppInterface;
    //   323: invokevirtual 1009	com/tencent/av/app/VideoAppInterface:a	()Landroid/os/Handler;
    //   326: new 2575	com/tencent/av/ui/AVActivity$11
    //   329: dup
    //   330: aload_0
    //   331: invokespecial 2576	com/tencent/av/ui/AVActivity$11:<init>	(Lcom/tencent/av/ui/AVActivity;)V
    //   334: ldc2_w 2577
    //   337: invokevirtual 1018	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   340: pop
    //   341: aload_0
    //   342: getfield 139	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvAppVideoAppInterface	Lcom/tencent/av/app/VideoAppInterface;
    //   345: invokevirtual 1009	com/tencent/av/app/VideoAppInterface:a	()Landroid/os/Handler;
    //   348: new 2580	com/tencent/av/ui/AVActivity$12
    //   351: dup
    //   352: aload_0
    //   353: lload 9
    //   355: invokespecial 2582	com/tencent/av/ui/AVActivity$12:<init>	(Lcom/tencent/av/ui/AVActivity;J)V
    //   358: ldc2_w 2583
    //   361: invokevirtual 1018	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   364: pop
    //   365: aload 21
    //   367: getfield 518	lid:jdField_d_of_type_Int	I
    //   370: iconst_2
    //   371: if_icmpne +1084 -> 1455
    //   374: aload 21
    //   376: invokevirtual 2503	lid:k	()Z
    //   379: ifeq +1022 -> 1401
    //   382: aload 21
    //   384: getfield 1199	lid:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   387: astore 19
    //   389: aload 21
    //   391: getfield 2585	lid:jdField_k_of_type_Boolean	Z
    //   394: istore 16
    //   396: aload_0
    //   397: getfield 141	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvVideoController	Lcom/tencent/av/VideoController;
    //   400: aload_0
    //   401: getfield 93	com/tencent/av/ui/AVActivity:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   404: invokevirtual 2587	com/tencent/av/VideoController:b	(Ljava/lang/String;)I
    //   407: iconst_5
    //   408: if_icmpne +874 -> 1282
    //   411: iconst_1
    //   412: istore 15
    //   414: aload 21
    //   416: getfield 2588	lid:jdField_i_of_type_Boolean	Z
    //   419: istore 17
    //   421: aload 21
    //   423: getfield 2589	lid:jdField_j_of_type_Boolean	Z
    //   426: istore 18
    //   428: iload 18
    //   430: ifeq +41 -> 471
    //   433: invokestatic 2593	bdgk:d	()Ljava/lang/String;
    //   436: astore 20
    //   438: aload_0
    //   439: getfield 903	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvCameraCameraUtils	Lcom/tencent/av/camera/CameraUtils;
    //   442: lload 9
    //   444: invokevirtual 2595	com/tencent/av/camera/CameraUtils:a	(J)Z
    //   447: ifne +841 -> 1288
    //   450: aload_0
    //   451: getfield 903	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvCameraCameraUtils	Lcom/tencent/av/camera/CameraUtils;
    //   454: lload 9
    //   456: invokevirtual 911	com/tencent/av/camera/CameraUtils:b	(J)Z
    //   459: ifne +829 -> 1288
    //   462: aload_0
    //   463: getfield 903	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvCameraCameraUtils	Lcom/tencent/av/camera/CameraUtils;
    //   466: lload 9
    //   468: invokevirtual 2596	com/tencent/av/camera/CameraUtils:a	(J)V
    //   471: aload_0
    //   472: getfield 595	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   475: ifnull +59 -> 534
    //   478: iload 18
    //   480: ifeq +877 -> 1357
    //   483: iload 16
    //   485: ifeq +872 -> 1357
    //   488: iload 17
    //   490: ifeq +836 -> 1326
    //   493: aload_0
    //   494: getfield 595	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   497: lload 9
    //   499: aload 19
    //   501: iconst_1
    //   502: iconst_1
    //   503: iconst_0
    //   504: iload 15
    //   506: invokevirtual 1388	com/tencent/av/ui/VideoLayerUI:a	(JLjava/lang/String;IZZZ)V
    //   509: aload_0
    //   510: getfield 139	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvAppVideoAppInterface	Lcom/tencent/av/app/VideoAppInterface;
    //   513: ldc_w 2597
    //   516: invokestatic 2600	msp:a	(Lcom/tencent/av/app/VideoAppInterface;Ljava/lang/String;)Z
    //   519: istore 15
    //   521: aload_0
    //   522: getfield 595	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   525: lload 9
    //   527: iconst_1
    //   528: iload 15
    //   530: invokevirtual 906	com/tencent/av/ui/VideoLayerUI:b	(JZZ)Z
    //   533: pop
    //   534: aload_0
    //   535: getfield 595	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   538: ifnull +10 -> 548
    //   541: aload_0
    //   542: getfield 595	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   545: invokevirtual 2602	com/tencent/av/ui/VideoLayerUI:q	()V
    //   548: aload_0
    //   549: getfield 515	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoControlUI	Lcom/tencent/av/ui/VideoControlUI;
    //   552: ifnull +12 -> 564
    //   555: aload_0
    //   556: getfield 515	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoControlUI	Lcom/tencent/av/ui/VideoControlUI;
    //   559: lload 9
    //   561: invokevirtual 2604	com/tencent/av/ui/VideoControlUI:b	(J)V
    //   564: aload_0
    //   565: getfield 546	com/tencent/av/ui/AVActivity:jdField_a_of_type_Men	Lmen;
    //   568: ifnull +10 -> 578
    //   571: aload_0
    //   572: getfield 546	com/tencent/av/ui/AVActivity:jdField_a_of_type_Men	Lmen;
    //   575: invokevirtual 2605	men:c	()V
    //   578: aload_0
    //   579: getfield 141	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvVideoController	Lcom/tencent/av/VideoController;
    //   582: iconst_0
    //   583: invokevirtual 1399	com/tencent/av/VideoController:a	(Z)I
    //   586: pop
    //   587: aload_0
    //   588: invokevirtual 2606	com/tencent/av/ui/AVActivity:b	()V
    //   591: aload_0
    //   592: invokevirtual 2607	com/tencent/av/ui/AVActivity:e	()V
    //   595: aload_0
    //   596: getfield 139	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvAppVideoAppInterface	Lcom/tencent/av/app/VideoAppInterface;
    //   599: invokevirtual 2329	com/tencent/av/app/VideoAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   602: new 263	android/content/Intent
    //   605: dup
    //   606: ldc_w 2280
    //   609: invokespecial 2281	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   612: invokevirtual 2332	com/tencent/qphone/base/util/BaseApplication:sendBroadcast	(Landroid/content/Intent;)V
    //   615: aload_0
    //   616: getfield 595	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   619: ifnull +20 -> 639
    //   622: aload_0
    //   623: invokevirtual 560	com/tencent/av/ui/AVActivity:a	()Z
    //   626: ifeq +13 -> 639
    //   629: aload_0
    //   630: getfield 595	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   633: ldc_w 2597
    //   636: invokevirtual 2118	com/tencent/av/ui/VideoLayerUI:a	(Ljava/lang/String;)V
    //   639: aload 21
    //   641: getfield 518	lid:jdField_d_of_type_Int	I
    //   644: iconst_2
    //   645: if_icmpeq +12 -> 657
    //   648: aload 21
    //   650: getfield 518	lid:jdField_d_of_type_Int	I
    //   653: iconst_1
    //   654: if_icmpne +45 -> 699
    //   657: aload_0
    //   658: getfield 615	com/tencent/av/ui/AVActivity:jdField_a_of_type_Mlf	Lmlf;
    //   661: ifnull +38 -> 699
    //   664: aload_0
    //   665: getfield 615	com/tencent/av/ui/AVActivity:jdField_a_of_type_Mlf	Lmlf;
    //   668: invokevirtual 2609	mlf:d	()I
    //   671: iconst_1
    //   672: if_icmpne +27 -> 699
    //   675: aload 21
    //   677: getfield 976	lid:jdField_C_of_type_Boolean	Z
    //   680: ifeq +19 -> 699
    //   683: aload_0
    //   684: getfield 221	com/tencent/av/ui/AVActivity:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   687: new 2611	com/tencent/av/ui/AVActivity$14
    //   690: dup
    //   691: aload_0
    //   692: invokespecial 2612	com/tencent/av/ui/AVActivity$14:<init>	(Lcom/tencent/av/ui/AVActivity;)V
    //   695: invokevirtual 1257	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   698: pop
    //   699: aload 21
    //   701: getfield 2615	lid:W	I
    //   704: iconst_m1
    //   705: if_icmpne +12 -> 717
    //   708: aload 21
    //   710: aload_0
    //   711: invokevirtual 2616	com/tencent/av/ui/AVActivity:a	()I
    //   714: putfield 2615	lid:W	I
    //   717: aload 21
    //   719: getfield 2619	lid:V	I
    //   722: iconst_m1
    //   723: if_icmpne +105 -> 828
    //   726: aload_0
    //   727: invokevirtual 576	com/tencent/av/ui/AVActivity:getApplicationContext	()Landroid/content/Context;
    //   730: invokestatic 685	bdne:a	(Landroid/content/Context;)Landroid/content/SharedPreferences;
    //   733: astore 19
    //   735: aload 21
    //   737: aload 19
    //   739: new 231	java/lang/StringBuilder
    //   742: dup
    //   743: invokespecial 232	java/lang/StringBuilder:<init>	()V
    //   746: ldc_w 2621
    //   749: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   752: aload_0
    //   753: getfield 139	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvAppVideoAppInterface	Lcom/tencent/av/app/VideoAppInterface;
    //   756: invokevirtual 690	com/tencent/av/app/VideoAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   759: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   762: invokevirtual 250	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   765: iconst_1
    //   766: invokeinterface 700 3 0
    //   771: putfield 2619	lid:V	I
    //   774: aload 21
    //   776: getfield 2619	lid:V	I
    //   779: iconst_1
    //   780: if_icmpne +48 -> 828
    //   783: aload 19
    //   785: invokeinterface 2625 1 0
    //   790: new 231	java/lang/StringBuilder
    //   793: dup
    //   794: invokespecial 232	java/lang/StringBuilder:<init>	()V
    //   797: ldc_w 2621
    //   800: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   803: aload_0
    //   804: getfield 139	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvAppVideoAppInterface	Lcom/tencent/av/app/VideoAppInterface;
    //   807: invokevirtual 690	com/tencent/av/app/VideoAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   810: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   813: invokevirtual 250	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   816: iconst_0
    //   817: invokeinterface 2631 3 0
    //   822: invokeinterface 2634 1 0
    //   827: pop
    //   828: aload 21
    //   830: getfield 2054	lid:u	I
    //   833: ifeq +38 -> 871
    //   836: aload 21
    //   838: getfield 2054	lid:u	I
    //   841: iconst_1
    //   842: if_icmpne +1305 -> 2147
    //   845: aload_0
    //   846: iconst_2
    //   847: aload_0
    //   848: invokevirtual 740	com/tencent/av/ui/AVActivity:getResources	()Landroid/content/res/Resources;
    //   851: ldc_w 2635
    //   854: invokevirtual 2636	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   857: iconst_0
    //   858: invokestatic 2641	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;ILjava/lang/CharSequence;I)Lcom/tencent/mobileqq/widget/QQToast;
    //   861: invokevirtual 2644	com/tencent/mobileqq/widget/QQToast:a	()Landroid/widget/Toast;
    //   864: pop
    //   865: aload 21
    //   867: iconst_0
    //   868: putfield 2054	lid:u	I
    //   871: aload_0
    //   872: getfield 139	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvAppVideoAppInterface	Lcom/tencent/av/app/VideoAppInterface;
    //   875: iconst_2
    //   876: anewarray 1290	java/lang/Object
    //   879: dup
    //   880: iconst_0
    //   881: sipush 7000
    //   884: invokestatic 2137	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   887: aastore
    //   888: dup
    //   889: iconst_1
    //   890: aload_0
    //   891: getfield 93	com/tencent/av/ui/AVActivity:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   894: aastore
    //   895: invokevirtual 1293	com/tencent/av/app/VideoAppInterface:a	([Ljava/lang/Object;)V
    //   898: invokestatic 671	com/tencent/mobileqq/utils/AudioHelper:d	()Z
    //   901: ifeq +10 -> 911
    //   904: aload_0
    //   905: getfield 139	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvAppVideoAppInterface	Lcom/tencent/av/app/VideoAppInterface;
    //   908: invokestatic 2647	com/tencent/mobileqq/debug/PstnCardTestActivity:showTestBtn	(Lcom/tencent/av/app/VideoAppInterface;)V
    //   911: invokestatic 1246	lvt:a	()Llvt;
    //   914: bipush 16
    //   916: invokevirtual 2648	lvt:b	(I)V
    //   919: aload 21
    //   921: getfield 2589	lid:jdField_j_of_type_Boolean	Z
    //   924: istore 15
    //   926: aload 21
    //   928: getfield 2585	lid:jdField_k_of_type_Boolean	Z
    //   931: istore 16
    //   933: iload 15
    //   935: ifeq +8 -> 943
    //   938: iload 16
    //   940: ifne +1230 -> 2170
    //   943: invokestatic 1246	lvt:a	()Llvt;
    //   946: iconst_1
    //   947: invokevirtual 2524	lvt:a	(I)V
    //   950: invokestatic 2651	java/lang/System:currentTimeMillis	()J
    //   953: lstore 11
    //   955: invokestatic 2387	lyg:a	()Llyg;
    //   958: getfield 2652	lyg:jdField_b_of_type_Long	J
    //   961: lstore 13
    //   963: aload 21
    //   965: invokevirtual 1507	lid:b	()J
    //   968: lconst_0
    //   969: lcmp
    //   970: ifle +1210 -> 2180
    //   973: aload 21
    //   975: invokevirtual 1507	lid:b	()J
    //   978: lstore 7
    //   980: aload 22
    //   982: lload 7
    //   984: bipush 25
    //   986: lload 11
    //   988: lload 13
    //   990: lsub
    //   991: invokevirtual 1512	lkz:a	(JIJ)V
    //   994: aload_0
    //   995: getfield 141	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvVideoController	Lcom/tencent/av/VideoController;
    //   998: ldc_w 2539
    //   1001: ldc_w 2654
    //   1004: invokevirtual 2215	com/tencent/av/VideoController:a	(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/av/VideoController;
    //   1007: pop
    //   1008: ldc_w 2541
    //   1011: putstatic 2218	lfh:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1014: new 231	java/lang/StringBuilder
    //   1017: dup
    //   1018: invokespecial 232	java/lang/StringBuilder:<init>	()V
    //   1021: aload_0
    //   1022: getfield 252	com/tencent/av/ui/AVActivity:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1025: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1028: ldc_w 2656
    //   1031: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1034: invokevirtual 250	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1037: invokestatic 2225	com/tencent/mobileqq/utils/AudioHelper:b	(Ljava/lang/String;)V
    //   1040: aload_0
    //   1041: invokevirtual 1135	com/tencent/av/ui/AVActivity:getIntent	()Landroid/content/Intent;
    //   1044: ldc_w 2658
    //   1047: iconst_0
    //   1048: invokevirtual 267	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   1051: ifeq +21 -> 1072
    //   1054: invokestatic 2663	abws:a	()Labws;
    //   1057: aload_0
    //   1058: invokevirtual 1135	com/tencent/av/ui/AVActivity:getIntent	()Landroid/content/Intent;
    //   1061: ldc_w 2658
    //   1064: iconst_0
    //   1065: invokevirtual 267	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   1068: iconst_1
    //   1069: invokevirtual 2664	abws:a	(IZ)V
    //   1072: aload_0
    //   1073: invokevirtual 2665	com/tencent/av/ui/AVActivity:a	()Lcom/tencent/av/VideoController;
    //   1076: invokevirtual 2666	com/tencent/av/VideoController:x	()V
    //   1079: invokestatic 2667	com/tencent/av/VideoController:a	()Lcom/tencent/av/VideoController;
    //   1082: aload_0
    //   1083: invokevirtual 1094	com/tencent/av/VideoController:a	(Landroid/content/Context;)Llsa;
    //   1086: astore 19
    //   1088: aload 19
    //   1090: ifnull +12 -> 1102
    //   1093: aload 19
    //   1095: lload 9
    //   1097: invokeinterface 2670 3 0
    //   1102: invokestatic 671	com/tencent/mobileqq/utils/AudioHelper:d	()Z
    //   1105: ifeq +46 -> 1151
    //   1108: aload_0
    //   1109: getfield 252	com/tencent/av/ui/AVActivity:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1112: iconst_1
    //   1113: new 231	java/lang/StringBuilder
    //   1116: dup
    //   1117: invokespecial 232	java/lang/StringBuilder:<init>	()V
    //   1120: ldc_w 2672
    //   1123: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1126: aload_0
    //   1127: invokevirtual 1982	com/tencent/av/ui/AVActivity:getWindow	()Landroid/view/Window;
    //   1130: invokevirtual 445	android/view/Window:getDecorView	()Landroid/view/View;
    //   1133: invokevirtual 450	android/view/View:getSystemUiVisibility	()I
    //   1136: invokevirtual 309	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1139: ldc_w 313
    //   1142: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1145: invokevirtual 250	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1148: invokestatic 406	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1151: aload_0
    //   1152: getfield 179	com/tencent/av/ui/AVActivity:jdField_a_of_type_Lmz	Llmz;
    //   1155: aload_0
    //   1156: aload_0
    //   1157: getfield 139	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvAppVideoAppInterface	Lcom/tencent/av/app/VideoAppInterface;
    //   1160: aload_0
    //   1161: getfield 141	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvVideoController	Lcom/tencent/av/VideoController;
    //   1164: invokevirtual 2675	lmz:a	(Lmqq/app/BaseActivity;Lcom/tencent/av/app/VideoAppInterface;Lcom/tencent/av/VideoController;)V
    //   1167: aload_0
    //   1168: getfield 926	com/tencent/av/ui/AVActivity:jdField_a_of_type_Mpe	Lmpe;
    //   1171: ifnull +76 -> 1247
    //   1174: invokestatic 304	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1177: ifeq +41 -> 1218
    //   1180: aload_0
    //   1181: getfield 252	com/tencent/av/ui/AVActivity:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1184: iconst_2
    //   1185: new 231	java/lang/StringBuilder
    //   1188: dup
    //   1189: invokespecial 232	java/lang/StringBuilder:<init>	()V
    //   1192: ldc_w 2677
    //   1195: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1198: aload 21
    //   1200: getfield 2680	lid:aB	Z
    //   1203: invokevirtual 471	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1206: ldc_w 313
    //   1209: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1212: invokevirtual 250	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1215: invokestatic 316	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1218: aload 21
    //   1220: getfield 2680	lid:aB	Z
    //   1223: ifeq +17 -> 1240
    //   1226: aload_0
    //   1227: getfield 926	com/tencent/av/ui/AVActivity:jdField_a_of_type_Mpe	Lmpe;
    //   1230: iconst_0
    //   1231: invokevirtual 2681	mpe:a	(I)V
    //   1234: aload 21
    //   1236: iconst_0
    //   1237: putfield 2680	lid:aB	Z
    //   1240: aload_0
    //   1241: getfield 926	com/tencent/av/ui/AVActivity:jdField_a_of_type_Mpe	Lmpe;
    //   1244: invokevirtual 930	mpe:a	()V
    //   1247: return
    //   1248: astore 19
    //   1250: aload_0
    //   1251: getfield 252	com/tencent/av/ui/AVActivity:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1254: iconst_1
    //   1255: new 231	java/lang/StringBuilder
    //   1258: dup
    //   1259: invokespecial 232	java/lang/StringBuilder:<init>	()V
    //   1262: ldc_w 2683
    //   1265: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1268: aload 19
    //   1270: invokevirtual 729	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1273: invokevirtual 250	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1276: invokestatic 326	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1279: goto -1200 -> 79
    //   1282: iconst_0
    //   1283: istore 15
    //   1285: goto -871 -> 414
    //   1288: aload 20
    //   1290: ldc_w 2685
    //   1293: invokevirtual 2688	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1296: ifeq -825 -> 471
    //   1299: aload_0
    //   1300: getfield 903	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvCameraCameraUtils	Lcom/tencent/av/camera/CameraUtils;
    //   1303: invokevirtual 2691	com/tencent/av/camera/CameraUtils:a	()Landroid/hardware/Camera$Parameters;
    //   1306: ifnonnull -835 -> 471
    //   1309: aload_0
    //   1310: getfield 903	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvCameraCameraUtils	Lcom/tencent/av/camera/CameraUtils;
    //   1313: ldc_w 2693
    //   1316: lload 9
    //   1318: iconst_m1
    //   1319: iconst_m1
    //   1320: invokevirtual 2696	com/tencent/av/camera/CameraUtils:a	(Ljava/lang/String;JII)V
    //   1323: goto -852 -> 471
    //   1326: aload_0
    //   1327: getfield 595	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   1330: lload 9
    //   1332: iconst_1
    //   1333: iconst_0
    //   1334: invokevirtual 906	com/tencent/av/ui/VideoLayerUI:b	(JZZ)Z
    //   1337: pop
    //   1338: aload_0
    //   1339: getfield 595	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   1342: lload 9
    //   1344: aload 19
    //   1346: iconst_1
    //   1347: iconst_1
    //   1348: iconst_0
    //   1349: iload 15
    //   1351: invokevirtual 1388	com/tencent/av/ui/VideoLayerUI:a	(JLjava/lang/String;IZZZ)V
    //   1354: goto -820 -> 534
    //   1357: iload 18
    //   1359: ifeq +18 -> 1377
    //   1362: aload_0
    //   1363: getfield 595	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   1366: lload 9
    //   1368: iconst_1
    //   1369: iconst_0
    //   1370: invokevirtual 906	com/tencent/av/ui/VideoLayerUI:b	(JZZ)Z
    //   1373: pop
    //   1374: goto -840 -> 534
    //   1377: iload 16
    //   1379: ifeq -845 -> 534
    //   1382: aload_0
    //   1383: getfield 595	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   1386: lload 9
    //   1388: aload 19
    //   1390: iconst_1
    //   1391: iconst_1
    //   1392: iconst_0
    //   1393: iload 15
    //   1395: invokevirtual 1388	com/tencent/av/ui/VideoLayerUI:a	(JLjava/lang/String;IZZZ)V
    //   1398: goto -864 -> 534
    //   1401: aload 21
    //   1403: getfield 1828	lid:ah	Z
    //   1406: ifne -872 -> 534
    //   1409: aload_0
    //   1410: getfield 125	com/tencent/av/ui/AVActivity:jdField_f_of_type_Boolean	Z
    //   1413: ifne -879 -> 534
    //   1416: aload 21
    //   1418: lload 9
    //   1420: iconst_1
    //   1421: invokevirtual 914	lid:a	(JZ)V
    //   1424: aload_0
    //   1425: getfield 903	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvCameraCameraUtils	Lcom/tencent/av/camera/CameraUtils;
    //   1428: lload 9
    //   1430: invokevirtual 2596	com/tencent/av/camera/CameraUtils:a	(J)V
    //   1433: aload_0
    //   1434: getfield 595	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   1437: ifnull -903 -> 534
    //   1440: aload_0
    //   1441: getfield 595	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   1444: lload 9
    //   1446: iconst_1
    //   1447: iconst_0
    //   1448: invokevirtual 906	com/tencent/av/ui/VideoLayerUI:b	(JZZ)Z
    //   1451: pop
    //   1452: goto -918 -> 534
    //   1455: aload 21
    //   1457: getfield 518	lid:jdField_d_of_type_Int	I
    //   1460: iconst_4
    //   1461: if_icmpne -927 -> 534
    //   1464: aload 21
    //   1466: getfield 1361	lid:jdField_c_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   1469: astore 23
    //   1471: aload 23
    //   1473: new 2698	mdm
    //   1476: dup
    //   1477: aload_0
    //   1478: invokespecial 2699	mdm:<init>	(Lcom/tencent/av/ui/AVActivity;)V
    //   1481: invokestatic 2705	java/util/Collections:sort	(Ljava/util/List;Ljava/util/Comparator;)V
    //   1484: aload_0
    //   1485: getfield 141	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvVideoController	Lcom/tencent/av/VideoController;
    //   1488: invokevirtual 2407	com/tencent/av/VideoController:g	()I
    //   1491: istore 4
    //   1493: iconst_0
    //   1494: istore_3
    //   1495: iload_3
    //   1496: aload 23
    //   1498: invokevirtual 1366	java/util/ArrayList:size	()I
    //   1501: if_icmpge -967 -> 534
    //   1504: aload 23
    //   1506: iload_3
    //   1507: invokevirtual 1370	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1510: checkcast 1372	lqq
    //   1513: astore 24
    //   1515: aload 24
    //   1517: getfield 1373	lqq:jdField_a_of_type_Long	J
    //   1520: invokestatic 1378	mto:a	(J)Ljava/lang/String;
    //   1523: astore 25
    //   1525: aload 24
    //   1527: getfield 1379	lqq:jdField_a_of_type_Int	I
    //   1530: istore 5
    //   1532: aload 24
    //   1534: getfield 2706	lqq:jdField_a_of_type_Boolean	Z
    //   1537: istore 16
    //   1539: aload_0
    //   1540: getfield 595	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   1543: ifnull +371 -> 1914
    //   1546: aload_0
    //   1547: getfield 595	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   1550: aload 25
    //   1552: iload 5
    //   1554: invokevirtual 2709	com/tencent/av/ui/VideoLayerUI:a	(Ljava/lang/String;I)Z
    //   1557: istore 15
    //   1559: aload_0
    //   1560: getfield 85	com/tencent/av/ui/AVActivity:jdField_d_of_type_Int	I
    //   1563: invokestatic 2712	mti:b	(I)I
    //   1566: istore 6
    //   1568: aload_0
    //   1569: getfield 139	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvAppVideoAppInterface	Lcom/tencent/av/app/VideoAppInterface;
    //   1572: iload 6
    //   1574: aload 25
    //   1576: aload 21
    //   1578: getfield 1639	lid:jdField_g_of_type_Long	J
    //   1581: invokestatic 1545	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1584: invokevirtual 2063	com/tencent/av/app/VideoAppInterface:getDisplayName	(ILjava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1587: astore 20
    //   1589: aload 24
    //   1591: getfield 2713	lqq:jdField_b_of_type_Boolean	Z
    //   1594: ifeq +126 -> 1720
    //   1597: aload 25
    //   1599: aload_0
    //   1600: getfield 139	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvAppVideoAppInterface	Lcom/tencent/av/app/VideoAppInterface;
    //   1603: invokevirtual 690	com/tencent/av/app/VideoAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1606: invokevirtual 1385	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1609: ifne +111 -> 1720
    //   1612: iload 16
    //   1614: ifeq +106 -> 1720
    //   1617: aload 24
    //   1619: getfield 2714	lqq:jdField_d_of_type_Boolean	Z
    //   1622: ifne +98 -> 1720
    //   1625: aload 20
    //   1627: invokestatic 2716	mto:a	(Ljava/lang/String;)I
    //   1630: bipush 20
    //   1632: if_icmple +561 -> 2193
    //   1635: new 231	java/lang/StringBuilder
    //   1638: dup
    //   1639: invokespecial 232	java/lang/StringBuilder:<init>	()V
    //   1642: aload 20
    //   1644: iconst_0
    //   1645: bipush 20
    //   1647: invokestatic 2719	mto:a	(Ljava/lang/String;II)Ljava/lang/String;
    //   1650: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1653: ldc_w 2721
    //   1656: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1659: invokevirtual 250	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1662: astore 19
    //   1664: iload 5
    //   1666: iconst_2
    //   1667: if_icmpne +269 -> 1936
    //   1670: aload_0
    //   1671: ldc_w 2722
    //   1674: invokevirtual 2723	com/tencent/av/ui/AVActivity:getString	(I)Ljava/lang/String;
    //   1677: iconst_1
    //   1678: anewarray 1290	java/lang/Object
    //   1681: dup
    //   1682: iconst_0
    //   1683: aload 19
    //   1685: aastore
    //   1686: invokestatic 2727	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1689: astore 19
    //   1691: aload_0
    //   1692: getfield 515	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoControlUI	Lcom/tencent/av/ui/VideoControlUI;
    //   1695: ifnull +225 -> 1920
    //   1698: aload_0
    //   1699: getfield 515	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoControlUI	Lcom/tencent/av/ui/VideoControlUI;
    //   1702: instanceof 2729
    //   1705: ifeq +215 -> 1920
    //   1708: aload_0
    //   1709: getfield 515	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoControlUI	Lcom/tencent/av/ui/VideoControlUI;
    //   1712: sipush 1036
    //   1715: aload 19
    //   1717: invokevirtual 2732	com/tencent/av/ui/VideoControlUI:a	(ILjava/lang/String;)V
    //   1720: aload_0
    //   1721: getfield 595	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   1724: ifnull +183 -> 1907
    //   1727: aload_0
    //   1728: invokespecial 373	com/tencent/av/ui/AVActivity:k	()V
    //   1731: aload 24
    //   1733: getfield 2713	lqq:jdField_b_of_type_Boolean	Z
    //   1736: ifne +381 -> 2117
    //   1739: aload 24
    //   1741: getfield 2706	lqq:jdField_a_of_type_Boolean	Z
    //   1744: ifne +373 -> 2117
    //   1747: iload 4
    //   1749: iconst_4
    //   1750: if_icmpeq +337 -> 2087
    //   1753: aload 21
    //   1755: getfield 2735	lid:E	I
    //   1758: iconst_2
    //   1759: if_icmpne +246 -> 2005
    //   1762: aconst_null
    //   1763: ldc_w 1170
    //   1766: ldc_w 412
    //   1769: ldc_w 412
    //   1772: ldc_w 2737
    //   1775: ldc_w 2737
    //   1778: iconst_0
    //   1779: iconst_0
    //   1780: ldc_w 412
    //   1783: ldc_w 412
    //   1786: ldc_w 412
    //   1789: ldc_w 412
    //   1792: invokestatic 1178	azqs:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1795: aload_0
    //   1796: getfield 595	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   1799: lload 9
    //   1801: aload 25
    //   1803: iload 5
    //   1805: aload_0
    //   1806: getfield 145	com/tencent/av/ui/AVActivity:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   1809: aload 24
    //   1811: getfield 2713	lqq:jdField_b_of_type_Boolean	Z
    //   1814: aload 24
    //   1816: getfield 2706	lqq:jdField_a_of_type_Boolean	Z
    //   1819: invokevirtual 2740	com/tencent/av/ui/VideoLayerUI:a	(JLjava/lang/String;ILandroid/graphics/Bitmap;ZZ)V
    //   1822: iload 15
    //   1824: ifne +83 -> 1907
    //   1827: aload 21
    //   1829: getfield 1488	lid:J	Z
    //   1832: ifne +75 -> 1907
    //   1835: ldc_w 2741
    //   1838: fstore_2
    //   1839: fload_2
    //   1840: fstore_1
    //   1841: aload_0
    //   1842: getfield 595	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   1845: aload 25
    //   1847: iload 5
    //   1849: invokevirtual 2743	com/tencent/av/ui/VideoLayerUI:b	(Ljava/lang/String;I)Z
    //   1852: ifeq +20 -> 1872
    //   1855: fload_2
    //   1856: fstore_1
    //   1857: aload_0
    //   1858: getfield 595	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   1861: invokevirtual 859	com/tencent/av/ui/VideoLayerUI:f	()I
    //   1864: iconst_3
    //   1865: if_icmpeq +7 -> 1872
    //   1868: ldc_w 2744
    //   1871: fstore_1
    //   1872: aload_0
    //   1873: invokevirtual 576	com/tencent/av/ui/AVActivity:getApplicationContext	()Landroid/content/Context;
    //   1876: fload_1
    //   1877: invokestatic 2747	mww:a	(Landroid/content/Context;F)F
    //   1880: fstore_1
    //   1881: aload_0
    //   1882: getfield 595	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   1885: aload 25
    //   1887: iload 5
    //   1889: aload 20
    //   1891: fload_1
    //   1892: iconst_m1
    //   1893: invokevirtual 2750	com/tencent/av/ui/VideoLayerUI:a	(Ljava/lang/String;ILjava/lang/String;FI)V
    //   1896: aload_0
    //   1897: getfield 595	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   1900: aload 25
    //   1902: iload 5
    //   1904: invokevirtual 2751	com/tencent/av/ui/VideoLayerUI:a	(Ljava/lang/String;I)V
    //   1907: iload_3
    //   1908: iconst_1
    //   1909: iadd
    //   1910: istore_3
    //   1911: goto -416 -> 1495
    //   1914: iconst_0
    //   1915: istore 15
    //   1917: goto -358 -> 1559
    //   1920: aload_0
    //   1921: getfield 139	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvAppVideoAppInterface	Lcom/tencent/av/app/VideoAppInterface;
    //   1924: sipush 1036
    //   1927: aload 19
    //   1929: invokestatic 2754	mdd:a	(Lcom/tencent/av/app/VideoAppInterface;ILjava/lang/String;)Z
    //   1932: pop
    //   1933: goto -213 -> 1720
    //   1936: aload_0
    //   1937: ldc_w 2755
    //   1940: invokevirtual 2723	com/tencent/av/ui/AVActivity:getString	(I)Ljava/lang/String;
    //   1943: iconst_1
    //   1944: anewarray 1290	java/lang/Object
    //   1947: dup
    //   1948: iconst_0
    //   1949: aload 19
    //   1951: aastore
    //   1952: invokestatic 2727	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1955: astore 19
    //   1957: aload_0
    //   1958: getfield 515	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoControlUI	Lcom/tencent/av/ui/VideoControlUI;
    //   1961: ifnull +28 -> 1989
    //   1964: aload_0
    //   1965: getfield 515	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoControlUI	Lcom/tencent/av/ui/VideoControlUI;
    //   1968: instanceof 2729
    //   1971: ifeq +18 -> 1989
    //   1974: aload_0
    //   1975: getfield 515	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoControlUI	Lcom/tencent/av/ui/VideoControlUI;
    //   1978: sipush 1037
    //   1981: aload 19
    //   1983: invokevirtual 2732	com/tencent/av/ui/VideoControlUI:a	(ILjava/lang/String;)V
    //   1986: goto -266 -> 1720
    //   1989: aload_0
    //   1990: getfield 139	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvAppVideoAppInterface	Lcom/tencent/av/app/VideoAppInterface;
    //   1993: sipush 1037
    //   1996: aload 19
    //   1998: invokestatic 2754	mdd:a	(Lcom/tencent/av/app/VideoAppInterface;ILjava/lang/String;)Z
    //   2001: pop
    //   2002: goto -282 -> 1720
    //   2005: aload 21
    //   2007: getfield 1270	lid:jdField_C_of_type_Int	I
    //   2010: bipush 10
    //   2012: if_icmpne +39 -> 2051
    //   2015: aconst_null
    //   2016: ldc_w 1170
    //   2019: ldc_w 412
    //   2022: ldc_w 412
    //   2025: ldc_w 2757
    //   2028: ldc_w 2757
    //   2031: iconst_0
    //   2032: iconst_0
    //   2033: ldc_w 412
    //   2036: ldc_w 412
    //   2039: ldc_w 412
    //   2042: ldc_w 412
    //   2045: invokestatic 1178	azqs:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2048: goto -253 -> 1795
    //   2051: aconst_null
    //   2052: ldc_w 1170
    //   2055: ldc_w 412
    //   2058: ldc_w 412
    //   2061: ldc_w 2759
    //   2064: ldc_w 2759
    //   2067: iconst_0
    //   2068: iconst_0
    //   2069: ldc_w 412
    //   2072: ldc_w 412
    //   2075: ldc_w 412
    //   2078: ldc_w 412
    //   2081: invokestatic 1178	azqs:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2084: goto -289 -> 1795
    //   2087: aload_0
    //   2088: getfield 595	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   2091: lload 9
    //   2093: aload 25
    //   2095: iload 5
    //   2097: aload_0
    //   2098: getfield 147	com/tencent/av/ui/AVActivity:jdField_b_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   2101: aload 24
    //   2103: getfield 2713	lqq:jdField_b_of_type_Boolean	Z
    //   2106: aload 24
    //   2108: getfield 2706	lqq:jdField_a_of_type_Boolean	Z
    //   2111: invokevirtual 2740	com/tencent/av/ui/VideoLayerUI:a	(JLjava/lang/String;ILandroid/graphics/Bitmap;ZZ)V
    //   2114: goto -292 -> 1822
    //   2117: aload_0
    //   2118: getfield 595	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   2121: lload 9
    //   2123: aload 25
    //   2125: iload 5
    //   2127: aload_0
    //   2128: getfield 147	com/tencent/av/ui/AVActivity:jdField_b_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   2131: aload 24
    //   2133: getfield 2713	lqq:jdField_b_of_type_Boolean	Z
    //   2136: aload 24
    //   2138: getfield 2706	lqq:jdField_a_of_type_Boolean	Z
    //   2141: invokevirtual 2740	com/tencent/av/ui/VideoLayerUI:a	(JLjava/lang/String;ILandroid/graphics/Bitmap;ZZ)V
    //   2144: goto -322 -> 1822
    //   2147: aload_0
    //   2148: getfield 139	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvAppVideoAppInterface	Lcom/tencent/av/app/VideoAppInterface;
    //   2151: sipush 1023
    //   2154: ldc_w 2760
    //   2157: invokestatic 559	mdd:a	(Lcom/tencent/av/app/VideoAppInterface;II)Z
    //   2160: pop
    //   2161: ldc_w 2762
    //   2164: invokestatic 894	mqj:a	(Ljava/lang/String;)V
    //   2167: goto -1302 -> 865
    //   2170: invokestatic 1246	lvt:a	()Llvt;
    //   2173: iconst_1
    //   2174: invokevirtual 2648	lvt:b	(I)V
    //   2177: goto -1227 -> 950
    //   2180: ldc2_w 2307
    //   2183: lstore 7
    //   2185: goto -1205 -> 980
    //   2188: astore 19
    //   2190: goto -1279 -> 911
    //   2193: aload 20
    //   2195: astore 19
    //   2197: goto -533 -> 1664
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2200	0	this	AVActivity
    //   1840	52	1	f1	float
    //   1838	18	2	f2	float
    //   1494	417	3	i1	int
    //   1491	260	4	i2	int
    //   1530	596	5	i3	int
    //   1566	7	6	i4	int
    //   978	1206	7	l1	long
    //   8	2114	9	l2	long
    //   953	34	11	l3	long
    //   961	28	13	l4	long
    //   412	1504	15	bool1	boolean
    //   394	1219	16	bool2	boolean
    //   419	70	17	bool3	boolean
    //   426	932	18	bool4	boolean
    //   304	790	19	localObject1	Object
    //   1248	141	19	localIllegalArgumentException	java.lang.IllegalArgumentException
    //   1662	335	19	str1	String
    //   2188	1	19	localException	Exception
    //   2195	1	19	localObject2	Object
    //   436	1758	20	str2	String
    //   85	1921	21	locallid	lid
    //   165	816	22	locallkz	lkz
    //   1469	36	23	localArrayList	ArrayList
    //   1513	624	24	locallqq	lqq
    //   1523	601	25	str3	String
    // Exception table:
    //   from	to	target	type
    //   70	79	1248	java/lang/IllegalArgumentException
    //   904	911	2188	java/lang/Exception
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
    lid locallid = lfb.a().a();
    lkx.a(20, 1L);
    if ((locallid != null) && (locallid.k())) {
      lkx.a(31);
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
    if ((this.jdField_a_of_type_ComTencentAvVideoController.a().B) && (this.jdField_a_of_type_Mlf != null))
    {
      this.jdField_a_of_type_Mlf.c();
      if (this.jdField_a_of_type_Mlf.b() < 1000L) {
        break label278;
      }
    }
    label278:
    for (int i1 = 1;; i1 = 2)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a().u = i1;
      azqs.b(null, "CliOper", "", "", "0X800863D", "0X800863D", 0, 0, "", "", "", "");
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
    if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_C_of_type_Int == 2)) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.ui.AVActivity
 * JD-Core Version:    0.7.0.1
 */