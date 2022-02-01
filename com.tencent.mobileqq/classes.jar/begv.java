import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.troopinfo.TroopInfoData;

class begv
  extends BroadcastReceiver
{
  begv(begt parambegt) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("com.tencent.mobileqq.JoinTroopUtil.RET_ACTION".equals(paramIntent.getAction())) {}
    switch (paramIntent.getIntExtra("ret_action", 1000))
    {
    default: 
      begt.a(this.a, begt.a(this.a).troopUin, 2);
      return;
    case 1000: 
      begt.a(this.a, begt.a(this.a).troopUin, 2);
      return;
    case 1001: 
      begt.a(this.a, begt.a(this.a).troopUin, 2);
      return;
    case 1002: 
      begt.a(this.a, begt.a(this.a).troopUin, 2);
      return;
    case 1003: 
      begt.a(this.a, begt.a(this.a).troopUin, 1);
      return;
    }
    begt.a(this.a, begt.a(this.a).troopUin, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     begv
 * JD-Core Version:    0.7.0.1
 */