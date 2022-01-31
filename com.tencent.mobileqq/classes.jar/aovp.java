import android.support.annotation.NonNull;
import org.json.JSONException;
import org.json.JSONObject;

public class aovp
  extends aouf<aovo>
{
  public static final aovo a = new aovo();
  
  public static aovo c()
  {
    aovo localaovo2 = (aovo)aoks.a().a(423);
    aovo localaovo1 = localaovo2;
    if (localaovo2 == null) {
      localaovo1 = new aovo();
    }
    return localaovo1;
  }
  
  public int a()
  {
    return 423;
  }
  
  @NonNull
  public aovo a()
  {
    return a;
  }
  
  @NonNull
  public aovo a(aoko[] paramArrayOfaoko)
  {
    boolean bool = true;
    localaovo = new aovo();
    paramArrayOfaoko = paramArrayOfaoko[0].a;
    try
    {
      if (new JSONObject(paramArrayOfaoko).optInt("show_red_name_card", 0) == 1) {}
      for (;;)
      {
        localaovo.a = bool;
        return localaovo;
        bool = false;
      }
      return localaovo;
    }
    catch (JSONException paramArrayOfaoko)
    {
      wxe.e("QVipRedNameCardProcessor", "QVipRedNameCardConfig onParsed exception :" + paramArrayOfaoko.getMessage());
    }
  }
  
  public Class<aovo> a()
  {
    return aovo.class;
  }
  
  @NonNull
  public aovo b()
  {
    return a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aovp
 * JD-Core Version:    0.7.0.1
 */