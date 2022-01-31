import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.widget.DynamicGridView;

class amio
  implements ViewTreeObserver.OnPreDrawListener
{
  private final int jdField_a_of_type_Int;
  private final View jdField_a_of_type_AndroidViewView;
  private final int b;
  
  amio(amin paramamin, View paramView, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
  }
  
  public boolean onPreDraw()
  {
    this.jdField_a_of_type_Amin.a.getViewTreeObserver().removeOnPreDrawListener(this);
    DynamicGridView.a(this.jdField_a_of_type_Amin.a, DynamicGridView.a(this.jdField_a_of_type_Amin.a) + amin.a(this.jdField_a_of_type_Amin));
    DynamicGridView.b(this.jdField_a_of_type_Amin.a, DynamicGridView.b(this.jdField_a_of_type_Amin.a) + amin.b(this.jdField_a_of_type_Amin));
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
    DynamicGridView.a(this.jdField_a_of_type_Amin.a, this.jdField_a_of_type_Amin.a.a(DynamicGridView.a(this.jdField_a_of_type_Amin.a)));
    if (DynamicGridView.a(this.jdField_a_of_type_Amin.a) != null) {
      DynamicGridView.a(this.jdField_a_of_type_Amin.a).setVisibility(4);
    }
    DynamicGridView.a(this.jdField_a_of_type_Amin.a, this.jdField_a_of_type_Int, this.b);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     amio
 * JD-Core Version:    0.7.0.1
 */