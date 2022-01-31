import android.os.Handler;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.widget.XEditTextEx;

class anfc
  implements View.OnClickListener
{
  anfc(anez paramanez, String paramString) {}
  
  public void onClick(View paramView)
  {
    anez.a(this.jdField_a_of_type_Anez).removeCallbacks(anez.a(this.jdField_a_of_type_Anez));
    anez.a(this.jdField_a_of_type_Anez).run();
    int i = anez.a(this.jdField_a_of_type_Anez).getSelectionStart();
    paramView = anez.a(this.jdField_a_of_type_Anez).getEditableText();
    if ((i < 0) || (i >= paramView.length()))
    {
      paramView.append(this.jdField_a_of_type_JavaLangString);
      return;
    }
    paramView.insert(i, this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     anfc
 * JD-Core Version:    0.7.0.1
 */