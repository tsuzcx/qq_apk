import android.os.Handler;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XEditTextEx;

class ardp
  implements View.OnClickListener
{
  ardp(ardm paramardm, String paramString) {}
  
  public void onClick(View paramView)
  {
    ardm.a(this.jdField_a_of_type_Ardm).removeCallbacks(ardm.a(this.jdField_a_of_type_Ardm));
    ardm.a(this.jdField_a_of_type_Ardm).run();
    int i = ardm.a(this.jdField_a_of_type_Ardm).a.getSelectionStart();
    Editable localEditable = ardm.a(this.jdField_a_of_type_Ardm).a.getEditableText();
    if ((i < 0) || (i >= localEditable.length())) {
      localEditable.append(this.jdField_a_of_type_JavaLangString);
    }
    for (;;)
    {
      bcst.b(ardm.a(this.jdField_a_of_type_Ardm).a(), "dc00898", "", "", "0X800B22C", "0X800B22C", 0, 0, "", "", "", "");
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localEditable.insert(i, this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ardp
 * JD-Core Version:    0.7.0.1
 */