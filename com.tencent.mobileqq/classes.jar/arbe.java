import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class arbe
  extends aqwt<arbd>
{
  @NonNull
  public arbd a(int paramInt)
  {
    return new arbd();
  }
  
  @Nullable
  public arbd a(aqxa[] paramArrayOfaqxa)
  {
    if ((paramArrayOfaqxa != null) && (paramArrayOfaqxa.length > 0) && (paramArrayOfaqxa[0] != null))
    {
      arbd localarbd = arbd.a(paramArrayOfaqxa[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("GlobalSearchConfProcessor", 2, "onParsed " + paramArrayOfaqxa[0].a);
      }
      return localarbd;
    }
    return null;
  }
  
  public void a(arbd paramarbd)
  {
    com.tencent.mobileqq.search.util.SearchConfigManager.needSeparate = paramarbd.a();
    if (QLog.isColorLevel()) {
      QLog.d("GlobalSearchConfProcessor", 2, "onUpdate " + paramarbd.toString());
    }
  }
  
  public Class<arbd> clazz()
  {
    return arbd.class;
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
 * Qualified Name:     arbe
 * JD-Core Version:    0.7.0.1
 */