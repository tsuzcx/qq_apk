import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class aoyu
{
  private String a = "";
  private String b = "";
  
  public static aoyu a(aoko[] paramArrayOfaoko)
  {
    if ((paramArrayOfaoko == null) || (paramArrayOfaoko.length <= 0)) {
      paramArrayOfaoko = null;
    }
    aoyu localaoyu;
    for (;;)
    {
      return paramArrayOfaoko;
      localaoyu = new aoyu();
      try
      {
        JSONObject localJSONObject = new JSONObject(paramArrayOfaoko[0].a);
        if (localJSONObject.has("AndroidDrawerJumpURL"))
        {
          localaoyu.a = localJSONObject.getString("AndroidDrawerJumpURL");
          if (QLog.isColorLevel()) {
            QLog.d("TencentDocUserConfigBean", 2, "handleTencentDocUserConfigCmd AndroidDrawerJumpURL = " + localaoyu.a);
          }
        }
        paramArrayOfaoko = localaoyu;
        if (localJSONObject.has("AndroidAioJumpURL"))
        {
          localaoyu.b = localJSONObject.getString("AndroidAioJumpURL");
          paramArrayOfaoko = localaoyu;
          if (QLog.isColorLevel())
          {
            QLog.d("TencentDocUserConfigBean", 2, "handleTencentDocUserConfigCmd AndroidAioJumpURL = " + localaoyu.b);
            return localaoyu;
          }
        }
      }
      catch (JSONException paramArrayOfaoko)
      {
        paramArrayOfaoko.printStackTrace();
      }
    }
    return localaoyu;
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
 * Qualified Name:     aoyu
 * JD-Core Version:    0.7.0.1
 */