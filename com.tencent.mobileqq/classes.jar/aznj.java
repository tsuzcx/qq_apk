import android.net.Uri;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

public class aznj
{
  public long a;
  public String a;
  public String b;
  public String c;
  public String d;
  
  public aznj()
  {
    this.jdField_a_of_type_Long = -1L;
  }
  
  public aznj(String paramString)
  {
    this.jdField_a_of_type_Long = -1L;
    this.c = paramString;
  }
  
  public aznj(String paramString1, String paramString2, String paramString3, long paramLong, String paramString4)
  {
    this.jdField_a_of_type_Long = -1L;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.c = paramString3;
    this.jdField_a_of_type_Long = paramLong;
    this.d = paramString4;
  }
  
  private static long a(String paramString)
  {
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        long l = Long.parseLong(paramString);
        return l;
      }
    }
    catch (Throwable paramString)
    {
      QLog.e("SoLoadWidget.SoLocalInfo", 1, paramString, new Object[0]);
    }
    return -1L;
  }
  
  public static aznj a(String paramString)
  {
    aznj localaznj = new aznj();
    try
    {
      paramString = Uri.parse(paramString);
      localaznj.jdField_a_of_type_JavaLangString = paramString.getQueryParameter("ver");
      localaznj.b = paramString.getQueryParameter("name");
      localaznj.c = paramString.getQueryParameter("path");
      localaznj.jdField_a_of_type_Long = a(paramString.getQueryParameter("crc"));
      localaznj.d = paramString.getQueryParameter("url");
      return localaznj;
    }
    catch (Throwable paramString)
    {
      QLog.e("SoLoadWidget.SoLocalInfo", 1, paramString, new Object[0]);
    }
    return localaznj;
  }
  
  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("?").append("ver=").append(this.jdField_a_of_type_JavaLangString).append("&name=").append(this.b).append("&path=").append(ajeu.c(this.c)).append("&crc=").append(this.jdField_a_of_type_Long).append("&url=").append(ajeu.c(this.d));
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aznj
 * JD-Core Version:    0.7.0.1
 */