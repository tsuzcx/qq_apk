import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.troopinfo.TroopInfoData;

class bbfx
  extends BroadcastReceiver
{
  bbfx(bbfv parambbfv) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("com.tencent.mobileqq.JoinTroopUtil.RET_ACTION".equals(paramIntent.getAction())) {}
    switch (paramIntent.getIntExtra("ret_action", 1000))
    {
    default: 
      bbfv.a(this.a, bbfv.a(this.a).troopUin, 2);
      return;
    case 1000: 
      bbfv.a(this.a, bbfv.a(this.a).troopUin, 2);
      return;
    case 1001: 
      bbfv.a(this.a, bbfv.a(this.a).troopUin, 2);
      return;
    case 1002: 
      bbfv.a(this.a, bbfv.a(this.a).troopUin, 2);
      return;
    case 1003: 
      bbfv.a(this.a, bbfv.a(this.a).troopUin, 1);
      return;
    }
    bbfv.a(this.a, bbfv.a(this.a).troopUin, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbfx
 * JD-Core Version:    0.7.0.1
 */