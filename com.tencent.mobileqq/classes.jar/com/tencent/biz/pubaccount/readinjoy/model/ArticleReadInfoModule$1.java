package com.tencent.biz.pubaccount.readinjoy.model;

import com.tencent.biz.pubaccount.readinjoy.struct.ArticleReadInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import qeu;

public class ArticleReadInfoModule$1
  implements Runnable
{
  public ArticleReadInfoModule$1(qeu paramqeu) {}
  
  public void run()
  {
    List localList = this.this$0.a.query(ArticleReadInfo.class, true, null, null, null, null, null, null);
    qeu.a(this.this$0, localList);
    qeu.a(this.this$0).set(true);
    QLog.d("ArticleReadInfoModule", 1, "article info read load from db finish");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.ArticleReadInfoModule.1
 * JD-Core Version:    0.7.0.1
 */