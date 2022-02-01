import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class arhe
  extends aqwt<arhd>
{
  @NonNull
  public arhd a(int paramInt)
  {
    return new arhd();
  }
  
  @Nullable
  public arhd a(aqxa[] paramArrayOfaqxa)
  {
    if ((paramArrayOfaqxa != null) && (paramArrayOfaqxa.length > 0) && (paramArrayOfaqxa[0] != null))
    {
      arhd localarhd = arhd.a(paramArrayOfaqxa[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("WVStatisticsConfProcessor", 2, "onParsed " + paramArrayOfaqxa[0].a);
      }
      return localarhd;
    }
    return null;
  }
  
  public void a(arhd paramarhd)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WVStatisticsConfProcessor", 2, "onUpdate " + paramarhd.toString());
    }
  }
  
  public Class<arhd> clazz()
  {
    return arhd.class;
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
 * Qualified Name:     arhe
 * JD-Core Version:    0.7.0.1
 */