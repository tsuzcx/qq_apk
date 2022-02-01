package com.tencent.biz.pubaccount.weishi_new.profile.data;

public class WSShareDataFetchFactory
{
  public static WSIShareDataFetcher a(String paramString)
  {
    return new WSProfileFeedsDataFetcher();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.profile.data.WSShareDataFetchFactory
 * JD-Core Version:    0.7.0.1
 */