package com.tencent.biz.pubaccount.weishi_new.data;

public abstract interface IDataFetcher<PARAM extends FetcherParams, I>
{
  public abstract boolean a(PARAM paramPARAM, IFetchDataRspListener<I> paramIFetchDataRspListener);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.data.IDataFetcher
 * JD-Core Version:    0.7.0.1
 */