import android.text.InputFilter.LengthFilter;
import android.text.Spanned;
import com.tencent.mobileqq.widget.QQToast;

class bmih
  extends InputFilter.LengthFilter
{
  boolean jdField_a_of_type_Boolean = true;
  
  bmih(bmig parambmig, int paramInt1, int paramInt2)
  {
    super(paramInt1);
  }
  
  public CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
  {
    if (this.jdField_a_of_type_Int - (paramSpanned.length() - (paramInt4 - paramInt3)) <= 0)
    {
      if (this.jdField_a_of_type_Boolean)
      {
        wxj.a("textEdit", "overLimit", bmhu.b(this.jdField_a_of_type_Bmig.a), 0, new String[0]);
        this.jdField_a_of_type_Boolean = false;
      }
      if (bmhu.a(this.jdField_a_of_type_Bmig.a) != null) {
        QQToast.a(this.jdField_a_of_type_Bmig.getContext(), alud.a(2131714821) + bmhu.a(this.jdField_a_of_type_Bmig.a).c + alud.a(2131714807), 0).a();
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
 * Qualified Name:     bmih
 * JD-Core Version:    0.7.0.1
 */