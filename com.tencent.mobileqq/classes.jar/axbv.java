import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.nearby.picbrowser.PicInfo;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

class axbv
  implements View.OnClickListener
{
  axbv(axax paramaxax, int paramInt) {}
  
  public void onClick(View paramView)
  {
    PicInfo localPicInfo = (PicInfo)paramView.getTag();
    if (localPicInfo == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      bjnw localbjnw = bjnw.a(this.jdField_a_of_type_Axax.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity);
      if (this.jdField_a_of_type_Int != 0) {
        localbjnw.c(this.jdField_a_of_type_Axax.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getString(2131694053));
      }
      localbjnw.c(amtj.a(2131706383));
      if (this.jdField_a_of_type_Axax.jdField_a_of_type_JavaUtilArrayList.size() > 1) {
        localbjnw.a(amtj.a(2131706466), 3);
      }
      localbjnw.c(2131690620);
      localbjnw.a(new axbw(this, paramView, localPicInfo, localbjnw));
      localbjnw.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axbv
 * JD-Core Version:    0.7.0.1
 */