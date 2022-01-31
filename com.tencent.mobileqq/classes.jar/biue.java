import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ImageView;

class biue
  implements TextWatcher
{
  boolean jdField_a_of_type_Boolean = false;
  
  biue(biua parambiua) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    int j;
    int i;
    int m;
    int k;
    if (paramEditable.length() > 0)
    {
      biua.a(this.jdField_a_of_type_Biua).setVisibility(0);
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
          biua.a(this.jdField_a_of_type_Biua).setVisibility(4);
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
      k += biua.a(this.jdField_a_of_type_Biua, c);
      if ((k > 16) && (!this.jdField_a_of_type_Boolean))
      {
        biua.a(this.jdField_a_of_type_Biua).removeTextChangedListener(this);
        if (n == 0) {
          biua.a(this.jdField_a_of_type_Biua).setText(paramEditable.insert(m, "\r\n"));
        }
        for (;;)
        {
          biua.a(this.jdField_a_of_type_Biua).setSelection(paramEditable.length());
          this.jdField_a_of_type_Boolean = true;
          biua.a(this.jdField_a_of_type_Biua).addTextChangedListener(this);
          return;
          biua.a(this.jdField_a_of_type_Biua).setText(paramEditable.insert(i, "\r\n"));
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
 * Qualified Name:     biue
 * JD-Core Version:    0.7.0.1
 */