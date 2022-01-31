import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.widget.DynamicGridView;

class bhwi
  implements ViewTreeObserver.OnPreDrawListener
{
  private final int jdField_a_of_type_Int;
  private final int b;
  
  bhwi(bhwh parambhwh, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
  }
  
  public boolean onPreDraw()
  {
    this.jdField_a_of_type_Bhwh.a.getViewTreeObserver().removeOnPreDrawListener(this);
    DynamicGridView.a(this.jdField_a_of_type_Bhwh.a, DynamicGridView.a(this.jdField_a_of_type_Bhwh.a) + bhwh.a(this.jdField_a_of_type_Bhwh));
    DynamicGridView.b(this.jdField_a_of_type_Bhwh.a, DynamicGridView.b(this.jdField_a_of_type_Bhwh.a) + bhwh.b(this.jdField_a_of_type_Bhwh));
    if (DynamicGridView.a(this.jdField_a_of_type_Bhwh.a) != null) {
      DynamicGridView.a(this.jdField_a_of_type_Bhwh.a).setVisibility(0);
    }
    DynamicGridView.a(this.jdField_a_of_type_Bhwh.a, this.jdField_a_of_type_Bhwh.a.a(DynamicGridView.a(this.jdField_a_of_type_Bhwh.a)));
    if (DynamicGridView.a(this.jdField_a_of_type_Bhwh.a) != null) {
      DynamicGridView.a(this.jdField_a_of_type_Bhwh.a).setVisibility(4);
    }
    DynamicGridView.a(this.jdField_a_of_type_Bhwh.a, this.jdField_a_of_type_Int, this.b);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhwi
 * JD-Core Version:    0.7.0.1
 */