import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public abstract class azsa
  extends arac<azsf>
{
  protected abstract int a();
  
  @NonNull
  public azsf a(int paramInt)
  {
    return new azsf();
  }
  
  @Nullable
  public azsf a(araj[] paramArrayOfaraj)
  {
    azsf localazsf = new azsf();
    if ((paramArrayOfaraj != null) && (paramArrayOfaraj.length > 0) && (paramArrayOfaraj[0] != null)) {
      azsf.a(localazsf, paramArrayOfaraj[0].a);
    }
    return localazsf;
  }
  
  public void a(azsf paramazsf) {}
  
  public Class<azsf> clazz()
  {
    return azsf.class;
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
 * Qualified Name:     azsa
 * JD-Core Version:    0.7.0.1
 */