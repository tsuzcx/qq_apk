import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.troopinfo.TroopInfoData;

class bbbo
  extends BroadcastReceiver
{
  bbbo(bbbm parambbbm) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("com.tencent.mobileqq.JoinTroopUtil.RET_ACTION".equals(paramIntent.getAction())) {}
    switch (paramIntent.getIntExtra("ret_action", 1000))
    {
    default: 
      bbbm.a(this.a, bbbm.a(this.a).troopUin, 2);
      return;
    case 1000: 
      bbbm.a(this.a, bbbm.a(this.a).troopUin, 2);
      return;
    case 1001: 
      bbbm.a(this.a, bbbm.a(this.a).troopUin, 2);
      return;
    case 1002: 
      bbbm.a(this.a, bbbm.a(this.a).troopUin, 2);
      return;
    case 1003: 
      bbbm.a(this.a, bbbm.a(this.a).troopUin, 1);
      return;
    }
    bbbm.a(this.a, bbbm.a(this.a).troopUin, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbbo
 * JD-Core Version:    0.7.0.1
 */