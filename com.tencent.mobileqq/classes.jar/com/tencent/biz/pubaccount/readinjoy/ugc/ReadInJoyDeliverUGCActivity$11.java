package com.tencent.biz.pubaccount.readinjoy.ugc;

import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Iterator;
import java.util.List;

class ReadInJoyDeliverUGCActivity$11
  implements Runnable
{
  ReadInJoyDeliverUGCActivity$11(ReadInJoyDeliverUGCActivity paramReadInJoyDeliverUGCActivity) {}
  
  public void run()
  {
    Iterator localIterator = ReadInJoyDeliverUGCActivity.b(this.this$0).iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = (String)localIterator.next();
      try
      {
        localObject1 = new File((String)localObject1);
        if (((File)localObject1).exists()) {
          ((File)localObject1).delete();
        }
      }
      catch (NullPointerException localNullPointerException1)
      {
        QLog.d("ReadInJoyDeliverUGCActivity", 2, "deleteFile error" + localNullPointerException1.toString());
      }
    }
    localIterator = ReadInJoyDeliverUGCActivity.c(this.this$0).iterator();
    while (localIterator.hasNext())
    {
      Object localObject2 = (String)localIterator.next();
      try
      {
        localObject2 = new File((String)localObject2);
        if (((File)localObject2).exists()) {
          ((File)localObject2).delete();
        }
      }
      catch (NullPointerException localNullPointerException2)
      {
        QLog.d("ReadInJoyDeliverUGCActivity", 2, "deleteFile error" + localNullPointerException2.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDeliverUGCActivity.11
 * JD-Core Version:    0.7.0.1
 */