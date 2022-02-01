package com.tencent.biz.pubaccount.weishi_new;

import android.support.v4.app.Fragment;
import java.util.List;
import ujo;
import uwz;

public class WSHomeFragment$3$1
  implements Runnable
{
  public WSHomeFragment$3$1(ujo paramujo) {}
  
  public void run()
  {
    if (WSHomeFragment.c(this.a.a))
    {
      int i = 0;
      while (i < WSHomeFragment.a(this.a.a).size())
      {
        Fragment localFragment = (Fragment)WSHomeFragment.a(this.a.a).get(i);
        if ((localFragment instanceof uwz)) {
          ((uwz)localFragment).a(WSHomeFragment.a);
        }
        i += 1;
      }
    }
    WSHomeFragment.b(this.a.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.WSHomeFragment.3.1
 * JD-Core Version:    0.7.0.1
 */