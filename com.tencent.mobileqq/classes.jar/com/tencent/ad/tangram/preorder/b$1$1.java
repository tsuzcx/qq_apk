package com.tencent.ad.tangram.preorder;

import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.AdBuilder;
import com.tencent.ad.tangram.net.AdHttp.Params;
import com.tencent.ad.tangram.protocol.msg_content;
import com.tencent.ad.tangram.statistics.b;

class b$1$1
  implements Runnable
{
  b$1$1(b.1 param1, msg_content parammsg_content) {}
  
  public void run()
  {
    if (this.this$0.val$params.responseCode != -2147483648)
    {
      if (this.val$finalMsgContent != null)
      {
        AdAppPreOrderManager.INSTANCE.setTaskStatusAndCommit(this.this$0.val$msgId, 5, this.val$finalMsgContent);
        Ad localAd = AdBuilder.INSTANCE.build(this.val$finalMsgContent.ad_info);
        b.reportAsync(this.this$0.val$context, localAd, 317);
        return;
      }
      AdAppPreOrderManager.INSTANCE.setTaskFinishedAndCommit(this.this$0.val$msgId, 101);
      return;
    }
    AdAppPreOrderManager.INSTANCE.setTaskStatusAndCommit(this.this$0.val$msgId, 6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.preorder.b.1.1
 * JD-Core Version:    0.7.0.1
 */