package com.tencent.biz.pubaccount.readinjoy.view.fastweb;

import java.util.List;
import qxb;
import rau;

class FastWebActivity$23
  implements Runnable
{
  FastWebActivity$23(FastWebActivity paramFastWebActivity, List paramList) {}
  
  public void run()
  {
    if (FastWebActivity.a(this.this$0) != null)
    {
      rau.c(FastWebActivity.a(this.this$0), this.a);
      FastWebActivity.a(this.this$0).notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity.23
 * JD-Core Version:    0.7.0.1
 */