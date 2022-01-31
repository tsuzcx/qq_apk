import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;

class atry
  implements View.OnClickListener
{
  atry(atqw paramatqw, String paramString) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_Atqw.a, QQBrowserActivity.class);
    StringBuilder localStringBuilder = new StringBuilder().append(this.jdField_a_of_type_JavaLangString).append("&from=");
    paramView = this.jdField_a_of_type_Atqw.a;
    if (NearbyPeopleProfileActivity.a(this.jdField_a_of_type_Atqw.a.j)) {}
    for (paramView = "1";; paramView = "2")
    {
      localIntent.putExtra("url", paramView);
      axqy.b(this.jdField_a_of_type_Atqw.a.app, "dc00899", "grp_lbs", "", "data_card", "clk_focus", 0, 0, "", "", "", "");
      this.jdField_a_of_type_Atqw.a.startActivity(localIntent);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atry
 * JD-Core Version:    0.7.0.1
 */