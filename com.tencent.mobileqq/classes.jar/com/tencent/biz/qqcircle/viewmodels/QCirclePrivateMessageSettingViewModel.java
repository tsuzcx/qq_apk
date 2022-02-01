package com.tencent.biz.qqcircle.viewmodels;

import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.qqcircle.requests.QCircleChangePMSettingRequest;
import com.tencent.biz.qqcircle.requests.QCircleGetPMSettingRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.richframework.data.base.UIStateData;
import qqcircle.QQCirclePrivateMsgShow.StChangePMSettingRsp;
import qqcircle.QQCirclePrivateMsgShow.StGetPMSettingRsp;
import qqcircle.QQCirclePrivateMsgShow.StPMSettingData;

public class QCirclePrivateMessageSettingViewModel
  extends QCircleBaseViewModel
{
  public MutableLiveData<UIStateData<QQCirclePrivateMsgShow.StGetPMSettingRsp>> a = new MutableLiveData();
  public MutableLiveData<UIStateData<QQCirclePrivateMsgShow.StChangePMSettingRsp>> b = new MutableLiveData();
  
  public String a()
  {
    return "QCirclePrivateMessageSettingViewModel";
  }
  
  public void a(String paramString)
  {
    paramString = new QCircleGetPMSettingRequest(paramString);
    this.a.setValue(UIStateData.b());
    VSNetworkHelper.getInstance().sendRequest(paramString, new QCirclePrivateMessageSettingViewModel.1(this));
  }
  
  public void a(QQCirclePrivateMsgShow.StPMSettingData paramStPMSettingData)
  {
    paramStPMSettingData = new QCircleChangePMSettingRequest(paramStPMSettingData);
    this.b.setValue(UIStateData.b());
    VSNetworkHelper.getInstance().sendRequest(paramStPMSettingData, new QCirclePrivateMessageSettingViewModel.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.viewmodels.QCirclePrivateMessageSettingViewModel
 * JD-Core Version:    0.7.0.1
 */