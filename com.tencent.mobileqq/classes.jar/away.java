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

class away
  extends BroadcastReceiver
{
  away(awax paramawax) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    int i;
    JSONObject localJSONObject;
    if ((paramContext.equals(awax.a(this.a.b))) || (paramContext.equals(awax.d(this.a.b))))
    {
      i = paramIntent.getIntExtra("key_state", -1);
      awax.a(this.a, i);
      localJSONObject = awax.a(this.a, i);
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
        awax.a(this.a, "size:" + l);
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
          awax.a(paramIntent, paramContext);
          if (i == 4)
          {
            if (j <= 90) {
              break;
            }
            awax.a(this.a).removeCallbacksAndMessages(null);
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
      awax.a(this.a, "STATE_DOWANLODAD_COMPLETE");
      paramContext = Message.obtain();
      if (awax.a(this.a) == 1) {}
      for (paramContext.arg1 = 40; !TextUtils.equals(awax.a(this.a), "checkVersion"); paramContext.arg1 = 0)
      {
        awax.b(this.a, 0);
        awax.a(this.a).sendMessage(paramContext);
        break;
      }
      awax.a(this.a, "STATE_DOWANLODAD_FAILED");
      break;
      awax.a(this.a, "STATE_PRELOAD_FALIED");
      break;
      awax.a(this.a, "STATE_LOAD_COMPLETE");
      break;
      awax.a(this.a, "STATE_LOAD_FALIED");
      break;
      awax.a(this.a, "STATE_LAUNCHERING");
      break;
      awax.a(this.a, "STATE_LAUNCHER_SUCC");
      break;
      awax.a(this.a, "STATE_LAUNCHER_FAILED");
      break;
      if (awax.b(this.a.b).equals(paramContext))
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
    } while (!awax.c(this.a.b).equals(paramContext));
    awax.c(this.a, paramIntent.getIntExtra("key_isCache", -1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     away
 * JD-Core Version:    0.7.0.1
 */