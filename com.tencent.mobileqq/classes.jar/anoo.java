import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkAppCenter;

public class anoo
{
  java.lang.ref.WeakReference<QQAppInterface> a;
  
  public anoo(QQAppInterface paramQQAppInterface)
  {
    this.a = new mqq.util.WeakReference(paramQQAppInterface);
  }
  
  public boolean a(String paramString, int paramInt1, int paramInt2, alpg paramalpg)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.a.get();
    if (localQQAppInterface == null)
    {
      ArkAppCenter.c("ArkApp.SSO", "requestArkAppList, app is null, return false");
      return false;
    }
    return ((anoh)localQQAppInterface.a(95)).a(paramString, paramInt1, paramInt2, paramalpg);
  }
  
  public boolean a(String paramString1, String paramString2, int paramInt1, int paramInt2, alpg paramalpg)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.a.get();
    if (localQQAppInterface == null)
    {
      ArkAppCenter.c("ArkApp.SSO", "sendAppMsg, app is null, return false");
      return false;
    }
    return ((anoh)localQQAppInterface.a(95)).a(paramString1, paramString2, paramInt1, paramInt2, paramalpg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anoo
 * JD-Core Version:    0.7.0.1
 */