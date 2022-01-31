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

class aswn
  extends BroadcastReceiver
{
  aswn(aswm paramaswm) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    int i;
    JSONObject localJSONObject;
    if ((paramContext.equals(aswm.a(this.a.b))) || (paramContext.equals(aswm.d(this.a.b))))
    {
      i = paramIntent.getIntExtra("key_state", -1);
      aswm.a(this.a, i);
      localJSONObject = aswm.a(this.a, i);
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
        aswm.a(this.a, "size:" + l);
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
          aswm.a(paramIntent, paramContext);
          if (i == 4)
          {
            if (j <= 90) {
              break;
            }
            aswm.a(this.a).removeCallbacksAndMessages(null);
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
      aswm.a(this.a, "STATE_DOWANLODAD_COMPLETE");
      paramContext = Message.obtain();
      if (aswm.a(this.a) == 1) {}
      for (paramContext.arg1 = 40; !TextUtils.equals(aswm.a(this.a), "checkVersion"); paramContext.arg1 = 0)
      {
        aswm.b(this.a, 0);
        aswm.a(this.a).sendMessage(paramContext);
        break;
      }
      aswm.a(this.a, "STATE_DOWANLODAD_FAILED");
      break;
      aswm.a(this.a, "STATE_PRELOAD_FALIED");
      break;
      aswm.a(this.a, "STATE_LOAD_COMPLETE");
      break;
      aswm.a(this.a, "STATE_LOAD_FALIED");
      break;
      aswm.a(this.a, "STATE_LAUNCHERING");
      break;
      aswm.a(this.a, "STATE_LAUNCHER_SUCC");
      break;
      aswm.a(this.a, "STATE_LAUNCHER_FAILED");
      break;
      if (aswm.b(this.a.b).equals(paramContext))
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
    } while (!aswm.c(this.a.b).equals(paramContext));
    aswm.c(this.a, paramIntent.getIntExtra("key_isCache", -1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aswn
 * JD-Core Version:    0.7.0.1
 */