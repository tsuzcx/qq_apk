import org.json.JSONException;
import org.json.JSONObject;

public class aqkx
{
  private boolean a;
  
  public static aqkx a(aptx[] paramArrayOfaptx)
  {
    boolean bool = true;
    if ((paramArrayOfaptx == null) || (paramArrayOfaptx.length <= 0))
    {
      paramArrayOfaptx = null;
      return paramArrayOfaptx;
    }
    aqkx localaqkx = new aqkx();
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(paramArrayOfaptx[0].a);
        paramArrayOfaptx = localaqkx;
        if (!localJSONObject.has("SendAsTxDoc")) {
          break;
        }
        if (localJSONObject.getJSONObject("SendAsTxDoc").getInt("enableSendAsTxDoc") == 1)
        {
          localaqkx.a = bool;
          return localaqkx;
        }
      }
      catch (JSONException paramArrayOfaptx)
      {
        paramArrayOfaptx.printStackTrace();
        return localaqkx;
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
 * Qualified Name:     aqkx
 * JD-Core Version:    0.7.0.1
 */