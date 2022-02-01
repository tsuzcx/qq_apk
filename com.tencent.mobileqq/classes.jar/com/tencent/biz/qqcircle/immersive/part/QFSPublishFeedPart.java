package com.tencent.biz.qqcircle.immersive.part;

import android.app.Activity;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants.PeakConstants;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants._QQStoryMainActivity;
import com.tencent.biz.qcircleshadow.lib.QCircleHostLauncher;
import com.tencent.biz.qcircleshadow.lib.QCirclePluginInitHelper;
import com.tencent.biz.qcircleshadow.lib.variation.HostDataTransUtils;
import com.tencent.biz.qqcircle.QCirclePluginConfig;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.immersive.events.QFSFeedPositionChangeEvent;
import com.tencent.biz.qqcircle.immersive.events.QFSFolderLazyInitEvent;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSPageSelectEvent;
import com.tencent.biz.qqcircle.immersive.utils.QFSPublishTipsUtils;
import com.tencent.biz.qqcircle.launcher.QCircleLauncher;
import com.tencent.biz.qqcircle.localphoto.scan.QCirclePhotoScanManager;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.publish.account.LoginData;
import com.tencent.biz.qqcircle.publish.queue.QCircleTaskQueue;
import com.tencent.biz.qqcircle.publish.viewmodel.QCirclePublishViewModel;
import com.tencent.biz.qqcircle.richframework.part.ReportBean;
import com.tencent.biz.qqcircle.utils.QCircleBindPhoneNumberHelper;
import com.tencent.biz.qqcircle.utils.QCirclePermissionUtil;
import com.tencent.biz.qqcircle.widgets.dialog.QCircleLoadingDialog;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.qcircle.api.constant.QCircleConstants;
import com.tencent.mobileqq.qcircle.api.global.QCircleHostGlobalInfo;
import com.tencent.mobileqq.qcircle.api.helper.HostUIHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.winkpublish.api.IUploadCommonSetting;
import com.tencent.mobileqq.winkpublish.api.IUploadTaskManager;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import cooperation.qqcircle.report.QCircleLpReportDc05504.DataBuilder;
import cooperation.qqcircle.report.QCirclePublishQualityReporter;
import cooperation.qqcircle.report.QCircleReportBean;
import cooperation.qqcircle.report.QCircleReportHelper;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import feedcloud.FeedCloudCommon.Entry;
import feedcloud.FeedCloudMeta.StUser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class QFSPublishFeedPart
  extends QFSBasePart
  implements View.OnClickListener, SimpleEventReceiver
{
  private ImageView a;
  private FeedCloudMeta.StUser b;
  private QCircleLoadingDialog c;
  private int d = 16;
  private boolean e = false;
  private ReportBean<QCircleReportBean> f;
  private boolean g = false;
  private boolean h = false;
  private String i;
  private QFSPublishTipsUtils j = new QFSPublishTipsUtils();
  private boolean k = false;
  
  public QFSPublishFeedPart(FeedCloudMeta.StUser paramStUser)
  {
    this.b = paramStUser;
    f();
  }
  
  private void a(Intent paramIntent)
  {
    if (paramIntent != null)
    {
      paramIntent = paramIntent.getExtras();
      if (paramIntent == null) {
        return;
      }
      b(paramIntent);
    }
  }
  
  private void a(Intent paramIntent1, Intent paramIntent2)
  {
    if (paramIntent1 != null)
    {
      paramIntent1 = paramIntent1.getExtras();
      if (paramIntent1 != null)
      {
        if (!paramIntent1.getBoolean("key_is_take_photo")) {
          return;
        }
        paramIntent1.putBoolean("key_is_take_photo", false);
        if ((paramIntent2 != null) && (paramIntent2.getSerializableExtra("key_bundle_common_init_bean") != null)) {
          paramIntent1.putSerializable("key_bundle_common_init_bean", paramIntent2.getSerializableExtra("key_bundle_common_init_bean"));
        }
        QCircleLauncher.a(g(), paramIntent1);
        a(paramIntent1);
        return;
      }
      return;
    }
    QCircleLauncher.a(g(), null);
  }
  
  private void a(@NonNull Bundle paramBundle)
  {
    String str = paramBundle.getString(QCircleConstants.w, "");
    int m = paramBundle.getInt("fromType", 1);
    QCirclePublishQualityReporter.report(QCirclePublishQualityReporter.E_PICKER_EXIT_NORMAL, Arrays.asList(new FeedCloudCommon.Entry[] { QCircleReportHelper.newEntry("traceid", str), QCircleReportHelper.newEntry("ext1", String.valueOf(m)), QCircleReportHelper.newEntry("ret_code", "0") }));
  }
  
  private void a(@NonNull QFSFeedPositionChangeEvent paramQFSFeedPositionChangeEvent)
  {
    if (paramQFSFeedPositionChangeEvent.getPosition() != 1) {
      return;
    }
    q();
  }
  
  private void a(@NonNull QFSFolderLazyInitEvent paramQFSFolderLazyInitEvent)
  {
    if (paramQFSFolderLazyInitEvent.getLazyInitType() == 2) {
      paramQFSFolderLazyInitEvent.execute(new QFSPublishFeedPart.2(this));
    }
  }
  
  private void a(QFSPageSelectEvent paramQFSPageSelectEvent)
  {
    QLog.d("QFSPublishFeedPart", 1, new Object[] { "[handlerPageSelectEvent] event selected position: ", Integer.valueOf(paramQFSPageSelectEvent.mSelectPosition) });
    c(i(), this.d);
  }
  
  private void a(Object paramObject)
  {
    if ((!this.e) && ((paramObject instanceof Integer)))
    {
      int m = ((Integer)paramObject).intValue();
      if (m == 1) {
        this.d = 16;
      } else if (m == 6) {
        this.d = 17;
      } else if (m == 4) {
        this.d = 18;
      }
      QLog.d("QFSPublishFeedPart", 1, new Object[] { "[handleNewLayerTabChangedEvent]... type:", Integer.valueOf(m), " fromType:", Integer.valueOf(this.d) });
    }
  }
  
  private QCircleLpReportDc05504.DataBuilder b(int paramInt1, int paramInt2)
  {
    return new QCircleLpReportDc05504.DataBuilder().setToUin(HostDataTransUtils.getAccount()).setActionType(14).setThrActionType(0).setExt1(String.valueOf(paramInt2)).setExt3(String.valueOf(System.currentTimeMillis())).setExt6("0").setPageId(paramInt1);
  }
  
  private void b(@NonNull Bundle paramBundle)
  {
    String str = paramBundle.getString(QCircleConstants.w, "");
    int m = paramBundle.getInt("fromType", 16);
    QCirclePublishQualityReporter.report(QCirclePublishQualityReporter.E_PICKER_EXIT_CANCEL, Arrays.asList(new FeedCloudCommon.Entry[] { QCircleReportHelper.newEntry("traceid", str), QCircleReportHelper.newEntry("ext1", String.valueOf(m)), QCircleReportHelper.newEntry("ret_code", "0") }));
  }
  
  private void c(int paramInt1, int paramInt2)
  {
    QCircleLpReportDc05504.report(b(paramInt1, paramInt2).setSubActionType(1));
  }
  
  private void c(Bundle paramBundle)
  {
    if ((c() != null) && (c().getIntent() != null) && (c().getIntent().hasExtra("key_attrs")))
    {
      paramBundle.putSerializable("key_attrs", (HashMap)c().getIntent().getSerializableExtra("key_attrs"));
      c().getIntent().putExtra("key_attrs", new HashMap());
    }
  }
  
  private String d(Bundle paramBundle)
  {
    if ((c() != null) && (c().getIntent() != null) && (c().getIntent().hasExtra("key_scheme")))
    {
      String str = c().getIntent().getStringExtra("key_scheme");
      paramBundle.putString("key_scheme", str);
      c().getIntent().putExtra("key_scheme", "");
      return str;
    }
    return "";
  }
  
  private void f()
  {
    if ((c() != null) && (c().getIntent() != null) && (c().getIntent().hasExtra("key_scheme")) && (!TextUtils.isEmpty(c().getIntent().getStringExtra("key_scheme"))))
    {
      if (c().getIntent().hasExtra("fromType"))
      {
        this.e = true;
        this.d = c().getIntent().getIntExtra("fromType", this.d);
        return;
      }
      this.e = true;
      this.d = 7;
    }
  }
  
  private void n()
  {
    if (!this.k)
    {
      this.k = true;
      o();
    }
  }
  
  private void o()
  {
    long l = System.currentTimeMillis();
    QCircleHostLauncher.isCameraResReady();
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onInitView... isCameraResReady cost:");
      localStringBuilder.append(System.currentTimeMillis() - l);
      QLog.d("[Performance2]QFSPublishFeedPart", 1, localStringBuilder.toString());
    }
  }
  
  private Object p()
  {
    if (QCircleHostGlobalInfo.getFolderUIType() == 3) {
      return "upper_right";
    }
    return "bottom_middle";
  }
  
  private void q()
  {
    if (QCircleHostGlobalInfo.getFolderUIType() != 3) {
      return;
    }
    Object localObject = this.a;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = ((ImageView)localObject).getParent();
    }
    if (!(localObject instanceof View))
    {
      QLog.d("QFSPublishFeedPart", 1, "[tryShowPublishPopupTips] parent not is view type.");
      return;
    }
    if (this.j == null)
    {
      QLog.d("QFSPublishFeedPart", 1, "[tryShowPublishPopupTips] publish tips utils should not be null.");
      return;
    }
    if (QCirclePluginConfig.a().N())
    {
      QLog.d("QFSPublishFeedPart", 1, "[tryShowPublishPopupTips] current publish guide tips flag...");
      return;
    }
    this.j.a(this.a);
    QCirclePluginConfig.a().h(true);
  }
  
  private boolean r()
  {
    if ((QCirclePublishViewModel.a(LoginData.a().b())) && (s()))
    {
      QLog.d("QFSPublishFeedPart", 1, "onClick... hasDraft");
      t();
      return true;
    }
    return false;
  }
  
  private boolean s()
  {
    if ((c() != null) && (c().getIntent() != null)) {
      return c().getIntent().getBooleanExtra("key_need_use_draft", false);
    }
    return true;
  }
  
  private void t()
  {
    if (Build.VERSION.SDK_INT >= 23) {
      QCirclePermissionUtil.a(c(), new QFSPublishFeedPart.1(this), 0, new String[] { "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE" });
    } else {
      u();
    }
    a(i(), this.d);
  }
  
  private void u()
  {
    if (!QCircleBindPhoneNumberHelper.a())
    {
      QCircleBindPhoneNumberHelper.a(c(), 1);
      return;
    }
    n();
    QLog.d("[Performance2]QFSPublishFeedPart", 1, "handlePublishEntranceClickNew...");
    this.i = QCirclePublishQualityReporter.getTraceId();
    String str = QCirclePublishQualityReporter.E_PUBLIC_START;
    Object localObject = str;
    if (QCircleConfigHelper.bh())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(((IUploadCommonSetting)QRoute.api(IUploadCommonSetting.class)).getSpKey());
      ((StringBuilder)localObject).append("_");
      ((StringBuilder)localObject).append(str);
      localObject = ((StringBuilder)localObject).toString();
    }
    if (QCirclePluginInitHelper.isPeakAlive(g()))
    {
      QCirclePublishQualityReporter.report((String)localObject, Arrays.asList(new FeedCloudCommon.Entry[] { QCircleReportHelper.newEntry("traceid", this.i), QCircleReportHelper.newEntry("ext1", String.valueOf(this.d)), QCircleReportHelper.newEntry("ext2", "PeakAlive"), QCircleReportHelper.newEntry("ret_code", "0") }));
      v();
      return;
    }
    QCirclePublishQualityReporter.report((String)localObject, Arrays.asList(new FeedCloudCommon.Entry[] { QCircleReportHelper.newEntry("traceid", this.i), QCircleReportHelper.newEntry("ext1", String.valueOf(this.d)), QCircleReportHelper.newEntry("ext2", "PeakNoAlive"), QCircleReportHelper.newEntry("ret_code", "0") }));
    localObject = this.c;
    if (localObject != null) {
      ((QCircleLoadingDialog)localObject).a();
    }
    QCirclePluginInitHelper.preloadPeakProcess(g());
    v();
  }
  
  private void v()
  {
    long l = Long.parseLong(HostDataTransUtils.getAccount());
    Bundle localBundle = w();
    String str = d(localBundle);
    c(localBundle);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("jumpToPublishPage... schema:");
    localStringBuilder.append(str);
    QLog.d("QFSPublishFeedPart", 1, localStringBuilder.toString());
    QCircleLauncher.a(c(), localBundle, String.valueOf(l), this.d, this.i);
    if ((QCircleConfigHelper.a(HostDataTransUtils.isStudyMode())) && (!TextUtils.isEmpty(str))) {
      c().finish();
    }
  }
  
  private Bundle w()
  {
    Bundle localBundle = new Bundle();
    localBundle.putLong(QCircleHostConstants.PeakConstants.TIME_STAMP(), System.currentTimeMillis());
    localBundle.putLong(QCircleHostConstants.PeakConstants.TIMESTAMP_LAST_ACTIVITY(), System.currentTimeMillis());
    localBundle.putInt("key_qcircle_entrance_type", 3);
    localBundle.putBoolean("bundle_key_select_qq_photo", this.h);
    localBundle.putBoolean("bundle_key_allow_long_video", this.g);
    localBundle.putBoolean("key_qcircle_reopen_carema", true);
    localBundle.putAll(c().getIntent().getExtras());
    localBundle.putBoolean("key_qcircle_publish_smart_block_buster", QCirclePhotoScanManager.f());
    QCircleInitBean localQCircleInitBean = new QCircleInitBean();
    localQCircleInitBean.setFromReportBean(l().clone());
    localBundle.putSerializable("key_bundle_common_init_bean", localQCircleInitBean);
    return localBundle;
  }
  
  public String a()
  {
    return "QFSPublishFeedPart";
  }
  
  public void a(int paramInt)
  {
    if (!this.e) {
      this.d = paramInt;
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    QLog.d("QFSPublishFeedPart", 1, "publish button click: actiontype:14,subActionType:2,thrActionType:0,report to dc05504");
    QCircleLpReportDc05504.report(b(paramInt1, paramInt2).setSubActionType(2));
    QCirclePublishQualityReporter.report(QCirclePublishQualityReporter.E_PUBLISH_CLICK, Arrays.asList(new FeedCloudCommon.Entry[] { QCircleReportHelper.newEntry("ext1", "publish button click: actiontype:14,subActionType:2,thrActionType:0,report to dc05504") }));
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if (256 == paramInt1)
    {
      e();
      return;
    }
    if (257 == paramInt1) {
      return;
    }
    if (QCircleHostConstants._QQStoryMainActivity.REQUEST_CODE_TAKE_VIDEO() == paramInt1) {
      a(paramInt2, paramIntent);
    }
  }
  
  void a(int paramInt, Intent paramIntent)
  {
    HostUIHelper.closeHostEnvironment();
    Intent localIntent = c().getIntent();
    if (paramInt == -1)
    {
      a(paramIntent, localIntent);
      return;
    }
    if (paramInt == 0) {
      a(paramIntent);
    }
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    this.a = ((ImageView)paramView.findViewById(2131442021));
    this.a.setOnClickListener(this);
    if (QCirclePluginUtil.b(this.b)) {
      this.a.setVisibility(0);
    } else {
      this.a.setVisibility(8);
    }
    paramView = new QCircleDTParamBuilder().buildElementParams();
    paramView.put("xsj_camera_position", p());
    VideoReport.setElementId(this.a, "em_xsj_edit_button");
    VideoReport.setElementParams(this.a, paramView);
    if (this.c == null) {
      this.c = new QCircleLoadingDialog(g());
    }
  }
  
  public void a(ReportBean<QCircleReportBean> paramReportBean)
  {
    this.f = paramReportBean;
  }
  
  public void a(String paramString, Object paramObject)
  {
    super.a(paramString, paramObject);
    if (TextUtils.equals(paramString, "tab_changed_new_layer"))
    {
      a(paramObject);
      return;
    }
    if (TextUtils.equals(paramString, "publish_on_click")) {
      d();
    }
  }
  
  public void d()
  {
    ImageView localImageView = this.a;
    if (localImageView != null) {
      localImageView.performClick();
    }
  }
  
  void e()
  {
    QLog.d("QFSPublishFeedPart", 1, "doOnActivityResult，return from qzone publish page");
    QCircleReportHelper.getInstance().recordPageEndShow(36, true);
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QFSPageSelectEvent.class);
    localArrayList.add(QFSFeedPositionChangeEvent.class);
    localArrayList.add(QFSFolderLazyInitEvent.class);
    return localArrayList;
  }
  
  public QCircleReportBean l()
  {
    ReportBean localReportBean = this.f;
    if (localReportBean != null) {
      return (QCircleReportBean)localReportBean.getReportBean();
    }
    return super.l();
  }
  
  public void onActivityPaused(Activity paramActivity)
  {
    super.onActivityPaused(paramActivity);
    QCirclePhotoScanManager.a().d();
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    super.onActivityResumed(paramActivity);
    paramActivity = this.a;
    if (paramActivity != null) {
      paramActivity.setClickable(true);
    }
    SimpleEventBus.getInstance().registerReceiver(this);
    QCirclePhotoScanManager.a().c();
  }
  
  public void onActivityStopped(Activity paramActivity)
  {
    super.onActivityStopped(paramActivity);
    SimpleEventBus.getInstance().unRegisterReceiver(this);
    Object localObject = this.c;
    if ((localObject != null) && (((QCircleLoadingDialog)localObject).isShowing())) {
      this.c.dismiss();
    }
    localObject = this.j;
    if (localObject != null) {
      ((QFSPublishTipsUtils)localObject).a(paramActivity);
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131442021)
    {
      QLog.e("QFSPublishFeedPart", 1, "click publish start");
      if ((QCircleConfigHelper.bg()) && ((((IUploadTaskManager)QRoute.api(IUploadTaskManager.class)).hasRunningTask()) || (QCircleTaskQueue.a().e()))) {
        QCircleToast.a(QCircleToast.b, 2131896236, 0);
      } else if (!r()) {
        t();
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof QFSPageSelectEvent))
    {
      a((QFSPageSelectEvent)paramSimpleBaseEvent);
      return;
    }
    if ((paramSimpleBaseEvent instanceof QFSFeedPositionChangeEvent))
    {
      a((QFSFeedPositionChangeEvent)paramSimpleBaseEvent);
      return;
    }
    if ((paramSimpleBaseEvent instanceof QFSFolderLazyInitEvent)) {
      a((QFSFolderLazyInitEvent)paramSimpleBaseEvent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.part.QFSPublishFeedPart
 * JD-Core Version:    0.7.0.1
 */