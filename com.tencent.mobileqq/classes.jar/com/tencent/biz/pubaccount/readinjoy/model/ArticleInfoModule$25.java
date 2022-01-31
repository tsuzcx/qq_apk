package com.tencent.biz.pubaccount.readinjoy.model;

import awgf;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.qphone.base.util.QLog;
import pew;

public class ArticleInfoModule$25
  implements Runnable
{
  public ArticleInfoModule$25(pew parampew, ArticleInfo paramArticleInfo) {}
  
  public void run()
  {
    if (!this.this$0.a.b(this.a)) {
      QLog.d("ArticleInfoModule", 2, "delete article fail ! title : " + this.a.mTitle + " , articleID : " + this.a.mArticleID);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.ArticleInfoModule.25
 * JD-Core Version:    0.7.0.1
 */