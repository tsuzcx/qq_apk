package com.tencent.av.ui;

import aciy;
import aluq;
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
import apdh;
import awqx;
import bach;
import baig;
import bavz;
import bawf;
import bbqo;
import begr;
import bjeh;
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
import krx;
import ksn;
import ksu;
import kur;
import kvq;
import kvr;
import kvw;
import kxi;
import kya;
import kyj;
import kyl;
import kzi;
import kzq;
import lad;
import lal;
import lbn;
import leb;
import lfi;
import lja;
import ljb;
import llm;
import loj;
import lor;
import lqb;
import lqi;
import lqj;
import lql;
import lqm;
import lqn;
import lqo;
import lqp;
import lqq;
import lqr;
import lqs;
import lqu;
import lqx;
import lqy;
import lrn;
import lrs;
import lru;
import lry;
import lrz;
import ltq;
import lwq;
import lxz;
import max;
import mbo;
import mbt;
import mct;
import med;
import mez;
import mfy;
import mga;
import mhr;
import mhs;
import mht;
import mjg;
import mqq.app.BaseActivity;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import zqa;

public class AVActivity
  extends BaseActivity
  implements SensorEventListener, kzi, ljb
{
  public int a;
  long jdField_a_of_type_Long = 0L;
  Dialog jdField_a_of_type_AndroidAppDialog = null;
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = null;
  public Bitmap a;
  private Sensor jdField_a_of_type_AndroidHardwareSensor;
  private SensorManager jdField_a_of_type_AndroidHardwareSensorManager;
  Handler jdField_a_of_type_AndroidOsHandler = new lqo(this);
  private MessageQueue.IdleHandler jdField_a_of_type_AndroidOsMessageQueue$IdleHandler = new lqi(this);
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = null;
  public RelativeLayout a;
  public bawf a;
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
  kur jdField_a_of_type_Kur = new lqq(this);
  kvw jdField_a_of_type_Kvw = new lqx(this);
  kzq jdField_a_of_type_Kzq = new lqr(this);
  private lal jdField_a_of_type_Lal = new lal();
  private loj jdField_a_of_type_Loj;
  lqy jdField_a_of_type_Lqy = null;
  public lrn a;
  private lrs jdField_a_of_type_Lrs;
  public lru a;
  public lwq a;
  public lxz a;
  public max a;
  public mbo a;
  private mhs jdField_a_of_type_Mhs;
  mht jdField_a_of_type_Mht = null;
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
    this.jdField_a_of_type_Max = null;
    this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    this.jdField_b_of_type_AndroidGraphicsBitmap = null;
    this.jdField_h_of_type_Int = 0;
    this.jdField_a_of_type_Lru = new lqu(this);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(this);
    this.jdField_a_of_type_ComTencentAvUiGuideGuideHelper = new GuideHelper();
    this.jdField_a_of_type_Bawf = new lqj(this);
    this.jdField_k_of_type_Boolean = false;
    this.jdField_m_of_type_Boolean = false;
    this.mIsShadow = false;
    this.jdField_b_of_type_JavaLangString = ("AVActivity_" + AudioHelper.b());
  }
  
  private String a(Intent paramIntent)
  {
    int i3 = paramIntent.getIntExtra("uinType", -1);
    int i2 = mjg.b(i3);
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
      return ksn.a(i1, paramIntent, new int[0]);
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
    bjeh.a(paramActivity);
    if (bjeh.b())
    {
      int i1 = bjeh.b(paramActivity);
      int i2 = ImmersiveUtils.getStatusBarHeight(paramActivity);
      QLog.w(ImmersiveUtils.jdField_a_of_type_JavaLangString, 1, "initLiuHaiProperty, onAttachedToWindow, notchheight[" + i1 + "], statusBarHeight[" + i2 + "]");
      if (bjeh.c(paramActivity))
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
        kvq localkvq;
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
              localkvq = this.jdField_a_of_type_ComTencentAvVideoController.a();
              i1 = localkvq.jdField_d_of_type_Int;
              if (QLog.isDevelopLevel()) {
                QLog.w(this.jdField_b_of_type_JavaLangString, 1, "SwitchToolbar, sessionType[" + i1 + "], isInviting[" + localkvq.f() + "], isToolBarDisplay[" + this.jdField_a_of_type_ComTencentAvUiVideoControlUI.h() + "|" + this.jdField_a_of_type_ComTencentAvUiVideoControlUI.jdField_h_of_type_Boolean + "], seq[" + paramLong + "]");
              }
              if ((i1 != 1) && (i1 != 3)) {
                break;
              }
            } while ((!this.jdField_a_of_type_ComTencentAvUiVideoControlUI.a.b(1)) && (!this.jdField_a_of_type_ComTencentAvUiVideoControlUI.a.b(3)));
            this.jdField_a_of_type_ComTencentAvUiVideoControlUI.a.a(paramLong, 0, true);
            return;
            if (!localkvq.f()) {
              break;
            }
          } while ((i1 != 2) || ((!this.jdField_a_of_type_ComTencentAvUiVideoControlUI.a.b(1)) && (!this.jdField_a_of_type_ComTencentAvUiVideoControlUI.a.b(3))));
          this.jdField_a_of_type_ComTencentAvUiVideoControlUI.a.a(paramLong, 0, true);
          return;
        } while ((this.jdField_a_of_type_Lrn != null) && (this.jdField_a_of_type_Lrn.a()));
        if ((!localkvq.jdField_A_of_type_Boolean) || (this.jdField_a_of_type_ComTencentAvUiVideoControlUI.h())) {
          break;
        }
      } while (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null);
      lqb.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1022, 2131630356);
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
      this.jdField_b_of_type_AndroidGraphicsBitmap = mjg.a(getApplicationContext(), 2130841373);
    }
  }
  
  private void k()
  {
    View localView = findViewById(2131306805);
    if ((localView != null) && (this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch == null)) {
      ThreadManager.getSubThreadHandler().post(new AVActivity.9(this, localView));
    }
  }
  
  private void l()
  {
    if (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) {}
    do
    {
      return;
      View localView = super.findViewById(2131297390);
      this.jdField_a_of_type_ComTencentAvUiVideoLayerUI = new VideoLayerUI(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this, localView);
      this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(a());
      this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(new lqp(this));
    } while (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI == null);
    this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(this.jdField_a_of_type_Lxz);
  }
  
  public void BtnOnClick(View paramView)
  {
    long l1 = AudioHelper.b();
    QLog.d(this.jdField_b_of_type_JavaLangString, 1, "BtnOnClick, id[" + ltq.a(paramView.getId()) + "], nfonWindowFocus[" + this.jdField_j_of_type_Boolean + "], seq[" + l1 + "]");
    if (!this.jdField_j_of_type_Boolean) {}
    for (;;)
    {
      return;
      if ((this.jdField_a_of_type_Lrn != null) && (this.jdField_a_of_type_Lrn.a())) {
        this.jdField_a_of_type_Lrn.a(paramView);
      }
      while ((paramView.getId() == 2131306805) && (this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch != null))
      {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch, "105000.105100");
        this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = null;
        return;
        if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI != null)
        {
          this.jdField_a_of_type_ComTencentAvUiVideoControlUI.y(l1);
          mga.c(paramView.getId());
          this.jdField_a_of_type_ComTencentAvUiVideoControlUI.a(l1, paramView);
          e(l1);
        }
      }
    }
  }
  
  public void TestMenuBtnOnClick(View paramView)
  {
    paramView = new PopupMenu(this, paramView);
    mez.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface).a(paramView);
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
    SharedPreferences localSharedPreferences = baig.a(getApplicationContext());
    String str = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
    return localSharedPreferences.getInt("showRecordTip" + String.valueOf(str), 0);
  }
  
  View a(long paramLong)
  {
    if ((this.jdField_a_of_type_Mhs == null) || (!this.n))
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
    Object localObject = findViewById(2131306805);
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
    ImageView localImageView = (ImageView)findViewById(2131306684);
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
    QLog.i(this.jdField_b_of_type_JavaLangString, 1, "MoreBtnTips. showTips. mMoreBtnTipsImageDownloaded = " + this.n + ", mMoreBtnTips = " + this.jdField_a_of_type_Mhs);
    localImageView.setImageDrawable(this.jdField_a_of_type_ComTencentImageURLDrawable);
    int i1 = aciy.a(10.0F, getResources());
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
  
  public loj a()
  {
    return this.jdField_a_of_type_Loj;
  }
  
  void a()
  {
    if (this.jdField_a_of_type_Lqy == null) {
      this.jdField_a_of_type_Lqy = new lqy(this, super.getApplicationContext(), 2);
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
    if ((this.jdField_a_of_type_ComTencentAvUiVideoControlUI instanceof DoubleVideoCtrlUI)) {
      ((DoubleVideoCtrlUI)this.jdField_a_of_type_ComTencentAvUiVideoControlUI).a(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.i(), c());
    }
    this.jdField_a_of_type_ComTencentAvUiVideoControlUI.y(l1);
    this.jdField_a_of_type_ComTencentAvUiVideoControlUI.f(l1, 65535);
    if (this.jdField_a_of_type_Lxz != null)
    {
      this.jdField_a_of_type_Lxz.a(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.i(), this.jdField_a_of_type_ComTencentAvUiVideoControlUI, this.jdField_a_of_type_Lxz.c());
      this.jdField_a_of_type_Lxz.a(this.jdField_a_of_type_Lxz.c());
      this.jdField_a_of_type_Lxz.b(this.jdField_a_of_type_Lxz.c());
    }
    if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_A_of_type_Boolean) && (!this.jdField_a_of_type_ComTencentAvVideoController.a().H)) {
      mct.a("0X8008ABA");
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
      while (this.jdField_a_of_type_Mbo != null)
      {
        this.jdField_a_of_type_Mbo.b();
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
      localObject = findViewById(2131306801);
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
      if (this.jdField_a_of_type_Mbo != null)
      {
        i4 = this.jdField_a_of_type_Mbo.a();
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
          if ((this.jdField_a_of_type_Mbo == null) || (paramInt == 1)) {
            break;
          }
          this.jdField_a_of_type_Mbo.b(i6);
          return;
          if ((i5 != 0) || (!bjeh.b())) {
            break label510;
          }
        }
      }
      label447:
      label510:
      for (i1 = bjeh.b(this);; i1 = 0)
      {
        localObject = this.jdField_a_of_type_ComTencentAvVideoController.a();
        if ((((kvq)localObject).v()) && ((((kvq)localObject).jdField_A_of_type_Boolean) || (((kvq)localObject).jdField_B_of_type_Boolean)) && (this.jdField_a_of_type_Lxz != null) && (!this.jdField_a_of_type_Lxz.d()))
        {
          i2 = this.jdField_a_of_type_Lxz.c();
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
    if ((paramInt1 == 2131306805) && (paramInt3 == 0))
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
      if (this.jdField_a_of_type_Lxz != null)
      {
        this.jdField_a_of_type_Lxz.d(paramInt);
        this.jdField_a_of_type_Lxz.d();
        this.jdField_a_of_type_Lxz.a(this.jdField_a_of_type_ComTencentAvUiVideoControlUI, this.jdField_h_of_type_Int);
      }
    } while ((!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_A_of_type_Boolean) && (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_B_of_type_Boolean));
    g(paramLong);
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    QLog.i(this.jdField_b_of_type_JavaLangString, 1, "MoreBtnTips. tryShow_qav_more_tips. mMoreBtnTipsImageDownloaded = " + this.n + ", mMoreBtnTips = " + this.jdField_a_of_type_Mhs + ", delayMillis = " + paramLong2);
    if (this.jdField_a_of_type_Mhs != null)
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
    Intent localIntent = aciy.a(new Intent(super.getApplicationContext(), SplashActivity.class), null);
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
      paramInt = lor.a(paramString1.jdField_I_of_type_Int);
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
        paramBoolean = this.jdField_a_of_type_Lxz.i();
        boolean bool = lxz.f();
        if ((!paramBoolean) || (!bool)) {
          break;
        }
        mct.a("0X8008AB2");
      }
      return;
    }
    mct.a("0X8008AB1");
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentAvVideoController.a();
    QLog.w(this.jdField_b_of_type_JavaLangString, 1, "avideo onCreateUI, SessionType[" + ((kvq)localObject1).jdField_d_of_type_Int + "], seq[" + paramLong + "]");
    mez.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this);
    Object localObject2 = this.jdField_a_of_type_ComTencentAvVideoController.a(getApplicationContext());
    if (localObject2 != null) {
      ((lfi)localObject2).a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    }
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131306537));
    }
    this.jdField_a_of_type_JavaLangRunnable = new AVActivity.5(this);
    if (this.jdField_a_of_type_ComTencentAvCameraCameraUtils == null)
    {
      this.jdField_a_of_type_ComTencentAvCameraCameraUtils = CameraUtils.a(this);
      this.jdField_a_of_type_ComTencentAvCameraCameraUtils.a(this.jdField_a_of_type_Kzq);
      this.jdField_a_of_type_ComTencentAvCameraCameraUtils.a(this.jdField_a_of_type_ComTencentAvVideoController);
    }
    localObject2 = super.findViewById(2131297390).findViewById(2131297387);
    try
    {
      ((View)localObject2).setBackgroundResource(2130841514);
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
        this.jdField_a_of_type_Mhs = mhr.a(i1);
        if ((this.jdField_a_of_type_Mhs != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_Mhs.jdField_a_of_type_JavaLangString)))
        {
          localObject2 = URLDrawable.URLDrawableOptions.obtain();
          this.jdField_a_of_type_ComTencentImageURLDrawable = URLDrawable.getDrawable(this.jdField_a_of_type_Mhs.jdField_a_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject2);
          this.n = false;
          this.jdField_a_of_type_ComTencentImageURLDrawable.setURLDrawableListener(new lqs(this));
          this.jdField_a_of_type_ComTencentImageURLDrawable.startDownload();
          if (1 == this.jdField_a_of_type_ComTencentImageURLDrawable.getStatus())
          {
            paramBoolean = true;
            this.n = paramBoolean;
            awqx.b(null, "CliOper", "", "", "0X800A75E", "0X800A75E", i1, this.jdField_a_of_type_Mhs.jdField_a_of_type_Int, "", "", "", "");
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
              ((DoubleVideoCtrlUI)localObject2).a(2131306520, this.jdField_a_of_type_ComTencentAvVideoController.o, 2130841430);
              if (!this.jdField_a_of_type_ComTencentAvVideoController.q) {
                ((DoubleVideoCtrlUI)localObject2).a.a(true, 0, false);
              }
            }
          }
          if ((((kvq)localObject1).jdField_g_of_type_Int != 4) && (((kvq)localObject1).v()) && (!this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_Int == 1) && (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) && (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getParent() != null))
          {
            i1 = mbt.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, ((kvq)localObject1).jdField_d_of_type_JavaLangString, true, true);
            if ((i1 > 0) && (this.jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView == null)) {
              this.jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView = bavz.a(this, (RelativeLayout)this.jdField_a_of_type_AndroidWidgetRelativeLayout.getParent(), false);
            }
            i2 = bavz.a();
            localObject1 = bavz.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, i1, i2, null);
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
          this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView = ((QavRecordButtonView)findViewById(2131309242));
          a(paramLong, "onCreateUI", false);
          if (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) {
            this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.k(0);
          }
          localObject1 = (RelativeLayout)findViewById(2131313234);
          if ((localObject1 != null) && (lxz.f()))
          {
            this.jdField_a_of_type_Lxz = new lxz(this, (RelativeLayout)localObject1, this.jdField_a_of_type_ComTencentAvVideoController, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_ComTencentAvUiVideoControlUI);
            this.jdField_a_of_type_Lxz.c(1);
            if (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) {
              this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(this.jdField_a_of_type_Lxz);
            }
          }
          k();
          lja.a().a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this);
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
          this.jdField_a_of_type_ComTencentAvUiVideoControlUI = new DoubleVideoMeetingCtrlUI(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_Lru);
          this.jdField_b_of_type_Int = ((kvq)localObject1).jdField_d_of_type_Int;
        }
        for (;;)
        {
          this.jdField_a_of_type_ComTencentAvUiVideoControlUI.m(this.jdField_a_of_type_ComTencentAvCameraCameraUtils.a());
          break;
          label963:
          this.jdField_a_of_type_ComTencentAvUiVideoControlUI = new DoubleVideoCtrlUI(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_Lru);
        }
        this.jdField_a_of_type_ComTencentAvUiVideoControlUI = new DoubleVideoCtrlUI(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_Lru);
        this.jdField_a_of_type_ComTencentAvUiVideoControlUI.m(this.jdField_a_of_type_ComTencentAvCameraCameraUtils.a());
        continue;
        if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI == null)
        {
          if (!this.jdField_g_of_type_Boolean) {
            break label1095;
          }
          this.jdField_a_of_type_ComTencentAvUiVideoControlUI = new DoubleVideoMeetingCtrlUI(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_Lru);
          this.jdField_b_of_type_Int = ((kvq)localObject1).jdField_d_of_type_Int;
        }
        for (;;)
        {
          this.jdField_a_of_type_ComTencentAvUiVideoControlUI.m(this.jdField_a_of_type_ComTencentAvCameraCameraUtils.a());
          break;
          label1095:
          if (((kvq)localObject1).jdField_A_of_type_Int == 1)
          {
            this.jdField_a_of_type_ComTencentAvUiVideoControlUI = new MultiVideoCtrlLayerUI4Discussion(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_Lru);
          }
          else if (((kvq)localObject1).jdField_A_of_type_Int == 10)
          {
            this.jdField_a_of_type_ComTencentAvUiVideoControlUI = new MultiVideoCtrlLayerUI4NewGroupChat(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_Lru);
          }
          else
          {
            if (QLog.isColorLevel()) {
              QLog.d(this.jdField_b_of_type_JavaLangString, 2, "OnCreateUI --> Not Set MultiAVType");
            }
            this.jdField_a_of_type_ComTencentAvUiVideoControlUI = new MultiVideoCtrlLayerUI4Discussion(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_Lru);
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
    krx.c(this.jdField_b_of_type_JavaLangString, "notifyEvent :" + paramInteger + "|" + paramObject1 + "|" + paramObject2);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { paramInteger, paramObject1, paramObject2 });
  }
  
  public void a(String paramString)
  {
    kxi localkxi = (kxi)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(3);
    FaceItem localFaceItem = localkxi.a(paramString);
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
        new lrz(l1, localFaceItem.getId(), true, 2).a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
        VoiceRecogTips.b(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramString);
        awqx.b(null, "CliOper", "", "", "0X800984F", "0X800984F", 0, 0, "", "", "", localFaceItem.getId());
        return;
      }
      localkxi.a(l1, localFaceItem);
      return;
    }
    QLog.i(this.jdField_b_of_type_JavaLangString, 1, "onAVVoiceRecogComplete. recogResult = " + paramString + ", paly voice sticker falied. voiceStickerItem == null.");
  }
  
  void a(String paramString, long paramLong)
  {
    View localView = findViewById(2131306684);
    if (localView == null) {}
    do
    {
      do
      {
        return;
      } while (localView.getVisibility() != 0);
      localView.setVisibility(4);
      QLog.w(this.jdField_b_of_type_JavaLangString, 1, "MoreBtnTips. hide_qav_more_tips. from[" + paramString + "], seq[" + paramLong + "]");
    } while (this.jdField_a_of_type_Mhs == null);
    mhr.a(this.jdField_a_of_type_Mhs.jdField_a_of_type_Int);
    this.jdField_a_of_type_Mhs = null;
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
    if (this.jdField_a_of_type_Lqy != null) {
      this.jdField_a_of_type_Lqy.enable();
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
        if ((this.jdField_a_of_type_Loj == null) || (this.jdField_a_of_type_Loj.a()))
        {
          if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 4)
          {
            ArrayList localArrayList = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList;
            int i1 = 0;
            if (i1 < localArrayList.size())
            {
              leb localleb = (leb)localArrayList.get(i1);
              String str = mfy.a(localleb.jdField_a_of_type_Long);
              int i2 = localleb.jdField_a_of_type_Int;
              if (localleb.jdField_b_of_type_Long == 5L) {}
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
        this.jdField_a_of_type_ComTencentAvUiVideoControlUI.k(paramLong);
      }
      if (this.jdField_a_of_type_Lrn != null) {
        this.jdField_a_of_type_Lrn.d();
      }
      f();
      this.jdField_a_of_type_ComTencentAvVideoController.a(true);
      this.jdField_a_of_type_ComTencentAvVideoController.i(false);
      if (this.jdField_a_of_type_Loj != null) {
        this.jdField_a_of_type_Loj.a(paramLong, this.jdField_e_of_type_Boolean);
      }
    } while (this.jdField_a_of_type_Mbo == null);
    this.jdField_a_of_type_Mbo.b();
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
      if ((!lxz.k()) && (this.jdField_a_of_type_Lxz != null)) {
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
            if ((i1 != 0) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_B_of_type_Boolean))
            {
              this.jdField_a_of_type_Lxz.d(this.jdField_h_of_type_Int);
              this.jdField_a_of_type_Lxz.d();
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
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_B_of_type_Boolean)
      {
        this.jdField_a_of_type_Lxz.d(0);
        this.jdField_a_of_type_Lxz.d();
        this.jdField_a_of_type_Lxz.k();
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
      lqb.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1043);
      return;
    }
    if (this.jdField_a_of_type_AndroidViewView$OnClickListener == null) {
      this.jdField_a_of_type_AndroidViewView$OnClickListener = new lqn(this, paramString, l1);
    }
    lqb.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1044, null, this.jdField_a_of_type_AndroidViewView$OnClickListener);
  }
  
  public void b(boolean paramBoolean)
  {
    VideoLayerUI.a(findViewById(2131297390), paramBoolean);
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
    if (this.jdField_a_of_type_Lqy != null) {
      this.jdField_a_of_type_Lqy.disable();
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
    kvq localkvq = this.jdField_a_of_type_ComTencentAvVideoController.a();
    int i3 = localkvq.jdField_d_of_type_Int;
    boolean bool = ((Intent)localObject3).getBooleanExtra("isDoubleVideoMeeting", false);
    this.jdField_g_of_type_Boolean = bool;
    Object localObject1 = ((Intent)localObject3).getStringExtra("Fromwhere");
    if ((localObject1 != null) && (((String)localObject1).compareTo("AVNotification") == 0))
    {
      if (((localkvq.jdField_g_of_type_Int == 2) || (localkvq.jdField_g_of_type_Int == 13)) && (i4 != 1) && (i4 != 2))
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_b_of_type_JavaLangString, 2, "Close Double Video Meeting. --> QAVNotification to MultiVideo");
        }
        if (localkvq.jdField_I_of_type_Boolean) {
          break label392;
        }
        this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, localkvq.jdField_d_of_type_JavaLangString, 1, true);
        this.jdField_a_of_type_ComTencentAvVideoController.a(localkvq.jdField_d_of_type_JavaLangString, 230);
        this.jdField_a_of_type_ComTencentAvVideoController.b(230);
      }
      if (localkvq.jdField_i_of_type_Int == 1)
      {
        if (localkvq.jdField_A_of_type_Int != 10) {
          break label430;
        }
        awqx.b(null, "CliOper", "", "", "0X8005930", "0X8005930", 0, 0, "", "", "", "");
      }
    }
    label392:
    long l1;
    for (;;)
    {
      if (bool) {
        awqx.b(null, "CliOper", "", "", "0X8005209", "0X8005209", 0, 0, "", "", "", "");
      }
      if (i4 != 0) {
        break label466;
      }
      krx.d(this.jdField_b_of_type_JavaLangString, "processExtraData-->can not get session type in intent.");
      ((kyl)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4)).a(localkvq.b(), 5, 1015L);
      finish();
      return;
      l1 = Long.valueOf(localkvq.jdField_d_of_type_JavaLangString).longValue();
      this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, 3, l1);
      this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, l1, 1);
      break;
      label430:
      awqx.b(null, "CliOper", "", "", "0X80046D7", "0X80046D7", 0, 0, "", "", "", "");
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
      str = localkvq.jdField_d_of_type_JavaLangString;
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
        krx.d(this.jdField_b_of_type_JavaLangString, "processExtraData-->can not get uin in intent.");
        ((kyl)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4)).a(localkvq.b(), 5, 1016L);
        finish();
        return;
        if ((i4 != 3) && (i4 != 4)) {
          break label497;
        }
        str = ((Intent)localObject3).getStringExtra("GroupId");
        i1 = ((Intent)localObject3).getIntExtra("MeetingConfID", 0);
        i5 = ((Intent)localObject3).getIntExtra("ConfAppID", 0);
        int i6 = ((Intent)localObject3).getIntExtra("MeetingStasks", -1);
        localkvq.jdField_L_of_type_Int = i1;
        localkvq.M = i5;
        localkvq.N = i6;
        break label497;
        if ((i4 != 3) && (i4 != 4)) {
          break label2376;
        }
        if (bool)
        {
          str = localkvq.jdField_d_of_type_JavaLangString;
          continue;
        }
        str = String.valueOf(this.jdField_a_of_type_ComTencentAvVideoController.jdField_a_of_type_Long);
        continue;
      }
      if ((i3 == 1) || (i3 == 2))
      {
        localObject2 = localkvq.jdField_d_of_type_JavaLangString;
        i1 = mjg.b(localkvq.jdField_i_of_type_Int);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          krx.d(this.jdField_b_of_type_JavaLangString, "can not get the original peeruin");
          ((kyl)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4)).a(localkvq.b(), 5, 1016L);
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
          krx.d(this.jdField_b_of_type_JavaLangString, "can not get the original group uin");
          ((kyl)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4)).a(localkvq.b(), 5, 1016L);
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
        QLog.w(this.jdField_b_of_type_JavaLangString, 1, "processExtraData, mSessionType[" + this.jdField_b_of_type_Int + "], mUinType[" + this.jdField_d_of_type_Int + "], mPeerUin[" + this.jdField_c_of_type_JavaLangString + "], mPeerName[" + this.jdField_e_of_type_JavaLangString + "], mPhoneNum[" + this.jdField_f_of_type_JavaLangString + "], mSelfNation[" + this.jdField_g_of_type_JavaLangString + "], mSelfMobile[" + this.jdField_h_of_type_JavaLangString + "], mIsReceiver[" + this.jdField_a_of_type_Boolean + "], mIsAudioMode[" + this.jdField_b_of_type_Boolean + "], mExtraUin[" + this.jdField_i_of_type_JavaLangString + "], mIsPeerNetworkWell[" + this.jdField_c_of_type_Boolean + "], mIsFriend[" + this.jdField_d_of_type_Boolean + "], mFromWhere[" + this.jdField_j_of_type_JavaLangString + "], intentUinStr[" + str + "], \nsession[" + localkvq + "]");
        bach.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ArrayOfByte);
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
            str = ksn.a(3, this.jdField_c_of_type_JavaLangString, new int[0]);
            if (ksn.a().a(str)) {
              break;
            }
            localObject1 = ksn.a().a(str, false);
            ((kvq)localObject1).jdField_e_of_type_Boolean = false;
            ((kvq)localObject1).a("processExtraData", 0);
            ((kvq)localObject1).ae = false;
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
        localkvq.as = ((Intent)localObject3).getBooleanExtra("disableInvite", false);
        i2 = i3;
        if (localkvq.jdField_A_of_type_Int != 0)
        {
          i2 = i3;
          if (i5 != localkvq.jdField_A_of_type_Int)
          {
            i2 = i3;
            if (i5 != 0) {
              i2 = 1;
            }
          }
        }
        localkvq.a(i5);
        if (!bool) {
          if (this.jdField_a_of_type_ComTencentAvVideoController.l())
          {
            this.jdField_a_of_type_ComTencentAvVideoController.h(true);
            if (i2 != 0)
            {
              this.jdField_a_of_type_ComTencentAvVideoController.a(i1, this.jdField_a_of_type_ComTencentAvVideoController.jdField_a_of_type_Long, 99);
              localkvq.a(i5);
              localkvq.a(paramLong, "processExtraData.1", 3);
            }
            localkvq.jdField_B_of_type_Int = ((Intent)localObject3).getIntExtra("Type", -1);
            localkvq.jdField_g_of_type_Long = l1;
            this.jdField_d_of_type_JavaLangString = str;
            if (str.compareTo((String)localObject1) != 0) {
              break label1814;
            }
            if (i2 == 0) {
              break label1802;
            }
            this.jdField_b_of_type_Int = i4;
            i1 = ((Intent)localObject3).getIntExtra("uinType", -1);
            localkvq.jdField_i_of_type_Int = i1;
            this.jdField_d_of_type_Int = i1;
            this.jdField_i_of_type_JavaLangString = localkvq.jdField_f_of_type_JavaLangString;
            if (localkvq.jdField_B_of_type_Int == -1) {
              localkvq.jdField_B_of_type_Int = 0;
            }
            this.jdField_c_of_type_Boolean = localkvq.q;
            if (QLog.isColorLevel()) {
              QLog.d(this.jdField_b_of_type_JavaLangString, 2, "processExtraData multiAVType: " + localkvq.jdField_A_of_type_Int);
            }
          }
        }
        for (;;)
        {
          if (i2 != 0) {
            break label1898;
          }
          this.jdField_d_of_type_Int = localkvq.jdField_i_of_type_Int;
          this.jdField_i_of_type_JavaLangString = localkvq.jdField_f_of_type_JavaLangString;
          this.jdField_c_of_type_Boolean = localkvq.q;
          break;
          if ((str.compareTo((String)localObject1) == 0) || (!this.jdField_a_of_type_ComTencentAvVideoController.jdField_e_of_type_Boolean)) {
            break label1541;
          }
          this.jdField_a_of_type_ComTencentAvVideoController.a(i1, this.jdField_a_of_type_ComTencentAvVideoController.jdField_a_of_type_Long, 98);
          localkvq.a(i5);
          break label1541;
          this.jdField_b_of_type_Int = localkvq.jdField_d_of_type_Int;
          continue;
          localkvq.a(paramLong, "processExtraData.2", i4);
          localkvq.jdField_i_of_type_Int = ((Intent)localObject3).getIntExtra("uinType", -1);
          if ((localkvq.jdField_B_of_type_Int == 0) || (localkvq.jdField_B_of_type_Int == 1)) {
            localkvq.jdField_a_of_type_ArrayOfLong = ((Intent)localObject3).getLongArrayExtra("DiscussUinList");
          }
          this.jdField_b_of_type_Int = i4;
          continue;
          localkvq.jdField_d_of_type_JavaLangString = str;
          this.jdField_b_of_type_Int = i4;
          this.jdField_c_of_type_JavaLangString = str;
        }
        label1898:
        break label1006;
        if (((i3 != 1) && (i3 != 2)) || ((i4 != 1) && (i4 != 2))) {
          break label1006;
        }
        i1 = ((Intent)localObject3).getIntExtra("uinType", -1);
        if ((i1 != -1) && (i1 != localkvq.jdField_i_of_type_Int))
        {
          if (QLog.isColorLevel()) {
            QLog.w(this.jdField_b_of_type_JavaLangString, 2, "New Double Video in , newUinType !=-1 && newUinType != oldUinType , close old video.");
          }
          this.jdField_a_of_type_ComTencentAvVideoController.a(false, 203, new int[] { localkvq.jdField_A_of_type_Int });
          this.jdField_a_of_type_ComTencentAvVideoController.b(203);
          if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI != null)
          {
            this.jdField_a_of_type_ComTencentAvUiVideoControlUI.d(paramLong);
            this.jdField_a_of_type_ComTencentAvUiVideoControlUI = null;
          }
          localObject1 = localkvq.jdField_d_of_type_JavaLangString;
          localObject2 = ksn.a(3, (String)localObject1, new int[0]);
          Object localObject4 = ksn.a().b((String)localObject2);
          if (localObject4 == null)
          {
            krx.d(this.jdField_b_of_type_JavaLangString, "Can not get SessionInfo : SessionId = " + (String)localObject2);
            finish();
            return;
          }
          localObject3 = ((kvq)localObject4).jdField_f_of_type_JavaLangString;
          i1 = localkvq.jdField_i_of_type_Int;
          localObject4 = ((kvq)localObject4).jdField_r_of_type_JavaLangString;
          this.jdField_a_of_type_ComTencentAvVideoController.a((String)localObject1, 231);
          this.jdField_a_of_type_ComTencentAvVideoController.b(231);
          this.jdField_a_of_type_ComTencentAvVideoController.a("AVActivity.processExtraData", (String)localObject2, i1, (String)localObject1, (String)localObject3, 0, (String)localObject4, false, true);
          d(paramLong);
          localObject1 = ksn.a(3, this.jdField_c_of_type_JavaLangString, new int[0]);
          localObject2 = ksn.a().a((String)localObject1, false);
          ((kvq)localObject2).jdField_e_of_type_Boolean = true;
          ((kvq)localObject2).a("processExtraData", 2);
          ((kvq)localObject2).ae = false;
          if (((String)localObject1).equals(this.jdField_a_of_type_JavaLangString)) {
            break label1006;
          }
          this.jdField_a_of_type_JavaLangString = ((String)localObject1);
          break label1006;
        }
        if (QLog.isColorLevel()) {
          QLog.w(this.jdField_b_of_type_JavaLangString, 2, "New Double Video in , newUinType !=-1 && newUinType == oldUinType , resume old video");
        }
        this.jdField_b_of_type_Int = localkvq.jdField_d_of_type_Int;
        this.jdField_g_of_type_Boolean = localkvq.jdField_I_of_type_Boolean;
        this.jdField_d_of_type_Int = localkvq.jdField_i_of_type_Int;
        this.jdField_c_of_type_JavaLangString = localkvq.jdField_d_of_type_JavaLangString;
        this.jdField_e_of_type_JavaLangString = localkvq.jdField_e_of_type_JavaLangString;
        this.jdField_l_of_type_JavaLangString = localkvq.jdField_k_of_type_JavaLangString;
        this.jdField_e_of_type_Int = localkvq.x;
        this.jdField_m_of_type_JavaLangString = localkvq.jdField_o_of_type_JavaLangString;
        this.jdField_f_of_type_Int = localkvq.y;
        this.jdField_i_of_type_JavaLangString = localkvq.jdField_f_of_type_JavaLangString;
        this.jdField_f_of_type_JavaLangString = localkvq.a();
        this.jdField_a_of_type_Boolean = localkvq.jdField_e_of_type_Boolean;
        this.jdField_b_of_type_Boolean = localkvq.Q;
        this.jdField_c_of_type_Boolean = localkvq.q;
        this.jdField_d_of_type_Boolean = localkvq.jdField_L_of_type_Boolean;
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
    kvq localkvq = this.jdField_a_of_type_ComTencentAvVideoController.a();
    QLog.w(this.jdField_b_of_type_JavaLangString + "|VideoNodeManager", 1, "processIntentData begin, isProcessCreate[" + this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.jdField_c_of_type_Boolean + "], isMsfRecv[" + this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.jdField_d_of_type_Boolean + "], seq[" + paramLong + "], \nSessionInfo[" + localkvq + "]");
    Object localObject1;
    String str1;
    Object localObject2;
    String str2;
    long l1;
    if ((this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.jdField_c_of_type_Boolean) || (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.jdField_d_of_type_Boolean))
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.jdField_c_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.jdField_d_of_type_Boolean = false;
      kyj.a(26);
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
      this.jdField_b_of_type_Long = bavz.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_c_of_type_JavaLangString, 3, true, null);
      this.jdField_g_of_type_Int = ((Intent)localObject1).getIntExtra("vipType", 0);
      krx.b("VideoNodeManager", "==> AVActivity processIntentData() mSessionType = " + this.jdField_b_of_type_Int + "  mIsAudioMode = " + this.jdField_b_of_type_Boolean);
      kyj.b(this.jdField_b_of_type_Int);
      if (!this.jdField_b_of_type_Boolean) {
        break label773;
      }
      l1 = 1L;
      label568:
      kyj.a(13, l1);
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
      localkvq.jdField_B_of_type_Int = ((Intent)localObject1).getIntExtra("Type", -1);
      localObject2 = ((Intent)localObject1).getStringExtra("GroupId");
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        break label911;
      }
      krx.d(this.jdField_b_of_type_JavaLangString, "relationIdStr is null");
      this.jdField_e_of_type_Boolean = true;
      ((kyl)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4)).a(localkvq.b(), 5, 1016L);
      finish();
      return;
      kyj.a();
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
      i2 = localkvq.jdField_A_of_type_Int;
      i1 = i2;
      if (QLog.isColorLevel())
      {
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, "Not get avtype inside intent default value: " + i2);
        i1 = i2;
      }
    }
    localkvq.a(i1);
    if (localObject2 != null)
    {
      localkvq.jdField_g_of_type_Long = Long.valueOf((String)localObject2).longValue();
      this.jdField_d_of_type_JavaLangString = ((String)localObject2);
    }
    localkvq.jdField_a_of_type_ArrayOfLong = ((Intent)localObject1).getLongArrayExtra("DiscussUinList");
    localkvq.as = ((Intent)localObject1).getBooleanExtra("disableInvite", false);
    while (this.jdField_b_of_type_Int == 0)
    {
      krx.d(this.jdField_b_of_type_JavaLangString, "invalid sessionType!!!");
      this.jdField_e_of_type_Boolean = true;
      ((kyl)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4)).a(localkvq.b(), 5, 1015L);
      finish();
      return;
      label1085:
      localkvq.ag = ((Intent)localObject1).getBooleanExtra("isOtherTerminalOnChating", false);
      if (localkvq.ag)
      {
        localkvq.jdField_i_of_type_Long = ((Intent)localObject1).getLongExtra("otherTerminalChatingRoomId", 0L);
        localkvq.ai = ((Intent)localObject1).getBooleanExtra("startfromVideoEntry", false);
      }
    }
    i1 = ((Intent)localObject1).getIntExtra("remoteStatus", 0);
    boolean bool;
    if (this.jdField_a_of_type_Boolean)
    {
      if (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))
      {
        krx.d(this.jdField_b_of_type_JavaLangString, "uin is empty");
        this.jdField_e_of_type_Boolean = true;
        ((kyl)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4)).a(localkvq.b(), 5, 1016L);
        finish();
        return;
      }
      if (TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) {
        this.jdField_e_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
      }
      if ((this.jdField_d_of_type_Int != 1011) && (localkvq.jdField_a_of_type_Kvr.jdField_b_of_type_Boolean))
      {
        this.jdField_a_of_type_ComTencentAvVideoController.a(localkvq.jdField_d_of_type_JavaLangString, 232);
        this.jdField_a_of_type_ComTencentAvVideoController.b(232);
      }
      localkvq.a(paramLong, "processIntentData", this.jdField_b_of_type_Int);
      localkvq.jdField_i_of_type_Int = this.jdField_d_of_type_Int;
      localkvq.jdField_d_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
      localkvq.jdField_e_of_type_JavaLangString = this.jdField_e_of_type_JavaLangString;
      localkvq.jdField_f_of_type_JavaLangString = this.jdField_i_of_type_JavaLangString;
      localkvq.jdField_g_of_type_JavaLangString = str1;
      localkvq.a(this.jdField_f_of_type_JavaLangString);
      if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
        Looper.myQueue().addIdleHandler(this.jdField_a_of_type_AndroidOsMessageQueue$IdleHandler);
      }
      localkvq.jdField_e_of_type_Boolean = this.jdField_a_of_type_Boolean;
      localkvq.Q = this.jdField_b_of_type_Boolean;
      localkvq.q = this.jdField_c_of_type_Boolean;
      localkvq.jdField_i_of_type_JavaLangString = this.jdField_g_of_type_JavaLangString;
      localkvq.jdField_j_of_type_JavaLangString = this.jdField_h_of_type_JavaLangString;
      localkvq.jdField_k_of_type_JavaLangString = this.jdField_l_of_type_JavaLangString;
      localkvq.jdField_o_of_type_JavaLangString = this.jdField_m_of_type_JavaLangString;
      localkvq.x = this.jdField_e_of_type_Int;
      localkvq.y = this.jdField_f_of_type_Int;
      localkvq.jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_ArrayOfByte;
      localkvq.jdField_L_of_type_Boolean = this.jdField_d_of_type_Boolean;
      localkvq.jdField_f_of_type_Int = this.jdField_b_of_type_Int;
      localkvq.jdField_m_of_type_Boolean = this.jdField_f_of_type_Boolean;
      localkvq.jdField_b_of_type_Long = this.jdField_b_of_type_Long;
      localkvq.jdField_o_of_type_Int = this.jdField_g_of_type_Int;
      if (i1 != 4) {
        break label1998;
      }
      bool = true;
      label1500:
      localkvq.jdField_r_of_type_Boolean = bool;
      localkvq.jdField_k_of_type_Int = ((Intent)localObject1).getIntExtra("friendTerminal", 3);
      localkvq.jdField_I_of_type_Boolean = this.jdField_g_of_type_Boolean;
      localkvq.p = this.jdField_c_of_type_Int;
      localkvq.jdField_l_of_type_JavaLangString = ((Intent)localObject1).getStringExtra("actId");
      localkvq.jdField_m_of_type_JavaLangString = ((Intent)localObject1).getStringExtra("mp_ext_params");
      localkvq.jdField_a_of_type_Long = this.jdField_a_of_type_Long;
      if ((this.jdField_d_of_type_Int != 1011) && (this.jdField_d_of_type_Int != 21)) {
        break label2034;
      }
      localkvq.jdField_a_of_type_Kvr.jdField_a_of_type_JavaLangString = str2;
      localkvq.jdField_a_of_type_Kvr.jdField_b_of_type_JavaLangString = ((Intent)localObject1).getStringExtra("name");
      localkvq.jdField_a_of_type_Kvr.jdField_c_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
      if (Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).longValue() <= Long.valueOf(this.jdField_c_of_type_JavaLangString).longValue()) {
        break label2004;
      }
      localkvq.jdField_a_of_type_Kvr.jdField_a_of_type_Boolean = true;
      localObject1 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication().getApplicationInfo().dataDir + "/" + MD5.toMD5(str2) + ".jpg";
      if (!apdh.a((String)localObject1)) {}
    }
    for (;;)
    {
      try
      {
        localkvq.jdField_a_of_type_Kvr.jdField_a_of_type_AndroidGraphicsBitmap = BitmapFactory.decodeFile((String)localObject1);
        QLog.w(this.jdField_b_of_type_JavaLangString + "|VideoNodeManager", 1, "processIntentData end, mRelationId[" + this.jdField_d_of_type_JavaLangString + "], bStartByTerminalSwitch[" + localkvq.ag + "], terSwitchStartFromVideoEntry[" + localkvq.ai + "], \nSessionInfo[" + localkvq + "]");
        return;
        if (this.jdField_d_of_type_Int == 1006)
        {
          if (TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString))
          {
            krx.d(this.jdField_b_of_type_JavaLangString, "phoneNum is empty");
            this.jdField_e_of_type_Boolean = true;
            ((kyl)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4)).a(localkvq.b(), 5, 1016L);
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
          krx.d(this.jdField_b_of_type_JavaLangString, "Create video failed because uin is empty");
          this.jdField_e_of_type_Boolean = true;
          ((kyl)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4)).a(localkvq.b(), 5, 1016L);
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
        localkvq.jdField_a_of_type_Kvr.jdField_a_of_type_Boolean = false;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        QLog.d(this.jdField_b_of_type_JavaLangString, 1, "processIntentData OutOfMemoryError", localOutOfMemoryError);
        continue;
      }
      label2034:
      localkvq.jdField_a_of_type_Kvr.jdField_a_of_type_JavaLangString = null;
      localkvq.jdField_a_of_type_Kvr.jdField_b_of_type_JavaLangString = null;
      localkvq.jdField_a_of_type_Kvr.jdField_a_of_type_Boolean = false;
    }
  }
  
  public void d(boolean paramBoolean)
  {
    QLog.w(this.jdField_b_of_type_JavaLangString, 1, "onZimuModeChange, inZimu[" + paramBoolean + "]");
    lxz locallxz;
    if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (this.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) && (this.jdField_a_of_type_Lxz != null))
    {
      this.jdField_a_of_type_Lxz.jdField_d_of_type_Boolean = paramBoolean;
      locallxz = this.jdField_a_of_type_Lxz;
      if (!paramBoolean) {
        break label87;
      }
    }
    label87:
    for (int i1 = 0;; i1 = this.jdField_h_of_type_Int)
    {
      locallxz.d(i1);
      this.jdField_a_of_type_Lxz.d();
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
        if (this.jdField_a_of_type_Lxz == null) {
          break label219;
        }
        i1 = this.jdField_a_of_type_Lxz.c();
        ((DoubleVideoCtrlUI)localObject).e_(i1);
        g(l1);
      }
    }
    if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (this.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) && (this.jdField_a_of_type_Lxz != null))
    {
      this.jdField_a_of_type_Lxz.jdField_c_of_type_Boolean = paramBoolean;
      if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_B_of_type_Boolean) || (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_A_of_type_Boolean))
      {
        localObject = this.jdField_a_of_type_Lxz;
        if (!paramBoolean) {
          break label224;
        }
      }
    }
    label219:
    label224:
    for (int i1 = i2;; i1 = this.jdField_h_of_type_Int)
    {
      ((lxz)localObject).d(i1);
      this.jdField_a_of_type_Lxz.d();
      localObject = findViewById(2131297390);
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
    begr localbegr = begr.c(this);
    localbegr.getWindow().addFlags(524288);
    localbegr.getWindow().addFlags(2097152);
    localbegr.getWindow().addFlags(128);
    localbegr.b(2131654897);
    localbegr.c(2131625035);
    localbegr.a(new lql(this));
    localbegr.setOnDismissListener(new lqm(this));
    localbegr.setCanceledOnTouchOutside(true);
    localbegr.e(150);
    this.jdField_a_of_type_AndroidAppDialog = localbegr;
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
    krx.d(this.jdField_b_of_type_JavaLangString, "avideo life_finish, FromWhere[" + this.jdField_j_of_type_JavaLangString + "]");
    kvq localkvq = ksn.a().a();
    if ((localkvq.jdField_A_of_type_Boolean) && (this.jdField_a_of_type_Lxz != null))
    {
      this.jdField_a_of_type_Lxz.c();
      if (this.jdField_a_of_type_Lxz.b() < 1000L) {
        break label311;
      }
    }
    for (;;)
    {
      localkvq.u = i1;
      awqx.b(null, "CliOper", "", "", "0X800863D", "0X800863D", 0, 0, "", "", "", "");
      if ((this.jdField_e_of_type_Boolean) && (localkvq.aA) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null))
      {
        String str1 = String.valueOf(localkvq.jdField_g_of_type_Long);
        String str2 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getDisplayName(this.jdField_d_of_type_Int, str1, localkvq.jdField_f_of_type_JavaLangString);
        Intent localIntent = aciy.a(new Intent(super.getApplicationContext(), SplashActivity.class), null);
        localIntent.putExtra("uin", str1);
        localIntent.putExtra("uintype", localkvq.jdField_i_of_type_Int);
        localIntent.putExtra("uinname", str2);
        startActivity(localIntent);
      }
      if (QLog.isColorLevel()) {
        QLog.i("double_2_multi", 2, "finish fromDoubleChat[" + localkvq.aA + "], session[" + localkvq + "]");
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
    ViewGroup localViewGroup = (ViewGroup)findViewById(2131297390);
    float f1 = getResources().getDimension(2131166447);
    float f2 = getResources().getDimension(2131166450);
    Object localObject = new RelativeLayout.LayoutParams(-1, (int)f1);
    ((RelativeLayout.LayoutParams)localObject).setMargins(0, (int)f2, 0, 0);
    this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterPanel = new EffectFilterPanel(getBaseContext(), this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterPanel.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = localViewGroup.findViewById(2131306822);
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
      ViewGroup localViewGroup = (ViewGroup)findViewById(2131297390);
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
      FaceItem localFaceItem = (FaceItem)((kxi)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(3)).a();
      if ((localFaceItem == null) || (!localFaceItem.isInteract()) || (!localFaceItem.isSameType("face"))) {
        break label138;
      }
    }
    label138:
    for (paramBoolean = true;; paramBoolean = false)
    {
      krx.c(this.jdField_b_of_type_JavaLangString, "onChangeUI_quitDoubleScreenStatus isIntactiveFace:" + paramBoolean);
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
    mht localmht = mht.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    if (localmht != null)
    {
      if (paramBoolean) {
        i1 = 1;
      }
      localmht.a(i1);
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
      mez.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramInt2, paramIntent);
    }
    do
    {
      return;
      if (paramInt1 == 802)
      {
        mez.b(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramInt2, paramIntent);
        return;
      }
    } while ((paramInt1 != 1002) || (this.jdField_a_of_type_Lwq == null));
    this.jdField_a_of_type_Lwq.e();
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
    lry locallry = new lry(null);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(7002), locallry });
    QLog.i(this.jdField_b_of_type_JavaLangString, 1, "avideo onBackPressed, BlockSystemBack[" + locallry.jdField_b_of_type_Boolean + "], BlockName[" + locallry.jdField_b_of_type_JavaLangString + "]");
    boolean bool1 = locallry.jdField_b_of_type_Boolean;
    boolean bool2 = bool1;
    if (!bool1)
    {
      bool2 = bool1;
      if (this.jdField_a_of_type_Mbo != null) {
        bool2 = this.jdField_a_of_type_Mbo.b();
      }
    }
    bool1 = bool2;
    if (!bool2)
    {
      if ((this.jdField_a_of_type_Lrn == null) || (!this.jdField_a_of_type_Lrn.a())) {
        break label221;
      }
      bool1 = this.jdField_a_of_type_Lrn.b();
    }
    for (;;)
    {
      bool2 = bool1;
      if (this.jdField_a_of_type_Lwq != null)
      {
        bool2 = bool1;
        if (this.jdField_a_of_type_Lwq.a())
        {
          this.jdField_a_of_type_Lwq.c();
          bool2 = true;
        }
      }
      if (!bool2) {
        super.onBackPressed();
      }
      this.jdField_a_of_type_ComTencentAvVideoController.a("backgroundReason", "2");
      ksu.jdField_a_of_type_JavaLangString = "2";
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
    QLog.w(this.jdField_b_of_type_JavaLangString + "|VideoNodeManager", 1, "avideo life_onCreate, seq[" + l1 + "]");
    this.mIsShadow = false;
    super.onCreate(paramBundle);
    super.requestWindowFeature(1);
    super.setContentView(2131493928);
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
        break label322;
      }
      QLog.d(this.jdField_b_of_type_JavaLangString, 1, "onCreate, 尝试同步获取AppRuntime");
      paramBundle = paramBundle.getRuntime();
      localObject = this.jdField_b_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder().append("onCreate, 同步获取AppRuntime结果");
      if (paramBundle == null) {
        break label316;
      }
      bool = true;
      QLog.d((String)localObject, 1, bool);
    }
    for (;;)
    {
      if (paramBundle != null) {
        break label339;
      }
      krx.d(this.jdField_b_of_type_JavaLangString, "onCreate, appRuntime is null exit");
      paramBundle = super.getString(2131654840) + " 0x05";
      Toast.makeText(super.getBaseContext(), paramBundle, 0).show();
      this.jdField_e_of_type_Boolean = true;
      sendBroadcast(new Intent("com.tencent.av.ui.AVLoadingDialogActivity.ACTION_LOADING_FINISH"));
      finish();
      return;
      label316:
      bool = false;
      break;
      label322:
      QLog.d(this.jdField_b_of_type_JavaLangString, 1, "onCreate, BaseApplicationImpl.getApplication is null");
      paramBundle = (Bundle)localObject;
    }
    label339:
    if ((paramBundle instanceof VideoAppInterface)) {}
    for (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = ((VideoAppInterface)paramBundle); this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null; this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = null)
    {
      krx.d(this.jdField_b_of_type_JavaLangString, "onCreate, AppRuntime is no VideoAppInterface, " + paramBundle.getClass().getName() + " exit");
      paramBundle = super.getString(2131654840) + " 0x06";
      Toast.makeText(super.getBaseContext(), paramBundle, 0).show();
      this.jdField_e_of_type_Boolean = true;
      sendBroadcast(new Intent("com.tencent.av.ui.AVLoadingDialogActivity.ACTION_LOADING_FINISH"));
      finish();
      return;
    }
    f(true);
    paramBundle = (kyl)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4);
    localObject = ksn.a().a();
    if (localObject != null)
    {
      QLog.d(this.jdField_b_of_type_JavaLangString, 1, "avideo life_onCreate roomId = " + ((kvq)localObject).b() + ",isReceiver = " + ((kvq)localObject).jdField_e_of_type_Boolean);
      if (((kvq)localObject).jdField_e_of_type_Boolean) {
        paramBundle.a(((kvq)localObject).b(), 7, 1L);
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
      kya.a().a(this);
      this.jdField_a_of_type_ComTencentAvVideoController = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
      if (this.jdField_a_of_type_ComTencentAvVideoController != null) {
        break;
      }
      krx.d(this.jdField_b_of_type_JavaLangString, "onCreate,VideoAppInterface.mVideoController exit");
      paramBundle = super.getString(2131654840) + " 0x07";
      Toast.makeText(super.getBaseContext(), paramBundle, 0).show();
      this.jdField_e_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast(new Intent("com.tencent.av.ui.AVLoadingDialogActivity.ACTION_LOADING_FINISH"));
      finish();
      return;
      QLog.d(this.jdField_b_of_type_JavaLangString, 1, "avideo life_onCreate sessionInfo is null ");
    }
    if (!this.jdField_a_of_type_ComTencentAvVideoController.b())
    {
      krx.d(this.jdField_b_of_type_JavaLangString, "onCreate,VideoAppInterface.initVcController exit");
      paramBundle = super.getString(2131654840) + " 0x08";
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
        localObject = ksn.a(3, paramBundle, new int[0]);
        localObject = ksn.a().b((String)localObject);
        if ((localObject == null) || (((kvq)localObject).jdField_i_of_type_Int == -1))
        {
          localObject = ksn.a().a();
          if ((((kvq)localObject).jdField_i_of_type_Int != -1) && ((((kvq)localObject).f()) || (((kvq)localObject).h())))
          {
            localObject = new Intent("tencent.video.v2q.ypc2b.failEnter.asIsInviting");
            ((Intent)localObject).setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getPackageName());
            ((Intent)localObject).putExtra("uin", paramBundle);
            ((Intent)localObject).putExtra("uinType", i1);
            this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast((Intent)localObject);
            this.jdField_e_of_type_Boolean = true;
            this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast(new Intent("com.tencent.av.ui.AVLoadingDialogActivity.ACTION_LOADING_FINISH"));
            krx.d(this.jdField_b_of_type_JavaLangString, "onCreate,VideoAppInterface.UIN_TYPE_PUBLIC_ACCOUNT exit: " + paramBundle);
            finish();
            return;
          }
        }
      }
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_Kur);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_Lru);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_Kvw);
    this.jdField_a_of_type_ComTencentAvVideoController.b();
    a();
    d();
    this.jdField_a_of_type_JavaLangString = a(getIntent());
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (!a(getIntent())) && (!ksn.a().a(this.jdField_a_of_type_JavaLangString)))
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a(false, 204, new int[] { this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_A_of_type_Int });
      this.jdField_a_of_type_ComTencentAvVideoController.b(204);
      ksn.a().a(this.jdField_a_of_type_JavaLangString, false);
    }
    for (;;)
    {
      if (!this.jdField_a_of_type_ComTencentAvVideoController.a().a()) {
        c(l1);
      }
      GraphicRenderMgr.getInstance();
      ThreadManager.post(new AVActivity.4(this), 5, null, false);
      this.jdField_a_of_type_Mht = mht.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      b(0);
      a(l1, false);
      if ((this.jdField_a_of_type_ComTencentAvUiVideoControlUI instanceof DoubleVideoCtrlUI)) {
        llm.a().a();
      }
      if (EffectSettingUi.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, false))
      {
        this.jdField_a_of_type_Lrs = new lrs(this);
        this.jdField_a_of_type_Lrs.a();
      }
      this.jdField_a_of_type_Loj = loj.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      i1 = this.jdField_a_of_type_ComTencentAvVideoController.a().K;
      if (QLog.isDevelopLevel()) {
        QLog.d(this.jdField_b_of_type_JavaLangString, 4, "onCreate changeVideoLayoutMode Style=" + this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int + "|" + this.jdField_a_of_type_ComTencentAvVideoController.a().K + "|" + this.jdField_a_of_type_ComTencentAvVideoController.g());
      }
      a(i1, false);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast(new Intent("com.tencent.av.ui.AVLoadingDialogActivity.ACTION_LOADING_FINISH"));
      paramBundle = (ViewStub)findViewById(2131306545);
      this.jdField_a_of_type_Lwq = new lwq(findViewById(2131306488), paramBundle, 2131306771, this.jdField_a_of_type_ComTencentAvVideoController, this);
      this.jdField_a_of_type_Mbo = new mbo(this, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface)) {
        findViewById(2131306710).setVisibility(0);
      }
      this.jdField_a_of_type_ComTencentAvUiGuideGuideHelper.a(this);
      AudioHelper.b(this.jdField_b_of_type_JavaLangString + ".onCreate.end");
      return;
      this.jdField_a_of_type_JavaLangString = ksn.a().a().jdField_c_of_type_JavaLangString;
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
    if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (this.jdField_a_of_type_ComTencentAvVideoController.a() != null) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_A_of_type_Boolean) && (this.jdField_a_of_type_Lxz != null)) {
      this.jdField_a_of_type_Lxz.c();
    }
    if (this.jdField_a_of_type_Lxz != null)
    {
      this.jdField_a_of_type_Lxz.e();
      this.jdField_a_of_type_Lxz = null;
    }
    if (this.jdField_a_of_type_ComTencentAvCameraCameraUtils != null)
    {
      this.jdField_a_of_type_ComTencentAvCameraCameraUtils.b(this.jdField_a_of_type_Kzq);
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
    if (this.jdField_a_of_type_Lrn != null)
    {
      this.jdField_a_of_type_Lrn.b();
      this.jdField_a_of_type_Lrn = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView = null;
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_Kvw);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_Lru);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_Kur);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      lad locallad = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
      if (locallad != null) {
        locallad.a();
      }
    }
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null)
    {
      unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
    }
    if (this.jdField_e_of_type_Boolean)
    {
      lbn.a().a();
      if (this.jdField_a_of_type_Mht != null) {
        this.jdField_a_of_type_Mht.a(this.jdField_a_of_type_JavaLangString);
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
    this.jdField_a_of_type_Mht = null;
    this.jdField_a_of_type_Lqy = null;
    AudioHelper.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
    this.jdField_a_of_type_Lru = null;
    this.jdField_a_of_type_Kvw = null;
    if (this.jdField_a_of_type_Lrs != null)
    {
      this.jdField_a_of_type_Lrs.b();
      this.jdField_a_of_type_Lrs = null;
    }
    kya.a().a(null);
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(7004), this.jdField_c_of_type_JavaLangString, Boolean.valueOf(this.jdField_e_of_type_Boolean) });
    }
    lja.a().a();
    lja.a().a(null, null);
    zqa.a(this);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
    if (this.jdField_a_of_type_Lwq != null)
    {
      awqx.b(null, "CliOper", "", "", "0X800A345", "0X800A345", this.jdField_a_of_type_Lwq.a(), 0, "", "", "", "");
      this.jdField_a_of_type_Lwq.f();
    }
    this.jdField_a_of_type_Lwq = null;
    if (this.jdField_a_of_type_Mbo != null)
    {
      this.jdField_a_of_type_Mbo.a();
      this.jdField_a_of_type_Mbo = null;
    }
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
    if (this.jdField_a_of_type_Loj != null) {
      this.jdField_a_of_type_Loj.b();
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
          if ((i2 != 2) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_A_of_type_Int != 2)) {
            break label290;
          }
          if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_A_of_type_Int != i2) {
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
    aluq.a(this, 2, true);
    lja.a().a(16);
    i(false);
    bbqo.a(BaseApplicationImpl.getContext(), true, 50, 1);
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
        if ("0".equals(ksu.jdField_a_of_type_JavaLangString)) {
          this.jdField_a_of_type_ComTencentAvVideoController.a("backgroundReason", "5");
        }
      }
      QLog.d(this.jdField_b_of_type_JavaLangString, 1, "avideo life_onPause end");
      if (this.jdField_a_of_type_Lwq != null)
      {
        this.jdField_a_of_type_Lwq.c();
        this.jdField_a_of_type_Lwq.e();
      }
      this.jdField_a_of_type_Lal.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_a_of_type_ComTencentAvVideoController);
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
    //   2: invokevirtual 2466	com/tencent/av/ui/AVActivity:i	(Z)V
    //   5: invokestatic 242	com/tencent/mobileqq/utils/AudioHelper:b	()J
    //   8: lstore 9
    //   10: aload_0
    //   11: iconst_2
    //   12: iconst_0
    //   13: invokestatic 2464	aluq:a	(Landroid/content/Context;IZ)V
    //   16: invokestatic 2469	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   19: bipush 50
    //   21: iconst_0
    //   22: invokestatic 2501	bbqo:a	(Landroid/content/Context;II)V
    //   25: invokestatic 2469	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   28: iconst_0
    //   29: bipush 50
    //   31: iconst_1
    //   32: invokestatic 2474	bbqo:a	(Landroid/content/Context;ZII)V
    //   35: new 230	java/lang/StringBuilder
    //   38: dup
    //   39: invokespecial 231	java/lang/StringBuilder:<init>	()V
    //   42: aload_0
    //   43: getfield 251	com/tencent/av/ui/AVActivity:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   46: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: ldc_w 2503
    //   52: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   58: invokestatic 2174	com/tencent/mobileqq/utils/AudioHelper:b	(Ljava/lang/String;)V
    //   61: aload_0
    //   62: iconst_0
    //   63: putfield 228	com/tencent/av/ui/AVActivity:mIsShadow	Z
    //   66: aload_0
    //   67: invokespecial 2505	mqq/app/BaseActivity:onResume	()V
    //   70: invokestatic 1572	ksn:a	()Lksn;
    //   73: invokevirtual 2002	ksn:a	()Lkvq;
    //   76: astore 21
    //   78: aload_0
    //   79: getfield 251	com/tencent/av/ui/AVActivity:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   82: iconst_1
    //   83: new 230	java/lang/StringBuilder
    //   86: dup
    //   87: invokespecial 231	java/lang/StringBuilder:<init>	()V
    //   90: ldc_w 2507
    //   93: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: aload_0
    //   97: getfield 557	com/tencent/av/ui/AVActivity:o	Z
    //   100: invokevirtual 458	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   103: ldc_w 519
    //   106: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: lload 9
    //   111: invokevirtual 245	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   114: ldc_w 2509
    //   117: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: aload 21
    //   122: invokevirtual 724	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   125: ldc_w 388
    //   128: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   134: invokestatic 391	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   137: aload_0
    //   138: iconst_0
    //   139: putfield 2476	com/tencent/av/ui/AVActivity:jdField_i_of_type_Boolean	Z
    //   142: invokestatic 2512	lfm:a	()V
    //   145: aload_0
    //   146: getfield 138	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvAppVideoAppInterface	Lcom/tencent/av/app/VideoAppInterface;
    //   149: iconst_4
    //   150: invokevirtual 1271	com/tencent/av/app/VideoAppInterface:a	(I)Lkwt;
    //   153: checkcast 1471	kyl
    //   156: astore 22
    //   158: aload 21
    //   160: getfield 878	kvq:jdField_e_of_type_Boolean	Z
    //   163: ifeq +16 -> 179
    //   166: aload 22
    //   168: aload 21
    //   170: invokevirtual 1472	kvq:b	()J
    //   173: bipush 8
    //   175: lconst_1
    //   176: invokevirtual 1477	kyl:a	(JIJ)V
    //   179: aload_0
    //   180: invokevirtual 1112	com/tencent/av/ui/AVActivity:getIntent	()Landroid/content/Intent;
    //   183: ldc_w 2253
    //   186: iconst_0
    //   187: invokevirtual 283	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   190: ifeq +13 -> 203
    //   193: aload 22
    //   195: ldc2_w 2254
    //   198: iconst_3
    //   199: lconst_1
    //   200: invokevirtual 1477	kyl:a	(JIJ)V
    //   203: aload_0
    //   204: getfield 138	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvAppVideoAppInterface	Lcom/tencent/av/app/VideoAppInterface;
    //   207: invokevirtual 2513	com/tencent/av/app/VideoAppInterface:i	()Z
    //   210: ifne +10 -> 220
    //   213: aload_0
    //   214: getfield 138	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvAppVideoAppInterface	Lcom/tencent/av/app/VideoAppInterface;
    //   217: invokevirtual 2514	com/tencent/av/app/VideoAppInterface:b	()V
    //   220: aload_0
    //   221: getfield 557	com/tencent/av/ui/AVActivity:o	Z
    //   224: ifeq +19 -> 243
    //   227: aload_0
    //   228: getfield 78	com/tencent/av/ui/AVActivity:jdField_b_of_type_Int	I
    //   231: iconst_1
    //   232: if_icmpeq +11 -> 243
    //   235: aload_0
    //   236: getfield 78	com/tencent/av/ui/AVActivity:jdField_b_of_type_Int	I
    //   239: iconst_2
    //   240: if_icmpne +3 -> 243
    //   243: aload_0
    //   244: iconst_0
    //   245: putfield 557	com/tencent/av/ui/AVActivity:o	Z
    //   248: aload_0
    //   249: iconst_0
    //   250: putfield 202	com/tencent/av/ui/AVActivity:jdField_k_of_type_Boolean	Z
    //   253: aload_0
    //   254: iconst_2
    //   255: invokevirtual 2321	com/tencent/av/ui/AVActivity:b	(I)V
    //   258: aload_0
    //   259: getfield 140	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvVideoController	Lcom/tencent/av/VideoController;
    //   262: iconst_1
    //   263: invokevirtual 1370	com/tencent/av/VideoController:i	(Z)V
    //   266: aload_0
    //   267: getfield 317	com/tencent/av/ui/AVActivity:jdField_a_of_type_Loj	Lloj;
    //   270: ifnull +10 -> 280
    //   273: aload_0
    //   274: getfield 317	com/tencent/av/ui/AVActivity:jdField_a_of_type_Loj	Lloj;
    //   277: invokevirtual 2451	loj:b	()V
    //   280: aload_0
    //   281: getfield 138	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvAppVideoAppInterface	Lcom/tencent/av/app/VideoAppInterface;
    //   284: invokevirtual 992	com/tencent/av/app/VideoAppInterface:a	()Landroid/os/Handler;
    //   287: new 2516	com/tencent/av/ui/AVActivity$11
    //   290: dup
    //   291: aload_0
    //   292: lload 9
    //   294: invokespecial 2518	com/tencent/av/ui/AVActivity$11:<init>	(Lcom/tencent/av/ui/AVActivity;J)V
    //   297: ldc2_w 2519
    //   300: invokevirtual 1002	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   303: pop
    //   304: aload 21
    //   306: getfield 504	kvq:jdField_d_of_type_Int	I
    //   309: iconst_2
    //   310: if_icmpne +1018 -> 1328
    //   313: aload 21
    //   315: invokevirtual 2443	kvq:j	()Z
    //   318: ifeq +956 -> 1274
    //   321: aload 21
    //   323: getfield 1177	kvq:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   326: astore 19
    //   328: aload 21
    //   330: getfield 2521	kvq:jdField_k_of_type_Boolean	Z
    //   333: istore 16
    //   335: aload_0
    //   336: getfield 140	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvVideoController	Lcom/tencent/av/VideoController;
    //   339: aload_0
    //   340: getfield 92	com/tencent/av/ui/AVActivity:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   343: invokevirtual 2523	com/tencent/av/VideoController:b	(Ljava/lang/String;)I
    //   346: iconst_5
    //   347: if_icmpne +808 -> 1155
    //   350: iconst_1
    //   351: istore 15
    //   353: aload 21
    //   355: getfield 2524	kvq:jdField_i_of_type_Boolean	Z
    //   358: istore 17
    //   360: aload 21
    //   362: getfield 2525	kvq:jdField_j_of_type_Boolean	Z
    //   365: istore 18
    //   367: iload 18
    //   369: ifeq +41 -> 410
    //   372: invokestatic 2529	babp:d	()Ljava/lang/String;
    //   375: astore 20
    //   377: aload_0
    //   378: getfield 884	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvCameraCameraUtils	Lcom/tencent/av/camera/CameraUtils;
    //   381: lload 9
    //   383: invokevirtual 2531	com/tencent/av/camera/CameraUtils:a	(J)Z
    //   386: ifne +775 -> 1161
    //   389: aload_0
    //   390: getfield 884	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvCameraCameraUtils	Lcom/tencent/av/camera/CameraUtils;
    //   393: lload 9
    //   395: invokevirtual 892	com/tencent/av/camera/CameraUtils:b	(J)Z
    //   398: ifne +763 -> 1161
    //   401: aload_0
    //   402: getfield 884	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvCameraCameraUtils	Lcom/tencent/av/camera/CameraUtils;
    //   405: lload 9
    //   407: invokevirtual 2532	com/tencent/av/camera/CameraUtils:a	(J)V
    //   410: aload_0
    //   411: getfield 590	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   414: ifnull +59 -> 473
    //   417: iload 18
    //   419: ifeq +811 -> 1230
    //   422: iload 16
    //   424: ifeq +806 -> 1230
    //   427: iload 17
    //   429: ifeq +770 -> 1199
    //   432: aload_0
    //   433: getfield 590	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   436: lload 9
    //   438: aload 19
    //   440: iconst_1
    //   441: iconst_1
    //   442: iconst_0
    //   443: iload 15
    //   445: invokevirtual 1357	com/tencent/av/ui/VideoLayerUI:a	(JLjava/lang/String;IZZZ)V
    //   448: aload_0
    //   449: getfield 138	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvAppVideoAppInterface	Lcom/tencent/av/app/VideoAppInterface;
    //   452: ldc_w 2533
    //   455: invokestatic 2536	mez:a	(Lcom/tencent/av/app/VideoAppInterface;Ljava/lang/String;)Z
    //   458: istore 15
    //   460: aload_0
    //   461: getfield 590	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   464: lload 9
    //   466: iconst_1
    //   467: iload 15
    //   469: invokevirtual 887	com/tencent/av/ui/VideoLayerUI:a	(JZZ)Z
    //   472: pop
    //   473: aload_0
    //   474: getfield 590	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   477: ifnull +10 -> 487
    //   480: aload_0
    //   481: getfield 590	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   484: invokevirtual 2538	com/tencent/av/ui/VideoLayerUI:q	()V
    //   487: aload_0
    //   488: getfield 501	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoControlUI	Lcom/tencent/av/ui/VideoControlUI;
    //   491: ifnull +12 -> 503
    //   494: aload_0
    //   495: getfield 501	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoControlUI	Lcom/tencent/av/ui/VideoControlUI;
    //   498: lload 9
    //   500: invokevirtual 2540	com/tencent/av/ui/VideoControlUI:b	(J)V
    //   503: aload_0
    //   504: getfield 532	com/tencent/av/ui/AVActivity:jdField_a_of_type_Lrn	Llrn;
    //   507: ifnull +10 -> 517
    //   510: aload_0
    //   511: getfield 532	com/tencent/av/ui/AVActivity:jdField_a_of_type_Lrn	Llrn;
    //   514: invokevirtual 2541	lrn:c	()V
    //   517: aload_0
    //   518: getfield 140	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvVideoController	Lcom/tencent/av/VideoController;
    //   521: iconst_0
    //   522: invokevirtual 1368	com/tencent/av/VideoController:a	(Z)I
    //   525: pop
    //   526: aload_0
    //   527: invokevirtual 2542	com/tencent/av/ui/AVActivity:b	()V
    //   530: aload_0
    //   531: invokevirtual 2543	com/tencent/av/ui/AVActivity:e	()V
    //   534: aload_0
    //   535: getfield 138	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvAppVideoAppInterface	Lcom/tencent/av/app/VideoAppInterface;
    //   538: invokevirtual 2276	com/tencent/av/app/VideoAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   541: new 262	android/content/Intent
    //   544: dup
    //   545: ldc_w 2227
    //   548: invokespecial 2228	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   551: invokevirtual 2279	com/tencent/qphone/base/util/BaseApplication:sendBroadcast	(Landroid/content/Intent;)V
    //   554: aload_0
    //   555: getfield 590	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   558: ifnull +20 -> 578
    //   561: aload_0
    //   562: invokevirtual 546	com/tencent/av/ui/AVActivity:a	()Z
    //   565: ifeq +13 -> 578
    //   568: aload_0
    //   569: getfield 590	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   572: ldc_w 2533
    //   575: invokevirtual 2071	com/tencent/av/ui/VideoLayerUI:a	(Ljava/lang/String;)V
    //   578: aload 21
    //   580: getfield 504	kvq:jdField_d_of_type_Int	I
    //   583: iconst_2
    //   584: if_icmpeq +12 -> 596
    //   587: aload 21
    //   589: getfield 504	kvq:jdField_d_of_type_Int	I
    //   592: iconst_1
    //   593: if_icmpne +45 -> 638
    //   596: aload_0
    //   597: getfield 610	com/tencent/av/ui/AVActivity:jdField_a_of_type_Lxz	Llxz;
    //   600: ifnull +38 -> 638
    //   603: aload_0
    //   604: getfield 610	com/tencent/av/ui/AVActivity:jdField_a_of_type_Lxz	Llxz;
    //   607: invokevirtual 2545	lxz:d	()I
    //   610: iconst_1
    //   611: if_icmpne +27 -> 638
    //   614: aload 21
    //   616: getfield 959	kvq:jdField_B_of_type_Boolean	Z
    //   619: ifeq +19 -> 638
    //   622: aload_0
    //   623: getfield 220	com/tencent/av/ui/AVActivity:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   626: new 2547	com/tencent/av/ui/AVActivity$13
    //   629: dup
    //   630: aload_0
    //   631: invokespecial 2548	com/tencent/av/ui/AVActivity$13:<init>	(Lcom/tencent/av/ui/AVActivity;)V
    //   634: invokevirtual 1232	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   637: pop
    //   638: aload 21
    //   640: getfield 2551	kvq:U	I
    //   643: iconst_m1
    //   644: if_icmpne +12 -> 656
    //   647: aload 21
    //   649: aload_0
    //   650: invokevirtual 2552	com/tencent/av/ui/AVActivity:a	()I
    //   653: putfield 2551	kvq:U	I
    //   656: aload 21
    //   658: getfield 2555	kvq:T	I
    //   661: iconst_m1
    //   662: if_icmpne +105 -> 767
    //   665: aload_0
    //   666: invokevirtual 563	com/tencent/av/ui/AVActivity:getApplicationContext	()Landroid/content/Context;
    //   669: invokestatic 682	baig:a	(Landroid/content/Context;)Landroid/content/SharedPreferences;
    //   672: astore 19
    //   674: aload 21
    //   676: aload 19
    //   678: new 230	java/lang/StringBuilder
    //   681: dup
    //   682: invokespecial 231	java/lang/StringBuilder:<init>	()V
    //   685: ldc_w 2557
    //   688: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   691: aload_0
    //   692: getfield 138	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvAppVideoAppInterface	Lcom/tencent/av/app/VideoAppInterface;
    //   695: invokevirtual 685	com/tencent/av/app/VideoAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   698: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   701: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   704: iconst_1
    //   705: invokeinterface 695 3 0
    //   710: putfield 2555	kvq:T	I
    //   713: aload 21
    //   715: getfield 2555	kvq:T	I
    //   718: iconst_1
    //   719: if_icmpne +48 -> 767
    //   722: aload 19
    //   724: invokeinterface 2561 1 0
    //   729: new 230	java/lang/StringBuilder
    //   732: dup
    //   733: invokespecial 231	java/lang/StringBuilder:<init>	()V
    //   736: ldc_w 2557
    //   739: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   742: aload_0
    //   743: getfield 138	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvAppVideoAppInterface	Lcom/tencent/av/app/VideoAppInterface;
    //   746: invokevirtual 685	com/tencent/av/app/VideoAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   749: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   752: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   755: iconst_0
    //   756: invokeinterface 2567 3 0
    //   761: invokeinterface 2570 1 0
    //   766: pop
    //   767: aload 21
    //   769: getfield 2007	kvq:u	I
    //   772: ifeq +38 -> 810
    //   775: aload 21
    //   777: getfield 2007	kvq:u	I
    //   780: iconst_1
    //   781: if_icmpne +1239 -> 2020
    //   784: aload_0
    //   785: iconst_2
    //   786: aload_0
    //   787: invokevirtual 737	com/tencent/av/ui/AVActivity:getResources	()Landroid/content/res/Resources;
    //   790: ldc_w 2571
    //   793: invokevirtual 2572	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   796: iconst_0
    //   797: invokestatic 2577	bbmy:a	(Landroid/content/Context;ILjava/lang/CharSequence;I)Lbbmy;
    //   800: invokevirtual 2580	bbmy:a	()Landroid/widget/Toast;
    //   803: pop
    //   804: aload 21
    //   806: iconst_0
    //   807: putfield 2007	kvq:u	I
    //   810: aload_0
    //   811: getfield 138	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvAppVideoAppInterface	Lcom/tencent/av/app/VideoAppInterface;
    //   814: iconst_2
    //   815: anewarray 1265	java/lang/Object
    //   818: dup
    //   819: iconst_0
    //   820: sipush 7000
    //   823: invokestatic 2090	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   826: aastore
    //   827: dup
    //   828: iconst_1
    //   829: aload_0
    //   830: getfield 92	com/tencent/av/ui/AVActivity:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   833: aastore
    //   834: invokevirtual 1268	com/tencent/av/app/VideoAppInterface:a	([Ljava/lang/Object;)V
    //   837: invokestatic 668	com/tencent/mobileqq/utils/AudioHelper:d	()Z
    //   840: ifeq +10 -> 850
    //   843: aload_0
    //   844: getfield 138	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvAppVideoAppInterface	Lcom/tencent/av/app/VideoAppInterface;
    //   847: invokestatic 2583	com/tencent/mobileqq/debug/PstnCardTestActivity:showTestBtn	(Lcom/tencent/av/app/VideoAppInterface;)V
    //   850: invokestatic 1224	lja:a	()Llja;
    //   853: bipush 16
    //   855: invokevirtual 2584	lja:b	(I)V
    //   858: aload 21
    //   860: getfield 2525	kvq:jdField_j_of_type_Boolean	Z
    //   863: istore 15
    //   865: aload 21
    //   867: getfield 2521	kvq:jdField_k_of_type_Boolean	Z
    //   870: istore 16
    //   872: iload 15
    //   874: ifeq +8 -> 882
    //   877: iload 16
    //   879: ifne +1164 -> 2043
    //   882: invokestatic 1224	lja:a	()Llja;
    //   885: iconst_1
    //   886: invokevirtual 2465	lja:a	(I)V
    //   889: invokestatic 2587	java/lang/System:currentTimeMillis	()J
    //   892: lstore 11
    //   894: invokestatic 2327	llm:a	()Lllm;
    //   897: getfield 2588	llm:jdField_b_of_type_Long	J
    //   900: lstore 13
    //   902: aload 21
    //   904: invokevirtual 1472	kvq:b	()J
    //   907: lconst_0
    //   908: lcmp
    //   909: ifle +1144 -> 2053
    //   912: aload 21
    //   914: invokevirtual 1472	kvq:b	()J
    //   917: lstore 7
    //   919: aload 22
    //   921: lload 7
    //   923: bipush 25
    //   925: lload 11
    //   927: lload 13
    //   929: lsub
    //   930: invokevirtual 1477	kyl:a	(JIJ)V
    //   933: aload_0
    //   934: getfield 140	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvVideoController	Lcom/tencent/av/VideoController;
    //   937: ldc_w 2481
    //   940: ldc_w 2590
    //   943: invokevirtual 2164	com/tencent/av/VideoController:a	(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/av/VideoController;
    //   946: pop
    //   947: ldc_w 2483
    //   950: putstatic 2167	ksu:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   953: new 230	java/lang/StringBuilder
    //   956: dup
    //   957: invokespecial 231	java/lang/StringBuilder:<init>	()V
    //   960: aload_0
    //   961: getfield 251	com/tencent/av/ui/AVActivity:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   964: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   967: ldc_w 2592
    //   970: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   973: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   976: invokestatic 2174	com/tencent/mobileqq/utils/AudioHelper:b	(Ljava/lang/String;)V
    //   979: aload_0
    //   980: invokevirtual 1112	com/tencent/av/ui/AVActivity:getIntent	()Landroid/content/Intent;
    //   983: ldc_w 2594
    //   986: iconst_0
    //   987: invokevirtual 266	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   990: ifeq +21 -> 1011
    //   993: invokestatic 2599	zrr:a	()Lzrr;
    //   996: aload_0
    //   997: invokevirtual 1112	com/tencent/av/ui/AVActivity:getIntent	()Landroid/content/Intent;
    //   1000: ldc_w 2594
    //   1003: iconst_0
    //   1004: invokevirtual 266	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   1007: iconst_1
    //   1008: invokevirtual 2600	zrr:a	(IZ)V
    //   1011: aload_0
    //   1012: invokevirtual 2601	com/tencent/av/ui/AVActivity:a	()Lcom/tencent/av/VideoController;
    //   1015: invokevirtual 2602	com/tencent/av/VideoController:x	()V
    //   1018: invokestatic 2603	com/tencent/av/VideoController:a	()Lcom/tencent/av/VideoController;
    //   1021: aload_0
    //   1022: invokevirtual 1075	com/tencent/av/VideoController:a	(Landroid/content/Context;)Llfi;
    //   1025: astore 19
    //   1027: aload 19
    //   1029: ifnull +12 -> 1041
    //   1032: aload 19
    //   1034: lload 9
    //   1036: invokeinterface 2606 3 0
    //   1041: invokestatic 668	com/tencent/mobileqq/utils/AudioHelper:d	()Z
    //   1044: ifeq +46 -> 1090
    //   1047: aload_0
    //   1048: getfield 251	com/tencent/av/ui/AVActivity:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1051: iconst_1
    //   1052: new 230	java/lang/StringBuilder
    //   1055: dup
    //   1056: invokespecial 231	java/lang/StringBuilder:<init>	()V
    //   1059: ldc_w 2608
    //   1062: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1065: aload_0
    //   1066: invokevirtual 1935	com/tencent/av/ui/AVActivity:getWindow	()Landroid/view/Window;
    //   1069: invokevirtual 432	android/view/Window:getDecorView	()Landroid/view/View;
    //   1072: invokevirtual 437	android/view/View:getSystemUiVisibility	()I
    //   1075: invokevirtual 302	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1078: ldc_w 388
    //   1081: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1084: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1087: invokestatic 391	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1090: aload_0
    //   1091: getfield 178	com/tencent/av/ui/AVActivity:jdField_a_of_type_Lal	Llal;
    //   1094: aload_0
    //   1095: aload_0
    //   1096: getfield 138	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvAppVideoAppInterface	Lcom/tencent/av/app/VideoAppInterface;
    //   1099: aload_0
    //   1100: getfield 140	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvVideoController	Lcom/tencent/av/VideoController;
    //   1103: invokevirtual 2611	lal:a	(Lmqq/app/BaseActivity;Lcom/tencent/av/app/VideoAppInterface;Lcom/tencent/av/VideoController;)V
    //   1106: aload_0
    //   1107: getfield 907	com/tencent/av/ui/AVActivity:jdField_a_of_type_Mbo	Lmbo;
    //   1110: ifnull +10 -> 1120
    //   1113: aload_0
    //   1114: getfield 907	com/tencent/av/ui/AVActivity:jdField_a_of_type_Mbo	Lmbo;
    //   1117: invokevirtual 911	mbo:b	()V
    //   1120: return
    //   1121: astore 19
    //   1123: aload_0
    //   1124: getfield 251	com/tencent/av/ui/AVActivity:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1127: iconst_1
    //   1128: new 230	java/lang/StringBuilder
    //   1131: dup
    //   1132: invokespecial 231	java/lang/StringBuilder:<init>	()V
    //   1135: ldc_w 2613
    //   1138: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1141: aload 19
    //   1143: invokevirtual 724	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1146: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1149: invokestatic 307	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1152: goto -1082 -> 70
    //   1155: iconst_0
    //   1156: istore 15
    //   1158: goto -805 -> 353
    //   1161: aload 20
    //   1163: ldc_w 2615
    //   1166: invokevirtual 2618	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1169: ifeq -759 -> 410
    //   1172: aload_0
    //   1173: getfield 884	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvCameraCameraUtils	Lcom/tencent/av/camera/CameraUtils;
    //   1176: invokevirtual 2621	com/tencent/av/camera/CameraUtils:a	()Landroid/hardware/Camera$Parameters;
    //   1179: ifnonnull -769 -> 410
    //   1182: aload_0
    //   1183: getfield 884	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvCameraCameraUtils	Lcom/tencent/av/camera/CameraUtils;
    //   1186: ldc_w 2623
    //   1189: lload 9
    //   1191: iconst_m1
    //   1192: iconst_m1
    //   1193: invokevirtual 2626	com/tencent/av/camera/CameraUtils:a	(Ljava/lang/String;JII)V
    //   1196: goto -786 -> 410
    //   1199: aload_0
    //   1200: getfield 590	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   1203: lload 9
    //   1205: iconst_1
    //   1206: iconst_0
    //   1207: invokevirtual 887	com/tencent/av/ui/VideoLayerUI:a	(JZZ)Z
    //   1210: pop
    //   1211: aload_0
    //   1212: getfield 590	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   1215: lload 9
    //   1217: aload 19
    //   1219: iconst_1
    //   1220: iconst_1
    //   1221: iconst_0
    //   1222: iload 15
    //   1224: invokevirtual 1357	com/tencent/av/ui/VideoLayerUI:a	(JLjava/lang/String;IZZZ)V
    //   1227: goto -754 -> 473
    //   1230: iload 18
    //   1232: ifeq +18 -> 1250
    //   1235: aload_0
    //   1236: getfield 590	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   1239: lload 9
    //   1241: iconst_1
    //   1242: iconst_0
    //   1243: invokevirtual 887	com/tencent/av/ui/VideoLayerUI:a	(JZZ)Z
    //   1246: pop
    //   1247: goto -774 -> 473
    //   1250: iload 16
    //   1252: ifeq -779 -> 473
    //   1255: aload_0
    //   1256: getfield 590	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   1259: lload 9
    //   1261: aload 19
    //   1263: iconst_1
    //   1264: iconst_1
    //   1265: iconst_0
    //   1266: iload 15
    //   1268: invokevirtual 1357	com/tencent/av/ui/VideoLayerUI:a	(JLjava/lang/String;IZZZ)V
    //   1271: goto -798 -> 473
    //   1274: aload 21
    //   1276: getfield 1781	kvq:ag	Z
    //   1279: ifne -806 -> 473
    //   1282: aload_0
    //   1283: getfield 124	com/tencent/av/ui/AVActivity:jdField_f_of_type_Boolean	Z
    //   1286: ifne -813 -> 473
    //   1289: aload 21
    //   1291: lload 9
    //   1293: iconst_1
    //   1294: invokevirtual 895	kvq:a	(JZ)V
    //   1297: aload_0
    //   1298: getfield 884	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvCameraCameraUtils	Lcom/tencent/av/camera/CameraUtils;
    //   1301: lload 9
    //   1303: invokevirtual 2532	com/tencent/av/camera/CameraUtils:a	(J)V
    //   1306: aload_0
    //   1307: getfield 590	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   1310: ifnull -837 -> 473
    //   1313: aload_0
    //   1314: getfield 590	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   1317: lload 9
    //   1319: iconst_1
    //   1320: iconst_0
    //   1321: invokevirtual 887	com/tencent/av/ui/VideoLayerUI:a	(JZZ)Z
    //   1324: pop
    //   1325: goto -852 -> 473
    //   1328: aload 21
    //   1330: getfield 504	kvq:jdField_d_of_type_Int	I
    //   1333: iconst_4
    //   1334: if_icmpne -861 -> 473
    //   1337: aload 21
    //   1339: getfield 1329	kvq:jdField_c_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   1342: astore 23
    //   1344: aload 23
    //   1346: new 2628	lqk
    //   1349: dup
    //   1350: aload_0
    //   1351: invokespecial 2629	lqk:<init>	(Lcom/tencent/av/ui/AVActivity;)V
    //   1354: invokestatic 2635	java/util/Collections:sort	(Ljava/util/List;Ljava/util/Comparator;)V
    //   1357: aload_0
    //   1358: getfield 140	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvVideoController	Lcom/tencent/av/VideoController;
    //   1361: invokevirtual 2349	com/tencent/av/VideoController:g	()I
    //   1364: istore 4
    //   1366: iconst_0
    //   1367: istore_3
    //   1368: iload_3
    //   1369: aload 23
    //   1371: invokevirtual 1334	java/util/ArrayList:size	()I
    //   1374: if_icmpge -901 -> 473
    //   1377: aload 23
    //   1379: iload_3
    //   1380: invokevirtual 1338	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1383: checkcast 1340	leb
    //   1386: astore 24
    //   1388: aload 24
    //   1390: getfield 1341	leb:jdField_a_of_type_Long	J
    //   1393: invokestatic 1346	mfy:a	(J)Ljava/lang/String;
    //   1396: astore 25
    //   1398: aload 24
    //   1400: getfield 1347	leb:jdField_a_of_type_Int	I
    //   1403: istore 5
    //   1405: aload 24
    //   1407: getfield 2636	leb:jdField_a_of_type_Boolean	Z
    //   1410: istore 16
    //   1412: aload_0
    //   1413: getfield 590	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   1416: ifnull +371 -> 1787
    //   1419: aload_0
    //   1420: getfield 590	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   1423: aload 25
    //   1425: iload 5
    //   1427: invokevirtual 2639	com/tencent/av/ui/VideoLayerUI:a	(Ljava/lang/String;I)Z
    //   1430: istore 15
    //   1432: aload_0
    //   1433: getfield 84	com/tencent/av/ui/AVActivity:jdField_d_of_type_Int	I
    //   1436: invokestatic 2642	mfs:b	(I)I
    //   1439: istore 6
    //   1441: aload_0
    //   1442: getfield 138	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvAppVideoAppInterface	Lcom/tencent/av/app/VideoAppInterface;
    //   1445: iload 6
    //   1447: aload 25
    //   1449: aload 21
    //   1451: getfield 1607	kvq:jdField_g_of_type_Long	J
    //   1454: invokestatic 1511	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1457: invokevirtual 2016	com/tencent/av/app/VideoAppInterface:getDisplayName	(ILjava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1460: astore 20
    //   1462: aload 24
    //   1464: getfield 2643	leb:jdField_b_of_type_Boolean	Z
    //   1467: ifeq +126 -> 1593
    //   1470: aload 25
    //   1472: aload_0
    //   1473: getfield 138	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvAppVideoAppInterface	Lcom/tencent/av/app/VideoAppInterface;
    //   1476: invokevirtual 685	com/tencent/av/app/VideoAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1479: invokevirtual 1354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1482: ifne +111 -> 1593
    //   1485: iload 16
    //   1487: ifeq +106 -> 1593
    //   1490: aload 24
    //   1492: getfield 2644	leb:jdField_d_of_type_Boolean	Z
    //   1495: ifne +98 -> 1593
    //   1498: aload 20
    //   1500: invokestatic 2646	mfy:a	(Ljava/lang/String;)I
    //   1503: bipush 20
    //   1505: if_icmple +561 -> 2066
    //   1508: new 230	java/lang/StringBuilder
    //   1511: dup
    //   1512: invokespecial 231	java/lang/StringBuilder:<init>	()V
    //   1515: aload 20
    //   1517: iconst_0
    //   1518: bipush 20
    //   1520: invokestatic 2649	mfy:a	(Ljava/lang/String;II)Ljava/lang/String;
    //   1523: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1526: ldc_w 2651
    //   1529: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1532: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1535: astore 19
    //   1537: iload 5
    //   1539: iconst_2
    //   1540: if_icmpne +269 -> 1809
    //   1543: aload_0
    //   1544: ldc_w 2652
    //   1547: invokevirtual 2653	com/tencent/av/ui/AVActivity:getString	(I)Ljava/lang/String;
    //   1550: iconst_1
    //   1551: anewarray 1265	java/lang/Object
    //   1554: dup
    //   1555: iconst_0
    //   1556: aload 19
    //   1558: aastore
    //   1559: invokestatic 2657	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1562: astore 19
    //   1564: aload_0
    //   1565: getfield 501	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoControlUI	Lcom/tencent/av/ui/VideoControlUI;
    //   1568: ifnull +225 -> 1793
    //   1571: aload_0
    //   1572: getfield 501	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoControlUI	Lcom/tencent/av/ui/VideoControlUI;
    //   1575: instanceof 2659
    //   1578: ifeq +215 -> 1793
    //   1581: aload_0
    //   1582: getfield 501	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoControlUI	Lcom/tencent/av/ui/VideoControlUI;
    //   1585: sipush 1036
    //   1588: aload 19
    //   1590: invokevirtual 2662	com/tencent/av/ui/VideoControlUI:a	(ILjava/lang/String;)V
    //   1593: aload_0
    //   1594: getfield 590	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   1597: ifnull +183 -> 1780
    //   1600: aload_0
    //   1601: invokespecial 356	com/tencent/av/ui/AVActivity:j	()V
    //   1604: aload 24
    //   1606: getfield 2643	leb:jdField_b_of_type_Boolean	Z
    //   1609: ifne +381 -> 1990
    //   1612: aload 24
    //   1614: getfield 2636	leb:jdField_a_of_type_Boolean	Z
    //   1617: ifne +373 -> 1990
    //   1620: iload 4
    //   1622: iconst_4
    //   1623: if_icmpeq +337 -> 1960
    //   1626: aload 21
    //   1628: getfield 2665	kvq:C	I
    //   1631: iconst_2
    //   1632: if_icmpne +246 -> 1878
    //   1635: aconst_null
    //   1636: ldc_w 1147
    //   1639: ldc_w 397
    //   1642: ldc_w 397
    //   1645: ldc_w 2667
    //   1648: ldc_w 2667
    //   1651: iconst_0
    //   1652: iconst_0
    //   1653: ldc_w 397
    //   1656: ldc_w 397
    //   1659: ldc_w 397
    //   1662: ldc_w 397
    //   1665: invokestatic 1155	awqx:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1668: aload_0
    //   1669: getfield 590	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   1672: lload 9
    //   1674: aload 25
    //   1676: iload 5
    //   1678: aload_0
    //   1679: getfield 144	com/tencent/av/ui/AVActivity:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   1682: aload 24
    //   1684: getfield 2643	leb:jdField_b_of_type_Boolean	Z
    //   1687: aload 24
    //   1689: getfield 2636	leb:jdField_a_of_type_Boolean	Z
    //   1692: invokevirtual 2670	com/tencent/av/ui/VideoLayerUI:a	(JLjava/lang/String;ILandroid/graphics/Bitmap;ZZ)V
    //   1695: iload 15
    //   1697: ifne +83 -> 1780
    //   1700: aload 21
    //   1702: getfield 1453	kvq:jdField_I_of_type_Boolean	Z
    //   1705: ifne +75 -> 1780
    //   1708: ldc_w 2671
    //   1711: fstore_2
    //   1712: fload_2
    //   1713: fstore_1
    //   1714: aload_0
    //   1715: getfield 590	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   1718: aload 25
    //   1720: iload 5
    //   1722: invokevirtual 2673	com/tencent/av/ui/VideoLayerUI:b	(Ljava/lang/String;I)Z
    //   1725: ifeq +20 -> 1745
    //   1728: fload_2
    //   1729: fstore_1
    //   1730: aload_0
    //   1731: getfield 590	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   1734: invokevirtual 841	com/tencent/av/ui/VideoLayerUI:f	()I
    //   1737: iconst_3
    //   1738: if_icmpeq +7 -> 1745
    //   1741: ldc_w 2674
    //   1744: fstore_1
    //   1745: aload_0
    //   1746: invokevirtual 563	com/tencent/av/ui/AVActivity:getApplicationContext	()Landroid/content/Context;
    //   1749: fload_1
    //   1750: invokestatic 2677	mjg:a	(Landroid/content/Context;F)F
    //   1753: fstore_1
    //   1754: aload_0
    //   1755: getfield 590	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   1758: aload 25
    //   1760: iload 5
    //   1762: aload 20
    //   1764: fload_1
    //   1765: iconst_m1
    //   1766: invokevirtual 2680	com/tencent/av/ui/VideoLayerUI:a	(Ljava/lang/String;ILjava/lang/String;FI)V
    //   1769: aload_0
    //   1770: getfield 590	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   1773: aload 25
    //   1775: iload 5
    //   1777: invokevirtual 2681	com/tencent/av/ui/VideoLayerUI:a	(Ljava/lang/String;I)V
    //   1780: iload_3
    //   1781: iconst_1
    //   1782: iadd
    //   1783: istore_3
    //   1784: goto -416 -> 1368
    //   1787: iconst_0
    //   1788: istore 15
    //   1790: goto -358 -> 1432
    //   1793: aload_0
    //   1794: getfield 138	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvAppVideoAppInterface	Lcom/tencent/av/app/VideoAppInterface;
    //   1797: sipush 1036
    //   1800: aload 19
    //   1802: invokestatic 2684	lqb:a	(Lcom/tencent/av/app/VideoAppInterface;ILjava/lang/String;)Z
    //   1805: pop
    //   1806: goto -213 -> 1593
    //   1809: aload_0
    //   1810: ldc_w 2685
    //   1813: invokevirtual 2653	com/tencent/av/ui/AVActivity:getString	(I)Ljava/lang/String;
    //   1816: iconst_1
    //   1817: anewarray 1265	java/lang/Object
    //   1820: dup
    //   1821: iconst_0
    //   1822: aload 19
    //   1824: aastore
    //   1825: invokestatic 2657	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1828: astore 19
    //   1830: aload_0
    //   1831: getfield 501	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoControlUI	Lcom/tencent/av/ui/VideoControlUI;
    //   1834: ifnull +28 -> 1862
    //   1837: aload_0
    //   1838: getfield 501	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoControlUI	Lcom/tencent/av/ui/VideoControlUI;
    //   1841: instanceof 2659
    //   1844: ifeq +18 -> 1862
    //   1847: aload_0
    //   1848: getfield 501	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoControlUI	Lcom/tencent/av/ui/VideoControlUI;
    //   1851: sipush 1037
    //   1854: aload 19
    //   1856: invokevirtual 2662	com/tencent/av/ui/VideoControlUI:a	(ILjava/lang/String;)V
    //   1859: goto -266 -> 1593
    //   1862: aload_0
    //   1863: getfield 138	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvAppVideoAppInterface	Lcom/tencent/av/app/VideoAppInterface;
    //   1866: sipush 1037
    //   1869: aload 19
    //   1871: invokestatic 2684	lqb:a	(Lcom/tencent/av/app/VideoAppInterface;ILjava/lang/String;)Z
    //   1874: pop
    //   1875: goto -282 -> 1593
    //   1878: aload 21
    //   1880: getfield 1245	kvq:jdField_A_of_type_Int	I
    //   1883: bipush 10
    //   1885: if_icmpne +39 -> 1924
    //   1888: aconst_null
    //   1889: ldc_w 1147
    //   1892: ldc_w 397
    //   1895: ldc_w 397
    //   1898: ldc_w 2687
    //   1901: ldc_w 2687
    //   1904: iconst_0
    //   1905: iconst_0
    //   1906: ldc_w 397
    //   1909: ldc_w 397
    //   1912: ldc_w 397
    //   1915: ldc_w 397
    //   1918: invokestatic 1155	awqx:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1921: goto -253 -> 1668
    //   1924: aconst_null
    //   1925: ldc_w 1147
    //   1928: ldc_w 397
    //   1931: ldc_w 397
    //   1934: ldc_w 2689
    //   1937: ldc_w 2689
    //   1940: iconst_0
    //   1941: iconst_0
    //   1942: ldc_w 397
    //   1945: ldc_w 397
    //   1948: ldc_w 397
    //   1951: ldc_w 397
    //   1954: invokestatic 1155	awqx:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1957: goto -289 -> 1668
    //   1960: aload_0
    //   1961: getfield 590	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   1964: lload 9
    //   1966: aload 25
    //   1968: iload 5
    //   1970: aload_0
    //   1971: getfield 146	com/tencent/av/ui/AVActivity:jdField_b_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   1974: aload 24
    //   1976: getfield 2643	leb:jdField_b_of_type_Boolean	Z
    //   1979: aload 24
    //   1981: getfield 2636	leb:jdField_a_of_type_Boolean	Z
    //   1984: invokevirtual 2670	com/tencent/av/ui/VideoLayerUI:a	(JLjava/lang/String;ILandroid/graphics/Bitmap;ZZ)V
    //   1987: goto -292 -> 1695
    //   1990: aload_0
    //   1991: getfield 590	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   1994: lload 9
    //   1996: aload 25
    //   1998: iload 5
    //   2000: aload_0
    //   2001: getfield 146	com/tencent/av/ui/AVActivity:jdField_b_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   2004: aload 24
    //   2006: getfield 2643	leb:jdField_b_of_type_Boolean	Z
    //   2009: aload 24
    //   2011: getfield 2636	leb:jdField_a_of_type_Boolean	Z
    //   2014: invokevirtual 2670	com/tencent/av/ui/VideoLayerUI:a	(JLjava/lang/String;ILandroid/graphics/Bitmap;ZZ)V
    //   2017: goto -322 -> 1695
    //   2020: aload_0
    //   2021: getfield 138	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvAppVideoAppInterface	Lcom/tencent/av/app/VideoAppInterface;
    //   2024: sipush 1023
    //   2027: ldc_w 2690
    //   2030: invokestatic 545	lqb:a	(Lcom/tencent/av/app/VideoAppInterface;II)Z
    //   2033: pop
    //   2034: ldc_w 2692
    //   2037: invokestatic 875	mct:a	(Ljava/lang/String;)V
    //   2040: goto -1236 -> 804
    //   2043: invokestatic 1224	lja:a	()Llja;
    //   2046: iconst_1
    //   2047: invokevirtual 2584	lja:b	(I)V
    //   2050: goto -1161 -> 889
    //   2053: ldc2_w 2254
    //   2056: lstore 7
    //   2058: goto -1139 -> 919
    //   2061: astore 19
    //   2063: goto -1213 -> 850
    //   2066: aload 20
    //   2068: astore 19
    //   2070: goto -533 -> 1537
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2073	0	this	AVActivity
    //   1713	52	1	f1	float
    //   1711	18	2	f2	float
    //   1367	417	3	i1	int
    //   1364	260	4	i2	int
    //   1403	596	5	i3	int
    //   1439	7	6	i4	int
    //   917	1140	7	l1	long
    //   8	1987	9	l2	long
    //   892	34	11	l3	long
    //   900	28	13	l4	long
    //   351	1438	15	bool1	boolean
    //   333	1153	16	bool2	boolean
    //   358	70	17	bool3	boolean
    //   365	866	18	bool4	boolean
    //   326	707	19	localObject1	Object
    //   1121	141	19	localIllegalArgumentException	java.lang.IllegalArgumentException
    //   1535	335	19	str1	String
    //   2061	1	19	localException	Exception
    //   2068	1	19	localObject2	Object
    //   375	1692	20	str2	String
    //   76	1803	21	localkvq	kvq
    //   156	764	22	localkyl	kyl
    //   1342	36	23	localArrayList	ArrayList
    //   1386	624	24	localleb	leb
    //   1396	601	25	str3	String
    // Exception table:
    //   from	to	target	type
    //   61	70	1121	java/lang/IllegalArgumentException
    //   843	850	2061	java/lang/Exception
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
    kvq localkvq = ksn.a().a();
    kyj.a(20, 1L);
    if ((localkvq != null) && (localkvq.j())) {
      kyj.a(31);
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
    if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_A_of_type_Boolean) && (this.jdField_a_of_type_Lxz != null))
    {
      this.jdField_a_of_type_Lxz.c();
      if (this.jdField_a_of_type_Lxz.b() < 1000L) {
        break label278;
      }
    }
    label278:
    for (int i1 = 1;; i1 = 2)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a().u = i1;
      awqx.b(null, "CliOper", "", "", "0X800863D", "0X800863D", 0, 0, "", "", "", "");
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
    if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_A_of_type_Int == 2)) {
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