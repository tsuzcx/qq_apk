import android.net.Uri;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

public class bcoq
{
  public long a;
  public String a;
  public String b;
  public String c;
  public String d;
  public String e;
  public String f;
  
  public bcoq()
  {
    this.jdField_a_of_type_Long = -1L;
  }
  
  public bcoq(String paramString1, String paramString2, String paramString3, long paramLong, String paramString4, String paramString5, String paramString6)
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
  
  public static bcoq a(String paramString)
  {
    bcoq localbcoq = new bcoq();
    try
    {
      paramString = Uri.parse(paramString);
      localbcoq.jdField_a_of_type_JavaLangString = paramString.getQueryParameter("ver");
      localbcoq.b = paramString.getQueryParameter("name");
      localbcoq.c = paramString.getQueryParameter("path");
      localbcoq.jdField_a_of_type_Long = a(paramString.getQueryParameter("crc"));
      localbcoq.d = paramString.getQueryParameter("url");
      localbcoq.e = paramString.getQueryParameter("rUrl");
      localbcoq.f = paramString.getQueryParameter("rPath");
      return localbcoq;
    }
    catch (Throwable paramString)
    {
      QLog.e("SoLoadWidget.SoLocalInfo", 1, paramString, new Object[0]);
    }
    return localbcoq;
  }
  
  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("?").append("ver=").append(this.jdField_a_of_type_JavaLangString).append("&name=").append(this.b).append("&path=").append(akww.c(this.c)).append("&crc=").append(this.jdField_a_of_type_Long).append("&url=").append(akww.c(this.d)).append("&rUrl=").append(akww.c(this.e)).append("&rPath=").append(akww.c(this.f));
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcoq
 * JD-Core Version:    0.7.0.1
 */