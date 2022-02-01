package com.tencent.live2.jsplugin.pusher;

class V2TXLivePusherJSAdapter$1
  implements Runnable
{
  V2TXLivePusherJSAdapter$1(V2TXLivePusherJSAdapter paramV2TXLivePusherJSAdapter, int paramInt) {}
  
  public void run()
  {
    if (V2TXLivePusherJSAdapter.access$000(this.this$0) != this.val$angle)
    {
      V2TXLivePusherJSAdapter localV2TXLivePusherJSAdapter = this.this$0;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("notify orientation changed. [angle:");
      localStringBuilder.append(this.val$angle);
      localStringBuilder.append("]");
      V2TXLivePusherJSAdapter.access$100(localV2TXLivePusherJSAdapter, localStringBuilder.toString(), true);
      V2TXLivePusherJSAdapter.access$002(this.this$0, this.val$angle);
      localV2TXLivePusherJSAdapter = this.this$0;
      V2TXLivePusherJSAdapter.access$300(localV2TXLivePusherJSAdapter, V2TXLivePusherJSAdapter.access$200(localV2TXLivePusherJSAdapter));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.live2.jsplugin.pusher.V2TXLivePusherJSAdapter.1
 * JD-Core Version:    0.7.0.1
 */