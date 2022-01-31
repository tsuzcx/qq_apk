import android.widget.DatePicker;
import android.widget.DatePicker.OnDateChangedListener;

class bfec
  implements DatePicker.OnDateChangedListener
{
  bfec(bfeb parambfeb) {}
  
  public void onDateChanged(DatePicker paramDatePicker, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramDatePicker != null)
    {
      bfeb.a(this.a, paramDatePicker.getYear());
      bfeb.b(this.a, paramDatePicker.getMonth());
      bfeb.c(this.a, paramDatePicker.getDayOfMonth());
      return;
    }
    bfeb.a(this.a, paramInt1);
    bfeb.b(this.a, paramInt2);
    bfeb.c(this.a, paramInt3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bfec
 * JD-Core Version:    0.7.0.1
 */