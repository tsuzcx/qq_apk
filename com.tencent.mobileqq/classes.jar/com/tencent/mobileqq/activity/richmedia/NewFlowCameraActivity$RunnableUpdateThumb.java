package com.tencent.mobileqq.activity.richmedia;

import agej;
import alwa;
import alwb;
import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import bdep;
import yuk;

public class NewFlowCameraActivity$RunnableUpdateThumb
  implements Runnable
{
  Bitmap a;
  public Bitmap b;
  
  public NewFlowCameraActivity$RunnableUpdateThumb(NewFlowCameraActivity paramNewFlowCameraActivity, @NonNull Bitmap paramBitmap1, @NonNull Bitmap paramBitmap2)
  {
    this.a = paramBitmap1;
    this.b = paramBitmap2;
  }
  
  private void a()
  {
    if ((NewFlowCameraActivity.a(this.this$0) == null) || (NewFlowCameraActivity.b(this.this$0) == null) || (NewFlowCameraActivity.a(this.this$0) == null))
    {
      yuk.e("PTV.NewFlowCameraActivity", "RunnableUpdateThumb error. mFragmentAnimThumbView == null or mFragmentThumbView == null or mFragmentNumView == null.");
      return;
    }
    NewFlowCameraActivity.a(this.this$0).setImageBitmap(this.a);
    NewFlowCameraActivity.a(this.this$0).setVisibility(0);
    NewFlowCameraActivity.b(this.this$0).setVisibility(8);
    int i = bdep.a;
    int j = bdep.a(this.this$0.getApplicationContext());
    int k = agej.a(47.0F, this.this$0.getResources());
    int m = agej.a(75.0F, this.this$0.getResources());
    int n = agej.a(12.0F, this.this$0.getResources());
    int i1 = agej.a(20.0F, this.this$0.getResources());
    yuk.c("PTV.NewFlowCameraActivity", "startScaleAnim. sWidth:" + i + " sHeight:" + j + " dWidth:" + k + " dHeight:" + m + " sMarginLeft:" + 0 + " sMarginBottom:" + 0 + " dMarginLeft:" + n + " dMarginBottom:" + i1);
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    localValueAnimator.setDuration(300L);
    localValueAnimator.setInterpolator(new LinearInterpolator());
    localValueAnimator.addUpdateListener(new alwa(this, k, i, m, j, n, i1));
    localValueAnimator.addListener(new alwb(this));
    localValueAnimator.start();
  }
  
  public void run()
  {
    if (!this.this$0.j)
    {
      yuk.e("PTV.NewFlowCameraActivity", "RunnableUpdateThumb error. enableMultiFragment = %s.", new Object[] { Boolean.valueOf(this.this$0.j) });
      return;
    }
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity.RunnableUpdateThumb
 * JD-Core Version:    0.7.0.1
 */