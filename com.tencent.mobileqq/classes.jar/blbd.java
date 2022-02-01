import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.widget.DynamicGridView;

class blbd
  implements ViewTreeObserver.OnPreDrawListener
{
  private final int jdField_a_of_type_Int;
  private final View jdField_a_of_type_AndroidViewView;
  private final int b;
  
  blbd(blbc paramblbc, View paramView, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
  }
  
  public boolean onPreDraw()
  {
    this.jdField_a_of_type_Blbc.a.getViewTreeObserver().removeOnPreDrawListener(this);
    DynamicGridView.a(this.jdField_a_of_type_Blbc.a, DynamicGridView.a(this.jdField_a_of_type_Blbc.a) + blbc.a(this.jdField_a_of_type_Blbc));
    DynamicGridView.b(this.jdField_a_of_type_Blbc.a, DynamicGridView.b(this.jdField_a_of_type_Blbc.a) + blbc.b(this.jdField_a_of_type_Blbc));
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
    DynamicGridView.a(this.jdField_a_of_type_Blbc.a, this.jdField_a_of_type_Blbc.a.a(DynamicGridView.a(this.jdField_a_of_type_Blbc.a)));
    if (DynamicGridView.a(this.jdField_a_of_type_Blbc.a) != null) {
      DynamicGridView.a(this.jdField_a_of_type_Blbc.a).setVisibility(4);
    }
    DynamicGridView.a(this.jdField_a_of_type_Blbc.a, this.jdField_a_of_type_Int, this.b);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blbd
 * JD-Core Version:    0.7.0.1
 */