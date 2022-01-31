import android.os.CountDownTimer;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.portal.FormalView;
import com.tencent.mobileqq.portal.PortalManager;
import com.tencent.mobileqq.portal.ProgressViewRed;

class awia
  extends CountDownTimer
{
  awia(awhw paramawhw, long paramLong1, long paramLong2, long[] paramArrayOfLong)
  {
    super(paramLong1, paramLong2);
  }
  
  public void onFinish()
  {
    PortalManager localPortalManager = (PortalManager)this.jdField_a_of_type_Awhw.jdField_a_of_type_ComTencentMobileqqActivityConversation.a.getManager(79);
    if (localPortalManager != null) {
      localPortalManager.a();
    }
  }
  
  public void onTick(long paramLong)
  {
    if (awhw.a(this.jdField_a_of_type_Awhw).getVisibility() == 0)
    {
      this.jdField_a_of_type_Awhw.a(paramLong);
      awhw.a(this.jdField_a_of_type_Awhw).a(paramLong, this.jdField_a_of_type_ArrayOfLong[0], this.jdField_a_of_type_Awhw.jdField_a_of_type_JavaLangStringBuilder);
    }
    if (this.jdField_a_of_type_Awhw.jdField_a_of_type_ComTencentMobileqqPortalFormalView.getVisibility() == 0)
    {
      this.jdField_a_of_type_Awhw.a(paramLong);
      this.jdField_a_of_type_Awhw.jdField_a_of_type_ComTencentMobileqqPortalFormalView.a(paramLong, this.jdField_a_of_type_ArrayOfLong[0], this.jdField_a_of_type_Awhw.jdField_b_of_type_JavaLangStringBuilder);
    }
    paramLong = System.currentTimeMillis() - this.jdField_a_of_type_Awhw.jdField_b_of_type_Long;
    if (paramLong > 2000L) {
      this.jdField_a_of_type_Awhw.jdField_a_of_type_ComTencentMobileqqPortalFormalView.setHBSpeed(1);
    }
    while (paramLong <= 1000L) {
      return;
    }
    this.jdField_a_of_type_Awhw.jdField_a_of_type_ComTencentMobileqqPortalFormalView.setHBSpeed(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awia
 * JD-Core Version:    0.7.0.1
 */