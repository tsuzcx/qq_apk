import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import com.tencent.mobileqq.filemanager.activity.fileassistant.FileAssistantActivity;

public class aoba
  extends AnimatorListenerAdapter
{
  public aoba(FileAssistantActivity paramFileAssistantActivity) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    FileAssistantActivity.a(this.a).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aoba
 * JD-Core Version:    0.7.0.1
 */