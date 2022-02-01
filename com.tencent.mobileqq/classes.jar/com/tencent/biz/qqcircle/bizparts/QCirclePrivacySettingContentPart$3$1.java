package com.tencent.biz.qqcircle.bizparts;

import com.tencent.biz.qqcircle.utils.QCircleToastUtil;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.Switch;
import cooperation.qzone.LocalMultiProcConfig;

class QCirclePrivacySettingContentPart$3$1
  implements VSDispatchObserver.onVSRspCallBack<Object>
{
  QCirclePrivacySettingContentPart$3$1(QCirclePrivacySettingContentPart.3 param3, boolean paramBoolean) {}
  
  public void onReceive(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, Object paramObject)
  {
    if ((paramBoolean) && (paramLong == 0L))
    {
      QLog.e("QCirclePrivacySettingContentPart", 1, "setRecomAutoTemplateSwitch success");
      return;
    }
    paramBaseRequest = new StringBuilder();
    paramBaseRequest.append("setRecomAutoTemplateSwitch fail, isSuccess:");
    paramBaseRequest.append(paramBoolean);
    paramBaseRequest.append(" retCode:");
    paramBaseRequest.append(paramLong);
    QLog.e("QCirclePrivacySettingContentPart", 1, paramBaseRequest.toString());
    QCircleToastUtil.a(paramLong, paramString, 0);
    if (this.a) {
      paramBaseRequest = "0";
    } else {
      paramBaseRequest = "1";
    }
    QCircleConfigHelper.b("qqcircle", "recommend_video_template_profile_switch", paramBaseRequest);
    LocalMultiProcConfig.putBool("recommend_video_template_profile_switch", this.a ^ true);
    QCirclePrivacySettingContentPart.a(this.b.a).setChecked(this.a ^ true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCirclePrivacySettingContentPart.3.1
 * JD-Core Version:    0.7.0.1
 */