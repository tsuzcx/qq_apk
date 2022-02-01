package com.tencent.biz.pubaccount.readinjoy.model;

import com.tencent.qphone.base.util.QLog;
import java.util.List;
import pfd;
import pon;

public class ArticleInfoModule$52
  implements Runnable
{
  public ArticleInfoModule$52(pon parampon, List paramList1, List paramList2) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArticleInfoModule", 2, "onTopicInfoListFetched: keywordList: " + this.a + " topicInfoList: " + this.b);
    }
    pfd.a().a(this.a, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.ArticleInfoModule.52
 * JD-Core Version:    0.7.0.1
 */