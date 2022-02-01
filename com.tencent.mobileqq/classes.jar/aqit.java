import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aqit
  extends aptq<aqis>
{
  @NonNull
  public aqis a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("SearchBusinessConfProcessor", 2, "migrateOldOrDefaultContent ");
    }
    return new aqis();
  }
  
  @Nullable
  public aqis a(aptx[] paramArrayOfaptx)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SearchBusinessConfProcessor", 2, "onParsed start");
    }
    if ((paramArrayOfaptx != null) && (paramArrayOfaptx.length > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SearchBusinessConfProcessor", 2, "onParsed " + paramArrayOfaptx.length);
      }
      return aqis.a(paramArrayOfaptx[0]);
    }
    return null;
  }
  
  public void a(aqis paramaqis)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("onUpdate ");
      if (paramaqis == null) {
        break label43;
      }
    }
    label43:
    for (paramaqis = paramaqis.toString();; paramaqis = " empty")
    {
      QLog.d("SearchBusinessConfProcessor", 2, paramaqis);
      return;
    }
  }
  
  public Class<aqis> clazz()
  {
    return aqis.class;
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
    return 434;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqit
 * JD-Core Version:    0.7.0.1
 */