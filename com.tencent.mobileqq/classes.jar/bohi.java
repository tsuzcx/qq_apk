import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import dov.com.qq.im.aeeditor.module.music.AEEditorMusicPanelDialog.3.1;

public class bohi
  implements Animation.AnimationListener
{
  bohi(bohf parambohf) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    bohf.b(this.a, false);
    bohf.a(this.a).post(new AEEditorMusicPanelDialog.3.1(this));
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    bohf.b(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bohi
 * JD-Core Version:    0.7.0.1
 */