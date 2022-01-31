import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.profile.view.ProfileHeaderView;
import com.tencent.qphone.base.util.BaseApplication;

public class awvi
  implements View.OnClickListener
{
  public awvi(ProfileHeaderView paramProfileHeaderView, View paramView) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.a.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.a.getCurrentAccountUin(), 0).edit().putBoolean("common_topic_friend_list_should_show", false).apply();
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awvi
 * JD-Core Version:    0.7.0.1
 */