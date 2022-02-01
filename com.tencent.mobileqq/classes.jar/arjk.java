import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class arjk
  extends arac<arjl>
{
  @NonNull
  public arjl a(int paramInt)
  {
    return new arjl();
  }
  
  @Nullable
  public arjl a(araj[] paramArrayOfaraj)
  {
    if ((paramArrayOfaraj != null) && (paramArrayOfaraj.length > 0) && (paramArrayOfaraj[0] != null))
    {
      arjl localarjl = arjl.a(paramArrayOfaraj[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("TogetherBusinessConfProcessor", 2, "onParsed " + paramArrayOfaraj[0].a);
      }
      return localarjl;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TogetherBusinessConfProcessor", 2, "onParsed is null");
    }
    return null;
  }
  
  public void a(arjl paramarjl)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TogetherBusinessConfProcessor", 2, "onUpdate " + paramarjl.toString());
    }
  }
  
  public Class<arjl> clazz()
  {
    return arjl.class;
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
      QLog.d("TogetherBusinessConfProcessor", 2, "migrateOldVersion");
    }
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TogetherBusinessConfProcessor", 2, new Object[] { "onReqFailed ", Integer.valueOf(paramInt) });
    }
  }
  
  public int type()
  {
    return 535;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arjk
 * JD-Core Version:    0.7.0.1
 */