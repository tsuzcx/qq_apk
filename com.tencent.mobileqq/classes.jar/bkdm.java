import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.crop.CropNewView;

public class bkdm
  extends GestureDetector.SimpleOnGestureListener
{
  private bkdm(CropNewView paramCropNewView) {}
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return super.onFling(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return CropNewView.a(this.a, paramFloat1, paramFloat2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkdm
 * JD-Core Version:    0.7.0.1
 */