import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class armu
  extends aqwt<armt>
{
  public static armt a()
  {
    return (armt)aqxe.a().a(486);
  }
  
  @NonNull
  public armt a(int paramInt)
  {
    return new armt();
  }
  
  @Nullable
  public armt a(aqxa[] paramArrayOfaqxa)
  {
    if ((paramArrayOfaqxa != null) && (paramArrayOfaqxa.length > 0)) {
      return armt.a(paramArrayOfaqxa);
    }
    return null;
  }
  
  public void a(armt paramarmt) {}
  
  public Class<armt> clazz()
  {
    return armt.class;
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
    return 486;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     armu
 * JD-Core Version:    0.7.0.1
 */