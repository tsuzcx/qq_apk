import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BaseActivity;
import org.json.JSONException;
import org.json.JSONObject;

class ataw
  extends BroadcastReceiver
{
  ataw(atav paramatav) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    int i;
    JSONObject localJSONObject;
    if ((paramContext.equals(atav.a(this.a.b))) || (paramContext.equals(atav.d(this.a.b))))
    {
      i = paramIntent.getIntExtra("key_state", -1);
      atav.a(this.a, i);
      localJSONObject = atav.a(this.a, i);
      switch (i)
      {
      default: 
        this.a.callJs(this.a.a, new String[] { localJSONObject.toString() });
      }
    }
    do
    {
      for (;;)
      {
        return;
        l = paramIntent.getLongExtra("key_totalSize", 0L);
        atav.a(this.a, "size:" + l);
        try
        {
          localJSONObject.putOpt("totalSize", Long.valueOf(l));
          localJSONObject.remove("state");
        }
        catch (JSONException paramContext)
        {
          for (;;)
          {
            paramContext.printStackTrace();
          }
        }
      }
      int j = paramIntent.getIntExtra("key_progress", 0);
      long l = paramIntent.getLongExtra("key_totalSize", 0L);
      paramIntent = this.a;
      if (i == 1) {}
      for (paramContext = "progress:STATE_DOWANLOADING:" + j;; paramContext = "progress:STATE_LOADING:" + j)
      {
        for (;;)
        {
          atav.a(paramIntent, paramContext);
          if (i == 4)
          {
            if (j <= 90) {
              break;
            }
            atav.a(this.a).removeCallbacksAndMessages(null);
          }
          try
          {
            localJSONObject.putOpt("totalSize", Long.valueOf(l));
            localJSONObject.putOpt("pro", Integer.valueOf(j));
          }
          catch (JSONException paramContext)
          {
            paramContext.printStackTrace();
          }
        }
        break;
      }
      atav.a(this.a, "STATE_DOWANLODAD_COMPLETE");
      paramContext = Message.obtain();
      if (atav.a(this.a) == 1) {}
      for (paramContext.arg1 = 40; !TextUtils.equals(atav.a(this.a), "checkVersion"); paramContext.arg1 = 0)
      {
        atav.b(this.a, 0);
        atav.a(this.a).sendMessage(paramContext);
        break;
      }
      atav.a(this.a, "STATE_DOWANLODAD_FAILED");
      break;
      atav.a(this.a, "STATE_PRELOAD_FALIED");
      break;
      atav.a(this.a, "STATE_LOAD_COMPLETE");
      break;
      atav.a(this.a, "STATE_LOAD_FALIED");
      break;
      atav.a(this.a, "STATE_LAUNCHERING");
      break;
      atav.a(this.a, "STATE_LAUNCHER_SUCC");
      break;
      atav.a(this.a, "STATE_LAUNCHER_FAILED");
      break;
      if (atav.b(this.a.b).equals(paramContext))
      {
        paramContext = this.a.mRuntime.a();
        if ((paramContext instanceof BaseActivity))
        {
          ((BaseActivity)paramContext).doOnBackPressed();
          return;
        }
        paramContext.onBackPressed();
        return;
      }
    } while (!atav.c(this.a.b).equals(paramContext));
    atav.c(this.a, paramIntent.getIntExtra("key_isCache", -1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ataw
 * JD-Core Version:    0.7.0.1
 */