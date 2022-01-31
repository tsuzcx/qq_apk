package com.tencent.biz.pubaccount.ecshopassit;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

public class EcShopData
  extends Entity
{
  public static final String TABLE_NAME = "EcShopData";
  public long bindUin;
  public int mDistance;
  public String mImgInfo = "";
  public long mLastDraftTime;
  public long mLastMsgTime;
  @unique
  public String mUin;
  public String msgId;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.ecshopassit.EcShopData
 * JD-Core Version:    0.7.0.1
 */