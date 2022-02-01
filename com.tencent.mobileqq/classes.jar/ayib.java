import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.nearby.picbrowser.PicInfo;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

class ayib
  implements View.OnClickListener
{
  ayib(ayhd paramayhd, int paramInt) {}
  
  public void onClick(View paramView)
  {
    PicInfo localPicInfo = (PicInfo)paramView.getTag();
    if (localPicInfo == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      bkzi localbkzi = bkzi.a(this.jdField_a_of_type_Ayhd.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity);
      if (this.jdField_a_of_type_Int != 0) {
        localbkzi.c(this.jdField_a_of_type_Ayhd.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getString(2131694244));
      }
      localbkzi.c(anvx.a(2131706735));
      if (this.jdField_a_of_type_Ayhd.jdField_a_of_type_JavaUtilArrayList.size() > 1) {
        localbkzi.a(anvx.a(2131706818), 3);
      }
      localbkzi.c(2131690697);
      localbkzi.a(new ayic(this, paramView, localPicInfo, localbkzi));
      localbkzi.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayib
 * JD-Core Version:    0.7.0.1
 */