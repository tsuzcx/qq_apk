import android.content.Intent;
import android.view.View;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.nearby.interestTag.InterestTagInfo;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;

class axar
  implements axdg
{
  axar(awzr paramawzr, String paramString) {}
  
  public void a(View paramView, int paramInt, InterestTagInfo paramInterestTagInfo)
  {
    if (paramInterestTagInfo.tagJumpUrl.equals("icon_more_url"))
    {
      paramView = new Intent(this.jdField_a_of_type_Awzr.a, QQBrowserActivity.class);
      paramView.putExtra("url", this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_Awzr.a.startActivity(paramView);
      paramInterestTagInfo = this.jdField_a_of_type_Awzr.a.app;
      if (this.jdField_a_of_type_Awzr.a.e == 2) {}
      for (paramView = "1";; paramView = "2")
      {
        bcef.b(paramInterestTagInfo, "dc00899", "grp_lbs", "", "data_card", "clk_more_tribe", 0, 0, paramView, "", "", "");
        return;
      }
    }
    paramView = new Intent(this.jdField_a_of_type_Awzr.a, QQBrowserActivity.class);
    paramView.putExtra("url", paramInterestTagInfo.tagJumpUrl);
    this.jdField_a_of_type_Awzr.a.startActivity(paramView);
    paramInterestTagInfo = this.jdField_a_of_type_Awzr.a.app;
    if (this.jdField_a_of_type_Awzr.a.e == 2) {}
    for (paramView = "1";; paramView = "2")
    {
      bcef.b(paramInterestTagInfo, "dc00899", "grp_lbs", "", "data_card", "clk_tribe", 0, 0, paramView, "", "", "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axar
 * JD-Core Version:    0.7.0.1
 */