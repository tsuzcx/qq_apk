import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileFragment;

public class atty
  implements View.OnClickListener
{
  public atty(NearbyProfileFragment paramNearbyProfileFragment, String paramString, int paramInt) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileFragment.a, QQBrowserActivity.class);
    paramView.putExtra("url", this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileFragment.a.startActivity(paramView);
    axra localaxra = new axra(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileFragment.a.app).a("dc00899").b("grp_lbs").c("face_score_vip").d("expert_click");
    String str1 = "" + (NearbyProfileFragment.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileFragment).gender + 1);
    String str2 = "" + this.jdField_a_of_type_Int;
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileFragment.a.e == 3) {}
    for (paramView = "2";; paramView = "1")
    {
      localaxra.a(new String[] { "", str1, str2, paramView }).a();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atty
 * JD-Core Version:    0.7.0.1
 */