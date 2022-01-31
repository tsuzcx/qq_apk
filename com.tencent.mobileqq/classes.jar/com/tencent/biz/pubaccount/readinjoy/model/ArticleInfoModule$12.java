package com.tencent.biz.pubaccount.readinjoy.model;

import awbw;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import pew;

public class ArticleInfoModule$12
  implements Runnable
{
  public ArticleInfoModule$12(pew parampew, int paramInt) {}
  
  public void run()
  {
    this.this$0.a.b("DELETE FROM " + ArticleInfo.class.getSimpleName() + " WHERE mChannelID = " + this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.ArticleInfoModule.12
 * JD-Core Version:    0.7.0.1
 */