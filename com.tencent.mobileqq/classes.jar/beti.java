import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.widget.ProfileNameView;

public class beti
  implements View.OnClickListener
{
  public beti(ProfileNameView paramProfileNameView, awqt paramawqt) {}
  
  public void onClick(View paramView)
  {
    String str = bcos.a().a(this.jdField_a_of_type_Awqt.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Awqt.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
    Intent localIntent = new Intent(paramView.getContext(), QQBrowserActivity.class);
    localIntent.putExtra("url", str);
    paramView.getContext().startActivity(localIntent);
    azqs.b(null, "dc00898", "", "", "0X800A708", "0X800A708", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beti
 * JD-Core Version:    0.7.0.1
 */