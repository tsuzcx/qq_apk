import android.support.v4.view.ViewPager.OnPageChangeListener;
import com.tencent.mobileqq.profile.view.PhotoViewForShopping;
import com.tencent.mobileqq.profile.view.VipScaledViewPager;

public class auze
  implements ViewPager.OnPageChangeListener
{
  boolean jdField_a_of_type_Boolean = false;
  boolean b = false;
  
  public auze(PhotoViewForShopping paramPhotoViewForShopping) {}
  
  public void onPageScrollStateChanged(int paramInt)
  {
    if (paramInt == 1)
    {
      this.jdField_a_of_type_ComTencentMobileqqProfileViewPhotoViewForShopping.a.b();
      this.jdField_a_of_type_Boolean = true;
    }
    if (paramInt == 2) {
      this.b = true;
    }
    if (paramInt == 0)
    {
      if (this.b)
      {
        this.b = false;
        this.jdField_a_of_type_ComTencentMobileqqProfileViewPhotoViewForShopping.a.a();
      }
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentMobileqqProfileViewPhotoViewForShopping.a.a();
        this.jdField_a_of_type_Boolean = false;
      }
    }
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auze
 * JD-Core Version:    0.7.0.1
 */