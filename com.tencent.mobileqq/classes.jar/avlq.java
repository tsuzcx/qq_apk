import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.nearby.picbrowser.PicInfo;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import java.util.ArrayList;

class avlq
  implements View.OnClickListener
{
  avlq(avkt paramavkt) {}
  
  public void onClick(View paramView)
  {
    PicInfo localPicInfo;
    int i;
    int j;
    if ((paramView.getTag() instanceof PicInfo))
    {
      localPicInfo = (PicInfo)paramView.getTag();
      paramView = zjc.a(paramView);
      i = 0;
      if (i >= this.a.a.jdField_a_of_type_JavaUtilArrayList.size()) {
        break label268;
      }
      if (avkt.a(this.a).nowUserType != 0) {
        break label222;
      }
      if (localPicInfo.jdField_a_of_type_Int != ((PicInfo)this.a.a.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_Int) {
        break label255;
      }
      j = i;
    }
    for (;;)
    {
      label86:
      this.a.a.a(j, paramView);
      azqs.b(this.a.a.app, "CliOper", "", "", "0X800482A", "0X800482A", 0, 0, "", "", "", "");
      if (this.a.a.e == 3) {}
      for (paramView = "2";; paramView = "1")
      {
        azqs.b(null, "dc00899", "grp_lbs", "", "data_card", "clk_pic", 0, 0, paramView, "", "", "");
        if (auwd.a(this.a.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.h, this.a.a.e)) {
          this.a.a.app.a().b(localPicInfo.jdField_a_of_type_JavaLangString);
        }
        return;
        label222:
        j = i;
        if (TextUtils.equals(localPicInfo.jdField_a_of_type_JavaLangString, ((PicInfo)this.a.a.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_JavaLangString)) {
          break label86;
        }
        label255:
        i += 1;
        break;
      }
      label268:
      j = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avlq
 * JD-Core Version:    0.7.0.1
 */