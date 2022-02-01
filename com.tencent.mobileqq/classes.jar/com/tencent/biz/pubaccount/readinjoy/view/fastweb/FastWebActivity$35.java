package com.tencent.biz.pubaccount.readinjoy.view.fastweb;

import com.tencent.qphone.base.util.QLog;

class FastWebActivity$35
  implements Runnable
{
  FastWebActivity$35(FastWebActivity paramFastWebActivity, boolean paramBoolean) {}
  
  public void run()
  {
    try
    {
      if (this.a) {
        FastWebActivity.k(this.this$0);
      }
      for (;;)
      {
        FastWebActivity.d(this.this$0, this.a);
        return;
        FastWebActivity.l(this.this$0);
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.d("FastWebActivity", 1, "jump error, msg=" + localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity.35
 * JD-Core Version:    0.7.0.1
 */