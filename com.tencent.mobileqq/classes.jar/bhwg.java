import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.widget.DynamicGridView;

class bhwg
  implements ViewTreeObserver.OnPreDrawListener
{
  private final int jdField_a_of_type_Int;
  private final View jdField_a_of_type_AndroidViewView;
  private final int b;
  
  bhwg(bhwf parambhwf, View paramView, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
  }
  
  public boolean onPreDraw()
  {
    this.jdField_a_of_type_Bhwf.a.getViewTreeObserver().removeOnPreDrawListener(this);
    DynamicGridView.a(this.jdField_a_of_type_Bhwf.a, DynamicGridView.a(this.jdField_a_of_type_Bhwf.a) + bhwf.a(this.jdField_a_of_type_Bhwf));
    DynamicGridView.b(this.jdField_a_of_type_Bhwf.a, DynamicGridView.b(this.jdField_a_of_type_Bhwf.a) + bhwf.b(this.jdField_a_of_type_Bhwf));
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
    DynamicGridView.a(this.jdField_a_of_type_Bhwf.a, this.jdField_a_of_type_Bhwf.a.a(DynamicGridView.a(this.jdField_a_of_type_Bhwf.a)));
    if (DynamicGridView.a(this.jdField_a_of_type_Bhwf.a) != null) {
      DynamicGridView.a(this.jdField_a_of_type_Bhwf.a).setVisibility(4);
    }
    DynamicGridView.a(this.jdField_a_of_type_Bhwf.a, this.jdField_a_of_type_Int, this.b);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhwg
 * JD-Core Version:    0.7.0.1
 */