package com.tencent.biz.pubaccount.readinjoy.view.fastweb;

import android.os.Build.VERSION;
import aqge;
import swp;
import swq;

public class FastWebActivity$27$2
  implements Runnable
{
  public FastWebActivity$27$2(swp paramswp) {}
  
  public void run()
  {
    if ((Build.VERSION.SDK_INT > 26) && (FastWebActivity.a(this.a.a) == null))
    {
      aqge.a(this.a.a, new swq(this));
      return;
    }
    this.a.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity.27.2
 * JD-Core Version:    0.7.0.1
 */