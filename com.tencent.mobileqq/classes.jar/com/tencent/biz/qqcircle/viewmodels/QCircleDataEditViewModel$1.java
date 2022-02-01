package com.tencent.biz.qqcircle.viewmodels;

import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import qqcircle.QQCircleProfile.SetProfileRsp;

class QCircleDataEditViewModel$1
  implements VSDispatchObserver.onVSRspCallBack<QQCircleProfile.SetProfileRsp>
{
  QCircleDataEditViewModel$1(QCircleDataEditViewModel paramQCircleDataEditViewModel) {}
  
  public void a(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, QQCircleProfile.SetProfileRsp paramSetProfileRsp)
  {
    paramBaseRequest = new StringBuilder();
    paramBaseRequest.append("setProfileRequest isSuccess:");
    paramBaseRequest.append(paramBoolean);
    paramBaseRequest.append(" retCode:");
    paramBaseRequest.append(paramLong);
    paramBaseRequest.append(" errorMsg:");
    paramBaseRequest.append(paramString);
    QLog.d("QCircleDataEditViewMode", 1, paramBaseRequest.toString());
    if ((paramBoolean) && (paramLong == 0L) && (paramSetProfileRsp != null))
    {
      this.a.a.setValue(UIStateData.a(false).a(false, paramSetProfileRsp));
      return;
    }
    this.a.a.setValue(UIStateData.a(paramString).a(paramLong));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.viewmodels.QCircleDataEditViewModel.1
 * JD-Core Version:    0.7.0.1
 */