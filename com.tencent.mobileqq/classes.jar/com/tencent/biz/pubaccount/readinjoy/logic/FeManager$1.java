package com.tencent.biz.pubaccount.readinjoy.logic;

import java.util.concurrent.atomic.AtomicBoolean;

class FeManager$1
  implements Runnable
{
  public void run()
  {
    try
    {
      this.this$0.jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicGFeReporter.a(this.a);
    }
    catch (Exception localException2)
    {
      try
      {
        this.this$0.jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicPFeReporter.a(this.a);
      }
      catch (Exception localException2)
      {
        try
        {
          for (;;)
          {
            FeManager.a(this.this$0, System.currentTimeMillis());
            FeManager.a(this.this$0, FeManager.a(this.this$0));
            if (this.this$0.jdField_a_of_type_Boolean) {
              this.this$0.jdField_a_of_type_Boolean = false;
            }
            FeManager.a(this.this$0).set(false);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.logic.FeManager.1
 * JD-Core Version:    0.7.0.1
 */