import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class aqzu
  extends aqkz<aqzt>
{
  public static aqzt a()
  {
    return (aqzt)aqlk.a().a(486);
  }
  
  @NonNull
  public aqzt a(int paramInt)
  {
    return new aqzt();
  }
  
  @Nullable
  public aqzt a(aqlg[] paramArrayOfaqlg)
  {
    if ((paramArrayOfaqlg != null) && (paramArrayOfaqlg.length > 0)) {
      return aqzt.a(paramArrayOfaqlg);
    }
    return null;
  }
  
  public void a(aqzt paramaqzt) {}
  
  public Class<aqzt> clazz()
  {
    return aqzt.class;
  }
  
  public boolean isNeedCompressed()
  {
    return true;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return false;
  }
  
  public int migrateOldVersion()
  {
    return 0;
  }
  
  public void onReqFailed(int paramInt) {}
  
  public int type()
  {
    return 486;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqzu
 * JD-Core Version:    0.7.0.1
 */