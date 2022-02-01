package com.tencent.biz.qqcircle.bizparts;

import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import com.tencent.richframework.data.base.UIStateData;
import qqcircle.QQCirclePrivateMsgShow.StGetPMSettingRsp;

class QCirclePrivateMessageSettingContentPart$1
  implements Observer<UIStateData<QQCirclePrivateMsgShow.StGetPMSettingRsp>>
{
  QCirclePrivateMessageSettingContentPart$1(QCirclePrivateMessageSettingContentPart paramQCirclePrivateMessageSettingContentPart) {}
  
  public void a(@Nullable UIStateData<QQCirclePrivateMsgShow.StGetPMSettingRsp> paramUIStateData)
  {
    if ((paramUIStateData != null) && (paramUIStateData.c() == 3))
    {
      QCirclePrivateMessageSettingContentPart.a(this.a, (QQCirclePrivateMsgShow.StGetPMSettingRsp)paramUIStateData.e());
      return;
    }
    if ((paramUIStateData != null) && (paramUIStateData.c() == 4)) {
      QCirclePrivateMessageSettingContentPart.a(this.a, paramUIStateData.g(), paramUIStateData.f());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCirclePrivateMessageSettingContentPart.1
 * JD-Core Version:    0.7.0.1
 */