import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilecard.base.component.ProfileHeaderBaseComponent.1.1;
import com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView;
import com.tencent.mobileqq.profilecard.base.view.ProfileBaseView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

public class aysc
  implements adkm
{
  aysc(aysb paramaysb) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    QQToast.a(BaseApplication.getContext(), paramInt2, paramInt1, 0).a();
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
    {
      ((aymg)aysb.a(this.a)).a.updateCoverData(paramArrayOfByte);
      if ((this.a.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewAbsProfileHeaderView instanceof ProfileBaseView)) {
        this.a.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewAbsProfileHeaderView.a((aymg)aysb.b(this.a), false);
      }
    }
  }
  
  public void b(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null) {
      if ((aysb.c(this.a) != null) && (((aymg)aysb.d(this.a)).a != null))
      {
        if (((aymg)aysb.e(this.a)).a.checkCoverUrl(paramArrayOfByte)) {
          ((aymg)aysb.f(this.a)).a.updateCoverData(paramArrayOfByte);
        }
        if ((this.a.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewAbsProfileHeaderView instanceof ProfileBaseView)) {
          ((ProfileBaseView)this.a.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewAbsProfileHeaderView).a((aymg)aysb.g(this.a), false);
        }
        ThreadManager.excute(new ProfileHeaderBaseComponent.1.1(this), 32, null, false);
      }
    }
    for (;;)
    {
      bcef.b(aysb.b(this.a), "dc00898", "", "", "0X8007EC2", "0X8007EC2", 0, 0, "", "", "", "");
      return;
      this.a.jdField_a_of_type_Aysa.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aysc
 * JD-Core Version:    0.7.0.1
 */