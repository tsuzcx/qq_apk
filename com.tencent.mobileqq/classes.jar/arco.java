import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class arco
{
  private boolean a;
  
  public static arco a(aqxa[] paramArrayOfaqxa)
  {
    arco localarco = new arco();
    StringBuilder localStringBuilder = new StringBuilder();
    for (;;)
    {
      try
      {
        int j = paramArrayOfaqxa.length;
        int i = 0;
        if (i < j)
        {
          String str = paramArrayOfaqxa[i].a;
          QLog.d("OpenSdkD55Processor", 1, new Object[] { "content=", str });
          JSONObject localJSONObject = new JSONObject(str);
          if (localJSONObject.has("enable_d55"))
          {
            if (localJSONObject.optInt("enable_d55", 0) == 1)
            {
              bool = true;
              localarco.a = bool;
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
          QLog.d("OpenSdkD55Processor", 1, "parse, content:" + localStringBuilder.toString());
          return localarco;
        }
      }
      catch (JSONException paramArrayOfaqxa)
      {
        QLog.e("OpenSdkD55Processor", 1, "JSONException", paramArrayOfaqxa);
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
    new StringBuilder().append("isSwitchOpen:").append(this.a);
    return super.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arco
 * JD-Core Version:    0.7.0.1
 */