import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.tavcut.session.TAVCutImageSession;
import dov.com.qq.im.aeeditor.module.edit.AEEditorImageEditFragment;

public class boeq
  extends GestureDetector.SimpleOnGestureListener
{
  public boeq(AEEditorImageEditFragment paramAEEditorImageEditFragment) {}
  
  public void onShowPress(MotionEvent paramMotionEvent)
  {
    super.onShowPress(paramMotionEvent);
    AEEditorImageEditFragment.a(this.a).toggleAEKit(AEEditorImageEditFragment.a(this.a), false);
    bnzb.a(AEEditorImageEditFragment.e(), "[onTouch] onShowPress");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     boeq
 * JD-Core Version:    0.7.0.1
 */