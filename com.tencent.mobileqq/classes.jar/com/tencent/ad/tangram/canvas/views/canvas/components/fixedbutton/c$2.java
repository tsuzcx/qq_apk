package com.tencent.ad.tangram.canvas.views.canvas.components.fixedbutton;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.tencent.ad.tangram.util.AdUIUtils;

class c$2
  implements Runnable
{
  c$2(c paramc, Context paramContext) {}
  
  public void run()
  {
    ViewGroup.LayoutParams localLayoutParams = c.access$000(this.this$0).getLayoutParams();
    localLayoutParams.width = AdUIUtils.dp2px(56.0F, this.val$context.getResources());
    localLayoutParams.height = localLayoutParams.width;
    c.access$000(this.this$0).setLayoutParams(localLayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.canvas.views.canvas.components.fixedbutton.c.2
 * JD-Core Version:    0.7.0.1
 */