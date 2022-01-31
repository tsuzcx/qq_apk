import android.support.annotation.NonNull;
import org.json.JSONException;
import org.json.JSONObject;

public class amiv
  extends amie<amiu>
{
  public static amiu c()
  {
    return (amiu)alzw.a().a(412);
  }
  
  public int a()
  {
    return 412;
  }
  
  @NonNull
  public amiu a()
  {
    return new amiu();
  }
  
  @NonNull
  public amiu a(alzs[] paramArrayOfalzs)
  {
    boolean bool = true;
    localamiu = new amiu();
    try
    {
      if (new JSONObject(paramArrayOfalzs[0].a).optInt("allow_edit_color_nick", 1) == 1) {}
      for (;;)
      {
        localamiu.a = bool;
        return localamiu;
        bool = false;
      }
      return localamiu;
    }
    catch (JSONException paramArrayOfalzs)
    {
      urk.e("QVipColorNickProcessor", "QVipColorNickProcessor onParsed exception :" + paramArrayOfalzs.getMessage());
    }
  }
  
  public Class<amiu> a()
  {
    return amiu.class;
  }
  
  @NonNull
  public amiu b()
  {
    return new amiu();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amiv
 * JD-Core Version:    0.7.0.1
 */