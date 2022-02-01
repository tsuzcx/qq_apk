import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mobileqq.filemanager.fileviewer.viewer.SimpleFileViewer;
import com.tencent.mobileqq.filemanager.fileviewer.viewer.SimpleFileViewer.GestureRelativeLayout;

public class aubf
  implements GestureDetector.OnGestureListener
{
  private aubf(SimpleFileViewer.GestureRelativeLayout paramGestureRelativeLayout) {}
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public void onLongPress(MotionEvent paramMotionEvent) {}
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (Math.abs(paramFloat2) > Math.abs(paramFloat1))
    {
      paramMotionEvent1 = this.a.a.b();
      if (paramFloat2 <= 0.0F) {
        break label97;
      }
      if (paramMotionEvent1 != null) {
        paramMotionEvent1.setVisibility(8);
      }
      if (this.a.a.jdField_a_of_type_Aulr != null) {
        this.a.a.jdField_a_of_type_Aulr.b(true);
      }
      if (this.a.a.jdField_a_of_type_Aulp != null) {
        this.a.a.jdField_a_of_type_Aulp.b(true);
      }
    }
    label97:
    do
    {
      do
      {
        return false;
      } while (paramFloat2 >= 0.0F);
      if (paramMotionEvent1 != null) {
        paramMotionEvent1.setVisibility(0);
      }
      if (this.a.a.jdField_a_of_type_Aulr != null) {
        this.a.a.jdField_a_of_type_Aulr.a(true);
      }
    } while (this.a.a.jdField_a_of_type_Aulp == null);
    this.a.a.jdField_a_of_type_Aulp.a(true);
    return false;
  }
  
  public void onShowPress(MotionEvent paramMotionEvent) {}
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aubf
 * JD-Core Version:    0.7.0.1
 */