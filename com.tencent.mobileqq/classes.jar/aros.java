import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class aros
{
  private String a = "";
  private String b = "";
  
  public static aros a(aqxa[] paramArrayOfaqxa)
  {
    if ((paramArrayOfaqxa == null) || (paramArrayOfaqxa.length <= 0)) {
      paramArrayOfaqxa = null;
    }
    aros localaros;
    for (;;)
    {
      return paramArrayOfaqxa;
      localaros = new aros();
      try
      {
        JSONObject localJSONObject = new JSONObject(paramArrayOfaqxa[0].a);
        if (localJSONObject.has("AndroidDrawerJumpURL"))
        {
          localaros.a = localJSONObject.getString("AndroidDrawerJumpURL");
          if (QLog.isColorLevel()) {
            QLog.d("TencentDocUserConfigBean", 2, "handleTencentDocUserConfigCmd AndroidDrawerJumpURL = " + localaros.a);
          }
        }
        paramArrayOfaqxa = localaros;
        if (localJSONObject.has("AndroidAioJumpURL"))
        {
          localaros.b = localJSONObject.getString("AndroidAioJumpURL");
          paramArrayOfaqxa = localaros;
          if (QLog.isColorLevel())
          {
            QLog.d("TencentDocUserConfigBean", 2, "handleTencentDocUserConfigCmd AndroidAioJumpURL = " + localaros.b);
            return localaros;
          }
        }
      }
      catch (JSONException paramArrayOfaqxa)
      {
        paramArrayOfaqxa.printStackTrace();
      }
    }
    return localaros;
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
 * Qualified Name:     aros
 * JD-Core Version:    0.7.0.1
 */