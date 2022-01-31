import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.widget.DynamicGridView;

class bfqm
  implements ViewTreeObserver.OnPreDrawListener
{
  private final int jdField_a_of_type_Int;
  private final View jdField_a_of_type_AndroidViewView;
  private final int b;
  
  bfqm(bfql parambfql, View paramView, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
  }
  
  public boolean onPreDraw()
  {
    this.jdField_a_of_type_Bfql.a.getViewTreeObserver().removeOnPreDrawListener(this);
    DynamicGridView.a(this.jdField_a_of_type_Bfql.a, DynamicGridView.a(this.jdField_a_of_type_Bfql.a) + bfql.a(this.jdField_a_of_type_Bfql));
    DynamicGridView.b(this.jdField_a_of_type_Bfql.a, DynamicGridView.b(this.jdField_a_of_type_Bfql.a) + bfql.b(this.jdField_a_of_type_Bfql));
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
    DynamicGridView.a(this.jdField_a_of_type_Bfql.a, this.jdField_a_of_type_Bfql.a.a(DynamicGridView.a(this.jdField_a_of_type_Bfql.a)));
    if (DynamicGridView.a(this.jdField_a_of_type_Bfql.a) != null) {
      DynamicGridView.a(this.jdField_a_of_type_Bfql.a).setVisibility(4);
    }
    DynamicGridView.a(this.jdField_a_of_type_Bfql.a, this.jdField_a_of_type_Int, this.b);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bfqm
 * JD-Core Version:    0.7.0.1
 */