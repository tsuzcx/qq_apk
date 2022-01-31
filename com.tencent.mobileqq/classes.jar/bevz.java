import android.text.TextUtils;
import com.tencent.qqmini.sdk.launcher.model.EntryModel;
import com.tencent.qqmini.sdk.launcher.model.FirstPageInfo;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import org.json.JSONObject;

public class bevz
{
  private static bevz jdField_a_of_type_Bevz;
  private bevt jdField_a_of_type_Bevt;
  private bewa jdField_a_of_type_Bewa;
  
  public static bevz a()
  {
    if (jdField_a_of_type_Bevz == null) {}
    try
    {
      if (jdField_a_of_type_Bevz == null) {
        jdField_a_of_type_Bevz = new bevz();
      }
      return jdField_a_of_type_Bevz;
    }
    finally {}
  }
  
  public int a()
  {
    MiniAppInfo localMiniAppInfo = beqy.a().a();
    if ((localMiniAppInfo != null) && (localMiniAppInfo.launchParam != null))
    {
      betc.b("GameInfoManager", "getScene = " + localMiniAppInfo.launchParam.jdField_a_of_type_Int);
      return localMiniAppInfo.launchParam.jdField_a_of_type_Int;
    }
    return 1001;
  }
  
  public bevt a()
  {
    return this.jdField_a_of_type_Bevt;
  }
  
  public bewa a()
  {
    if (this.jdField_a_of_type_Bewa == null) {
      return new bewa(this);
    }
    return this.jdField_a_of_type_Bewa;
  }
  
  public MiniAppInfo a()
  {
    return beqy.a().a();
  }
  
  public String a()
  {
    MiniAppInfo localMiniAppInfo = beqy.a().a();
    if (localMiniAppInfo != null) {
      return localMiniAppInfo.appId;
    }
    betc.d("GameInfoManager", "getAppId() error");
    return null;
  }
  
  public JSONObject a()
  {
    MiniAppInfo localMiniAppInfo = beqy.a().a();
    if ((localMiniAppInfo != null) && (localMiniAppInfo.firstPage != null))
    {
      betc.b("GameInfoManager", "getQueryPath = " + localMiniAppInfo.firstPage.jdField_a_of_type_JavaLangString);
      if ("miniGamePath".equals(localMiniAppInfo.firstPage.jdField_a_of_type_JavaLangString)) {
        return new JSONObject();
      }
      return bexo.a(localMiniAppInfo.firstPage.jdField_a_of_type_JavaLangString);
    }
    return new JSONObject();
  }
  
  public void a()
  {
    this.jdField_a_of_type_Bewa = new bewa(this);
    this.jdField_a_of_type_Bewa.jdField_a_of_type_Int = a();
    this.jdField_a_of_type_Bewa.jdField_a_of_type_OrgJsonJSONObject = a();
    this.jdField_a_of_type_Bewa.jdField_a_of_type_JavaLangString = e();
    this.jdField_a_of_type_Bewa.b = d();
    this.jdField_a_of_type_Bewa.c = b();
    this.jdField_a_of_type_Bewa.d = g();
  }
  
  public void a(bevt parambevt)
  {
    this.jdField_a_of_type_Bevt = parambevt;
  }
  
  public void a(MiniAppInfo paramMiniAppInfo)
  {
    if (this.jdField_a_of_type_Bevt != null) {
      a();
    }
  }
  
  public String b()
  {
    MiniAppInfo localMiniAppInfo = beqy.a().a();
    if ((localMiniAppInfo != null) && (localMiniAppInfo.launchParam != null))
    {
      betc.b("GameInfoManager", "getFromMiniAppId = " + localMiniAppInfo.launchParam.f);
      if (!TextUtils.isEmpty(localMiniAppInfo.launchParam.f)) {}
    }
    else
    {
      return null;
    }
    return localMiniAppInfo.launchParam.f;
  }
  
  public JSONObject b()
  {
    JSONObject localJSONObject = new JSONObject();
    Object localObject2 = a().a();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new JSONObject();
    }
    int i = a();
    String str2 = e();
    localObject2 = b();
    String str1 = d();
    String str3 = g();
    try
    {
      new JSONObject();
      localJSONObject.put("query", localObject1);
      localJSONObject.put("entryDataHash", str3);
    }
    catch (Exception localException2)
    {
      try
      {
        localJSONObject.put("scene", bela.a(i));
      }
      catch (Exception localException2)
      {
        try
        {
          for (;;)
          {
            localJSONObject.put("shareTicket", str2);
            try
            {
              localObject1 = new JSONObject();
              ((JSONObject)localObject1).put("appId", localObject2);
              ((JSONObject)localObject1).put("extraData", str1);
              localJSONObject.put("referrerInfo", localObject1);
              return localJSONObject;
            }
            catch (Exception localException4)
            {
              bexk.a().e("GameInfoManager", "onForeground exception put referrerInfo string :" + localException4);
            }
            localException1 = localException1;
            bexk.a().e("GameInfoManager", "onForeground exception put query string :" + localException1);
            continue;
            localException2 = localException2;
            bexk.a().e("GameInfoManager", "onForeground exception put scene string :" + localException2);
          }
        }
        catch (Exception localException3)
        {
          for (;;)
          {
            bexk.a().e("GameInfoManager", "onForeground exception put shareTicket string :" + localException3);
          }
        }
      }
    }
    return localJSONObject;
  }
  
  public String c()
  {
    MiniAppInfo localMiniAppInfo = beqy.a().a();
    if (localMiniAppInfo != null)
    {
      betc.b("GameInfoManager", "getAppId() = " + localMiniAppInfo.appId);
      return localMiniAppInfo.name;
    }
    betc.d("GameInfoManager", "getAppId() error");
    return null;
  }
  
  public String d()
  {
    MiniAppInfo localMiniAppInfo = beqy.a().a();
    if ((localMiniAppInfo != null) && (localMiniAppInfo.launchParam != null))
    {
      betc.b("GameInfoManager", "getNavigateExtData = " + localMiniAppInfo.launchParam.e);
      if (!TextUtils.isEmpty(localMiniAppInfo.launchParam.e)) {}
    }
    else
    {
      return null;
    }
    return localMiniAppInfo.launchParam.e;
  }
  
  public String e()
  {
    MiniAppInfo localMiniAppInfo = beqy.a().a();
    if ((localMiniAppInfo != null) && (localMiniAppInfo.launchParam != null))
    {
      betc.b("GameInfoManager", "getShareTicket = " + localMiniAppInfo.launchParam.h);
      if (!TextUtils.isEmpty(localMiniAppInfo.launchParam.h)) {}
    }
    else
    {
      return null;
    }
    return localMiniAppInfo.launchParam.h;
  }
  
  public String f()
  {
    MiniAppInfo localMiniAppInfo = beqy.a().a();
    if (localMiniAppInfo != null)
    {
      betc.b("GameInfoManager", "getExtendData = " + localMiniAppInfo.extendData);
      if (!TextUtils.isEmpty(localMiniAppInfo.extendData)) {}
    }
    else
    {
      return null;
    }
    return localMiniAppInfo.extendData;
  }
  
  public String g()
  {
    MiniAppInfo localMiniAppInfo = beqy.a().a();
    if ((localMiniAppInfo != null) && (localMiniAppInfo.launchParam.jdField_a_of_type_ComTencentQqminiSdkLauncherModelEntryModel != null)) {
      return localMiniAppInfo.launchParam.jdField_a_of_type_ComTencentQqminiSdkLauncherModelEntryModel.a();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bevz
 * JD-Core Version:    0.7.0.1
 */