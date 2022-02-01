import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

class aynr
  implements View.OnClickListener
{
  aynr(aynp paramaynp) {}
  
  public void onClick(View paramView)
  {
    int i = this.a.jdField_a_of_type_JavaUtilArrayList.size();
    NearbyPeopleProfileActivity localNearbyPeopleProfileActivity = this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity;
    if (i >= NearbyPeopleProfileActivity.c) {
      QQToast.a(this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 0, this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getString(2131693945), 0).a();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      aynp.c(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aynr
 * JD-Core Version:    0.7.0.1
 */