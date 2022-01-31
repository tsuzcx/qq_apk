import android.widget.NumberPicker;
import android.widget.TimePicker;
import android.widget.TimePicker.OnTimeChangedListener;

class bfel
  implements TimePicker.OnTimeChangedListener
{
  bfel(bfek parambfek) {}
  
  public void onTimeChanged(TimePicker paramTimePicker, int paramInt1, int paramInt2)
  {
    bfek.a(this.a, paramInt1);
    if (paramInt1 == bfek.a(this.a).getMinValue())
    {
      bfek.b(this.a).setMinValue(bfek.a(this.a));
      bfek.b(this.a).setMaxValue(59);
      return;
    }
    if (paramInt1 == bfek.a(this.a).getMaxValue())
    {
      bfek.b(this.a).setMinValue(0);
      bfek.b(this.a).setMaxValue(bfek.b(this.a));
      return;
    }
    bfek.b(this.a).setMinValue(0);
    bfek.b(this.a).setMaxValue(59);
    bfek.b(this.a, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bfel
 * JD-Core Version:    0.7.0.1
 */