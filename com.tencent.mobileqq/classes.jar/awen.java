import android.os.Bundle;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.mp.mobileqq_mp.FollowResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.richstatus.StatusJsHandler;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.observer.BusinessObserver;

public class awen
  implements BusinessObserver
{
  public awen(StatusJsHandler paramStatusJsHandler) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    BaseActivity localBaseActivity = (BaseActivity)this.a.jdField_a_of_type_JavaLangRefWeakReference.get();
    if ((localBaseActivity == null) || (localBaseActivity.isFinishing())) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.richstatus.", 2, "success:" + String.valueOf(paramBoolean));
    }
    if (!paramBoolean)
    {
      this.a.a(2131695568);
      this.a.a(this.a.c, "false");
      return;
    }
    for (;;)
    {
      try
      {
        paramBundle = paramBundle.getByteArray("data");
        if (paramBundle == null) {
          break;
        }
        mobileqq_mp.FollowResponse localFollowResponse = new mobileqq_mp.FollowResponse();
        localFollowResponse.mergeFrom(paramBundle);
        if ((!localFollowResponse.ret_info.has()) || (!((mobileqq_mp.RetInfo)localFollowResponse.ret_info.get()).ret_code.has())) {
          break label321;
        }
        paramInt = ((mobileqq_mp.RetInfo)localFollowResponse.ret_info.get()).ret_code.get();
        if (paramInt == 0)
        {
          this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.followType = 1;
          this.a.a(localBaseActivity, this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail);
          ((PublicAccountHandler)localBaseActivity.app.a(11)).a(this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail);
          nnx.a().a(localBaseActivity.getApplicationContext(), localBaseActivity.app, this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin, null, true);
          this.a.a(this.a.c, "true");
          return;
        }
        if (paramInt == 58)
        {
          this.a.a(2131695565);
          break;
        }
        if (paramInt == 65)
        {
          this.a.a(2131695538);
          break;
        }
        this.a.a(2131695568);
      }
      catch (Exception paramBundle) {}
      break;
      label321:
      paramInt = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     awen
 * JD-Core Version:    0.7.0.1
 */