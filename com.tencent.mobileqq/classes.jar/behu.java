import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class behu
{
  private static MiniAppInfo a;
  public static List<String> a;
  
  static
  {
    jdField_a_of_type_JavaUtilList = new ArrayList(Arrays.asList(new String[] { "requestPayment", "updateHTMLWebView", "insertHTMLWebView", "removeHTMLWebView", "insertMap", "wnsRequest", "getQua", "openUrl", "notifyNative", "launchApplication", "getUserInfoExtra", "updateShareMenu", "showShareMenu", "hideShareMenu", "getShareInfo", "shareAppMessage" }));
  }
  
  public static MiniAppInfo a()
  {
    if (jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo == null)
      {
        MiniAppInfo localMiniAppInfo = new MiniAppInfo();
        localMiniAppInfo.appId = "0000000000";
        localMiniAppInfo.launchParam.a = "0000000000";
        jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo = localMiniAppInfo;
      }
      return jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     behu
 * JD-Core Version:    0.7.0.1
 */