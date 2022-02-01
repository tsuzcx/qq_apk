package com.tencent.biz.qqcircle.manager;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.PointF;
import android.os.Build.VERSION;
import android.view.animation.PathInterpolator;
import android.widget.ImageView;
import com.tencent.biz.qqcircle.utils.ViewUtils;

class QCircleFuelAnimationManager$1
  implements Runnable
{
  QCircleFuelAnimationManager$1(QCircleFuelAnimationManager paramQCircleFuelAnimationManager, ImageView paramImageView1, ImageView paramImageView2, boolean paramBoolean) {}
  
  public void run()
  {
    this.a.setVisibility(8);
    this.a.setImageDrawable(null);
    this.b.setVisibility(0);
    Object localObject2 = new PointF(this.b.getX(), this.b.getY() - ViewUtils.a(5.0F));
    if (this.c) {
      localObject1 = new PointF(this.b.getX() + ViewUtils.a(80.0F), this.b.getY() - ViewUtils.a(95.0F));
    } else {
      localObject1 = new PointF(this.b.getX() + ViewUtils.a(145.0F), this.b.getY() - ViewUtils.a(95.0F));
    }
    Object localObject1 = QCircleFuelAnimationManager.a(this.this$0, this.b, (PointF)localObject2, (PointF)localObject1, new PointF((((PointF)localObject1).x - ((PointF)localObject2).x) * 0.19F + ((PointF)localObject2).x, (((PointF)localObject1).y - ((PointF)localObject2).y) * 1.14F + ((PointF)localObject2).y), new PointF((((PointF)localObject1).x - ((PointF)localObject2).x) * 0.91F + ((PointF)localObject2).x, (((PointF)localObject1).y - ((PointF)localObject2).y) * 1.16F + ((PointF)localObject2).y), 420L);
    if (Build.VERSION.SDK_INT >= 21) {
      ((ValueAnimator)localObject1).setInterpolator(new PathInterpolator(0.16F, 0.0F, 0.0F, 1.0F));
    }
    ((ValueAnimator)localObject1).start();
    ((ValueAnimator)localObject1).addListener(new QCircleFuelAnimationManager.1.1(this, (PointF)localObject2));
    localObject1 = ObjectAnimator.ofFloat(this.b, "scaleX", new float[] { 1.0F, 0.0F }).setDuration(420L);
    if (Build.VERSION.SDK_INT >= 21) {
      ((ObjectAnimator)localObject1).setInterpolator(new PathInterpolator(0.33F, 0.0F, 0.67F, 1.0F));
    }
    localObject2 = ObjectAnimator.ofFloat(this.b, "scaleY", new float[] { 1.0F, 0.0F }).setDuration(420L);
    if (Build.VERSION.SDK_INT >= 21) {
      ((ObjectAnimator)localObject2).setInterpolator(new PathInterpolator(0.33F, 0.0F, 0.67F, 1.0F));
    }
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.b, "alpha", new float[] { 1.0F, 0.0F }).setDuration(420L);
    if (Build.VERSION.SDK_INT >= 21) {
      localObjectAnimator.setInterpolator(new PathInterpolator(0.33F, 0.0F, 0.67F, 1.0F));
    }
    ((ObjectAnimator)localObject1).start();
    ((ObjectAnimator)localObject2).start();
    localObjectAnimator.start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.manager.QCircleFuelAnimationManager.1
 * JD-Core Version:    0.7.0.1
 */