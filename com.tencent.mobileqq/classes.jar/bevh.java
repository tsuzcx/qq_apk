import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mobileqq.widget.SlideDetectListView;

public class bevh
  extends GestureDetector.SimpleOnGestureListener
{
  public bevh(SlideDetectListView paramSlideDetectListView) {}
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (!this.a.jdField_c_of_type_Boolean) {}
    do
    {
      return false;
      if ((paramFloat1 > 0.0F) && (Math.abs(paramFloat1) > Math.abs(paramFloat2) * 2.0F) && ((this.a.jdField_c_of_type_Int == 0) || (this.a.d)) && (!this.a.jdField_a_of_type_Boolean) && (Math.abs(paramFloat1) > this.a.f))
      {
        this.a.jdField_b_of_type_Int = this.a.a(this.a.jdField_a_of_type_Int);
        this.a.jdField_a_of_type_AndroidViewView = this.a.a(this.a.jdField_b_of_type_Int);
        if (this.a.jdField_a_of_type_AndroidViewView != null)
        {
          this.a.jdField_a_of_type_Boolean = true;
          this.a.setPressed(false);
          this.a.jdField_a_of_type_AndroidViewView.setPressed(false);
          if (SlideDetectListView.a(this.a) != null)
          {
            int i = this.a.jdField_b_of_type_Int;
            int j = this.a.getHeaderViewsCount();
            SlideDetectListView.a(this.a).a(this.a, this.a.jdField_a_of_type_AndroidViewView, i - j);
          }
          this.a.jdField_a_of_type_Int = 0;
        }
        for (;;)
        {
          return true;
          this.a.jdField_b_of_type_Boolean = true;
        }
      }
    } while (Math.abs(paramFloat1) <= Math.abs(paramFloat2) * 2.0F);
    this.a.jdField_b_of_type_Boolean = true;
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bevh
 * JD-Core Version:    0.7.0.1
 */