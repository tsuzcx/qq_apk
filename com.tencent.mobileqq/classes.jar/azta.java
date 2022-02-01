import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.profile.lifeachivement.LifeAchivementPanelView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class azta
  implements View.OnClickListener
{
  public azta(LifeAchivementPanelView paramLifeAchivementPanelView) {}
  
  public void onClick(View paramView)
  {
    int i = 2;
    if (QLog.isColorLevel()) {
      QLog.i("LifeAchivementPanelView", 2, "DATA_TYPE_LIFE_ACHIVEMENT_TITLE on click");
    }
    azsy.a(LifeAchivementPanelView.b(this.a), this.a.a);
    if (LifeAchivementPanelView.a(this.a)) {
      i = 1;
    }
    bdla.b(null, "", "", "", "0X800AE57", "0X800AE57", i, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azta
 * JD-Core Version:    0.7.0.1
 */