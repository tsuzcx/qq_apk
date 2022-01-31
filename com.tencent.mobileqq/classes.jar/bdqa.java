import android.text.TextUtils;
import com.tencent.qqmini.sdk.launcher.model.EntryModel;
import com.tencent.qqmini.sdk.launcher.model.FirstPageInfo;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import org.json.JSONObject;

public class bdqa
{
  private static bdqa jdField_a_of_type_Bdqa;
  private bdpy jdField_a_of_type_Bdpy;
  private bdqb jdField_a_of_type_Bdqb;
  
  public static bdqa a()
  {
    if (jdField_a_of_type_Bdqa == null) {}
    try
    {
      if (jdField_a_of_type_Bdqa == null) {
        jdField_a_of_type_Bdqa = new bdqa();
      }
      return jdField_a_of_type_Bdqa;
    }
    finally {}
  }
  
  public int a()
  {
    MiniAppInfo localMiniAppInfo = bdlx.a().a();
    if ((localMiniAppInfo != null) && (localMiniAppInfo.launchParam != null))
    {
      bdnw.b("GameInfoManager", "getScene = " + localMiniAppInfo.launchParam.jdField_a_of_type_Int);
      return localMiniAppInfo.launchParam.jdField_a_of_type_Int;
    }
    return 1001;
  }
  
  public bdpy a()
  {
    return this.jdField_a_of_type_Bdpy;
  }
  
  public bdqb a()
  {
    if (this.jdField_a_of_type_Bdqb == null) {
      return new bdqb(this);
    }
    return this.jdField_a_of_type_Bdqb;
  }
  
  public MiniAppInfo a()
  {
    return bdlx.a().a();
  }
  
  public String a()
  {
    MiniAppInfo localMiniAppInfo = bdlx.a().a();
    if (localMiniAppInfo != null) {
      return localMiniAppInfo.appId;
    }
    bdnw.d("GameInfoManager", "getAppId() error");
    return null;
  }
  
  public JSONObject a()
  {
    MiniAppInfo localMiniAppInfo = bdlx.a().a();
    if ((localMiniAppInfo != null) && (localMiniAppInfo.firstPage != null))
    {
      bdnw.b("GameInfoManager", "getQueryPath = " + localMiniAppInfo.firstPage.a);
      if ("miniGamePath".equals(localMiniAppInfo.firstPage.a)) {
        return new JSONObject();
      }
      return bdrf.a(localMiniAppInfo.firstPage.a);
    }
    return new JSONObject();
  }
  
  public void a(bdpy parambdpy)
  {
    this.jdField_a_of_type_Bdpy = parambdpy;
  }
  
  public String b()
  {
    MiniAppInfo localMiniAppInfo = bdlx.a().a();
    if ((localMiniAppInfo != null) && (localMiniAppInfo.launchParam != null))
    {
      bdnw.b("GameInfoManager", "getFromMiniAppId = " + localMiniAppInfo.launchParam.f);
      if (!TextUtils.isEmpty(localMiniAppInfo.launchParam.f)) {}
    }
    else
    {
      return null;
    }
    return localMiniAppInfo.launchParam.f;
  }
  
  public String c()
  {
    MiniAppInfo localMiniAppInfo = bdlx.a().a();
    if (localMiniAppInfo != null)
    {
      bdnw.b("GameInfoManager", "getAppId() = " + localMiniAppInfo.appId);
      return localMiniAppInfo.name;
    }
    bdnw.d("GameInfoManager", "getAppId() error");
    return null;
  }
  
  public String d()
  {
    MiniAppInfo localMiniAppInfo = bdlx.a().a();
    if ((localMiniAppInfo != null) && (localMiniAppInfo.launchParam != null))
    {
      bdnw.b("GameInfoManager", "getNavigateExtData = " + localMiniAppInfo.launchParam.e);
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
    MiniAppInfo localMiniAppInfo = bdlx.a().a();
    if ((localMiniAppInfo != null) && (localMiniAppInfo.launchParam != null))
    {
      bdnw.b("GameInfoManager", "getShareTicket = " + localMiniAppInfo.launchParam.h);
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
    MiniAppInfo localMiniAppInfo = bdlx.a().a();
    if (localMiniAppInfo != null)
    {
      bdnw.b("GameInfoManager", "getExtendData = " + localMiniAppInfo.extendData);
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
    MiniAppInfo localMiniAppInfo = bdlx.a().a();
    if ((localMiniAppInfo != null) && (localMiniAppInfo.launchParam.jdField_a_of_type_ComTencentQqminiSdkLauncherModelEntryModel != null)) {
      return localMiniAppInfo.launchParam.jdField_a_of_type_ComTencentQqminiSdkLauncherModelEntryModel.a();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdqa
 * JD-Core Version:    0.7.0.1
 */