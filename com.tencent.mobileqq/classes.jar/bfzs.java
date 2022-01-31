import android.view.View;
import android.view.View.OnLayoutChangeListener;

class bfzs
  implements View.OnLayoutChangeListener
{
  private int jdField_a_of_type_Int;
  private int b;
  
  private bfzs(bfzo parambfzo) {}
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    if ((this.jdField_a_of_type_Int > 0) && (this.b > 0)) {}
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      if ((paramInt1 != 0) && (!bfzo.c(this.jdField_a_of_type_Bfzo)) && ((this.jdField_a_of_type_Int != paramView.getHeight()) || (this.b != paramView.getWidth()))) {
        this.jdField_a_of_type_Bfzo.f(bfzo.b(this.jdField_a_of_type_Bfzo));
      }
      this.jdField_a_of_type_Int = paramView.getHeight();
      this.b = paramView.getWidth();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bfzs
 * JD-Core Version:    0.7.0.1
 */