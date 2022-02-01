import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class arjf
  extends arac<arjg>
{
  @NonNull
  public arjg a(int paramInt)
  {
    return new arjg();
  }
  
  @Nullable
  public arjg a(araj[] paramArrayOfaraj)
  {
    if ((paramArrayOfaraj != null) && (paramArrayOfaraj.length > 0) && (paramArrayOfaraj[0] != null)) {
      return arjg.a(paramArrayOfaraj[0].a);
    }
    if (QLog.isColorLevel()) {
      QLog.d("SubAccountConfProcessor", 2, "onParsed is null");
    }
    return null;
  }
  
  public void a(arjg paramarjg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SubAccountConfProcessor", 2, "onUpdate " + paramarjg.toString());
    }
  }
  
  public Class<arjg> clazz()
  {
    return arjg.class;
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
      QLog.d("SubAccountConfProcessor", 2, "migrateOldVersion");
    }
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SubAccountConfProcessor", 2, new Object[] { "onReqFailed ", Integer.valueOf(paramInt) });
    }
  }
  
  public int type()
  {
    return 607;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arjf
 * JD-Core Version:    0.7.0.1
 */