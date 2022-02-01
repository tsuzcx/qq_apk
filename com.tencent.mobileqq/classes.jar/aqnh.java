import android.os.Handler;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XEditTextEx;

class aqnh
  implements View.OnClickListener
{
  aqnh(aqne paramaqne, String paramString) {}
  
  public void onClick(View paramView)
  {
    aqne.a(this.jdField_a_of_type_Aqne).removeCallbacks(aqne.a(this.jdField_a_of_type_Aqne));
    aqne.a(this.jdField_a_of_type_Aqne).run();
    int i = aqne.a(this.jdField_a_of_type_Aqne).getSelectionStart();
    Editable localEditable = aqne.a(this.jdField_a_of_type_Aqne).getEditableText();
    if ((i < 0) || (i >= localEditable.length())) {
      localEditable.append(this.jdField_a_of_type_JavaLangString);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localEditable.insert(i, this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqnh
 * JD-Core Version:    0.7.0.1
 */