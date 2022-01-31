import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

public class auso
{
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    String str = "*S1*" + bcvy.a(paramString.getBytes(), 11);
    if (QLog.isDevelopLevel()) {
      QLog.i("NearbyURLSafeUtil", 4, "encode:" + paramString + " to:" + str);
    }
    return str;
  }
  
  public static boolean a(String paramString)
  {
    if (paramString == null) {
      throw new NullPointerException("isBase64 src should not be null");
    }
    return paramString.startsWith("*S1*");
  }
  
  public static String b(String paramString)
  {
    if (paramString == null) {
      throw new NullPointerException("decode src should not be null");
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("NearbyURLSafeUtil", 4, "decode src:" + paramString);
    }
    String str = paramString;
    if (a(paramString))
    {
      paramString = new String(bcvy.a(paramString.substring("*S1*".length()), 11));
      str = paramString;
      if (QLog.isDevelopLevel())
      {
        QLog.i("NearbyURLSafeUtil", 4, "decode result:" + paramString);
        str = paramString;
      }
    }
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     auso
 * JD-Core Version:    0.7.0.1
 */