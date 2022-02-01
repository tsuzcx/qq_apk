import android.os.Handler;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XEditTextEx;

class arqn
  implements View.OnClickListener
{
  arqn(arqk paramarqk, String paramString) {}
  
  public void onClick(View paramView)
  {
    arqk.a(this.jdField_a_of_type_Arqk).removeCallbacks(arqk.a(this.jdField_a_of_type_Arqk));
    arqk.a(this.jdField_a_of_type_Arqk).run();
    int i = arqk.a(this.jdField_a_of_type_Arqk).input.getSelectionStart();
    Editable localEditable = arqk.a(this.jdField_a_of_type_Arqk).input.getEditableText();
    if ((i < 0) || (i >= localEditable.length())) {
      localEditable.append(this.jdField_a_of_type_JavaLangString);
    }
    for (;;)
    {
      bdla.b(arqk.a(this.jdField_a_of_type_Arqk).getApp(), "dc00898", "", "", "0X800B22C", "0X800B22C", 0, 0, "", "", "", "");
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localEditable.insert(i, this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arqn
 * JD-Core Version:    0.7.0.1
 */