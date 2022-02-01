package com.tencent.biz.pubaccount.readinjoy.view.fastweb;

import android.os.Build.VERSION;
import com.tencent.mobileqq.colornote.swipeback.SwipeLayoutUtils;

class FastWebActivity$26$1
  implements Runnable
{
  FastWebActivity$26$1(FastWebActivity.26 param26) {}
  
  public void run()
  {
    if ((Build.VERSION.SDK_INT > 26) && (FastWebActivity.a(this.a.a) == null))
    {
      SwipeLayoutUtils.a(this.a.a, new FastWebActivity.26.1.1(this));
      return;
    }
    this.a.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity.26.1
 * JD-Core Version:    0.7.0.1
 */