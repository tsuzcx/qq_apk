package com.tencent.av.widget.shimmer;

class ShimmerTextView$onDrawRunnable
  implements Runnable
{
  ShimmerTextView$onDrawRunnable(ShimmerTextView paramShimmerTextView) {}
  
  public void run()
  {
    ShimmerTextView localShimmerTextView = this.this$0;
    localShimmerTextView.a += 1;
    if (this.this$0.a >= 50) {
      this.this$0.a = 0;
    }
    this.this$0.setGradientX(this.this$0.getWidth() * this.this$0.a / 50);
    this.this$0.postInvalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.widget.shimmer.ShimmerTextView.onDrawRunnable
 * JD-Core Version:    0.7.0.1
 */