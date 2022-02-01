import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class bcdv
  extends aptq<bcdw>
{
  @NonNull
  public bcdw a(int paramInt)
  {
    return new bcdw();
  }
  
  @Nullable
  public bcdw a(aptx[] paramArrayOfaptx)
  {
    bcdw localbcdw = new bcdw();
    if ((paramArrayOfaptx != null) && (paramArrayOfaptx.length > 0) && (paramArrayOfaptx[0] != null)) {
      bcdw.a(localbcdw, paramArrayOfaptx[0].a);
    }
    return localbcdw;
  }
  
  public void a(bcdw parambcdw) {}
  
  public Class<bcdw> clazz()
  {
    return bcdw.class;
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
    return 577;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcdv
 * JD-Core Version:    0.7.0.1
 */