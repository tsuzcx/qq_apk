import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.nearby.picbrowser.PicInfo;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class asub
  implements View.OnClickListener
{
  asub(aste paramaste) {}
  
  public void onClick(View paramView)
  {
    PicInfo localPicInfo;
    if ((paramView.getTag() instanceof PicInfo))
    {
      localPicInfo = (PicInfo)paramView.getTag();
      if (localPicInfo.g != "type_qq_head_pic") {
        break label189;
      }
      localPicInfo.c = this.a.a.app.a(32, String.valueOf(aste.a(this.a).uin), 200);
      if (QLog.isColorLevel()) {
        QLog.e("Q.nearby_people_card.", 2, "on mode guest small head clicked: uin is: " + aste.a(this.a).uin + " local path is: " + localPicInfo.c);
      }
      paramView = xgx.a(paramView);
      this.a.a.a(localPicInfo, paramView);
      if (ProfileActivity.c(this.a.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.h)) {
        awqx.b(this.a.a.app, "CliOper", "", "", "0X8005240", "0X8005240", 0, 0, "", "", "", "");
      }
    }
    return;
    label189:
    paramView = xgx.a(paramView);
    int i = 0;
    label196:
    int j;
    if (i < this.a.a.jdField_a_of_type_JavaUtilArrayList.size()) {
      if (aste.a(this.a).nowUserType == 0)
      {
        if (localPicInfo.jdField_a_of_type_Int != ((PicInfo)this.a.a.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_Int) {
          break label425;
        }
        j = i;
      }
    }
    for (;;)
    {
      label256:
      this.a.a.a(j, paramView);
      awqx.b(this.a.a.app, "CliOper", "", "", "0X800482A", "0X800482A", 0, 0, "", "", "", "");
      if (this.a.a.e == 3) {}
      for (paramView = "2";; paramView = "1")
      {
        awqx.b(null, "dc00899", "grp_lbs", "", "data_card", "clk_pic", 0, 0, paramView, "", "", "");
        if (!asep.a(this.a.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.h, this.a.a.e)) {
          break;
        }
        this.a.a.app.a().b(localPicInfo.jdField_a_of_type_JavaLangString);
        return;
        j = i;
        if (TextUtils.equals(localPicInfo.jdField_a_of_type_JavaLangString, ((PicInfo)this.a.a.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_JavaLangString)) {
          break label256;
        }
        label425:
        i += 1;
        break label196;
      }
      j = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     asub
 * JD-Core Version:    0.7.0.1
 */