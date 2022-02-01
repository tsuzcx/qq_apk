import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class arke
  extends arac<arkd>
{
  @NonNull
  public arkd a(int paramInt)
  {
    return new arkd();
  }
  
  @Nullable
  public arkd a(araj[] paramArrayOfaraj)
  {
    if ((paramArrayOfaraj != null) && (paramArrayOfaraj.length > 0) && (paramArrayOfaraj[0] != null))
    {
      arkd localarkd = arkd.a(paramArrayOfaraj[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("WVStatisticsConfProcessor", 2, "onParsed " + paramArrayOfaraj[0].a);
      }
      return localarkd;
    }
    return null;
  }
  
  public void a(arkd paramarkd)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WVStatisticsConfProcessor", 2, "onUpdate " + paramarkd.toString());
    }
  }
  
  public Class<arkd> clazz()
  {
    return arkd.class;
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
    return 361;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arke
 * JD-Core Version:    0.7.0.1
 */