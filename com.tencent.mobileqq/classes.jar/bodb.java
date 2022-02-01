import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import dov.com.qq.im.aeeditor.module.toolbar.VideoEditToolBar;

public class bodb
  implements Animation.AnimationListener
{
  public bodb(VideoEditToolBar paramVideoEditToolBar) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.setVisibility(8);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bodb
 * JD-Core Version:    0.7.0.1
 */