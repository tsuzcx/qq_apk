package com.tencent.biz.pubaccount.weishi_new;

import com.tencent.biz.pubaccount.weishi_new.ui.OnTabSelectedListener;
import com.tencent.mobileqq.app.BaseFragment;
import java.util.List;

class WSHomeFragment$3$1
  implements Runnable
{
  WSHomeFragment$3$1(WSHomeFragment.3 param3) {}
  
  public void run()
  {
    if (WSHomeFragment.c(this.a.a))
    {
      WSHomeFragment.c(this.a.a);
      int i = 0;
      while (i < WSHomeFragment.a(this.a.a).size())
      {
        Object localObject = (BaseFragment)WSHomeFragment.a(this.a.a).get(i);
        if ((localObject instanceof OnTabSelectedListener))
        {
          localObject = (OnTabSelectedListener)localObject;
          if (WSHomeFragment.a == i) {
            ((OnTabSelectedListener)localObject).g();
          } else {
            ((OnTabSelectedListener)localObject).h();
          }
        }
        i += 1;
      }
    }
    WSHomeFragment.b(this.a.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.WSHomeFragment.3.1
 * JD-Core Version:    0.7.0.1
 */