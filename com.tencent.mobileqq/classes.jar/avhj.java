import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.widget.ProgressButton;

class avhj
  implements DialogInterface.OnClickListener
{
  avhj(avgk paramavgk) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      if (this.a.jdField_a_of_type_Avlm != null) {
        this.a.jdField_a_of_type_Avlm.a(2);
      }
      if (avgk.a(this.a) != null)
      {
        if (!this.a.m) {
          break label88;
        }
        azmj.b(this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "P_CliOper", "Grp_qiqiqun", "", "qiqi_qq_mob_nearby", "download_trigger", 0, 0, avgk.a(this.a).uin, "", "yes", "android");
      }
    }
    label88:
    do
    {
      do
      {
        return;
        azmj.b(this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "P_CliOper", "Grp_qiqiqun", "", "qiqi_qq_mob_nearby", "download_goon", 0, 0, avgk.a(this.a).uin, "", "yes", "android");
        return;
      } while (paramInt != 0);
      if (this.a.jdField_a_of_type_Avlm != null) {
        this.a.jdField_a_of_type_Avlm.a(10);
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqWidgetProgressButton != null)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetProgressButton.setText(2131699239);
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetProgressButton.setProgress(0);
      }
      this.a.jdField_a_of_type_Int = 2;
    } while (avgk.a(this.a) == null);
    azmj.b(this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "P_CliOper", "Grp_qiqiqun", "", "qiqi_qq_mob_nearby", "download_cancel", 0, 0, avgk.a(this.a).uin, "", "yes", "android");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avhj
 * JD-Core Version:    0.7.0.1
 */