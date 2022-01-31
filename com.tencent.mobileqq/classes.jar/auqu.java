import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.nearby.NearbyJsInterface;

public class auqu
  extends BroadcastReceiver
{
  public auqu(NearbyJsInterface paramNearbyJsInterface) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    this.a.tribePersonalDataModify();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     auqu
 * JD-Core Version:    0.7.0.1
 */