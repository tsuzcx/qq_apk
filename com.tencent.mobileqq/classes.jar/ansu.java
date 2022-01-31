import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.ViewGroup;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoButton;

public class ansu
  extends AnimatorListenerAdapter
{
  public ansu(EditVideoButton paramEditVideoButton) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    EditVideoButton.b(this.a).setVisibility(8);
    EditVideoButton.c(this.a).setVisibility(8);
    EditVideoButton.d(this.a).setVisibility(8);
    EditVideoButton.a(this.a, EditVideoButton.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     ansu
 * JD-Core Version:    0.7.0.1
 */