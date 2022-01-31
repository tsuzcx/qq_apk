import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.ark.ArkDispatchTask;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.vipreport.ArkVipReporter.1;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import mqq.app.AppRuntime;
import org.json.JSONObject;

public class anry
{
  private static Object jdField_a_of_type_JavaLangObject = new Object();
  private static HashMap<String, anrz> jdField_a_of_type_JavaUtilHashMap = new HashMap(2);
  private static boolean jdField_a_of_type_Boolean = true;
  private static HashMap<String, anrx> b = new HashMap(2);
  
  private static anrz a(String paramString)
  {
    Iterator localIterator = jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      anrz localanrz = (anrz)((Map.Entry)localIterator.next()).getValue();
      if ((localanrz.jdField_a_of_type_JavaUtilSet != null) && (localanrz.jdField_a_of_type_JavaUtilSet.contains(paramString))) {
        return localanrz;
      }
    }
    return null;
  }
  
  public static void a(String paramString, long paramLong)
  {
    if ((jdField_a_of_type_Boolean) && (bdeu.b()) && (!TextUtils.isEmpty(paramString))) {
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        anrz localanrz = a(paramString);
        if ((localanrz != null) && (paramString.equals(localanrz.jdField_b_of_type_JavaLangString)))
        {
          String str = localanrz.jdField_a_of_type_JavaLangString;
          if (b.containsKey(str)) {
            b(str);
          }
          anrx localanrx = new anrx();
          localObject1 = BaseApplicationImpl.getApplication().getRuntime();
          if (((AppRuntime)localObject1).getAccount() == null)
          {
            localObject1 = "";
            localanrx.jdField_a_of_type_JavaLangString = ((String)localObject1);
            localanrx.jdField_b_of_type_JavaLangString = (Build.MANUFACTURER + "_" + Build.MODEL);
            localanrx.jdField_c_of_type_JavaLangString = "android";
            localanrx.d = "8.3.5_4555";
            localanrx.e = str;
            localanrx.f = localanrz.jdField_b_of_type_JavaLangString;
            localanrx.g = localanrz.jdField_c_of_type_JavaLangString;
            localanrx.jdField_a_of_type_Long = paramLong;
            localanrx.jdField_a_of_type_JavaUtilArrayList = new ArrayList(8);
            b.put(str, localanrx);
            QLog.d("ArkVipReporter", 1, new Object[] { "startSceneByEvent() sceneName=", str, ",evt =", paramString });
            ArkDispatchTask.getInstance().postToArkThreadDelay(new ArkVipReporter.1(str, localanrz), localanrz.jdField_a_of_type_Long);
          }
        }
        else
        {
          return;
        }
        Object localObject1 = ((AppRuntime)localObject1).getAccount();
      }
    }
  }
  
  public static void a(String paramString, anrz paramanrz)
  {
    aolw localaolw = aolx.b(380).a();
    if ((localaolw != null) && (localaolw.a() != null)) {
      jdField_a_of_type_Boolean = localaolw.a().c;
    }
    if ((jdField_a_of_type_Boolean) && (!TextUtils.isEmpty(paramString)) && (!jdField_a_of_type_JavaUtilHashMap.containsKey(paramanrz))) {
      jdField_a_of_type_JavaUtilHashMap.put(paramString, paramanrz);
    }
    QLog.d("ArkVipReporter", 1, new Object[] { "initScene() sceneName=", paramString, ", enable =", Boolean.valueOf(jdField_a_of_type_Boolean) });
  }
  
  public static void a(String paramString, boolean paramBoolean, long paramLong, HashMap<String, String> paramHashMap)
  {
    if ((jdField_a_of_type_Boolean) && (bdeu.b()) && (!TextUtils.isEmpty(paramString))) {
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        anrz localanrz = a(paramString);
        if (localanrz != null)
        {
          anrx localanrx = (anrx)b.get(localanrz.jdField_a_of_type_JavaLangString);
          if (localanrx == null) {
            return;
          }
          anrw localanrw = new anrw();
          localanrw.jdField_a_of_type_JavaLangString = paramString;
          localanrw.jdField_a_of_type_Int = localanrx.jdField_a_of_type_JavaUtilArrayList.size();
          localanrw.jdField_a_of_type_Boolean = paramBoolean;
          localanrw.jdField_b_of_type_Long = System.currentTimeMillis();
          localanrw.jdField_c_of_type_Long = paramLong;
          localanrw.jdField_a_of_type_Long = (localanrw.jdField_b_of_type_Long - paramLong);
          localanrw.d = bdin.b(null);
          localanrw.jdField_a_of_type_JavaUtilHashMap = paramHashMap;
          localanrx.jdField_a_of_type_JavaUtilArrayList.add(localanrw);
          QLog.d("ArkVipReporter", 1, new Object[] { "addEventToScene() evt:", paramString, ", cost time=", Long.valueOf(paramLong) });
          if (paramString.equals(localanrz.jdField_c_of_type_JavaLangString)) {
            b(localanrz.jdField_a_of_type_JavaLangString);
          }
        }
        return;
      }
    }
  }
  
  private static void b(String paramString)
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      anrx localanrx = (anrx)b.remove(paramString);
      if (localanrx != null)
      {
        localanrx.jdField_b_of_type_Long = System.currentTimeMillis();
        localanrx.jdField_c_of_type_Long = (localanrx.jdField_b_of_type_Long - localanrx.jdField_a_of_type_Long);
        ??? = localanrx.a().toString();
        QLog.d("ArkVipReporter", 1, new Object[] { "report() sceneName:", paramString, ",total cost time=", Long.valueOf(localanrx.jdField_c_of_type_Long) });
        if (1 != BaseApplicationImpl.sProcessId) {
          break label136;
        }
        paramString = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
        if (paramString != null)
        {
          paramString = ((ArkAppCenter)paramString.getManager(121)).a();
          if (paramString != null) {
            paramString.b((String)???);
          }
        }
      }
      return;
    }
    label136:
    paramString = new Bundle();
    paramString.putString("reportContent", (String)???);
    anqp.a().a("callVIPReport", paramString, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anry
 * JD-Core Version:    0.7.0.1
 */