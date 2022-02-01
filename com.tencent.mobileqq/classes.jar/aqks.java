import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class aqks
  extends aptq<aqkr>
{
  public static aqkr a()
  {
    return (aqkr)apub.a().a(487);
  }
  
  @NonNull
  public aqkr a(int paramInt)
  {
    return new aqkr();
  }
  
  @Nullable
  public aqkr a(aptx[] paramArrayOfaptx)
  {
    if ((paramArrayOfaptx != null) && (paramArrayOfaptx.length > 0)) {
      return aqkr.a(paramArrayOfaptx);
    }
    return null;
  }
  
  public void a(aqkr paramaqkr) {}
  
  public Class<aqkr> clazz()
  {
    return aqkr.class;
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
    return 487;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqks
 * JD-Core Version:    0.7.0.1
 */