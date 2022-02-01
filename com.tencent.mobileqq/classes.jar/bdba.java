import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bdba
  implements View.OnClickListener
{
  bdba(bdaz parambdaz) {}
  
  public void onClick(View paramView)
  {
    Context localContext = paramView.getContext();
    if (bgnt.a(localContext) == 1)
    {
      bdaz.a(this.a, localContext, paramView);
      if ((localContext instanceof BaseActivity)) {
        bcst.b(((BaseActivity)localContext).app, "CliOper", "", "", "0X8005BA3", "0X8005BA3", 0, 0, "", "", "", "");
      }
    }
    for (;;)
    {
      bcst.b(null, "CliOper", "", "", "0X8004B5C", "0X8004B5C", 1, 0, "", "", "", "");
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (!bgnt.g(localContext))
      {
        QQToast.a(localContext, 2131691985, 0).a();
      }
      else
      {
        Resources localResources = localContext.getResources();
        bglp.a(localContext, 232, "", anni.a(2131713285), localResources.getString(2131690582), localResources.getString(2131694081), new bdbb(this, localContext, paramView), new bdbc(this)).show();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdba
 * JD-Core Version:    0.7.0.1
 */