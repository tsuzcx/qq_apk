import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.tavcut.session.TAVCutVideoSession;
import dov.com.qq.im.aeeditor.module.edit.AEEditorVideoEditFragment;

public class bofj
  extends GestureDetector.SimpleOnGestureListener
{
  public bofj(AEEditorVideoEditFragment paramAEEditorVideoEditFragment) {}
  
  public void onShowPress(MotionEvent paramMotionEvent)
  {
    super.onShowPress(paramMotionEvent);
    AEEditorVideoEditFragment.a(this.a).toggleAEKit(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bofj
 * JD-Core Version:    0.7.0.1
 */