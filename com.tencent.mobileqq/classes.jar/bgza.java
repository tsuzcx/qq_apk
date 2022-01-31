import android.text.TextUtils;
import com.tencent.qqmini.sdk.launcher.model.EntryModel;
import com.tencent.qqmini.sdk.launcher.model.FirstPageInfo;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.log.QMLog;
import org.json.JSONObject;

public class bgza
{
  private bgyu jdField_a_of_type_Bgyu;
  private bgzb jdField_a_of_type_Bgzb;
  private MiniAppInfo jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo;
  
  public int a()
  {
    if ((this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo != null) && (this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.launchParam != null))
    {
      QMLog.i("GameInfoManager", "getScene = " + this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.launchParam.scene);
      return this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.launchParam.scene;
    }
    return 1001;
  }
  
  public bgyu a()
  {
    return this.jdField_a_of_type_Bgyu;
  }
  
  public bgzb a()
  {
    if (this.jdField_a_of_type_Bgzb == null) {
      return new bgzb(this);
    }
    return this.jdField_a_of_type_Bgzb;
  }
  
  public MiniAppInfo a()
  {
    return this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo;
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo != null) {
      return this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.appId;
    }
    QMLog.e("GameInfoManager", "getAppId() error");
    return null;
  }
  
  public JSONObject a()
  {
    if ((this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo != null) && (this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.firstPage != null))
    {
      QMLog.i("GameInfoManager", "getQueryPath = " + this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.firstPage.pagePath);
      if ("miniGamePath".equals(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.firstPage.pagePath)) {
        return new JSONObject();
      }
      return bhan.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.firstPage.pagePath);
    }
    return new JSONObject();
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo != null) && (this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.firstPage != null)) {
      this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.firstPage.setPagePath(null);
    }
  }
  
  public void a(bgyu parambgyu)
  {
    this.jdField_a_of_type_Bgyu = parambgyu;
  }
  
  public void a(MiniAppInfo paramMiniAppInfo)
  {
    this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo = paramMiniAppInfo;
    b();
  }
  
  public String b()
  {
    if ((this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo != null) && (this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.launchParam != null))
    {
      QMLog.i("GameInfoManager", "getFromMiniAppId = " + this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.launchParam.fromMiniAppId);
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.launchParam.fromMiniAppId)) {}
    }
    else
    {
      return null;
    }
    return this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.launchParam.fromMiniAppId;
  }
  
  public JSONObject b()
  {
    JSONObject localJSONObject = new JSONObject();
    Object localObject2 = a();
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
        localJSONObject.put("scene", bgos.a(i));
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
              bhaj.a().e("GameInfoManager", "onForeground exception put referrerInfo string :" + localException4);
            }
            localException1 = localException1;
            bhaj.a().e("GameInfoManager", "onForeground exception put query string :" + localException1);
            continue;
            localException2 = localException2;
            bhaj.a().e("GameInfoManager", "onForeground exception put scene string :" + localException2);
          }
        }
        catch (Exception localException3)
        {
          for (;;)
          {
            bhaj.a().e("GameInfoManager", "onForeground exception put shareTicket string :" + localException3);
          }
        }
      }
    }
    return localJSONObject;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Bgzb = new bgzb(this);
    this.jdField_a_of_type_Bgzb.jdField_a_of_type_Int = a();
    this.jdField_a_of_type_Bgzb.jdField_a_of_type_OrgJsonJSONObject = a();
    this.jdField_a_of_type_Bgzb.jdField_a_of_type_JavaLangString = e();
    this.jdField_a_of_type_Bgzb.b = d();
    this.jdField_a_of_type_Bgzb.c = b();
    this.jdField_a_of_type_Bgzb.d = g();
  }
  
  public String c()
  {
    if (this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo != null)
    {
      QMLog.i("GameInfoManager", "getAppId() = " + this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.appId);
      return this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.name;
    }
    QMLog.e("GameInfoManager", "getAppId() error");
    return null;
  }
  
  public String d()
  {
    if ((this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo != null) && (this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.launchParam != null))
    {
      QMLog.i("GameInfoManager", "getNavigateExtData = " + this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.launchParam.navigateExtData);
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.launchParam.navigateExtData)) {}
    }
    else
    {
      return null;
    }
    return this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.launchParam.navigateExtData;
  }
  
  public String e()
  {
    if ((this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo != null) && (this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.launchParam != null))
    {
      QMLog.i("GameInfoManager", "getShareTicket = " + this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.launchParam.shareTicket);
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.launchParam.shareTicket)) {}
    }
    else
    {
      return null;
    }
    return this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.launchParam.shareTicket;
  }
  
  public String f()
  {
    if (this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo != null)
    {
      QMLog.i("GameInfoManager", "getExtendData = " + this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.extendData);
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.extendData)) {}
    }
    else
    {
      return null;
    }
    return this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.extendData;
  }
  
  public String g()
  {
    if ((this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo != null) && (this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.launchParam.entryModel != null)) {
      return this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.launchParam.entryModel.getEntryHash();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgza
 * JD-Core Version:    0.7.0.1
 */