import android.os.Handler;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.widget.XEditTextEx;

class aowo
  implements View.OnClickListener
{
  aowo(aowl paramaowl, String paramString) {}
  
  public void onClick(View paramView)
  {
    aowl.a(this.jdField_a_of_type_Aowl).removeCallbacks(aowl.a(this.jdField_a_of_type_Aowl));
    aowl.a(this.jdField_a_of_type_Aowl).run();
    int i = aowl.a(this.jdField_a_of_type_Aowl).getSelectionStart();
    paramView = aowl.a(this.jdField_a_of_type_Aowl).getEditableText();
    if ((i < 0) || (i >= paramView.length()))
    {
      paramView.append(this.jdField_a_of_type_JavaLangString);
      return;
    }
    paramView.insert(i, this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aowo
 * JD-Core Version:    0.7.0.1
 */