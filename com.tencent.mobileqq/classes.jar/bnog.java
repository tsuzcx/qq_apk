import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ImageView;

class bnog
  implements TextWatcher
{
  boolean jdField_a_of_type_Boolean = false;
  
  bnog(bnoc parambnoc) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    int j;
    int i;
    int m;
    int k;
    if (paramEditable.length() > 0)
    {
      bnoc.a(this.jdField_a_of_type_Bnoc).setVisibility(0);
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
          bnoc.a(this.jdField_a_of_type_Bnoc).setVisibility(4);
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
      k += bnoc.a(this.jdField_a_of_type_Bnoc, c);
      if ((k > 16) && (!this.jdField_a_of_type_Boolean))
      {
        bnoc.a(this.jdField_a_of_type_Bnoc).removeTextChangedListener(this);
        if (n == 0) {
          bnoc.a(this.jdField_a_of_type_Bnoc).setText(paramEditable.insert(m, "\r\n"));
        }
        for (;;)
        {
          bnoc.a(this.jdField_a_of_type_Bnoc).setSelection(paramEditable.length());
          this.jdField_a_of_type_Boolean = true;
          bnoc.a(this.jdField_a_of_type_Bnoc).addTextChangedListener(this);
          return;
          bnoc.a(this.jdField_a_of_type_Bnoc).setText(paramEditable.insert(i, "\r\n"));
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
 * Qualified Name:     bnog
 * JD-Core Version:    0.7.0.1
 */