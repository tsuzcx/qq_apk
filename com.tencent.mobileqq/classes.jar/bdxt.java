import android.widget.NumberPicker;
import android.widget.TimePicker;
import android.widget.TimePicker.OnTimeChangedListener;

class bdxt
  implements TimePicker.OnTimeChangedListener
{
  bdxt(bdxs parambdxs) {}
  
  public void onTimeChanged(TimePicker paramTimePicker, int paramInt1, int paramInt2)
  {
    bdxs.a(this.a, paramInt1);
    if (paramInt1 == bdxs.a(this.a).getMinValue())
    {
      bdxs.b(this.a).setMinValue(bdxs.a(this.a));
      bdxs.b(this.a).setMaxValue(59);
      return;
    }
    if (paramInt1 == bdxs.a(this.a).getMaxValue())
    {
      bdxs.b(this.a).setMinValue(0);
      bdxs.b(this.a).setMaxValue(bdxs.b(this.a));
      return;
    }
    bdxs.b(this.a).setMinValue(0);
    bdxs.b(this.a).setMaxValue(59);
    bdxs.b(this.a, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdxt
 * JD-Core Version:    0.7.0.1
 */