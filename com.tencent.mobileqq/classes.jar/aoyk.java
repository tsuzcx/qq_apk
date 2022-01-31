import org.json.JSONException;
import org.json.JSONObject;

public class aoyk
{
  private boolean a;
  
  public static aoyk a(aoko[] paramArrayOfaoko)
  {
    boolean bool = true;
    if ((paramArrayOfaoko == null) || (paramArrayOfaoko.length <= 0))
    {
      paramArrayOfaoko = null;
      return paramArrayOfaoko;
    }
    aoyk localaoyk = new aoyk();
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(paramArrayOfaoko[0].a);
        paramArrayOfaoko = localaoyk;
        if (!localJSONObject.has("SendAsTxDoc")) {
          break;
        }
        if (localJSONObject.getJSONObject("SendAsTxDoc").getInt("enableSendAsTxDoc") == 1)
        {
          localaoyk.a = bool;
          return localaoyk;
        }
      }
      catch (JSONException paramArrayOfaoko)
      {
        paramArrayOfaoko.printStackTrace();
        return localaoyk;
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
 * Qualified Name:     aoyk
 * JD-Core Version:    0.7.0.1
 */