import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.nearby.NearbyJsInterface;
import com.tencent.qphone.base.util.QLog;

public class auvc
  extends BroadcastReceiver
{
  public auvc(NearbyJsInterface paramNearbyJsInterface) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("command_type", 0);
    QLog.i("NearbyJsInterface", 2, "receive request" + paramIntent.getExtras());
    switch (i)
    {
    }
    do
    {
      do
      {
        return;
      } while (TextUtils.isEmpty(NearbyJsInterface.a(this.a)));
      this.a.callJs(NearbyJsInterface.a(this.a), new String[] { paramIntent.getStringExtra("data") });
      NearbyJsInterface.a(this.a, "");
      return;
    } while (TextUtils.isEmpty(NearbyJsInterface.b(this.a)));
    this.a.callJs(NearbyJsInterface.b(this.a), new String[] { paramIntent.getStringExtra("data") });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     auvc
 * JD-Core Version:    0.7.0.1
 */