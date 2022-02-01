import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

class atse
  implements View.OnClickListener
{
  atse(atsd paramatsd) {}
  
  public void onClick(View paramView)
  {
    if (!atsd.a(this.a)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((atvo.a()) && (athc.c() > atgz.a()))
      {
        atvb.a(SplashActivity.sTopActivity, 2131692321, 2131692326, new atsf(this));
      }
      else
      {
        ArrayList localArrayList = new ArrayList();
        localArrayList.addAll(athc.a());
        Intent localIntent = new Intent();
        localIntent.putParcelableArrayListExtra("sFilesSelected", localArrayList);
        atsd.b(this.a, localIntent);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atse
 * JD-Core Version:    0.7.0.1
 */