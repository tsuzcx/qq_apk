import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.agent.AuthorityControlFragment;
import com.tencent.open.model.AppInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class bfcq
  extends bfqu
{
  public bfcq(AuthorityControlFragment paramAuthorityControlFragment) {}
  
  protected void a(boolean paramBoolean, List<AppInfo> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AuthorityControlActivity", 2, "onDelApp: invoked.  isSuccess: " + paramBoolean + " infos: " + paramList);
    }
    QQAppInterface localQQAppInterface;
    if ((paramBoolean) && (paramList != null) && (paramList.size() > 0))
    {
      AuthorityControlFragment.a(this.a).b(paramList);
      AuthorityControlFragment.a(this.a).a();
      if (AuthorityControlFragment.a(this.a).getCount() == 0) {
        AuthorityControlFragment.a(this.a);
      }
      int i = paramList.size();
      paramList = String.format(alud.a(2131701181), new Object[] { Integer.valueOf(i) });
      QQToast.a(AuthorityControlFragment.a(this.a), 2, paramList, 0).a();
      localQQAppInterface = AuthorityControlFragment.a(this.a);
      if (!paramBoolean) {
        break label207;
      }
    }
    label207:
    for (paramList = "0";; paramList = "1")
    {
      azqs.b(localQQAppInterface, "dc00898", "", "", "0X8009E1D", "0X8009E1D", 0, 0, paramList, "", "", "");
      return;
      QQToast.a(AuthorityControlFragment.a(this.a), 1, alud.a(2131701185), 0).a();
      break;
    }
  }
  
  protected void a(boolean paramBoolean, List<AppInfo> paramList, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AuthorityControlActivity", 2, "onGetAuthorizeAppList: invoked.  isSuccess: " + paramBoolean + " infos: " + paramList);
    }
    if (paramBoolean)
    {
      paramString = paramList;
      if (paramList == null) {
        paramString = new ArrayList();
      }
      AuthorityControlFragment.a(this.a).a(paramString);
      AuthorityControlFragment.a(this.a, new ArrayList(paramString));
      if (AuthorityControlFragment.a(this.a).getCount() == 0) {
        AuthorityControlFragment.a(this.a);
      }
    }
    for (;;)
    {
      AuthorityControlFragment.a(this.a).notifyDataSetChanged();
      if ((AuthorityControlFragment.a(this.a).isShowing()) && (!this.a.isRemoving())) {}
      try
      {
        AuthorityControlFragment.a(this.a).dismiss();
        label148:
        AuthorityControlFragment.a(this.a, paramBoolean);
        return;
        AuthorityControlFragment.a(this.a).setVisibility(0);
        this.a.setRightButton(2131690335, this.a);
        continue;
        AuthorityControlFragment.a(this.a);
      }
      catch (Throwable paramList)
      {
        break label148;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfcq
 * JD-Core Version:    0.7.0.1
 */