package com.tencent.ark.open;

import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.ark.ArkEnvironmentManager;

class ArkView$1
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  ArkView$1(ArkView paramArkView) {}
  
  public void onGlobalLayout()
  {
    int i = this.this$0.getWidth();
    int j = this.this$0.getHeight();
    if (i > 0) {
      ArkView.access$000(this.this$0).width = i;
    }
    if (j > 0) {
      ArkView.access$000(this.this$0).height = j;
    }
    ArkView.access$100().logI("ArkApp.ArkView", "onGlobalLayout width=" + i + ", height=" + j);
    ArkView.access$202(this.this$0, true);
    if (ArkView.access$300(this.this$0) != null)
    {
      ArkView.access$400(this.this$0, ArkView.access$300(this.this$0));
      ArkView.access$302(this.this$0, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ark.open.ArkView.1
 * JD-Core Version:    0.7.0.1
 */