import android.text.Editable;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

class bgfr
  implements TextView.OnEditorActionListener
{
  bgfr(bgfo parambgfo, bgfu parambgfu) {}
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool2 = false;
    boolean bool1;
    if ((paramInt != 4) && (paramInt != 6))
    {
      bool1 = bool2;
      if (paramKeyEvent != null)
      {
        bool1 = bool2;
        if (66 == paramKeyEvent.getKeyCode())
        {
          bool1 = bool2;
          if (paramKeyEvent.getAction() != 0) {}
        }
      }
    }
    else
    {
      paramTextView = this.jdField_a_of_type_Bgfu.a.getEditableText().toString();
      paramInt = this.jdField_a_of_type_Bgfu.a.getSelectionStart();
      paramTextView = paramTextView.substring(0, paramInt);
      paramTextView = this.jdField_a_of_type_Bgfo.a(paramTextView);
      bool1 = bool2;
      if (!TextUtils.isEmpty(paramTextView))
      {
        this.jdField_a_of_type_Bgfu.a.getEditableText().replace(paramInt, paramInt, "\n" + paramTextView);
        this.jdField_a_of_type_Bgfu.a.setSelection(paramTextView.length() + paramInt + 1);
        bool1 = true;
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgfr
 * JD-Core Version:    0.7.0.1
 */