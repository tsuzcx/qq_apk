import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class aoul
{
  private String a = "";
  private String b = "";
  
  public static aoul a(aogf[] paramArrayOfaogf)
  {
    if ((paramArrayOfaogf == null) || (paramArrayOfaogf.length <= 0)) {
      paramArrayOfaogf = null;
    }
    aoul localaoul;
    for (;;)
    {
      return paramArrayOfaogf;
      localaoul = new aoul();
      try
      {
        JSONObject localJSONObject = new JSONObject(paramArrayOfaogf[0].a);
        if (localJSONObject.has("AndroidDrawerJumpURL"))
        {
          localaoul.a = localJSONObject.getString("AndroidDrawerJumpURL");
          if (QLog.isColorLevel()) {
            QLog.d("TencentDocUserConfigBean", 2, "handleTencentDocUserConfigCmd AndroidDrawerJumpURL = " + localaoul.a);
          }
        }
        paramArrayOfaogf = localaoul;
        if (localJSONObject.has("AndroidAioJumpURL"))
        {
          localaoul.b = localJSONObject.getString("AndroidAioJumpURL");
          paramArrayOfaogf = localaoul;
          if (QLog.isColorLevel())
          {
            QLog.d("TencentDocUserConfigBean", 2, "handleTencentDocUserConfigCmd AndroidAioJumpURL = " + localaoul.b);
            return localaoul;
          }
        }
      }
      catch (JSONException paramArrayOfaogf)
      {
        paramArrayOfaogf.printStackTrace();
      }
    }
    return localaoul;
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
 * Qualified Name:     aoul
 * JD-Core Version:    0.7.0.1
 */