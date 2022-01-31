import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class ancz
{
  private String a = "";
  private String b = "";
  
  public static ancz a(ampi[] paramArrayOfampi)
  {
    if ((paramArrayOfampi == null) || (paramArrayOfampi.length <= 0)) {
      paramArrayOfampi = null;
    }
    ancz localancz;
    for (;;)
    {
      return paramArrayOfampi;
      localancz = new ancz();
      try
      {
        JSONObject localJSONObject = new JSONObject(paramArrayOfampi[0].a);
        if (localJSONObject.has("AndroidDrawerJumpURL"))
        {
          localancz.a = localJSONObject.getString("AndroidDrawerJumpURL");
          if (QLog.isColorLevel()) {
            QLog.d("TencentDocUserConfigBean", 2, "handleTencentDocUserConfigCmd AndroidDrawerJumpURL = " + localancz.a);
          }
        }
        paramArrayOfampi = localancz;
        if (localJSONObject.has("AndroidAioJumpURL"))
        {
          localancz.b = localJSONObject.getString("AndroidAioJumpURL");
          paramArrayOfampi = localancz;
          if (QLog.isColorLevel())
          {
            QLog.d("TencentDocUserConfigBean", 2, "handleTencentDocUserConfigCmd AndroidAioJumpURL = " + localancz.b);
            return localancz;
          }
        }
      }
      catch (JSONException paramArrayOfampi)
      {
        paramArrayOfampi.printStackTrace();
      }
    }
    return localancz;
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
 * Qualified Name:     ancz
 * JD-Core Version:    0.7.0.1
 */