import android.net.Uri;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

public class bdgs
{
  public long a;
  public String a;
  public String b;
  public String c;
  public String d;
  public String e;
  public String f;
  
  public bdgs()
  {
    this.jdField_a_of_type_Long = -1L;
  }
  
  public bdgs(String paramString1, String paramString2, String paramString3, long paramLong, String paramString4, String paramString5, String paramString6)
  {
    this.jdField_a_of_type_Long = -1L;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.c = paramString3;
    this.jdField_a_of_type_Long = paramLong;
    this.d = paramString4;
    this.e = paramString5;
    this.f = paramString6;
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
  
  public static bdgs a(String paramString)
  {
    bdgs localbdgs = new bdgs();
    try
    {
      paramString = Uri.parse(paramString);
      localbdgs.jdField_a_of_type_JavaLangString = paramString.getQueryParameter("ver");
      localbdgs.b = paramString.getQueryParameter("name");
      localbdgs.c = paramString.getQueryParameter("path");
      localbdgs.jdField_a_of_type_Long = a(paramString.getQueryParameter("crc"));
      localbdgs.d = paramString.getQueryParameter("url");
      localbdgs.e = paramString.getQueryParameter("rUrl");
      localbdgs.f = paramString.getQueryParameter("rPath");
      return localbdgs;
    }
    catch (Throwable paramString)
    {
      QLog.e("SoLoadWidget.SoLocalInfo", 1, paramString, new Object[0]);
    }
    return localbdgs;
  }
  
  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("?").append("ver=").append(this.jdField_a_of_type_JavaLangString).append("&name=").append(this.b).append("&path=").append(albw.c(this.c)).append("&crc=").append(this.jdField_a_of_type_Long).append("&url=").append(albw.c(this.d)).append("&rUrl=").append(albw.c(this.e)).append("&rPath=").append(albw.c(this.f));
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdgs
 * JD-Core Version:    0.7.0.1
 */