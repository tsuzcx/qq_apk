import org.json.JSONException;
import org.json.JSONObject;

public class arbk
{
  private boolean a;
  
  public static arbk a(aqlg[] paramArrayOfaqlg)
  {
    boolean bool = true;
    if ((paramArrayOfaqlg == null) || (paramArrayOfaqlg.length <= 0))
    {
      paramArrayOfaqlg = null;
      return paramArrayOfaqlg;
    }
    arbk localarbk = new arbk();
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(paramArrayOfaqlg[0].a);
        paramArrayOfaqlg = localarbk;
        if (!localJSONObject.has("SendAsTxDoc")) {
          break;
        }
        if (localJSONObject.getJSONObject("SendAsTxDoc").getInt("enableSendAsTxDoc") == 1)
        {
          localarbk.a = bool;
          return localarbk;
        }
      }
      catch (JSONException paramArrayOfaqlg)
      {
        paramArrayOfaqlg.printStackTrace();
        return localarbk;
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
 * Qualified Name:     arbk
 * JD-Core Version:    0.7.0.1
 */