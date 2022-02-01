package com.tencent.biz.qqcircle.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.Window;
import com.tencent.biz.qqcircle.QCirclePluginConfig;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QCircleFolderBean;
import com.tencent.biz.qqcircle.folder.QCirclePageLayoutTypeHelper;
import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import com.tencent.biz.qqcircle.fragments.main.QCircleFolderActivityFragment;
import com.tencent.biz.qqcircle.immersive.QFSFolderFragment;
import com.tencent.biz.qqcircle.localphoto.scan.QCirclePhotoScanManager;
import com.tencent.biz.qqcircle.richframework.util.preloadview.LayoutPreLoader;
import com.tencent.biz.qqcircle.scrollers.QCircleFeedPlayerScroller;
import com.tencent.biz.qqcircle.widgets.feed.QCircleWaterfallFeedItemView;
import com.tencent.biz.qqcircle.widgets.pymk.QCirclePYMKRecommendView;
import com.tencent.biz.richframework.compat.CompatPublicFragment;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.mobileqq.qcircle.api.constant.QCirclePeriodCollect;
import com.tencent.mobileqq.qcircle.api.global.QCircleHostGlobalInfo;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.eevee.QCircleEeveeMananger;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.relation.QCircleRelationGroupManager;
import cooperation.qqcircle.report.QCircleReportHelper;
import cooperation.qqcircle.report.QCircleReporter;

public class QCircleFolderActivity
  extends QCircleFragmentActivity
{
  private void i()
  {
    if (QCirclePluginConfig.a().k())
    {
      QLog.d("LayoutPreLoader", 1, "preInflateViews");
      j();
    }
    QCircleReportHelper.getInstance().pushPageScene(0);
    QCircleRelationGroupManager.instance().loadRelationGroup();
    QCircleEeveeMananger.getInstance().onSend(5, null, null);
    QCirclePageLayoutTypeHelper.a().c();
    QCirclePhotoScanManager.a().b();
    QCirclePeriodCollect.record("folder_init");
  }
  
  private void j()
  {
    LayoutPreLoader.a().a(hashCode(), 2131626807, 10);
    LayoutPreLoader.a().a(hashCode(), 2131626805, 10);
    LayoutPreLoader.a().a(hashCode(), 2131626810, 10);
    LayoutPreLoader.a().a(hashCode(), 2131626816, 10);
    LayoutPreLoader.a().a(hashCode(), 2131626806, 10);
    LayoutPreLoader.a().a(hashCode(), 2131626809, 10);
    LayoutPreLoader.a().a(hashCode(), 2131626802, 10);
    LayoutPreLoader.a().a(hashCode(), 2131626804, 10);
    LayoutPreLoader.a().a(hashCode(), 2131626812, 10);
    LayoutPreLoader.a().a(hashCode(), QCirclePYMKRecommendView.class, 3);
    LayoutPreLoader.a().a(hashCode(), 2131626795, 3);
    if (QCirclePluginConfig.H()) {
      LayoutPreLoader.a().a(hashCode(), 2131626811, 10);
    }
    if (QCircleConfigHelper.aD()) {
      LayoutPreLoader.a().a(hashCode(), QCircleWaterfallFeedItemView.class, 10);
    }
  }
  
  public QCircleBaseFragment a()
  {
    if (QCircleConfigHelper.bg()) {
      return new QFSFolderFragment();
    }
    return new QCircleFolderActivityFragment();
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    QCirclePluginUtil.a("QCircleFolderActivity", paramMotionEvent);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public void onBackPressed()
  {
    QLog.d("QCircleFolderActivity", 1, "QCircleFolderActivity->onBackEvent");
    QCircleEeveeMananger.getInstance().onSend(6, null, null);
    if ((this.b != null) && (this.b.onBackEvent())) {
      return;
    }
    super.onBackPressed();
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    QLog.d("QCircleFolderActivity", 1, "QCircleFolderActivity->doOnCreate");
    if (paramBundle != null)
    {
      paramBundle.remove("android:support:fragments");
      paramBundle.remove("android:support:next_request_index");
      paramBundle.remove("android:support:request_indicies");
      paramBundle.remove("android:support:request_fragment_who");
      paramBundle.clear();
    }
    super.onCreate(paramBundle);
    getWindow().setSoftInputMode(32);
    QCirclePeriodCollect.record("folder_create");
    i();
  }
  
  protected void onDestroy()
  {
    QLog.d("QCircleFolderActivity", 1, "QCircleFolderActivity->doOnDestroy");
    super.onDestroy();
    QCircleReportHelper.getInstance().popPageScene(0);
    QCircleReporter.getInstance().flush();
    VSNetworkHelper.getInstance().cancelRequest(this);
    QCircleFeedPlayerScroller.j();
    QCircleFeedPicLoader.g().destroy();
    QCircleHostGlobalInfo.clearExposedGuideFeedIdList();
    QCirclePhotoScanManager.a().e();
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    QLog.d("QCircleFolderActivity", 1, "QCircleFolderActivity->doOnNewIntent");
    super.onNewIntent(paramIntent);
    if (getIntent() != null) {
      getIntent().putExtras(paramIntent);
    }
  }
  
  protected void onRestoreInstanceState(Bundle paramBundle)
  {
    super.onRestoreInstanceState(paramBundle);
    getIntent().putExtra("key_bundle_common_init_bean", getIntent().getSerializableExtra("key_bundle_common_init_bean"));
  }
  
  protected void onResume()
  {
    boolean bool1 = true;
    QLog.d("QCircleFolderActivity", 1, "QCircleFolderActivity->doOnResume");
    super.onResume();
    QCircleFolderBean localQCircleFolderBean = (QCircleFolderBean)getIntent().getSerializableExtra("key_bundle_common_init_bean");
    boolean bool2 = localQCircleFolderBean.isPublish();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("doOnResume isWrite?");
    localStringBuilder.append(bool2);
    localStringBuilder.append(", mQCircleFragment?");
    if (this.b == null) {
      bool1 = false;
    }
    localStringBuilder.append(bool1);
    QLog.d("QCircleFolderActivity", 4, localStringBuilder.toString());
    if ((bool2) && ((this.b instanceof QCircleFolderActivityFragment)))
    {
      ((QCircleFolderActivityFragment)this.b).u();
      localQCircleFolderBean.setPublish(false);
    }
    if (localQCircleFolderBean.getEnterTime() > 0L)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onResume time:");
      localStringBuilder.append(System.currentTimeMillis() - localQCircleFolderBean.getEnterTime());
      QLog.d("QCircleFolderActivity", 4, localStringBuilder.toString());
    }
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putSerializable("key_bundle_common_init_bean", getIntent().getSerializableExtra("key_bundle_common_init_bean"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.activity.QCircleFolderActivity
 * JD-Core Version:    0.7.0.1
 */