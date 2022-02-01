package com.tencent.biz.subscribe.beans;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;

public class RecommendInfoItem
{
  public int a;
  public CertifiedAccountMeta.StFeed a;
  public CertifiedAccountMeta.StUser a;
  
  public RecommendInfoItem(CertifiedAccountMeta.StFeed paramStFeed)
  {
    this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed = paramStFeed;
    this.jdField_a_of_type_Int = 2;
  }
  
  public RecommendInfoItem(CertifiedAccountMeta.StUser paramStUser)
  {
    this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StUser = paramStUser;
    this.jdField_a_of_type_Int = 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.beans.RecommendInfoItem
 * JD-Core Version:    0.7.0.1
 */