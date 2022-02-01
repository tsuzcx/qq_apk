package com.tencent.biz.pubaccount.weishi_new.drama.data;

import com.tencent.biz.pubaccount.weishi_new.data.IDataFetcher;
import com.tencent.biz.pubaccount.weishi_new.data.IFetchDataRspListener;
import com.tencent.biz.pubaccount.weishi_new.net.common.WSNetService;
import com.tencent.biz.pubaccount.weishi_new.request.newreq.WSAllEpisodeIdsRequest;

public class WSAllEpisodeIdsFetcher
  implements IDataFetcher<WSEpisodeParams, String>
{
  public boolean a(WSEpisodeParams paramWSEpisodeParams, IFetchDataRspListener<String> paramIFetchDataRspListener)
  {
    WSNetService.a(new WSAllEpisodeIdsRequest(paramWSEpisodeParams.a)).a(new WSAllEpisodeIdsFetcher.1(this, paramIFetchDataRspListener));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.drama.data.WSAllEpisodeIdsFetcher
 * JD-Core Version:    0.7.0.1
 */