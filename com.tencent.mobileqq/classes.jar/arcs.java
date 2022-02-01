import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class arcs
{
  private boolean a = true;
  
  public static arcs a(aqxa[] paramArrayOfaqxa)
  {
    arcs localarcs = new arcs();
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
          if (localJSONObject.has("enableIframe"))
          {
            if (localJSONObject.optInt("enableIframe", 1) != 0)
            {
              bool = true;
              localarcs.a = bool;
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
          QLog.d("OpenSdkIFrameProcessor", 1, "parse, content:" + localStringBuilder.toString());
          return localarcs;
        }
      }
      catch (JSONException paramArrayOfaqxa)
      {
        QLog.e("OpenSdkIFrameProcessor", 1, "JSONException", paramArrayOfaqxa);
        return null;
      }
      boolean bool = false;
    }
  }
  
  public boolean a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arcs
 * JD-Core Version:    0.7.0.1
 */