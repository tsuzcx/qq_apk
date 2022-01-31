import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import dov.com.qq.im.aeeditor.module.music.AEEditorMusicPanelDialog.1.1;

public class bloq
  implements Animation.AnimationListener
{
  bloq(blop paramblop) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    blop.a(this.a, false);
    blop.a(this.a).post(new AEEditorMusicPanelDialog.1.1(this));
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    blop.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bloq
 * JD-Core Version:    0.7.0.1
 */