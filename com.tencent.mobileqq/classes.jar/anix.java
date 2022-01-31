import com.tencent.mobileqq.ark.ArkAppCenter;

class anix
  implements alkr
{
  anix(anit paramanit) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (!paramBoolean)
    {
      ArkAppCenter.c("ArkApp.ArkAppCGI", "ArkSafe,doReport, sso request failed");
      return;
    }
    ArkAppCenter.b("ArkApp.ArkAppCGI", "ArkSafe.doReport.server.back=" + paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anix
 * JD-Core Version:    0.7.0.1
 */