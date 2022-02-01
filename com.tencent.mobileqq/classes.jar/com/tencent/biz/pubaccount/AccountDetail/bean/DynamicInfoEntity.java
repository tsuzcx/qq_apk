package com.tencent.biz.pubaccount.AccountDetail.bean;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

public class DynamicInfoEntity
  extends Entity
{
  public byte[] dynamicInfoData = null;
  @unique
  public String puin;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.AccountDetail.bean.DynamicInfoEntity
 * JD-Core Version:    0.7.0.1
 */