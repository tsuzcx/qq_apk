import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class arch
  extends aqwt<arcg>
{
  public static arcg a()
  {
    return (arcg)aqxe.a().a(572);
  }
  
  @NonNull
  public arcg a(int paramInt)
  {
    return new arcg();
  }
  
  @Nullable
  public arcg a(aqxa[] paramArrayOfaqxa)
  {
    if ((paramArrayOfaqxa != null) && (paramArrayOfaqxa.length > 0))
    {
      new arcg();
      return arcg.a(paramArrayOfaqxa);
    }
    return null;
  }
  
  public void a(arcg paramarcg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NotificationBannerConfProcessor", 2, "onUpdate " + paramarcg.toString());
    }
  }
  
  public Class<arcg> clazz()
  {
    return arcg.class;
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
    return 572;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arch
 * JD-Core Version:    0.7.0.1
 */