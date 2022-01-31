import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.mobileqq.emosm.view.DragSortListView;

class appb
  extends GestureDetector.SimpleOnGestureListener
{
  appb(appa paramappa) {}
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    if ((!this.a.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.b()) && (this.a.d != -1)) {
      this.a.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setTapPos(this.a.d);
    }
    return false;
  }
  
  public final boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if ((this.a.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.b()) || (Math.abs(paramFloat1) <= Math.abs(paramFloat2)) || (this.a.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.c()) || (this.a.c) || (Math.abs(paramFloat1) <= this.a.jdField_a_of_type_Float) || ((paramFloat1 < 0.0F) && (this.a.jdField_a_of_type_Int == 2))) {}
    while ((paramFloat1 > 0.0F) && (this.a.jdField_a_of_type_Int == 1)) {
      return false;
    }
    int i = this.a.d;
    this.a.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setSrcPos(i);
    this.a.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.c();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     appb
 * JD-Core Version:    0.7.0.1
 */