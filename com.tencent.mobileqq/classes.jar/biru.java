import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.widget.ProfileNameView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class biru
  implements View.OnClickListener
{
  public biru(ProfileNameView paramProfileNameView, azrb paramazrb) {}
  
  public void onClick(View paramView)
  {
    String str = bgld.a().a(this.jdField_a_of_type_Azrb.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
    Intent localIntent = new Intent(paramView.getContext(), QQBrowserActivity.class);
    localIntent.putExtra("url", str);
    paramView.getContext().startActivity(localIntent);
    bdla.b(null, "dc00898", "", "", "0X800A708", "0X800A708", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     biru
 * JD-Core Version:    0.7.0.1
 */