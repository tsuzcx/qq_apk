import org.json.JSONException;
import org.json.JSONObject;

public class ancp
{
  private boolean a;
  
  public static ancp a(ampi[] paramArrayOfampi)
  {
    boolean bool = true;
    if ((paramArrayOfampi == null) || (paramArrayOfampi.length <= 0))
    {
      paramArrayOfampi = null;
      return paramArrayOfampi;
    }
    ancp localancp = new ancp();
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(paramArrayOfampi[0].a);
        paramArrayOfampi = localancp;
        if (!localJSONObject.has("SendAsTxDoc")) {
          break;
        }
        if (localJSONObject.getJSONObject("SendAsTxDoc").getInt("enableSendAsTxDoc") == 1)
        {
          localancp.a = bool;
          return localancp;
        }
      }
      catch (JSONException paramArrayOfampi)
      {
        paramArrayOfampi.printStackTrace();
        return localancp;
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
 * Qualified Name:     ancp
 * JD-Core Version:    0.7.0.1
 */