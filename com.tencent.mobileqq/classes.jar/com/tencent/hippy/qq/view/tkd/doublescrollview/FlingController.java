package com.tencent.hippy.qq.view.tkd.doublescrollview;

import android.os.Handler;
import android.util.Log;
import com.tencent.widget.immersive.ImmersiveUtils;

public class FlingController
{
  private static final int MSG_FLING = 95;
  private static final String TAG = "FlingController";
  private static final int absA = 300;
  private int a;
  private IDoubleScroll flingListener;
  private int fps = 50;
  private Handler handler = new FlingController.1(this);
  public boolean isFling = false;
  private int mVelocity;
  private FlingController.MyVelocity myVelocity = new FlingController.MyVelocity();
  
  private void finish()
  {
    this.mVelocity = 0;
    refreash();
    this.isFling = false;
  }
  
  private void refreash()
  {
    this.myVelocity.refreash();
  }
  
  public int computeDistance()
  {
    int j = this.mVelocity;
    int i = j - this.a;
    j = ImmersiveUtils.PxToDp(j + i >> 1);
    this.mVelocity = i;
    if ((Math.abs(-j) < 5) || (Math.abs(this.mVelocity) < 10)) {
      finish();
    }
    return j;
  }
  
  public void setFlingListener(IDoubleScroll paramIDoubleScroll)
  {
    this.flingListener = paramIDoubleScroll;
  }
  
  public void setY(int paramInt)
  {
    this.myVelocity.setY(paramInt);
  }
  
  public void startFling()
  {
    int i = this.myVelocity.getVelocity();
    int j = this.fps;
    this.mVelocity = (i / j * 3);
    if (this.mVelocity < 0) {
      this.a = (-300 / j);
    } else {
      this.a = (300 / j);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mVelocity: ");
    localStringBuilder.append(this.mVelocity);
    localStringBuilder.append("  a: ");
    localStringBuilder.append(this.a);
    Log.d("FlingController", localStringBuilder.toString());
    this.isFling = true;
  }
  
  public void stop()
  {
    finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hippy.qq.view.tkd.doublescrollview.FlingController
 * JD-Core Version:    0.7.0.1
 */