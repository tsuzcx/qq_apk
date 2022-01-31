import android.widget.NumberPicker;
import android.widget.NumberPicker.OnValueChangeListener;

class bhjw
  implements NumberPicker.OnValueChangeListener
{
  private int jdField_a_of_type_Int;
  
  public bhjw(bhjv parambhjv, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void onValueChange(NumberPicker paramNumberPicker, int paramInt1, int paramInt2)
  {
    if ((bhjv.a(this.jdField_a_of_type_Bhjv) != null) && (bhjv.a(this.jdField_a_of_type_Bhjv).length > this.jdField_a_of_type_Int))
    {
      bhjv.a(this.jdField_a_of_type_Bhjv)[this.jdField_a_of_type_Int] = paramInt2;
      bhjv.a(this.jdField_a_of_type_Bhjv).onValChange(this.jdField_a_of_type_Int, paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhjw
 * JD-Core Version:    0.7.0.1
 */