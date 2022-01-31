import android.widget.DatePicker;
import android.widget.DatePicker.OnDateChangedListener;

class bdxk
  implements DatePicker.OnDateChangedListener
{
  bdxk(bdxj parambdxj) {}
  
  public void onDateChanged(DatePicker paramDatePicker, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramDatePicker != null)
    {
      bdxj.a(this.a, paramDatePicker.getYear());
      bdxj.b(this.a, paramDatePicker.getMonth());
      bdxj.c(this.a, paramDatePicker.getDayOfMonth());
      return;
    }
    bdxj.a(this.a, paramInt1);
    bdxj.b(this.a, paramInt2);
    bdxj.c(this.a, paramInt3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdxk
 * JD-Core Version:    0.7.0.1
 */