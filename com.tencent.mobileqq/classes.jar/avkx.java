import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayPanel.13;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayPanel.13.1;

public class avkx
  implements View.OnClickListener
{
  public avkx(NearbyProfileDisplayPanel.13.1 param1) {}
  
  public void onClick(View paramView)
  {
    if (TextUtils.isEmpty(avkt.a(this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel$13.this$0).strGodJumpUrl)) {
      return;
    }
    paramView = new Intent(this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel$13.this$0.a, QQBrowserActivity.class);
    Object localObject = new StringBuilder().append(avkt.a(this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel$13.this$0).strGodJumpUrl).append("&gender=");
    int i;
    if (this.a.jdField_a_of_type_ComTencentMobileqqDataCard == null)
    {
      i = 0;
      paramView.putExtra("url", i);
      this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel$13.this$0.a.startActivity(paramView);
      localObject = this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel$13.this$0.a.app;
      if (this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel$13.this$0.a.e != 2) {
        break label202;
      }
    }
    label202:
    for (paramView = "1";; paramView = "2")
    {
      azqs.b((QQAppInterface)localObject, "dc00899", "grp_lbs", "", "rank_list", "clk_icon", 0, 0, paramView, "", "", "");
      return;
      i = this.a.jdField_a_of_type_ComTencentMobileqqDataCard.shGender + 1;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avkx
 * JD-Core Version:    0.7.0.1
 */