package com.tencent.biz.pubaccount.readinjoy.logic;

import java.util.concurrent.atomic.AtomicBoolean;
import oyy;
import oyz;
import oza;

public class FeManager$1
  implements Runnable
{
  public void run()
  {
    try
    {
      this.this$0.jdField_a_of_type_Oyz.a(this.a);
    }
    catch (Exception localException2)
    {
      try
      {
        this.this$0.jdField_a_of_type_Oza.a(this.a);
      }
      catch (Exception localException2)
      {
        try
        {
          for (;;)
          {
            oyy.a(this.this$0, System.currentTimeMillis());
            oyy.a(this.this$0, oyy.a(this.this$0));
            if (this.this$0.jdField_a_of_type_Boolean) {
              this.this$0.jdField_a_of_type_Boolean = false;
            }
            oyy.a(this.this$0).set(false);
            return;
            localException1 = localException1;
            localException1.printStackTrace();
            continue;
            localException2 = localException2;
            localException2.printStackTrace();
          }
        }
        catch (Exception localException3)
        {
          for (;;)
          {
            localException3.printStackTrace();
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.logic.FeManager.1
 * JD-Core Version:    0.7.0.1
 */