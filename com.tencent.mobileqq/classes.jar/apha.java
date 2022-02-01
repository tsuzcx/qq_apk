import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import com.tencent.mobileqq.businessCard.activity.BusinessCardEditActivity;
import com.tencent.mobileqq.businessCard.views.ClearEllipsisEditText;

public class apha
  implements TextWatcher
{
  int jdField_a_of_type_Int;
  EditText jdField_a_of_type_AndroidWidgetEditText;
  String jdField_a_of_type_JavaLangString = "";
  boolean jdField_a_of_type_Boolean = true;
  int b;
  public boolean b;
  
  public apha(BusinessCardEditActivity paramBusinessCardEditActivity, int paramInt, EditText paramEditText)
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidWidgetEditText = paramEditText;
    this.jdField_b_of_type_Int = 0;
  }
  
  public apha(BusinessCardEditActivity paramBusinessCardEditActivity, int paramInt1, EditText paramEditText, int paramInt2)
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_AndroidWidgetEditText = paramEditText;
    this.jdField_b_of_type_Int = paramInt2;
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    int j = 1;
    boolean bool;
    label69:
    int i;
    if ((this.jdField_b_of_type_Int == 1) && (!this.jdField_a_of_type_JavaLangString.equals(paramEditable.toString())))
    {
      if (this.jdField_a_of_type_Boolean)
      {
        bool = this.jdField_b_of_type_Boolean;
        this.jdField_b_of_type_Boolean = bool;
      }
    }
    else
    {
      this.jdField_a_of_type_Boolean = false;
      if (!(this.jdField_a_of_type_AndroidWidgetEditText instanceof ClearEllipsisEditText)) {
        break label155;
      }
      paramEditable = ((ClearEllipsisEditText)this.jdField_a_of_type_AndroidWidgetEditText).a();
      i = paramEditable.length();
      if ((this.jdField_a_of_type_AndroidWidgetEditText.getTag() == null) || (!((String)this.jdField_a_of_type_AndroidWidgetEditText.getTag()).equals("name"))) {
        break label197;
      }
      i = paramEditable.getBytes().length;
    }
    for (;;)
    {
      if (i > this.jdField_a_of_type_Int)
      {
        for (;;)
        {
          if (i <= this.jdField_a_of_type_Int) {
            break label177;
          }
          paramEditable = paramEditable.substring(0, paramEditable.length() - 1);
          if (j != 0)
          {
            i = paramEditable.getBytes().length;
            continue;
            bool = true;
            break;
            label155:
            paramEditable = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
            break label69;
          }
          i = paramEditable.length();
        }
        label177:
        this.jdField_a_of_type_AndroidWidgetEditText.setText(paramEditable);
        this.jdField_a_of_type_AndroidWidgetEditText.setSelection(paramEditable.length());
      }
      return;
      label197:
      j = 0;
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_JavaLangString = paramCharSequence.toString();
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apha
 * JD-Core Version:    0.7.0.1
 */