import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.widget.DynamicGridView;

class blkx
  implements ViewTreeObserver.OnPreDrawListener
{
  private final int jdField_a_of_type_Int;
  private final int b;
  
  blkx(blkw paramblkw, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
  }
  
  public boolean onPreDraw()
  {
    this.jdField_a_of_type_Blkw.a.getViewTreeObserver().removeOnPreDrawListener(this);
    DynamicGridView.a(this.jdField_a_of_type_Blkw.a, DynamicGridView.a(this.jdField_a_of_type_Blkw.a) + blkw.a(this.jdField_a_of_type_Blkw));
    DynamicGridView.b(this.jdField_a_of_type_Blkw.a, DynamicGridView.b(this.jdField_a_of_type_Blkw.a) + blkw.b(this.jdField_a_of_type_Blkw));
    if (DynamicGridView.a(this.jdField_a_of_type_Blkw.a) != null) {
      DynamicGridView.a(this.jdField_a_of_type_Blkw.a).setVisibility(0);
    }
    DynamicGridView.a(this.jdField_a_of_type_Blkw.a, this.jdField_a_of_type_Blkw.a.a(DynamicGridView.a(this.jdField_a_of_type_Blkw.a)));
    if (DynamicGridView.a(this.jdField_a_of_type_Blkw.a) != null) {
      DynamicGridView.a(this.jdField_a_of_type_Blkw.a).setVisibility(4);
    }
    DynamicGridView.a(this.jdField_a_of_type_Blkw.a, this.jdField_a_of_type_Int, this.b);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blkx
 * JD-Core Version:    0.7.0.1
 */