import com.tencent.ark.ark.Application;
import com.tencent.ark.open.ArkAppMgr.AppPathInfo;
import com.tencent.ark.open.ArkAppMgr.IGetAppPathByNameCallbackTimeOut;
import com.tencent.mobileqq.ark.ArkAppCenter;

final class anjz
  implements ArkAppMgr.IGetAppPathByNameCallbackTimeOut
{
  anjz(String paramString1, String paramString2, ankb paramankb) {}
  
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
          this.jdField_a_of_type_Ankb.a(true);
          ArkAppCenter.c("ArkApp", String.format("CheckShareUrlLegality, url is in whileList, appName=%s and url=%s", new Object[] { this.jdField_a_of_type_JavaLangString, this.b }));
        }
      }
      else
      {
        return;
      }
      this.jdField_a_of_type_Ankb.a(false);
      ArkAppCenter.c("ArkApp", String.format("CheckShareUrlLegality, url is not in whileList, appName=%s and url=%s", new Object[] { this.jdField_a_of_type_JavaLangString, this.b }));
      return;
    }
    this.jdField_a_of_type_Ankb.a(false);
    anoe.a(anjy.a(), this.jdField_a_of_type_JavaLangString, "ArkCheckShareUrlLegality", paramInt, 0, 0L, 0L, 0L, "", "");
    ArkAppCenter.c("ArkApp", String.format("CheckShareUrlLegality,getAppInfo is failed and msg=%s", new Object[] { paramString }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anjz
 * JD-Core Version:    0.7.0.1
 */