package com.tencent.biz.pubaccount.readinjoy.view.fastweb;

import com.tencent.biz.pubaccount.readinjoy.comment.data.AnchorData;
import com.tencent.qphone.base.util.QLog;
import ozh;

class FastWebActivity$39
  implements Runnable
{
  FastWebActivity$39(FastWebActivity paramFastWebActivity) {}
  
  public void run()
  {
    if ((FastWebActivity.a(this.this$0) == null) || (FastWebActivity.a(this.this$0) == null))
    {
      QLog.d("FastWebActivity", 1, "error! scrollToHotNewComment");
      return;
    }
    if (FastWebActivity.a(this.this$0).b)
    {
      FastWebActivity.a(this.this$0).f();
      return;
    }
    FastWebActivity.a(this.this$0).e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity.39
 * JD-Core Version:    0.7.0.1
 */