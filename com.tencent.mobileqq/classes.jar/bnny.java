import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class bnny
  extends BroadcastReceiver
{
  bnny(bnnx parambnnx) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getAction().equals("com.tencent.qq.syncQunMsg"))
    {
      int i = paramIntent.getIntExtra("com.tencent.qq.unreadcount", 0);
      bnnx.a(this.a, i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnny
 * JD-Core Version:    0.7.0.1
 */