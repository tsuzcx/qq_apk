import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public abstract class ayzn
  extends aqkz<ayzs>
{
  protected abstract int a();
  
  @NonNull
  public ayzs a(int paramInt)
  {
    return new ayzs();
  }
  
  @Nullable
  public ayzs a(aqlg[] paramArrayOfaqlg)
  {
    ayzs localayzs = new ayzs();
    if ((paramArrayOfaqlg != null) && (paramArrayOfaqlg.length > 0) && (paramArrayOfaqlg[0] != null)) {
      ayzs.a(localayzs, paramArrayOfaqlg[0].a);
    }
    return localayzs;
  }
  
  public void a(ayzs paramayzs) {}
  
  public Class<ayzs> clazz()
  {
    return ayzs.class;
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
    return a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayzn
 * JD-Core Version:    0.7.0.1
 */