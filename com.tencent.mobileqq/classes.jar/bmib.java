import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.tavcut.session.TAVCutImageSession;
import dov.com.qq.im.aeeditor.module.edit.AEEditorImageEditFragment;

public class bmib
  extends GestureDetector.SimpleOnGestureListener
{
  public bmib(AEEditorImageEditFragment paramAEEditorImageEditFragment) {}
  
  public void onShowPress(MotionEvent paramMotionEvent)
  {
    super.onShowPress(paramMotionEvent);
    AEEditorImageEditFragment.a(this.a).toggleAEKit(AEEditorImageEditFragment.a(this.a), false);
    bmbx.a("AEEditorImageEditFragment", "[onTouch] onShowPress");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmib
 * JD-Core Version:    0.7.0.1
 */