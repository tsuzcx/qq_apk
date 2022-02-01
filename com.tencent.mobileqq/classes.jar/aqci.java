import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.ark.ArkDispatchTask;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
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

public class aqci
{
  private static Object jdField_a_of_type_JavaLangObject = new Object();
  private static HashMap<String, aqcj> jdField_a_of_type_JavaUtilHashMap = new HashMap(2);
  private static boolean jdField_a_of_type_Boolean = true;
  private static HashMap<String, aqch> b = new HashMap(2);
  
  private static aqcj a(String paramString)
  {
    Iterator localIterator = jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      aqcj localaqcj = (aqcj)((Map.Entry)localIterator.next()).getValue();
      if ((localaqcj.jdField_a_of_type_JavaUtilSet != null) && (localaqcj.jdField_a_of_type_JavaUtilSet.contains(paramString))) {
        return localaqcj;
      }
    }
    return null;
  }
  
  public static void a(String paramString, long paramLong)
  {
    if ((jdField_a_of_type_Boolean) && (bhbx.b()) && (!TextUtils.isEmpty(paramString))) {
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        aqcj localaqcj = a(paramString);
        if ((localaqcj != null) && (paramString.equals(localaqcj.jdField_b_of_type_JavaLangString)))
        {
          String str = localaqcj.jdField_a_of_type_JavaLangString;
          if (b.containsKey(str)) {
            b(str);
          }
          aqch localaqch = new aqch();
          localObject1 = BaseApplicationImpl.getApplication().getRuntime();
          if (((AppRuntime)localObject1).getAccount() == null)
          {
            localObject1 = "";
            localaqch.jdField_a_of_type_JavaLangString = ((String)localObject1);
            localaqch.jdField_b_of_type_JavaLangString = (Build.MANUFACTURER + "_" + Build.MODEL);
            localaqch.jdField_c_of_type_JavaLangString = "android";
            localaqch.d = "8.4.10_4875";
            localaqch.e = str;
            localaqch.f = localaqcj.jdField_b_of_type_JavaLangString;
            localaqch.g = localaqcj.jdField_c_of_type_JavaLangString;
            localaqch.jdField_a_of_type_Long = paramLong;
            localaqch.jdField_a_of_type_JavaUtilArrayList = new ArrayList(8);
            b.put(str, localaqch);
            QLog.d("ArkVipReporter", 1, new Object[] { "startSceneByEvent() sceneName=", str, ",evt =", paramString });
            ArkDispatchTask.getInstance().postToArkThreadDelay(new ArkVipReporter.1(str, localaqcj), localaqcj.jdField_a_of_type_Long);
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
  
  public static void a(String paramString, aqcj paramaqcj)
  {
    aqys localaqys = aqyt.b(380).a();
    if ((localaqys != null) && (localaqys.a() != null)) {
      jdField_a_of_type_Boolean = localaqys.a().c;
    }
    if ((jdField_a_of_type_Boolean) && (!TextUtils.isEmpty(paramString)) && (!jdField_a_of_type_JavaUtilHashMap.containsKey(paramaqcj))) {
      jdField_a_of_type_JavaUtilHashMap.put(paramString, paramaqcj);
    }
    QLog.d("ArkVipReporter", 1, new Object[] { "initScene() sceneName=", paramString, ", enable =", Boolean.valueOf(jdField_a_of_type_Boolean) });
  }
  
  public static void a(String paramString, boolean paramBoolean, long paramLong, HashMap<String, String> paramHashMap)
  {
    if ((jdField_a_of_type_Boolean) && (bhbx.b()) && (!TextUtils.isEmpty(paramString))) {
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        aqcj localaqcj = a(paramString);
        if (localaqcj != null)
        {
          aqch localaqch = (aqch)b.get(localaqcj.jdField_a_of_type_JavaLangString);
          if (localaqch == null) {
            return;
          }
          aqcg localaqcg = new aqcg();
          localaqcg.jdField_a_of_type_JavaLangString = paramString;
          localaqcg.jdField_a_of_type_Int = localaqch.jdField_a_of_type_JavaUtilArrayList.size();
          localaqcg.jdField_a_of_type_Boolean = paramBoolean;
          localaqcg.jdField_b_of_type_Long = System.currentTimeMillis();
          localaqcg.jdField_c_of_type_Long = paramLong;
          localaqcg.jdField_a_of_type_Long = (localaqcg.jdField_b_of_type_Long - paramLong);
          localaqcg.d = NetworkUtil.getNetworkType(null);
          localaqcg.jdField_a_of_type_JavaUtilHashMap = paramHashMap;
          localaqch.jdField_a_of_type_JavaUtilArrayList.add(localaqcg);
          QLog.d("ArkVipReporter", 1, new Object[] { "addEventToScene() evt:", paramString, ", cost time=", Long.valueOf(paramLong) });
          if (paramString.equals(localaqcj.jdField_c_of_type_JavaLangString)) {
            b(localaqcj.jdField_a_of_type_JavaLangString);
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
      aqch localaqch = (aqch)b.remove(paramString);
      if (localaqch != null)
      {
        localaqch.jdField_b_of_type_Long = System.currentTimeMillis();
        localaqch.jdField_c_of_type_Long = (localaqch.jdField_b_of_type_Long - localaqch.jdField_a_of_type_Long);
        ??? = localaqch.a().toString();
        QLog.d("ArkVipReporter", 1, new Object[] { "report() sceneName:", paramString, ",total cost time=", Long.valueOf(localaqch.jdField_c_of_type_Long) });
        if (1 != BaseApplicationImpl.sProcessId) {
          break label137;
        }
        paramString = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
        if (paramString != null)
        {
          paramString = ((ArkAppCenter)paramString.getManager(QQManagerFactory.ARK_APP_CENTER_MANAGER)).a();
          if (paramString != null) {
            paramString.b((String)???);
          }
        }
      }
      return;
    }
    label137:
    paramString = new Bundle();
    paramString.putString("reportContent", (String)???);
    aqba.a().a("callVIPReport", paramString, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqci
 * JD-Core Version:    0.7.0.1
 */