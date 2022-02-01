import android.support.annotation.NonNull;
import org.json.JSONException;
import org.json.JSONObject;

public class aqgt
  extends aqgc<aqgs>
{
  public static aqgs c()
  {
    return (aqgs)apub.a().a(412);
  }
  
  @NonNull
  public aqgs a()
  {
    return new aqgs();
  }
  
  @NonNull
  public aqgs a(aptx[] paramArrayOfaptx)
  {
    boolean bool = true;
    localaqgs = new aqgs();
    try
    {
      if (new JSONObject(paramArrayOfaptx[0].a).optInt("allow_edit_color_nick", 1) == 1) {}
      for (;;)
      {
        localaqgs.a = bool;
        return localaqgs;
        bool = false;
      }
      return localaqgs;
    }
    catch (JSONException paramArrayOfaptx)
    {
      xvv.e("QVipColorNickProcessor", "QVipColorNickProcessor onParsed exception :" + paramArrayOfaptx.getMessage());
    }
  }
  
  @NonNull
  public aqgs b()
  {
    return new aqgs();
  }
  
  public Class<aqgs> clazz()
  {
    return aqgs.class;
  }
  
  public int type()
  {
    return 412;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqgt
 * JD-Core Version:    0.7.0.1
 */