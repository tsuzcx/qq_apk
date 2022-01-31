import android.widget.NumberPicker;
import android.widget.NumberPicker.OnValueChangeListener;

class bhfp
  implements NumberPicker.OnValueChangeListener
{
  private int jdField_a_of_type_Int;
  
  public bhfp(bhfo parambhfo, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void onValueChange(NumberPicker paramNumberPicker, int paramInt1, int paramInt2)
  {
    if ((bhfo.a(this.jdField_a_of_type_Bhfo) != null) && (bhfo.a(this.jdField_a_of_type_Bhfo).length > this.jdField_a_of_type_Int))
    {
      bhfo.a(this.jdField_a_of_type_Bhfo)[this.jdField_a_of_type_Int] = paramInt2;
      bhfo.a(this.jdField_a_of_type_Bhfo).onValChange(this.jdField_a_of_type_Int, paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhfp
 * JD-Core Version:    0.7.0.1
 */