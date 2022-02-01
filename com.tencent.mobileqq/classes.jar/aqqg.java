import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aqqg
  extends aqkz<aqqf>
{
  public static aqqf a()
  {
    return (aqqf)aqlk.a().a(572);
  }
  
  @NonNull
  public aqqf a(int paramInt)
  {
    return new aqqf();
  }
  
  @Nullable
  public aqqf a(aqlg[] paramArrayOfaqlg)
  {
    if ((paramArrayOfaqlg != null) && (paramArrayOfaqlg.length > 0))
    {
      new aqqf();
      return aqqf.a(paramArrayOfaqlg);
    }
    return null;
  }
  
  public void a(aqqf paramaqqf)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NotificationBannerConfProcessor", 2, "onUpdate " + paramaqqf.toString());
    }
  }
  
  public Class<aqqf> clazz()
  {
    return aqqf.class;
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
 * Qualified Name:     aqqg
 * JD-Core Version:    0.7.0.1
 */