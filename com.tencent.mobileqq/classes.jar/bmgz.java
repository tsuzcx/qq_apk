import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bmgz
  implements RadioGroup.OnCheckedChangeListener
{
  bmgz(bmgx parambmgx) {}
  
  public void onCheckedChanged(RadioGroup paramRadioGroup, int paramInt)
  {
    bmgx.a(this.a, paramInt);
    EventCollector.getInstance().onCheckedChanged(paramRadioGroup, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmgz
 * JD-Core Version:    0.7.0.1
 */