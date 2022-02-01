import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.ark.ArkAppCenter;

class apxu
  implements BusinessObserver
{
  apxu(apxp paramapxp) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (!paramBoolean)
    {
      ArkAppCenter.c("ArkApp.ArkAppCGI", "doVipReport(), sso request failed");
      return;
    }
    ArkAppCenter.b("ArkApp.ArkAppCGI", "doVipReport().server.back=" + paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apxu
 * JD-Core Version:    0.7.0.1
 */