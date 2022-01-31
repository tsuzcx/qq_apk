import android.support.annotation.NonNull;
import org.json.JSONException;
import org.json.JSONObject;

public class aorc
  extends aopw<aorb>
{
  public static aorb a()
  {
    return (aorb)aogj.a().a(413);
  }
  
  public int a()
  {
    return 413;
  }
  
  @NonNull
  public aorb a(@NonNull aogf[] paramArrayOfaogf)
  {
    aorb localaorb = new aorb();
    paramArrayOfaogf = paramArrayOfaogf[0].a;
    if (paramArrayOfaogf != null) {}
    try
    {
      if (!"".equals(paramArrayOfaogf))
      {
        paramArrayOfaogf = new JSONObject(paramArrayOfaogf);
        localaorb.a(paramArrayOfaogf.getString("url"));
        localaorb.a(paramArrayOfaogf.getBoolean("isEnable"));
        localaorb.b(paramArrayOfaogf.getBoolean("hideHotValue"));
      }
      return localaorb;
    }
    catch (JSONException paramArrayOfaogf)
    {
      paramArrayOfaogf.printStackTrace();
    }
    return localaorb;
  }
  
  public Class<aorb> a()
  {
    return aorb.class;
  }
  
  @NonNull
  public aorb b()
  {
    return new aorb();
  }
  
  @NonNull
  public aorb c()
  {
    return new aorb();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aorc
 * JD-Core Version:    0.7.0.1
 */