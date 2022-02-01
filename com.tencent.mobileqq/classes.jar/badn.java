import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilecard.base.component.ProfileHeaderBaseComponent.1.1;
import com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView;
import com.tencent.mobileqq.profilecard.base.view.ProfileBaseView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

public class badn
  implements aero
{
  badn(badm parambadm) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    QQToast.a(BaseApplication.getContext(), paramInt2, paramInt1, 0).a();
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
    {
      ((azxr)badm.a(this.a)).a.updateCoverData(paramArrayOfByte);
      if ((this.a.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewAbsProfileHeaderView instanceof ProfileBaseView)) {
        this.a.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewAbsProfileHeaderView.a((azxr)badm.b(this.a), false);
      }
    }
  }
  
  public void b(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null) {
      if ((badm.c(this.a) != null) && (((azxr)badm.d(this.a)).a != null))
      {
        if (((azxr)badm.e(this.a)).a.checkCoverUrl(paramArrayOfByte)) {
          ((azxr)badm.f(this.a)).a.updateCoverData(paramArrayOfByte);
        }
        if ((this.a.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewAbsProfileHeaderView instanceof ProfileBaseView)) {
          ((ProfileBaseView)this.a.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewAbsProfileHeaderView).a((azxr)badm.g(this.a), false);
        }
        ThreadManager.excute(new ProfileHeaderBaseComponent.1.1(this), 32, null, false);
      }
    }
    for (;;)
    {
      bdll.b(badm.b(this.a), "dc00898", "", "", "0X8007EC2", "0X8007EC2", 0, 0, "", "", "", "");
      return;
      this.a.jdField_a_of_type_Badl.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     badn
 * JD-Core Version:    0.7.0.1
 */