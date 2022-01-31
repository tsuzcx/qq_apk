import android.os.Handler;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.widget.XEditTextEx;

class anex
  implements View.OnClickListener
{
  anex(aneu paramaneu, String paramString) {}
  
  public void onClick(View paramView)
  {
    aneu.a(this.jdField_a_of_type_Aneu).removeCallbacks(aneu.a(this.jdField_a_of_type_Aneu));
    aneu.a(this.jdField_a_of_type_Aneu).run();
    int i = aneu.a(this.jdField_a_of_type_Aneu).a.getSelectionStart();
    paramView = aneu.a(this.jdField_a_of_type_Aneu).a.getEditableText();
    if ((i < 0) || (i >= paramView.length()))
    {
      paramView.append(this.jdField_a_of_type_JavaLangString);
      return;
    }
    paramView.insert(i, this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     anex
 * JD-Core Version:    0.7.0.1
 */