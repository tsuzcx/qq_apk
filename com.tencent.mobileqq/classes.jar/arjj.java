import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class arjj
  extends arac<arjh>
{
  @NonNull
  public arjh a(int paramInt)
  {
    return new arjh();
  }
  
  @Nullable
  public arjh a(araj[] paramArrayOfaraj)
  {
    if ((paramArrayOfaraj != null) && (paramArrayOfaraj.length > 0))
    {
      new arjh();
      return arjh.a(paramArrayOfaraj);
    }
    return null;
  }
  
  public void a(arjh paramarjh)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TencentDocsPushProcessor", 2, "onUpdate " + paramarjh.toString());
    }
  }
  
  public Class<arjh> clazz()
  {
    return arjh.class;
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
  
  public void onReqFailed(int paramInt) {}
  
  public int type()
  {
    return 418;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arjj
 * JD-Core Version:    0.7.0.1
 */