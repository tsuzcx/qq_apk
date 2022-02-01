import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.agent.OpenSdkFriendService.CheckAvatarUpdateCallback.1;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class bjeu
  implements bjlh
{
  protected bjeu(bjet parambjet) {}
  
  public void a(Exception paramException)
  {
    bjko.c("OpenSdkFriendService", "CheckAvatarUpdate Exception. " + paramException.getMessage(), paramException);
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
        localObject = bjpy.a(bizw.a().a(), "prefer_last_avatar_update_time").edit();
        ((SharedPreferences.Editor)localObject).putString(this.a.b, paramJSONObject.getString("time"));
        ((SharedPreferences.Editor)localObject).commit();
        if (this.a.a != null) {
          this.a.a.a();
        }
      }
      else
      {
        bjko.e("OpenSdkFriendService", "CheckAvatarUpdateCallback error. ret=" + i + ", msg=" + (String)localObject);
        return;
      }
    }
    catch (JSONException paramJSONObject)
    {
      bjko.c("OpenSdkFriendService", "CheckAvatarUpdate Exception. " + paramJSONObject.getMessage(), paramJSONObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjeu
 * JD-Core Version:    0.7.0.1
 */