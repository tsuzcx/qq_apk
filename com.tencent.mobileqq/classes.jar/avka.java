import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.nearby.picbrowser.PicInfo;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import java.util.ArrayList;

class avka
  implements View.OnClickListener
{
  avka(avjc paramavjc, int paramInt) {}
  
  public void onClick(View paramView)
  {
    PicInfo localPicInfo = (PicInfo)paramView.getTag();
    if (localPicInfo == null) {
      return;
    }
    bhpy localbhpy = bhpy.a(this.jdField_a_of_type_Avjc.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity);
    if (this.jdField_a_of_type_Int != 0) {
      localbhpy.c(this.jdField_a_of_type_Avjc.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getString(2131694729));
    }
    localbhpy.c(alpo.a(2131707643));
    if (this.jdField_a_of_type_Avjc.jdField_a_of_type_JavaUtilArrayList.size() > 1) {
      localbhpy.a(alpo.a(2131707726), 3);
    }
    localbhpy.c(2131690648);
    localbhpy.a(new avkb(this, paramView, localPicInfo, localbhpy));
    localbhpy.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avka
 * JD-Core Version:    0.7.0.1
 */