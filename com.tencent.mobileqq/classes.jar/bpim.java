import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import dov.com.qq.im.aeeditor.module.music.AEEditorLyricPanelDialog.3.1;

public class bpim
  implements Animation.AnimationListener
{
  bpim(bpij parambpij) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    bpij.a(this.a, false);
    bpij.a(this.a).post(new AEEditorLyricPanelDialog.3.1(this));
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    bpij.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpim
 * JD-Core Version:    0.7.0.1
 */