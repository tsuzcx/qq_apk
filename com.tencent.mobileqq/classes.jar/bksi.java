import android.view.View;
import android.view.View.OnLayoutChangeListener;

class bksi
  implements View.OnLayoutChangeListener
{
  private int jdField_a_of_type_Int;
  private int b;
  
  private bksi(bkse parambkse) {}
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    if ((this.jdField_a_of_type_Int > 0) && (this.b > 0)) {}
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      if ((paramInt1 != 0) && (!bkse.c(this.jdField_a_of_type_Bkse)) && ((this.jdField_a_of_type_Int != paramView.getHeight()) || (this.b != paramView.getWidth()))) {
        this.jdField_a_of_type_Bkse.f(bkse.b(this.jdField_a_of_type_Bkse));
      }
      this.jdField_a_of_type_Int = paramView.getHeight();
      this.b = paramView.getWidth();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bksi
 * JD-Core Version:    0.7.0.1
 */