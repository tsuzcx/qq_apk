package com.tencent.biz.qqcircle.viewmodels;

import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.qqcircle.requests.QCircleSetProfileRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.richframework.data.base.UIStateData;
import cooperation.qqcircle.report.IQCircleReportSessionOperation;
import feedcloud.FeedCloudCommon.StCommonExt;
import feedcloud.FeedCloudMeta.StTagInfo;
import java.util.List;
import qqcircle.QQCircleProfile.SetProfileRsp;

public class QCircleDataEditViewModel
  extends QCircleBaseViewModel
  implements IQCircleReportSessionOperation
{
  public MutableLiveData<UIStateData<QQCircleProfile.SetProfileRsp>> a = new MutableLiveData();
  
  public String a()
  {
    return "QCircleDataEditViewMode";
  }
  
  public void a(String paramString, List<FeedCloudMeta.StTagInfo> paramList, List<Long> paramList1)
  {
    paramString = new QCircleSetProfileRequest(paramString, paramList, paramList1);
    this.a.setValue(UIStateData.b());
    VSNetworkHelper.getInstance().sendRequest(paramString, new QCircleDataEditViewModel.1(this));
  }
  
  public FeedCloudCommon.StCommonExt getSession(boolean paramBoolean)
  {
    return null;
  }
  
  public void updateSession(FeedCloudCommon.StCommonExt paramStCommonExt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.viewmodels.QCircleDataEditViewModel
 * JD-Core Version:    0.7.0.1
 */