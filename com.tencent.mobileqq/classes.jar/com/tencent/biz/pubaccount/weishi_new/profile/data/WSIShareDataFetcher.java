package com.tencent.biz.pubaccount.weishi_new.profile.data;

import com.tencent.biz.pubaccount.weishi_new.data.FetcherParams;
import com.tencent.biz.pubaccount.weishi_new.data.IFetchDataRspListener;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;
import java.util.List;

public abstract interface WSIShareDataFetcher<PARAM extends FetcherParams, I>
{
  public abstract List<I> a();
  
  public abstract void a(IFetchDataRspListener<WSVerticalItemData> paramIFetchDataRspListener);
  
  public abstract boolean a(PARAM paramPARAM);
  
  public abstract void b();
  
  public abstract void b(IFetchDataRspListener<WSVerticalItemData> paramIFetchDataRspListener);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.profile.data.WSIShareDataFetcher
 * JD-Core Version:    0.7.0.1
 */