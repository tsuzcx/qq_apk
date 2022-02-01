import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class azsy
  extends arac<azsz>
{
  @NonNull
  public azsz a(int paramInt)
  {
    return new azsz();
  }
  
  @Nullable
  public azsz a(araj[] paramArrayOfaraj)
  {
    azsz localazsz = new azsz();
    if ((paramArrayOfaraj != null) && (paramArrayOfaraj.length > 0) && (paramArrayOfaraj[0] != null)) {
      azsz.a(localazsz, paramArrayOfaraj[0].a);
    }
    return localazsz;
  }
  
  public void a(azsz paramazsz) {}
  
  public Class<azsz> clazz()
  {
    return azsz.class;
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
    return 495;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azsy
 * JD-Core Version:    0.7.0.1
 */