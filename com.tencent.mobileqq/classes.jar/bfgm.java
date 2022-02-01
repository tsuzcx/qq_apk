import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.troop.activity.TroopAdminList;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class bfgm
  implements View.OnClickListener
{
  public bfgm(TroopAdminList paramTroopAdminList) {}
  
  public void onClick(View paramView)
  {
    Object localObject1 = (bfgo)paramView.getTag();
    if (localObject1 != null)
    {
      localObject1 = ((bfgo)localObject1).a;
      if (!this.a.app.getCurrentAccountUin().equals(localObject1)) {
        break label60;
      }
      localObject1 = new ProfileActivity.AllInOne((String)localObject1, 0);
    }
    for (;;)
    {
      ProfileActivity.b(this.a, (ProfileActivity.AllInOne)localObject1);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label60:
      int i = this.a.getIntent().getIntExtra("t_s_f", -1);
      Object localObject2 = ((anyw)this.a.app.getManager(51)).e((String)localObject1);
      TroopInfo localTroopInfo = ((TroopManager)this.a.app.getManager(52)).b(this.a.c);
      if ((localObject2 != null) && (((Friends)localObject2).isFriend()))
      {
        if (localTroopInfo != null)
        {
          localObject1 = new ProfileActivity.AllInOne((String)localObject1, 20);
          ((ProfileActivity.AllInOne)localObject1).d = this.a.d;
          ((ProfileActivity.AllInOne)localObject1).c = this.a.c;
        }
        for (;;)
        {
          ((ProfileActivity.AllInOne)localObject1).h = ((Friends)localObject2).name;
          ((ProfileActivity.AllInOne)localObject1).i = ((Friends)localObject2).remark;
          break;
          localObject1 = new ProfileActivity.AllInOne((String)localObject1, 1);
        }
      }
      if (i == 1002)
      {
        localObject1 = new ProfileActivity.AllInOne((String)localObject1, 97);
      }
      else if (localTroopInfo != null)
      {
        localObject1 = new ProfileActivity.AllInOne((String)localObject1, 21);
        ((ProfileActivity.AllInOne)localObject1).d = this.a.d;
        ((ProfileActivity.AllInOne)localObject1).c = this.a.c;
        ((ProfileActivity.AllInOne)localObject1).l = 12;
      }
      else
      {
        localObject1 = new ProfileActivity.AllInOne((String)localObject1, 23);
        localObject2 = new Bundle();
        ((Bundle)localObject2).putString("troop_code", this.a.d);
        ((Bundle)localObject2).putString("troop_uin", this.a.c);
        ((ProfileActivity.AllInOne)localObject1).b.putBundle("flc_extra_param", (Bundle)localObject2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfgm
 * JD-Core Version:    0.7.0.1
 */