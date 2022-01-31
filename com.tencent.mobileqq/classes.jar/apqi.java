import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.SplashActivity;
import java.util.ArrayList;

class apqi
  implements View.OnClickListener
{
  apqi(apqh paramapqh) {}
  
  public void onClick(View paramView)
  {
    if (!apqh.a(this.a)) {
      return;
    }
    if ((apue.a()) && (apeh.c() > apee.a()))
    {
      aptr.a(SplashActivity.sTopActivity, 2131692672, 2131692677, new apqj(this));
      return;
    }
    paramView = new ArrayList();
    paramView.addAll(apeh.a());
    Intent localIntent = new Intent();
    localIntent.putParcelableArrayListExtra("sFilesSelected", paramView);
    apqh.b(this.a, localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apqi
 * JD-Core Version:    0.7.0.1
 */