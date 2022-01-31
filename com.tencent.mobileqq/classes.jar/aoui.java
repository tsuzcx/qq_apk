import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import mqq.app.AppRuntime;

public class aoui
  extends aofy<aouf>
{
  public static aouf a()
  {
    return (aouf)aogj.a().a(346);
  }
  
  public int a()
  {
    return 346;
  }
  
  @NonNull
  public aouf a(int paramInt)
  {
    return new aouf();
  }
  
  @Nullable
  public aouf a(aogf[] paramArrayOfaogf)
  {
    if ((paramArrayOfaogf != null) && (paramArrayOfaogf.length > 0)) {
      return aouf.a(paramArrayOfaogf);
    }
    return null;
  }
  
  public Class<aouf> a()
  {
    return aouf.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(aouf paramaouf)
  {
    if ((paramaouf != null) && (!TextUtils.isEmpty(paramaouf.d()))) {
      ((baet)BaseApplicationImpl.getApplication().getRuntime().getManager(272)).a(paramaouf);
    }
  }
  
  public int b()
  {
    return 0;
  }
  
  public boolean b()
  {
    return false;
  }
  
  public boolean c()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aoui
 * JD-Core Version:    0.7.0.1
 */