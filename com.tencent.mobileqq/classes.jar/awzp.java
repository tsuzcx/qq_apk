import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;

class awzp
  implements View.OnClickListener
{
  awzp(awzo paramawzo) {}
  
  public void onClick(View paramView)
  {
    Context localContext = paramView.getContext();
    if (badq.a(localContext) == 1)
    {
      awzo.a(this.a, localContext, paramView);
      if ((localContext instanceof BaseActivity)) {
        awqx.b(((BaseActivity)localContext).app, "CliOper", "", "", "0X8005BA3", "0X8005BA3", 0, 0, "", "", "", "");
      }
    }
    for (;;)
    {
      awqx.b(null, "CliOper", "", "", "0X8004B5C", "0X8004B5C", 1, 0, "", "", "", "");
      return;
      if (!badq.g(localContext))
      {
        bbmy.a(localContext, 2131626719, 0).a();
      }
      else
      {
        Resources localResources = localContext.getResources();
        babr.a(localContext, 232, "", ajjy.a(2131648800), localResources.getString(2131625035), localResources.getString(2131629116), new awzq(this, localContext, paramView), new awzr(this)).show();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     awzp
 * JD-Core Version:    0.7.0.1
 */