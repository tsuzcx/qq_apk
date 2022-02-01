package com.tencent.mobileqq.app;

import amvb;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.ApngImage;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.os.MqqHandler;

public final class LebaUtil$2
  implements Runnable
{
  public LebaUtil$2(AtomicBoolean paramAtomicBoolean, ImageView paramImageView1, ImageView paramImageView2, Animation paramAnimation1, Animation paramAnimation2, Animation paramAnimation3, Animation paramAnimation4, boolean paramBoolean, TextView paramTextView1, TextView paramTextView2, TextView paramTextView3, long paramLong1, long paramLong2, MqqHandler paramMqqHandler) {}
  
  public void run()
  {
    boolean bool = false;
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetImageView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimation);
      this.jdField_a_of_type_AndroidWidgetImageView.startAnimation(this.jdField_b_of_type_AndroidViewAnimationAnimation);
      if (this.jdField_a_of_type_Boolean) {
        amvb.a(this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_b_of_type_AndroidWidgetTextView, this.jdField_c_of_type_AndroidWidgetTextView, this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean);
      }
      AtomicBoolean localAtomicBoolean = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean;
      if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
        bool = true;
      }
      localAtomicBoolean.set(bool);
      if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
        break label156;
      }
    }
    label156:
    for (long l = this.jdField_a_of_type_Long;; l = this.jdField_b_of_type_Long)
    {
      this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(this, l);
      return;
      ApngImage.pauseByTag(39);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetImageView.startAnimation(this.jdField_c_of_type_AndroidViewAnimationAnimation);
      this.jdField_a_of_type_AndroidWidgetImageView.startAnimation(this.d);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.LebaUtil.2
 * JD-Core Version:    0.7.0.1
 */