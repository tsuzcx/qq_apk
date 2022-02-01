import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class armw
  extends aqwt<armv>
{
  public static armv a()
  {
    return (armv)aqxe.a().a(500);
  }
  
  @NonNull
  public armv a(int paramInt)
  {
    return new armv();
  }
  
  @Nullable
  public armv a(aqxa[] paramArrayOfaqxa)
  {
    if ((paramArrayOfaqxa != null) && (paramArrayOfaqxa.length > 0)) {
      return armv.a(paramArrayOfaqxa);
    }
    return null;
  }
  
  public void a(armv paramarmv) {}
  
  public Class<armv> clazz()
  {
    return armv.class;
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
    return 500;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     armw
 * JD-Core Version:    0.7.0.1
 */