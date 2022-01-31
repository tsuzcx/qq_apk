package com.tencent.mobileqq.activity.recent;

import android.animation.ValueAnimator;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.av.camera.QavCameraUsage;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qrcode.activity.ScannerActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.PlusPanelUtils;
import com.tencent.mobileqq.activity.contact.addcontact.AddContactsActivity;
import com.tencent.mobileqq.activity.qwallet.QWalletSetting;
import com.tencent.mobileqq.activity.qwallet.QrcodeHbGuiderActivity;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.activity.richmedia.MX3FlowNewCameraActivity;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;
import com.tencent.mobileqq.activity.richmedia.NewPreFlowCamera;
import com.tencent.mobileqq.apollo.ApolloManager;
import com.tencent.mobileqq.apollo.plusPanel.MoreAppItemHandler;
import com.tencent.mobileqq.apollo.plusPanel.view.PlusRecyclerViewAdapter;
import com.tencent.mobileqq.apollo.process.CmGameUtil;
import com.tencent.mobileqq.apollo.utils.ApolloDaoManager;
import com.tencent.mobileqq.apollo.utils.ApolloSoLoader;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.AccountDpcManager.DpcAccountNames;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ar.ARNativeBridge;
import com.tencent.mobileqq.ar.ArNativeSoLoader;
import com.tencent.mobileqq.ar.config.WorldCup;
import com.tencent.mobileqq.armap.ARMapActivity;
import com.tencent.mobileqq.armap.RedPacketRainConfigManager;
import com.tencent.mobileqq.armap.test.ARMainActivity;
import com.tencent.mobileqq.earlydownload.EarlyDownloadManager;
import com.tencent.mobileqq.earlydownload.handler.ArNativeSoDownloadHandler;
import com.tencent.mobileqq.hitrate.PreloadProcHitSession;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.richmedia.capture.activity.CameraCaptureActivity;
import com.tencent.mobileqq.richmedia.capture.activity.CaptureSoDownloadActivity;
import com.tencent.mobileqq.richmedia.capture.fragment.AIOEffectsCameraCaptureFragment;
import com.tencent.mobileqq.richmedia.capture.fragment.QuickShootEffectsCameraCaptureFragment;
import com.tencent.mobileqq.richmedia.capture.util.CaptureReportUtil;
import com.tencent.mobileqq.richmedia.capture.util.CaptureUtil;
import com.tencent.mobileqq.shortvideo.ShortVideoErrorReport;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.dancegame.DanceGameVideoManager;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraCompatibleList;
import com.tencent.mobileqq.shortvideo.redbag.RedBagVideoManager;
import com.tencent.mobileqq.shortvideo.util.PtvFilterSoLoad;
import com.tencent.mobileqq.shortvideo.util.RecentDanceConfigMgr;
import com.tencent.mobileqq.shortvideo.util.RecentDanceConfigMgr.DItemInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.troop.createNewTroop.NewTroopCreateActivity;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.mobileqq.webprocess.WebProcessReceiver;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.PopupMenuDialog;
import com.tencent.widget.PopupMenuDialog.MenuItem;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.peak.PeakUtils;
import cooperation.qlink.QQProxyForQlink;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;
import xqp;
import xqq;
import xqr;
import xqs;
import xqt;
import xqy;
import xqz;
import xra;
import xrb;
import xrc;
import xrd;
import xre;
import xrf;
import xrg;
import xrh;
import xri;

