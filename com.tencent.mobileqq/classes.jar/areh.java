import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONObject;

public class areh
{
  public static final String a;
  public int a;
  public int b;
  public String b;
  public int c;
  public String c;
  public String d = "";
  public String e = "";
  
  static
  {
    jdField_a_of_type_JavaLangString = avln.jdField_a_of_type_JavaLangString + "GameCenterMsgBean";
  }
  
  public areh()
  {
    this.jdField_b_of_type_JavaLangString = avlf.jdField_b_of_type_JavaLangString;
    this.jdField_c_of_type_JavaLangString = avlf.jdField_c_of_type_JavaLangString;
  }
  
  public static areh a(araj[] paramArrayOfaraj)
  {
    if ((paramArrayOfaraj == null) || (paramArrayOfaraj.length <= 0))
    {
      a();
      return null;
    }
    QLog.i(jdField_a_of_type_JavaLangString, 1, "parse begins");
    areh localareh = new areh();
    int i = 0;
    int k;
    for (int j = 0;; j = k)
    {
      if (i < paramArrayOfaraj.length)
      {
        String str = paramArrayOfaraj[i].jdField_a_of_type_JavaLangString;
        Object localObject;
        try
        {
          localObject = new JSONObject(str);
          if (((JSONObject)localObject).has("trace_url_keyword"))
          {
            SharedPreferences localSharedPreferences = BaseApplicationImpl.sApplication.getSharedPreferences("game_center_sp_mutiprocess", 4);
            localObject = ((JSONObject)localObject).optJSONArray("trace_url_keyword");
            localSharedPreferences.edit().putString("trace_url_keyword" + a(), ((JSONArray)localObject).toString()).commit();
            QLog.i(jdField_a_of_type_JavaLangString, 1, "[parse] trace url:" + str);
            k = 1;
          }
          else if (((JSONObject)localObject).has("play_buddy_tmp_chat_switch"))
          {
            localareh.jdField_c_of_type_Int = ((JSONObject)localObject).optInt("play_buddy_tmp_chat_switch");
            QLog.i(jdField_a_of_type_JavaLangString, 1, "playBuddySwitch:" + localareh.jdField_c_of_type_Int);
            k = j;
            if (!((JSONObject)localObject).has("miniAppName")) {
              break label489;
            }
            localareh.e = ((JSONObject)localObject).optString("miniAppName");
            QLog.i(jdField_a_of_type_JavaLangString, 1, "miniAppName:" + localareh.e);
            k = j;
          }
        }
        catch (Throwable localThrowable)
        {
          QLog.e(jdField_a_of_type_JavaLangString, 1, localThrowable, new Object[0]);
          k = j;
        }
        if (((JSONObject)localObject).has("gameMsgFuncSwitch")) {
          localareh.jdField_a_of_type_Int = ((JSONObject)localObject).optInt("gameMsgFuncSwitch");
        }
        if (((JSONObject)localObject).has("gameMsgListUrl")) {
          localareh.jdField_b_of_type_JavaLangString = ((JSONObject)localObject).optString("gameMsgListUrl");
        }
        if (((JSONObject)localObject).has("gamePrefix")) {
          localareh.jdField_c_of_type_JavaLangString = ((JSONObject)localObject).optString("gamePrefix");
        }
        if (((JSONObject)localObject).has("viewType")) {
          localareh.jdField_b_of_type_Int = ((JSONObject)localObject).optInt("viewType", 0);
        }
        if (((JSONObject)localObject).has("playerInfoUrl")) {
          localareh.d = ((JSONObject)localObject).optString("playerInfoUrl");
        }
        QLog.i(jdField_a_of_type_JavaLangString, 1, "[parse], mGraySwitch:" + localareh.jdField_a_of_type_Int + ",url:" + localareh.jdField_b_of_type_JavaLangString + ",playerInfo:" + localareh.d);
        k = j;
      }
      else
      {
        if (j == 0) {
          a();
        }
        QLog.i(jdField_a_of_type_JavaLangString, 1, "parse ends");
        return localareh;
      }
      label489:
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
  
  public void a(areh paramareh)
  {
    if (paramareh == null) {}
    do
    {
      return;
      this.jdField_a_of_type_Int = paramareh.jdField_a_of_type_Int;
      this.jdField_b_of_type_Int = paramareh.jdField_b_of_type_Int;
      if (!TextUtils.isEmpty(paramareh.jdField_b_of_type_JavaLangString)) {
        this.jdField_b_of_type_JavaLangString = paramareh.jdField_b_of_type_JavaLangString;
      }
      if (!TextUtils.isEmpty(paramareh.jdField_c_of_type_JavaLangString)) {
        this.jdField_c_of_type_JavaLangString = paramareh.jdField_c_of_type_JavaLangString;
      }
    } while (TextUtils.isEmpty(paramareh.d));
    this.d = paramareh.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     areh
 * JD-Core Version:    0.7.0.1
 */