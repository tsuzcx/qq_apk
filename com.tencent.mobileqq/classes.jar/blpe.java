import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.TextView;

class blpe
  implements Animation.AnimationListener
{
  blpe(blpb paramblpb) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    blpb.b(this.a).setVisibility(8);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blpe
 * JD-Core Version:    0.7.0.1
 */