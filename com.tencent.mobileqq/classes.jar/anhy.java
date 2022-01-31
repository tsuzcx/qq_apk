import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.EditTextDialog;
import mqq.os.MqqHandler;

public class anhy
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private anhy(EditTextDialog paramEditTextDialog) {}
  
  public void onGlobalLayout()
  {
    int i = this.a.jdField_a_of_type_AndroidViewView.getBottom();
    if (this.a.b < 0)
    {
      if (QLog.isColorLevel()) {
        QLog.i("EditTextDialog", 2, "onGlobalLayout first bottom:" + i);
      }
      this.a.b = i;
      this.a.jdField_a_of_type_MqqOsMqqHandler.post(new anhz(this));
    }
    while (this.a.b - i <= this.a.jdField_a_of_type_Int) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("EditTextDialog", 2, "onGlobalLayout second bottom:" + i);
    }
    this.a.jdField_a_of_type_AndroidViewViewGroup.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    this.a.b = i;
    this.a.jdField_a_of_type_AndroidViewViewGroup.requestLayout();
    this.a.jdField_a_of_type_MqqOsMqqHandler.post(new ania(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anhy
 * JD-Core Version:    0.7.0.1
 */