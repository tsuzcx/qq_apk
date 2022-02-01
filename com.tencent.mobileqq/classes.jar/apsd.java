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

public class apsd
{
  private static Object jdField_a_of_type_JavaLangObject = new Object();
  private static HashMap<String, apse> jdField_a_of_type_JavaUtilHashMap = new HashMap(2);
  private static boolean jdField_a_of_type_Boolean = true;
  private static HashMap<String, apsc> b = new HashMap(2);
  
  private static apse a(String paramString)
  {
    Iterator localIterator = jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      apse localapse = (apse)((Map.Entry)localIterator.next()).getValue();
      if ((localapse.jdField_a_of_type_JavaUtilSet != null) && (localapse.jdField_a_of_type_JavaUtilSet.contains(paramString))) {
        return localapse;
      }
    }
    return null;
  }
  
  public static void a(String paramString, long paramLong)
  {
    if ((jdField_a_of_type_Boolean) && (bgjw.b()) && (!TextUtils.isEmpty(paramString))) {
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        apse localapse = a(paramString);
        if ((localapse != null) && (paramString.equals(localapse.jdField_b_of_type_JavaLangString)))
        {
          String str = localapse.jdField_a_of_type_JavaLangString;
          if (b.containsKey(str)) {
            b(str);
          }
          apsc localapsc = new apsc();
          localObject1 = BaseApplicationImpl.getApplication().getRuntime();
          if (((AppRuntime)localObject1).getAccount() == null)
          {
            localObject1 = "";
            localapsc.jdField_a_of_type_JavaLangString = ((String)localObject1);
            localapsc.jdField_b_of_type_JavaLangString = (Build.MANUFACTURER + "_" + Build.MODEL);
            localapsc.jdField_c_of_type_JavaLangString = "android";
            localapsc.d = "8.4.1_4680";
            localapsc.e = str;
            localapsc.f = localapse.jdField_b_of_type_JavaLangString;
            localapsc.g = localapse.jdField_c_of_type_JavaLangString;
            localapsc.jdField_a_of_type_Long = paramLong;
            localapsc.jdField_a_of_type_JavaUtilArrayList = new ArrayList(8);
            b.put(str, localapsc);
            QLog.d("ArkVipReporter", 1, new Object[] { "startSceneByEvent() sceneName=", str, ",evt =", paramString });
            ArkDispatchTask.getInstance().postToArkThreadDelay(new ArkVipReporter.1(str, localapse), localapse.jdField_a_of_type_Long);
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
  
  public static void a(String paramString, apse paramapse)
  {
    aqmu localaqmu = aqmv.b(380).a();
    if ((localaqmu != null) && (localaqmu.a() != null)) {
      jdField_a_of_type_Boolean = localaqmu.a().c;
    }
    if ((jdField_a_of_type_Boolean) && (!TextUtils.isEmpty(paramString)) && (!jdField_a_of_type_JavaUtilHashMap.containsKey(paramapse))) {
      jdField_a_of_type_JavaUtilHashMap.put(paramString, paramapse);
    }
    QLog.d("ArkVipReporter", 1, new Object[] { "initScene() sceneName=", paramString, ", enable =", Boolean.valueOf(jdField_a_of_type_Boolean) });
  }
  
  public static void a(String paramString, boolean paramBoolean, long paramLong, HashMap<String, String> paramHashMap)
  {
    if ((jdField_a_of_type_Boolean) && (bgjw.b()) && (!TextUtils.isEmpty(paramString))) {
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        apse localapse = a(paramString);
        if (localapse != null)
        {
          apsc localapsc = (apsc)b.get(localapse.jdField_a_of_type_JavaLangString);
          if (localapsc == null) {
            return;
          }
          apsb localapsb = new apsb();
          localapsb.jdField_a_of_type_JavaLangString = paramString;
          localapsb.jdField_a_of_type_Int = localapsc.jdField_a_of_type_JavaUtilArrayList.size();
          localapsb.jdField_a_of_type_Boolean = paramBoolean;
          localapsb.jdField_b_of_type_Long = System.currentTimeMillis();
          localapsb.jdField_c_of_type_Long = paramLong;
          localapsb.jdField_a_of_type_Long = (localapsb.jdField_b_of_type_Long - paramLong);
          localapsb.d = bgnt.b(null);
          localapsb.jdField_a_of_type_JavaUtilHashMap = paramHashMap;
          localapsc.jdField_a_of_type_JavaUtilArrayList.add(localapsb);
          QLog.d("ArkVipReporter", 1, new Object[] { "addEventToScene() evt:", paramString, ", cost time=", Long.valueOf(paramLong) });
          if (paramString.equals(localapse.jdField_c_of_type_JavaLangString)) {
            b(localapse.jdField_a_of_type_JavaLangString);
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
      apsc localapsc = (apsc)b.remove(paramString);
      if (localapsc != null)
      {
        localapsc.jdField_b_of_type_Long = System.currentTimeMillis();
        localapsc.jdField_c_of_type_Long = (localapsc.jdField_b_of_type_Long - localapsc.jdField_a_of_type_Long);
        ??? = localapsc.a().toString();
        QLog.d("ArkVipReporter", 1, new Object[] { "report() sceneName:", paramString, ",total cost time=", Long.valueOf(localapsc.jdField_c_of_type_Long) });
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
    apqv.a().a("callVIPReport", paramString, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apsd
 * JD-Core Version:    0.7.0.1
 */