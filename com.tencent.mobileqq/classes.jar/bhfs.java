import android.widget.NumberPicker;
import android.widget.NumberPicker.OnValueChangeListener;

class bhfs
  implements NumberPicker.OnValueChangeListener
{
  bhfs(bhfr parambhfr) {}
  
  public void onValueChange(NumberPicker paramNumberPicker, int paramInt1, int paramInt2)
  {
    bhfr.a(this.a, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhfs
 * JD-Core Version:    0.7.0.1
 */