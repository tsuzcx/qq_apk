package com.tencent.biz.qqcircle.viewmodels;

import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.qqcircle.requests.QCircleGetBackFlowUserPymkPageRequest;
import com.tencent.richframework.data.base.UIStateData;
import feedcloud.FeedCloudRead.StGetFeedListRsp;

public class QCircleBackFlowSplashViewModel
  extends QCircleBaseViewModel
{
  public MutableLiveData<UIStateData<FeedCloudRead.StGetFeedListRsp>> a = new MutableLiveData();
  private String b;
  
  public String a()
  {
    return "QCircleBackFlowSplashViewModel";
  }
  
  public void a(String paramString)
  {
    this.b = paramString;
  }
  
  public void b()
  {
    QCircleGetBackFlowUserPymkPageRequest localQCircleGetBackFlowUserPymkPageRequest = new QCircleGetBackFlowUserPymkPageRequest();
    String str = this.b;
    if (str != null) {
      localQCircleGetBackFlowUserPymkPageRequest.setTransferData(str);
    }
    a(localQCircleGetBackFlowUserPymkPageRequest, new QCircleBackFlowSplashViewModel.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.viewmodels.QCircleBackFlowSplashViewModel
 * JD-Core Version:    0.7.0.1
 */