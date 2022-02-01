package com.tencent.av.widget.stageview;

import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import bjcl;
import mwl;
import mwm;

public class StageEffectView$5$1
  implements Runnable
{
  public StageEffectView$5$1(mwl parammwl) {}
  
  public void run()
  {
    bjcl localbjcl = new bjcl(-90.0F, 0.0F, this.a.jdField_a_of_type_Float, this.a.b, 200.0F, false);
    localbjcl.setDuration(500L);
    localbjcl.setInterpolator(new DecelerateInterpolator());
    this.a.jdField_a_of_type_AndroidWidgetImageView.startAnimation(localbjcl);
    localbjcl.setAnimationListener(new mwm(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.widget.stageview.StageEffectView.5.1
 * JD-Core Version:    0.7.0.1
 */