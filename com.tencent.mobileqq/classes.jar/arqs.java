import android.os.Handler;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XEditTextEx;

class arqs
  implements View.OnClickListener
{
  arqs(arqp paramarqp, String paramString) {}
  
  public void onClick(View paramView)
  {
    arqp.a(this.jdField_a_of_type_Arqp).removeCallbacks(arqp.a(this.jdField_a_of_type_Arqp));
    arqp.a(this.jdField_a_of_type_Arqp).run();
    int i = arqp.a(this.jdField_a_of_type_Arqp).getSelectionStart();
    Editable localEditable = arqp.a(this.jdField_a_of_type_Arqp).getEditableText();
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
 * Qualified Name:     arqs
 * JD-Core Version:    0.7.0.1
 */