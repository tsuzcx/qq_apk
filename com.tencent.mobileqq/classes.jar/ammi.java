import org.json.JSONException;
import org.json.JSONObject;

public class ammi
{
  private boolean a;
  
  public static ammi a(alzs[] paramArrayOfalzs)
  {
    boolean bool = true;
    if ((paramArrayOfalzs == null) || (paramArrayOfalzs.length <= 0))
    {
      paramArrayOfalzs = null;
      return paramArrayOfalzs;
    }
    ammi localammi = new ammi();
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(paramArrayOfalzs[0].a);
        paramArrayOfalzs = localammi;
        if (!localJSONObject.has("SendAsTxDoc")) {
          break;
        }
        if (localJSONObject.getJSONObject("SendAsTxDoc").getInt("enableSendAsTxDoc") == 1)
        {
          localammi.a = bool;
          return localammi;
        }
      }
      catch (JSONException paramArrayOfalzs)
      {
        paramArrayOfalzs.printStackTrace();
        return localammi;
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
 * Qualified Name:     ammi
 * JD-Core Version:    0.7.0.1
 */