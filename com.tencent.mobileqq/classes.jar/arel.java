import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class arel
  extends arac<arek>
{
  @NonNull
  public arek a(int paramInt)
  {
    return new arek();
  }
  
  @Nullable
  public arek a(araj[] paramArrayOfaraj)
  {
    if ((paramArrayOfaraj != null) && (paramArrayOfaraj.length > 0) && (paramArrayOfaraj[0] != null))
    {
      arek localarek = arek.a(paramArrayOfaraj[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("GlobalSearchConfProcessor", 2, "onParsed " + paramArrayOfaraj[0].a);
      }
      return localarek;
    }
    return null;
  }
  
  public void a(arek paramarek)
  {
    com.tencent.mobileqq.search.util.SearchConfigManager.needSeparate = paramarek.a();
    if (QLog.isColorLevel()) {
      QLog.d("GlobalSearchConfProcessor", 2, "onUpdate " + paramarek.toString());
    }
  }
  
  public Class<arek> clazz()
  {
    return arek.class;
  }
  
  public boolean isAccountRelated()
  {
    return false;
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
  
  public void onReqFailed(int paramInt) {}
  
  public int type()
  {
    return 414;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arel
 * JD-Core Version:    0.7.0.1
 */