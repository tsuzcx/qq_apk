import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.nearby.NearbyJsInterface;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class awio
  extends BroadcastReceiver
{
  public awio(NearbyJsInterface paramNearbyJsInterface) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("command_type", 0);
    QLog.i("NearbyJsInterface", 2, "receive request" + paramIntent.getExtras());
    switch (i)
    {
    }
    do
    {
      do
      {
        do
        {
          return;
        } while (TextUtils.isEmpty(NearbyJsInterface.a(this.a)));
        this.a.callJs(NearbyJsInterface.a(this.a), new String[] { paramIntent.getStringExtra("data") });
        NearbyJsInterface.a(this.a, "");
        return;
      } while (TextUtils.isEmpty(NearbyJsInterface.b(this.a)));
      this.a.callJs(NearbyJsInterface.b(this.a), new String[] { paramIntent.getStringExtra("data") });
      return;
    } while (TextUtils.isEmpty(NearbyJsInterface.c(this.a)));
    i = paramIntent.getIntExtra("exit_mode", 0);
    int j = paramIntent.getIntExtra("exit_action", 0);
    paramContext = new JSONObject();
    try
    {
      paramContext.put("mode", i);
      paramContext.put("action", j);
      this.a.callJs(NearbyJsInterface.c(this.a), new String[] { paramContext.toString() });
      NearbyJsInterface.b(this.a, "");
      return;
    }
    catch (JSONException paramContext)
    {
      for (;;)
      {
        QLog.e("NearbyJsInterface", 2, "onExitProfile, exp:" + paramContext.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awio
 * JD-Core Version:    0.7.0.1
 */