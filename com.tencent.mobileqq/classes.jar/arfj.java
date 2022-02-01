import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class arfj
  extends arac<arfi>
{
  private static arfi a;
  
  public static arfi a()
  {
    arfi localarfi2 = (arfi)aran.a().a(524);
    arfi localarfi1 = localarfi2;
    if (localarfi2 == null) {
      localarfi1 = arfi.a();
    }
    return localarfi1;
  }
  
  @NonNull
  public arfi a(int paramInt)
  {
    if (a != null) {
      return a;
    }
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkConfProcessor", 2, "migrateOldOrDefaultContent ");
    }
    a = arfi.a();
    return a;
  }
  
  @Nullable
  public arfi a(araj[] paramArrayOfaraj)
  {
    if ((paramArrayOfaraj != null) && (paramArrayOfaraj.length > 0))
    {
      paramArrayOfaraj = arfi.a(paramArrayOfaraj[0].a);
      a = null;
      return paramArrayOfaraj;
    }
    return arfi.a();
  }
  
  public void a(arfi paramarfi)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MutualMarkConfProcessor", 2, "onUpdate newConf:" + paramarfi);
    }
  }
  
  public Class<arfi> clazz()
  {
    return arfi.class;
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
      QLog.d("MutualMarkConfProcessor", 2, "onReqFailed failCode:" + paramInt);
    }
  }
  
  public int type()
  {
    return 524;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arfj
 * JD-Core Version:    0.7.0.1
 */