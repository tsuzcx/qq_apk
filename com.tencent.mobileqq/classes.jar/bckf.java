import com.tencent.ark.open.ArkAppMgr.AppPathInfo;
import com.tencent.ark.open.ArkAppMgr.IGetAppPathByNameCallback;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

final class bckf
  implements ArkAppMgr.IGetAppPathByNameCallback
{
  protected WeakReference<bcke> a;
  
  public bckf(bcke parambcke)
  {
    this.a = new WeakReference(parambcke);
  }
  
  public void onGetAppPathByName(int paramInt, String paramString, ArkAppMgr.AppPathInfo paramAppPathInfo, Object paramObject)
  {
    bcke localbcke = (bcke)this.a.get();
    if (localbcke == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("ArkNodeContainer", 1, "onGetAppPathByName.wrapper == null");
      }
      return;
    }
    localbcke.onGetAppPathByName(paramInt, paramString, paramAppPathInfo, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bckf
 * JD-Core Version:    0.7.0.1
 */