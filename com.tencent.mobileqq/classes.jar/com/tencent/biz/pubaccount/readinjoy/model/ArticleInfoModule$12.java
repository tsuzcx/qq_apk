package com.tencent.biz.pubaccount.readinjoy.model;

import atmp;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import ooq;

public class ArticleInfoModule$12
  implements Runnable
{
  public ArticleInfoModule$12(ooq paramooq, int paramInt) {}
  
  public void run()
  {
    this.this$0.a.b("DELETE FROM " + ArticleInfo.class.getSimpleName() + " WHERE mChannelID = " + this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.ArticleInfoModule.12
 * JD-Core Version:    0.7.0.1
 */