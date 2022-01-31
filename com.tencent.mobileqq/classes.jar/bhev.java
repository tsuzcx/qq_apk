import android.widget.DatePicker;
import android.widget.DatePicker.OnDateChangedListener;

class bhev
  implements DatePicker.OnDateChangedListener
{
  bhev(bheu parambheu) {}
  
  public void onDateChanged(DatePicker paramDatePicker, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramDatePicker != null)
    {
      bheu.a(this.a, paramDatePicker.getYear());
      bheu.b(this.a, paramDatePicker.getMonth());
      bheu.c(this.a, paramDatePicker.getDayOfMonth());
      return;
    }
    bheu.a(this.a, paramInt1);
    bheu.b(this.a, paramInt2);
    bheu.c(this.a, paramInt3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhev
 * JD-Core Version:    0.7.0.1
 */