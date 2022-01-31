import org.json.JSONException;
import org.json.JSONObject;

public class ancu
{
  private boolean a;
  
  public static ancu a(amph[] paramArrayOfamph)
  {
    boolean bool = true;
    if ((paramArrayOfamph == null) || (paramArrayOfamph.length <= 0))
    {
      paramArrayOfamph = null;
      return paramArrayOfamph;
    }
    ancu localancu = new ancu();
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(paramArrayOfamph[0].a);
        paramArrayOfamph = localancu;
        if (!localJSONObject.has("SendAsTxDoc")) {
          break;
        }
        if (localJSONObject.getJSONObject("SendAsTxDoc").getInt("enableSendAsTxDoc") == 1)
        {
          localancu.a = bool;
          return localancu;
        }
      }
      catch (JSONException paramArrayOfamph)
      {
        paramArrayOfamph.printStackTrace();
        return localancu;
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
 * Qualified Name:     ancu
 * JD-Core Version:    0.7.0.1
 */