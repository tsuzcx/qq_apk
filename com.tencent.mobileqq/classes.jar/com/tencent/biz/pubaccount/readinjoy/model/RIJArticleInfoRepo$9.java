package com.tencent.biz.pubaccount.readinjoy.model;

import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import qga;

public class RIJArticleInfoRepo$9
  implements Runnable
{
  public RIJArticleInfoRepo$9(qga paramqga, int paramInt) {}
  
  public void run()
  {
    qga.a(this.this$0).execSQL("DELETE FROM " + ArticleInfo.class.getSimpleName() + " WHERE mChannelID = " + this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.RIJArticleInfoRepo.9
 * JD-Core Version:    0.7.0.1
 */