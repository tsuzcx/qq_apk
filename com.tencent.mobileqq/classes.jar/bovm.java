import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.View.OnTouchListener;
import dov.com.qq.im.cropvideo.CropVideoActivity;

public class bovm
  implements View.OnTouchListener
{
  public bovm(CropVideoActivity paramCropVideoActivity) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    CropVideoActivity.a(this.a).onTouchEvent(paramMotionEvent);
    CropVideoActivity.a(this.a).a(paramMotionEvent);
    CropVideoActivity.a(this.a).onTouchEvent(paramMotionEvent);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bovm
 * JD-Core Version:    0.7.0.1
 */