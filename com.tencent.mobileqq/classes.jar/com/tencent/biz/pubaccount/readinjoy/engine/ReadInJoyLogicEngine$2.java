package com.tencent.biz.pubaccount.readinjoy.engine;

import com.tencent.qphone.base.util.QLog;
import owy;
import oxb;

public class ReadInJoyLogicEngine$2
  implements Runnable
{
  public ReadInJoyLogicEngine$2(owy paramowy, int paramInt) {}
  
  public void run()
  {
    QLog.d("ReadInJoyLogicEngine", 1, new Object[] { "onLoadMoreArticle, channelID = ", Integer.valueOf(this.a) });
    oxb.a().b(false, this.a, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine.2
 * JD-Core Version:    0.7.0.1
 */