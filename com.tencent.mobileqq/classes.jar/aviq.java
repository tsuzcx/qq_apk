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

class aviq
  extends BroadcastReceiver
{
  aviq(avip paramavip) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    int i;
    JSONObject localJSONObject;
    if ((paramContext.equals(avip.a(this.a.b))) || (paramContext.equals(avip.d(this.a.b))))
    {
      i = paramIntent.getIntExtra("key_state", -1);
      avip.a(this.a, i);
      localJSONObject = avip.a(this.a, i);
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
        avip.a(this.a, "size:" + l);
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
          avip.a(paramIntent, paramContext);
          if (i == 4)
          {
            if (j <= 90) {
              break;
            }
            avip.a(this.a).removeCallbacksAndMessages(null);
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
      avip.a(this.a, "STATE_DOWANLODAD_COMPLETE");
      paramContext = Message.obtain();
      if (avip.a(this.a) == 1) {}
      for (paramContext.arg1 = 40; !TextUtils.equals(avip.a(this.a), "checkVersion"); paramContext.arg1 = 0)
      {
        avip.b(this.a, 0);
        avip.a(this.a).sendMessage(paramContext);
        break;
      }
      avip.a(this.a, "STATE_DOWANLODAD_FAILED");
      break;
      avip.a(this.a, "STATE_PRELOAD_FALIED");
      break;
      avip.a(this.a, "STATE_LOAD_COMPLETE");
      break;
      avip.a(this.a, "STATE_LOAD_FALIED");
      break;
      avip.a(this.a, "STATE_LAUNCHERING");
      break;
      avip.a(this.a, "STATE_LAUNCHER_SUCC");
      break;
      avip.a(this.a, "STATE_LAUNCHER_FAILED");
      break;
      if (avip.b(this.a.b).equals(paramContext))
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
    } while (!avip.c(this.a.b).equals(paramContext));
    avip.c(this.a, paramIntent.getIntExtra("key_isCache", -1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aviq
 * JD-Core Version:    0.7.0.1
 */