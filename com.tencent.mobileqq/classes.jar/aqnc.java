import android.os.Handler;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XEditTextEx;

class aqnc
  implements View.OnClickListener
{
  aqnc(aqmz paramaqmz, String paramString) {}
  
  public void onClick(View paramView)
  {
    aqmz.a(this.jdField_a_of_type_Aqmz).removeCallbacks(aqmz.a(this.jdField_a_of_type_Aqmz));
    aqmz.a(this.jdField_a_of_type_Aqmz).run();
    int i = aqmz.a(this.jdField_a_of_type_Aqmz).input.getSelectionStart();
    Editable localEditable = aqmz.a(this.jdField_a_of_type_Aqmz).input.getEditableText();
    if ((i < 0) || (i >= localEditable.length())) {
      localEditable.append(this.jdField_a_of_type_JavaLangString);
    }
    for (;;)
    {
      bcef.b(aqmz.a(this.jdField_a_of_type_Aqmz).getApp(), "dc00898", "", "", "0X800B22C", "0X800B22C", 0, 0, "", "", "", "");
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localEditable.insert(i, this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqnc
 * JD-Core Version:    0.7.0.1
 */