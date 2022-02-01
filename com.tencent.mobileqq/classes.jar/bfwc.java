import android.text.Editable;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

class bfwc
  implements TextView.OnEditorActionListener
{
  bfwc(bfvz parambfvz, bfwf parambfwf) {}
  
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
      paramTextView = this.jdField_a_of_type_Bfwf.a.getEditableText().toString();
      paramInt = this.jdField_a_of_type_Bfwf.a.getSelectionStart();
      paramTextView = paramTextView.substring(0, paramInt);
      paramTextView = this.jdField_a_of_type_Bfvz.a(paramTextView);
      bool1 = bool2;
      if (!TextUtils.isEmpty(paramTextView))
      {
        this.jdField_a_of_type_Bfwf.a.getEditableText().replace(paramInt, paramInt, "\n" + paramTextView);
        this.jdField_a_of_type_Bfwf.a.setSelection(paramTextView.length() + paramInt + 1);
        bool1 = true;
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfwc
 * JD-Core Version:    0.7.0.1
 */