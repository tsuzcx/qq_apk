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

public class annp
{
  private static Object jdField_a_of_type_JavaLangObject = new Object();
  private static HashMap<String, annq> jdField_a_of_type_JavaUtilHashMap = new HashMap(2);
  private static boolean jdField_a_of_type_Boolean = true;
  private static HashMap<String, anno> b = new HashMap(2);
  
  private static annq a(String paramString)
  {
    Iterator localIterator = jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      annq localannq = (annq)((Map.Entry)localIterator.next()).getValue();
      if ((localannq.jdField_a_of_type_JavaUtilSet != null) && (localannq.jdField_a_of_type_JavaUtilSet.contains(paramString))) {
        return localannq;
      }
    }
    return null;
  }
  
  public static void a(String paramString, long paramLong)
  {
    if ((jdField_a_of_type_Boolean) && (bdal.b()) && (!TextUtils.isEmpty(paramString))) {
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        annq localannq = a(paramString);
        if ((localannq != null) && (paramString.equals(localannq.jdField_b_of_type_JavaLangString)))
        {
          String str = localannq.jdField_a_of_type_JavaLangString;
          if (b.containsKey(str)) {
            b(str);
          }
          anno localanno = new anno();
          localObject1 = BaseApplicationImpl.getApplication().getRuntime();
          if (((AppRuntime)localObject1).getAccount() == null)
          {
            localObject1 = "";
            localanno.jdField_a_of_type_JavaLangString = ((String)localObject1);
            localanno.jdField_b_of_type_JavaLangString = (Build.MANUFACTURER + "_" + Build.MODEL);
            localanno.jdField_c_of_type_JavaLangString = "android";
            localanno.d = "8.3.3_4515";
            localanno.e = str;
            localanno.f = localannq.jdField_b_of_type_JavaLangString;
            localanno.g = localannq.jdField_c_of_type_JavaLangString;
            localanno.jdField_a_of_type_Long = paramLong;
            localanno.jdField_a_of_type_JavaUtilArrayList = new ArrayList(8);
            b.put(str, localanno);
            QLog.d("ArkVipReporter", 1, new Object[] { "startSceneByEvent() sceneName=", str, ",evt =", paramString });
            ArkDispatchTask.getInstance().postToArkThreadDelay(new ArkVipReporter.1(str, localannq), localannq.jdField_a_of_type_Long);
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
  
  public static void a(String paramString, annq paramannq)
  {
    aohn localaohn = aoho.b(380).a();
    if ((localaohn != null) && (localaohn.a() != null)) {
      jdField_a_of_type_Boolean = localaohn.a().c;
    }
    if ((jdField_a_of_type_Boolean) && (!TextUtils.isEmpty(paramString)) && (!jdField_a_of_type_JavaUtilHashMap.containsKey(paramannq))) {
      jdField_a_of_type_JavaUtilHashMap.put(paramString, paramannq);
    }
    QLog.d("ArkVipReporter", 1, new Object[] { "initScene() sceneName=", paramString, ", enable =", Boolean.valueOf(jdField_a_of_type_Boolean) });
  }
  
  public static void a(String paramString, boolean paramBoolean, long paramLong, HashMap<String, String> paramHashMap)
  {
    if ((jdField_a_of_type_Boolean) && (bdal.b()) && (!TextUtils.isEmpty(paramString))) {
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        annq localannq = a(paramString);
        if (localannq != null)
        {
          anno localanno = (anno)b.get(localannq.jdField_a_of_type_JavaLangString);
          if (localanno == null) {
            return;
          }
          annn localannn = new annn();
          localannn.jdField_a_of_type_JavaLangString = paramString;
          localannn.jdField_a_of_type_Int = localanno.jdField_a_of_type_JavaUtilArrayList.size();
          localannn.jdField_a_of_type_Boolean = paramBoolean;
          localannn.jdField_b_of_type_Long = System.currentTimeMillis();
          localannn.jdField_c_of_type_Long = paramLong;
          localannn.jdField_a_of_type_Long = (localannn.jdField_b_of_type_Long - paramLong);
          localannn.d = bdee.b(null);
          localannn.jdField_a_of_type_JavaUtilHashMap = paramHashMap;
          localanno.jdField_a_of_type_JavaUtilArrayList.add(localannn);
          QLog.d("ArkVipReporter", 1, new Object[] { "addEventToScene() evt:", paramString, ", cost time=", Long.valueOf(paramLong) });
          if (paramString.equals(localannq.jdField_c_of_type_JavaLangString)) {
            b(localannq.jdField_a_of_type_JavaLangString);
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
      anno localanno = (anno)b.remove(paramString);
      if (localanno != null)
      {
        localanno.jdField_b_of_type_Long = System.currentTimeMillis();
        localanno.jdField_c_of_type_Long = (localanno.jdField_b_of_type_Long - localanno.jdField_a_of_type_Long);
        ??? = localanno.a().toString();
        QLog.d("ArkVipReporter", 1, new Object[] { "report() sceneName:", paramString, ",total cost time=", Long.valueOf(localanno.jdField_c_of_type_Long) });
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
    anmg.a().a("callVIPReport", paramString, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     annp
 * JD-Core Version:    0.7.0.1
 */