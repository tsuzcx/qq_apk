package com.tencent.biz.qqcircle.launcher;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import com.tencent.biz.qcircleshadow.lib.QCircleHostClassHelper;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants._AEEditorConstants;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants._PublicFragmentActivity;
import com.tencent.biz.qcircleshadow.lib.QCircleHostLauncher;
import com.tencent.biz.qcircleshadow.lib.QCircleHostQzoneHelper;
import com.tencent.biz.qqcircle.QCircleGpsHelper;
import com.tencent.biz.qqcircle.QCircleJsUrlConfig;
import com.tencent.biz.qqcircle.QCirclePluginConfig;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.activity.QCircleFolderActivity;
import com.tencent.biz.qqcircle.activity.QCircleFragmentActivity;
import com.tencent.biz.qqcircle.activity.QCircleSingleTaskActivity;
import com.tencent.biz.qqcircle.beans.QCircleAggregationBean;
import com.tencent.biz.qqcircle.beans.QCircleFolderBean;
import com.tencent.biz.qqcircle.beans.QCircleFollowUserBean;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QCircleLayerBean;
import com.tencent.biz.qqcircle.beans.QCircleLikeBean;
import com.tencent.biz.qqcircle.beans.QCirclePicPreviewInitBean;
import com.tencent.biz.qqcircle.beans.QCirclePolymerizationBean;
import com.tencent.biz.qqcircle.beans.QCirclePolymerizeDetailBean;
import com.tencent.biz.qqcircle.beans.QCircleSettingBean;
import com.tencent.biz.qqcircle.debug.mocklbs.QCircleMockLbsFragment;
import com.tencent.biz.qqcircle.flutter.QCircleFlutterLauncher;
import com.tencent.biz.qqcircle.flutter.QCircleFlutterUtils;
import com.tencent.biz.qqcircle.fragments.QCircleDataEditFragment;
import com.tencent.biz.qqcircle.fragments.QCircleDraftFragment;
import com.tencent.biz.qqcircle.fragments.QCircleNewPolymerizeDetailFragment;
import com.tencent.biz.qqcircle.fragments.QCirclePolymerizationFragment;
import com.tencent.biz.qqcircle.fragments.QCirclePolymerizeDetailFragment;
import com.tencent.biz.qqcircle.fragments.QCirclePrivacySettingFragment;
import com.tencent.biz.qqcircle.fragments.QCirclePrivateMessageSettingFragment;
import com.tencent.biz.qqcircle.fragments.QCircleSettingFragment;
import com.tencent.biz.qqcircle.fragments.feeddetail.QCircleFeedDetailFragment;
import com.tencent.biz.qqcircle.fragments.troop.QCircleTroopAggregationFragment;
import com.tencent.biz.qqcircle.immersive.QFSFullScreenFragment;
import com.tencent.biz.qqcircle.immersive.QFSMusicAggregationFragment;
import com.tencent.biz.qqcircle.immersive.aggregation.QFSMusicAggregationPreLoaderTask;
import com.tencent.biz.qqcircle.immersive.aggregation.bean.QFSMusicAggregationInitBean;
import com.tencent.biz.qqcircle.list.bizblocks.QCircleBlackListBlock;
import com.tencent.biz.qqcircle.list.bizblocks.QCircleBlockCheckListBlock;
import com.tencent.biz.qqcircle.list.bizblocks.QCircleChatListBlock;
import com.tencent.biz.qqcircle.list.bizblocks.QCircleLikeListBlock;
import com.tencent.biz.qqcircle.list.bizblocks.QCircleMessageListBlock;
import com.tencent.biz.qqcircle.preload.task.QCircleFolderPreLoaderTask;
import com.tencent.biz.qqcircle.preload.task.QCircleNewPolymerizeDetailPreLoaderTask;
import com.tencent.biz.qqcircle.preload.task.QCirclePolymerizationPreLoaderTask;
import com.tencent.biz.qqcircle.preload.task.QCirclePolymerizeDetailPreLoaderTask;
import com.tencent.biz.qqcircle.preload.task.QCircleTagPreLoaderTask;
import com.tencent.biz.qqcircle.publish.activity.QCirclePublishPicPreviewFragment;
import com.tencent.biz.qqcircle.publish.activity.QCircleUploadActivityFragment;
import com.tencent.biz.qqcircle.publish.outbox.QCirclePublishQueueFragment;
import com.tencent.biz.qqcircle.publish.preview.QCircleUploadPreviewerFragment;
import com.tencent.biz.qqcircle.publish.util.QcirclePublishJumpModel;
import com.tencent.biz.qqcircle.richframework.part.list.base.PublicListFragment;
import com.tencent.biz.qqcircle.richframework.util.FastClickUtils;
import com.tencent.biz.qqcircle.utils.PermissionUtils;
import com.tencent.biz.qqcircle.utils.QCircleBindPhoneNumberHelper;
import com.tencent.biz.qqcircle.widgets.QCircleCustomDialog;
import com.tencent.mobileqq.config.api.IAppSettingApi;
import com.tencent.mobileqq.engineering.preload.PreLoader;
import com.tencent.mobileqq.qcircle.api.constant.QCircleConstants;
import com.tencent.mobileqq.qcircle.api.constant.QCirclePeriodCollect;
import com.tencent.mobileqq.qcircle.api.data.QCircleHippyBean;
import com.tencent.mobileqq.qcircle.api.helper.HostUIHelper;
import com.tencent.mobileqq.qcircle.api.interfaces.QCircleHookPluginIntentCallBack;
import com.tencent.mobileqq.qcircle.api.utils.EeveeRedpointUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qcircle.application.QCircleApplication;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.common.RFWLauncher;
import cooperation.qqcircle.report.QCirclePublishQualityReporter;
import cooperation.qqcircle.report.QCircleReportHelper;
import cooperation.qqcircle.utils.QCircleCommonUtil;
import feedcloud.FeedCloudCommon.Entry;
import feedcloud.FeedCloudMeta.StTagInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;

