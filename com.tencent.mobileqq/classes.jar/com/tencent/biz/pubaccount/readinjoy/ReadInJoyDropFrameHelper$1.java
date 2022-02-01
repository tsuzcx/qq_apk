package com.tencent.biz.pubaccount.readinjoy;

import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import orn;
import orp;

public class ReadInJoyDropFrameHelper$1
  implements Runnable
{
  public void run()
  {
    Iterator localIterator = ((List)orn.a(this.this$0).get(Integer.valueOf(orn.a(this.this$0, this.a)))).iterator();
    while (localIterator.hasNext())
    {
      orp localorp = (orp)localIterator.next();
      QLog.d("ReadInJoyDropFrameHelper", 2, "updateFeedsFluency UI FluencyVal : " + this.b);
      localorp.a(this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ReadInJoyDropFrameHelper.1
 * JD-Core Version:    0.7.0.1
 */