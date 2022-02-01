import android.text.Layout.Alignment;
import android.text.Spanned;
import android.text.StaticLayout;
import android.text.TextUtils;

class bors
  extends bpkc
{
  bors(borq paramborq, int paramInt)
  {
    super(paramInt);
  }
  
  public CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
  {
    String str1 = paramSpanned.subSequence(0, paramInt3).toString() + paramCharSequence.subSequence(paramInt1, paramInt2).toString() + paramSpanned.subSequence(paramInt4, paramSpanned.length()).toString();
    String str2 = bfsj.b(str1);
    Object localObject = this.jdField_a_of_type_Borq.a(str2);
    localObject = this.jdField_a_of_type_Borq.a((String)localObject);
    localObject = this.jdField_a_of_type_Borq.a((String[])localObject);
    if (bory.a((CharSequence)localObject, 0, ((CharSequence)localObject).length(), this.jdField_a_of_type_Borq.a, this.jdField_a_of_type_Borq.b, Layout.Alignment.ALIGN_CENTER, 1.0F, 0.0F, false, null, 0, 4).getLineCount() > 3)
    {
      if (!TextUtils.equals("", paramCharSequence)) {
        a();
      }
      return "";
    }
    this.jdField_a_of_type_Int = (str1.length() - str2.length() + 20);
    return super.filter(paramCharSequence, paramInt1, paramInt2, paramSpanned, paramInt3, paramInt4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bors
 * JD-Core Version:    0.7.0.1
 */