import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.nearby.picbrowser.PicInfo;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import java.util.ArrayList;

class atta
  implements View.OnClickListener
{
  atta(atsc paramatsc, int paramInt) {}
  
  public void onClick(View paramView)
  {
    PicInfo localPicInfo = (PicInfo)paramView.getTag();
    if (localPicInfo == null) {
      return;
    }
    bfpc localbfpc = bfpc.a(this.jdField_a_of_type_Atsc.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity);
    if (this.jdField_a_of_type_Int != 0) {
      localbfpc.c(this.jdField_a_of_type_Atsc.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getString(2131694573));
    }
    localbfpc.c(ajya.a(2131707271));
    if (this.jdField_a_of_type_Atsc.jdField_a_of_type_JavaUtilArrayList.size() > 1) {
      localbfpc.a(ajya.a(2131707354), 3);
    }
    localbfpc.c(2131690596);
    localbfpc.a(new attb(this, paramView, localPicInfo, localbfpc));
    localbfpc.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atta
 * JD-Core Version:    0.7.0.1
 */