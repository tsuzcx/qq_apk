import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import dov.com.qq.im.aeeditor.module.edit.AEEditorImageEditFragment;

public class bmhu
  implements bmob
{
  public bmhu(AEEditorImageEditFragment paramAEEditorImageEditFragment) {}
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    if (AEEditorImageEditFragment.a(this.a).getVisibility() == 0)
    {
      Rect localRect = new Rect();
      AEEditorImageEditFragment.a(this.a).getGlobalVisibleRect(localRect);
      if (!localRect.contains((int)paramMotionEvent.getRawX(), (int)paramMotionEvent.getRawY())) {
        AEEditorImageEditFragment.a(this.a);
      }
    }
    return false;
  }
  
  public boolean b(MotionEvent paramMotionEvent)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmhu
 * JD-Core Version:    0.7.0.1
 */