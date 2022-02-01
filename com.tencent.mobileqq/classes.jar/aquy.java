import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class aquy
  extends aqkz<aqux>
{
  @NonNull
  public aqux a(int paramInt)
  {
    return new aqux();
  }
  
  @Nullable
  public aqux a(aqlg[] paramArrayOfaqlg)
  {
    if ((paramArrayOfaqlg != null) && (paramArrayOfaqlg.length > 0)) {
      return aqux.a(paramArrayOfaqlg);
    }
    return null;
  }
  
  public void a(aqux paramaqux) {}
  
  public Class<aqux> clazz()
  {
    return aqux.class;
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
 * Qualified Name:     aquy
 * JD-Core Version:    0.7.0.1
 */