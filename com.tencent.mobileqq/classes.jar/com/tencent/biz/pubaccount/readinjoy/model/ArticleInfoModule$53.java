package com.tencent.biz.pubaccount.readinjoy.model;

import com.tencent.qphone.base.util.QLog;
import java.util.List;
import oxb;
import pew;

public class ArticleInfoModule$53
  implements Runnable
{
  public ArticleInfoModule$53(pew parampew, List paramList1, List paramList2) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArticleInfoModule", 2, "onTopicInfoListFetched: keywordList: " + this.a + " topicInfoList: " + this.b);
    }
    oxb.a().a(this.a, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.ArticleInfoModule.53
 * JD-Core Version:    0.7.0.1
 */