import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import mqq.app.AppRuntime;

public class aotb
  extends aofy<aosy>
{
  public static aosy a()
  {
    return (aosy)aogj.a().a(383);
  }
  
  public int a()
  {
    return 383;
  }
  
  @NonNull
  public aosy a(int paramInt)
  {
    return new aosy();
  }
  
  @Nullable
  public aosy a(aogf[] paramArrayOfaogf)
  {
    if ((paramArrayOfaogf != null) && (paramArrayOfaogf.length > 0)) {
      return aosy.a(paramArrayOfaogf);
    }
    return null;
  }
  
  public Class<aosy> a()
  {
    return aosy.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(aosy paramaosy)
  {
    if ((paramaosy != null) && (!TextUtils.isEmpty(paramaosy.b()))) {
      ((baff)BaseApplicationImpl.getApplication().getRuntime().getManager(305)).a(paramaosy);
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
 * Qualified Name:     aotb
 * JD-Core Version:    0.7.0.1
 */