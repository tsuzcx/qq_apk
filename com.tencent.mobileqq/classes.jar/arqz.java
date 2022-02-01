import org.json.JSONException;
import org.json.JSONObject;

public class arqz
{
  private boolean a;
  
  public static arqz a(araj[] paramArrayOfaraj)
  {
    boolean bool = true;
    if ((paramArrayOfaraj == null) || (paramArrayOfaraj.length <= 0))
    {
      paramArrayOfaraj = null;
      return paramArrayOfaraj;
    }
    arqz localarqz = new arqz();
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(paramArrayOfaraj[0].a);
        paramArrayOfaraj = localarqz;
        if (!localJSONObject.has("SendAsTxDoc")) {
          break;
        }
        if (localJSONObject.getJSONObject("SendAsTxDoc").getInt("enableSendAsTxDoc") == 1)
        {
          localarqz.a = bool;
          return localarqz;
        }
      }
      catch (JSONException paramArrayOfaraj)
      {
        paramArrayOfaraj.printStackTrace();
        return localarqz;
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
 * Qualified Name:     arqz
 * JD-Core Version:    0.7.0.1
 */