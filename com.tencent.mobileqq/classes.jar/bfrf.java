import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.widget.DynamicGridView;

class bfrf
  implements ViewTreeObserver.OnPreDrawListener
{
  private final int jdField_a_of_type_Int;
  private final int b;
  
  bfrf(bfre parambfre, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
  }
  
  public boolean onPreDraw()
  {
    this.jdField_a_of_type_Bfre.a.getViewTreeObserver().removeOnPreDrawListener(this);
    DynamicGridView.a(this.jdField_a_of_type_Bfre.a, DynamicGridView.a(this.jdField_a_of_type_Bfre.a) + bfre.a(this.jdField_a_of_type_Bfre));
    DynamicGridView.b(this.jdField_a_of_type_Bfre.a, DynamicGridView.b(this.jdField_a_of_type_Bfre.a) + bfre.b(this.jdField_a_of_type_Bfre));
    if (DynamicGridView.a(this.jdField_a_of_type_Bfre.a) != null) {
      DynamicGridView.a(this.jdField_a_of_type_Bfre.a).setVisibility(0);
    }
    DynamicGridView.a(this.jdField_a_of_type_Bfre.a, this.jdField_a_of_type_Bfre.a.a(DynamicGridView.a(this.jdField_a_of_type_Bfre.a)));
    if (DynamicGridView.a(this.jdField_a_of_type_Bfre.a) != null) {
      DynamicGridView.a(this.jdField_a_of_type_Bfre.a).setVisibility(4);
    }
    DynamicGridView.a(this.jdField_a_of_type_Bfre.a, this.jdField_a_of_type_Int, this.b);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bfrf
 * JD-Core Version:    0.7.0.1
 */