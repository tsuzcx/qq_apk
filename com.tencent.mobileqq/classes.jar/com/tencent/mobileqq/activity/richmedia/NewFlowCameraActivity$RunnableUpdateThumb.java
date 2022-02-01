package com.tencent.mobileqq.activity.richmedia;

import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;

class NewFlowCameraActivity$RunnableUpdateThumb
  implements Runnable
{
  Bitmap a;
  Bitmap b;
  
  public NewFlowCameraActivity$RunnableUpdateThumb(NewFlowCameraActivity paramNewFlowCameraActivity, @NonNull Bitmap paramBitmap1, @NonNull Bitmap paramBitmap2)
  {
    this.a = paramBitmap1;
    this.b = paramBitmap2;
  }
  
  private void a()
  {
    if ((NewFlowCameraActivity.a(this.this$0) == null) || (NewFlowCameraActivity.b(this.this$0) == null) || (NewFlowCameraActivity.a(this.this$0) == null))
    {
      SLog.e("PTV.NewFlowCameraActivity", "RunnableUpdateThumb error. mFragmentAnimThumbView == null or mFragmentThumbView == null or mFragmentNumView == null.");
      return;
    }
    NewFlowCameraActivity.a(this.this$0).setImageBitmap(this.a);
    NewFlowCameraActivity.a(this.this$0).setVisibility(0);
    NewFlowCameraActivity.b(this.this$0).setVisibility(8);
    int i = ScreenUtil.SCREEN_WIDTH;
    int j = ScreenUtil.getInstantScreenHeight(this.this$0.getApplicationContext());
    int k = AIOUtils.a(47.0F, this.this$0.getResources());
    int m = AIOUtils.a(75.0F, this.this$0.getResources());
    int n = AIOUtils.a(12.0F, this.this$0.getResources());
    int i1 = AIOUtils.a(20.0F, this.this$0.getResources());
    SLog.c("PTV.NewFlowCameraActivity", "startScaleAnim. sWidth:" + i + " sHeight:" + j + " dWidth:" + k + " dHeight:" + m + " sMarginLeft:" + 0 + " sMarginBottom:" + 0 + " dMarginLeft:" + n + " dMarginBottom:" + i1);
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    localValueAnimator.setDuration(300L);
    localValueAnimator.setInterpolator(new LinearInterpolator());
    localValueAnimator.addUpdateListener(new NewFlowCameraActivity.RunnableUpdateThumb.1(this, k, i, m, j, n, i1));
    localValueAnimator.addListener(new NewFlowCameraActivity.RunnableUpdateThumb.2(this));
    localValueAnimator.start();
  }
  
  public void run()
  {
    if (!this.this$0.j)
    {
      SLog.e("PTV.NewFlowCameraActivity", "RunnableUpdateThumb error. enableMultiFragment = %s.", new Object[] { Boolean.valueOf(this.this$0.j) });
      return;
    }
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity.RunnableUpdateThumb
 * JD-Core Version:    0.7.0.1
 */