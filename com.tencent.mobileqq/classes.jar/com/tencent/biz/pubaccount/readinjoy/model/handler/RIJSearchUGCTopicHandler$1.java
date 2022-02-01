package com.tencent.biz.pubaccount.readinjoy.model.handler;

import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class RIJSearchUGCTopicHandler$1
  implements Runnable
{
  RIJSearchUGCTopicHandler$1(RIJSearchUGCTopicHandler paramRIJSearchUGCTopicHandler, List paramList1, List paramList2) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RIJSearchUGCTopicHandler", 2, "onTopicInfoListFetched: keywordList: " + this.a + " topicInfoList: " + this.b);
    }
    ReadInJoyLogicEngineEventDispatcher.a().a(this.a, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.handler.RIJSearchUGCTopicHandler.1
 * JD-Core Version:    0.7.0.1
 */