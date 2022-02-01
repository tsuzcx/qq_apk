package com.tencent.biz.pubaccount.readinjoy.logic;

import java.util.concurrent.atomic.AtomicBoolean;
import pnu;
import pnv;
import pnw;

public class FeManager$1
  implements Runnable
{
  public void run()
  {
    try
    {
      this.this$0.jdField_a_of_type_Pnv.a(this.a);
    }
    catch (Exception localException2)
    {
      try
      {
        this.this$0.jdField_a_of_type_Pnw.a(this.a);
      }
      catch (Exception localException2)
      {
        try
        {
          for (;;)
          {
            pnu.a(this.this$0, System.currentTimeMillis());
            pnu.a(this.this$0, pnu.a(this.this$0));
            if (this.this$0.jdField_a_of_type_Boolean) {
              this.this$0.jdField_a_of_type_Boolean = false;
            }
            pnu.a(this.this$0).set(false);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.logic.FeManager.1
 * JD-Core Version:    0.7.0.1
 */