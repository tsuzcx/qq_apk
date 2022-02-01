package com.tencent.hippy.qq.view.tkd.doublescrollview;

public class FlingController$MyVelocity
{
  private int length = 5;
  private int max;
  private FixLengthQueue times = new FixLengthQueue(this.length);
  private FixLengthQueue ys = new FixLengthQueue(this.length);
  
  public int getVelocity()
  {
    long l1 = this.times.getFirst() - this.times.getEnd();
    long l2 = this.ys.getFirst();
    long l3 = this.ys.getEnd();
    if (l1 == 0L) {
      return 0;
    }
    double d = (l2 - l3) * 1000L / l1;
    Double.isNaN(d);
    return (int)(d * 1.2D);
  }
  
  public void refreash()
  {
    this.ys.refreash();
    this.times.refreash();
  }
  
  public void setY(int paramInt)
  {
    this.ys.add(paramInt);
    this.times.add(System.currentTimeMillis());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.view.tkd.doublescrollview.FlingController.MyVelocity
 * JD-Core Version:    0.7.0.1
 */