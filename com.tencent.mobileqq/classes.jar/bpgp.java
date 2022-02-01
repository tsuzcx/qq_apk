import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.tavcut.session.TAVCutImageSession;
import dov.com.qq.im.aeeditor.module.edit.AEEditorImageEditFragment;

public class bpgp
  implements View.OnTouchListener
{
  public bpgp(AEEditorImageEditFragment paramAEEditorImageEditFragment, GestureDetector paramGestureDetector) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    this.jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent);
    if ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3))
    {
      AEEditorImageEditFragment.a(this.jdField_a_of_type_DovComQqImAeeditorModuleEditAEEditorImageEditFragment).toggleAEKit(AEEditorImageEditFragment.a(this.jdField_a_of_type_DovComQqImAeeditorModuleEditAEEditorImageEditFragment), true);
      bpam.a(AEEditorImageEditFragment.e(), "[onTouch] onTouch/ACTION_CANCEL ");
    }
    bpam.a(AEEditorImageEditFragment.e(), "[onTouch] Action: " + paramMotionEvent.getAction());
    return (paramMotionEvent.getAction() == 0) && (this.jdField_a_of_type_DovComQqImAeeditorModuleEditAEEditorImageEditFragment.a == null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpgp
 * JD-Core Version:    0.7.0.1
 */