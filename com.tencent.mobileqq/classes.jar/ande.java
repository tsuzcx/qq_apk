import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class ande
{
  private String a = "";
  private String b = "";
  
  public static ande a(amph[] paramArrayOfamph)
  {
    if ((paramArrayOfamph == null) || (paramArrayOfamph.length <= 0)) {
      paramArrayOfamph = null;
    }
    ande localande;
    for (;;)
    {
      return paramArrayOfamph;
      localande = new ande();
      try
      {
        JSONObject localJSONObject = new JSONObject(paramArrayOfamph[0].a);
        if (localJSONObject.has("AndroidDrawerJumpURL"))
        {
          localande.a = localJSONObject.getString("AndroidDrawerJumpURL");
          if (QLog.isColorLevel()) {
            QLog.d("TencentDocUserConfigBean", 2, "handleTencentDocUserConfigCmd AndroidDrawerJumpURL = " + localande.a);
          }
        }
        paramArrayOfamph = localande;
        if (localJSONObject.has("AndroidAioJumpURL"))
        {
          localande.b = localJSONObject.getString("AndroidAioJumpURL");
          paramArrayOfamph = localande;
          if (QLog.isColorLevel())
          {
            QLog.d("TencentDocUserConfigBean", 2, "handleTencentDocUserConfigCmd AndroidAioJumpURL = " + localande.b);
            return localande;
          }
        }
      }
      catch (JSONException paramArrayOfamph)
      {
        paramArrayOfamph.printStackTrace();
      }
    }
    return localande;
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
 * Qualified Name:     ande
 * JD-Core Version:    0.7.0.1
 */