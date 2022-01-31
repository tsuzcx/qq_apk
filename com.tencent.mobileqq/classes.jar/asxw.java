import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import org.json.JSONObject;

class asxw
  extends BroadcastReceiver
{
  asxw(asxr paramasxr) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    int i;
    if ((paramContext.equals(aswm.a(asxr.b(this.a)))) || (paramContext.equals(aswm.d(asxr.b(this.a)))))
    {
      i = paramIntent.getIntExtra("key_state", -1);
      paramContext = asxr.a(this.a, i);
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
    asxx.a.a = 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asxw
 * JD-Core Version:    0.7.0.1
 */