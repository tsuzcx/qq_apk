package com.tencent.av.ui;

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
import android.media.AudioManager;
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
import android.view.Display;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewStub;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.Toast;
import androidx.annotation.RequiresApi;
import aqrl;
import bdla;
import bhhr;
import bibh;
import bibn;
import biwn;
import bkzi;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.magicface.FaceItem;
import com.tencent.av.business.manager.voiceRecog.VoiceRecogTips;
import com.tencent.av.camera.CameraUtils;
import com.tencent.av.opengl.GraphicRenderMgr;
import com.tencent.av.ui.funchat.filter.EffectFilterPanel;
import com.tencent.av.ui.funchat.record.QavRecordButtonView;
import com.tencent.av.ui.guide.GuideHelper;
import com.tencent.av.wtogether.data.ChooseFileInfo;
import com.tencent.av.wtogether.media.WatchTogetherMediaPlayCtrl;
import com.tencent.av.wtogether.view.WatchTogetherAdminControlView;
import com.tencent.av.wtogether.view.WatchTogetherOrdinaryControlView;
import com.tencent.avcore.jni.data.SDKConfigInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.debug.PstnCardTestActivity;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.mqsafeedit.MD5;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.vipav.VipFullScreenVideoView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import dov.com.tencent.mobileqq.richmedia.capture.util.LiuHaiUtils;
import java.io.File;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import lbd;
import lby;
import lbz;
import lcf;
import lci;
import lee;
import lfe;
import lff;
import lfk;
import lfm;
import lhd;
import lhw;
import lii;
import lik;
import ljh;
import ljr;
import lkf;
import lkn;
import llh;
import lls;
import lob;
import lph;
import ltm;
import ltn;
import lvv;
import lvy;
import lwa;
import lwf;
import lzh;
import lzr;
import mbf;
import mbm;
import mbn;
import mbp;
import mbq;
import mbr;
import mbs;
import mbt;
import mbu;
import mbv;
import mbw;
import mby;
import mcb;
import mcc;
import mcq;
import mcv;
import mcx;
import mdb;
import mdc;
import mez;
import mhw;
import mji;
import mjw;
import mml;
import mnm;
import mnr;
import mor;
import mqb;
import mqq.app.BaseActivity;
import mqq.app.MobileQQ;
import mqx;
import mrr;
import mry;
import msa;
import mtr;
import mts;
import mtt;
import mvk;
import mxd;
import mxk;
import mym;
import mzk;

