import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.biz.qqstory.support.logging.SLog;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.TextLayer;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.TextLayer.TextItem;

public class anhe
  extends AnimatorListenerAdapter
{
  public anhe(TextLayer.TextItem paramTextItem) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    SLog.b(TextLayer.a, "scaleAnimator cancel!");
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    SLog.b(TextLayer.a, "scaleAnimator end!");
    this.a.w = 1.0F;
    this.a.i = false;
    this.a.a.k();
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    SLog.b(TextLayer.a, "scaleAnimator start!");
    this.a.i = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anhe
 * JD-Core Version:    0.7.0.1
 */