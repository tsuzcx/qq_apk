import android.support.annotation.NonNull;
import org.json.JSONException;
import org.json.JSONObject;

public class aorg
  extends aopw<aorf>
{
  public static final aorf a = new aorf();
  
  public static aorf c()
  {
    aorf localaorf2 = (aorf)aogj.a().a(423);
    aorf localaorf1 = localaorf2;
    if (localaorf2 == null) {
      localaorf1 = new aorf();
    }
    return localaorf1;
  }
  
  public int a()
  {
    return 423;
  }
  
  @NonNull
  public aorf a()
  {
    return a;
  }
  
  @NonNull
  public aorf a(aogf[] paramArrayOfaogf)
  {
    boolean bool = true;
    localaorf = new aorf();
    paramArrayOfaogf = paramArrayOfaogf[0].a;
    try
    {
      if (new JSONObject(paramArrayOfaogf).optInt("show_red_name_card", 0) == 1) {}
      for (;;)
      {
        localaorf.a = bool;
        return localaorf;
        bool = false;
      }
      return localaorf;
    }
    catch (JSONException paramArrayOfaogf)
    {
      wsv.e("QVipRedNameCardProcessor", "QVipRedNameCardConfig onParsed exception :" + paramArrayOfaogf.getMessage());
    }
  }
  
  public Class<aorf> a()
  {
    return aorf.class;
  }
  
  @NonNull
  public aorf b()
  {
    return a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aorg
 * JD-Core Version:    0.7.0.1
 */