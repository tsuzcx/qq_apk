import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.SplashActivity;
import java.util.ArrayList;

class arjp
  implements View.OnClickListener
{
  arjp(arjo paramarjo) {}
  
  public void onClick(View paramView)
  {
    if (!arjo.a(this.a)) {
      return;
    }
    if ((arni.a()) && (aqxj.c() > aqxg.a()))
    {
      armv.a(SplashActivity.sTopActivity, 2131692752, 2131692757, new arjq(this));
      return;
    }
    paramView = new ArrayList();
    paramView.addAll(aqxj.a());
    Intent localIntent = new Intent();
    localIntent.putParcelableArrayListExtra("sFilesSelected", paramView);
    arjo.b(this.a, localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arjp
 * JD-Core Version:    0.7.0.1
 */