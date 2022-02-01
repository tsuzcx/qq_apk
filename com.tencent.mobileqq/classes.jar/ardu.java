import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class ardu
  extends aqwt<ardt>
{
  @NonNull
  public ardt a(int paramInt)
  {
    return new ardt();
  }
  
  @Nullable
  public ardt a(aqxa[] paramArrayOfaqxa)
  {
    if ((paramArrayOfaqxa != null) && (paramArrayOfaqxa.length > 0)) {
      return ardt.a(paramArrayOfaqxa[0].a);
    }
    return null;
  }
  
  public void a(ardt paramardt) {}
  
  public Class<ardt> clazz()
  {
    return ardt.class;
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
  
  public int type()
  {
    return 419;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ardu
 * JD-Core Version:    0.7.0.1
 */