public class QCircleLauncher
{
  private static void a(Activity paramActivity, Intent paramIntent, int paramInt)
  {
    if (paramActivity == null)
    {
      QLog.e("QCircleLauncher", 1, "activity is null,cannot start activity");
      return;
    }
    paramIntent.putExtra("key_bundle_open_page_time", System.currentTimeMillis());
    paramActivity.startActivityForResult(paramIntent, paramInt);
  }
  
  public static void a(Activity paramActivity, QCirclePicPreviewInitBean paramQCirclePicPreviewInitBean, int paramInt)
  {
    if (FastClickUtils.a("QCircleLauncher_launchPublishPicPreviewPage", 500L)) {
      return;
    }
    Intent localIntent = new Intent();
    localIntent.setClass(paramActivity, QCircleFragmentActivity.class);
    localIntent.putExtra("key_bundle_common_init_bean", paramQCirclePicPreviewInitBean);
    localIntent.putExtra("public_fragment_class", QCirclePublishPicPreviewFragment.class.getName());
    a(paramActivity, localIntent, paramInt);
  }
  
  public static void a(Context paramContext)
  {
    if (FastClickUtils.a("QCircleLauncher_llaunchOutboxPage", 500L)) {
      return;
    }
    Intent localIntent = new Intent();
    localIntent.addFlags(268435456);
    localIntent.setClass(paramContext, QCircleFragmentActivity.class);
    localIntent.putExtra("public_fragment_class", QCirclePublishQueueFragment.class.getName());
    QCircleLauncherUtil.a(paramContext, localIntent);
  }
  
  public static void a(Context paramContext, Intent paramIntent)
  {
    if (FastClickUtils.a("QCircleLauncher_launchPublishMoodPage", 500L)) {
      return;
    }
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    localIntent.addFlags(268435456);
    localIntent.setClass(QCircleApplication.APP, QCircleFragmentActivity.class);
    localIntent.putExtra(QCircleHostConstants._PublicFragmentActivity.KEY_FRAGMENT_CLASS(), QCircleUploadPreviewerFragment.class.getName());
    QCircleLauncherUtil.a(paramContext, localIntent);
  }
  
  public static void a(Context paramContext, Bundle paramBundle)
  {
    if (!FastClickUtils.a("QCircleLauncher_launchPublishMoodPage", 500L))
    {
      if (paramContext == null) {
        return;
      }
      Intent localIntent = new Intent();
      localIntent.addFlags(268435456);
      localIntent.setClass(paramContext, QCircleSingleTaskActivity.class);
      boolean bool = false;
      if (paramBundle != null)
      {
        localIntent.putExtras(paramBundle);
        bool = paramBundle.getBoolean("key_is_take_photo", true);
      }
      if (bool)
      {
        localIntent.putExtra("key_is_take_photo", true);
        new QcirclePublishJumpModel().a(paramContext, localIntent, null, false, QCircleHostConstants._AEEditorConstants.AE_PHOTO_PICKER_TAB_ALBUM());
        return;
      }
      localIntent.putExtra(QCircleHostConstants._PublicFragmentActivity.KEY_FRAGMENT_CLASS(), QCircleUploadActivityFragment.class.getName());
      QCircleLauncherUtil.a(paramContext, localIntent);
    }
  }
  
