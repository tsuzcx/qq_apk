import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;

class azkv
  extends ajjh
{
  azkv(azks paramazks) {}
  
  protected void onUpdateAddFriend(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString, Bundle paramBundle)
  {
    if (!this.a.b(paramString)) {}
    while (!paramBoolean1) {
      return;
    }
    azks.a(this.a, paramString);
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
      azks.a(this.a, paramObject);
    } while (!(this.a.a instanceof QQAppInterface));
    QQAppInterface localQQAppInterface = (QQAppInterface)this.a.a;
    ((ajjj)this.a.a.getManager(51)).d(paramObject);
    ajzm.a(localQQAppInterface, paramObject);
    localQQAppInterface.a().a().a(paramObject, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azkv
 * JD-Core Version:    0.7.0.1
 */