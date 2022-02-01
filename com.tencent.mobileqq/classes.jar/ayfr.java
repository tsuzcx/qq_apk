import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ayfr
  implements View.OnClickListener
{
  ayfr(ayek paramayek, String paramString) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_Ayek.a, QQBrowserActivity.class);
    StringBuilder localStringBuilder = new StringBuilder().append(this.jdField_a_of_type_JavaLangString).append("&from=");
    Object localObject = this.jdField_a_of_type_Ayek.a;
    if (NearbyPeopleProfileActivity.a(this.jdField_a_of_type_Ayek.a.j)) {}
    for (localObject = "1";; localObject = "2")
    {
      localIntent.putExtra("url", (String)localObject);
      this.jdField_a_of_type_Ayek.a.startActivity(localIntent);
      bdla.b(this.jdField_a_of_type_Ayek.a.app, "dc00899", "grp_lbs", "", "data_card", "clk_fans", 0, 0, "", "", "", "");
      this.jdField_a_of_type_Ayek.a.l = true;
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayfr
 * JD-Core Version:    0.7.0.1
 */