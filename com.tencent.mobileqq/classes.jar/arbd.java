import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class arbd
  extends aqkz<arbc>
{
  @NonNull
  public arbc a(int paramInt)
  {
    return new arbc();
  }
  
  @Nullable
  public arbc a(aqlg[] paramArrayOfaqlg)
  {
    if ((paramArrayOfaqlg != null) && (paramArrayOfaqlg.length > 0)) {
      return arbc.a(paramArrayOfaqlg);
    }
    return null;
  }
  
  public void a(arbc paramarbc) {}
  
  public Class<arbc> clazz()
  {
    return arbc.class;
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
    return 440;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arbd
 * JD-Core Version:    0.7.0.1
 */