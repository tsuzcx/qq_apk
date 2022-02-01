package com.tencent.live2.impl;

import com.tencent.live2.V2TXLivePusher;

class V2TXLivePusherImpl$15
  implements Runnable
{
  V2TXLivePusherImpl$15(V2TXLivePusherImpl paramV2TXLivePusherImpl, String paramString) {}
  
  public void run()
  {
    if ((this.val$url.equals(V2TXLivePusherImpl.access$100(this.this$0))) && (V2TXLivePusherImpl.access$000(this.this$0).isPushing() == 1))
    {
      V2TXLivePusherImpl.access$200(this.this$0, "startPush fail, same url, current is pushing", false);
      V2TXLivePusherImpl.access$302(this.this$0, a.b.a);
      return;
    }
    if (V2TXLivePusherImpl.access$000(this.this$0).isPushing() == 1)
    {
      V2TXLivePusherImpl.access$400(this.this$0, "startPusher，now is pushing so stop current push", false);
      V2TXLivePusherImpl.access$000(this.this$0).stopPush();
    }
    V2TXLivePusherImpl.access$000(this.this$0).startPush(this.val$url);
    V2TXLivePusherImpl.access$102(this.this$0, this.val$url);
    V2TXLivePusherImpl.access$302(this.this$0, a.b.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.live2.impl.V2TXLivePusherImpl.15
 * JD-Core Version:    0.7.0.1
 */