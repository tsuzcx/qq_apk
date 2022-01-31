package com.tencent.av.ui;

import android.annotation.TargetApi;
import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.av.SessionMgr;
import com.tencent.av.VideoConstants.ProcessInfo;
import com.tencent.av.VideoController;
import com.tencent.av.app.GAudioUIObserver;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.SessionInfo.Anychat_Info;
import com.tencent.av.app.SessionInfo.GuildInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.app.VideoObserver;
import com.tencent.av.business.manager.report.VideoNodeManager;
import com.tencent.av.business.manager.report.VideoNodeReporter;
import com.tencent.av.report.VideoConnRateReport;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.av.utils.BitmapTools;
import com.tencent.av.utils.CharacterUtil;
import com.tencent.av.utils.PhoneStatusTools;
import com.tencent.av.utils.QAVNotification;
import com.tencent.av.utils.TipsManager;
import com.tencent.av.utils.TraeHelper;
import com.tencent.av.utils.UITools;
import com.tencent.av.utils.VExtensionInfoManager;
import com.tencent.av.utils.VideoWifiLock;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQLSUnlockActivity;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.QQUtils;
import com.tencent.mobileqq.vas.ColorRingManager;
import com.tencent.mobileqq.vipav.VipFullScreenVideoView;
import com.tencent.mobileqq.vipav.VipFunCallManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.File;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kcz;
import kda;
import kdc;
import kdd;
import kde;
import kdf;
import kdi;
import kdk;
import kdl;
import kdm;
import mqq.app.BaseActivity;

