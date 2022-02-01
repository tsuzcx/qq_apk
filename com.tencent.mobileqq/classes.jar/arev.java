import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class arev
  extends arac<areu>
{
  @NonNull
  public areu a(int paramInt)
  {
    return new areu();
  }
  
  @Nullable
  public areu a(araj[] paramArrayOfaraj)
  {
    if ((paramArrayOfaraj != null) && (paramArrayOfaraj.length > 0) && (paramArrayOfaraj[0] != null))
    {
      areu localareu = areu.a(paramArrayOfaraj[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("LocationEasterEggConfProcessor", 2, "onParsed " + paramArrayOfaraj[0].a);
      }
      return localareu;
    }
    if (QLog.isColorLevel()) {
      QLog.d("LocationEasterEggConfProcessor", 2, "onParsed is null");
    }
    return null;
  }
  
  public void a(areu paramareu)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationEasterEggConfProcessor", 2, "onUpdate " + paramareu.toString());
    }
  }
  
  public Class<areu> clazz()
  {
    return areu.class;
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
      QLog.d("LocationEasterEggConfProcessor", 2, "migrateOldVersion");
    }
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationEasterEggConfProcessor", 2, new Object[] { "onReqFailed ", Integer.valueOf(paramInt) });
    }
  }
  
  public int type()
  {
    return 575;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arev
 * JD-Core Version:    0.7.0.1
 */