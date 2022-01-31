import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.filemanager.activity.fileassistant.FileAssistantActivity;

public class aqkv
  implements View.OnTouchListener
{
  public aqkv(FileAssistantActivity paramFileAssistantActivity) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqkv
 * JD-Core Version:    0.7.0.1
 */