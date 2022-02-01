import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class arkv
  extends arac<arku>
{
  public static arku a()
  {
    arku localarku2 = (arku)aran.a().a(493);
    arku localarku1 = localarku2;
    if (localarku2 == null) {
      localarku1 = new arku();
    }
    return localarku1;
  }
  
  @NonNull
  public arku a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("SearchBusinessConfProcessor", 2, "migrateOldOrDefaultContent ");
    }
    return new arku();
  }
  
  @Nullable
  public arku a(araj[] paramArrayOfaraj)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SearchBusinessConfProcessor", 2, "onParsed start");
    }
    if ((paramArrayOfaraj != null) && (paramArrayOfaraj.length > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SearchBusinessConfProcessor", 2, "onParsed " + paramArrayOfaraj.length);
      }
      return arku.a(paramArrayOfaraj[0]);
    }
    return null;
  }
  
  public void a(arku paramarku)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("onUpdate ");
      if (paramarku == null) {
        break label43;
      }
    }
    label43:
    for (paramarku = paramarku.toString();; paramarku = " empty")
    {
      QLog.d("SearchBusinessConfProcessor", 2, paramarku);
      return;
    }
  }
  
  public Class<arku> clazz()
  {
    return arku.class;
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
 * Qualified Name:     arkv
 * JD-Core Version:    0.7.0.1
 */