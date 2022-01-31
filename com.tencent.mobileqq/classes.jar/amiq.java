import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.widget.DynamicGridView;

class amiq
  implements ViewTreeObserver.OnPreDrawListener
{
  private final int jdField_a_of_type_Int;
  private final int b;
  
  amiq(amip paramamip, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
  }
  
  public boolean onPreDraw()
  {
    this.jdField_a_of_type_Amip.a.getViewTreeObserver().removeOnPreDrawListener(this);
    DynamicGridView.a(this.jdField_a_of_type_Amip.a, DynamicGridView.a(this.jdField_a_of_type_Amip.a) + amip.a(this.jdField_a_of_type_Amip));
    DynamicGridView.b(this.jdField_a_of_type_Amip.a, DynamicGridView.b(this.jdField_a_of_type_Amip.a) + amip.b(this.jdField_a_of_type_Amip));
    if (DynamicGridView.a(this.jdField_a_of_type_Amip.a) != null) {
      DynamicGridView.a(this.jdField_a_of_type_Amip.a).setVisibility(0);
    }
    DynamicGridView.a(this.jdField_a_of_type_Amip.a, this.jdField_a_of_type_Amip.a.a(DynamicGridView.a(this.jdField_a_of_type_Amip.a)));
    if (DynamicGridView.a(this.jdField_a_of_type_Amip.a) != null) {
      DynamicGridView.a(this.jdField_a_of_type_Amip.a).setVisibility(4);
    }
    DynamicGridView.a(this.jdField_a_of_type_Amip.a, this.jdField_a_of_type_Int, this.b);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     amiq
 * JD-Core Version:    0.7.0.1
 */