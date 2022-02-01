import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public abstract class ayfi
  extends aptq<ayfj>
{
  protected abstract int a();
  
  @NonNull
  public ayfj a(int paramInt)
  {
    return new ayfj();
  }
  
  @Nullable
  public ayfj a(aptx[] paramArrayOfaptx)
  {
    ayfj localayfj = new ayfj();
    if ((paramArrayOfaptx != null) && (paramArrayOfaptx.length > 0) && (paramArrayOfaptx[0] != null)) {
      ayfj.a(localayfj, paramArrayOfaptx[0].a);
    }
    return localayfj;
  }
  
  public void a(ayfj paramayfj) {}
  
  public Class<ayfj> clazz()
  {
    return ayfj.class;
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
    return a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayfi
 * JD-Core Version:    0.7.0.1
 */