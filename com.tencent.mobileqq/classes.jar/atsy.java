import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.nearby.picbrowser.PicInfo;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import java.util.ArrayList;

class atsy
  implements View.OnClickListener
{
  atsy(atsa paramatsa, int paramInt) {}
  
  public void onClick(View paramView)
  {
    PicInfo localPicInfo = (PicInfo)paramView.getTag();
    if (localPicInfo == null) {
      return;
    }
    bfol localbfol = bfol.a(this.jdField_a_of_type_Atsa.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity);
    if (this.jdField_a_of_type_Int != 0) {
      localbfol.c(this.jdField_a_of_type_Atsa.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getString(2131694572));
    }
    localbfol.c(ajyc.a(2131707260));
    if (this.jdField_a_of_type_Atsa.jdField_a_of_type_JavaUtilArrayList.size() > 1) {
      localbfol.a(ajyc.a(2131707343), 3);
    }
    localbfol.c(2131690596);
    localbfol.a(new atsz(this, paramView, localPicInfo, localbfol));
    localbfol.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atsy
 * JD-Core Version:    0.7.0.1
 */