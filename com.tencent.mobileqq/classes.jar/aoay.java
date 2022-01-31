import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.filemanager.activity.fileassistant.FileAssistantActivity;

public class aoay
  implements View.OnTouchListener
{
  public aoay(FileAssistantActivity paramFileAssistantActivity) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 4)
    {
      this.a.a.dismiss();
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aoay
 * JD-Core Version:    0.7.0.1
 */