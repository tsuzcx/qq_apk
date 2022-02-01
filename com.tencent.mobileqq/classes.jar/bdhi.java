import android.net.Uri;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

public class bdhi
{
  public long a;
  public String a;
  public String b;
  public String c;
  public String d;
  public String e;
  public String f;
  
  public bdhi()
  {
    this.jdField_a_of_type_Long = -1L;
  }
  
  public bdhi(String paramString1, String paramString2, String paramString3, long paramLong, String paramString4, String paramString5, String paramString6)
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
  
  public static bdhi a(String paramString)
  {
    bdhi localbdhi = new bdhi();
    try
    {
      paramString = Uri.parse(paramString);
      localbdhi.jdField_a_of_type_JavaLangString = paramString.getQueryParameter("ver");
      localbdhi.b = paramString.getQueryParameter("name");
      localbdhi.c = paramString.getQueryParameter("path");
      localbdhi.jdField_a_of_type_Long = a(paramString.getQueryParameter("crc"));
      localbdhi.d = paramString.getQueryParameter("url");
      localbdhi.e = paramString.getQueryParameter("rUrl");
      localbdhi.f = paramString.getQueryParameter("rPath");
      return localbdhi;
    }
    catch (Throwable paramString)
    {
      QLog.e("SoLoadWidget.SoLocalInfo", 1, paramString, new Object[0]);
    }
    return localbdhi;
  }
  
  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("?").append("ver=").append(this.jdField_a_of_type_JavaLangString).append("&name=").append(this.b).append("&path=").append(alil.c(this.c)).append("&crc=").append(this.jdField_a_of_type_Long).append("&url=").append(alil.c(this.d)).append("&rUrl=").append(alil.c(this.e)).append("&rPath=").append(alil.c(this.f));
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdhi
 * JD-Core Version:    0.7.0.1
 */