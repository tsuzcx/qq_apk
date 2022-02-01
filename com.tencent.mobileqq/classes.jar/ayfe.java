import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public abstract class ayfe
  extends aptq<ayfg>
{
  abstract int a();
  
  @NonNull
  public ayfg a(int paramInt)
  {
    return new ayfg();
  }
  
  @Nullable
  public ayfg a(aptx[] paramArrayOfaptx)
  {
    ayfg localayfg = new ayfg();
    if ((paramArrayOfaptx != null) && (paramArrayOfaptx.length > 0) && (paramArrayOfaptx[0] != null)) {
      ayfg.a(localayfg, paramArrayOfaptx[0].a);
    }
    return localayfg;
  }
  
  public void a(ayfg paramayfg) {}
  
  public Class<ayfg> clazz()
  {
    return ayfg.class;
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
 * Qualified Name:     ayfe
 * JD-Core Version:    0.7.0.1
 */