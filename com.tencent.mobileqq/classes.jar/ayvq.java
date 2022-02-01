import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import java.util.HashMap;

class ayvq
  implements View.OnClickListener
{
  ayvq(ayvm paramayvm) {}
  
  public void onClick(View paramView)
  {
    QLog.d("ProfileCircleComponent", 4, "qqCircleWriteEntrance onClick");
    HashMap localHashMap = new HashMap();
    localHashMap.put("key_is_publish", "1");
    localHashMap.put("key_jump_from", "5");
    vgn.a(BaseApplicationImpl.getContext(), "openfolder", localHashMap);
    QCircleLpReportDc05504.report("", 3, 2, 2);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayvq
 * JD-Core Version:    0.7.0.1
 */