import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.open.agent.OpenAuthorityFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqconnect.wtlogin.OpenSDKAppInterface;
import cooperation.qqfav.util.HandlerPlus;

public class bdby
  implements bdcq
{
  public bdby(OpenAuthorityFragment paramOpenAuthorityFragment) {}
  
  public void a(long paramLong)
  {
    QLog.d("OpenAuthorityFragment", 1, new Object[] { "-->onDeleteVirtual vid=", Long.valueOf(paramLong) });
    if (!bbfj.g(BaseApplicationImpl.getApplication()))
    {
      this.a.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.removeCallbacks(this.a.jdField_a_of_type_JavaLangRunnable);
      this.a.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.post(this.a.jdField_a_of_type_JavaLangRunnable);
      return;
    }
    this.a.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a().a(OpenAuthorityFragment.a(this.a), paramLong, this.a.jdField_a_of_type_Bdom);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bdby
 * JD-Core Version:    0.7.0.1
 */