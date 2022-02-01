import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aqlp
  extends aptq<aqlo>
{
  public static aqlo a()
  {
    aqlo localaqlo2 = (aqlo)apub.a().a(573);
    aqlo localaqlo1 = localaqlo2;
    if (localaqlo2 == null) {
      localaqlo1 = new aqlo();
    }
    return localaqlo1;
  }
  
  @NonNull
  public aqlo a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("SuspiciousTroopConfProcessor", 2, "migrateOldOrDefaultContent ");
    }
    return new aqlo();
  }
  
  @Nullable
  public aqlo a(aptx[] paramArrayOfaptx)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SuspiciousTroopConfProcessor", 2, "onParsed start");
    }
    if ((paramArrayOfaptx != null) && (paramArrayOfaptx.length > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SuspiciousTroopConfProcessor", 2, "onParsed " + paramArrayOfaptx.length);
      }
      return aqlo.a(paramArrayOfaptx[0]);
    }
    return null;
  }
  
  public void a(aqlo paramaqlo)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("onUpdate ");
      if (paramaqlo == null) {
        break label43;
      }
    }
    label43:
    for (paramaqlo = paramaqlo.toString();; paramaqlo = " empty")
    {
      QLog.d("SuspiciousTroopConfProcessor", 2, paramaqlo);
      return;
    }
  }
  
  public Class<aqlo> clazz()
  {
    return aqlo.class;
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
      QLog.e("SuspiciousTroopConfProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public int type()
  {
    return 573;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqlp
 * JD-Core Version:    0.7.0.1
 */