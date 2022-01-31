import android.text.InputFilter.LengthFilter;
import android.text.Spanned;

class bjru
  extends InputFilter.LengthFilter
{
  boolean jdField_a_of_type_Boolean = true;
  
  bjru(bjrt parambjrt, int paramInt1, int paramInt2)
  {
    super(paramInt1);
  }
  
  public CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
  {
    if (this.jdField_a_of_type_Int - (paramSpanned.length() - (paramInt4 - paramInt3)) <= 0)
    {
      if (this.jdField_a_of_type_Boolean)
      {
        vel.a("textEdit", "overLimit", bjrh.b(this.jdField_a_of_type_Bjrt.a), 0, new String[0]);
        this.jdField_a_of_type_Boolean = false;
      }
      if (bjrh.a(this.jdField_a_of_type_Bjrt.a) != null) {
        bcpw.a(this.jdField_a_of_type_Bjrt.getContext(), ajyc.a(2131714426) + bjrh.a(this.jdField_a_of_type_Bjrt.a).c + ajyc.a(2131714412), 0).a();
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
 * Qualified Name:     bjru
 * JD-Core Version:    0.7.0.1
 */