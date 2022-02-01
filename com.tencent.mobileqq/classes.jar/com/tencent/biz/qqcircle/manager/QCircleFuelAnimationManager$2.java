package com.tencent.biz.qqcircle.manager;

import android.animation.ObjectAnimator;
import android.os.Build.VERSION;
import android.view.View;
import android.view.animation.PathInterpolator;
import vqo;

public class QCircleFuelAnimationManager$2
  implements Runnable
{
  public QCircleFuelAnimationManager$2(vqo paramvqo, View paramView) {}
  
  public void run()
  {
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.a, "scaleX", new float[] { 1.0F, 1.2F, 1.0F }).setDuration(300L);
    if (Build.VERSION.SDK_INT >= 21) {
      localObjectAnimator.setInterpolator(new PathInterpolator(0.33F, 0.0F, 0.67F, 1.0F));
    }
    localObjectAnimator.start();
    localObjectAnimator = ObjectAnimator.ofFloat(this.a, "scaleY", new float[] { 1.0F, 1.2F, 1.0F }).setDuration(300L);
    if (Build.VERSION.SDK_INT >= 21) {
      localObjectAnimator.setInterpolator(new PathInterpolator(0.33F, 0.0F, 0.67F, 1.0F));
    }
    localObjectAnimator.start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.manager.QCircleFuelAnimationManager.2
 * JD-Core Version:    0.7.0.1
 */