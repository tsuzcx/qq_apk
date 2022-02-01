import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class arif
  extends arac<aric>
{
  @NonNull
  public static aric a()
  {
    aric localaric2 = (aric)aran.a().a(630);
    aric localaric1 = localaric2;
    if (localaric2 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QrCodeDisplay.ConfProcessor", 2, "loadConfig(): bean is null then new QrCodeConfBean()");
      }
      localaric1 = new aric();
    }
    return localaric1;
  }
  
  @NonNull
  public aric a(int paramInt)
  {
    return new aric();
  }
  
  @Nullable
  public aric a(araj[] paramArrayOfaraj)
  {
    if ((paramArrayOfaraj == null) || (paramArrayOfaraj.length == 0))
    {
      QLog.d("QrCodeDisplay.ConfProcessor", 1, "QrCodeDisplayConfProcessor onParsed, confFiles is null empty");
      return null;
    }
    paramArrayOfaraj = paramArrayOfaraj[0].a;
    if (QLog.isColorLevel()) {
      QLog.d("QrCodeDisplay.ConfProcessor", 2, "QrCodeDisplayConfProcessor onParsed, content:" + paramArrayOfaraj);
    }
    return aric.a(paramArrayOfaraj);
  }
  
  public void a(aric paramaric)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QrCodeDisplay.ConfProcessor", 2, "onUpdate " + paramaric.toString());
    }
  }
  
  public Class<aric> clazz()
  {
    return aric.class;
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
      QLog.d("QrCodeDisplay.ConfProcessor", 2, "migrateOldVersion");
    }
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QrCodeDisplay.ConfProcessor", 2, new Object[] { "onReqFailed ", Integer.valueOf(paramInt) });
    }
  }
  
  public int type()
  {
    return 630;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arif
 * JD-Core Version:    0.7.0.1
 */