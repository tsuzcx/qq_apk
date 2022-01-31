package com.tencent.biz.pubaccount.readinjoy.view.fastweb;

import amkn;
import android.os.Build.VERSION;
import riy;
import riz;

public class FastWebActivity$25$2
  implements Runnable
{
  public FastWebActivity$25$2(riy paramriy) {}
  
  public void run()
  {
    if ((Build.VERSION.SDK_INT > 26) && (FastWebActivity.a(this.a.a) == null))
    {
      amkn.a(this.a.a, new riz(this));
      return;
    }
    this.a.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity.25.2
 * JD-Core Version:    0.7.0.1
 */