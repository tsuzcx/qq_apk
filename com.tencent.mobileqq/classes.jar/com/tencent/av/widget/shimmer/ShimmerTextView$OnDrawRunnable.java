package com.tencent.av.widget.shimmer;

class ShimmerTextView$OnDrawRunnable
  implements Runnable
{
  ShimmerTextView$OnDrawRunnable(ShimmerTextView paramShimmerTextView) {}
  
  public void run()
  {
    ShimmerTextView localShimmerTextView = this.this$0;
    localShimmerTextView.a += 1;
    if (this.this$0.a >= 50) {
      this.this$0.a = 0;
    }
    localShimmerTextView = this.this$0;
    localShimmerTextView.setGradientX(localShimmerTextView.getWidth() * this.this$0.a / 50);
    this.this$0.postInvalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.widget.shimmer.ShimmerTextView.OnDrawRunnable
 * JD-Core Version:    0.7.0.1
 */