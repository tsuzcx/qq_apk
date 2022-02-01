import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class aqcz
  extends aqkz<aqcy>
{
  public static aqcy a()
  {
    return (aqcy)aqlk.a().a(586);
  }
  
  @NonNull
  public aqcy a(int paramInt)
  {
    return new aqcy();
  }
  
  @Nullable
  public aqcy a(aqlg[] paramArrayOfaqlg)
  {
    if ((paramArrayOfaqlg != null) && (paramArrayOfaqlg.length > 0)) {
      return aqcy.a(paramArrayOfaqlg[0].a);
    }
    return null;
  }
  
  public void a(aqcy paramaqcy) {}
  
  public Class<aqcy> clazz()
  {
    return aqcy.class;
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
    return 586;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqcz
 * JD-Core Version:    0.7.0.1
 */