import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class apyz
  extends aptq<apyy>
{
  private static apyy a;
  
  public static apyy a()
  {
    apyy localapyy2 = (apyy)apub.a().a(524);
    apyy localapyy1 = localapyy2;
    if (localapyy2 == null) {
      localapyy1 = apyy.a();
    }
    return localapyy1;
  }
  
  @NonNull
  public apyy a(int paramInt)
  {
    if (a != null) {
      return a;
    }
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkConfProcessor", 2, "migrateOldOrDefaultContent ");
    }
    a = apyy.a();
    return a;
  }
  
  @Nullable
  public apyy a(aptx[] paramArrayOfaptx)
  {
    if ((paramArrayOfaptx != null) && (paramArrayOfaptx.length > 0))
    {
      paramArrayOfaptx = apyy.a(paramArrayOfaptx[0].a);
      a = null;
      return paramArrayOfaptx;
    }
    return apyy.a();
  }
  
  public void a(apyy paramapyy)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MutualMarkConfProcessor", 2, "onUpdate newConf:" + paramapyy);
    }
  }
  
  public Class<apyy> clazz()
  {
    return apyy.class;
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
 * Qualified Name:     apyz
 * JD-Core Version:    0.7.0.1
 */