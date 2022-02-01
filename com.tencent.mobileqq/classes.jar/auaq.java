import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

class auaq
  implements View.OnClickListener
{
  auaq(auap paramauap) {}
  
  public void onClick(View paramView)
  {
    if (!auap.a(this.a)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((auea.a()) && (atpm.c() > atpj.a()))
      {
        audn.a(SplashActivity.sTopActivity, 2131692476, 2131692481, new auar(this));
      }
      else
      {
        ArrayList localArrayList = new ArrayList();
        localArrayList.addAll(atpm.a());
        Intent localIntent = new Intent();
        localIntent.putParcelableArrayListExtra("sFilesSelected", localArrayList);
        auap.b(this.a, localIntent);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auaq
 * JD-Core Version:    0.7.0.1
 */