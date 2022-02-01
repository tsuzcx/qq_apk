import android.text.Editable;
import android.widget.EditText;
import com.tencent.mobileqq.data.EmoticonPackage;

final class bgdl
  implements avtb<EmoticonPackage>
{
  bgdl(int paramInt1, int paramInt2, EditText paramEditText) {}
  
  public void a(EmoticonPackage paramEmoticonPackage)
  {
    int j = 0;
    char[] arrayOfChar1 = aqyy.b(this.jdField_a_of_type_Int, this.b);
    char[] arrayOfChar2 = new char[7];
    arrayOfChar2[0] = '<';
    arrayOfChar2[1] = '$';
    arrayOfChar2[2] = arrayOfChar1[0];
    arrayOfChar2[3] = arrayOfChar1[1];
    arrayOfChar2[4] = arrayOfChar1[2];
    arrayOfChar2[5] = arrayOfChar1[3];
    arrayOfChar2[6] = '>';
    int i = j;
    if (paramEmoticonPackage != null)
    {
      i = j;
      if (paramEmoticonPackage.isAPNG == 2)
      {
        arrayOfChar2[1] = 'ǿ';
        i = j;
      }
    }
    while (i < arrayOfChar2.length)
    {
      if (arrayOfChar2[i] == 0) {
        arrayOfChar2[i] = 'Ā';
      }
      i += 1;
    }
    i = this.jdField_a_of_type_AndroidWidgetEditText.getSelectionStart();
    j = this.jdField_a_of_type_AndroidWidgetEditText.getSelectionEnd();
    this.jdField_a_of_type_AndroidWidgetEditText.getEditableText().replace(i, j, String.valueOf(arrayOfChar2));
    this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgdl
 * JD-Core Version:    0.7.0.1
 */