import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import com.tencent.mobileqq.fragment.SimpleDebugFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class attf
  implements RadioGroup.OnCheckedChangeListener
{
  public attf(SimpleDebugFragment paramSimpleDebugFragment, RadioGroup paramRadioGroup) {}
  
  public void onCheckedChanged(RadioGroup paramRadioGroup, int paramInt)
  {
    switch (this.jdField_a_of_type_AndroidWidgetRadioGroup.getCheckedRadioButtonId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onCheckedChanged(paramRadioGroup, paramInt);
      return;
      bbyp.a(0);
      continue;
      bbyp.a(1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     attf
 * JD-Core Version:    0.7.0.1
 */