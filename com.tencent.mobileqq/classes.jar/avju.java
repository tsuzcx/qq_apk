import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.gamecenter.data.GameNoticeCenter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.os.MqqHandler;

public class avju
  implements View.OnClickListener
{
  public avju(GameNoticeCenter paramGameNoticeCenter, String paramString) {}
  
  public void onClick(View paramView)
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = ((QQAppInterface)localObject).getHandler(GameNoticeCenter.class);
      if (localObject != null)
      {
        localObject = ((MqqHandler)localObject).obtainMessage(2);
        ((Message)localObject).obj = this.jdField_a_of_type_JavaLangString;
        ((Message)localObject).sendToTarget();
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avju
 * JD-Core Version:    0.7.0.1
 */