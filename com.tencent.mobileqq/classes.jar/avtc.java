import com.tencent.ark.open.ArkAppMgr.AppPathInfo;
import com.tencent.ark.open.ArkAppMgr.IGetAppPathByNameCallback;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

final class avtc
  implements ArkAppMgr.IGetAppPathByNameCallback
{
  protected WeakReference<avtb> a;
  
  public avtc(avtb paramavtb)
  {
    this.a = new WeakReference(paramavtb);
  }
  
  public void onGetAppPathByName(int paramInt, String paramString, ArkAppMgr.AppPathInfo paramAppPathInfo, Object paramObject)
  {
    avtb localavtb = (avtb)this.a.get();
    if (localavtb == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("ArkNodeContainer", 1, "onGetAppPathByName.wrapper == null");
      }
      return;
    }
    localavtb.onGetAppPathByName(paramInt, paramString, paramAppPathInfo, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avtc
 * JD-Core Version:    0.7.0.1
 */