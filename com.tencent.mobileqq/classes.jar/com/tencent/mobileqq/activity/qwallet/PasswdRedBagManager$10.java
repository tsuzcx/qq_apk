package com.tencent.mobileqq.activity.qwallet;

import agji;
import agjk;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class PasswdRedBagManager$10
  implements Runnable
{
  public PasswdRedBagManager$10(agjk paramagjk) {}
  
  public void run()
  {
    try
    {
      Object localObject = agjk.a(this.this$0).a();
      if (localObject != null)
      {
        agjk.a(this.this$0, false);
        localObject = ((HashMap)localObject).entrySet().iterator();
        while (((Iterator)localObject).hasNext())
        {
          Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
          this.this$0.d.put(localEntry.getKey(), localEntry.getValue());
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isDevelopLevel()) {
        localThrowable.printStackTrace();
      }
      agjk.b(this.this$0, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.PasswdRedBagManager.10
 * JD-Core Version:    0.7.0.1
 */