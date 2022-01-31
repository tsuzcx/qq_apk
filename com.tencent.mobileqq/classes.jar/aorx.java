import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.filemanager.activity.fileassistant.FileAssistantActivity;

public class aorx
  implements View.OnTouchListener
{
  public aorx(FileAssistantActivity paramFileAssistantActivity) {}
  
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
 * Qualified Name:     aorx
 * JD-Core Version:    0.7.0.1
 */