import android.os.Bundle;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.bubble.BubbleDiyEntity;
import com.tencent.mobileqq.emosm.web.MessengerService;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class ashp
  implements BusinessObserver
{
  ashp(ashe paramashe, Bundle paramBundle1, MessengerService paramMessengerService, Bundle paramBundle2) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && (paramObject != null)) {}
    try
    {
      if ((paramObject instanceof List))
      {
        paramObject = (List)paramObject;
        if (!paramObject.isEmpty())
        {
          this.jdField_a_of_type_AndroidOsBundle.putString("diyText", ((BubbleDiyEntity)paramObject.get(0)).diyText);
          this.jdField_a_of_type_AndroidOsBundle.putString("isDiy", "1");
          this.jdField_a_of_type_AndroidOsBundle.putString("tl", ((BubbleDiyEntity)paramObject.get(0)).topLeftId);
          this.jdField_a_of_type_AndroidOsBundle.putString("tr", ((BubbleDiyEntity)paramObject.get(0)).topRightId);
          this.jdField_a_of_type_AndroidOsBundle.putString("bl", ((BubbleDiyEntity)paramObject.get(0)).bottomLeftId);
          this.jdField_a_of_type_AndroidOsBundle.putString("br", ((BubbleDiyEntity)paramObject.get(0)).bottomRightId);
        }
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService.a(this.b);
        return;
        this.jdField_a_of_type_AndroidOsBundle.putString("diyText", "");
      }
      return;
    }
    catch (Exception paramObject)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.emoji.web.MessengerService", 2, paramObject.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ashp
 * JD-Core Version:    0.7.0.1
 */