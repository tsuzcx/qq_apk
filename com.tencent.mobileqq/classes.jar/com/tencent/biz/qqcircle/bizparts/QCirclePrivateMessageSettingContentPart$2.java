package com.tencent.biz.qqcircle.bizparts;

import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import qqcircle.QQCirclePrivateMsgShow.StChangePMSettingRsp;
import qqcircle.QQCirclePrivateMsgShow.StFuelCostRange;
import qqcircle.QQCirclePrivateMsgShow.StPMSettingData;

class QCirclePrivateMessageSettingContentPart$2
  implements Observer<UIStateData<QQCirclePrivateMsgShow.StChangePMSettingRsp>>
{
  QCirclePrivateMessageSettingContentPart$2(QCirclePrivateMessageSettingContentPart paramQCirclePrivateMessageSettingContentPart) {}
  
  public void a(@Nullable UIStateData<QQCirclePrivateMsgShow.StChangePMSettingRsp> paramUIStateData)
  {
    if ((paramUIStateData != null) && (paramUIStateData.c() == 3))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onChanged() return success！ retCode : ");
      localStringBuilder.append(((QQCirclePrivateMsgShow.StChangePMSettingRsp)paramUIStateData.e()).errCode.get());
      localStringBuilder.append(" , errMsg : ");
      localStringBuilder.append(((QQCirclePrivateMsgShow.StChangePMSettingRsp)paramUIStateData.e()).errMsg.get());
      QLog.e("QCirclePrivateMessageSettingContentPart", 1, localStringBuilder.toString());
      try
      {
        QCirclePrivateMessageSettingContentPart.a(this.a, (QQCirclePrivateMsgShow.StPMSettingData)new QQCirclePrivateMsgShow.StPMSettingData().mergeFrom(((QQCirclePrivateMsgShow.StPMSettingData)((QQCirclePrivateMsgShow.StChangePMSettingRsp)paramUIStateData.e()).setting.get()).toByteArray()));
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        localInvalidProtocolBufferMicroException.printStackTrace();
      }
      QCirclePrivateMessageSettingContentPart.a(this.a, (QQCirclePrivateMsgShow.StFuelCostRange)((QQCirclePrivateMsgShow.StChangePMSettingRsp)paramUIStateData.e()).fuelCostRange.get());
      return;
    }
    if ((paramUIStateData != null) && (paramUIStateData.c() == 4)) {
      QCirclePrivateMessageSettingContentPart.a(this.a, paramUIStateData.g(), paramUIStateData.f());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCirclePrivateMessageSettingContentPart.2
 * JD-Core Version:    0.7.0.1
 */