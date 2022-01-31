import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.SplashActivity;
import java.util.ArrayList;

class apqm
  implements View.OnClickListener
{
  apqm(apql paramapql) {}
  
  public void onClick(View paramView)
  {
    if (!apql.a(this.a)) {
      return;
    }
    if ((apug.a()) && (apel.c() > apei.a()))
    {
      aptt.a(SplashActivity.sTopActivity, 2131692673, 2131692678, new apqn(this));
      return;
    }
    paramView = new ArrayList();
    paramView.addAll(apel.a());
    Intent localIntent = new Intent();
    localIntent.putParcelableArrayListExtra("sFilesSelected", paramView);
    apql.b(this.a, localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apqm
 * JD-Core Version:    0.7.0.1
 */