import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class apdj
  extends aptq<apdk>
{
  @NonNull
  public apdk a(int paramInt)
  {
    return new apdk();
  }
  
  @Nullable
  public apdk a(aptx[] paramArrayOfaptx)
  {
    apdk localapdk = new apdk();
    if ((paramArrayOfaptx != null) && (paramArrayOfaptx.length > 0) && (paramArrayOfaptx[0] != null)) {
      apdk.a(localapdk, paramArrayOfaptx[0].a);
    }
    return localapdk;
  }
  
  public void a(apdk paramapdk) {}
  
  public Class<apdk> clazz()
  {
    return apdk.class;
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
    return 416;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apdj
 * JD-Core Version:    0.7.0.1
 */