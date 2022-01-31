import android.text.InputFilter;
import android.text.Spanned;

class bivc
  implements InputFilter
{
  private int jdField_a_of_type_Int = 32;
  
  public bivc(biur parambiur) {}
  
  public CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
  {
    if (paramCharSequence.equals("\n")) {
      return "";
    }
    for (;;)
    {
      char c;
      if ((paramInt1 <= this.jdField_a_of_type_Int) && (paramInt2 < paramSpanned.length()))
      {
        c = paramSpanned.charAt(paramInt2);
        paramInt1 += biur.a(this.jdField_a_of_type_Biur, c);
        paramInt2 += 1;
      }
      else
      {
        if (paramInt1 > this.jdField_a_of_type_Int) {
          return paramSpanned.subSequence(0, paramInt2 - 1);
        }
        paramInt3 = 0;
        paramInt2 = paramInt1;
        paramInt1 = paramInt3;
        while ((paramInt2 <= this.jdField_a_of_type_Int) && (paramInt1 < paramCharSequence.length()))
        {
          c = paramCharSequence.charAt(paramInt1);
          paramInt2 = biur.a(this.jdField_a_of_type_Biur, c) + paramInt2;
          paramInt1 += 1;
        }
        paramInt3 = paramInt1;
        if (paramInt2 > this.jdField_a_of_type_Int) {
          paramInt3 = paramInt1 - 1;
        }
        return paramCharSequence.subSequence(0, paramInt3);
        paramInt1 = 0;
        paramInt2 = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bivc
 * JD-Core Version:    0.7.0.1
 */