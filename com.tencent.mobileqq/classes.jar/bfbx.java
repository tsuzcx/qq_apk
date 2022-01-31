import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.agent.OpenSdkFriendService.CheckAvatarUpdateCallback.1;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class bfbx
  implements bfic
{
  protected bfbx(bfbw parambfbw) {}
  
  public void a(Exception paramException)
  {
    bfhg.c("OpenSdkFriendService", "CheckAvatarUpdate Exception. " + paramException.getMessage(), paramException);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    try
    {
      int i = paramJSONObject.getInt("ret");
      Object localObject = paramJSONObject.getString("msg");
      if (i == 0)
      {
        localObject = paramJSONObject.getJSONArray("update_list");
        i = ((JSONArray)localObject).length();
        if (i > 0) {
          ThreadManager.executeOnSubThread(new OpenSdkFriendService.CheckAvatarUpdateCallback.1(this, i, (JSONArray)localObject));
        }
        localObject = bfmy.a(bexd.a().a(), "prefer_last_avatar_update_time").edit();
        ((SharedPreferences.Editor)localObject).putString(this.a.b, paramJSONObject.getString("time"));
        ((SharedPreferences.Editor)localObject).commit();
        if (this.a.a != null) {
          this.a.a.a();
        }
      }
      else
      {
        bfhg.e("OpenSdkFriendService", "CheckAvatarUpdateCallback error. ret=" + i + ", msg=" + (String)localObject);
        return;
      }
    }
    catch (JSONException paramJSONObject)
    {
      bfhg.c("OpenSdkFriendService", "CheckAvatarUpdate Exception. " + paramJSONObject.getMessage(), paramJSONObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfbx
 * JD-Core Version:    0.7.0.1
 */