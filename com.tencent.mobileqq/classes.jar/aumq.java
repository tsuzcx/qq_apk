import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;

class aumq
  extends BroadcastReceiver
{
  aumq(aumo paramaumo) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("command_type", 0);
    QLog.i("GroupVideoManager|Communicate", 2, "get message from plugin: " + paramIntent.getExtras());
    switch (i)
    {
    case 4: 
    default: 
      return;
    case 1: 
      aumo.a(this.a, paramIntent, aumo.a(this.a));
      return;
    case 2: 
      aumo.a(this.a, paramIntent, aumo.b(this.a));
      return;
    case 3: 
      aumo.a(this.a, paramIntent);
      return;
    }
    aumo.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aumq
 * JD-Core Version:    0.7.0.1
 */