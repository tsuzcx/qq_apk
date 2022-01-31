import android.support.annotation.NonNull;
import org.json.JSONException;
import org.json.JSONObject;

public class aoqn
  extends aopw<aoqm>
{
  public static aoqm c()
  {
    return (aoqm)aogj.a().a(412);
  }
  
  public int a()
  {
    return 412;
  }
  
  @NonNull
  public aoqm a()
  {
    return new aoqm();
  }
  
  @NonNull
  public aoqm a(aogf[] paramArrayOfaogf)
  {
    boolean bool = true;
    localaoqm = new aoqm();
    try
    {
      if (new JSONObject(paramArrayOfaogf[0].a).optInt("allow_edit_color_nick", 1) == 1) {}
      for (;;)
      {
        localaoqm.a = bool;
        return localaoqm;
        bool = false;
      }
      return localaoqm;
    }
    catch (JSONException paramArrayOfaogf)
    {
      wsv.e("QVipColorNickProcessor", "QVipColorNickProcessor onParsed exception :" + paramArrayOfaogf.getMessage());
    }
  }
  
  public Class<aoqm> a()
  {
    return aoqm.class;
  }
  
  @NonNull
  public aoqm b()
  {
    return new aoqm();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aoqn
 * JD-Core Version:    0.7.0.1
 */