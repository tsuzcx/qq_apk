import android.os.Handler;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.widget.XEditTextEx;

class amov
  implements View.OnClickListener
{
  amov(amos paramamos, String paramString) {}
  
  public void onClick(View paramView)
  {
    amos.a(this.jdField_a_of_type_Amos).removeCallbacks(amos.a(this.jdField_a_of_type_Amos));
    amos.a(this.jdField_a_of_type_Amos).run();
    int i = amos.a(this.jdField_a_of_type_Amos).getSelectionStart();
    paramView = amos.a(this.jdField_a_of_type_Amos).getEditableText();
    if ((i < 0) || (i >= paramView.length()))
    {
      paramView.append(this.jdField_a_of_type_JavaLangString);
      return;
    }
    paramView.insert(i, this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     amov
 * JD-Core Version:    0.7.0.1
 */