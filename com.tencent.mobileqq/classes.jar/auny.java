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

class auny
  extends BroadcastReceiver
{
  auny(aunx paramaunx) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    int i;
    JSONObject localJSONObject;
    if ((paramContext.equals(aunx.a(this.a.b))) || (paramContext.equals(aunx.d(this.a.b))))
    {
      i = paramIntent.getIntExtra("key_state", -1);
      aunx.a(this.a, i);
      localJSONObject = aunx.a(this.a, i);
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
        aunx.a(this.a, "size:" + l);
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
          aunx.a(paramIntent, paramContext);
          if (i == 4)
          {
            if (j <= 90) {
              break;
            }
            aunx.a(this.a).removeCallbacksAndMessages(null);
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
      aunx.a(this.a, "STATE_DOWANLODAD_COMPLETE");
      paramContext = Message.obtain();
      if (aunx.a(this.a) == 1) {}
      for (paramContext.arg1 = 40; !TextUtils.equals(aunx.a(this.a), "checkVersion"); paramContext.arg1 = 0)
      {
        aunx.b(this.a, 0);
        aunx.a(this.a).sendMessage(paramContext);
        break;
      }
      aunx.a(this.a, "STATE_DOWANLODAD_FAILED");
      break;
      aunx.a(this.a, "STATE_PRELOAD_FALIED");
      break;
      aunx.a(this.a, "STATE_LOAD_COMPLETE");
      break;
      aunx.a(this.a, "STATE_LOAD_FALIED");
      break;
      aunx.a(this.a, "STATE_LAUNCHERING");
      break;
      aunx.a(this.a, "STATE_LAUNCHER_SUCC");
      break;
      aunx.a(this.a, "STATE_LAUNCHER_FAILED");
      break;
      if (aunx.b(this.a.b).equals(paramContext))
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
    } while (!aunx.c(this.a.b).equals(paramContext));
    aunx.c(this.a, paramIntent.getIntExtra("key_isCache", -1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auny
 * JD-Core Version:    0.7.0.1
 */