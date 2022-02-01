import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aqby
  extends aptq<aqbv>
{
  @NonNull
  public static aqbv a()
  {
    aqbv localaqbv2 = (aqbv)apub.a().a(630);
    aqbv localaqbv1 = localaqbv2;
    if (localaqbv2 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QrCodeDisplay.ConfProcessor", 2, "loadConfig(): bean is null then new QrCodeConfBean()");
      }
      localaqbv1 = new aqbv();
    }
    return localaqbv1;
  }
  
  @NonNull
  public aqbv a(int paramInt)
  {
    return new aqbv();
  }
  
  @Nullable
  public aqbv a(aptx[] paramArrayOfaptx)
  {
    if ((paramArrayOfaptx == null) || (paramArrayOfaptx.length == 0))
    {
      QLog.d("QrCodeDisplay.ConfProcessor", 1, "QrCodeDisplayConfProcessor onParsed, confFiles is null empty");
      return null;
    }
    paramArrayOfaptx = paramArrayOfaptx[0].a;
    if (QLog.isColorLevel()) {
      QLog.d("QrCodeDisplay.ConfProcessor", 2, "QrCodeDisplayConfProcessor onParsed, content:" + paramArrayOfaptx);
    }
    return aqbv.a(paramArrayOfaptx);
  }
  
  public void a(aqbv paramaqbv)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QrCodeDisplay.ConfProcessor", 2, "onUpdate " + paramaqbv.toString());
    }
  }
  
  public Class<aqbv> clazz()
  {
    return aqbv.class;
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
 * Qualified Name:     aqby
 * JD-Core Version:    0.7.0.1
 */