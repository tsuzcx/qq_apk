import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bcmf
  implements View.OnClickListener
{
  bcmf(bcme parambcme) {}
  
  public void onClick(View paramView)
  {
    Context localContext = paramView.getContext();
    if (NetworkUtil.getSystemNetwork(localContext) == 1)
    {
      bcme.a(this.a, localContext, paramView);
      if ((localContext instanceof BaseActivity)) {
        bcef.b(((BaseActivity)localContext).app, "CliOper", "", "", "0X8005BA3", "0X8005BA3", 0, 0, "", "", "", "");
      }
    }
    for (;;)
    {
      bcef.b(null, "CliOper", "", "", "0X8004B5C", "0X8004B5C", 1, 0, "", "", "", "");
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (!NetworkUtil.isNetworkAvailable(localContext))
      {
        QQToast.a(localContext, 2131692035, 0).a();
      }
      else
      {
        Resources localResources = localContext.getResources();
        bfur.a(localContext, 232, "", amtj.a(2131713626), localResources.getString(2131690620), localResources.getString(2131694201), new bcmg(this, localContext, paramView), new bcmh(this)).show();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcmf
 * JD-Core Version:    0.7.0.1
 */