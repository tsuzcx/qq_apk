import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aynl
  implements View.OnClickListener
{
  aynl(aymj paramaymj, String paramString) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_Aymj.a, QQBrowserActivity.class);
    StringBuilder localStringBuilder = new StringBuilder().append(this.jdField_a_of_type_JavaLangString).append("&from=");
    Object localObject = this.jdField_a_of_type_Aymj.a;
    if (NearbyPeopleProfileActivity.a(this.jdField_a_of_type_Aymj.a.j)) {}
    for (localObject = "1";; localObject = "2")
    {
      localIntent.putExtra("url", (String)localObject);
      bdll.b(this.jdField_a_of_type_Aymj.a.app, "dc00899", "grp_lbs", "", "data_card", "clk_focus", 0, 0, "", "", "", "");
      this.jdField_a_of_type_Aymj.a.startActivity(localIntent);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aynl
 * JD-Core Version:    0.7.0.1
 */