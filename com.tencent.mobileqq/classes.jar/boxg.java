import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class boxg
  implements View.OnClickListener
{
  boxg(boxb paramboxb) {}
  
  public void onClick(View paramView)
  {
    boxb.e(this.a);
    boxb.b(this.a).setVisibility(8);
    bozz.a().a("CameraModuleSvc.GetPlayShowCatMatTree", "", 4);
    PeakAppInterface.a.a(1010);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     boxg
 * JD-Core Version:    0.7.0.1
 */