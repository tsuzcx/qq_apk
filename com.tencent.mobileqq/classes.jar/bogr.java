import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import dov.com.qq.im.aeeditor.module.music.AEEditorLyricPanelDialog.3.1;

public class bogr
  implements Animation.AnimationListener
{
  bogr(bogo parambogo) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    bogo.a(this.a, false);
    bogo.a(this.a).post(new AEEditorLyricPanelDialog.3.1(this));
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    bogo.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bogr
 * JD-Core Version:    0.7.0.1
 */