package com.tencent.av.widget.stageview;

import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import bibn;
import mvm;
import mvn;

public class StageEffectView$5$1
  implements Runnable
{
  public StageEffectView$5$1(mvm parammvm) {}
  
  public void run()
  {
    bibn localbibn = new bibn(-90.0F, 0.0F, this.a.jdField_a_of_type_Float, this.a.b, 200.0F, false);
    localbibn.setDuration(500L);
    localbibn.setInterpolator(new DecelerateInterpolator());
    this.a.jdField_a_of_type_AndroidWidgetImageView.startAnimation(localbibn);
    localbibn.setAnimationListener(new mvn(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.widget.stageview.StageEffectView.5.1
 * JD-Core Version:    0.7.0.1
 */