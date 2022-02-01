import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ayjb
  implements View.OnClickListener
{
  public ayjb(NearbyProfileFragment paramNearbyProfileFragment, String paramString, int paramInt) {}
  
  public void onClick(View paramView)
  {
    Object localObject = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileFragment.a, QQBrowserActivity.class);
    ((Intent)localObject).putExtra("url", this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileFragment.a.startActivity((Intent)localObject);
    bdlf localbdlf = new bdlf(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileFragment.a.app).a("dc00899").b("grp_lbs").c("face_score_vip").d("expert_click");
    String str1 = "" + (NearbyProfileFragment.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileFragment).gender + 1);
    String str2 = "" + this.jdField_a_of_type_Int;
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileFragment.a.e == 3) {}
    for (localObject = "2";; localObject = "1")
    {
      localbdlf.a(new String[] { "", str1, str2, localObject }).a();
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayjb
 * JD-Core Version:    0.7.0.1
 */