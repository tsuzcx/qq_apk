import android.widget.NumberPicker;
import android.widget.NumberPicker.OnValueChangeListener;

class bfef
  implements NumberPicker.OnValueChangeListener
{
  private int jdField_a_of_type_Int;
  
  public bfef(bfee parambfee, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void onValueChange(NumberPicker paramNumberPicker, int paramInt1, int paramInt2)
  {
    if ((bfee.a(this.jdField_a_of_type_Bfee) != null) && (bfee.a(this.jdField_a_of_type_Bfee).length > this.jdField_a_of_type_Int))
    {
      bfee.a(this.jdField_a_of_type_Bfee)[this.jdField_a_of_type_Int] = paramInt2;
      bfee.a(this.jdField_a_of_type_Bfee).onValChange(this.jdField_a_of_type_Int, paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bfef
 * JD-Core Version:    0.7.0.1
 */