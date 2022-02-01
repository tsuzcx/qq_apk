import com.tencent.ark.open.ArkAppMgr.AppPathInfo;
import com.tencent.ark.open.ArkAppMgr.IGetAppPathByNameCallback;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

final class bcjz
  implements ArkAppMgr.IGetAppPathByNameCallback
{
  protected WeakReference<bcjy> a;
  
  public bcjz(bcjy parambcjy)
  {
    this.a = new WeakReference(parambcjy);
  }
  
  public void onGetAppPathByName(int paramInt, String paramString, ArkAppMgr.AppPathInfo paramAppPathInfo, Object paramObject)
  {
    bcjy localbcjy = (bcjy)this.a.get();
    if (localbcjy == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("ArkNodeContainer", 1, "onGetAppPathByName.wrapper == null");
      }
      return;
    }
    localbcjy.onGetAppPathByName(paramInt, paramString, paramAppPathInfo, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcjz
 * JD-Core Version:    0.7.0.1
 */