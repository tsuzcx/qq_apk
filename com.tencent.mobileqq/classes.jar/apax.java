import android.os.Handler;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.widget.XEditTextEx;

class apax
  implements View.OnClickListener
{
  apax(apau paramapau, String paramString) {}
  
  public void onClick(View paramView)
  {
    apau.a(this.jdField_a_of_type_Apau).removeCallbacks(apau.a(this.jdField_a_of_type_Apau));
    apau.a(this.jdField_a_of_type_Apau).run();
    int i = apau.a(this.jdField_a_of_type_Apau).getSelectionStart();
    paramView = apau.a(this.jdField_a_of_type_Apau).getEditableText();
    if ((i < 0) || (i >= paramView.length()))
    {
      paramView.append(this.jdField_a_of_type_JavaLangString);
      return;
    }
    paramView.insert(i, this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apax
 * JD-Core Version:    0.7.0.1
 */