  public static void a(Context paramContext, Bundle paramBundle, String paramString1, int paramInt, String paramString2)
  {
    if (FastClickUtils.a("QCircleLauncher_launchQcirclePublishActiviy", 500L)) {
      return;
    }
    paramBundle.putInt("fromType", paramInt);
    boolean bool2 = TextUtils.isEmpty(paramString2);
    boolean bool1 = true;
    if (bool2)
    {
      paramString1 = QCirclePublishQualityReporter.getTraceId();
      paramBundle.putString(QCircleConstants.w, paramString1);
      QCirclePublishQualityReporter.report(QCirclePublishQualityReporter.E_PUBLIC_START, Arrays.asList(new FeedCloudCommon.Entry[] { QCircleReportHelper.newEntry("traceid", paramString1), QCircleReportHelper.newEntry("ext1", String.valueOf(paramInt)), QCircleReportHelper.newEntry("ret_code", "0") }));
    }
    else
    {
      paramBundle.putString(QCircleConstants.w, paramString2);
    }
    if (Build.VERSION.SDK_INT >= 23) {
      bool1 = PermissionUtils.a(paramContext);
    }
    if ((!bool1) && ((paramContext instanceof Activity)))
    {
      QCircleCustomDialog.b(paramContext);
      return;
    }
    a(paramContext, paramBundle);
  }
  
  public static void a(Context paramContext, QCircleAggregationBean paramQCircleAggregationBean)
  {
    if (FastClickUtils.a("QCircleLauncher_launchAggregationPage", 500L)) {
      return;
    }
    Intent localIntent = new Intent();
    localIntent.addFlags(268435456);
    localIntent.setClass(paramContext, QCircleFragmentActivity.class);
    localIntent.putExtra("key_bundle_common_init_bean", paramQCircleAggregationBean);
    localIntent.putExtra("public_fragment_class", QCircleTroopAggregationFragment.class.getName());
    QCircleLauncherUtil.a(paramContext, localIntent);
  }
  
  public static void a(Context paramContext, QCircleFolderBean paramQCircleFolderBean)
  {
    if (FastClickUtils.a("QCircleLauncher_launchFolderPage", 500L)) {
      return;
    }
    QCircleGpsHelper.a().c();
    QCirclePluginConfig.a().f();
    PreLoader.remove("2002");
    PreLoader.preLoad("2002", new QCircleFolderPreLoaderTask(QCircleGpsHelper.a().e(), paramQCircleFolderBean));
    Intent localIntent = new Intent();
    Object localObject = paramContext;
    if (paramContext == null) {
      localObject = QCircleApplication.APP;
    }
    if (paramQCircleFolderBean.getAttrs() != null) {
      QCircleLauncherUtil.a(localIntent, paramQCircleFolderBean.getAttrs());
    }
    localIntent.addFlags(268435456);
    localIntent.putExtra("key_bundle_common_init_bean", paramQCircleFolderBean);
    localIntent.setClass((Context)localObject, QCircleFolderActivity.class);
    localIntent.putExtra("key_bundle_open_page_time", System.currentTimeMillis());
    if (HostUIHelper.getInstance().getQCircleHookPluginIntentCallBack() != null)
    {
      HostUIHelper.getInstance().getQCircleHookPluginIntentCallBack().getPluginIntent(localIntent);
      HostUIHelper.getInstance().setPluginIntentHook(null);
      return;
    }
    ((Context)localObject).startActivity(localIntent);
    if (((localObject instanceof Activity)) && (paramQCircleFolderBean.getBottomMarginPx() != 0.0F)) {
      ((Activity)localObject).overridePendingTransition(2130772504, 2130772505);
    }
    QCirclePeriodCollect.record("folder_launch");
  }
  
