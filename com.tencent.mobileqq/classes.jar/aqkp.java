import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;

class aqkp
  extends BroadcastReceiver
{
  aqkp(aqkn paramaqkn) {}
  
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
      aqkn.a(this.a, paramIntent, aqkn.a(this.a));
      return;
    case 2: 
      aqkn.a(this.a, paramIntent, aqkn.b(this.a));
      return;
    case 3: 
      aqkn.a(this.a, paramIntent);
      return;
    }
    aqkn.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aqkp
 * JD-Core Version:    0.7.0.1
 */