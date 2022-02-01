package com.tencent.biz.qqcircle.viewmodels;

import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.qqcircle.requests.QCircleGetNewUserPymkPageRequest;
import com.tencent.richframework.data.base.UIStateData;
import feedcloud.FeedCloudRead.StGetFeedListRsp;

public class QCircleSplashViewModel
  extends QCircleBaseViewModel
{
  public MutableLiveData<UIStateData<FeedCloudRead.StGetFeedListRsp>> a = new MutableLiveData();
  private FeedCloudRead.StGetFeedListRsp b;
  private String c;
  
  private int c(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2) {
          return 21;
        }
        return 28;
      }
      return 24;
    }
    return 21;
  }
  
  public String a()
  {
    return "PYMK-QcircleSplashViewModel";
  }
  
  public void a(int paramInt)
  {
    a(paramInt, 0);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    QCircleGetNewUserPymkPageRequest localQCircleGetNewUserPymkPageRequest = new QCircleGetNewUserPymkPageRequest(c(paramInt1), paramInt2);
    String str = this.c;
    if (str != null) {
      localQCircleGetNewUserPymkPageRequest.setTransferData(str);
    }
    a(localQCircleGetNewUserPymkPageRequest, new QCircleSplashViewModel.1(this));
  }
  
  public void a(String paramString)
  {
    this.c = paramString;
  }
  
  public FeedCloudRead.StGetFeedListRsp b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.viewmodels.QCircleSplashViewModel
 * JD-Core Version:    0.7.0.1
 */