import android.graphics.Bitmap;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.httputils.HttpCommunicator;
import java.util.ArrayList;
import mqq.app.AppRuntime;

public class amou
{
  public static byte a;
  private static amow jdField_a_of_type_Amow;
  public static anef a;
  private static HttpCommunicator jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator;
  private static ArrayList<amov> jdField_a_of_type_JavaUtilArrayList;
  static anea[] jdField_a_of_type_ArrayOfAnea;
  public static byte b;
  static anef b;
  private boolean jdField_a_of_type_Boolean = true;
  
  static
  {
    jdField_a_of_type_Byte = 3;
    jdField_b_of_type_Byte = 1;
  }
  
  public amou(QQAppInterface paramQQAppInterface, String paramString)
  {
    jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator = paramQQAppInterface.getHttpCommunicatort();
    jdField_a_of_type_Amow = new amow(paramQQAppInterface.getApp(), paramString);
    jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    jdField_a_of_type_Anef = new anef((short)24, (byte)0);
    jdField_b_of_type_Anef = new anef((short)12, (byte)1);
    jdField_a_of_type_ArrayOfAnea = new anea[] { jdField_a_of_type_Anef, jdField_b_of_type_Anef };
    jdField_a_of_type_Amow.a();
  }
  
  public static amow a()
  {
    return jdField_a_of_type_Amow;
  }
  
  public static HttpCommunicator a()
  {
    return jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator;
  }
  
  public static String a()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.sApplication.getRuntime();
    if (localAppRuntime != null) {
      return localAppRuntime.getAccount();
    }
    return null;
  }
  
  public static String a(String paramString1, int paramInt, String paramString2)
  {
    paramString1 = new StringBuffer(amow.a(paramString1, paramInt).trim());
    if (paramString2 != null)
    {
      paramString2 = paramString2.trim();
      if (paramString2.length() > 0)
      {
        if (paramString2.charAt(0) != '&') {
          paramString1.append('&');
        }
        paramString1.append(paramString2);
      }
    }
    return paramString1.toString();
  }
  
  public static ArrayList<amov> a()
  {
    return jdField_a_of_type_JavaUtilArrayList;
  }
  
  public static void a()
  {
    jdField_a_of_type_Amow = null;
    if (jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator != null) {
      jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator.b();
    }
    jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator = null;
  }
  
  public int a(int paramInt)
  {
    return jdField_a_of_type_ArrayOfAnea[paramInt].a();
  }
  
  public long a(int paramInt1, int paramInt2)
  {
    return ((anef)jdField_a_of_type_ArrayOfAnea[paramInt1]).a(paramInt2);
  }
  
  public Bitmap a(int paramInt1, int paramInt2)
  {
    return ((anef)jdField_a_of_type_ArrayOfAnea[paramInt1]).a(paramInt2);
  }
  
  public String a(int paramInt1, int paramInt2)
  {
    return ((anef)jdField_a_of_type_ArrayOfAnea[paramInt1]).c(paramInt2);
  }
  
  public short a(int paramInt1, int paramInt2)
  {
    return ((anef)jdField_a_of_type_ArrayOfAnea[paramInt1]).a(paramInt2);
  }
  
  public String b(int paramInt1, int paramInt2)
  {
    return ((anef)jdField_a_of_type_ArrayOfAnea[paramInt1]).a(paramInt2);
  }
  
  public String c(int paramInt1, int paramInt2)
  {
    return ((anef)jdField_a_of_type_ArrayOfAnea[paramInt1]).b(paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amou
 * JD-Core Version:    0.7.0.1
 */