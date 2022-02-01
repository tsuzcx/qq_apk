import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class arjv
  extends arac<arju>
{
  @NonNull
  public static arju a()
  {
    arju localarju2 = (arju)aran.a().a(435);
    arju localarju1 = localarju2;
    if (localarju2 == null) {
      localarju1 = new arju();
    }
    return localarju1;
  }
  
  @NonNull
  public arju a(int paramInt)
  {
    return new arju();
  }
  
  @Nullable
  public arju a(araj[] paramArrayOfaraj)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramArrayOfaraj != null)
    {
      localObject1 = localObject2;
      if (paramArrayOfaraj.length > 0) {
        localObject1 = arju.a(paramArrayOfaraj);
      }
    }
    return localObject1;
  }
  
  public void a(arju paramarju)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopUrlConfProcessor", 2, "onUpdate " + paramarju.toString());
    }
  }
  
  public Class<arju> clazz()
  {
    return arju.class;
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
 * Qualified Name:     arjv
 * JD-Core Version:    0.7.0.1
 */