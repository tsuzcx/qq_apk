import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class atwd
  implements CompoundButton.OnCheckedChangeListener
{
  atwd(atwa paramatwa, String paramString) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    blec localblec = blec.a();
    String str = this.jdField_a_of_type_JavaLangString;
    if (paramBoolean) {}
    for (int i = 0;; i = 1)
    {
      localblec.b(str, i);
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atwd
 * JD-Core Version:    0.7.0.1
 */