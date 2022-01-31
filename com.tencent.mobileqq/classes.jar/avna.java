import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.widget.ProgressButton;

class avna
  implements DialogInterface.OnClickListener
{
  avna(avmf paramavmf) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      if (this.a.jdField_a_of_type_Avpv != null) {
        this.a.jdField_a_of_type_Avpv.a(2);
      }
      if (avmf.a(this.a) != null)
      {
        if (!this.a.n) {
          break label88;
        }
        azqs.b(this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "P_CliOper", "Grp_qiqiqun", "", "qiqi_qq_mob_nearby", "download_trigger", 0, 0, avmf.a(this.a).uin, "", "yes", "android");
      }
    }
    label88:
    do
    {
      do
      {
        return;
        azqs.b(this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "P_CliOper", "Grp_qiqiqun", "", "qiqi_qq_mob_nearby", "download_goon", 0, 0, avmf.a(this.a).uin, "", "yes", "android");
        return;
      } while (paramInt != 0);
      if (this.a.jdField_a_of_type_Avpv != null) {
        this.a.jdField_a_of_type_Avpv.a(10);
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqWidgetProgressButton != null)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetProgressButton.setText(2131699251);
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetProgressButton.setProgress(0);
      }
      this.a.jdField_a_of_type_Int = 2;
    } while (avmf.a(this.a) == null);
    azqs.b(this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "P_CliOper", "Grp_qiqiqun", "", "qiqi_qq_mob_nearby", "download_cancel", 0, 0, avmf.a(this.a).uin, "", "yes", "android");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avna
 * JD-Core Version:    0.7.0.1
 */