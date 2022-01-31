import android.support.v4.view.ViewPager.OnPageChangeListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.profile.VipProfileCardPreviewActivity;
import com.tencent.mobileqq.profile.view.VipScaledViewPager;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class awsc
  implements ViewPager.OnPageChangeListener
{
  boolean jdField_a_of_type_Boolean = false;
  boolean b = false;
  
  public awsc(VipProfileCardPreviewActivity paramVipProfileCardPreviewActivity) {}
  
  public void onPageScrollStateChanged(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, "onPageScrollStateChanged state = " + paramInt);
    }
    if (paramInt == 1)
    {
      this.jdField_a_of_type_ComTencentMobileqqProfileVipProfileCardPreviewActivity.jdField_a_of_type_ComTencentMobileqqProfileViewVipScaledViewPager.b();
      this.jdField_a_of_type_ComTencentMobileqqProfileVipProfileCardPreviewActivity.a(this.jdField_a_of_type_ComTencentMobileqqProfileVipProfileCardPreviewActivity.x);
      this.b = true;
    }
    if (paramInt == 2) {
      this.jdField_a_of_type_Boolean = true;
    }
    if (paramInt == 0)
    {
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentMobileqqProfileVipProfileCardPreviewActivity.b(this.jdField_a_of_type_ComTencentMobileqqProfileVipProfileCardPreviewActivity.x);
        this.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_ComTencentMobileqqProfileVipProfileCardPreviewActivity.jdField_a_of_type_ComTencentMobileqqProfileViewVipScaledViewPager.a();
      }
      if (this.b)
      {
        this.jdField_a_of_type_ComTencentMobileqqProfileVipProfileCardPreviewActivity.jdField_a_of_type_ComTencentMobileqqProfileViewVipScaledViewPager.a();
        this.b = false;
      }
    }
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, "onPageScrolled pos = " + paramInt1);
    }
    this.jdField_a_of_type_ComTencentMobileqqProfileVipProfileCardPreviewActivity.jdField_a_of_type_ComTencentMobileqqProfileViewVipScaledViewPager.b();
  }
  
  public void onPageSelected(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, "onPageSelected pos = " + paramInt);
    }
    this.jdField_a_of_type_ComTencentMobileqqProfileVipProfileCardPreviewActivity.jdField_a_of_type_ComTencentMobileqqProfileViewVipScaledViewPager.a();
    this.jdField_a_of_type_ComTencentMobileqqProfileVipProfileCardPreviewActivity.d(paramInt);
    this.jdField_a_of_type_ComTencentMobileqqProfileVipProfileCardPreviewActivity.x = paramInt;
    if (((awrb)this.jdField_a_of_type_ComTencentMobileqqProfileVipProfileCardPreviewActivity.jdField_a_of_type_JavaUtilList.get(paramInt)).a.o == awra.h)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, "report shopping template = " + paramInt);
      }
      azqs.b(this.jdField_a_of_type_ComTencentMobileqqProfileVipProfileCardPreviewActivity.app, "CliOper", "", "", "Shop_Malltemplate", "0X8005B93", 0, 0, "", "", "", "");
    }
    azqs.b(this.jdField_a_of_type_ComTencentMobileqqProfileVipProfileCardPreviewActivity.app, "CliOper", "", "", "card_mall", "0X8004C26", 0, 0, "", "", "", VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqProfileVipProfileCardPreviewActivity.app, this.jdField_a_of_type_ComTencentMobileqqProfileVipProfileCardPreviewActivity.app.getCurrentAccountUin()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awsc
 * JD-Core Version:    0.7.0.1
 */