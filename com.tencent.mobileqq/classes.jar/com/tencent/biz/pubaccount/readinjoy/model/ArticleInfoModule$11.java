package com.tencent.biz.pubaccount.readinjoy.model;

import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import ptv;

public class ArticleInfoModule$11
  implements Runnable
{
  public ArticleInfoModule$11(ptv paramptv, int paramInt) {}
  
  public void run()
  {
    this.this$0.a.execSQL("DELETE FROM " + ArticleInfo.class.getSimpleName() + " WHERE mChannelID = " + this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.ArticleInfoModule.11
 * JD-Core Version:    0.7.0.1
 */