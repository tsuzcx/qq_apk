import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.widget.DynamicGridView;

class bjpt
  implements ViewTreeObserver.OnPreDrawListener
{
  private final int jdField_a_of_type_Int;
  private final int b;
  
  bjpt(bjps parambjps, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
  }
  
  public boolean onPreDraw()
  {
    this.jdField_a_of_type_Bjps.a.getViewTreeObserver().removeOnPreDrawListener(this);
    DynamicGridView.a(this.jdField_a_of_type_Bjps.a, DynamicGridView.a(this.jdField_a_of_type_Bjps.a) + bjps.a(this.jdField_a_of_type_Bjps));
    DynamicGridView.b(this.jdField_a_of_type_Bjps.a, DynamicGridView.b(this.jdField_a_of_type_Bjps.a) + bjps.b(this.jdField_a_of_type_Bjps));
    if (DynamicGridView.a(this.jdField_a_of_type_Bjps.a) != null) {
      DynamicGridView.a(this.jdField_a_of_type_Bjps.a).setVisibility(0);
    }
    DynamicGridView.a(this.jdField_a_of_type_Bjps.a, this.jdField_a_of_type_Bjps.a.a(DynamicGridView.a(this.jdField_a_of_type_Bjps.a)));
    if (DynamicGridView.a(this.jdField_a_of_type_Bjps.a) != null) {
      DynamicGridView.a(this.jdField_a_of_type_Bjps.a).setVisibility(4);
    }
    DynamicGridView.a(this.jdField_a_of_type_Bjps.a, this.jdField_a_of_type_Int, this.b);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjpt
 * JD-Core Version:    0.7.0.1
 */