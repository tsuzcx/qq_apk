import android.widget.NumberPicker;
import android.widget.TimePicker;
import android.widget.TimePicker.OnTimeChangedListener;

class bhkc
  implements TimePicker.OnTimeChangedListener
{
  bhkc(bhkb parambhkb) {}
  
  public void onTimeChanged(TimePicker paramTimePicker, int paramInt1, int paramInt2)
  {
    bhkb.a(this.a, paramInt1);
    if (paramInt1 == bhkb.a(this.a).getMinValue())
    {
      bhkb.b(this.a).setMinValue(bhkb.a(this.a));
      bhkb.b(this.a).setMaxValue(59);
      return;
    }
    if (paramInt1 == bhkb.a(this.a).getMaxValue())
    {
      bhkb.b(this.a).setMinValue(0);
      bhkb.b(this.a).setMaxValue(bhkb.b(this.a));
      return;
    }
    bhkb.b(this.a).setMinValue(0);
    bhkb.b(this.a).setMaxValue(59);
    bhkb.b(this.a, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhkc
 * JD-Core Version:    0.7.0.1
 */