package com.tencent.biz.pubaccount.readinjoy.engine;

import com.tencent.qphone.base.util.QLog;
import osg;
import osj;

public class ReadInJoyLogicEngine$2
  implements Runnable
{
  public ReadInJoyLogicEngine$2(osg paramosg, int paramInt) {}
  
  public void run()
  {
    QLog.d("ReadInJoyLogicEngine", 1, new Object[] { "onLoadMoreArticle, channelID = ", Integer.valueOf(this.a) });
    osj.a().b(false, this.a, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine.2
 * JD-Core Version:    0.7.0.1
 */