package com.tencent.biz.pubaccount.readinjoy.view.fastweb;

import amkm;
import android.os.Build.VERSION;
import riv;
import riw;

public class FastWebActivity$25$2
  implements Runnable
{
  public FastWebActivity$25$2(riv paramriv) {}
  
  public void run()
  {
    if ((Build.VERSION.SDK_INT > 26) && (FastWebActivity.a(this.a.a) == null))
    {
      amkm.a(this.a.a, new riw(this));
      return;
    }
    this.a.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity.25.2
 * JD-Core Version:    0.7.0.1
 */