import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class bhqr
  extends BroadcastReceiver
{
  bhqr(bhqq parambhqq) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getAction().equals("com.tencent.qq.syncSecretShuoshuoMsg"))
    {
      int i = paramIntent.getIntExtra("com.tencent.qq.syncSecretShuoshuoMsgType", 0);
      bhqq.a(this.a, i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bhqr
 * JD-Core Version:    0.7.0.1
 */