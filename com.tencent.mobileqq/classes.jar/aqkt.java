import android.graphics.Bitmap;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;
import mqq.app.AppRuntime;

public class aqkt
{
  public static byte a;
  private static aqkv jdField_a_of_type_Aqkv;
  public static arcv a;
  private static bgut jdField_a_of_type_Bgut;
  private static ArrayList<aqku> jdField_a_of_type_JavaUtilArrayList;
  static arcq[] jdField_a_of_type_ArrayOfArcq;
  public static byte b;
  static arcv b;
  private boolean jdField_a_of_type_Boolean = true;
  
  static
  {
    jdField_a_of_type_Byte = 3;
    jdField_b_of_type_Byte = 1;
  }
  
  public aqkt(QQAppInterface paramQQAppInterface, String paramString)
  {
    jdField_a_of_type_Bgut = paramQQAppInterface.getHttpCommunicatort();
    jdField_a_of_type_Aqkv = new aqkv(paramQQAppInterface.getApp(), paramString);
    jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    jdField_a_of_type_Arcv = new arcv((short)24, (byte)0);
    jdField_b_of_type_Arcv = new arcv((short)12, (byte)1);
    jdField_a_of_type_ArrayOfArcq = new arcq[] { jdField_a_of_type_Arcv, jdField_b_of_type_Arcv };
    jdField_a_of_type_Aqkv.a();
  }
  
  public static aqkv a()
  {
    return jdField_a_of_type_Aqkv;
  }
  
  public static bgut a()
  {
    return jdField_a_of_type_Bgut;
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
    paramString1 = new StringBuffer(aqkv.a(paramString1, paramInt).trim());
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
  
  public static ArrayList<aqku> a()
  {
    return jdField_a_of_type_JavaUtilArrayList;
  }
  
  public static void a()
  {
    jdField_a_of_type_Aqkv = null;
    if (jdField_a_of_type_Bgut != null) {
      jdField_a_of_type_Bgut.b();
    }
    jdField_a_of_type_Bgut = null;
  }
  
  public int a(int paramInt)
  {
    return jdField_a_of_type_ArrayOfArcq[paramInt].a();
  }
  
  public long a(int paramInt1, int paramInt2)
  {
    return ((arcv)jdField_a_of_type_ArrayOfArcq[paramInt1]).a(paramInt2);
  }
  
  public Bitmap a(int paramInt1, int paramInt2)
  {
    return ((arcv)jdField_a_of_type_ArrayOfArcq[paramInt1]).a(paramInt2);
  }
  
  public String a(int paramInt1, int paramInt2)
  {
    return ((arcv)jdField_a_of_type_ArrayOfArcq[paramInt1]).c(paramInt2);
  }
  
  public short a(int paramInt1, int paramInt2)
  {
    return ((arcv)jdField_a_of_type_ArrayOfArcq[paramInt1]).a(paramInt2);
  }
  
  public String b(int paramInt1, int paramInt2)
  {
    return ((arcv)jdField_a_of_type_ArrayOfArcq[paramInt1]).a(paramInt2);
  }
  
  public String c(int paramInt1, int paramInt2)
  {
    return ((arcv)jdField_a_of_type_ArrayOfArcq[paramInt1]).b(paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqkt
 * JD-Core Version:    0.7.0.1
 */