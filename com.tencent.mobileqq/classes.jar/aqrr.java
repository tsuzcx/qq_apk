import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class aqrr
  extends aqkz<aqrq>
{
  @NonNull
  public aqrq a(int paramInt)
  {
    return new aqrq();
  }
  
  @Nullable
  public aqrq a(aqlg[] paramArrayOfaqlg)
  {
    if ((paramArrayOfaqlg != null) && (paramArrayOfaqlg.length > 0)) {
      return aqrq.a(paramArrayOfaqlg[0].a);
    }
    return null;
  }
  
  public void a(aqrq paramaqrq) {}
  
  public Class<aqrq> clazz()
  {
    return aqrq.class;
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
 * Qualified Name:     aqrr
 * JD-Core Version:    0.7.0.1
 */