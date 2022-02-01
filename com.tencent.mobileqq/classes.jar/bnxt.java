import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.tavcut.session.TAVCutImageSession;
import dov.com.qq.im.aeeditor.module.edit.AEEditorImageEditFragment;

public class bnxt
  extends GestureDetector.SimpleOnGestureListener
{
  public bnxt(AEEditorImageEditFragment paramAEEditorImageEditFragment) {}
  
  public void onShowPress(MotionEvent paramMotionEvent)
  {
    super.onShowPress(paramMotionEvent);
    AEEditorImageEditFragment.a(this.a).toggleAEKit(AEEditorImageEditFragment.a(this.a), false);
    bnrh.a("AEEditorImageEditFragment", "[onTouch] onShowPress");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnxt
 * JD-Core Version:    0.7.0.1
 */