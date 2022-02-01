package com.tencent.ad.tangram.canvas.views.canvas.components.picture;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.ad.tangram.canvas.views.canvas.framework.AdCanvasViewListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;

class b$a
  implements View.OnClickListener
{
  private String formId;
  private String linkType;
  private String url;
  
  b$a(b paramb, String paramString1, String paramString2, String paramString3)
  {
    this.linkType = paramString1;
    this.formId = paramString2;
    this.url = paramString3;
  }
  
  public void onClick(View paramView)
  {
    if ((b.access$000(this.this$0) != null) && (b.access$100(this.this$0).get() != null)) {
      ((AdCanvasViewListener)b.access$300(this.this$0).get()).hotAreaClick(this.linkType, b.access$200(this.this$0).id, this.url, this.formId);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.ad.tangram.canvas.views.canvas.components.picture.b.a
 * JD-Core Version:    0.7.0.1
 */