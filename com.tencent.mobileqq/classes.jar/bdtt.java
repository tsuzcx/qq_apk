import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bdtt
  implements View.OnClickListener
{
  bdtt(bdts parambdts) {}
  
  public void onClick(View paramView)
  {
    Context localContext = paramView.getContext();
    if (bhnv.a(localContext) == 1)
    {
      bdts.a(this.a, localContext, paramView);
      if ((localContext instanceof BaseActivity)) {
        bdll.b(((BaseActivity)localContext).app, "CliOper", "", "", "0X8005BA3", "0X8005BA3", 0, 0, "", "", "", "");
      }
    }
    for (;;)
    {
      bdll.b(null, "CliOper", "", "", "0X8004B5C", "0X8004B5C", 1, 0, "", "", "", "");
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (!bhnv.g(localContext))
      {
        QQToast.a(localContext, 2131691989, 0).a();
      }
      else
      {
        Resources localResources = localContext.getResources();
        bhlq.a(localContext, 232, "", anzj.a(2131713394), localResources.getString(2131690580), localResources.getString(2131694098), new bdtu(this, localContext, paramView), new bdtv(this)).show();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdtt
 * JD-Core Version:    0.7.0.1
 */