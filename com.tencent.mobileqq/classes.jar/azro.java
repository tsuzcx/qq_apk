import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.profilesetting.InterestSwitchEditActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class azro
  implements azrf
{
  public azro(InterestSwitchEditActivity paramInterestSwitchEditActivity, azsj paramazsj, bkho parambkho) {}
  
  public void a(@NotNull View paramView, @Nullable azrd paramazrd)
  {
    if (bnyz.a(paramView)) {
      return;
    }
    if ((paramazrd == null) || (this.jdField_a_of_type_Azsj.g() == paramazrd.a())) {}
    for (;;)
    {
      this.jdField_a_of_type_Bkho.dismiss();
      return;
      InterestSwitchEditActivity.a(this.jdField_a_of_type_ComTencentMobileqqProfilesettingInterestSwitchEditActivity, paramazrd.a(), this.jdField_a_of_type_Azsj);
      if (!bgnt.d(BaseApplication.getContext()))
      {
        QQToast.a(BaseApplicationImpl.sApplication, 2131693946, 0).b(this.jdField_a_of_type_ComTencentMobileqqProfilesettingInterestSwitchEditActivity.getTitleBarHeight());
        return;
      }
      InterestSwitchEditActivity.a(this.jdField_a_of_type_ComTencentMobileqqProfilesettingInterestSwitchEditActivity, this.jdField_a_of_type_Azsj, paramazrd.a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azro
 * JD-Core Version:    0.7.0.1
 */