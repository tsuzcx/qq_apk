import android.text.TextUtils;
import com.tencent.qqmini.sdk.launcher.model.EntryModel;
import com.tencent.qqmini.sdk.launcher.model.FirstPageInfo;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import org.json.JSONObject;

public class bevi
{
  private static bevi jdField_a_of_type_Bevi;
  private bevc jdField_a_of_type_Bevc;
  private bevj jdField_a_of_type_Bevj;
  
  public static bevi a()
  {
    if (jdField_a_of_type_Bevi == null) {}
    try
    {
      if (jdField_a_of_type_Bevi == null) {
        jdField_a_of_type_Bevi = new bevi();
      }
      return jdField_a_of_type_Bevi;
    }
    finally {}
  }
  
  public int a()
  {
    MiniAppInfo localMiniAppInfo = beqh.a().a();
    if ((localMiniAppInfo != null) && (localMiniAppInfo.launchParam != null))
    {
      besl.b("GameInfoManager", "getScene = " + localMiniAppInfo.launchParam.jdField_a_of_type_Int);
      return localMiniAppInfo.launchParam.jdField_a_of_type_Int;
    }
    return 1001;
  }
  
  public bevc a()
  {
    return this.jdField_a_of_type_Bevc;
  }
  
  public bevj a()
  {
    if (this.jdField_a_of_type_Bevj == null) {
      return new bevj(this);
    }
    return this.jdField_a_of_type_Bevj;
  }
  
  public MiniAppInfo a()
  {
    return beqh.a().a();
  }
  
  public String a()
  {
    MiniAppInfo localMiniAppInfo = beqh.a().a();
    if (localMiniAppInfo != null) {
      return localMiniAppInfo.appId;
    }
    besl.d("GameInfoManager", "getAppId() error");
    return null;
  }
  
  public JSONObject a()
  {
    MiniAppInfo localMiniAppInfo = beqh.a().a();
    if ((localMiniAppInfo != null) && (localMiniAppInfo.firstPage != null))
    {
      besl.b("GameInfoManager", "getQueryPath = " + localMiniAppInfo.firstPage.jdField_a_of_type_JavaLangString);
      if ("miniGamePath".equals(localMiniAppInfo.firstPage.jdField_a_of_type_JavaLangString)) {
        return new JSONObject();
      }
      return bewx.a(localMiniAppInfo.firstPage.jdField_a_of_type_JavaLangString);
    }
    return new JSONObject();
  }
  
  public void a()
  {
    this.jdField_a_of_type_Bevj = new bevj(this);
    this.jdField_a_of_type_Bevj.jdField_a_of_type_Int = a();
    this.jdField_a_of_type_Bevj.jdField_a_of_type_OrgJsonJSONObject = a();
    this.jdField_a_of_type_Bevj.jdField_a_of_type_JavaLangString = e();
    this.jdField_a_of_type_Bevj.b = d();
    this.jdField_a_of_type_Bevj.c = b();
    this.jdField_a_of_type_Bevj.d = g();
  }
  
  public void a(bevc parambevc)
  {
    this.jdField_a_of_type_Bevc = parambevc;
  }
  
  public void a(MiniAppInfo paramMiniAppInfo)
  {
    if (this.jdField_a_of_type_Bevc != null) {
      a();
    }
  }
  
  public String b()
  {
    MiniAppInfo localMiniAppInfo = beqh.a().a();
    if ((localMiniAppInfo != null) && (localMiniAppInfo.launchParam != null))
    {
      besl.b("GameInfoManager", "getFromMiniAppId = " + localMiniAppInfo.launchParam.f);
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
        localJSONObject.put("scene", bekj.a(i));
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
              bewt.a().e("GameInfoManager", "onForeground exception put referrerInfo string :" + localException4);
            }
            localException1 = localException1;
            bewt.a().e("GameInfoManager", "onForeground exception put query string :" + localException1);
            continue;
            localException2 = localException2;
            bewt.a().e("GameInfoManager", "onForeground exception put scene string :" + localException2);
          }
        }
        catch (Exception localException3)
        {
          for (;;)
          {
            bewt.a().e("GameInfoManager", "onForeground exception put shareTicket string :" + localException3);
          }
        }
      }
    }
    return localJSONObject;
  }
  
  public String c()
  {
    MiniAppInfo localMiniAppInfo = beqh.a().a();
    if (localMiniAppInfo != null)
    {
      besl.b("GameInfoManager", "getAppId() = " + localMiniAppInfo.appId);
      return localMiniAppInfo.name;
    }
    besl.d("GameInfoManager", "getAppId() error");
    return null;
  }
  
  public String d()
  {
    MiniAppInfo localMiniAppInfo = beqh.a().a();
    if ((localMiniAppInfo != null) && (localMiniAppInfo.launchParam != null))
    {
      besl.b("GameInfoManager", "getNavigateExtData = " + localMiniAppInfo.launchParam.e);
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
    MiniAppInfo localMiniAppInfo = beqh.a().a();
    if ((localMiniAppInfo != null) && (localMiniAppInfo.launchParam != null))
    {
      besl.b("GameInfoManager", "getShareTicket = " + localMiniAppInfo.launchParam.h);
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
    MiniAppInfo localMiniAppInfo = beqh.a().a();
    if (localMiniAppInfo != null)
    {
      besl.b("GameInfoManager", "getExtendData = " + localMiniAppInfo.extendData);
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
    MiniAppInfo localMiniAppInfo = beqh.a().a();
    if ((localMiniAppInfo != null) && (localMiniAppInfo.launchParam.jdField_a_of_type_ComTencentQqminiSdkLauncherModelEntryModel != null)) {
      return localMiniAppInfo.launchParam.jdField_a_of_type_ComTencentQqminiSdkLauncherModelEntryModel.a();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bevi
 * JD-Core Version:    0.7.0.1
 */