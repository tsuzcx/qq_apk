import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class arfv
{
  private boolean a;
  
  public static arfv a(araj[] paramArrayOfaraj)
  {
    arfv localarfv = new arfv();
    StringBuilder localStringBuilder = new StringBuilder();
    for (;;)
    {
      try
      {
        int j = paramArrayOfaraj.length;
        int i = 0;
        if (i < j)
        {
          String str = paramArrayOfaraj[i].a;
          QLog.d("OpenSdkD55Processor", 1, new Object[] { "content=", str });
          JSONObject localJSONObject = new JSONObject(str);
          if (localJSONObject.has("enable_d55"))
          {
            if (localJSONObject.optInt("enable_d55", 0) == 1)
            {
              bool = true;
              localarfv.a = bool;
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
          return localarfv;
        }
      }
      catch (JSONException paramArrayOfaraj)
      {
        QLog.e("OpenSdkD55Processor", 1, "JSONException", paramArrayOfaraj);
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
 * Qualified Name:     arfv
 * JD-Core Version:    0.7.0.1
 */