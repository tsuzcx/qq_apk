import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bmrj
  implements RadioGroup.OnCheckedChangeListener
{
  bmrj(bmrh parambmrh) {}
  
  public void onCheckedChanged(RadioGroup paramRadioGroup, int paramInt)
  {
    bmrh.a(this.a, paramInt);
    EventCollector.getInstance().onCheckedChanged(paramRadioGroup, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmrj
 * JD-Core Version:    0.7.0.1
 */