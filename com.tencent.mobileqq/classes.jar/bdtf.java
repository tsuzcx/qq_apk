import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bdtf
  implements View.OnClickListener
{
  bdtf(bdte parambdte) {}
  
  public void onClick(View paramView)
  {
    Context localContext = paramView.getContext();
    if (NetworkUtil.getSystemNetwork(localContext) == 1)
    {
      bdte.a(this.a, localContext, paramView);
      if ((localContext instanceof BaseActivity)) {
        bdla.b(((BaseActivity)localContext).app, "CliOper", "", "", "0X8005BA3", "0X8005BA3", 0, 0, "", "", "", "");
      }
    }
    for (;;)
    {
      bdla.b(null, "CliOper", "", "", "0X8004B5C", "0X8004B5C", 1, 0, "", "", "", "");
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (!NetworkUtil.isNetworkAvailable(localContext))
      {
        QQToast.a(localContext, 2131692125, 0).a();
      }
      else
      {
        Resources localResources = localContext.getResources();
        bhdj.a(localContext, 232, "", anvx.a(2131713973), localResources.getString(2131690697), localResources.getString(2131694399), new bdtg(this, localContext, paramView), new bdth(this)).show();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdtf
 * JD-Core Version:    0.7.0.1
 */