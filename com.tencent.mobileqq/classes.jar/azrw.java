import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public abstract class azrw
  extends arac<azry>
{
  abstract int a();
  
  @NonNull
  public azry a(int paramInt)
  {
    return new azry();
  }
  
  @Nullable
  public azry a(araj[] paramArrayOfaraj)
  {
    azry localazry = new azry();
    if ((paramArrayOfaraj != null) && (paramArrayOfaraj.length > 0) && (paramArrayOfaraj[0] != null)) {
      azry.a(localazry, paramArrayOfaraj[0].a);
    }
    return localazry;
  }
  
  public void a(azry paramazry) {}
  
  public Class<azry> clazz()
  {
    return azry.class;
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
 * Qualified Name:     azrw
 * JD-Core Version:    0.7.0.1
 */