import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.open.agent.OpenAuthorityFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqconnect.wtlogin.OpenSDKAppInterface;
import cooperation.qqfav.util.HandlerPlus;

public class bjdu
  implements bjel
{
  public bjdu(OpenAuthorityFragment paramOpenAuthorityFragment) {}
  
  public void a(long paramLong)
  {
    QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, new Object[] { "-->onDeleteVirtual vid=", Long.valueOf(paramLong) });
    if (!NetworkUtil.isNetworkAvailable(BaseApplicationImpl.getApplication()))
    {
      this.a.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.removeCallbacks(this.a.jdField_a_of_type_JavaLangRunnable);
      this.a.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.post(this.a.jdField_a_of_type_JavaLangRunnable);
      return;
    }
    OpenAuthorityFragment.a(this.a).a().a(OpenAuthorityFragment.a(this.a), paramLong, this.a.jdField_a_of_type_Bjgg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjdu
 * JD-Core Version:    0.7.0.1
 */