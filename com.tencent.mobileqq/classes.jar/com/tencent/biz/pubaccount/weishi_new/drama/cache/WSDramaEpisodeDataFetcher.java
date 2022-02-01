package com.tencent.biz.pubaccount.weishi_new.drama.cache;

import UserGrowth.stDrama;
import UserGrowth.stDramaFeed;
import UserGrowth.stDramaInfo;
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
import java.util.ArrayList;

public class WSDramaEpisodeDataFetcher
  implements IDataFetcher<WSDramaFeedsParams, stDramaFeed>
{
  private WSDramaEpisodeDataFetcher.ResponseModel a(@NonNull WSRequest<stGetDramaFeedsRsp> paramWSRequest, @NonNull stGetDramaFeedsRsp paramstGetDramaFeedsRsp, @NonNull WSDramaFeedsParams paramWSDramaFeedsParams)
  {
    paramWSRequest = new StringBuilder();
    paramWSRequest.append("[WSDramaEpisodeDataFetcher.java][handleSuccessOnSubThread] dramaFeedsSize:");
    paramWSRequest.append(paramstGetDramaFeedsRsp.dramaFeeds.size());
    WSLog.a("WSDramaEpisodeDataFetcher-nel-log", paramWSRequest.toString());
    paramWSRequest = new StringBuilder();
    paramWSRequest.append("[WSDramaEpisodeDataFetcher.java][handleSuccessOnSubThread] dramaId:");
    paramWSRequest.append(paramstGetDramaFeedsRsp.drama.dramaInfo.id);
    WSLog.a("WSDramaEpisodeDataFetcher-nel-log", paramWSRequest.toString());
    paramWSRequest = paramstGetDramaFeedsRsp.drama;
    ArrayList localArrayList = paramstGetDramaFeedsRsp.dramaFeeds;
    boolean bool2 = paramWSDramaFeedsParams.a();
    boolean bool1;
    if (paramWSDramaFeedsParams.g() == 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    return new WSDramaEpisodeDataFetcher.ResponseModel(paramWSRequest, localArrayList, bool2, bool1, paramstGetDramaFeedsRsp.attachInfo, paramstGetDramaFeedsRsp.isFinished);
  }
  
  private void a(@NonNull WSDramaEpisodeDataFetcher.ResponseModel paramResponseModel, @NonNull IFetchDataRspListener<stDramaFeed> paramIFetchDataRspListener)
  {
    WSDramaEpisodeDataFetcher.EpisodeExt localEpisodeExt = WSEpisodeResultUtil.a(paramResponseModel.e, paramResponseModel.c, paramResponseModel.d, paramResponseModel.f);
    paramIFetchDataRspListener.a(paramResponseModel.b, false, paramResponseModel.c, localEpisodeExt);
  }
  
  private void a(@NonNull WSServiceErrorInfo paramWSServiceErrorInfo, @NonNull IFetchDataRspListener<stDramaFeed> paramIFetchDataRspListener, @NonNull WSDramaFeedsParams paramWSDramaFeedsParams)
  {
    paramIFetchDataRspListener.a(paramWSServiceErrorInfo.a(), paramWSServiceErrorInfo.b(), paramWSDramaFeedsParams.a(), paramWSDramaFeedsParams.b());
  }
  
  public boolean a(@NonNull WSDramaFeedsParams paramWSDramaFeedsParams, @NonNull IFetchDataRspListener<stDramaFeed> paramIFetchDataRspListener)
  {
    boolean bool2 = paramWSDramaFeedsParams.a();
    boolean bool3 = paramWSDramaFeedsParams.b();
    String str1 = paramWSDramaFeedsParams.d();
    String str2 = paramWSDramaFeedsParams.e();
    boolean bool1;
    if (paramWSDramaFeedsParams.g() == 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    WSNetService.a(new WSGetDramaFeedsRequest(new WSDramaEpisodeParams(bool2, bool3, str1, str2, bool1), paramWSDramaFeedsParams.h())).a(new WSDramaEpisodeDataFetcher.1(this, paramWSDramaFeedsParams, paramIFetchDataRspListener));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.drama.cache.WSDramaEpisodeDataFetcher
 * JD-Core Version:    0.7.0.1
 */