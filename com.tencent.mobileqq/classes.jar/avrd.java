import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class avrd
  extends aqwt<avre>
{
  @NonNull
  public avre a(int paramInt)
  {
    return new avre();
  }
  
  @Nullable
  public avre a(aqxa[] paramArrayOfaqxa)
  {
    avre localavre = new avre();
    if ((paramArrayOfaqxa != null) && (paramArrayOfaqxa.length > 0) && (paramArrayOfaqxa[0] != null)) {
      avre.a(localavre, paramArrayOfaqxa[0].a);
    }
    return localavre;
  }
  
  public void a(avre paramavre) {}
  
  public Class<avre> clazz()
  {
    return avre.class;
  }
  
  public boolean isAccountRelated()
  {
    return false;
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
  
  public void onReqNoReceive() {}
  
  public int type()
  {
    return 445;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avrd
 * JD-Core Version:    0.7.0.1
 */