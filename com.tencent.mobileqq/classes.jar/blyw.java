import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ImageView;

class blyw
  implements TextWatcher
{
  boolean jdField_a_of_type_Boolean = false;
  
  blyw(blys paramblys) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    int j;
    int i;
    int m;
    int k;
    if (paramEditable.length() > 0)
    {
      blys.a(this.jdField_a_of_type_Blys).setVisibility(0);
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
          blys.a(this.jdField_a_of_type_Blys).setVisibility(4);
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
      k += blys.a(this.jdField_a_of_type_Blys, c);
      if ((k > 16) && (!this.jdField_a_of_type_Boolean))
      {
        blys.a(this.jdField_a_of_type_Blys).removeTextChangedListener(this);
        if (n == 0) {
          blys.a(this.jdField_a_of_type_Blys).setText(paramEditable.insert(m, "\r\n"));
        }
        for (;;)
        {
          blys.a(this.jdField_a_of_type_Blys).setSelection(paramEditable.length());
          this.jdField_a_of_type_Boolean = true;
          blys.a(this.jdField_a_of_type_Blys).addTextChangedListener(this);
          return;
          blys.a(this.jdField_a_of_type_Blys).setText(paramEditable.insert(i, "\r\n"));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blyw
 * JD-Core Version:    0.7.0.1
 */