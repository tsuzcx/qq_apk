package com.tencent.biz.subscribe.widget.relativevideo;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.tencent.widget.immersive.ImmersiveUtils;

class RelativePersonalBottomView$4
  implements Runnable
{
  RelativePersonalBottomView$4(RelativePersonalBottomView paramRelativePersonalBottomView, View paramView) {}
  
  public void run()
  {
    if (this.a != null)
    {
      ViewGroup.LayoutParams localLayoutParams = this.this$0.getLayoutParams();
      localLayoutParams.height = (ImmersiveUtils.b() - this.a.getHeight());
      this.this$0.setLayoutParams(localLayoutParams);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.relativevideo.RelativePersonalBottomView.4
 * JD-Core Version:    0.7.0.1
 */