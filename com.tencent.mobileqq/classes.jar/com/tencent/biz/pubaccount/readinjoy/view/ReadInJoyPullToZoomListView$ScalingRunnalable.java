package com.tencent.biz.pubaccount.readinjoy.view;

import android.view.ViewGroup.LayoutParams;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import com.tencent.qphone.base.util.QLog;

class ReadInJoyPullToZoomListView$ScalingRunnalable
  implements Runnable
{
  float jdField_a_of_type_Float;
  long jdField_a_of_type_Long;
  boolean jdField_a_of_type_Boolean = true;
  long b;
  
  ReadInJoyPullToZoomListView$ScalingRunnalable(ReadInJoyPullToZoomListView paramReadInJoyPullToZoomListView) {}
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
    if ((QLog.isColorLevel()) && (ReadInJoyPullToZoomListView.a())) {
      QLog.e("Q.readinjoy.video.PullToZoomListView", 2, "#ScalingRunnalable# abortAnimation(): ");
    }
  }
  
  public void a(long paramLong)
  {
    this.b = AnimationUtils.currentAnimationTimeMillis();
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_Float = (ReadInJoyPullToZoomListView.a(this.this$0).getBottom() / ReadInJoyPullToZoomListView.a(this.this$0));
    this.jdField_a_of_type_Boolean = false;
    this.this$0.post(this);
    if ((QLog.isColorLevel()) && (ReadInJoyPullToZoomListView.a())) {
      QLog.d("Q.readinjoy.video.PullToZoomListView", 2, "#ScalingRunnalable# startAnimation(): duration =" + paramLong + ", mScale=" + this.jdField_a_of_type_Float);
    }
  }
  
  public void run()
  {
    ReadInJoyPullToZoomListView.a(this.this$0);
    float f1;
    float f2;
    if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Float > 1.0D))
    {
      f1 = ((float)AnimationUtils.currentAnimationTimeMillis() - (float)this.b) / (float)this.jdField_a_of_type_Long;
      f2 = this.jdField_a_of_type_Float - (this.jdField_a_of_type_Float - 1.0F) * ReadInJoyPullToZoomListView.a().getInterpolation(f1);
      ViewGroup.LayoutParams localLayoutParams = ReadInJoyPullToZoomListView.a(this.this$0).getLayoutParams();
      if (f2 <= 1.0F) {
        break label173;
      }
      localLayoutParams.height = ReadInJoyPullToZoomListView.a(this.this$0);
      localLayoutParams.height = ((int)(ReadInJoyPullToZoomListView.a(this.this$0) * f2));
      ReadInJoyPullToZoomListView.a(this.this$0).setLayoutParams(localLayoutParams);
      this.this$0.post(this);
      if ((QLog.isColorLevel()) && (ReadInJoyPullToZoomListView.a())) {
        QLog.d("Q.readinjoy.video.PullToZoomListView", 2, "#ScalingRunnalable# runing...... f1 = " + f1 + ", f2=" + f2);
      }
    }
    return;
    label173:
    if ((QLog.isColorLevel()) && (ReadInJoyPullToZoomListView.a())) {
      QLog.w("Q.readinjoy.video.PullToZoomListView", 2, "#ScalingRunnalable# run() end! f1 = " + f1 + ", f2=" + f2);
    }
    this.jdField_a_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyPullToZoomListView.ScalingRunnalable
 * JD-Core Version:    0.7.0.1
 */