import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.widget.DynamicGridView;

class bjpr
  implements ViewTreeObserver.OnPreDrawListener
{
  private final int jdField_a_of_type_Int;
  private final View jdField_a_of_type_AndroidViewView;
  private final int b;
  
  bjpr(bjpq parambjpq, View paramView, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
  }
  
  public boolean onPreDraw()
  {
    this.jdField_a_of_type_Bjpq.a.getViewTreeObserver().removeOnPreDrawListener(this);
    DynamicGridView.a(this.jdField_a_of_type_Bjpq.a, DynamicGridView.a(this.jdField_a_of_type_Bjpq.a) + bjpq.a(this.jdField_a_of_type_Bjpq));
    DynamicGridView.b(this.jdField_a_of_type_Bjpq.a, DynamicGridView.b(this.jdField_a_of_type_Bjpq.a) + bjpq.b(this.jdField_a_of_type_Bjpq));
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
    DynamicGridView.a(this.jdField_a_of_type_Bjpq.a, this.jdField_a_of_type_Bjpq.a.a(DynamicGridView.a(this.jdField_a_of_type_Bjpq.a)));
    if (DynamicGridView.a(this.jdField_a_of_type_Bjpq.a) != null) {
      DynamicGridView.a(this.jdField_a_of_type_Bjpq.a).setVisibility(4);
    }
    DynamicGridView.a(this.jdField_a_of_type_Bjpq.a, this.jdField_a_of_type_Int, this.b);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjpr
 * JD-Core Version:    0.7.0.1
 */