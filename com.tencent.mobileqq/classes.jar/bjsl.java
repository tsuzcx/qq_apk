import android.text.InputFilter.LengthFilter;
import android.text.Spanned;

class bjsl
  extends InputFilter.LengthFilter
{
  boolean jdField_a_of_type_Boolean = true;
  
  bjsl(bjsk parambjsk, int paramInt1, int paramInt2)
  {
    super(paramInt1);
  }
  
  public CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
  {
    if (this.jdField_a_of_type_Int - (paramSpanned.length() - (paramInt4 - paramInt3)) <= 0)
    {
      if (this.jdField_a_of_type_Boolean)
      {
        vei.a("textEdit", "overLimit", bjry.b(this.jdField_a_of_type_Bjsk.a), 0, new String[0]);
        this.jdField_a_of_type_Boolean = false;
      }
      if (bjry.a(this.jdField_a_of_type_Bjsk.a) != null) {
        bcql.a(this.jdField_a_of_type_Bjsk.getContext(), ajya.a(2131714437) + bjry.a(this.jdField_a_of_type_Bjsk.a).c + ajya.a(2131714423), 0).a();
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
 * Qualified Name:     bjsl
 * JD-Core Version:    0.7.0.1
 */