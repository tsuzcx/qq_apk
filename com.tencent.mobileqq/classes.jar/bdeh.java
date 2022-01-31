import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import java.lang.ref.WeakReference;

class bdeh
  implements View.OnClickListener
{
  bdeh(bdef parambdef) {}
  
  public void onClick(View paramView)
  {
    int i = 2;
    bfhg.b("NewUpgradeDialog", bfeh.a(10010, bdef.a(), 2, 200));
    bfef.a().a(17, bfeh.a(10010, bdef.a(), 4, 200));
    this.a.dismiss();
    ((Activity)this.a.a.get()).finish();
    if (bdef.a() == 2) {
      i = 1;
    }
    azmj.b(null, "dc00898", "", "", "0X8008FFC", "0X8008FFC", i, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdeh
 * JD-Core Version:    0.7.0.1
 */