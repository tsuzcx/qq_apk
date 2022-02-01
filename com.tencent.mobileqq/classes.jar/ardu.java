import android.os.Handler;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XEditTextEx;

class ardu
  implements View.OnClickListener
{
  ardu(ardr paramardr, String paramString) {}
  
  public void onClick(View paramView)
  {
    ardr.a(this.jdField_a_of_type_Ardr).removeCallbacks(ardr.a(this.jdField_a_of_type_Ardr));
    ardr.a(this.jdField_a_of_type_Ardr).run();
    int i = ardr.a(this.jdField_a_of_type_Ardr).getSelectionStart();
    Editable localEditable = ardr.a(this.jdField_a_of_type_Ardr).getEditableText();
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
 * Qualified Name:     ardu
 * JD-Core Version:    0.7.0.1
 */