package com.tencent.ad.tangram.canvas.views.canvas.components.button;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class b$1
  implements View.OnClickListener
{
  b$1(b paramb, String paramString1, boolean paramBoolean, String paramString2, String paramString3) {}
  
  public void onClick(View paramView)
  {
    b.access$000(this.this$0, this.val$linkType, this.val$isFixed, this.val$actionUrl, this.val$formId);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.canvas.views.canvas.components.button.b.1
 * JD-Core Version:    0.7.0.1
 */