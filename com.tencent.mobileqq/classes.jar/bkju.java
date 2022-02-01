import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.widget.DynamicGridView;

class bkju
  implements ViewTreeObserver.OnPreDrawListener
{
  private final int jdField_a_of_type_Int;
  private final int b;
  
  bkju(bkjt parambkjt, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
  }
  
  public boolean onPreDraw()
  {
    this.jdField_a_of_type_Bkjt.a.getViewTreeObserver().removeOnPreDrawListener(this);
    DynamicGridView.a(this.jdField_a_of_type_Bkjt.a, DynamicGridView.a(this.jdField_a_of_type_Bkjt.a) + bkjt.a(this.jdField_a_of_type_Bkjt));
    DynamicGridView.b(this.jdField_a_of_type_Bkjt.a, DynamicGridView.b(this.jdField_a_of_type_Bkjt.a) + bkjt.b(this.jdField_a_of_type_Bkjt));
    if (DynamicGridView.a(this.jdField_a_of_type_Bkjt.a) != null) {
      DynamicGridView.a(this.jdField_a_of_type_Bkjt.a).setVisibility(0);
    }
    DynamicGridView.a(this.jdField_a_of_type_Bkjt.a, this.jdField_a_of_type_Bkjt.a.a(DynamicGridView.a(this.jdField_a_of_type_Bkjt.a)));
    if (DynamicGridView.a(this.jdField_a_of_type_Bkjt.a) != null) {
      DynamicGridView.a(this.jdField_a_of_type_Bkjt.a).setVisibility(4);
    }
    DynamicGridView.a(this.jdField_a_of_type_Bkjt.a, this.jdField_a_of_type_Int, this.b);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkju
 * JD-Core Version:    0.7.0.1
 */