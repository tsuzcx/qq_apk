package com.tencent.biz.webviewplugin;

import awbv;
import awbw;
import com.tencent.mobileqq.data.OfflineWebRes;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import zab;

public class OfflineWebResManager$2
  implements Runnable
{
  public OfflineWebResManager$2(zab paramzab, int paramInt) {}
  
  public void run()
  {
    try
    {
      Thread.sleep(this.a * 1000);
      if (!zab.jdField_a_of_type_Boolean)
      {
        zab.c();
        if (!zab.b)
        {
          this.this$0.jdField_a_of_type_Awbw.a(OfflineWebRes.class.getSimpleName());
          return;
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
      zab.jdField_a_of_type_Boolean = this.this$0.jdField_a_of_type_Awbw.d(OfflineWebRes.class.getSimpleName());
      Object localObject;
      if (!zab.jdField_a_of_type_Boolean)
      {
        localObject = new OfflineWebRes();
        ((OfflineWebRes)localObject).fileName = "test";
        ((OfflineWebRes)localObject).hashName = "test";
        ((OfflineWebRes)localObject).md5 = "test_md5";
        this.this$0.jdField_a_of_type_Awbw.a((awbv)localObject);
      }
      while (!zab.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.isEmpty())
      {
        localObject = (String)zab.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.poll();
        this.this$0.b((String)localObject);
      }
      this.this$0.a();
      this.this$0.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.OfflineWebResManager.2
 * JD-Core Version:    0.7.0.1
 */