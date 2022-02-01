import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class bcsj
  extends aqkz<bcsk>
{
  @NonNull
  public bcsk a(int paramInt)
  {
    return new bcsk();
  }
  
  @Nullable
  public bcsk a(aqlg[] paramArrayOfaqlg)
  {
    bcsk localbcsk = new bcsk();
    if ((paramArrayOfaqlg != null) && (paramArrayOfaqlg.length > 0) && (paramArrayOfaqlg[0] != null)) {
      bcsk.a(localbcsk, paramArrayOfaqlg[0].a);
    }
    return localbcsk;
  }
  
  public void a(bcsk parambcsk) {}
  
  public Class<bcsk> clazz()
  {
    return bcsk.class;
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
 * Qualified Name:     bcsj
 * JD-Core Version:    0.7.0.1
 */