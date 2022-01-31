package com.tencent.av.widget.stageview;

import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import bcqi;
import mvo;
import mvp;

public class StageEffectView$5$1
  implements Runnable
{
  public StageEffectView$5$1(mvo parammvo) {}
  
  public void run()
  {
    bcqi localbcqi = new bcqi(-90.0F, 0.0F, this.a.jdField_a_of_type_Float, this.a.b, 200.0F, false);
    localbcqi.setDuration(500L);
    localbcqi.setInterpolator(new DecelerateInterpolator());
    this.a.jdField_a_of_type_AndroidWidgetImageView.startAnimation(localbcqi);
    localbcqi.setAnimationListener(new mvp(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.widget.stageview.StageEffectView.5.1
 * JD-Core Version:    0.7.0.1
 */