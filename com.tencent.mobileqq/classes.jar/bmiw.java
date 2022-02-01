import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.tavcut.session.TAVCutVideoSession;
import dov.com.qq.im.aeeditor.module.edit.AEEditorVideoEditFragment;

public class bmiw
  extends GestureDetector.SimpleOnGestureListener
{
  public bmiw(AEEditorVideoEditFragment paramAEEditorVideoEditFragment) {}
  
  public void onShowPress(MotionEvent paramMotionEvent)
  {
    super.onShowPress(paramMotionEvent);
    this.a.a.toggleAEKit(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmiw
 * JD-Core Version:    0.7.0.1
 */