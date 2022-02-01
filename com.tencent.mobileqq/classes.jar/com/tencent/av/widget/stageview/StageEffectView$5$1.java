package com.tencent.av.widget.stageview;

import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import bhim;
import mvu;
import mvv;

public class StageEffectView$5$1
  implements Runnable
{
  public StageEffectView$5$1(mvu parammvu) {}
  
  public void run()
  {
    bhim localbhim = new bhim(-90.0F, 0.0F, this.a.jdField_a_of_type_Float, this.a.b, 200.0F, false);
    localbhim.setDuration(500L);
    localbhim.setInterpolator(new DecelerateInterpolator());
    this.a.jdField_a_of_type_AndroidWidgetImageView.startAnimation(localbhim);
    localbhim.setAnimationListener(new mvv(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.widget.stageview.StageEffectView.5.1
 * JD-Core Version:    0.7.0.1
 */