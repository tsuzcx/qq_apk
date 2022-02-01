import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class arfd
  extends aqwt<arfc>
{
  @NonNull
  public arfc a(int paramInt)
  {
    return new arfc();
  }
  
  @Nullable
  public arfc a(aqxa[] paramArrayOfaqxa)
  {
    if ((paramArrayOfaqxa != null) && (paramArrayOfaqxa.length > 0) && (paramArrayOfaqxa[0] != null))
    {
      arfc localarfc = arfc.a(paramArrayOfaqxa[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("QuickAuthorityConfProcessor", 2, "onParsed " + paramArrayOfaqxa[0].a);
      }
      return localarfc;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QuickAuthorityConfProcessor", 2, "onParsed is null");
    }
    return null;
  }
  
  public void a(arfc paramarfc)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QuickAuthorityConfProcessor", 2, "onUpdate " + paramarfc.toString());
    }
  }
  
  public Class<arfc> clazz()
  {
    return arfc.class;
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
      QLog.d("QuickAuthorityConfProcessor", 2, "migrateOldVersion");
    }
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QuickAuthorityConfProcessor", 2, new Object[] { "onReqFailed ", Integer.valueOf(paramInt) });
    }
  }
  
  public int type()
  {
    return 546;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arfd
 * JD-Core Version:    0.7.0.1
 */