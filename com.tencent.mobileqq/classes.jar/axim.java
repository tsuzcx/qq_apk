import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.remind.widget.IosTimepicker;

public class axim
  implements View.OnClickListener
{
  public axim(IosTimepicker paramIosTimepicker) {}
  
  public void onClick(View paramView)
  {
    if ((IosTimepicker.a(this.a) != null) && (IosTimepicker.a(this.a).isShowing()))
    {
      IosTimepicker.a(this.a).dismiss();
      IosTimepicker.a(this.a, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     axim
 * JD-Core Version:    0.7.0.1
 */