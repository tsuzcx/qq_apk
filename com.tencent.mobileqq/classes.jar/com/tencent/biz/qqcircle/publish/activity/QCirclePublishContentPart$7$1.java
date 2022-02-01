package com.tencent.biz.qqcircle.publish.activity;

import android.content.Context;
import com.tencent.biz.qcircleshadow.lib.variation.HostSelectMemberUtils;
import com.tencent.mobileqq.qcircle.api.helper.HostUIHelper.HostEnvironmentLifeCycle;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;

class QCirclePublishContentPart$7$1
  extends HostUIHelper.HostEnvironmentLifeCycle
{
  QCirclePublishContentPart$7$1(QCirclePublishContentPart.7 param7) {}
  
  public void onEnvironmentCreated(Context paramContext)
  {
    HostSelectMemberUtils.onPublishClick(paramContext, true, 1, QCircleConfigHelper.ak(), 1001);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.activity.QCirclePublishContentPart.7.1
 * JD-Core Version:    0.7.0.1
 */