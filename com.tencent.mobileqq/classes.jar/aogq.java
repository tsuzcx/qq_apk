import android.view.View;
import android.view.View.OnSystemUiVisibilityChangeListener;
import android.view.Window;
import com.tencent.biz.qqstory.support.logging.SLog;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.EditTextDialog;

public class aogq
  implements View.OnSystemUiVisibilityChangeListener
{
  public aogq(EditTextDialog paramEditTextDialog) {}
  
  public void onSystemUiVisibilityChange(int paramInt)
  {
    if ((paramInt & 0x4) == 0)
    {
      SLog.b("EditTextDialog", "onStatusBarShow");
      this.a.getWindow().getDecorView().removeCallbacks(EditTextDialog.a(this.a));
      this.a.getWindow().getDecorView().postDelayed(EditTextDialog.a(this.a), 1500L);
      return;
    }
    SLog.b("EditTextDialog", "onStatusBarHide");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aogq
 * JD-Core Version:    0.7.0.1
 */