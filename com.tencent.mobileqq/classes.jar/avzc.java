import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.AddAccountActivity;
import com.tencent.mobileqq.activity.SubAccountUgActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.remote.SimpleAccount;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;

class avzc
  implements View.OnClickListener
{
  avzc(avyo paramavyo) {}
  
  public void onClick(View paramView)
  {
    if ((paramView.getTag() instanceof avzd)) {}
    SubAccountInfo localSubAccountInfo;
    switch (((avzd)paramView.getTag()).a)
    {
    default: 
      return;
    case 0: 
      if (bdal.c())
      {
        QQToast.a(avyo.a(this.a), 2131694147, 0).a();
        return;
      }
      paramView = new Intent(avyo.a(this.a), AddAccountActivity.class);
      avyo.a(this.a).startActivity(paramView);
      avyo.a(this.a).overridePendingTransition(2130771997, 2130771990);
      azyk.c(avyo.a(this.a), avyo.a(this.a));
      azmj.b(avyo.a(this.a), "CliOper", "", "", "0X80072D4", "0X80072D4", 0, 0, "", "", "", "");
      return;
    case 2: 
      localSubAccountInfo = (SubAccountInfo)paramView.getTag(2131361860);
      if (localSubAccountInfo != null)
      {
        paramView = avyo.a(this.a).getApplication().getAllAccounts();
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
        this.a.a(paramView, avyo.a(this.a).app);
      }
      for (;;)
      {
        azmj.b(avyo.a(this.a), "dc00898", "", "", "0X800AC36", "0X800AC36", 0, 0, "", "", "", "");
        azmj.b(avyo.a(this.a), "CliOper", "", "", "0X80072D2", "0X80072D2", 0, 0, "", "", "", "");
        return;
        if (localSubAccountInfo != null)
        {
          paramView = new Intent("before_account_change");
          avyo.a(this.a).sendBroadcast(paramView);
          paramView = new Intent(avyo.a(this.a), SubAccountUgActivity.class);
          paramView.putExtra("subAccount", localSubAccountInfo.subuin);
          avyo.a(this.a).startActivity(paramView);
        }
      }
      paramView = (SimpleAccount)paramView.getTag(2131361860);
      this.a.a(paramView, avyo.a(this.a));
      azmj.b(avyo.a(this.a), "dc00898", "", "", "0X800AC36", "0X800AC36", 0, 0, "", "", "", "");
      azmj.b(avyo.a(this.a), "CliOper", "", "", "0X80072D3", "0X80072D3", 0, 0, "", "", "", "");
      return;
      paramView = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avzc
 * JD-Core Version:    0.7.0.1
 */