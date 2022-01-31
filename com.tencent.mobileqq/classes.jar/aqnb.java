import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import org.json.JSONObject;

class aqnb
  extends BroadcastReceiver
{
  aqnb(aqmw paramaqmw) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    int i;
    if ((paramContext.equals(aqlr.a(aqmw.b(this.a)))) || (paramContext.equals(aqlr.d(aqmw.b(this.a)))))
    {
      i = paramIntent.getIntExtra("key_state", -1);
      paramContext = aqmw.a(this.a, i);
    }
    switch (i)
    {
    default: 
      return;
    case 9: 
    case 100: 
      this.a.callJs("notifyJsCallback", new String[] { paramContext.toString() });
      return;
    }
    aqnc.a.a = 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aqnb
 * JD-Core Version:    0.7.0.1
 */