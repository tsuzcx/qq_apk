import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class arob
  extends aqwt<aroa>
{
  @NonNull
  public aroa a(int paramInt)
  {
    return new aroa();
  }
  
  @Nullable
  public aroa a(aqxa[] paramArrayOfaqxa)
  {
    if ((paramArrayOfaqxa != null) && (paramArrayOfaqxa.length > 0)) {
      return aroa.a(paramArrayOfaqxa);
    }
    return null;
  }
  
  public void a(aroa paramaroa) {}
  
  public Class<aroa> clazz()
  {
    return aroa.class;
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
    return 440;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arob
 * JD-Core Version:    0.7.0.1
 */