import android.os.Handler;
import com.tencent.widget.TCWNumberPicker;

public class amlf
  implements Runnable
{
  public amlf(TCWNumberPicker paramTCWNumberPicker) {}
  
  public void run()
  {
    if (TCWNumberPicker.a(this.a))
    {
      TCWNumberPicker.a(this.a, TCWNumberPicker.a(this.a) + 1);
      TCWNumberPicker.a(this.a).postDelayed(this, TCWNumberPicker.a(this.a));
    }
    while (!TCWNumberPicker.b(this.a)) {
      return;
    }
    TCWNumberPicker.a(this.a, TCWNumberPicker.a(this.a) - 1);
    TCWNumberPicker.a(this.a).postDelayed(this, TCWNumberPicker.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     amlf
 * JD-Core Version:    0.7.0.1
 */