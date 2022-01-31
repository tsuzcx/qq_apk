import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;

class aviy
  implements View.OnClickListener
{
  aviy(avhw paramavhw, String paramString) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_Avhw.a, QQBrowserActivity.class);
    StringBuilder localStringBuilder = new StringBuilder().append(this.jdField_a_of_type_JavaLangString).append("&from=");
    paramView = this.jdField_a_of_type_Avhw.a;
    if (NearbyPeopleProfileActivity.a(this.jdField_a_of_type_Avhw.a.j)) {}
    for (paramView = "1";; paramView = "2")
    {
      localIntent.putExtra("url", paramView);
      azmj.b(this.jdField_a_of_type_Avhw.a.app, "dc00899", "grp_lbs", "", "data_card", "clk_focus", 0, 0, "", "", "", "");
      this.jdField_a_of_type_Avhw.a.startActivity(localIntent);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aviy
 * JD-Core Version:    0.7.0.1
 */