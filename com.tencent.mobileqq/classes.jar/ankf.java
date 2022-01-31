import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkAppCenter;

public class ankf
{
  java.lang.ref.WeakReference<QQAppInterface> a;
  
  public ankf(QQAppInterface paramQQAppInterface)
  {
    this.a = new mqq.util.WeakReference(paramQQAppInterface);
  }
  
  public boolean a(String paramString, int paramInt1, int paramInt2, alkr paramalkr)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.a.get();
    if (localQQAppInterface == null)
    {
      ArkAppCenter.c("ArkApp.SSO", "requestArkAppList, app is null, return false");
      return false;
    }
    return ((anjy)localQQAppInterface.a(95)).a(paramString, paramInt1, paramInt2, paramalkr);
  }
  
  public boolean a(String paramString1, String paramString2, int paramInt1, int paramInt2, alkr paramalkr)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.a.get();
    if (localQQAppInterface == null)
    {
      ArkAppCenter.c("ArkApp.SSO", "sendAppMsg, app is null, return false");
      return false;
    }
    return ((anjy)localQQAppInterface.a(95)).a(paramString1, paramString2, paramInt1, paramInt2, paramalkr);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ankf
 * JD-Core Version:    0.7.0.1
 */