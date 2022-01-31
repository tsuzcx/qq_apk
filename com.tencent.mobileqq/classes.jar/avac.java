import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.guide.NearbyGuideActivity;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;

public class avac
  implements View.OnClickListener
{
  public avac(NearbyGuideActivity paramNearbyGuideActivity) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.jdField_a_of_type_AndroidAppDialog != null) && (!this.a.isFinishing()))
    {
      this.a.jdField_a_of_type_AndroidAppDialog.dismiss();
      this.a.jdField_a_of_type_AndroidAppDialog = null;
      this.a.d(alud.a(2131707574));
      if (this.a.jdField_a_of_type_Auxh == null) {
        this.a.jdField_a_of_type_Auxh = ((auxh)this.a.app.a(60));
      }
      this.a.jdField_a_of_type_Auxh.a(NearbyPeopleProfileActivity.c, 5);
      this.a.e("0X8005909");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avac
 * JD-Core Version:    0.7.0.1
 */