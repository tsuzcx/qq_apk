import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class aoys
{
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  private static String jdField_a_of_type_JavaLangString = "";
  private static HashMap<String, Integer> jdField_a_of_type_JavaUtilHashMap = new HashMap(8);
  private static HashMap<String, Integer> b = new HashMap(8);
  
  private static void a(aoyt paramaoyt)
  {
    if (paramaoyt == null) {}
    do
    {
      do
      {
        return;
        paramaoyt = paramaoyt.toString();
        if (QLog.isColorLevel()) {
          QLog.d("ArkApp.ArkSecurityReporter", 2, new Object[] { "ArkSafe.report reportRealTime content=", paramaoyt });
        }
        if (1 != BaseApplicationImpl.sProcessId) {
          break;
        }
        localObject = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
      } while (localObject == null);
      localObject = ((ArkAppCenter)((QQAppInterface)localObject).getManager(121)).a();
    } while (localObject == null);
    ((aoul)localObject).a(paramaoyt);
    return;
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("reportContent", paramaoyt);
    aoxw.a().a("callReportUrlCheck", (Bundle)localObject, null);
  }
  
  public static void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      Integer localInteger = (Integer)jdField_a_of_type_JavaUtilHashMap.get(paramString);
      if (localInteger != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ArkApp.ArkSecurityReporter", 2, new Object[] { "ArkSafe.report valid resource app=", paramString, ", count=", localInteger, ", result=0 , QQVersion=", b() });
        }
        bcef.b(null, "dc00898", "", "", "0X8009BCF", "0X8009BCF", 0, localInteger.intValue(), 0, b(), "", paramString, "");
        jdField_a_of_type_JavaUtilHashMap.remove(paramString);
      }
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        localInteger = (Integer)b.get(paramString);
        if (localInteger != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ArkApp.ArkSecurityReporter", 2, new Object[] { "ArkSafe.report valid navigation app=", paramString, ", count=", localInteger, ", result=0, r3=1, QQVersion=", b() });
          }
          bcef.b(null, "dc00898", "", "", "0X8009BD0", "0X8009BD0", 0, localInteger.intValue(), 0, b(), "1", paramString, "");
          b.remove(paramString);
        }
        return;
      }
    }
  }
  
  public static void a(String paramString1, String arg1, int paramInt1, int paramInt2, String paramString3)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(???))) {
      return;
    }
    if (paramInt2 == 0) {
      for (;;)
      {
        synchronized (jdField_a_of_type_JavaLangObject)
        {
          paramString3 = (Integer)jdField_a_of_type_JavaUtilHashMap.get(paramString1);
          if (paramString3 != null)
          {
            paramInt1 = paramString3.intValue();
            jdField_a_of_type_JavaUtilHashMap.put(paramString1, Integer.valueOf(paramInt1 + 1));
            return;
          }
        }
        jdField_a_of_type_JavaUtilHashMap.put(paramString1, Integer.valueOf(1));
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("ArkApp.ArkSecurityReporter", 2, new Object[] { "ArkSafe.report invalid resource url app=", paramString1, ", count=1, result=", Integer.valueOf(paramInt2), ",validType=", Integer.valueOf(paramInt1), ",sender uin=", paramString3, " ,url=", npn.b(???, new String[0]), " ,QQVersion=", b() });
    }
    bcef.a(null, "dc00898", "", paramString3, "0X8009BCF", "0X8009BCF", paramInt1, paramInt2, b(), "0", paramString1, ???);
    paramString3 = new aoyt();
    paramString3.jdField_b_of_type_JavaLangString = paramString1;
    paramString3.jdField_c_of_type_JavaLangString = ???;
    paramString3.jdField_b_of_type_Int = 0;
    paramString3.jdField_c_of_type_Int = paramInt1;
    paramString3.a = paramInt2;
    a(paramString3);
  }
  
  private static String b()
  {
    if (TextUtils.isEmpty(jdField_a_of_type_JavaLangString)) {}
    for (;;)
    {
      try
      {
        arrayOfString = "8.4.8".split("\\.");
        if (arrayOfString != null)
        {
          if (arrayOfString.length < 3) {
            continue;
          }
          jdField_a_of_type_JavaLangString = String.format("%d%02d%02d", new Object[] { Integer.valueOf(Integer.parseInt(arrayOfString[0])), Integer.valueOf(Integer.parseInt(arrayOfString[1])), Integer.valueOf(Integer.parseInt(arrayOfString[2])) });
        }
      }
      catch (Exception localException)
      {
        String[] arrayOfString;
        QLog.d("ArkApp.ArkSecurityReporter", 2, "ArkSafe", localException);
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ArkApp.ArkSecurityReporter", 2, new Object[] { "ArkSafe.report get QQVersion=", jdField_a_of_type_JavaLangString });
      }
      return jdField_a_of_type_JavaLangString;
      if (arrayOfString.length == 2) {
        jdField_a_of_type_JavaLangString = String.format("%d%02d00", new Object[] { Integer.valueOf(Integer.parseInt(arrayOfString[0])), Integer.valueOf(Integer.parseInt(arrayOfString[1])) });
      }
    }
  }
  
  public static void b(String paramString1, String arg1, int paramInt1, int paramInt2, String paramString3)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(???))) {
      return;
    }
    if (paramInt2 == 0) {
      for (;;)
      {
        synchronized (jdField_a_of_type_JavaLangObject)
        {
          paramString3 = (Integer)b.get(paramString1);
          if (paramString3 != null)
          {
            paramInt1 = paramString3.intValue();
            b.put(paramString1, Integer.valueOf(paramInt1 + 1));
            return;
          }
        }
        b.put(paramString1, Integer.valueOf(1));
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("ArkApp.ArkSecurityReporter", 2, new Object[] { "ArkSafe.report invalid navigation url app=", paramString1, ",count=1, result=", Integer.valueOf(paramInt2), ",validType=", Integer.valueOf(paramInt1), ",sender uin=", paramString3, ",r3=1 ,url=", npn.b(???, new String[0]), " ,QQVersion=", b() });
    }
    bcef.a(null, "dc00898", "", paramString3, "0X8009BD0", "0X8009BD0", paramInt1, paramInt2, b(), "1", paramString1, ???);
    paramString3 = new aoyt();
    paramString3.jdField_b_of_type_JavaLangString = paramString1;
    paramString3.jdField_c_of_type_JavaLangString = ???;
    paramString3.jdField_b_of_type_Int = 1;
    paramString3.jdField_c_of_type_Int = paramInt1;
    paramString3.a = paramInt2;
    a(paramString3);
  }
  
  public static void c(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    if (paramInt2 == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ArkApp.ArkSecurityReporter", 2, new Object[] { "ArkSafe.report web url app=", paramString1, ", count=1, result=0, r3=2, url=", npn.b(paramString2, new String[0]), ",QQVersion=", b() });
      }
      bcef.a(null, "dc00898", "", "", "0X8009BD0", "0X8009BD0", 0, 0, b(), "2", paramString1, "");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ArkApp.ArkSecurityReporter", 2, new Object[] { "ArkSafe.report web url app=", paramString1, ", count=1, result=", Integer.valueOf(paramInt2), ",validType=", Integer.valueOf(paramInt1), " ,sender uin=", paramString3, " ,r3=2 ,url=", npn.b(paramString2, new String[0]), " ,QQVersion=", b() });
    }
    bcef.a(null, "dc00898", "", paramString3, "0X8009BD0", "0X8009BD0", paramInt1, paramInt2, b(), "2", paramString1, paramString2);
    paramString3 = new aoyt();
    paramString3.jdField_b_of_type_JavaLangString = paramString1;
    paramString3.jdField_c_of_type_JavaLangString = paramString2;
    paramString3.a = paramInt2;
    paramString3.jdField_b_of_type_Int = 2;
    paramString3.jdField_c_of_type_Int = paramInt1;
    paramString3.a = paramInt2;
    a(paramString3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aoys
 * JD-Core Version:    0.7.0.1
 */