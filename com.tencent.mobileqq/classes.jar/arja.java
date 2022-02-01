import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class arja
  extends arac<arjb>
{
  @NonNull
  public arjb a(int paramInt)
  {
    return new arjb();
  }
  
  @Nullable
  public arjb a(araj[] paramArrayOfaraj)
  {
    if ((paramArrayOfaraj != null) && (paramArrayOfaraj.length > 0) && (paramArrayOfaraj[0] != null)) {
      return arjb.a(paramArrayOfaraj[0].a);
    }
    if (QLog.isColorLevel()) {
      QLog.d("SingTogetherConfProcessor", 2, "onParsed is null");
    }
    return null;
  }
  
  public void a(arjb paramarjb)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SingTogetherConfProcessor", 2, "onUpdate " + paramarjb.toString());
    }
  }
  
  public Class<arjb> clazz()
  {
    return arjb.class;
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
      QLog.d("SingTogetherConfProcessor", 2, "migrateOldVersion");
    }
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SingTogetherConfProcessor", 2, new Object[] { "onReqFailed ", Integer.valueOf(paramInt) });
    }
  }
  
  public int type()
  {
    return 551;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arja
 * JD-Core Version:    0.7.0.1
 */