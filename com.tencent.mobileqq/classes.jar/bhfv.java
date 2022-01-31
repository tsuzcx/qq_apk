import android.widget.NumberPicker;
import android.widget.TimePicker;
import android.widget.TimePicker.OnTimeChangedListener;

class bhfv
  implements TimePicker.OnTimeChangedListener
{
  bhfv(bhfu parambhfu) {}
  
  public void onTimeChanged(TimePicker paramTimePicker, int paramInt1, int paramInt2)
  {
    bhfu.a(this.a, paramInt1);
    if (paramInt1 == bhfu.a(this.a).getMinValue())
    {
      bhfu.b(this.a).setMinValue(bhfu.a(this.a));
      bhfu.b(this.a).setMaxValue(59);
      return;
    }
    if (paramInt1 == bhfu.a(this.a).getMaxValue())
    {
      bhfu.b(this.a).setMinValue(0);
      bhfu.b(this.a).setMaxValue(bhfu.b(this.a));
      return;
    }
    bhfu.b(this.a).setMinValue(0);
    bhfu.b(this.a).setMaxValue(59);
    bhfu.b(this.a, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhfv
 * JD-Core Version:    0.7.0.1
 */