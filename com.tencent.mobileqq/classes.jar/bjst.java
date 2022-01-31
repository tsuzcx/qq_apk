import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class bjst
  extends BroadcastReceiver
{
  bjst(bjss parambjss) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getAction().equals("com.tencent.qq.syncSecretShuoshuoMsg"))
    {
      int i = paramIntent.getIntExtra("com.tencent.qq.syncSecretShuoshuoMsgType", 0);
      bjss.a(this.a, i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjst
 * JD-Core Version:    0.7.0.1
 */