import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.tencent.biz.qqstory.support.logging.SLog;
import dov.com.qq.im.capture.text.DynamicTextItem;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.EditTextDialog;

public class aogm
  implements View.OnFocusChangeListener
{
  public aogm(EditTextDialog paramEditTextDialog) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if ((paramBoolean) && (this.a.a != null)) {
      this.a.a.a(this.a.a.b(), true);
    }
    SLog.b("EditTextDialog", "onFocusChange:" + paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aogm
 * JD-Core Version:    0.7.0.1
 */