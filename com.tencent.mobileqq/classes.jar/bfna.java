import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;

class bfna
  implements View.OnClickListener
{
  bfna(bfmy parambfmy) {}
  
  public void onClick(View paramView)
  {
    int i = 2;
    bhzm.b("NewUpgradeDialog", bhwn.a(10010, bfmy.a(), 2, 200));
    bhwl.a().a(17, bhwn.a(10010, bfmy.a(), 4, 200));
    this.a.dismiss();
    ((Activity)this.a.a.get()).finish();
    if (bfmy.a() == 2) {
      i = 1;
    }
    bcef.b(null, "dc00898", "", "", "0X8008FFC", "0X8008FFC", i, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfna
 * JD-Core Version:    0.7.0.1
 */