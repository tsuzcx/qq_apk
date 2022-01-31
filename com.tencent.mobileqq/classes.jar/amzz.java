import android.support.annotation.NonNull;
import org.json.JSONException;
import org.json.JSONObject;

public class amzz
  extends amyp<amzy>
{
  public static final amzy a = new amzy();
  
  public static amzy c()
  {
    amzy localamzy2 = (amzy)ampl.a().a(423);
    amzy localamzy1 = localamzy2;
    if (localamzy2 == null) {
      localamzy1 = new amzy();
    }
    return localamzy1;
  }
  
  public int a()
  {
    return 423;
  }
  
  @NonNull
  public amzy a()
  {
    return a;
  }
  
  @NonNull
  public amzy a(amph[] paramArrayOfamph)
  {
    boolean bool = true;
    localamzy = new amzy();
    paramArrayOfamph = paramArrayOfamph[0].a;
    try
    {
      if (new JSONObject(paramArrayOfamph).optInt("show_red_name_card", 0) == 1) {}
      for (;;)
      {
        localamzy.a = bool;
        return localamzy;
        bool = false;
      }
      return localamzy;
    }
    catch (JSONException paramArrayOfamph)
    {
      ved.e("QVipRedNameCardProcessor", "QVipRedNameCardConfig onParsed exception :" + paramArrayOfamph.getMessage());
    }
  }
  
  public Class<amzy> a()
  {
    return amzy.class;
  }
  
  @NonNull
  public amzy b()
  {
    return a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amzz
 * JD-Core Version:    0.7.0.1
 */