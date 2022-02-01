import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ImageView;

class bour
  implements TextWatcher
{
  boolean jdField_a_of_type_Boolean = false;
  
  bour(boun paramboun) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    int j;
    int i;
    int m;
    int k;
    if (paramEditable.length() > 0)
    {
      boun.a(this.jdField_a_of_type_Boun).setVisibility(0);
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
          boun.a(this.jdField_a_of_type_Boun).setVisibility(4);
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
      k += boun.a(this.jdField_a_of_type_Boun, c);
      if ((k > 16) && (!this.jdField_a_of_type_Boolean))
      {
        boun.a(this.jdField_a_of_type_Boun).removeTextChangedListener(this);
        if (n == 0) {
          boun.a(this.jdField_a_of_type_Boun).setText(paramEditable.insert(m, "\r\n"));
        }
        for (;;)
        {
          boun.a(this.jdField_a_of_type_Boun).setSelection(paramEditable.length());
          this.jdField_a_of_type_Boolean = true;
          boun.a(this.jdField_a_of_type_Boun).addTextChangedListener(this);
          return;
          boun.a(this.jdField_a_of_type_Boun).setText(paramEditable.insert(i, "\r\n"));
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
 * Qualified Name:     bour
 * JD-Core Version:    0.7.0.1
 */