import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.gamecenter.data.GameNoticeCenter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.os.MqqHandler;

public class avca
  implements View.OnClickListener
{
  public avca(GameNoticeCenter paramGameNoticeCenter, String paramString) {}
  
  public void onClick(View paramView)
  {
    Message localMessage = GameNoticeCenter.access$200(this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeCenter).obtainMessage(1);
    localMessage.obj = this.jdField_a_of_type_JavaLangString;
    localMessage.sendToTarget();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avca
 * JD-Core Version:    0.7.0.1
 */