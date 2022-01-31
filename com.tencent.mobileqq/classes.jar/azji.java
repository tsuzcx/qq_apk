import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.aio.photo.AIOShortVideoData;
import org.json.JSONException;
import org.json.JSONObject;

class azji
  extends BroadcastReceiver
{
  azji(azjh paramazjh) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {}
    for (;;)
    {
      return;
      paramContext = paramIntent.getStringExtra("event");
      if (paramContext != null)
      {
        paramIntent = paramIntent.getStringExtra("data");
        if ((paramIntent != null) && (paramContext.equals("ShortVideoHongbaoInfoUpdate"))) {
          try
          {
            paramContext = new JSONObject(paramIntent);
            paramIntent = paramContext.optString("shortVideoId");
            boolean bool = paramContext.optBoolean("isPaid");
            if ((azjh.a(this.a) != null) && (azjh.a(this.a).h != 1) && (bool) && (azjh.a(this.a).c.equals(paramIntent)))
            {
              new azjq(this.a).execute(new String[0]);
              return;
            }
          }
          catch (JSONException paramContext) {}
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azji
 * JD-Core Version:    0.7.0.1
 */