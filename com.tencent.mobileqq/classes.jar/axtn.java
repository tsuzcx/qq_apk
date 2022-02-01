import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.SubAccountUgActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;

class axtn
  implements View.OnClickListener
{
  axtn(axsv paramaxsv) {}
  
  public void onClick(View paramView)
  {
    if ((paramView.getTag() instanceof axto)) {}
    SubAccountInfo localSubAccountInfo;
    Object localObject1;
    switch (((axto)paramView.getTag()).a)
    {
    default: 
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    case 2: 
      localSubAccountInfo = (SubAccountInfo)paramView.getTag(2131361895);
      if (localSubAccountInfo != null)
      {
        localObject1 = axsv.a(this.a).getApplication().getAllAccounts();
        Object localObject2 = new ArrayList();
        if (localObject1 != null) {
          ((List)localObject2).addAll((Collection)localObject1);
        }
        if ((localObject2 != null) && (((List)localObject2).size() > 0))
        {
          localObject2 = ((List)localObject2).iterator();
          do
          {
            if (!((Iterator)localObject2).hasNext()) {
              break;
            }
            localObject1 = (SimpleAccount)((Iterator)localObject2).next();
          } while (!TextUtils.equals(((SimpleAccount)localObject1).getUin(), localSubAccountInfo.subuin));
        }
      }
      break;
    }
    for (;;)
    {
      if (localObject1 != null) {
        this.a.a((SimpleAccount)localObject1, axsv.a(this.a).app);
      }
      for (;;)
      {
        bcef.b(axsv.a(this.a), "dc00898", "", "", "0X800AC36", "0X800AC36", 0, 0, "", "", "", "");
        bcef.b(axsv.a(this.a), "CliOper", "", "", "0X80072D2", "0X80072D2", 0, 0, "", "", "", "");
        axvz.a("0X800AF3A");
        break;
        if (localSubAccountInfo != null)
        {
          localObject1 = new Intent("before_account_change");
          axsv.a(this.a).sendBroadcast((Intent)localObject1);
          localObject1 = new Intent(axsv.a(this.a), SubAccountUgActivity.class);
          ((Intent)localObject1).putExtra("subAccount", localSubAccountInfo.subuin);
          axsv.a(this.a).startActivity((Intent)localObject1);
        }
      }
      localObject1 = (SimpleAccount)paramView.getTag(2131361895);
      this.a.a((SimpleAccount)localObject1, axsv.a(this.a));
      bcef.b(axsv.a(this.a), "dc00898", "", "", "0X800AC36", "0X800AC36", 0, 0, "", "", "", "");
      bcef.b(axsv.a(this.a), "CliOper", "", "", "0X80072D3", "0X80072D3", 0, 0, "", "", "", "");
      axvz.a("0X800AF3A");
      break;
      localObject1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axtn
 * JD-Core Version:    0.7.0.1
 */