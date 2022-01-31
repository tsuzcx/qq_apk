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

public class bbch
  implements View.OnClickListener
{
  public bbch(TroopAdminList paramTroopAdminList) {}
  
  public void onClick(View paramView)
  {
    paramView = (bbcj)paramView.getTag();
    if (paramView != null)
    {
      paramView = paramView.a;
      if (!this.a.app.getCurrentAccountUin().equals(paramView)) {
        break label53;
      }
      paramView = new ProfileActivity.AllInOne(paramView, 0);
    }
    for (;;)
    {
      ProfileActivity.b(this.a, paramView);
      return;
      label53:
      int i = this.a.getIntent().getIntExtra("t_s_f", -1);
      Object localObject = ((aloz)this.a.app.getManager(51)).e(paramView);
      TroopInfo localTroopInfo = ((TroopManager)this.a.app.getManager(52)).b(this.a.c);
      if ((localObject != null) && (((Friends)localObject).isFriend()))
      {
        if (localTroopInfo != null)
        {
          paramView = new ProfileActivity.AllInOne(paramView, 20);
          paramView.d = this.a.d;
          paramView.c = this.a.c;
        }
        for (;;)
        {
          paramView.h = ((Friends)localObject).name;
          paramView.i = ((Friends)localObject).remark;
          break;
          paramView = new ProfileActivity.AllInOne(paramView, 1);
        }
      }
      if (i == 1002)
      {
        paramView = new ProfileActivity.AllInOne(paramView, 97);
      }
      else if (localTroopInfo != null)
      {
        paramView = new ProfileActivity.AllInOne(paramView, 21);
        paramView.d = this.a.d;
        paramView.c = this.a.c;
        paramView.l = 12;
      }
      else
      {
        paramView = new ProfileActivity.AllInOne(paramView, 23);
        localObject = new Bundle();
        ((Bundle)localObject).putString("troop_code", this.a.d);
        ((Bundle)localObject).putString("troop_uin", this.a.c);
        paramView.b.putBundle("flc_extra_param", (Bundle)localObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbch
 * JD-Core Version:    0.7.0.1
 */