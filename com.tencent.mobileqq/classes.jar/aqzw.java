import android.graphics.Bitmap;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;
import mqq.app.AppRuntime;

public class aqzw
{
  public static byte a;
  private static aqzy jdField_a_of_type_Aqzy;
  public static arsk a;
  private static bhuw jdField_a_of_type_Bhuw;
  private static ArrayList<aqzx> jdField_a_of_type_JavaUtilArrayList;
  static arsf[] jdField_a_of_type_ArrayOfArsf;
  public static byte b;
  static arsk b;
  private boolean jdField_a_of_type_Boolean = true;
  
  static
  {
    jdField_a_of_type_Byte = 3;
    jdField_b_of_type_Byte = 1;
  }
  
  public aqzw(QQAppInterface paramQQAppInterface, String paramString)
  {
    jdField_a_of_type_Bhuw = paramQQAppInterface.getHttpCommunicatort();
    jdField_a_of_type_Aqzy = new aqzy(paramQQAppInterface.getApp(), paramString);
    jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    jdField_a_of_type_Arsk = new arsk((short)24, (byte)0);
    jdField_b_of_type_Arsk = new arsk((short)12, (byte)1);
    jdField_a_of_type_ArrayOfArsf = new arsf[] { jdField_a_of_type_Arsk, jdField_b_of_type_Arsk };
    jdField_a_of_type_Aqzy.a();
  }
  
  public static aqzy a()
  {
    return jdField_a_of_type_Aqzy;
  }
  
  public static bhuw a()
  {
    return jdField_a_of_type_Bhuw;
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
    paramString1 = new StringBuffer(aqzy.a(paramString1, paramInt).trim());
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
  
  public static ArrayList<aqzx> a()
  {
    return jdField_a_of_type_JavaUtilArrayList;
  }
  
  public static void a()
  {
    jdField_a_of_type_Aqzy = null;
    if (jdField_a_of_type_Bhuw != null) {
      jdField_a_of_type_Bhuw.b();
    }
    jdField_a_of_type_Bhuw = null;
  }
  
  public int a(int paramInt)
  {
    return jdField_a_of_type_ArrayOfArsf[paramInt].a();
  }
  
  public long a(int paramInt1, int paramInt2)
  {
    return ((arsk)jdField_a_of_type_ArrayOfArsf[paramInt1]).a(paramInt2);
  }
  
  public Bitmap a(int paramInt1, int paramInt2)
  {
    return ((arsk)jdField_a_of_type_ArrayOfArsf[paramInt1]).a(paramInt2);
  }
  
  public String a(int paramInt1, int paramInt2)
  {
    return ((arsk)jdField_a_of_type_ArrayOfArsf[paramInt1]).c(paramInt2);
  }
  
  public short a(int paramInt1, int paramInt2)
  {
    return ((arsk)jdField_a_of_type_ArrayOfArsf[paramInt1]).a(paramInt2);
  }
  
  public String b(int paramInt1, int paramInt2)
  {
    return ((arsk)jdField_a_of_type_ArrayOfArsf[paramInt1]).a(paramInt2);
  }
  
  public String c(int paramInt1, int paramInt2)
  {
    return ((arsk)jdField_a_of_type_ArrayOfArsf[paramInt1]).b(paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqzw
 * JD-Core Version:    0.7.0.1
 */