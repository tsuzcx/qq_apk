import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class aqzy
  extends aqkz<aqzx>
{
  public static aqzx a()
  {
    return (aqzx)aqlk.a().a(521);
  }
  
  @NonNull
  public aqzx a(int paramInt)
  {
    return new aqzx();
  }
  
  @Nullable
  public aqzx a(aqlg[] paramArrayOfaqlg)
  {
    if ((paramArrayOfaqlg != null) && (paramArrayOfaqlg.length > 0)) {
      return aqzx.a(paramArrayOfaqlg);
    }
    return null;
  }
  
  public void a(aqzx paramaqzx) {}
  
  public Class<aqzx> clazz()
  {
    return aqzx.class;
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
    return 521;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqzy
 * JD-Core Version:    0.7.0.1
 */