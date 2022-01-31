import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class bjxa
  extends BroadcastReceiver
{
  bjxa(bjwz parambjwz) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getAction().equals("com.tencent.qq.syncSecretShuoshuoMsg"))
    {
      int i = paramIntent.getIntExtra("com.tencent.qq.syncSecretShuoshuoMsgType", 0);
      bjwz.a(this.a, i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjxa
 * JD-Core Version:    0.7.0.1
 */