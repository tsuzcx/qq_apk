import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;

class bdsg
  extends ViewOutlineProvider
{
  bdsg(bdsf parambdsf, int paramInt) {}
  
  public void getOutline(View paramView, Outline paramOutline)
  {
    paramOutline.setRoundRect(0, 0, paramView.getWidth(), paramView.getHeight(), this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdsg
 * JD-Core Version:    0.7.0.1
 */