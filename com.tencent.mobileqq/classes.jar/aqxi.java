import android.support.annotation.NonNull;
import org.json.JSONException;
import org.json.JSONObject;

public class aqxi
  extends aqwr<aqxh>
{
  public static aqxh c()
  {
    return (aqxh)aqlk.a().a(412);
  }
  
  @NonNull
  public aqxh a()
  {
    return new aqxh();
  }
  
  @NonNull
  public aqxh a(aqlg[] paramArrayOfaqlg)
  {
    boolean bool = true;
    localaqxh = new aqxh();
    try
    {
      if (new JSONObject(paramArrayOfaqlg[0].a).optInt("allow_edit_color_nick", 1) == 1) {}
      for (;;)
      {
        localaqxh.a = bool;
        return localaqxh;
        bool = false;
      }
      return localaqxh;
    }
    catch (JSONException paramArrayOfaqlg)
    {
      yqp.e("QVipColorNickProcessor", "QVipColorNickProcessor onParsed exception :" + paramArrayOfaqlg.getMessage());
    }
  }
  
  @NonNull
  public aqxh b()
  {
    return new aqxh();
  }
  
  public Class<aqxh> clazz()
  {
    return aqxh.class;
  }
  
  public int type()
  {
    return 412;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqxi
 * JD-Core Version:    0.7.0.1
 */