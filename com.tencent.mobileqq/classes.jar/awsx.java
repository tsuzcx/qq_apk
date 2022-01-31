import com.tencent.ark.open.ArkAppMgr.AppPathInfo;
import com.tencent.ark.open.ArkAppMgr.IGetAppPathByNameCallback;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

final class awsx
  implements ArkAppMgr.IGetAppPathByNameCallback
{
  protected WeakReference<awsw> a;
  
  public awsx(awsw paramawsw)
  {
    this.a = new WeakReference(paramawsw);
  }
  
  public void onGetAppPathByName(int paramInt, String paramString, ArkAppMgr.AppPathInfo paramAppPathInfo, Object paramObject)
  {
    awsw localawsw = (awsw)this.a.get();
    if (localawsw == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("ArkNodeContainer", 1, "onGetAppPathByName.wrapper == null");
      }
      return;
    }
    localawsw.onGetAppPathByName(paramInt, paramString, paramAppPathInfo, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awsx
 * JD-Core Version:    0.7.0.1
 */