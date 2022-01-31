import android.support.annotation.NonNull;
import org.json.JSONException;
import org.json.JSONObject;

public class amzs
  extends amyi<amzr>
{
  public static final amzr a = new amzr();
  
  public static amzr c()
  {
    amzr localamzr2 = (amzr)ampm.a().a(423);
    amzr localamzr1 = localamzr2;
    if (localamzr2 == null) {
      localamzr1 = new amzr();
    }
    return localamzr1;
  }
  
  public int a()
  {
    return 423;
  }
  
  @NonNull
  public amzr a()
  {
    return a;
  }
  
  @NonNull
  public amzr a(ampi[] paramArrayOfampi)
  {
    boolean bool = true;
    localamzr = new amzr();
    paramArrayOfampi = paramArrayOfampi[0].a;
    try
    {
      if (new JSONObject(paramArrayOfampi).optInt("show_red_name_card", 0) == 1) {}
      for (;;)
      {
        localamzr.a = bool;
        return localamzr;
        bool = false;
      }
      return localamzr;
    }
    catch (JSONException paramArrayOfampi)
    {
      veg.e("QVipRedNameCardProcessor", "QVipRedNameCardConfig onParsed exception :" + paramArrayOfampi.getMessage());
    }
  }
  
  public Class<amzr> a()
  {
    return amzr.class;
  }
  
  @NonNull
  public amzr b()
  {
    return a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amzs
 * JD-Core Version:    0.7.0.1
 */