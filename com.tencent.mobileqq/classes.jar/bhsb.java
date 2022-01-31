import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class bhsb
  extends BroadcastReceiver
{
  bhsb(bhsa parambhsa) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getAction().equals("com.tencent.qq.syncQunMsg"))
    {
      int i = paramIntent.getIntExtra("com.tencent.qq.unreadcount", 0);
      bhsa.a(this.a, i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bhsb
 * JD-Core Version:    0.7.0.1
 */