public class RecentOptPopBar
  implements View.OnClickListener
{
  public static final int[] a;
  private static final int[] jdField_b_of_type_ArrayOfInt = { 2131438761, 2130842332 };
  private static final int[] jdField_c_of_type_ArrayOfInt = { 2131436251, 2130838697 };
  private static final int[] jdField_d_of_type_ArrayOfInt = { 2131436255, 2130838687 };
  private static final int[] jdField_e_of_type_ArrayOfInt = { 2131436256, 2130838701 };
  private static final int[] jdField_f_of_type_ArrayOfInt = { 2131436252, 2130838700 };
  private static final int[] g = { 2131436246, 2130838706 };
  private static final int[] h = { 2131436260, 2130838702 };
  private static final int[] i = { 2131436262, 2130838705 };
  private static final int[] j = { 2131436261, 2130838700 };
  private static final int[] k = { 2131438763, 2130842302 };
  private static final int[] l = { 2131439219, 2130842302 };
  private Rect jdField_a_of_type_AndroidGraphicsRect;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private MoreAppItemHandler jdField_a_of_type_ComTencentMobileqqApolloPlusPanelMoreAppItemHandler = new MoreAppItemHandler();
  private PlusRecyclerViewAdapter jdField_a_of_type_ComTencentMobileqqApolloPlusPanelViewPlusRecyclerViewAdapter;
  public BaseActivity a;
  private RedTouch jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private PopupMenuDialog jdField_a_of_type_ComTencentWidgetPopupMenuDialog;
  public boolean a;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private RedTouch jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch;
  private boolean jdField_b_of_type_Boolean;
  private RedTouch jdField_c_of_type_ComTencentMobileqqRedtouchRedTouch;
  private boolean jdField_c_of_type_Boolean;
  private boolean jdField_d_of_type_Boolean;
  private boolean jdField_e_of_type_Boolean;
  private boolean jdField_f_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { 2131436248, 2130838707 };
  }
  
  public RecentOptPopBar(BaseActivity paramBaseActivity)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
  }
  
  public static Intent a(BaseActivity paramBaseActivity, long paramLong1, long paramLong2, int paramInt)
  {
    Intent localIntent = new Intent(paramBaseActivity, ScannerActivity.class);
    localIntent.putExtra("from", "Conversation");
    localIntent.putExtra("from_+", true);
    localIntent.putExtra("leftViewText", paramBaseActivity.getString(2131433712));
    localIntent.putExtra("selfSet_leftViewText", paramBaseActivity.getString(2131433712));
    localIntent.putExtra("start_time", System.currentTimeMillis());
    paramBaseActivity = new Bundle();
    paramBaseActivity.putLong("ar_promotion_type", paramLong1);
    paramBaseActivity.putLong("ar_recoglize_mask", paramLong2);
    paramBaseActivity.putString("H5Source", String.valueOf(paramInt));
    paramBaseActivity.putBoolean("ar_show_promotion_entry", true);
    localIntent.putExtra("ARRelationShipPromotion", paramBaseActivity);
    localIntent.setFlags(67108864);
    return localIntent;
  }
  
  public static void a(Intent paramIntent, FrameHelperActivity paramFrameHelperActivity)
  {
    if ((paramIntent != null) && (paramFrameHelperActivity != null) && ((paramFrameHelperActivity.getActivity() instanceof SplashActivity)))
    {
      paramFrameHelperActivity = (SplashActivity)paramFrameHelperActivity.getActivity();
      if (!paramIntent.getBooleanExtra("open_leba_tab_fragment", false)) {
        break label42;
      }
      paramFrameHelperActivity.b(paramIntent);
    }
    label42:
    while (!paramIntent.getBooleanExtra("open_chatfragment", false)) {
      return;
    }
    RecentUtil.a(paramFrameHelperActivity, paramIntent);
  }
  
  public static void a(BaseActivity paramBaseActivity, long paramLong1, long paramLong2, int paramInt)
  {
    if (!a(paramBaseActivity)) {
      return;
    }
    paramBaseActivity.startActivity(a(paramBaseActivity, paramLong1, paramLong2, paramInt));
  }
  
  public static boolean a(BaseActivity paramBaseActivity)
  {
    if (QavCameraUsage.b(BaseApplicationImpl.getContext())) {
      return false;
    }
    if (paramBaseActivity.isInMultiWindow())
    {
      QQToast.a(paramBaseActivity, "该功能无法在分屏模式下使用。", 0).a();
      return false;
    }
    return true;
  }
  
  private void v()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecentOptPopBar", 2, "showProgress");
    }
    if (this.jdField_f_of_type_Boolean) {}
    do
    {
      return;
      try
      {
        if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a("正在加载资源...");
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(false);
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
        this.jdField_f_of_type_Boolean = true;
        return;
      }
      catch (Exception localException) {}
    } while (!QLog.isColorLevel());
    QLog.i("RecentOptPopBar", 2, localException.toString());
  }
  
  private void w()
  {
    Object localObject = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, ARMapActivity.class);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity((Intent)localObject);
    localObject = RedPacketRainConfigManager.a();
    ((RedPacketRainConfigManager)localObject).jdField_a_of_type_Boolean = false;
    ((RedPacketRainConfigManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app);
  }
  
  private void x()
  {
    if (!VideoEnvironment.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app)) {
      DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 230).setMessage("系统版本过低，不支持短视频功能").setPositiveButton(2131433030, new xra(this)).show();
    }
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.c())
      {
        QQToast.a(BaseApplicationImpl.getContext(), 2131428992, 1).b(BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131558448));
        return;
      }
    } while (!VideoEnvironment.d(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app));
    t();
  }
  
  public int a()
  {
    Object localObject = (ApolloManager)CmGameUtil.a().getManager(152);
    if (localObject == null) {}
    do
    {
      do
      {
        return 0;
        m = ((ApolloManager)localObject).b();
        if ((m != 1) && (m != 2)) {
          break;
        }
      } while (CmGameUtil.a() == null);
      localObject = ((ApolloDaoManager)CmGameUtil.a().getManager(154)).i();
    } while (localObject == null);
    if (((List)localObject).size() >= 3) {}
    for (int m = 3;; m = ((List)localObject).size()) {
      return 0 + ((int)(m * DeviceInfoUtil.a * 44.0F) + (int)(DeviceInfoUtil.a * 21.0F));
    }
    if (m == 3) {}
    for (m = (int)(127.0F * DeviceInfoUtil.a);; m = 0) {
      return m;
    }
  }
  
  public View a()
  {
    if (CmGameUtil.a() == null) {
      return null;
    }
    ApolloManager localApolloManager = (ApolloManager)CmGameUtil.a().getManager(152);
    if (localApolloManager == null) {
      return null;
    }
    if (!localApolloManager.g()) {
      return null;
    }
    int m = localApolloManager.b();
    if ((m == 1) || (m == 2)) {
      return b();
    }
    if (m == 3) {
      return c();
    }
    return null;
  }
  
  public PopupMenuDialog.MenuItem a(int[] paramArrayOfInt)
  {
    PopupMenuDialog.MenuItem localMenuItem = new PopupMenuDialog.MenuItem();
    localMenuItem.jdField_a_of_type_Int = paramArrayOfInt[0];
    localMenuItem.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(paramArrayOfInt[0]);
    localMenuItem.c = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(paramArrayOfInt[0]);
    localMenuItem.b = paramArrayOfInt[1];
    return localMenuItem;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloPlusPanelViewPlusRecyclerViewAdapter == null) || (CmGameUtil.a() == null)) {}
    List localList;
    do
    {
      return;
      localList = PopupMenuDialog.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 3);
      if (localList != null) {
        break;
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqApolloPlusPanelViewPlusRecyclerViewAdapter.getItemCount() <= 0);
    this.jdField_a_of_type_Boolean = true;
    return;
    if (this.jdField_a_of_type_ComTencentMobileqqApolloPlusPanelViewPlusRecyclerViewAdapter.getItemCount() != localList.size()) {
      this.jdField_a_of_type_Boolean = true;
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloPlusPanelViewPlusRecyclerViewAdapter.a(localList);
    this.jdField_a_of_type_ComTencentMobileqqApolloPlusPanelViewPlusRecyclerViewAdapter.notifyDataSetChanged();
  }
  
  public void a(int paramInt)
  {
    long l1 = VACDReportUtil.a(null, "qqwallet", "payCode", "click", "2", 0, null);
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, JumpActivity.class);
    localIntent.setData(Uri.parse("mqqapi://wallet/open?src_type=web&viewtype=0&version=1&view=" + paramInt + "&entry=2&seq=" + l1));
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivityForResult(localIntent, -1);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "CliOper", "", "", "0X8005ED3", "0X8005ED3", 0, 0, "", "", "", "");
  }
  
  /* Error */
  protected void a(Intent paramIntent)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 11
    //   3: invokestatic 505	com/tencent/mobileqq/app/DeviceProfileManager:a	()Lcom/tencent/mobileqq/app/DeviceProfileManager;
    //   6: getstatic 511	com/tencent/mobileqq/app/DeviceProfileManager$DpcNames:PreUploadVideoConfig	Lcom/tencent/mobileqq/app/DeviceProfileManager$DpcNames;
    //   9: invokevirtual 514	com/tencent/mobileqq/app/DeviceProfileManager$DpcNames:name	()Ljava/lang/String;
    //   12: ldc_w 516
    //   15: invokevirtual 519	com/tencent/mobileqq/app/DeviceProfileManager:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   18: astore 19
    //   20: iconst_0
    //   21: invokestatic 154	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   24: ldc_w 521
    //   27: new 457	java/lang/StringBuilder
    //   30: dup
    //   31: invokespecial 458	java/lang/StringBuilder:<init>	()V
    //   34: ldc_w 523
    //   37: invokevirtual 464	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: aload 19
    //   42: invokevirtual 464	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: invokevirtual 473	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   48: invokestatic 528	com/tencent/mobileqq/utils/LogTag:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   51: fconst_0
    //   52: fstore_2
    //   53: fconst_0
    //   54: fstore 4
    //   56: fconst_0
    //   57: fstore_3
    //   58: lconst_0
    //   59: lstore 17
    //   61: aload 19
    //   63: ifnull +550 -> 613
    //   66: aload 19
    //   68: invokevirtual 531	java/lang/String:length	()I
    //   71: ifle +542 -> 613
    //   74: aload 19
    //   76: ldc_w 533
    //   79: invokevirtual 537	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   82: astore 19
    //   84: aload 19
    //   86: ifnull +527 -> 613
    //   89: aload 19
    //   91: arraylength
    //   92: iconst_5
    //   93: if_icmplt +520 -> 613
    //   96: aload 19
    //   98: iconst_0
    //   99: aaload
    //   100: invokestatic 542	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   103: invokevirtual 545	java/lang/Integer:intValue	()I
    //   106: istore 7
    //   108: aload 19
    //   110: iconst_1
    //   111: aaload
    //   112: invokestatic 542	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   115: invokevirtual 545	java/lang/Integer:intValue	()I
    //   118: istore 6
    //   120: fload 4
    //   122: fstore_3
    //   123: aload 19
    //   125: iconst_2
    //   126: aaload
    //   127: invokestatic 550	java/lang/Float:valueOf	(Ljava/lang/String;)Ljava/lang/Float;
    //   130: invokevirtual 554	java/lang/Float:floatValue	()F
    //   133: fstore_2
    //   134: fload_2
    //   135: fstore_3
    //   136: aload 19
    //   138: iconst_3
    //   139: aaload
    //   140: invokestatic 542	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   143: invokevirtual 545	java/lang/Integer:intValue	()I
    //   146: istore 5
    //   148: aload 19
    //   150: iconst_4
    //   151: aaload
    //   152: invokestatic 559	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   155: invokevirtual 562	java/lang/Long:longValue	()J
    //   158: lstore 15
    //   160: iload 7
    //   162: istore 9
    //   164: iload 6
    //   166: istore 8
    //   168: iload 5
    //   170: istore 7
    //   172: fload_2
    //   173: fstore_3
    //   174: iconst_0
    //   175: invokestatic 154	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   178: ldc_w 521
    //   181: new 457	java/lang/StringBuilder
    //   184: dup
    //   185: invokespecial 458	java/lang/StringBuilder:<init>	()V
    //   188: ldc_w 564
    //   191: invokevirtual 464	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: iload 9
    //   196: invokevirtual 467	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   199: ldc_w 566
    //   202: invokevirtual 464	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: iload 8
    //   207: invokevirtual 467	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   210: ldc_w 568
    //   213: invokevirtual 464	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: iload 7
    //   218: invokevirtual 467	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   221: ldc_w 570
    //   224: invokevirtual 464	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: fload_3
    //   228: invokevirtual 573	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   231: ldc_w 575
    //   234: invokevirtual 464	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: lload 15
    //   239: invokevirtual 472	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   242: invokevirtual 473	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   245: invokestatic 528	com/tencent/mobileqq/utils/LogTag:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   248: invokestatic 580	com/tencent/mobileqq/highway/utils/VideoUpConfigInfo:isPreUpload	()Z
    //   251: istore 13
    //   253: getstatic 583	com/tencent/mobileqq/highway/utils/VideoUpConfigInfo:sIsHardCodeEnable	Z
    //   256: istore 14
    //   258: iload 8
    //   260: iconst_1
    //   261: if_icmpne +296 -> 557
    //   264: iload 14
    //   266: ifeq +291 -> 557
    //   269: iconst_1
    //   270: istore 12
    //   272: iconst_0
    //   273: invokestatic 154	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   276: ldc_w 521
    //   279: new 457	java/lang/StringBuilder
    //   282: dup
    //   283: invokespecial 458	java/lang/StringBuilder:<init>	()V
    //   286: ldc_w 585
    //   289: invokevirtual 464	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   292: iload 12
    //   294: invokevirtual 588	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   297: ldc_w 590
    //   300: invokevirtual 464	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   303: iload 8
    //   305: invokevirtual 467	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   308: ldc_w 592
    //   311: invokevirtual 464	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   314: iload 14
    //   316: invokevirtual 588	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   319: invokevirtual 473	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   322: invokestatic 528	com/tencent/mobileqq/utils/LogTag:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   325: invokestatic 595	com/tencent/mobileqq/highway/utils/VideoUpConfigInfo:getIsUpdated	()Z
    //   328: ifne +42 -> 370
    //   331: invokestatic 254	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   334: ifeq +13 -> 347
    //   337: ldc_w 256
    //   340: iconst_2
    //   341: ldc_w 597
    //   344: invokestatic 261	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   347: aload_0
    //   348: getfield 93	com/tencent/mobileqq/activity/recent/RecentOptPopBar:jdField_a_of_type_ComTencentMobileqqAppBaseActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   351: getfield 304	com/tencent/mobileqq/app/BaseActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   354: aload_0
    //   355: getfield 93	com/tencent/mobileqq/activity/recent/RecentOptPopBar:jdField_a_of_type_ComTencentMobileqqAppBaseActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   358: getfield 304	com/tencent/mobileqq/app/BaseActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   361: invokevirtual 600	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   364: invokestatic 606	com/tencent/mobileqq/highway/config/HwServlet:getConfig	(Lmqq/app/AppRuntime;Ljava/lang/String;)V
    //   367: invokestatic 609	com/tencent/mobileqq/highway/utils/VideoUpConfigInfo:setIsUpdated	()V
    //   370: invokestatic 610	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   373: invokestatic 614	com/tencent/mobileqq/utils/NetworkUtil:h	(Landroid/content/Context;)Z
    //   376: ifeq +193 -> 569
    //   379: iload 9
    //   381: iconst_1
    //   382: if_icmpne +181 -> 563
    //   385: iload 13
    //   387: ifeq +176 -> 563
    //   390: iconst_0
    //   391: invokestatic 154	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   394: ldc_w 521
    //   397: new 457	java/lang/StringBuilder
    //   400: dup
    //   401: invokespecial 458	java/lang/StringBuilder:<init>	()V
    //   404: ldc_w 616
    //   407: invokevirtual 464	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   410: iload 11
    //   412: invokevirtual 588	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   415: ldc_w 590
    //   418: invokevirtual 464	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   421: iload 9
    //   423: invokevirtual 467	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   426: ldc_w 592
    //   429: invokevirtual 464	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   432: iload 13
    //   434: invokevirtual 588	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   437: ldc_w 618
    //   440: invokevirtual 464	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   443: invokevirtual 473	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   446: invokestatic 528	com/tencent/mobileqq/utils/LogTag:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   449: aload_1
    //   450: ldc_w 620
    //   453: iload 11
    //   455: invokevirtual 114	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   458: pop
    //   459: aload_1
    //   460: ldc_w 622
    //   463: iload 12
    //   465: invokevirtual 114	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   468: pop
    //   469: aload_1
    //   470: ldc_w 624
    //   473: fload_3
    //   474: invokevirtual 627	android/content/Intent:putExtra	(Ljava/lang/String;F)Landroid/content/Intent;
    //   477: pop
    //   478: iload 12
    //   480: putstatic 630	com/tencent/mobileqq/shortvideo/hwcodec/HwEnvData:jdField_a_of_type_Boolean	Z
    //   483: iload 11
    //   485: putstatic 632	com/tencent/mobileqq/shortvideo/hwcodec/HwEnvData:jdField_b_of_type_Boolean	Z
    //   488: return
    //   489: astore 19
    //   491: iconst_0
    //   492: istore 6
    //   494: iconst_0
    //   495: istore 10
    //   497: iconst_0
    //   498: istore 5
    //   500: lload 17
    //   502: lstore 15
    //   504: fload_2
    //   505: fstore_3
    //   506: iload 5
    //   508: istore 7
    //   510: iload 6
    //   512: istore 8
    //   514: iload 10
    //   516: istore 9
    //   518: invokestatic 254	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   521: ifeq -347 -> 174
    //   524: ldc_w 256
    //   527: iconst_2
    //   528: ldc_w 634
    //   531: aload 19
    //   533: invokestatic 637	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   536: lload 17
    //   538: lstore 15
    //   540: fload_2
    //   541: fstore_3
    //   542: iload 5
    //   544: istore 7
    //   546: iload 6
    //   548: istore 8
    //   550: iload 10
    //   552: istore 9
    //   554: goto -380 -> 174
    //   557: iconst_0
    //   558: istore 12
    //   560: goto -288 -> 272
    //   563: iconst_0
    //   564: istore 11
    //   566: goto -176 -> 390
    //   569: iconst_0
    //   570: istore 11
    //   572: goto -123 -> 449
    //   575: astore 19
    //   577: iconst_0
    //   578: istore 6
    //   580: iconst_0
    //   581: istore 5
    //   583: iload 7
    //   585: istore 10
    //   587: goto -87 -> 500
    //   590: astore 19
    //   592: iconst_0
    //   593: istore 5
    //   595: fload_3
    //   596: fstore_2
    //   597: iload 7
    //   599: istore 10
    //   601: goto -101 -> 500
    //   604: astore 19
    //   606: iload 7
    //   608: istore 10
    //   610: goto -110 -> 500
    //   613: iconst_0
    //   614: istore 7
    //   616: iconst_0
    //   617: istore 8
    //   619: iconst_0
    //   620: istore 9
    //   622: lload 17
    //   624: lstore 15
    //   626: goto -452 -> 174
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	629	0	this	RecentOptPopBar
    //   0	629	1	paramIntent	Intent
    //   52	545	2	f1	float
    //   57	539	3	f2	float
    //   54	67	4	f3	float
    //   146	448	5	m	int
    //   118	461	6	n	int
    //   106	509	7	i1	int
    //   166	452	8	i2	int
    //   162	459	9	i3	int
    //   495	114	10	i4	int
    //   1	570	11	bool1	boolean
    //   270	289	12	bool2	boolean
    //   251	182	13	bool3	boolean
    //   256	59	14	bool4	boolean
    //   158	467	15	l1	long
    //   59	564	17	l2	long
    //   18	131	19	localObject	Object
    //   489	43	19	localNumberFormatException1	java.lang.NumberFormatException
    //   575	1	19	localNumberFormatException2	java.lang.NumberFormatException
    //   590	1	19	localNumberFormatException3	java.lang.NumberFormatException
    //   604	1	19	localNumberFormatException4	java.lang.NumberFormatException
    // Exception table:
    //   from	to	target	type
    //   96	108	489	java/lang/NumberFormatException
    //   108	120	575	java/lang/NumberFormatException
    //   123	134	590	java/lang/NumberFormatException
    //   136	148	590	java/lang/NumberFormatException
    //   148	160	604	java/lang/NumberFormatException
  }
  
  public void a(View paramView)
  {
    QLog.d("RecentOptPopBar", 1, "showCmGameNewPop");
    g();
    int i1;
    int i2;
    int n;
    int m;
    if (this.jdField_a_of_type_AndroidWidgetFrameLayout == null)
    {
      this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
      paramView.getGlobalVisibleRect(this.jdField_a_of_type_AndroidGraphicsRect);
      paramView = new TextView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      paramView.setBackgroundColor(-16777216);
      paramView.setTextColor(-1);
      paramView.setText("玩过的轻游戏在这里哦~");
      paramView.setGravity(17);
      paramView.setTextSize(14.0F);
      this.jdField_a_of_type_AndroidWidgetFrameLayout = new FrameLayout(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      if (FontSettingManager.a() <= 17.0F) {
        break label410;
      }
      paramView.setBackgroundResource(2130838063);
      i1 = (int)(110.0F * DeviceInfoUtil.a);
      i2 = (int)(50.0F * DeviceInfoUtil.a);
      n = (int)((float)DeviceInfoUtil.l() - 116.0F * DeviceInfoUtil.a - PopupMenuDialog.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131558949) - 4.0F * DeviceInfoUtil.a);
      m = this.jdField_a_of_type_AndroidGraphicsRect.bottom + (int)(220.0F * DeviceInfoUtil.a + 6.0F * DeviceInfoUtil.a);
      paramView.setIncludeFontPadding(false);
      paramView.setGravity(3);
      paramView.setTextSize(14.0F);
      paramView.setPadding((int)(DeviceInfoUtil.a * 10.0F), (int)(DeviceInfoUtil.a * 10.0F), (int)(20.0F * DeviceInfoUtil.a), (int)(8.0F * DeviceInfoUtil.a));
    }
    for (;;)
    {
      Object localObject = new FrameLayout.LayoutParams(i1, i2);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(paramView, (ViewGroup.LayoutParams)localObject);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setX(n);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setY(m);
      try
      {
        paramView = (WindowManager)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getSystemService("window");
        m = 24;
        if (ImmersiveUtils.isSupporImmersive() == 1) {
          m = 67108888;
        }
        localObject = new WindowManager.LayoutParams(-1, -1, 2, m, -3);
        paramView.addView(this.jdField_a_of_type_AndroidWidgetFrameLayout, (ViewGroup.LayoutParams)localObject);
      }
      catch (Throwable paramView)
      {
        for (;;)
        {
          QLog.e("RecentOptPopBar", 2, "showCmGameNewPop error e=" + paramView.toString());
        }
      }
      ThreadManager.getUIHandler().postDelayed(new xqq(this), 10000L);
      VipUtils.a(CmGameUtil.a(), "cmshow", "Apollo", "recentgameguidance", 0, 0, new String[] { "" + CmGameUtil.c() });
      return;
      label410:
      paramView.setBackgroundResource(2130838062);
      i1 = (int)(179.0F * DeviceInfoUtil.a);
      i2 = (int)(33.0F * DeviceInfoUtil.a);
      n = (int)((float)DeviceInfoUtil.l() - 185.0F * DeviceInfoUtil.a - PopupMenuDialog.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131558949));
      m = this.jdField_a_of_type_AndroidGraphicsRect.bottom + (int)(220.0F * DeviceInfoUtil.a + 16.0F * DeviceInfoUtil.a);
    }
  }
  
  public void a(View paramView, int paramInt1, int paramInt2)
  {
    a();
    if ((this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog != null) && (this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog.jdField_a_of_type_Boolean)) {
      this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog = null;
    }
    if (this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog == null) {
      e();
    }
    for (;;)
    {
      paramInt2 = WorldCup.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getAppInterface(), paramView, this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog, paramInt2);
      this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog.showAsDropDown(paramView, paramInt1, paramInt2);
      if ((this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch != null) && (this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch != null)) {
        break label662;
      }
      localObject1 = (LinearLayout)this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog.getContentView().findViewById(2131363062);
      paramInt1 = 0;
      label98:
      if (paramInt1 >= ((LinearLayout)localObject1).getChildCount()) {
        break label662;
      }
      try
      {
        Object localObject2 = ((LinearLayout)localObject1).getChildAt(paramInt1);
        if (((PopupMenuDialog.MenuItem)((View)localObject2).getTag()).jdField_a_of_type_Int == 2131436251)
        {
          localObject2 = (TextView)((View)localObject2).findViewById(2131363250);
          this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (View)localObject2).a(21).a();
        }
        for (;;)
        {
          paramInt1 += 1;
          break label98;
          if (this.jdField_a_of_type_Boolean)
          {
            e();
            this.jdField_a_of_type_Boolean = false;
          }
          if (((this.jdField_e_of_type_Boolean) && (!QWalletSetting.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getCurrentAccountUin(), "F2FRedpackEntry", false))) || ((!this.jdField_e_of_type_Boolean) && (QWalletSetting.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getCurrentAccountUin(), "F2FRedpackEntry", false))))
          {
            e();
            this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = null;
            this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch = null;
          }
          if (QWalletSetting.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getCurrentAccountUin()))
          {
            if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
              this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidWidgetTextView.getResources().getColor(2131493096));
            }
            if (this.jdField_b_of_type_AndroidWidgetImageView != null) {
              this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130838702);
            }
          }
          while (((this.jdField_d_of_type_Boolean) && (!RecentDanceConfigMgr.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app))) || ((!this.jdField_d_of_type_Boolean) && (RecentDanceConfigMgr.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app))) || ((this.jdField_d_of_type_Boolean) && (RecentDanceConfigMgr.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app)) && (RecentDanceConfigMgr.a())))
          {
            e();
            break;
            if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
              this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidWidgetTextView.getResources().getColor(2131494220));
            }
            if (this.jdField_b_of_type_AndroidWidgetImageView != null) {
              this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130838703);
            }
          }
          if (((PopupMenuDialog.MenuItem)((View)localObject2).getTag()).jdField_a_of_type_Int != 2131436252) {
            break label500;
          }
          localObject2 = ((View)localObject2).findViewById(2131363249);
          this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (View)localObject2).a(53).a();
        }
      }
      catch (Exception localException3)
      {
        label500:
        do
        {
          for (;;)
          {
            localException3.printStackTrace();
          }
        } while (((PopupMenuDialog.MenuItem)localException3.getTag()).jdField_a_of_type_Int != 2131436260);
        this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localException3.findViewById(2131363250));
        this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)localException3.findViewById(2131363249));
        if (!QWalletSetting.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getCurrentAccountUin())) {
          break label629;
        }
      }
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidWidgetTextView.getResources().getColor(2131493096));
    this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130838702);
    for (;;)
    {
      this.jdField_c_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_b_of_type_AndroidWidgetImageView).a(53).a();
      a("KEY_F2F_REDPACK_IS_SHOWED", true);
      break;
      label629:
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidWidgetTextView.getResources().getColor(2131494220));
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130838703);
    }
    label662:
    if (this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch != null)
    {
      localObject1 = ((RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getManager(35)).a("101210.101211");
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.a((BusinessInfoCheckUpdate.AppInfo)localObject1);
    }
    boolean bool;
    if ((this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch == null) || (this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch != null))
    {
      if (RedBagVideoManager.a(RedBagVideoManager.g)) {
        break label1010;
      }
      bool = true;
      this.jdField_c_of_type_Boolean = bool;
      if (this.jdField_c_of_type_Boolean != this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch.g) {
        this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch.a(this.jdField_c_of_type_Boolean);
      }
    }
    if (this.jdField_c_of_type_ComTencentMobileqqRedtouchRedTouch != null)
    {
      if (a("KEY_F2F_REDPACK_RED_TOUCH", true))
      {
        localObject1 = new BusinessInfoCheckUpdate.RedTypeInfo();
        ((BusinessInfoCheckUpdate.RedTypeInfo)localObject1).red_type.set(0);
        this.jdField_c_of_type_ComTencentMobileqqRedtouchRedTouch.a((BusinessInfoCheckUpdate.RedTypeInfo)localObject1);
      }
    }
    else {
      label803:
      paramInt2 = 1;
    }
    try
    {
      localObject1 = BaseApplicationImpl.getApplication().getSharedPreferences("CrashControl_com.tencent.mobileqq:peak", 4);
      paramInt1 = paramInt2;
      if (localObject1 != null)
      {
        paramInt1 = paramInt2;
        if (!((SharedPreferences)localObject1).getBoolean("allowpreload", true))
        {
          long l1 = ((SharedPreferences)localObject1).getLong("starttime", 0L);
          paramInt1 = ((SharedPreferences)localObject1).getInt("controlwindow", 86400);
          long l2 = System.currentTimeMillis();
          if ((l1 <= 0L) || (paramInt1 <= 0) || (l2 <= l1) || (l2 - l1 <= paramInt1 * 1000)) {
            break label1033;
          }
          ((SharedPreferences)localObject1).edit().putBoolean("allowpreload", true).commit();
          paramInt1 = paramInt2;
        }
      }
    }
    catch (Exception localException1)
    {
      try
      {
        StatisticCollector.a(BaseApplicationImpl.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getAppInterface().getCurrentAccountUin(), "actNoPreloadPeak", true, 0L, 0L, null, "");
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          paramInt1 = paramInt2;
        }
      }
      localException1 = localException1;
      paramInt1 = 1;
    }
    if (paramInt1 != 0)
    {
      if (PeakUtils.a == null)
      {
        PeakUtils.a = new PreloadProcHitSession("peak_preload_plus_panel", "com.tencent.mobileqq:peak");
        PeakUtils.a.a();
      }
      ThreadManager.getSubThreadHandler().post(new xrh(this));
    }
    b();
    Object localObject1 = (ApolloManager)CmGameUtil.a().getManager(152);
    if ((localObject1 == null) || (!((ApolloManager)localObject1).g())) {}
    for (;;)
    {
      return;
      label1010:
      bool = false;
      break;
      this.jdField_c_of_type_ComTencentMobileqqRedtouchRedTouch.a(new BusinessInfoCheckUpdate.AppInfo());
      break label803;
      label1033:
      QLog.d("RecentOptPopBar", 1, "preloadPeakProcess is not allowed as crash frequently.");
      paramInt2 = 0;
      paramInt1 = 0;
      for (;;)
      {
        localException1.printStackTrace();
      }
      paramInt1 = localException1.b();
      if ((paramInt1 == 3) && (this.jdField_b_of_type_Boolean))
      {
        localException1.k = false;
        if (BaseApplicationImpl.getContext().getSharedPreferences("apollo_sp", 0).getInt("showed_ball" + CmGameUtil.a().getCurrentAccountUin(), 0) != 0) {
          break label1253;
        }
        h();
        VipUtils.a(CmGameUtil.a(), "cmshow", "Apollo", "ballexposure", 0, 0, new String[] { "", "" + ApolloManager.a() });
      }
      while ((paramInt1 == 2) && (this.jdField_b_of_type_Boolean))
      {
        localException1.k = false;
        ThreadManager.getUIHandler().postDelayed(new xri(this, paramView), 500L);
        return;
        label1253:
        if (this.jdField_a_of_type_AndroidWidgetImageView != null)
        {
          this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams().height = 0;
          this.jdField_a_of_type_AndroidWidgetImageView.requestLayout();
          VipUtils.a(CmGameUtil.a(), "cmshow", "Apollo", "ballexposure", 0, 0, new String[] { "", "" + ApolloManager.a() });
        }
      }
    }
  }
  
  public void a(String paramString, long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity == null) {}
    while (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getSharedPreferences("SP_SHOT_REDTOUCH_TIME" + this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getAppInterface().getCurrentAccountUin(), 0).getLong(paramString, 0L) != 0L) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getSharedPreferences("SP_SHOT_REDTOUCH_TIME" + this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getAppInterface().getCurrentAccountUin(), 0).edit().putLong(paramString, paramLong).commit();
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getSharedPreferences("SP_RECENT_OPTOPBAR", 0).edit().putBoolean(paramString + this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getCurrentAccountUin(), paramBoolean).commit();
  }
  
  protected void a(boolean paramBoolean)
  {
    boolean bool3 = b();
    Object localObject1 = (RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getManager(35);
    Object localObject2 = ((RedTouchManager)localObject1).a("103100.103500.103501");
    if (QLog.isColorLevel()) {
      QLog.d("RecentOptPopBar", 2, "<hongdian> aioShortVideoFilterPath=" + "103100.103500.103501" + "   reddotInfo=" + localObject2);
    }
    boolean bool2;
    if (localObject2 != null) {
      if (((BusinessInfoCheckUpdate.AppInfo)localObject2).iNewFlag.get() == 1)
      {
        bool2 = true;
        bool1 = bool2;
        if (QLog.isColorLevel()) {
          QLog.d("RecentOptPopBar", 2, "<hongdian> reddotInfo.iNewFlag.get()=" + ((BusinessInfoCheckUpdate.AppInfo)localObject2).iNewFlag.get() + "   showRedDot=" + bool2);
        }
      }
    }
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localObject2 = BaseApplicationImpl.getApplication().getSharedPreferences("flow_filter_reddot_sp", 4);
      bool2 = ((SharedPreferences)localObject2).getBoolean("flow_filter_reddot_key", false);
      if (bool2)
      {
        ((RedTouchManager)localObject1).b("103100.103500.103501");
        ((SharedPreferences)localObject2).edit().putBoolean("flow_filter_reddot_key", false).commit();
        bool1 = false;
      }
      if (QLog.isColorLevel()) {
        QLog.d("RecentOptPopBar", 2, "<hongdian> showRedDot=" + bool1 + " currentClicked=" + bool2);
      }
      boolean bool4 = BaseApplicationImpl.getApplication().getSharedPreferences("flow_filter_reddot_pkg_sp" + this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getCurrentAccountUin(), 4).getBoolean("flow_filter_reddot_key", false);
      if (!bool4) {}
      for (bool2 = true;; bool2 = false)
      {
        if (QLog.isColorLevel()) {
          QLog.d("RecentOptPopBar", 2, "<hongdian> needShowRedPkg=" + bool2 + "  clicked=" + bool4);
        }
        bool4 = PtvFilterSoLoad.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, BaseApplicationImpl.getContext());
        localObject2 = PlusPanelUtils.a(AppConstants.aW);
        if (CaptureUtil.a()) {
          if (bool3)
          {
            CameraCaptureActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QuickShootEffectsCameraCaptureFragment.class.getName(), AIOEffectsCameraCaptureFragment.a(null, 10004, null, 0L, false), 9010);
            if (QLog.isColorLevel()) {
              QLog.d("RecentOptPopBar", 2, "launch CameraCaptureActivity");
            }
            ShortVideoErrorReport.a(0);
          }
        }
        for (;;)
        {
          if (MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app).b()) {
            MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app).a(false);
          }
          return;
          bool2 = false;
          break;
          localObject1 = CameraCaptureActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QuickShootEffectsCameraCaptureFragment.class.getName(), AIOEffectsCameraCaptureFragment.a(null, 10004, null, 0L, false));
          CaptureSoDownloadActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QuickShootEffectsCameraCaptureFragment.class.getName(), ((Intent)localObject1).getExtras(), 9010);
          ShortVideoErrorReport.a(1);
          continue;
          if ((bool3) && ((bool4) || (PtvFilterSoLoad.a(BaseApplicationImpl.getContext()) == 0))) {}
          for (int m = 1;; m = 0)
          {
            if (m == 0) {
              break label871;
            }
            localObject1 = NewFlowCameraActivity.class;
            if (CameraCompatibleList.d(CameraCompatibleList.c)) {
              localObject1 = MX3FlowNewCameraActivity.class;
            }
            localObject1 = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (Class)localObject1);
            File localFile = new File(AppConstants.aW);
            if (!localFile.exists()) {
              localFile.mkdirs();
            }
            PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).edit().putString("camera_photo_path", (String)localObject2).commit();
            ((Intent)localObject1).putExtra("qcamera_photo_filepath", (String)localObject2);
            ((Intent)localObject1).putExtra("support_photo_merge", true);
            ((Intent)localObject1).putExtra("recapture", paramBoolean);
            ((Intent)localObject1).putExtra("activity_start_time", SystemClock.elapsedRealtime());
            ((Intent)localObject1).putExtra("video_min_frame_count", 3);
            ((Intent)localObject1).putExtra("PhotoConst.MY_UIN", this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getAccount());
            ((Intent)localObject1).putExtra("sv_config", DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.SV658Cfg.name(), null));
            ((Intent)localObject1).putExtra("sv_whitelist", DeviceProfileManager.a().a(DeviceProfileManager.AccountDpcManager.DpcAccountNames.picpredownload_whitelist.name()));
            ((Intent)localObject1).putExtra("flow_show_filter_red", bool1);
            ((Intent)localObject1).putExtra("flow_show_filter_red_pkg", bool2);
            a((Intent)localObject1);
            ((Intent)localObject1).putExtra("edit_video_type", 10004);
            ((Intent)localObject1).putExtra("entrance_type", 8);
            ((Intent)localObject1).putExtra("flow_camera_video_mode", true);
            ((Intent)localObject1).putExtra("flow_camera_use_filter_function", bool4);
            this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivityForResult((Intent)localObject1, 9010);
            if (QLog.isColorLevel()) {
              QLog.d("RecentOptPopBar", 2, "launch NewFlowCameraActivity");
            }
            ShortVideoErrorReport.a(0);
            break;
          }
          label871:
          ShortVideoErrorReport.a(1);
          localObject1 = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, NewPreFlowCamera.class);
          ((Intent)localObject1).putExtra("support_photo_merge", true);
          ((Intent)localObject1).putExtra("qcamera_photo_filepath", (String)localObject2);
          ((Intent)localObject1).putExtra("edit_video_type", 10004);
          ((Intent)localObject1).putExtra("entrance_type", 8);
          ((Intent)localObject1).putExtra("flow_show_filter_red", bool1);
          ((Intent)localObject1).putExtra("flow_show_filter_red_pkg", bool2);
          this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivityForResult((Intent)localObject1, 9010);
        }
      }
    }
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog != null) && (this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog.isShowing());
  }
  
  public boolean a(String paramString, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity == null) {
      return paramBoolean;
    }
    return this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getSharedPreferences("SP_RECENT_OPTOPBAR", 0).getBoolean(paramString + this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getCurrentAccountUin(), paramBoolean);
  }
  
  public View b()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(1);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2130838684);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = new RecyclerView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    this.jdField_a_of_type_ComTencentMobileqqApolloPlusPanelViewPlusRecyclerViewAdapter = new PlusRecyclerViewAdapter(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    Object localObject = PopupMenuDialog.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 3);
    if ((localObject == null) || (((List)localObject).size() == 0))
    {
      this.jdField_a_of_type_Boolean = true;
      return null;
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloPlusPanelViewPlusRecyclerViewAdapter.a((List)localObject);
    localObject = new LinearLayoutManager(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    ((LinearLayoutManager)localObject).setOrientation(1);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setOverScrollMode(2);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager((RecyclerView.LayoutManager)localObject);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setBackgroundColor(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColor(2131493444));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqApolloPlusPanelViewPlusRecyclerViewAdapter);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView);
    localObject = (RelativeLayout)LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).inflate(2130968692, null);
    ((RelativeLayout)localObject).setOnClickListener(new xqp(this));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject);
    return this.jdField_a_of_type_AndroidWidgetLinearLayout;
  }
  
  public PopupMenuDialog.MenuItem b(int[] paramArrayOfInt)
  {
    PopupMenuDialog.MenuItem localMenuItem = new PopupMenuDialog.MenuItem();
    localMenuItem.jdField_a_of_type_Int = paramArrayOfInt[0];
    localMenuItem.c = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(paramArrayOfInt[0]);
    localMenuItem.b = paramArrayOfInt[1];
    RecentDanceConfigMgr.DItemInfo localDItemInfo = RecentDanceConfigMgr.a();
    if (localDItemInfo != null)
    {
      localMenuItem.jdField_a_of_type_JavaLangString = localDItemInfo.showName;
      localMenuItem.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable = localDItemInfo.drawable;
      return localMenuItem;
    }
    localMenuItem.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(paramArrayOfInt[0]);
    localMenuItem.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable = null;
    return localMenuItem;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog == null) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
  }
  
  public boolean b()
  {
    if (ShortVideoUtils.a()) {
      return true;
    }
    ThreadManager.post(new xqz(this), 8, null, true);
    return false;
  }
  
  public View c()
  {
    int m = BaseApplicationImpl.getContext().getSharedPreferences("apollo_sp", 0).getInt("showed_ball" + CmGameUtil.a().getCurrentAccountUin(), 0);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).inflate(2130968696, null));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131363251));
    if (m == 1)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams().height = 0;
      this.jdField_a_of_type_AndroidWidgetImageView.requestLayout();
    }
    ((Button)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131363258)).setOnClickListener(new xrb(this));
    ((Button)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131363259)).setOnClickListener(new xrc(this));
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getAppInterface();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = (WebProcessManager)((AppInterface)localObject).getManager(12);
      if (localObject != null) {
        ((WebProcessManager)localObject).e();
      }
      localObject = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, WebProcessReceiver.class);
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.sendBroadcast((Intent)localObject, "com.tencent.msg.permission.pushnotify");
    }
    return this.jdField_a_of_type_AndroidWidgetRelativeLayout;
  }
  
  public void c()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog == null) {
        return;
      }
      BaseApplicationImpl.getContext().getSharedPreferences("apollo_sp", 0).getInt("showed_ball" + CmGameUtil.a().getCurrentAccountUin(), 0);
      if (this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog.isShowing())
      {
        this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog.getContentView().setBackgroundResource(2130838698);
        this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog.getContentView().findViewById(2131363062).setBackgroundColor(0);
        this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog.getContentView().findViewById(2131363062).setPadding(0, 0, 0, 0);
        this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog.getContentView().findViewById(2131374955).getLayoutParams().height = 0;
        int m = PopupMenuDialog.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131558950);
        int n = PopupMenuDialog.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131558951);
        this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog.update(PopupMenuDialog.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131558949), m * 5 + n);
      }
      CmGameUtil.b(3);
      ApolloManager localApolloManager = (ApolloManager)CmGameUtil.a().getManager(152);
      if (localApolloManager != null)
      {
        localApolloManager.h = true;
        this.jdField_a_of_type_Boolean = true;
      }
      VipUtils.a(CmGameUtil.a(), "cmshow", "Apollo", "ballignore", 0, 0, new String[] { "", "" + ApolloManager.a() });
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("RecentOptPopBar", 2, "onClickIgnore e=" + localThrowable.toString());
    }
  }
  
  public void d()
  {
    ApolloManager localApolloManager = (ApolloManager)CmGameUtil.a().getManager(152);
    if (localApolloManager == null) {
      return;
    }
    localApolloManager.jdField_f_of_type_Boolean = true;
    e();
  }
  
  public void e()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(a(g));
    localArrayList.add(a(jdField_c_of_type_ArrayOfInt));
    localArrayList.add(a(jdField_a_of_type_ArrayOfInt));
    localArrayList.add(a(jdField_d_of_type_ArrayOfInt));
    localArrayList.add(a(jdField_e_of_type_ArrayOfInt));
    this.jdField_d_of_type_Boolean = false;
    if (RecentDanceConfigMgr.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app))
    {
      localArrayList.add(b(j));
      this.jdField_d_of_type_Boolean = true;
    }
    this.jdField_e_of_type_Boolean = false;
    if (QWalletSetting.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getCurrentAccountUin(), "F2FRedpackEntry", false))
    {
      localArrayList.add(a(h));
      this.jdField_e_of_type_Boolean = true;
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "hongbaocaidan.show", 0, 0, "", "", "", "");
    }
    View localView = a();
    if (localView != null)
    {
      this.jdField_b_of_type_Boolean = true;
      if (this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog != null)
      {
        ((ViewGroup)this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog.getContentView()).removeAllViews();
        this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog = null;
      }
      this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog = PopupMenuDialog.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, localArrayList, localView, a(), new xrd(this), new xre(this), 0, false);
      if (this.jdField_a_of_type_ComTencentMobileqqApolloPlusPanelViewPlusRecyclerViewAdapter != null) {
        this.jdField_a_of_type_ComTencentMobileqqApolloPlusPanelViewPlusRecyclerViewAdapter.a(this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog);
      }
      return;
    }
    this.jdField_b_of_type_Boolean = false;
    if (!ApolloSoLoader.a()) {
      this.jdField_a_of_type_Boolean = true;
    }
    this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog = PopupMenuDialog.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, localArrayList, new xrf(this), new xrg(this));
  }
  
  public void f()
  {
    if (a()) {
      this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog.dismiss();
    }
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_AndroidWidgetFrameLayout == null) {
      return;
    }
    try
    {
      ((WindowManager)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getSystemService("window")).removeView(this.jdField_a_of_type_AndroidWidgetFrameLayout);
      QLog.d("RecentOptPopBar", 1, "removeNewUserTag");
      this.jdField_a_of_type_AndroidWidgetFrameLayout = null;
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e("RecentOptPopBar", 2, "removeNewUserTag error e=" + localThrowable.toString());
      }
    }
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView == null) {
      return;
    }
    QLog.d("RecentOptPopBar", 1, "showCmGameNewAnim");
    this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog.getContentView().findViewById(2131363062).setBackgroundResource(2130838685);
    this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog.getContentView().findViewById(2131374955).getLayoutParams().height = 0;
    this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog.getContentView().setBackgroundColor(0);
    this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog.getContentView().findViewById(2131370696).setBackgroundColor(0);
    PopupMenuDialog.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131558950);
    PopupMenuDialog.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131558951);
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { (int)(127.0F * DeviceInfoUtil.a), 0 });
    localValueAnimator.setDuration(400L);
    localValueAnimator.addUpdateListener(new xqr(this));
    localValueAnimator.setInterpolator(new DecelerateInterpolator(2.0F));
    localValueAnimator.setStartDelay(500L);
    localValueAnimator.start();
    BaseApplicationImpl.getContext().getSharedPreferences("apollo_sp", 0).edit().putInt("showed_ball" + CmGameUtil.a().getCurrentAccountUin(), 1).commit();
    ThreadManager.getUIHandler().postDelayed(new xqs(this), 10000L);
  }
  
  public void i()
  {
    a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 0L, 0L, 1);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "CliOper", "", "", "0X8004077", "0X8004077", 0, 0, "", "", "", "");
  }
  
  public void j()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, AddContactsActivity.class);
    localIntent.putExtra("entrence_data_report", 2);
    localIntent.putExtra("EntranceId", 4);
    localIntent.putExtra("leftViewText", this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131433712));
    localIntent.putExtra("selfSet_leftViewText", this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131433712));
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity(localIntent);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "CliOper", "", "", "0X8004839", "0X8004839", 0, 0, "", "", "", "");
    try
    {
      ((RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getManager(35)).b(String.valueOf("101210.101211"));
      return;
    }
    catch (Exception localException) {}
  }
  
  public void k()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, ARMainActivity.class);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity(localIntent);
  }
  
  public void l()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecentOptPopBar", 2, "hideProgress");
    }
    try
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()))
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
        this.jdField_f_of_type_Boolean = false;
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("RecentOptPopBar", 2, localException.toString());
    }
  }
  
  public void m()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecentOptPopBar", 2, "enterArmap");
    }
    if (!ArNativeSoLoader.a("ArMapEngine7652"))
    {
      Object localObject = (EarlyDownloadManager)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getManager(76);
      if (localObject != null)
      {
        localObject = (ArNativeSoDownloadHandler)((EarlyDownloadManager)localObject).a("qq.android.ar.native.so_v7.6.5.2");
        if (localObject != null)
        {
          ((ArNativeSoDownloadHandler)localObject).a(new xqt(this, (ArNativeSoDownloadHandler)localObject));
          v();
          ((ArNativeSoDownloadHandler)localObject).a(true);
        }
      }
      return;
    }
    if (!ARNativeBridge.loadNativeLibrary())
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 1, "资源加载失败", 1).a();
      QLog.d("RecentOptPopBar", 1, "ArMap, enterArmap, so exists but load falid");
      return;
    }
    QLog.d("RecentOptPopBar", 1, "ArMap, enterArmap, launch normal");
    w();
  }
  
  public void n() {}
  
  public void o()
  {
    QQProxyForQlink.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 8, null);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "CliOper", "", "", "0X80053AD", "0X80053AD", 0, 0, "", "", "", "");
  }
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog.dismiss();
  }
  
  public void p()
  {
    long l1 = VACDReportUtil.a(null, "qqwallet", "gotoF2fredpack", "click", null, 0, null);
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QrcodeHbGuiderActivity.class);
    localIntent.putExtra("appInfo", "");
    localIntent.putExtra("vacreport_key_seq", l1);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity(localIntent);
    a("KEY_F2F_REDPACK_RED_TOUCH", false);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "jiahao.hongbao.click", 0, 0, "", "", "", "");
  }
  
  public void q()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, NewTroopCreateActivity.class);
    localIntent.putExtra("param_exit_animation", 0);
    localIntent.setFlags(603979776);
    localIntent.putExtra("create_source", 0);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivityForResult(localIntent, 1300);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.overridePendingTransition(2131034134, 2131034135);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "CliOper", "", "", "0X8004074", "0X8004074", 0, 0, "", "", "", "");
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00899", "Grp_create", "", "msg_page", "exp_creategrp", 0, 0, "", "", "", "");
  }
  
  public void r()
  {
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "CliOper", "", "", "0X800780A", "0X800780A", 0, 0, "", "", "", "");
    StoryReportor.a("plus_shoot", "clk_entry", 0, 0, new String[] { "", "", "", "" });
    StoryReportor.a("plus_shoot", "exp_shoot", 0, 0, new String[] { "", "", "", "" });
    if (this.jdField_c_of_type_Boolean) {
      RedBagVideoManager.a(RedBagVideoManager.g);
    }
    s();
    if (PeakUtils.a != null) {
      PeakUtils.a.b();
    }
  }
  
  protected void s()
  {
    if (!VideoEnvironment.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app)) {
      DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 230).setMessage("系统版本过低，不支持短视频功能").setPositiveButton(2131433030, new xqy(this)).show();
    }
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.c())
      {
        QQToast.a(BaseApplicationImpl.getContext(), 2131428992, 1).b(BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131558448));
        return;
      }
    } while (!VideoEnvironment.d(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app));
    a(false);
  }
  
  protected void t()
  {
    RecentDanceConfigMgr.DItemInfo localDItemInfo = RecentDanceConfigMgr.a();
    if (localDItemInfo == null) {
      RecentDanceConfigMgr.a("showDanceCategoryPanel:[Plus] itemInfo=null");
    }
    for (;;)
    {
      return;
      boolean bool = DanceGameVideoManager.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app);
      RecentDanceConfigMgr.a("showDanceCategoryPanel: videoUsable=" + bool);
      CaptureReportUtil.i();
      if (bool)
      {
        CameraCaptureActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QuickShootEffectsCameraCaptureFragment.class.getName(), AIOEffectsCameraCaptureFragment.a(null, 10004, null, 0L, false, localDItemInfo.unfold, localDItemInfo.categoryID, localDItemInfo.itemID), 9010);
        RecentDanceConfigMgr.a("showDanceCategoryPanel: unfold=" + localDItemInfo.unfold + " categoryID=" + localDItemInfo.categoryID + " itemID=" + localDItemInfo.itemID);
        ShortVideoErrorReport.a(0);
      }
      while (MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app).b())
      {
        MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app).a(false);
        return;
        Intent localIntent = CameraCaptureActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QuickShootEffectsCameraCaptureFragment.class.getName(), AIOEffectsCameraCaptureFragment.a(null, 10004, null, 0L, false, localDItemInfo.unfold, localDItemInfo.categoryID, localDItemInfo.itemID));
        RecentDanceConfigMgr.a("showDanceCategoryPanel[SoDownload]: unfold=" + localDItemInfo.unfold + " categoryID=" + localDItemInfo.categoryID + " itemID=" + localDItemInfo.itemID);
        CaptureSoDownloadActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QuickShootEffectsCameraCaptureFragment.class.getName(), localIntent.getExtras(), 9010, true);
        ShortVideoErrorReport.a(1);
      }
    }
  }
  
  public void u()
  {
    if (this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog != null) {
      this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentOptPopBar
 * JD-Core Version:    0.7.0.1
 */