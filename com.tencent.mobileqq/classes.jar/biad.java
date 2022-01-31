import android.text.InputFilter.LengthFilter;
import android.text.Spanned;

class biad
  extends InputFilter.LengthFilter
{
  boolean jdField_a_of_type_Boolean = true;
  
  biad(biac parambiac, int paramInt1, int paramInt2)
  {
    super(paramInt1);
  }
  
  public CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
  {
    if (this.jdField_a_of_type_Int - (paramSpanned.length() - (paramInt4 - paramInt3)) <= 0)
    {
      if (this.jdField_a_of_type_Boolean)
      {
        urp.a("textEdit", "overLimit", bhzq.b(this.jdField_a_of_type_Biac.a), 0, new String[0]);
        this.jdField_a_of_type_Boolean = false;
      }
      if (bhzq.a(this.jdField_a_of_type_Biac.a) != null) {
        bbmy.a(this.jdField_a_of_type_Biac.getContext(), ajjy.a(2131648637) + bhzq.a(this.jdField_a_of_type_Biac.a).c + ajjy.a(2131648623), 0).a();
      }
    }
    for (;;)
    {
      return super.filter(paramCharSequence, paramInt1, paramInt2, paramSpanned, paramInt3, paramInt4);
      this.jdField_a_of_type_Boolean = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     biad
 * JD-Core Version:    0.7.0.1
 */