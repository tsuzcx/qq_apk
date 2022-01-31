import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.picbrowser.PicInfo;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import java.util.ArrayList;

class atro
  implements View.OnClickListener
{
  atro(atqw paramatqw) {}
  
  public void onClick(View paramView)
  {
    if (this.a.p)
    {
      atqw.b(this.a);
      return;
    }
    PicInfo localPicInfo = (PicInfo)paramView.getTag();
    paramView = xpu.a(paramView);
    int i = 0;
    label33:
    if (i < this.a.a.jdField_a_of_type_JavaUtilArrayList.size()) {
      if (localPicInfo.jdField_a_of_type_Int != ((PicInfo)this.a.a.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_Int) {}
    }
    for (;;)
    {
      this.a.a.a(i, paramView);
      axqy.b(this.a.a.app, "CliOper", "", "", "0X800482A", "0X800482A", 0, 0, "", "", "", "");
      if (this.a.a.e == 3) {}
      for (paramView = "2";; paramView = "1")
      {
        axqy.b(null, "dc00899", "grp_lbs", "", "data_card", "clk_pic", 0, 0, paramView, "", "", "");
        if (!atav.a(this.a.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.h, this.a.a.e)) {
          break;
        }
        this.a.a.app.a().b(localPicInfo.jdField_a_of_type_JavaLangString);
        return;
        i += 1;
        break label33;
      }
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atro
 * JD-Core Version:    0.7.0.1
 */