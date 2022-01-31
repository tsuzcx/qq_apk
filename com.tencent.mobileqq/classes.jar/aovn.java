import android.support.annotation.NonNull;
import org.json.JSONException;
import org.json.JSONObject;

public class aovn
  extends aouf<aovm>
{
  public static aovm a()
  {
    return (aovm)aoks.a().a(563);
  }
  
  public int a()
  {
    return 563;
  }
  
  @NonNull
  public aovm a(@NonNull aoko[] paramArrayOfaoko)
  {
    aovm localaovm = new aovm();
    paramArrayOfaoko = paramArrayOfaoko[0].a;
    if (paramArrayOfaoko != null) {}
    try
    {
      if (!"".equals(paramArrayOfaoko))
      {
        paramArrayOfaoko = new JSONObject(paramArrayOfaoko);
        localaovm.a = paramArrayOfaoko.getString("musicBoxUrl");
        localaovm.b = paramArrayOfaoko.getString("playerUrl");
      }
      return localaovm;
    }
    catch (JSONException paramArrayOfaoko)
    {
      paramArrayOfaoko.printStackTrace();
    }
    return localaovm;
  }
  
  public Class<aovm> a()
  {
    return aovm.class;
  }
  
  @NonNull
  public aovm b()
  {
    return new aovm();
  }
  
  @NonNull
  public aovm c()
  {
    return new aovm();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aovn
 * JD-Core Version:    0.7.0.1
 */