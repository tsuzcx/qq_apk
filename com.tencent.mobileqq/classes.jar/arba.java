import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONObject;

public class arba
{
  public static final String a;
  public int a;
  public HashMap<String, ArrayList<String>> a;
  public int b;
  public String b;
  public int c;
  public String c;
  public String d = "";
  public String e = "";
  
  static
  {
    jdField_a_of_type_JavaLangString = avec.jdField_a_of_type_JavaLangString + "GameCenterMsgBean";
  }
  
  public arba()
  {
    this.jdField_b_of_type_JavaLangString = avdu.jdField_b_of_type_JavaLangString;
    this.jdField_c_of_type_JavaLangString = avdu.jdField_c_of_type_JavaLangString;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public static arba a(aqxa[] paramArrayOfaqxa)
  {
    if ((paramArrayOfaqxa == null) || (paramArrayOfaqxa.length <= 0))
    {
      a();
      return null;
    }
    QLog.i(jdField_a_of_type_JavaLangString, 1, "parse begins");
    arba localarba = new arba();
    int i = 0;
    int k;
    for (int j = 0;; j = k)
    {
      if (i < paramArrayOfaqxa.length)
      {
        String str = paramArrayOfaqxa[i].jdField_a_of_type_JavaLangString;
        Object localObject;
        try
        {
          localObject = new JSONObject(str);
          if (((JSONObject)localObject).has("AioQuickReply"))
          {
            QLog.i(jdField_a_of_type_JavaLangString, 1, "parse AioQuickReply");
            a((JSONObject)localObject, localarba);
            k = j;
          }
          else if (((JSONObject)localObject).has("trace_url_keyword"))
          {
            SharedPreferences localSharedPreferences = BaseApplicationImpl.sApplication.getSharedPreferences("game_center_sp_mutiprocess", 4);
            localObject = ((JSONObject)localObject).optJSONArray("trace_url_keyword");
            localSharedPreferences.edit().putString("trace_url_keyword" + a(), ((JSONArray)localObject).toString()).commit();
            QLog.i(jdField_a_of_type_JavaLangString, 1, "[parse] trace url:" + str);
            k = 1;
          }
          else if (((JSONObject)localObject).has("play_buddy_tmp_chat_switch"))
          {
            localarba.jdField_c_of_type_Int = ((JSONObject)localObject).optInt("play_buddy_tmp_chat_switch");
            QLog.i(jdField_a_of_type_JavaLangString, 1, "playBuddySwitch:" + localarba.jdField_c_of_type_Int);
            k = j;
            if (!((JSONObject)localObject).has("miniAppName")) {
              break label520;
            }
            localarba.e = ((JSONObject)localObject).optString("miniAppName");
            QLog.i(jdField_a_of_type_JavaLangString, 1, "miniAppName:" + localarba.e);
            k = j;
          }
        }
        catch (Throwable localThrowable)
        {
          QLog.e(jdField_a_of_type_JavaLangString, 1, localThrowable, new Object[0]);
          k = j;
        }
        if (((JSONObject)localObject).has("gameMsgFuncSwitch")) {
          localarba.jdField_a_of_type_Int = ((JSONObject)localObject).optInt("gameMsgFuncSwitch");
        }
        if (((JSONObject)localObject).has("gameMsgListUrl")) {
          localarba.jdField_b_of_type_JavaLangString = ((JSONObject)localObject).optString("gameMsgListUrl");
        }
        if (((JSONObject)localObject).has("gamePrefix")) {
          localarba.jdField_c_of_type_JavaLangString = ((JSONObject)localObject).optString("gamePrefix");
        }
        if (((JSONObject)localObject).has("viewType")) {
          localarba.jdField_b_of_type_Int = ((JSONObject)localObject).optInt("viewType", 0);
        }
        if (((JSONObject)localObject).has("playerInfoUrl")) {
          localarba.d = ((JSONObject)localObject).optString("playerInfoUrl");
        }
        QLog.i(jdField_a_of_type_JavaLangString, 1, "[parse], mGraySwitch:" + localarba.jdField_a_of_type_Int + ",url:" + localarba.jdField_b_of_type_JavaLangString + ",playerInfo:" + localarba.d);
        k = j;
      }
      else
      {
        if (j == 0) {
          a();
        }
        QLog.i(jdField_a_of_type_JavaLangString, 1, "parse ends");
        return localarba;
      }
      label520:
      i += 1;
    }
  }
  
  private static String a()
  {
    String str2 = "";
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    String str1 = str2;
    if (localAppRuntime != null)
    {
      str1 = str2;
      if (localAppRuntime.getLongAccountUin() != 0L) {
        str1 = localAppRuntime.getAccount();
      }
    }
    return str1;
  }
  
  public static void a()
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.sApplication.getSharedPreferences("game_center_sp_mutiprocess", 4);
    String str = "trace_url_keyword" + a();
    if (localSharedPreferences.contains(str))
    {
      QLog.i(jdField_a_of_type_JavaLangString, 1, "parse removeTraceKey");
      localSharedPreferences.edit().remove(str).commit();
    }
  }
  
  private static void a(JSONObject paramJSONObject, arba paramarba)
  {
    try
    {
      QLog.i(jdField_a_of_type_JavaLangString, 1, "[parseAioQuickReply]");
      if ((paramarba == null) || (paramarba.jdField_a_of_type_JavaUtilHashMap == null))
      {
        QLog.w(jdField_a_of_type_JavaLangString, 1, "param is null, return.");
        return;
      }
      paramarba.jdField_a_of_type_JavaUtilHashMap.clear();
      paramJSONObject = paramJSONObject.getJSONObject("AioQuickReply");
      Iterator localIterator = paramJSONObject.keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (!TextUtils.isEmpty(str))
        {
          JSONArray localJSONArray = paramJSONObject.getJSONArray(str);
          ArrayList localArrayList = new ArrayList();
          int i = 0;
          while (i < localJSONArray.length())
          {
            localArrayList.add(localJSONArray.get(i).toString());
            i += 1;
          }
          paramarba.jdField_a_of_type_JavaUtilHashMap.put(str, localArrayList);
        }
      }
      return;
    }
    catch (Throwable paramJSONObject)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, paramJSONObject, new Object[0]);
    }
  }
  
  public void a(arba paramarba)
  {
    if (paramarba == null) {}
    do
    {
      return;
      this.jdField_a_of_type_Int = paramarba.jdField_a_of_type_Int;
      this.jdField_b_of_type_Int = paramarba.jdField_b_of_type_Int;
      if (!TextUtils.isEmpty(paramarba.jdField_b_of_type_JavaLangString)) {
        this.jdField_b_of_type_JavaLangString = paramarba.jdField_b_of_type_JavaLangString;
      }
      if (!TextUtils.isEmpty(paramarba.jdField_c_of_type_JavaLangString)) {
        this.jdField_c_of_type_JavaLangString = paramarba.jdField_c_of_type_JavaLangString;
      }
    } while (TextUtils.isEmpty(paramarba.d));
    this.d = paramarba.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arba
 * JD-Core Version:    0.7.0.1
 */