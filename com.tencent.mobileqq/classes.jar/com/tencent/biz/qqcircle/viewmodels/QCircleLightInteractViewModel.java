package com.tencent.biz.qqcircle.viewmodels;

import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.qqcircle.requests.QCircleGetLightInteractRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.richframework.data.base.UIStateData;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StLightInteractInfo;
import feedcloud.FeedCloudRead.StGetLightInteractListRsp;
import java.util.List;

public class QCircleLightInteractViewModel
  extends QCircleBaseViewModel
{
  public static String a = "QCircleLightInteractViewModel";
  private MutableLiveData<UIStateData<List<FeedCloudMeta.StLightInteractInfo>>> b = new MutableLiveData();
  private String c = "";
  
  public String a()
  {
    return a;
  }
  
  public void a(FeedCloudMeta.StFeed paramStFeed, boolean paramBoolean1, boolean paramBoolean2, int paramInt, String paramString)
  {
    if (!paramBoolean1) {
      this.c = "";
    }
    paramStFeed = new QCircleGetLightInteractRequest(paramStFeed, this.c, paramInt, paramString);
    paramStFeed.setEnableCache(paramBoolean2);
    this.b.setValue(UIStateData.b());
    a(paramStFeed, new QCircleLightInteractViewModel.1(this, paramBoolean1));
  }
  
  public void a(boolean paramBoolean1, long paramLong, boolean paramBoolean2, String paramString, FeedCloudRead.StGetLightInteractListRsp paramStGetLightInteractListRsp)
  {
    boolean bool = VSNetworkHelper.isProtocolCache(paramString);
    if ((paramBoolean1) && (paramLong == 0L) && (paramStGetLightInteractListRsp != null))
    {
      this.c = paramStGetLightInteractListRsp.attachInfo.get();
      Object localObject = paramStGetLightInteractListRsp.listInfo.get();
      if (((List)localObject).size() > 0)
      {
        paramString = this.b;
        localObject = UIStateData.a(bool).a(paramBoolean2, localObject);
        int i = paramStGetLightInteractListRsp.isFinish.get();
        paramBoolean1 = true;
        if (i != 1) {
          paramBoolean1 = false;
        }
        paramString.setValue(((UIStateData)localObject).c(paramBoolean1));
        return;
      }
      this.b.setValue(UIStateData.a().b(paramBoolean2));
      return;
    }
    this.b.setValue(UIStateData.a(paramString).b(paramBoolean2));
  }
  
  public MutableLiveData<UIStateData<List<FeedCloudMeta.StLightInteractInfo>>> b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.viewmodels.QCircleLightInteractViewModel
 * JD-Core Version:    0.7.0.1
 */