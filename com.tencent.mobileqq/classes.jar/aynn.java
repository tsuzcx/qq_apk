import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mobileqq.nearby.picbrowser.PicInfo;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.nearby.widget.AvatarWallPagerAdapter;
import com.tencent.mobileqq.nearby.widget.AvatarWallViewPager;
import java.util.Collection;
import java.util.Map;

public class aynn
  extends AvatarWallPagerAdapter<PicInfo>
{
  protected LinearLayout.LayoutParams a;
  
  public aynn(aymj paramaymj, AvatarWallViewPager paramAvatarWallViewPager)
  {
    super(paramAvatarWallViewPager);
  }
  
  public View a(int paramInt, PicInfo paramPicInfo)
  {
    return this.jdField_a_of_type_Aymj.a(paramInt, paramPicInfo);
  }
  
  public View a(boolean paramBoolean, int paramInt)
  {
    View localView = new View(this.jdField_a_of_type_Aymj.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity);
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams == null)
    {
      paramInt = zps.a(this.jdField_a_of_type_Aymj.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 5.0F);
      this.jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams = new LinearLayout.LayoutParams(paramInt, paramInt);
      paramInt = zps.a(this.jdField_a_of_type_Aymj.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 4.0F);
      this.jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams.leftMargin = (paramInt / 2);
      this.jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams.rightMargin = (paramInt / 2);
    }
    if (paramBoolean) {}
    for (Drawable localDrawable = bguq.a(this.jdField_a_of_type_Aymj.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources(), Color.parseColor("#CC12B7F5"), this.jdField_a_of_type_Aymj.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getDrawable(2130843683));; localDrawable = bguq.a(this.jdField_a_of_type_Aymj.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources(), Color.parseColor("#66FFFFFF"), this.jdField_a_of_type_Aymj.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getDrawable(2130843683)))
    {
      localView.setLayoutParams(this.jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams);
      localView.setBackgroundDrawable(localDrawable);
      return localView;
    }
  }
  
  public void a(int paramInt, View paramView)
  {
    this.jdField_a_of_type_Aymj.jdField_a_of_type_JavaUtilMap.values().remove(paramView);
  }
  
  public boolean a(PicInfo paramPicInfo1, PicInfo paramPicInfo2)
  {
    return this.jdField_a_of_type_Aymj.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.a(paramPicInfo1, paramPicInfo2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aynn
 * JD-Core Version:    0.7.0.1
 */