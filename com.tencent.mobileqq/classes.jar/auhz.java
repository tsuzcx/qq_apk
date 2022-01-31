import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.AddAccountActivity;
import com.tencent.mobileqq.activity.SubAccountUgActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.qphone.base.remote.SimpleAccount;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;

class auhz
  implements View.OnClickListener
{
  auhz(auhk paramauhk) {}
  
  public void onClick(View paramView)
  {
    if ((paramView.getTag() instanceof auia)) {}
    SubAccountInfo localSubAccountInfo;
    switch (((auia)paramView.getTag()).a)
    {
    default: 
      return;
    case 0: 
      if (bbbr.c())
      {
        bcql.a(auhk.a(this.a), 2131694031, 0).a();
        return;
      }
      paramView = new Intent(auhk.a(this.a), AddAccountActivity.class);
      auhk.a(this.a).startActivity(paramView);
      auhk.a(this.a).overridePendingTransition(2130771997, 2130771990);
      ayap.c(auhk.a(this.a), auhk.a(this.a));
      axqy.b(auhk.a(this.a), "CliOper", "", "", "0X80072D4", "0X80072D4", 0, 0, "", "", "", "");
      return;
    case 2: 
      localSubAccountInfo = (SubAccountInfo)paramView.getTag(2131361860);
      if (localSubAccountInfo != null)
      {
        paramView = auhk.a(this.a).getApplication().getAllAccounts();
        Object localObject = new ArrayList();
        if (paramView != null) {
          ((List)localObject).addAll(paramView);
        }
        if ((localObject != null) && (((List)localObject).size() > 0))
        {
          localObject = ((List)localObject).iterator();
          do
          {
            if (!((Iterator)localObject).hasNext()) {
              break;
            }
            paramView = (SimpleAccount)((Iterator)localObject).next();
          } while (!TextUtils.equals(paramView.getUin(), localSubAccountInfo.subuin));
        }
      }
      break;
    }
    for (;;)
    {
      if (paramView != null) {
        auhk.a(this.a, paramView);
      }
      for (;;)
      {
        axqy.b(auhk.a(this.a), "CliOper", "", "", "0X80072D2", "0X80072D2", 0, 0, "", "", "", "");
        return;
        if (localSubAccountInfo != null)
        {
          paramView = new Intent("before_account_change");
          auhk.a(this.a).sendBroadcast(paramView);
          paramView = new Intent(auhk.a(this.a), SubAccountUgActivity.class);
          paramView.putExtra("subAccount", localSubAccountInfo.subuin);
          auhk.a(this.a).startActivity(paramView);
        }
      }
      paramView = (SimpleAccount)paramView.getTag(2131361860);
      if (paramView != null) {
        auhk.a(this.a, paramView);
      }
      axqy.b(auhk.a(this.a), "CliOper", "", "", "0X80072D3", "0X80072D3", 0, 0, "", "", "", "");
      return;
      paramView = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     auhz
 * JD-Core Version:    0.7.0.1
 */