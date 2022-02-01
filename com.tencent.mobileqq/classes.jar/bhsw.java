import com.tencent.open.agent.OpenAuthorityFragment;
import com.tencent.open.model.GetVirtualListResult;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqconnect.wtlogin.OpenSDKAppInterface;

public class bhsw
  implements bifh
{
  public bhsw(OpenAuthorityFragment paramOpenAuthorityFragment) {}
  
  public void a()
  {
    boolean bool = true;
    GetVirtualListResult localGetVirtualListResult = OpenAuthorityFragment.a(this.a).a().a(OpenAuthorityFragment.a(this.a));
    if (localGetVirtualListResult != null)
    {
      QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "getVirtualList onSuccess null != virtualResult");
      bhvf localbhvf = this.a.a;
      if (localGetVirtualListResult.a == 0) {}
      for (;;)
      {
        localbhvf.a(bool, localGetVirtualListResult);
        return;
        bool = false;
      }
    }
    QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "getVirtualList onSuccess null == virtualResult");
    this.a.a.a(false, null);
  }
  
  public void a(int paramInt, String paramString)
  {
    QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, new Object[] { "getVirtualList onFail errorCode=", Integer.valueOf(paramInt), ", msg=", paramString });
    if (OpenAuthorityFragment.a(this.a, paramInt, true))
    {
      QLog.e("SDK_LOGIN.OpenAuthorityFragment", 1, "getVirtualList handle110537");
      return;
    }
    if (OpenAuthorityFragment.a(this.a, paramInt, 2))
    {
      QLog.e("SDK_LOGIN.OpenAuthorityFragment", 1, "getVirtualList handle110509");
      return;
    }
    this.a.a.a(false, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhsw
 * JD-Core Version:    0.7.0.1
 */