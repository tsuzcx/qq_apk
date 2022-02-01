package com.tencent.biz.subscribe.beans;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;

public class RecommendInfoItem
{
  public int a;
  public CertifiedAccountMeta.StUser b;
  public CertifiedAccountMeta.StFeed c;
  
  public RecommendInfoItem(CertifiedAccountMeta.StFeed paramStFeed)
  {
    this.c = paramStFeed;
    this.a = 2;
  }
  
  public RecommendInfoItem(CertifiedAccountMeta.StUser paramStUser)
  {
    this.b = paramStUser;
    this.a = 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.beans.RecommendInfoItem
 * JD-Core Version:    0.7.0.1
 */