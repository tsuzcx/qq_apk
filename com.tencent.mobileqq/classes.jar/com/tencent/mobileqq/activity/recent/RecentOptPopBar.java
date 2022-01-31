package com.tencent.mobileqq.activity.recent;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.net.Uri;
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
import xhl;
import xhn;
import xhs;
import xht;
import xhu;

public class RecentOptPopBar
  implements View.OnClickListener
{
  private static final int[] jdField_a_of_type_ArrayOfInt = { 2131438720, 2130842250 };
  private static final int[] jdField_b_of_type_ArrayOfInt = { 2131436215, 2130838685 };
  private static final int[] jdField_c_of_type_ArrayOfInt = { 2131436212, 2130838694 };
  private static final int[] jdField_d_of_type_ArrayOfInt = { 2131436219, 2130838675 };
  private static final int[] e = { 2131436220, 2130838689 };
  private static final int[] f = { 2131436216, 2130838688 };
  private static final int[] g = { 2131436210, 2130838693 };
  private static final int[] h = { 2131436224, 2130838690 };
  private static final int[] i = { 2131436225, 2130838688 };
  private static final int[] j = { 2131438722, 2130842220 };
  private static final int[] k = { 2131439161, 2130842220 };
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
  
  public RecentOptPopBar(BaseActivity paramBaseActivity)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
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
      DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 230).setMessage("系统版本过低，不支持短视频功能").setPositiveButton(2131432999, new xhu(this)).show();
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.c()) {
      QQToast.a(BaseApplicationImpl.getContext(), 2131428986, 1).b(BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131558448));
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
    localArrayList.add(a(jdField_b_of_type_ArrayOfInt));
    localArrayList.add(a(jdField_c_of_type_ArrayOfInt));
    localArrayList.add(a(jdField_d_of_type_ArrayOfInt));
    localArrayList.add(a(e));
    this.jdField_c_of_type_Boolean = false;
    if (QWalletSetting.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getCurrentAccountUin(), "F2FRedpackEntry", false))
    {
      localArrayList.add(a(h));
      this.jdField_c_of_type_Boolean = true;
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "hongbaocaidan.show", 0, 0, "", "", "", "");
    }
    this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog = PopupMenuDialog.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, localArrayList, new xhl(this));
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
    //   3: invokestatic 376	com/tencent/mobileqq/app/DeviceProfileManager:a	()Lcom/tencent/mobileqq/app/DeviceProfileManager;
    //   6: getstatic 382	com/tencent/mobileqq/app/DeviceProfileManager$DpcNames:PreUploadVideoConfig	Lcom/tencent/mobileqq/app/DeviceProfileManager$DpcNames;
    //   9: invokevirtual 385	com/tencent/mobileqq/app/DeviceProfileManager$DpcNames:name	()Ljava/lang/String;
    //   12: ldc_w 387
    //   15: invokevirtual 390	com/tencent/mobileqq/app/DeviceProfileManager:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   18: astore 19
    //   20: iconst_0
    //   21: invokestatic 395	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   24: ldc_w 397
    //   27: new 335	java/lang/StringBuilder
    //   30: dup
    //   31: invokespecial 336	java/lang/StringBuilder:<init>	()V
    //   34: ldc_w 399
    //   37: invokevirtual 342	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: aload 19
    //   42: invokevirtual 342	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: invokevirtual 351	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   48: invokestatic 404	com/tencent/mobileqq/utils/LogTag:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
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
    //   68: invokevirtual 407	java/lang/String:length	()I
    //   71: ifle +540 -> 611
    //   74: aload 19
    //   76: ldc_w 409
    //   79: invokevirtual 413	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
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
    //   100: invokestatic 418	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   103: invokevirtual 421	java/lang/Integer:intValue	()I
    //   106: istore 7
    //   108: aload 19
    //   110: iconst_1
    //   111: aaload
    //   112: invokestatic 418	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   115: invokevirtual 421	java/lang/Integer:intValue	()I
    //   118: istore 6
    //   120: fload 4
    //   122: fstore_3
    //   123: aload 19
    //   125: iconst_2
    //   126: aaload
    //   127: invokestatic 426	java/lang/Float:valueOf	(Ljava/lang/String;)Ljava/lang/Float;
    //   130: invokevirtual 430	java/lang/Float:floatValue	()F
    //   133: fstore_2
    //   134: fload_2
    //   135: fstore_3
    //   136: aload 19
    //   138: iconst_3
    //   139: aaload
    //   140: invokestatic 418	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   143: invokevirtual 421	java/lang/Integer:intValue	()I
    //   146: istore 5
    //   148: aload 19
    //   150: iconst_4
    //   151: aaload
    //   152: invokestatic 435	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   155: invokevirtual 439	java/lang/Long:longValue	()J
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
    //   175: invokestatic 395	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   178: ldc_w 397
    //   181: new 335	java/lang/StringBuilder
    //   184: dup
    //   185: invokespecial 336	java/lang/StringBuilder:<init>	()V
    //   188: ldc_w 441
    //   191: invokevirtual 342	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: iload 9
    //   196: invokevirtual 345	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   199: ldc_w 443
    //   202: invokevirtual 342	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: iload 8
    //   207: invokevirtual 345	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   210: ldc_w 445
    //   213: invokevirtual 342	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: iload 7
    //   218: invokevirtual 345	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   221: ldc_w 447
    //   224: invokevirtual 342	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: fload_3
    //   228: invokevirtual 450	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   231: ldc_w 452
    //   234: invokevirtual 342	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: lload 15
    //   239: invokevirtual 350	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   242: invokevirtual 351	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   245: invokestatic 404	com/tencent/mobileqq/utils/LogTag:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   248: invokestatic 457	com/tencent/mobileqq/highway/utils/VideoUpConfigInfo:isPreUpload	()Z
    //   251: istore 13
    //   253: getstatic 460	com/tencent/mobileqq/highway/utils/VideoUpConfigInfo:sIsHardCodeEnable	Z
    //   256: istore 14
    //   258: iload 8
    //   260: iconst_1
    //   261: if_icmpne +294 -> 555
    //   264: iload 14
    //   266: ifeq +289 -> 555
    //   269: iconst_1
    //   270: istore 12
    //   272: iconst_0
    //   273: invokestatic 395	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   276: ldc_w 397
    //   279: new 335	java/lang/StringBuilder
    //   282: dup
    //   283: invokespecial 336	java/lang/StringBuilder:<init>	()V
    //   286: ldc_w 462
    //   289: invokevirtual 342	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   292: iload 12
    //   294: invokevirtual 465	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   297: ldc_w 467
    //   300: invokevirtual 342	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   303: iload 8
    //   305: invokevirtual 345	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   308: ldc_w 469
    //   311: invokevirtual 342	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   314: iload 14
    //   316: invokevirtual 465	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   319: invokevirtual 351	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   322: invokestatic 404	com/tencent/mobileqq/utils/LogTag:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   325: invokestatic 472	com/tencent/mobileqq/highway/utils/VideoUpConfigInfo:getIsUpdated	()Z
    //   328: ifne +41 -> 369
    //   331: invokestatic 119	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   334: ifeq +12 -> 346
    //   337: ldc 121
    //   339: iconst_2
    //   340: ldc_w 474
    //   343: invokestatic 126	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   346: aload_0
    //   347: getfield 76	com/tencent/mobileqq/activity/recent/RecentOptPopBar:jdField_a_of_type_ComTencentMobileqqAppBaseActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   350: getfield 177	com/tencent/mobileqq/app/BaseActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   353: aload_0
    //   354: getfield 76	com/tencent/mobileqq/activity/recent/RecentOptPopBar:jdField_a_of_type_ComTencentMobileqqAppBaseActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   357: getfield 177	com/tencent/mobileqq/app/BaseActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   360: invokevirtual 475	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   363: invokestatic 481	com/tencent/mobileqq/highway/config/HwServlet:getConfig	(Lmqq/app/AppRuntime;Ljava/lang/String;)V
    //   366: invokestatic 484	com/tencent/mobileqq/highway/utils/VideoUpConfigInfo:setIsUpdated	()V
    //   369: invokestatic 485	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   372: invokestatic 490	com/tencent/mobileqq/utils/NetworkUtil:h	(Landroid/content/Context;)Z
    //   375: ifeq +192 -> 567
    //   378: iload 9
    //   380: iconst_1
    //   381: if_icmpne +180 -> 561
    //   384: iload 13
    //   386: ifeq +175 -> 561
    //   389: iconst_0
    //   390: invokestatic 395	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   393: ldc_w 397
    //   396: new 335	java/lang/StringBuilder
    //   399: dup
    //   400: invokespecial 336	java/lang/StringBuilder:<init>	()V
    //   403: ldc_w 492
    //   406: invokevirtual 342	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   409: iload 11
    //   411: invokevirtual 465	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   414: ldc_w 467
    //   417: invokevirtual 342	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   420: iload 9
    //   422: invokevirtual 345	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   425: ldc_w 469
    //   428: invokevirtual 342	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   431: iload 13
    //   433: invokevirtual 465	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   436: ldc_w 494
    //   439: invokevirtual 342	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   442: invokevirtual 351	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   445: invokestatic 404	com/tencent/mobileqq/utils/LogTag:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   448: aload_1
    //   449: ldc_w 496
    //   452: iload 11
    //   454: invokevirtual 500	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   457: pop
    //   458: aload_1
    //   459: ldc_w 502
    //   462: iload 12
    //   464: invokevirtual 500	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   467: pop
    //   468: aload_1
    //   469: ldc_w 504
    //   472: fload_3
    //   473: invokevirtual 507	android/content/Intent:putExtra	(Ljava/lang/String;F)Landroid/content/Intent;
    //   476: pop
    //   477: iload 12
    //   479: putstatic 510	com/tencent/mobileqq/shortvideo/hwcodec/HwEnvData:jdField_a_of_type_Boolean	Z
    //   482: iload 11
    //   484: putstatic 512	com/tencent/mobileqq/shortvideo/hwcodec/HwEnvData:jdField_b_of_type_Boolean	Z
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
    //   517: invokestatic 119	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   520: ifeq -346 -> 174
    //   523: ldc 121
    //   525: iconst_2
    //   526: ldc_w 514
    //   529: aload 19
    //   531: invokestatic 517	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
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
    //   7: getfield 317	com/tencent/mobileqq/activity/recent/RecentOptPopBar:jdField_a_of_type_ComTencentWidgetPopupMenuDialog	Lcom/tencent/widget/PopupMenuDialog;
    //   10: ifnonnull +129 -> 139
    //   13: aload_0
    //   14: invokevirtual 520	com/tencent/mobileqq/activity/recent/RecentOptPopBar:a	()V
    //   17: aload_0
    //   18: getfield 317	com/tencent/mobileqq/activity/recent/RecentOptPopBar:jdField_a_of_type_ComTencentWidgetPopupMenuDialog	Lcom/tencent/widget/PopupMenuDialog;
    //   21: aload_1
    //   22: iload_2
    //   23: iload_3
    //   24: invokevirtual 523	com/tencent/widget/PopupMenuDialog:showAsDropDown	(Landroid/view/View;II)V
    //   27: aload_0
    //   28: getfield 525	com/tencent/mobileqq/activity/recent/RecentOptPopBar:jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch	Lcom/tencent/mobileqq/redtouch/RedTouch;
    //   31: ifnull +10 -> 41
    //   34: aload_0
    //   35: getfield 527	com/tencent/mobileqq/activity/recent/RecentOptPopBar:jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch	Lcom/tencent/mobileqq/redtouch/RedTouch;
    //   38: ifnonnull +568 -> 606
    //   41: aload_0
    //   42: getfield 317	com/tencent/mobileqq/activity/recent/RecentOptPopBar:jdField_a_of_type_ComTencentWidgetPopupMenuDialog	Lcom/tencent/widget/PopupMenuDialog;
    //   45: invokevirtual 531	com/tencent/widget/PopupMenuDialog:getContentView	()Landroid/view/View;
    //   48: ldc_w 532
    //   51: invokevirtual 538	android/view/View:findViewById	(I)Landroid/view/View;
    //   54: checkcast 540	android/widget/LinearLayout
    //   57: astore_1
    //   58: iconst_0
    //   59: istore_2
    //   60: iload_2
    //   61: aload_1
    //   62: invokevirtual 543	android/widget/LinearLayout:getChildCount	()I
    //   65: if_icmpge +541 -> 606
    //   68: aload_1
    //   69: iload_2
    //   70: invokevirtual 546	android/widget/LinearLayout:getChildAt	(I)Landroid/view/View;
    //   73: astore 11
    //   75: aload 11
    //   77: invokevirtual 550	android/view/View:getTag	()Ljava/lang/Object;
    //   80: checkcast 253	com/tencent/widget/PopupMenuDialog$MenuItem
    //   83: checkcast 253	com/tencent/widget/PopupMenuDialog$MenuItem
    //   86: getfield 257	com/tencent/widget/PopupMenuDialog$MenuItem:jdField_a_of_type_Int	I
    //   89: ldc 32
    //   91: if_icmpne +286 -> 377
    //   94: aload 11
    //   96: ldc_w 551
    //   99: invokevirtual 538	android/view/View:findViewById	(I)Landroid/view/View;
    //   102: checkcast 553	android/widget/TextView
    //   105: astore 11
    //   107: aload_0
    //   108: new 555	com/tencent/mobileqq/redtouch/RedTouch
    //   111: dup
    //   112: aload_0
    //   113: getfield 76	com/tencent/mobileqq/activity/recent/RecentOptPopBar:jdField_a_of_type_ComTencentMobileqqAppBaseActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   116: aload 11
    //   118: invokespecial 558	com/tencent/mobileqq/redtouch/RedTouch:<init>	(Landroid/content/Context;Landroid/view/View;)V
    //   121: bipush 21
    //   123: invokevirtual 561	com/tencent/mobileqq/redtouch/RedTouch:a	(I)Lcom/tencent/mobileqq/redtouch/RedTouch;
    //   126: invokevirtual 564	com/tencent/mobileqq/redtouch/RedTouch:a	()Lcom/tencent/mobileqq/redtouch/RedTouch;
    //   129: putfield 525	com/tencent/mobileqq/activity/recent/RecentOptPopBar:jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch	Lcom/tencent/mobileqq/redtouch/RedTouch;
    //   132: iload_2
    //   133: iconst_1
    //   134: iadd
    //   135: istore_2
    //   136: goto -76 -> 60
    //   139: aload_0
    //   140: getfield 282	com/tencent/mobileqq/activity/recent/RecentOptPopBar:jdField_c_of_type_Boolean	Z
    //   143: ifeq +20 -> 163
    //   146: aload_0
    //   147: getfield 76	com/tencent/mobileqq/activity/recent/RecentOptPopBar:jdField_a_of_type_ComTencentMobileqqAppBaseActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   150: invokevirtual 285	com/tencent/mobileqq/app/BaseActivity:getCurrentAccountUin	()Ljava/lang/String;
    //   153: ldc_w 287
    //   156: iconst_0
    //   157: invokestatic 292	com/tencent/mobileqq/activity/qwallet/QWalletSetting:a	(Ljava/lang/String;Ljava/lang/String;Z)Z
    //   160: ifeq +27 -> 187
    //   163: aload_0
    //   164: getfield 282	com/tencent/mobileqq/activity/recent/RecentOptPopBar:jdField_c_of_type_Boolean	Z
    //   167: ifne +34 -> 201
    //   170: aload_0
    //   171: getfield 76	com/tencent/mobileqq/activity/recent/RecentOptPopBar:jdField_a_of_type_ComTencentMobileqqAppBaseActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   174: invokevirtual 285	com/tencent/mobileqq/app/BaseActivity:getCurrentAccountUin	()Ljava/lang/String;
    //   177: ldc_w 287
    //   180: iconst_0
    //   181: invokestatic 292	com/tencent/mobileqq/activity/qwallet/QWalletSetting:a	(Ljava/lang/String;Ljava/lang/String;Z)Z
    //   184: ifeq +17 -> 201
    //   187: aload_0
    //   188: invokevirtual 520	com/tencent/mobileqq/activity/recent/RecentOptPopBar:a	()V
    //   191: aload_0
    //   192: aconst_null
    //   193: putfield 525	com/tencent/mobileqq/activity/recent/RecentOptPopBar:jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch	Lcom/tencent/mobileqq/redtouch/RedTouch;
    //   196: aload_0
    //   197: aconst_null
    //   198: putfield 527	com/tencent/mobileqq/activity/recent/RecentOptPopBar:jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch	Lcom/tencent/mobileqq/redtouch/RedTouch;
    //   201: aload_0
    //   202: getfield 76	com/tencent/mobileqq/activity/recent/RecentOptPopBar:jdField_a_of_type_ComTencentMobileqqAppBaseActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   205: invokevirtual 285	com/tencent/mobileqq/app/BaseActivity:getCurrentAccountUin	()Ljava/lang/String;
    //   208: invokestatic 567	com/tencent/mobileqq/activity/qwallet/QWalletSetting:a	(Ljava/lang/String;)Z
    //   211: ifeq +119 -> 330
    //   214: aload_0
    //   215: getfield 569	com/tencent/mobileqq/activity/recent/RecentOptPopBar:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   218: ifnull +23 -> 241
    //   221: aload_0
    //   222: getfield 569	com/tencent/mobileqq/activity/recent/RecentOptPopBar:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   225: aload_0
    //   226: getfield 569	com/tencent/mobileqq/activity/recent/RecentOptPopBar:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   229: invokevirtual 570	android/widget/TextView:getResources	()Landroid/content/res/Resources;
    //   232: ldc_w 571
    //   235: invokevirtual 574	android/content/res/Resources:getColor	(I)I
    //   238: invokevirtual 577	android/widget/TextView:setTextColor	(I)V
    //   241: aload_0
    //   242: getfield 579	com/tencent/mobileqq/activity/recent/RecentOptPopBar:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   245: ifnull +12 -> 257
    //   248: aload_0
    //   249: getfield 579	com/tencent/mobileqq/activity/recent/RecentOptPopBar:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   252: ldc 57
    //   254: invokevirtual 584	android/widget/ImageView:setImageResource	(I)V
    //   257: aload_0
    //   258: getfield 585	com/tencent/mobileqq/activity/recent/RecentOptPopBar:jdField_b_of_type_Boolean	Z
    //   261: ifeq +16 -> 277
    //   264: aload_0
    //   265: getfield 76	com/tencent/mobileqq/activity/recent/RecentOptPopBar:jdField_a_of_type_ComTencentMobileqqAppBaseActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   268: getfield 177	com/tencent/mobileqq/app/BaseActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   271: invokestatic 587	com/tencent/mobileqq/shortvideo/util/RecentDanceConfigMgr:a	(Lcom/tencent/common/app/AppInterface;)Z
    //   274: ifeq +49 -> 323
    //   277: aload_0
    //   278: getfield 585	com/tencent/mobileqq/activity/recent/RecentOptPopBar:jdField_b_of_type_Boolean	Z
    //   281: ifne +16 -> 297
    //   284: aload_0
    //   285: getfield 76	com/tencent/mobileqq/activity/recent/RecentOptPopBar:jdField_a_of_type_ComTencentMobileqqAppBaseActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   288: getfield 177	com/tencent/mobileqq/app/BaseActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   291: invokestatic 587	com/tencent/mobileqq/shortvideo/util/RecentDanceConfigMgr:a	(Lcom/tencent/common/app/AppInterface;)Z
    //   294: ifne +29 -> 323
    //   297: aload_0
    //   298: getfield 585	com/tencent/mobileqq/activity/recent/RecentOptPopBar:jdField_b_of_type_Boolean	Z
    //   301: ifeq -284 -> 17
    //   304: aload_0
    //   305: getfield 76	com/tencent/mobileqq/activity/recent/RecentOptPopBar:jdField_a_of_type_ComTencentMobileqqAppBaseActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   308: getfield 177	com/tencent/mobileqq/app/BaseActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   311: invokestatic 587	com/tencent/mobileqq/shortvideo/util/RecentDanceConfigMgr:a	(Lcom/tencent/common/app/AppInterface;)Z
    //   314: ifeq -297 -> 17
    //   317: invokestatic 589	com/tencent/mobileqq/shortvideo/util/RecentDanceConfigMgr:a	()Z
    //   320: ifeq -303 -> 17
    //   323: aload_0
    //   324: invokevirtual 520	com/tencent/mobileqq/activity/recent/RecentOptPopBar:a	()V
    //   327: goto -310 -> 17
    //   330: aload_0
    //   331: getfield 569	com/tencent/mobileqq/activity/recent/RecentOptPopBar:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   334: ifnull +23 -> 357
    //   337: aload_0
    //   338: getfield 569	com/tencent/mobileqq/activity/recent/RecentOptPopBar:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   341: aload_0
    //   342: getfield 569	com/tencent/mobileqq/activity/recent/RecentOptPopBar:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   345: invokevirtual 570	android/widget/TextView:getResources	()Landroid/content/res/Resources;
    //   348: ldc_w 590
    //   351: invokevirtual 574	android/content/res/Resources:getColor	(I)I
    //   354: invokevirtual 577	android/widget/TextView:setTextColor	(I)V
    //   357: aload_0
    //   358: getfield 579	com/tencent/mobileqq/activity/recent/RecentOptPopBar:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   361: ifnull -104 -> 257
    //   364: aload_0
    //   365: getfield 579	com/tencent/mobileqq/activity/recent/RecentOptPopBar:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   368: ldc_w 591
    //   371: invokevirtual 584	android/widget/ImageView:setImageResource	(I)V
    //   374: goto -117 -> 257
    //   377: aload 11
    //   379: invokevirtual 550	android/view/View:getTag	()Ljava/lang/Object;
    //   382: checkcast 253	com/tencent/widget/PopupMenuDialog$MenuItem
    //   385: checkcast 253	com/tencent/widget/PopupMenuDialog$MenuItem
    //   388: getfield 257	com/tencent/widget/PopupMenuDialog$MenuItem:jdField_a_of_type_Int	I
    //   391: ldc 48
    //   393: if_icmpne +51 -> 444
    //   396: aload 11
    //   398: ldc_w 592
    //   401: invokevirtual 538	android/view/View:findViewById	(I)Landroid/view/View;
    //   404: astore 11
    //   406: aload_0
    //   407: new 555	com/tencent/mobileqq/redtouch/RedTouch
    //   410: dup
    //   411: aload_0
    //   412: getfield 76	com/tencent/mobileqq/activity/recent/RecentOptPopBar:jdField_a_of_type_ComTencentMobileqqAppBaseActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   415: aload 11
    //   417: invokespecial 558	com/tencent/mobileqq/redtouch/RedTouch:<init>	(Landroid/content/Context;Landroid/view/View;)V
    //   420: bipush 53
    //   422: invokevirtual 561	com/tencent/mobileqq/redtouch/RedTouch:a	(I)Lcom/tencent/mobileqq/redtouch/RedTouch;
    //   425: invokevirtual 564	com/tencent/mobileqq/redtouch/RedTouch:a	()Lcom/tencent/mobileqq/redtouch/RedTouch;
    //   428: putfield 527	com/tencent/mobileqq/activity/recent/RecentOptPopBar:jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch	Lcom/tencent/mobileqq/redtouch/RedTouch;
    //   431: goto -299 -> 132
    //   434: astore 11
    //   436: aload 11
    //   438: invokevirtual 595	java/lang/Exception:printStackTrace	()V
    //   441: goto -309 -> 132
    //   444: aload 11
    //   446: invokevirtual 550	android/view/View:getTag	()Ljava/lang/Object;
    //   449: checkcast 253	com/tencent/widget/PopupMenuDialog$MenuItem
    //   452: checkcast 253	com/tencent/widget/PopupMenuDialog$MenuItem
    //   455: getfield 257	com/tencent/widget/PopupMenuDialog$MenuItem:jdField_a_of_type_Int	I
    //   458: ldc 56
    //   460: if_icmpne -328 -> 132
    //   463: aload_0
    //   464: aload 11
    //   466: ldc_w 551
    //   469: invokevirtual 538	android/view/View:findViewById	(I)Landroid/view/View;
    //   472: checkcast 553	android/widget/TextView
    //   475: putfield 569	com/tencent/mobileqq/activity/recent/RecentOptPopBar:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   478: aload_0
    //   479: aload 11
    //   481: ldc_w 592
    //   484: invokevirtual 538	android/view/View:findViewById	(I)Landroid/view/View;
    //   487: checkcast 581	android/widget/ImageView
    //   490: putfield 579	com/tencent/mobileqq/activity/recent/RecentOptPopBar:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   493: aload_0
    //   494: getfield 76	com/tencent/mobileqq/activity/recent/RecentOptPopBar:jdField_a_of_type_ComTencentMobileqqAppBaseActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   497: invokevirtual 285	com/tencent/mobileqq/app/BaseActivity:getCurrentAccountUin	()Ljava/lang/String;
    //   500: invokestatic 567	com/tencent/mobileqq/activity/qwallet/QWalletSetting:a	(Ljava/lang/String;)Z
    //   503: ifeq +70 -> 573
    //   506: aload_0
    //   507: getfield 569	com/tencent/mobileqq/activity/recent/RecentOptPopBar:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   510: aload_0
    //   511: getfield 569	com/tencent/mobileqq/activity/recent/RecentOptPopBar:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   514: invokevirtual 570	android/widget/TextView:getResources	()Landroid/content/res/Resources;
    //   517: ldc_w 571
    //   520: invokevirtual 574	android/content/res/Resources:getColor	(I)I
    //   523: invokevirtual 577	android/widget/TextView:setTextColor	(I)V
    //   526: aload_0
    //   527: getfield 579	com/tencent/mobileqq/activity/recent/RecentOptPopBar:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   530: ldc 57
    //   532: invokevirtual 584	android/widget/ImageView:setImageResource	(I)V
    //   535: aload_0
    //   536: new 555	com/tencent/mobileqq/redtouch/RedTouch
    //   539: dup
    //   540: aload_0
    //   541: getfield 76	com/tencent/mobileqq/activity/recent/RecentOptPopBar:jdField_a_of_type_ComTencentMobileqqAppBaseActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   544: aload_0
    //   545: getfield 579	com/tencent/mobileqq/activity/recent/RecentOptPopBar:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   548: invokespecial 558	com/tencent/mobileqq/redtouch/RedTouch:<init>	(Landroid/content/Context;Landroid/view/View;)V
    //   551: bipush 53
    //   553: invokevirtual 561	com/tencent/mobileqq/redtouch/RedTouch:a	(I)Lcom/tencent/mobileqq/redtouch/RedTouch;
    //   556: invokevirtual 564	com/tencent/mobileqq/redtouch/RedTouch:a	()Lcom/tencent/mobileqq/redtouch/RedTouch;
    //   559: putfield 597	com/tencent/mobileqq/activity/recent/RecentOptPopBar:jdField_c_of_type_ComTencentMobileqqRedtouchRedTouch	Lcom/tencent/mobileqq/redtouch/RedTouch;
    //   562: aload_0
    //   563: ldc_w 599
    //   566: iconst_1
    //   567: invokevirtual 602	com/tencent/mobileqq/activity/recent/RecentOptPopBar:a	(Ljava/lang/String;Z)V
    //   570: goto -438 -> 132
    //   573: aload_0
    //   574: getfield 569	com/tencent/mobileqq/activity/recent/RecentOptPopBar:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   577: aload_0
    //   578: getfield 569	com/tencent/mobileqq/activity/recent/RecentOptPopBar:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   581: invokevirtual 570	android/widget/TextView:getResources	()Landroid/content/res/Resources;
    //   584: ldc_w 590
    //   587: invokevirtual 574	android/content/res/Resources:getColor	(I)I
    //   590: invokevirtual 577	android/widget/TextView:setTextColor	(I)V
    //   593: aload_0
    //   594: getfield 579	com/tencent/mobileqq/activity/recent/RecentOptPopBar:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   597: ldc_w 591
    //   600: invokevirtual 584	android/widget/ImageView:setImageResource	(I)V
    //   603: goto -68 -> 535
    //   606: aload_0
    //   607: getfield 585	com/tencent/mobileqq/activity/recent/RecentOptPopBar:jdField_b_of_type_Boolean	Z
    //   610: ifeq +129 -> 739
    //   613: aload_0
    //   614: getfield 604	com/tencent/mobileqq/activity/recent/RecentOptPopBar:jdField_d_of_type_ComTencentMobileqqRedtouchRedTouch	Lcom/tencent/mobileqq/redtouch/RedTouch;
    //   617: ifnonnull +127 -> 744
    //   620: aload_0
    //   621: getfield 76	com/tencent/mobileqq/activity/recent/RecentOptPopBar:jdField_a_of_type_ComTencentMobileqqAppBaseActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   624: getfield 177	com/tencent/mobileqq/app/BaseActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   627: aconst_null
    //   628: invokestatic 607	com/tencent/mobileqq/shortvideo/util/RecentDanceConfigMgr:a	(Lcom/tencent/common/app/AppInterface;[I)Z
    //   631: ifeq +113 -> 744
    //   634: aload_0
    //   635: getfield 317	com/tencent/mobileqq/activity/recent/RecentOptPopBar:jdField_a_of_type_ComTencentWidgetPopupMenuDialog	Lcom/tencent/widget/PopupMenuDialog;
    //   638: invokevirtual 531	com/tencent/widget/PopupMenuDialog:getContentView	()Landroid/view/View;
    //   641: ldc_w 532
    //   644: invokevirtual 538	android/view/View:findViewById	(I)Landroid/view/View;
    //   647: checkcast 540	android/widget/LinearLayout
    //   650: astore_1
    //   651: iconst_0
    //   652: istore_2
    //   653: iload_2
    //   654: aload_1
    //   655: invokevirtual 543	android/widget/LinearLayout:getChildCount	()I
    //   658: if_icmpge +86 -> 744
    //   661: aload_1
    //   662: iload_2
    //   663: invokevirtual 546	android/widget/LinearLayout:getChildAt	(I)Landroid/view/View;
    //   666: astore 11
    //   668: aload 11
    //   670: invokevirtual 550	android/view/View:getTag	()Ljava/lang/Object;
    //   673: checkcast 253	com/tencent/widget/PopupMenuDialog$MenuItem
    //   676: checkcast 253	com/tencent/widget/PopupMenuDialog$MenuItem
    //   679: getfield 257	com/tencent/widget/PopupMenuDialog$MenuItem:jdField_a_of_type_Int	I
    //   682: ldc 60
    //   684: if_icmpne +38 -> 722
    //   687: aload 11
    //   689: ldc_w 592
    //   692: invokevirtual 538	android/view/View:findViewById	(I)Landroid/view/View;
    //   695: astore 11
    //   697: aload_0
    //   698: new 555	com/tencent/mobileqq/redtouch/RedTouch
    //   701: dup
    //   702: aload_0
    //   703: getfield 76	com/tencent/mobileqq/activity/recent/RecentOptPopBar:jdField_a_of_type_ComTencentMobileqqAppBaseActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   706: aload 11
    //   708: invokespecial 558	com/tencent/mobileqq/redtouch/RedTouch:<init>	(Landroid/content/Context;Landroid/view/View;)V
    //   711: bipush 53
    //   713: invokevirtual 561	com/tencent/mobileqq/redtouch/RedTouch:a	(I)Lcom/tencent/mobileqq/redtouch/RedTouch;
    //   716: invokevirtual 564	com/tencent/mobileqq/redtouch/RedTouch:a	()Lcom/tencent/mobileqq/redtouch/RedTouch;
    //   719: putfield 604	com/tencent/mobileqq/activity/recent/RecentOptPopBar:jdField_d_of_type_ComTencentMobileqqRedtouchRedTouch	Lcom/tencent/mobileqq/redtouch/RedTouch;
    //   722: iload_2
    //   723: iconst_1
    //   724: iadd
    //   725: istore_2
    //   726: goto -73 -> 653
    //   729: astore 11
    //   731: aload 11
    //   733: invokevirtual 595	java/lang/Exception:printStackTrace	()V
    //   736: goto -14 -> 722
    //   739: aload_0
    //   740: aconst_null
    //   741: putfield 604	com/tencent/mobileqq/activity/recent/RecentOptPopBar:jdField_d_of_type_ComTencentMobileqqRedtouchRedTouch	Lcom/tencent/mobileqq/redtouch/RedTouch;
    //   744: aload_0
    //   745: getfield 604	com/tencent/mobileqq/activity/recent/RecentOptPopBar:jdField_d_of_type_ComTencentMobileqqRedtouchRedTouch	Lcom/tencent/mobileqq/redtouch/RedTouch;
    //   748: ifnull +41 -> 789
    //   751: aload_0
    //   752: getfield 76	com/tencent/mobileqq/activity/recent/RecentOptPopBar:jdField_a_of_type_ComTencentMobileqqAppBaseActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   755: getfield 177	com/tencent/mobileqq/app/BaseActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   758: aconst_null
    //   759: invokestatic 607	com/tencent/mobileqq/shortvideo/util/RecentDanceConfigMgr:a	(Lcom/tencent/common/app/AppInterface;[I)Z
    //   762: ifeq +338 -> 1100
    //   765: new 609	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedTypeInfo
    //   768: dup
    //   769: invokespecial 610	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedTypeInfo:<init>	()V
    //   772: astore_1
    //   773: aload_1
    //   774: getfield 614	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedTypeInfo:red_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   777: iconst_0
    //   778: invokevirtual 619	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   781: aload_0
    //   782: getfield 604	com/tencent/mobileqq/activity/recent/RecentOptPopBar:jdField_d_of_type_ComTencentMobileqqRedtouchRedTouch	Lcom/tencent/mobileqq/redtouch/RedTouch;
    //   785: aload_1
    //   786: invokevirtual 622	com/tencent/mobileqq/redtouch/RedTouch:a	(Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedTypeInfo;)V
    //   789: aload_0
    //   790: getfield 525	com/tencent/mobileqq/activity/recent/RecentOptPopBar:jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch	Lcom/tencent/mobileqq/redtouch/RedTouch;
    //   793: ifnull +33 -> 826
    //   796: aload_0
    //   797: getfield 76	com/tencent/mobileqq/activity/recent/RecentOptPopBar:jdField_a_of_type_ComTencentMobileqqAppBaseActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   800: getfield 177	com/tencent/mobileqq/app/BaseActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   803: bipush 35
    //   805: invokevirtual 626	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   808: checkcast 628	com/tencent/mobileqq/redtouch/RedTouchManager
    //   811: ldc_w 630
    //   814: invokevirtual 633	com/tencent/mobileqq/redtouch/RedTouchManager:a	(Ljava/lang/String;)Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   817: astore_1
    //   818: aload_0
    //   819: getfield 525	com/tencent/mobileqq/activity/recent/RecentOptPopBar:jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch	Lcom/tencent/mobileqq/redtouch/RedTouch;
    //   822: aload_1
    //   823: invokevirtual 636	com/tencent/mobileqq/redtouch/RedTouch:a	(Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;)V
    //   826: aload_0
    //   827: getfield 527	com/tencent/mobileqq/activity/recent/RecentOptPopBar:jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch	Lcom/tencent/mobileqq/redtouch/RedTouch;
    //   830: ifnull +3 -> 833
    //   833: aload_0
    //   834: getfield 527	com/tencent/mobileqq/activity/recent/RecentOptPopBar:jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch	Lcom/tencent/mobileqq/redtouch/RedTouch;
    //   837: ifnull +46 -> 883
    //   840: getstatic 640	com/tencent/mobileqq/shortvideo/redbag/RedBagVideoManager:g	Ljava/lang/String;
    //   843: invokestatic 641	com/tencent/mobileqq/shortvideo/redbag/RedBagVideoManager:a	(Ljava/lang/String;)Z
    //   846: ifne +271 -> 1117
    //   849: iconst_1
    //   850: istore 6
    //   852: aload_0
    //   853: iload 6
    //   855: putfield 642	com/tencent/mobileqq/activity/recent/RecentOptPopBar:jdField_a_of_type_Boolean	Z
    //   858: aload_0
    //   859: getfield 642	com/tencent/mobileqq/activity/recent/RecentOptPopBar:jdField_a_of_type_Boolean	Z
    //   862: aload_0
    //   863: getfield 527	com/tencent/mobileqq/activity/recent/RecentOptPopBar:jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch	Lcom/tencent/mobileqq/redtouch/RedTouch;
    //   866: getfield 644	com/tencent/mobileqq/redtouch/RedTouch:e	Z
    //   869: if_icmpeq +14 -> 883
    //   872: aload_0
    //   873: getfield 527	com/tencent/mobileqq/activity/recent/RecentOptPopBar:jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch	Lcom/tencent/mobileqq/redtouch/RedTouch;
    //   876: aload_0
    //   877: getfield 642	com/tencent/mobileqq/activity/recent/RecentOptPopBar:jdField_a_of_type_Boolean	Z
    //   880: invokevirtual 646	com/tencent/mobileqq/redtouch/RedTouch:a	(Z)V
    //   883: aload_0
    //   884: getfield 597	com/tencent/mobileqq/activity/recent/RecentOptPopBar:jdField_c_of_type_ComTencentMobileqqRedtouchRedTouch	Lcom/tencent/mobileqq/redtouch/RedTouch;
    //   887: ifnull +38 -> 925
    //   890: aload_0
    //   891: ldc_w 648
    //   894: iconst_1
    //   895: invokevirtual 650	com/tencent/mobileqq/activity/recent/RecentOptPopBar:a	(Ljava/lang/String;Z)Z
    //   898: ifeq +225 -> 1123
    //   901: new 609	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedTypeInfo
    //   904: dup
    //   905: invokespecial 610	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedTypeInfo:<init>	()V
    //   908: astore_1
    //   909: aload_1
    //   910: getfield 614	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedTypeInfo:red_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   913: iconst_0
    //   914: invokevirtual 619	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   917: aload_0
    //   918: getfield 597	com/tencent/mobileqq/activity/recent/RecentOptPopBar:jdField_c_of_type_ComTencentMobileqqRedtouchRedTouch	Lcom/tencent/mobileqq/redtouch/RedTouch;
    //   921: aload_1
    //   922: invokevirtual 622	com/tencent/mobileqq/redtouch/RedTouch:a	(Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedTypeInfo;)V
    //   925: invokestatic 654	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   928: ldc_w 656
    //   931: iconst_4
    //   932: invokevirtual 660	com/tencent/common/app/BaseApplicationImpl:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   935: astore_1
    //   936: iload 4
    //   938: istore_2
    //   939: aload_1
    //   940: ifnull +107 -> 1047
    //   943: iload 4
    //   945: istore_2
    //   946: aload_1
    //   947: ldc_w 662
    //   950: iconst_1
    //   951: invokeinterface 667 3 0
    //   956: ifne +91 -> 1047
    //   959: aload_1
    //   960: ldc_w 669
    //   963: lconst_0
    //   964: invokeinterface 673 4 0
    //   969: lstore 7
    //   971: aload_1
    //   972: ldc_w 675
    //   975: ldc_w 676
    //   978: invokeinterface 680 3 0
    //   983: istore_2
    //   984: invokestatic 685	java/lang/System:currentTimeMillis	()J
    //   987: lstore 9
    //   989: lload 7
    //   991: lconst_0
    //   992: lcmp
    //   993: ifle +147 -> 1140
    //   996: iload_2
    //   997: ifle +143 -> 1140
    //   1000: lload 9
    //   1002: lload 7
    //   1004: lcmp
    //   1005: ifle +135 -> 1140
    //   1008: lload 9
    //   1010: lload 7
    //   1012: lsub
    //   1013: iload_2
    //   1014: sipush 1000
    //   1017: imul
    //   1018: i2l
    //   1019: lcmp
    //   1020: ifle +120 -> 1140
    //   1023: aload_1
    //   1024: invokeinterface 689 1 0
    //   1029: ldc_w 662
    //   1032: iconst_1
    //   1033: invokeinterface 695 3 0
    //   1038: invokeinterface 698 1 0
    //   1043: pop
    //   1044: iload 4
    //   1046: istore_2
    //   1047: iload_2
    //   1048: ifeq +46 -> 1094
    //   1051: getstatic 703	cooperation/peak/PeakUtils:a	Lcom/tencent/mobileqq/hitrate/PreloadProcHitSession;
    //   1054: ifnonnull +25 -> 1079
    //   1057: new 705	com/tencent/mobileqq/hitrate/PreloadProcHitSession
    //   1060: dup
    //   1061: ldc_w 707
    //   1064: ldc_w 709
    //   1067: invokespecial 712	com/tencent/mobileqq/hitrate/PreloadProcHitSession:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   1070: putstatic 703	cooperation/peak/PeakUtils:a	Lcom/tencent/mobileqq/hitrate/PreloadProcHitSession;
    //   1073: getstatic 703	cooperation/peak/PeakUtils:a	Lcom/tencent/mobileqq/hitrate/PreloadProcHitSession;
    //   1076: invokevirtual 713	com/tencent/mobileqq/hitrate/PreloadProcHitSession:a	()V
    //   1079: invokestatic 719	com/tencent/mobileqq/app/ThreadManager:getSubThreadHandler	()Lmqq/os/MqqHandler;
    //   1082: new 721	xhm
    //   1085: dup
    //   1086: aload_0
    //   1087: invokespecial 722	xhm:<init>	(Lcom/tencent/mobileqq/activity/recent/RecentOptPopBar;)V
    //   1090: invokevirtual 728	mqq/os/MqqHandler:post	(Ljava/lang/Runnable;)Z
    //   1093: pop
    //   1094: aload_0
    //   1095: invokevirtual 730	com/tencent/mobileqq/activity/recent/RecentOptPopBar:b	()Z
    //   1098: pop
    //   1099: return
    //   1100: aload_0
    //   1101: getfield 604	com/tencent/mobileqq/activity/recent/RecentOptPopBar:jdField_d_of_type_ComTencentMobileqqRedtouchRedTouch	Lcom/tencent/mobileqq/redtouch/RedTouch;
    //   1104: new 732	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo
    //   1107: dup
    //   1108: invokespecial 733	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:<init>	()V
    //   1111: invokevirtual 636	com/tencent/mobileqq/redtouch/RedTouch:a	(Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;)V
    //   1114: goto -325 -> 789
    //   1117: iconst_0
    //   1118: istore 6
    //   1120: goto -268 -> 852
    //   1123: aload_0
    //   1124: getfield 597	com/tencent/mobileqq/activity/recent/RecentOptPopBar:jdField_c_of_type_ComTencentMobileqqRedtouchRedTouch	Lcom/tencent/mobileqq/redtouch/RedTouch;
    //   1127: new 732	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo
    //   1130: dup
    //   1131: invokespecial 733	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:<init>	()V
    //   1134: invokevirtual 636	com/tencent/mobileqq/redtouch/RedTouch:a	(Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;)V
    //   1137: goto -212 -> 925
    //   1140: ldc 121
    //   1142: iconst_1
    //   1143: ldc_w 735
    //   1146: invokestatic 126	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1149: invokestatic 218	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1152: invokestatic 740	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   1155: aload_0
    //   1156: getfield 76	com/tencent/mobileqq/activity/recent/RecentOptPopBar:jdField_a_of_type_ComTencentMobileqqAppBaseActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   1159: invokevirtual 744	com/tencent/mobileqq/app/BaseActivity:getAppInterface	()Lcom/tencent/common/app/AppInterface;
    //   1162: invokevirtual 747	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1165: ldc_w 749
    //   1168: iconst_1
    //   1169: lconst_0
    //   1170: lconst_0
    //   1171: aconst_null
    //   1172: ldc_w 298
    //   1175: invokevirtual 752	com/tencent/mobileqq/statistics/StatisticCollector:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   1178: iconst_0
    //   1179: istore_2
    //   1180: goto -133 -> 1047
    //   1183: astore_1
    //   1184: iload 5
    //   1186: istore_2
    //   1187: aload_1
    //   1188: invokevirtual 595	java/lang/Exception:printStackTrace	()V
    //   1191: goto -144 -> 1047
    //   1194: astore_1
    //   1195: iconst_0
    //   1196: istore_2
    //   1197: goto -10 -> 1187
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1200	0	this	RecentOptPopBar
    //   0	1200	1	paramView	View
    //   0	1200	2	paramInt1	int
    //   0	1200	3	paramInt2	int
    //   4	1041	4	m	int
    //   1	1184	5	n	int
    //   850	269	6	bool	boolean
    //   969	42	7	l1	long
    //   987	22	9	l2	long
    //   73	343	11	localObject	Object
    //   434	46	11	localException1	Exception
    //   666	41	11	localView	View
    //   729	3	11	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   68	132	434	java/lang/Exception
    //   377	431	434	java/lang/Exception
    //   444	535	434	java/lang/Exception
    //   535	570	434	java/lang/Exception
    //   573	603	434	java/lang/Exception
    //   661	722	729	java/lang/Exception
    //   925	936	1183	java/lang/Exception
    //   946	989	1183	java/lang/Exception
    //   1023	1044	1183	java/lang/Exception
    //   1140	1149	1183	java/lang/Exception
    //   1149	1178	1194	java/lang/Exception
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
    ThreadManager.post(new xht(this), 8, null, true);
    return false;
  }
  
  public void c()
  {
    if (QavCameraUsage.b(BaseApplicationImpl.getContext())) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isInMultiWindow())
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, "该功能无法在分屏模式下使用。", 0).a();
      return;
    }
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, ScannerActivity.class);
    localIntent.putExtra("from", "Conversation");
    localIntent.putExtra("from_+", true);
    localIntent.putExtra("leftViewText", this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131433681));
    localIntent.putExtra("selfSet_leftViewText", this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131433681));
    localIntent.putExtra("start_time", System.currentTimeMillis());
    localIntent.setFlags(67108864);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity(localIntent);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "CliOper", "", "", "0X8004077", "0X8004077", 0, 0, "", "", "", "");
  }
  
  public void d()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, AddContactsActivity.class);
    localIntent.putExtra("entrence_data_report", 2);
    localIntent.putExtra("EntranceId", 4);
    localIntent.putExtra("leftViewText", this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131433681));
    localIntent.putExtra("selfSet_leftViewText", this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131433681));
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
    if (!ArNativeSoLoader.a("ArMapEngine738"))
    {
      Object localObject = (EarlyDownloadManager)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getManager(76);
      if (localObject != null)
      {
        localObject = (ArNativeSoDownloadHandler)((EarlyDownloadManager)localObject).a("qq.android.ar.native.so_v7.3.8");
        if (localObject != null)
        {
          ((ArNativeSoDownloadHandler)localObject).a(new xhn(this, (ArNativeSoDownloadHandler)localObject));
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
      DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 230).setMessage("系统版本过低，不支持短视频功能").setPositiveButton(2131432999, new xhs(this)).show();
    }
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.c())
      {
        QQToast.a(BaseApplicationImpl.getContext(), 2131428986, 1).b(BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131558448));
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