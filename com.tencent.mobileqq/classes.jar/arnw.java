import android.support.annotation.NonNull;
import org.json.JSONException;
import org.json.JSONObject;

public class arnw
  extends armf<arnv>
{
  public static arnv a = new arnv();
  
  public static arnv c()
  {
    arnv localarnv2 = (arnv)aran.a().a(423);
    arnv localarnv1 = localarnv2;
    if (localarnv2 == null) {
      localarnv1 = new arnv();
    }
    return localarnv1;
  }
  
  @NonNull
  public arnv a()
  {
    return a;
  }
  
  @NonNull
  public arnv a(araj[] paramArrayOfaraj)
  {
    boolean bool = true;
    localarnv = new arnv();
    paramArrayOfaraj = paramArrayOfaraj[0].a;
    try
    {
      if (new JSONObject(paramArrayOfaraj).optInt("show_red_name_card", 0) == 1) {}
      for (;;)
      {
        localarnv.a = bool;
        return localarnv;
        bool = false;
      }
      return localarnv;
    }
    catch (JSONException paramArrayOfaraj)
    {
      yuk.e("QVipRedNameCardProcessor", "QVipRedNameCardConfig onParsed exception :" + paramArrayOfaraj.getMessage());
    }
  }
  
  @NonNull
  public arnv b()
  {
    return a;
  }
  
  public Class<arnv> clazz()
  {
    return arnv.class;
  }
  
  public int type()
  {
    return 423;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arnw
 * JD-Core Version:    0.7.0.1
 */