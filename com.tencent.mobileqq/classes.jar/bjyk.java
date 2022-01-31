import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class bjyk
  extends BroadcastReceiver
{
  bjyk(bjyj parambjyj) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getAction().equals("com.tencent.qq.syncQunMsg"))
    {
      int i = paramIntent.getIntExtra("com.tencent.qq.unreadcount", 0);
      bjyj.a(this.a, i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjyk
 * JD-Core Version:    0.7.0.1
 */