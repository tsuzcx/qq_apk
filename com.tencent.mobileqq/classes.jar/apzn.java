import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class apzn
{
  private boolean a;
  
  public static apzn a(aptx[] paramArrayOfaptx)
  {
    apzn localapzn = new apzn();
    StringBuilder localStringBuilder = new StringBuilder();
    for (;;)
    {
      try
      {
        int j = paramArrayOfaptx.length;
        int i = 0;
        if (i < j)
        {
          String str = paramArrayOfaptx[i].a;
          QLog.d("SDK_SHARE.OpenSdkFakeMsgProcessor", 1, new Object[] { "content=", str });
          JSONObject localJSONObject = new JSONObject(str);
          if (localJSONObject.has("enable_fake_msg"))
          {
            if (localJSONObject.optInt("enable_fake_msg", 0) == 1)
            {
              bool = true;
              localapzn.a = bool;
            }
          }
          else
          {
            localStringBuilder.append("config: ").append(str).append(",");
            i += 1;
          }
        }
        else
        {
          QLog.d("SDK_SHARE.OpenSdkFakeMsgProcessor", 1, "parse, content:" + localStringBuilder.toString());
          return localapzn;
        }
      }
      catch (JSONException paramArrayOfaptx)
      {
        QLog.e("SDK_SHARE.OpenSdkFakeMsgProcessor", 1, "JSONException", paramArrayOfaptx);
        return null;
      }
      boolean bool = false;
    }
  }
  
  public boolean a()
  {
    return this.a;
  }
  
  public String toString()
  {
    new StringBuilder().append("isEnableFakeMsg:").append(this.a);
    return super.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     apzn
 * JD-Core Version:    0.7.0.1
 */