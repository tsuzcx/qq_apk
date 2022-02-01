import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import com.tencent.mobileqq.togetherui.writetogether.WriteTogetherEditorFragment;

public class bdkn
  implements View.OnTouchListener
{
  public bdkn(WriteTogetherEditorFragment paramWriteTogetherEditorFragment) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0) {
      WriteTogetherEditorFragment.a(this.a).setAlpha(0.5F);
    }
    for (;;)
    {
      return false;
      if (paramMotionEvent.getAction() == 1) {
        WriteTogetherEditorFragment.a(this.a).setAlpha(1.0F);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdkn
 * JD-Core Version:    0.7.0.1
 */