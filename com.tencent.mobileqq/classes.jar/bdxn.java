import android.widget.NumberPicker;
import android.widget.NumberPicker.OnValueChangeListener;

class bdxn
  implements NumberPicker.OnValueChangeListener
{
  private int jdField_a_of_type_Int;
  
  public bdxn(bdxm parambdxm, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void onValueChange(NumberPicker paramNumberPicker, int paramInt1, int paramInt2)
  {
    if ((bdxm.a(this.jdField_a_of_type_Bdxm) != null) && (bdxm.a(this.jdField_a_of_type_Bdxm).length > this.jdField_a_of_type_Int))
    {
      bdxm.a(this.jdField_a_of_type_Bdxm)[this.jdField_a_of_type_Int] = paramInt2;
      bdxm.a(this.jdField_a_of_type_Bdxm).onValChange(this.jdField_a_of_type_Int, paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdxn
 * JD-Core Version:    0.7.0.1
 */