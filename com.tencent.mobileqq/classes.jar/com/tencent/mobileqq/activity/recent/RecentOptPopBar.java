package com.tencent.mobileqq.activity.recent;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
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
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.AccountDpcManager.DpcAccountNames;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ar.ARNativeBridge;
import com.tencent.mobileqq.ar.ArNativeSoLoader;
import com.tencent.mobileqq.armap.ARMapActivity;
import com.tencent.mobileqq.armap.RedPacketRainConfigManager;
import com.tencent.mobileqq.armap.test.ARMainActivity;
import com.tencent.mobileqq.earlydownload.EarlyDownloadManager;
import com.tencent.mobileqq.earlydownload.handler.ArNativeSoDownloadHandler;
import com.tencent.mobileqq.hitrate.PreloadProcHitSession;
import com.tencent.mobileqq.pb.PBInt32Field;
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
import com.tencent.mobileqq.troop.createNewTroop.NewTroopCreateActivity;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.PopupMenuDialog;
import com.tencent.widget.PopupMenuDialog.MenuItem;
import cooperation.peak.PeakUtils;
import cooperation.qlink.QQProxyForQlink;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import xks;
import xku;
import xkz;
import xla;
import xlb;

public class RecentOptPopBar
  implements View.OnClickListener
{
  public static final int[] a;
  private static final int[] jdField_b_of_type_ArrayOfInt = { 2131438738, 2130842297 };
  private static final int[] jdField_c_of_type_ArrayOfInt = { 2131436232, 2130838689 };
  private static final int[] jdField_d_of_type_ArrayOfInt = { 2131436236, 2130838679 };
  private static final int[] e = { 2131436237, 2130838693 };
  private static final int[] f = { 2131436233, 2130838692 };
  private static final int[] g = { 2131436227, 2130838697 };
  private static final int[] h = { 2131436241, 2130838694 };
  private static final int[] i = { 2131436242, 2130838692 };
  private static final int[] j = { 2131438740, 2130842267 };
  private static final int[] k = { 2131439189, 2130842267 };
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  public BaseActivity a;
  private RedTouch jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private PopupMenuDialog jdField_a_of_type_ComTencentWidgetPopupMenuDialog;
  private boolean jdField_a_of_type_Boolean;
  private RedTouch jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch;
  private boolean jdField_b_of_type_Boolean;
  private RedTouch jdField_c_of_type_ComTencentMobileqqRedtouchRedTouch;
  private boolean jdField_c_of_type_Boolean;
  private RedTouch jdField_d_of_type_ComTencentMobileqqRedtouchRedTouch;
  private boolean jdField_d_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { 2131436229, 2130838698 };
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
    localIntent.putExtra("leftViewText", paramBaseActivity.getString(2131433698));
    localIntent.putExtra("selfSet_leftViewText", paramBaseActivity.getString(2131433698));
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
  
  private void p()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecentOptPopBar", 2, "showProgress");
    }
    if (this.jdField_d_of_type_Boolean) {}
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
        this.jdField_d_of_type_Boolean = true;
        return;
      }
      catch (Exception localException) {}
    } while (!QLog.isColorLevel());
    QLog.i("RecentOptPopBar", 2, localException.toString());
  }
  
  private void q()
  {
    Object localObject = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, ARMapActivity.class);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity((Intent)localObject);
    localObject = RedPacketRainConfigManager.a();
    ((RedPacketRainConfigManager)localObject).jdField_a_of_type_Boolean = false;
    ((RedPacketRainConfigManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app);
  }
  
  private void r()
  {
    if (!VideoEnvironment.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app))
    {
      DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 230).setMessage("系统版本过低，不支持短视频功能").setPositiveButton(2131433016, new xlb(this)).show();
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.c()) {
      QQToast.a(BaseApplicationImpl.getContext(), 2131428992, 1).b(BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131558448));
    }
    for (;;)
    {
      RecentDanceConfigMgr.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app);
      return;
      if (VideoEnvironment.d(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app)) {
        n();
      }
    }
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
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(a(g));
    localArrayList.add(a(jdField_c_of_type_ArrayOfInt));
    localArrayList.add(a(jdField_a_of_type_ArrayOfInt));
    localArrayList.add(a(jdField_d_of_type_ArrayOfInt));
    localArrayList.add(a(e));
    this.jdField_c_of_type_Boolean = false;
    if (QWalletSetting.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getCurrentAccountUin(), "F2FRedpackEntry", false))
    {
      localArrayList.add(a(h));
      this.jdField_c_of_type_Boolean = true;
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "hongbaocaidan.show", 0, 0, "", "", "", "");
    }
    this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog = PopupMenuDialog.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, localArrayList, new xks(this));
  }
  
  public void a(int paramInt)
  {
    long l = VACDReportUtil.a(null, "qqwallet", "payCode", "click", "2", 0, null);
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, JumpActivity.class);
    localIntent.setData(Uri.parse("mqqapi://wallet/open?src_type=web&viewtype=0&version=1&view=" + paramInt + "&entry=2&seq=" + l));
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivityForResult(localIntent, -1);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "CliOper", "", "", "0X8005ED3", "0X8005ED3", 0, 0, "", "", "", "");
  }
  
  /* Error */
  protected void a(Intent paramIntent)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 11
    //   3: invokestatic 469	com/tencent/mobileqq/app/DeviceProfileManager:a	()Lcom/tencent/mobileqq/app/DeviceProfileManager;
    //   6: getstatic 475	com/tencent/mobileqq/app/DeviceProfileManager$DpcNames:PreUploadVideoConfig	Lcom/tencent/mobileqq/app/DeviceProfileManager$DpcNames;
    //   9: invokevirtual 478	com/tencent/mobileqq/app/DeviceProfileManager$DpcNames:name	()Ljava/lang/String;
    //   12: ldc_w 480
    //   15: invokevirtual 483	com/tencent/mobileqq/app/DeviceProfileManager:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   18: astore 19
    //   20: iconst_0
    //   21: invokestatic 137	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   24: ldc_w 485
    //   27: new 428	java/lang/StringBuilder
    //   30: dup
    //   31: invokespecial 429	java/lang/StringBuilder:<init>	()V
    //   34: ldc_w 487
    //   37: invokevirtual 435	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: aload 19
    //   42: invokevirtual 435	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: invokevirtual 444	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   48: invokestatic 492	com/tencent/mobileqq/utils/LogTag:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   51: fconst_0
    //   52: fstore_2
    //   53: fconst_0
    //   54: fstore 4
    //   56: fconst_0
    //   57: fstore_3
    //   58: lconst_0
    //   59: lstore 17
    //   61: aload 19
    //   63: ifnull +548 -> 611
    //   66: aload 19
    //   68: invokevirtual 495	java/lang/String:length	()I
    //   71: ifle +540 -> 611
    //   74: aload 19
    //   76: ldc_w 497
    //   79: invokevirtual 501	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   82: astore 19
    //   84: aload 19
    //   86: ifnull +525 -> 611
    //   89: aload 19
    //   91: arraylength
    //   92: iconst_5
    //   93: if_icmplt +518 -> 611
    //   96: aload 19
    //   98: iconst_0
    //   99: aaload
    //   100: invokestatic 506	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   103: invokevirtual 509	java/lang/Integer:intValue	()I
    //   106: istore 7
    //   108: aload 19
    //   110: iconst_1
    //   111: aaload
    //   112: invokestatic 506	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   115: invokevirtual 509	java/lang/Integer:intValue	()I
    //   118: istore 6
    //   120: fload 4
    //   122: fstore_3
    //   123: aload 19
    //   125: iconst_2
    //   126: aaload
    //   127: invokestatic 514	java/lang/Float:valueOf	(Ljava/lang/String;)Ljava/lang/Float;
    //   130: invokevirtual 518	java/lang/Float:floatValue	()F
    //   133: fstore_2
    //   134: fload_2
    //   135: fstore_3
    //   136: aload 19
    //   138: iconst_3
    //   139: aaload
    //   140: invokestatic 506	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   143: invokevirtual 509	java/lang/Integer:intValue	()I
    //   146: istore 5
    //   148: aload 19
    //   150: iconst_4
    //   151: aaload
    //   152: invokestatic 523	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   155: invokevirtual 526	java/lang/Long:longValue	()J
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
    //   175: invokestatic 137	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   178: ldc_w 485
    //   181: new 428	java/lang/StringBuilder
    //   184: dup
    //   185: invokespecial 429	java/lang/StringBuilder:<init>	()V
    //   188: ldc_w 528
    //   191: invokevirtual 435	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: iload 9
    //   196: invokevirtual 438	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   199: ldc_w 530
    //   202: invokevirtual 435	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: iload 8
    //   207: invokevirtual 438	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   210: ldc_w 532
    //   213: invokevirtual 435	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: iload 7
    //   218: invokevirtual 438	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   221: ldc_w 534
    //   224: invokevirtual 435	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: fload_3
    //   228: invokevirtual 537	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   231: ldc_w 539
    //   234: invokevirtual 435	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: lload 15
    //   239: invokevirtual 443	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   242: invokevirtual 444	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   245: invokestatic 492	com/tencent/mobileqq/utils/LogTag:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   248: invokestatic 544	com/tencent/mobileqq/highway/utils/VideoUpConfigInfo:isPreUpload	()Z
    //   251: istore 13
    //   253: getstatic 547	com/tencent/mobileqq/highway/utils/VideoUpConfigInfo:sIsHardCodeEnable	Z
    //   256: istore 14
    //   258: iload 8
    //   260: iconst_1
    //   261: if_icmpne +294 -> 555
    //   264: iload 14
    //   266: ifeq +289 -> 555
    //   269: iconst_1
    //   270: istore 12
    //   272: iconst_0
    //   273: invokestatic 137	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   276: ldc_w 485
    //   279: new 428	java/lang/StringBuilder
    //   282: dup
    //   283: invokespecial 429	java/lang/StringBuilder:<init>	()V
    //   286: ldc_w 549
    //   289: invokevirtual 435	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   292: iload 12
    //   294: invokevirtual 552	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   297: ldc_w 554
    //   300: invokevirtual 435	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   303: iload 8
    //   305: invokevirtual 438	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   308: ldc_w 556
    //   311: invokevirtual 435	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   314: iload 14
    //   316: invokevirtual 552	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   319: invokevirtual 444	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   322: invokestatic 492	com/tencent/mobileqq/utils/LogTag:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   325: invokestatic 559	com/tencent/mobileqq/highway/utils/VideoUpConfigInfo:getIsUpdated	()Z
    //   328: ifne +41 -> 369
    //   331: invokestatic 231	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   334: ifeq +12 -> 346
    //   337: ldc 233
    //   339: iconst_2
    //   340: ldc_w 561
    //   343: invokestatic 238	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   346: aload_0
    //   347: getfield 76	com/tencent/mobileqq/activity/recent/RecentOptPopBar:jdField_a_of_type_ComTencentMobileqqAppBaseActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   350: getfield 281	com/tencent/mobileqq/app/BaseActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   353: aload_0
    //   354: getfield 76	com/tencent/mobileqq/activity/recent/RecentOptPopBar:jdField_a_of_type_ComTencentMobileqqAppBaseActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   357: getfield 281	com/tencent/mobileqq/app/BaseActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   360: invokevirtual 562	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   363: invokestatic 568	com/tencent/mobileqq/highway/config/HwServlet:getConfig	(Lmqq/app/AppRuntime;Ljava/lang/String;)V
    //   366: invokestatic 571	com/tencent/mobileqq/highway/utils/VideoUpConfigInfo:setIsUpdated	()V
    //   369: invokestatic 572	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   372: invokestatic 576	com/tencent/mobileqq/utils/NetworkUtil:h	(Landroid/content/Context;)Z
    //   375: ifeq +192 -> 567
    //   378: iload 9
    //   380: iconst_1
    //   381: if_icmpne +180 -> 561
    //   384: iload 13
    //   386: ifeq +175 -> 561
    //   389: iconst_0
    //   390: invokestatic 137	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   393: ldc_w 485
    //   396: new 428	java/lang/StringBuilder
    //   399: dup
    //   400: invokespecial 429	java/lang/StringBuilder:<init>	()V
    //   403: ldc_w 578
    //   406: invokevirtual 435	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   409: iload 11
    //   411: invokevirtual 552	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   414: ldc_w 554
    //   417: invokevirtual 435	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   420: iload 9
    //   422: invokevirtual 438	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   425: ldc_w 556
    //   428: invokevirtual 435	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   431: iload 13
    //   433: invokevirtual 552	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   436: ldc_w 580
    //   439: invokevirtual 435	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   442: invokevirtual 444	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   445: invokestatic 492	com/tencent/mobileqq/utils/LogTag:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   448: aload_1
    //   449: ldc_w 582
    //   452: iload 11
    //   454: invokevirtual 97	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   457: pop
    //   458: aload_1
    //   459: ldc_w 584
    //   462: iload 12
    //   464: invokevirtual 97	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   467: pop
    //   468: aload_1
    //   469: ldc_w 586
    //   472: fload_3
    //   473: invokevirtual 589	android/content/Intent:putExtra	(Ljava/lang/String;F)Landroid/content/Intent;
    //   476: pop
    //   477: iload 12
    //   479: putstatic 592	com/tencent/mobileqq/shortvideo/hwcodec/HwEnvData:jdField_a_of_type_Boolean	Z
    //   482: iload 11
    //   484: putstatic 594	com/tencent/mobileqq/shortvideo/hwcodec/HwEnvData:jdField_b_of_type_Boolean	Z
    //   487: return
    //   488: astore 19
    //   490: iconst_0
    //   491: istore 6
    //   493: iconst_0
    //   494: istore 10
    //   496: iconst_0
    //   497: istore 5
    //   499: lload 17
    //   501: lstore 15
    //   503: fload_2
    //   504: fstore_3
    //   505: iload 5
    //   507: istore 7
    //   509: iload 6
    //   511: istore 8
    //   513: iload 10
    //   515: istore 9
    //   517: invokestatic 231	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   520: ifeq -346 -> 174
    //   523: ldc 233
    //   525: iconst_2
    //   526: ldc_w 596
    //   529: aload 19
    //   531: invokestatic 599	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   534: lload 17
    //   536: lstore 15
    //   538: fload_2
    //   539: fstore_3
    //   540: iload 5
    //   542: istore 7
    //   544: iload 6
    //   546: istore 8
    //   548: iload 10
    //   550: istore 9
    //   552: goto -378 -> 174
    //   555: iconst_0
    //   556: istore 12
    //   558: goto -286 -> 272
    //   561: iconst_0
    //   562: istore 11
    //   564: goto -175 -> 389
    //   567: iconst_0
    //   568: istore 11
    //   570: goto -122 -> 448
    //   573: astore 19
    //   575: iconst_0
    //   576: istore 6
    //   578: iconst_0
    //   579: istore 5
    //   581: iload 7
    //   583: istore 10
    //   585: goto -86 -> 499
    //   588: astore 19
    //   590: iconst_0
    //   591: istore 5
    //   593: fload_3
    //   594: fstore_2
    //   595: iload 7
    //   597: istore 10
    //   599: goto -100 -> 499
    //   602: astore 19
    //   604: iload 7
    //   606: istore 10
    //   608: goto -109 -> 499
    //   611: iconst_0
    //   612: istore 7
    //   614: iconst_0
    //   615: istore 8
    //   617: iconst_0
    //   618: istore 9
    //   620: lload 17
    //   622: lstore 15
    //   624: goto -450 -> 174
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	627	0	this	RecentOptPopBar
    //   0	627	1	paramIntent	Intent
    //   52	543	2	f1	float
    //   57	537	3	f2	float
    //   54	67	4	f3	float
    //   146	446	5	m	int
    //   118	459	6	n	int
    //   106	507	7	i1	int
    //   166	450	8	i2	int
    //   162	457	9	i3	int
    //   494	113	10	i4	int
    //   1	568	11	bool1	boolean
    //   270	287	12	bool2	boolean
    //   251	181	13	bool3	boolean
    //   256	59	14	bool4	boolean
    //   158	465	15	l1	long
    //   59	562	17	l2	long
    //   18	131	19	localObject	Object
    //   488	42	19	localNumberFormatException1	java.lang.NumberFormatException
    //   573	1	19	localNumberFormatException2	java.lang.NumberFormatException
    //   588	1	19	localNumberFormatException3	java.lang.NumberFormatException
    //   602	1	19	localNumberFormatException4	java.lang.NumberFormatException
    // Exception table:
    //   from	to	target	type
    //   96	108	488	java/lang/NumberFormatException
    //   108	120	573	java/lang/NumberFormatException
    //   123	134	588	java/lang/NumberFormatException
    //   136	148	588	java/lang/NumberFormatException
    //   148	160	602	java/lang/NumberFormatException
  }
  
  /* Error */
  public void a(View paramView, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 5
    //   3: iconst_1
    //   4: istore 4
    //   6: aload_0
    //   7: getfield 410	com/tencent/mobileqq/activity/recent/RecentOptPopBar:jdField_a_of_type_ComTencentWidgetPopupMenuDialog	Lcom/tencent/widget/PopupMenuDialog;
    //   10: ifnull +18 -> 28
    //   13: aload_0
    //   14: getfield 410	com/tencent/mobileqq/activity/recent/RecentOptPopBar:jdField_a_of_type_ComTencentWidgetPopupMenuDialog	Lcom/tencent/widget/PopupMenuDialog;
    //   17: getfield 601	com/tencent/widget/PopupMenuDialog:jdField_a_of_type_Boolean	Z
    //   20: ifeq +8 -> 28
    //   23: aload_0
    //   24: aconst_null
    //   25: putfield 410	com/tencent/mobileqq/activity/recent/RecentOptPopBar:jdField_a_of_type_ComTencentWidgetPopupMenuDialog	Lcom/tencent/widget/PopupMenuDialog;
    //   28: aload_0
    //   29: getfield 410	com/tencent/mobileqq/activity/recent/RecentOptPopBar:jdField_a_of_type_ComTencentWidgetPopupMenuDialog	Lcom/tencent/widget/PopupMenuDialog;
    //   32: ifnonnull +146 -> 178
    //   35: aload_0
    //   36: invokevirtual 603	com/tencent/mobileqq/activity/recent/RecentOptPopBar:a	()V
    //   39: aload_0
    //   40: getfield 76	com/tencent/mobileqq/activity/recent/RecentOptPopBar:jdField_a_of_type_ComTencentMobileqqAppBaseActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   43: invokevirtual 607	com/tencent/mobileqq/app/BaseActivity:getAppInterface	()Lcom/tencent/common/app/AppInterface;
    //   46: aload_1
    //   47: aload_0
    //   48: getfield 410	com/tencent/mobileqq/activity/recent/RecentOptPopBar:jdField_a_of_type_ComTencentWidgetPopupMenuDialog	Lcom/tencent/widget/PopupMenuDialog;
    //   51: iload_3
    //   52: invokestatic 612	com/tencent/mobileqq/ar/config/WorldCup:a	(Lcom/tencent/common/app/AppInterface;Landroid/view/View;Lcom/tencent/widget/PopupMenuDialog;I)I
    //   55: istore_3
    //   56: aload_0
    //   57: getfield 410	com/tencent/mobileqq/activity/recent/RecentOptPopBar:jdField_a_of_type_ComTencentWidgetPopupMenuDialog	Lcom/tencent/widget/PopupMenuDialog;
    //   60: aload_1
    //   61: iload_2
    //   62: iload_3
    //   63: invokevirtual 615	com/tencent/widget/PopupMenuDialog:showAsDropDown	(Landroid/view/View;II)V
    //   66: aload_0
    //   67: getfield 617	com/tencent/mobileqq/activity/recent/RecentOptPopBar:jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch	Lcom/tencent/mobileqq/redtouch/RedTouch;
    //   70: ifnull +10 -> 80
    //   73: aload_0
    //   74: getfield 619	com/tencent/mobileqq/activity/recent/RecentOptPopBar:jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch	Lcom/tencent/mobileqq/redtouch/RedTouch;
    //   77: ifnonnull +568 -> 645
    //   80: aload_0
    //   81: getfield 410	com/tencent/mobileqq/activity/recent/RecentOptPopBar:jdField_a_of_type_ComTencentWidgetPopupMenuDialog	Lcom/tencent/widget/PopupMenuDialog;
    //   84: invokevirtual 623	com/tencent/widget/PopupMenuDialog:getContentView	()Landroid/view/View;
    //   87: ldc_w 624
    //   90: invokevirtual 630	android/view/View:findViewById	(I)Landroid/view/View;
    //   93: checkcast 632	android/widget/LinearLayout
    //   96: astore_1
    //   97: iconst_0
    //   98: istore_2
    //   99: iload_2
    //   100: aload_1
    //   101: invokevirtual 635	android/widget/LinearLayout:getChildCount	()I
    //   104: if_icmpge +541 -> 645
    //   107: aload_1
    //   108: iload_2
    //   109: invokevirtual 638	android/widget/LinearLayout:getChildAt	(I)Landroid/view/View;
    //   112: astore 11
    //   114: aload 11
    //   116: invokevirtual 642	android/view/View:getTag	()Ljava/lang/Object;
    //   119: checkcast 349	com/tencent/widget/PopupMenuDialog$MenuItem
    //   122: checkcast 349	com/tencent/widget/PopupMenuDialog$MenuItem
    //   125: getfield 353	com/tencent/widget/PopupMenuDialog$MenuItem:jdField_a_of_type_Int	I
    //   128: ldc 32
    //   130: if_icmpne +286 -> 416
    //   133: aload 11
    //   135: ldc_w 643
    //   138: invokevirtual 630	android/view/View:findViewById	(I)Landroid/view/View;
    //   141: checkcast 645	android/widget/TextView
    //   144: astore 11
    //   146: aload_0
    //   147: new 647	com/tencent/mobileqq/redtouch/RedTouch
    //   150: dup
    //   151: aload_0
    //   152: getfield 76	com/tencent/mobileqq/activity/recent/RecentOptPopBar:jdField_a_of_type_ComTencentMobileqqAppBaseActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   155: aload 11
    //   157: invokespecial 650	com/tencent/mobileqq/redtouch/RedTouch:<init>	(Landroid/content/Context;Landroid/view/View;)V
    //   160: bipush 21
    //   162: invokevirtual 653	com/tencent/mobileqq/redtouch/RedTouch:a	(I)Lcom/tencent/mobileqq/redtouch/RedTouch;
    //   165: invokevirtual 656	com/tencent/mobileqq/redtouch/RedTouch:a	()Lcom/tencent/mobileqq/redtouch/RedTouch;
    //   168: putfield 617	com/tencent/mobileqq/activity/recent/RecentOptPopBar:jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch	Lcom/tencent/mobileqq/redtouch/RedTouch;
    //   171: iload_2
    //   172: iconst_1
    //   173: iadd
    //   174: istore_2
    //   175: goto -76 -> 99
    //   178: aload_0
    //   179: getfield 375	com/tencent/mobileqq/activity/recent/RecentOptPopBar:jdField_c_of_type_Boolean	Z
    //   182: ifeq +20 -> 202
    //   185: aload_0
    //   186: getfield 76	com/tencent/mobileqq/activity/recent/RecentOptPopBar:jdField_a_of_type_ComTencentMobileqqAppBaseActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   189: invokevirtual 378	com/tencent/mobileqq/app/BaseActivity:getCurrentAccountUin	()Ljava/lang/String;
    //   192: ldc_w 380
    //   195: iconst_0
    //   196: invokestatic 385	com/tencent/mobileqq/activity/qwallet/QWalletSetting:a	(Ljava/lang/String;Ljava/lang/String;Z)Z
    //   199: ifeq +27 -> 226
    //   202: aload_0
    //   203: getfield 375	com/tencent/mobileqq/activity/recent/RecentOptPopBar:jdField_c_of_type_Boolean	Z
    //   206: ifne +34 -> 240
    //   209: aload_0
    //   210: getfield 76	com/tencent/mobileqq/activity/recent/RecentOptPopBar:jdField_a_of_type_ComTencentMobileqqAppBaseActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   213: invokevirtual 378	com/tencent/mobileqq/app/BaseActivity:getCurrentAccountUin	()Ljava/lang/String;
    //   216: ldc_w 380
    //   219: iconst_0
    //   220: invokestatic 385	com/tencent/mobileqq/activity/qwallet/QWalletSetting:a	(Ljava/lang/String;Ljava/lang/String;Z)Z
    //   223: ifeq +17 -> 240
    //   226: aload_0
    //   227: invokevirtual 603	com/tencent/mobileqq/activity/recent/RecentOptPopBar:a	()V
    //   230: aload_0
    //   231: aconst_null
    //   232: putfield 617	com/tencent/mobileqq/activity/recent/RecentOptPopBar:jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch	Lcom/tencent/mobileqq/redtouch/RedTouch;
    //   235: aload_0
    //   236: aconst_null
    //   237: putfield 619	com/tencent/mobileqq/activity/recent/RecentOptPopBar:jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch	Lcom/tencent/mobileqq/redtouch/RedTouch;
    //   240: aload_0
    //   241: getfield 76	com/tencent/mobileqq/activity/recent/RecentOptPopBar:jdField_a_of_type_ComTencentMobileqqAppBaseActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   244: invokevirtual 378	com/tencent/mobileqq/app/BaseActivity:getCurrentAccountUin	()Ljava/lang/String;
    //   247: invokestatic 659	com/tencent/mobileqq/activity/qwallet/QWalletSetting:a	(Ljava/lang/String;)Z
    //   250: ifeq +119 -> 369
    //   253: aload_0
    //   254: getfield 661	com/tencent/mobileqq/activity/recent/RecentOptPopBar:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   257: ifnull +23 -> 280
    //   260: aload_0
    //   261: getfield 661	com/tencent/mobileqq/activity/recent/RecentOptPopBar:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   264: aload_0
    //   265: getfield 661	com/tencent/mobileqq/activity/recent/RecentOptPopBar:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   268: invokevirtual 662	android/widget/TextView:getResources	()Landroid/content/res/Resources;
    //   271: ldc_w 663
    //   274: invokevirtual 666	android/content/res/Resources:getColor	(I)I
    //   277: invokevirtual 669	android/widget/TextView:setTextColor	(I)V
    //   280: aload_0
    //   281: getfield 671	com/tencent/mobileqq/activity/recent/RecentOptPopBar:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   284: ifnull +12 -> 296
    //   287: aload_0
    //   288: getfield 671	com/tencent/mobileqq/activity/recent/RecentOptPopBar:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   291: ldc 57
    //   293: invokevirtual 676	android/widget/ImageView:setImageResource	(I)V
    //   296: aload_0
    //   297: getfield 677	com/tencent/mobileqq/activity/recent/RecentOptPopBar:jdField_b_of_type_Boolean	Z
    //   300: ifeq +16 -> 316
    //   303: aload_0
    //   304: getfield 76	com/tencent/mobileqq/activity/recent/RecentOptPopBar:jdField_a_of_type_ComTencentMobileqqAppBaseActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   307: getfield 281	com/tencent/mobileqq/app/BaseActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   310: invokestatic 679	com/tencent/mobileqq/shortvideo/util/RecentDanceConfigMgr:a	(Lcom/tencent/common/app/AppInterface;)Z
    //   313: ifeq +49 -> 362
    //   316: aload_0
    //   317: getfield 677	com/tencent/mobileqq/activity/recent/RecentOptPopBar:jdField_b_of_type_Boolean	Z
    //   320: ifne +16 -> 336
    //   323: aload_0
    //   324: getfield 76	com/tencent/mobileqq/activity/recent/RecentOptPopBar:jdField_a_of_type_ComTencentMobileqqAppBaseActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   327: getfield 281	com/tencent/mobileqq/app/BaseActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   330: invokestatic 679	com/tencent/mobileqq/shortvideo/util/RecentDanceConfigMgr:a	(Lcom/tencent/common/app/AppInterface;)Z
    //   333: ifne +29 -> 362
    //   336: aload_0
    //   337: getfield 677	com/tencent/mobileqq/activity/recent/RecentOptPopBar:jdField_b_of_type_Boolean	Z
    //   340: ifeq -301 -> 39
    //   343: aload_0
    //   344: getfield 76	com/tencent/mobileqq/activity/recent/RecentOptPopBar:jdField_a_of_type_ComTencentMobileqqAppBaseActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   347: getfield 281	com/tencent/mobileqq/app/BaseActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   350: invokestatic 679	com/tencent/mobileqq/shortvideo/util/RecentDanceConfigMgr:a	(Lcom/tencent/common/app/AppInterface;)Z
    //   353: ifeq -314 -> 39
    //   356: invokestatic 681	com/tencent/mobileqq/shortvideo/util/RecentDanceConfigMgr:a	()Z
    //   359: ifeq -320 -> 39
    //   362: aload_0
    //   363: invokevirtual 603	com/tencent/mobileqq/activity/recent/RecentOptPopBar:a	()V
    //   366: goto -327 -> 39
    //   369: aload_0
    //   370: getfield 661	com/tencent/mobileqq/activity/recent/RecentOptPopBar:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   373: ifnull +23 -> 396
    //   376: aload_0
    //   377: getfield 661	com/tencent/mobileqq/activity/recent/RecentOptPopBar:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   380: aload_0
    //   381: getfield 661	com/tencent/mobileqq/activity/recent/RecentOptPopBar:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   384: invokevirtual 662	android/widget/TextView:getResources	()Landroid/content/res/Resources;
    //   387: ldc_w 682
    //   390: invokevirtual 666	android/content/res/Resources:getColor	(I)I
    //   393: invokevirtual 669	android/widget/TextView:setTextColor	(I)V
    //   396: aload_0
    //   397: getfield 671	com/tencent/mobileqq/activity/recent/RecentOptPopBar:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   400: ifnull -104 -> 296
    //   403: aload_0
    //   404: getfield 671	com/tencent/mobileqq/activity/recent/RecentOptPopBar:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   407: ldc_w 683
    //   410: invokevirtual 676	android/widget/ImageView:setImageResource	(I)V
    //   413: goto -117 -> 296
    //   416: aload 11
    //   418: invokevirtual 642	android/view/View:getTag	()Ljava/lang/Object;
    //   421: checkcast 349	com/tencent/widget/PopupMenuDialog$MenuItem
    //   424: checkcast 349	com/tencent/widget/PopupMenuDialog$MenuItem
    //   427: getfield 353	com/tencent/widget/PopupMenuDialog$MenuItem:jdField_a_of_type_Int	I
    //   430: ldc 48
    //   432: if_icmpne +51 -> 483
    //   435: aload 11
    //   437: ldc_w 684
    //   440: invokevirtual 630	android/view/View:findViewById	(I)Landroid/view/View;
    //   443: astore 11
    //   445: aload_0
    //   446: new 647	com/tencent/mobileqq/redtouch/RedTouch
    //   449: dup
    //   450: aload_0
    //   451: getfield 76	com/tencent/mobileqq/activity/recent/RecentOptPopBar:jdField_a_of_type_ComTencentMobileqqAppBaseActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   454: aload 11
    //   456: invokespecial 650	com/tencent/mobileqq/redtouch/RedTouch:<init>	(Landroid/content/Context;Landroid/view/View;)V
    //   459: bipush 53
    //   461: invokevirtual 653	com/tencent/mobileqq/redtouch/RedTouch:a	(I)Lcom/tencent/mobileqq/redtouch/RedTouch;
    //   464: invokevirtual 656	com/tencent/mobileqq/redtouch/RedTouch:a	()Lcom/tencent/mobileqq/redtouch/RedTouch;
    //   467: putfield 619	com/tencent/mobileqq/activity/recent/RecentOptPopBar:jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch	Lcom/tencent/mobileqq/redtouch/RedTouch;
    //   470: goto -299 -> 171
    //   473: astore 11
    //   475: aload 11
    //   477: invokevirtual 687	java/lang/Exception:printStackTrace	()V
    //   480: goto -309 -> 171
    //   483: aload 11
    //   485: invokevirtual 642	android/view/View:getTag	()Ljava/lang/Object;
    //   488: checkcast 349	com/tencent/widget/PopupMenuDialog$MenuItem
    //   491: checkcast 349	com/tencent/widget/PopupMenuDialog$MenuItem
    //   494: getfield 353	com/tencent/widget/PopupMenuDialog$MenuItem:jdField_a_of_type_Int	I
    //   497: ldc 56
    //   499: if_icmpne -328 -> 171
    //   502: aload_0
    //   503: aload 11
    //   505: ldc_w 643
    //   508: invokevirtual 630	android/view/View:findViewById	(I)Landroid/view/View;
    //   511: checkcast 645	android/widget/TextView
    //   514: putfield 661	com/tencent/mobileqq/activity/recent/RecentOptPopBar:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   517: aload_0
    //   518: aload 11
    //   520: ldc_w 684
    //   523: invokevirtual 630	android/view/View:findViewById	(I)Landroid/view/View;
    //   526: checkcast 673	android/widget/ImageView
    //   529: putfield 671	com/tencent/mobileqq/activity/recent/RecentOptPopBar:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   532: aload_0
    //   533: getfield 76	com/tencent/mobileqq/activity/recent/RecentOptPopBar:jdField_a_of_type_ComTencentMobileqqAppBaseActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   536: invokevirtual 378	com/tencent/mobileqq/app/BaseActivity:getCurrentAccountUin	()Ljava/lang/String;
    //   539: invokestatic 659	com/tencent/mobileqq/activity/qwallet/QWalletSetting:a	(Ljava/lang/String;)Z
    //   542: ifeq +70 -> 612
    //   545: aload_0
    //   546: getfield 661	com/tencent/mobileqq/activity/recent/RecentOptPopBar:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   549: aload_0
    //   550: getfield 661	com/tencent/mobileqq/activity/recent/RecentOptPopBar:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   553: invokevirtual 662	android/widget/TextView:getResources	()Landroid/content/res/Resources;
    //   556: ldc_w 663
    //   559: invokevirtual 666	android/content/res/Resources:getColor	(I)I
    //   562: invokevirtual 669	android/widget/TextView:setTextColor	(I)V
    //   565: aload_0
    //   566: getfield 671	com/tencent/mobileqq/activity/recent/RecentOptPopBar:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   569: ldc 57
    //   571: invokevirtual 676	android/widget/ImageView:setImageResource	(I)V
    //   574: aload_0
    //   575: new 647	com/tencent/mobileqq/redtouch/RedTouch
    //   578: dup
    //   579: aload_0
    //   580: getfield 76	com/tencent/mobileqq/activity/recent/RecentOptPopBar:jdField_a_of_type_ComTencentMobileqqAppBaseActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   583: aload_0
    //   584: getfield 671	com/tencent/mobileqq/activity/recent/RecentOptPopBar:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   587: invokespecial 650	com/tencent/mobileqq/redtouch/RedTouch:<init>	(Landroid/content/Context;Landroid/view/View;)V
    //   590: bipush 53
    //   592: invokevirtual 653	com/tencent/mobileqq/redtouch/RedTouch:a	(I)Lcom/tencent/mobileqq/redtouch/RedTouch;
    //   595: invokevirtual 656	com/tencent/mobileqq/redtouch/RedTouch:a	()Lcom/tencent/mobileqq/redtouch/RedTouch;
    //   598: putfield 689	com/tencent/mobileqq/activity/recent/RecentOptPopBar:jdField_c_of_type_ComTencentMobileqqRedtouchRedTouch	Lcom/tencent/mobileqq/redtouch/RedTouch;
    //   601: aload_0
    //   602: ldc_w 691
    //   605: iconst_1
    //   606: invokevirtual 693	com/tencent/mobileqq/activity/recent/RecentOptPopBar:a	(Ljava/lang/String;Z)V
    //   609: goto -438 -> 171
    //   612: aload_0
    //   613: getfield 661	com/tencent/mobileqq/activity/recent/RecentOptPopBar:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   616: aload_0
    //   617: getfield 661	com/tencent/mobileqq/activity/recent/RecentOptPopBar:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   620: invokevirtual 662	android/widget/TextView:getResources	()Landroid/content/res/Resources;
    //   623: ldc_w 682
    //   626: invokevirtual 666	android/content/res/Resources:getColor	(I)I
    //   629: invokevirtual 669	android/widget/TextView:setTextColor	(I)V
    //   632: aload_0
    //   633: getfield 671	com/tencent/mobileqq/activity/recent/RecentOptPopBar:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   636: ldc_w 683
    //   639: invokevirtual 676	android/widget/ImageView:setImageResource	(I)V
    //   642: goto -68 -> 574
    //   645: aload_0
    //   646: getfield 677	com/tencent/mobileqq/activity/recent/RecentOptPopBar:jdField_b_of_type_Boolean	Z
    //   649: ifeq +129 -> 778
    //   652: aload_0
    //   653: getfield 695	com/tencent/mobileqq/activity/recent/RecentOptPopBar:jdField_d_of_type_ComTencentMobileqqRedtouchRedTouch	Lcom/tencent/mobileqq/redtouch/RedTouch;
    //   656: ifnonnull +127 -> 783
    //   659: aload_0
    //   660: getfield 76	com/tencent/mobileqq/activity/recent/RecentOptPopBar:jdField_a_of_type_ComTencentMobileqqAppBaseActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   663: getfield 281	com/tencent/mobileqq/app/BaseActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   666: aconst_null
    //   667: invokestatic 698	com/tencent/mobileqq/shortvideo/util/RecentDanceConfigMgr:a	(Lcom/tencent/common/app/AppInterface;[I)Z
    //   670: ifeq +113 -> 783
    //   673: aload_0
    //   674: getfield 410	com/tencent/mobileqq/activity/recent/RecentOptPopBar:jdField_a_of_type_ComTencentWidgetPopupMenuDialog	Lcom/tencent/widget/PopupMenuDialog;
    //   677: invokevirtual 623	com/tencent/widget/PopupMenuDialog:getContentView	()Landroid/view/View;
    //   680: ldc_w 624
    //   683: invokevirtual 630	android/view/View:findViewById	(I)Landroid/view/View;
    //   686: checkcast 632	android/widget/LinearLayout
    //   689: astore_1
    //   690: iconst_0
    //   691: istore_2
    //   692: iload_2
    //   693: aload_1
    //   694: invokevirtual 635	android/widget/LinearLayout:getChildCount	()I
    //   697: if_icmpge +86 -> 783
    //   700: aload_1
    //   701: iload_2
    //   702: invokevirtual 638	android/widget/LinearLayout:getChildAt	(I)Landroid/view/View;
    //   705: astore 11
    //   707: aload 11
    //   709: invokevirtual 642	android/view/View:getTag	()Ljava/lang/Object;
    //   712: checkcast 349	com/tencent/widget/PopupMenuDialog$MenuItem
    //   715: checkcast 349	com/tencent/widget/PopupMenuDialog$MenuItem
    //   718: getfield 353	com/tencent/widget/PopupMenuDialog$MenuItem:jdField_a_of_type_Int	I
    //   721: ldc 60
    //   723: if_icmpne +38 -> 761
    //   726: aload 11
    //   728: ldc_w 684
    //   731: invokevirtual 630	android/view/View:findViewById	(I)Landroid/view/View;
    //   734: astore 11
    //   736: aload_0
    //   737: new 647	com/tencent/mobileqq/redtouch/RedTouch
    //   740: dup
    //   741: aload_0
    //   742: getfield 76	com/tencent/mobileqq/activity/recent/RecentOptPopBar:jdField_a_of_type_ComTencentMobileqqAppBaseActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   745: aload 11
    //   747: invokespecial 650	com/tencent/mobileqq/redtouch/RedTouch:<init>	(Landroid/content/Context;Landroid/view/View;)V
    //   750: bipush 53
    //   752: invokevirtual 653	com/tencent/mobileqq/redtouch/RedTouch:a	(I)Lcom/tencent/mobileqq/redtouch/RedTouch;
    //   755: invokevirtual 656	com/tencent/mobileqq/redtouch/RedTouch:a	()Lcom/tencent/mobileqq/redtouch/RedTouch;
    //   758: putfield 695	com/tencent/mobileqq/activity/recent/RecentOptPopBar:jdField_d_of_type_ComTencentMobileqqRedtouchRedTouch	Lcom/tencent/mobileqq/redtouch/RedTouch;
    //   761: iload_2
    //   762: iconst_1
    //   763: iadd
    //   764: istore_2
    //   765: goto -73 -> 692
    //   768: astore 11
    //   770: aload 11
    //   772: invokevirtual 687	java/lang/Exception:printStackTrace	()V
    //   775: goto -14 -> 761
    //   778: aload_0
    //   779: aconst_null
    //   780: putfield 695	com/tencent/mobileqq/activity/recent/RecentOptPopBar:jdField_d_of_type_ComTencentMobileqqRedtouchRedTouch	Lcom/tencent/mobileqq/redtouch/RedTouch;
    //   783: aload_0
    //   784: getfield 695	com/tencent/mobileqq/activity/recent/RecentOptPopBar:jdField_d_of_type_ComTencentMobileqqRedtouchRedTouch	Lcom/tencent/mobileqq/redtouch/RedTouch;
    //   787: ifnull +41 -> 828
    //   790: aload_0
    //   791: getfield 76	com/tencent/mobileqq/activity/recent/RecentOptPopBar:jdField_a_of_type_ComTencentMobileqqAppBaseActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   794: getfield 281	com/tencent/mobileqq/app/BaseActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   797: aconst_null
    //   798: invokestatic 698	com/tencent/mobileqq/shortvideo/util/RecentDanceConfigMgr:a	(Lcom/tencent/common/app/AppInterface;[I)Z
    //   801: ifeq +338 -> 1139
    //   804: new 700	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedTypeInfo
    //   807: dup
    //   808: invokespecial 701	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedTypeInfo:<init>	()V
    //   811: astore_1
    //   812: aload_1
    //   813: getfield 705	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedTypeInfo:red_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   816: iconst_0
    //   817: invokevirtual 710	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   820: aload_0
    //   821: getfield 695	com/tencent/mobileqq/activity/recent/RecentOptPopBar:jdField_d_of_type_ComTencentMobileqqRedtouchRedTouch	Lcom/tencent/mobileqq/redtouch/RedTouch;
    //   824: aload_1
    //   825: invokevirtual 713	com/tencent/mobileqq/redtouch/RedTouch:a	(Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedTypeInfo;)V
    //   828: aload_0
    //   829: getfield 617	com/tencent/mobileqq/activity/recent/RecentOptPopBar:jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch	Lcom/tencent/mobileqq/redtouch/RedTouch;
    //   832: ifnull +33 -> 865
    //   835: aload_0
    //   836: getfield 76	com/tencent/mobileqq/activity/recent/RecentOptPopBar:jdField_a_of_type_ComTencentMobileqqAppBaseActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   839: getfield 281	com/tencent/mobileqq/app/BaseActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   842: bipush 35
    //   844: invokevirtual 717	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   847: checkcast 719	com/tencent/mobileqq/redtouch/RedTouchManager
    //   850: ldc_w 721
    //   853: invokevirtual 724	com/tencent/mobileqq/redtouch/RedTouchManager:a	(Ljava/lang/String;)Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   856: astore_1
    //   857: aload_0
    //   858: getfield 617	com/tencent/mobileqq/activity/recent/RecentOptPopBar:jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch	Lcom/tencent/mobileqq/redtouch/RedTouch;
    //   861: aload_1
    //   862: invokevirtual 727	com/tencent/mobileqq/redtouch/RedTouch:a	(Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;)V
    //   865: aload_0
    //   866: getfield 619	com/tencent/mobileqq/activity/recent/RecentOptPopBar:jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch	Lcom/tencent/mobileqq/redtouch/RedTouch;
    //   869: ifnull +3 -> 872
    //   872: aload_0
    //   873: getfield 619	com/tencent/mobileqq/activity/recent/RecentOptPopBar:jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch	Lcom/tencent/mobileqq/redtouch/RedTouch;
    //   876: ifnull +46 -> 922
    //   879: getstatic 731	com/tencent/mobileqq/shortvideo/redbag/RedBagVideoManager:g	Ljava/lang/String;
    //   882: invokestatic 732	com/tencent/mobileqq/shortvideo/redbag/RedBagVideoManager:a	(Ljava/lang/String;)Z
    //   885: ifne +271 -> 1156
    //   888: iconst_1
    //   889: istore 6
    //   891: aload_0
    //   892: iload 6
    //   894: putfield 733	com/tencent/mobileqq/activity/recent/RecentOptPopBar:jdField_a_of_type_Boolean	Z
    //   897: aload_0
    //   898: getfield 733	com/tencent/mobileqq/activity/recent/RecentOptPopBar:jdField_a_of_type_Boolean	Z
    //   901: aload_0
    //   902: getfield 619	com/tencent/mobileqq/activity/recent/RecentOptPopBar:jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch	Lcom/tencent/mobileqq/redtouch/RedTouch;
    //   905: getfield 735	com/tencent/mobileqq/redtouch/RedTouch:g	Z
    //   908: if_icmpeq +14 -> 922
    //   911: aload_0
    //   912: getfield 619	com/tencent/mobileqq/activity/recent/RecentOptPopBar:jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch	Lcom/tencent/mobileqq/redtouch/RedTouch;
    //   915: aload_0
    //   916: getfield 733	com/tencent/mobileqq/activity/recent/RecentOptPopBar:jdField_a_of_type_Boolean	Z
    //   919: invokevirtual 737	com/tencent/mobileqq/redtouch/RedTouch:a	(Z)V
    //   922: aload_0
    //   923: getfield 689	com/tencent/mobileqq/activity/recent/RecentOptPopBar:jdField_c_of_type_ComTencentMobileqqRedtouchRedTouch	Lcom/tencent/mobileqq/redtouch/RedTouch;
    //   926: ifnull +38 -> 964
    //   929: aload_0
    //   930: ldc_w 739
    //   933: iconst_1
    //   934: invokevirtual 741	com/tencent/mobileqq/activity/recent/RecentOptPopBar:a	(Ljava/lang/String;Z)Z
    //   937: ifeq +225 -> 1162
    //   940: new 700	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedTypeInfo
    //   943: dup
    //   944: invokespecial 701	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedTypeInfo:<init>	()V
    //   947: astore_1
    //   948: aload_1
    //   949: getfield 705	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedTypeInfo:red_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   952: iconst_0
    //   953: invokevirtual 710	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   956: aload_0
    //   957: getfield 689	com/tencent/mobileqq/activity/recent/RecentOptPopBar:jdField_c_of_type_ComTencentMobileqqRedtouchRedTouch	Lcom/tencent/mobileqq/redtouch/RedTouch;
    //   960: aload_1
    //   961: invokevirtual 713	com/tencent/mobileqq/redtouch/RedTouch:a	(Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedTypeInfo;)V
    //   964: invokestatic 745	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   967: ldc_w 747
    //   970: iconst_4
    //   971: invokevirtual 751	com/tencent/common/app/BaseApplicationImpl:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   974: astore_1
    //   975: iload 4
    //   977: istore_2
    //   978: aload_1
    //   979: ifnull +107 -> 1086
    //   982: iload 4
    //   984: istore_2
    //   985: aload_1
    //   986: ldc_w 753
    //   989: iconst_1
    //   990: invokeinterface 758 3 0
    //   995: ifne +91 -> 1086
    //   998: aload_1
    //   999: ldc_w 760
    //   1002: lconst_0
    //   1003: invokeinterface 764 4 0
    //   1008: lstore 7
    //   1010: aload_1
    //   1011: ldc_w 766
    //   1014: ldc_w 767
    //   1017: invokeinterface 771 3 0
    //   1022: istore_2
    //   1023: invokestatic 116	java/lang/System:currentTimeMillis	()J
    //   1026: lstore 9
    //   1028: lload 7
    //   1030: lconst_0
    //   1031: lcmp
    //   1032: ifle +147 -> 1179
    //   1035: iload_2
    //   1036: ifle +143 -> 1179
    //   1039: lload 9
    //   1041: lload 7
    //   1043: lcmp
    //   1044: ifle +135 -> 1179
    //   1047: lload 9
    //   1049: lload 7
    //   1051: lsub
    //   1052: iload_2
    //   1053: sipush 1000
    //   1056: imul
    //   1057: i2l
    //   1058: lcmp
    //   1059: ifle +120 -> 1179
    //   1062: aload_1
    //   1063: invokeinterface 775 1 0
    //   1068: ldc_w 753
    //   1071: iconst_1
    //   1072: invokeinterface 780 3 0
    //   1077: invokeinterface 783 1 0
    //   1082: pop
    //   1083: iload 4
    //   1085: istore_2
    //   1086: iload_2
    //   1087: ifeq +46 -> 1133
    //   1090: getstatic 788	cooperation/peak/PeakUtils:a	Lcom/tencent/mobileqq/hitrate/PreloadProcHitSession;
    //   1093: ifnonnull +25 -> 1118
    //   1096: new 790	com/tencent/mobileqq/hitrate/PreloadProcHitSession
    //   1099: dup
    //   1100: ldc_w 792
    //   1103: ldc_w 794
    //   1106: invokespecial 796	com/tencent/mobileqq/hitrate/PreloadProcHitSession:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   1109: putstatic 788	cooperation/peak/PeakUtils:a	Lcom/tencent/mobileqq/hitrate/PreloadProcHitSession;
    //   1112: getstatic 788	cooperation/peak/PeakUtils:a	Lcom/tencent/mobileqq/hitrate/PreloadProcHitSession;
    //   1115: invokevirtual 797	com/tencent/mobileqq/hitrate/PreloadProcHitSession:a	()V
    //   1118: invokestatic 803	com/tencent/mobileqq/app/ThreadManager:getSubThreadHandler	()Lmqq/os/MqqHandler;
    //   1121: new 805	xkt
    //   1124: dup
    //   1125: aload_0
    //   1126: invokespecial 806	xkt:<init>	(Lcom/tencent/mobileqq/activity/recent/RecentOptPopBar;)V
    //   1129: invokevirtual 812	mqq/os/MqqHandler:post	(Ljava/lang/Runnable;)Z
    //   1132: pop
    //   1133: aload_0
    //   1134: invokevirtual 814	com/tencent/mobileqq/activity/recent/RecentOptPopBar:b	()Z
    //   1137: pop
    //   1138: return
    //   1139: aload_0
    //   1140: getfield 695	com/tencent/mobileqq/activity/recent/RecentOptPopBar:jdField_d_of_type_ComTencentMobileqqRedtouchRedTouch	Lcom/tencent/mobileqq/redtouch/RedTouch;
    //   1143: new 816	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo
    //   1146: dup
    //   1147: invokespecial 817	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:<init>	()V
    //   1150: invokevirtual 727	com/tencent/mobileqq/redtouch/RedTouch:a	(Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;)V
    //   1153: goto -325 -> 828
    //   1156: iconst_0
    //   1157: istore 6
    //   1159: goto -268 -> 891
    //   1162: aload_0
    //   1163: getfield 689	com/tencent/mobileqq/activity/recent/RecentOptPopBar:jdField_c_of_type_ComTencentMobileqqRedtouchRedTouch	Lcom/tencent/mobileqq/redtouch/RedTouch;
    //   1166: new 816	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo
    //   1169: dup
    //   1170: invokespecial 817	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:<init>	()V
    //   1173: invokevirtual 727	com/tencent/mobileqq/redtouch/RedTouch:a	(Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;)V
    //   1176: goto -212 -> 964
    //   1179: ldc 233
    //   1181: iconst_1
    //   1182: ldc_w 819
    //   1185: invokestatic 238	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1188: invokestatic 201	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1191: invokestatic 824	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   1194: aload_0
    //   1195: getfield 76	com/tencent/mobileqq/activity/recent/RecentOptPopBar:jdField_a_of_type_ComTencentMobileqqAppBaseActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   1198: invokevirtual 607	com/tencent/mobileqq/app/BaseActivity:getAppInterface	()Lcom/tencent/common/app/AppInterface;
    //   1201: invokevirtual 827	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1204: ldc_w 829
    //   1207: iconst_1
    //   1208: lconst_0
    //   1209: lconst_0
    //   1210: aconst_null
    //   1211: ldc_w 391
    //   1214: invokevirtual 832	com/tencent/mobileqq/statistics/StatisticCollector:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   1217: iconst_0
    //   1218: istore_2
    //   1219: goto -133 -> 1086
    //   1222: astore_1
    //   1223: iload 5
    //   1225: istore_2
    //   1226: aload_1
    //   1227: invokevirtual 687	java/lang/Exception:printStackTrace	()V
    //   1230: goto -144 -> 1086
    //   1233: astore_1
    //   1234: iconst_0
    //   1235: istore_2
    //   1236: goto -10 -> 1226
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1239	0	this	RecentOptPopBar
    //   0	1239	1	paramView	View
    //   0	1239	2	paramInt1	int
    //   0	1239	3	paramInt2	int
    //   4	1080	4	m	int
    //   1	1223	5	n	int
    //   889	269	6	bool	boolean
    //   1008	42	7	l1	long
    //   1026	22	9	l2	long
    //   112	343	11	localObject	Object
    //   473	46	11	localException1	Exception
    //   705	41	11	localView	View
    //   768	3	11	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   107	171	473	java/lang/Exception
    //   416	470	473	java/lang/Exception
    //   483	574	473	java/lang/Exception
    //   574	609	473	java/lang/Exception
    //   612	642	473	java/lang/Exception
    //   700	761	768	java/lang/Exception
    //   964	975	1222	java/lang/Exception
    //   985	1028	1222	java/lang/Exception
    //   1062	1083	1222	java/lang/Exception
    //   1179	1188	1222	java/lang/Exception
    //   1188	1217	1233	java/lang/Exception
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
        localObject2 = PlusPanelUtils.a(AppConstants.aV);
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
              break label865;
            }
            localObject1 = NewFlowCameraActivity.class;
            if (CameraCompatibleList.d(CameraCompatibleList.c)) {
              localObject1 = MX3FlowNewCameraActivity.class;
            }
            localObject1 = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (Class)localObject1);
            File localFile = new File(AppConstants.aV);
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
          label865:
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
  
  public void b()
  {
    if (a()) {
      this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog.dismiss();
    }
  }
  
  public boolean b()
  {
    if (ShortVideoUtils.a()) {
      return true;
    }
    ThreadManager.post(new xla(this), 8, null, true);
    return false;
  }
  
  public void c()
  {
    a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 0L, 0L, 1);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "CliOper", "", "", "0X8004077", "0X8004077", 0, 0, "", "", "", "");
  }
  
  public void d()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, AddContactsActivity.class);
    localIntent.putExtra("entrence_data_report", 2);
    localIntent.putExtra("EntranceId", 4);
    localIntent.putExtra("leftViewText", this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131433698));
    localIntent.putExtra("selfSet_leftViewText", this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131433698));
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity(localIntent);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "CliOper", "", "", "0X8004839", "0X8004839", 0, 0, "", "", "", "");
    try
    {
      ((RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getManager(35)).b(String.valueOf("101210.101211"));
      return;
    }
    catch (Exception localException) {}
  }
  
  public void e()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, ARMainActivity.class);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity(localIntent);
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecentOptPopBar", 2, "hideProgress");
    }
    try
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()))
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
        this.jdField_d_of_type_Boolean = false;
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("RecentOptPopBar", 2, localException.toString());
    }
  }
  
  public void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecentOptPopBar", 2, "enterArmap");
    }
    if (!ArNativeSoLoader.a("ArMapEngine7651"))
    {
      Object localObject = (EarlyDownloadManager)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getManager(76);
      if (localObject != null)
      {
        localObject = (ArNativeSoDownloadHandler)((EarlyDownloadManager)localObject).a("qq.android.ar.native.so_v7.6.5.1");
        if (localObject != null)
        {
          ((ArNativeSoDownloadHandler)localObject).a(new xku(this, (ArNativeSoDownloadHandler)localObject));
          p();
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
    q();
  }
  
  public void h() {}
  
  public void i()
  {
    QQProxyForQlink.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 8, null);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "CliOper", "", "", "0X80053AD", "0X80053AD", 0, 0, "", "", "", "");
  }
  
  public void j()
  {
    long l = VACDReportUtil.a(null, "qqwallet", "gotoF2fredpack", "click", null, 0, null);
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QrcodeHbGuiderActivity.class);
    localIntent.putExtra("appInfo", "");
    localIntent.putExtra("vacreport_key_seq", l);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity(localIntent);
    a("KEY_F2F_REDPACK_RED_TOUCH", false);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "jiahao.hongbao.click", 0, 0, "", "", "", "");
  }
  
  public void k()
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
  
  public void l()
  {
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "CliOper", "", "", "0X800780A", "0X800780A", 0, 0, "", "", "", "");
    StoryReportor.a("plus_shoot", "clk_entry", 0, 0, new String[] { "", "", "", "" });
    StoryReportor.a("plus_shoot", "exp_shoot", 0, 0, new String[] { "", "", "", "" });
    if (this.jdField_a_of_type_Boolean) {
      RedBagVideoManager.a(RedBagVideoManager.g);
    }
    m();
    if (PeakUtils.a != null) {
      PeakUtils.a.b();
    }
  }
  
  protected void m()
  {
    if (!VideoEnvironment.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app)) {
      DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 230).setMessage("系统版本过低，不支持短视频功能").setPositiveButton(2131433016, new xkz(this)).show();
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
  
  protected void n()
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
  
  public void o()
  {
    if (this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog != null) {
      this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog.a();
    }
  }
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentOptPopBar
 * JD-Core Version:    0.7.0.1
 */