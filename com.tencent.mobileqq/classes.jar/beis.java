import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.widget.DynamicGridView;

class beis
  implements ViewTreeObserver.OnPreDrawListener
{
  private final int jdField_a_of_type_Int;
  private final View jdField_a_of_type_AndroidViewView;
  private final int b;
  
  beis(beir parambeir, View paramView, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
  }
  
  public boolean onPreDraw()
  {
    this.jdField_a_of_type_Beir.a.getViewTreeObserver().removeOnPreDrawListener(this);
    DynamicGridView.a(this.jdField_a_of_type_Beir.a, DynamicGridView.a(this.jdField_a_of_type_Beir.a) + beir.a(this.jdField_a_of_type_Beir));
    DynamicGridView.b(this.jdField_a_of_type_Beir.a, DynamicGridView.b(this.jdField_a_of_type_Beir.a) + beir.b(this.jdField_a_of_type_Beir));
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
    DynamicGridView.a(this.jdField_a_of_type_Beir.a, this.jdField_a_of_type_Beir.a.a(DynamicGridView.a(this.jdField_a_of_type_Beir.a)));
    if (DynamicGridView.a(this.jdField_a_of_type_Beir.a) != null) {
      DynamicGridView.a(this.jdField_a_of_type_Beir.a).setVisibility(4);
    }
    DynamicGridView.a(this.jdField_a_of_type_Beir.a, this.jdField_a_of_type_Int, this.b);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     beis
 * JD-Core Version:    0.7.0.1
 */