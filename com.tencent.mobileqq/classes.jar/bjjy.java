import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

public class bjjy
{
  public int a;
  public String a;
  public int b;
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      paramString = paramString.split(";");
    } while ((paramString == null) || (paramString.length < 3));
    try
    {
      this.jdField_a_of_type_Int = Integer.valueOf(paramString[0]).intValue();
      this.b = Integer.valueOf(paramString[1]).intValue();
      this.jdField_a_of_type_JavaLangString = paramString[2];
      return;
    }
    catch (Throwable paramString)
    {
      QLog.e("FontManager", 1, "loadDefaultFontData Throwable, errMsg = " + paramString.getMessage());
    }
  }
  
  public String toString()
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      return "";
    }
    return this.jdField_a_of_type_Int + ";" + this.b + ";" + this.jdField_a_of_type_JavaLangString + ";";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjjy
 * JD-Core Version:    0.7.0.1
 */