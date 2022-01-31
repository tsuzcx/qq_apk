package com.tencent.biz.pubaccount.readinjoy.view.fastweb;

import android.os.Build.VERSION;
import qwj;

public class FastWebActivity$22$2
  implements Runnable
{
  public FastWebActivity$22$2(qwj paramqwj) {}
  
  public void run()
  {
    if (Build.VERSION.SDK_INT > 26)
    {
      FastWebActivity.g(this.a.a);
      return;
    }
    this.a.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity.22.2
 * JD-Core Version:    0.7.0.1
 */