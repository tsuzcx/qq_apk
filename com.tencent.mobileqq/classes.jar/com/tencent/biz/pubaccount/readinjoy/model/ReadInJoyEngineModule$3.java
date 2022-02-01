package com.tencent.biz.pubaccount.readinjoy.model;

import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleReadInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;

class ReadInJoyEngineModule$3
  implements IFindRemovedEntity<ArticleReadInfo>
{
  ReadInJoyEngineModule$3(ReadInJoyEngineModule paramReadInJoyEngineModule) {}
  
  public Entity a(EntityManager paramEntityManager, ArticleReadInfo paramArticleReadInfo)
  {
    paramEntityManager = null;
    if (this.a.a.tabbleIsExist(ArticleInfo.class.getSimpleName())) {
      paramEntityManager = this.a.a.find(ArticleReadInfo.class, "mArticleID = ?", new String[] { String.valueOf(paramArticleReadInfo.mArticleID) });
    }
    return paramEntityManager;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyEngineModule.3
 * JD-Core Version:    0.7.0.1
 */