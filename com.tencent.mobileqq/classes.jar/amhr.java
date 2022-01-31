import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class amhr
  implements amhm
{
  public void a(Context paramContext, ColorNote paramColorNote)
  {
    Object localObject1 = paramColorNote.getSubType();
    if (((String)localObject1).startsWith("qzone_detail")) {}
    do
    {
      try
      {
        Object localObject2 = new JSONObject(new String(paramColorNote.getReserve()));
        int i = ((JSONObject)localObject2).getInt("appid");
        paramColorNote = ((JSONObject)localObject2).getString("cellid");
        localObject1 = ((JSONObject)localObject2).getString("subid");
        long l = ((JSONObject)localObject2).getLong("uin");
        ((JSONObject)localObject2).getString("source");
        boolean bool = ((JSONObject)localObject2).getBoolean("mIsFromKuolie");
        String str = ((JSONObject)localObject2).getString("mainTitle");
        localObject2 = ((JSONObject)localObject2).getString("subType");
        Bundle localBundle = new Bundle();
        localBundle.putBoolean("req_from_kuolie", bool);
        localBundle.putString("mainTitle", str);
        localBundle.putString("subType", (String)localObject2);
        bgyp.a(paramContext, bgyw.a(), Long.valueOf(l).toString(), i + "", paramColorNote, (String)localObject1, 0, localBundle, true, true);
        return;
      }
      catch (JSONException paramContext)
      {
        QLog.e("QZoneLauncher", 1, paramContext, new Object[0]);
        return;
      }
      if (((String)localObject1).startsWith("qzone_userhome")) {
        try
        {
          paramColorNote = new JSONObject(new String(paramColorNote.getReserve())).getString("visitUin");
          bgyp.a(paramContext, bgyw.a(), paramColorNote, 0, 0, 0, null, null, true);
          return;
        }
        catch (JSONException paramContext)
        {
          QLog.e("QZoneLauncher", 1, paramContext, new Object[0]);
          return;
        }
      }
    } while (!((String)localObject1).startsWith("qzone_famous_userhome"));
    try
    {
      localObject1 = new JSONObject(new String(paramColorNote.getReserve()));
      paramColorNote = ((JSONObject)localObject1).getString("visitUin");
      localObject1 = ((JSONObject)localObject1).getString("webviewUrl");
      bgyp.a(paramContext, bgyw.a(), paramColorNote, 0, 0, null, (String)localObject1, true);
      return;
    }
    catch (JSONException paramContext)
    {
      QLog.e("QZoneLauncher", 1, paramContext, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     amhr
 * JD-Core Version:    0.7.0.1
 */