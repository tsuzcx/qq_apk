import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class aqzw
  extends aqkz<aqzv>
{
  public static aqzv a()
  {
    return (aqzv)aqlk.a().a(500);
  }
  
  @NonNull
  public aqzv a(int paramInt)
  {
    return new aqzv();
  }
  
  @Nullable
  public aqzv a(aqlg[] paramArrayOfaqlg)
  {
    if ((paramArrayOfaqlg != null) && (paramArrayOfaqlg.length > 0)) {
      return aqzv.a(paramArrayOfaqlg);
    }
    return null;
  }
  
  public void a(aqzv paramaqzv) {}
  
  public Class<aqzv> clazz()
  {
    return aqzv.class;
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
 * Qualified Name:     aqzw
 * JD-Core Version:    0.7.0.1
 */