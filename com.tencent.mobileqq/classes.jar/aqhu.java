import android.support.annotation.NonNull;
import org.json.JSONException;
import org.json.JSONObject;

public class aqhu
  extends aqgc<aqht>
{
  public static aqht a = new aqht();
  
  public static aqht c()
  {
    aqht localaqht2 = (aqht)apub.a().a(423);
    aqht localaqht1 = localaqht2;
    if (localaqht2 == null) {
      localaqht1 = new aqht();
    }
    return localaqht1;
  }
  
  @NonNull
  public aqht a()
  {
    return a;
  }
  
  @NonNull
  public aqht a(aptx[] paramArrayOfaptx)
  {
    boolean bool = true;
    localaqht = new aqht();
    paramArrayOfaptx = paramArrayOfaptx[0].a;
    try
    {
      if (new JSONObject(paramArrayOfaptx).optInt("show_red_name_card", 0) == 1) {}
      for (;;)
      {
        localaqht.a = bool;
        return localaqht;
        bool = false;
      }
      return localaqht;
    }
    catch (JSONException paramArrayOfaptx)
    {
      xvv.e("QVipRedNameCardProcessor", "QVipRedNameCardConfig onParsed exception :" + paramArrayOfaptx.getMessage());
    }
  }
  
  @NonNull
  public aqht b()
  {
    return a;
  }
  
  public Class<aqht> clazz()
  {
    return aqht.class;
  }
  
  public int type()
  {
    return 423;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqhu
 * JD-Core Version:    0.7.0.1
 */