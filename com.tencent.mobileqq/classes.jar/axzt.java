import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;

class axzt
  implements View.OnClickListener
{
  axzt(axzs paramaxzs) {}
  
  public void onClick(View paramView)
  {
    Context localContext = paramView.getContext();
    if (bbfj.a(localContext) == 1)
    {
      axzs.a(this.a, localContext, paramView);
      if ((localContext instanceof BaseActivity)) {
        axqy.b(((BaseActivity)localContext).app, "CliOper", "", "", "0X8005BA3", "0X8005BA3", 0, 0, "", "", "", "");
      }
    }
    for (;;)
    {
      axqy.b(null, "CliOper", "", "", "0X8004B5C", "0X8004B5C", 1, 0, "", "", "", "");
      return;
      if (!bbfj.g(localContext))
      {
        bcql.a(localContext, 2131692321, 0).a();
      }
      else
      {
        Resources localResources = localContext.getResources();
        bbdj.a(localContext, 232, "", ajya.a(2131714600), localResources.getString(2131690596), localResources.getString(2131694794), new axzu(this, localContext, paramView), new axzv(this)).show();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axzt
 * JD-Core Version:    0.7.0.1
 */