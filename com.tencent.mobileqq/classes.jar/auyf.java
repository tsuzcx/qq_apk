import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import com.tencent.mobileqq.fragment.SimpleDebugFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class auyf
  implements RadioGroup.OnCheckedChangeListener
{
  public auyf(SimpleDebugFragment paramSimpleDebugFragment, RadioGroup paramRadioGroup) {}
  
  public void onCheckedChanged(RadioGroup paramRadioGroup, int paramInt)
  {
    switch (this.jdField_a_of_type_AndroidWidgetRadioGroup.getCheckedRadioButtonId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onCheckedChanged(paramRadioGroup, paramInt);
      return;
      bdfk.a(0);
      continue;
      bdfk.a(1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auyf
 * JD-Core Version:    0.7.0.1
 */