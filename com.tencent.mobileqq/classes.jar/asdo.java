import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import com.tencent.mobileqq.freshnews.BlockableEditTextView;

public class asdo
  implements TextWatcher
{
  public int a;
  public CharSequence a;
  public boolean a;
  int b = -1;
  int c = -1;
  
  public asdo(BlockableEditTextView paramBlockableEditTextView)
  {
    this.jdField_a_of_type_JavaLangCharSequence = "";
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    if ((this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_Int == 0)) {}
    while (this.jdField_a_of_type_Int >= 0) {
      return;
    }
    if (BlockableEditTextView.a(this.jdField_a_of_type_ComTencentMobileqqFreshnewsBlockableEditTextView) == 2)
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqFreshnewsBlockableEditTextView.setText(this.jdField_a_of_type_JavaLangCharSequence);
      this.jdField_a_of_type_Boolean = false;
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqFreshnewsBlockableEditTextView.setText(TextUtils.concat(new CharSequence[] { this.jdField_a_of_type_JavaLangCharSequence.subSequence(this.c, this.jdField_a_of_type_JavaLangCharSequence.length()), this.jdField_a_of_type_JavaLangCharSequence.subSequence(0, this.b) }));
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqFreshnewsBlockableEditTextView.setSelection(this.b);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((this.jdField_a_of_type_Boolean) || (BlockableEditTextView.a(this.jdField_a_of_type_ComTencentMobileqqFreshnewsBlockableEditTextView) == 0)) {}
    do
    {
      Editable localEditable;
      asdp[] arrayOfasdp;
      do
      {
        do
        {
          do
          {
            return;
            this.jdField_a_of_type_Int = 0;
          } while (paramInt3 == paramInt2);
          localEditable = this.jdField_a_of_type_ComTencentMobileqqFreshnewsBlockableEditTextView.getEditableText();
        } while (localEditable == null);
        arrayOfasdp = (asdp[])localEditable.getSpans(paramInt1, paramInt1, asdp.class);
      } while ((arrayOfasdp == null) || (arrayOfasdp.length <= 0));
      this.b = localEditable.getSpanStart(arrayOfasdp[0]);
      this.c = localEditable.getSpanEnd(arrayOfasdp[0]);
    } while ((this.c < 0) || (this.c < this.b) || (paramInt2 <= paramInt3) || (BlockableEditTextView.a(this.jdField_a_of_type_ComTencentMobileqqFreshnewsBlockableEditTextView) == 0) || (paramInt1 == this.b) || (paramInt1 == this.c));
    this.jdField_a_of_type_JavaLangCharSequence = new SpannableStringBuilder(paramCharSequence).subSequence(0, paramCharSequence.length());
    this.jdField_a_of_type_Int = -1;
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asdo
 * JD-Core Version:    0.7.0.1
 */