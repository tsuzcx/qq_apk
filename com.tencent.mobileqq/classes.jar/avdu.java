import android.app.Dialog;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.DeleteFaceFragment;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.manager.TicketManager;

public class avdu
  implements View.OnClickListener
{
  public avdu(DeleteFaceFragment paramDeleteFaceFragment, FragmentActivity paramFragmentActivity) {}
  
  public void onClick(View paramView)
  {
    bdll.b(null, "dc00898", "", "", "0X800A320", "0X800A320", 0, 0, "", "", "", "");
    if ((DeleteFaceFragment.a(this.jdField_a_of_type_ComTencentMobileqqFragmentDeleteFaceFragment) != null) && (DeleteFaceFragment.a(this.jdField_a_of_type_ComTencentMobileqqFragmentDeleteFaceFragment).isShowing())) {
      DeleteFaceFragment.a(this.jdField_a_of_type_ComTencentMobileqqFragmentDeleteFaceFragment).dismiss();
    }
    if (!bhnv.d(this.jdField_a_of_type_ComTencentMobileqqFragmentDeleteFaceFragment.getActivity())) {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqFragmentDeleteFaceFragment.getActivity(), this.jdField_a_of_type_ComTencentMobileqqFragmentDeleteFaceFragment.getString(2131691989), 0).b(this.jdField_a_of_type_ComTencentMobileqqFragmentDeleteFaceFragment.a());
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("DeleteFaceFragment", 2, "user confirm delete");
      }
      if ((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity == null) || (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app == null))
      {
        QLog.d("DeleteFaceFragment", 1, "delete face, but activity is null or app is null");
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqFragmentDeleteFaceFragment.a();
        TicketManager localTicketManager = (TicketManager)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getManager(2);
        String str1 = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getAccount();
        String str2 = localTicketManager.getSkey(str1);
        if (TextUtils.isEmpty(str2))
        {
          QLog.d("DeleteFaceFragment", 1, "skey is null");
          localTicketManager.getSkey(str1, 16L, new avdv(this, str1));
        }
        else
        {
          DeleteFaceFragment.a(this.jdField_a_of_type_ComTencentMobileqqFragmentDeleteFaceFragment, str1, str2);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avdu
 * JD-Core Version:    0.7.0.1
 */