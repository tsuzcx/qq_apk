import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.ViewGroup;
import android.widget.TextView;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoButton;

public class anco
  extends AnimatorListenerAdapter
{
  public anco(EditVideoButton paramEditVideoButton) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    EditVideoButton.a(this.a).setVisibility(8);
    EditVideoButton.a(this.a).setVisibility(8);
    EditVideoButton.a(this.a, EditVideoButton.b(this.a));
    if (this.a.a != null) {
      this.a.a(2131363390);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anco
 * JD-Core Version:    0.7.0.1
 */