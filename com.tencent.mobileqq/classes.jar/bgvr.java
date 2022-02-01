import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;

class bgvr
  implements View.OnClickListener
{
  bgvr(bgvp parambgvp) {}
  
  public void onClick(View paramView)
  {
    int i = 2;
    bjko.b("NewUpgradeDialog", bjhp.a(10010, bgvp.a(), 2, 200));
    bjhn.a().a(17, bjhp.a(10010, bgvp.a(), 4, 200));
    this.a.dismiss();
    ((Activity)this.a.a.get()).finish();
    if (bgvp.a() == 2) {
      i = 1;
    }
    bdla.b(null, "dc00898", "", "", "0X8008FFC", "0X8008FFC", i, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgvr
 * JD-Core Version:    0.7.0.1
 */