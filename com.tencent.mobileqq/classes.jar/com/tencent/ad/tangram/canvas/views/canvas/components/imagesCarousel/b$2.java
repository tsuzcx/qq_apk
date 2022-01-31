package com.tencent.ad.tangram.canvas.views.canvas.components.imagesCarousel;

import android.support.v4.view.ViewPager;
import android.widget.FrameLayout.LayoutParams;

class b$2
  implements Runnable
{
  b$2(b paramb) {}
  
  public void run()
  {
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)b.access$900(this.this$0).getLayoutParams();
    localLayoutParams.width = b.access$600(this.this$0).width;
    localLayoutParams.height = b.access$600(this.this$0).height;
    b.access$900(this.this$0).setLayoutParams(localLayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ad.tangram.canvas.views.canvas.components.imagesCarousel.b.2
 * JD-Core Version:    0.7.0.1
 */