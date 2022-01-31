import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import org.json.JSONObject;

class atcf
  extends BroadcastReceiver
{
  atcf(atca paramatca) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    int i;
    if ((paramContext.equals(atav.a(atca.b(this.a)))) || (paramContext.equals(atav.d(atca.b(this.a)))))
    {
      i = paramIntent.getIntExtra("key_state", -1);
      paramContext = atca.a(this.a, i);
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
    atcg.a.a = 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atcf
 * JD-Core Version:    0.7.0.1
 */