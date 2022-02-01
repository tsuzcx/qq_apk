import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.guide.NearbyGuideActivity;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class awnm
  implements View.OnClickListener
{
  public awnm(NearbyGuideActivity paramNearbyGuideActivity) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.jdField_a_of_type_AndroidAppDialog != null) && (!this.a.isFinishing()))
    {
      this.a.jdField_a_of_type_AndroidAppDialog.dismiss();
      this.a.jdField_a_of_type_AndroidAppDialog = null;
      this.a.d(amtj.a(2131706302));
      if (this.a.jdField_a_of_type_Awkr == null) {
        this.a.jdField_a_of_type_Awkr = ((awkr)this.a.app.getBusinessHandler(60));
      }
      this.a.jdField_a_of_type_Awkr.a(NearbyPeopleProfileActivity.c, 5);
      this.a.e("0X8005909");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awnm
 * JD-Core Version:    0.7.0.1
 */