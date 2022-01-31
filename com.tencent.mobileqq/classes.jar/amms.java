import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class amms
{
  private String a = "";
  private String b = "";
  
  public static amms a(alzs[] paramArrayOfalzs)
  {
    if ((paramArrayOfalzs == null) || (paramArrayOfalzs.length <= 0)) {
      paramArrayOfalzs = null;
    }
    amms localamms;
    for (;;)
    {
      return paramArrayOfalzs;
      localamms = new amms();
      try
      {
        JSONObject localJSONObject = new JSONObject(paramArrayOfalzs[0].a);
        if (localJSONObject.has("AndroidDrawerJumpURL"))
        {
          localamms.a = localJSONObject.getString("AndroidDrawerJumpURL");
          if (QLog.isColorLevel()) {
            QLog.d("TencentDocUserConfigBean", 2, "handleTencentDocUserConfigCmd AndroidDrawerJumpURL = " + localamms.a);
          }
        }
        paramArrayOfalzs = localamms;
        if (localJSONObject.has("AndroidAioJumpURL"))
        {
          localamms.b = localJSONObject.getString("AndroidAioJumpURL");
          paramArrayOfalzs = localamms;
          if (QLog.isColorLevel())
          {
            QLog.d("TencentDocUserConfigBean", 2, "handleTencentDocUserConfigCmd AndroidAioJumpURL = " + localamms.b);
            return localamms;
          }
        }
      }
      catch (JSONException paramArrayOfalzs)
      {
        paramArrayOfalzs.printStackTrace();
      }
    }
    return localamms;
  }
  
  public String a()
  {
    if (TextUtils.isEmpty(this.a)) {
      return null;
    }
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amms
 * JD-Core Version:    0.7.0.1
 */