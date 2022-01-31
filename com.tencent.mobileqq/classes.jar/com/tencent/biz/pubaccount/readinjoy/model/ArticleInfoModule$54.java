package com.tencent.biz.pubaccount.readinjoy.model;

import com.tencent.qphone.base.util.QLog;
import java.util.List;
import osm;
import ozr;

public class ArticleInfoModule$54
  implements Runnable
{
  public ArticleInfoModule$54(ozr paramozr, List paramList1, List paramList2) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArticleInfoModule", 2, "onTopicInfoListFetched: keywordList: " + this.a + " topicInfoList: " + this.b);
    }
    osm.a().a(this.a, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.ArticleInfoModule.54
 * JD-Core Version:    0.7.0.1
 */