import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class arih
  extends arac<arig>
{
  @NonNull
  public arig a(int paramInt)
  {
    return new arig();
  }
  
  @Nullable
  public arig a(araj[] paramArrayOfaraj)
  {
    if ((paramArrayOfaraj != null) && (paramArrayOfaraj.length > 0) && (paramArrayOfaraj[0] != null))
    {
      arig localarig = arig.a(paramArrayOfaraj[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("QuickAuthorityConfProcessor", 2, "onParsed " + paramArrayOfaraj[0].a);
      }
      return localarig;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QuickAuthorityConfProcessor", 2, "onParsed is null");
    }
    return null;
  }
  
  public void a(arig paramarig)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QuickAuthorityConfProcessor", 2, "onUpdate " + paramarig.toString());
    }
  }
  
  public Class<arig> clazz()
  {
    return arig.class;
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
    if (QLog.isColorLevel()) {
      QLog.d("QuickAuthorityConfProcessor", 2, "migrateOldVersion");
    }
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QuickAuthorityConfProcessor", 2, new Object[] { "onReqFailed ", Integer.valueOf(paramInt) });
    }
  }
  
  public int type()
  {
    return 546;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arih
 * JD-Core Version:    0.7.0.1
 */