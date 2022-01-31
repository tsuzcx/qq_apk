import com.tencent.mobileqq.ark.ArkAppCenter;

class aniy
  implements alkr
{
  aniy(anit paramanit) {}
  
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
 * Qualified Name:     aniy
 * JD-Core Version:    0.7.0.1
 */