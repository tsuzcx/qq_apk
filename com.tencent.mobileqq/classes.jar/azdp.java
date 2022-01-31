import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.troopinfo.TroopInfoData;

class azdp
  extends BroadcastReceiver
{
  azdp(azdn paramazdn) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("com.tencent.mobileqq.JoinTroopUtil.RET_ACTION".equals(paramIntent.getAction())) {}
    switch (paramIntent.getIntExtra("ret_action", 1000))
    {
    default: 
      azdn.a(this.a, azdn.a(this.a).troopUin, 2);
      return;
    case 1000: 
      azdn.a(this.a, azdn.a(this.a).troopUin, 2);
      return;
    case 1001: 
      azdn.a(this.a, azdn.a(this.a).troopUin, 2);
      return;
    case 1002: 
      azdn.a(this.a, azdn.a(this.a).troopUin, 2);
      return;
    case 1003: 
      azdn.a(this.a, azdn.a(this.a).troopUin, 1);
      return;
    }
    azdn.a(this.a, azdn.a(this.a).troopUin, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azdp
 * JD-Core Version:    0.7.0.1
 */