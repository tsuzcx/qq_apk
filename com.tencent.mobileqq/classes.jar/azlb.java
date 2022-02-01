import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilecard.base.component.ProfileHeaderBaseComponent.1.1;
import com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView;
import com.tencent.mobileqq.profilecard.base.view.ProfileBaseView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

public class azlb
  implements aeil
{
  azlb(azla paramazla) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    QQToast.a(BaseApplication.getContext(), paramInt2, paramInt1, 0).a();
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
    {
      ((azfe)azla.a(this.a)).a.updateCoverData(paramArrayOfByte);
      if ((this.a.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewAbsProfileHeaderView instanceof ProfileBaseView)) {
        this.a.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewAbsProfileHeaderView.a((azfe)azla.b(this.a), false);
      }
    }
  }
  
  public void b(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null) {
      if ((azla.c(this.a) != null) && (((azfe)azla.d(this.a)).a != null))
      {
        if (((azfe)azla.e(this.a)).a.checkCoverUrl(paramArrayOfByte)) {
          ((azfe)azla.f(this.a)).a.updateCoverData(paramArrayOfByte);
        }
        if ((this.a.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewAbsProfileHeaderView instanceof ProfileBaseView)) {
          ((ProfileBaseView)this.a.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewAbsProfileHeaderView).a((azfe)azla.g(this.a), false);
        }
        ThreadManager.excute(new ProfileHeaderBaseComponent.1.1(this), 32, null, false);
      }
    }
    for (;;)
    {
      bcst.b(azla.b(this.a), "dc00898", "", "", "0X8007EC2", "0X8007EC2", 0, 0, "", "", "", "");
      return;
      this.a.jdField_a_of_type_Azkz.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azlb
 * JD-Core Version:    0.7.0.1
 */