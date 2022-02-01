package com.tencent.biz.pubaccount.accountdetail.api.impl;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

public class PublicAccountDynamicInfoEntityImpl
  extends Entity
{
  public byte[] dynamicInfoData = null;
  @unique
  public String puin;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDynamicInfoEntityImpl
 * JD-Core Version:    0.7.0.1
 */