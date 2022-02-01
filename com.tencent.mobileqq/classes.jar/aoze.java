import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.ark.ArkDispatchTask;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.vipreport.ArkVipReporter.1;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import mqq.app.AppRuntime;
import org.json.JSONObject;

public class aoze
{
  private static Object jdField_a_of_type_JavaLangObject = new Object();
  private static HashMap<String, aozf> jdField_a_of_type_JavaUtilHashMap = new HashMap(2);
  private static boolean jdField_a_of_type_Boolean = true;
  private static HashMap<String, aozd> b = new HashMap(2);
  
  private static aozf a(String paramString)
  {
    Iterator localIterator = jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      aozf localaozf = (aozf)((Map.Entry)localIterator.next()).getValue();
      if ((localaozf.jdField_a_of_type_JavaUtilSet != null) && (localaozf.jdField_a_of_type_JavaUtilSet.contains(paramString))) {
        return localaozf;
      }
    }
    return null;
  }
  
  public static void a(String paramString, long paramLong)
  {
    if ((jdField_a_of_type_Boolean) && (bftf.b()) && (!TextUtils.isEmpty(paramString))) {
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        aozf localaozf = a(paramString);
        if ((localaozf != null) && (paramString.equals(localaozf.jdField_b_of_type_JavaLangString)))
        {
          String str = localaozf.jdField_a_of_type_JavaLangString;
          if (b.containsKey(str)) {
            b(str);
          }
          aozd localaozd = new aozd();
          localObject1 = BaseApplicationImpl.getApplication().getRuntime();
          if (((AppRuntime)localObject1).getAccount() == null)
          {
            localObject1 = "";
            localaozd.jdField_a_of_type_JavaLangString = ((String)localObject1);
            localaozd.jdField_b_of_type_JavaLangString = (Build.MANUFACTURER + "_" + Build.MODEL);
            localaozd.jdField_c_of_type_JavaLangString = "android";
            localaozd.d = "8.4.8_4810";
            localaozd.e = str;
            localaozd.f = localaozf.jdField_b_of_type_JavaLangString;
            localaozd.g = localaozf.jdField_c_of_type_JavaLangString;
            localaozd.jdField_a_of_type_Long = paramLong;
            localaozd.jdField_a_of_type_JavaUtilArrayList = new ArrayList(8);
            b.put(str, localaozd);
            QLog.d("ArkVipReporter", 1, new Object[] { "startSceneByEvent() sceneName=", str, ",evt =", paramString });
            ArkDispatchTask.getInstance().postToArkThreadDelay(new ArkVipReporter.1(str, localaozf), localaozf.jdField_a_of_type_Long);
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
  
  public static void a(String paramString, aozf paramaozf)
  {
    apvp localapvp = apvq.b(380).a();
    if ((localapvp != null) && (localapvp.a() != null)) {
      jdField_a_of_type_Boolean = localapvp.a().c;
    }
    if ((jdField_a_of_type_Boolean) && (!TextUtils.isEmpty(paramString)) && (!jdField_a_of_type_JavaUtilHashMap.containsKey(paramaozf))) {
      jdField_a_of_type_JavaUtilHashMap.put(paramString, paramaozf);
    }
    QLog.d("ArkVipReporter", 1, new Object[] { "initScene() sceneName=", paramString, ", enable =", Boolean.valueOf(jdField_a_of_type_Boolean) });
  }
  
  public static void a(String paramString, boolean paramBoolean, long paramLong, HashMap<String, String> paramHashMap)
  {
    if ((jdField_a_of_type_Boolean) && (bftf.b()) && (!TextUtils.isEmpty(paramString))) {
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        aozf localaozf = a(paramString);
        if (localaozf != null)
        {
          aozd localaozd = (aozd)b.get(localaozf.jdField_a_of_type_JavaLangString);
          if (localaozd == null) {
            return;
          }
          aozc localaozc = new aozc();
          localaozc.jdField_a_of_type_JavaLangString = paramString;
          localaozc.jdField_a_of_type_Int = localaozd.jdField_a_of_type_JavaUtilArrayList.size();
          localaozc.jdField_a_of_type_Boolean = paramBoolean;
          localaozc.jdField_b_of_type_Long = System.currentTimeMillis();
          localaozc.jdField_c_of_type_Long = paramLong;
          localaozc.jdField_a_of_type_Long = (localaozc.jdField_b_of_type_Long - paramLong);
          localaozc.d = NetworkUtil.getNetworkType(null);
          localaozc.jdField_a_of_type_JavaUtilHashMap = paramHashMap;
          localaozd.jdField_a_of_type_JavaUtilArrayList.add(localaozc);
          QLog.d("ArkVipReporter", 1, new Object[] { "addEventToScene() evt:", paramString, ", cost time=", Long.valueOf(paramLong) });
          if (paramString.equals(localaozf.jdField_c_of_type_JavaLangString)) {
            b(localaozf.jdField_a_of_type_JavaLangString);
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
      aozd localaozd = (aozd)b.remove(paramString);
      if (localaozd != null)
      {
        localaozd.jdField_b_of_type_Long = System.currentTimeMillis();
        localaozd.jdField_c_of_type_Long = (localaozd.jdField_b_of_type_Long - localaozd.jdField_a_of_type_Long);
        ??? = localaozd.a().toString();
        QLog.d("ArkVipReporter", 1, new Object[] { "report() sceneName:", paramString, ",total cost time=", Long.valueOf(localaozd.jdField_c_of_type_Long) });
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
    aoxw.a().a("callVIPReport", paramString, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aoze
 * JD-Core Version:    0.7.0.1
 */