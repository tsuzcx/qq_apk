import android.widget.NumberPicker;
import android.widget.TimePicker;
import android.widget.TimePicker.OnTimeChangedListener;

class bffc
  implements TimePicker.OnTimeChangedListener
{
  bffc(bffb parambffb) {}
  
  public void onTimeChanged(TimePicker paramTimePicker, int paramInt1, int paramInt2)
  {
    bffb.a(this.a, paramInt1);
    if (paramInt1 == bffb.a(this.a).getMinValue())
    {
      bffb.b(this.a).setMinValue(bffb.a(this.a));
      bffb.b(this.a).setMaxValue(59);
      return;
    }
    if (paramInt1 == bffb.a(this.a).getMaxValue())
    {
      bffb.b(this.a).setMinValue(0);
      bffb.b(this.a).setMaxValue(bffb.b(this.a));
      return;
    }
    bffb.b(this.a).setMinValue(0);
    bffb.b(this.a).setMaxValue(59);
    bffb.b(this.a, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bffc
 * JD-Core Version:    0.7.0.1
 */