import android.support.annotation.NonNull;
import org.json.JSONException;
import org.json.JSONObject;

public class amzg
  extends amyp<amzf>
{
  public static amzf c()
  {
    return (amzf)ampl.a().a(412);
  }
  
  public int a()
  {
    return 412;
  }
  
  @NonNull
  public amzf a()
  {
    return new amzf();
  }
  
  @NonNull
  public amzf a(amph[] paramArrayOfamph)
  {
    boolean bool = true;
    localamzf = new amzf();
    try
    {
      if (new JSONObject(paramArrayOfamph[0].a).optInt("allow_edit_color_nick", 1) == 1) {}
      for (;;)
      {
        localamzf.a = bool;
        return localamzf;
        bool = false;
      }
      return localamzf;
    }
    catch (JSONException paramArrayOfamph)
    {
      ved.e("QVipColorNickProcessor", "QVipColorNickProcessor onParsed exception :" + paramArrayOfamph.getMessage());
    }
  }
  
  public Class<amzf> a()
  {
    return amzf.class;
  }
  
  @NonNull
  public amzf b()
  {
    return new amzf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amzg
 * JD-Core Version:    0.7.0.1
 */