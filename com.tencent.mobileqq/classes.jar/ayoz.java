import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ayoz
  implements View.OnClickListener
{
  ayoz(ayoy paramayoy) {}
  
  public void onClick(View paramView)
  {
    if (System.currentTimeMillis() < ayoy.a(this.a) + 1000L) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      ayoy.a(this.a, System.currentTimeMillis());
      Intent localIntent = new Intent(paramView.getContext(), QQBrowserActivity.class);
      localIntent.putExtra("url", ayoq.a());
      localIntent.putExtra("hide_more_button", true);
      localIntent.addFlags(536870912);
      paramView.getContext().startActivity(localIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayoz
 * JD-Core Version:    0.7.0.1
 */