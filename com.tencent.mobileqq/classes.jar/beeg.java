import android.net.Uri;
import android.net.Uri.Builder;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.CookieManager;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class beeg
{
  public static String a;
  private static HashMap<String, Long> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private static JSONObject jdField_a_of_type_OrgJsonJSONObject;
  private static String[] jdField_a_of_type_ArrayOfJavaLangString;
  
  static
  {
    jdField_a_of_type_JavaLangString = "";
    jdField_a_of_type_OrgJsonJSONObject = new JSONObject();
    jdField_a_of_type_ArrayOfJavaLangString = new String[2];
  }
  
  public static long a(String paramString)
  {
    paramString = (Long)jdField_a_of_type_JavaUtilHashMap.remove(paramString);
    if (paramString != null) {
      return SystemClock.elapsedRealtime() - paramString.longValue();
    }
    return 0L;
  }
  
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (paramString = "";; paramString = paramString.hashCode() + "_" + System.currentTimeMillis())
    {
      jdField_a_of_type_JavaLangString = paramString;
      QLog.d("TenDocLogReportHelper", 2, "init trace id: " + jdField_a_of_type_JavaLangString);
      return jdField_a_of_type_JavaLangString;
    }
  }
  
  public static String a(String paramString1, String paramString2)
  {
    String str;
    if (paramString1 == null) {
      str = null;
    }
    Uri localUri;
    do
    {
      return str;
      localUri = Uri.parse(paramString1);
      str = paramString1;
    } while (!TextUtils.isEmpty(localUri.getQueryParameter("xiaolv_wy_tdoc_tid")));
    QLog.d("TenDocLogReportHelper", 2, "trace url: " + paramString1 + ",traceId: " + paramString2);
    paramString1 = localUri.buildUpon();
    paramString1.appendQueryParameter("xiaolv_wy_tdoc_tid", paramString2);
    return paramString1.toString();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    bdla.b(paramQQAppInterface, "dc00898", "", "", paramString, paramString, 0, 0, "", "", "", "");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    a(jdField_a_of_type_ArrayOfJavaLangString, paramString1, paramString3, paramString4, paramString5);
    bdla.b(paramQQAppInterface, "dc00898", "", "", paramString2, paramString2, 0, 0, "", "", jdField_a_of_type_ArrayOfJavaLangString[0], jdField_a_of_type_ArrayOfJavaLangString[1]);
    if (QLog.isColorLevel()) {
      QLog.d("TenDocLogReportHelper", 2, "reportTDW: traceId=" + paramString1 + " T=" + paramString2 + " value=" + paramString3 + " extra1=" + paramString4 + " extra2=" + paramString5);
    }
  }
  
  public static void a(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    if (paramTeamWorkFileImportInfo == null) {
      return;
    }
    if (TextUtils.isEmpty(paramTeamWorkFileImportInfo.k))
    {
      paramTeamWorkFileImportInfo.k = a(paramTeamWorkFileImportInfo.b);
      return;
    }
    QLog.d("TenDocLogReportHelper", 2, "has setted trace Id: " + paramTeamWorkFileImportInfo.k);
  }
  
  public static void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    jdField_a_of_type_JavaUtilHashMap.put(paramString, Long.valueOf(SystemClock.elapsedRealtime()));
  }
  
  public static void a(String paramString1, String paramString2, String paramString3)
  {
    QLog.d(paramString1, 2, "tencentdoc log:" + paramString2 + " - " + paramString3);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    QLog.d(paramString1, 2, "tencentdoc log:" + paramString2 + " - " + paramString3 + " - " + paramString4);
  }
  
  private static void a(String[] paramArrayOfString, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    try
    {
      jdField_a_of_type_OrgJsonJSONObject.put("trace", paramString1);
      jdField_a_of_type_OrgJsonJSONObject.put("value", paramString2);
      jdField_a_of_type_OrgJsonJSONObject.put("extra1", paramString3);
      jdField_a_of_type_OrgJsonJSONObject.put("extra2", paramString4);
      paramString1 = jdField_a_of_type_OrgJsonJSONObject.toString();
      int i = paramString1.length();
      int j = i / 2;
      paramArrayOfString[0] = paramString1.substring(0, j);
      paramArrayOfString[1] = paramString1.substring(j, i);
      return;
    }
    catch (JSONException paramArrayOfString)
    {
      QLog.e("TenDocLogReportHelper", 2, "report fail", paramArrayOfString);
    }
  }
  
  public static boolean a(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(paramString)) {
      if (!paramString.contains("docs.qq.com"))
      {
        bool1 = bool2;
        if (!paramString.contains("docx.qq.com")) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static String b(String paramString)
  {
    if (paramString == null) {
      paramString = null;
    }
    Uri localUri;
    do
    {
      return paramString;
      localUri = Uri.parse(paramString);
    } while (!TextUtils.isEmpty(localUri.getQueryParameter("showDiscuss")));
    paramString = localUri.buildUpon();
    paramString.appendQueryParameter("showDiscuss", "true");
    return paramString.toString();
  }
  
  public static void b(String paramString1, String paramString2, String paramString3)
  {
    String str;
    if (a(paramString1))
    {
      str = "ps_key:" + b(paramString1);
      paramString1 = c(paramString1);
      if (TextUtils.isEmpty(paramString1)) {
        a(paramString2, paramString3, str);
      }
    }
    else
    {
      return;
    }
    a(paramString2, paramString3, str, paramString1);
  }
  
  public static void b(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (a(paramString1))
    {
      paramString1 = c(paramString1);
      if (TextUtils.isEmpty(paramString1)) {
        a(paramString2, paramString3, paramString4);
      }
    }
    else
    {
      return;
    }
    a(paramString2, paramString3, paramString4, paramString1);
  }
  
  private static boolean b(String paramString)
  {
    paramString = CookieManager.getInstance().getCookie(paramString);
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = paramString.split(";");
      int j = paramString.length;
      int i = 0;
      while (i < j)
      {
        String[] arrayOfString = paramString[i];
        if ((arrayOfString != null) && (arrayOfString.contains("p_skey")))
        {
          arrayOfString = arrayOfString.split("=");
          if ((arrayOfString.length > 1) && (!TextUtils.isEmpty(arrayOfString[1]))) {
            return true;
          }
        }
        i += 1;
      }
    }
    return false;
  }
  
  public static String c(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return Uri.parse(paramString).getQueryParameter("xiaolv_wy_tdoc_tid");
  }
  
  public static String d(String paramString)
  {
    String str = c(paramString);
    if (!TextUtils.isEmpty(str)) {}
    int i;
    do
    {
      return str;
      i = paramString.indexOf("?");
      str = paramString;
    } while (i == -1);
    return paramString.substring(0, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beeg
 * JD-Core Version:    0.7.0.1
 */