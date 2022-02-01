import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.widget.DynamicGridView;

class bkjs
  implements ViewTreeObserver.OnPreDrawListener
{
  private final int jdField_a_of_type_Int;
  private final View jdField_a_of_type_AndroidViewView;
  private final int b;
  
  bkjs(bkjr parambkjr, View paramView, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
  }
  
  public boolean onPreDraw()
  {
    this.jdField_a_of_type_Bkjr.a.getViewTreeObserver().removeOnPreDrawListener(this);
    DynamicGridView.a(this.jdField_a_of_type_Bkjr.a, DynamicGridView.a(this.jdField_a_of_type_Bkjr.a) + bkjr.a(this.jdField_a_of_type_Bkjr));
    DynamicGridView.b(this.jdField_a_of_type_Bkjr.a, DynamicGridView.b(this.jdField_a_of_type_Bkjr.a) + bkjr.b(this.jdField_a_of_type_Bkjr));
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
    DynamicGridView.a(this.jdField_a_of_type_Bkjr.a, this.jdField_a_of_type_Bkjr.a.a(DynamicGridView.a(this.jdField_a_of_type_Bkjr.a)));
    if (DynamicGridView.a(this.jdField_a_of_type_Bkjr.a) != null) {
      DynamicGridView.a(this.jdField_a_of_type_Bkjr.a).setVisibility(4);
    }
    DynamicGridView.a(this.jdField_a_of_type_Bkjr.a, this.jdField_a_of_type_Int, this.b);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkjs
 * JD-Core Version:    0.7.0.1
 */