package com.tencent.biz.pubaccount.weishi_new.verticalvideo.data;

import UserGrowth.stGetDramaFeedsRsp;
import android.support.annotation.NonNull;
import com.tencent.biz.pubaccount.weishi_new.data.IDataFetcher;
import com.tencent.biz.pubaccount.weishi_new.data.IFetchDataRspListener;
import com.tencent.biz.pubaccount.weishi_new.drama.data.WSDramaEpisodeParams;
import com.tencent.biz.pubaccount.weishi_new.net.common.WSNetService;
import com.tencent.biz.pubaccount.weishi_new.net.common.WSRequest;
import com.tencent.biz.pubaccount.weishi_new.net.common.WSServiceErrorInfo;
import com.tencent.biz.pubaccount.weishi_new.request.newreq.WSGetDramaFeedsRequest;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import java.util.List;

public class WSDramaEpisodeDataFetcher
  implements IDataFetcher<WSDramaEpisodeParams, WSVerticalItemData>
{
  public boolean a;
  public boolean b;
  public String c;
  
  private int a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1) {
      return 1;
    }
    if (paramBoolean2) {
      return 3;
    }
    return 2;
  }
  
  private WSDramaEpisodeDataFetcher.ResponseModel a(@NonNull WSRequest<stGetDramaFeedsRsp> paramWSRequest, @NonNull stGetDramaFeedsRsp paramstGetDramaFeedsRsp, @NonNull WSDramaEpisodeParams paramWSDramaEpisodeParams)
  {
    boolean bool;
    if ((paramWSDramaEpisodeParams.e()) && (paramstGetDramaFeedsRsp.isFinished)) {
      bool = true;
    } else {
      bool = false;
    }
    paramWSRequest = WSVerticalDataUtil.a(paramstGetDramaFeedsRsp.drama, paramstGetDramaFeedsRsp.dramaFeeds, bool);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSDramaEpisodeDataFetcher.java][handleSuccessOnSubThread] itemDataList size:");
    localStringBuilder.append(paramWSRequest.size());
    localStringBuilder.append(", mIsFinished:");
    localStringBuilder.append(paramstGetDramaFeedsRsp.isFinished);
    WSLog.e("WSDramaEpisodeDataFetcher", localStringBuilder.toString());
    return new WSDramaEpisodeDataFetcher.ResponseModel(paramstGetDramaFeedsRsp.drama, paramWSRequest, paramWSDramaEpisodeParams.a(), paramWSDramaEpisodeParams.e(), paramstGetDramaFeedsRsp.attachInfo, paramstGetDramaFeedsRsp.isFinished);
  }
  
  private void a(@NonNull WSServiceErrorInfo paramWSServiceErrorInfo, @NonNull IFetchDataRspListener<WSVerticalItemData> paramIFetchDataRspListener, @NonNull WSDramaEpisodeParams paramWSDramaEpisodeParams)
  {
    paramIFetchDataRspListener.a(paramWSServiceErrorInfo.a(), paramWSServiceErrorInfo.b(), paramWSDramaEpisodeParams.a(), paramWSDramaEpisodeParams.b());
  }
  
  private void a(@NonNull WSDramaEpisodeDataFetcher.ResponseModel paramResponseModel)
  {
    this.c = paramResponseModel.e;
    if (paramResponseModel.d)
    {
      this.b = paramResponseModel.f;
      return;
    }
    this.a = paramResponseModel.f;
  }
  
  private void a(@NonNull WSDramaEpisodeDataFetcher.ResponseModel paramResponseModel, @NonNull IFetchDataRspListener<WSVerticalItemData> paramIFetchDataRspListener)
  {
    a(paramResponseModel);
    int i = a(paramResponseModel.c, paramResponseModel.d);
    paramIFetchDataRspListener.a(paramResponseModel.b, false, paramResponseModel.c, Integer.valueOf(i));
  }
  
  private boolean a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return this.b;
    }
    return this.a;
  }
  
  public boolean a(@NonNull WSDramaEpisodeParams paramWSDramaEpisodeParams, @NonNull IFetchDataRspListener<WSVerticalItemData> paramIFetchDataRspListener)
  {
    if (a(paramWSDramaEpisodeParams.e()))
    {
      paramIFetchDataRspListener = new StringBuilder();
      paramIFetchDataRspListener.append("fetchData() is finished. isLoadMoreDown = ");
      paramIFetchDataRspListener.append(paramWSDramaEpisodeParams.e());
      WSLog.a("WSDramaEpisodeDataFetcher", paramIFetchDataRspListener.toString());
      return false;
    }
    WSNetService.a(new WSGetDramaFeedsRequest(paramWSDramaEpisodeParams, this.c)).a(new WSDramaEpisodeDataFetcher.1(this, paramWSDramaEpisodeParams, paramIFetchDataRspListener));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSDramaEpisodeDataFetcher
 * JD-Core Version:    0.7.0.1
 */