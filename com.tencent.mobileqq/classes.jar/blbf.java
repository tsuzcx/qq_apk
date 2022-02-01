import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.widget.DynamicGridView;

class blbf
  implements ViewTreeObserver.OnPreDrawListener
{
  private final int jdField_a_of_type_Int;
  private final int b;
  
  blbf(blbe paramblbe, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
  }
  
  public boolean onPreDraw()
  {
    this.jdField_a_of_type_Blbe.a.getViewTreeObserver().removeOnPreDrawListener(this);
    DynamicGridView.a(this.jdField_a_of_type_Blbe.a, DynamicGridView.a(this.jdField_a_of_type_Blbe.a) + blbe.a(this.jdField_a_of_type_Blbe));
    DynamicGridView.b(this.jdField_a_of_type_Blbe.a, DynamicGridView.b(this.jdField_a_of_type_Blbe.a) + blbe.b(this.jdField_a_of_type_Blbe));
    if (DynamicGridView.a(this.jdField_a_of_type_Blbe.a) != null) {
      DynamicGridView.a(this.jdField_a_of_type_Blbe.a).setVisibility(0);
    }
    DynamicGridView.a(this.jdField_a_of_type_Blbe.a, this.jdField_a_of_type_Blbe.a.a(DynamicGridView.a(this.jdField_a_of_type_Blbe.a)));
    if (DynamicGridView.a(this.jdField_a_of_type_Blbe.a) != null) {
      DynamicGridView.a(this.jdField_a_of_type_Blbe.a).setVisibility(4);
    }
    DynamicGridView.a(this.jdField_a_of_type_Blbe.a, this.jdField_a_of_type_Int, this.b);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blbf
 * JD-Core Version:    0.7.0.1
 */