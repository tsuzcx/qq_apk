import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.ViewStub;
import com.tencent.mobileqq.filemanager.activity.fileassistant.FileAssistantActivity;

public class aqpc
  extends AnimatorListenerAdapter
{
  public aqpc(FileAssistantActivity paramFileAssistantActivity) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    FileAssistantActivity.a(this.a).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqpc
 * JD-Core Version:    0.7.0.1
 */