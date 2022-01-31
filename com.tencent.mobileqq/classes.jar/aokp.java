import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class aokp
{
  private long jdField_a_of_type_Long;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c;
  
  public static aokp a(aogf[] paramArrayOfaogf)
  {
    aokp localaokp = new aokp();
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    for (;;)
    {
      try
      {
        if (i >= paramArrayOfaogf.length) {
          break label221;
        }
        String str = paramArrayOfaogf[i].a;
        if (TextUtils.isEmpty(str))
        {
          QLog.d("OpenSdkConfProcessor", 1, "parse, content empty");
        }
        else
        {
          JSONObject localJSONObject = new JSONObject(str);
          if (localJSONObject.has("enable_third_app_share_for_backend"))
          {
            if (localJSONObject.optInt("enable_third_app_share_for_backend", 0) == 1)
            {
              bool = true;
              localaokp.jdField_a_of_type_Boolean = bool;
            }
          }
          else
          {
            if (localJSONObject.has("enable_third_app_share_big_image_by_server"))
            {
              if (localJSONObject.optInt("enable_third_app_share_big_image_by_server", 0) != 1) {
                break label211;
              }
              bool = true;
              localaokp.b = bool;
            }
            if (localJSONObject.has("sdk_share_verify_appinfo_timeout_duration")) {
              localaokp.jdField_a_of_type_Long = localJSONObject.optInt("sdk_share_verify_appinfo_timeout_duration", 0);
            }
            if (localJSONObject.has("sdk_login_use_third_transform_pkg_name"))
            {
              if (localJSONObject.optInt("sdk_login_use_third_transform_pkg_name", 0) != 1) {
                break label216;
              }
              bool = true;
              localaokp.c = bool;
            }
            localStringBuilder.append("config: ").append(str).append(",");
          }
        }
      }
      catch (Exception paramArrayOfaogf)
      {
        QLog.e("OpenSdkConfProcessor", 1, "parse, failed!", paramArrayOfaogf);
        return null;
      }
      boolean bool = false;
      continue;
      label211:
      bool = false;
      continue;
      label216:
      bool = false;
      continue;
      label221:
      QLog.d("OpenSdkConfProcessor", 1, "parse, content:" + localStringBuilder.toString());
      return localaokp;
      i += 1;
    }
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean b()
  {
    return this.b;
  }
  
  public boolean c()
  {
    return this.c;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("serverShareEntryEnable:").append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append("serverShareImageEnable:").append(this.b);
    localStringBuilder.append("timeout_duration:").append(this.jdField_a_of_type_Long);
    localStringBuilder.append("useThirdTransformPkgName:").append(this.c);
    return super.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aokp
 * JD-Core Version:    0.7.0.1
 */