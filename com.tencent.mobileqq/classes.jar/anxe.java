import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.BlurMaskFilter;
import android.graphics.BlurMaskFilter.Blur;
import android.graphics.Paint;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.FaceLayer;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.FaceLayer.FaceItem;

public class anxe
  implements ValueAnimator.AnimatorUpdateListener
{
  public anxe(FaceLayer.FaceItem paramFaceItem) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.a.p = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    this.a.b.g.setMaskFilter(new BlurMaskFilter(this.a.p, BlurMaskFilter.Blur.OUTER));
    this.a.b.k();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anxe
 * JD-Core Version:    0.7.0.1
 */