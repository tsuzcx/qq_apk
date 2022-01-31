import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import java.util.Arrays;

public class amii
{
  private final String jdField_a_of_type_JavaLangString;
  public final boolean a;
  private final String[] jdField_a_of_type_ArrayOfJavaLangString;
  private final String jdField_b_of_type_JavaLangString;
  private final String[] jdField_b_of_type_ArrayOfJavaLangString;
  private final String c;
  private final String d;
  
  public amii()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_a_of_type_ArrayOfJavaLangString = null;
    this.jdField_b_of_type_ArrayOfJavaLangString = null;
    this.c = null;
    this.d = null;
  }
  
  public amii(String paramString1, boolean paramBoolean, String paramString2, String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_ArrayOfJavaLangString = paramArrayOfString1;
    this.jdField_b_of_type_ArrayOfJavaLangString = paramArrayOfString2;
    if ("AIO".equals(paramString1))
    {
      this.c = "0X800A647";
      this.d = "0X800A648";
      return;
    }
    if ("group".equals(paramString1))
    {
      this.c = "0X800A649";
      this.d = "0X800A64A";
      return;
    }
    if ("download".equals(paramString1))
    {
      this.c = "0X800A64B";
      this.d = "0X800A64C";
      return;
    }
    this.c = null;
    this.d = null;
  }
  
  public SpannableString a(Context paramContext, CharSequence paramCharSequence)
  {
    paramCharSequence = paramCharSequence + this.jdField_b_of_type_JavaLangString;
    SpannableString localSpannableString = new SpannableString(paramCharSequence);
    int i = 0;
    if (i < this.jdField_a_of_type_ArrayOfJavaLangString.length)
    {
      String str1 = this.jdField_a_of_type_ArrayOfJavaLangString[i];
      String str2 = this.jdField_b_of_type_ArrayOfJavaLangString[i];
      if ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2))) {}
      for (;;)
      {
        i += 1;
        break;
        int j = paramCharSequence.indexOf(this.jdField_a_of_type_ArrayOfJavaLangString[i]);
        localSpannableString.setSpan(new amij(this, str2, paramContext), j, str1.length() + j, 33);
      }
    }
    awqx.b(null, "dc00898", "", "", this.c, this.c, 2, 0, "", "", "", "");
    return localSpannableString;
  }
  
  public String toString()
  {
    return "Item{enable=" + this.jdField_a_of_type_Boolean + ", content='" + this.jdField_b_of_type_JavaLangString + '\'' + ", keyWords=" + Arrays.toString(this.jdField_a_of_type_ArrayOfJavaLangString) + ", actionUrls=" + Arrays.toString(this.jdField_b_of_type_ArrayOfJavaLangString) + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amii
 * JD-Core Version:    0.7.0.1
 */