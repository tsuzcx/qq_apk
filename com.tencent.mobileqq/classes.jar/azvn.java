import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.widget.QQToast;

class azvn
  implements View.OnClickListener
{
  azvn(azvm paramazvm) {}
  
  public void onClick(View paramView)
  {
    Context localContext = paramView.getContext();
    if (bdee.a(localContext) == 1)
    {
      azvm.a(this.a, localContext, paramView);
      if ((localContext instanceof BaseActivity)) {
        azmj.b(((BaseActivity)localContext).app, "CliOper", "", "", "0X8005BA3", "0X8005BA3", 0, 0, "", "", "", "");
      }
    }
    for (;;)
    {
      azmj.b(null, "CliOper", "", "", "0X8004B5C", "0X8004B5C", 1, 0, "", "", "", "");
      return;
      if (!bdee.g(localContext))
      {
        QQToast.a(localContext, 2131692397, 0).a();
      }
      else
      {
        Resources localResources = localContext.getResources();
        bdcd.a(localContext, 232, "", alpo.a(2131714972), localResources.getString(2131690648), localResources.getString(2131694951), new azvo(this, localContext, paramView), new azvp(this)).show();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azvn
 * JD-Core Version:    0.7.0.1
 */