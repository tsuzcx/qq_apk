import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class bhss
  extends BroadcastReceiver
{
  bhss(bhsr parambhsr) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getAction().equals("com.tencent.qq.syncQunMsg"))
    {
      int i = paramIntent.getIntExtra("com.tencent.qq.unreadcount", 0);
      bhsr.a(this.a, i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bhss
 * JD-Core Version:    0.7.0.1
 */