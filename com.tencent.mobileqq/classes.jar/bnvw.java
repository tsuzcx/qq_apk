import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bnvw
  implements View.OnClickListener
{
  bnvw(bnvr parambnvr) {}
  
  public void onClick(View paramView)
  {
    bnvr.e(this.a);
    bnvr.b(this.a).setVisibility(8);
    bnyp.a().a("CameraModuleSvc.GetPlayShowCatMatTree", "", 4);
    PeakAppInterface.a.a(1010);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnvw
 * JD-Core Version:    0.7.0.1
 */