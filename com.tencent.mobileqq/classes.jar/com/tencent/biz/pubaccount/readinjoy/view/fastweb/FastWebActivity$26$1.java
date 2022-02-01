package com.tencent.biz.pubaccount.readinjoy.view.fastweb;

import android.os.Build.VERSION;
import apoq;
import srs;
import srt;

public class FastWebActivity$26$1
  implements Runnable
{
  public FastWebActivity$26$1(srs paramsrs) {}
  
  public void run()
  {
    if ((Build.VERSION.SDK_INT > 26) && (FastWebActivity.a(this.a.a) == null))
    {
      apoq.a(this.a.a, new srt(this));
      return;
    }
    this.a.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity.26.1
 * JD-Core Version:    0.7.0.1
 */