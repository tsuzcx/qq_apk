import com.tencent.qphone.base.util.QLog;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitConfigHelper;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.YtSDKKitFrameworkWorkMode;
import org.json.JSONException;
import org.json.JSONObject;

public class astp
{
  private static astp jdField_a_of_type_Astp;
  private static final String jdField_a_of_type_JavaLangString = astp.class.getSimpleName();
  private JSONObject jdField_a_of_type_OrgJsonJSONObject;
  private JSONObject b;
  
  public static astp a()
  {
    try
    {
      if (jdField_a_of_type_Astp == null) {
        jdField_a_of_type_Astp = new astp();
      }
      astp localastp = jdField_a_of_type_Astp;
      return localastp;
    }
    finally {}
  }
  
  private YtSDKKitFramework.YtSDKKitFrameworkWorkMode a(int paramInt)
  {
    YtSDKKitFramework.YtSDKKitFrameworkWorkMode localYtSDKKitFrameworkWorkMode = YtSDKKitFramework.YtSDKKitFrameworkWorkMode.YT_FW_UNKNOWN;
    switch (paramInt)
    {
    default: 
      return localYtSDKKitFrameworkWorkMode;
    case 0: 
      return YtSDKKitFramework.YtSDKKitFrameworkWorkMode.YT_FW_UNKNOWN;
    case 1: 
      return YtSDKKitFramework.YtSDKKitFrameworkWorkMode.YT_FW_OCR_TYPE;
    case 2: 
      return YtSDKKitFramework.YtSDKKitFrameworkWorkMode.YT_FW_SILENT_TYPE;
    case 3: 
      return YtSDKKitFramework.YtSDKKitFrameworkWorkMode.YT_FW_ACTION_TYPE;
    case 4: 
      return YtSDKKitFramework.YtSDKKitFrameworkWorkMode.YT_FW_REFLECT_TYPE;
    }
    return YtSDKKitFramework.YtSDKKitFrameworkWorkMode.YT_FW_ACTREFLECT_TYPE;
  }
  
  public int a(String paramString1, String paramString2)
  {
    try
    {
      this.jdField_a_of_type_OrgJsonJSONObject = new JSONObject(paramString1).getJSONObject("sdk_settings");
      this.b = new JSONObject(paramString2).getJSONObject("ui_basic_config");
      return 0;
    }
    catch (JSONException paramString1)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "initWithConfig error " + paramString1.getMessage());
    }
    return -1;
  }
  
  public JSONObject a(int paramInt)
  {
    return YtSDKKitConfigHelper.getSDKConfig(a(paramInt), this.jdField_a_of_type_OrgJsonJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     astp
 * JD-Core Version:    0.7.0.1
 */