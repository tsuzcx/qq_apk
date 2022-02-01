import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONObject;

public class aqoz
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
    jdField_a_of_type_JavaLangString = autn.jdField_a_of_type_JavaLangString + "GameCenterMsgBean";
  }
  
  public aqoz()
  {
    this.jdField_b_of_type_JavaLangString = autf.jdField_b_of_type_JavaLangString;
    this.jdField_c_of_type_JavaLangString = autf.jdField_c_of_type_JavaLangString;
  }
  
  public static aqoz a(aqlg[] paramArrayOfaqlg)
  {
    if ((paramArrayOfaqlg == null) || (paramArrayOfaqlg.length <= 0))
    {
      a();
      return null;
    }
    QLog.i(jdField_a_of_type_JavaLangString, 1, "parse begins");
    aqoz localaqoz = new aqoz();
    int i = 0;
    int k;
    for (int j = 0;; j = k)
    {
      if (i < paramArrayOfaqlg.length)
      {
        String str = paramArrayOfaqlg[i].jdField_a_of_type_JavaLangString;
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
            localaqoz.jdField_c_of_type_Int = ((JSONObject)localObject).optInt("play_buddy_tmp_chat_switch");
            QLog.i(jdField_a_of_type_JavaLangString, 1, "playBuddySwitch:" + localaqoz.jdField_c_of_type_Int);
            k = j;
            if (!((JSONObject)localObject).has("miniAppName")) {
              break label489;
            }
            localaqoz.e = ((JSONObject)localObject).optString("miniAppName");
            QLog.i(jdField_a_of_type_JavaLangString, 1, "miniAppName:" + localaqoz.e);
            k = j;
          }
        }
        catch (Throwable localThrowable)
        {
          QLog.e(jdField_a_of_type_JavaLangString, 1, localThrowable, new Object[0]);
          k = j;
        }
        if (((JSONObject)localObject).has("gameMsgFuncSwitch")) {
          localaqoz.jdField_a_of_type_Int = ((JSONObject)localObject).optInt("gameMsgFuncSwitch");
        }
        if (((JSONObject)localObject).has("gameMsgListUrl")) {
          localaqoz.jdField_b_of_type_JavaLangString = ((JSONObject)localObject).optString("gameMsgListUrl");
        }
        if (((JSONObject)localObject).has("gamePrefix")) {
          localaqoz.jdField_c_of_type_JavaLangString = ((JSONObject)localObject).optString("gamePrefix");
        }
        if (((JSONObject)localObject).has("viewType")) {
          localaqoz.jdField_b_of_type_Int = ((JSONObject)localObject).optInt("viewType", 0);
        }
        if (((JSONObject)localObject).has("playerInfoUrl")) {
          localaqoz.d = ((JSONObject)localObject).optString("playerInfoUrl");
        }
        QLog.i(jdField_a_of_type_JavaLangString, 1, "[parse], mGraySwitch:" + localaqoz.jdField_a_of_type_Int + ",url:" + localaqoz.jdField_b_of_type_JavaLangString + ",playerInfo:" + localaqoz.d);
        k = j;
      }
      else
      {
        if (j == 0) {
          a();
        }
        QLog.i(jdField_a_of_type_JavaLangString, 1, "parse ends");
        return localaqoz;
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
  
  public void a(aqoz paramaqoz)
  {
    if (paramaqoz == null) {}
    do
    {
      return;
      this.jdField_a_of_type_Int = paramaqoz.jdField_a_of_type_Int;
      this.jdField_b_of_type_Int = paramaqoz.jdField_b_of_type_Int;
      if (!TextUtils.isEmpty(paramaqoz.jdField_b_of_type_JavaLangString)) {
        this.jdField_b_of_type_JavaLangString = paramaqoz.jdField_b_of_type_JavaLangString;
      }
      if (!TextUtils.isEmpty(paramaqoz.jdField_c_of_type_JavaLangString)) {
        this.jdField_c_of_type_JavaLangString = paramaqoz.jdField_c_of_type_JavaLangString;
      }
    } while (TextUtils.isEmpty(paramaqoz.d));
    this.d = paramaqoz.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqoz
 * JD-Core Version:    0.7.0.1
 */