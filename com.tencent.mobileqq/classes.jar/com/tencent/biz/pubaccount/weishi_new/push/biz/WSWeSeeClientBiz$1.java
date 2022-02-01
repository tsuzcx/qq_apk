package com.tencent.biz.pubaccount.weishi_new.push.biz;

import android.content.Context;
import com.tencent.biz.pubaccount.weishi_new.push.WSPushStrategyInfo;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiScehmeUtil;

class WSWeSeeClientBiz$1
  implements Runnable
{
  WSWeSeeClientBiz$1(WSWeSeeClientBiz paramWSWeSeeClientBiz, Context paramContext, WSPushStrategyInfo paramWSPushStrategyInfo) {}
  
  public void run()
  {
    WeishiScehmeUtil.a(this.a.getApplicationContext(), "biz_src_jc_gzh_weishi", this.b.mScheme);
    WSWeSeeClientBiz.a(this.this$0, this.b.mScheme);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.push.biz.WSWeSeeClientBiz.1
 * JD-Core Version:    0.7.0.1
 */