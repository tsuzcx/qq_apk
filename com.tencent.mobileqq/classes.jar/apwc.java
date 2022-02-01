import com.tencent.ark.ark.Application;
import com.tencent.ark.open.ArkAppMgr.AppPathInfo;
import com.tencent.ark.open.ArkAppMgr.IGetAppPathByNameCallbackTimeOut;
import com.tencent.mobileqq.ark.ArkAppCenter;

final class apwc
  implements ArkAppMgr.IGetAppPathByNameCallbackTimeOut
{
  apwc(String paramString1, String paramString2, apst paramapst) {}
  
  public void onGetAppPathByNameTimeout(int paramInt, String paramString, ArkAppMgr.AppPathInfo paramAppPathInfo, Object paramObject)
  {
    if ((paramInt == 0) && (paramAppPathInfo != null) && (paramAppPathInfo.path != null))
    {
      paramString = ark.Application.Create(this.jdField_a_of_type_JavaLangString, paramAppPathInfo.path);
      if (paramString != null)
      {
        boolean bool = paramString.CheckShareUrlLegality(this.b);
        paramString.Release();
        if (bool)
        {
          this.jdField_a_of_type_Apst.a(true);
          ArkAppCenter.c("ArkApp.ArkSecureUtil", String.format("CheckShareUrlLegality, url is in whileList, appName=%s and url=%s", new Object[] { this.jdField_a_of_type_JavaLangString, this.b }));
        }
      }
      else
      {
        return;
      }
      this.jdField_a_of_type_Apst.a(false);
      ArkAppCenter.c("ArkApp.ArkSecureUtil", String.format("CheckShareUrlLegality, url is not in whileList, appName=%s and url=%s", new Object[] { this.jdField_a_of_type_JavaLangString, this.b }));
      return;
    }
    this.jdField_a_of_type_Apst.a(false);
    apyp.a(apuh.a(), this.jdField_a_of_type_JavaLangString, "ArkCheckShareUrlLegality", paramInt, 0, 0L, 0L, 0L, "", "");
    ArkAppCenter.c("ArkApp.ArkSecureUtil", String.format("CheckShareUrlLegality,getAppInfo is failed and msg=%s", new Object[] { paramString }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apwc
 * JD-Core Version:    0.7.0.1
 */