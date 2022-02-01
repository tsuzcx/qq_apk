package com.tencent.biz.pubaccount.readinjoy.model;

import com.tencent.biz.pubaccount.readinjoy.struct.WeiShiVideoArticleInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;

class ReadInJoyEngineModule$10
  implements IFindRemovedEntity<WeiShiVideoArticleInfo>
{
  ReadInJoyEngineModule$10(ReadInJoyEngineModule paramReadInJoyEngineModule) {}
  
  public Entity a(EntityManager paramEntityManager, WeiShiVideoArticleInfo paramWeiShiVideoArticleInfo)
  {
    paramEntityManager = null;
    if (this.a.a.tabbleIsExist(WeiShiVideoArticleInfo.class.getSimpleName())) {
      paramEntityManager = this.a.a.find(WeiShiVideoArticleInfo.class, "articleID = ? and channelID = ?", new String[] { String.valueOf(paramWeiShiVideoArticleInfo.articleID), String.valueOf(paramWeiShiVideoArticleInfo.channelID) });
    }
    return paramEntityManager;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyEngineModule.10
 * JD-Core Version:    0.7.0.1
 */