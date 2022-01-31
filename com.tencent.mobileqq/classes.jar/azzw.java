import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.widget.QQToast;

class azzw
  implements View.OnClickListener
{
  azzw(azzv paramazzv) {}
  
  public void onClick(View paramView)
  {
    Context localContext = paramView.getContext();
    if (bdin.a(localContext) == 1)
    {
      azzv.a(this.a, localContext, paramView);
      if ((localContext instanceof BaseActivity)) {
        azqs.b(((BaseActivity)localContext).app, "CliOper", "", "", "0X8005BA3", "0X8005BA3", 0, 0, "", "", "", "");
      }
    }
    for (;;)
    {
      azqs.b(null, "CliOper", "", "", "0X8004B5C", "0X8004B5C", 1, 0, "", "", "", "");
      return;
      if (!bdin.g(localContext))
      {
        QQToast.a(localContext, 2131692398, 0).a();
      }
      else
      {
        Resources localResources = localContext.getResources();
        bdgm.a(localContext, 232, "", alud.a(2131714984), localResources.getString(2131690648), localResources.getString(2131694953), new azzx(this, localContext, paramView), new azzy(this)).show();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azzw
 * JD-Core Version:    0.7.0.1
 */