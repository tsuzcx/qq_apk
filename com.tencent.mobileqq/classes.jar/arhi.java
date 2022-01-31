import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import org.json.JSONObject;

class arhi
  extends BroadcastReceiver
{
  arhi(arhd paramarhd) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    int i;
    if ((paramContext.equals(arfy.a(arhd.b(this.a)))) || (paramContext.equals(arfy.d(arhd.b(this.a)))))
    {
      i = paramIntent.getIntExtra("key_state", -1);
      paramContext = arhd.a(this.a, i);
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
    arhj.a.a = 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     arhi
 * JD-Core Version:    0.7.0.1
 */