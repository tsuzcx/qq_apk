import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.widget.DynamicGridView;

class bhrz
  implements ViewTreeObserver.OnPreDrawListener
{
  private final int jdField_a_of_type_Int;
  private final View jdField_a_of_type_AndroidViewView;
  private final int b;
  
  bhrz(bhry parambhry, View paramView, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
  }
  
  public boolean onPreDraw()
  {
    this.jdField_a_of_type_Bhry.a.getViewTreeObserver().removeOnPreDrawListener(this);
    DynamicGridView.a(this.jdField_a_of_type_Bhry.a, DynamicGridView.a(this.jdField_a_of_type_Bhry.a) + bhry.a(this.jdField_a_of_type_Bhry));
    DynamicGridView.b(this.jdField_a_of_type_Bhry.a, DynamicGridView.b(this.jdField_a_of_type_Bhry.a) + bhry.b(this.jdField_a_of_type_Bhry));
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
    DynamicGridView.a(this.jdField_a_of_type_Bhry.a, this.jdField_a_of_type_Bhry.a.a(DynamicGridView.a(this.jdField_a_of_type_Bhry.a)));
    if (DynamicGridView.a(this.jdField_a_of_type_Bhry.a) != null) {
      DynamicGridView.a(this.jdField_a_of_type_Bhry.a).setVisibility(4);
    }
    DynamicGridView.a(this.jdField_a_of_type_Bhry.a, this.jdField_a_of_type_Int, this.b);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhrz
 * JD-Core Version:    0.7.0.1
 */