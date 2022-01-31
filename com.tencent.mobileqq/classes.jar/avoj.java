import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.nearby.picbrowser.PicInfo;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import java.util.ArrayList;

class avoj
  implements View.OnClickListener
{
  avoj(avnl paramavnl, int paramInt) {}
  
  public void onClick(View paramView)
  {
    PicInfo localPicInfo = (PicInfo)paramView.getTag();
    if (localPicInfo == null) {
      return;
    }
    bhuf localbhuf = bhuf.a(this.jdField_a_of_type_Avnl.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity);
    if (this.jdField_a_of_type_Int != 0) {
      localbhuf.c(this.jdField_a_of_type_Avnl.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getString(2131694731));
    }
    localbhuf.c(alud.a(2131707655));
    if (this.jdField_a_of_type_Avnl.jdField_a_of_type_JavaUtilArrayList.size() > 1) {
      localbhuf.a(alud.a(2131707738), 3);
    }
    localbhuf.c(2131690648);
    localbhuf.a(new avok(this, paramView, localPicInfo, localbhuf));
    localbhuf.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avoj
 * JD-Core Version:    0.7.0.1
 */