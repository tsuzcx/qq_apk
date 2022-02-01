package com.tencent.biz.pubaccount.weishi_new.profile.data;

import UserGrowth.stGetPersonalFeedListRsp;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.data.IFetchDataRspListener;
import com.tencent.biz.pubaccount.weishi_new.net.common.WSNetService;
import com.tencent.biz.pubaccount.weishi_new.net.common.WSServiceErrorInfo;
import com.tencent.biz.pubaccount.weishi_new.request.ProfileFeedListRequest;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalDataUtil;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class WSProfileFeedsDataFetcher
  implements WSIShareDataFetcher<WSProfileFeedsRequestParams, WSVerticalItemData>
{
  public List<WSVerticalItemData> a = new ArrayList();
  public List<IFetchDataRspListener<WSVerticalItemData>> b = new ArrayList();
  private String c;
  private String d;
  private boolean e;
  private boolean f;
  
  private WSProfileFeedsDataFetcher.ResponseModel a(stGetPersonalFeedListRsp paramstGetPersonalFeedListRsp, WSProfileFeedsRequestParams paramWSProfileFeedsRequestParams)
  {
    if ((!this.f) && (TextUtils.equals(this.c, paramWSProfileFeedsRequestParams.c())))
    {
      this.d = paramstGetPersonalFeedListRsp.attach_info;
      this.e = paramstGetPersonalFeedListRsp.is_finished;
      if (paramstGetPersonalFeedListRsp.feeds == null)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[WSProfileFeedsDataFetcher.java][handleRspOnSubThread] itemDataList is null, mIsFinished:");
        ((StringBuilder)localObject).append(paramstGetPersonalFeedListRsp.is_finished);
        WSLog.e("WSProfileFeedsDataFetcher", ((StringBuilder)localObject).toString());
      }
      Object localObject = WSVerticalDataUtil.a(paramstGetPersonalFeedListRsp.feeds, false);
      this.a.addAll((Collection)localObject);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[WSProfileFeedsDataFetcher.java][handleRspOnSubThread] itemDataList size:");
      localStringBuilder.append(((List)localObject).size());
      localStringBuilder.append(", mIsFinished:");
      localStringBuilder.append(paramstGetPersonalFeedListRsp.is_finished);
      localStringBuilder.append(", reqType:");
      localStringBuilder.append(paramWSProfileFeedsRequestParams.f());
      localStringBuilder.append(", mAttachInfo:");
      localStringBuilder.append(this.d);
      WSLog.e("WSProfileFeedsDataFetcher", localStringBuilder.toString());
      return new WSProfileFeedsDataFetcher.ResponseModel((List)localObject, paramWSProfileFeedsRequestParams.a(), paramstGetPersonalFeedListRsp.is_finished);
    }
    return null;
  }
  
  private void a(WSProfileFeedsRequestParams paramWSProfileFeedsRequestParams, WSServiceErrorInfo paramWSServiceErrorInfo)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      IFetchDataRspListener localIFetchDataRspListener = (IFetchDataRspListener)localIterator.next();
      if (localIFetchDataRspListener != null) {
        localIFetchDataRspListener.a(paramWSServiceErrorInfo.a(), paramWSServiceErrorInfo.b(), paramWSProfileFeedsRequestParams.a(), paramWSProfileFeedsRequestParams.b());
      }
    }
  }
  
  private void a(WSProfileFeedsRequestParams paramWSProfileFeedsRequestParams, WSProfileFeedsDataFetcher.ResponseModel paramResponseModel)
  {
    if (paramResponseModel == null) {
      return;
    }
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      IFetchDataRspListener localIFetchDataRspListener = (IFetchDataRspListener)localIterator.next();
      if (localIFetchDataRspListener != null) {
        localIFetchDataRspListener.a(paramResponseModel.a, paramWSProfileFeedsRequestParams.b(), paramResponseModel.b, Boolean.valueOf(paramResponseModel.c ^ true));
      }
    }
  }
  
  public List<WSVerticalItemData> a()
  {
    return this.a;
  }
  
  public void a(IFetchDataRspListener<WSVerticalItemData> paramIFetchDataRspListener)
  {
    if (!this.b.contains(paramIFetchDataRspListener)) {
      this.b.add(paramIFetchDataRspListener);
    }
  }
  
  public boolean a(WSProfileFeedsRequestParams paramWSProfileFeedsRequestParams)
  {
    this.f = false;
    if (this.e) {
      return false;
    }
    if (paramWSProfileFeedsRequestParams.b())
    {
      this.a.clear();
      this.d = "";
    }
    this.c = paramWSProfileFeedsRequestParams.c();
    WSNetService.a(new ProfileFeedListRequest(paramWSProfileFeedsRequestParams.c(), this.d, paramWSProfileFeedsRequestParams.a(), paramWSProfileFeedsRequestParams.d(), paramWSProfileFeedsRequestParams.e(), paramWSProfileFeedsRequestParams.f())).a(new WSProfileFeedsDataFetcher.1(this, paramWSProfileFeedsRequestParams));
    return true;
  }
  
  public void b()
  {
    this.f = true;
    this.d = "";
    this.e = false;
    this.a.clear();
  }
  
  public void b(IFetchDataRspListener<WSVerticalItemData> paramIFetchDataRspListener)
  {
    this.b.remove(paramIFetchDataRspListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.profile.data.WSProfileFeedsDataFetcher
 * JD-Core Version:    0.7.0.1
 */