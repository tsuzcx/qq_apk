import android.text.InputFilter.LengthFilter;
import android.text.Spanned;
import com.tencent.mobileqq.widget.QQToast;

class bqbi
  extends InputFilter.LengthFilter
{
  boolean jdField_a_of_type_Boolean = true;
  
  bqbi(bqbh parambqbh, int paramInt1, int paramInt2)
  {
    super(paramInt1);
  }
  
  public CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
  {
    if (this.jdField_a_of_type_Int - (paramSpanned.length() - (paramInt4 - paramInt3)) <= 0)
    {
      if (this.jdField_a_of_type_Boolean)
      {
        yup.a("textEdit", "overLimit", bqav.b(this.jdField_a_of_type_Bqbh.a), 0, new String[0]);
        this.jdField_a_of_type_Boolean = false;
      }
      if (bqav.a(this.jdField_a_of_type_Bqbh.a) != null) {
        QQToast.a(this.jdField_a_of_type_Bqbh.getContext(), anzj.a(2131713231) + bqav.a(this.jdField_a_of_type_Bqbh.a).c + anzj.a(2131713217), 0).a();
      }
    }
    for (;;)
    {
      return super.filter(paramCharSequence, paramInt1, paramInt2, paramSpanned, paramInt3, paramInt4);
      this.jdField_a_of_type_Boolean = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqbi
 * JD-Core Version:    0.7.0.1
 */