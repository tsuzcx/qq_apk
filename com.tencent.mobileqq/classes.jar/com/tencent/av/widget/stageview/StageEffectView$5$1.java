package com.tencent.av.widget.stageview;

import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import beqg;
import mye;
import myf;

public class StageEffectView$5$1
  implements Runnable
{
  public StageEffectView$5$1(mye parammye) {}
  
  public void run()
  {
    beqg localbeqg = new beqg(-90.0F, 0.0F, this.a.jdField_a_of_type_Float, this.a.b, 200.0F, false);
    localbeqg.setDuration(500L);
    localbeqg.setInterpolator(new DecelerateInterpolator());
    this.a.jdField_a_of_type_AndroidWidgetImageView.startAnimation(localbeqg);
    localbeqg.setAnimationListener(new myf(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.widget.stageview.StageEffectView.5.1
 * JD-Core Version:    0.7.0.1
 */