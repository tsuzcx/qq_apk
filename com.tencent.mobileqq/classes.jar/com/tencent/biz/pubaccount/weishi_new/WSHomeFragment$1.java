package com.tencent.biz.pubaccount.weishi_new;

import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qroute.QRoute;

class WSHomeFragment$1
  implements Runnable
{
  WSHomeFragment$1(WSHomeFragment paramWSHomeFragment) {}
  
  public void run()
  {
    String str = HardCodeUtil.a(2131706836) + ((IMiniAppService)QRoute.api(IMiniAppService.class)).getMemeryUsage() + "%";
    if (WSHomeFragment.a(this.this$0) != null) {
      WSHomeFragment.a(this.this$0).setText(str);
    }
    this.this$0.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.WSHomeFragment.1
 * JD-Core Version:    0.7.0.1
 */