import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.qphone.base.util.QLog;

class bacf
  implements TextWatcher
{
  bacf(baca parambaca, bacg parambacg, babb parambabb) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    int i;
    int k;
    if (this.jdField_a_of_type_Baca.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.b() != 0)
    {
      int j = this.jdField_a_of_type_Baca.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.b();
      i = this.jdField_a_of_type_Baca.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.c();
      j -= i;
      k = paramInt3 - paramInt2;
      if (k > j)
      {
        bcpw.a(baca.a(this.jdField_a_of_type_Baca), "最多可以输入500个字", 1).a();
        paramInt2 = j + paramInt2;
        this.jdField_a_of_type_Bacg.a.removeTextChangedListener(this);
        CharSequence localCharSequence = paramCharSequence.subSequence(0, paramInt1 + paramInt2);
        paramCharSequence = paramCharSequence.subSequence(paramInt1 + paramInt3, paramCharSequence.length());
        paramCharSequence = localCharSequence.toString() + paramCharSequence.toString();
        this.jdField_a_of_type_Bacg.a.setText(paramCharSequence);
        this.jdField_a_of_type_Bacg.a.addTextChangedListener(this);
        this.jdField_a_of_type_Bacg.a.setSelection(paramInt1 + paramInt2);
        this.jdField_a_of_type_Baca.jdField_a_of_type_Babp.a(i, i + paramInt2);
        this.jdField_a_of_type_Babb.jdField_a_of_type_Int = (paramInt2 + paramInt1);
        this.jdField_a_of_type_Babb.b(paramCharSequence);
      }
    }
    for (;;)
    {
      QLog.i("xmediaEditor", 1, "onTextChanged, mData.position:" + this.jdField_a_of_type_Babb.c + ", text:" + this.jdField_a_of_type_Babb.jdField_a_of_type_JavaLangString + ",Listener:" + toString());
      return;
      this.jdField_a_of_type_Baca.jdField_a_of_type_Babp.a(i, i + k);
      this.jdField_a_of_type_Babb.jdField_a_of_type_Int = (paramInt1 + k);
      this.jdField_a_of_type_Babb.b(paramCharSequence.toString());
      continue;
      i = this.jdField_a_of_type_Baca.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.c();
      this.jdField_a_of_type_Baca.jdField_a_of_type_Babp.a(i, i + paramInt3 - paramInt2);
      this.jdField_a_of_type_Babb.jdField_a_of_type_Int = (paramInt1 + paramInt3);
      this.jdField_a_of_type_Babb.b(paramCharSequence.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bacf
 * JD-Core Version:    0.7.0.1
 */