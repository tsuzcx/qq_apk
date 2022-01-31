package com.tencent.biz.pubaccount.readinjoy.view.fastweb;

import java.util.List;
import rjs;
import rnm;

class FastWebActivity$26
  implements Runnable
{
  FastWebActivity$26(FastWebActivity paramFastWebActivity, List paramList) {}
  
  public void run()
  {
    if (FastWebActivity.a(this.this$0) != null)
    {
      rnm.c(FastWebActivity.a(this.this$0), this.a);
      FastWebActivity.a(this.this$0).notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity.26
 * JD-Core Version:    0.7.0.1
 */