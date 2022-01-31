import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.ViewStub;
import com.tencent.mobileqq.filemanager.activity.fileassistant.FileAssistantActivity;

public class aqks
  implements ValueAnimator.AnimatorUpdateListener
{
  public aqks(FileAssistantActivity paramFileAssistantActivity) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    FileAssistantActivity.a(this.a).getLayoutParams().height = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    FileAssistantActivity.a(this.a).requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqks
 * JD-Core Version:    0.7.0.1
 */