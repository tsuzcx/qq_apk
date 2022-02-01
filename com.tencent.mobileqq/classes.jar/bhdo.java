import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;

class bhdo
  implements View.OnClickListener
{
  bhdo(bhdm parambhdm) {}
  
  public void onClick(View paramView)
  {
    int i = 2;
    bjtx.b("NewUpgradeDialog", bjqy.a(10010, bhdm.a(), 2, 200));
    bjqw.a().a(17, bjqy.a(10010, bhdm.a(), 4, 200));
    this.a.dismiss();
    ((Activity)this.a.a.get()).finish();
    if (bhdm.a() == 2) {
      i = 1;
    }
    bdll.b(null, "dc00898", "", "", "0X8008FFC", "0X8008FFC", i, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhdo
 * JD-Core Version:    0.7.0.1
 */