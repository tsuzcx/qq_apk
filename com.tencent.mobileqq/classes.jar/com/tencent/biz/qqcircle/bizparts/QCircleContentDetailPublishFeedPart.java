package com.tencent.biz.qqcircle.bizparts;

import android.app.Activity;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants.PeakConstants;
import com.tencent.biz.qcircleshadow.lib.QCircleHostQzoneHelper;
import com.tencent.biz.qcircleshadow.lib.variation.HostDataTransUtils;
import com.tencent.biz.qqcircle.activity.QCircleFragmentActivity;
import com.tencent.biz.qqcircle.beans.QCircleFolderBean;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.launcher.QCircleLauncher;
import com.tencent.biz.qqcircle.utils.QCircleBindPhoneNumberHelper;
import com.tencent.biz.qqcircle.widgets.QCircleProgressDialog;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import cooperation.qqcircle.report.QCircleLpReportDc05504.DataBuilder;
import feedcloud.FeedCloudMeta.StTagInfo;
import feedcloud.FeedCloudMeta.StTagMedalInfo;

public class QCircleContentDetailPublishFeedPart
  extends QCircleBasePart
  implements View.OnClickListener
{
  private LinearLayout a;
  private QCircleProgressDialog c;
  private boolean d = false;
  private int e = 5;
  
  private void a(FeedCloudMeta.StTagInfo paramStTagInfo)
  {
    if (!QCircleBindPhoneNumberHelper.a())
    {
      QCircleBindPhoneNumberHelper.a(c(), 1);
      return;
    }
    this.a.setClickable(false);
    boolean bool;
    if (QCircleHostQzoneHelper.getInt4Uin("_qq_circle_publish", 0, Long.valueOf(HostDataTransUtils.getAccount()).longValue()) == 1) {
      bool = true;
    } else {
      bool = false;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("plus button clicked. hasDraft=");
    ((StringBuilder)localObject).append(bool);
    QLog.i("QCircleContentDetailPublishFeedPart", 1, ((StringBuilder)localObject).toString());
    localObject = new Bundle();
    ((Bundle)localObject).putLong(QCircleHostConstants.PeakConstants.TIME_STAMP(), System.currentTimeMillis());
    ((Bundle)localObject).putLong(QCircleHostConstants.PeakConstants.TIMESTAMP_LAST_ACTIVITY(), System.currentTimeMillis());
    ((Bundle)localObject).putBoolean("key_need_use_draft", false);
    Intent localIntent = c().getIntent();
    if (localIntent != null)
    {
      ((Bundle)localObject).putString("key_scheme", localIntent.getStringExtra("key_scheme"));
      localIntent.putExtra("key_scheme", "");
    }
    ((Bundle)localObject).putInt("key_qcircle_entrance_type", 3);
    if (paramStTagInfo != null)
    {
      ((Bundle)localObject).putString("key_qcircle_publish_default_tag_id", paramStTagInfo.tagId.get());
      ((Bundle)localObject).putString("key_qcircle_publish_default_tag_name", paramStTagInfo.tagName.get());
      ((Bundle)localObject).putString("key_qcircle_publish_default_tag_rank", String.valueOf(paramStTagInfo.medal.rank.get()));
    }
    QCircleLauncher.a(g(), (Bundle)localObject, null, 100, null);
  }
  
  public String a()
  {
    return "QCircleContentDetailPublishFeedPart";
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 256) && (paramInt2 == -1)) {
      QCircleLauncher.a(g(), new QCircleFolderBean());
    }
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    this.a = ((LinearLayout)paramView.findViewById(2131441812));
    this.a.setOnClickListener(this);
    this.c = new QCircleProgressDialog(g());
    if (((QCircleInitBean)c().getIntent().getSerializableExtra("key_bundle_common_init_bean")).getTagInfo().has())
    {
      this.a.setVisibility(0);
      return;
    }
    this.a.setVisibility(8);
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    super.onActivityResumed(paramActivity);
    paramActivity = this.a;
    if (paramActivity != null) {
      paramActivity.setClickable(true);
    }
    if (!this.d)
    {
      QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setToUin(HostDataTransUtils.getAccount()).setActionType(14).setSubActionType(1).setThrActionType(0).setExt1(String.valueOf(this.e)).setPageId(f()));
      this.d = true;
    }
  }
  
  public void onActivityStopped(Activity paramActivity)
  {
    super.onActivityStopped(paramActivity);
    this.c.dismiss();
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131441812)
    {
      FeedCloudMeta.StTagInfo localStTagInfo = ((QCircleInitBean)c().getIntent().getSerializableExtra("key_bundle_common_init_bean")).getTagInfo();
      if (Build.VERSION.SDK_INT >= 23) {
        ((QCircleFragmentActivity)g()).a(new QCircleContentDetailPublishFeedPart.1(this, localStTagInfo), 0, new String[] { "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE" });
      } else {
        a(localStTagInfo);
      }
      QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setToUin(HostDataTransUtils.getAccount()).setActionType(14).setSubActionType(2).setThrActionType(0).setExt1(String.valueOf(this.e)).setPageId(f()));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCircleContentDetailPublishFeedPart
 * JD-Core Version:    0.7.0.1
 */