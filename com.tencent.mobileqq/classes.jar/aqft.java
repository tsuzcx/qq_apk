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

public class aqft
{
  private static Object jdField_a_of_type_JavaLangObject = new Object();
  private static HashMap<String, aqfu> jdField_a_of_type_JavaUtilHashMap = new HashMap(2);
  private static boolean jdField_a_of_type_Boolean = true;
  private static HashMap<String, aqfs> b = new HashMap(2);
  
  private static aqfu a(String paramString)
  {
    Iterator localIterator = jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      aqfu localaqfu = (aqfu)((Map.Entry)localIterator.next()).getValue();
      if ((localaqfu.jdField_a_of_type_JavaUtilSet != null) && (localaqfu.jdField_a_of_type_JavaUtilSet.contains(paramString))) {
        return localaqfu;
      }
    }
    return null;
  }
  
  public static void a(String paramString, long paramLong)
  {
    if ((jdField_a_of_type_Boolean) && (bhjx.b()) && (!TextUtils.isEmpty(paramString))) {
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        aqfu localaqfu = a(paramString);
        if ((localaqfu != null) && (paramString.equals(localaqfu.jdField_b_of_type_JavaLangString)))
        {
          String str = localaqfu.jdField_a_of_type_JavaLangString;
          if (b.containsKey(str)) {
            b(str);
          }
          aqfs localaqfs = new aqfs();
          localObject1 = BaseApplicationImpl.getApplication().getRuntime();
          if (((AppRuntime)localObject1).getAccount() == null)
          {
            localObject1 = "";
            localaqfs.jdField_a_of_type_JavaLangString = ((String)localObject1);
            localaqfs.jdField_b_of_type_JavaLangString = (Build.MANUFACTURER + "_" + Build.MODEL);
            localaqfs.jdField_c_of_type_JavaLangString = "android";
            localaqfs.d = "8.4.5_4745";
            localaqfs.e = str;
            localaqfs.f = localaqfu.jdField_b_of_type_JavaLangString;
            localaqfs.g = localaqfu.jdField_c_of_type_JavaLangString;
            localaqfs.jdField_a_of_type_Long = paramLong;
            localaqfs.jdField_a_of_type_JavaUtilArrayList = new ArrayList(8);
            b.put(str, localaqfs);
            QLog.d("ArkVipReporter", 1, new Object[] { "startSceneByEvent() sceneName=", str, ",evt =", paramString });
            ArkDispatchTask.getInstance().postToArkThreadDelay(new ArkVipReporter.1(str, localaqfu), localaqfu.jdField_a_of_type_Long);
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
  
  public static void a(String paramString, aqfu paramaqfu)
  {
    arbz localarbz = arca.b(380).a();
    if ((localarbz != null) && (localarbz.a() != null)) {
      jdField_a_of_type_Boolean = localarbz.a().c;
    }
    if ((jdField_a_of_type_Boolean) && (!TextUtils.isEmpty(paramString)) && (!jdField_a_of_type_JavaUtilHashMap.containsKey(paramaqfu))) {
      jdField_a_of_type_JavaUtilHashMap.put(paramString, paramaqfu);
    }
    QLog.d("ArkVipReporter", 1, new Object[] { "initScene() sceneName=", paramString, ", enable =", Boolean.valueOf(jdField_a_of_type_Boolean) });
  }
  
  public static void a(String paramString, boolean paramBoolean, long paramLong, HashMap<String, String> paramHashMap)
  {
    if ((jdField_a_of_type_Boolean) && (bhjx.b()) && (!TextUtils.isEmpty(paramString))) {
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        aqfu localaqfu = a(paramString);
        if (localaqfu != null)
        {
          aqfs localaqfs = (aqfs)b.get(localaqfu.jdField_a_of_type_JavaLangString);
          if (localaqfs == null) {
            return;
          }
          aqfr localaqfr = new aqfr();
          localaqfr.jdField_a_of_type_JavaLangString = paramString;
          localaqfr.jdField_a_of_type_Int = localaqfs.jdField_a_of_type_JavaUtilArrayList.size();
          localaqfr.jdField_a_of_type_Boolean = paramBoolean;
          localaqfr.jdField_b_of_type_Long = System.currentTimeMillis();
          localaqfr.jdField_c_of_type_Long = paramLong;
          localaqfr.jdField_a_of_type_Long = (localaqfr.jdField_b_of_type_Long - paramLong);
          localaqfr.d = bhnv.b(null);
          localaqfr.jdField_a_of_type_JavaUtilHashMap = paramHashMap;
          localaqfs.jdField_a_of_type_JavaUtilArrayList.add(localaqfr);
          QLog.d("ArkVipReporter", 1, new Object[] { "addEventToScene() evt:", paramString, ", cost time=", Long.valueOf(paramLong) });
          if (paramString.equals(localaqfu.jdField_c_of_type_JavaLangString)) {
            b(localaqfu.jdField_a_of_type_JavaLangString);
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
      aqfs localaqfs = (aqfs)b.remove(paramString);
      if (localaqfs != null)
      {
        localaqfs.jdField_b_of_type_Long = System.currentTimeMillis();
        localaqfs.jdField_c_of_type_Long = (localaqfs.jdField_b_of_type_Long - localaqfs.jdField_a_of_type_Long);
        ??? = localaqfs.a().toString();
        QLog.d("ArkVipReporter", 1, new Object[] { "report() sceneName:", paramString, ",total cost time=", Long.valueOf(localaqfs.jdField_c_of_type_Long) });
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
    aqel.a().a("callVIPReport", paramString, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqft
 * JD-Core Version:    0.7.0.1
 */