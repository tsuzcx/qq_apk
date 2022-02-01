import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aqdo
  extends aptq<aqdn>
{
  @NonNull
  public static aqdn a()
  {
    aqdn localaqdn2 = (aqdn)apub.a().a(435);
    aqdn localaqdn1 = localaqdn2;
    if (localaqdn2 == null) {
      localaqdn1 = new aqdn();
    }
    return localaqdn1;
  }
  
  @NonNull
  public aqdn a(int paramInt)
  {
    return new aqdn();
  }
  
  @Nullable
  public aqdn a(aptx[] paramArrayOfaptx)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramArrayOfaptx != null)
    {
      localObject1 = localObject2;
      if (paramArrayOfaptx.length > 0) {
        localObject1 = aqdn.a(paramArrayOfaptx);
      }
    }
    return localObject1;
  }
  
  public void a(aqdn paramaqdn)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopUrlConfProcessor", 2, "onUpdate " + paramaqdn.toString());
    }
  }
  
  public Class<aqdn> clazz()
  {
    return aqdn.class;
  }
  
  public boolean isAccountRelated()
  {
    return true;
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
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopUrlConfProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public int type()
  {
    return 435;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqdo
 * JD-Core Version:    0.7.0.1
 */