import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class arov
  extends arac<arou>
{
  @NonNull
  public arou a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("SearchBusinessConfProcessor", 2, "migrateOldOrDefaultContent ");
    }
    return new arou();
  }
  
  @Nullable
  public arou a(araj[] paramArrayOfaraj)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SearchBusinessConfProcessor", 2, "onParsed start");
    }
    if ((paramArrayOfaraj != null) && (paramArrayOfaraj.length > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SearchBusinessConfProcessor", 2, "onParsed " + paramArrayOfaraj.length);
      }
      return arou.a(paramArrayOfaraj[0]);
    }
    return null;
  }
  
  public void a(arou paramarou)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("onUpdate ");
      if (paramarou == null) {
        break label43;
      }
    }
    label43:
    for (paramarou = paramarou.toString();; paramarou = " empty")
    {
      QLog.d("SearchBusinessConfProcessor", 2, paramarou);
      return;
    }
  }
  
  public Class<arou> clazz()
  {
    return arou.class;
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
 * Qualified Name:     arov
 * JD-Core Version:    0.7.0.1
 */