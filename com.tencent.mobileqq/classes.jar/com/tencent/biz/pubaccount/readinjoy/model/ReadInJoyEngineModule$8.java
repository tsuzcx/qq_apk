package com.tencent.biz.pubaccount.readinjoy.model;

import com.tencent.biz.pubaccount.readinjoy.struct.TopBannerInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;

class ReadInJoyEngineModule$8
  implements IFindRemovedEntity<TopBannerInfo>
{
  ReadInJoyEngineModule$8(ReadInJoyEngineModule paramReadInJoyEngineModule) {}
  
  public Entity a(EntityManager paramEntityManager, TopBannerInfo paramTopBannerInfo)
  {
    paramEntityManager = null;
    if (this.a.a.tabbleIsExist(TopBannerInfo.class.getSimpleName())) {
      paramEntityManager = this.a.a.find(TopBannerInfo.class, "mChannelId = ?", new String[] { "" + paramTopBannerInfo.mChannelId });
    }
    return paramEntityManager;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyEngineModule.8
 * JD-Core Version:    0.7.0.1
 */