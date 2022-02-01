import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import dov.com.qq.im.aeeditor.module.music.AEEditorMusicPanelDialog.3.1;

public class bmlz
  implements Animation.AnimationListener
{
  bmlz(bmlw parambmlw) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    bmlw.b(this.a, false);
    bmlw.a(this.a).post(new AEEditorMusicPanelDialog.3.1(this));
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    bmlw.b(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmlz
 * JD-Core Version:    0.7.0.1
 */