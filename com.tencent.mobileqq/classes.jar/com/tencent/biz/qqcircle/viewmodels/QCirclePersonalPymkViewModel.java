package com.tencent.biz.qqcircle.viewmodels;

import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.qqcircle.requests.QCircleGetMainPagePymkRecomFeedListRequest;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import feedcloud.FeedCloudRead.StGetFeedListRsp;

public class QCirclePersonalPymkViewModel
  extends QCircleBaseViewModel
{
  public MutableLiveData<UIStateData<FeedCloudRead.StGetFeedListRsp>> a = new MutableLiveData();
  private FeedCloudRead.StGetFeedListRsp b;
  
  public String a()
  {
    return "PYMK-QCirclePersonalPymkViewModel";
  }
  
  public void a(String paramString)
  {
    QCircleGetMainPagePymkRecomFeedListRequest localQCircleGetMainPagePymkRecomFeedListRequest = new QCircleGetMainPagePymkRecomFeedListRequest(31, paramString, false);
    QLog.d("PYMK-QCirclePersonalPymkViewModel", 1, new Object[] { "[fetchPersonalPymkSource] userId: ", paramString });
    a(localQCircleGetMainPagePymkRecomFeedListRequest, new QCirclePersonalPymkViewModel.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.viewmodels.QCirclePersonalPymkViewModel
 * JD-Core Version:    0.7.0.1
 */