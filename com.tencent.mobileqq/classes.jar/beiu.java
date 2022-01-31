import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.widget.DynamicGridView;

class beiu
  implements ViewTreeObserver.OnPreDrawListener
{
  private final int jdField_a_of_type_Int;
  private final int b;
  
  beiu(beit parambeit, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
  }
  
  public boolean onPreDraw()
  {
    this.jdField_a_of_type_Beit.a.getViewTreeObserver().removeOnPreDrawListener(this);
    DynamicGridView.a(this.jdField_a_of_type_Beit.a, DynamicGridView.a(this.jdField_a_of_type_Beit.a) + beit.a(this.jdField_a_of_type_Beit));
    DynamicGridView.b(this.jdField_a_of_type_Beit.a, DynamicGridView.b(this.jdField_a_of_type_Beit.a) + beit.b(this.jdField_a_of_type_Beit));
    if (DynamicGridView.a(this.jdField_a_of_type_Beit.a) != null) {
      DynamicGridView.a(this.jdField_a_of_type_Beit.a).setVisibility(0);
    }
    DynamicGridView.a(this.jdField_a_of_type_Beit.a, this.jdField_a_of_type_Beit.a.a(DynamicGridView.a(this.jdField_a_of_type_Beit.a)));
    if (DynamicGridView.a(this.jdField_a_of_type_Beit.a) != null) {
      DynamicGridView.a(this.jdField_a_of_type_Beit.a).setVisibility(4);
    }
    DynamicGridView.a(this.jdField_a_of_type_Beit.a, this.jdField_a_of_type_Int, this.b);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     beiu
 * JD-Core Version:    0.7.0.1
 */