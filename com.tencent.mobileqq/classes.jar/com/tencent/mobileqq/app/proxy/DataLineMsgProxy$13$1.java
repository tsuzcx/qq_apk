package com.tencent.mobileqq.app.proxy;

import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSetList;
import java.util.Iterator;
import java.util.List;

class DataLineMsgProxy$13$1
  implements Runnable
{
  DataLineMsgProxy$13$1(DataLineMsgProxy.13 param13, List paramList) {}
  
  public void run()
  {
    Object localObject = this.a;
    int k = 0;
    int i = 0;
    int j = k;
    if (localObject != null)
    {
      j = k;
      if (DataLineMsgProxy.a(this.b.this$0) != null)
      {
        localObject = this.a.iterator();
        for (;;)
        {
          j = i;
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          DataLineMsgRecord localDataLineMsgRecord = (DataLineMsgRecord)((Iterator)localObject).next();
          if (DataLineMsgProxy.a(this.b.this$0).insertFrontToList(localDataLineMsgRecord)) {
            i += 1;
          }
        }
      }
    }
    if (this.b.c != null) {
      this.b.c.a(j);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.proxy.DataLineMsgProxy.13.1
 * JD-Core Version:    0.7.0.1
 */