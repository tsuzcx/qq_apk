import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class bnmn
  extends BroadcastReceiver
{
  bnmn(bnmm parambnmm) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getAction().equals("com.tencent.qq.syncSecretShuoshuoMsg"))
    {
      int i = paramIntent.getIntExtra("com.tencent.qq.syncSecretShuoshuoMsgType", 0);
      bnmm.a(this.a, i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnmn
 * JD-Core Version:    0.7.0.1
 */