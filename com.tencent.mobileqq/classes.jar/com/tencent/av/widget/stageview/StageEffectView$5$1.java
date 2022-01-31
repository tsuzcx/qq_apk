package com.tencent.av.widget.stageview;

import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import bbnk;
import mkp;
import mkq;

public class StageEffectView$5$1
  implements Runnable
{
  public StageEffectView$5$1(mkp parammkp) {}
  
  public void run()
  {
    bbnk localbbnk = new bbnk(-90.0F, 0.0F, this.a.jdField_a_of_type_Float, this.a.b, 200.0F, false);
    localbbnk.setDuration(500L);
    localbbnk.setInterpolator(new DecelerateInterpolator());
    this.a.jdField_a_of_type_AndroidWidgetImageView.startAnimation(localbbnk);
    localbbnk.setAnimationListener(new mkq(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.widget.stageview.StageEffectView.5.1
 * JD-Core Version:    0.7.0.1
 */