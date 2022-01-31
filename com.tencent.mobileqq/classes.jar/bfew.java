import android.widget.NumberPicker;
import android.widget.NumberPicker.OnValueChangeListener;

class bfew
  implements NumberPicker.OnValueChangeListener
{
  private int jdField_a_of_type_Int;
  
  public bfew(bfev parambfev, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void onValueChange(NumberPicker paramNumberPicker, int paramInt1, int paramInt2)
  {
    if ((bfev.a(this.jdField_a_of_type_Bfev) != null) && (bfev.a(this.jdField_a_of_type_Bfev).length > this.jdField_a_of_type_Int))
    {
      bfev.a(this.jdField_a_of_type_Bfev)[this.jdField_a_of_type_Int] = paramInt2;
      bfev.a(this.jdField_a_of_type_Bfev).onValChange(this.jdField_a_of_type_Int, paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bfew
 * JD-Core Version:    0.7.0.1
 */