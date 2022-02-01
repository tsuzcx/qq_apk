package com.tencent.biz.pubaccount.readinjoy.model;

import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;

class ReadInJoyEngineModule$2
  implements IFindRemovedEntity<ArticleInfo>
{
  ReadInJoyEngineModule$2(ReadInJoyEngineModule paramReadInJoyEngineModule) {}
  
  public Entity a(EntityManager paramEntityManager, ArticleInfo paramArticleInfo)
  {
    Object localObject = null;
    if (this.a.a.tabbleIsExist(ArticleInfo.class.getSimpleName()))
    {
      paramEntityManager = null;
      if (paramArticleInfo.mChannelID != 70L) {
        paramEntityManager = this.a.a.find(ArticleInfo.class, "mArticleID = ? and mChannelID = ?", new String[] { String.valueOf(paramArticleInfo.mArticleID), String.valueOf(paramArticleInfo.mChannelID) });
      }
      localObject = this.a.a.find(ArticleInfo.class, "mRecommendSeq = ? and mChannelID = ?", new String[] { String.valueOf(paramArticleInfo.mRecommendSeq), String.valueOf(paramArticleInfo.mChannelID) });
      if (paramEntityManager == null) {
        break label262;
      }
    }
    for (;;)
    {
      if ((QLog.isColorLevel()) && (paramEntityManager != null)) {
        QLog.e("ReadInJoyEngineModule", 2, "removeEntityIfExistsInDB, article duplicated, article been channelID=" + paramArticleInfo.mChannelID + "articleID=" + paramArticleInfo.mArticleID + "recommendSeq=" + paramArticleInfo.mRecommendSeq);
      }
      localObject = paramEntityManager;
      if (paramArticleInfo.mChannelID == 70L)
      {
        localObject = paramEntityManager;
        if (paramArticleInfo.mFeedId != 0L)
        {
          paramArticleInfo = this.a.a.find(ArticleInfo.class, "mFeedId = ? and mChannelID = ?", new String[] { String.valueOf(paramArticleInfo.mFeedId), String.valueOf(paramArticleInfo.mChannelID) });
          localObject = paramEntityManager;
          if (paramArticleInfo != null)
          {
            this.a.a.remove(paramArticleInfo);
            localObject = paramEntityManager;
          }
        }
      }
      return localObject;
      label262:
      paramEntityManager = (EntityManager)localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyEngineModule.2
 * JD-Core Version:    0.7.0.1
 */