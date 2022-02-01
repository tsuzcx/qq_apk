import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class blqh
  implements RadioGroup.OnCheckedChangeListener
{
  blqh(blqf paramblqf) {}
  
  public void onCheckedChanged(RadioGroup paramRadioGroup, int paramInt)
  {
    blqf.a(this.a, paramInt);
    EventCollector.getInstance().onCheckedChanged(paramRadioGroup, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blqh
 * JD-Core Version:    0.7.0.1
 */