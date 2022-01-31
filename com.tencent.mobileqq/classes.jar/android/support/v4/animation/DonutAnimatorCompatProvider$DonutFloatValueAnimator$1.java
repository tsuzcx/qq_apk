package android.support.v4.animation;

import android.view.View;

class DonutAnimatorCompatProvider$DonutFloatValueAnimator$1
  implements Runnable
{
  DonutAnimatorCompatProvider$DonutFloatValueAnimator$1(DonutAnimatorCompatProvider.DonutFloatValueAnimator paramDonutFloatValueAnimator) {}
  
  public void run()
  {
    float f = (float)(DonutAnimatorCompatProvider.DonutFloatValueAnimator.access$000(this.this$0) - DonutAnimatorCompatProvider.DonutFloatValueAnimator.access$100(this.this$0)) * 1.0F / (float)DonutAnimatorCompatProvider.DonutFloatValueAnimator.access$200(this.this$0);
    if ((f > 1.0F) || (this.this$0.mTarget.getParent() == null)) {
      f = 1.0F;
    }
    DonutAnimatorCompatProvider.DonutFloatValueAnimator.access$302(this.this$0, f);
    DonutAnimatorCompatProvider.DonutFloatValueAnimator.access$400(this.this$0);
    if (DonutAnimatorCompatProvider.DonutFloatValueAnimator.access$300(this.this$0) >= 1.0F)
    {
      DonutAnimatorCompatProvider.DonutFloatValueAnimator.access$500(this.this$0);
      return;
    }
    this.this$0.mTarget.postDelayed(DonutAnimatorCompatProvider.DonutFloatValueAnimator.access$600(this.this$0), 16L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.v4.animation.DonutAnimatorCompatProvider.DonutFloatValueAnimator.1
 * JD-Core Version:    0.7.0.1
 */