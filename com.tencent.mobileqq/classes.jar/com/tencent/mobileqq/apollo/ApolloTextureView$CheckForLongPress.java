package com.tencent.mobileqq.apollo;

import alqx;
import android.text.TextUtils;

class ApolloTextureView$CheckForLongPress
  implements Runnable
{
  private int a;
  
  ApolloTextureView$CheckForLongPress(ApolloTextureView paramApolloTextureView) {}
  
  public void a()
  {
    this.a = ApolloTextureView.access$801(this.this$0);
  }
  
  public void run()
  {
    if (this.a == ApolloTextureView.access$201(this.this$0))
    {
      ApolloTextureView.access$302(this.this$0, true);
      ApolloTextureView.access$401(this.this$0, 2);
      if ((!TextUtils.isEmpty(ApolloTextureView.access$500(this.this$0))) && (ApolloTextureView.access$600(this.this$0) >= 0) && (ApolloTextureView.access$700(this.this$0) != null)) {
        ApolloTextureView.access$700(this.this$0).onNotifyLongTouch(ApolloTextureView.access$500(this.this$0));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloTextureView.CheckForLongPress
 * JD-Core Version:    0.7.0.1
 */