import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class arnn
  extends aqwt<arnl>
{
  public static arnl a()
  {
    return (arnl)aqxe.a().a(429);
  }
  
  @NonNull
  public arnl a(int paramInt)
  {
    return new arnl();
  }
  
  @Nullable
  public arnl a(aqxa[] paramArrayOfaqxa)
  {
    if ((paramArrayOfaqxa != null) && (paramArrayOfaqxa.length > 0)) {
      return arnl.a(paramArrayOfaqxa);
    }
    return null;
  }
  
  public void a(arnl paramarnl) {}
  
  public Class<arnl> clazz()
  {
    return arnl.class;
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
    return 429;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arnn
 * JD-Core Version:    0.7.0.1
 */