import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.troopinfo.TroopInfoData;

class bdok
  extends BroadcastReceiver
{
  bdok(bdoi parambdoi) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("com.tencent.mobileqq.JoinTroopUtil.RET_ACTION".equals(paramIntent.getAction())) {}
    switch (paramIntent.getIntExtra("ret_action", 1000))
    {
    default: 
      bdoi.a(this.a, bdoi.a(this.a).troopUin, 2);
      return;
    case 1000: 
      bdoi.a(this.a, bdoi.a(this.a).troopUin, 2);
      return;
    case 1001: 
      bdoi.a(this.a, bdoi.a(this.a).troopUin, 2);
      return;
    case 1002: 
      bdoi.a(this.a, bdoi.a(this.a).troopUin, 2);
      return;
    case 1003: 
      bdoi.a(this.a, bdoi.a(this.a).troopUin, 1);
      return;
    }
    bdoi.a(this.a, bdoi.a(this.a).troopUin, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdok
 * JD-Core Version:    0.7.0.1
 */