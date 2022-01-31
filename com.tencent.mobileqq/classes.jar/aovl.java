import android.support.annotation.NonNull;
import org.json.JSONException;
import org.json.JSONObject;

public class aovl
  extends aouf<aovk>
{
  public static aovk a()
  {
    return (aovk)aoks.a().a(413);
  }
  
  public int a()
  {
    return 413;
  }
  
  @NonNull
  public aovk a(@NonNull aoko[] paramArrayOfaoko)
  {
    aovk localaovk = new aovk();
    paramArrayOfaoko = paramArrayOfaoko[0].a;
    if (paramArrayOfaoko != null) {}
    try
    {
      if (!"".equals(paramArrayOfaoko))
      {
        paramArrayOfaoko = new JSONObject(paramArrayOfaoko);
        localaovk.a(paramArrayOfaoko.getString("url"));
        localaovk.a(paramArrayOfaoko.getBoolean("isEnable"));
        localaovk.b(paramArrayOfaoko.getBoolean("hideHotValue"));
      }
      return localaovk;
    }
    catch (JSONException paramArrayOfaoko)
    {
      paramArrayOfaoko.printStackTrace();
    }
    return localaovk;
  }
  
  public Class<aovk> a()
  {
    return aovk.class;
  }
  
  @NonNull
  public aovk b()
  {
    return new aovk();
  }
  
  @NonNull
  public aovk c()
  {
    return new aovk();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aovl
 * JD-Core Version:    0.7.0.1
 */