import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import org.json.JSONObject;

class arhg
  extends BroadcastReceiver
{
  arhg(arhb paramarhb) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    int i;
    if ((paramContext.equals(arfw.a(arhb.b(this.a)))) || (paramContext.equals(arfw.d(arhb.b(this.a)))))
    {
      i = paramIntent.getIntExtra("key_state", -1);
      paramContext = arhb.a(this.a, i);
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
    arhh.a.a = 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     arhg
 * JD-Core Version:    0.7.0.1
 */