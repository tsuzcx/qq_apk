import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.guide.NearbyGuideActivity;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class axto
  implements View.OnClickListener
{
  public axto(NearbyGuideActivity paramNearbyGuideActivity) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.jdField_a_of_type_AndroidAppDialog != null) && (!this.a.isFinishing()))
    {
      this.a.jdField_a_of_type_AndroidAppDialog.dismiss();
      this.a.jdField_a_of_type_AndroidAppDialog = null;
      this.a.d(anvx.a(2131706654));
      if (this.a.jdField_a_of_type_Axqt == null) {
        this.a.jdField_a_of_type_Axqt = ((axqt)this.a.app.getBusinessHandler(BusinessHandlerFactory.NEARBY_CARD_HANDLER));
      }
      this.a.jdField_a_of_type_Axqt.a(NearbyPeopleProfileActivity.c, 5);
      this.a.e("0X8005909");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axto
 * JD-Core Version:    0.7.0.1
 */