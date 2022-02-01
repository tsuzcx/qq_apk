import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.widget.DynamicGridView;

class blkv
  implements ViewTreeObserver.OnPreDrawListener
{
  private final int jdField_a_of_type_Int;
  private final View jdField_a_of_type_AndroidViewView;
  private final int b;
  
  blkv(blku paramblku, View paramView, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
  }
  
  public boolean onPreDraw()
  {
    this.jdField_a_of_type_Blku.a.getViewTreeObserver().removeOnPreDrawListener(this);
    DynamicGridView.a(this.jdField_a_of_type_Blku.a, DynamicGridView.a(this.jdField_a_of_type_Blku.a) + blku.a(this.jdField_a_of_type_Blku));
    DynamicGridView.b(this.jdField_a_of_type_Blku.a, DynamicGridView.b(this.jdField_a_of_type_Blku.a) + blku.b(this.jdField_a_of_type_Blku));
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
    DynamicGridView.a(this.jdField_a_of_type_Blku.a, this.jdField_a_of_type_Blku.a.a(DynamicGridView.a(this.jdField_a_of_type_Blku.a)));
    if (DynamicGridView.a(this.jdField_a_of_type_Blku.a) != null) {
      DynamicGridView.a(this.jdField_a_of_type_Blku.a).setVisibility(4);
    }
    DynamicGridView.a(this.jdField_a_of_type_Blku.a, this.jdField_a_of_type_Int, this.b);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blkv
 * JD-Core Version:    0.7.0.1
 */