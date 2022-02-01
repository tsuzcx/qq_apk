package com.tencent.ad.tangram.views.canvas.framework;

import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.ad.tangram.views.canvas.components.keyElements.a;

class AdCanvasView$3
  implements Runnable
{
  AdCanvasView$3(AdCanvasView paramAdCanvasView, String paramString1, String paramString2, String paramString3, String paramString4) {}
  
  public void run()
  {
    AdCanvasView.access$000(this.this$0).setVisibility(0);
    AdCanvasView.access$000(this.this$0).setOnClickListener(new AdCanvasView.3.1(this));
    a locala = new a(this.this$0.getContext());
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("应用名称:");
    ((StringBuilder)localObject1).append(this.val$name);
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("应用版本:");
    ((StringBuilder)localObject2).append(this.val$versionName);
    localObject2 = ((StringBuilder)localObject2).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("开发者:");
    localStringBuilder.append(this.val$authorName);
    locala.setTextContent((String)localObject1, (String)localObject2, localStringBuilder.toString());
    localObject1 = new RelativeLayout.LayoutParams(-1, -1);
    ((RelativeLayout.LayoutParams)localObject1).addRule(13, -1);
    AdCanvasView.access$000(this.this$0).addView(locala, (ViewGroup.LayoutParams)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.views.canvas.framework.AdCanvasView.3
 * JD-Core Version:    0.7.0.1
 */