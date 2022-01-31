import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ImageView;

class bhuc
  implements TextWatcher
{
  boolean jdField_a_of_type_Boolean = false;
  
  bhuc(bhty parambhty) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    int j;
    int i;
    int m;
    int k;
    if (paramEditable.length() > 0)
    {
      bhty.a(this.jdField_a_of_type_Bhty).setVisibility(0);
      j = 1;
      i = 0;
      m = 0;
      k = 0;
    }
    char c;
    label55:
    int n;
    for (;;)
    {
      if (i < paramEditable.length())
      {
        c = paramEditable.charAt(i);
        if (c == '\n')
        {
          return;
          bhty.a(this.jdField_a_of_type_Bhty).setVisibility(4);
          j = 1;
          i = 0;
          m = 0;
          k = 0;
        }
        else
        {
          n = j;
          if (c == ' ')
          {
            if (j == 0) {
              break label244;
            }
            n = 0;
            m = i;
          }
        }
      }
    }
    for (;;)
    {
      k += bhty.a(this.jdField_a_of_type_Bhty, c);
      if ((k > 16) && (!this.jdField_a_of_type_Boolean))
      {
        bhty.a(this.jdField_a_of_type_Bhty).removeTextChangedListener(this);
        if (n == 0) {
          bhty.a(this.jdField_a_of_type_Bhty).setText(paramEditable.insert(m, "\r\n"));
        }
        for (;;)
        {
          bhty.a(this.jdField_a_of_type_Bhty).setSelection(paramEditable.length());
          this.jdField_a_of_type_Boolean = true;
          bhty.a(this.jdField_a_of_type_Bhty).addTextChangedListener(this);
          return;
          bhty.a(this.jdField_a_of_type_Bhty).setText(paramEditable.insert(i, "\r\n"));
        }
      }
      i += 1;
      j = n;
      break;
      if (k > 16) {
        break label55;
      }
      this.jdField_a_of_type_Boolean = false;
      return;
      label244:
      m = i;
      n = j;
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bhuc
 * JD-Core Version:    0.7.0.1
 */