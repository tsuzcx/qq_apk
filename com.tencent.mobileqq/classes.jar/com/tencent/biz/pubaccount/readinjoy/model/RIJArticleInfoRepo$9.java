package com.tencent.biz.pubaccount.readinjoy.model;

import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.mobileqq.persistence.EntityManager;

class RIJArticleInfoRepo$9
  implements Runnable
{
  RIJArticleInfoRepo$9(RIJArticleInfoRepo paramRIJArticleInfoRepo, int paramInt) {}
  
  public void run()
  {
    RIJArticleInfoRepo.a(this.this$0).execSQL("DELETE FROM " + ArticleInfo.class.getSimpleName() + " WHERE mChannelID = " + this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.RIJArticleInfoRepo.9
 * JD-Core Version:    0.7.0.1
 */