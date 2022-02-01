import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;

public class atsz
  extends GestureDetector.SimpleOnGestureListener
{
  public atsz(FileBrowserActivity paramFileBrowserActivity, int paramInt) {}
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if ((paramMotionEvent1 == null) || (paramMotionEvent2 == null)) {}
    do
    {
      return false;
      paramFloat1 = paramMotionEvent1.getX() - paramMotionEvent2.getX();
      paramFloat2 = Math.abs((paramMotionEvent1.getY() - paramMotionEvent2.getY()) / paramFloat1);
    } while ((paramFloat1 > -this.jdField_a_of_type_Int) || (paramFloat2 >= 0.5F) || (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileBrowserActivity.a == null) || (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileBrowserActivity.a.c()));
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileBrowserActivity.onBackEvent();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atsz
 * JD-Core Version:    0.7.0.1
 */