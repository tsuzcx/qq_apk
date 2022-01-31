package com.tencent.biz.pubaccount.ecshopassit;

import com.tencent.mobileqq.activity.recent.data.RecentPubAccountAssistantItem;
import com.tencent.mobileqq.data.PubAccountAssistantData;

public class RecentItemEcShop
  extends RecentPubAccountAssistantItem
{
  public long bindUin;
  public String imgInfos;
  
  public RecentItemEcShop(EcShopData paramEcShopData)
  {
    super(a(paramEcShopData));
    this.mUnreadFlag = 1;
    this.imgInfos = paramEcShopData.mImgInfo;
  }
  
  protected static PubAccountAssistantData a(EcShopData paramEcShopData)
  {
    PubAccountAssistantData localPubAccountAssistantData = new PubAccountAssistantData();
    localPubAccountAssistantData.mUin = paramEcShopData.mUin;
    localPubAccountAssistantData.mLastDraftTime = paramEcShopData.mLastDraftTime;
    localPubAccountAssistantData.mLastMsgTime = paramEcShopData.mLastMsgTime;
    localPubAccountAssistantData.mDistance = paramEcShopData.mDistance;
    return localPubAccountAssistantData;
  }
  
  public int a()
  {
    return 1008;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.ecshopassit.RecentItemEcShop
 * JD-Core Version:    0.7.0.1
 */