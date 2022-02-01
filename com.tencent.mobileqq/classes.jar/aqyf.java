import android.support.annotation.NonNull;
import org.json.JSONException;
import org.json.JSONObject;

public class aqyf
  extends aqwr<aqye>
{
  public static aqye a = new aqye();
  
  public static aqye c()
  {
    aqye localaqye2 = (aqye)aqlk.a().a(423);
    aqye localaqye1 = localaqye2;
    if (localaqye2 == null) {
      localaqye1 = new aqye();
    }
    return localaqye1;
  }
  
  @NonNull
  public aqye a()
  {
    return a;
  }
  
  @NonNull
  public aqye a(aqlg[] paramArrayOfaqlg)
  {
    boolean bool = true;
    localaqye = new aqye();
    paramArrayOfaqlg = paramArrayOfaqlg[0].a;
    try
    {
      if (new JSONObject(paramArrayOfaqlg).optInt("show_red_name_card", 0) == 1) {}
      for (;;)
      {
        localaqye.a = bool;
        return localaqye;
        bool = false;
      }
      return localaqye;
    }
    catch (JSONException paramArrayOfaqlg)
    {
      yqp.e("QVipRedNameCardProcessor", "QVipRedNameCardConfig onParsed exception :" + paramArrayOfaqlg.getMessage());
    }
  }
  
  @NonNull
  public aqye b()
  {
    return a;
  }
  
  public Class<aqye> clazz()
  {
    return aqye.class;
  }
  
  public int type()
  {
    return 423;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqyf
 * JD-Core Version:    0.7.0.1
 */