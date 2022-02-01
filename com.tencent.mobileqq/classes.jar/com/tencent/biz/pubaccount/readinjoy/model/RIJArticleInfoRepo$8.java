package com.tencent.biz.pubaccount.readinjoy.model;

import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;

class RIJArticleInfoRepo$8
  implements Runnable
{
  RIJArticleInfoRepo$8(RIJArticleInfoRepo paramRIJArticleInfoRepo, ArticleInfo paramArticleInfo) {}
  
  public void run()
  {
    if (!RIJArticleInfoRepo.a(this.this$0).remove(this.a)) {
      QLog.d("RIJArticleInfoRepo", 2, "delete article fail ! title : " + this.a.mTitle + " , articleID : " + this.a.mArticleID);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.RIJArticleInfoRepo.8
 * JD-Core Version:    0.7.0.1
 */