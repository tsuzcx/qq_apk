import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.location.ui.LocationMapWidget;
import com.tencent.mobileqq.onlinestatus.location.OnlineStatusLocationFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ayst
  implements View.OnClickListener
{
  public ayst(OnlineStatusLocationFragment paramOnlineStatusLocationFragment) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("OnlineStatusLocationFragment", 2, "myBtn onClick: invoked. set my btn black");
    }
    this.a.a.setClickable(false);
    this.a.a.setImageDrawable(this.a.getActivity().getResources().getDrawable(2130840540));
    OnlineStatusLocationFragment.a(this.a).a(true);
    OnlineStatusLocationFragment.a(this.a, OnlineStatusLocationFragment.a(this.a).a());
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayst
 * JD-Core Version:    0.7.0.1
 */