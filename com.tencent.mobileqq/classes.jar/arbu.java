import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class arbu
{
  private String a = "";
  private String b = "";
  
  public static arbu a(aqlg[] paramArrayOfaqlg)
  {
    if ((paramArrayOfaqlg == null) || (paramArrayOfaqlg.length <= 0)) {
      paramArrayOfaqlg = null;
    }
    arbu localarbu;
    for (;;)
    {
      return paramArrayOfaqlg;
      localarbu = new arbu();
      try
      {
        JSONObject localJSONObject = new JSONObject(paramArrayOfaqlg[0].a);
        if (localJSONObject.has("AndroidDrawerJumpURL"))
        {
          localarbu.a = localJSONObject.getString("AndroidDrawerJumpURL");
          if (QLog.isColorLevel()) {
            QLog.d("TencentDocUserConfigBean", 2, "handleTencentDocUserConfigCmd AndroidDrawerJumpURL = " + localarbu.a);
          }
        }
        paramArrayOfaqlg = localarbu;
        if (localJSONObject.has("AndroidAioJumpURL"))
        {
          localarbu.b = localJSONObject.getString("AndroidAioJumpURL");
          paramArrayOfaqlg = localarbu;
          if (QLog.isColorLevel())
          {
            QLog.d("TencentDocUserConfigBean", 2, "handleTencentDocUserConfigCmd AndroidAioJumpURL = " + localarbu.b);
            return localarbu;
          }
        }
      }
      catch (JSONException paramArrayOfaqlg)
      {
        paramArrayOfaqlg.printStackTrace();
      }
    }
    return localarbu;
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
 * Qualified Name:     arbu
 * JD-Core Version:    0.7.0.1
 */