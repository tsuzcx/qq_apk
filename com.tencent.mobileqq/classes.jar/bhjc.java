import android.widget.DatePicker;
import android.widget.DatePicker.OnDateChangedListener;

class bhjc
  implements DatePicker.OnDateChangedListener
{
  bhjc(bhjb parambhjb) {}
  
  public void onDateChanged(DatePicker paramDatePicker, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramDatePicker != null)
    {
      bhjb.a(this.a, paramDatePicker.getYear());
      bhjb.b(this.a, paramDatePicker.getMonth());
      bhjb.c(this.a, paramDatePicker.getDayOfMonth());
      return;
    }
    bhjb.a(this.a, paramInt1);
    bhjb.b(this.a, paramInt2);
    bhjb.c(this.a, paramInt3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhjc
 * JD-Core Version:    0.7.0.1
 */