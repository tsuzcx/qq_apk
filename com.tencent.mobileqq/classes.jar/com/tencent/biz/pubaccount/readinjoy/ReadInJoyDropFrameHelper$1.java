package com.tencent.biz.pubaccount.readinjoy;

import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class ReadInJoyDropFrameHelper$1
  implements Runnable
{
  public void run()
  {
    Iterator localIterator = ((List)ReadInJoyDropFrameHelper.a(this.this$0).get(Integer.valueOf(ReadInJoyDropFrameHelper.a(this.this$0, this.a)))).iterator();
    while (localIterator.hasNext())
    {
      ReadInJoyDropFrameHelper.OnFeedsFluencyResultListener localOnFeedsFluencyResultListener = (ReadInJoyDropFrameHelper.OnFeedsFluencyResultListener)localIterator.next();
      QLog.d("ReadInJoyDropFrameHelper", 2, "updateFeedsFluency UI FluencyVal : " + this.b);
      localOnFeedsFluencyResultListener.a(this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ReadInJoyDropFrameHelper.1
 * JD-Core Version:    0.7.0.1
 */