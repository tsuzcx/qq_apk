import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;

class bgub
  extends anyu
{
  bgub(bgty parambgty) {}
  
  protected void onUpdateAddFriend(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString, Bundle paramBundle)
  {
    if (!this.a.b(paramString)) {}
    while (!paramBoolean1) {
      return;
    }
    bgty.a(this.a, paramString);
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
      bgty.a(this.a, paramObject);
    } while (!(this.a.a instanceof QQAppInterface));
    QQAppInterface localQQAppInterface = (QQAppInterface)this.a.a;
    ((anyw)this.a.a.getManager(51)).d(paramObject);
    bbcg.a(localQQAppInterface, paramObject);
    bejn.a(localQQAppInterface, paramObject);
    localQQAppInterface.a().a().a(paramObject, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgub
 * JD-Core Version:    0.7.0.1
 */