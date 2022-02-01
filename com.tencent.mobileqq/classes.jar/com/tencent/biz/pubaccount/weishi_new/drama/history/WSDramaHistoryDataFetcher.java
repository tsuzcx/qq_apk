package com.tencent.biz.pubaccount.weishi_new.drama.history;

import UserGrowth.stDrama;
import UserGrowth.stGetHistoryDramaRsp;
import com.tencent.biz.pubaccount.weishi_new.data.FetcherParams;
import com.tencent.biz.pubaccount.weishi_new.data.IDataFetcher;
import com.tencent.biz.pubaccount.weishi_new.data.IFetchDataRspListener;
import com.tencent.biz.pubaccount.weishi_new.net.common.WSNetService;
import com.tencent.biz.pubaccount.weishi_new.net.common.WSServiceErrorInfo;
import com.tencent.biz.pubaccount.weishi_new.request.newreq.WSHistoryDramaRequest;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import java.util.ArrayList;

public class WSDramaHistoryDataFetcher
  implements IDataFetcher<FetcherParams, WSDramaHistoryData>
{
  private String a;
  
  private WSDramaHistoryDataFetcher.ResponseModel a(stGetHistoryDramaRsp paramstGetHistoryDramaRsp)
  {
    this.a = paramstGetHistoryDramaRsp.attachInfo;
    ArrayList localArrayList = new ArrayList();
    if (paramstGetHistoryDramaRsp.dramas != null)
    {
      int i = 0;
      while (i < paramstGetHistoryDramaRsp.dramas.size())
      {
        localArrayList.add(new WSDramaHistoryData((stDrama)paramstGetHistoryDramaRsp.dramas.get(i)));
        i += 1;
      }
    }
    WSLog.d("WSDramaHistoryDataFetcher", "[WSDramaHistoryDataFetcher.java][handleSuccessOnSubThread] historyDramaRsp.dramas is null!");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSDramaHistoryDataFetcher.java][handleSuccessOnSubThread] data list:");
    localStringBuilder.append(localArrayList.size());
    WSLog.e("WSDramaHistoryDataFetcher", localStringBuilder.toString());
    return new WSDramaHistoryDataFetcher.ResponseModel(localArrayList, paramstGetHistoryDramaRsp.isFinished);
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, WSDramaHistoryDataFetcher.ResponseModel paramResponseModel, IFetchDataRspListener<WSDramaHistoryData> paramIFetchDataRspListener)
  {
    if (paramIFetchDataRspListener != null) {
      paramIFetchDataRspListener.a(paramResponseModel.a, paramBoolean2, paramBoolean1, Boolean.valueOf(paramResponseModel.b ^ true));
    }
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, WSServiceErrorInfo paramWSServiceErrorInfo, IFetchDataRspListener paramIFetchDataRspListener)
  {
    if (paramIFetchDataRspListener != null) {
      paramIFetchDataRspListener.a(paramWSServiceErrorInfo.a(), paramWSServiceErrorInfo.b(), paramBoolean1, paramBoolean2);
    }
  }
  
  public boolean a(FetcherParams paramFetcherParams, IFetchDataRspListener<WSDramaHistoryData> paramIFetchDataRspListener)
  {
    boolean bool1 = paramFetcherParams.a();
    boolean bool2 = paramFetcherParams.b();
    if (bool1) {
      this.a = "";
    }
    WSNetService.a(new WSHistoryDramaRequest(WeishiUtils.n(), this.a)).a(new WSDramaHistoryDataFetcher.1(this, bool1, bool2, paramIFetchDataRspListener));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.drama.history.WSDramaHistoryDataFetcher
 * JD-Core Version:    0.7.0.1
 */