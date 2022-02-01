import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aqst
  extends aqkz<aqsq>
{
  @NonNull
  public static aqsq a()
  {
    aqsq localaqsq2 = (aqsq)aqlk.a().a(630);
    aqsq localaqsq1 = localaqsq2;
    if (localaqsq2 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QrCodeDisplay.ConfProcessor", 2, "loadConfig(): bean is null then new QrCodeConfBean()");
      }
      localaqsq1 = new aqsq();
    }
    return localaqsq1;
  }
  
  @NonNull
  public aqsq a(int paramInt)
  {
    return new aqsq();
  }
  
  @Nullable
  public aqsq a(aqlg[] paramArrayOfaqlg)
  {
    if ((paramArrayOfaqlg == null) || (paramArrayOfaqlg.length == 0))
    {
      QLog.d("QrCodeDisplay.ConfProcessor", 1, "QrCodeDisplayConfProcessor onParsed, confFiles is null empty");
      return null;
    }
    paramArrayOfaqlg = paramArrayOfaqlg[0].a;
    if (QLog.isColorLevel()) {
      QLog.d("QrCodeDisplay.ConfProcessor", 2, "QrCodeDisplayConfProcessor onParsed, content:" + paramArrayOfaqlg);
    }
    return aqsq.a(paramArrayOfaqlg);
  }
  
  public void a(aqsq paramaqsq)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QrCodeDisplay.ConfProcessor", 2, "onUpdate " + paramaqsq.toString());
    }
  }
  
  public Class<aqsq> clazz()
  {
    return aqsq.class;
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
 * Qualified Name:     aqst
 * JD-Core Version:    0.7.0.1
 */