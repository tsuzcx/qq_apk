import android.os.Handler;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.widget.XEditTextEx;

class apas
  implements View.OnClickListener
{
  apas(apap paramapap, String paramString) {}
  
  public void onClick(View paramView)
  {
    apap.a(this.jdField_a_of_type_Apap).removeCallbacks(apap.a(this.jdField_a_of_type_Apap));
    apap.a(this.jdField_a_of_type_Apap).run();
    int i = apap.a(this.jdField_a_of_type_Apap).a.getSelectionStart();
    paramView = apap.a(this.jdField_a_of_type_Apap).a.getEditableText();
    if ((i < 0) || (i >= paramView.length()))
    {
      paramView.append(this.jdField_a_of_type_JavaLangString);
      return;
    }
    paramView.insert(i, this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apas
 * JD-Core Version:    0.7.0.1
 */