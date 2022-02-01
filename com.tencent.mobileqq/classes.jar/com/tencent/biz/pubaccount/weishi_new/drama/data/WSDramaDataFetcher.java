package com.tencent.biz.pubaccount.weishi_new.drama.data;

import UserGrowth.stDrama;
import UserGrowth.stDramaFeed;
import UserGrowth.stDramaInfo;
import UserGrowth.stGetSimpleRecommendDramaRsp;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.data.IDataFetcher;
import com.tencent.biz.pubaccount.weishi_new.data.IFetchDataRspListener;
import com.tencent.biz.pubaccount.weishi_new.net.common.WSNetService;
import com.tencent.biz.pubaccount.weishi_new.net.common.WSRequest;
import com.tencent.biz.pubaccount.weishi_new.net.common.WSServiceErrorInfo;
import com.tencent.biz.pubaccount.weishi_new.request.newreq.WSDramaRequest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class WSDramaDataFetcher
  implements IDataFetcher<WSDramaParams, WSDramaItemData>
{
  private stDramaFeed a(Map<String, stDramaFeed> paramMap, Map<String, ArrayList<String>> paramMap1, stDrama paramstDrama)
  {
    int i = paramstDrama.dramaInfo.curWatchedFeedNum;
    paramMap1 = a(paramMap1, paramstDrama);
    if ((paramMap1 != null) && (i < paramMap1.size())) {
      return (stDramaFeed)paramMap.get((String)paramMap1.get(i));
    }
    return null;
  }
  
  private WSDramaDataFetcher.ResponseModel a(WSRequest<stGetSimpleRecommendDramaRsp> paramWSRequest, stGetSimpleRecommendDramaRsp paramstGetSimpleRecommendDramaRsp)
  {
    Object localObject = paramstGetSimpleRecommendDramaRsp.dramas;
    paramWSRequest = paramstGetSimpleRecommendDramaRsp.feedInfoMap;
    paramstGetSimpleRecommendDramaRsp = paramstGetSimpleRecommendDramaRsp.dramaFeedsMap;
    ArrayList localArrayList = new ArrayList();
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      stDrama localstDrama = (stDrama)((Iterator)localObject).next();
      if (!a(localstDrama))
      {
        localstDrama.dramaInfo.curWatchedFeedNum = Math.min(localstDrama.dramaInfo.curPublishedFeedNum, localstDrama.dramaInfo.curWatchedFeedNum);
        WSDramaItemData localWSDramaItemData = new WSDramaItemData(localstDrama);
        localWSDramaItemData.a(a(paramstGetSimpleRecommendDramaRsp, localstDrama));
        localWSDramaItemData.a(a(paramWSRequest, paramstGetSimpleRecommendDramaRsp, localstDrama));
        localArrayList.add(localWSDramaItemData);
      }
    }
    if (localArrayList.size() > 0) {
      ((WSDramaItemData)localArrayList.get(0)).a(true);
    }
    return new WSDramaDataFetcher.ResponseModel(localArrayList);
  }
  
  private ArrayList<String> a(Map<String, ArrayList<String>> paramMap, stDrama paramstDrama)
  {
    if (paramMap != null) {
      return (ArrayList)paramMap.get(paramstDrama.dramaInfo.id);
    }
    return null;
  }
  
  private void a(WSDramaDataFetcher.ResponseModel paramResponseModel, IFetchDataRspListener<WSDramaItemData> paramIFetchDataRspListener)
  {
    if (paramIFetchDataRspListener != null) {
      paramIFetchDataRspListener.a(paramResponseModel.a, false, false, null);
    }
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, WSServiceErrorInfo paramWSServiceErrorInfo, IFetchDataRspListener<WSDramaItemData> paramIFetchDataRspListener)
  {
    if (paramIFetchDataRspListener != null) {
      paramIFetchDataRspListener.a(paramWSServiceErrorInfo.a(), paramWSServiceErrorInfo.b(), paramBoolean1, paramBoolean2);
    }
  }
  
  private boolean a(stDrama paramstDrama)
  {
    return (paramstDrama == null) || (paramstDrama.dramaInfo == null) || (TextUtils.isEmpty(paramstDrama.dramaInfo.id));
  }
  
  public boolean a(WSDramaParams paramWSDramaParams, IFetchDataRspListener<WSDramaItemData> paramIFetchDataRspListener)
  {
    boolean bool1 = paramWSDramaParams.a();
    boolean bool2 = paramWSDramaParams.b();
    WSNetService.a(new WSDramaRequest(paramWSDramaParams.c())).a(new WSDramaDataFetcher.1(this, paramIFetchDataRspListener, bool1, bool2));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.drama.data.WSDramaDataFetcher
 * JD-Core Version:    0.7.0.1
 */