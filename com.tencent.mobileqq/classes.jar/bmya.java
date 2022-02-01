import android.view.animation.Animation;
import cooperation.qzone.contentbox.PlusMenuContainer;

public class bmya
  extends blgm
{
  public bmya(PlusMenuContainer paramPlusMenuContainer) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.setVisibility(4);
    PlusMenuContainer.a(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmya
 * JD-Core Version:    0.7.0.1
 */