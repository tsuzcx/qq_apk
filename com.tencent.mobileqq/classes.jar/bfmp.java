import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.mobileqq.vas.VasQuickUpdateManager.CallBacker;
import com.tencent.mobileqq.widget.RandomCoverView;

final class bfmp
  extends VasQuickUpdateManager.CallBacker
{
  bfmp(BaseActivity paramBaseActivity, Card paramCard, RandomCoverView paramRandomCoverView, ajxg paramajxg, boolean paramBoolean) {}
  
  public void callback(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, VasQuickUpdateManager paramVasQuickUpdateManager)
  {
    bfmo.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramVasQuickUpdateManager.app, this.jdField_a_of_type_ComTencentMobileqqDataCard, this.jdField_a_of_type_ComTencentMobileqqWidgetRandomCoverView, this.jdField_a_of_type_Ajxg, this.jdField_a_of_type_Boolean);
    paramVasQuickUpdateManager.removeCallBacker(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bfmp
 * JD-Core Version:    0.7.0.1
 */