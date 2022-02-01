package com.tencent.mobileqq.activity.qwallet;

import ajuj;
import ajul;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class PasswdRedBagManager$10
  implements Runnable
{
  public PasswdRedBagManager$10(ajul paramajul) {}
  
  public void run()
  {
    try
    {
      Object localObject = ajul.a(this.this$0).a();
      if (localObject != null)
      {
        ajul.a(this.this$0, false);
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
      ajul.b(this.this$0, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.PasswdRedBagManager.10
 * JD-Core Version:    0.7.0.1
 */