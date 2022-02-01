import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.widget.ProgressButton;

class aylw
  implements DialogInterface.OnClickListener
{
  aylw(aykx paramaykx) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      if (this.a.jdField_a_of_type_Aypz != null) {
        this.a.jdField_a_of_type_Aypz.a(2);
      }
      if (aykx.a(this.a) != null)
      {
        if (!this.a.m) {
          break label88;
        }
        bdll.b(this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "P_CliOper", "Grp_qiqiqun", "", "qiqi_qq_mob_nearby", "download_trigger", 0, 0, aykx.a(this.a).uin, "", "yes", "android");
      }
    }
    label88:
    do
    {
      do
      {
        return;
        bdll.b(this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "P_CliOper", "Grp_qiqiqun", "", "qiqi_qq_mob_nearby", "download_goon", 0, 0, aykx.a(this.a).uin, "", "yes", "android");
        return;
      } while (paramInt != 0);
      if (this.a.jdField_a_of_type_Aypz != null) {
        this.a.jdField_a_of_type_Aypz.a(10);
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqWidgetProgressButton != null)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetProgressButton.setText(2131697963);
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetProgressButton.setProgress(0);
      }
      this.a.jdField_a_of_type_Int = 2;
    } while (aykx.a(this.a) == null);
    bdll.b(this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "P_CliOper", "Grp_qiqiqun", "", "qiqi_qq_mob_nearby", "download_cancel", 0, 0, aykx.a(this.a).uin, "", "yes", "android");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aylw
 * JD-Core Version:    0.7.0.1
 */