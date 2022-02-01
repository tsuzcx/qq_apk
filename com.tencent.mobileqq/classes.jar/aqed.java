import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class aqed
  extends aptq<aqec>
{
  @NonNull
  public aqec a(int paramInt)
  {
    return new aqec();
  }
  
  @Nullable
  public aqec a(aptx[] paramArrayOfaptx)
  {
    if ((paramArrayOfaptx != null) && (paramArrayOfaptx.length > 0)) {
      return aqec.a(paramArrayOfaptx);
    }
    return null;
  }
  
  public void a(aqec paramaqec) {}
  
  public Class<aqec> clazz()
  {
    return aqec.class;
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
    return 484;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqed
 * JD-Core Version:    0.7.0.1
 */