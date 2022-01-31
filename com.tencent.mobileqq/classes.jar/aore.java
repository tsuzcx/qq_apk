import android.support.annotation.NonNull;
import org.json.JSONException;
import org.json.JSONObject;

public class aore
  extends aopw<aord>
{
  public static aord a()
  {
    return (aord)aogj.a().a(563);
  }
  
  public int a()
  {
    return 563;
  }
  
  @NonNull
  public aord a(@NonNull aogf[] paramArrayOfaogf)
  {
    aord localaord = new aord();
    paramArrayOfaogf = paramArrayOfaogf[0].a;
    if (paramArrayOfaogf != null) {}
    try
    {
      if (!"".equals(paramArrayOfaogf))
      {
        paramArrayOfaogf = new JSONObject(paramArrayOfaogf);
        localaord.a = paramArrayOfaogf.getString("musicBoxUrl");
        localaord.b = paramArrayOfaogf.getString("playerUrl");
      }
      return localaord;
    }
    catch (JSONException paramArrayOfaogf)
    {
      paramArrayOfaogf.printStackTrace();
    }
    return localaord;
  }
  
  public Class<aord> a()
  {
    return aord.class;
  }
  
  @NonNull
  public aord b()
  {
    return new aord();
  }
  
  @NonNull
  public aord c()
  {
    return new aord();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aore
 * JD-Core Version:    0.7.0.1
 */