import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.troopinfo.TroopInfoData;

class aydd
  extends BroadcastReceiver
{
  aydd(aydb paramaydb) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("com.tencent.mobileqq.JoinTroopUtil.RET_ACTION".equals(paramIntent.getAction())) {}
    switch (paramIntent.getIntExtra("ret_action", 1000))
    {
    default: 
      aydb.a(this.a, aydb.a(this.a).troopUin, 2);
      return;
    case 1000: 
      aydb.a(this.a, aydb.a(this.a).troopUin, 2);
      return;
    case 1001: 
      aydb.a(this.a, aydb.a(this.a).troopUin, 2);
      return;
    case 1002: 
      aydb.a(this.a, aydb.a(this.a).troopUin, 2);
      return;
    case 1003: 
      aydb.a(this.a, aydb.a(this.a).troopUin, 1);
      return;
    }
    aydb.a(this.a, aydb.a(this.a).troopUin, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     aydd
 * JD-Core Version:    0.7.0.1
 */