import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.profilesetting.InterestSwitchEditActivity;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class azae
  implements ayzv
{
  public azae(InterestSwitchEditActivity paramInterestSwitchEditActivity, azaz paramazaz, bjnw parambjnw) {}
  
  public void a(@NotNull View paramView, @Nullable ayzt paramayzt)
  {
    if (bmbv.a(paramView)) {
      return;
    }
    if ((paramayzt == null) || (this.jdField_a_of_type_Azaz.g() == paramayzt.a())) {}
    for (;;)
    {
      this.jdField_a_of_type_Bjnw.dismiss();
      return;
      InterestSwitchEditActivity.a(this.jdField_a_of_type_ComTencentMobileqqProfilesettingInterestSwitchEditActivity, paramayzt.a(), this.jdField_a_of_type_Azaz);
      if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
      {
        QQToast.a(BaseApplicationImpl.sApplication, 2131694062, 0).b(this.jdField_a_of_type_ComTencentMobileqqProfilesettingInterestSwitchEditActivity.getTitleBarHeight());
        return;
      }
      InterestSwitchEditActivity.a(this.jdField_a_of_type_ComTencentMobileqqProfilesettingInterestSwitchEditActivity, this.jdField_a_of_type_Azaz, paramayzt.a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azae
 * JD-Core Version:    0.7.0.1
 */