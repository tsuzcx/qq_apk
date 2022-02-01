import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aqes
  extends aptq<aqer>
{
  public static aqer a()
  {
    aqer localaqer2 = (aqer)apub.a().a(493);
    aqer localaqer1 = localaqer2;
    if (localaqer2 == null) {
      localaqer1 = new aqer();
    }
    return localaqer1;
  }
  
  @NonNull
  public aqer a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("SearchBusinessConfProcessor", 2, "migrateOldOrDefaultContent ");
    }
    return new aqer();
  }
  
  @Nullable
  public aqer a(aptx[] paramArrayOfaptx)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SearchBusinessConfProcessor", 2, "onParsed start");
    }
    if ((paramArrayOfaptx != null) && (paramArrayOfaptx.length > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SearchBusinessConfProcessor", 2, "onParsed " + paramArrayOfaptx.length);
      }
      return aqer.a(paramArrayOfaptx[0]);
    }
    return null;
  }
  
  public void a(aqer paramaqer)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("onUpdate ");
      if (paramaqer == null) {
        break label43;
      }
    }
    label43:
    for (paramaqer = paramaqer.toString();; paramaqer = " empty")
    {
      QLog.d("SearchBusinessConfProcessor", 2, paramaqer);
      return;
    }
  }
  
  public Class<aqer> clazz()
  {
    return aqer.class;
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
      QLog.e("SearchBusinessConfProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public int type()
  {
    return 493;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqes
 * JD-Core Version:    0.7.0.1
 */