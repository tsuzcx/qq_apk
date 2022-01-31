import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class amft
{
  private long jdField_a_of_type_Long;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  public static amft a(alzs[] paramArrayOfalzs)
  {
    amft localamft = new amft();
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < paramArrayOfalzs.length)
        {
          String str = paramArrayOfalzs[i].a;
          JSONObject localJSONObject = new JSONObject(str);
          if (localJSONObject.has("enable_third_app_share_for_backend"))
          {
            if (localJSONObject.optInt("enable_third_app_share_for_backend", 0) == 1)
            {
              bool = true;
              localamft.jdField_a_of_type_Boolean = bool;
            }
          }
          else
          {
            if (localJSONObject.has("enable_third_app_share_big_image_by_server"))
            {
              if (localJSONObject.optInt("enable_third_app_share_big_image_by_server", 0) != 1) {
                break label207;
              }
              bool = true;
              localamft.b = bool;
            }
            if (localJSONObject.has("sdk_share_verify_appinfo_timeout_duration")) {
              localamft.jdField_a_of_type_Long = localJSONObject.optInt("sdk_share_verify_appinfo_timeout_duration", 0);
            }
            localStringBuilder.append("config: ").append(str).append(",");
            i += 1;
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("SDKShareConfProcessor", 2, "parse, content:" + localStringBuilder.toString());
          }
          return localamft;
        }
      }
      catch (JSONException paramArrayOfalzs)
      {
        QLog.d("SDKShareConfProcessor", 2, "parse, failed!");
        paramArrayOfalzs.printStackTrace();
        return null;
      }
      boolean bool = false;
      continue;
      label207:
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
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("serverShareEntryEnable:").append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append("serverShareImageEnable:").append(this.b);
    localStringBuilder.append("timeout_duration:").append(this.jdField_a_of_type_Long);
    return super.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amft
 * JD-Core Version:    0.7.0.1
 */