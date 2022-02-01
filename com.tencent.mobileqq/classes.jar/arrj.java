import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class arrj
{
  private String a = "";
  private String b = "";
  
  public static arrj a(araj[] paramArrayOfaraj)
  {
    if ((paramArrayOfaraj == null) || (paramArrayOfaraj.length <= 0)) {
      paramArrayOfaraj = null;
    }
    arrj localarrj;
    for (;;)
    {
      return paramArrayOfaraj;
      localarrj = new arrj();
      try
      {
        JSONObject localJSONObject = new JSONObject(paramArrayOfaraj[0].a);
        if (localJSONObject.has("AndroidDrawerJumpURL"))
        {
          localarrj.a = localJSONObject.getString("AndroidDrawerJumpURL");
          if (QLog.isColorLevel()) {
            QLog.d("TencentDocUserConfigBean", 2, "handleTencentDocUserConfigCmd AndroidDrawerJumpURL = " + localarrj.a);
          }
        }
        paramArrayOfaraj = localarrj;
        if (localJSONObject.has("AndroidAioJumpURL"))
        {
          localarrj.b = localJSONObject.getString("AndroidAioJumpURL");
          paramArrayOfaraj = localarrj;
          if (QLog.isColorLevel())
          {
            QLog.d("TencentDocUserConfigBean", 2, "handleTencentDocUserConfigCmd AndroidAioJumpURL = " + localarrj.b);
            return localarrj;
          }
        }
      }
      catch (JSONException paramArrayOfaraj)
      {
        paramArrayOfaraj.printStackTrace();
      }
    }
    return localarrj;
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
 * Qualified Name:     arrj
 * JD-Core Version:    0.7.0.1
 */