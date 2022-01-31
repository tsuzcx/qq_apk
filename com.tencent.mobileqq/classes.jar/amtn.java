import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class amtn
{
  private long jdField_a_of_type_Long;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c;
  
  public static amtn a(amph[] paramArrayOfamph)
  {
    amtn localamtn = new amtn();
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < paramArrayOfamph.length)
        {
          String str = paramArrayOfamph[i].a;
          JSONObject localJSONObject = new JSONObject(str);
          if (localJSONObject.has("enable_third_app_share_for_backend"))
          {
            if (localJSONObject.optInt("enable_third_app_share_for_backend", 0) == 1)
            {
              bool = true;
              localamtn.jdField_a_of_type_Boolean = bool;
            }
          }
          else
          {
            if (localJSONObject.has("enable_third_app_share_big_image_by_server"))
            {
              if (localJSONObject.optInt("enable_third_app_share_big_image_by_server", 0) != 1) {
                break label236;
              }
              bool = true;
              localamtn.b = bool;
            }
            if (localJSONObject.has("sdk_share_verify_appinfo_timeout_duration")) {
              localamtn.jdField_a_of_type_Long = localJSONObject.optInt("sdk_share_verify_appinfo_timeout_duration", 0);
            }
            if (localJSONObject.has("sdk_login_use_third_transform_pkg_name"))
            {
              if (localJSONObject.optInt("sdk_login_use_third_transform_pkg_name", 0) != 1) {
                break label241;
              }
              bool = true;
              localamtn.c = bool;
            }
            localStringBuilder.append("config: ").append(str).append(",");
            i += 1;
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("OpenSdkConfProcessor", 2, "parse, content:" + localStringBuilder.toString());
          }
          return localamtn;
        }
      }
      catch (JSONException paramArrayOfamph)
      {
        QLog.d("OpenSdkConfProcessor", 2, "parse, failed!");
        paramArrayOfamph.printStackTrace();
        return null;
      }
      boolean bool = false;
      continue;
      label236:
      bool = false;
      continue;
      label241:
      bool = false;
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
 * Qualified Name:     amtn
 * JD-Core Version:    0.7.0.1
 */