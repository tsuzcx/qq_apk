import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;

class bgdn
  implements View.OnClickListener
{
  bgdn(bgdl parambgdl) {}
  
  public void onClick(View paramView)
  {
    int i = 2;
    bisy.b("NewUpgradeDialog", bipz.a(10010, bgdl.a(), 2, 200));
    bipx.a().a(17, bipz.a(10010, bgdl.a(), 4, 200));
    this.a.dismiss();
    ((Activity)this.a.a.get()).finish();
    if (bgdl.a() == 2) {
      i = 1;
    }
    bcst.b(null, "dc00898", "", "", "0X8008FFC", "0X8008FFC", i, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgdn
 * JD-Core Version:    0.7.0.1
 */