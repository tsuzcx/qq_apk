import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class arfb
  extends aqwt<arey>
{
  @NonNull
  public static arey a()
  {
    arey localarey2 = (arey)aqxe.a().a(630);
    arey localarey1 = localarey2;
    if (localarey2 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QrCodeDisplay.ConfProcessor", 2, "loadConfig(): bean is null then new QrCodeConfBean()");
      }
      localarey1 = new arey();
    }
    return localarey1;
  }
  
  @NonNull
  public arey a(int paramInt)
  {
    return new arey();
  }
  
  @Nullable
  public arey a(aqxa[] paramArrayOfaqxa)
  {
    if ((paramArrayOfaqxa == null) || (paramArrayOfaqxa.length == 0))
    {
      QLog.d("QrCodeDisplay.ConfProcessor", 1, "QrCodeDisplayConfProcessor onParsed, confFiles is null empty");
      return null;
    }
    paramArrayOfaqxa = paramArrayOfaqxa[0].a;
    if (QLog.isColorLevel()) {
      QLog.d("QrCodeDisplay.ConfProcessor", 2, "QrCodeDisplayConfProcessor onParsed, content:" + paramArrayOfaqxa);
    }
    return arey.a(paramArrayOfaqxa);
  }
  
  public void a(arey paramarey)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QrCodeDisplay.ConfProcessor", 2, "onUpdate " + paramarey.toString());
    }
  }
  
  public Class<arey> clazz()
  {
    return arey.class;
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
 * Qualified Name:     arfb
 * JD-Core Version:    0.7.0.1
 */