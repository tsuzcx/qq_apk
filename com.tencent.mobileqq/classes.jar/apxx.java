import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONObject;

public class apxx
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
    jdField_a_of_type_JavaLangString = atyn.jdField_a_of_type_JavaLangString + "GameCenterMsgBean";
  }
  
  public apxx()
  {
    this.jdField_b_of_type_JavaLangString = atyf.jdField_b_of_type_JavaLangString;
    this.jdField_c_of_type_JavaLangString = atyf.jdField_c_of_type_JavaLangString;
  }
  
  public static apxx a(aptx[] paramArrayOfaptx)
  {
    if ((paramArrayOfaptx == null) || (paramArrayOfaptx.length <= 0))
    {
      a();
      return null;
    }
    QLog.i(jdField_a_of_type_JavaLangString, 1, "parse begins");
    apxx localapxx = new apxx();
    int i = 0;
    int k;
    for (int j = 0;; j = k)
    {
      if (i < paramArrayOfaptx.length)
      {
        String str = paramArrayOfaptx[i].jdField_a_of_type_JavaLangString;
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
            localapxx.jdField_c_of_type_Int = ((JSONObject)localObject).optInt("play_buddy_tmp_chat_switch");
            QLog.i(jdField_a_of_type_JavaLangString, 1, "playBuddySwitch:" + localapxx.jdField_c_of_type_Int);
            k = j;
            if (!((JSONObject)localObject).has("miniAppName")) {
              break label489;
            }
            localapxx.e = ((JSONObject)localObject).optString("miniAppName");
            QLog.i(jdField_a_of_type_JavaLangString, 1, "miniAppName:" + localapxx.e);
            k = j;
          }
        }
        catch (Throwable localThrowable)
        {
          QLog.e(jdField_a_of_type_JavaLangString, 1, localThrowable, new Object[0]);
          k = j;
        }
        if (((JSONObject)localObject).has("gameMsgFuncSwitch")) {
          localapxx.jdField_a_of_type_Int = ((JSONObject)localObject).optInt("gameMsgFuncSwitch");
        }
        if (((JSONObject)localObject).has("gameMsgListUrl")) {
          localapxx.jdField_b_of_type_JavaLangString = ((JSONObject)localObject).optString("gameMsgListUrl");
        }
        if (((JSONObject)localObject).has("gamePrefix")) {
          localapxx.jdField_c_of_type_JavaLangString = ((JSONObject)localObject).optString("gamePrefix");
        }
        if (((JSONObject)localObject).has("viewType")) {
          localapxx.jdField_b_of_type_Int = ((JSONObject)localObject).optInt("viewType", 0);
        }
        if (((JSONObject)localObject).has("playerInfoUrl")) {
          localapxx.d = ((JSONObject)localObject).optString("playerInfoUrl");
        }
        QLog.i(jdField_a_of_type_JavaLangString, 1, "[parse], mGraySwitch:" + localapxx.jdField_a_of_type_Int + ",url:" + localapxx.jdField_b_of_type_JavaLangString + ",playerInfo:" + localapxx.d);
        k = j;
      }
      else
      {
        if (j == 0) {
          a();
        }
        QLog.i(jdField_a_of_type_JavaLangString, 1, "parse ends");
        return localapxx;
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
  
  public void a(apxx paramapxx)
  {
    if (paramapxx == null) {}
    do
    {
      return;
      this.jdField_a_of_type_Int = paramapxx.jdField_a_of_type_Int;
      this.jdField_b_of_type_Int = paramapxx.jdField_b_of_type_Int;
      if (!TextUtils.isEmpty(paramapxx.jdField_b_of_type_JavaLangString)) {
        this.jdField_b_of_type_JavaLangString = paramapxx.jdField_b_of_type_JavaLangString;
      }
      if (!TextUtils.isEmpty(paramapxx.jdField_c_of_type_JavaLangString)) {
        this.jdField_c_of_type_JavaLangString = paramapxx.jdField_c_of_type_JavaLangString;
      }
    } while (TextUtils.isEmpty(paramapxx.d));
    this.d = paramapxx.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     apxx
 * JD-Core Version:    0.7.0.1
 */