import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.troopinfo.TroopInfoData;

class bffw
  extends BroadcastReceiver
{
  bffw(bffu parambffu) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("com.tencent.mobileqq.JoinTroopUtil.RET_ACTION".equals(paramIntent.getAction())) {}
    switch (paramIntent.getIntExtra("ret_action", 1000))
    {
    default: 
      bffu.a(this.a, bffu.a(this.a).troopUin, 2);
      return;
    case 1000: 
      bffu.a(this.a, bffu.a(this.a).troopUin, 2);
      return;
    case 1001: 
      bffu.a(this.a, bffu.a(this.a).troopUin, 2);
      return;
    case 1002: 
      bffu.a(this.a, bffu.a(this.a).troopUin, 2);
      return;
    case 1003: 
      bffu.a(this.a, bffu.a(this.a).troopUin, 1);
      return;
    }
    bffu.a(this.a, bffu.a(this.a).troopUin, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bffw
 * JD-Core Version:    0.7.0.1
 */