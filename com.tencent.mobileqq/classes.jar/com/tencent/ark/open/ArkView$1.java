package com.tencent.ark.open;

import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.ark.Logger;

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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onGlobalLayout width=");
    ((StringBuilder)localObject).append(i);
    ((StringBuilder)localObject).append(", height=");
    ((StringBuilder)localObject).append(j);
    Logger.logI("ArkApp.ArkView", ((StringBuilder)localObject).toString());
    ArkView.access$102(this.this$0, true);
    if (ArkView.access$200(this.this$0) != null)
    {
      localObject = this.this$0;
      ArkView.access$300((ArkView)localObject, ArkView.access$200((ArkView)localObject));
      ArkView.access$202(this.this$0, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ark.open.ArkView.1
 * JD-Core Version:    0.7.0.1
 */