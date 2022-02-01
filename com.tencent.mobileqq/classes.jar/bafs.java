import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.profilesetting.InterestSwitchEditActivity;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class bafs
  implements bafj
{
  public bafs(InterestSwitchEditActivity paramInterestSwitchEditActivity, bagn parambagn, bkzi parambkzi) {}
  
  public void a(@NotNull View paramView, @Nullable bafh parambafh)
  {
    if (bnrf.a(paramView)) {
      return;
    }
    if ((parambafh == null) || (this.jdField_a_of_type_Bagn.g() == parambafh.a())) {}
    for (;;)
    {
      this.jdField_a_of_type_Bkzi.dismiss();
      return;
      InterestSwitchEditActivity.a(this.jdField_a_of_type_ComTencentMobileqqProfilesettingInterestSwitchEditActivity, parambafh.a(), this.jdField_a_of_type_Bagn);
      if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
      {
        QQToast.a(BaseApplicationImpl.sApplication, 2131694253, 0).b(this.jdField_a_of_type_ComTencentMobileqqProfilesettingInterestSwitchEditActivity.getTitleBarHeight());
        return;
      }
      InterestSwitchEditActivity.a(this.jdField_a_of_type_ComTencentMobileqqProfilesettingInterestSwitchEditActivity, this.jdField_a_of_type_Bagn, parambafh.a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bafs
 * JD-Core Version:    0.7.0.1
 */