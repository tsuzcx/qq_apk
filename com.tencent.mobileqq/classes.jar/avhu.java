import android.view.View;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mobileqq.nearby.picbrowser.PicInfo;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.nearby.widget.AvatarWallPagerAdapter;
import java.util.Collection;
import java.util.Map;

public class avhu
  extends AvatarWallPagerAdapter<PicInfo>
{
  protected LinearLayout.LayoutParams a;
  
  public View a(int paramInt, PicInfo paramPicInfo)
  {
    return this.jdField_a_of_type_Avgk.a(paramInt, paramPicInfo);
  }
  
  public View a(boolean paramBoolean, int paramInt)
  {
    View localView = new View(this.jdField_a_of_type_Avgk.jdField_a_of_type_AndroidContentContext);
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams == null)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams = new LinearLayout.LayoutParams(xod.a(this.jdField_a_of_type_Avgk.jdField_a_of_type_AndroidContentContext, 11.0F), xod.a(this.jdField_a_of_type_Avgk.jdField_a_of_type_AndroidContentContext, 1.0F));
      this.jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams.leftMargin = xod.a(this.jdField_a_of_type_Avgk.jdField_a_of_type_AndroidContentContext, 2.0F);
      this.jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams.rightMargin = xod.a(this.jdField_a_of_type_Avgk.jdField_a_of_type_AndroidContentContext, 2.0F);
    }
    localView.setLayoutParams(this.jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams);
    if (paramBoolean)
    {
      localView.setBackgroundColor(-1);
      return localView;
    }
    localView.setBackgroundColor(1728053247);
    return localView;
  }
  
  public void a(int paramInt, View paramView)
  {
    this.jdField_a_of_type_Avgk.jdField_a_of_type_JavaUtilMap.values().remove(paramView);
  }
  
  public boolean a(PicInfo paramPicInfo1, PicInfo paramPicInfo2)
  {
    return this.jdField_a_of_type_Avgk.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.a(paramPicInfo1, paramPicInfo2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avhu
 * JD-Core Version:    0.7.0.1
 */