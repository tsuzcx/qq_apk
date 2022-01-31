import android.os.Handler;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.widget.XEditTextEx;

class anfh
  implements View.OnClickListener
{
  anfh(anfe paramanfe, String paramString) {}
  
  public void onClick(View paramView)
  {
    anfe.a(this.jdField_a_of_type_Anfe).removeCallbacks(anfe.a(this.jdField_a_of_type_Anfe));
    anfe.a(this.jdField_a_of_type_Anfe).run();
    int i = anfe.a(this.jdField_a_of_type_Anfe).getSelectionStart();
    paramView = anfe.a(this.jdField_a_of_type_Anfe).getEditableText();
    if ((i < 0) || (i >= paramView.length()))
    {
      paramView.append(this.jdField_a_of_type_JavaLangString);
      return;
    }
    paramView.insert(i, this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     anfh
 * JD-Core Version:    0.7.0.1
 */