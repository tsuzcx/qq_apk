import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.tencent.mobileqq.filemanager.activity.fileassistant.FileAssistantActivity;

public class aoaz
  implements ValueAnimator.AnimatorUpdateListener
{
  public aoaz(FileAssistantActivity paramFileAssistantActivity) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    FileAssistantActivity.a(this.a).getLayoutParams().height = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    FileAssistantActivity.a(this.a).requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aoaz
 * JD-Core Version:    0.7.0.1
 */