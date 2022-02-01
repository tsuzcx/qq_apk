import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class armk
  extends aqwt<arml>
{
  @NonNull
  public arml a(int paramInt)
  {
    return new arml();
  }
  
  @Nullable
  public arml a(aqxa[] paramArrayOfaqxa)
  {
    if ((paramArrayOfaqxa != null) && (paramArrayOfaqxa.length > 0))
    {
      arml localarml = arml.a(paramArrayOfaqxa[0].a);
      if (QLog.isColorLevel()) {
        QLog.i("UinSearchConfProcessor", 2, "onParsed: " + paramArrayOfaqxa[0].a);
      }
      return localarml;
    }
    return new arml();
  }
  
  public void a(arml paramarml)
  {
    if (QLog.isColorLevel()) {
      QLog.i("UinSearchConfProcessor", 2, "onUpdate");
    }
  }
  
  public Class<arml> clazz()
  {
    return arml.class;
  }
  
  public boolean isAccountRelated()
  {
    return true;
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
      QLog.i("UinSearchConfProcessor", 2, "onReqFailed: " + paramInt);
    }
  }
  
  public int type()
  {
    return 589;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     armk
 * JD-Core Version:    0.7.0.1
 */