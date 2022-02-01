import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

class aswj
  implements View.OnClickListener
{
  aswj(aswi paramaswi) {}
  
  public void onClick(View paramView)
  {
    if (!aswi.a(this.a)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((aszt.a()) && (aslg.c() > asld.a()))
      {
        aszg.a(SplashActivity.sTopActivity, 2131692374, 2131692379, new aswk(this));
      }
      else
      {
        ArrayList localArrayList = new ArrayList();
        localArrayList.addAll(aslg.a());
        Intent localIntent = new Intent();
        localIntent.putParcelableArrayListExtra("sFilesSelected", localArrayList);
        aswi.b(this.a, localIntent);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aswj
 * JD-Core Version:    0.7.0.1
 */