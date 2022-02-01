package com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.push;

import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;

final class RIJMergeKanDianMessage$1
  implements Runnable
{
  RIJMergeKanDianMessage$1(QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    ((KandianMergeManager)this.a.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER)).j();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.push.RIJMergeKanDianMessage.1
 * JD-Core Version:    0.7.0.1
 */