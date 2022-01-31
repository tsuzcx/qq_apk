import org.json.JSONException;
import org.json.JSONObject;

public class aoso
{
  private String a = alpo.a(2131715219);
  private String b = "";
  
  public static aoso a(aogf[] paramArrayOfaogf)
  {
    if ((paramArrayOfaogf == null) || (paramArrayOfaogf.length <= 0)) {
      return null;
    }
    aoso localaoso = new aoso();
    try
    {
      paramArrayOfaogf = new JSONObject(paramArrayOfaogf[0].a);
      localaoso.a = paramArrayOfaogf.getString("emptyShowWording");
      localaoso.b = paramArrayOfaogf.getString("linkWord");
      return localaoso;
    }
    catch (JSONException paramArrayOfaogf)
    {
      paramArrayOfaogf.printStackTrace();
      return localaoso;
    }
    catch (NullPointerException paramArrayOfaogf)
    {
      paramArrayOfaogf.printStackTrace();
    }
    return localaoso;
  }
  
  public String a()
  {
    return this.a;
  }
  
  public String b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aoso
 * JD-Core Version:    0.7.0.1
 */