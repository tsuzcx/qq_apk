import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.guide.NearbyGuideActivity;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;

public class auvt
  implements View.OnClickListener
{
  public auvt(NearbyGuideActivity paramNearbyGuideActivity) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.jdField_a_of_type_AndroidAppDialog != null) && (!this.a.isFinishing()))
    {
      this.a.jdField_a_of_type_AndroidAppDialog.dismiss();
      this.a.jdField_a_of_type_AndroidAppDialog = null;
      this.a.d(alpo.a(2131707562));
      if (this.a.jdField_a_of_type_Ausy == null) {
        this.a.jdField_a_of_type_Ausy = ((ausy)this.a.app.a(60));
      }
      this.a.jdField_a_of_type_Ausy.a(NearbyPeopleProfileActivity.c, 5);
      this.a.e("0X8005909");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     auvt
 * JD-Core Version:    0.7.0.1
 */