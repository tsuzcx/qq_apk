import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class aqlh
{
  private String a = "";
  private String b = "";
  
  public static aqlh a(aptx[] paramArrayOfaptx)
  {
    if ((paramArrayOfaptx == null) || (paramArrayOfaptx.length <= 0)) {
      paramArrayOfaptx = null;
    }
    aqlh localaqlh;
    for (;;)
    {
      return paramArrayOfaptx;
      localaqlh = new aqlh();
      try
      {
        JSONObject localJSONObject = new JSONObject(paramArrayOfaptx[0].a);
        if (localJSONObject.has("AndroidDrawerJumpURL"))
        {
          localaqlh.a = localJSONObject.getString("AndroidDrawerJumpURL");
          if (QLog.isColorLevel()) {
            QLog.d("TencentDocUserConfigBean", 2, "handleTencentDocUserConfigCmd AndroidDrawerJumpURL = " + localaqlh.a);
          }
        }
        paramArrayOfaptx = localaqlh;
        if (localJSONObject.has("AndroidAioJumpURL"))
        {
          localaqlh.b = localJSONObject.getString("AndroidAioJumpURL");
          paramArrayOfaptx = localaqlh;
          if (QLog.isColorLevel())
          {
            QLog.d("TencentDocUserConfigBean", 2, "handleTencentDocUserConfigCmd AndroidAioJumpURL = " + localaqlh.b);
            return localaqlh;
          }
        }
      }
      catch (JSONException paramArrayOfaptx)
      {
        paramArrayOfaptx.printStackTrace();
      }
    }
    return localaqlh;
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
 * Qualified Name:     aqlh
 * JD-Core Version:    0.7.0.1
 */