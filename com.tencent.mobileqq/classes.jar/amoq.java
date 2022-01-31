import android.os.Handler;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.widget.XEditTextEx;

class amoq
  implements View.OnClickListener
{
  amoq(amon paramamon, String paramString) {}
  
  public void onClick(View paramView)
  {
    amon.a(this.jdField_a_of_type_Amon).removeCallbacks(amon.a(this.jdField_a_of_type_Amon));
    amon.a(this.jdField_a_of_type_Amon).run();
    int i = amon.a(this.jdField_a_of_type_Amon).a.getSelectionStart();
    paramView = amon.a(this.jdField_a_of_type_Amon).a.getEditableText();
    if ((i < 0) || (i >= paramView.length()))
    {
      paramView.append(this.jdField_a_of_type_JavaLangString);
      return;
    }
    paramView.insert(i, this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     amoq
 * JD-Core Version:    0.7.0.1
 */