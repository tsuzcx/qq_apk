import android.text.TextUtils;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import cooperation.troop_homework.TroopHomeworkHelper;
import cooperation.troop_homework.jsp.TroopHWJsPlugin;
import mqq.app.AppRuntime;
import mqq.manager.TicketManager;
import org.json.JSONException;
import org.json.JSONObject;

public class anft
  implements Runnable
{
  public anft(TroopHWJsPlugin paramTroopHWJsPlugin, String paramString) {}
  
  public void run()
  {
    Object localObject2 = this.jdField_a_of_type_CooperationTroop_homeworkJspTroopHWJsPlugin.mRuntime.a();
    Object localObject1 = (TicketManager)((AppRuntime)localObject2).getManager(2);
    localObject2 = ((AppRuntime)localObject2).getAccount();
    localObject1 = ((TicketManager)localObject1).getSkey((String)localObject2);
    if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.jdField_a_of_type_CooperationTroop_homeworkJspTroopHWJsPlugin.h)))
    {
      localObject1 = TroopHomeworkHelper.a(this.jdField_a_of_type_CooperationTroop_homeworkJspTroopHWJsPlugin.h, this.jdField_a_of_type_JavaLangString, (String)localObject2, (String)localObject1, 1234567L);
      if (localObject1 == null) {}
    }
    try
    {
      localObject1 = new JSONObject((String)localObject1);
      if (((JSONObject)localObject1).optInt("retcode", -1) == 0)
      {
        localObject1 = ((JSONObject)localObject1).optJSONObject("data");
        if (localObject1 != null)
        {
          localObject1 = ((JSONObject)localObject1).optString("url");
          localObject2 = new JSONObject();
          ((JSONObject)localObject2).put("id", this.jdField_a_of_type_CooperationTroop_homeworkJspTroopHWJsPlugin.d - 1);
          ((JSONObject)localObject2).put("state", "uploaded");
          ((JSONObject)localObject2).put("url", localObject1);
          this.jdField_a_of_type_CooperationTroop_homeworkJspTroopHWJsPlugin.callJs(this.jdField_a_of_type_CooperationTroop_homeworkJspTroopHWJsPlugin.b, new String[] { ((JSONObject)localObject2).toString() });
        }
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anft
 * JD-Core Version:    0.7.0.1
 */