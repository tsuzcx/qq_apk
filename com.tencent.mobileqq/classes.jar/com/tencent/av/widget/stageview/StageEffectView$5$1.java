package com.tencent.av.widget.stageview;

import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import bcqx;
import mvl;
import mvm;

public class StageEffectView$5$1
  implements Runnable
{
  public StageEffectView$5$1(mvl parammvl) {}
  
  public void run()
  {
    bcqx localbcqx = new bcqx(-90.0F, 0.0F, this.a.jdField_a_of_type_Float, this.a.b, 200.0F, false);
    localbcqx.setDuration(500L);
    localbcqx.setInterpolator(new DecelerateInterpolator());
    this.a.jdField_a_of_type_AndroidWidgetImageView.startAnimation(localbcqx);
    localbcqx.setAnimationListener(new mvm(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.widget.stageview.StageEffectView.5.1
 * JD-Core Version:    0.7.0.1
 */