import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.nearby.picbrowser.PicInfo;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import java.util.ArrayList;

class aswu
  implements View.OnClickListener
{
  aswu(asvw paramasvw, int paramInt) {}
  
  public void onClick(View paramView)
  {
    PicInfo localPicInfo = (PicInfo)paramView.getTag();
    if (localPicInfo == null) {
      return;
    }
    begr localbegr = begr.a(this.jdField_a_of_type_Asvw.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity);
    if (this.jdField_a_of_type_Int != 0) {
      localbegr.c(this.jdField_a_of_type_Asvw.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getString(2131628911));
    }
    localbegr.c(ajjy.a(2131641475));
    if (this.jdField_a_of_type_Asvw.jdField_a_of_type_JavaUtilArrayList.size() > 1) {
      localbegr.a(ajjy.a(2131641558), 3);
    }
    localbegr.c(2131625035);
    localbegr.a(new aswv(this, paramView, localPicInfo, localbegr));
    localbegr.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aswu
 * JD-Core Version:    0.7.0.1
 */