public class VideoInviteActivity
  extends BaseActivity
{
  public static int a;
  public static int b;
  long jdField_a_of_type_Long = -1L;
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = null;
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap = null;
  AudioManager jdField_a_of_type_AndroidMediaAudioManager = null;
  public ImageButton a;
  public ImageView a;
  public RelativeLayout a;
  public TextView a;
  public VideoController a;
  GAudioUIObserver jdField_a_of_type_ComTencentAvAppGAudioUIObserver = new kdi(this);
  public SessionInfo a;
  public VideoAppInterface a;
  VideoObserver jdField_a_of_type_ComTencentAvAppVideoObserver = new kdf(this);
  public QavInOutAnimation a;
  public QavPanel a;
  QAVNotification jdField_a_of_type_ComTencentAvUtilsQAVNotification = null;
  TipsManager jdField_a_of_type_ComTencentAvUtilsTipsManager = null;
  VExtensionInfoManager jdField_a_of_type_ComTencentAvUtilsVExtensionInfoManager = null;
  VideoWifiLock jdField_a_of_type_ComTencentAvUtilsVideoWifiLock;
  public VipFullScreenVideoView a;
  Runnable jdField_a_of_type_JavaLangRunnable = new kde(this);
  String jdField_a_of_type_JavaLangString = null;
  public WeakReference a;
  public boolean a;
  byte[] jdField_a_of_type_ArrayOfByte = null;
  public ImageButton b;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  String jdField_b_of_type_JavaLangString = null;
  public boolean b;
  public int c;
  public String c;
  public boolean c;
  public int d;
  public String d;
  public boolean d;
  int e;
  public String e;
  public boolean e;
  int jdField_f_of_type_Int = 0;
  String jdField_f_of_type_JavaLangString;
  boolean jdField_f_of_type_Boolean = true;
  int g;
  public boolean g;
  public int h;
  public boolean h;
  public int i;
  public boolean i;
  final int j = 0;
  final int k = 1;
  
  static
  {
    jdField_a_of_type_Int = 60000;
    jdField_b_of_type_Int = 1;
  }
  
  public VideoInviteActivity()
  {
    this.jdField_a_of_type_ComTencentAvAppSessionInfo = null;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_c_of_type_Int = 0;
    this.jdField_d_of_type_Int = 0;
    this.jdField_e_of_type_Int = 0;
    this.jdField_g_of_type_Int = 0;
    this.jdField_c_of_type_JavaLangString = null;
    this.jdField_d_of_type_JavaLangString = null;
    this.jdField_e_of_type_JavaLangString = null;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidWidgetImageView = null;
    this.jdField_a_of_type_AndroidWidgetTextView = null;
    this.jdField_g_of_type_Boolean = false;
    this.jdField_h_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentAvVideoController = null;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = null;
    this.jdField_h_of_type_Int = 0;
    this.jdField_i_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(this);
    this.jdField_a_of_type_ComTencentAvUiQavPanel = null;
    this.jdField_a_of_type_ComTencentAvUiQavInOutAnimation = null;
    this.jdField_i_of_type_Boolean = false;
  }
  
  private void c(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoInviteActivity", 2, "sendIsResumeBroadcast isResume = " + paramBoolean);
    }
    SmallScreenUtils.a(BaseApplicationImpl.getContext(), paramBoolean);
  }
  
  ActionSheet a(Context paramContext)
  {
    paramContext = new kdl(this, paramContext);
    paramContext.getWindow().setWindowAnimations(2131624571);
    return paramContext;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentAvAppSessionInfo == null) {}
    label7:
    int n;
    int m;
    label180:
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
        } while (!this.jdField_b_of_type_Boolean);
        n = VipFunCallManager.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getAccount(), 6, false, this.jdField_c_of_type_JavaLangString);
      } while (n == 0);
      m = NetworkUtil.a(BaseApplicationImpl.getContext());
      if ((m == 4) || (m == 1)) {}
      for (m = 1;; m = 0)
      {
        int i1 = VipFunCallManager.a();
        localObject = VipFunCallManager.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, n, VipFunCallManager.a(), null);
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break;
        }
        if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
          this.jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView = VipFunCallManager.a(this, this.jdField_a_of_type_AndroidWidgetRelativeLayout, true);
        }
        File localFile = new File((String)localObject);
        if ((localFile == null) || (!localFile.exists())) {
          break label180;
        }
        if ((this.jdField_a_of_type_AndroidWidgetRelativeLayout == null) || (!VipFunCallManager.a(this, this.jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView, (String)localObject, i1, null, n, false))) {
          break;
        }
        b(true);
        if (!ImmersiveUtils.a()) {
          break;
        }
        ImmersiveUtils.a(super.getWindow(), false);
        return;
      }
    } while (m == 0);
    Object localObject = new Intent();
    ((Intent)localObject).setAction("tencent.video.v2q.AnnimateDownloadStart");
    ((Intent)localObject).setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getPackageName());
    ((Intent)localObject).putExtra("callId", n);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast((Intent)localObject);
  }
  
  public void a(int paramInt) {}
  
  void a(Context paramContext, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_p_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(40), this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_c_of_type_JavaLangString, Boolean.valueOf(true) });
    }
    if (paramBoolean) {}
    for (paramContext = a(paramContext);; paramContext = ActionSheet.a(paramContext))
    {
      paramContext.b(2131429149);
      paramContext.b(2131429150);
      paramContext.b(2131429151);
      if (d()) {
        paramContext.b(2131429152);
      }
      paramContext.c(2131433029);
      paramContext.a(new kcz(this, paramBoolean));
      paramContext.a(new kda(this, paramContext, paramBoolean));
      paramContext.show();
      return;
    }
  }
  
  public void a(String paramString)
  {
    if (PhoneStatusTools.b(this)) {
      if ((!this.jdField_c_of_type_Boolean) && (this.jdField_f_of_type_Boolean))
      {
        TraeHelper.a().a(paramString + "_VideoInviteActivity.playRing");
        if ((this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) || (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp() == null))
        {
          this.jdField_a_of_type_Long = 0L;
          if (this.jdField_a_of_type_Long != 0L) {
            break label151;
          }
          TraeHelper.a().a(paramString + "_VideoInviteActivity.playRing.1", this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 2131230742, -1, null);
        }
      }
      else
      {
        TraeHelper.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, false);
      }
    }
    label151:
    while (!PhoneStatusTools.a(this)) {
      for (;;)
      {
        return;
        this.jdField_a_of_type_Long = VipFunCallManager.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getAccount(), 3, false, this.jdField_c_of_type_JavaLangString);
        continue;
        String str = ColorRingManager.a(this.jdField_a_of_type_Long, 3);
        if (new File(str).exists())
        {
          TraeHelper.a().b(paramString + "_VideoInviteActivity.playRing.2", this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 0, str, -1, null);
          ReportController.b(null, "CliOper", "", "", "0X8005004", "0X8005004", 0, 0, "", this.jdField_a_of_type_Long + "", "", "");
        }
        else
        {
          TraeHelper.a().a(paramString + "_VideoInviteActivity.playRing.3", this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 2131230742, -1, null);
          if ((this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp() != null))
          {
            paramString = new Intent();
            paramString.setAction("tencent.video.v2q.commingRingDownload");
            paramString.setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getPackageName());
            paramString.putExtra("comming_ring_down_key", this.jdField_a_of_type_Long);
            this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast(paramString);
          }
        }
      }
    }
    TraeHelper.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, false);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = false;
    TraeHelper.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    if ((this.jdField_a_of_type_ComTencentAvUiQavInOutAnimation != null) && (!this.jdField_i_of_type_Boolean)) {
      this.jdField_a_of_type_ComTencentAvUiQavInOutAnimation.a(new kdc(this, paramBoolean));
    }
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_ComTencentAvVideoController == null);
      if (this.jdField_h_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_c_of_type_JavaLangString, 1, true);
        long l = CharacterUtil.a(this.jdField_c_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentAvVideoController.b(3, l);
        this.jdField_g_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentAvVideoController.a(l, 1);
        this.jdField_e_of_type_Boolean = true;
        super.finish();
        return;
      }
      this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_c_of_type_JavaLangString, 1, false);
      this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_c_of_type_JavaLangString, 0);
      this.jdField_a_of_type_ComTencentAvVideoController.b(249);
    } while (!paramBoolean);
    this.jdField_a_of_type_ComTencentAvVideoController.c(this.jdField_c_of_type_JavaLangString, 1);
  }
  
  boolean a()
  {
    boolean bool2 = false;
    Object localObject = super.getIntent();
    if ((localObject != null) && (!a((Intent)localObject)))
    {
      this.jdField_c_of_type_JavaLangString = ((Intent)localObject).getStringExtra("peerUin");
      if (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
        if (QLog.isColorLevel()) {
          QLog.e("VideoInviteActivity", 2, "initVideoParam uin is empty!");
        }
      }
    }
    do
    {
      do
      {
        return false;
        this.jdField_d_of_type_Int = ((Intent)localObject).getIntExtra("uinType", 0);
        this.jdField_e_of_type_JavaLangString = ((Intent)localObject).getStringExtra("extraUin");
        this.jdField_c_of_type_Int = ((Intent)localObject).getIntExtra("curUserStatus", 0);
        this.jdField_b_of_type_Boolean = ((Intent)localObject).getBooleanExtra("isAudioMode", false);
        this.jdField_c_of_type_Boolean = ((Intent)localObject).getBooleanExtra("powerKey", false);
        this.jdField_f_of_type_Boolean = ((Intent)localObject).getBooleanExtra("isPlayRing", true);
        this.jdField_h_of_type_Boolean = ((Intent)localObject).getBooleanExtra("isDoubleVideoMeeting", false);
        return true;
        localObject = SessionMgr.a().a();
      } while (localObject == null);
      this.jdField_d_of_type_Int = ((SessionInfo)localObject).jdField_i_of_type_Int;
      this.jdField_c_of_type_JavaLangString = ((SessionInfo)localObject).jdField_c_of_type_JavaLangString;
      if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("VideoInviteActivity", 2, "initVideoParam uin is empty!");
    return false;
    this.jdField_d_of_type_Int = ((SessionInfo)localObject).jdField_i_of_type_Int;
    this.jdField_e_of_type_JavaLangString = ((SessionInfo)localObject).jdField_e_of_type_JavaLangString;
    this.jdField_c_of_type_Int = this.jdField_a_of_type_ComTencentAvVideoController.a();
    this.jdField_b_of_type_Boolean = ((SessionInfo)localObject).Q;
    boolean bool1 = bool2;
    if (((SessionInfo)localObject).jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Int <= 0) {
      if (((SessionInfo)localObject).jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.jdField_a_of_type_Int != 0)
      {
        bool1 = bool2;
        if (((SessionInfo)localObject).jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.jdField_a_of_type_Long > 0L) {}
      }
      else
      {
        bool1 = true;
      }
    }
    this.jdField_f_of_type_Boolean = bool1;
    this.jdField_h_of_type_Boolean = ((SessionInfo)localObject).G;
    return true;
  }
  
  protected boolean a(Intent paramIntent)
  {
    boolean bool2 = false;
    paramIntent = paramIntent.getStringExtra("Fromwhere");
    boolean bool1 = bool2;
    if (paramIntent != null)
    {
      bool1 = bool2;
      if (paramIntent.compareTo("AVNotification") == 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  protected void b() {}
  
  public void b(boolean paramBoolean) {}
  
  boolean b()
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = ((VideoAppInterface)super.getAppRuntime());
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentAvVideoController = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
      if (this.jdField_a_of_type_ComTencentAvVideoController != null) {}
      for (boolean bool = true;; bool = false)
      {
        this.jdField_a_of_type_ComTencentAvUtilsVideoWifiLock = new VideoWifiLock(super.getApplicationContext(), 1, "video wifi lock");
        return bool;
      }
    }
    return false;
  }
  
  @TargetApi(16)
  public void c()
  {
    if (Build.VERSION.SDK_INT >= 16) {}
    try
    {
      KeyguardManager localKeyguardManager = (KeyguardManager)super.getSystemService("keyguard");
      if ((localKeyguardManager != null) && (localKeyguardManager.isKeyguardLocked()))
      {
        boolean bool = localKeyguardManager.isKeyguardSecure();
        if (bool) {
          return;
        }
      }
      super.startActivity(new Intent(super.getApplicationContext(), QQLSUnlockActivity.class));
      return;
    }
    catch (SecurityException localSecurityException) {}
  }
  
  protected boolean c()
  {
    if (this.jdField_a_of_type_ComTencentAvUtilsVideoWifiLock == null) {
      this.jdField_a_of_type_ComTencentAvUtilsVideoWifiLock = new VideoWifiLock(super.getApplicationContext(), 1, "video wifi lock");
    }
    if ((PhoneStatusTools.e(super.getApplicationContext())) && (this.jdField_a_of_type_ComTencentAvUtilsVideoWifiLock != null)) {
      this.jdField_a_of_type_ComTencentAvUtilsVideoWifiLock.a();
    }
    return true;
  }
  
  public void d()
  {
    sendBroadcast(new Intent("tencent.video.v2nearbyV.exit"));
    if (QLog.isColorLevel()) {
      QLog.d("nearby.video.multiMsg", 2, "exitNearbyVideo");
    }
  }
  
  boolean d()
  {
    return (!QQUtils.a(super.getApplicationContext())) || (Build.VERSION.SDK_INT >= 16);
  }
  
  public void e()
  {
    if (!c()) {
      return;
    }
    d();
    if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && ((this.jdField_a_of_type_ComTencentAvVideoController.jdField_e_of_type_Boolean) || (this.jdField_a_of_type_ComTencentAvVideoController.l()))) {
      i();
    }
    for (;;)
    {
      TraeHelper.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      TraeHelper.a().a("VideoInviteActivity.acceptVideoRequest");
      return;
      if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (SessionMgr.a().a() != null) && (SessionMgr.a().a().jdField_p_of_type_Boolean)) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(40), SessionMgr.a().a().jdField_c_of_type_JavaLangString, Boolean.valueOf(true) });
      }
      f();
    }
  }
  
  protected boolean e()
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
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoInviteActivity", 2, "startVideoChatActivity");
    }
    TraeHelper.a().a();
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (this.jdField_a_of_type_ComTencentAvVideoController.q)) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(113) });
    }
    Intent localIntent = new Intent(super.getApplicationContext(), AVActivity.class);
    localIntent.addFlags(262144);
    if (this.jdField_h_of_type_Boolean)
    {
      String str = this.jdField_c_of_type_JavaLangString;
      localIntent.putExtra("sessionType", 3);
      localIntent.putExtra("Type", 1);
      localIntent.putExtra("uin", str);
      localIntent.putExtra("uinType", 0);
      localIntent.putExtra("isDoubleVideoMeeting", true);
      localIntent.putExtra("inviteUin", str);
      localIntent.putExtra("sessionType", 1);
      localIntent.putExtra("isSender", false);
      localIntent.putExtra("isEnter", true);
      localIntent.putExtra("name", this.jdField_d_of_type_JavaLangString);
      super.startActivity(localIntent);
      this.jdField_e_of_type_Boolean = false;
      super.finish();
      super.overridePendingTransition(2131034270, 2131034269);
      return;
    }
    localIntent.putExtra("uinType", this.jdField_d_of_type_Int);
    localIntent.putExtra("bindType", this.jdField_e_of_type_Int);
    localIntent.putExtra("bindId", this.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("uin", this.jdField_c_of_type_JavaLangString);
    localIntent.putExtra("name", this.jdField_d_of_type_JavaLangString);
    localIntent.putExtra("extraUin", this.jdField_e_of_type_JavaLangString);
    localIntent.putExtra("receive", true);
    localIntent.putExtra("isAudioMode", this.jdField_b_of_type_Boolean);
    localIntent.putExtra("sig", this.jdField_a_of_type_ArrayOfByte);
    localIntent.putExtra("subServiceType", this.jdField_g_of_type_Int);
    if (QLog.isColorLevel()) {
      QLog.d("VideoInviteActivity", 2, "startVideoChatActivity: mBindType = " + this.jdField_e_of_type_Int + ",mBindId = " + this.jdField_a_of_type_JavaLangString + ",BindType = " + this.jdField_a_of_type_ComTencentAvAppSessionInfo.A);
    }
    if (this.jdField_d_of_type_Int == 0) {
      localIntent.putExtra("isFriend", this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_c_of_type_JavaLangString));
    }
    if (this.jdField_b_of_type_Boolean) {
      localIntent.putExtra("sessionType", 1);
    }
    for (;;)
    {
      localIntent.putExtra("shutCamera", this.jdField_a_of_type_Boolean);
      localIntent.putExtra("isSender", false);
      break;
      localIntent.putExtra("sessionType", 2);
    }
  }
  
  public void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoInviteActivity", 2, "onVideoRequestTimeout");
    }
    TraeHelper.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    TraeHelper.a().a("VideoInviteActivity.onVideoRequestTimeout");
    if (this.jdField_a_of_type_ComTencentAvUiQavInOutAnimation != null) {
      this.jdField_a_of_type_ComTencentAvUiQavInOutAnimation.a(new kdd(this));
    }
    do
    {
      return;
      this.jdField_d_of_type_Boolean = false;
    } while (this.jdField_a_of_type_ComTencentAvVideoController == null);
    if (this.jdField_h_of_type_Boolean)
    {
      long l = CharacterUtil.a(this.jdField_c_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentAvVideoController.b(3, l);
      if (!this.jdField_g_of_type_Boolean)
      {
        this.jdField_g_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentAvVideoController.a(l, 2);
      }
      this.jdField_e_of_type_Boolean = true;
      finish();
      return;
    }
    this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_c_of_type_JavaLangString, 0);
    this.jdField_a_of_type_ComTencentAvVideoController.b(247);
    this.jdField_a_of_type_ComTencentAvVideoController.c(this.jdField_c_of_type_JavaLangString, 0);
  }
  
  public void h()
  {
    Object localObject2 = this.jdField_c_of_type_JavaLangString;
    int n = this.jdField_d_of_type_Int;
    int m = n;
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_ComTencentAvAppSessionInfo != null)
    {
      m = n;
      localObject1 = localObject2;
      if (this.jdField_a_of_type_ComTencentAvAppSessionInfo.A == 1)
      {
        m = n;
        localObject1 = localObject2;
        if (this.jdField_d_of_type_Int == 9500)
        {
          m = n;
          localObject1 = localObject2;
          if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentAvAppSessionInfo.n))
          {
            localObject1 = this.jdField_a_of_type_ComTencentAvAppSessionInfo.n;
            m = 0;
          }
        }
      }
    }
    if (this.jdField_a_of_type_AndroidWidgetImageView != null)
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(m, (String)localObject1, this.jdField_e_of_type_JavaLangString, true, true);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
      localObject2 = UITools.a(super.getApplicationContext(), 2130840224);
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
      {
        if (localObject2 == null) {
          break label321;
        }
        long l = System.currentTimeMillis();
        localObject2 = new BitmapDrawable((Bitmap)localObject2);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable((Drawable)localObject2);
        if (QLog.isColorLevel()) {
          QLog.d("VideoInviteActivity", 2, "blur time = " + (System.currentTimeMillis() - l) + "ms");
        }
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_AndroidWidgetTextView != null)
      {
        this.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getDisplayName(m, (String)localObject1, this.jdField_e_of_type_JavaLangString);
        if ((this.jdField_d_of_type_Int == 25) && (this.jdField_d_of_type_JavaLangString.equals(this.jdField_c_of_type_JavaLangString)))
        {
          this.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_g_of_type_JavaLangString;
          if (QLog.isColorLevel()) {
            QLog.w("VideoInviteActivity", 2, "mPeerName = " + this.jdField_d_of_type_JavaLangString);
          }
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_d_of_type_JavaLangString);
      }
      return;
      label321:
      localObject2 = BitmapTools.a(super.getApplicationContext(), 2130840224);
      if (localObject2 != null) {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable((Drawable)localObject2);
      } else {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130840224);
      }
    }
  }
  
  void i()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoInviteActivity", 2, "showGAudioDialog");
    }
    kdk localkdk1 = new kdk(this, 0);
    kdk localkdk2 = new kdk(this, 1);
    DialogUtil.b(this, 230, null, super.getString(2131428983), 2131428675, 2131429053, localkdk1, localkdk2).show();
  }
  
  void j()
  {
    String str2 = "";
    int m;
    String str1;
    if (this.jdField_a_of_type_ComTencentAvVideoController != null)
    {
      m = this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_i_of_type_Int;
      str1 = this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_e_of_type_JavaLangString;
    }
    for (;;)
    {
      switch (m)
      {
      default: 
        this.jdField_i_of_type_Int = 99;
        str1 = str2;
      }
      for (;;)
      {
        this.jdField_f_of_type_JavaLangString = str1;
        return;
        if (this.jdField_h_of_type_Boolean)
        {
          this.jdField_i_of_type_Int = 7;
          str1 = super.getString(2131429223);
        }
        else
        {
          this.jdField_i_of_type_Int = 0;
          str1 = str2;
          continue;
          str1 = super.getString(2131429218) + this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getDisplayName(1, str1, null);
          this.jdField_i_of_type_Int = 1;
          continue;
          str1 = super.getString(2131429218) + this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getDisplayName(3000, str1, null);
          this.jdField_i_of_type_Int = 2;
          continue;
          str1 = super.getString(2131429219);
          this.jdField_i_of_type_Int = 3;
          continue;
          str1 = super.getString(2131429220);
          this.jdField_i_of_type_Int = 4;
          continue;
          str1 = super.getString(2131429221);
          this.jdField_i_of_type_Int = 5;
          continue;
          str1 = super.getString(2131429222);
          this.jdField_i_of_type_Int = 6;
          continue;
          str1 = super.getString(2131437443);
          this.jdField_i_of_type_Int = 7;
        }
      }
      str1 = null;
      m = 0;
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    QLog.d("VideoInviteActivity", 1, "avideo onCreate");
    VideoNodeManager.a(29);
    super.onCreate(paramBundle);
    super.overridePendingTransition(2131034270, 0);
    if ((Build.VERSION.SDK_INT >= 19) && (ImmersiveUtils.isSupporImmersive() == 1)) {
      super.getWindow().addFlags(67108864);
    }
    if (ImmersiveUtils.a()) {
      ImmersiveUtils.a(super.getWindow(), true);
    }
    int m;
    label272:
    label401:
    label466:
    PhoneContactManager localPhoneContactManager;
    for (;;)
    {
      try
      {
        super.getWindow().addFlags(WindowManager.LayoutParams.class.getField("FLAG_NEEDS_MENU_KEY").getInt(null));
        if ((!b()) || (!a()))
        {
          if (QLog.isColorLevel()) {
            QLog.w("VideoInviteActivity", 2, "init param failure.");
          }
          this.jdField_e_of_type_Boolean = true;
          super.finish();
          return;
        }
      }
      catch (NoSuchFieldException paramBundle)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("VideoInviteActivity", 2, "Not exist FLAG_NEEDS_MENU_KEY filed", paramBundle);
        continue;
      }
      catch (IllegalAccessException paramBundle)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("VideoInviteActivity", 2, "Could not access FLAG_NEEDS_MENU_KEY", paramBundle);
        continue;
        paramBundle = this.jdField_c_of_type_JavaLangString;
        if (!this.jdField_h_of_type_Boolean) {
          break;
        }
      }
      paramBundle = SessionMgr.a(100, paramBundle, new int[0]);
      this.jdField_a_of_type_AndroidMediaAudioManager = ((AudioManager)super.getSystemService("audio"));
      this.jdField_a_of_type_ComTencentAvAppSessionInfo = SessionMgr.a().a(paramBundle);
      if ((this.jdField_a_of_type_ComTencentAvVideoController == null) || (this.jdField_a_of_type_ComTencentAvAppSessionInfo == null) || (!this.jdField_a_of_type_ComTencentAvAppSessionInfo.d()))
      {
        if (QLog.isColorLevel())
        {
          paramBundle = new StringBuilder().append("session state error! ");
          if (this.jdField_a_of_type_ComTencentAvAppSessionInfo == null) {
            break label679;
          }
          m = this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_g_of_type_Int;
          QLog.w("VideoInviteActivity", 2, m);
        }
        if ((this.jdField_a_of_type_ComTencentAvAppSessionInfo == null) || (!this.jdField_a_of_type_ComTencentAvAppSessionInfo.c()) || (!this.jdField_c_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_c_of_type_JavaLangString))) {
          break label684;
        }
        if (QLog.isColorLevel()) {
          QLog.w("VideoInviteActivity", 2, "onCreate mPeerUin.equals(mSessionInfo.peerUin)");
        }
      }
      if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (this.jdField_a_of_type_ComTencentAvVideoController.jdField_e_of_type_Boolean != true))
      {
        TraeHelper.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getApplicationContext(), this.jdField_a_of_type_ComTencentAvVideoController);
        TraeHelper.a().a("VideoInviteActivity.onCreate");
        if (this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_f_of_type_Int != 1) {
          break label735;
        }
        TraeHelper.a().a("DEVICE_SPEAKERPHONE;DEVICE_EARPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;");
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_ComTencentAvAppVideoObserver);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_ComTencentAvAppGAudioUIObserver);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_JavaLangRunnable, jdField_a_of_type_Int);
      if (this.jdField_a_of_type_ComTencentAvVideoController.e() <= 0) {
        break label748;
      }
      this.jdField_a_of_type_ComTencentAvVideoController.b(203, this.jdField_c_of_type_JavaLangString);
      this.jdField_h_of_type_Int = PhoneStatusTools.a(this);
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppSessionInfo.n;
      this.jdField_e_of_type_Int = this.jdField_a_of_type_ComTencentAvAppSessionInfo.A;
      this.jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_ArrayOfByte;
      this.jdField_g_of_type_Int = this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_p_of_type_Int;
      paramBundle = new IntentFilter();
      paramBundle.addAction("tencent.video.q2v.ACTION_ON_UPDATE_FRIEND_INFO");
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = new kdm(this);
      super.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramBundle);
      j();
      if (this.jdField_d_of_type_Int == 25)
      {
        localPhoneContactManager = (PhoneContactManager)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getManager(10);
        if ((localPhoneContactManager == null) || (this.jdField_e_of_type_JavaLangString == null)) {
          break label833;
        }
      }
    }
    label679:
    label684:
    label833:
    for (paramBundle = localPhoneContactManager.c(this.jdField_e_of_type_JavaLangString);; paramBundle = null)
    {
      if (paramBundle != null)
      {
        paramBundle = localPhoneContactManager.a(this.jdField_e_of_type_JavaLangString);
        if ((paramBundle != null) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(paramBundle)))
        {
          ReportController.b(null, "CliOper", "", "", "0X800624D", "0X800624D", 1, 0, "", "", "", "");
          return;
          paramBundle = SessionMgr.a(3, paramBundle, new int[0]);
          break;
          m = -1;
          break label272;
          if (this.jdField_a_of_type_ComTencentAvVideoController != null)
          {
            this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_c_of_type_JavaLangString, 0);
            this.jdField_a_of_type_ComTencentAvVideoController.b(245);
            this.jdField_a_of_type_ComTencentAvVideoController.c(this.jdField_c_of_type_JavaLangString, 2);
          }
          this.jdField_e_of_type_Boolean = true;
          super.finish();
          return;
          label735:
          TraeHelper.a().a("DEVICE_EARPHONE;DEVICE_SPEAKERPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;");
          break label401;
          label748:
          this.jdField_a_of_type_ComTencentAvVideoController.b(202, this.jdField_c_of_type_JavaLangString);
          break label466;
        }
        ReportController.b(null, "CliOper", "", "", "0X800624D", "0X800624D", 0, 0, "", "", "", "");
        return;
      }
      ReportController.b(null, "CliOper", "", "", "0X800624D", "0X800624D", 2, 0, "", "", "", "");
      return;
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    QLog.d("VideoInviteActivity", 1, "onDestroy");
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    if (this.jdField_a_of_type_ComTencentAvUtilsVideoWifiLock != null)
    {
      this.jdField_a_of_type_ComTencentAvUtilsVideoWifiLock.a();
      this.jdField_a_of_type_ComTencentAvUtilsVideoWifiLock = null;
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_ComTencentAvAppVideoObserver);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_ComTencentAvAppGAudioUIObserver);
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null)
    {
      super.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
    }
    TraeHelper.a().a("VideoInviteActivity.onDestroy");
    TraeHelper.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
    if (this.jdField_e_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentAvVideoController = null;
    }
    this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    this.jdField_a_of_type_ComTencentAvUtilsVideoWifiLock = null;
    this.jdField_a_of_type_ComTencentAvUtilsQAVNotification = null;
    this.jdField_a_of_type_AndroidWidgetImageView = null;
    this.jdField_a_of_type_AndroidWidgetTextView = null;
    this.jdField_b_of_type_AndroidWidgetTextView = null;
    this.jdField_a_of_type_AndroidWidgetImageButton = null;
    this.jdField_b_of_type_AndroidWidgetImageButton = null;
    this.jdField_a_of_type_AndroidMediaAudioManager = null;
    this.jdField_a_of_type_ComTencentAvUtilsTipsManager = null;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = null;
    this.jdField_a_of_type_ComTencentAvAppVideoObserver = null;
    this.jdField_a_of_type_ComTencentAvAppGAudioUIObserver = null;
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (!this.jdField_d_of_type_Boolean)
    {
      if (paramInt == 4) {
        a(true);
      }
    }
    else {
      return true;
    }
    if ((paramInt == 25) || (paramInt == 24))
    {
      TraeHelper.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      TraeHelper.a().a("VideoInviteActivity.onKeyDown.1");
    }
    for (;;)
    {
      return super.onKeyDown(paramInt, paramKeyEvent);
      if (paramInt == 26) {
        TraeHelper.a().a("VideoInviteActivity.onKeyDown.2");
      }
    }
  }
  
  protected void onPause()
  {
    super.onPause();
    QLog.d("VideoInviteActivity", 1, "onPause");
    c(false);
    if (this.jdField_a_of_type_ComTencentAvVideoController != null)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a("state", "0");
      if ("0".equals(VideoConstants.ProcessInfo.jdField_a_of_type_JavaLangString)) {
        this.jdField_a_of_type_ComTencentAvVideoController.a("backgroundReason", "5");
      }
    }
  }
  
  protected void onResume()
  {
    super.onResume();
    QLog.d("VideoInviteActivity", 1, "onResume");
    this.jdField_c_of_type_Boolean = false;
    c(true);
    SessionInfo localSessionInfo = SessionMgr.a().a();
    VideoNodeReporter localVideoNodeReporter = (VideoNodeReporter)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4);
    if ((localVideoNodeReporter != null) && (localSessionInfo != null))
    {
      long l1 = System.currentTimeMillis();
      long l2 = VideoConnRateReport.a().b;
      localVideoNodeReporter.a(localSessionInfo.j, 24, l1 - l2);
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController != null)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a("state", "1");
      VideoConstants.ProcessInfo.jdField_a_of_type_JavaLangString = "0";
    }
  }
  
  protected void onStart()
  {
    super.onStart();
    QLog.d("VideoInviteActivity", 1, "onStart");
    if (this.jdField_a_of_type_ComTencentAvUtilsQAVNotification != null) {
      this.jdField_a_of_type_ComTencentAvUtilsQAVNotification.a(this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_b_of_type_JavaLangString);
    }
  }
  
  protected void onStop()
  {
    super.onStop();
    QLog.d("VideoInviteActivity", 1, "onStop");
    if ((PhoneStatusTools.b(this)) && (!this.jdField_d_of_type_Boolean)) {
      TraeHelper.a().a("VideoInviteActivity.onStop");
    }
    if (this.jdField_a_of_type_ComTencentAvAppSessionInfo == null) {
      if (QLog.isColorLevel()) {
        QLog.w("VideoInviteActivity", 2, "onStop mSessionInfo is null ");
      }
    }
    while ((this.jdField_e_of_type_Boolean) || (!this.jdField_a_of_type_ComTencentAvAppSessionInfo.d())) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentAvUtilsQAVNotification == null) {
      this.jdField_a_of_type_ComTencentAvUtilsQAVNotification = QAVNotification.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    }
    Bitmap localBitmap = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_d_of_type_Int, this.jdField_c_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, true, true);
    this.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getDisplayName(this.jdField_d_of_type_Int, this.jdField_c_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString);
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentAvUtilsQAVNotification.a(this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_b_of_type_JavaLangString, this.jdField_d_of_type_JavaLangString, localBitmap, null, 45, this.jdField_d_of_type_Int, 1);
      return;
    }
    this.jdField_a_of_type_ComTencentAvUtilsQAVNotification.a(this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_b_of_type_JavaLangString, this.jdField_d_of_type_JavaLangString, localBitmap, null, 40, this.jdField_d_of_type_Int, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.av.ui.VideoInviteActivity
 * JD-Core Version:    0.7.0.1
 */