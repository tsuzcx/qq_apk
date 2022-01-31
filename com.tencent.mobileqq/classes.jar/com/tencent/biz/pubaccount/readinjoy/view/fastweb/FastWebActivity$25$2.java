package com.tencent.biz.pubaccount.readinjoy.view.fastweb;

import android.os.Build.VERSION;
import aoft;
import ryq;
import ryr;

public class FastWebActivity$25$2
  implements Runnable
{
  public FastWebActivity$25$2(ryq paramryq) {}
  
  public void run()
  {
    if ((Build.VERSION.SDK_INT > 26) && (FastWebActivity.a(this.a.a) == null))
    {
      aoft.a(this.a.a, new ryr(this));
      return;
    }
    this.a.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity.25.2
 * JD-Core Version:    0.7.0.1
 */