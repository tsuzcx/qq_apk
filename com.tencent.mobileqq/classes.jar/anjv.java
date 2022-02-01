import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.utils.ApolloConfigDataReport.1;
import com.tencent.mobileqq.apollo.utils.ApolloConfigDataReport.2;
import com.tencent.mobileqq.apollo.utils.ApolloConfigDataReport.3;
import com.tencent.mobileqq.apollo.utils.ApolloConfigDataReport.4;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerReq;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerReqComm;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import org.json.JSONArray;
import org.json.JSONObject;

public class anjv
{
  private static HashSet<String> jdField_a_of_type_JavaUtilHashSet;
  private static JSONObject jdField_a_of_type_OrgJsonJSONObject;
  private static HashSet<String> b;
  private static HashSet<String> c;
  
  private static String a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("dwtuin=").append(paramString1).append("&sop_type=").append(paramString2).append("&sop_name=").append(paramString3).append("&dwop_via=").append(paramInt1).append("&dwop_cnt=").append(1).append("&dwop_result=").append(paramInt2).append("&dwflag2=").append(paramString4).append("&dwflag3=").append(paramString5).append("&dwflag4=").append(paramString6).append("&dwflag5=").append(paramString7);
    return localStringBuilder.toString();
  }
  
  public static HashSet<String> a()
  {
    if (b == null) {
      ThreadManager.excute(new ApolloConfigDataReport.2(), 64, null, true);
    }
    return b;
  }
  
  public static void a()
  {
    if (jdField_a_of_type_JavaUtilHashSet != null) {
      jdField_a_of_type_JavaUtilHashSet.clear();
    }
    if (b != null) {
      b.clear();
    }
    if (c != null) {
      c.clear();
    }
  }
  
  public static void a(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    if (((paramAppInterface == null) || (!(paramAppInterface instanceof QQAppInterface))) && (jdField_a_of_type_JavaUtilHashSet == null)) {
      ThreadManager.excute(new ApolloConfigDataReport.4(), 64, null, true);
    }
    if ((jdField_a_of_type_JavaUtilHashSet != null) && (jdField_a_of_type_JavaUtilHashSet.contains(paramString3))) {
      try
      {
        paramAppInterface = BaseApplicationImpl.sApplication.getRuntime();
        if (paramAppInterface == null)
        {
          QLog.e("ApolloConfigDataReport", 1, "interceptReport appRuntime is null");
          return;
        }
        Object localObject = new WebSSOAgent.UniSsoServerReqComm();
        ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
        ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
        ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("8.4.10");
        paramString1 = new WebSSOAgent.UniSsoServerReq();
        paramString1.comm.set((MessageMicro)localObject);
        localObject = new JSONObject();
        ((JSONObject)localObject).put("cmd", "apollo_dc_report.forward_data");
        ((JSONObject)localObject).put("from", "android");
        ((JSONObject)localObject).put("dcId", "644");
        paramString2 = a(paramString4, paramString2, paramString3, paramInt1, paramInt2, paramString5, paramString6, paramString7, paramString8);
        ((JSONObject)localObject).put("fields_data", paramString2);
        paramString1.reqdata.set(((JSONObject)localObject).toString());
        if (QLog.isColorLevel()) {
          QLog.d("ApolloConfigDataReport", 2, new Object[] { "interceptReport sop_name:", paramString3, ",fields_data:", paramString2 });
        }
        paramString2 = new NewIntent(BaseApplicationImpl.sApplication.getApplicationContext(), awcn.class);
        paramString2.putExtra("extra_cmd", "apollo_dc_report.forward_data");
        paramString2.putExtra("extra_data", paramString1.toByteArray());
        paramString2.putExtra("extra_timeout", 15000);
        paramString2.setObserver(new anjx());
        paramAppInterface.startServlet(paramString2);
        return;
      }
      catch (Exception paramAppInterface)
      {
        QLog.e("ApolloConfigDataReport", 1, "interceptReport Exception:", paramAppInterface);
        paramAppInterface.printStackTrace();
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    c();
    b(paramQQAppInterface);
  }
  
  public static HashSet<String> b()
  {
    if (c == null) {
      ThreadManager.excute(new ApolloConfigDataReport.3(), 64, null, true);
    }
    return c;
  }
  
  private static HashSet<String> b(int paramInt, JSONObject paramJSONObject)
  {
    HashSet localHashSet = new HashSet();
    if (paramJSONObject == null)
    {
      QLog.e("ApolloConfigDataReport", 1, "storeStabilityWatchCMDList mBaseJSONObj is null");
      return localHashSet;
    }
    if (paramInt == 1) {}
    for (;;)
    {
      try
      {
        paramJSONObject = paramJSONObject.optJSONArray("store_stable_watch_cmd_list");
        if ((paramJSONObject == null) || (paramJSONObject.length() <= 0)) {
          break;
        }
        paramInt = 0;
        if (paramInt >= paramJSONObject.length()) {
          break;
        }
        String str = paramJSONObject.optString(paramInt);
        if (TextUtils.isEmpty(str)) {
          break label113;
        }
        localHashSet.add(str);
      }
      catch (Exception paramJSONObject)
      {
        QLog.e("ApolloConfigDataReport", 1, "storeStabilityWatchCMDList Exception e:", paramJSONObject);
        return localHashSet;
      }
      if (paramInt == 2)
      {
        paramJSONObject = paramJSONObject.optJSONArray("store_stable_watch_url_list");
      }
      else
      {
        paramJSONObject = null;
        continue;
        label113:
        paramInt += 1;
      }
    }
  }
  
  private static HashSet<String> b(JSONObject paramJSONObject)
  {
    localHashSet = new HashSet();
    if (paramJSONObject == null) {
      QLog.e("ApolloConfigDataReport", 1, "parseReportConfigJson mBaseJSONObj is null");
    }
    for (;;)
    {
      return localHashSet;
      try
      {
        paramJSONObject = paramJSONObject.optJSONArray("644_opname");
        if ((paramJSONObject == null) || (paramJSONObject.length() <= 0)) {
          continue;
        }
        int i = 0;
        while (i < paramJSONObject.length())
        {
          String str = paramJSONObject.optString(i);
          if (!TextUtils.isEmpty(str)) {
            localHashSet.add(str);
          }
          i += 1;
        }
        return localHashSet;
      }
      catch (Exception paramJSONObject)
      {
        QLog.e("ApolloConfigDataReport", 1, "parseReportConfigJson Exception e:", paramJSONObject);
      }
    }
  }
  
  private static JSONObject b()
  {
    Object localObject1 = FileUtils.readFile("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/apollo_report_config.json");
    if (localObject1 == null)
    {
      QLog.e("ApolloConfigDataReport", 1, "parseBasicJson file is null");
      return null;
    }
    localObject1 = new String((byte[])localObject1);
    try
    {
      localObject1 = new JSONObject((String)localObject1).optJSONArray("terminalForword");
      if ((localObject1 == null) || (((JSONArray)localObject1).length() <= 0)) {
        break label80;
      }
      localObject1 = ((JSONArray)localObject1).optJSONObject(0);
      if (localObject1 == null) {
        break label80;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("ApolloConfigDataReport", 1, "parseBasicJson Exception e:", localException);
        Object localObject2 = null;
      }
    }
    return localObject1;
  }
  
  public static void b(QQAppInterface paramQQAppInterface)
  {
    if (!NetworkUtil.isNetworkAvailable(null)) {
      return;
    }
    ThreadManager.excute(new ApolloConfigDataReport.1(paramQQAppInterface), 128, null, true);
  }
  
  private static void c()
  {
    jdField_a_of_type_OrgJsonJSONObject = b();
    jdField_a_of_type_JavaUtilHashSet = b(jdField_a_of_type_OrgJsonJSONObject);
    b = b(1, jdField_a_of_type_OrgJsonJSONObject);
    c = b(2, jdField_a_of_type_OrgJsonJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anjv
 * JD-Core Version:    0.7.0.1
 */