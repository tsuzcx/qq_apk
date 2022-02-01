package com.tencent.biz.qqcircle.publish.util;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.aelight.camera.entry.api.IAECameraLauncher;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants._AEEditorConstants;
import com.tencent.biz.qcircleshadow.lib.QCircleHostQzoneHelper;
import com.tencent.biz.qqcircle.publish.account.LoginData;
import com.tencent.biz.qqcircle.publish.model.DynamicArrayList;
import com.tencent.biz.qqcircle.publish.viewmodel.QCirclePublishViewModel;
import com.tencent.mobileqq.qcircle.api.constant.QCircleConstants;
import com.tencent.mobileqq.qcircle.api.helper.HostUIHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCirclePublishQualityReporter;
import cooperation.qqcircle.report.QCircleReportHelper;
import feedcloud.FeedCloudCommon.Entry;
import java.util.Arrays;

public class QcirclePublishJumpModel
{
  public String a = QCircleHostConstants._AEEditorConstants.AE_PHOTO_PICKER_TAB_ALBUM();
  private boolean b;
  private int c;
  private boolean d = false;
  private boolean e = false;
  private QcirclePublishJumpModel.TakePhotoHostEnvironmentLifeCycle f;
  private long g;
  private long h;
  private String i;
  private String j;
  private String k = "";
  private DynamicArrayList<String> l = new DynamicArrayList();
  private boolean m;
  private boolean n;
  private Intent o;
  
  public static Context a(Context paramContext)
  {
    Context localContext = paramContext;
    if ((paramContext instanceof Activity))
    {
      Activity localActivity = (Activity)paramContext;
      localContext = paramContext;
      if ((localActivity.getBaseContext() instanceof ContextWrapper)) {
        localContext = localActivity.getBaseContext();
      }
    }
    return localContext;
  }
  
  private void a()
  {
    HostUIHelper.openHostEnvironment(new QcirclePublishJumpModel.1(this));
  }
  
  private void a(Intent paramIntent)
  {
    this.g = LoginData.a().b();
    this.b = paramIntent.getBooleanExtra("key_isfrom_photobubble", false);
    this.c = paramIntent.getIntExtra("key_qcircle_entrance_type", 0);
    this.d = paramIntent.getBooleanExtra("bundle_key_allow_long_video", false);
    this.e = paramIntent.getBooleanExtra("bundle_key_select_qq_photo", false);
    this.h = QCircleHostQzoneHelper.getInt4Uin("sp_key_max_limit_video_length", QCirclePublishViewModel.u, LoginData.a().b());
    this.i = paramIntent.getStringExtra("key_scheme");
    this.j = paramIntent.getStringExtra("key_polymerization_scheme");
    this.k = paramIntent.getStringExtra(QCircleConstants.w);
    this.n = paramIntent.getBooleanExtra("key_is_capsule_button", false);
  }
  
  private void b(Context paramContext)
  {
    if (QCircleConfigHelper.bh())
    {
      Bundle localBundle = new Bundle();
      Intent localIntent = this.o;
      if (localIntent != null) {
        localBundle.putAll(localIntent.getExtras());
      }
      localBundle.putString("qcircle_client_traceid", this.k);
      ((IAECameraLauncher)QRoute.api(IAECameraLauncher.class)).launchAEMultiCameraFromFlash(a(paramContext), localBundle);
      return;
    }
    if ((this.d) && (this.e))
    {
      QCirclePublishQualityReporter.report(QCirclePublishQualityReporter.E_PICKER_ENTER, Arrays.asList(new FeedCloudCommon.Entry[] { QCircleReportHelper.newEntry("traceid", this.k), QCircleReportHelper.newEntry("ext2", "longvideomode"), QCircleReportHelper.newEntry("ret_code", "0") }));
      a();
      return;
    }
    paramContext = this.f;
    if (paramContext != null)
    {
      HostUIHelper.openHostEnvironment(paramContext);
      return;
    }
    QLog.e("[QcirclePublish]QcirclePublishJumpUtil", 1, "initData... mTakePhotoHostEnvironmentLifeCycle == null");
    this.f = new QcirclePublishJumpModel.TakePhotoHostEnvironmentLifeCycle(this);
    HostUIHelper.openHostEnvironment(this.f);
  }
  
  public void a(Context paramContext, Intent paramIntent, DynamicArrayList<String> paramDynamicArrayList, boolean paramBoolean, String paramString)
  {
    a(paramIntent);
    if (paramDynamicArrayList != null) {
      this.l = paramDynamicArrayList;
    }
    this.m = paramBoolean;
    this.a = paramString;
    this.o = paramIntent;
    b(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.util.QcirclePublishJumpModel
 * JD-Core Version:    0.7.0.1
 */