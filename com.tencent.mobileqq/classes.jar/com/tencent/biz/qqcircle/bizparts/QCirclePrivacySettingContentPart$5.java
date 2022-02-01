package com.tencent.biz.qqcircle.bizparts;

import androidx.lifecycle.Observer;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.widget.Switch;
import feedcloud.FeedCloudRead.StGetMainPageRsp;
import qqcircle.QQCircleFeedBase.StMainPageBusiRspData;

class QCirclePrivacySettingContentPart$5
  implements Observer<UIStateData<FeedCloudRead.StGetMainPageRsp>>
{
  QCirclePrivacySettingContentPart$5(QCirclePrivacySettingContentPart paramQCirclePrivacySettingContentPart) {}
  
  public void a(UIStateData<FeedCloudRead.StGetMainPageRsp> paramUIStateData)
  {
    if ((paramUIStateData != null) && ((paramUIStateData.c() == 2) || (paramUIStateData.c() == 3)) && (paramUIStateData.e() != null) && (((FeedCloudRead.StGetMainPageRsp)paramUIStateData.e()).busiRspData != null)) {}
    try
    {
      QQCircleFeedBase.StMainPageBusiRspData localStMainPageBusiRspData = new QQCircleFeedBase.StMainPageBusiRspData();
      localStMainPageBusiRspData.mergeFrom(((FeedCloudRead.StGetMainPageRsp)paramUIStateData.e()).busiRspData.get().toByteArray());
      QCirclePrivacySettingContentPart.b(this.a).setChecked(QCirclePluginUtil.b(localStMainPageBusiRspData.opMask.get()));
      QCirclePrivacySettingContentPart.c(this.a).setChecked(QCirclePluginUtil.c(localStMainPageBusiRspData.opMask.get()));
      return;
    }
    catch (Exception paramUIStateData)
    {
      label110:
      break label110;
    }
    QLog.e("QCirclePrivacySettingContentPart", 1, "mergeFrom stMainPageBusiRspData error");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCirclePrivacySettingContentPart.5
 * JD-Core Version:    0.7.0.1
 */