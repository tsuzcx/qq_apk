import android.os.Handler;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.widget.XEditTextEx;

class aowj
  implements View.OnClickListener
{
  aowj(aowg paramaowg, String paramString) {}
  
  public void onClick(View paramView)
  {
    aowg.a(this.jdField_a_of_type_Aowg).removeCallbacks(aowg.a(this.jdField_a_of_type_Aowg));
    aowg.a(this.jdField_a_of_type_Aowg).run();
    int i = aowg.a(this.jdField_a_of_type_Aowg).a.getSelectionStart();
    paramView = aowg.a(this.jdField_a_of_type_Aowg).a.getEditableText();
    if ((i < 0) || (i >= paramView.length()))
    {
      paramView.append(this.jdField_a_of_type_JavaLangString);
      return;
    }
    paramView.insert(i, this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aowj
 * JD-Core Version:    0.7.0.1
 */