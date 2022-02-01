import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import dov.com.qq.im.aeeditor.module.music.AEEditorMusicPanelDialog.3.1;

public class bpjd
  implements Animation.AnimationListener
{
  bpjd(bpja parambpja) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    bpja.b(this.a, false);
    bpja.a(this.a).post(new AEEditorMusicPanelDialog.3.1(this));
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    bpja.b(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpjd
 * JD-Core Version:    0.7.0.1
 */