import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.profile.lifeachivement.LifeAchivementPanelView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class azzp
  implements View.OnClickListener
{
  public azzp(LifeAchivementPanelView paramLifeAchivementPanelView) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LifeAchivementPanelView", 2, "addAchivementBtn onClicked");
    }
    azzo.a(LifeAchivementPanelView.a(this.a));
    bdll.b(null, "", "", "", "0X800AE54", "0X800AE54", 1, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azzp
 * JD-Core Version:    0.7.0.1
 */