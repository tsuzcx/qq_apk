import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;

class axzr
  implements View.OnClickListener
{
  axzr(axzq paramaxzq) {}
  
  public void onClick(View paramView)
  {
    Context localContext = paramView.getContext();
    if (bbev.a(localContext) == 1)
    {
      axzq.a(this.a, localContext, paramView);
      if ((localContext instanceof BaseActivity)) {
        axqw.b(((BaseActivity)localContext).app, "CliOper", "", "", "0X8005BA3", "0X8005BA3", 0, 0, "", "", "", "");
      }
    }
    for (;;)
    {
      axqw.b(null, "CliOper", "", "", "0X8004B5C", "0X8004B5C", 1, 0, "", "", "", "");
      return;
      if (!bbev.g(localContext))
      {
        bcpw.a(localContext, 2131692321, 0).a();
      }
      else
      {
        Resources localResources = localContext.getResources();
        bbcv.a(localContext, 232, "", ajyc.a(2131714589), localResources.getString(2131690596), localResources.getString(2131694793), new axzs(this, localContext, paramView), new axzt(this)).show();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axzr
 * JD-Core Version:    0.7.0.1
 */