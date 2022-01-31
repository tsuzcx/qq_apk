import com.tencent.ark.open.ArkAppMgr.AppPathInfo;
import com.tencent.ark.open.ArkAppMgr.IGetAppPathByNameCallback;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

final class ayoa
  implements ArkAppMgr.IGetAppPathByNameCallback
{
  protected WeakReference<aynz> a;
  
  public ayoa(aynz paramaynz)
  {
    this.a = new WeakReference(paramaynz);
  }
  
  public void onGetAppPathByName(int paramInt, String paramString, ArkAppMgr.AppPathInfo paramAppPathInfo, Object paramObject)
  {
    aynz localaynz = (aynz)this.a.get();
    if (localaynz == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("ArkNodeContainer", 1, "onGetAppPathByName.wrapper == null");
      }
      return;
    }
    localaynz.onGetAppPathByName(paramInt, paramString, paramAppPathInfo, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayoa
 * JD-Core Version:    0.7.0.1
 */