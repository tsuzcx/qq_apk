import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public abstract class ayzj
  extends aqkz<ayzl>
{
  abstract int a();
  
  @NonNull
  public ayzl a(int paramInt)
  {
    return new ayzl();
  }
  
  @Nullable
  public ayzl a(aqlg[] paramArrayOfaqlg)
  {
    ayzl localayzl = new ayzl();
    if ((paramArrayOfaqlg != null) && (paramArrayOfaqlg.length > 0) && (paramArrayOfaqlg[0] != null)) {
      ayzl.a(localayzl, paramArrayOfaqlg[0].a);
    }
    return localayzl;
  }
  
  public void a(ayzl paramayzl) {}
  
  public Class<ayzl> clazz()
  {
    return ayzl.class;
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
 * Qualified Name:     ayzj
 * JD-Core Version:    0.7.0.1
 */