import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.mobileqq.vas.VasQuickUpdateManager.CallBacker;
import com.tencent.mobileqq.widget.RandomCoverView;

final class bjmk
  extends VasQuickUpdateManager.CallBacker
{
  bjmk(BaseActivity paramBaseActivity, Card paramCard, RandomCoverView paramRandomCoverView, amst paramamst, boolean paramBoolean) {}
  
  public void callback(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, VasQuickUpdateManager paramVasQuickUpdateManager)
  {
    bjmj.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramVasQuickUpdateManager.app, this.jdField_a_of_type_ComTencentMobileqqDataCard, this.jdField_a_of_type_ComTencentMobileqqWidgetRandomCoverView, this.jdField_a_of_type_Amst, this.jdField_a_of_type_Boolean);
    paramVasQuickUpdateManager.removeCallBacker(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjmk
 * JD-Core Version:    0.7.0.1
 */