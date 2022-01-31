import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.widget.DynamicGridView;

class bhsb
  implements ViewTreeObserver.OnPreDrawListener
{
  private final int jdField_a_of_type_Int;
  private final int b;
  
  bhsb(bhsa parambhsa, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
  }
  
  public boolean onPreDraw()
  {
    this.jdField_a_of_type_Bhsa.a.getViewTreeObserver().removeOnPreDrawListener(this);
    DynamicGridView.a(this.jdField_a_of_type_Bhsa.a, DynamicGridView.a(this.jdField_a_of_type_Bhsa.a) + bhsa.a(this.jdField_a_of_type_Bhsa));
    DynamicGridView.b(this.jdField_a_of_type_Bhsa.a, DynamicGridView.b(this.jdField_a_of_type_Bhsa.a) + bhsa.b(this.jdField_a_of_type_Bhsa));
    if (DynamicGridView.a(this.jdField_a_of_type_Bhsa.a) != null) {
      DynamicGridView.a(this.jdField_a_of_type_Bhsa.a).setVisibility(0);
    }
    DynamicGridView.a(this.jdField_a_of_type_Bhsa.a, this.jdField_a_of_type_Bhsa.a.a(DynamicGridView.a(this.jdField_a_of_type_Bhsa.a)));
    if (DynamicGridView.a(this.jdField_a_of_type_Bhsa.a) != null) {
      DynamicGridView.a(this.jdField_a_of_type_Bhsa.a).setVisibility(4);
    }
    DynamicGridView.a(this.jdField_a_of_type_Bhsa.a, this.jdField_a_of_type_Int, this.b);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhsb
 * JD-Core Version:    0.7.0.1
 */