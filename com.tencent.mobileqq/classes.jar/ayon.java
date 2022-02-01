import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.nearby.picbrowser.PicInfo;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

class ayon
  implements View.OnClickListener
{
  ayon(aynp paramaynp, int paramInt) {}
  
  public void onClick(View paramView)
  {
    PicInfo localPicInfo = (PicInfo)paramView.getTag();
    if (localPicInfo == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      blir localblir = blir.a(this.jdField_a_of_type_Aynp.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity);
      if (this.jdField_a_of_type_Int != 0) {
        localblir.c(this.jdField_a_of_type_Aynp.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getString(2131693954));
      }
      localblir.c(anzj.a(2131706153));
      if (this.jdField_a_of_type_Aynp.jdField_a_of_type_JavaUtilArrayList.size() > 1) {
        localblir.a(anzj.a(2131706236), 3);
      }
      localblir.c(2131690580);
      localblir.a(new ayoo(this, paramView, localPicInfo, localblir));
      localblir.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayon
 * JD-Core Version:    0.7.0.1
 */