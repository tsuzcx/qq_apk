import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class apze
  extends aptq<apzd>
{
  public static apzd a()
  {
    return (apzd)apub.a().a(572);
  }
  
  @NonNull
  public apzd a(int paramInt)
  {
    return new apzd();
  }
  
  @Nullable
  public apzd a(aptx[] paramArrayOfaptx)
  {
    if ((paramArrayOfaptx != null) && (paramArrayOfaptx.length > 0))
    {
      new apzd();
      return apzd.a(paramArrayOfaptx);
    }
    return null;
  }
  
  public void a(apzd paramapzd)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NotificationBannerConfProcessor", 2, "onUpdate " + paramapzd.toString());
    }
  }
  
  public Class<apzd> clazz()
  {
    return apzd.class;
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
 * Qualified Name:     apze
 * JD-Core Version:    0.7.0.1
 */