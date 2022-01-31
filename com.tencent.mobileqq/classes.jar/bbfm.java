import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import java.lang.ref.WeakReference;

class bbfm
  implements View.OnClickListener
{
  bbfm(bbfk parambbfk) {}
  
  public void onClick(View paramView)
  {
    int i = 2;
    bdii.b("NewUpgradeDialog", bdfj.a(10010, bbfk.a(), 2, 200));
    bdfh.a().a(17, bdfj.a(10010, bbfk.a(), 4, 200));
    this.a.dismiss();
    ((Activity)this.a.a.get()).finish();
    if (bbfk.a() == 2) {
      i = 1;
    }
    axqy.b(null, "dc00898", "", "", "0X8008FFC", "0X8008FFC", i, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbfm
 * JD-Core Version:    0.7.0.1
 */