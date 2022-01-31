import android.support.annotation.NonNull;
import org.json.JSONException;
import org.json.JSONObject;

public class amjo
  extends amie<amjn>
{
  public static final amjn a = new amjn();
  
  public static amjn c()
  {
    amjn localamjn2 = (amjn)alzw.a().a(423);
    amjn localamjn1 = localamjn2;
    if (localamjn2 == null) {
      localamjn1 = new amjn();
    }
    return localamjn1;
  }
  
  public int a()
  {
    return 423;
  }
  
  @NonNull
  public amjn a()
  {
    return a;
  }
  
  @NonNull
  public amjn a(alzs[] paramArrayOfalzs)
  {
    boolean bool = true;
    localamjn = new amjn();
    paramArrayOfalzs = paramArrayOfalzs[0].a;
    try
    {
      if (new JSONObject(paramArrayOfalzs).optInt("show_red_name_card", 0) == 1) {}
      for (;;)
      {
        localamjn.a = bool;
        return localamjn;
        bool = false;
      }
      return localamjn;
    }
    catch (JSONException paramArrayOfalzs)
    {
      urk.e("QVipRedNameCardProcessor", "QVipRedNameCardConfig onParsed exception :" + paramArrayOfalzs.getMessage());
    }
  }
  
  public Class<amjn> a()
  {
    return amjn.class;
  }
  
  @NonNull
  public amjn b()
  {
    return a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amjo
 * JD-Core Version:    0.7.0.1
 */