import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;

class avix
  implements View.OnClickListener
{
  avix(avhw paramavhw, String paramString) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_Avhw.a, QQBrowserActivity.class);
    StringBuilder localStringBuilder = new StringBuilder().append(this.jdField_a_of_type_JavaLangString).append("&from=");
    paramView = this.jdField_a_of_type_Avhw.a;
    if (NearbyPeopleProfileActivity.a(this.jdField_a_of_type_Avhw.a.j)) {}
    for (paramView = "1";; paramView = "2")
    {
      localIntent.putExtra("url", paramView);
      this.jdField_a_of_type_Avhw.a.startActivity(localIntent);
      azmj.b(this.jdField_a_of_type_Avhw.a.app, "dc00899", "grp_lbs", "", "data_card", "clk_fans", 0, 0, "", "", "", "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avix
 * JD-Core Version:    0.7.0.1
 */