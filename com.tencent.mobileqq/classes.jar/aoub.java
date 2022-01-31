import org.json.JSONException;
import org.json.JSONObject;

public class aoub
{
  private boolean a;
  
  public static aoub a(aogf[] paramArrayOfaogf)
  {
    boolean bool = true;
    if ((paramArrayOfaogf == null) || (paramArrayOfaogf.length <= 0))
    {
      paramArrayOfaogf = null;
      return paramArrayOfaogf;
    }
    aoub localaoub = new aoub();
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(paramArrayOfaogf[0].a);
        paramArrayOfaogf = localaoub;
        if (!localJSONObject.has("SendAsTxDoc")) {
          break;
        }
        if (localJSONObject.getJSONObject("SendAsTxDoc").getInt("enableSendAsTxDoc") == 1)
        {
          localaoub.a = bool;
          return localaoub;
        }
      }
      catch (JSONException paramArrayOfaogf)
      {
        paramArrayOfaogf.printStackTrace();
        return localaoub;
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
 * Qualified Name:     aoub
 * JD-Core Version:    0.7.0.1
 */