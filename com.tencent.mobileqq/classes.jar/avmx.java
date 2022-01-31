import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.picbrowser.PicInfo;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import java.util.ArrayList;

class avmx
  implements View.OnClickListener
{
  avmx(avmf paramavmf) {}
  
  public void onClick(View paramView)
  {
    if (this.a.p)
    {
      avmf.b(this.a);
      return;
    }
    PicInfo localPicInfo = (PicInfo)paramView.getTag();
    paramView = zjc.a(paramView);
    int i = 0;
    label33:
    if (i < this.a.a.jdField_a_of_type_JavaUtilArrayList.size()) {
      if (localPicInfo.jdField_a_of_type_Int != ((PicInfo)this.a.a.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_Int) {}
    }
    for (;;)
    {
      this.a.a.a(i, paramView);
      azqs.b(this.a.a.app, "CliOper", "", "", "0X800482A", "0X800482A", 0, 0, "", "", "", "");
      if (this.a.a.e == 3) {}
      for (paramView = "2";; paramView = "1")
      {
        azqs.b(null, "dc00899", "grp_lbs", "", "data_card", "clk_pic", 0, 0, paramView, "", "", "");
        if (!auwd.a(this.a.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.h, this.a.a.e)) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avmx
 * JD-Core Version:    0.7.0.1
 */