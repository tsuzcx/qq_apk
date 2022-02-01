import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class areg
  extends arac<aref>
{
  public static aref a()
  {
    return (aref)aran.a().a(660);
  }
  
  @NonNull
  public aref a(int paramInt)
  {
    return new aref();
  }
  
  @Nullable
  public aref a(araj[] paramArrayOfaraj)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameCenterEnterConfProc", 2, "GameCenterEnterConfProcessor onParsed ");
    }
    if ((paramArrayOfaraj != null) && (paramArrayOfaraj.length > 0)) {
      return aref.a(paramArrayOfaraj);
    }
    return null;
  }
  
  public void a(aref paramaref) {}
  
  public Class<aref> clazz()
  {
    return aref.class;
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
    return 660;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     areg
 * JD-Core Version:    0.7.0.1
 */