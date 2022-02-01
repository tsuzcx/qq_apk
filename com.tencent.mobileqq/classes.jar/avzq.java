import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;

class avzq
  extends BroadcastReceiver
{
  avzq(avzo paramavzo) {}
  
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
      avzo.a(this.a, paramIntent, avzo.a(this.a));
      return;
    case 2: 
      avzo.a(this.a, paramIntent, avzo.b(this.a));
      return;
    case 3: 
      avzo.a(this.a, paramIntent);
      return;
    }
    avzo.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avzq
 * JD-Core Version:    0.7.0.1
 */