  public static void a(Context paramContext, QCircleFollowUserBean paramQCircleFollowUserBean)
  {
    if (FastClickUtils.a("QCircleLauncher_launchSpecialFollowListPage", 500L)) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramQCircleFollowUserBean.getAdapterClassName());
    a(paramContext, localArrayList, null, paramQCircleFollowUserBean);
  }
  
  public static void a(Context paramContext, QCircleInitBean paramQCircleInitBean)
  {
    if (paramQCircleInitBean == null) {
      return;
    }
    if (FastClickUtils.a("QCircleLauncher_launchContentDetailPage", 500L)) {
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("public_fragment_class", QCircleFeedDetailFragment.class.getName());
    localIntent.putExtra("key_bundle_common_init_bean", paramQCircleInitBean);
    localIntent.addFlags(268435456);
    localIntent.setClass(paramContext, QCircleFragmentActivity.class);
    QCircleLauncherUtil.a(paramContext, localIntent);
  }
  
  public static void a(Context paramContext, QCircleLayerBean paramQCircleLayerBean)
  {
    if (FastClickUtils.a("QCircleLauncher_launchContentDetailPage", 500L)) {
      return;
    }
    Intent localIntent = new Intent();
    if ((paramQCircleLayerBean != null) && (paramQCircleLayerBean.getTagInfo().has()))
    {
      PreLoader.remove("2005");
      PreLoader.preLoad("2005", new QCircleTagPreLoaderTask(paramQCircleLayerBean, true));
    }
    if ((!QCircleConfigHelper.bg()) && (a()) && (QCircleFlutterUtils.a()))
    {
      QCircleFlutterLauncher.a(paramContext, paramQCircleLayerBean);
      return;
    }
    if ((paramContext instanceof Activity))
    {
      localIntent.putExtra("key_bundle_common_init_bean", paramQCircleLayerBean);
      localIntent.addFlags(268435456);
      localIntent.setClass(paramContext, QCircleLauncherUtil.c());
      localIntent.putExtra("public_fragment_window_feature", 1);
      localIntent.putExtra("public_fragment_class", QCircleLauncherUtil.b());
      localIntent.putExtra("key_bundle_open_page_time", System.currentTimeMillis());
      paramContext = (Activity)paramContext;
      paramContext.startActivity(localIntent);
      paramContext.overridePendingTransition(0, 0);
      return;
    }
    QCircleLauncherUtil.a(paramContext, localIntent);
  }
  
  public static void a(Context paramContext, QCircleLikeBean paramQCircleLikeBean)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCircleLikeListBlock.class.getName());
    a(paramContext, localArrayList, null, paramQCircleLikeBean);
  }
  
  public static void a(Context paramContext, QCirclePolymerizationBean paramQCirclePolymerizationBean)
  {
    if (FastClickUtils.a("QCircleLauncher_launchPolymerizationPage", 500L)) {
      return;
    }
    PreLoader.remove("2008");
    PreLoader.preLoad("2008", new QCirclePolymerizationPreLoaderTask(paramQCirclePolymerizationBean));
    Intent localIntent = new Intent();
    localIntent.addFlags(268435456);
    localIntent.setClass(paramContext, QCircleFragmentActivity.class);
    localIntent.putExtra("key_bundle_common_init_bean", paramQCirclePolymerizationBean);
    localIntent.putExtra("public_fragment_class", QCirclePolymerizationFragment.class.getName());
    QCircleLauncherUtil.a(paramContext, localIntent);
  }
  
  public static void a(Context paramContext, QCirclePolymerizeDetailBean paramQCirclePolymerizeDetailBean)
  {
    if (FastClickUtils.a("QCircleLauncher_launchPolymerizeDetailPage", 500L)) {
      return;
    }
    PreLoader.remove("2009");
    PreLoader.preLoad("2009", new QCirclePolymerizeDetailPreLoaderTask(paramQCirclePolymerizeDetailBean));
    Intent localIntent = new Intent();
    localIntent.addFlags(268435456);
    localIntent.setClass(paramContext, QCircleFragmentActivity.class);
    localIntent.putExtra("key_bundle_common_init_bean", paramQCirclePolymerizeDetailBean);
    localIntent.putExtra("public_fragment_class", QCirclePolymerizeDetailFragment.class.getName());
    QCircleLauncherUtil.a(paramContext, localIntent);
  }
  
  public static void a(Context paramContext, QCircleSettingBean paramQCircleSettingBean)
  {
    if (FastClickUtils.a("QCircleLauncher_launchSettingPage", 500L)) {
      return;
    }
    Intent localIntent = new Intent();
    localIntent.addFlags(268435456);
    localIntent.setClass(paramContext, QCircleFragmentActivity.class);
    localIntent.putExtra("public_fragment_class", QCircleSettingFragment.class.getName());
    localIntent.putExtra("key_bundle_common_init_bean", paramQCircleSettingBean);
    QCircleLauncherUtil.a(paramContext, localIntent);
  }
  
  public static void a(Context paramContext, QFSMusicAggregationInitBean paramQFSMusicAggregationInitBean)
  {
    if (FastClickUtils.a("QCircleLauncherlaunchMusicAggregationPage", 500L)) {
      return;
    }
    PreLoader.remove("2013");
    PreLoader.preLoad("2013", new QFSMusicAggregationPreLoaderTask(paramQFSMusicAggregationInitBean));
    Intent localIntent = new Intent();
    localIntent.addFlags(268435456);
    localIntent.setClass(paramContext, QCircleFragmentActivity.class);
    localIntent.putExtra("key_bundle_common_init_bean", paramQFSMusicAggregationInitBean);
    localIntent.putExtra("public_fragment_class", QFSMusicAggregationFragment.class.getName());
    QCircleLauncherUtil.a(paramContext, localIntent);
  }
  
  public static void a(Context paramContext, QCircleHippyBean paramQCircleHippyBean)
  {
    if ((paramContext != null) && (paramQCircleHippyBean != null))
    {
      Object localObject;
      if (QCircleCommonUtil.isInNightMode()) {
        localObject = "1";
      } else {
        localObject = "0";
      }
      paramQCircleHippyBean.setTheme((String)localObject);
      if (!TextUtils.isEmpty(paramQCircleHippyBean.getModuleName()))
      {
        if (QCircleConfigHelper.a())
        {
          localObject = new Intent();
          paramQCircleHippyBean.setStartTime(System.currentTimeMillis());
          ((Intent)localObject).putExtra("key_hippy_bean", paramQCircleHippyBean);
          QCircleHostLauncher.startQCircleHippyActivity(paramContext, (Intent)localObject);
          return;
        }
        a(paramContext, paramQCircleHippyBean.getDefaultUrl(), null, -1);
        return;
      }
      a(paramContext, paramQCircleHippyBean.getDefaultUrl(), null, -1);
    }
  }
  
  public static void a(Context paramContext, String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("QCircleLauncher", 1, "url is empty");
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("handleUrl:");
    ((StringBuilder)localObject).append(paramString);
    QLog.d("QCircleLauncher", 1, ((StringBuilder)localObject).toString());
    int i = QCirclePluginUtil.a(paramString);
    if (i == 0)
    {
      a(paramContext, paramString, null, -1);
      return;
    }
    if (i == 1)
    {
      if ((paramString != null) && ((paramString.contains("opencamera")) || (paramString.contains("openpublish"))) && (!QCircleBindPhoneNumberHelper.a()))
      {
        QCircleBindPhoneNumberHelper.a(paramContext, 1);
        return;
      }
      localObject = new Intent(paramContext, QCircleHostClassHelper.getJumpActivityClass());
      ((Intent)localObject).setData(Uri.parse(paramString));
      paramContext.startActivity((Intent)localObject);
    }
  }
  
  public static void a(Context paramContext, String paramString, Intent paramIntent, int paramInt)
  {
    if (paramContext == null)
    {
      QLog.i("QCircleLauncher", 1, "launchQCircleHybirdActivity context == null");
      return;
    }
    if (TextUtils.isEmpty(paramString))
    {
      QLog.i("QCircleLauncher", 1, "launchQCircleHybirdActivity url isEmpty");
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("launchQCircleHybirdActivity url:");
    ((StringBuilder)localObject).append(paramString);
    QLog.i("QCircleLauncher", 1, ((StringBuilder)localObject).toString());
    if (!QCircleJsUrlConfig.a(paramString))
    {
      QLog.i("QCircleLauncher", 1, "launchQCircleHybirdActivity url is Invalid");
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("launchQCircleHybirdActivity:");
    ((StringBuilder)localObject).append(paramString);
    if (FastClickUtils.a(((StringBuilder)localObject).toString(), 1500L))
    {
      QLog.i("QCircleLauncher", 1, "launchQCircleHybirdActivity is fast double click");
      return;
    }
    localObject = paramIntent;
    if (paramIntent == null) {
      localObject = new Intent();
    }
    if (!paramString.contains("?"))
    {
      paramIntent = new StringBuilder();
      paramIntent.append(paramString);
      paramIntent.append("?");
      paramString = paramIntent.toString();
    }
    else
    {
      paramIntent = new StringBuilder();
      paramIntent.append(paramString);
      paramIntent.append("&");
      paramString = paramIntent.toString();
    }
    paramIntent = new StringBuilder();
    paramIntent.append(paramString);
    paramIntent.append("plugin_version=");
    paramIntent.append(1);
    paramString = QCircleHostLauncher.handleQCircleHybirdActivityIntent(paramContext, paramIntent.toString(), (Intent)localObject, paramInt);
    paramString.putExtra("web_color_note_type", 3);
    if ((paramContext instanceof FragmentActivity))
    {
      ((FragmentActivity)paramContext).startActivityForResult(paramString, paramInt);
      return;
    }
    paramContext.startActivity(paramString);
  }
  
  private static void a(Context paramContext, ArrayList<String> paramArrayList, ArrayList paramArrayList1, QCircleInitBean paramQCircleInitBean)
  {
    Intent localIntent = new Intent();
    localIntent.setClass(paramContext, QCircleFragmentActivity.class);
    localIntent.putExtra("public_fragment_class", PublicListFragment.class.getName());
    localIntent.putExtra("public_list_block_class_array", paramArrayList);
    localIntent.putExtra("public_list_init_data", paramArrayList1);
    localIntent.putExtra("key_bundle_common_init_bean", paramQCircleInitBean);
    localIntent.addFlags(268435456);
    QCircleLauncherUtil.a(paramContext, localIntent);
  }
  
  public static void a(List<JSONObject> paramList)
  {
    paramList = new ArrayList();
    paramList.add(QCircleBlockCheckListBlock.class.getName());
    a(QCircleApplication.APP, paramList, null, null);
  }
  
  private static boolean a()
  {
    boolean bool = QCircleLauncherUtil.a();
    if (((IAppSettingApi)QRoute.api(IAppSettingApi.class)).isDebugVersion())
    {
      if (QCirclePluginConfig.b().getBoolean("qcircle_force_enable_floatlayer_flutter", true))
      {
        QLog.w("QCircleLauncher", 1, "[launchContentLayerPage] force flutter page");
        return true;
      }
      QLog.w("QCircleLauncher", 1, "[launchContentLayerPage] use native page");
      bool = false;
    }
    return bool;
  }
  
  public static void b(Context paramContext)
  {
    if (FastClickUtils.a("QCircleLauncher_launchChangeMsfServerPage", 500L)) {
      return;
    }
    RFWLauncher.a(paramContext);
  }
  
  public static void b(Context paramContext, QCircleInitBean paramQCircleInitBean)
  {
    if (FastClickUtils.a("QCircleLauncher_launchPersonalDetailPage", 500L)) {
      return;
    }
    QCircleLauncherUtil.a(paramQCircleInitBean);
    Intent localIntent = new Intent();
    localIntent.addFlags(268435456);
    localIntent.setClass(paramContext, QCircleFragmentActivity.class);
    localIntent.putExtra("key_bundle_common_init_bean", paramQCircleInitBean);
    localIntent.putExtra("public_fragment_class", QCircleLauncherUtil.d());
    QCircleLauncherUtil.a(paramContext, localIntent);
  }
  
  public static void b(Context paramContext, QCirclePolymerizeDetailBean paramQCirclePolymerizeDetailBean)
  {
    if (FastClickUtils.a("QCircleLauncher_launchPolymerizeRecommendPage", 500L)) {
      return;
    }
    PreLoader.remove("2010");
    PreLoader.preLoad("2010", new QCircleNewPolymerizeDetailPreLoaderTask(paramQCirclePolymerizeDetailBean));
    Intent localIntent = new Intent();
    localIntent.addFlags(268435456);
    localIntent.setClass(paramContext, QCircleFragmentActivity.class);
    localIntent.putExtra("key_bundle_common_init_bean", paramQCirclePolymerizeDetailBean);
    localIntent.putExtra("public_fragment_class", QCircleNewPolymerizeDetailFragment.class.getName());
    QCircleLauncherUtil.a(paramContext, localIntent);
  }
  
  public static void b(Context paramContext, @Nullable QCircleSettingBean paramQCircleSettingBean)
  {
    if (FastClickUtils.a("QCircleLauncher_launchPrivacySettingPage", 500L)) {
      return;
    }
    Intent localIntent = new Intent();
    localIntent.addFlags(268435456);
    localIntent.setClass(paramContext, QCircleFragmentActivity.class);
    localIntent.putExtra("public_fragment_class", QCirclePrivacySettingFragment.class.getName());
    if (paramQCircleSettingBean != null) {
      localIntent.putExtra("key_bundle_common_init_bean", paramQCircleSettingBean);
    }
    QCircleLauncherUtil.a(paramContext, localIntent);
  }
  
  public static void c(Context paramContext)
  {
    if (FastClickUtils.a("QCircleLauncher_launchMockLbsPage", 500L)) {
      return;
    }
    Intent localIntent = new Intent();
    localIntent.addFlags(268435456);
    localIntent.setClass(paramContext, QCircleFragmentActivity.class);
    localIntent.putExtra("public_fragment_class", QCircleMockLbsFragment.class.getName());
    QCircleLauncherUtil.a(paramContext, localIntent);
  }
  
  public static void c(Context paramContext, QCircleInitBean paramQCircleInitBean)
  {
    if (FastClickUtils.a("QCircleLauncher_launchDataEditPage", 500L)) {
      return;
    }
    Intent localIntent = new Intent();
    localIntent.addFlags(268435456);
    localIntent.setClass(paramContext, QCircleFragmentActivity.class);
    localIntent.putExtra("key_bundle_common_init_bean", paramQCircleInitBean);
    localIntent.putExtra("public_fragment_class", QCircleDataEditFragment.class.getName());
    QCircleLauncherUtil.a(paramContext, localIntent);
  }
  
  public static void d(Context paramContext, QCircleInitBean paramQCircleInitBean)
  {
    if (FastClickUtils.a("QCircleLauncher_launchPrivateMessageSettingPage", 500L)) {
      return;
    }
    Intent localIntent = new Intent();
    localIntent.addFlags(268435456);
    localIntent.setClass(paramContext, QCircleFragmentActivity.class);
    localIntent.putExtra("key_bundle_common_init_bean", paramQCircleInitBean);
    localIntent.putExtra("public_fragment_class", QCirclePrivateMessageSettingFragment.class.getName());
    QCircleLauncherUtil.a(paramContext, localIntent);
  }
  
  public static void e(Context paramContext, QCircleInitBean paramQCircleInitBean)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCircleBlackListBlock.class.getName());
    a(paramContext, localArrayList, null, paramQCircleInitBean);
  }
  
  public static void f(Context paramContext, QCircleInitBean paramQCircleInitBean)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCircleMessageListBlock.class.getName());
    localArrayList.add(QCircleChatListBlock.class.getName());
    a(paramContext, localArrayList, null, paramQCircleInitBean);
    QCircleHostQzoneHelper.cleanQCirclePush();
    EeveeRedpointUtil.saveFolderMessageNoticeBubbleLastExposeNum(0);
  }
  
  public static void g(Context paramContext, QCircleInitBean paramQCircleInitBean)
  {
    if (FastClickUtils.a("QCircleLauncher_launchDraftPage", 500L)) {
      return;
    }
    Intent localIntent = new Intent();
    localIntent.addFlags(268435456);
    localIntent.setClass(paramContext, QCircleFragmentActivity.class);
    localIntent.putExtra("key_bundle_common_init_bean", paramQCircleInitBean);
    localIntent.putExtra("public_fragment_class", QCircleDraftFragment.class.getName());
    QCircleLauncherUtil.a(paramContext, localIntent);
  }
  
  public static void h(Context paramContext, QCircleInitBean paramQCircleInitBean)
  {
    if (FastClickUtils.a("QCircleLauncher_launchFullScreenPage", 500L)) {
      return;
    }
    Intent localIntent = new Intent();
    localIntent.addFlags(268435456);
    localIntent.setClass(paramContext, QCircleFragmentActivity.class);
    localIntent.putExtra("key_bundle_common_init_bean", paramQCircleInitBean);
    localIntent.putExtra("public_fragment_class", QFSFullScreenFragment.class.getName());
    QCircleLauncherUtil.a(paramContext, localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.launcher.QCircleLauncher
 * JD-Core Version:    0.7.0.1
 */