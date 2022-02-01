import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class aqjy
  extends arac<aqjz>
{
  @NonNull
  public aqjz a(int paramInt)
  {
    return new aqjz();
  }
  
  @Nullable
  public aqjz a(araj[] paramArrayOfaraj)
  {
    aqjz localaqjz = new aqjz();
    if ((paramArrayOfaraj != null) && (paramArrayOfaraj.length > 0) && (paramArrayOfaraj[0] != null)) {
      aqjz.a(localaqjz, paramArrayOfaraj[0].a);
    }
    return localaqjz;
  }
  
  public void a(aqjz paramaqjz) {}
  
  public Class<aqjz> clazz()
  {
    return aqjz.class;
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
 * Qualified Name:     aqjy
 * JD-Core Version:    0.7.0.1
 */