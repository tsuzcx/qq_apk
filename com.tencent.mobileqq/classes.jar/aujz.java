import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

class aujz
  implements View.OnClickListener
{
  aujz(aujy paramaujy) {}
  
  public void onClick(View paramView)
  {
    if (!aujy.a(this.a)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((aunj.a()) && (atyw.c() > atyt.a()))
      {
        aumw.a(SplashActivity.sTopActivity, 2131692326, 2131692331, new auka(this));
      }
      else
      {
        ArrayList localArrayList = new ArrayList();
        localArrayList.addAll(atyw.a());
        Intent localIntent = new Intent();
        localIntent.putParcelableArrayListExtra("sFilesSelected", localArrayList);
        aujy.b(this.a, localIntent);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aujz
 * JD-Core Version:    0.7.0.1
 */