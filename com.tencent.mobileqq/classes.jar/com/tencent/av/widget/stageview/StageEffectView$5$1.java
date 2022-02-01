package com.tencent.av.widget.stageview;

import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import bite;
import mws;
import mwt;

public class StageEffectView$5$1
  implements Runnable
{
  public StageEffectView$5$1(mws parammws) {}
  
  public void run()
  {
    bite localbite = new bite(-90.0F, 0.0F, this.a.jdField_a_of_type_Float, this.a.b, 200.0F, false);
    localbite.setDuration(500L);
    localbite.setInterpolator(new DecelerateInterpolator());
    this.a.jdField_a_of_type_AndroidWidgetImageView.startAnimation(localbite);
    localbite.setAnimationListener(new mwt(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.widget.stageview.StageEffectView.5.1
 * JD-Core Version:    0.7.0.1
 */