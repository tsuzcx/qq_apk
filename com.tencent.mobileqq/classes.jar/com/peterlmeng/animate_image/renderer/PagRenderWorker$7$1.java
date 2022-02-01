package com.peterlmeng.animate_image.renderer;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.os.Handler;

class PagRenderWorker$7$1
  implements ValueAnimator.AnimatorUpdateListener
{
  PagRenderWorker$7$1(PagRenderWorker.7 param7) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if ((this.this$1.this$0.handler != null) && (PagRenderWorker.access$100(this.this$1.this$0) == 1))
    {
      paramValueAnimator = this.this$1.this$0.handler.obtainMessage();
      paramValueAnimator.what = 0;
      paramValueAnimator.obj = this.this$1.this$0;
      paramValueAnimator.arg1 = ((int)(((Float)PagRenderWorker.access$000(this.this$1.this$0).getAnimatedValue()).floatValue() * 1.0E+008F));
      this.this$1.this$0.handler.sendMessage(paramValueAnimator);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.peterlmeng.animate_image.renderer.PagRenderWorker.7.1
 * JD-Core Version:    0.7.0.1
 */