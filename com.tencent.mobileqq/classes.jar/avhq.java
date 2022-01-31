import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;

class avhq
  implements View.OnClickListener
{
  avhq(avgk paramavgk, String paramString) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_Avgk.a, QQBrowserActivity.class);
    StringBuilder localStringBuilder = new StringBuilder().append(this.jdField_a_of_type_JavaLangString).append("&from=");
    paramView = this.jdField_a_of_type_Avgk.a;
    if (NearbyPeopleProfileActivity.a(this.jdField_a_of_type_Avgk.a.j)) {}
    for (paramView = "1";; paramView = "2")
    {
      localIntent.putExtra("url", paramView);
      this.jdField_a_of_type_Avgk.a.startActivity(localIntent);
      azmj.b(this.jdField_a_of_type_Avgk.a.app, "dc00899", "grp_lbs", "", "data_card", "clk_fans", 0, 0, "", "", "", "");
      this.jdField_a_of_type_Avgk.a.l = true;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avhq
 * JD-Core Version:    0.7.0.1
 */