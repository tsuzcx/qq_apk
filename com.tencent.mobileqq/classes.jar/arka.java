import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class arka
  extends arac<arjz>
{
  @NonNull
  public arjz a(int paramInt)
  {
    return new arjz();
  }
  
  @Nullable
  public arjz a(araj[] paramArrayOfaraj)
  {
    if ((paramArrayOfaraj != null) && (paramArrayOfaraj.length > 0) && (paramArrayOfaraj[0] != null))
    {
      arjz localarjz = arjz.a(paramArrayOfaraj[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("WVPreloadPskeyConfProcessor", 2, "onParsed " + paramArrayOfaraj[0].a);
      }
      return localarjz;
    }
    if (QLog.isColorLevel()) {
      QLog.d("WVPreloadPskeyConfProcessor", 2, "onParsed is null");
    }
    return null;
  }
  
  public void a(arjz paramarjz)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WVPreloadPskeyConfProcessor", 2, "onUpdate " + paramarjz.toString());
    }
  }
  
  public Class<arjz> clazz()
  {
    return arjz.class;
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
      QLog.d("WVPreloadPskeyConfProcessor", 2, "migrateOldVersion");
    }
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WVPreloadPskeyConfProcessor", 2, new Object[] { "onReqFailed ", Integer.valueOf(paramInt) });
    }
  }
  
  public int type()
  {
    return 585;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arka
 * JD-Core Version:    0.7.0.1
 */