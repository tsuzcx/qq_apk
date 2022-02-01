import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.proxy.ProxyManager;

class bglv
  extends anvi
{
  bglv(bgls parambgls) {}
  
  protected void onUpdateAddFriend(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString, Bundle paramBundle)
  {
    if (!this.a.b(paramString)) {}
    while (!paramBoolean1) {
      return;
    }
    bgls.a(this.a, paramString);
  }
  
  protected void onUpdateDelFriend(boolean paramBoolean, Object paramObject)
  {
    paramObject = "" + paramObject;
    if (!this.a.b(paramObject)) {}
    do
    {
      do
      {
        return;
      } while (!paramBoolean);
      bgls.a(this.a, paramObject);
    } while (!(this.a.a instanceof QQAppInterface));
    QQAppInterface localQQAppInterface = (QQAppInterface)this.a.a;
    ((anvk)this.a.a.getManager(QQManagerFactory.FRIENDS_MANAGER)).d(paramObject);
    bbdk.a(localQQAppInterface, paramObject);
    bejj.a(localQQAppInterface, paramObject);
    localQQAppInterface.getProxyManager().a().a(paramObject, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bglv
 * JD-Core Version:    0.7.0.1
 */