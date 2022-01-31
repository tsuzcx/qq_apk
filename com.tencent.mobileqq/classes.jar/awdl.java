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

class awdl
  implements View.OnClickListener
{
  awdl(awcx paramawcx) {}
  
  public void onClick(View paramView)
  {
    if ((paramView.getTag() instanceof awdm)) {}
    SubAccountInfo localSubAccountInfo;
    switch (((awdm)paramView.getTag()).a)
    {
    default: 
      return;
    case 0: 
      if (bdeu.c())
      {
        QQToast.a(awcx.a(this.a), 2131694149, 0).a();
        return;
      }
      paramView = new Intent(awcx.a(this.a), AddAccountActivity.class);
      awcx.a(this.a).startActivity(paramView);
      awcx.a(this.a).overridePendingTransition(2130771997, 2130771990);
      bact.c(awcx.a(this.a), awcx.a(this.a));
      azqs.b(awcx.a(this.a), "CliOper", "", "", "0X80072D4", "0X80072D4", 0, 0, "", "", "", "");
      return;
    case 2: 
      localSubAccountInfo = (SubAccountInfo)paramView.getTag(2131361860);
      if (localSubAccountInfo != null)
      {
        paramView = awcx.a(this.a).getApplication().getAllAccounts();
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
        this.a.a(paramView, awcx.a(this.a).app);
      }
      for (;;)
      {
        azqs.b(awcx.a(this.a), "dc00898", "", "", "0X800AC36", "0X800AC36", 0, 0, "", "", "", "");
        azqs.b(awcx.a(this.a), "CliOper", "", "", "0X80072D2", "0X80072D2", 0, 0, "", "", "", "");
        return;
        if (localSubAccountInfo != null)
        {
          paramView = new Intent("before_account_change");
          awcx.a(this.a).sendBroadcast(paramView);
          paramView = new Intent(awcx.a(this.a), SubAccountUgActivity.class);
          paramView.putExtra("subAccount", localSubAccountInfo.subuin);
          awcx.a(this.a).startActivity(paramView);
        }
      }
      paramView = (SimpleAccount)paramView.getTag(2131361860);
      this.a.a(paramView, awcx.a(this.a));
      azqs.b(awcx.a(this.a), "dc00898", "", "", "0X800AC36", "0X800AC36", 0, 0, "", "", "", "");
      azqs.b(awcx.a(this.a), "CliOper", "", "", "0X80072D3", "0X80072D3", 0, 0, "", "", "", "");
      return;
      paramView = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awdl
 * JD-Core Version:    0.7.0.1
 */