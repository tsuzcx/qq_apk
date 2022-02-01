import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.tavcut.session.TAVCutVideoSession;
import dov.com.qq.im.aeeditor.module.edit.AEEditorVideoEditFragment;

public class bmix
  implements View.OnTouchListener
{
  public bmix(AEEditorVideoEditFragment paramAEEditorVideoEditFragment, GestureDetector paramGestureDetector) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    this.jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent);
    if ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3)) {
      this.jdField_a_of_type_DovComQqImAeeditorModuleEditAEEditorVideoEditFragment.a.toggleAEKit(true);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmix
 * JD-Core Version:    0.7.0.1
 */