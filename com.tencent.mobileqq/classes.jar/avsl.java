import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;

class avsl
  extends BroadcastReceiver
{
  avsl(avsj paramavsj) {}
  
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
      avsj.a(this.a, paramIntent, avsj.a(this.a));
      return;
    case 2: 
      avsj.a(this.a, paramIntent, avsj.b(this.a));
      return;
    case 3: 
      avsj.a(this.a, paramIntent);
      return;
    }
    avsj.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avsl
 * JD-Core Version:    0.7.0.1
 */