public class AVActivity
  extends BaseActivity
  implements SensorEventListener, ljh, ltn
{
  public int a;
  long jdField_a_of_type_Long = 0L;
  Dialog jdField_a_of_type_AndroidAppDialog = null;
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = null;
  public Bitmap a;
  private Sensor jdField_a_of_type_AndroidHardwareSensor;
  private SensorManager jdField_a_of_type_AndroidHardwareSensorManager;
  Handler jdField_a_of_type_AndroidOsHandler = new mbs(this);
  private MessageQueue.IdleHandler jdField_a_of_type_AndroidOsMessageQueue$IdleHandler = new mbm(this);
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = null;
  public RelativeLayout a;
  public bibn a;
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
  public Integer a;
  public Runnable a;
  public String a;
  public WeakReference<Activity> a;
  lee jdField_a_of_type_Lee = new mbv(this);
  lfk jdField_a_of_type_Lfk = new mcb(this);
  ljr jdField_a_of_type_Ljr = new mbt(this);
  private lkn jdField_a_of_type_Lkn = new lkn();
  private lzh jdField_a_of_type_Lzh;
  mcc jdField_a_of_type_Mcc = null;
  public mcq a;
  private mcv jdField_a_of_type_Mcv;
  public mcx a;
  public mhw a;
  public mji a;
  public mjw a;
  public mml a;
  public mnm a;
  private mts jdField_a_of_type_Mts;
  mtt jdField_a_of_type_Mtt = null;
  private mym jdField_a_of_type_Mym;
  boolean jdField_a_of_type_Boolean = false;
  byte[] jdField_a_of_type_ArrayOfByte = null;
  public int b;
  long jdField_b_of_type_Long = 0L;
  public Bitmap b;
  public Integer b;
  Runnable jdField_b_of_type_JavaLangRunnable = new AVActivity.3(this);
  public final String b;
  private mym jdField_b_of_type_Mym;
  boolean jdField_b_of_type_Boolean = true;
  int jdField_c_of_type_Int = 0;
  public Integer c;
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
    this.jdField_a_of_type_Mml = null;
    this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    this.jdField_b_of_type_AndroidGraphicsBitmap = null;
    this.jdField_a_of_type_Mcx = new mby(this);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(this);
    this.jdField_a_of_type_ComTencentAvUiGuideGuideHelper = new GuideHelper();
    this.jdField_a_of_type_Bibn = new mbn(this);
    this.jdField_k_of_type_Boolean = false;
    this.jdField_m_of_type_Boolean = false;
    this.mIsShadow = false;
    this.jdField_b_of_type_JavaLangString = ("AVActivity_" + AudioHelper.b());
  }
  
  private String a(Intent paramIntent)
  {
    int i2 = paramIntent.getIntExtra("uinType", -1);
    int i3 = mvk.b(i2);
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
      return lbz.a(i3, str2, new int[0]);
    }
  }
  
  private void a(Intent paramIntent)
  {
    if (paramIntent == null) {}
    do
    {
      return;
      paramIntent.setExtrasClassLoader(ChooseFileInfo.class.getClassLoader());
      paramIntent = (ChooseFileInfo)paramIntent.getParcelableExtra("ChooseFileInfo");
    } while ((paramIntent == null) || (this.jdField_d_of_type_Int != 0));
    ((mxd)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(15)).a(3, this.jdField_c_of_type_JavaLangString, paramIntent, null);
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
    LiuHaiUtils.a(paramActivity);
    if (LiuHaiUtils.b())
    {
      int i1 = LiuHaiUtils.b(paramActivity);
      int i2 = ImmersiveUtils.getStatusBarHeight(paramActivity);
      QLog.w(ImmersiveUtils.jdField_a_of_type_JavaLangString, 1, "initLiuHaiProperty, onAttachedToWindow, notchheight[" + i1 + "], statusBarHeight[" + i2 + "]");
      if (LiuHaiUtils.enableNotch(paramActivity))
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
  
  private void c(int paramInt)
  {
    Object localObject = lbz.a().a();
    if ((localObject == null) || (!((lfe)localObject).A())) {}
    do
    {
      return;
      localObject = this.jdField_a_of_type_ComTencentAvVideoController.a();
    } while ((localObject == null) || (((WatchTogetherMediaPlayCtrl)localObject).a() == paramInt));
    ((WatchTogetherMediaPlayCtrl)localObject).a(paramInt);
    if (((WatchTogetherMediaPlayCtrl)localObject).j()) {
      ((WatchTogetherMediaPlayCtrl)localObject).a(false);
    }
    m();
  }
  
  private void c(String paramString)
  {
    if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (AudioHelper.jdField_b_of_type_Boolean)) {
      this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_b_of_type_JavaLangString = paramString;
    }
  }
  
  private void h(long paramLong)
  {
    boolean bool2 = true;
    if (isDestroyed()) {}
    label10:
    label324:
    do
    {
      do
      {
        Object localObject;
        do
        {
          int i1;
          do
          {
            do
            {
              do
              {
                do
                {
                  break label10;
                  break label10;
                  break label10;
                  break label10;
                  break label10;
                  do
                  {
                    return;
                  } while ((this.jdField_a_of_type_ComTencentAvUiVideoControlUI == null) || (this.jdField_a_of_type_ComTencentAvUiVideoControlUI.h()));
                  localObject = this.jdField_a_of_type_ComTencentAvVideoController.a();
                  i1 = ((lfe)localObject).jdField_d_of_type_Int;
                  bool1 = ((lfe)localObject).A();
                  if (QLog.isDevelopLevel()) {
                    QLog.w(this.jdField_b_of_type_JavaLangString, 4, "switchToolbar, sessionType[" + i1 + "], isInviting[" + ((lfe)localObject).h() + "], isToolBarDisplay[" + this.jdField_a_of_type_ComTencentAvUiVideoControlUI.i() + "|" + this.jdField_a_of_type_ComTencentAvUiVideoControlUI.jdField_h_of_type_Boolean + "], watch[" + bool1 + "], curMenu[" + this.jdField_a_of_type_ComTencentAvUiVideoControlUI.a.b() + "], seq[" + paramLong + "]");
                  }
                  if (!bool1) {
                    break label324;
                  }
                  if ((this.jdField_a_of_type_ComTencentAvUiVideoLayerUI == null) || (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.n != 2)) {
                    break;
                  }
                  if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI.i()) {
                    this.jdField_a_of_type_ComTencentAvUiVideoControlUI.g("switchToolbar");
                  }
                  i1 = 1;
                  bool1 = false;
                  localObject = VideoController.a().a();
                } while (localObject == null);
                localObject = a(((WatchTogetherMediaPlayCtrl)localObject).i());
              } while (i1 != 0);
              if (!bool1) {}
              for (boolean bool1 = bool2;; bool1 = false)
              {
                ((mym)localObject).setImmersiveStatus(bool1);
                return;
                this.jdField_a_of_type_ComTencentAvUiVideoControlUI.c(0);
                boolean bool3 = this.jdField_a_of_type_ComTencentAvUiVideoControlUI.jdField_h_of_type_Boolean;
                if (!bool3) {}
                for (bool1 = true;; bool1 = false)
                {
                  ((lfe)localObject).c(bool1);
                  i1 = 0;
                  bool1 = bool3;
                  break;
                }
              }
              if ((i1 != 1) && (i1 != 3)) {
                break;
              }
              if ((this.jdField_a_of_type_ComTencentAvUiVideoControlUI.a.b(1)) || (this.jdField_a_of_type_ComTencentAvUiVideoControlUI.a.b(3))) {
                this.jdField_a_of_type_ComTencentAvUiVideoControlUI.a.a(paramLong, 0, true);
              }
            } while ((this.jdField_a_of_type_ComTencentAvUiVideoControlUI.jdField_h_of_type_Boolean) && (this.jdField_a_of_type_ComTencentAvUiVideoControlUI.i()));
            this.jdField_a_of_type_ComTencentAvUiVideoControlUI.c(0);
            return;
            if (!((lfe)localObject).h()) {
              break;
            }
          } while ((i1 != 2) || ((!this.jdField_a_of_type_ComTencentAvUiVideoControlUI.a.b(1)) && (!this.jdField_a_of_type_ComTencentAvUiVideoControlUI.a.b(3))));
          this.jdField_a_of_type_ComTencentAvUiVideoControlUI.a.a(paramLong, 0, true);
          return;
        } while ((this.jdField_a_of_type_Mcq != null) && (this.jdField_a_of_type_Mcq.a()));
        if ((!((lfe)localObject).jdField_B_of_type_Boolean) || (this.jdField_a_of_type_ComTencentAvUiVideoControlUI.i())) {
          break;
        }
      } while (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null);
      mbf.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1022, 2131695497);
      return;
      if (!a())
      {
        if ((!this.jdField_a_of_type_ComTencentAvUiVideoControlUI.i()) && ((this.jdField_a_of_type_ComTencentAvUiVideoControlUI.a.b(1)) || (this.jdField_a_of_type_ComTencentAvUiVideoControlUI.a.b(3)))) {
          this.jdField_a_of_type_ComTencentAvUiVideoControlUI.a.a(paramLong, 0, false);
        }
        b(paramLong, "switchToolbar", this.jdField_a_of_type_ComTencentAvUiVideoControlUI.i());
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
      this.jdField_b_of_type_AndroidGraphicsBitmap = mvk.a(getApplicationContext(), 2130841982);
    }
  }
  
  private void l()
  {
    View localView = findViewById(2131373767);
    if ((localView != null) && (this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch == null) && (!isDestroyed())) {
      runOnUiThread(new AVActivity.9(this, localView));
    }
  }
  
  private void m()
  {
    if ((this.jdField_h_of_type_Int == 0) || (this.jdField_h_of_type_Int == 180))
    {
      setRequestedOrientation(1);
      QLog.d(this.jdField_b_of_type_JavaLangString, 1, "setRequestedOrientation, displayRotation[ActivityInfo.SCREEN_ORIENTATION_PORTRAIT]");
      return;
    }
    if (this.jdField_h_of_type_Int == 90)
    {
      setRequestedOrientation(8);
      QLog.d(this.jdField_b_of_type_JavaLangString, 1, "setRequestedOrientation, displayRotation[ActivityInfo.SCREEN_ORIENTATION_REVERSE_LANDSCAPE]");
      return;
    }
    setRequestedOrientation(0);
    QLog.d(this.jdField_b_of_type_JavaLangString, 1, "setRequestedOrientation, displayRotation[ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE]");
  }
  
  private void n()
  {
    if (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) {}
    do
    {
      return;
      View localView = super.findViewById(2131363136);
      this.jdField_a_of_type_ComTencentAvUiVideoLayerUI = new VideoLayerUI(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this, localView);
      this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(a());
      this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(new mbu(this));
    } while (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI == null);
    this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(this.jdField_a_of_type_Mji);
  }
  
  public void BtnOnClick(View paramView)
  {
    long l1 = AudioHelper.b();
    QLog.d(this.jdField_b_of_type_JavaLangString, 1, "BtnOnClick, id[" + mez.a(paramView.getId()) + "], nfonWindowFocus[" + this.jdField_j_of_type_Boolean + "], seq[" + l1 + "]");
    if (!this.jdField_j_of_type_Boolean) {}
    for (;;)
    {
      return;
      if ((paramView.getId() == 2131373459) || (paramView.getId() == 2131373460)) {
        b(true);
      }
      if ((this.jdField_a_of_type_Mcq != null) && (this.jdField_a_of_type_Mcq.a())) {
        this.jdField_a_of_type_Mcq.a(paramView);
      }
      while ((paramView.getId() == 2131373767) && (this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch != null))
      {
        lvv.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch, 1);
        this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = null;
        return;
        if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI != null)
        {
          this.jdField_a_of_type_ComTencentAvUiVideoControlUI.D(l1);
          msa.c(paramView.getId());
          this.jdField_a_of_type_ComTencentAvUiVideoControlUI.a(l1, paramView);
          e(l1);
        }
      }
    }
  }
  
  public void TestMenuBtnOnClick(View paramView)
  {
    paramView = new PopupMenu(this, paramView);
    mqx.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface).a(paramView);
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
    SharedPreferences localSharedPreferences = bhhr.a(getApplicationContext());
    String str = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
    return localSharedPreferences.getInt("showRecordTip" + String.valueOf(str), 0);
  }
  
  View a(long paramLong)
  {
    if ((this.jdField_a_of_type_Mts == null) || (!this.n))
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
    Object localObject = findViewById(2131373767);
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
    ImageView localImageView = (ImageView)findViewById(2131373638);
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
    QLog.i(this.jdField_b_of_type_JavaLangString, 1, "MoreBtnTips. showTips. mMoreBtnTipsImageDownloaded = " + this.n + ", mMoreBtnTips = " + this.jdField_a_of_type_Mts);
    localImageView.setImageDrawable(this.jdField_a_of_type_ComTencentImageURLDrawable);
    int i1 = AIOUtils.dp2px(10.0F, getResources());
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
  
  public lzh a()
  {
    return this.jdField_a_of_type_Lzh;
  }
  
  @TargetApi(21)
  @Nullable
  public mjw a()
  {
    if ((Build.VERSION.SDK_INT < 21) || (this.jdField_a_of_type_ComTencentAvVideoController == null)) {
      return null;
    }
    this.jdField_a_of_type_Mjw = this.jdField_a_of_type_ComTencentAvVideoController.a();
    this.jdField_a_of_type_Mjw.a(this);
    return this.jdField_a_of_type_Mjw;
  }
  
  public mym a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_Mym == null)
      {
        ((ViewStub)findViewById(2131373788)).inflate();
        this.jdField_a_of_type_Mym = ((WatchTogetherAdminControlView)findViewById(2131373787));
      }
      return this.jdField_a_of_type_Mym;
    }
    if (this.jdField_b_of_type_Mym == null)
    {
      ((ViewStub)findViewById(2131373790)).inflate();
      this.jdField_b_of_type_Mym = ((WatchTogetherOrdinaryControlView)findViewById(2131373789));
    }
    return this.jdField_b_of_type_Mym;
  }
  
  void a()
  {
    if (this.jdField_a_of_type_Mcc == null) {
      this.jdField_a_of_type_Mcc = new mcc(this, super.getApplicationContext(), 2);
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
    Object localObject;
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("changeVideoLayoutMode, mode[").append(paramInt).append("], ctrlUI[").append(this.jdField_a_of_type_ComTencentAvUiVideoControlUI).append("], curMode[");
      if (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI == null)
      {
        localObject = "null";
        QLog.i("WTogether", 4, localObject + "]");
      }
    }
    else
    {
      if (!isDestroyed()) {
        break label102;
      }
    }
    label102:
    while ((this.jdField_a_of_type_ComTencentAvUiVideoControlUI == null) || (this.jdField_a_of_type_ComTencentAvUiVideoControlUI.h()) || (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI == null) || (paramInt == this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.f()))
    {
      return;
      localObject = Integer.valueOf(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.f());
      break;
    }
    long l1 = AudioHelper.b();
    this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.g(paramInt);
    if (((this.jdField_a_of_type_ComTencentAvUiVideoControlUI instanceof DoubleVideoCtrlUI)) && ((paramInt == 2) || (paramInt == 1)))
    {
      this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.f(l1);
      ((DoubleVideoCtrlUI)this.jdField_a_of_type_ComTencentAvUiVideoControlUI).a(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.i(), c());
    }
    this.jdField_a_of_type_ComTencentAvUiVideoControlUI.D(l1);
    this.jdField_a_of_type_ComTencentAvUiVideoControlUI.i(l1, 16777215);
    if (this.jdField_a_of_type_Mji != null)
    {
      this.jdField_a_of_type_Mji.a(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.i(), this.jdField_a_of_type_ComTencentAvUiVideoControlUI, this.jdField_a_of_type_Mji.c());
      this.jdField_a_of_type_Mji.a(this.jdField_a_of_type_Mji.c());
      this.jdField_a_of_type_Mji.b(this.jdField_a_of_type_Mji.c());
    }
    if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_B_of_type_Boolean) && (!this.jdField_a_of_type_ComTencentAvVideoController.a().I)) {
      mor.a("0X8008ABA");
    }
    if ((this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterPanel != null) && (this.jdField_a_of_type_ComTencentAvVideoController != null))
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
      while (this.jdField_a_of_type_Mnm != null)
      {
        this.jdField_a_of_type_Mnm.a();
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
    int i6 = this.jdField_a_of_type_ComTencentAvUiVideoControlUI.c();
    Object localObject;
    if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI.i())
    {
      localObject = findViewById(2131373763);
      if ((localObject == null) || (!(((View)localObject).getLayoutParams() instanceof ViewGroup.MarginLayoutParams))) {
        break label522;
      }
    }
    label516:
    label522:
    for (int i1 = ((ViewGroup.MarginLayoutParams)((View)localObject).getLayoutParams()).topMargin;; i1 = 0)
    {
      int i2 = 0;
      int i3 = 0;
      int i7 = i5 + i3;
      int i4;
      label121:
      boolean bool;
      if (this.jdField_a_of_type_Mnm != null)
      {
        i4 = this.jdField_a_of_type_Mnm.a();
        if (QLog.isColorLevel()) {
          QLog.w("ChatRoomUtil", 1, "calcControlUIOffset, topOffset[" + i7 + "], topToolbarHeight[" + i5 + "], topToolbarTop[" + i1 + "], bottomToolbarHeight[" + i6 + "], chatRoomInputPanelHeight[" + i4 + "], recordBarHeight[" + i2 + "], systemBarHeight[" + i3 + "], from[" + paramInt + "], seq[" + paramLong + "]");
        }
        if (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null)
        {
          if ((c() != 1) || (i4 <= i6)) {
            break label453;
          }
          localObject = this.jdField_a_of_type_ComTencentAvUiVideoLayerUI;
          if (!this.jdField_a_of_type_ComTencentAvUiVideoControlUI.jdField_h_of_type_Boolean)
          {
            bool = true;
            label288:
            ((VideoLayerUI)localObject).a(paramLong, i7, i4, bool);
          }
        }
        else
        {
          this.jdField_a_of_type_ComTencentAvUiVideoControlUI.P();
          if ((this.jdField_a_of_type_Mnm == null) || (paramInt == 1)) {
            break;
          }
          this.jdField_a_of_type_Mnm.b(i6);
          return;
          if ((i5 != 0) || (!LiuHaiUtils.b())) {
            break label516;
          }
        }
      }
      for (i1 = LiuHaiUtils.b(this);; i1 = 0)
      {
        localObject = this.jdField_a_of_type_ComTencentAvVideoController.a();
        if ((((lfe)localObject).x()) && ((((lfe)localObject).jdField_B_of_type_Boolean) || (((lfe)localObject).C)) && (this.jdField_a_of_type_Mji != null) && (!this.jdField_a_of_type_Mji.d()))
        {
          i2 = this.jdField_a_of_type_Mji.c();
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
          break label288;
          label453:
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
    if ((paramInt1 == 2131373767) && (paramInt3 == 0))
    {
      a(paramLong, 2000L);
      this.jdField_a_of_type_ComTencentAvUiGuideGuideHelper.a(paramLong, this, 1, 0);
    }
  }
  
  public void a(long paramLong, int paramInt, boolean paramBoolean)
  {
    if (isDestroyed()) {}
    while ((this.jdField_a_of_type_ComTencentAvUiVideoControlUI == null) || (this.jdField_a_of_type_ComTencentAvUiVideoControlUI.h())) {
      return;
    }
    this.jdField_a_of_type_ComTencentAvUiVideoControlUI.b(paramLong, paramInt);
    this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(paramInt, false);
    this.jdField_a_of_type_ComTencentAvCameraCameraUtils.a(paramInt);
    this.jdField_h_of_type_Int = paramInt;
    if (this.jdField_a_of_type_Mji != null)
    {
      this.jdField_a_of_type_Mji.d(paramInt);
      this.jdField_a_of_type_Mji.d();
      this.jdField_a_of_type_Mji.a(this.jdField_a_of_type_ComTencentAvUiVideoControlUI, this.jdField_h_of_type_Int);
    }
    if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_B_of_type_Boolean) || (this.jdField_a_of_type_ComTencentAvVideoController.a().C)) {
      g(paramLong);
    }
    c(paramInt);
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    QLog.i(this.jdField_b_of_type_JavaLangString, 1, "MoreBtnTips. tryShow_qav_more_tips. mMoreBtnTipsImageDownloaded = " + this.n + ", mMoreBtnTips = " + this.jdField_a_of_type_Mts + ", delayMillis = " + paramLong2);
    if (this.jdField_a_of_type_Mts != null)
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
    Intent localIntent = AIOUtils.setOpenAIOIntent(new Intent(super.getApplicationContext(), SplashActivity.class), null);
    localIntent.putExtra("uin", paramString1);
    localIntent.putExtra("uintype", paramInt);
    localIntent.putExtra("uinname", paramString2);
    startActivity(localIntent);
    QLog.w(this.jdField_b_of_type_JavaLangString, 1, "enterChatWin, uin[" + paramString1 + "], type[" + paramInt + "], seq[" + paramLong + "]");
    this.jdField_e_of_type_Boolean = false;
    finish();
    paramInt = 2130772148;
    paramString1 = this.jdField_a_of_type_ComTencentAvVideoController.a();
    if (paramString1 != null) {
      paramInt = lzr.a(paramString1.L);
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
        paramBoolean = this.jdField_a_of_type_Mji.i();
        boolean bool = mji.f();
        if ((!paramBoolean) || (!bool)) {
          break;
        }
        mor.a("0X8008AB2");
      }
      return;
    }
    mor.a("0X8008AB1");
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentAvVideoController.a();
    QLog.w(this.jdField_b_of_type_JavaLangString, 1, "avideo onCreateUI, SessionType[" + ((lfe)localObject1).jdField_d_of_type_Int + "], seq[" + paramLong + "]");
    mqx.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this);
    Object localObject2 = this.jdField_a_of_type_ComTencentAvVideoController.a(getApplicationContext());
    if (localObject2 != null) {
      ((lph)localObject2).a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    }
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131373486));
    }
    this.jdField_a_of_type_JavaLangRunnable = new AVActivity.5(this);
    if (this.jdField_a_of_type_ComTencentAvCameraCameraUtils == null)
    {
      this.jdField_a_of_type_ComTencentAvCameraCameraUtils = CameraUtils.a(this);
      this.jdField_a_of_type_ComTencentAvCameraCameraUtils.a(this.jdField_a_of_type_Ljr);
      this.jdField_a_of_type_ComTencentAvCameraCameraUtils.a(this.jdField_a_of_type_ComTencentAvVideoController.jdField_a_of_type_Lcf);
    }
    localObject2 = super.findViewById(2131363136).findViewById(2131363133);
    try
    {
      ((View)localObject2).setBackgroundResource(2130842142);
      if (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI == null) {
        n();
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
      if ((this.jdField_b_of_type_Int == 2) || (this.jdField_b_of_type_Int == 4)) {
        VideoController.a().a(this);
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
        this.jdField_a_of_type_Mts = mtr.a(i1);
        if ((this.jdField_a_of_type_Mts != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_Mts.jdField_a_of_type_JavaLangString)))
        {
          localObject2 = URLDrawable.URLDrawableOptions.obtain();
          this.jdField_a_of_type_ComTencentImageURLDrawable = URLDrawable.getDrawable(this.jdField_a_of_type_Mts.jdField_a_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject2);
          this.n = false;
          this.jdField_a_of_type_ComTencentImageURLDrawable.setURLDrawableListener(new mbw(this));
          this.jdField_a_of_type_ComTencentImageURLDrawable.startDownload();
          if (1 == this.jdField_a_of_type_ComTencentImageURLDrawable.getStatus())
          {
            paramBoolean = true;
            this.n = paramBoolean;
            bdla.b(null, "CliOper", "", "", "0X800A75E", "0X800A75E", i1, this.jdField_a_of_type_Mts.jdField_a_of_type_Int, "", "", "", "");
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
              ((DoubleVideoCtrlUI)localObject2).a(2131373468, this.jdField_a_of_type_ComTencentAvVideoController.n, 2130842040);
              if (!this.jdField_a_of_type_ComTencentAvVideoController.p) {
                ((DoubleVideoCtrlUI)localObject2).a.a(true, 0, false);
              }
            }
          }
          if ((((lfe)localObject1).jdField_g_of_type_Int != 4) && (((lfe)localObject1).x()) && (!this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_Int == 1) && (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) && (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getParent() != null) && (!isDestroyed()))
          {
            i1 = mnr.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, ((lfe)localObject1).jdField_d_of_type_JavaLangString, true, true);
            if ((i1 > 0) && (this.jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView == null)) {
              this.jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView = bibh.a(this, (RelativeLayout)this.jdField_a_of_type_AndroidWidgetRelativeLayout.getParent(), false);
            }
            i2 = bibh.a();
            localObject1 = bibh.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, i1, i2, null);
            if (localObject1 != null)
            {
              localObject2 = new File((String)localObject1);
              if ((localObject2 == null) || (!((File)localObject2).exists())) {
                break label1363;
              }
              if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
                this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new AVActivity.7(this, (String)localObject1, i2, i1), 1000L);
              }
            }
          }
          this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView = ((QavRecordButtonView)findViewById(2131376385));
          a(paramLong, "onCreateUI", false);
          if (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) {
            this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.l(0);
          }
          localObject1 = (RelativeLayout)findViewById(2131381020);
          if ((localObject1 != null) && (mji.f()))
          {
            this.jdField_a_of_type_Mji = new mji(this, (RelativeLayout)localObject1, this.jdField_a_of_type_ComTencentAvVideoController, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_ComTencentAvUiVideoControlUI);
            this.jdField_a_of_type_Mji.c(1);
            if (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) {
              this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(this.jdField_a_of_type_Mji);
            }
          }
          l();
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
            break label1066;
          }
          this.jdField_a_of_type_ComTencentAvUiVideoControlUI = new DoubleVideoMeetingCtrlUI(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_Mcx);
          this.jdField_b_of_type_Int = ((lfe)localObject1).jdField_d_of_type_Int;
        }
        for (;;)
        {
          this.jdField_a_of_type_ComTencentAvUiVideoControlUI.m(this.jdField_a_of_type_ComTencentAvCameraCameraUtils.a());
          break;
          label1066:
          this.jdField_a_of_type_ComTencentAvUiVideoControlUI = new DoubleVideoCtrlUI(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_Mcx);
        }
        if (this.jdField_g_of_type_Boolean)
        {
          this.jdField_a_of_type_ComTencentAvUiVideoControlUI = new DoubleVideoMeetingCtrlUI(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_Mcx);
          this.jdField_b_of_type_Int = ((lfe)localObject1).jdField_d_of_type_Int;
        }
        else
        {
          this.jdField_a_of_type_ComTencentAvUiVideoControlUI = new DoubleVideoCtrlUI(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_Mcx);
          this.jdField_a_of_type_ComTencentAvUiVideoControlUI.m(this.jdField_a_of_type_ComTencentAvCameraCameraUtils.a());
          continue;
          if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI == null)
          {
            if (!this.jdField_g_of_type_Boolean) {
              break label1241;
            }
            this.jdField_a_of_type_ComTencentAvUiVideoControlUI = new DoubleVideoMeetingCtrlUI(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_Mcx);
            this.jdField_b_of_type_Int = ((lfe)localObject1).jdField_d_of_type_Int;
          }
          for (;;)
          {
            this.jdField_a_of_type_ComTencentAvUiVideoControlUI.m(this.jdField_a_of_type_ComTencentAvCameraCameraUtils.a());
            break;
            label1241:
            if (((lfe)localObject1).D == 1)
            {
              this.jdField_a_of_type_ComTencentAvUiVideoControlUI = new MultiVideoCtrlLayerUI4Discussion(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_Mcx);
            }
            else if (((lfe)localObject1).D == 10)
            {
              this.jdField_a_of_type_ComTencentAvUiVideoControlUI = new MultiVideoCtrlLayerUI4NewGroupChat(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_Mcx);
            }
            else
            {
              if (QLog.isColorLevel()) {
                QLog.d(this.jdField_b_of_type_JavaLangString, 2, "OnCreateUI --> Not Set MultiAVType");
              }
              this.jdField_a_of_type_ComTencentAvUiVideoControlUI = new MultiVideoCtrlLayerUI4Discussion(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_Mcx);
            }
          }
          paramBoolean = false;
          continue;
          label1363:
          QLog.e(this.jdField_b_of_type_JavaLangString, 1, "funcall --> !file.exists() + path:" + (String)localObject1);
        }
      }
    }
  }
  
  public void a(Integer paramInteger, Object paramObject1, Object paramObject2)
  {
    lbd.f(this.jdField_b_of_type_JavaLangString, "notifyEvent :" + paramInteger + "|" + paramObject1 + "|" + paramObject2);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { paramInteger, paramObject1, paramObject2 });
  }
  
  public void a(String paramString)
  {
    lhd locallhd = (lhd)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(3);
    FaceItem localFaceItem = locallhd.a(paramString);
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
        new mdc(l1, localFaceItem.getId(), true, 2).a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
        VoiceRecogTips.b(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramString);
        bdla.b(null, "CliOper", "", "", "0X800984F", "0X800984F", 0, 0, "", "", "", localFaceItem.getId());
        return;
      }
      locallhd.a(l1, localFaceItem);
      return;
    }
    QLog.i(this.jdField_b_of_type_JavaLangString, 1, "onAVVoiceRecogComplete. recogResult = " + paramString + ", paly voice sticker falied. voiceStickerItem == null.");
  }
  
  void a(String paramString, long paramLong)
  {
    View localView = findViewById(2131373638);
    if (localView == null) {}
    do
    {
      do
      {
        return;
      } while (localView.getVisibility() != 0);
      localView.setVisibility(4);
      QLog.w(this.jdField_b_of_type_JavaLangString, 1, "MoreBtnTips. hide_qav_more_tips. from[" + paramString + "], seq[" + paramLong + "]");
    } while (this.jdField_a_of_type_Mts == null);
    mtr.a(this.jdField_a_of_type_Mts.jdField_a_of_type_Int);
    this.jdField_a_of_type_Mts = null;
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
    if (this.jdField_a_of_type_Mcc != null) {
      this.jdField_a_of_type_Mcc.enable();
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
        if ((this.jdField_a_of_type_Lzh == null) || (this.jdField_a_of_type_Lzh.a()))
        {
          if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 4)
          {
            ArrayList localArrayList = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList;
            int i1 = 0;
            if (i1 < localArrayList.size())
            {
              lob locallob = (lob)localArrayList.get(i1);
              String str = mry.a(locallob.jdField_a_of_type_Long);
              int i2 = locallob.jdField_a_of_type_Int;
              if ((locallob.jdField_b_of_type_Long == 5L) || (locallob.jdField_b_of_type_Long == 14L)) {}
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
        this.jdField_a_of_type_ComTencentAvUiVideoControlUI.n(paramLong);
      }
      if (this.jdField_a_of_type_Mcq != null) {
        this.jdField_a_of_type_Mcq.d();
      }
      f();
      this.jdField_a_of_type_ComTencentAvVideoController.a(true);
      this.jdField_a_of_type_ComTencentAvVideoController.h(false);
      if (this.jdField_a_of_type_Lzh != null) {
        this.jdField_a_of_type_Lzh.a(paramLong, this.jdField_e_of_type_Boolean);
      }
    } while (this.jdField_a_of_type_Mnm == null);
    this.jdField_a_of_type_Mnm.a();
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
      paramString = this.jdField_a_of_type_ComTencentAvVideoController.a();
      if ((!mji.k()) && (this.jdField_a_of_type_Mji != null) && (!paramString.A())) {
        break label161;
      }
      if ((this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView != null) && (this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView.getVisibility() != 8)) {
        this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView.setVisibility(8);
      }
    }
    label161:
    do
    {
      do
      {
        return;
        i1 = 0;
        break;
        int i3 = paramString.jdField_d_of_type_Int;
        i1 = i2;
        if (i3 != 1)
        {
          if (i3 != 2) {
            break label264;
          }
          i1 = i2;
        }
        for (;;)
        {
          if (paramBoolean)
          {
            if ((i1 != 0) && (paramString.C))
            {
              this.jdField_a_of_type_Mji.d(this.jdField_h_of_type_Int);
              this.jdField_a_of_type_Mji.d();
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
        this.jdField_a_of_type_Mji.d(0);
        this.jdField_a_of_type_Mji.d();
        this.jdField_a_of_type_Mji.k();
      }
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(272);
      a(paramLong, "tryShowRecordBtn.2", false);
    } while (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI == null);
    label264:
    this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.l(0);
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
      mbf.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1043);
      return;
    }
    if (this.jdField_a_of_type_AndroidViewView$OnClickListener == null) {
      this.jdField_a_of_type_AndroidViewView$OnClickListener = new mbr(this, paramString, l1);
    }
    mbf.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1044, null, this.jdField_a_of_type_AndroidViewView$OnClickListener);
  }
  
  public void b(boolean paramBoolean)
  {
    VideoLayerUI.a(findViewById(2131363136), paramBoolean);
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
    if (this.jdField_a_of_type_Mcc != null) {
      this.jdField_a_of_type_Mcc.disable();
    }
  }
  
  void c(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString + "|VideoNodeManager", 2, "processExtraData, seq[" + paramLong + "]");
    }
    Intent localIntent = super.getIntent();
    if (localIntent == null)
    {
      QLog.d(this.jdField_b_of_type_JavaLangString, 1, "processExtraData-->can not get intent");
      return;
    }
    AudioHelper.a("AVActivity.processExtraData", localIntent.getExtras());
    int i4 = localIntent.getIntExtra("sessionType", 0);
    lfe locallfe = this.jdField_a_of_type_ComTencentAvVideoController.a();
    int i2 = locallfe.jdField_d_of_type_Int;
    Object localObject1 = localIntent.getStringExtra("Fromwhere");
    boolean bool = localIntent.getBooleanExtra("isDoubleVideoMeeting", false);
    a("processExtraData", bool);
    if ("AVNotification".equals(localObject1))
    {
      if (((locallfe.jdField_g_of_type_Int == 2) || (locallfe.jdField_g_of_type_Int == 13)) && (i4 != 1) && (i4 != 2))
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_b_of_type_JavaLangString, 2, "Close Double Video Meeting. --> QAVNotification to MultiVideo");
        }
        if (locallfe.J) {
          break label390;
        }
        this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, locallfe.jdField_d_of_type_JavaLangString, 1, true);
        this.jdField_a_of_type_ComTencentAvVideoController.a(locallfe.jdField_d_of_type_JavaLangString, 230);
        this.jdField_a_of_type_ComTencentAvVideoController.b(230);
      }
      if (locallfe.jdField_j_of_type_Int == 1)
      {
        if (locallfe.D != 10) {
          break label428;
        }
        bdla.b(null, "CliOper", "", "", "0X8005930", "0X8005930", 0, 0, "", "", "", "");
      }
    }
    label390:
    long l1;
    for (;;)
    {
      if (bool) {
        bdla.b(null, "CliOper", "", "", "0X8005209", "0X8005209", 0, 0, "", "", "", "");
      }
      if (i4 != 0) {
        break label464;
      }
      lbd.g(this.jdField_b_of_type_JavaLangString, "processExtraData-->can not get session type in intent.");
      ((lik)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4)).a(locallfe.b(), 5, 1015L);
      finish();
      return;
      l1 = Long.valueOf(locallfe.jdField_d_of_type_JavaLangString).longValue();
      this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, 3, l1);
      this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, l1, 1);
      break;
      label428:
      bdla.b(null, "CliOper", "", "", "0X80046D7", "0X80046D7", 0, 0, "", "", "", "");
    }
    label464:
    String str1 = null;
    if ((i4 == 1) || (i4 == 2))
    {
      str1 = localIntent.getStringExtra("uin");
      label489:
      if (!"AVNotification".equals(localObject1)) {
        break label2382;
      }
      if ((i4 != 1) && (i4 != 2)) {
        break label639;
      }
      str1 = locallfe.jdField_d_of_type_JavaLangString;
    }
    label1538:
    label1805:
    label1817:
    label2379:
    label2382:
    for (;;)
    {
      int i1;
      int i3;
      int i5;
      if (str1 == null)
      {
        lbd.g(this.jdField_b_of_type_JavaLangString, "processExtraData-->can not get uin in intent.");
        ((lik)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4)).a(locallfe.b(), 5, 1016L);
        finish();
        return;
        if ((i4 != 3) && (i4 != 4)) {
          break label489;
        }
        str1 = localIntent.getStringExtra("GroupId");
        i1 = localIntent.getIntExtra("MeetingConfID", 0);
        i3 = localIntent.getIntExtra("ConfAppID", 0);
        i5 = localIntent.getIntExtra("MeetingStasks", -1);
        locallfe.O = i1;
        locallfe.P = i3;
        locallfe.Q = i5;
        break label489;
        label639:
        if ((i4 != 3) && (i4 != 4)) {
          break label2382;
        }
        if (bool)
        {
          str1 = locallfe.jdField_d_of_type_JavaLangString;
          continue;
        }
        str1 = String.valueOf(this.jdField_a_of_type_ComTencentAvVideoController.jdField_a_of_type_Long);
        continue;
      }
      Object localObject2;
      if ((i2 == 1) || (i2 == 2))
      {
        localObject2 = locallfe.jdField_d_of_type_JavaLangString;
        i1 = mvk.b(locallfe.jdField_j_of_type_Int);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          lbd.g(this.jdField_b_of_type_JavaLangString, "can not get the original peeruin");
          ((lik)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4)).a(locallfe.b(), 5, 1016L);
          finish();
        }
      }
      else if ((i2 == 3) || (i2 == 4))
      {
        localObject2 = String.valueOf(this.jdField_a_of_type_ComTencentAvVideoController.jdField_a_of_type_Long);
        i1 = this.jdField_a_of_type_ComTencentAvVideoController.jdField_b_of_type_Int;
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          lbd.g(this.jdField_b_of_type_JavaLangString, "can not get the original group uin");
          ((lik)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4)).a(locallfe.b(), 5, 1016L);
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
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, "processExtraData-->IntentSessionType=" + i4 + ", OriginalSessionType=" + i2 + ", IntentUin=" + str1);
      }
      if ((localObject1 != null) && (QLog.isColorLevel())) {
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, "processExtraData-->OriginalUin=" + (String)localObject1 + ", originalRelationType=" + i1);
      }
      if ((i2 == 0) && (!this.jdField_a_of_type_ComTencentAvVideoController.l()))
      {
        d(paramLong);
        label984:
        if ("AIOQAVWatchTogether".equals(this.jdField_j_of_type_JavaLangString)) {
          a(localIntent);
        }
        QLog.w(this.jdField_b_of_type_JavaLangString, 1, "processExtraData, mSessionType[" + this.jdField_b_of_type_Int + "], mUinType[" + this.jdField_d_of_type_Int + "], mPeerUin[" + this.jdField_c_of_type_JavaLangString + "], mPeerName[" + this.jdField_e_of_type_JavaLangString + "], mPhoneNum[" + this.jdField_f_of_type_JavaLangString + "], mSelfNation[" + this.jdField_g_of_type_JavaLangString + "], mSelfMobile[" + this.jdField_h_of_type_JavaLangString + "], mIsReceiver[" + this.jdField_a_of_type_Boolean + "], mIsAudioMode[" + this.jdField_b_of_type_Boolean + "], mExtraUin[" + this.jdField_i_of_type_JavaLangString + "], mIsPeerNetworkWell[" + this.jdField_c_of_type_Boolean + "], mIsFriend[" + this.jdField_d_of_type_Boolean + "], mFromWhere[" + this.jdField_j_of_type_JavaLangString + "], intentUinStr[" + str1 + "], \nsession[" + locallfe + "]");
        HexUtil.printHexString(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ArrayOfByte);
        return;
      }
      if ((i2 == 3) || (i2 == 4) || (this.jdField_a_of_type_ComTencentAvVideoController.l()))
      {
        if ((i2 != 0) || (!this.jdField_a_of_type_ComTencentAvVideoController.l())) {
          break label2379;
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
            str1 = lbz.a(3, this.jdField_c_of_type_JavaLangString, new int[0]);
            if (lbz.a().a(str1)) {
              break;
            }
            localObject1 = lbz.a().a(str1, false);
            ((lfe)localObject1).jdField_e_of_type_Boolean = false;
            ((lfe)localObject1).a("processExtraData", 0);
            ((lfe)localObject1).ag = false;
            if (!str1.equals(this.jdField_a_of_type_JavaLangString)) {
              this.jdField_a_of_type_JavaLangString = str1;
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
        l1 = Long.valueOf(str1).longValue();
        i3 = 0;
        i5 = localIntent.getIntExtra("MultiAVType", 0);
        locallfe.au = localIntent.getBooleanExtra("disableInvite", false);
        i2 = i3;
        if (locallfe.D != 0)
        {
          i2 = i3;
          if (i5 != locallfe.D)
          {
            i2 = i3;
            if (i5 != 0) {
              i2 = 1;
            }
          }
        }
        locallfe.a(i5);
        if (!bool) {
          if (this.jdField_a_of_type_ComTencentAvVideoController.l())
          {
            this.jdField_a_of_type_ComTencentAvVideoController.g(true);
            if (i2 != 0)
            {
              this.jdField_a_of_type_ComTencentAvVideoController.a(i1, this.jdField_a_of_type_ComTencentAvVideoController.jdField_a_of_type_Long, 99);
              locallfe.a(i5);
              locallfe.a(paramLong, "processExtraData.1", 3);
            }
            locallfe.c("processExtraData.1", localIntent.getIntExtra("Type", -1));
            locallfe.jdField_g_of_type_Long = l1;
            this.jdField_d_of_type_JavaLangString = str1;
            if (str1.compareTo((String)localObject1) != 0) {
              break label1817;
            }
            if (i2 == 0) {
              break label1805;
            }
            this.jdField_b_of_type_Int = i4;
            i1 = localIntent.getIntExtra("uinType", -1);
            locallfe.jdField_j_of_type_Int = i1;
            this.jdField_d_of_type_Int = i1;
            this.jdField_i_of_type_JavaLangString = locallfe.jdField_f_of_type_JavaLangString;
            if (locallfe.E == -1) {
              locallfe.c("processExtraData.2", 0);
            }
            this.jdField_c_of_type_Boolean = locallfe.r;
            if (QLog.isColorLevel()) {
              QLog.d(this.jdField_b_of_type_JavaLangString, 2, "processExtraData multiAVType: " + locallfe.D);
            }
          }
        }
        for (;;)
        {
          if (i2 != 0) {
            break label1901;
          }
          this.jdField_d_of_type_Int = locallfe.jdField_j_of_type_Int;
          this.jdField_i_of_type_JavaLangString = locallfe.jdField_f_of_type_JavaLangString;
          this.jdField_c_of_type_Boolean = locallfe.r;
          break;
          if ((str1.compareTo((String)localObject1) == 0) || (!this.jdField_a_of_type_ComTencentAvVideoController.jdField_e_of_type_Boolean)) {
            break label1538;
          }
          this.jdField_a_of_type_ComTencentAvVideoController.a(i1, this.jdField_a_of_type_ComTencentAvVideoController.jdField_a_of_type_Long, 98);
          locallfe.a(i5);
          break label1538;
          this.jdField_b_of_type_Int = locallfe.jdField_d_of_type_Int;
          continue;
          locallfe.a(paramLong, "processExtraData.2", i4);
          locallfe.jdField_j_of_type_Int = localIntent.getIntExtra("uinType", -1);
          if ((locallfe.E == 0) || (locallfe.E == 1)) {
            locallfe.jdField_a_of_type_ArrayOfLong = localIntent.getLongArrayExtra("DiscussUinList");
          }
          this.jdField_b_of_type_Int = i4;
          continue;
          locallfe.jdField_d_of_type_JavaLangString = str1;
          this.jdField_b_of_type_Int = i4;
          this.jdField_c_of_type_JavaLangString = str1;
        }
        label1901:
        break label984;
        if (((i2 != 1) && (i2 != 2)) || ((i4 != 1) && (i4 != 2))) {
          break label984;
        }
        i1 = localIntent.getIntExtra("uinType", -1);
        if ((i1 != -1) && (i1 != locallfe.jdField_j_of_type_Int))
        {
          if (QLog.isColorLevel()) {
            QLog.w(this.jdField_b_of_type_JavaLangString, 2, "New Double Video in , newUinType !=-1 && newUinType != oldUinType , close old video.");
          }
          this.jdField_a_of_type_ComTencentAvVideoController.a(false, 203, new int[] { locallfe.D });
          this.jdField_a_of_type_ComTencentAvVideoController.b(203);
          if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI != null)
          {
            this.jdField_a_of_type_ComTencentAvUiVideoControlUI.d(paramLong);
            this.jdField_a_of_type_ComTencentAvUiVideoControlUI = null;
          }
          localObject1 = locallfe.jdField_d_of_type_JavaLangString;
          localObject2 = lbz.a(3, (String)localObject1, new int[0]);
          Object localObject3 = lbz.a().c((String)localObject2);
          if (localObject3 == null)
          {
            lbd.g(this.jdField_b_of_type_JavaLangString, "Can not get SessionInfo : SessionId = " + (String)localObject2);
            finish();
            return;
          }
          String str2 = ((lfe)localObject3).jdField_f_of_type_JavaLangString;
          i1 = locallfe.jdField_j_of_type_Int;
          localObject3 = ((lfe)localObject3).jdField_s_of_type_JavaLangString;
          this.jdField_a_of_type_ComTencentAvVideoController.a((String)localObject1, 231);
          this.jdField_a_of_type_ComTencentAvVideoController.b(231);
          this.jdField_a_of_type_ComTencentAvVideoController.a("AVActivity.processExtraData", (String)localObject2, i1, (String)localObject1, str2, 0, (String)localObject3, false, true);
          d(paramLong);
          localObject1 = lbz.a(3, this.jdField_c_of_type_JavaLangString, new int[0]);
          localObject2 = lbz.a().a((String)localObject1, false);
          ((lfe)localObject2).jdField_e_of_type_Boolean = true;
          ((lfe)localObject2).a("processExtraData", 2);
          ((lfe)localObject2).ag = false;
          if (((String)localObject1).equals(this.jdField_a_of_type_JavaLangString)) {
            break label984;
          }
          this.jdField_a_of_type_JavaLangString = ((String)localObject1);
          break label984;
        }
        if (QLog.isColorLevel()) {
          QLog.w(this.jdField_b_of_type_JavaLangString, 2, "New Double Video in , newUinType !=-1 && newUinType == oldUinType , resume old video");
        }
        this.jdField_b_of_type_Int = locallfe.jdField_d_of_type_Int;
        a("processExtraData", locallfe.J);
        this.jdField_d_of_type_Int = locallfe.jdField_j_of_type_Int;
        this.jdField_c_of_type_JavaLangString = locallfe.jdField_d_of_type_JavaLangString;
        this.jdField_e_of_type_JavaLangString = locallfe.jdField_e_of_type_JavaLangString;
        this.jdField_l_of_type_JavaLangString = locallfe.jdField_k_of_type_JavaLangString;
        this.jdField_e_of_type_Int = locallfe.A;
        this.jdField_m_of_type_JavaLangString = locallfe.jdField_p_of_type_JavaLangString;
        this.jdField_f_of_type_Int = locallfe.jdField_B_of_type_Int;
        this.jdField_i_of_type_JavaLangString = locallfe.jdField_f_of_type_JavaLangString;
        this.jdField_f_of_type_JavaLangString = locallfe.a();
        this.jdField_a_of_type_Boolean = locallfe.jdField_e_of_type_Boolean;
        this.jdField_b_of_type_Boolean = locallfe.S;
        this.jdField_c_of_type_Boolean = locallfe.r;
        this.jdField_d_of_type_Boolean = locallfe.jdField_N_of_type_Boolean;
        break label984;
      }
    }
  }
  
  public void c(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) {
      this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.g(paramBoolean);
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
    lfe locallfe = this.jdField_a_of_type_ComTencentAvVideoController.a();
    QLog.w(this.jdField_b_of_type_JavaLangString + "|VideoNodeManager", 1, "processIntentData begin, isProcessCreate[" + this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.jdField_c_of_type_Boolean + "], isMsfRecv[" + this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.jdField_d_of_type_Boolean + "], seq[" + paramLong + "], \nSessionInfo[" + locallfe + "]");
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
      lii.a(26);
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
        locallfe.ad = 4;
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
      this.jdField_b_of_type_Long = bibh.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_c_of_type_JavaLangString, 3, true, null);
      this.jdField_g_of_type_Int = ((Intent)localObject1).getIntExtra("vipType", 0);
      lbd.e("VideoNodeManager", "==> AVActivity processIntentData() mSessionType = " + this.jdField_b_of_type_Int + "  mIsAudioMode = " + this.jdField_b_of_type_Boolean);
      lii.b(this.jdField_b_of_type_Int);
      if (!this.jdField_b_of_type_Boolean) {
        break label867;
      }
      l1 = 1L;
      label659:
      lii.a(13, l1);
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
      lvy.a().jdField_b_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
      if ((this.jdField_b_of_type_Int != 3) && (this.jdField_b_of_type_Int != 4)) {
        break label1179;
      }
      locallfe.c("processIntentData", ((Intent)localObject1).getIntExtra("Type", -1));
      localObject2 = ((Intent)localObject1).getStringExtra("GroupId");
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        break label1005;
      }
      lbd.g(this.jdField_b_of_type_JavaLangString, "relationIdStr is null");
      this.jdField_e_of_type_Boolean = true;
      ((lik)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4)).a(locallfe.b(), 5, 1016L);
      finish();
      return;
      lii.a();
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
      i2 = locallfe.D;
      i1 = i2;
      if (QLog.isColorLevel())
      {
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, "Not get avtype inside intent default value: " + i2);
        i1 = i2;
      }
    }
    locallfe.a(i1);
    if (localObject2 != null)
    {
      locallfe.jdField_g_of_type_Long = Long.valueOf((String)localObject2).longValue();
      this.jdField_d_of_type_JavaLangString = ((String)localObject2);
    }
    locallfe.jdField_a_of_type_ArrayOfLong = ((Intent)localObject1).getLongArrayExtra("DiscussUinList");
    locallfe.au = ((Intent)localObject1).getBooleanExtra("disableInvite", false);
    while (this.jdField_b_of_type_Int == 0)
    {
      lbd.g(this.jdField_b_of_type_JavaLangString, "invalid sessionType!!!");
      this.jdField_e_of_type_Boolean = true;
      ((lik)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4)).a(locallfe.b(), 5, 1015L);
      finish();
      return;
      label1179:
      locallfe.ai = ((Intent)localObject1).getBooleanExtra("isOtherTerminalOnChating", false);
      if (locallfe.ai)
      {
        locallfe.jdField_i_of_type_Long = ((Intent)localObject1).getLongExtra("otherTerminalChatingRoomId", 0L);
        locallfe.ak = ((Intent)localObject1).getBooleanExtra("startfromVideoEntry", false);
      }
    }
    i1 = ((Intent)localObject1).getIntExtra("remoteStatus", 0);
    if (this.jdField_a_of_type_Boolean)
    {
      if (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))
      {
        lbd.g(this.jdField_b_of_type_JavaLangString, "uin is empty");
        this.jdField_e_of_type_Boolean = true;
        ((lik)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4)).a(locallfe.b(), 5, 1016L);
        finish();
        return;
      }
      if (TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) {
        this.jdField_e_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
      }
      if ((this.jdField_d_of_type_Int != 1011) && (locallfe.jdField_a_of_type_Lff.jdField_b_of_type_Boolean))
      {
        this.jdField_a_of_type_ComTencentAvVideoController.a(locallfe.jdField_d_of_type_JavaLangString, 232);
        this.jdField_a_of_type_ComTencentAvVideoController.b(232);
      }
      locallfe.a(paramLong, "processIntentData", this.jdField_b_of_type_Int);
      locallfe.jdField_j_of_type_Int = this.jdField_d_of_type_Int;
      locallfe.jdField_d_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
      locallfe.jdField_e_of_type_JavaLangString = this.jdField_e_of_type_JavaLangString;
      locallfe.jdField_f_of_type_JavaLangString = this.jdField_i_of_type_JavaLangString;
      locallfe.jdField_g_of_type_JavaLangString = str1;
      locallfe.a(this.jdField_f_of_type_JavaLangString);
      if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
        Looper.myQueue().addIdleHandler(this.jdField_a_of_type_AndroidOsMessageQueue$IdleHandler);
      }
      locallfe.jdField_e_of_type_Boolean = this.jdField_a_of_type_Boolean;
      locallfe.S = this.jdField_b_of_type_Boolean;
      locallfe.r = this.jdField_c_of_type_Boolean;
      locallfe.jdField_i_of_type_JavaLangString = this.jdField_g_of_type_JavaLangString;
      locallfe.jdField_j_of_type_JavaLangString = this.jdField_h_of_type_JavaLangString;
      locallfe.jdField_k_of_type_JavaLangString = this.jdField_l_of_type_JavaLangString;
      locallfe.jdField_p_of_type_JavaLangString = this.jdField_m_of_type_JavaLangString;
      locallfe.A = this.jdField_e_of_type_Int;
      locallfe.jdField_B_of_type_Int = this.jdField_f_of_type_Int;
      locallfe.jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_ArrayOfByte;
      locallfe.jdField_N_of_type_Boolean = this.jdField_d_of_type_Boolean;
      locallfe.jdField_f_of_type_Int = this.jdField_b_of_type_Int;
      locallfe.n = this.jdField_f_of_type_Boolean;
      locallfe.jdField_b_of_type_Long = this.jdField_b_of_type_Long;
      locallfe.jdField_p_of_type_Int = this.jdField_g_of_type_Int;
      if (i1 != 4) {
        break label2095;
      }
      bool1 = true;
      label1594:
      locallfe.jdField_s_of_type_Boolean = bool1;
      locallfe.jdField_l_of_type_Int = ((Intent)localObject1).getIntExtra("friendTerminal", 3);
      locallfe.e("processIntentData", this.jdField_g_of_type_Boolean);
      locallfe.q = this.jdField_c_of_type_Int;
      locallfe.jdField_l_of_type_JavaLangString = ((Intent)localObject1).getStringExtra("actId");
      locallfe.jdField_m_of_type_JavaLangString = ((Intent)localObject1).getStringExtra("mp_ext_params");
      locallfe.jdField_a_of_type_Long = this.jdField_a_of_type_Long;
      if ((this.jdField_d_of_type_Int != 1011) && (this.jdField_d_of_type_Int != 21)) {
        break label2131;
      }
      locallfe.jdField_a_of_type_Lff.jdField_a_of_type_JavaLangString = str2;
      locallfe.jdField_a_of_type_Lff.jdField_b_of_type_JavaLangString = ((Intent)localObject1).getStringExtra("name");
      locallfe.jdField_a_of_type_Lff.jdField_c_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
      if (Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).longValue() <= Long.valueOf(this.jdField_c_of_type_JavaLangString).longValue()) {
        break label2101;
      }
      locallfe.jdField_a_of_type_Lff.jdField_a_of_type_Boolean = true;
      localObject1 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication().getApplicationInfo().dataDir + "/" + MD5.toMD5(str2) + ".jpg";
      if (!FileUtil.isFileExists((String)localObject1)) {}
    }
    for (;;)
    {
      try
      {
        locallfe.jdField_a_of_type_Lff.jdField_a_of_type_AndroidGraphicsBitmap = BitmapFactory.decodeFile((String)localObject1);
        QLog.w(this.jdField_b_of_type_JavaLangString + "|VideoNodeManager", 1, "processIntentData end, mRelationId[" + this.jdField_d_of_type_JavaLangString + "], bStartByTerminalSwitch[" + locallfe.ai + "], terSwitchStartFromVideoEntry[" + locallfe.ak + "], \nSessionInfo[" + locallfe + "]");
        return;
        if (this.jdField_d_of_type_Int == 1006)
        {
          if (TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString))
          {
            lbd.g(this.jdField_b_of_type_JavaLangString, "phoneNum is empty");
            this.jdField_e_of_type_Boolean = true;
            ((lik)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4)).a(locallfe.b(), 5, 1016L);
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
          lbd.g(this.jdField_b_of_type_JavaLangString, "Create video failed because uin is empty");
          this.jdField_e_of_type_Boolean = true;
          ((lik)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4)).a(locallfe.b(), 5, 1016L);
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
        locallfe.jdField_a_of_type_Lff.jdField_a_of_type_Boolean = false;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        QLog.d(this.jdField_b_of_type_JavaLangString, 1, "processIntentData OutOfMemoryError", localOutOfMemoryError);
        continue;
      }
      label2131:
      locallfe.jdField_a_of_type_Lff.jdField_a_of_type_JavaLangString = null;
      locallfe.jdField_a_of_type_Lff.jdField_b_of_type_JavaLangString = null;
      locallfe.jdField_a_of_type_Lff.jdField_a_of_type_Boolean = false;
    }
  }
  
  public void d(boolean paramBoolean)
  {
    QLog.w(this.jdField_b_of_type_JavaLangString, 1, "onZimuModeChange, inZimu[" + paramBoolean + "]");
    mji localmji;
    if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (this.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) && (this.jdField_a_of_type_Mji != null))
    {
      this.jdField_a_of_type_Mji.jdField_d_of_type_Boolean = paramBoolean;
      localmji = this.jdField_a_of_type_Mji;
      if (!paramBoolean) {
        break label87;
      }
    }
    label87:
    for (int i1 = 0;; i1 = this.jdField_h_of_type_Int)
    {
      localmji.d(i1);
      this.jdField_a_of_type_Mji.d();
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
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      boolean bool = super.dispatchTouchEvent(paramMotionEvent);
      EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
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
      this.jdField_a_of_type_ComTencentAvUiVideoControlUI.P();
      if ((this.jdField_a_of_type_ComTencentAvUiVideoControlUI instanceof DoubleVideoCtrlUI))
      {
        localObject = (DoubleVideoCtrlUI)this.jdField_a_of_type_ComTencentAvUiVideoControlUI;
        if (this.jdField_a_of_type_Mji == null) {
          break label219;
        }
        i1 = this.jdField_a_of_type_Mji.c();
        ((DoubleVideoCtrlUI)localObject).e_(i1);
        g(l1);
      }
    }
    if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (this.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) && (this.jdField_a_of_type_Mji != null))
    {
      this.jdField_a_of_type_Mji.jdField_c_of_type_Boolean = paramBoolean;
      if ((this.jdField_a_of_type_ComTencentAvVideoController.a().C) || (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_B_of_type_Boolean))
      {
        localObject = this.jdField_a_of_type_Mji;
        if (!paramBoolean) {
          break label224;
        }
      }
    }
    label219:
    label224:
    for (int i1 = i2;; i1 = this.jdField_h_of_type_Int)
    {
      ((mji)localObject).d(i1);
      this.jdField_a_of_type_Mji.d();
      localObject = findViewById(2131363136);
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
    bkzi localbkzi = bkzi.c(this);
    localbkzi.getWindow().addFlags(524288);
    localbkzi.getWindow().addFlags(2097152);
    localbkzi.getWindow().addFlags(128);
    localbkzi.b(2131719985);
    localbkzi.c(2131690697);
    localbkzi.a(new mbp(this));
    localbkzi.setOnDismissListener(new mbq(this));
    localbkzi.setCanceledOnTouchOutside(true);
    localbkzi.e(150);
    this.jdField_a_of_type_AndroidAppDialog = localbkzi;
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
    lbd.g(this.jdField_b_of_type_JavaLangString, "avideo life_finish, FromWhere[" + this.jdField_j_of_type_JavaLangString + "]");
    lfe locallfe = lbz.a().a();
    if ((locallfe.jdField_B_of_type_Boolean) && (this.jdField_a_of_type_Mji != null))
    {
      this.jdField_a_of_type_Mji.c();
      if (this.jdField_a_of_type_Mji.b() < 1000L) {
        break label311;
      }
    }
    for (;;)
    {
      locallfe.v = i1;
      bdla.b(null, "CliOper", "", "", "0X800863D", "0X800863D", 0, 0, "", "", "", "");
      if ((this.jdField_e_of_type_Boolean) && (locallfe.aE) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null))
      {
        String str1 = String.valueOf(locallfe.jdField_g_of_type_Long);
        String str2 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getDisplayName(this.jdField_d_of_type_Int, str1, locallfe.jdField_f_of_type_JavaLangString);
        Intent localIntent = AIOUtils.setOpenAIOIntent(new Intent(super.getApplicationContext(), SplashActivity.class), null);
        localIntent.putExtra("uin", str1);
        localIntent.putExtra("uintype", locallfe.jdField_j_of_type_Int);
        localIntent.putExtra("uinname", str2);
        startActivity(localIntent);
      }
      if (QLog.isColorLevel()) {
        QLog.i("double_2_multi", 2, "finish fromDoubleChat[" + locallfe.aE + "], session[" + locallfe + "]");
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
    ViewGroup localViewGroup = (ViewGroup)findViewById(2131363136);
    float f1 = getResources().getDimension(2131297704);
    float f2 = getResources().getDimension(2131297707);
    Object localObject = new RelativeLayout.LayoutParams(-1, (int)f1);
    ((RelativeLayout.LayoutParams)localObject).setMargins(0, (int)f2, 0, 0);
    this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterPanel = new EffectFilterPanel(getBaseContext(), this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterPanel.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = localViewGroup.findViewById(2131373791);
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
      ViewGroup localViewGroup = (ViewGroup)findViewById(2131363136);
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
    FaceItem localFaceItem = (FaceItem)((lhd)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(3)).a();
    if ((localFaceItem != null) && (localFaceItem.isInteract()) && (localFaceItem.isSameType("face"))) {}
    for (paramBoolean = bool2;; paramBoolean = false)
    {
      lbd.f(this.jdField_b_of_type_JavaLangString, "onChangeUI_quitDoubleScreenStatus isIntactiveFace:" + paramBoolean);
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
    mtt localmtt = mtt.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    if (localmtt != null)
    {
      if (paramBoolean) {
        i1 = 1;
      }
      localmtt.a(i1);
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
      mqx.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramInt2, paramIntent);
    }
    do
    {
      mxd localmxd;
      do
      {
        do
        {
          do
          {
            return;
            if (paramInt1 == 802)
            {
              mqx.b(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramInt2, paramIntent);
              return;
            }
            if (paramInt1 != 1002) {
              break;
            }
          } while (this.jdField_a_of_type_Mhw == null);
          this.jdField_a_of_type_Mhw.f();
          return;
          if ((Build.VERSION.SDK_INT < 21) || (paramInt1 != 8080)) {
            break;
          }
        } while (this.jdField_a_of_type_Mjw == null);
        if (paramInt2 == -1)
        {
          lwf.a(this);
          this.jdField_a_of_type_Mjw.a(paramIntent);
          this.jdField_a_of_type_Mjw.a();
          return;
        }
        this.jdField_a_of_type_Mjw.b();
        return;
        if (paramInt1 != 2020) {
          break;
        }
        localmxd = (mxd)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(15);
      } while (localmxd == null);
      localmxd.a(lbz.a().a(), paramInt2, paramIntent);
      return;
    } while (paramInt1 != 21001);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a(paramInt2, paramIntent);
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
    mdb localmdb = new mdb(null);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(7002), localmdb });
    QLog.i(this.jdField_b_of_type_JavaLangString, 1, "avideo onBackPressed, BlockSystemBack[" + localmdb.jdField_b_of_type_Boolean + "], BlockName[" + localmdb.jdField_b_of_type_JavaLangString + "]");
    boolean bool1 = localmdb.jdField_b_of_type_Boolean;
    boolean bool2 = bool1;
    if (!bool1)
    {
      bool2 = bool1;
      if (this.jdField_a_of_type_Mnm != null) {
        bool2 = this.jdField_a_of_type_Mnm.c();
      }
    }
    bool1 = bool2;
    if (!bool2)
    {
      if ((this.jdField_a_of_type_Mcq == null) || (!this.jdField_a_of_type_Mcq.a())) {
        break label221;
      }
      bool1 = this.jdField_a_of_type_Mcq.b();
    }
    for (;;)
    {
      bool2 = bool1;
      if (this.jdField_a_of_type_Mhw != null)
      {
        bool2 = bool1;
        if (this.jdField_a_of_type_Mhw.a())
        {
          this.jdField_a_of_type_Mhw.c();
          bool2 = true;
        }
      }
      if (!bool2) {
        super.onBackPressed();
      }
      this.jdField_a_of_type_ComTencentAvVideoController.a("backgroundReason", "2");
      lci.jdField_a_of_type_JavaLangString = "2";
      return;
      label221:
      bool1 = bool2;
      if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
        bool1 = this.jdField_a_of_type_ComTencentAvUiVideoControlUI.a();
      }
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    lfe locallfe = lbz.a().a();
    if ((locallfe == null) || (!locallfe.A())) {}
    label191:
    label224:
    for (;;)
    {
      EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
      return;
      WatchTogetherMediaPlayCtrl localWatchTogetherMediaPlayCtrl = this.jdField_a_of_type_ComTencentAvVideoController.a();
      if (localWatchTogetherMediaPlayCtrl != null)
      {
        localWatchTogetherMediaPlayCtrl.e();
        if (QLog.isDebugVersion())
        {
          int i1 = ((WindowManager)getSystemService("window")).getDefaultDisplay().getRotation();
          QLog.d(this.jdField_b_of_type_JavaLangString, 1, "onConfigurationChanged, displayRotation[" + i1 + "]");
        }
        if (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) {
          this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.j(paramConfiguration.orientation);
        }
        if (paramConfiguration.orientation == 1)
        {
          if (!locallfe.B()) {
            break label191;
          }
          this.jdField_a_of_type_ComTencentAvUiVideoControlUI.g("onConfigurationChanged");
        }
        for (;;)
        {
          if ((paramConfiguration.orientation == 1) || (this.jdField_a_of_type_ComTencentAvUiVideoControlUI == null) || (!this.jdField_a_of_type_ComTencentAvUiVideoControlUI.i())) {
            break label224;
          }
          this.jdField_a_of_type_ComTencentAvUiVideoControlUI.g("onConfigurationChanged");
          break;
          if (locallfe.x)
          {
            locallfe.c(true);
            this.jdField_a_of_type_ComTencentAvUiVideoControlUI.g("onConfigurationChanged");
          }
          else
          {
            this.jdField_a_of_type_ComTencentAvUiVideoControlUI.L();
          }
        }
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
    super.setContentView(2131559727);
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
      lbd.g(this.jdField_b_of_type_JavaLangString, "onCreate, appRuntime is null exit");
      paramBundle = super.getString(2131719926) + " 0x05";
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
      lbd.g(this.jdField_b_of_type_JavaLangString, "onCreate, AppRuntime is no VideoAppInterface, " + paramBundle.getClass().getName() + " exit");
      paramBundle = super.getString(2131719926) + " 0x06";
      Toast.makeText(super.getBaseContext(), paramBundle, 0).show();
      this.jdField_e_of_type_Boolean = true;
      sendBroadcast(new Intent("com.tencent.av.ui.AVLoadingDialogActivity.ACTION_LOADING_FINISH"));
      finish();
      return;
    }
    f(true);
    paramBundle = (lik)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4);
    localObject1 = lbz.a().a();
    if (localObject1 != null)
    {
      QLog.d(this.jdField_b_of_type_JavaLangString, 1, "avideo life_onCreate roomId = " + ((lfe)localObject1).b() + ",isReceiver = " + ((lfe)localObject1).jdField_e_of_type_Boolean);
      if (((lfe)localObject1).jdField_e_of_type_Boolean) {
        paramBundle.a(((lfe)localObject1).b(), 7, 1L);
      }
    }
    for (;;)
    {
      bool = getIntent().getBooleanExtra("isMakingAcall", false);
      if (bool) {
        paramBundle.a(-1L, 1, 1L);
      }
      QLog.d(this.jdField_b_of_type_JavaLangString, 1, "avideo life_onCreate  isMakingAcall =  " + bool);
      lvy.a().a(getIntent(), this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
      lhw.a().a(this);
      this.jdField_a_of_type_ComTencentAvVideoController = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
      if (this.jdField_a_of_type_ComTencentAvVideoController != null) {
        break;
      }
      lbd.g(this.jdField_b_of_type_JavaLangString, "onCreate,VideoAppInterface.mVideoController exit");
      paramBundle = super.getString(2131719926) + " 0x07";
      Toast.makeText(super.getBaseContext(), paramBundle, 0).show();
      this.jdField_e_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast(new Intent("com.tencent.av.ui.AVLoadingDialogActivity.ACTION_LOADING_FINISH"));
      finish();
      return;
      QLog.d(this.jdField_b_of_type_JavaLangString, 1, "avideo life_onCreate sessionInfo is null ");
    }
    if (!this.jdField_a_of_type_ComTencentAvVideoController.c())
    {
      lbd.g(this.jdField_b_of_type_JavaLangString, "onCreate,VideoAppInterface.initVcController exit");
      paramBundle = super.getString(2131719926) + " 0x08";
      Toast.makeText(super.getBaseContext(), paramBundle, 0).show();
      this.jdField_e_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast(new Intent("com.tencent.av.ui.AVLoadingDialogActivity.ACTION_LOADING_FINISH"));
      finish();
      return;
    }
    this.jdField_a_of_type_ComTencentAvVideoController.A(SDKConfigInfo.getDeviceInfo(new llh(getApplicationContext())));
    paramBundle = super.getIntent();
    int i1;
    if (paramBundle != null)
    {
      i1 = paramBundle.getIntExtra("uinType", -1);
      localObject1 = paramBundle.getStringExtra("uin");
      if (i1 == 1008)
      {
        localObject2 = lbz.a(3, (String)localObject1, new int[0]);
        localObject2 = lbz.a().c((String)localObject2);
        if ((localObject2 == null) || (((lfe)localObject2).jdField_j_of_type_Int == -1))
        {
          localObject2 = lbz.a().a();
          if ((((lfe)localObject2).jdField_j_of_type_Int != -1) && ((((lfe)localObject2).h()) || (((lfe)localObject2).j())))
          {
            paramBundle = new Intent("tencent.video.v2q.ypc2b.failEnter.asIsInviting");
            paramBundle.setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getPackageName());
            paramBundle.putExtra("uin", (String)localObject1);
            paramBundle.putExtra("uinType", i1);
            this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast(paramBundle);
            this.jdField_e_of_type_Boolean = true;
            this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast(new Intent("com.tencent.av.ui.AVLoadingDialogActivity.ACTION_LOADING_FINISH"));
            lbd.g(this.jdField_b_of_type_JavaLangString, "onCreate,VideoAppInterface.UIN_TYPE_PUBLIC_ACCOUNT exit: " + (String)localObject1);
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
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_Lee);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_Mcx);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_Lfk);
      this.jdField_a_of_type_ComTencentAvVideoController.jdField_a_of_type_Lby.b();
      a();
      d();
      this.jdField_a_of_type_JavaLangString = a(getIntent());
      if ((TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) || (a(getIntent())) || (lbz.a().a(this.jdField_a_of_type_JavaLangString))) {
        break label1689;
      }
      this.jdField_a_of_type_ComTencentAvVideoController.a(false, 204, new int[] { this.jdField_a_of_type_ComTencentAvVideoController.a().D });
      this.jdField_a_of_type_ComTencentAvVideoController.b(204);
      lbz.a().a(this.jdField_a_of_type_JavaLangString, false);
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
      this.jdField_a_of_type_Mtt = mtt.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      b(0);
      a(l1, false);
      if ((this.jdField_a_of_type_ComTencentAvUiVideoControlUI instanceof DoubleVideoCtrlUI)) {
        lwa.a().a();
      }
      if (EffectSettingUi.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, false))
      {
        this.jdField_a_of_type_Mcv = new mcv(this);
        this.jdField_a_of_type_Mcv.a();
      }
      this.jdField_a_of_type_Lzh = lzh.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      i1 = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_N_of_type_Int;
      if (QLog.isDevelopLevel()) {
        QLog.d(this.jdField_b_of_type_JavaLangString, 4, "onCreate changeVideoLayoutMode Style=" + this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int + "|" + this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_N_of_type_Int + "|" + this.jdField_a_of_type_ComTencentAvVideoController.h());
      }
      a(i1, false);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast(new Intent("com.tencent.av.ui.AVLoadingDialogActivity.ACTION_LOADING_FINISH"));
      paramBundle = (ViewStub)findViewById(2131373494);
      this.jdField_a_of_type_Mhw = new mhw(findViewById(2131373435), paramBundle, 2131373729, this.jdField_a_of_type_ComTencentAvVideoController, this);
      this.jdField_a_of_type_Mnm = new mnm(this, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface)) {
        findViewById(2131373665).setVisibility(0);
      }
      this.jdField_a_of_type_ComTencentAvUiGuideGuideHelper.a(this);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a(this);
      AudioHelper.b(this.jdField_b_of_type_JavaLangString + ".onCreate.end");
      return;
      paramBundle = paramBundle.getStringExtra("Fromwhere");
      break;
      label1689:
      this.jdField_a_of_type_JavaLangString = lbz.a().a().jdField_c_of_type_JavaLangString;
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
    if (this.jdField_a_of_type_Mnm != null)
    {
      this.jdField_a_of_type_Mnm.a(this.jdField_e_of_type_Boolean);
      this.jdField_a_of_type_Mnm = null;
    }
    if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (this.jdField_a_of_type_ComTencentAvVideoController.a() != null) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_B_of_type_Boolean) && (this.jdField_a_of_type_Mji != null)) {
      this.jdField_a_of_type_Mji.c();
    }
    if (this.jdField_a_of_type_Mji != null)
    {
      this.jdField_a_of_type_Mji.e();
      this.jdField_a_of_type_Mji = null;
    }
    if (this.jdField_a_of_type_ComTencentAvCameraCameraUtils != null)
    {
      this.jdField_a_of_type_ComTencentAvCameraCameraUtils.b(this.jdField_a_of_type_Ljr);
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
    if (this.jdField_a_of_type_Mcq != null)
    {
      this.jdField_a_of_type_Mcq.b();
      this.jdField_a_of_type_Mcq = null;
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
      label359:
      int i1;
      break label359;
    }
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_Lfk);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_Mcx);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_Lee);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      localObject = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
      if (localObject != null) {
        ((lkf)localObject).a();
      }
    }
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null)
    {
      unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
    }
    if (this.jdField_e_of_type_Boolean)
    {
      lls.a().a();
      if (this.jdField_a_of_type_Mtt != null) {
        this.jdField_a_of_type_Mtt.a(this.jdField_a_of_type_JavaLangString);
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
    this.jdField_a_of_type_Mtt = null;
    this.jdField_a_of_type_Mcc = null;
    AudioHelper.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
    this.jdField_a_of_type_Mcx = null;
    this.jdField_a_of_type_Lfk = null;
    if (this.jdField_a_of_type_Mcv != null)
    {
      this.jdField_a_of_type_Mcv.b();
      this.jdField_a_of_type_Mcv = null;
    }
    lhw.a().a(null);
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(7004), this.jdField_c_of_type_JavaLangString, Boolean.valueOf(this.jdField_e_of_type_Boolean) });
    }
    ltm.a().a();
    ltm.a().a(null, null);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
    if (this.jdField_a_of_type_Mhw != null)
    {
      i1 = this.jdField_a_of_type_Mhw.a();
      if (i1 > 0) {
        bdla.b(null, "CliOper", "", "", "0X800A345", "0X800A345", i1, 0, "", "", "", "");
      }
      this.jdField_a_of_type_Mhw.g();
    }
    this.jdField_a_of_type_Mhw = null;
    mrr.a(this);
  }
  
  @RequiresApi(api=16)
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool = false;
    if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      bool = this.jdField_a_of_type_ComTencentAvUiVideoControlUI.a(paramInt, paramKeyEvent);
    }
    if (bool) {
      return true;
    }
    switch (paramInt)
    {
    default: 
    case 84: 
    case 24: 
    case 25: 
      for (;;)
      {
        return super.onKeyDown(paramInt, paramKeyEvent);
        return true;
        try
        {
          if ((lfm.a()) && (lfm.a().b()))
          {
            if (paramInt == 25) {}
            for (int i1 = -1;; i1 = 1)
            {
              Object localObject = (AudioManager)BaseApplicationImpl.getApplication().getSystemService("audio");
              int i2 = ((AudioManager)localObject).getStreamVolume(0);
              if (this.jdField_a_of_type_JavaLangInteger == null) {
                this.jdField_a_of_type_JavaLangInteger = Integer.valueOf(i2);
              }
              int i3 = ((AudioManager)localObject).getStreamMaxVolume(0);
              if (this.jdField_c_of_type_JavaLangInteger == null) {
                this.jdField_c_of_type_JavaLangInteger = Integer.valueOf(i3);
              }
              ((AudioManager)localObject).adjustStreamVolume(0, i1, 1);
              i1 = ((AudioManager)localObject).getStreamVolume(0);
              this.jdField_b_of_type_JavaLangInteger = Integer.valueOf(i1);
              localObject = this.jdField_a_of_type_ComTencentAvVideoController.b();
              if (localObject != null) {
                ((WatchTogetherMediaPlayCtrl)localObject).a().a(this.jdField_c_of_type_JavaLangInteger.intValue(), this.jdField_b_of_type_JavaLangInteger.intValue());
              }
              if (QLog.isColorLevel()) {
                QLog.d(this.jdField_b_of_type_JavaLangString, 2, "adjustStreamVolume. streamType = " + 0 + ", maxVolume = " + i3 + ", oldVolume = " + i2 + ", newVolume = " + i1);
              }
              return true;
            }
          }
        }
        catch (Exception localException)
        {
          QLog.e(this.jdField_b_of_type_JavaLangString, 1, "adjustStreamVolume fail.", localException);
        }
      }
    }
    if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (this.jdField_a_of_type_ComTencentAvCameraCameraUtils != null))
    {
      paramKeyEvent = this.jdField_a_of_type_ComTencentAvVideoController.a();
      if (((paramKeyEvent.jdField_d_of_type_Int == 2) && (paramKeyEvent.l())) || ((paramKeyEvent.jdField_d_of_type_Int == 4) && (paramKeyEvent.jdField_g_of_type_Int >= 9)))
      {
        long l1 = AudioHelper.b();
        if (this.jdField_a_of_type_ComTencentAvCameraCameraUtils.b(l1)) {
          f(l1);
        }
      }
    }
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
    if (this.jdField_a_of_type_Lzh != null) {
      this.jdField_a_of_type_Lzh.b();
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
    aqrl.a(this, 2, true);
    ltm.a().a(16);
    i(false);
    biwn.a(BaseApplicationImpl.getContext(), true, 50, 1);
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
        if ("0".equals(lci.jdField_a_of_type_JavaLangString)) {
          this.jdField_a_of_type_ComTencentAvVideoController.a("backgroundReason", "5");
        }
      }
      QLog.d(this.jdField_b_of_type_JavaLangString, 1, "avideo life_onPause end");
      if (this.jdField_a_of_type_Mhw != null)
      {
        this.jdField_a_of_type_Mhw.c();
        this.jdField_a_of_type_Mhw.f();
      }
      this.jdField_a_of_type_Lkn.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_a_of_type_ComTencentAvVideoController);
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
    //   2: invokevirtual 2780	com/tencent/av/ui/AVActivity:i	(Z)V
    //   5: invokestatic 243	com/tencent/mobileqq/utils/AudioHelper:b	()J
    //   8: lstore 10
    //   10: aload_0
    //   11: iconst_2
    //   12: iconst_0
    //   13: invokestatic 2777	aqrl:a	(Landroid/content/Context;IZ)V
    //   16: invokestatic 2783	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   19: bipush 50
    //   21: iconst_0
    //   22: invokestatic 2815	biwn:a	(Landroid/content/Context;II)V
    //   25: invokestatic 2783	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   28: iconst_0
    //   29: bipush 50
    //   31: iconst_1
    //   32: invokestatic 2788	biwn:a	(Landroid/content/Context;ZII)V
    //   35: invokestatic 2783	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   38: bipush 50
    //   40: iconst_2
    //   41: invokestatic 2815	biwn:a	(Landroid/content/Context;II)V
    //   44: new 231	java/lang/StringBuilder
    //   47: dup
    //   48: invokespecial 232	java/lang/StringBuilder:<init>	()V
    //   51: aload_0
    //   52: getfield 252	com/tencent/av/ui/AVActivity:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   55: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: ldc_w 2817
    //   61: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: invokevirtual 250	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   67: invokestatic 2411	com/tencent/mobileqq/utils/AudioHelper:b	(Ljava/lang/String;)V
    //   70: aload_0
    //   71: iconst_0
    //   72: putfield 229	com/tencent/av/ui/AVActivity:mIsShadow	Z
    //   75: aload_0
    //   76: invokespecial 2819	mqq/app/BaseActivity:onResume	()V
    //   79: invokestatic 531	lbz:a	()Llbz;
    //   82: invokevirtual 534	lbz:a	()Llfe;
    //   85: astore 22
    //   87: aload_0
    //   88: getfield 252	com/tencent/av/ui/AVActivity:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   91: iconst_1
    //   92: new 231	java/lang/StringBuilder
    //   95: dup
    //   96: invokespecial 232	java/lang/StringBuilder:<init>	()V
    //   99: ldc_w 2821
    //   102: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: aload_0
    //   106: getfield 648	com/tencent/av/ui/AVActivity:o	Z
    //   109: invokevirtual 499	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   112: ldc_w 593
    //   115: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: lload 10
    //   120: invokevirtual 246	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   123: ldc_w 2823
    //   126: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: aload 22
    //   131: invokevirtual 816	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   134: ldc_w 313
    //   137: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: invokevirtual 250	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   143: invokestatic 433	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   146: aload_0
    //   147: iconst_0
    //   148: putfield 2790	com/tencent/av/ui/AVActivity:jdField_i_of_type_Boolean	Z
    //   151: invokestatic 2826	lqe:a	()V
    //   154: aload_0
    //   155: getfield 141	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvAppVideoAppInterface	Lcom/tencent/av/app/VideoAppInterface;
    //   158: iconst_4
    //   159: invokevirtual 358	com/tencent/av/app/VideoAppInterface:a	(I)Llgp;
    //   162: checkcast 1621	lik
    //   165: astore 23
    //   167: aload 22
    //   169: getfield 1009	lfe:jdField_e_of_type_Boolean	Z
    //   172: ifeq +16 -> 188
    //   175: aload 23
    //   177: aload 22
    //   179: invokevirtual 1622	lfe:b	()J
    //   182: bipush 8
    //   184: lconst_1
    //   185: invokevirtual 1627	lik:a	(JIJ)V
    //   188: aload_0
    //   189: invokevirtual 1250	com/tencent/av/ui/AVActivity:getIntent	()Landroid/content/Intent;
    //   192: ldc_w 2492
    //   195: iconst_0
    //   196: invokevirtual 284	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   199: ifeq +13 -> 212
    //   202: aload 23
    //   204: ldc2_w 2493
    //   207: iconst_3
    //   208: lconst_1
    //   209: invokevirtual 1627	lik:a	(JIJ)V
    //   212: aload_0
    //   213: getfield 141	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvAppVideoAppInterface	Lcom/tencent/av/app/VideoAppInterface;
    //   216: invokevirtual 2827	com/tencent/av/app/VideoAppInterface:l	()Z
    //   219: ifne +10 -> 229
    //   222: aload_0
    //   223: getfield 141	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvAppVideoAppInterface	Lcom/tencent/av/app/VideoAppInterface;
    //   226: invokevirtual 2828	com/tencent/av/app/VideoAppInterface:c	()V
    //   229: aload_0
    //   230: getfield 648	com/tencent/av/ui/AVActivity:o	Z
    //   233: ifeq +19 -> 252
    //   236: aload_0
    //   237: getfield 81	com/tencent/av/ui/AVActivity:jdField_b_of_type_Int	I
    //   240: iconst_1
    //   241: if_icmpeq +11 -> 252
    //   244: aload_0
    //   245: getfield 81	com/tencent/av/ui/AVActivity:jdField_b_of_type_Int	I
    //   248: iconst_2
    //   249: if_icmpne +3 -> 252
    //   252: aload_0
    //   253: iconst_0
    //   254: putfield 648	com/tencent/av/ui/AVActivity:o	Z
    //   257: aload_0
    //   258: invokevirtual 2121	com/tencent/av/ui/AVActivity:b	()I
    //   261: istore 4
    //   263: aload_0
    //   264: iconst_0
    //   265: putfield 203	com/tencent/av/ui/AVActivity:jdField_k_of_type_Boolean	Z
    //   268: aload_0
    //   269: iconst_2
    //   270: invokevirtual 2580	com/tencent/av/ui/AVActivity:b	(I)V
    //   273: aload_0
    //   274: getfield 143	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvVideoController	Lcom/tencent/av/VideoController;
    //   277: iconst_1
    //   278: invokevirtual 1515	com/tencent/av/VideoController:h	(Z)V
    //   281: aload_0
    //   282: getfield 334	com/tencent/av/ui/AVActivity:jdField_a_of_type_Lzh	Llzh;
    //   285: ifnull +10 -> 295
    //   288: aload_0
    //   289: getfield 334	com/tencent/av/ui/AVActivity:jdField_a_of_type_Lzh	Llzh;
    //   292: invokevirtual 2764	lzh:b	()V
    //   295: getstatic 486	android/os/Build$VERSION:SDK_INT	I
    //   298: bipush 21
    //   300: if_icmplt +47 -> 347
    //   303: aload_0
    //   304: getfield 143	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvVideoController	Lcom/tencent/av/VideoController;
    //   307: invokevirtual 922	com/tencent/av/VideoController:a	()Lmjw;
    //   310: astore 20
    //   312: aload 20
    //   314: ifnull +33 -> 347
    //   317: aload 20
    //   319: invokevirtual 2829	mjw:c	()Z
    //   322: ifeq +25 -> 347
    //   325: aload_0
    //   326: getfield 141	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvAppVideoAppInterface	Lcom/tencent/av/app/VideoAppInterface;
    //   329: invokevirtual 1123	com/tencent/av/app/VideoAppInterface:a	()Landroid/os/Handler;
    //   332: new 2831	com/tencent/av/ui/AVActivity$11
    //   335: dup
    //   336: aload_0
    //   337: invokespecial 2832	com/tencent/av/ui/AVActivity$11:<init>	(Lcom/tencent/av/ui/AVActivity;)V
    //   340: ldc2_w 2833
    //   343: invokevirtual 1132	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   346: pop
    //   347: aload_0
    //   348: getfield 141	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvAppVideoAppInterface	Lcom/tencent/av/app/VideoAppInterface;
    //   351: invokevirtual 1123	com/tencent/av/app/VideoAppInterface:a	()Landroid/os/Handler;
    //   354: new 2836	com/tencent/av/ui/AVActivity$12
    //   357: dup
    //   358: aload_0
    //   359: lload 10
    //   361: invokespecial 2838	com/tencent/av/ui/AVActivity$12:<init>	(Lcom/tencent/av/ui/AVActivity;J)V
    //   364: ldc2_w 2839
    //   367: invokevirtual 1132	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   370: pop
    //   371: aload 22
    //   373: getfield 568	lfe:jdField_d_of_type_Int	I
    //   376: iconst_2
    //   377: if_icmpne +1097 -> 1474
    //   380: aload 22
    //   382: invokevirtual 2757	lfe:l	()Z
    //   385: ifeq +1035 -> 1420
    //   388: aload 22
    //   390: getfield 1315	lfe:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   393: astore 20
    //   395: aload 22
    //   397: getfield 2841	lfe:jdField_k_of_type_Boolean	Z
    //   400: istore 16
    //   402: aload_0
    //   403: getfield 143	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvVideoController	Lcom/tencent/av/VideoController;
    //   406: aload_0
    //   407: getfield 95	com/tencent/av/ui/AVActivity:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   410: invokevirtual 2843	com/tencent/av/VideoController:b	(Ljava/lang/String;)Z
    //   413: istore 17
    //   415: aload 22
    //   417: getfield 2844	lfe:jdField_i_of_type_Boolean	Z
    //   420: istore 18
    //   422: aload 22
    //   424: getfield 2845	lfe:jdField_j_of_type_Boolean	Z
    //   427: istore 19
    //   429: iload 19
    //   431: ifeq +41 -> 472
    //   434: invokestatic 2850	com/tencent/mobileqq/utils/DeviceInfoUtil:getDeviceModel	()Ljava/lang/String;
    //   437: astore 21
    //   439: aload_0
    //   440: getfield 1015	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvCameraCameraUtils	Lcom/tencent/av/camera/CameraUtils;
    //   443: lload 10
    //   445: invokevirtual 2852	com/tencent/av/camera/CameraUtils:a	(J)Z
    //   448: ifne +859 -> 1307
    //   451: aload_0
    //   452: getfield 1015	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvCameraCameraUtils	Lcom/tencent/av/camera/CameraUtils;
    //   455: lload 10
    //   457: invokevirtual 1023	com/tencent/av/camera/CameraUtils:b	(J)Z
    //   460: ifne +847 -> 1307
    //   463: aload_0
    //   464: getfield 1015	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvCameraCameraUtils	Lcom/tencent/av/camera/CameraUtils;
    //   467: lload 10
    //   469: invokevirtual 2853	com/tencent/av/camera/CameraUtils:a	(J)V
    //   472: aload_0
    //   473: getfield 595	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   476: ifnull +59 -> 535
    //   479: iload 19
    //   481: ifeq +895 -> 1376
    //   484: iload 16
    //   486: ifeq +890 -> 1376
    //   489: iload 18
    //   491: ifeq +854 -> 1345
    //   494: aload_0
    //   495: getfield 595	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   498: lload 10
    //   500: aload 20
    //   502: iconst_1
    //   503: iconst_1
    //   504: iconst_0
    //   505: iload 17
    //   507: invokevirtual 1503	com/tencent/av/ui/VideoLayerUI:a	(JLjava/lang/String;IZZZ)V
    //   510: aload_0
    //   511: getfield 141	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvAppVideoAppInterface	Lcom/tencent/av/app/VideoAppInterface;
    //   514: ldc_w 2854
    //   517: invokestatic 2857	mqx:a	(Lcom/tencent/av/app/VideoAppInterface;Ljava/lang/String;)Z
    //   520: istore 16
    //   522: aload_0
    //   523: getfield 595	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   526: lload 10
    //   528: iconst_1
    //   529: iload 16
    //   531: invokevirtual 1018	com/tencent/av/ui/VideoLayerUI:b	(JZZ)Z
    //   534: pop
    //   535: aload_0
    //   536: getfield 595	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   539: ifnull +10 -> 549
    //   542: aload_0
    //   543: getfield 595	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   546: invokevirtual 2859	com/tencent/av/ui/VideoLayerUI:q	()V
    //   549: aload_0
    //   550: getfield 565	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoControlUI	Lcom/tencent/av/ui/VideoControlUI;
    //   553: ifnull +12 -> 565
    //   556: aload_0
    //   557: getfield 565	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoControlUI	Lcom/tencent/av/ui/VideoControlUI;
    //   560: lload 10
    //   562: invokevirtual 2861	com/tencent/av/ui/VideoControlUI:b	(J)V
    //   565: aload_0
    //   566: getfield 627	com/tencent/av/ui/AVActivity:jdField_a_of_type_Mcq	Lmcq;
    //   569: ifnull +10 -> 579
    //   572: aload_0
    //   573: getfield 627	com/tencent/av/ui/AVActivity:jdField_a_of_type_Mcq	Lmcq;
    //   576: invokevirtual 2862	mcq:c	()V
    //   579: aload_0
    //   580: getfield 143	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvVideoController	Lcom/tencent/av/VideoController;
    //   583: iconst_0
    //   584: invokevirtual 1513	com/tencent/av/VideoController:a	(Z)I
    //   587: pop
    //   588: aload_0
    //   589: invokevirtual 2863	com/tencent/av/ui/AVActivity:b	()V
    //   592: aload_0
    //   593: invokevirtual 2864	com/tencent/av/ui/AVActivity:e	()V
    //   596: aload_0
    //   597: getfield 141	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvAppVideoAppInterface	Lcom/tencent/av/app/VideoAppInterface;
    //   600: invokevirtual 2514	com/tencent/av/app/VideoAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   603: new 263	android/content/Intent
    //   606: dup
    //   607: ldc_w 2465
    //   610: invokespecial 2466	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   613: invokevirtual 2517	com/tencent/qphone/base/util/BaseApplication:sendBroadcast	(Landroid/content/Intent;)V
    //   616: aload_0
    //   617: getfield 595	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   620: ifnull +20 -> 640
    //   623: aload_0
    //   624: invokevirtual 641	com/tencent/av/ui/AVActivity:a	()Z
    //   627: ifeq +13 -> 640
    //   630: aload_0
    //   631: getfield 595	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   634: ldc_w 2854
    //   637: invokevirtual 2251	com/tencent/av/ui/VideoLayerUI:a	(Ljava/lang/String;)V
    //   640: aload 22
    //   642: getfield 568	lfe:jdField_d_of_type_Int	I
    //   645: iconst_2
    //   646: if_icmpeq +12 -> 658
    //   649: aload 22
    //   651: getfield 568	lfe:jdField_d_of_type_Int	I
    //   654: iconst_1
    //   655: if_icmpne +45 -> 700
    //   658: aload_0
    //   659: getfield 702	com/tencent/av/ui/AVActivity:jdField_a_of_type_Mji	Lmji;
    //   662: ifnull +38 -> 700
    //   665: aload_0
    //   666: getfield 702	com/tencent/av/ui/AVActivity:jdField_a_of_type_Mji	Lmji;
    //   669: invokevirtual 2866	mji:d	()I
    //   672: iconst_1
    //   673: if_icmpne +27 -> 700
    //   676: aload 22
    //   678: getfield 1088	lfe:C	Z
    //   681: ifeq +19 -> 700
    //   684: aload_0
    //   685: getfield 221	com/tencent/av/ui/AVActivity:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   688: new 2868	com/tencent/av/ui/AVActivity$14
    //   691: dup
    //   692: aload_0
    //   693: invokespecial 2869	com/tencent/av/ui/AVActivity$14:<init>	(Lcom/tencent/av/ui/AVActivity;)V
    //   696: invokevirtual 1373	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   699: pop
    //   700: aload 22
    //   702: getfield 2872	lfe:X	I
    //   705: iconst_m1
    //   706: if_icmpne +12 -> 718
    //   709: aload 22
    //   711: aload_0
    //   712: invokevirtual 2873	com/tencent/av/ui/AVActivity:a	()I
    //   715: putfield 2872	lfe:X	I
    //   718: aload 22
    //   720: getfield 2876	lfe:W	I
    //   723: iconst_m1
    //   724: if_icmpne +105 -> 829
    //   727: aload_0
    //   728: invokevirtual 654	com/tencent/av/ui/AVActivity:getApplicationContext	()Landroid/content/Context;
    //   731: invokestatic 774	bhhr:a	(Landroid/content/Context;)Landroid/content/SharedPreferences;
    //   734: astore 20
    //   736: aload 22
    //   738: aload 20
    //   740: new 231	java/lang/StringBuilder
    //   743: dup
    //   744: invokespecial 232	java/lang/StringBuilder:<init>	()V
    //   747: ldc_w 2878
    //   750: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   753: aload_0
    //   754: getfield 141	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvAppVideoAppInterface	Lcom/tencent/av/app/VideoAppInterface;
    //   757: invokevirtual 777	com/tencent/av/app/VideoAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   760: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   763: invokevirtual 250	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   766: iconst_1
    //   767: invokeinterface 787 3 0
    //   772: putfield 2876	lfe:W	I
    //   775: aload 22
    //   777: getfield 2876	lfe:W	I
    //   780: iconst_1
    //   781: if_icmpne +48 -> 829
    //   784: aload 20
    //   786: invokeinterface 2882 1 0
    //   791: new 231	java/lang/StringBuilder
    //   794: dup
    //   795: invokespecial 232	java/lang/StringBuilder:<init>	()V
    //   798: ldc_w 2878
    //   801: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   804: aload_0
    //   805: getfield 141	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvAppVideoAppInterface	Lcom/tencent/av/app/VideoAppInterface;
    //   808: invokevirtual 777	com/tencent/av/app/VideoAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   811: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   814: invokevirtual 250	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   817: iconst_0
    //   818: invokeinterface 2888 3 0
    //   823: invokeinterface 2891 1 0
    //   828: pop
    //   829: aload 22
    //   831: getfield 2178	lfe:v	I
    //   834: ifeq +38 -> 872
    //   837: aload 22
    //   839: getfield 2178	lfe:v	I
    //   842: iconst_1
    //   843: if_icmpne +1323 -> 2166
    //   846: aload_0
    //   847: iconst_2
    //   848: aload_0
    //   849: invokevirtual 827	com/tencent/av/ui/AVActivity:getResources	()Landroid/content/res/Resources;
    //   852: ldc_w 2892
    //   855: invokevirtual 2893	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   858: iconst_0
    //   859: invokestatic 2898	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;ILjava/lang/CharSequence;I)Lcom/tencent/mobileqq/widget/QQToast;
    //   862: invokevirtual 2901	com/tencent/mobileqq/widget/QQToast:a	()Landroid/widget/Toast;
    //   865: pop
    //   866: aload 22
    //   868: iconst_0
    //   869: putfield 2178	lfe:v	I
    //   872: aload_0
    //   873: getfield 141	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvAppVideoAppInterface	Lcom/tencent/av/app/VideoAppInterface;
    //   876: iconst_2
    //   877: anewarray 1406	java/lang/Object
    //   880: dup
    //   881: iconst_0
    //   882: sipush 7000
    //   885: invokestatic 975	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   888: aastore
    //   889: dup
    //   890: iconst_1
    //   891: aload_0
    //   892: getfield 95	com/tencent/av/ui/AVActivity:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   895: aastore
    //   896: invokevirtual 1409	com/tencent/av/app/VideoAppInterface:a	([Ljava/lang/Object;)V
    //   899: invokestatic 760	com/tencent/mobileqq/utils/AudioHelper:e	()Z
    //   902: ifeq +10 -> 912
    //   905: aload_0
    //   906: getfield 141	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvAppVideoAppInterface	Lcom/tencent/av/app/VideoAppInterface;
    //   909: invokestatic 2904	com/tencent/mobileqq/debug/PstnCardTestActivity:showTestBtn	(Lcom/tencent/av/app/VideoAppInterface;)V
    //   912: invokestatic 1362	ltm:a	()Lltm;
    //   915: bipush 16
    //   917: invokevirtual 2905	ltm:b	(I)V
    //   920: aload 22
    //   922: getfield 2845	lfe:jdField_j_of_type_Boolean	Z
    //   925: istore 16
    //   927: aload 22
    //   929: getfield 2841	lfe:jdField_k_of_type_Boolean	Z
    //   932: istore 17
    //   934: iload 16
    //   936: ifeq +8 -> 944
    //   939: iload 17
    //   941: ifne +1248 -> 2189
    //   944: invokestatic 1362	ltm:a	()Lltm;
    //   947: iconst_1
    //   948: invokevirtual 2778	ltm:a	(I)V
    //   951: invokestatic 2908	java/lang/System:currentTimeMillis	()J
    //   954: lstore 12
    //   956: invokestatic 2586	lwa:a	()Llwa;
    //   959: getfield 2909	lwa:jdField_b_of_type_Long	J
    //   962: lstore 14
    //   964: aload 22
    //   966: invokevirtual 1622	lfe:b	()J
    //   969: lconst_0
    //   970: lcmp
    //   971: ifle +1228 -> 2199
    //   974: aload 22
    //   976: invokevirtual 1622	lfe:b	()J
    //   979: lstore 8
    //   981: aload 23
    //   983: lload 8
    //   985: bipush 25
    //   987: lload 12
    //   989: lload 14
    //   991: lsub
    //   992: invokevirtual 1627	lik:a	(JIJ)V
    //   995: aload_0
    //   996: getfield 143	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvVideoController	Lcom/tencent/av/VideoController;
    //   999: ldc_w 2795
    //   1002: ldc_w 2911
    //   1005: invokevirtual 2359	com/tencent/av/VideoController:a	(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/av/VideoController;
    //   1008: pop
    //   1009: ldc_w 2797
    //   1012: putstatic 2362	lci:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1015: new 231	java/lang/StringBuilder
    //   1018: dup
    //   1019: invokespecial 232	java/lang/StringBuilder:<init>	()V
    //   1022: aload_0
    //   1023: getfield 252	com/tencent/av/ui/AVActivity:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1026: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1029: ldc_w 2913
    //   1032: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1035: invokevirtual 250	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1038: invokestatic 2411	com/tencent/mobileqq/utils/AudioHelper:b	(Ljava/lang/String;)V
    //   1041: aload_0
    //   1042: invokevirtual 1250	com/tencent/av/ui/AVActivity:getIntent	()Landroid/content/Intent;
    //   1045: ldc_w 2915
    //   1048: iconst_0
    //   1049: invokevirtual 267	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   1052: ifeq +21 -> 1073
    //   1055: invokestatic 2920	aczy:a	()Laczy;
    //   1058: aload_0
    //   1059: invokevirtual 1250	com/tencent/av/ui/AVActivity:getIntent	()Landroid/content/Intent;
    //   1062: ldc_w 2915
    //   1065: iconst_0
    //   1066: invokevirtual 267	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   1069: iconst_1
    //   1070: invokevirtual 2921	aczy:a	(IZ)V
    //   1073: aload_0
    //   1074: invokevirtual 2922	com/tencent/av/ui/AVActivity:a	()Lcom/tencent/av/VideoController;
    //   1077: invokevirtual 2924	com/tencent/av/VideoController:w	()V
    //   1080: invokestatic 606	com/tencent/av/VideoController:a	()Lcom/tencent/av/VideoController;
    //   1083: aload_0
    //   1084: invokevirtual 1207	com/tencent/av/VideoController:a	(Landroid/content/Context;)Llph;
    //   1087: astore 20
    //   1089: aload 20
    //   1091: ifnull +12 -> 1103
    //   1094: aload 20
    //   1096: lload 10
    //   1098: invokeinterface 2927 3 0
    //   1103: invokestatic 760	com/tencent/mobileqq/utils/AudioHelper:e	()Z
    //   1106: ifeq +46 -> 1152
    //   1109: aload_0
    //   1110: getfield 252	com/tencent/av/ui/AVActivity:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1113: iconst_1
    //   1114: new 231	java/lang/StringBuilder
    //   1117: dup
    //   1118: invokespecial 232	java/lang/StringBuilder:<init>	()V
    //   1121: ldc_w 2929
    //   1124: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1127: aload_0
    //   1128: invokevirtual 2107	com/tencent/av/ui/AVActivity:getWindow	()Landroid/view/Window;
    //   1131: invokevirtual 473	android/view/Window:getDecorView	()Landroid/view/View;
    //   1134: invokevirtual 478	android/view/View:getSystemUiVisibility	()I
    //   1137: invokevirtual 309	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1140: ldc_w 313
    //   1143: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1146: invokevirtual 250	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1149: invokestatic 433	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1152: aload_0
    //   1153: getfield 179	com/tencent/av/ui/AVActivity:jdField_a_of_type_Lkn	Llkn;
    //   1156: aload_0
    //   1157: aload_0
    //   1158: getfield 141	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvAppVideoAppInterface	Lcom/tencent/av/app/VideoAppInterface;
    //   1161: aload_0
    //   1162: getfield 143	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvVideoController	Lcom/tencent/av/VideoController;
    //   1165: invokevirtual 2932	lkn:a	(Lmqq/app/BaseActivity;Lcom/tencent/av/app/VideoAppInterface;Lcom/tencent/av/VideoController;)V
    //   1168: aload_0
    //   1169: getfield 1038	com/tencent/av/ui/AVActivity:jdField_a_of_type_Mnm	Lmnm;
    //   1172: ifnull +76 -> 1248
    //   1175: invokestatic 304	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1178: ifeq +41 -> 1219
    //   1181: aload_0
    //   1182: getfield 252	com/tencent/av/ui/AVActivity:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1185: iconst_2
    //   1186: new 231	java/lang/StringBuilder
    //   1189: dup
    //   1190: invokespecial 232	java/lang/StringBuilder:<init>	()V
    //   1193: ldc_w 2934
    //   1196: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1199: aload 22
    //   1201: getfield 2937	lfe:aC	Z
    //   1204: invokevirtual 499	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1207: ldc_w 313
    //   1210: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1213: invokevirtual 250	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1216: invokestatic 316	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1219: aload 22
    //   1221: getfield 2937	lfe:aC	Z
    //   1224: ifeq +17 -> 1241
    //   1227: aload_0
    //   1228: getfield 1038	com/tencent/av/ui/AVActivity:jdField_a_of_type_Mnm	Lmnm;
    //   1231: iconst_0
    //   1232: invokevirtual 2938	mnm:a	(I)V
    //   1235: aload 22
    //   1237: iconst_0
    //   1238: putfield 2937	lfe:aC	Z
    //   1241: aload_0
    //   1242: getfield 1038	com/tencent/av/ui/AVActivity:jdField_a_of_type_Mnm	Lmnm;
    //   1245: invokevirtual 1042	mnm:a	()V
    //   1248: aload_0
    //   1249: getfield 141	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvAppVideoAppInterface	Lcom/tencent/av/app/VideoAppInterface;
    //   1252: invokevirtual 1123	com/tencent/av/app/VideoAppInterface:a	()Landroid/os/Handler;
    //   1255: new 2940	com/tencent/av/ui/AVActivity$15
    //   1258: dup
    //   1259: aload_0
    //   1260: iload 4
    //   1262: invokespecial 2943	com/tencent/av/ui/AVActivity$15:<init>	(Lcom/tencent/av/ui/AVActivity;I)V
    //   1265: ldc2_w 2833
    //   1268: invokevirtual 1132	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   1271: pop
    //   1272: return
    //   1273: astore 20
    //   1275: aload_0
    //   1276: getfield 252	com/tencent/av/ui/AVActivity:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1279: iconst_1
    //   1280: new 231	java/lang/StringBuilder
    //   1283: dup
    //   1284: invokespecial 232	java/lang/StringBuilder:<init>	()V
    //   1287: ldc_w 2945
    //   1290: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1293: aload 20
    //   1295: invokevirtual 816	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1298: invokevirtual 250	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1301: invokestatic 326	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1304: goto -1225 -> 79
    //   1307: aload 21
    //   1309: ldc_w 2947
    //   1312: invokevirtual 2950	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1315: ifeq -843 -> 472
    //   1318: aload_0
    //   1319: getfield 1015	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvCameraCameraUtils	Lcom/tencent/av/camera/CameraUtils;
    //   1322: invokevirtual 2953	com/tencent/av/camera/CameraUtils:a	()Landroid/hardware/Camera$Parameters;
    //   1325: ifnonnull -853 -> 472
    //   1328: aload_0
    //   1329: getfield 1015	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvCameraCameraUtils	Lcom/tencent/av/camera/CameraUtils;
    //   1332: ldc_w 2955
    //   1335: lload 10
    //   1337: iconst_m1
    //   1338: iconst_m1
    //   1339: invokevirtual 2958	com/tencent/av/camera/CameraUtils:a	(Ljava/lang/String;JII)V
    //   1342: goto -870 -> 472
    //   1345: aload_0
    //   1346: getfield 595	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   1349: lload 10
    //   1351: iconst_1
    //   1352: iconst_0
    //   1353: invokevirtual 1018	com/tencent/av/ui/VideoLayerUI:b	(JZZ)Z
    //   1356: pop
    //   1357: aload_0
    //   1358: getfield 595	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   1361: lload 10
    //   1363: aload 20
    //   1365: iconst_1
    //   1366: iconst_1
    //   1367: iconst_0
    //   1368: iload 17
    //   1370: invokevirtual 1503	com/tencent/av/ui/VideoLayerUI:a	(JLjava/lang/String;IZZZ)V
    //   1373: goto -838 -> 535
    //   1376: iload 19
    //   1378: ifeq +18 -> 1396
    //   1381: aload_0
    //   1382: getfield 595	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   1385: lload 10
    //   1387: iconst_1
    //   1388: iconst_0
    //   1389: invokevirtual 1018	com/tencent/av/ui/VideoLayerUI:b	(JZZ)Z
    //   1392: pop
    //   1393: goto -858 -> 535
    //   1396: iload 16
    //   1398: ifeq -863 -> 535
    //   1401: aload_0
    //   1402: getfield 595	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   1405: lload 10
    //   1407: aload 20
    //   1409: iconst_1
    //   1410: iconst_1
    //   1411: iconst_0
    //   1412: iload 17
    //   1414: invokevirtual 1503	com/tencent/av/ui/VideoLayerUI:a	(JLjava/lang/String;IZZZ)V
    //   1417: goto -882 -> 535
    //   1420: aload 22
    //   1422: getfield 1940	lfe:ai	Z
    //   1425: ifne -890 -> 535
    //   1428: aload_0
    //   1429: getfield 127	com/tencent/av/ui/AVActivity:jdField_f_of_type_Boolean	Z
    //   1432: ifne -897 -> 535
    //   1435: aload 22
    //   1437: lload 10
    //   1439: iconst_1
    //   1440: invokevirtual 1026	lfe:a	(JZ)V
    //   1443: aload_0
    //   1444: getfield 1015	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvCameraCameraUtils	Lcom/tencent/av/camera/CameraUtils;
    //   1447: lload 10
    //   1449: invokevirtual 2853	com/tencent/av/camera/CameraUtils:a	(J)V
    //   1452: aload_0
    //   1453: getfield 595	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   1456: ifnull -921 -> 535
    //   1459: aload_0
    //   1460: getfield 595	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   1463: lload 10
    //   1465: iconst_1
    //   1466: iconst_0
    //   1467: invokevirtual 1018	com/tencent/av/ui/VideoLayerUI:b	(JZZ)Z
    //   1470: pop
    //   1471: goto -936 -> 535
    //   1474: aload 22
    //   1476: getfield 568	lfe:jdField_d_of_type_Int	I
    //   1479: iconst_4
    //   1480: if_icmpne -945 -> 535
    //   1483: aload 22
    //   1485: getfield 1474	lfe:jdField_c_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   1488: astore 24
    //   1490: aload 24
    //   1492: new 2960	mbo
    //   1495: dup
    //   1496: aload_0
    //   1497: invokespecial 2961	mbo:<init>	(Lcom/tencent/av/ui/AVActivity;)V
    //   1500: invokestatic 2967	java/util/Collections:sort	(Ljava/util/List;Ljava/util/Comparator;)V
    //   1503: aload_0
    //   1504: getfield 143	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvVideoController	Lcom/tencent/av/VideoController;
    //   1507: invokevirtual 2605	com/tencent/av/VideoController:h	()I
    //   1510: istore 5
    //   1512: iconst_0
    //   1513: istore_3
    //   1514: iload_3
    //   1515: aload 24
    //   1517: invokevirtual 1479	java/util/ArrayList:size	()I
    //   1520: if_icmpge -985 -> 535
    //   1523: aload 24
    //   1525: iload_3
    //   1526: invokevirtual 1483	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1529: checkcast 1485	lob
    //   1532: astore 25
    //   1534: aload 25
    //   1536: getfield 1486	lob:jdField_a_of_type_Long	J
    //   1539: invokestatic 1491	mry:a	(J)Ljava/lang/String;
    //   1542: astore 26
    //   1544: aload 25
    //   1546: getfield 1492	lob:jdField_a_of_type_Int	I
    //   1549: istore 6
    //   1551: aload 25
    //   1553: getfield 2968	lob:jdField_a_of_type_Boolean	Z
    //   1556: istore 17
    //   1558: aload_0
    //   1559: getfield 595	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   1562: ifnull +371 -> 1933
    //   1565: aload_0
    //   1566: getfield 595	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   1569: aload 26
    //   1571: iload 6
    //   1573: invokevirtual 2971	com/tencent/av/ui/VideoLayerUI:a	(Ljava/lang/String;I)Z
    //   1576: istore 16
    //   1578: aload_0
    //   1579: getfield 87	com/tencent/av/ui/AVActivity:jdField_d_of_type_Int	I
    //   1582: invokestatic 2972	mrr:b	(I)I
    //   1585: istore 7
    //   1587: aload_0
    //   1588: getfield 141	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvAppVideoAppInterface	Lcom/tencent/av/app/VideoAppInterface;
    //   1591: iload 7
    //   1593: aload 26
    //   1595: aload 22
    //   1597: getfield 1756	lfe:jdField_g_of_type_Long	J
    //   1600: invokestatic 1660	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1603: invokevirtual 2187	com/tencent/av/app/VideoAppInterface:getDisplayName	(ILjava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1606: astore 21
    //   1608: aload 25
    //   1610: getfield 2973	lob:jdField_b_of_type_Boolean	Z
    //   1613: ifeq +126 -> 1739
    //   1616: aload 26
    //   1618: aload_0
    //   1619: getfield 141	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvAppVideoAppInterface	Lcom/tencent/av/app/VideoAppInterface;
    //   1622: invokevirtual 777	com/tencent/av/app/VideoAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1625: invokevirtual 1500	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1628: ifne +111 -> 1739
    //   1631: iload 17
    //   1633: ifeq +106 -> 1739
    //   1636: aload 25
    //   1638: getfield 2974	lob:jdField_d_of_type_Boolean	Z
    //   1641: ifne +98 -> 1739
    //   1644: aload 21
    //   1646: invokestatic 2976	mry:a	(Ljava/lang/String;)I
    //   1649: bipush 20
    //   1651: if_icmple +561 -> 2212
    //   1654: new 231	java/lang/StringBuilder
    //   1657: dup
    //   1658: invokespecial 232	java/lang/StringBuilder:<init>	()V
    //   1661: aload 21
    //   1663: iconst_0
    //   1664: bipush 20
    //   1666: invokestatic 2979	mry:a	(Ljava/lang/String;II)Ljava/lang/String;
    //   1669: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1672: ldc_w 2981
    //   1675: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1678: invokevirtual 250	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1681: astore 20
    //   1683: iload 6
    //   1685: iconst_2
    //   1686: if_icmpne +269 -> 1955
    //   1689: aload_0
    //   1690: ldc_w 2982
    //   1693: invokevirtual 2983	com/tencent/av/ui/AVActivity:getString	(I)Ljava/lang/String;
    //   1696: iconst_1
    //   1697: anewarray 1406	java/lang/Object
    //   1700: dup
    //   1701: iconst_0
    //   1702: aload 20
    //   1704: aastore
    //   1705: invokestatic 2987	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1708: astore 20
    //   1710: aload_0
    //   1711: getfield 565	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoControlUI	Lcom/tencent/av/ui/VideoControlUI;
    //   1714: ifnull +225 -> 1939
    //   1717: aload_0
    //   1718: getfield 565	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoControlUI	Lcom/tencent/av/ui/VideoControlUI;
    //   1721: instanceof 2989
    //   1724: ifeq +215 -> 1939
    //   1727: aload_0
    //   1728: getfield 565	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoControlUI	Lcom/tencent/av/ui/VideoControlUI;
    //   1731: sipush 1036
    //   1734: aload 20
    //   1736: invokevirtual 2992	com/tencent/av/ui/VideoControlUI:a	(ILjava/lang/String;)V
    //   1739: aload_0
    //   1740: getfield 595	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   1743: ifnull +183 -> 1926
    //   1746: aload_0
    //   1747: invokespecial 400	com/tencent/av/ui/AVActivity:k	()V
    //   1750: aload 25
    //   1752: getfield 2973	lob:jdField_b_of_type_Boolean	Z
    //   1755: ifne +381 -> 2136
    //   1758: aload 25
    //   1760: getfield 2968	lob:jdField_a_of_type_Boolean	Z
    //   1763: ifne +373 -> 2136
    //   1766: iload 5
    //   1768: iconst_4
    //   1769: if_icmpeq +337 -> 2106
    //   1772: aload 22
    //   1774: getfield 2994	lfe:F	I
    //   1777: iconst_2
    //   1778: if_icmpne +246 -> 2024
    //   1781: aconst_null
    //   1782: ldc_w 1285
    //   1785: ldc_w 440
    //   1788: ldc_w 440
    //   1791: ldc_w 2996
    //   1794: ldc_w 2996
    //   1797: iconst_0
    //   1798: iconst_0
    //   1799: ldc_w 440
    //   1802: ldc_w 440
    //   1805: ldc_w 440
    //   1808: ldc_w 440
    //   1811: invokestatic 1293	bdla:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1814: aload_0
    //   1815: getfield 595	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   1818: lload 10
    //   1820: aload 26
    //   1822: iload 6
    //   1824: aload_0
    //   1825: getfield 147	com/tencent/av/ui/AVActivity:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   1828: aload 25
    //   1830: getfield 2973	lob:jdField_b_of_type_Boolean	Z
    //   1833: aload 25
    //   1835: getfield 2968	lob:jdField_a_of_type_Boolean	Z
    //   1838: invokevirtual 2999	com/tencent/av/ui/VideoLayerUI:a	(JLjava/lang/String;ILandroid/graphics/Bitmap;ZZ)V
    //   1841: iload 16
    //   1843: ifne +83 -> 1926
    //   1846: aload 22
    //   1848: getfield 1602	lfe:J	Z
    //   1851: ifne +75 -> 1926
    //   1854: ldc_w 3000
    //   1857: fstore_2
    //   1858: fload_2
    //   1859: fstore_1
    //   1860: aload_0
    //   1861: getfield 595	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   1864: aload 26
    //   1866: iload 6
    //   1868: invokevirtual 3002	com/tencent/av/ui/VideoLayerUI:b	(Ljava/lang/String;I)Z
    //   1871: ifeq +20 -> 1891
    //   1874: fload_2
    //   1875: fstore_1
    //   1876: aload_0
    //   1877: getfield 595	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   1880: invokevirtual 972	com/tencent/av/ui/VideoLayerUI:f	()I
    //   1883: iconst_3
    //   1884: if_icmpeq +7 -> 1891
    //   1887: ldc_w 3003
    //   1890: fstore_1
    //   1891: aload_0
    //   1892: invokevirtual 654	com/tencent/av/ui/AVActivity:getApplicationContext	()Landroid/content/Context;
    //   1895: fload_1
    //   1896: invokestatic 3006	mvk:a	(Landroid/content/Context;F)F
    //   1899: fstore_1
    //   1900: aload_0
    //   1901: getfield 595	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   1904: aload 26
    //   1906: iload 6
    //   1908: aload 21
    //   1910: fload_1
    //   1911: iconst_m1
    //   1912: invokevirtual 3009	com/tencent/av/ui/VideoLayerUI:a	(Ljava/lang/String;ILjava/lang/String;FI)V
    //   1915: aload_0
    //   1916: getfield 595	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   1919: aload 26
    //   1921: iload 6
    //   1923: invokevirtual 3010	com/tencent/av/ui/VideoLayerUI:a	(Ljava/lang/String;I)V
    //   1926: iload_3
    //   1927: iconst_1
    //   1928: iadd
    //   1929: istore_3
    //   1930: goto -416 -> 1514
    //   1933: iconst_0
    //   1934: istore 16
    //   1936: goto -358 -> 1578
    //   1939: aload_0
    //   1940: getfield 141	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvAppVideoAppInterface	Lcom/tencent/av/app/VideoAppInterface;
    //   1943: sipush 1036
    //   1946: aload 20
    //   1948: invokestatic 3013	mbf:a	(Lcom/tencent/av/app/VideoAppInterface;ILjava/lang/String;)Z
    //   1951: pop
    //   1952: goto -213 -> 1739
    //   1955: aload_0
    //   1956: ldc_w 3014
    //   1959: invokevirtual 2983	com/tencent/av/ui/AVActivity:getString	(I)Ljava/lang/String;
    //   1962: iconst_1
    //   1963: anewarray 1406	java/lang/Object
    //   1966: dup
    //   1967: iconst_0
    //   1968: aload 20
    //   1970: aastore
    //   1971: invokestatic 2987	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1974: astore 20
    //   1976: aload_0
    //   1977: getfield 565	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoControlUI	Lcom/tencent/av/ui/VideoControlUI;
    //   1980: ifnull +28 -> 2008
    //   1983: aload_0
    //   1984: getfield 565	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoControlUI	Lcom/tencent/av/ui/VideoControlUI;
    //   1987: instanceof 2989
    //   1990: ifeq +18 -> 2008
    //   1993: aload_0
    //   1994: getfield 565	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoControlUI	Lcom/tencent/av/ui/VideoControlUI;
    //   1997: sipush 1037
    //   2000: aload 20
    //   2002: invokevirtual 2992	com/tencent/av/ui/VideoControlUI:a	(ILjava/lang/String;)V
    //   2005: goto -266 -> 1739
    //   2008: aload_0
    //   2009: getfield 141	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvAppVideoAppInterface	Lcom/tencent/av/app/VideoAppInterface;
    //   2012: sipush 1037
    //   2015: aload 20
    //   2017: invokestatic 3013	mbf:a	(Lcom/tencent/av/app/VideoAppInterface;ILjava/lang/String;)Z
    //   2020: pop
    //   2021: goto -282 -> 1739
    //   2024: aload 22
    //   2026: getfield 1386	lfe:D	I
    //   2029: bipush 10
    //   2031: if_icmpne +39 -> 2070
    //   2034: aconst_null
    //   2035: ldc_w 1285
    //   2038: ldc_w 440
    //   2041: ldc_w 440
    //   2044: ldc_w 3016
    //   2047: ldc_w 3016
    //   2050: iconst_0
    //   2051: iconst_0
    //   2052: ldc_w 440
    //   2055: ldc_w 440
    //   2058: ldc_w 440
    //   2061: ldc_w 440
    //   2064: invokestatic 1293	bdla:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2067: goto -253 -> 1814
    //   2070: aconst_null
    //   2071: ldc_w 1285
    //   2074: ldc_w 440
    //   2077: ldc_w 440
    //   2080: ldc_w 3018
    //   2083: ldc_w 3018
    //   2086: iconst_0
    //   2087: iconst_0
    //   2088: ldc_w 440
    //   2091: ldc_w 440
    //   2094: ldc_w 440
    //   2097: ldc_w 440
    //   2100: invokestatic 1293	bdla:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2103: goto -289 -> 1814
    //   2106: aload_0
    //   2107: getfield 595	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   2110: lload 10
    //   2112: aload 26
    //   2114: iload 6
    //   2116: aload_0
    //   2117: getfield 149	com/tencent/av/ui/AVActivity:jdField_b_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   2120: aload 25
    //   2122: getfield 2973	lob:jdField_b_of_type_Boolean	Z
    //   2125: aload 25
    //   2127: getfield 2968	lob:jdField_a_of_type_Boolean	Z
    //   2130: invokevirtual 2999	com/tencent/av/ui/VideoLayerUI:a	(JLjava/lang/String;ILandroid/graphics/Bitmap;ZZ)V
    //   2133: goto -292 -> 1841
    //   2136: aload_0
    //   2137: getfield 595	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   2140: lload 10
    //   2142: aload 26
    //   2144: iload 6
    //   2146: aload_0
    //   2147: getfield 149	com/tencent/av/ui/AVActivity:jdField_b_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   2150: aload 25
    //   2152: getfield 2973	lob:jdField_b_of_type_Boolean	Z
    //   2155: aload 25
    //   2157: getfield 2968	lob:jdField_a_of_type_Boolean	Z
    //   2160: invokevirtual 2999	com/tencent/av/ui/VideoLayerUI:a	(JLjava/lang/String;ILandroid/graphics/Bitmap;ZZ)V
    //   2163: goto -322 -> 1841
    //   2166: aload_0
    //   2167: getfield 141	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvAppVideoAppInterface	Lcom/tencent/av/app/VideoAppInterface;
    //   2170: sipush 1023
    //   2173: ldc_w 3019
    //   2176: invokestatic 640	mbf:a	(Lcom/tencent/av/app/VideoAppInterface;II)Z
    //   2179: pop
    //   2180: ldc_w 3021
    //   2183: invokestatic 1006	mor:a	(Ljava/lang/String;)V
    //   2186: goto -1320 -> 866
    //   2189: invokestatic 1362	ltm:a	()Lltm;
    //   2192: iconst_1
    //   2193: invokevirtual 2905	ltm:b	(I)V
    //   2196: goto -1245 -> 951
    //   2199: ldc2_w 2493
    //   2202: lstore 8
    //   2204: goto -1223 -> 981
    //   2207: astore 20
    //   2209: goto -1297 -> 912
    //   2212: aload 21
    //   2214: astore 20
    //   2216: goto -533 -> 1683
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2219	0	this	AVActivity
    //   1859	52	1	f1	float
    //   1857	18	2	f2	float
    //   1513	417	3	i1	int
    //   261	1000	4	i2	int
    //   1510	260	5	i3	int
    //   1549	596	6	i4	int
    //   1585	7	7	i5	int
    //   979	1224	8	l1	long
    //   8	2133	10	l2	long
    //   954	34	12	l3	long
    //   962	28	14	l4	long
    //   400	1535	16	bool1	boolean
    //   413	1219	17	bool2	boolean
    //   420	70	18	bool3	boolean
    //   427	950	19	bool4	boolean
    //   310	785	20	localObject1	Object
    //   1273	135	20	localIllegalArgumentException	java.lang.IllegalArgumentException
    //   1681	335	20	str1	String
    //   2207	1	20	localException	Exception
    //   2214	1	20	localObject2	Object
    //   437	1776	21	str2	String
    //   85	1940	22	locallfe	lfe
    //   165	817	23	locallik	lik
    //   1488	36	24	localArrayList	ArrayList
    //   1532	624	25	locallob	lob
    //   1542	601	26	str3	String
    // Exception table:
    //   from	to	target	type
    //   70	79	1273	java/lang/IllegalArgumentException
    //   905	912	2207	java/lang/Exception
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    this.jdField_k_of_type_Boolean = true;
  }
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (paramSensorEvent != null)) {
      this.jdField_a_of_type_ComTencentAvVideoController.jdField_a_of_type_Lcf.a(paramSensorEvent.values);
    }
  }
  
  public void onStart()
  {
    lfe locallfe = lbz.a().a();
    lii.a(20, 1L);
    if ((locallfe != null) && (locallfe.l())) {
      lii.a(31);
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
    if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_B_of_type_Boolean) && (this.jdField_a_of_type_Mji != null))
    {
      this.jdField_a_of_type_Mji.c();
      if (this.jdField_a_of_type_Mji.b() < 1000L) {
        break label278;
      }
    }
    label278:
    for (int i1 = 1;; i1 = 2)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a().v = i1;
      bdla.b(null, "CliOper", "", "", "0X800863D", "0X800863D", 0, 0, "", "", "", "");
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
    if (lvy.a().jdField_a_of_type_Boolean)
    {
      lvy.a().jdField_i_of_type_Long = SystemClock.elapsedRealtime();
      return;
    }
    lvy.a().x = SystemClock.elapsedRealtime();
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