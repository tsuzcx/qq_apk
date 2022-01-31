import android.widget.DatePicker;
import android.widget.DatePicker.OnDateChangedListener;

class bfet
  implements DatePicker.OnDateChangedListener
{
  bfet(bfes parambfes) {}
  
  public void onDateChanged(DatePicker paramDatePicker, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramDatePicker != null)
    {
      bfes.a(this.a, paramDatePicker.getYear());
      bfes.b(this.a, paramDatePicker.getMonth());
      bfes.c(this.a, paramDatePicker.getDayOfMonth());
      return;
    }
    bfes.a(this.a, paramInt1);
    bfes.b(this.a, paramInt2);
    bfes.c(this.a, paramInt3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bfet
 * JD-Core Version:    0.7.0.1
 */