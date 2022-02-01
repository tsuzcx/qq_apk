import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.nearby.picbrowser.PicInfo;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

class axvt
  implements View.OnClickListener
{
  axvt(axuv paramaxuv, int paramInt) {}
  
  public void onClick(View paramView)
  {
    PicInfo localPicInfo = (PicInfo)paramView.getTag();
    if (localPicInfo == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      bkho localbkho = bkho.a(this.jdField_a_of_type_Axuv.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity);
      if (this.jdField_a_of_type_Int != 0) {
        localbkho.c(this.jdField_a_of_type_Axuv.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getString(2131693937));
      }
      localbkho.c(anni.a(2131706046));
      if (this.jdField_a_of_type_Axuv.jdField_a_of_type_JavaUtilArrayList.size() > 1) {
        localbkho.a(anni.a(2131706129), 3);
      }
      localbkho.c(2131690582);
      localbkho.a(new axvu(this, paramView, localPicInfo, localbkho));
      localbkho.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axvt
 * JD-Core Version:    0.7.0.1
 */