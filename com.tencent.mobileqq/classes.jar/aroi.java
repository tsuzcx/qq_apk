import org.json.JSONException;
import org.json.JSONObject;

public class aroi
{
  private boolean a;
  
  public static aroi a(aqxa[] paramArrayOfaqxa)
  {
    boolean bool = true;
    if ((paramArrayOfaqxa == null) || (paramArrayOfaqxa.length <= 0))
    {
      paramArrayOfaqxa = null;
      return paramArrayOfaqxa;
    }
    aroi localaroi = new aroi();
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(paramArrayOfaqxa[0].a);
        paramArrayOfaqxa = localaroi;
        if (!localJSONObject.has("SendAsTxDoc")) {
          break;
        }
        if (localJSONObject.getJSONObject("SendAsTxDoc").getInt("enableSendAsTxDoc") == 1)
        {
          localaroi.a = bool;
          return localaroi;
        }
      }
      catch (JSONException paramArrayOfaqxa)
      {
        paramArrayOfaqxa.printStackTrace();
        return localaroi;
      }
      bool = false;
    }
  }
  
  public boolean a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aroi
 * JD-Core Version:    0.7.0.1
 */