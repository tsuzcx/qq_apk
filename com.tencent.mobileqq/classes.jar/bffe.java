import com.tencent.open.agent.OpenAuthorityFragment;
import com.tencent.open.model.GetVirtualListResult;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqconnect.wtlogin.OpenSDKAppInterface;

public class bffe
  implements bfrt
{
  public bffe(OpenAuthorityFragment paramOpenAuthorityFragment) {}
  
  public void a()
  {
    boolean bool = true;
    GetVirtualListResult localGetVirtualListResult = this.a.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a().a(OpenAuthorityFragment.a(this.a));
    if (localGetVirtualListResult != null)
    {
      QLog.d("OpenAuthorityFragment", 1, "getVirtualList onSuccess null != virtualResult");
      bfrs localbfrs = this.a.jdField_a_of_type_Bfrs;
      if (localGetVirtualListResult.a == 0) {}
      for (;;)
      {
        localbfrs.a(bool, localGetVirtualListResult);
        return;
        bool = false;
      }
    }
    QLog.d("OpenAuthorityFragment", 1, "getVirtualList onSuccess null == virtualResult");
    this.a.jdField_a_of_type_Bfrs.a(false, null);
  }
  
  public void a(int paramInt, String paramString)
  {
    QLog.d("OpenAuthorityFragment", 1, new Object[] { "getVirtualList onFail errorCode=", Integer.valueOf(paramInt), ", msg=", paramString });
    this.a.jdField_a_of_type_Bfrs.a(false, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bffe
 * JD-Core Version:    0.7.0.1
 */